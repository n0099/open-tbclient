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
import com.baidu.tieba.r;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.j EM;
    private int aib;
    private ViewPager aid;
    private IndicatorView aie;
    private WindowManager bC;
    private GridView bnB;
    private LinearLayout bnC;
    private WindowManager.LayoutParams bnD;
    private GifView bnE;
    private ViewGroup bnF;
    private int bnG;
    private int bnH;
    private int bnI;
    private boolean bnJ;
    private int bnK;
    private t bnL;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bnM;
    private List<t> bnN;
    private int bnO;
    private int bnP;
    private c bnQ;
    private int bnR;
    private final Point bnS;
    private com.baidu.adp.lib.f.b<GridView> bnT;
    private int currentPosition;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void gs(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bnK = -1;
        this.bnO = 0;
        this.bnP = -1;
        this.currentPosition = -1;
        this.bnS = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bnK = -1;
        this.bnO = 0;
        this.bnP = -1;
        this.currentPosition = -1;
        this.bnS = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bnM = new ArrayList();
        this.bnN = new ArrayList();
        this.bnT = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.h.emotion_tab_content, (ViewGroup) this, true);
        this.aid = (ViewPager) findViewById(r.g.face_tab_viewpager);
        this.aid.setFadingEdgeLength(0);
        this.aid.setOnPageChangeListener(this);
        this.bnE = new GifView(context);
        ar.d(this.bnE, r.f.bg_expression_bubble, this.aib);
        this.bnE.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bnD = new WindowManager.LayoutParams();
        this.bnG = context.getResources().getDimensionPixelSize(r.e.ds240);
        this.bnH = context.getResources().getDimensionPixelSize(r.e.ds252);
        this.bnI = context.getResources().getDimensionPixelSize(r.e.ds10);
        this.bnD.width = this.bnG;
        this.bnD.height = this.bnH;
        this.bnD.gravity = 51;
        this.bnD.format = -3;
        this.bnD.type = 1000;
        this.bnD.flags |= 56;
        this.bnF = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aie = (IndicatorView) findViewById(r.g.face_tab_indicator);
        this.bnC = (LinearLayout) findViewById(r.g.face_tab_indicator_layout);
        this.bnC.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bnD.type = 1000;
            this.bnD.flags = 25165832;
        }
    }

    private void Y(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bnM.clear();
        this.bnN.clear();
        if (list != null && !list.isEmpty()) {
            this.bnM.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CU = cVar.CU();
                    int i4 = emotionsCount / (cols * CU);
                    if (emotionsCount % (cols * CU) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * CU;
                        } else {
                            i = emotionsCount - ((cols * CU) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.gx(i3);
                        tVar.b(cVar.CR());
                        tVar.eP(CU);
                        tVar.eO(cols);
                        tVar.gt(i4);
                        tVar.gu(i5);
                        tVar.gv(i);
                        tVar.gw(i5 * cols * CU);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bnN.add(tVar);
                    }
                }
            }
            this.bnO = this.bnN.size();
            for (int i6 = 0; i6 < this.bnO; i6++) {
                if (this.bnN != null && this.bnN.get(i6) != null) {
                    this.bnN.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void gq(int i) {
        if (this.bnN != null) {
            int size = this.bnN.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bnN.get(i2);
                    if (tVar != null && tVar.Sx() == i) {
                        this.bnR = tVar.getIndex();
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
                Y(list);
                gq(i);
                this.aid.setAdapter(new b());
                this.aid.setCurrentItem(this.bnR, true);
                if (this.bnQ != null) {
                    this.bnQ.gs(i);
                    this.bnP = i;
                }
            }
        }
    }

    public void gr(int i) {
        int i2;
        if (this.aid != null) {
            int size = this.bnN.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bnN.get(i3);
                    if (tVar == null || tVar.Sx() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.aid.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bnK != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Sn() != null) {
            String eF = aVar.Sn().Sq().eF(aVar.Sm() + i);
            this.bnE.setTag(eF);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axC = eF;
            this.bnE.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bnF.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bnD.x = this.rect.left - ((this.bnD.width - linearLayout.getWidth()) / 2);
            this.bnD.y = (this.rect.top - this.bnD.height) + this.bnI;
            this.bnE.setVisibility(0);
            if (!this.bnJ) {
                this.bC.addView(this.bnE, this.bnD);
                this.bnJ = true;
            } else {
                this.bC.updateViewLayout(this.bnE, this.bnD);
            }
            gridView.setSelection(i);
            if (this.bnK != -1) {
                ((LinearLayout) gridView.getChildAt(this.bnK - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bnK = i;
            this.bnB = gridView;
        }
    }

    private void Sk() {
        if (this.bnJ && this.bnE.getVisibility() != 8 && this.bnB != null) {
            this.bnB.setSelection(-1);
            this.bnE.setVisibility(8);
            if (this.bnK != -1) {
                ((LinearLayout) this.bnB.getChildAt(this.bnK - this.bnB.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bnK = -1;
            this.bnB = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bnS.set(x, y);
                break;
            case 1:
            case 3:
                Sk();
                break;
            case 2:
                this.bnS.set(x, y);
                if (this.bnJ && this.bnE.getVisibility() != 8 && this.bnB != null) {
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
                this.bnS.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Sk();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Sk();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bnB != null) {
                        offsetRectIntoDescendantCoords(this.bnB, this.rect);
                        int pointToPosition = this.bnB.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bnB);
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
        if (this.bnJ) {
            this.bC.removeView(this.bnE);
            this.bnJ = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bnN != null) {
            int size = this.bnN.size();
            if (i >= 0 && i < size) {
                this.bnL = this.bnN.get(i);
                if (this.aie != null && this.bnL != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aie.setVisibility(this.bnL.St() > 1 ? 0 : 4);
                        this.aie.setCount(this.bnL.St());
                        if (this.bnL != null && this.bnL.Sx() != this.bnP) {
                            this.bnP = this.bnL.Sx();
                            if (this.bnQ != null) {
                                this.bnQ.gs(this.bnL.Sx());
                            }
                        }
                    }
                    float Su = this.bnL.Su() + f;
                    this.aie.setPosition(Su);
                    this.bnC.setContentDescription(String.valueOf(String.format(getResources().getString(r.j.emotion_selection), Integer.valueOf(((int) Su) + 1))) + String.format(getResources().getString(r.j.emotion_page), Integer.valueOf(this.bnL.St())));
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
        this.aib = i;
        ar.d(this.bnE, r.f.bg_expression_bubble, i);
        ar.e(this, r.d.common_color_10255, i);
        this.aie.setSelector(ar.q(i, r.f.dot_pb_expression_s));
        this.aie.setDrawable(ar.q(i, r.f.dot_pb_expression_n));
        if (this.aid != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aid.getChildCount()) {
                    View childAt = this.aid.getChildAt(i3);
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
        Sk();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t bnV;

        public a(t tVar) {
            this.bnV = tVar;
        }

        public int Sm() {
            if (this.bnV == null) {
                return 0;
            }
            return this.bnV.Sw();
        }

        public t Sn() {
            return this.bnV;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bnV == null) {
                return 0;
            }
            return this.bnV.Sv();
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
                if (this.bnV.Ss() != 0) {
                    i2 = measuredWidth / this.bnV.Ss();
                }
                if (this.bnV.getRow() != 0) {
                    i3 = measuredHeight / this.bnV.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bnI * 2, EmotionTabContentView.this.bnI * 2, EmotionTabContentView.this.bnI * 2, EmotionTabContentView.this.bnI * 2);
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
            if (this.bnV != null) {
                int Sw = this.bnV.Sw() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(r.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ar.d(tbImageView, r.f.btn_choose_face_selector, EmotionTabContentView.this.aib);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eF = this.bnV.Sq().eF(Sw);
                tbImageView.setTag(eF);
                Object a = com.baidu.adp.lib.g.c.eA().a(eF, 20, new j(this), 0, 0, null, null, eF, false, null);
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
                if (this.bnV.Sr() == EmotionGroupType.BIG_EMOTION) {
                    String eF2 = this.bnV.Sq().eF(Sw);
                    if (!TextUtils.isEmpty(eF2)) {
                        if (EmotionTabContentView.this.aib == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(r.d.cp_cont_c);
                        } else {
                            color = ar.getColor(r.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eF2.substring(eF2.lastIndexOf("_") + 1, eF2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eF.length() > 3) {
                    linearLayout3.setContentDescription(eF.substring(2, eF.length() - 1));
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
            if (EmotionTabContentView.this.bnN == null) {
                return 0;
            }
            return EmotionTabContentView.this.bnN.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bnT.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bnT.ey();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bnN != null && i < EmotionTabContentView.this.bnN.size()) {
                t tVar = (t) EmotionTabContentView.this.bnN.get(i);
                gridView2.setNumColumns(tVar.Ss());
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
            if (EmotionTabContentView.this.bnN != null) {
                int size = EmotionTabContentView.this.bnN.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bnN.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aie.setVisibility(tVar.St() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aie.setCount(tVar.St());
                        EmotionTabContentView.this.aie.setPosition(tVar.Su());
                        EmotionTabContentView.this.aie.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(r.j.emotion_selection), Integer.valueOf(tVar.Su() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(r.j.emotion_page), Integer.valueOf(tVar.St())));
                    }
                    if (tVar != null && tVar.Sx() != EmotionTabContentView.this.bnP) {
                        EmotionTabContentView.this.bnP = tVar.Sx();
                        if (EmotionTabContentView.this.bnQ != null) {
                            EmotionTabContentView.this.bnQ.gs(tVar.Sx());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bnQ = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.EM = jVar;
    }
}
