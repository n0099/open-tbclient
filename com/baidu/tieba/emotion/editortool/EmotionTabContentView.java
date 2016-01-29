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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.k Lx;
    private WindowManager.LayoutParams aUA;
    private GifView aUB;
    private ViewGroup aUC;
    private int aUD;
    private int aUE;
    private int aUF;
    private boolean aUG;
    private int aUH;
    private t aUI;
    private List<com.baidu.tbadk.editortools.emotiontool.c> aUJ;
    private List<t> aUK;
    private int aUL;
    private int aUM;
    private c aUN;
    private int aUO;
    private final Point aUP;
    private com.baidu.adp.lib.f.b<GridView> aUQ;
    private GridView aUz;
    private int ahU;
    private ViewPager ahW;
    private IndicatorView ahX;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void fF(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.aUH = -1;
        this.aUL = 0;
        this.aUM = -1;
        this.currentPosition = -1;
        this.aUP = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.aUH = -1;
        this.aUL = 0;
        this.aUM = -1;
        this.currentPosition = -1;
        this.aUP = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aUJ = new ArrayList();
        this.aUK = new ArrayList();
        this.aUQ = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.emotion_tab_content, (ViewGroup) this, true);
        this.ahW = (ViewPager) findViewById(t.g.face_tab_viewpager);
        this.ahW.setFadingEdgeLength(0);
        this.ahW.setOnPageChangeListener(this);
        this.aUB = new GifView(context);
        ar.c(this.aUB, t.f.bg_expression_bubble, this.ahU);
        this.aUB.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.aUA = new WindowManager.LayoutParams();
        this.aUD = context.getResources().getDimensionPixelSize(t.e.ds240);
        this.aUE = context.getResources().getDimensionPixelSize(t.e.ds252);
        this.aUF = context.getResources().getDimensionPixelSize(t.e.face_tab_content_float_space);
        this.aUA.width = this.aUD;
        this.aUA.height = this.aUE;
        this.aUA.gravity = 51;
        this.aUA.format = -3;
        this.aUA.type = 1000;
        this.aUA.flags |= 56;
        this.aUC = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ahX = (IndicatorView) findViewById(t.g.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aUA.type = 1000;
            this.aUA.flags = 25165832;
        }
    }

    private void H(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.aUJ.clear();
        this.aUK.clear();
        if (list != null && !list.isEmpty()) {
            this.aUJ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int CW = cVar.CW();
                    int rows = cVar.getRows();
                    int i4 = emotionsCount / (CW * rows);
                    if (emotionsCount % (CW * rows) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = CW * rows;
                        } else {
                            i = emotionsCount - ((CW * rows) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.fK(i3);
                        tVar.b(cVar.CT());
                        tVar.eJ(rows);
                        tVar.eI(CW);
                        tVar.fG(i4);
                        tVar.fH(i5);
                        tVar.fI(i);
                        tVar.fJ(i5 * CW * rows);
                        tVar.setEndIndex((i + i2) - 1);
                        this.aUK.add(tVar);
                    }
                }
            }
            this.aUL = this.aUK.size();
            for (int i6 = 0; i6 < this.aUL; i6++) {
                if (this.aUK != null && this.aUK.get(i6) != null) {
                    this.aUK.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void fD(int i) {
        if (this.aUK != null) {
            int size = this.aUK.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.aUK.get(i2);
                    if (tVar != null && tVar.Lx() == i) {
                        this.aUO = tVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void c(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                H(list);
                fD(i);
                this.ahW.setAdapter(new b());
                this.ahW.setCurrentItem(this.aUO, true);
                if (this.aUN != null) {
                    this.aUN.fF(i);
                    this.aUM = i;
                }
            }
        }
    }

    public void fE(int i) {
        int i2;
        if (this.ahW != null) {
            int size = this.aUK.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.aUK.get(i3);
                    if (tVar == null || tVar.Lx() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.ahW.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.aUH != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Ln() != null) {
            String eA = aVar.Ln().Lq().eA(aVar.Lm() + i);
            this.aUB.setTag(eA);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.awr = eA;
            this.aUB.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.aUC.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.aUA.x = this.rect.left - ((this.aUA.width - linearLayout.getWidth()) / 2);
            this.aUA.y = (this.rect.top - this.aUA.height) + this.aUF;
            this.aUB.setVisibility(0);
            if (!this.aUG) {
                this.lB.addView(this.aUB, this.aUA);
                this.aUG = true;
            } else {
                this.lB.updateViewLayout(this.aUB, this.aUA);
            }
            gridView.setSelection(i);
            if (this.aUH != -1) {
                ((LinearLayout) gridView.getChildAt(this.aUH - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aUH = i;
            this.aUz = gridView;
        }
    }

    private void Lk() {
        if (this.aUG && this.aUB.getVisibility() != 8 && this.aUz != null) {
            this.aUz.setSelection(-1);
            this.aUB.setVisibility(8);
            if (this.aUH != -1) {
                ((LinearLayout) this.aUz.getChildAt(this.aUH - this.aUz.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aUH = -1;
            this.aUz = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aUP.set(x, y);
                break;
            case 1:
            case 3:
                Lk();
                break;
            case 2:
                this.aUP.set(x, y);
                if (this.aUG && this.aUB.getVisibility() != 8 && this.aUz != null) {
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
                this.aUP.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Lk();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Lk();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.aUz != null) {
                        offsetRectIntoDescendantCoords(this.aUz, this.rect);
                        int pointToPosition = this.aUz.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aUz);
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
        if (this.aUG) {
            this.lB.removeView(this.aUB);
            this.aUG = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aUK != null) {
            int size = this.aUK.size();
            if (i >= 0 && i < size) {
                this.aUI = this.aUK.get(i);
                if (this.ahX != null && this.aUI != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ahX.setVisibility(this.aUI.Lt() > 1 ? 0 : 4);
                        this.ahX.setCount(this.aUI.Lt());
                        if (this.aUI != null && this.aUI.Lx() != this.aUM) {
                            this.aUM = this.aUI.Lx();
                            if (this.aUN != null) {
                                this.aUN.fF(this.aUI.Lx());
                            }
                        }
                    }
                    this.ahX.setPosition(this.aUI.Lu() + f);
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
        this.ahU = i;
        ar.c(this.aUB, t.f.bg_expression_bubble, i);
        ar.d(this, t.d.write_editor_background, i);
        this.ahX.setSelector(ar.s(i, t.f.dot_pb_expression_s));
        this.ahX.setDrawable(ar.s(i, t.f.dot_pb_expression_n));
    }

    public void reset() {
        Lk();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t aUS;

        public a(t tVar) {
            this.aUS = tVar;
        }

        public int Lm() {
            if (this.aUS == null) {
                return 0;
            }
            return this.aUS.Lw();
        }

        public t Ln() {
            return this.aUS;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aUS == null) {
                return 0;
            }
            return this.aUS.Lv();
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
            int color;
            LinearLayout linearLayout = (LinearLayout) (view == null ? (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.emotion_tab_content_item, (ViewGroup) null) : view);
            if (this.aUS != null) {
                int Lw = this.aUS.Lw() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int Ls = measuredWidth / this.aUS.Ls();
                int row = measuredHeight / this.aUS.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.aUF * 2, EmotionTabContentView.this.aUF * 2, EmotionTabContentView.this.aUF * 2, EmotionTabContentView.this.aUF * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(Ls, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(t.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ar.c(tbImageView, t.f.btn_choose_face_selector, EmotionTabContentView.this.ahU);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eA = this.aUS.Lq().eA(Lw);
                tbImageView.setTag(eA);
                Object a = com.baidu.adp.lib.g.c.hl().a(eA, 20, new j(this), 0, 0, null, null, eA, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(t.g.emotion_tab_content_tip);
                if (this.aUS.Lr() == EmotionGroupType.BIG_EMOTION) {
                    String eA2 = this.aUS.Lq().eA(Lw);
                    if (!TextUtils.isEmpty(eA2)) {
                        if (EmotionTabContentView.this.ahU == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(t.d.cp_cont_c);
                        } else {
                            color = ar.getColor(t.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eA2.substring(eA2.lastIndexOf("_") + 1, eA2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
            }
            return linearLayout;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.aUK == null) {
                return 0;
            }
            return EmotionTabContentView.this.aUK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.aUQ.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.aUQ.hj();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.aUK != null && i < EmotionTabContentView.this.aUK.size()) {
                t tVar = (t) EmotionTabContentView.this.aUK.get(i);
                gridView2.setNumColumns(tVar.Ls());
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
            if (EmotionTabContentView.this.aUK != null) {
                int size = EmotionTabContentView.this.aUK.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.aUK.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ahX.setVisibility(tVar.Lt() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ahX.setCount(tVar.Lt());
                        EmotionTabContentView.this.ahX.setPosition(tVar.Lu());
                    }
                    if (tVar != null && tVar.Lx() != EmotionTabContentView.this.aUM) {
                        EmotionTabContentView.this.aUM = tVar.Lx();
                        if (EmotionTabContentView.this.aUN != null) {
                            EmotionTabContentView.this.aUN.fF(tVar.Lx());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aUN = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
    }
}
