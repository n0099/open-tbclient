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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.j JU;
    private IndicatorView aBn;
    private int ana;
    private GridView bKA;
    private LinearLayout bKB;
    private WindowManager.LayoutParams bKC;
    private GifView bKD;
    private ViewGroup bKE;
    private int bKF;
    private int bKG;
    private int bKH;
    private boolean bKI;
    private int bKJ;
    private u bKK;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bKL;
    private List<u> bKM;
    private int bKN;
    private int bKO;
    private c bKP;
    private int bKQ;
    private final Point bKR;
    private com.baidu.adp.lib.e.b<GridView> bKS;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hE(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bKJ = -1;
        this.bKN = 0;
        this.bKO = -1;
        this.currentPosition = -1;
        this.bKR = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bKJ = -1;
        this.bKN = 0;
        this.bKO = -1;
        this.currentPosition = -1;
        this.bKR = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bKL = new ArrayList();
        this.bKM = new ArrayList();
        this.bKS = new com.baidu.adp.lib.e.b<>(new j(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(w.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(w.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bKD = new GifView(context);
        aq.d(this.bKD, w.g.bg_expression_bubble, this.ana);
        this.bKD.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bKC = new WindowManager.LayoutParams();
        this.bKF = context.getResources().getDimensionPixelSize(w.f.ds240);
        this.bKG = context.getResources().getDimensionPixelSize(w.f.ds252);
        this.bKH = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.bKC.width = this.bKF;
        this.bKC.height = this.bKG;
        this.bKC.gravity = 51;
        this.bKC.format = -3;
        this.bKC.type = 1000;
        this.bKC.flags |= 56;
        this.bKE = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aBn = (IndicatorView) findViewById(w.h.face_tab_indicator);
        this.bKB = (LinearLayout) findViewById(w.h.face_tab_indicator_layout);
        this.bKB.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bKC.type = 1000;
            this.bKC.flags = 25165832;
        }
    }

    private void ac(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bKL.clear();
        this.bKM.clear();
        if (list != null && !list.isEmpty()) {
            this.bKL.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CD = cVar.CD();
                    int i4 = emotionsCount / (cols * CD);
                    if (emotionsCount % (cols * CD) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        u uVar = new u();
                        if (i5 < i4 - 1) {
                            i = cols * CD;
                        } else {
                            i = emotionsCount - ((cols * CD) * (i4 - 1));
                        }
                        uVar.e(cVar);
                        uVar.hJ(i3);
                        uVar.b(cVar.CA());
                        uVar.eL(CD);
                        uVar.eK(cols);
                        uVar.hF(i4);
                        uVar.hG(i5);
                        uVar.hH(i);
                        uVar.hI(i5 * cols * CD);
                        uVar.setEndIndex((i + i2) - 1);
                        this.bKM.add(uVar);
                    }
                }
            }
            this.bKN = this.bKM.size();
            for (int i6 = 0; i6 < this.bKN; i6++) {
                if (this.bKM != null && this.bKM.get(i6) != null) {
                    this.bKM.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hC(int i) {
        if (this.bKM != null) {
            int size = this.bKM.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    u uVar = this.bKM.get(i2);
                    if (uVar != null && uVar.WO() == i) {
                        this.bKQ = uVar.getIndex();
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
                ac(list);
                hC(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.bKQ, true);
                if (this.bKP != null) {
                    this.bKP.hE(i);
                    this.bKO = i;
                }
            }
        }
    }

    public void hD(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bKM.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    u uVar = this.bKM.get(i3);
                    if (uVar == null || uVar.WO() != i) {
                        i3++;
                    } else {
                        i2 = uVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bKJ != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.WE() != null) {
            String eB = aVar.WE().WH().eB(aVar.WD() + i);
            this.bKD.setTag(eB);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = eB;
            this.bKD.a(gifInfo);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bKE.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bKC.x = this.rect.left - ((this.bKC.width - linearLayout.getWidth()) / 2);
            this.bKC.y = (this.rect.top - this.bKC.height) + this.bKH;
            this.bKD.setVisibility(0);
            if (!this.bKI) {
                this.jn.addView(this.bKD, this.bKC);
                this.bKI = true;
            } else {
                this.jn.updateViewLayout(this.bKD, this.bKC);
            }
            gridView.setSelection(i);
            if (this.bKJ != -1) {
                ((LinearLayout) gridView.getChildAt(this.bKJ - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bKJ = i;
            this.bKA = gridView;
        }
    }

    private void WB() {
        if (this.bKI && this.bKD.getVisibility() != 8 && this.bKA != null) {
            this.bKA.setSelection(-1);
            this.bKD.setVisibility(8);
            if (this.bKJ != -1) {
                ((LinearLayout) this.bKA.getChildAt(this.bKJ - this.bKA.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bKJ = -1;
            this.bKA = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bKR.set(x, y);
                break;
            case 1:
            case 3:
                WB();
                break;
            case 2:
                this.bKR.set(x, y);
                if (this.bKI && this.bKD.getVisibility() != 8 && this.bKA != null) {
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
                this.bKR.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                WB();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    WB();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bKA != null) {
                        offsetRectIntoDescendantCoords(this.bKA, this.rect);
                        int pointToPosition = this.bKA.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bKA);
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
        if (this.bKI) {
            this.jn.removeView(this.bKD);
            this.bKI = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bKM != null) {
            int size = this.bKM.size();
            if (i >= 0 && i < size) {
                this.bKK = this.bKM.get(i);
                if (this.aBn != null && this.bKK != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aBn.setVisibility(this.bKK.WK() > 1 ? 0 : 4);
                        this.aBn.setCount(this.bKK.WK());
                        if (this.bKK != null && this.bKK.WO() != this.bKO) {
                            this.bKO = this.bKK.WO();
                            if (this.bKP != null) {
                                this.bKP.hE(this.bKK.WO());
                            }
                        }
                    }
                    float WL = this.bKK.WL() + f;
                    this.aBn.setPosition(WL);
                    this.bKB.setContentDescription(String.valueOf(String.format(getResources().getString(w.l.emotion_selection), Integer.valueOf(((int) WL) + 1))) + String.format(getResources().getString(w.l.emotion_page), Integer.valueOf(this.bKK.WK())));
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
        this.ana = i;
        aq.d(this.bKD, w.g.bg_expression_bubble, i);
        aq.e(this, w.e.common_color_10255, i);
        this.aBn.setSelector(aq.u(i, w.g.dot_pb_expression_s));
        this.aBn.setDrawable(aq.u(i, w.g.dot_pb_expression_n));
        if (this.mViewPager != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mViewPager.getChildCount()) {
                    View childAt = this.mViewPager.getChildAt(i3);
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
        WB();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final u bKU;

        public a(u uVar) {
            this.bKU = uVar;
        }

        public int WD() {
            if (this.bKU == null) {
                return 0;
            }
            return this.bKU.WN();
        }

        public u WE() {
            return this.bKU;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bKU == null) {
                return 0;
            }
            return this.bKU.WM();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.bKU.WJ() != 0) {
                    i2 = measuredWidth / this.bKU.WJ();
                }
                if (this.bKU.getRow() != 0) {
                    i3 = measuredHeight / this.bKU.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bKH * 2, EmotionTabContentView.this.bKH * 2, EmotionTabContentView.this.bKH * 2, EmotionTabContentView.this.bKH * 2);
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
            if (this.bKU != null) {
                int WN = this.bKU.WN() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(w.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aq.d(tbImageView, w.g.btn_choose_face_selector, EmotionTabContentView.this.ana);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eB = this.bKU.WH().eB(WN);
                tbImageView.setTag(eB);
                Object a = com.baidu.adp.lib.f.c.fM().a(eB, 20, new k(this), 0, 0, null, null, eB, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.e(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(w.h.emotion_tab_content_tip);
                if (this.bKU.WI() == EmotionGroupType.BIG_EMOTION) {
                    String eB2 = this.bKU.WH().eB(WN);
                    if (!TextUtils.isEmpty(eB2)) {
                        if (EmotionTabContentView.this.ana == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(w.e.cp_cont_c);
                        } else {
                            color = aq.getColor(w.e.cp_cont_c);
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
            if (EmotionTabContentView.this.bKM == null) {
                return 0;
            }
            return EmotionTabContentView.this.bKM.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bKS.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bKS.fK();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bKM != null && i < EmotionTabContentView.this.bKM.size()) {
                u uVar = (u) EmotionTabContentView.this.bKM.get(i);
                gridView2.setNumColumns(uVar.WJ());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(w.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(w.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(w.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new l(this));
                gridView2.setOnItemClickListener(new m(this));
                gridView2.setAdapter((ListAdapter) new a(uVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.bKM != null) {
                int size = EmotionTabContentView.this.bKM.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    u uVar = (u) EmotionTabContentView.this.bKM.get(i);
                    if (uVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aBn.setVisibility(uVar.WK() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aBn.setCount(uVar.WK());
                        EmotionTabContentView.this.aBn.setPosition(uVar.WL());
                        EmotionTabContentView.this.aBn.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_selection), Integer.valueOf(uVar.WL() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_page), Integer.valueOf(uVar.WK())));
                    }
                    if (uVar != null && uVar.WO() != EmotionTabContentView.this.bKO) {
                        EmotionTabContentView.this.bKO = uVar.WO();
                        if (EmotionTabContentView.this.bKP != null) {
                            EmotionTabContentView.this.bKP.hE(uVar.WO());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bKP = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
    }
}
