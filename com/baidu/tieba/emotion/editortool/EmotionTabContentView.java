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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
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
    private com.baidu.tbadk.editortools.j JT;
    private CustomMessageListener RR;
    private IndicatorView aCq;
    private int aoa;
    private b bQX;
    private GridView bQY;
    private LinearLayout bQZ;
    private WindowManager.LayoutParams bRa;
    private GifView bRb;
    private ViewGroup bRc;
    private int bRd;
    private int bRe;
    private int bRf;
    private boolean bRg;
    private int bRh;
    private w bRi;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bRj;
    private List<w> bRk;
    private int bRl;
    private int bRm;
    private c bRn;
    private int bRo;
    private final Point bRp;
    private com.baidu.adp.lib.e.b<GridView> bRq;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hN(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bRh = -1;
        this.bRl = 0;
        this.bRm = -1;
        this.currentPosition = -1;
        this.bRp = new Point();
        this.RR = new j(this, CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE);
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.bRh = -1;
        this.bRl = 0;
        this.bRm = -1;
        this.currentPosition = -1;
        this.bRp = new Point();
        this.RR = new j(this, CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bRj = new ArrayList();
        this.bRk = new ArrayList();
        this.bRq = new com.baidu.adp.lib.e.b<>(new k(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(w.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(w.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bRb = new GifView(context);
        as.d(this.bRb, w.g.bg_expression_bubble, this.aoa);
        this.bRb.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bRa = new WindowManager.LayoutParams();
        this.bRd = context.getResources().getDimensionPixelSize(w.f.ds240);
        this.bRe = context.getResources().getDimensionPixelSize(w.f.ds252);
        this.bRf = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.bRa.width = this.bRd;
        this.bRa.height = this.bRe;
        this.bRa.gravity = 51;
        this.bRa.format = -3;
        this.bRa.type = 1000;
        this.bRa.flags |= 56;
        this.bRc = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aCq = (IndicatorView) findViewById(w.h.face_tab_indicator);
        this.bQZ = (LinearLayout) findViewById(w.h.face_tab_indicator_layout);
        this.bQZ.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bRa.type = 1000;
            this.bRa.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bRj.clear();
        this.bRk.clear();
        if (list != null && !list.isEmpty()) {
            this.bRj.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CY = cVar.CY();
                    int i4 = emotionsCount / (cols * CY);
                    if (emotionsCount % (cols * CY) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        w wVar = new w();
                        if (i5 < i4 - 1) {
                            i = cols * CY;
                        } else {
                            i = emotionsCount - ((cols * CY) * (i4 - 1));
                        }
                        wVar.e(cVar);
                        wVar.hS(i3);
                        wVar.b(cVar.CV());
                        wVar.eN(CY);
                        wVar.eM(cols);
                        wVar.hO(i4);
                        wVar.hP(i5);
                        wVar.hQ(i);
                        wVar.hR(i5 * cols * CY);
                        wVar.setEndIndex((i + i2) - 1);
                        this.bRk.add(wVar);
                    }
                }
            }
            this.bRl = this.bRk.size();
            for (int i6 = 0; i6 < this.bRl; i6++) {
                if (this.bRk != null && this.bRk.get(i6) != null) {
                    this.bRk.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hL(int i) {
        if (this.bRk != null) {
            int size = this.bRk.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    w wVar = this.bRk.get(i2);
                    if (wVar != null && wVar.aak() == i) {
                        this.bRo = wVar.getIndex();
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
                ag(list);
                hL(i);
                this.bQX = new b();
                this.mViewPager.setAdapter(this.bQX);
                this.mViewPager.setCurrentItem(this.bRo, true);
                if (this.bRn != null) {
                    this.bRn.hN(i);
                    this.bRm = i;
                }
            }
        }
    }

    public void hM(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bRk.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    w wVar = this.bRk.get(i3);
                    if (wVar == null || wVar.aak() != i) {
                        i3++;
                    } else {
                        i2 = wVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bRh != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aaa() != null) {
            w aaa = aVar.aaa();
            String eD = aaa.aad().eD(aVar.ZZ() + i);
            if (aaa.aae() != EmotionGroupType.USER_COLLECT || !eD.equals(com.baidu.tbadk.imageManager.f.aDU)) {
                this.bRb.setTag(eD);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eD;
                if (eD.startsWith("#(meme,")) {
                    this.bRb.setShowStaticDrawable(false);
                } else {
                    this.bRb.setShowStaticDrawable(true);
                }
                this.bRb.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.bRc.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.bRa.x = this.rect.left - ((this.bRa.width - linearLayout.getWidth()) / 2);
                this.bRa.y = (this.rect.top - this.bRa.height) + this.bRf;
                this.bRb.setVisibility(0);
                if (!this.bRg) {
                    this.jn.addView(this.bRb, this.bRa);
                    this.bRg = true;
                } else {
                    this.jn.updateViewLayout(this.bRb, this.bRa);
                }
                gridView.setSelection(i);
                if (this.bRh != -1) {
                    ((LinearLayout) gridView.getChildAt(this.bRh - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.bRh = i;
                this.bQY = gridView;
            }
        }
    }

    private void ZX() {
        if (this.bRg && this.bRb.getVisibility() != 8 && this.bQY != null) {
            this.bQY.setSelection(-1);
            this.bRb.setVisibility(8);
            if (this.bRh != -1) {
                ((LinearLayout) this.bQY.getChildAt(this.bRh - this.bQY.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bRh = -1;
            this.bQY = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bRp.set(x, y);
                break;
            case 1:
            case 3:
                ZX();
                break;
            case 2:
                this.bRp.set(x, y);
                if (this.bRg && this.bRb.getVisibility() != 8 && this.bQY != null) {
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
                this.bRp.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                ZX();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    ZX();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bQY != null) {
                        offsetRectIntoDescendantCoords(this.bQY, this.rect);
                        int pointToPosition = this.bQY.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bQY);
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
        if (this.bRg) {
            this.jn.removeView(this.bRb);
            this.bRg = false;
        }
        MessageManager.getInstance().unRegisterListener(this.RR);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bRk != null) {
            int size = this.bRk.size();
            if (i >= 0 && i < size) {
                this.bRi = this.bRk.get(i);
                if (this.aCq != null && this.bRi != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aCq.setVisibility(this.bRi.aag() > 1 ? 0 : 4);
                        this.aCq.setCount(this.bRi.aag());
                        if (this.bRi != null && this.bRi.aak() != this.bRm) {
                            this.bRm = this.bRi.aak();
                            if (this.bRn != null) {
                                this.bRn.hN(this.bRi.aak());
                            }
                        }
                    }
                    float aah = this.bRi.aah() + f;
                    this.aCq.setPosition(aah);
                    this.bQZ.setContentDescription(String.valueOf(String.format(getResources().getString(w.l.emotion_selection), Integer.valueOf(((int) aah) + 1))) + String.format(getResources().getString(w.l.emotion_page), Integer.valueOf(this.bRi.aag())));
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
        this.aoa = i;
        as.d(this.bRb, w.g.bg_expression_bubble, i);
        as.e(this, w.e.common_color_10255, i);
        this.aCq.setSelector(as.u(i, w.g.dot_pb_expression_s));
        this.aCq.setDrawable(as.u(i, w.g.dot_pb_expression_n));
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
        ZX();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private w bRs;

        public a(w wVar) {
            this.bRs = wVar;
        }

        public void a(w wVar) {
            this.bRs = wVar;
        }

        public int ZZ() {
            if (this.bRs == null) {
                return 0;
            }
            return this.bRs.aaj();
        }

        public w aaa() {
            return this.bRs;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bRs == null) {
                return 0;
            }
            return this.bRs.aai();
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
            int color;
            com.baidu.adp.widget.a.a aVar;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m9getInst().getContext()).inflate(w.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.bRs.aaf() != 0) {
                    i2 = measuredWidth / this.bRs.aaf();
                }
                if (this.bRs.getRow() != 0) {
                    i3 = measuredHeight / this.bRs.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bRf * 2, EmotionTabContentView.this.bRf * 2, EmotionTabContentView.this.bRf * 2, EmotionTabContentView.this.bRf * 2);
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
            if (this.bRs != null) {
                int aaj = this.bRs.aaj() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(w.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                as.d(tbImageView, w.g.btn_choose_face_selector, EmotionTabContentView.this.aoa);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eD = this.bRs.aad().eD(aaj);
                tbImageView.setTag(eD);
                if (!TextUtils.isEmpty(eD)) {
                    Object a = com.baidu.adp.lib.f.c.fL().a(eD, 20, new l(this), 0, 0, null, null, eD, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.a.a) a;
                    }
                    if (aVar != null) {
                        aVar.e(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(w.h.emotion_tab_content_tip);
                if (this.bRs.aae() == EmotionGroupType.BIG_EMOTION) {
                    String eD2 = this.bRs.aad().eD(aaj);
                    if (!TextUtils.isEmpty(eD2) && !eD2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aoa == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(w.e.cp_cont_c);
                        } else {
                            color = as.getColor(w.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eD2.substring(eD2.lastIndexOf("_") + 1, eD2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eD != null && eD.length() > 3) {
                    linearLayout3.setContentDescription(eD.substring(2, eD.length() - 1));
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
            if (EmotionTabContentView.this.bRk == null) {
                return 0;
            }
            return EmotionTabContentView.this.bRk.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bRq.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bRq.fJ();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bRk != null && i < EmotionTabContentView.this.bRk.size()) {
                w wVar = (w) EmotionTabContentView.this.bRk.get(i);
                gridView2.setNumColumns(wVar.aaf());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(w.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(w.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(w.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new m(this));
                gridView2.setOnItemClickListener(new n(this));
                gridView2.setAdapter((ListAdapter) new a(wVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.bRk != null) {
                int size = EmotionTabContentView.this.bRk.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    w wVar = (w) EmotionTabContentView.this.bRk.get(i);
                    if (wVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aCq.setVisibility(wVar.aag() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aCq.setCount(wVar.aag());
                        EmotionTabContentView.this.aCq.setPosition(wVar.aah());
                        EmotionTabContentView.this.aCq.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_selection), Integer.valueOf(wVar.aah() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(w.l.emotion_page), Integer.valueOf(wVar.aag())));
                    }
                    if (wVar != null && wVar.aak() != EmotionTabContentView.this.bRm) {
                        EmotionTabContentView.this.bRm = wVar.aak();
                        if (EmotionTabContentView.this.bRn != null) {
                            EmotionTabContentView.this.bRn.hN(wVar.aak());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bRn = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.j jVar) {
        this.JT = jVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.RR);
    }
}
