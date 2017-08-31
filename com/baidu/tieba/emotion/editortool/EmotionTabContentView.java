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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private i Jp;
    private CustomMessageListener SH;
    private IndicatorView aEa;
    private int apS;
    private b caa;
    private GridView cab;
    private LinearLayout cac;
    private WindowManager.LayoutParams cad;
    private GifView cae;
    private ViewGroup caf;
    private int cag;
    private int cah;
    private int cai;
    private boolean caj;
    private int cak;
    private d cal;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cam;
    private List<d> can;
    private int cao;
    private int cap;
    private c caq;
    private int car;
    private final Point cas;
    private com.baidu.adp.lib.e.b<GridView> cat;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void ig(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cak = -1;
        this.cao = 0;
        this.cap = -1;
        this.currentPosition = -1;
        this.cas = new Point();
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.cam));
                        if (EmotionTabContentView.this.caa != null) {
                            EmotionTabContentView.this.caa.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cap < 0 || EmotionTabContentView.this.cap >= EmotionTabContentView.this.cam.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cam.get(EmotionTabContentView.this.cap)).Dk() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caa != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.can.size()) {
                                    EmotionTabContentView.this.cal = (d) EmotionTabContentView.this.can.get(EmotionTabContentView.this.currentPosition);
                                    int acs = EmotionTabContentView.this.cal.acs();
                                    EmotionTabContentView.this.aEa.setCount(acs);
                                    EmotionTabContentView.this.aEa.setVisibility(acs > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.mViewPager == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.mViewPager.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.mViewPager.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.acm().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.can.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.can.get(index));
                                                        aVar.notifyDataSetChanged();
                                                    }
                                                }
                                            }
                                            i = i2 + 1;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.cak = -1;
        this.cao = 0;
        this.cap = -1;
        this.currentPosition = -1;
        this.cas = new Point();
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.cam));
                        if (EmotionTabContentView.this.caa != null) {
                            EmotionTabContentView.this.caa.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cap < 0 || EmotionTabContentView.this.cap >= EmotionTabContentView.this.cam.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cam.get(EmotionTabContentView.this.cap)).Dk() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caa != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.can.size()) {
                                    EmotionTabContentView.this.cal = (d) EmotionTabContentView.this.can.get(EmotionTabContentView.this.currentPosition);
                                    int acs = EmotionTabContentView.this.cal.acs();
                                    EmotionTabContentView.this.aEa.setCount(acs);
                                    EmotionTabContentView.this.aEa.setVisibility(acs > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.mViewPager == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.mViewPager.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.mViewPager.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.acm().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.can.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.can.get(index));
                                                        aVar.notifyDataSetChanged();
                                                    }
                                                }
                                            }
                                            i = i2 + 1;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                    default:
                        return;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cam = new ArrayList();
        this.can = new ArrayList();
        this.cat = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ack */
            public GridView fJ() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView o(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView p(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.cae = new GifView(context);
        aj.d(this.cae, d.g.bg_expression_bubble, this.apS);
        this.cae.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cad = new WindowManager.LayoutParams();
        this.cag = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.cah = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.cai = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.cad.width = this.cag;
        this.cad.height = this.cah;
        this.cad.gravity = 51;
        this.cad.format = -3;
        this.cad.type = 1000;
        this.cad.flags |= 56;
        this.caf = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEa = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.cac = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.cac.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cad.type = 1000;
            this.cad.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cam.clear();
        this.can.clear();
        if (list != null && !list.isEmpty()) {
            this.cam.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dn = cVar.Dn();
                    int i4 = emotionsCount / (cols * Dn);
                    if (emotionsCount % (cols * Dn) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Dn;
                        } else {
                            i = emotionsCount - ((cols * Dn) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.il(i3);
                        dVar.b(cVar.Dk());
                        dVar.eR(Dn);
                        dVar.eQ(cols);
                        dVar.ih(i4);
                        dVar.ii(i5);
                        dVar.ij(i);
                        dVar.ik(i5 * cols * Dn);
                        dVar.setEndIndex((i + i2) - 1);
                        this.can.add(dVar);
                    }
                }
            }
            this.cao = this.can.size();
            for (int i6 = 0; i6 < this.cao; i6++) {
                if (this.can != null && this.can.get(i6) != null) {
                    this.can.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void ie(int i) {
        if (this.can != null) {
            int size = this.can.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.can.get(i2);
                    if (dVar != null && dVar.acw() == i) {
                        this.car = dVar.getIndex();
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
                am(list);
                ie(i);
                this.caa = new b();
                this.mViewPager.setAdapter(this.caa);
                this.mViewPager.setCurrentItem(this.car, true);
                if (this.caq != null) {
                    this.caq.ig(i);
                    this.cap = i;
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m11if(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.can.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.can.get(i3);
                        if (dVar == null || dVar.acw() != i) {
                            i3++;
                        } else {
                            i2 = dVar.getIndex();
                            break;
                        }
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.cak != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.acm() != null) {
            d acm = aVar.acm();
            String eH = acm.acp().eH(aVar.acl() + i);
            if (acm.acq() != EmotionGroupType.USER_COLLECT || !eH.equals(com.baidu.tbadk.imageManager.d.aFK)) {
                this.cae.setTag(eH);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eH;
                if (eH.startsWith("#(meme,")) {
                    this.cae.setShowStaticDrawable(false);
                } else {
                    this.cae.setShowStaticDrawable(true);
                }
                this.cae.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.caf.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cad.x = this.rect.left - ((this.cad.width - linearLayout.getWidth()) / 2);
                this.cad.y = (this.rect.top - this.cad.height) + this.cai;
                this.cae.setVisibility(0);
                if (!this.caj) {
                    this.mWindowManager.addView(this.cae, this.cad);
                    this.caj = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cae, this.cad);
                }
                gridView.setSelection(i);
                if (this.cak != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cak - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cak = i;
                this.cab = gridView;
            }
        }
    }

    private void acj() {
        if (this.caj && this.cae.getVisibility() != 8 && this.cab != null) {
            this.cab.setSelection(-1);
            this.cae.setVisibility(8);
            if (this.cak != -1) {
                ((LinearLayout) this.cab.getChildAt(this.cak - this.cab.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cak = -1;
            this.cab = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cas.set(x, y);
                break;
            case 1:
            case 3:
                acj();
                break;
            case 2:
                this.cas.set(x, y);
                if (this.caj && this.cae.getVisibility() != 8 && this.cab != null) {
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
                this.cas.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                acj();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    acj();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cab != null) {
                        offsetRectIntoDescendantCoords(this.cab, this.rect);
                        int pointToPosition = this.cab.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cab);
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
        if (this.caj) {
            this.mWindowManager.removeView(this.cae);
            this.caj = false;
        }
        MessageManager.getInstance().unRegisterListener(this.SH);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.can != null) {
            int size = this.can.size();
            if (i >= 0 && i < size) {
                this.cal = this.can.get(i);
                if (this.aEa != null && this.cal != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEa.setVisibility(this.cal.acs() > 1 ? 0 : 4);
                        this.aEa.setCount(this.cal.acs());
                        if (this.cal != null && this.cal.acw() != this.cap) {
                            this.cap = this.cal.acw();
                            if (this.caq != null) {
                                this.caq.ig(this.cal.acw());
                            }
                        }
                    }
                    float act = this.cal.act() + f;
                    this.aEa.setPosition(act);
                    this.cac.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) act) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.cal.acs())));
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
        this.apS = i;
        aj.d(this.cae, d.g.bg_expression_bubble, i);
        aj.e(this, d.e.common_color_10255, i);
        this.aEa.setSelector(aj.u(i, d.g.dot_pb_expression_s));
        this.aEa.setDrawable(aj.u(i, d.g.dot_pb_expression_n));
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
        acj();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d cav;

        public a(d dVar) {
            this.cav = dVar;
        }

        public void a(d dVar) {
            this.cav = dVar;
        }

        public int acl() {
            if (this.cav == null) {
                return 0;
            }
            return this.cav.acv();
        }

        public d acm() {
            return this.cav;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cav == null) {
                return 0;
            }
            return this.cav.acu();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cav.acr() != 0) {
                    i2 = measuredWidth / this.cav.acr();
                }
                if (this.cav.getRow() != 0) {
                    i3 = measuredHeight / this.cav.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cai * 2, EmotionTabContentView.this.cai * 2, EmotionTabContentView.this.cai * 2, EmotionTabContentView.this.cai * 2);
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
            if (this.cav != null) {
                int acv = this.cav.acv() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.apS);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eH = this.cav.acp().eH(acv);
                tbImageView.setTag(eH);
                if (!TextUtils.isEmpty(eH)) {
                    Object a = com.baidu.adp.lib.f.c.fK().a(eH, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.a(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, eH, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.a.a) a;
                    }
                    if (aVar != null) {
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(d.h.emotion_tab_content_tip);
                if (this.cav.acq() == EmotionGroupType.BIG_EMOTION) {
                    String eH2 = this.cav.acp().eH(acv);
                    if (!TextUtils.isEmpty(eH2) && !eH2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.apS == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = aj.getColor(d.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eH2.substring(eH2.lastIndexOf("_") + 1, eH2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eH != null && eH.length() > 3) {
                    linearLayout3.setContentDescription(eH.substring(2, eH.length() - 1));
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
            if (EmotionTabContentView.this.can == null) {
                return 0;
            }
            return EmotionTabContentView.this.can.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cat.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cat.fI();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.can != null && i < EmotionTabContentView.this.can.size()) {
                d dVar = (d) EmotionTabContentView.this.can.get(i);
                gridView2.setNumColumns(dVar.acr());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.acm() == null) {
                            return false;
                        }
                        d acm = aVar.acm();
                        if (acm.acq() == EmotionGroupType.BIG_EMOTION || acm.acq() == EmotionGroupType.USER_COLLECT) {
                            EmotionTabContentView.this.a(i2, (GridView) adapterView);
                            return true;
                        }
                        return false;
                    }
                });
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        adapterView.setSelection(-1);
                        if (EmotionTabContentView.this.Jp != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.acm() != null) {
                                d acm = aVar.acm();
                                int acl = aVar.acl();
                                com.baidu.tbadk.editortools.emotiontool.c acp = acm.acp();
                                String eH = acm.acp().eH(acl + i2);
                                if (acp.Dk() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aFK.equals(eH)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eH);
                                lVar.a(acp.Dk());
                                lVar.eC(acp.getGroupName());
                                lVar.eD(acp.getGroupId());
                                lVar.setWidth(acp.getWidth());
                                lVar.setHeight(acp.getHeight());
                                EmotionTabContentView.this.Jp.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
                            }
                        }
                    }
                });
                gridView2.setAdapter((ListAdapter) new a(dVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.can != null) {
                int size = EmotionTabContentView.this.can.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.can.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEa.setVisibility(dVar.acs() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEa.setCount(dVar.acs());
                        EmotionTabContentView.this.aEa.setPosition(dVar.act());
                        EmotionTabContentView.this.aEa.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.act() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.acs())));
                    }
                    if (dVar != null && dVar.acw() != EmotionTabContentView.this.cap) {
                        EmotionTabContentView.this.cap = dVar.acw();
                        if (EmotionTabContentView.this.caq != null) {
                            EmotionTabContentView.this.caq.ig(dVar.acw());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.caq = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.Jp = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SH);
    }
}
