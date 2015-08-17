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
import com.baidu.tbadk.core.util.al;
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
    private List<v> apA;
    private List<o> apB;
    private int apC;
    private int apD;
    private c apE;
    private int apF;
    private final Point apG;
    private int apH;
    private com.baidu.adp.lib.e.b<GridView> apI;
    private GridView apn;
    private IndicatorView apo;
    private WindowManager.LayoutParams apq;
    private GifView apr;
    private final Rect aps;
    private ViewGroup apt;
    private int apu;
    private int apv;
    private int apw;
    private boolean apx;
    private int apy;
    private o apz;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void dQ(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aps = new Rect();
        this.apy = -1;
        this.apC = 0;
        this.apD = -1;
        this.currentPosition = -1;
        this.apG = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.aps = new Rect();
        this.apy = -1;
        this.apC = 0;
        this.apD = -1;
        this.currentPosition = -1;
        this.apG = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.apA = new ArrayList();
        this.apB = new ArrayList();
        this.apI = new com.baidu.adp.lib.e.b<>(new com.baidu.tbadk.editortools.emotiontool.c(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(i.g.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(i.f.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.apr = new GifView(context);
        al.c(this.apr, i.e.bg_expression_bubble, this.apH);
        this.apr.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.apq = new WindowManager.LayoutParams();
        this.apu = context.getResources().getDimensionPixelSize(i.d.ds240);
        this.apv = context.getResources().getDimensionPixelSize(i.d.ds252);
        this.apw = context.getResources().getDimensionPixelSize(i.d.face_tab_content_float_space);
        this.apq.width = this.apu;
        this.apq.height = this.apv;
        this.apq.gravity = 51;
        this.apq.format = -3;
        this.apq.type = 1000;
        this.apq.flags |= 56;
        this.apt = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.apo = (IndicatorView) findViewById(i.f.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.apq.type = 1000;
            this.apq.flags = 25165832;
        }
    }

    private void o(List<v> list) {
        int i;
        int i2;
        this.apA.clear();
        this.apB.clear();
        if (list != null && !list.isEmpty()) {
            this.apA.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = list.get(i3);
                if (vVar != null) {
                    int emotionsCount = vVar.getEmotionsCount();
                    int Bi = vVar.Bi();
                    int Bj = vVar.Bj();
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
                        oVar.e(vVar);
                        oVar.dY(i3);
                        oVar.b(vVar.AZ());
                        oVar.dS(Bj);
                        oVar.dT(Bi);
                        oVar.dU(i4);
                        oVar.dV(i5);
                        oVar.dW(i);
                        oVar.dX(i5 * Bi * Bj);
                        oVar.setEndIndex((i + i2) - 1);
                        this.apB.add(oVar);
                    }
                }
            }
            this.apC = this.apB.size();
            for (int i6 = 0; i6 < this.apC; i6++) {
                if (this.apB != null && this.apB.get(i6) != null) {
                    this.apB.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dO(int i) {
        if (this.apB != null) {
            int size = this.apB.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    o oVar = this.apB.get(i2);
                    if (oVar != null && oVar.AY() == i) {
                        this.apF = oVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void b(List<v> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                o(list);
                dO(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.apF, true);
                if (this.apE != null) {
                    this.apE.dQ(i);
                    this.apD = i;
                }
            }
        }
    }

    public void dP(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.apB.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    o oVar = this.apB.get(i3);
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
        if (this.apy != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.AN() != null) {
            String dZ = aVar.AN().AR().dZ(aVar.AM() + i);
            this.apr.setTag(dZ);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.asY = dZ;
            this.apr.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.aps);
            this.apt.offsetDescendantRectToMyCoords(linearLayout, this.aps);
            this.apq.x = this.aps.left - ((this.apq.width - linearLayout.getWidth()) / 2);
            this.apq.y = (this.aps.top - this.apq.height) + this.apw;
            this.apr.setVisibility(0);
            if (!this.apx) {
                this.lB.addView(this.apr, this.apq);
                this.apx = true;
            } else {
                this.lB.updateViewLayout(this.apr, this.apq);
            }
            gridView.setSelection(i);
            if (this.apy != -1) {
                ((LinearLayout) gridView.getChildAt(this.apy - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.apy = i;
            this.apn = gridView;
        }
    }

    private void AK() {
        if (this.apx && this.apr.getVisibility() != 8 && this.apn != null) {
            this.apn.setSelection(-1);
            this.apr.setVisibility(8);
            if (this.apy != -1) {
                ((LinearLayout) this.apn.getChildAt(this.apy - this.apn.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.apy = -1;
            this.apn = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.apG.set(x, y);
                break;
            case 1:
            case 3:
                AK();
                break;
            case 2:
                this.apG.set(x, y);
                if (this.apx && this.apr.getVisibility() != 8 && this.apn != null) {
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
                this.apG.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                AK();
                break;
            case 2:
                getFocusedRect(this.aps);
                if (!this.aps.contains(x, y)) {
                    AK();
                    break;
                } else {
                    this.aps.set(x, y, x + 1, y + 1);
                    if (this.apn != null) {
                        offsetRectIntoDescendantCoords(this.apn, this.aps);
                        int pointToPosition = this.apn.pointToPosition(this.aps.left, this.aps.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.apn);
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
        if (this.apx) {
            this.lB.removeView(this.apr);
            this.apx = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.apB != null) {
            int size = this.apB.size();
            if (i >= 0 && i < size) {
                this.apz = this.apB.get(i);
                if (this.apo != null && this.apz != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.apo.setVisibility(0);
                        this.apo.setCount(this.apz.AU());
                        if (this.apz != null && this.apz.AY() != this.apD) {
                            this.apD = this.apz.AY();
                            if (this.apE != null) {
                                this.apE.dQ(this.apz.AY());
                            }
                        }
                    }
                    this.apo.setPosition(this.apz.AV() + f);
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
        this.apH = i;
        al.c(this.apr, i.e.bg_expression_bubble, i);
        al.d(this, i.c.write_editor_background, i);
        this.apo.setSelector(al.x(i, i.e.dot_pb_expression_s));
        this.apo.setDrawable(al.x(i, i.e.dot_pb_expression_n));
    }

    public void reset() {
        AK();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final o apK;

        public a(o oVar) {
            this.apK = oVar;
        }

        public int AM() {
            if (this.apK == null) {
                return 0;
            }
            return this.apK.AX();
        }

        public o AN() {
            return this.apK;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.apK == null) {
                return 0;
            }
            return this.apK.AW();
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
            if (this.apK != null) {
                int AX = this.apK.AX() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int AT = measuredWidth / this.apK.AT();
                int row = measuredHeight / this.apK.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.apw * 2, EmotionTabContentView.this.apw * 2, EmotionTabContentView.this.apw * 2, EmotionTabContentView.this.apw * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(AT, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.c(tbImageView, i.e.btn_choose_face_selector, EmotionTabContentView.this.apH);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String dZ = this.apK.AR().dZ(AX);
                tbImageView.setTag(dZ);
                Object a = com.baidu.adp.lib.f.c.hc().a(dZ, 20, new d(this), 0, 0, null, null, dZ, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(i.f.emotion_tab_content_tip);
                if (this.apK.AS() == EmotionGroupType.BIG_EMOTION) {
                    String dZ2 = this.apK.AR().dZ(AX);
                    if (!TextUtils.isEmpty(dZ2)) {
                        if (EmotionTabContentView.this.apH == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(i.c.cp_cont_c);
                        } else {
                            color = al.getColor(i.c.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(dZ2.substring(dZ2.lastIndexOf("_") + 1, dZ2.length() - 1));
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
            if (EmotionTabContentView.this.apB == null) {
                return 0;
            }
            return EmotionTabContentView.this.apB.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.apI.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.apI.ha();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.apB != null && i < EmotionTabContentView.this.apB.size()) {
                o oVar = (o) EmotionTabContentView.this.apB.get(i);
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
            if (EmotionTabContentView.this.apB != null) {
                int size = EmotionTabContentView.this.apB.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    o oVar = (o) EmotionTabContentView.this.apB.get(i);
                    if (oVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.apo.setVisibility(0);
                        EmotionTabContentView.this.apo.setCount(oVar.AU());
                        EmotionTabContentView.this.apo.setPosition(oVar.AV());
                    }
                    if (oVar != null && oVar.AY() != EmotionTabContentView.this.apD) {
                        EmotionTabContentView.this.apD = oVar.AY();
                        if (EmotionTabContentView.this.apE != null) {
                            EmotionTabContentView.this.apE.dQ(oVar.AY());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.apE = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
    }
}
