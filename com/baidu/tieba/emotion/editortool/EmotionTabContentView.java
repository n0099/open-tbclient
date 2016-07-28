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
    private com.baidu.tbadk.editortools.l Cw;
    private int afy;
    private ViewPager atL;
    private IndicatorView atM;
    private WindowManager bC;
    private GridView btg;
    private LinearLayout bth;
    private WindowManager.LayoutParams bti;
    private GifView btj;
    private ViewGroup btk;
    private int btl;
    private int btm;
    private int bto;
    private boolean btp;
    private int btq;
    private t btr;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bts;
    private List<t> btt;
    private int btu;
    private int btv;
    private c btw;
    private int btx;
    private final Point bty;
    private com.baidu.adp.lib.f.b<GridView> btz;
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
        this.btq = -1;
        this.btu = 0;
        this.btv = -1;
        this.currentPosition = -1;
        this.bty = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.btq = -1;
        this.btu = 0;
        this.btv = -1;
        this.currentPosition = -1;
        this.bty = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bts = new ArrayList();
        this.btt = new ArrayList();
        this.btz = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(u.h.emotion_tab_content, (ViewGroup) this, true);
        this.atL = (ViewPager) findViewById(u.g.face_tab_viewpager);
        this.atL.setFadingEdgeLength(0);
        this.atL.setOnPageChangeListener(this);
        this.btj = new GifView(context);
        av.d(this.btj, u.f.bg_expression_bubble, this.afy);
        this.btj.setVisibility(8);
        this.bC = (WindowManager) context.getSystemService("window");
        this.bti = new WindowManager.LayoutParams();
        this.btl = context.getResources().getDimensionPixelSize(u.e.ds240);
        this.btm = context.getResources().getDimensionPixelSize(u.e.ds252);
        this.bto = context.getResources().getDimensionPixelSize(u.e.ds10);
        this.bti.width = this.btl;
        this.bti.height = this.btm;
        this.bti.gravity = 51;
        this.bti.format = -3;
        this.bti.type = 1000;
        this.bti.flags |= 56;
        this.btk = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.atM = (IndicatorView) findViewById(u.g.face_tab_indicator);
        this.bth = (LinearLayout) findViewById(u.g.face_tab_indicator_layout);
        this.bth.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bti.type = 1000;
            this.bti.flags = 25165832;
        }
    }

    private void ad(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bts.clear();
        this.btt.clear();
        if (list != null && !list.isEmpty()) {
            this.bts.addAll(list);
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
                        this.btt.add(tVar);
                    }
                }
            }
            this.btu = this.btt.size();
            for (int i6 = 0; i6 < this.btu; i6++) {
                if (this.btt != null && this.btt.get(i6) != null) {
                    this.btt.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void gz(int i) {
        if (this.btt != null) {
            int size = this.btt.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.btt.get(i2);
                    if (tVar != null && tVar.Sf() == i) {
                        this.btx = tVar.getIndex();
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
                ad(list);
                gz(i);
                this.atL.setAdapter(new b());
                this.atL.setCurrentItem(this.btx, true);
                if (this.btw != null) {
                    this.btw.gB(i);
                    this.btv = i;
                }
            }
        }
    }

    public void gA(int i) {
        int i2;
        if (this.atL != null) {
            int size = this.btt.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.btt.get(i3);
                    if (tVar == null || tVar.Sf() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.atL.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.btq != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.RV() != null) {
            String eo = aVar.RV().RY().eo(aVar.RU() + i);
            this.btj.setTag(eo);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.auE = eo;
            this.btj.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.btk.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.bti.x = this.rect.left - ((this.bti.width - linearLayout.getWidth()) / 2);
            this.bti.y = (this.rect.top - this.bti.height) + this.bto;
            this.btj.setVisibility(0);
            if (!this.btp) {
                this.bC.addView(this.btj, this.bti);
                this.btp = true;
            } else {
                this.bC.updateViewLayout(this.btj, this.bti);
            }
            gridView.setSelection(i);
            if (this.btq != -1) {
                ((LinearLayout) gridView.getChildAt(this.btq - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.btq = i;
            this.btg = gridView;
        }
    }

    private void RS() {
        if (this.btp && this.btj.getVisibility() != 8 && this.btg != null) {
            this.btg.setSelection(-1);
            this.btj.setVisibility(8);
            if (this.btq != -1) {
                ((LinearLayout) this.btg.getChildAt(this.btq - this.btg.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.btq = -1;
            this.btg = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bty.set(x, y);
                break;
            case 1:
            case 3:
                RS();
                break;
            case 2:
                this.bty.set(x, y);
                if (this.btp && this.btj.getVisibility() != 8 && this.btg != null) {
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
                this.bty.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                RS();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    RS();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.btg != null) {
                        offsetRectIntoDescendantCoords(this.btg, this.rect);
                        int pointToPosition = this.btg.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.btg);
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
        if (this.btp) {
            this.bC.removeView(this.btj);
            this.btp = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.btt != null) {
            int size = this.btt.size();
            if (i >= 0 && i < size) {
                this.btr = this.btt.get(i);
                if (this.atM != null && this.btr != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.atM.setVisibility(this.btr.Sb() > 1 ? 0 : 4);
                        this.atM.setCount(this.btr.Sb());
                        if (this.btr != null && this.btr.Sf() != this.btv) {
                            this.btv = this.btr.Sf();
                            if (this.btw != null) {
                                this.btw.gB(this.btr.Sf());
                            }
                        }
                    }
                    float Sc = this.btr.Sc() + f;
                    this.atM.setPosition(Sc);
                    this.bth.setContentDescription(String.valueOf(String.format(getResources().getString(u.j.emotion_selection), Integer.valueOf(((int) Sc) + 1))) + String.format(getResources().getString(u.j.emotion_page), Integer.valueOf(this.btr.Sb())));
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
        this.afy = i;
        av.d(this.btj, u.f.bg_expression_bubble, i);
        av.e(this, u.d.common_color_10255, i);
        this.atM.setSelector(av.o(i, u.f.dot_pb_expression_s));
        this.atM.setDrawable(av.o(i, u.f.dot_pb_expression_n));
    }

    public void reset() {
        RS();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t btB;

        public a(t tVar) {
            this.btB = tVar;
        }

        public int RU() {
            if (this.btB == null) {
                return 0;
            }
            return this.btB.Se();
        }

        public t RV() {
            return this.btB;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.btB == null) {
                return 0;
            }
            return this.btB.Sd();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m10getInst().getContext()).inflate(u.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.btB.Sa() != 0) {
                    i2 = measuredWidth / this.btB.Sa();
                }
                if (this.btB.getRow() != 0) {
                    i3 = measuredHeight / this.btB.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bto * 2, EmotionTabContentView.this.bto * 2, EmotionTabContentView.this.bto * 2, EmotionTabContentView.this.bto * 2);
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
            if (this.btB != null) {
                int Se = this.btB.Se() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(u.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                av.d(tbImageView, u.f.btn_choose_face_selector, EmotionTabContentView.this.afy);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eo = this.btB.RY().eo(Se);
                tbImageView.setTag(eo);
                Object a = com.baidu.adp.lib.g.c.dF().a(eo, 20, new j(this), 0, 0, null, null, eo, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.e(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(u.g.emotion_tab_content_tip);
                if (this.btB.RZ() == EmotionGroupType.BIG_EMOTION) {
                    String eo2 = this.btB.RY().eo(Se);
                    if (!TextUtils.isEmpty(eo2)) {
                        if (EmotionTabContentView.this.afy == 0) {
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
            if (EmotionTabContentView.this.btt == null) {
                return 0;
            }
            return EmotionTabContentView.this.btt.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.btz.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.btz.dD();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.btt != null && i < EmotionTabContentView.this.btt.size()) {
                t tVar = (t) EmotionTabContentView.this.btt.get(i);
                gridView2.setNumColumns(tVar.Sa());
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
            if (EmotionTabContentView.this.btt != null) {
                int size = EmotionTabContentView.this.btt.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.btt.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.atM.setVisibility(tVar.Sb() > 1 ? 0 : 4);
                        EmotionTabContentView.this.atM.setCount(tVar.Sb());
                        EmotionTabContentView.this.atM.setPosition(tVar.Sc());
                        EmotionTabContentView.this.atM.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(u.j.emotion_selection), Integer.valueOf(tVar.Sc() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(u.j.emotion_page), Integer.valueOf(tVar.Sb())));
                    }
                    if (tVar != null && tVar.Sf() != EmotionTabContentView.this.btv) {
                        EmotionTabContentView.this.btv = tVar.Sf();
                        if (EmotionTabContentView.this.btw != null) {
                            EmotionTabContentView.this.btw.gB(tVar.Sf());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.btw = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.Cw = lVar;
    }
}
