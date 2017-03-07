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
    private com.baidu.tbadk.editortools.j Ll;
    private int amL;
    private IndicatorView amN;
    private int bCA;
    private int bCB;
    private boolean bCC;
    private int bCD;
    private t bCE;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bCF;
    private List<t> bCG;
    private int bCH;
    private int bCI;
    private c bCJ;
    private int bCK;
    private final Point bCL;
    private com.baidu.adp.lib.e.b<GridView> bCM;
    private GridView bCu;
    private LinearLayout bCv;
    private WindowManager.LayoutParams bCw;
    private GifView bCx;
    private ViewGroup bCy;
    private int bCz;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void ha(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bCD = -1;
        this.bCH = 0;
        this.bCI = -1;
        this.currentPosition = -1;
        this.bCL = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bCD = -1;
        this.bCH = 0;
        this.bCI = -1;
        this.currentPosition = -1;
        this.bCL = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bCF = new ArrayList();
        this.bCG = new ArrayList();
        this.bCM = new com.baidu.adp.lib.e.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(w.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(w.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bCx = new GifView(context);
        aq.d(this.bCx, w.g.bg_expression_bubble, this.amL);
        this.bCx.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bCw = new WindowManager.LayoutParams();
        this.bCz = context.getResources().getDimensionPixelSize(w.f.ds240);
        this.bCA = context.getResources().getDimensionPixelSize(w.f.ds252);
        this.bCB = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.bCw.width = this.bCz;
        this.bCw.height = this.bCA;
        this.bCw.gravity = 51;
        this.bCw.format = -3;
        this.bCw.type = 1000;
        this.bCw.flags |= 56;
        this.bCy = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.amN = (IndicatorView) findViewById(w.h.face_tab_indicator);
        this.bCv = (LinearLayout) findViewById(w.h.face_tab_indicator_layout);
        this.bCv.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bCw.type = 1000;
            this.bCw.flags = 25165832;
        }
    }

    private void Z(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bCF.clear();
        this.bCG.clear();
        if (list != null && !list.isEmpty()) {
            this.bCF.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dh = cVar.Dh();
                    int i4 = emotionsCount / (cols * Dh);
                    if (emotionsCount % (cols * Dh) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * Dh;
                        } else {
                            i = emotionsCount - ((cols * Dh) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.hf(i3);
                        tVar.b(cVar.De());
                        tVar.eL(Dh);
                        tVar.eK(cols);
                        tVar.hb(i4);
                        tVar.hc(i5);
                        tVar.hd(i);
                        tVar.he(i5 * cols * Dh);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bCG.add(tVar);
                    }
                }
            }
            this.bCH = this.bCG.size();
            for (int i6 = 0; i6 < this.bCH; i6++) {
                if (this.bCG != null && this.bCG.get(i6) != null) {
                    this.bCG.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void gY(int i) {
        if (this.bCG != null) {
            int size = this.bCG.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bCG.get(i2);
                    if (tVar != null && tVar.UR() == i) {
                        this.bCK = tVar.getIndex();
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
                Z(list);
                gY(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.bCK, true);
                if (this.bCJ != null) {
                    this.bCJ.ha(i);
                    this.bCI = i;
                }
            }
        }
    }

    public void gZ(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bCG.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bCG.get(i3);
                    if (tVar == null || tVar.UR() != i) {
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
        if (this.bCD != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.UH() != null) {
            String eB = aVar.UH().UK().eB(aVar.UG() + i);
            this.bCx.setTag(eB);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = eB;
            this.bCx.a(gifInfo);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bCy.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bCw.x = this.rect.left - ((this.bCw.width - linearLayout.getWidth()) / 2);
            this.bCw.y = (this.rect.top - this.bCw.height) + this.bCB;
            this.bCx.setVisibility(0);
            if (!this.bCC) {
                this.jn.addView(this.bCx, this.bCw);
                this.bCC = true;
            } else {
                this.jn.updateViewLayout(this.bCx, this.bCw);
            }
            gridView.setSelection(i);
            if (this.bCD != -1) {
                ((LinearLayout) gridView.getChildAt(this.bCD - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bCD = i;
            this.bCu = gridView;
        }
    }

    private void UE() {
        if (this.bCC && this.bCx.getVisibility() != 8 && this.bCu != null) {
            this.bCu.setSelection(-1);
            this.bCx.setVisibility(8);
            if (this.bCD != -1) {
                ((LinearLayout) this.bCu.getChildAt(this.bCD - this.bCu.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bCD = -1;
            this.bCu = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bCL.set(x, y);
                break;
            case 1:
            case 3:
                UE();
                break;
            case 2:
                this.bCL.set(x, y);
                if (this.bCC && this.bCx.getVisibility() != 8 && this.bCu != null) {
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
                this.bCL.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                UE();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    UE();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bCu != null) {
                        offsetRectIntoDescendantCoords(this.bCu, this.rect);
                        int pointToPosition = this.bCu.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bCu);
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
        if (this.bCC) {
            this.jn.removeView(this.bCx);
            this.bCC = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bCG != null) {
            int size = this.bCG.size();
            if (i >= 0 && i < size) {
                this.bCE = this.bCG.get(i);
                if (this.amN != null && this.bCE != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.amN.setVisibility(this.bCE.UN() > 1 ? 0 : 4);
                        this.amN.setCount(this.bCE.UN());
                        if (this.bCE != null && this.bCE.UR() != this.bCI) {
                            this.bCI = this.bCE.UR();
                            if (this.bCJ != null) {
                                this.bCJ.ha(this.bCE.UR());
                            }
                        }
                    }
                    float UO = this.bCE.UO() + f;
                    this.amN.setPosition(UO);
                    this.bCv.setContentDescription(String.valueOf(String.format(getResources().getString(w.l.emotion_selection), Integer.valueOf(((int) UO) + 1))) + String.format(getResources().getString(w.l.emotion_page), Integer.valueOf(this.bCE.UN())));
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
        this.amL = i;
        aq.d(this.bCx, w.g.bg_expression_bubble, i);
        aq.e(this, w.e.common_color_10255, i);
        this.amN.setSelector(aq.x(i, w.g.dot_pb_expression_s));
        this.amN.setDrawable(aq.x(i, w.g.dot_pb_expression_n));
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
        UE();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t bCO;

        public a(t tVar) {
            this.bCO = tVar;
        }

        public int UG() {
            if (this.bCO == null) {
                return 0;
            }
            return this.bCO.UQ();
        }

        public t UH() {
            return this.bCO;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bCO == null) {
                return 0;
            }
            return this.bCO.UP();
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
                if (this.bCO.UM() != 0) {
                    i2 = measuredWidth / this.bCO.UM();
                }
                if (this.bCO.getRow() != 0) {
                    i3 = measuredHeight / this.bCO.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bCB * 2, EmotionTabContentView.this.bCB * 2, EmotionTabContentView.this.bCB * 2, EmotionTabContentView.this.bCB * 2);
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
            if (this.bCO != null) {
                int UQ = this.bCO.UQ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(w.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aq.d(tbImageView, w.g.btn_choose_face_selector, EmotionTabContentView.this.amL);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eB = this.bCO.UK().eB(UQ);
                tbImageView.setTag(eB);
                Object a = com.baidu.adp.lib.f.c.fG().a(eB, 20, new j(this), 0, 0, null, null, eB, false, null);
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
                if (this.bCO.UL() == EmotionGroupType.BIG_EMOTION) {
                    String eB2 = this.bCO.UK().eB(UQ);
                    if (!TextUtils.isEmpty(eB2)) {
                        if (EmotionTabContentView.this.amL == 0) {
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
            if (EmotionTabContentView.this.bCG == null) {
                return 0;
            }
            return EmotionTabContentView.this.bCG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bCM.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bCM.fE();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bCG != null && i < EmotionTabContentView.this.bCG.size()) {
                t tVar = (t) EmotionTabContentView.this.bCG.get(i);
                gridView2.setNumColumns(tVar.UM());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(w.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(w.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(w.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.bCG != null) {
                int size = EmotionTabContentView.this.bCG.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bCG.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.amN.setVisibility(tVar.UN() > 1 ? 0 : 4);
                        EmotionTabContentView.this.amN.setCount(tVar.UN());
                        EmotionTabContentView.this.amN.setPosition(tVar.UO());
                        EmotionTabContentView.this.amN.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_selection), Integer.valueOf(tVar.UO() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_page), Integer.valueOf(tVar.UN())));
                    }
                    if (tVar != null && tVar.UR() != EmotionTabContentView.this.bCI) {
                        EmotionTabContentView.this.bCI = tVar.UR();
                        if (EmotionTabContentView.this.bCJ != null) {
                            EmotionTabContentView.this.bCJ.ha(tVar.UR());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bCJ = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
    }
}
