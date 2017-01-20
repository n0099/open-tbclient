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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.j DX;
    private int ahp;
    private IndicatorView ahr;
    private WindowManager bC;
    private List<t> bvA;
    private int bvB;
    private int bvC;
    private c bvD;
    private int bvE;
    private final Point bvF;
    private com.baidu.adp.lib.e.b<GridView> bvG;
    private GridView bvo;
    private LinearLayout bvp;
    private WindowManager.LayoutParams bvq;
    private GifView bvr;
    private ViewGroup bvs;
    private int bvt;
    private int bvu;
    private int bvv;
    private boolean bvw;
    private int bvx;
    private t bvy;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bvz;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void he(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bvx = -1;
        this.bvB = 0;
        this.bvC = -1;
        this.currentPosition = -1;
        this.bvF = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bvx = -1;
        this.bvB = 0;
        this.bvC = -1;
        this.currentPosition = -1;
        this.bvF = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bvz = new ArrayList();
        this.bvA = new ArrayList();
        this.bvG = new com.baidu.adp.lib.e.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(r.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bvr = new GifView(context);
        ap.d(this.bvr, r.g.bg_expression_bubble, this.ahp);
        this.bvr.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bvq = new WindowManager.LayoutParams();
        this.bvt = context.getResources().getDimensionPixelSize(r.f.ds240);
        this.bvu = context.getResources().getDimensionPixelSize(r.f.ds252);
        this.bvv = context.getResources().getDimensionPixelSize(r.f.ds10);
        this.bvq.width = this.bvt;
        this.bvq.height = this.bvu;
        this.bvq.gravity = 51;
        this.bvq.format = -3;
        this.bvq.type = 1000;
        this.bvq.flags |= 56;
        this.bvs = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ahr = (IndicatorView) findViewById(r.h.face_tab_indicator);
        this.bvp = (LinearLayout) findViewById(r.h.face_tab_indicator_layout);
        this.bvp.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bvq.type = 1000;
            this.bvq.flags = 25165832;
        }
    }

    private void ac(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bvz.clear();
        this.bvA.clear();
        if (list != null && !list.isEmpty()) {
            this.bvz.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CP = cVar.CP();
                    int i4 = emotionsCount / (cols * CP);
                    if (emotionsCount % (cols * CP) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * CP;
                        } else {
                            i = emotionsCount - ((cols * CP) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.hj(i3);
                        tVar.b(cVar.CM());
                        tVar.eQ(CP);
                        tVar.eP(cols);
                        tVar.hf(i4);
                        tVar.hg(i5);
                        tVar.hh(i);
                        tVar.hi(i5 * cols * CP);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bvA.add(tVar);
                    }
                }
            }
            this.bvB = this.bvA.size();
            for (int i6 = 0; i6 < this.bvB; i6++) {
                if (this.bvA != null && this.bvA.get(i6) != null) {
                    this.bvA.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hc(int i) {
        if (this.bvA != null) {
            int size = this.bvA.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bvA.get(i2);
                    if (tVar != null && tVar.TT() == i) {
                        this.bvE = tVar.getIndex();
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
                ac(list);
                hc(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.bvE, true);
                if (this.bvD != null) {
                    this.bvD.he(i);
                    this.bvC = i;
                }
            }
        }
    }

    public void hd(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bvA.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bvA.get(i3);
                    if (tVar == null || tVar.TT() != i) {
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
        if (this.bvx != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.TJ() != null) {
            String eG = aVar.TJ().TM().eG(aVar.TI() + i);
            this.bvr.setTag(eG);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = eG;
            this.bvr.a(gifInfo);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bvs.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bvq.x = this.rect.left - ((this.bvq.width - linearLayout.getWidth()) / 2);
            this.bvq.y = (this.rect.top - this.bvq.height) + this.bvv;
            this.bvr.setVisibility(0);
            if (!this.bvw) {
                this.bC.addView(this.bvr, this.bvq);
                this.bvw = true;
            } else {
                this.bC.updateViewLayout(this.bvr, this.bvq);
            }
            gridView.setSelection(i);
            if (this.bvx != -1) {
                ((LinearLayout) gridView.getChildAt(this.bvx - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bvx = i;
            this.bvo = gridView;
        }
    }

    private void TG() {
        if (this.bvw && this.bvr.getVisibility() != 8 && this.bvo != null) {
            this.bvo.setSelection(-1);
            this.bvr.setVisibility(8);
            if (this.bvx != -1) {
                ((LinearLayout) this.bvo.getChildAt(this.bvx - this.bvo.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bvx = -1;
            this.bvo = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bvF.set(x, y);
                break;
            case 1:
            case 3:
                TG();
                break;
            case 2:
                this.bvF.set(x, y);
                if (this.bvw && this.bvr.getVisibility() != 8 && this.bvo != null) {
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
                this.bvF.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                TG();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    TG();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bvo != null) {
                        offsetRectIntoDescendantCoords(this.bvo, this.rect);
                        int pointToPosition = this.bvo.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bvo);
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
        if (this.bvw) {
            this.bC.removeView(this.bvr);
            this.bvw = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bvA != null) {
            int size = this.bvA.size();
            if (i >= 0 && i < size) {
                this.bvy = this.bvA.get(i);
                if (this.ahr != null && this.bvy != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ahr.setVisibility(this.bvy.TP() > 1 ? 0 : 4);
                        this.ahr.setCount(this.bvy.TP());
                        if (this.bvy != null && this.bvy.TT() != this.bvC) {
                            this.bvC = this.bvy.TT();
                            if (this.bvD != null) {
                                this.bvD.he(this.bvy.TT());
                            }
                        }
                    }
                    float TQ = this.bvy.TQ() + f;
                    this.ahr.setPosition(TQ);
                    this.bvp.setContentDescription(String.valueOf(String.format(getResources().getString(r.l.emotion_selection), Integer.valueOf(((int) TQ) + 1))) + String.format(getResources().getString(r.l.emotion_page), Integer.valueOf(this.bvy.TP())));
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
        this.ahp = i;
        ap.d(this.bvr, r.g.bg_expression_bubble, i);
        ap.e(this, r.e.common_color_10255, i);
        this.ahr.setSelector(ap.r(i, r.g.dot_pb_expression_s));
        this.ahr.setDrawable(ap.r(i, r.g.dot_pb_expression_n));
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
        TG();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t bvI;

        public a(t tVar) {
            this.bvI = tVar;
        }

        public int TI() {
            if (this.bvI == null) {
                return 0;
            }
            return this.bvI.TS();
        }

        public t TJ() {
            return this.bvI;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bvI == null) {
                return 0;
            }
            return this.bvI.TR();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(r.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.bvI.TO() != 0) {
                    i2 = measuredWidth / this.bvI.TO();
                }
                if (this.bvI.getRow() != 0) {
                    i3 = measuredHeight / this.bvI.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bvv * 2, EmotionTabContentView.this.bvv * 2, EmotionTabContentView.this.bvv * 2, EmotionTabContentView.this.bvv * 2);
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
            if (this.bvI != null) {
                int TS = this.bvI.TS() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(r.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.d(tbImageView, r.g.btn_choose_face_selector, EmotionTabContentView.this.ahp);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eG = this.bvI.TM().eG(TS);
                tbImageView.setTag(eG);
                Object a = com.baidu.adp.lib.f.c.ey().a(eG, 20, new j(this), 0, 0, null, null, eG, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.e(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(r.h.emotion_tab_content_tip);
                if (this.bvI.TN() == EmotionGroupType.BIG_EMOTION) {
                    String eG2 = this.bvI.TM().eG(TS);
                    if (!TextUtils.isEmpty(eG2)) {
                        if (EmotionTabContentView.this.ahp == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(r.e.cp_cont_c);
                        } else {
                            color = ap.getColor(r.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eG2.substring(eG2.lastIndexOf("_") + 1, eG2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eG.length() > 3) {
                    linearLayout3.setContentDescription(eG.substring(2, eG.length() - 1));
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
            if (EmotionTabContentView.this.bvA == null) {
                return 0;
            }
            return EmotionTabContentView.this.bvA.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bvG.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bvG.ew();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bvA != null && i < EmotionTabContentView.this.bvA.size()) {
                t tVar = (t) EmotionTabContentView.this.bvA.get(i);
                gridView2.setNumColumns(tVar.TO());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(r.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(r.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(r.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.bvA != null) {
                int size = EmotionTabContentView.this.bvA.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bvA.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ahr.setVisibility(tVar.TP() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ahr.setCount(tVar.TP());
                        EmotionTabContentView.this.ahr.setPosition(tVar.TQ());
                        EmotionTabContentView.this.ahr.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(r.l.emotion_selection), Integer.valueOf(tVar.TQ() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(r.l.emotion_page), Integer.valueOf(tVar.TP())));
                    }
                    if (tVar != null && tVar.TT() != EmotionTabContentView.this.bvC) {
                        EmotionTabContentView.this.bvC = tVar.TT();
                        if (EmotionTabContentView.this.bvD != null) {
                            EmotionTabContentView.this.bvD.he(tVar.TT());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bvD = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.DX = jVar;
    }
}
