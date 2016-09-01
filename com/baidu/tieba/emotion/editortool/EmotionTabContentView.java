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
import com.baidu.tieba.t;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.l EJ;
    private int ait;
    private ViewPager awS;
    private IndicatorView awT;
    private WindowManager bC;
    private int bEA;
    private boolean bEB;
    private int bEC;
    private t bED;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bEE;
    private List<t> bEF;
    private int bEG;
    private int bEH;
    private c bEI;
    private int bEJ;
    private final Point bEK;
    private com.baidu.adp.lib.f.b<GridView> bEL;
    private GridView bEt;
    private LinearLayout bEu;
    private WindowManager.LayoutParams bEv;
    private GifView bEw;
    private ViewGroup bEx;
    private int bEy;
    private int bEz;
    private int currentPosition;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hd(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bEC = -1;
        this.bEG = 0;
        this.bEH = -1;
        this.currentPosition = -1;
        this.bEK = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bEC = -1;
        this.bEG = 0;
        this.bEH = -1;
        this.currentPosition = -1;
        this.bEK = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bEE = new ArrayList();
        this.bEF = new ArrayList();
        this.bEL = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.emotion_tab_content, (ViewGroup) this, true);
        this.awS = (ViewPager) findViewById(t.g.face_tab_viewpager);
        this.awS.setFadingEdgeLength(0);
        this.awS.setOnPageChangeListener(this);
        this.bEw = new GifView(context);
        av.d(this.bEw, t.f.bg_expression_bubble, this.ait);
        this.bEw.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bEv = new WindowManager.LayoutParams();
        this.bEy = context.getResources().getDimensionPixelSize(t.e.ds240);
        this.bEz = context.getResources().getDimensionPixelSize(t.e.ds252);
        this.bEA = context.getResources().getDimensionPixelSize(t.e.ds10);
        this.bEv.width = this.bEy;
        this.bEv.height = this.bEz;
        this.bEv.gravity = 51;
        this.bEv.format = -3;
        this.bEv.type = 1000;
        this.bEv.flags |= 56;
        this.bEx = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.awT = (IndicatorView) findViewById(t.g.face_tab_indicator);
        this.bEu = (LinearLayout) findViewById(t.g.face_tab_indicator_layout);
        this.bEu.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bEv.type = 1000;
            this.bEv.flags = 25165832;
        }
    }

    private void af(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bEE.clear();
        this.bEF.clear();
        if (list != null && !list.isEmpty()) {
            this.bEE.addAll(list);
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
                        tVar.hi(i3);
                        tVar.b(cVar.Da());
                        tVar.eM(Dd);
                        tVar.eL(cols);
                        tVar.he(i4);
                        tVar.hf(i5);
                        tVar.hg(i);
                        tVar.hh(i5 * cols * Dd);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bEF.add(tVar);
                    }
                }
            }
            this.bEG = this.bEF.size();
            for (int i6 = 0; i6 < this.bEG; i6++) {
                if (this.bEF != null && this.bEF.get(i6) != null) {
                    this.bEF.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hb(int i) {
        if (this.bEF != null) {
            int size = this.bEF.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bEF.get(i2);
                    if (tVar != null && tVar.WR() == i) {
                        this.bEJ = tVar.getIndex();
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
                hb(i);
                this.awS.setAdapter(new b());
                this.awS.setCurrentItem(this.bEJ, true);
                if (this.bEI != null) {
                    this.bEI.hd(i);
                    this.bEH = i;
                }
            }
        }
    }

    public void hc(int i) {
        int i2;
        if (this.awS != null) {
            int size = this.bEF.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bEF.get(i3);
                    if (tVar == null || tVar.WR() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.awS.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bEC != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.WH() != null) {
            String eC = aVar.WH().WK().eC(aVar.WG() + i);
            this.bEw.setTag(eC);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axL = eC;
            this.bEw.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bEx.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bEv.x = this.rect.left - ((this.bEv.width - linearLayout.getWidth()) / 2);
            this.bEv.y = (this.rect.top - this.bEv.height) + this.bEA;
            this.bEw.setVisibility(0);
            if (!this.bEB) {
                this.bC.addView(this.bEw, this.bEv);
                this.bEB = true;
            } else {
                this.bC.updateViewLayout(this.bEw, this.bEv);
            }
            gridView.setSelection(i);
            if (this.bEC != -1) {
                ((LinearLayout) gridView.getChildAt(this.bEC - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bEC = i;
            this.bEt = gridView;
        }
    }

    private void WE() {
        if (this.bEB && this.bEw.getVisibility() != 8 && this.bEt != null) {
            this.bEt.setSelection(-1);
            this.bEw.setVisibility(8);
            if (this.bEC != -1) {
                ((LinearLayout) this.bEt.getChildAt(this.bEC - this.bEt.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bEC = -1;
            this.bEt = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bEK.set(x, y);
                break;
            case 1:
            case 3:
                WE();
                break;
            case 2:
                this.bEK.set(x, y);
                if (this.bEB && this.bEw.getVisibility() != 8 && this.bEt != null) {
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
                this.bEK.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                WE();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    WE();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bEt != null) {
                        offsetRectIntoDescendantCoords(this.bEt, this.rect);
                        int pointToPosition = this.bEt.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bEt);
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
        if (this.bEB) {
            this.bC.removeView(this.bEw);
            this.bEB = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bEF != null) {
            int size = this.bEF.size();
            if (i >= 0 && i < size) {
                this.bED = this.bEF.get(i);
                if (this.awT != null && this.bED != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.awT.setVisibility(this.bED.WN() > 1 ? 0 : 4);
                        this.awT.setCount(this.bED.WN());
                        if (this.bED != null && this.bED.WR() != this.bEH) {
                            this.bEH = this.bED.WR();
                            if (this.bEI != null) {
                                this.bEI.hd(this.bED.WR());
                            }
                        }
                    }
                    float WO = this.bED.WO() + f;
                    this.awT.setPosition(WO);
                    this.bEu.setContentDescription(String.valueOf(String.format(getResources().getString(t.j.emotion_selection), Integer.valueOf(((int) WO) + 1))) + String.format(getResources().getString(t.j.emotion_page), Integer.valueOf(this.bED.WN())));
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
        this.ait = i;
        av.d(this.bEw, t.f.bg_expression_bubble, i);
        av.e(this, t.d.common_color_10255, i);
        this.awT.setSelector(av.q(i, t.f.dot_pb_expression_s));
        this.awT.setDrawable(av.q(i, t.f.dot_pb_expression_n));
        if (this.awS != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.awS.getChildCount()) {
                    View childAt = this.awS.getChildAt(i3);
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
        WE();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t bEN;

        public a(t tVar) {
            this.bEN = tVar;
        }

        public int WG() {
            if (this.bEN == null) {
                return 0;
            }
            return this.bEN.WQ();
        }

        public t WH() {
            return this.bEN;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bEN == null) {
                return 0;
            }
            return this.bEN.WP();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(t.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.bEN.WM() != 0) {
                    i2 = measuredWidth / this.bEN.WM();
                }
                if (this.bEN.getRow() != 0) {
                    i3 = measuredHeight / this.bEN.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bEA * 2, EmotionTabContentView.this.bEA * 2, EmotionTabContentView.this.bEA * 2, EmotionTabContentView.this.bEA * 2);
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
            if (this.bEN != null) {
                int WQ = this.bEN.WQ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(t.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                av.d(tbImageView, t.f.btn_choose_face_selector, EmotionTabContentView.this.ait);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eC = this.bEN.WK().eC(WQ);
                tbImageView.setTag(eC);
                Object a = com.baidu.adp.lib.g.c.eA().a(eC, 20, new j(this), 0, 0, null, null, eC, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.e(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(t.g.emotion_tab_content_tip);
                if (this.bEN.WL() == EmotionGroupType.BIG_EMOTION) {
                    String eC2 = this.bEN.WK().eC(WQ);
                    if (!TextUtils.isEmpty(eC2)) {
                        if (EmotionTabContentView.this.ait == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(t.d.cp_cont_c);
                        } else {
                            color = av.getColor(t.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eC2.substring(eC2.lastIndexOf("_") + 1, eC2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eC.length() > 3) {
                    linearLayout3.setContentDescription(eC.substring(2, eC.length() - 1));
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
            if (EmotionTabContentView.this.bEF == null) {
                return 0;
            }
            return EmotionTabContentView.this.bEF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bEL.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bEL.ey();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bEF != null && i < EmotionTabContentView.this.bEF.size()) {
                t tVar = (t) EmotionTabContentView.this.bEF.get(i);
                gridView2.setNumColumns(tVar.WM());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(t.d.common_color_10022);
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
            if (EmotionTabContentView.this.bEF != null) {
                int size = EmotionTabContentView.this.bEF.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bEF.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.awT.setVisibility(tVar.WN() > 1 ? 0 : 4);
                        EmotionTabContentView.this.awT.setCount(tVar.WN());
                        EmotionTabContentView.this.awT.setPosition(tVar.WO());
                        EmotionTabContentView.this.awT.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(t.j.emotion_selection), Integer.valueOf(tVar.WO() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(t.j.emotion_page), Integer.valueOf(tVar.WN())));
                    }
                    if (tVar != null && tVar.WR() != EmotionTabContentView.this.bEH) {
                        EmotionTabContentView.this.bEH = tVar.WR();
                        if (EmotionTabContentView.this.bEI != null) {
                            EmotionTabContentView.this.bEI.hd(tVar.WR());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bEI = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
    }
}
