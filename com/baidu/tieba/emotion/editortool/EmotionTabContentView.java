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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.l EJ;
    private int ahV;
    private ViewPager awv;
    private IndicatorView aww;
    private WindowManager bC;
    private GridView bEE;
    private LinearLayout bEF;
    private WindowManager.LayoutParams bEG;
    private GifView bEH;
    private ViewGroup bEI;
    private int bEJ;
    private int bEK;
    private int bEL;
    private boolean bEM;
    private int bEN;
    private t bEO;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bEP;
    private List<t> bEQ;
    private int bER;
    private int bES;
    private c bET;
    private int bEU;
    private final Point bEV;
    private com.baidu.adp.lib.f.b<GridView> bEW;
    private int currentPosition;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hh(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bEN = -1;
        this.bER = 0;
        this.bES = -1;
        this.currentPosition = -1;
        this.bEV = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bEN = -1;
        this.bER = 0;
        this.bES = -1;
        this.currentPosition = -1;
        this.bEV = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bEP = new ArrayList();
        this.bEQ = new ArrayList();
        this.bEW = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.h.emotion_tab_content, (ViewGroup) this, true);
        this.awv = (ViewPager) findViewById(r.g.face_tab_viewpager);
        this.awv.setFadingEdgeLength(0);
        this.awv.setOnPageChangeListener(this);
        this.bEH = new GifView(context);
        av.d(this.bEH, r.f.bg_expression_bubble, this.ahV);
        this.bEH.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bEG = new WindowManager.LayoutParams();
        this.bEJ = context.getResources().getDimensionPixelSize(r.e.ds240);
        this.bEK = context.getResources().getDimensionPixelSize(r.e.ds252);
        this.bEL = context.getResources().getDimensionPixelSize(r.e.ds10);
        this.bEG.width = this.bEJ;
        this.bEG.height = this.bEK;
        this.bEG.gravity = 51;
        this.bEG.format = -3;
        this.bEG.type = 1000;
        this.bEG.flags |= 56;
        this.bEI = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aww = (IndicatorView) findViewById(r.g.face_tab_indicator);
        this.bEF = (LinearLayout) findViewById(r.g.face_tab_indicator_layout);
        this.bEF.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bEG.type = 1000;
            this.bEG.flags = 25165832;
        }
    }

    private void af(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bEP.clear();
        this.bEQ.clear();
        if (list != null && !list.isEmpty()) {
            this.bEP.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dd = cVar.Dd();
                    int i4 = emotionsCount / (cols * Dd);
                    if (emotionsCount % (cols * Dd) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * Dd;
                        } else {
                            i = emotionsCount - ((cols * Dd) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.hm(i3);
                        tVar.b(cVar.Da());
                        tVar.eL(Dd);
                        tVar.eK(cols);
                        tVar.hi(i4);
                        tVar.hj(i5);
                        tVar.hk(i);
                        tVar.hl(i5 * cols * Dd);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bEQ.add(tVar);
                    }
                }
            }
            this.bER = this.bEQ.size();
            for (int i6 = 0; i6 < this.bER; i6++) {
                if (this.bEQ != null && this.bEQ.get(i6) != null) {
                    this.bEQ.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hf(int i) {
        if (this.bEQ != null) {
            int size = this.bEQ.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bEQ.get(i2);
                    if (tVar != null && tVar.Xk() == i) {
                        this.bEU = tVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void h(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                af(list);
                hf(i);
                this.awv.setAdapter(new b());
                this.awv.setCurrentItem(this.bEU, true);
                if (this.bET != null) {
                    this.bET.hh(i);
                    this.bES = i;
                }
            }
        }
    }

    public void hg(int i) {
        int i2;
        if (this.awv != null) {
            int size = this.bEQ.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bEQ.get(i3);
                    if (tVar == null || tVar.Xk() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.awv.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bEN != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Xa() != null) {
            String eB = aVar.Xa().Xd().eB(aVar.WZ() + i);
            this.bEH.setTag(eB);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axo = eB;
            this.bEH.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bEI.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bEG.x = this.rect.left - ((this.bEG.width - linearLayout.getWidth()) / 2);
            this.bEG.y = (this.rect.top - this.bEG.height) + this.bEL;
            this.bEH.setVisibility(0);
            if (!this.bEM) {
                this.bC.addView(this.bEH, this.bEG);
                this.bEM = true;
            } else {
                this.bC.updateViewLayout(this.bEH, this.bEG);
            }
            gridView.setSelection(i);
            if (this.bEN != -1) {
                ((LinearLayout) gridView.getChildAt(this.bEN - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bEN = i;
            this.bEE = gridView;
        }
    }

    private void WX() {
        if (this.bEM && this.bEH.getVisibility() != 8 && this.bEE != null) {
            this.bEE.setSelection(-1);
            this.bEH.setVisibility(8);
            if (this.bEN != -1) {
                ((LinearLayout) this.bEE.getChildAt(this.bEN - this.bEE.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bEN = -1;
            this.bEE = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bEV.set(x, y);
                break;
            case 1:
            case 3:
                WX();
                break;
            case 2:
                this.bEV.set(x, y);
                if (this.bEM && this.bEH.getVisibility() != 8 && this.bEE != null) {
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
                this.bEV.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                WX();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    WX();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bEE != null) {
                        offsetRectIntoDescendantCoords(this.bEE, this.rect);
                        int pointToPosition = this.bEE.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bEE);
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
        if (this.bEM) {
            this.bC.removeView(this.bEH);
            this.bEM = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bEQ != null) {
            int size = this.bEQ.size();
            if (i >= 0 && i < size) {
                this.bEO = this.bEQ.get(i);
                if (this.aww != null && this.bEO != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aww.setVisibility(this.bEO.Xg() > 1 ? 0 : 4);
                        this.aww.setCount(this.bEO.Xg());
                        if (this.bEO != null && this.bEO.Xk() != this.bES) {
                            this.bES = this.bEO.Xk();
                            if (this.bET != null) {
                                this.bET.hh(this.bEO.Xk());
                            }
                        }
                    }
                    float Xh = this.bEO.Xh() + f;
                    this.aww.setPosition(Xh);
                    this.bEF.setContentDescription(String.valueOf(String.format(getResources().getString(r.j.emotion_selection), Integer.valueOf(((int) Xh) + 1))) + String.format(getResources().getString(r.j.emotion_page), Integer.valueOf(this.bEO.Xg())));
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
        this.ahV = i;
        av.d(this.bEH, r.f.bg_expression_bubble, i);
        av.e(this, r.d.common_color_10255, i);
        this.aww.setSelector(av.q(i, r.f.dot_pb_expression_s));
        this.aww.setDrawable(av.q(i, r.f.dot_pb_expression_n));
        if (this.awv != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.awv.getChildCount()) {
                    View childAt = this.awv.getChildAt(i3);
                    if (childAt != null && (childAt instanceof GridView)) {
                        GridView gridView = (GridView) childAt;
                        if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                            ((a) gridView.getAdapter()).notifyDataSetChanged();
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void reset() {
        WX();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t bEY;

        public a(t tVar) {
            this.bEY = tVar;
        }

        public int WZ() {
            if (this.bEY == null) {
                return 0;
            }
            return this.bEY.Xj();
        }

        public t Xa() {
            return this.bEY;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bEY == null) {
                return 0;
            }
            return this.bEY.Xi();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.bEY.Xf() != 0) {
                    i2 = measuredWidth / this.bEY.Xf();
                }
                if (this.bEY.getRow() != 0) {
                    i3 = measuredHeight / this.bEY.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bEL * 2, EmotionTabContentView.this.bEL * 2, EmotionTabContentView.this.bEL * 2, EmotionTabContentView.this.bEL * 2);
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
            if (this.bEY != null) {
                int Xj = this.bEY.Xj() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(r.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                av.d(tbImageView, r.f.btn_choose_face_selector, EmotionTabContentView.this.ahV);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eB = this.bEY.Xd().eB(Xj);
                tbImageView.setTag(eB);
                Object a = com.baidu.adp.lib.g.c.eA().a(eB, 20, new j(this), 0, 0, null, null, eB, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.e(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(r.g.emotion_tab_content_tip);
                if (this.bEY.Xe() == EmotionGroupType.BIG_EMOTION) {
                    String eB2 = this.bEY.Xd().eB(Xj);
                    if (!TextUtils.isEmpty(eB2)) {
                        if (EmotionTabContentView.this.ahV == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(r.d.cp_cont_c);
                        } else {
                            color = av.getColor(r.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eB2.substring(eB2.lastIndexOf("_") + 1, eB2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eB.length() > 3) {
                    linearLayout3.setContentDescription(eB.substring(2, eB.length() - 1));
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
            if (EmotionTabContentView.this.bEQ == null) {
                return 0;
            }
            return EmotionTabContentView.this.bEQ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bEW.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bEW.ey();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bEQ != null && i < EmotionTabContentView.this.bEQ.size()) {
                t tVar = (t) EmotionTabContentView.this.bEQ.get(i);
                gridView2.setNumColumns(tVar.Xf());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(r.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(r.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(r.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.bEQ != null) {
                int size = EmotionTabContentView.this.bEQ.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bEQ.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aww.setVisibility(tVar.Xg() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aww.setCount(tVar.Xg());
                        EmotionTabContentView.this.aww.setPosition(tVar.Xh());
                        EmotionTabContentView.this.aww.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(r.j.emotion_selection), Integer.valueOf(tVar.Xh() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(r.j.emotion_page), Integer.valueOf(tVar.Xg())));
                    }
                    if (tVar != null && tVar.Xk() != EmotionTabContentView.this.bES) {
                        EmotionTabContentView.this.bES = tVar.Xk();
                        if (EmotionTabContentView.this.bET != null) {
                            EmotionTabContentView.this.bET.hh(tVar.Xk());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bET = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
    }
}
