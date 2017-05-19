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
    private com.baidu.tbadk.editortools.j Kg;
    private int ane;
    private IndicatorView ang;
    private GridView bEL;
    private LinearLayout bEM;
    private WindowManager.LayoutParams bEN;
    private GifView bEO;
    private ViewGroup bEP;
    private int bEQ;
    private int bER;
    private int bES;
    private boolean bET;
    private int bEU;
    private u bEV;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bEW;
    private List<u> bEX;
    private int bEY;
    private int bEZ;
    private c bFa;
    private int bFb;
    private final Point bFc;
    private com.baidu.adp.lib.e.b<GridView> bFd;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hg(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bEU = -1;
        this.bEY = 0;
        this.bEZ = -1;
        this.currentPosition = -1;
        this.bFc = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bEU = -1;
        this.bEY = 0;
        this.bEZ = -1;
        this.currentPosition = -1;
        this.bFc = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bEW = new ArrayList();
        this.bEX = new ArrayList();
        this.bFd = new com.baidu.adp.lib.e.b<>(new j(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(w.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(w.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bEO = new GifView(context);
        aq.d(this.bEO, w.g.bg_expression_bubble, this.ane);
        this.bEO.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bEN = new WindowManager.LayoutParams();
        this.bEQ = context.getResources().getDimensionPixelSize(w.f.ds240);
        this.bER = context.getResources().getDimensionPixelSize(w.f.ds252);
        this.bES = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.bEN.width = this.bEQ;
        this.bEN.height = this.bER;
        this.bEN.gravity = 51;
        this.bEN.format = -3;
        this.bEN.type = 1000;
        this.bEN.flags |= 56;
        this.bEP = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ang = (IndicatorView) findViewById(w.h.face_tab_indicator);
        this.bEM = (LinearLayout) findViewById(w.h.face_tab_indicator_layout);
        this.bEM.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bEN.type = 1000;
            this.bEN.flags = 25165832;
        }
    }

    private void ac(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bEW.clear();
        this.bEX.clear();
        if (list != null && !list.isEmpty()) {
            this.bEW.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CJ = cVar.CJ();
                    int i4 = emotionsCount / (cols * CJ);
                    if (emotionsCount % (cols * CJ) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        u uVar = new u();
                        if (i5 < i4 - 1) {
                            i = cols * CJ;
                        } else {
                            i = emotionsCount - ((cols * CJ) * (i4 - 1));
                        }
                        uVar.e(cVar);
                        uVar.hl(i3);
                        uVar.b(cVar.CG());
                        uVar.eK(CJ);
                        uVar.eJ(cols);
                        uVar.hh(i4);
                        uVar.hi(i5);
                        uVar.hj(i);
                        uVar.hk(i5 * cols * CJ);
                        uVar.setEndIndex((i + i2) - 1);
                        this.bEX.add(uVar);
                    }
                }
            }
            this.bEY = this.bEX.size();
            for (int i6 = 0; i6 < this.bEY; i6++) {
                if (this.bEX != null && this.bEX.get(i6) != null) {
                    this.bEX.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void he(int i) {
        if (this.bEX != null) {
            int size = this.bEX.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    u uVar = this.bEX.get(i2);
                    if (uVar != null && uVar.VL() == i) {
                        this.bFb = uVar.getIndex();
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
                he(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.bFb, true);
                if (this.bFa != null) {
                    this.bFa.hg(i);
                    this.bEZ = i;
                }
            }
        }
    }

    public void hf(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bEX.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    u uVar = this.bEX.get(i3);
                    if (uVar == null || uVar.VL() != i) {
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
        if (this.bEU != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.VB() != null) {
            String eA = aVar.VB().VE().eA(aVar.VA() + i);
            this.bEO.setTag(eA);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = eA;
            this.bEO.a(gifInfo);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bEP.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bEN.x = this.rect.left - ((this.bEN.width - linearLayout.getWidth()) / 2);
            this.bEN.y = (this.rect.top - this.bEN.height) + this.bES;
            this.bEO.setVisibility(0);
            if (!this.bET) {
                this.jn.addView(this.bEO, this.bEN);
                this.bET = true;
            } else {
                this.jn.updateViewLayout(this.bEO, this.bEN);
            }
            gridView.setSelection(i);
            if (this.bEU != -1) {
                ((LinearLayout) gridView.getChildAt(this.bEU - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bEU = i;
            this.bEL = gridView;
        }
    }

    private void Vy() {
        if (this.bET && this.bEO.getVisibility() != 8 && this.bEL != null) {
            this.bEL.setSelection(-1);
            this.bEO.setVisibility(8);
            if (this.bEU != -1) {
                ((LinearLayout) this.bEL.getChildAt(this.bEU - this.bEL.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bEU = -1;
            this.bEL = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bFc.set(x, y);
                break;
            case 1:
            case 3:
                Vy();
                break;
            case 2:
                this.bFc.set(x, y);
                if (this.bET && this.bEO.getVisibility() != 8 && this.bEL != null) {
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
                this.bFc.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Vy();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Vy();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bEL != null) {
                        offsetRectIntoDescendantCoords(this.bEL, this.rect);
                        int pointToPosition = this.bEL.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bEL);
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
        if (this.bET) {
            this.jn.removeView(this.bEO);
            this.bET = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bEX != null) {
            int size = this.bEX.size();
            if (i >= 0 && i < size) {
                this.bEV = this.bEX.get(i);
                if (this.ang != null && this.bEV != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ang.setVisibility(this.bEV.VH() > 1 ? 0 : 4);
                        this.ang.setCount(this.bEV.VH());
                        if (this.bEV != null && this.bEV.VL() != this.bEZ) {
                            this.bEZ = this.bEV.VL();
                            if (this.bFa != null) {
                                this.bFa.hg(this.bEV.VL());
                            }
                        }
                    }
                    float VI = this.bEV.VI() + f;
                    this.ang.setPosition(VI);
                    this.bEM.setContentDescription(String.valueOf(String.format(getResources().getString(w.l.emotion_selection), Integer.valueOf(((int) VI) + 1))) + String.format(getResources().getString(w.l.emotion_page), Integer.valueOf(this.bEV.VH())));
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
        this.ane = i;
        aq.d(this.bEO, w.g.bg_expression_bubble, i);
        aq.e(this, w.e.common_color_10255, i);
        this.ang.setSelector(aq.v(i, w.g.dot_pb_expression_s));
        this.ang.setDrawable(aq.v(i, w.g.dot_pb_expression_n));
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
        Vy();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final u bFf;

        public a(u uVar) {
            this.bFf = uVar;
        }

        public int VA() {
            if (this.bFf == null) {
                return 0;
            }
            return this.bFf.VK();
        }

        public u VB() {
            return this.bFf;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bFf == null) {
                return 0;
            }
            return this.bFf.VJ();
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
                if (this.bFf.VG() != 0) {
                    i2 = measuredWidth / this.bFf.VG();
                }
                if (this.bFf.getRow() != 0) {
                    i3 = measuredHeight / this.bFf.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bES * 2, EmotionTabContentView.this.bES * 2, EmotionTabContentView.this.bES * 2, EmotionTabContentView.this.bES * 2);
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
            if (this.bFf != null) {
                int VK = this.bFf.VK() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(w.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aq.d(tbImageView, w.g.btn_choose_face_selector, EmotionTabContentView.this.ane);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eA = this.bFf.VE().eA(VK);
                tbImageView.setTag(eA);
                Object a = com.baidu.adp.lib.f.c.fM().a(eA, 20, new k(this), 0, 0, null, null, eA, false, null);
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
                if (this.bFf.VF() == EmotionGroupType.BIG_EMOTION) {
                    String eA2 = this.bFf.VE().eA(VK);
                    if (!TextUtils.isEmpty(eA2)) {
                        if (EmotionTabContentView.this.ane == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(w.e.cp_cont_c);
                        } else {
                            color = aq.getColor(w.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eA2.substring(eA2.lastIndexOf("_") + 1, eA2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eA.length() > 3) {
                    linearLayout3.setContentDescription(eA.substring(2, eA.length() - 1));
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
            if (EmotionTabContentView.this.bEX == null) {
                return 0;
            }
            return EmotionTabContentView.this.bEX.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bFd.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bFd.fK();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bEX != null && i < EmotionTabContentView.this.bEX.size()) {
                u uVar = (u) EmotionTabContentView.this.bEX.get(i);
                gridView2.setNumColumns(uVar.VG());
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
            if (EmotionTabContentView.this.bEX != null) {
                int size = EmotionTabContentView.this.bEX.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    u uVar = (u) EmotionTabContentView.this.bEX.get(i);
                    if (uVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ang.setVisibility(uVar.VH() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ang.setCount(uVar.VH());
                        EmotionTabContentView.this.ang.setPosition(uVar.VI());
                        EmotionTabContentView.this.ang.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_selection), Integer.valueOf(uVar.VI() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_page), Integer.valueOf(uVar.VH())));
                    }
                    if (uVar != null && uVar.VL() != EmotionTabContentView.this.bEZ) {
                        EmotionTabContentView.this.bEZ = uVar.VL();
                        if (EmotionTabContentView.this.bFa != null) {
                            EmotionTabContentView.this.bFa.hg(uVar.VL());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bFa = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
    }
}
