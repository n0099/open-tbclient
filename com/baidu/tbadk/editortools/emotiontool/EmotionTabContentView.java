package com.baidu.tbadk.editortools.emotiontool;

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.j KA;
    private IndicatorView apA;
    private WindowManager.LayoutParams apB;
    private GifView apC;
    private final Rect apD;
    private ViewGroup apE;
    private int apF;
    private int apG;
    private int apH;
    private boolean apI;
    private int apJ;
    private o apK;
    private List<t> apL;
    private List<o> apM;
    private int apN;
    private int apO;
    private c apP;
    private int apQ;
    private final Point apR;
    private int apS;
    private com.baidu.adp.lib.e.b<GridView> apT;
    private GridView apz;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void dZ(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apD = new Rect();
        this.apJ = -1;
        this.apN = 0;
        this.apO = -1;
        this.currentPosition = -1;
        this.apR = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.apD = new Rect();
        this.apJ = -1;
        this.apN = 0;
        this.apO = -1;
        this.currentPosition = -1;
        this.apR = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.apL = new ArrayList();
        this.apM = new ArrayList();
        this.apT = new com.baidu.adp.lib.e.b<>(new com.baidu.tbadk.editortools.emotiontool.c(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(i.g.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(i.f.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.apC = new GifView(context);
        an.c(this.apC, i.e.bg_expression_bubble, this.apS);
        this.apC.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.apB = new WindowManager.LayoutParams();
        this.apF = context.getResources().getDimensionPixelSize(i.d.ds240);
        this.apG = context.getResources().getDimensionPixelSize(i.d.ds252);
        this.apH = context.getResources().getDimensionPixelSize(i.d.face_tab_content_float_space);
        this.apB.width = this.apF;
        this.apB.height = this.apG;
        this.apB.gravity = 51;
        this.apB.format = -3;
        this.apB.type = 1000;
        this.apB.flags |= 56;
        this.apE = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.apA = (IndicatorView) findViewById(i.f.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.apB.type = 1000;
            this.apB.flags = 25165832;
        }
    }

    private void p(List<t> list) {
        int i;
        int i2;
        this.apL.clear();
        this.apM.clear();
        if (list != null && !list.isEmpty()) {
            this.apL.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                t tVar = list.get(i3);
                if (tVar != null) {
                    int emotionsCount = tVar.getEmotionsCount();
                    int Bi = tVar.Bi();
                    int Bj = tVar.Bj();
                    int i4 = emotionsCount / (Bi * Bj);
                    if (emotionsCount % (Bi * Bj) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        o oVar = new o();
                        if (i5 < i4 - 1) {
                            i = Bi * Bj;
                        } else {
                            i = emotionsCount - ((Bi * Bj) * (i4 - 1));
                        }
                        oVar.e(tVar);
                        oVar.eh(i3);
                        oVar.b(tVar.AZ());
                        oVar.eb(Bj);
                        oVar.ec(Bi);
                        oVar.ed(i4);
                        oVar.ee(i5);
                        oVar.ef(i);
                        oVar.eg(i5 * Bi * Bj);
                        oVar.setEndIndex((i + i2) - 1);
                        this.apM.add(oVar);
                    }
                }
            }
            this.apN = this.apM.size();
            for (int i6 = 0; i6 < this.apN; i6++) {
                if (this.apM != null && this.apM.get(i6) != null) {
                    this.apM.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dX(int i) {
        if (this.apM != null) {
            int size = this.apM.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    o oVar = this.apM.get(i2);
                    if (oVar != null && oVar.AY() == i) {
                        this.apQ = oVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void c(List<t> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                p(list);
                dX(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.apQ, true);
                if (this.apP != null) {
                    this.apP.dZ(i);
                    this.apO = i;
                }
            }
        }
    }

    public void dY(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.apM.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    o oVar = this.apM.get(i3);
                    if (oVar == null || oVar.AY() != i) {
                        i3++;
                    } else {
                        i2 = oVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, true);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.apJ != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.AN() != null) {
            String ei = aVar.AN().AR().ei(aVar.AM() + i);
            this.apC.setTag(ei);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atg = ei;
            this.apC.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.apD);
            this.apE.offsetDescendantRectToMyCoords(linearLayout, this.apD);
            this.apB.x = this.apD.left - ((this.apB.width - linearLayout.getWidth()) / 2);
            this.apB.y = (this.apD.top - this.apB.height) + this.apH;
            this.apC.setVisibility(0);
            if (!this.apI) {
                this.lB.addView(this.apC, this.apB);
                this.apI = true;
            } else {
                this.lB.updateViewLayout(this.apC, this.apB);
            }
            gridView.setSelection(i);
            if (this.apJ != -1) {
                ((LinearLayout) gridView.getChildAt(this.apJ - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.apJ = i;
            this.apz = gridView;
        }
    }

    private void AK() {
        if (this.apI && this.apC.getVisibility() != 8 && this.apz != null) {
            this.apz.setSelection(-1);
            this.apC.setVisibility(8);
            if (this.apJ != -1) {
                ((LinearLayout) this.apz.getChildAt(this.apJ - this.apz.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.apJ = -1;
            this.apz = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.apR.set(x, y);
                break;
            case 1:
            case 3:
                AK();
                break;
            case 2:
                this.apR.set(x, y);
                if (this.apI && this.apC.getVisibility() != 8 && this.apz != null) {
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
                this.apR.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                AK();
                break;
            case 2:
                getFocusedRect(this.apD);
                if (!this.apD.contains(x, y)) {
                    AK();
                    break;
                } else {
                    this.apD.set(x, y, x + 1, y + 1);
                    if (this.apz != null) {
                        offsetRectIntoDescendantCoords(this.apz, this.apD);
                        int pointToPosition = this.apz.pointToPosition(this.apD.left, this.apD.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.apz);
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
        if (this.apI) {
            this.lB.removeView(this.apC);
            this.apI = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.apM != null) {
            int size = this.apM.size();
            if (i >= 0 && i < size) {
                this.apK = this.apM.get(i);
                if (this.apA != null && this.apK != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.apA.setVisibility(0);
                        this.apA.setCount(this.apK.AU());
                        if (this.apK != null && this.apK.AY() != this.apO) {
                            this.apO = this.apK.AY();
                            if (this.apP != null) {
                                this.apP.dZ(this.apK.AY());
                            }
                        }
                    }
                    this.apA.setPosition(this.apK.AV() + f);
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
        this.apS = i;
        an.c(this.apC, i.e.bg_expression_bubble, i);
        an.d(this, i.c.write_editor_background, i);
        this.apA.setSelector(an.x(i, i.e.dot_pb_expression_s));
        this.apA.setDrawable(an.x(i, i.e.dot_pb_expression_n));
    }

    public void reset() {
        AK();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final o apV;

        public a(o oVar) {
            this.apV = oVar;
        }

        public int AM() {
            if (this.apV == null) {
                return 0;
            }
            return this.apV.AX();
        }

        public o AN() {
            return this.apV;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.apV == null) {
                return 0;
            }
            return this.apV.AW();
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
            LinearLayout linearLayout = (LinearLayout) (view == null ? (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(i.g.emotion_tab_content_item, (ViewGroup) null) : view);
            if (this.apV != null) {
                int AX = this.apV.AX() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int AT = measuredWidth / this.apV.AT();
                int row = measuredHeight / this.apV.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.apH * 2, EmotionTabContentView.this.apH * 2, EmotionTabContentView.this.apH * 2, EmotionTabContentView.this.apH * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(AT, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                an.c(tbImageView, i.e.btn_choose_face_selector, EmotionTabContentView.this.apS);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ei = this.apV.AR().ei(AX);
                tbImageView.setTag(ei);
                Object a = com.baidu.adp.lib.f.c.ha().a(ei, 20, new d(this), 0, 0, null, null, ei, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(i.f.emotion_tab_content_tip);
                if (this.apV.AS() == EmotionGroupType.BIG_EMOTION) {
                    String ei2 = this.apV.AR().ei(AX);
                    if (!TextUtils.isEmpty(ei2)) {
                        if (EmotionTabContentView.this.apS == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(i.c.cp_cont_c);
                        } else {
                            color = an.getColor(i.c.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ei2.substring(ei2.lastIndexOf("_") + 1, ei2.length() - 1));
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
            if (EmotionTabContentView.this.apM == null) {
                return 0;
            }
            return EmotionTabContentView.this.apM.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.apT.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.apT.gY();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.apM != null && i < EmotionTabContentView.this.apM.size()) {
                o oVar = (o) EmotionTabContentView.this.apM.get(i);
                gridView2.setNumColumns(oVar.AT());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(i.c.transparent);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(i.d.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(i.d.ds28), 0);
                gridView2.setOnItemLongClickListener(new e(this));
                gridView2.setOnItemClickListener(new f(this));
                gridView2.setAdapter((ListAdapter) new a(oVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.apM != null) {
                int size = EmotionTabContentView.this.apM.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    o oVar = (o) EmotionTabContentView.this.apM.get(i);
                    if (oVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.apA.setVisibility(0);
                        EmotionTabContentView.this.apA.setCount(oVar.AU());
                        EmotionTabContentView.this.apA.setPosition(oVar.AV());
                    }
                    if (oVar != null && oVar.AY() != EmotionTabContentView.this.apO) {
                        EmotionTabContentView.this.apO = oVar.AY();
                        if (EmotionTabContentView.this.apP != null) {
                            EmotionTabContentView.this.apP.dZ(oVar.AY());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.apP = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.KA = jVar;
    }
}
