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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.j Kz;
    private WindowManager.LayoutParams apA;
    private GifView apB;
    private final Rect apC;
    private ViewGroup apD;
    private int apE;
    private int apF;
    private int apG;
    private boolean apH;
    private int apI;
    private o apJ;
    private List<t> apK;
    private List<o> apL;
    private int apM;
    private int apN;
    private c apO;
    private int apP;
    private final Point apQ;
    private int apR;
    private com.baidu.adp.lib.e.b<GridView> apS;
    private GridView apy;
    private IndicatorView apz;
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
        this.apC = new Rect();
        this.apI = -1;
        this.apM = 0;
        this.apN = -1;
        this.currentPosition = -1;
        this.apQ = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.apC = new Rect();
        this.apI = -1;
        this.apM = 0;
        this.apN = -1;
        this.currentPosition = -1;
        this.apQ = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.apK = new ArrayList();
        this.apL = new ArrayList();
        this.apS = new com.baidu.adp.lib.e.b<>(new com.baidu.tbadk.editortools.emotiontool.c(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(i.g.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(i.f.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.apB = new GifView(context);
        am.c(this.apB, i.e.bg_expression_bubble, this.apR);
        this.apB.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.apA = new WindowManager.LayoutParams();
        this.apE = context.getResources().getDimensionPixelSize(i.d.ds240);
        this.apF = context.getResources().getDimensionPixelSize(i.d.ds252);
        this.apG = context.getResources().getDimensionPixelSize(i.d.face_tab_content_float_space);
        this.apA.width = this.apE;
        this.apA.height = this.apF;
        this.apA.gravity = 51;
        this.apA.format = -3;
        this.apA.type = 1000;
        this.apA.flags |= 56;
        this.apD = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.apz = (IndicatorView) findViewById(i.f.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.apA.type = 1000;
            this.apA.flags = 25165832;
        }
    }

    private void p(List<t> list) {
        int i;
        int i2;
        this.apK.clear();
        this.apL.clear();
        if (list != null && !list.isEmpty()) {
            this.apK.addAll(list);
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
                        this.apL.add(oVar);
                    }
                }
            }
            this.apM = this.apL.size();
            for (int i6 = 0; i6 < this.apM; i6++) {
                if (this.apL != null && this.apL.get(i6) != null) {
                    this.apL.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dX(int i) {
        if (this.apL != null) {
            int size = this.apL.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    o oVar = this.apL.get(i2);
                    if (oVar != null && oVar.AY() == i) {
                        this.apP = oVar.getIndex();
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
                this.mViewPager.setCurrentItem(this.apP, true);
                if (this.apO != null) {
                    this.apO.dZ(i);
                    this.apN = i;
                }
            }
        }
    }

    public void dY(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.apL.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    o oVar = this.apL.get(i3);
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
        if (this.apI != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.AN() != null) {
            String ei = aVar.AN().AR().ei(aVar.AM() + i);
            this.apB.setTag(ei);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atf = ei;
            this.apB.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.apC);
            this.apD.offsetDescendantRectToMyCoords(linearLayout, this.apC);
            this.apA.x = this.apC.left - ((this.apA.width - linearLayout.getWidth()) / 2);
            this.apA.y = (this.apC.top - this.apA.height) + this.apG;
            this.apB.setVisibility(0);
            if (!this.apH) {
                this.lB.addView(this.apB, this.apA);
                this.apH = true;
            } else {
                this.lB.updateViewLayout(this.apB, this.apA);
            }
            gridView.setSelection(i);
            if (this.apI != -1) {
                ((LinearLayout) gridView.getChildAt(this.apI - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.apI = i;
            this.apy = gridView;
        }
    }

    private void AK() {
        if (this.apH && this.apB.getVisibility() != 8 && this.apy != null) {
            this.apy.setSelection(-1);
            this.apB.setVisibility(8);
            if (this.apI != -1) {
                ((LinearLayout) this.apy.getChildAt(this.apI - this.apy.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.apI = -1;
            this.apy = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.apQ.set(x, y);
                break;
            case 1:
            case 3:
                AK();
                break;
            case 2:
                this.apQ.set(x, y);
                if (this.apH && this.apB.getVisibility() != 8 && this.apy != null) {
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
                this.apQ.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                AK();
                break;
            case 2:
                getFocusedRect(this.apC);
                if (!this.apC.contains(x, y)) {
                    AK();
                    break;
                } else {
                    this.apC.set(x, y, x + 1, y + 1);
                    if (this.apy != null) {
                        offsetRectIntoDescendantCoords(this.apy, this.apC);
                        int pointToPosition = this.apy.pointToPosition(this.apC.left, this.apC.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.apy);
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
        if (this.apH) {
            this.lB.removeView(this.apB);
            this.apH = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.apL != null) {
            int size = this.apL.size();
            if (i >= 0 && i < size) {
                this.apJ = this.apL.get(i);
                if (this.apz != null && this.apJ != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.apz.setVisibility(0);
                        this.apz.setCount(this.apJ.AU());
                        if (this.apJ != null && this.apJ.AY() != this.apN) {
                            this.apN = this.apJ.AY();
                            if (this.apO != null) {
                                this.apO.dZ(this.apJ.AY());
                            }
                        }
                    }
                    this.apz.setPosition(this.apJ.AV() + f);
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
        this.apR = i;
        am.c(this.apB, i.e.bg_expression_bubble, i);
        am.d(this, i.c.write_editor_background, i);
        this.apz.setSelector(am.x(i, i.e.dot_pb_expression_s));
        this.apz.setDrawable(am.x(i, i.e.dot_pb_expression_n));
    }

    public void reset() {
        AK();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final o apU;

        public a(o oVar) {
            this.apU = oVar;
        }

        public int AM() {
            if (this.apU == null) {
                return 0;
            }
            return this.apU.AX();
        }

        public o AN() {
            return this.apU;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.apU == null) {
                return 0;
            }
            return this.apU.AW();
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
            if (this.apU != null) {
                int AX = this.apU.AX() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int AT = measuredWidth / this.apU.AT();
                int row = measuredHeight / this.apU.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.apG * 2, EmotionTabContentView.this.apG * 2, EmotionTabContentView.this.apG * 2, EmotionTabContentView.this.apG * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(AT, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.c(tbImageView, i.e.btn_choose_face_selector, EmotionTabContentView.this.apR);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ei = this.apU.AR().ei(AX);
                tbImageView.setTag(ei);
                Object a = com.baidu.adp.lib.f.c.ha().a(ei, 20, new d(this), 0, 0, null, null, ei, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(i.f.emotion_tab_content_tip);
                if (this.apU.AS() == EmotionGroupType.BIG_EMOTION) {
                    String ei2 = this.apU.AR().ei(AX);
                    if (!TextUtils.isEmpty(ei2)) {
                        if (EmotionTabContentView.this.apR == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(i.c.cp_cont_c);
                        } else {
                            color = am.getColor(i.c.cp_cont_c);
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
            if (EmotionTabContentView.this.apL == null) {
                return 0;
            }
            return EmotionTabContentView.this.apL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.apS.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.apS.gY();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.apL != null && i < EmotionTabContentView.this.apL.size()) {
                o oVar = (o) EmotionTabContentView.this.apL.get(i);
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
            if (EmotionTabContentView.this.apL != null) {
                int size = EmotionTabContentView.this.apL.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    o oVar = (o) EmotionTabContentView.this.apL.get(i);
                    if (oVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.apz.setVisibility(0);
                        EmotionTabContentView.this.apz.setCount(oVar.AU());
                        EmotionTabContentView.this.apz.setPosition(oVar.AV());
                    }
                    if (oVar != null && oVar.AY() != EmotionTabContentView.this.apN) {
                        EmotionTabContentView.this.apN = oVar.AY();
                        if (EmotionTabContentView.this.apO != null) {
                            EmotionTabContentView.this.apO.dZ(oVar.AY());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.apO = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
    }
}
