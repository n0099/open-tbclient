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
    private GridView aqY;
    private IndicatorView aqZ;
    private WindowManager.LayoutParams ara;
    private GifView arb;
    private final Rect arc;
    private ViewGroup ard;
    private int are;
    private int arf;
    private int arg;
    private boolean arh;
    private int ari;
    private o arj;
    private List<v> ark;
    private List<o> arl;
    private int arm;
    private int arn;
    private c aro;
    private int arp;
    private final Point arq;
    private int arr;
    private com.baidu.adp.lib.e.b<GridView> ars;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void dY(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arc = new Rect();
        this.ari = -1;
        this.arm = 0;
        this.arn = -1;
        this.currentPosition = -1;
        this.arq = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.arc = new Rect();
        this.ari = -1;
        this.arm = 0;
        this.arn = -1;
        this.currentPosition = -1;
        this.arq = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ark = new ArrayList();
        this.arl = new ArrayList();
        this.ars = new com.baidu.adp.lib.e.b<>(new com.baidu.tbadk.editortools.emotiontool.c(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(i.g.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(i.f.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.arb = new GifView(context);
        al.c(this.arb, i.e.bg_expression_bubble, this.arr);
        this.arb.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.ara = new WindowManager.LayoutParams();
        this.are = context.getResources().getDimensionPixelSize(i.d.ds240);
        this.arf = context.getResources().getDimensionPixelSize(i.d.ds252);
        this.arg = context.getResources().getDimensionPixelSize(i.d.face_tab_content_float_space);
        this.ara.width = this.are;
        this.ara.height = this.arf;
        this.ara.gravity = 51;
        this.ara.format = -3;
        this.ara.type = 1000;
        this.ara.flags |= 56;
        this.ard = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aqZ = (IndicatorView) findViewById(i.f.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ara.type = 1000;
            this.ara.flags = 25165832;
        }
    }

    private void p(List<v> list) {
        int i;
        int i2;
        this.ark.clear();
        this.arl.clear();
        if (list != null && !list.isEmpty()) {
            this.ark.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = list.get(i3);
                if (vVar != null) {
                    int emotionsCount = vVar.getEmotionsCount();
                    int Bv = vVar.Bv();
                    int Bw = vVar.Bw();
                    int i4 = emotionsCount / (Bv * Bw);
                    if (emotionsCount % (Bv * Bw) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        o oVar = new o();
                        if (i5 < i4 - 1) {
                            i = Bv * Bw;
                        } else {
                            i = emotionsCount - ((Bv * Bw) * (i4 - 1));
                        }
                        oVar.e(vVar);
                        oVar.eg(i3);
                        oVar.b(vVar.Bm());
                        oVar.ea(Bw);
                        oVar.eb(Bv);
                        oVar.ec(i4);
                        oVar.ed(i5);
                        oVar.ee(i);
                        oVar.ef(i5 * Bv * Bw);
                        oVar.setEndIndex((i + i2) - 1);
                        this.arl.add(oVar);
                    }
                }
            }
            this.arm = this.arl.size();
            for (int i6 = 0; i6 < this.arm; i6++) {
                if (this.arl != null && this.arl.get(i6) != null) {
                    this.arl.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dW(int i) {
        if (this.arl != null) {
            int size = this.arl.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    o oVar = this.arl.get(i2);
                    if (oVar != null && oVar.Bl() == i) {
                        this.arp = oVar.getIndex();
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
                p(list);
                dW(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.arp, true);
                if (this.aro != null) {
                    this.aro.dY(i);
                    this.arn = i;
                }
            }
        }
    }

    public void dX(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.arl.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    o oVar = this.arl.get(i3);
                    if (oVar == null || oVar.Bl() != i) {
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
        if (this.ari != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Ba() != null) {
            String eh = aVar.Ba().Be().eh(aVar.AZ() + i);
            this.arb.setTag(eh);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.auI = eh;
            this.arb.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.arc);
            this.ard.offsetDescendantRectToMyCoords(linearLayout, this.arc);
            this.ara.x = this.arc.left - ((this.ara.width - linearLayout.getWidth()) / 2);
            this.ara.y = (this.arc.top - this.ara.height) + this.arg;
            this.arb.setVisibility(0);
            if (!this.arh) {
                this.lB.addView(this.arb, this.ara);
                this.arh = true;
            } else {
                this.lB.updateViewLayout(this.arb, this.ara);
            }
            gridView.setSelection(i);
            if (this.ari != -1) {
                ((LinearLayout) gridView.getChildAt(this.ari - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.ari = i;
            this.aqY = gridView;
        }
    }

    private void AX() {
        if (this.arh && this.arb.getVisibility() != 8 && this.aqY != null) {
            this.aqY.setSelection(-1);
            this.arb.setVisibility(8);
            if (this.ari != -1) {
                ((LinearLayout) this.aqY.getChildAt(this.ari - this.aqY.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ari = -1;
            this.aqY = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.arq.set(x, y);
                break;
            case 1:
            case 3:
                AX();
                break;
            case 2:
                this.arq.set(x, y);
                if (this.arh && this.arb.getVisibility() != 8 && this.aqY != null) {
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
                this.arq.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                AX();
                break;
            case 2:
                getFocusedRect(this.arc);
                if (!this.arc.contains(x, y)) {
                    AX();
                    break;
                } else {
                    this.arc.set(x, y, x + 1, y + 1);
                    if (this.aqY != null) {
                        offsetRectIntoDescendantCoords(this.aqY, this.arc);
                        int pointToPosition = this.aqY.pointToPosition(this.arc.left, this.arc.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aqY);
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
        if (this.arh) {
            this.lB.removeView(this.arb);
            this.arh = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.arl != null) {
            int size = this.arl.size();
            if (i >= 0 && i < size) {
                this.arj = this.arl.get(i);
                if (this.aqZ != null && this.arj != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aqZ.setVisibility(0);
                        this.aqZ.setCount(this.arj.Bh());
                        if (this.arj != null && this.arj.Bl() != this.arn) {
                            this.arn = this.arj.Bl();
                            if (this.aro != null) {
                                this.aro.dY(this.arj.Bl());
                            }
                        }
                    }
                    this.aqZ.setPosition(this.arj.Bi() + f);
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
        this.arr = i;
        al.c(this.arb, i.e.bg_expression_bubble, i);
        al.d(this, i.c.write_editor_background, i);
        this.aqZ.setSelector(al.x(i, i.e.dot_pb_expression_s));
        this.aqZ.setDrawable(al.x(i, i.e.dot_pb_expression_n));
    }

    public void reset() {
        AX();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final o aru;

        public a(o oVar) {
            this.aru = oVar;
        }

        public int AZ() {
            if (this.aru == null) {
                return 0;
            }
            return this.aru.Bk();
        }

        public o Ba() {
            return this.aru;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aru == null) {
                return 0;
            }
            return this.aru.Bj();
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
            if (this.aru != null) {
                int Bk = this.aru.Bk() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int Bg = measuredWidth / this.aru.Bg();
                int row = measuredHeight / this.aru.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.arg * 2, EmotionTabContentView.this.arg * 2, EmotionTabContentView.this.arg * 2, EmotionTabContentView.this.arg * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(Bg, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.c(tbImageView, i.e.btn_choose_face_selector, EmotionTabContentView.this.arr);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eh = this.aru.Be().eh(Bk);
                tbImageView.setTag(eh);
                Object a = com.baidu.adp.lib.f.c.gZ().a(eh, 20, new d(this), 0, 0, null, null, eh, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(i.f.emotion_tab_content_tip);
                if (this.aru.Bf() == EmotionGroupType.BIG_EMOTION) {
                    String eh2 = this.aru.Be().eh(Bk);
                    if (!TextUtils.isEmpty(eh2)) {
                        if (EmotionTabContentView.this.arr == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(i.c.cp_cont_c);
                        } else {
                            color = al.getColor(i.c.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eh2.substring(eh2.lastIndexOf("_") + 1, eh2.length() - 1));
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
            if (EmotionTabContentView.this.arl == null) {
                return 0;
            }
            return EmotionTabContentView.this.arl.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ars.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ars.gX();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.arl != null && i < EmotionTabContentView.this.arl.size()) {
                o oVar = (o) EmotionTabContentView.this.arl.get(i);
                gridView2.setNumColumns(oVar.Bg());
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
            if (EmotionTabContentView.this.arl != null) {
                int size = EmotionTabContentView.this.arl.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    o oVar = (o) EmotionTabContentView.this.arl.get(i);
                    if (oVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aqZ.setVisibility(0);
                        EmotionTabContentView.this.aqZ.setCount(oVar.Bh());
                        EmotionTabContentView.this.aqZ.setPosition(oVar.Bi());
                    }
                    if (oVar != null && oVar.Bl() != EmotionTabContentView.this.arn) {
                        EmotionTabContentView.this.arn = oVar.Bl();
                        if (EmotionTabContentView.this.aro != null) {
                            EmotionTabContentView.this.aro.dY(oVar.Bl());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aro = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
    }
}
