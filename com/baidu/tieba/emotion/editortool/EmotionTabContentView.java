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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.k KS;
    private GridView aOD;
    private WindowManager.LayoutParams aOE;
    private GifView aOF;
    private ViewGroup aOG;
    private int aOH;
    private int aOI;
    private int aOJ;
    private boolean aOK;
    private int aOL;
    private t aOM;
    private List<com.baidu.tbadk.editortools.emotiontool.c> aON;
    private List<t> aOO;
    private int aOP;
    private int aOQ;
    private c aOR;
    private int aOS;
    private final Point aOT;
    private com.baidu.adp.lib.f.b<GridView> aOU;
    private int afY;
    private IndicatorView agf;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void fl(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.aOL = -1;
        this.aOP = 0;
        this.aOQ = -1;
        this.currentPosition = -1;
        this.aOT = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.aOL = -1;
        this.aOP = 0;
        this.aOQ = -1;
        this.currentPosition = -1;
        this.aOT = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aON = new ArrayList();
        this.aOO = new ArrayList();
        this.aOU = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(n.g.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(n.f.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.aOF = new GifView(context);
        as.c(this.aOF, n.e.bg_expression_bubble, this.afY);
        this.aOF.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.aOE = new WindowManager.LayoutParams();
        this.aOH = context.getResources().getDimensionPixelSize(n.d.ds240);
        this.aOI = context.getResources().getDimensionPixelSize(n.d.ds252);
        this.aOJ = context.getResources().getDimensionPixelSize(n.d.face_tab_content_float_space);
        this.aOE.width = this.aOH;
        this.aOE.height = this.aOI;
        this.aOE.gravity = 51;
        this.aOE.format = -3;
        this.aOE.type = 1000;
        this.aOE.flags |= 56;
        this.aOG = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.agf = (IndicatorView) findViewById(n.f.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aOE.type = 1000;
            this.aOE.flags = 25165832;
        }
    }

    private void J(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.aON.clear();
        this.aOO.clear();
        if (list != null && !list.isEmpty()) {
            this.aON.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int BQ = cVar.BQ();
                    int BR = cVar.BR();
                    int i4 = emotionsCount / (BQ * BR);
                    if (emotionsCount % (BQ * BR) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = BQ * BR;
                        } else {
                            i = emotionsCount - ((BQ * BR) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.fq(i3);
                        tVar.b(cVar.BN());
                        tVar.ev(BR);
                        tVar.eu(BQ);
                        tVar.fm(i4);
                        tVar.fn(i5);
                        tVar.fo(i);
                        tVar.fp(i5 * BQ * BR);
                        tVar.setEndIndex((i + i2) - 1);
                        this.aOO.add(tVar);
                    }
                }
            }
            this.aOP = this.aOO.size();
            for (int i6 = 0; i6 < this.aOP; i6++) {
                if (this.aOO != null && this.aOO.get(i6) != null) {
                    this.aOO.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void fj(int i) {
        if (this.aOO != null) {
            int size = this.aOO.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.aOO.get(i2);
                    if (tVar != null && tVar.Js() == i) {
                        this.aOS = tVar.getIndex();
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
                J(list);
                fj(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.aOS, true);
                if (this.aOR != null) {
                    this.aOR.fl(i);
                    this.aOQ = i;
                }
            }
        }
    }

    public void fk(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.aOO.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.aOO.get(i3);
                    if (tVar == null || tVar.Js() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.aOL != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Ji() != null) {
            String el = aVar.Ji().Jl().el(aVar.Jh() + i);
            this.aOF.setTag(el);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atV = el;
            this.aOF.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.aOG.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.aOE.x = this.rect.left - ((this.aOE.width - linearLayout.getWidth()) / 2);
            this.aOE.y = (this.rect.top - this.aOE.height) + this.aOJ;
            this.aOF.setVisibility(0);
            if (!this.aOK) {
                this.lB.addView(this.aOF, this.aOE);
                this.aOK = true;
            } else {
                this.lB.updateViewLayout(this.aOF, this.aOE);
            }
            gridView.setSelection(i);
            if (this.aOL != -1) {
                ((LinearLayout) gridView.getChildAt(this.aOL - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aOL = i;
            this.aOD = gridView;
        }
    }

    private void Jf() {
        if (this.aOK && this.aOF.getVisibility() != 8 && this.aOD != null) {
            this.aOD.setSelection(-1);
            this.aOF.setVisibility(8);
            if (this.aOL != -1) {
                ((LinearLayout) this.aOD.getChildAt(this.aOL - this.aOD.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aOL = -1;
            this.aOD = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aOT.set(x, y);
                break;
            case 1:
            case 3:
                Jf();
                break;
            case 2:
                this.aOT.set(x, y);
                if (this.aOK && this.aOF.getVisibility() != 8 && this.aOD != null) {
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
                this.aOT.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Jf();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Jf();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.aOD != null) {
                        offsetRectIntoDescendantCoords(this.aOD, this.rect);
                        int pointToPosition = this.aOD.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aOD);
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
        if (this.aOK) {
            this.lB.removeView(this.aOF);
            this.aOK = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aOO != null) {
            int size = this.aOO.size();
            if (i >= 0 && i < size) {
                this.aOM = this.aOO.get(i);
                if (this.agf != null && this.aOM != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.agf.setVisibility(this.aOM.Jo() > 1 ? 0 : 4);
                        this.agf.setCount(this.aOM.Jo());
                        if (this.aOM != null && this.aOM.Js() != this.aOQ) {
                            this.aOQ = this.aOM.Js();
                            if (this.aOR != null) {
                                this.aOR.fl(this.aOM.Js());
                            }
                        }
                    }
                    this.agf.setPosition(this.aOM.Jp() + f);
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
        this.afY = i;
        as.c(this.aOF, n.e.bg_expression_bubble, i);
        as.d(this, n.c.write_editor_background, i);
        this.agf.setSelector(as.x(i, n.e.dot_pb_expression_s));
        this.agf.setDrawable(as.x(i, n.e.dot_pb_expression_n));
    }

    public void reset() {
        Jf();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t aOW;

        public a(t tVar) {
            this.aOW = tVar;
        }

        public int Jh() {
            if (this.aOW == null) {
                return 0;
            }
            return this.aOW.Jr();
        }

        public t Ji() {
            return this.aOW;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aOW == null) {
                return 0;
            }
            return this.aOW.Jq();
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
            LinearLayout linearLayout = (LinearLayout) (view == null ? (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.g.emotion_tab_content_item, (ViewGroup) null) : view);
            if (this.aOW != null) {
                int Jr = this.aOW.Jr() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int Jn = measuredWidth / this.aOW.Jn();
                int row = measuredHeight / this.aOW.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.aOJ * 2, EmotionTabContentView.this.aOJ * 2, EmotionTabContentView.this.aOJ * 2, EmotionTabContentView.this.aOJ * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(Jn, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(n.f.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                as.c(tbImageView, n.e.btn_choose_face_selector, EmotionTabContentView.this.afY);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String el = this.aOW.Jl().el(Jr);
                tbImageView.setTag(el);
                Object a = com.baidu.adp.lib.g.c.hd().a(el, 20, new j(this), 0, 0, null, null, el, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(n.f.emotion_tab_content_tip);
                if (this.aOW.Jm() == EmotionGroupType.BIG_EMOTION) {
                    String el2 = this.aOW.Jl().el(Jr);
                    if (!TextUtils.isEmpty(el2)) {
                        if (EmotionTabContentView.this.afY == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(n.c.cp_cont_c);
                        } else {
                            color = as.getColor(n.c.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(el2.substring(el2.lastIndexOf("_") + 1, el2.length() - 1));
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
            if (EmotionTabContentView.this.aOO == null) {
                return 0;
            }
            return EmotionTabContentView.this.aOO.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.aOU.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.aOU.hb();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.aOO != null && i < EmotionTabContentView.this.aOO.size()) {
                t tVar = (t) EmotionTabContentView.this.aOO.get(i);
                gridView2.setNumColumns(tVar.Jn());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(n.c.transparent);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(n.d.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(n.d.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.aOO != null) {
                int size = EmotionTabContentView.this.aOO.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.aOO.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.agf.setVisibility(tVar.Jo() > 1 ? 0 : 4);
                        EmotionTabContentView.this.agf.setCount(tVar.Jo());
                        EmotionTabContentView.this.agf.setPosition(tVar.Jp());
                    }
                    if (tVar != null && tVar.Js() != EmotionTabContentView.this.aOQ) {
                        EmotionTabContentView.this.aOQ = tVar.Js();
                        if (EmotionTabContentView.this.aOR != null) {
                            EmotionTabContentView.this.aOR.fl(tVar.Js());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aOR = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
    }
}
