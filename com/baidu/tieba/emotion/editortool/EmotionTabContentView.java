package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.l BV;
    private c aVA;
    private int aVB;
    private final Point aVC;
    private com.baidu.adp.lib.f.b<GridView> aVD;
    private GridView aVl;
    private LinearLayout aVm;
    private WindowManager.LayoutParams aVn;
    private GifView aVo;
    private ViewGroup aVp;
    private int aVq;
    private int aVr;
    private int aVs;
    private boolean aVt;
    private int aVu;
    private t aVv;
    private List<com.baidu.tbadk.editortools.emotiontool.c> aVw;
    private List<t> aVx;
    private int aVy;
    private int aVz;
    private int aej;
    private ViewPager asg;
    private IndicatorView ash;
    private WindowManager bC;
    private int currentPosition;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void fB(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.aVu = -1;
        this.aVy = 0;
        this.aVz = -1;
        this.currentPosition = -1;
        this.aVC = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.aVu = -1;
        this.aVy = 0;
        this.aVz = -1;
        this.currentPosition = -1;
        this.aVC = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aVw = new ArrayList();
        this.aVx = new ArrayList();
        this.aVD = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.emotion_tab_content, (ViewGroup) this, true);
        this.asg = (ViewPager) findViewById(t.g.face_tab_viewpager);
        this.asg.setFadingEdgeLength(0);
        this.asg.setOnPageChangeListener(this);
        this.aVo = new GifView(context);
        at.d(this.aVo, t.f.bg_expression_bubble, this.aej);
        this.aVo.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.aVn = new WindowManager.LayoutParams();
        this.aVq = context.getResources().getDimensionPixelSize(t.e.ds240);
        this.aVr = context.getResources().getDimensionPixelSize(t.e.ds252);
        this.aVs = context.getResources().getDimensionPixelSize(t.e.face_tab_content_float_space);
        this.aVn.width = this.aVq;
        this.aVn.height = this.aVr;
        this.aVn.gravity = 51;
        this.aVn.format = -3;
        this.aVn.type = 1000;
        this.aVn.flags |= 56;
        this.aVp = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ash = (IndicatorView) findViewById(t.g.face_tab_indicator);
        this.aVm = (LinearLayout) findViewById(t.g.face_tab_indicator_layout);
        this.aVm.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aVn.type = 1000;
            this.aVn.flags = 25165832;
        }
    }

    private void M(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.aVw.clear();
        this.aVx.clear();
        if (list != null && !list.isEmpty()) {
            this.aVw.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Bz = cVar.Bz();
                    int i4 = emotionsCount / (cols * Bz);
                    if (emotionsCount % (cols * Bz) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * Bz;
                        } else {
                            i = emotionsCount - ((cols * Bz) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.fG(i3);
                        tVar.b(cVar.Bw());
                        tVar.et(Bz);
                        tVar.es(cols);
                        tVar.fC(i4);
                        tVar.fD(i5);
                        tVar.fE(i);
                        tVar.fF(i5 * cols * Bz);
                        tVar.setEndIndex((i + i2) - 1);
                        this.aVx.add(tVar);
                    }
                }
            }
            this.aVy = this.aVx.size();
            for (int i6 = 0; i6 < this.aVy; i6++) {
                if (this.aVx != null && this.aVx.get(i6) != null) {
                    this.aVx.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void fz(int i) {
        if (this.aVx != null) {
            int size = this.aVx.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.aVx.get(i2);
                    if (tVar != null && tVar.LW() == i) {
                        this.aVB = tVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void g(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                M(list);
                fz(i);
                this.asg.setAdapter(new b());
                this.asg.setCurrentItem(this.aVB, true);
                if (this.aVA != null) {
                    this.aVA.fB(i);
                    this.aVz = i;
                }
            }
        }
    }

    public void fA(int i) {
        int i2;
        if (this.asg != null) {
            int size = this.aVx.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.aVx.get(i3);
                    if (tVar == null || tVar.LW() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.asg.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.aVu != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.LM() != null) {
            String ek = aVar.LM().LP().ek(aVar.LL() + i);
            this.aVo.setTag(ek);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.asZ = ek;
            this.aVo.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.aVp.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.aVn.x = this.rect.left - ((this.aVn.width - linearLayout.getWidth()) / 2);
            this.aVn.y = (this.rect.top - this.aVn.height) + this.aVs;
            this.aVo.setVisibility(0);
            if (!this.aVt) {
                this.bC.addView(this.aVo, this.aVn);
                this.aVt = true;
            } else {
                this.bC.updateViewLayout(this.aVo, this.aVn);
            }
            gridView.setSelection(i);
            if (this.aVu != -1) {
                ((LinearLayout) gridView.getChildAt(this.aVu - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aVu = i;
            this.aVl = gridView;
        }
    }

    private void LJ() {
        if (this.aVt && this.aVo.getVisibility() != 8 && this.aVl != null) {
            this.aVl.setSelection(-1);
            this.aVo.setVisibility(8);
            if (this.aVu != -1) {
                ((LinearLayout) this.aVl.getChildAt(this.aVu - this.aVl.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aVu = -1;
            this.aVl = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aVC.set(x, y);
                break;
            case 1:
            case 3:
                LJ();
                break;
            case 2:
                this.aVC.set(x, y);
                if (this.aVt && this.aVo.getVisibility() != 8 && this.aVl != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aVC.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                LJ();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    LJ();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.aVl != null) {
                        offsetRectIntoDescendantCoords(this.aVl, this.rect);
                        int pointToPosition = this.aVl.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aVl);
                            break;
                        }
                    }
                }
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aVt) {
            this.bC.removeView(this.aVo);
            this.aVt = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aVx != null) {
            int size = this.aVx.size();
            if (i >= 0 && i < size) {
                this.aVv = this.aVx.get(i);
                if (this.ash != null && this.aVv != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ash.setVisibility(this.aVv.LS() > 1 ? 0 : 4);
                        this.ash.setCount(this.aVv.LS());
                        if (this.aVv != null && this.aVv.LW() != this.aVz) {
                            this.aVz = this.aVv.LW();
                            if (this.aVA != null) {
                                this.aVA.fB(this.aVv.LW());
                            }
                        }
                    }
                    float LT = this.aVv.LT() + f;
                    this.ash.setPosition(LT);
                    this.aVm.setContentDescription(String.valueOf(String.format(getResources().getString(t.j.emotion_selection), Integer.valueOf(((int) LT) + 1))) + String.format(getResources().getString(t.j.emotion_page), Integer.valueOf(this.aVv.LS())));
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        this.aej = i;
        at.d(this.aVo, t.f.bg_expression_bubble, i);
        at.e(this, t.d.write_editor_background, i);
        this.ash.setSelector(at.o(i, t.f.dot_pb_expression_s));
        this.ash.setDrawable(at.o(i, t.f.dot_pb_expression_n));
    }

    public void reset() {
        LJ();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t aVF;

        public a(t tVar) {
            this.aVF = tVar;
        }

        public int LL() {
            if (this.aVF == null) {
                return 0;
            }
            return this.aVF.LV();
        }

        public t LM() {
            return this.aVF;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aVF == null) {
                return 0;
            }
            return this.aVF.LU();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            com.baidu.adp.widget.a.a aVar;
            int color;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m11getInst().getContext()).inflate(t.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.aVF.LR() != 0) {
                    i2 = measuredWidth / this.aVF.LR();
                }
                if (this.aVF.getRow() != 0) {
                    i3 = measuredHeight / this.aVF.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.aVs * 2, EmotionTabContentView.this.aVs * 2, EmotionTabContentView.this.aVs * 2, EmotionTabContentView.this.aVs * 2);
                linearLayout = linearLayout2;
                linearLayout = linearLayout2;
                if (i2 != 0 && i3 != 0) {
                    if (viewGroup != null && viewGroup.getChildAt(0) != null) {
                        viewGroup.getChildAt(0).setLayoutParams(new AbsListView.LayoutParams(i2, i3));
                    }
                    linearLayout2.setLayoutParams(new AbsListView.LayoutParams(i2, i3));
                    linearLayout = linearLayout2;
                }
            } else {
                linearLayout = view;
            }
            LinearLayout linearLayout3 = (LinearLayout) linearLayout;
            if (this.aVF != null) {
                int LV = this.aVF.LV() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(t.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                at.d(tbImageView, t.f.btn_choose_face_selector, EmotionTabContentView.this.aej);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ek = this.aVF.LP().ek(LV);
                tbImageView.setTag(ek);
                Object a = com.baidu.adp.lib.g.c.dF().a(ek, 20, new j(this), 0, 0, null, null, ek, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(t.g.emotion_tab_content_tip);
                if (this.aVF.LQ() == EmotionGroupType.BIG_EMOTION) {
                    String ek2 = this.aVF.LP().ek(LV);
                    if (!TextUtils.isEmpty(ek2)) {
                        if (EmotionTabContentView.this.aej == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(t.d.cp_cont_c);
                        } else {
                            color = at.getColor(t.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ek2.substring(ek2.lastIndexOf("_") + 1, ek2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ek.length() > 3) {
                    linearLayout3.setContentDescription(ek.substring(2, ek.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.aVx == null) {
                return 0;
            }
            return EmotionTabContentView.this.aVx.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.aVD.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.aVD.dD();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.aVx != null && i < EmotionTabContentView.this.aVx.size()) {
                t tVar = (t) EmotionTabContentView.this.aVx.get(i);
                gridView2.setNumColumns(tVar.LR());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(t.d.transparent);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(t.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(t.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.aVx != null) {
                int size = EmotionTabContentView.this.aVx.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.aVx.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ash.setVisibility(tVar.LS() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ash.setCount(tVar.LS());
                        EmotionTabContentView.this.ash.setPosition(tVar.LT());
                        EmotionTabContentView.this.ash.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(t.j.emotion_selection), Integer.valueOf(tVar.LT() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(t.j.emotion_page), Integer.valueOf(tVar.LS())));
                    }
                    if (tVar != null && tVar.LW() != EmotionTabContentView.this.aVz) {
                        EmotionTabContentView.this.aVz = tVar.LW();
                        if (EmotionTabContentView.this.aVA != null) {
                            EmotionTabContentView.this.aVA.fB(tVar.LW());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aVA = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.BV = lVar;
    }
}
