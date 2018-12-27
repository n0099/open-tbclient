package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private EditorTools Ta;
    private int aGb;
    private int aLH;
    private IndicatorView aLN;
    private CustomMessageListener aof;
    private EmotionViewPagerAdapter dpc;
    private GridView dpd;
    private LinearLayout dpe;
    private WindowManager.LayoutParams dpf;
    private GifView dpg;
    private ViewGroup dph;
    private int dpi;
    private int dpj;
    private int dpk;
    private boolean dpl;
    private int dpm;
    private com.baidu.tieba.emotion.editortool.b dpn;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dpo;
    private List<com.baidu.tieba.emotion.editortool.b> dpp;
    private int dpq;
    private int dpr;
    private b dps;
    private int dpt;
    private final Point dpu;
    private com.baidu.adp.lib.e.b<GridView> dpv;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes5.dex */
    public interface b {
        void ls(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dpm = -1;
        this.dpq = 0;
        this.dpr = -1;
        this.aGb = -1;
        this.dpu = new Point();
        this.aof = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bd(new ArrayList(EmotionTabContentView.this.dpo));
                        if (EmotionTabContentView.this.dpc != null) {
                            EmotionTabContentView.this.dpc.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dpr < 0 || EmotionTabContentView.this.dpr >= EmotionTabContentView.this.dpo.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dpo.get(EmotionTabContentView.this.dpr)).Mn() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dpc != null) {
                                if (EmotionTabContentView.this.aGb >= 0 && EmotionTabContentView.this.aGb < EmotionTabContentView.this.dpp.size()) {
                                    EmotionTabContentView.this.dpn = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dpp.get(EmotionTabContentView.this.aGb);
                                    int avr = EmotionTabContentView.this.dpn.avr();
                                    EmotionTabContentView.this.aLN.setCount(avr);
                                    EmotionTabContentView.this.aLN.setVisibility(avr > 1 ? 0 : 4);
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
                                                    int index = aVar.avl().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dpp.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dpp.get(index));
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
        this.dpm = -1;
        this.dpq = 0;
        this.dpr = -1;
        this.aGb = -1;
        this.dpu = new Point();
        this.aof = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bd(new ArrayList(EmotionTabContentView.this.dpo));
                        if (EmotionTabContentView.this.dpc != null) {
                            EmotionTabContentView.this.dpc.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dpr < 0 || EmotionTabContentView.this.dpr >= EmotionTabContentView.this.dpo.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dpo.get(EmotionTabContentView.this.dpr)).Mn() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dpc != null) {
                                if (EmotionTabContentView.this.aGb >= 0 && EmotionTabContentView.this.aGb < EmotionTabContentView.this.dpp.size()) {
                                    EmotionTabContentView.this.dpn = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dpp.get(EmotionTabContentView.this.aGb);
                                    int avr = EmotionTabContentView.this.dpn.avr();
                                    EmotionTabContentView.this.aLN.setCount(avr);
                                    EmotionTabContentView.this.aLN.setVisibility(avr > 1 ? 0 : 4);
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
                                                    int index = aVar.avl().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dpp.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dpp.get(index));
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
        this.dpo = new ArrayList();
        this.dpp = new ArrayList();
        this.dpv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avj */
            public GridView jz() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public GridView v(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public GridView w(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(e.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(e.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.dpg = new GifView(context);
        al.d(this.dpg, e.f.bg_expression_bubble, this.aLH);
        this.dpg.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.dpf = new WindowManager.LayoutParams();
        this.dpi = context.getResources().getDimensionPixelSize(e.C0210e.ds240);
        this.dpj = context.getResources().getDimensionPixelSize(e.C0210e.ds252);
        this.dpk = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.dpf.width = this.dpi;
        this.dpf.height = this.dpj;
        this.dpf.gravity = 51;
        this.dpf.format = -3;
        this.dpf.type = 1000;
        this.dpf.flags |= 56;
        this.dph = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aLN = (IndicatorView) findViewById(e.g.face_tab_indicator);
        this.dpe = (LinearLayout) findViewById(e.g.face_tab_indicator_layout);
        this.dpe.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dpf.type = 1000;
            this.dpf.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dpo.clear();
        this.dpp.clear();
        if (list != null && !list.isEmpty()) {
            this.dpo.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Mq = cVar.Mq();
                    int Mr = cVar.Mr();
                    int i4 = emotionsCount / (Mq * Mr);
                    if (emotionsCount % (Mq * Mr) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = Mq * Mr;
                        } else {
                            i = emotionsCount - ((Mq * Mr) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.lx(i3);
                        bVar.b(cVar.Mn());
                        bVar.fV(Mr);
                        bVar.fU(Mq);
                        bVar.lt(i4);
                        bVar.lu(i5);
                        bVar.lv(i);
                        bVar.lw(i5 * Mq * Mr);
                        bVar.setEndIndex((i + i2) - 1);
                        this.dpp.add(bVar);
                    }
                }
            }
            this.dpq = this.dpp.size();
            for (int i6 = 0; i6 < this.dpq; i6++) {
                if (this.dpp != null && this.dpp.get(i6) != null) {
                    this.dpp.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void lq(int i) {
        if (this.dpp != null) {
            int size = this.dpp.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.dpp.get(i2);
                    if (bVar != null && bVar.avv() == i) {
                        this.dpt = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void j(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                bd(list);
                lq(i);
                this.dpc = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.dpc);
                this.mViewPager.setCurrentItem(this.dpt, true);
                if (this.dps != null) {
                    this.dps.ls(i);
                    this.dpr = i;
                }
            }
        }
    }

    public void lr(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.dpp.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.dpp.get(i3);
                        if (bVar == null || bVar.avv() != i) {
                            i3++;
                        } else {
                            i2 = bVar.getIndex();
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
        if (this.dpm != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.avl() != null) {
            com.baidu.tieba.emotion.editortool.b avl = aVar.avl();
            String fO = avl.avo().fO(aVar.avk() + i);
            if (avl.avp() != EmotionGroupType.USER_COLLECT || !fO.equals(com.baidu.tbadk.imageManager.d.bcv)) {
                this.dpg.setTag(fO);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = fO;
                if (fO.startsWith("#(meme,")) {
                    this.dpg.setShowStaticDrawable(false);
                } else {
                    this.dpg.setShowStaticDrawable(true);
                }
                this.dpg.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dph.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dpf.x = this.rect.left - ((this.dpf.width - linearLayout.getWidth()) / 2);
                this.dpf.y = (this.rect.top - this.dpf.height) + this.dpk;
                this.dpg.setVisibility(0);
                if (!this.dpl) {
                    this.mWindowManager.addView(this.dpg, this.dpf);
                    this.dpl = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dpg, this.dpf);
                }
                gridView.setSelection(i);
                if (this.dpm != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dpm - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dpm = i;
                this.dpd = gridView;
            }
        }
    }

    private void onUp() {
        if (this.dpl && this.dpg.getVisibility() != 8 && this.dpd != null) {
            this.dpd.setSelection(-1);
            this.dpg.setVisibility(8);
            if (this.dpm != -1) {
                ((LinearLayout) this.dpd.getChildAt(this.dpm - this.dpd.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dpm = -1;
            this.dpd = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dpu.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.dpu.set(x, y);
                if (this.dpl && this.dpg.getVisibility() != 8 && this.dpd != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dpu.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.dpd != null) {
                        offsetRectIntoDescendantCoords(this.dpd, this.rect);
                        int pointToPosition = this.dpd.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dpd);
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
        if (this.dpl) {
            this.mWindowManager.removeView(this.dpg);
            this.dpl = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aof);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dpp != null) {
            int size = this.dpp.size();
            if (i >= 0 && i < size) {
                this.dpn = this.dpp.get(i);
                if (this.aLN != null && this.dpn != null) {
                    if (this.aGb != i) {
                        this.aGb = i;
                        this.aLN.setVisibility(this.dpn.avr() > 1 ? 0 : 4);
                        this.aLN.setCount(this.dpn.avr());
                        if (this.dpn != null && this.dpn.avv() != this.dpr) {
                            this.dpr = this.dpn.avv();
                            if (this.dps != null) {
                                this.dps.ls(this.dpn.avv());
                            }
                        }
                    }
                    float avs = this.dpn.avs() + f;
                    this.aLN.setPosition(avs);
                    this.dpe.setContentDescription(String.format(getResources().getString(e.j.emotion_selection), Integer.valueOf(((int) avs) + 1)) + String.format(getResources().getString(e.j.emotion_page), Integer.valueOf(this.dpn.avr())));
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
        this.aLH = i;
        al.d(this.dpg, e.f.bg_expression_bubble, i);
        al.e(this, e.d.cp_bg_line_d, i);
        this.aLN.setSelector(al.y(i, e.f.dot_pb_expression_s));
        this.aLN.setDrawable(al.y(i, e.f.dot_pb_expression_n));
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
        onUp();
    }

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b dpx;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dpx = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dpx = bVar;
        }

        public int avk() {
            if (this.dpx == null) {
                return 0;
            }
            return this.dpx.avu();
        }

        public com.baidu.tieba.emotion.editortool.b avl() {
            return this.dpx;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dpx == null) {
                return 0;
            }
            return this.dpx.avt();
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
            com.baidu.adp.widget.ImageView.a aVar;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.dpx.avq() != 0) {
                    i2 = measuredWidth / this.dpx.avq();
                }
                if (this.dpx.getRow() != 0) {
                    i3 = measuredHeight / this.dpx.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dpk * 2, EmotionTabContentView.this.dpk * 2, EmotionTabContentView.this.dpk * 2, EmotionTabContentView.this.dpk * 2);
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
            if (this.dpx != null) {
                int avu = this.dpx.avu() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(e.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, e.f.btn_choose_face_selector, EmotionTabContentView.this.aLH);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String fO = this.dpx.avo().fO(avu);
                tbImageView.setTag(fO);
                if (!TextUtils.isEmpty(fO)) {
                    Object a = com.baidu.adp.lib.f.c.jA().a(fO, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.a(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, fO, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.ImageView.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.ImageView.a) a;
                    }
                    if (aVar != null) {
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(e.g.emotion_tab_content_tip);
                if (this.dpx.avp() == EmotionGroupType.BIG_EMOTION) {
                    String fO2 = this.dpx.avo().fO(avu);
                    if (!TextUtils.isEmpty(fO2) && !fO2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aLH == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(e.d.cp_cont_c);
                        } else {
                            color = al.getColor(e.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(fO2.substring(fO2.lastIndexOf(BaseRequestAction.SPLITE) + 1, fO2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (fO != null && fO.length() > 3) {
                    linearLayout3.setContentDescription(fO.substring(2, fO.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes5.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.dpp == null) {
                return 0;
            }
            return EmotionTabContentView.this.dpp.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dpv.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dpv.jy();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dpp != null && i < EmotionTabContentView.this.dpp.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dpp.get(i);
                gridView2.setNumColumns(bVar.avq());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(e.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.avl() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b avl = aVar.avl();
                        if (avl.avp() == EmotionGroupType.BIG_EMOTION || avl.avp() == EmotionGroupType.USER_COLLECT) {
                            EmotionTabContentView.this.a(i2, (GridView) adapterView);
                            return true;
                        }
                        return false;
                    }
                });
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        adapterView.setSelection(-1);
                        if (EmotionTabContentView.this.Ta != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.avl() != null) {
                                com.baidu.tieba.emotion.editortool.b avl = aVar.avl();
                                int avk = aVar.avk();
                                com.baidu.tbadk.editortools.emotiontool.c avo = avl.avo();
                                String fO = avl.avo().fO(avk + i2);
                                if (avo.Mn() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.bcv.equals(fO)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(fO);
                                pVar.a(avo.Mn());
                                pVar.gE(avo.getGroupName());
                                pVar.setPid(avo.getGroupId());
                                pVar.setWidth(avo.getWidth());
                                pVar.setHeight(avo.getHeight());
                                EmotionTabContentView.this.Ta.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
                            }
                        }
                    }
                });
                gridView2.setAdapter((ListAdapter) new a(bVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.dpp != null) {
                int size = EmotionTabContentView.this.dpp.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aGb) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dpp.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aGb = i;
                        EmotionTabContentView.this.aLN.setVisibility(bVar.avr() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aLN.setCount(bVar.avr());
                        EmotionTabContentView.this.aLN.setPosition(bVar.avs());
                        EmotionTabContentView.this.aLN.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_selection), Integer.valueOf(bVar.avs() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_page), Integer.valueOf(bVar.avr())));
                    }
                    if (bVar != null && bVar.avv() != EmotionTabContentView.this.dpr) {
                        EmotionTabContentView.this.dpr = bVar.avv();
                        if (EmotionTabContentView.this.dps != null) {
                            EmotionTabContentView.this.dps.ls(bVar.avv());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.dps = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aof);
    }
}
