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
    private com.baidu.tbadk.editortools.j KM;
    private int amZ;
    private IndicatorView anb;
    private int bCA;
    private int bCB;
    private c bCC;
    private int bCD;
    private final Point bCE;
    private com.baidu.adp.lib.e.b<GridView> bCF;
    private GridView bCn;
    private LinearLayout bCo;
    private WindowManager.LayoutParams bCp;
    private GifView bCq;
    private ViewGroup bCr;
    private int bCs;
    private int bCt;
    private int bCu;
    private boolean bCv;
    private int bCw;
    private u bCx;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bCy;
    private List<u> bCz;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hd(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bCw = -1;
        this.bCA = 0;
        this.bCB = -1;
        this.currentPosition = -1;
        this.bCE = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bCw = -1;
        this.bCA = 0;
        this.bCB = -1;
        this.currentPosition = -1;
        this.bCE = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bCy = new ArrayList();
        this.bCz = new ArrayList();
        this.bCF = new com.baidu.adp.lib.e.b<>(new j(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(w.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(w.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bCq = new GifView(context);
        aq.d(this.bCq, w.g.bg_expression_bubble, this.amZ);
        this.bCq.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bCp = new WindowManager.LayoutParams();
        this.bCs = context.getResources().getDimensionPixelSize(w.f.ds240);
        this.bCt = context.getResources().getDimensionPixelSize(w.f.ds252);
        this.bCu = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.bCp.width = this.bCs;
        this.bCp.height = this.bCt;
        this.bCp.gravity = 51;
        this.bCp.format = -3;
        this.bCp.type = 1000;
        this.bCp.flags |= 56;
        this.bCr = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.anb = (IndicatorView) findViewById(w.h.face_tab_indicator);
        this.bCo = (LinearLayout) findViewById(w.h.face_tab_indicator_layout);
        this.bCo.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bCp.type = 1000;
            this.bCp.flags = 25165832;
        }
    }

    private void Z(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bCy.clear();
        this.bCz.clear();
        if (list != null && !list.isEmpty()) {
            this.bCy.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int DF = cVar.DF();
                    int i4 = emotionsCount / (cols * DF);
                    if (emotionsCount % (cols * DF) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        u uVar = new u();
                        if (i5 < i4 - 1) {
                            i = cols * DF;
                        } else {
                            i = emotionsCount - ((cols * DF) * (i4 - 1));
                        }
                        uVar.e(cVar);
                        uVar.hi(i3);
                        uVar.b(cVar.DC());
                        uVar.eO(DF);
                        uVar.eN(cols);
                        uVar.he(i4);
                        uVar.hf(i5);
                        uVar.hg(i);
                        uVar.hh(i5 * cols * DF);
                        uVar.setEndIndex((i + i2) - 1);
                        this.bCz.add(uVar);
                    }
                }
            }
            this.bCA = this.bCz.size();
            for (int i6 = 0; i6 < this.bCA; i6++) {
                if (this.bCz != null && this.bCz.get(i6) != null) {
                    this.bCz.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hb(int i) {
        if (this.bCz != null) {
            int size = this.bCz.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    u uVar = this.bCz.get(i2);
                    if (uVar != null && uVar.Vp() == i) {
                        this.bCD = uVar.getIndex();
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
                hb(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.bCD, true);
                if (this.bCC != null) {
                    this.bCC.hd(i);
                    this.bCB = i;
                }
            }
        }
    }

    public void hc(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bCz.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    u uVar = this.bCz.get(i3);
                    if (uVar == null || uVar.Vp() != i) {
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
        if (this.bCw != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Vf() != null) {
            String eE = aVar.Vf().Vi().eE(aVar.Ve() + i);
            this.bCq.setTag(eE);
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = eE;
            this.bCq.a(gifInfo);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bCr.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bCp.x = this.rect.left - ((this.bCp.width - linearLayout.getWidth()) / 2);
            this.bCp.y = (this.rect.top - this.bCp.height) + this.bCu;
            this.bCq.setVisibility(0);
            if (!this.bCv) {
                this.jn.addView(this.bCq, this.bCp);
                this.bCv = true;
            } else {
                this.jn.updateViewLayout(this.bCq, this.bCp);
            }
            gridView.setSelection(i);
            if (this.bCw != -1) {
                ((LinearLayout) gridView.getChildAt(this.bCw - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.bCw = i;
            this.bCn = gridView;
        }
    }

    private void Vc() {
        if (this.bCv && this.bCq.getVisibility() != 8 && this.bCn != null) {
            this.bCn.setSelection(-1);
            this.bCq.setVisibility(8);
            if (this.bCw != -1) {
                ((LinearLayout) this.bCn.getChildAt(this.bCw - this.bCn.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bCw = -1;
            this.bCn = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bCE.set(x, y);
                break;
            case 1:
            case 3:
                Vc();
                break;
            case 2:
                this.bCE.set(x, y);
                if (this.bCv && this.bCq.getVisibility() != 8 && this.bCn != null) {
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
                this.bCE.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Vc();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Vc();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bCn != null) {
                        offsetRectIntoDescendantCoords(this.bCn, this.rect);
                        int pointToPosition = this.bCn.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bCn);
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
        if (this.bCv) {
            this.jn.removeView(this.bCq);
            this.bCv = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bCz != null) {
            int size = this.bCz.size();
            if (i >= 0 && i < size) {
                this.bCx = this.bCz.get(i);
                if (this.anb != null && this.bCx != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.anb.setVisibility(this.bCx.Vl() > 1 ? 0 : 4);
                        this.anb.setCount(this.bCx.Vl());
                        if (this.bCx != null && this.bCx.Vp() != this.bCB) {
                            this.bCB = this.bCx.Vp();
                            if (this.bCC != null) {
                                this.bCC.hd(this.bCx.Vp());
                            }
                        }
                    }
                    float Vm = this.bCx.Vm() + f;
                    this.anb.setPosition(Vm);
                    this.bCo.setContentDescription(String.valueOf(String.format(getResources().getString(w.l.emotion_selection), Integer.valueOf(((int) Vm) + 1))) + String.format(getResources().getString(w.l.emotion_page), Integer.valueOf(this.bCx.Vl())));
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
        this.amZ = i;
        aq.d(this.bCq, w.g.bg_expression_bubble, i);
        aq.e(this, w.e.common_color_10255, i);
        this.anb.setSelector(aq.x(i, w.g.dot_pb_expression_s));
        this.anb.setDrawable(aq.x(i, w.g.dot_pb_expression_n));
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
        Vc();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final u bCH;

        public a(u uVar) {
            this.bCH = uVar;
        }

        public int Ve() {
            if (this.bCH == null) {
                return 0;
            }
            return this.bCH.Vo();
        }

        public u Vf() {
            return this.bCH;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bCH == null) {
                return 0;
            }
            return this.bCH.Vn();
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
                if (this.bCH.Vk() != 0) {
                    i2 = measuredWidth / this.bCH.Vk();
                }
                if (this.bCH.getRow() != 0) {
                    i3 = measuredHeight / this.bCH.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bCu * 2, EmotionTabContentView.this.bCu * 2, EmotionTabContentView.this.bCu * 2, EmotionTabContentView.this.bCu * 2);
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
            if (this.bCH != null) {
                int Vo = this.bCH.Vo() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(w.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aq.d(tbImageView, w.g.btn_choose_face_selector, EmotionTabContentView.this.amZ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eE = this.bCH.Vi().eE(Vo);
                tbImageView.setTag(eE);
                Object a = com.baidu.adp.lib.f.c.fL().a(eE, 20, new k(this), 0, 0, null, null, eE, false, null);
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
                if (this.bCH.Vj() == EmotionGroupType.BIG_EMOTION) {
                    String eE2 = this.bCH.Vi().eE(Vo);
                    if (!TextUtils.isEmpty(eE2)) {
                        if (EmotionTabContentView.this.amZ == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(w.e.cp_cont_c);
                        } else {
                            color = aq.getColor(w.e.cp_cont_c);
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
            if (EmotionTabContentView.this.bCz == null) {
                return 0;
            }
            return EmotionTabContentView.this.bCz.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bCF.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bCF.fJ();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bCz != null && i < EmotionTabContentView.this.bCz.size()) {
                u uVar = (u) EmotionTabContentView.this.bCz.get(i);
                gridView2.setNumColumns(uVar.Vk());
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
            if (EmotionTabContentView.this.bCz != null) {
                int size = EmotionTabContentView.this.bCz.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    u uVar = (u) EmotionTabContentView.this.bCz.get(i);
                    if (uVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.anb.setVisibility(uVar.Vl() > 1 ? 0 : 4);
                        EmotionTabContentView.this.anb.setCount(uVar.Vl());
                        EmotionTabContentView.this.anb.setPosition(uVar.Vm());
                        EmotionTabContentView.this.anb.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_selection), Integer.valueOf(uVar.Vm() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_page), Integer.valueOf(uVar.Vl())));
                    }
                    if (uVar != null && uVar.Vp() != EmotionTabContentView.this.bCB) {
                        EmotionTabContentView.this.bCB = uVar.Vp();
                        if (EmotionTabContentView.this.bCC != null) {
                            EmotionTabContentView.this.bCC.hd(uVar.Vp());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bCC = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
    }
}
