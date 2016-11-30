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
import com.baidu.tieba.r;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.l EL;
    private int aiA;
    private ViewPager aiC;
    private IndicatorView aiD;
    private WindowManager bC;
    private WindowManager.LayoutParams bHA;
    private GifView bHB;
    private ViewGroup bHC;
    private int bHD;
    private int bHE;
    private int bHF;
    private boolean bHG;
    private int bHH;
    private t bHI;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bHJ;
    private List<t> bHK;
    private int bHL;
    private int bHM;
    private c bHN;
    private int bHO;
    private final Point bHP;
    private com.baidu.adp.lib.f.b<GridView> bHQ;
    private GridView bHy;
    private LinearLayout bHz;
    private int currentPosition;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hi(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bHH = -1;
        this.bHL = 0;
        this.bHM = -1;
        this.currentPosition = -1;
        this.bHP = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bHH = -1;
        this.bHL = 0;
        this.bHM = -1;
        this.currentPosition = -1;
        this.bHP = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bHJ = new ArrayList();
        this.bHK = new ArrayList();
        this.bHQ = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.h.emotion_tab_content, (ViewGroup) this, true);
        this.aiC = (ViewPager) findViewById(r.g.face_tab_viewpager);
        this.aiC.setFadingEdgeLength(0);
        this.aiC.setOnPageChangeListener(this);
        this.bHB = new GifView(context);
        at.d(this.bHB, r.f.bg_expression_bubble, this.aiA);
        this.bHB.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bHA = new WindowManager.LayoutParams();
        this.bHD = context.getResources().getDimensionPixelSize(r.e.ds240);
        this.bHE = context.getResources().getDimensionPixelSize(r.e.ds252);
        this.bHF = context.getResources().getDimensionPixelSize(r.e.ds10);
        this.bHA.width = this.bHD;
        this.bHA.height = this.bHE;
        this.bHA.gravity = 51;
        this.bHA.format = -3;
        this.bHA.type = 1000;
        this.bHA.flags |= 56;
        this.bHC = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aiD = (IndicatorView) findViewById(r.g.face_tab_indicator);
        this.bHz = (LinearLayout) findViewById(r.g.face_tab_indicator_layout);
        this.bHz.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bHA.type = 1000;
            this.bHA.flags = 25165832;
        }
    }

    private void ag(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bHJ.clear();
        this.bHK.clear();
        if (list != null && !list.isEmpty()) {
            this.bHJ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dl = cVar.Dl();
                    int i4 = emotionsCount / (cols * Dl);
                    if (emotionsCount % (cols * Dl) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * Dl;
                        } else {
                            i = emotionsCount - ((cols * Dl) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.hn(i3);
                        tVar.b(cVar.Di());
                        tVar.eO(Dl);
                        tVar.eN(cols);
                        tVar.hj(i4);
                        tVar.hk(i5);
                        tVar.hl(i);
                        tVar.hm(i5 * cols * Dl);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bHK.add(tVar);
                    }
                }
            }
            this.bHL = this.bHK.size();
            for (int i6 = 0; i6 < this.bHL; i6++) {
                if (this.bHK != null && this.bHK.get(i6) != null) {
                    this.bHK.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hg(int i) {
        if (this.bHK != null) {
            int size = this.bHK.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bHK.get(i2);
                    if (tVar != null && tVar.Ym() == i) {
                        this.bHO = tVar.getIndex();
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
                ag(list);
                hg(i);
                this.aiC.setAdapter(new b());
                this.aiC.setCurrentItem(this.bHO, true);
                if (this.bHN != null) {
                    this.bHN.hi(i);
                    this.bHM = i;
                }
            }
        }
    }

    public void hh(int i) {
        int i2;
        if (this.aiC != null) {
            int size = this.bHK.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bHK.get(i3);
                    if (tVar == null || tVar.Ym() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.aiC.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bHH != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Yc() != null) {
            String eE = aVar.Yc().Yf().eE(aVar.Yb() + i);
            this.bHB.setTag(eE);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.ayf = eE;
            this.bHB.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bHC.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bHA.x = this.rect.left - ((this.bHA.width - linearLayout.getWidth()) / 2);
            this.bHA.y = (this.rect.top - this.bHA.height) + this.bHF;
            this.bHB.setVisibility(0);
            if (!this.bHG) {
                this.bC.addView(this.bHB, this.bHA);
                this.bHG = true;
            } else {
                this.bC.updateViewLayout(this.bHB, this.bHA);
            }
            gridView.setSelection(i);
            if (this.bHH != -1) {
                ((LinearLayout) gridView.getChildAt(this.bHH - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bHH = i;
            this.bHy = gridView;
        }
    }

    private void XZ() {
        if (this.bHG && this.bHB.getVisibility() != 8 && this.bHy != null) {
            this.bHy.setSelection(-1);
            this.bHB.setVisibility(8);
            if (this.bHH != -1) {
                ((LinearLayout) this.bHy.getChildAt(this.bHH - this.bHy.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bHH = -1;
            this.bHy = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bHP.set(x, y);
                break;
            case 1:
            case 3:
                XZ();
                break;
            case 2:
                this.bHP.set(x, y);
                if (this.bHG && this.bHB.getVisibility() != 8 && this.bHy != null) {
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
                this.bHP.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                XZ();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    XZ();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bHy != null) {
                        offsetRectIntoDescendantCoords(this.bHy, this.rect);
                        int pointToPosition = this.bHy.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bHy);
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
        if (this.bHG) {
            this.bC.removeView(this.bHB);
            this.bHG = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bHK != null) {
            int size = this.bHK.size();
            if (i >= 0 && i < size) {
                this.bHI = this.bHK.get(i);
                if (this.aiD != null && this.bHI != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aiD.setVisibility(this.bHI.Yi() > 1 ? 0 : 4);
                        this.aiD.setCount(this.bHI.Yi());
                        if (this.bHI != null && this.bHI.Ym() != this.bHM) {
                            this.bHM = this.bHI.Ym();
                            if (this.bHN != null) {
                                this.bHN.hi(this.bHI.Ym());
                            }
                        }
                    }
                    float Yj = this.bHI.Yj() + f;
                    this.aiD.setPosition(Yj);
                    this.bHz.setContentDescription(String.valueOf(String.format(getResources().getString(r.j.emotion_selection), Integer.valueOf(((int) Yj) + 1))) + String.format(getResources().getString(r.j.emotion_page), Integer.valueOf(this.bHI.Yi())));
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
        this.aiA = i;
        at.d(this.bHB, r.f.bg_expression_bubble, i);
        at.e(this, r.d.common_color_10255, i);
        this.aiD.setSelector(at.q(i, r.f.dot_pb_expression_s));
        this.aiD.setDrawable(at.q(i, r.f.dot_pb_expression_n));
        if (this.aiC != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aiC.getChildCount()) {
                    View childAt = this.aiC.getChildAt(i3);
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
        XZ();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t bHS;

        public a(t tVar) {
            this.bHS = tVar;
        }

        public int Yb() {
            if (this.bHS == null) {
                return 0;
            }
            return this.bHS.Yl();
        }

        public t Yc() {
            return this.bHS;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bHS == null) {
                return 0;
            }
            return this.bHS.Yk();
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
                if (this.bHS.Yh() != 0) {
                    i2 = measuredWidth / this.bHS.Yh();
                }
                if (this.bHS.getRow() != 0) {
                    i3 = measuredHeight / this.bHS.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bHF * 2, EmotionTabContentView.this.bHF * 2, EmotionTabContentView.this.bHF * 2, EmotionTabContentView.this.bHF * 2);
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
            if (this.bHS != null) {
                int Yl = this.bHS.Yl() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(r.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                at.d(tbImageView, r.f.btn_choose_face_selector, EmotionTabContentView.this.aiA);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eE = this.bHS.Yf().eE(Yl);
                tbImageView.setTag(eE);
                Object a = com.baidu.adp.lib.g.c.eA().a(eE, 20, new j(this), 0, 0, null, null, eE, false, null);
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
                if (this.bHS.Yg() == EmotionGroupType.BIG_EMOTION) {
                    String eE2 = this.bHS.Yf().eE(Yl);
                    if (!TextUtils.isEmpty(eE2)) {
                        if (EmotionTabContentView.this.aiA == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(r.d.cp_cont_c);
                        } else {
                            color = at.getColor(r.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eE2.substring(eE2.lastIndexOf("_") + 1, eE2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eE.length() > 3) {
                    linearLayout3.setContentDescription(eE.substring(2, eE.length() - 1));
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
            if (EmotionTabContentView.this.bHK == null) {
                return 0;
            }
            return EmotionTabContentView.this.bHK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bHQ.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bHQ.ey();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bHK != null && i < EmotionTabContentView.this.bHK.size()) {
                t tVar = (t) EmotionTabContentView.this.bHK.get(i);
                gridView2.setNumColumns(tVar.Yh());
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
            if (EmotionTabContentView.this.bHK != null) {
                int size = EmotionTabContentView.this.bHK.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bHK.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aiD.setVisibility(tVar.Yi() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aiD.setCount(tVar.Yi());
                        EmotionTabContentView.this.aiD.setPosition(tVar.Yj());
                        EmotionTabContentView.this.aiD.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(r.j.emotion_selection), Integer.valueOf(tVar.Yj() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(r.j.emotion_page), Integer.valueOf(tVar.Yi())));
                    }
                    if (tVar != null && tVar.Ym() != EmotionTabContentView.this.bHM) {
                        EmotionTabContentView.this.bHM = tVar.Ym();
                        if (EmotionTabContentView.this.bHN != null) {
                            EmotionTabContentView.this.bHN.hi(tVar.Ym());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bHN = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
    }
}
