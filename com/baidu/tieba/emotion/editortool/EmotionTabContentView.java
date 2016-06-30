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
import com.baidu.tieba.u;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.l BW;
    private int aeK;
    private ViewPager asW;
    private IndicatorView asX;
    private WindowManager bC;
    private GridView bqS;
    private LinearLayout bqT;
    private WindowManager.LayoutParams bqU;
    private GifView bqV;
    private ViewGroup bqW;
    private int bqX;
    private int bqY;
    private int bqZ;
    private boolean bra;
    private int brb;
    private t brc;
    private List<com.baidu.tbadk.editortools.emotiontool.c> brd;
    private List<t> bre;
    private int brf;
    private int brg;
    private c brh;
    private int bri;
    private final Point brj;
    private com.baidu.adp.lib.f.b<GridView> brk;
    private int currentPosition;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void gB(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.brb = -1;
        this.brf = 0;
        this.brg = -1;
        this.currentPosition = -1;
        this.brj = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.brb = -1;
        this.brf = 0;
        this.brg = -1;
        this.currentPosition = -1;
        this.brj = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.brd = new ArrayList();
        this.bre = new ArrayList();
        this.brk = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(u.h.emotion_tab_content, (ViewGroup) this, true);
        this.asW = (ViewPager) findViewById(u.g.face_tab_viewpager);
        this.asW.setFadingEdgeLength(0);
        this.asW.setOnPageChangeListener(this);
        this.bqV = new GifView(context);
        av.d(this.bqV, u.f.bg_expression_bubble, this.aeK);
        this.bqV.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bqU = new WindowManager.LayoutParams();
        this.bqX = context.getResources().getDimensionPixelSize(u.e.ds240);
        this.bqY = context.getResources().getDimensionPixelSize(u.e.ds252);
        this.bqZ = context.getResources().getDimensionPixelSize(u.e.ds10);
        this.bqU.width = this.bqX;
        this.bqU.height = this.bqY;
        this.bqU.gravity = 51;
        this.bqU.format = -3;
        this.bqU.type = 1000;
        this.bqU.flags |= 56;
        this.bqW = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.asX = (IndicatorView) findViewById(u.g.face_tab_indicator);
        this.bqT = (LinearLayout) findViewById(u.g.face_tab_indicator_layout);
        this.bqT.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bqU.type = 1000;
            this.bqU.flags = 25165832;
        }
    }

    private void Y(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.brd.clear();
        this.bre.clear();
        if (list != null && !list.isEmpty()) {
            this.brd.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int BI = cVar.BI();
                    int i4 = emotionsCount / (cols * BI);
                    if (emotionsCount % (cols * BI) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = cols * BI;
                        } else {
                            i = emotionsCount - ((cols * BI) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.gG(i3);
                        tVar.b(cVar.BF());
                        tVar.ey(BI);
                        tVar.ex(cols);
                        tVar.gC(i4);
                        tVar.gD(i5);
                        tVar.gE(i);
                        tVar.gF(i5 * cols * BI);
                        tVar.setEndIndex((i + i2) - 1);
                        this.bre.add(tVar);
                    }
                }
            }
            this.brf = this.bre.size();
            for (int i6 = 0; i6 < this.brf; i6++) {
                if (this.bre != null && this.bre.get(i6) != null) {
                    this.bre.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void gz(int i) {
        if (this.bre != null) {
            int size = this.bre.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.bre.get(i2);
                    if (tVar != null && tVar.Ry() == i) {
                        this.bri = tVar.getIndex();
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
                Y(list);
                gz(i);
                this.asW.setAdapter(new b());
                this.asW.setCurrentItem(this.bri, true);
                if (this.brh != null) {
                    this.brh.gB(i);
                    this.brg = i;
                }
            }
        }
    }

    public void gA(int i) {
        int i2;
        if (this.asW != null) {
            int size = this.bre.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.bre.get(i3);
                    if (tVar == null || tVar.Ry() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.asW.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.brb != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Ro() != null) {
            String eo = aVar.Ro().Rr().eo(aVar.Rn() + i);
            this.bqV.setTag(eo);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atP = eo;
            this.bqV.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.bqW.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bqU.x = this.rect.left - ((this.bqU.width - linearLayout.getWidth()) / 2);
            this.bqU.y = (this.rect.top - this.bqU.height) + this.bqZ;
            this.bqV.setVisibility(0);
            if (!this.bra) {
                this.bC.addView(this.bqV, this.bqU);
                this.bra = true;
            } else {
                this.bC.updateViewLayout(this.bqV, this.bqU);
            }
            gridView.setSelection(i);
            if (this.brb != -1) {
                ((LinearLayout) gridView.getChildAt(this.brb - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.brb = i;
            this.bqS = gridView;
        }
    }

    private void Rl() {
        if (this.bra && this.bqV.getVisibility() != 8 && this.bqS != null) {
            this.bqS.setSelection(-1);
            this.bqV.setVisibility(8);
            if (this.brb != -1) {
                ((LinearLayout) this.bqS.getChildAt(this.brb - this.bqS.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.brb = -1;
            this.bqS = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.brj.set(x, y);
                break;
            case 1:
            case 3:
                Rl();
                break;
            case 2:
                this.brj.set(x, y);
                if (this.bra && this.bqV.getVisibility() != 8 && this.bqS != null) {
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
                this.brj.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Rl();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Rl();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bqS != null) {
                        offsetRectIntoDescendantCoords(this.bqS, this.rect);
                        int pointToPosition = this.bqS.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bqS);
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
        if (this.bra) {
            this.bC.removeView(this.bqV);
            this.bra = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bre != null) {
            int size = this.bre.size();
            if (i >= 0 && i < size) {
                this.brc = this.bre.get(i);
                if (this.asX != null && this.brc != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.asX.setVisibility(this.brc.Ru() > 1 ? 0 : 4);
                        this.asX.setCount(this.brc.Ru());
                        if (this.brc != null && this.brc.Ry() != this.brg) {
                            this.brg = this.brc.Ry();
                            if (this.brh != null) {
                                this.brh.gB(this.brc.Ry());
                            }
                        }
                    }
                    float Rv = this.brc.Rv() + f;
                    this.asX.setPosition(Rv);
                    this.bqT.setContentDescription(String.valueOf(String.format(getResources().getString(u.j.emotion_selection), Integer.valueOf(((int) Rv) + 1))) + String.format(getResources().getString(u.j.emotion_page), Integer.valueOf(this.brc.Ru())));
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
        this.aeK = i;
        av.d(this.bqV, u.f.bg_expression_bubble, i);
        av.e(this, u.d.common_color_10255, i);
        this.asX.setSelector(av.o(i, u.f.dot_pb_expression_s));
        this.asX.setDrawable(av.o(i, u.f.dot_pb_expression_n));
    }

    public void reset() {
        Rl();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t brm;

        public a(t tVar) {
            this.brm = tVar;
        }

        public int Rn() {
            if (this.brm == null) {
                return 0;
            }
            return this.brm.Rx();
        }

        public t Ro() {
            return this.brm;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.brm == null) {
                return 0;
            }
            return this.brm.Rw();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(u.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.brm.Rt() != 0) {
                    i2 = measuredWidth / this.brm.Rt();
                }
                if (this.brm.getRow() != 0) {
                    i3 = measuredHeight / this.brm.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bqZ * 2, EmotionTabContentView.this.bqZ * 2, EmotionTabContentView.this.bqZ * 2, EmotionTabContentView.this.bqZ * 2);
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
            if (this.brm != null) {
                int Rx = this.brm.Rx() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(u.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                av.d(tbImageView, u.f.btn_choose_face_selector, EmotionTabContentView.this.aeK);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eo = this.brm.Rr().eo(Rx);
                tbImageView.setTag(eo);
                Object a = com.baidu.adp.lib.g.c.dG().a(eo, 20, new j(this), 0, 0, null, null, eo, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(u.g.emotion_tab_content_tip);
                if (this.brm.Rs() == EmotionGroupType.BIG_EMOTION) {
                    String eo2 = this.brm.Rr().eo(Rx);
                    if (!TextUtils.isEmpty(eo2)) {
                        if (EmotionTabContentView.this.aeK == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(u.d.cp_cont_c);
                        } else {
                            color = av.getColor(u.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eo2.substring(eo2.lastIndexOf("_") + 1, eo2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eo.length() > 3) {
                    linearLayout3.setContentDescription(eo.substring(2, eo.length() - 1));
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
            if (EmotionTabContentView.this.bre == null) {
                return 0;
            }
            return EmotionTabContentView.this.bre.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.brk.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.brk.dE();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bre != null && i < EmotionTabContentView.this.bre.size()) {
                t tVar = (t) EmotionTabContentView.this.bre.get(i);
                gridView2.setNumColumns(tVar.Rt());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(u.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(u.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(u.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.bre != null) {
                int size = EmotionTabContentView.this.bre.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.bre.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.asX.setVisibility(tVar.Ru() > 1 ? 0 : 4);
                        EmotionTabContentView.this.asX.setCount(tVar.Ru());
                        EmotionTabContentView.this.asX.setPosition(tVar.Rv());
                        EmotionTabContentView.this.asX.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(u.j.emotion_selection), Integer.valueOf(tVar.Rv() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(u.j.emotion_page), Integer.valueOf(tVar.Ru())));
                    }
                    if (tVar != null && tVar.Ry() != EmotionTabContentView.this.brg) {
                        EmotionTabContentView.this.brg = tVar.Ry();
                        if (EmotionTabContentView.this.brh != null) {
                            EmotionTabContentView.this.brh.gB(tVar.Ry());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.brh = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
    }
}
