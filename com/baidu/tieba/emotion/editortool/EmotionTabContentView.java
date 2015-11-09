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
    private com.baidu.tbadk.editortools.j KB;
    private GridView aKc;
    private WindowManager.LayoutParams aKd;
    private GifView aKe;
    private final Rect aKf;
    private ViewGroup aKg;
    private int aKh;
    private int aKi;
    private int aKj;
    private boolean aKk;
    private int aKl;
    private s aKm;
    private List<com.baidu.tbadk.editortools.emotiontool.c> aKn;
    private List<s> aKo;
    private int aKp;
    private int aKq;
    private c aKr;
    private int aKs;
    private final Point aKt;
    private com.baidu.adp.lib.e.b<GridView> aKu;
    private int arf;
    private IndicatorView ari;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void eW(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKf = new Rect();
        this.aKl = -1;
        this.aKp = 0;
        this.aKq = -1;
        this.currentPosition = -1;
        this.aKt = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.aKf = new Rect();
        this.aKl = -1;
        this.aKp = 0;
        this.aKq = -1;
        this.currentPosition = -1;
        this.aKt = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aKn = new ArrayList();
        this.aKo = new ArrayList();
        this.aKu = new com.baidu.adp.lib.e.b<>(new h(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(i.g.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(i.f.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.aKe = new GifView(context);
        an.c(this.aKe, i.e.bg_expression_bubble, this.arf);
        this.aKe.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.aKd = new WindowManager.LayoutParams();
        this.aKh = context.getResources().getDimensionPixelSize(i.d.ds240);
        this.aKi = context.getResources().getDimensionPixelSize(i.d.ds252);
        this.aKj = context.getResources().getDimensionPixelSize(i.d.face_tab_content_float_space);
        this.aKd.width = this.aKh;
        this.aKd.height = this.aKi;
        this.aKd.gravity = 51;
        this.aKd.format = -3;
        this.aKd.type = 1000;
        this.aKd.flags |= 56;
        this.aKg = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ari = (IndicatorView) findViewById(i.f.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aKd.type = 1000;
            this.aKd.flags = 25165832;
        }
    }

    private void J(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.aKn.clear();
        this.aKo.clear();
        if (list != null && !list.isEmpty()) {
            this.aKn.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int AS = cVar.AS();
                    int AT = cVar.AT();
                    int i4 = emotionsCount / (AS * AT);
                    if (emotionsCount % (AS * AT) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        s sVar = new s();
                        if (i5 < i4 - 1) {
                            i = AS * AT;
                        } else {
                            i = emotionsCount - ((AS * AT) * (i4 - 1));
                        }
                        sVar.e(cVar);
                        sVar.fb(i3);
                        sVar.b(cVar.AP());
                        sVar.eh(AT);
                        sVar.eg(AS);
                        sVar.eX(i4);
                        sVar.eY(i5);
                        sVar.eZ(i);
                        sVar.fa(i5 * AS * AT);
                        sVar.setEndIndex((i + i2) - 1);
                        this.aKo.add(sVar);
                    }
                }
            }
            this.aKp = this.aKo.size();
            for (int i6 = 0; i6 < this.aKp; i6++) {
                if (this.aKo != null && this.aKo.get(i6) != null) {
                    this.aKo.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void eU(int i) {
        if (this.aKo != null) {
            int size = this.aKo.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    s sVar = this.aKo.get(i2);
                    if (sVar != null && sVar.HZ() == i) {
                        this.aKs = sVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void c(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                J(list);
                eU(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.aKs, true);
                if (this.aKr != null) {
                    this.aKr.eW(i);
                    this.aKq = i;
                }
            }
        }
    }

    public void eV(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.aKo.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    s sVar = this.aKo.get(i3);
                    if (sVar == null || sVar.HZ() != i) {
                        i3++;
                    } else {
                        i2 = sVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, true);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.aKl != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.HP() != null) {
            String dX = aVar.HP().HS().dX(aVar.HO() + i);
            this.aKe.setTag(dX);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.arU = dX;
            this.aKe.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.aKf);
            this.aKg.offsetDescendantRectToMyCoords(linearLayout, this.aKf);
            this.aKd.x = this.aKf.left - ((this.aKd.width - linearLayout.getWidth()) / 2);
            this.aKd.y = (this.aKf.top - this.aKd.height) + this.aKj;
            this.aKe.setVisibility(0);
            if (!this.aKk) {
                this.lB.addView(this.aKe, this.aKd);
                this.aKk = true;
            } else {
                this.lB.updateViewLayout(this.aKe, this.aKd);
            }
            gridView.setSelection(i);
            if (this.aKl != -1) {
                ((LinearLayout) gridView.getChildAt(this.aKl - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aKl = i;
            this.aKc = gridView;
        }
    }

    private void HM() {
        if (this.aKk && this.aKe.getVisibility() != 8 && this.aKc != null) {
            this.aKc.setSelection(-1);
            this.aKe.setVisibility(8);
            if (this.aKl != -1) {
                ((LinearLayout) this.aKc.getChildAt(this.aKl - this.aKc.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aKl = -1;
            this.aKc = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aKt.set(x, y);
                break;
            case 1:
            case 3:
                HM();
                break;
            case 2:
                this.aKt.set(x, y);
                if (this.aKk && this.aKe.getVisibility() != 8 && this.aKc != null) {
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
                this.aKt.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                HM();
                break;
            case 2:
                getFocusedRect(this.aKf);
                if (!this.aKf.contains(x, y)) {
                    HM();
                    break;
                } else {
                    this.aKf.set(x, y, x + 1, y + 1);
                    if (this.aKc != null) {
                        offsetRectIntoDescendantCoords(this.aKc, this.aKf);
                        int pointToPosition = this.aKc.pointToPosition(this.aKf.left, this.aKf.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aKc);
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
        if (this.aKk) {
            this.lB.removeView(this.aKe);
            this.aKk = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aKo != null) {
            int size = this.aKo.size();
            if (i >= 0 && i < size) {
                this.aKm = this.aKo.get(i);
                if (this.ari != null && this.aKm != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ari.setVisibility(0);
                        this.ari.setCount(this.aKm.HV());
                        if (this.aKm != null && this.aKm.HZ() != this.aKq) {
                            this.aKq = this.aKm.HZ();
                            if (this.aKr != null) {
                                this.aKr.eW(this.aKm.HZ());
                            }
                        }
                    }
                    this.ari.setPosition(this.aKm.HW() + f);
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
        this.arf = i;
        an.c(this.aKe, i.e.bg_expression_bubble, i);
        an.d(this, i.c.write_editor_background, i);
        this.ari.setSelector(an.x(i, i.e.dot_pb_expression_s));
        this.ari.setDrawable(an.x(i, i.e.dot_pb_expression_n));
    }

    public void reset() {
        HM();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final s aKw;

        public a(s sVar) {
            this.aKw = sVar;
        }

        public int HO() {
            if (this.aKw == null) {
                return 0;
            }
            return this.aKw.HY();
        }

        public s HP() {
            return this.aKw;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aKw == null) {
                return 0;
            }
            return this.aKw.HX();
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
            if (this.aKw != null) {
                int HY = this.aKw.HY() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int HU = measuredWidth / this.aKw.HU();
                int row = measuredHeight / this.aKw.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.aKj * 2, EmotionTabContentView.this.aKj * 2, EmotionTabContentView.this.aKj * 2, EmotionTabContentView.this.aKj * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(HU, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                an.c(tbImageView, i.e.btn_choose_face_selector, EmotionTabContentView.this.arf);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String dX = this.aKw.HS().dX(HY);
                tbImageView.setTag(dX);
                Object a = com.baidu.adp.lib.f.c.hb().a(dX, 20, new i(this), 0, 0, null, null, dX, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(i.f.emotion_tab_content_tip);
                if (this.aKw.HT() == EmotionGroupType.BIG_EMOTION) {
                    String dX2 = this.aKw.HS().dX(HY);
                    if (!TextUtils.isEmpty(dX2)) {
                        if (EmotionTabContentView.this.arf == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(i.c.cp_cont_c);
                        } else {
                            color = an.getColor(i.c.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(dX2.substring(dX2.lastIndexOf("_") + 1, dX2.length() - 1));
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
            if (EmotionTabContentView.this.aKo == null) {
                return 0;
            }
            return EmotionTabContentView.this.aKo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.aKu.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.aKu.gZ();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.aKo != null && i < EmotionTabContentView.this.aKo.size()) {
                s sVar = (s) EmotionTabContentView.this.aKo.get(i);
                gridView2.setNumColumns(sVar.HU());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(i.c.transparent);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(i.d.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(i.d.ds28), 0);
                gridView2.setOnItemLongClickListener(new j(this));
                gridView2.setOnItemClickListener(new k(this));
                gridView2.setAdapter((ListAdapter) new a(sVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.aKo != null) {
                int size = EmotionTabContentView.this.aKo.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    s sVar = (s) EmotionTabContentView.this.aKo.get(i);
                    if (sVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ari.setVisibility(0);
                        EmotionTabContentView.this.ari.setCount(sVar.HV());
                        EmotionTabContentView.this.ari.setPosition(sVar.HW());
                    }
                    if (sVar != null && sVar.HZ() != EmotionTabContentView.this.aKq) {
                        EmotionTabContentView.this.aKq = sVar.HZ();
                        if (EmotionTabContentView.this.aKr != null) {
                            EmotionTabContentView.this.aKr.eW(sVar.HZ());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aKr = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.KB = jVar;
    }
}
