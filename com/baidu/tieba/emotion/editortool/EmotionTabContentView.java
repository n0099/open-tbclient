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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
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
    private CustomMessageListener aIh;
    private i axO;
    private int bdE;
    private IndicatorView bsv;
    private int currentPosition;
    private b dfR;
    private GridView dfS;
    private LinearLayout dfT;
    private WindowManager.LayoutParams dfU;
    private GifView dfV;
    private ViewGroup dfW;
    private int dfX;
    private int dfY;
    private int dfZ;
    private boolean dga;
    private int dgb;
    private d dgc;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dgd;
    private List<d> dge;
    private int dgf;
    private int dgg;
    private c dgh;
    private int dgi;
    private final Point dgj;
    private com.baidu.adp.lib.e.b<GridView> dgk;
    private Context mContext;
    private WindowManager mWindowManager;
    private ViewPager qW;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void me(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dgb = -1;
        this.dgf = 0;
        this.dgg = -1;
        this.currentPosition = -1;
        this.dgj = new Point();
        this.aIh = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.aK(new ArrayList(EmotionTabContentView.this.dgd));
                        if (EmotionTabContentView.this.dfR != null) {
                            EmotionTabContentView.this.dfR.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dgg < 0 || EmotionTabContentView.this.dgg >= EmotionTabContentView.this.dgd.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dgd.get(EmotionTabContentView.this.dgg)).KU() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dfR != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dge.size()) {
                                    EmotionTabContentView.this.dgc = (d) EmotionTabContentView.this.dge.get(EmotionTabContentView.this.currentPosition);
                                    int aob = EmotionTabContentView.this.dgc.aob();
                                    EmotionTabContentView.this.bsv.setCount(aob);
                                    EmotionTabContentView.this.bsv.setVisibility(aob > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.qW == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.qW.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.qW.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.anV().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dge.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dge.get(index));
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
        this.dgb = -1;
        this.dgf = 0;
        this.dgg = -1;
        this.currentPosition = -1;
        this.dgj = new Point();
        this.aIh = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.aK(new ArrayList(EmotionTabContentView.this.dgd));
                        if (EmotionTabContentView.this.dfR != null) {
                            EmotionTabContentView.this.dfR.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dgg < 0 || EmotionTabContentView.this.dgg >= EmotionTabContentView.this.dgd.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dgd.get(EmotionTabContentView.this.dgg)).KU() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dfR != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dge.size()) {
                                    EmotionTabContentView.this.dgc = (d) EmotionTabContentView.this.dge.get(EmotionTabContentView.this.currentPosition);
                                    int aob = EmotionTabContentView.this.dgc.aob();
                                    EmotionTabContentView.this.bsv.setCount(aob);
                                    EmotionTabContentView.this.bsv.setVisibility(aob > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.qW == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.qW.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.qW.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.anV().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dge.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dge.get(index));
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
        this.dgd = new ArrayList();
        this.dge = new ArrayList();
        this.dgk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anT */
            public GridView nk() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView at(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView au(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.emotion_tab_content, (ViewGroup) this, true);
        this.qW = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.qW.setFadingEdgeLength(0);
        this.qW.setOnPageChangeListener(this);
        this.dfV = new GifView(context);
        aj.f(this.dfV, d.f.bg_expression_bubble, this.bdE);
        this.dfV.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dfU = new WindowManager.LayoutParams();
        this.dfX = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.dfY = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.dfZ = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.dfU.width = this.dfX;
        this.dfU.height = this.dfY;
        this.dfU.gravity = 51;
        this.dfU.format = -3;
        this.dfU.type = 1000;
        this.dfU.flags |= 56;
        this.dfW = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.bsv = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.dfT = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.dfT.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dfU.type = 1000;
            this.dfU.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dgd.clear();
        this.dge.clear();
        if (list != null && !list.isEmpty()) {
            this.dgd.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int KX = cVar.KX();
                    int i4 = emotionsCount / (cols * KX);
                    if (emotionsCount % (cols * KX) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * KX;
                        } else {
                            i = emotionsCount - ((cols * KX) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.mj(i3);
                        dVar.b(cVar.KU());
                        dVar.hY(KX);
                        dVar.hX(cols);
                        dVar.mf(i4);
                        dVar.mg(i5);
                        dVar.mh(i);
                        dVar.mi(i5 * cols * KX);
                        dVar.setEndIndex((i + i2) - 1);
                        this.dge.add(dVar);
                    }
                }
            }
            this.dgf = this.dge.size();
            for (int i6 = 0; i6 < this.dgf; i6++) {
                if (this.dge != null && this.dge.get(i6) != null) {
                    this.dge.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void mc(int i) {
        if (this.dge != null) {
            int size = this.dge.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.dge.get(i2);
                    if (dVar != null && dVar.aof() == i) {
                        this.dgi = dVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void l(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                aK(list);
                mc(i);
                this.dfR = new b();
                this.qW.setAdapter(this.dfR);
                this.qW.setCurrentItem(this.dgi, true);
                if (this.dgh != null) {
                    this.dgh.me(i);
                    this.dgg = i;
                }
            }
        }
    }

    public void md(int i) {
        int i2;
        if (this.qW != null) {
            int size = this.dge.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.dge.get(i3);
                        if (dVar == null || dVar.aof() != i) {
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
                this.qW.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.dgb != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.anV() != null) {
            d anV = aVar.anV();
            String hQ = anV.anY().hQ(aVar.anU() + i);
            if (anV.anZ() != EmotionGroupType.USER_COLLECT || !hQ.equals(com.baidu.tbadk.imageManager.d.buj)) {
                this.dfV.setTag(hQ);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = hQ;
                if (hQ.startsWith("#(meme,")) {
                    this.dfV.setShowStaticDrawable(false);
                } else {
                    this.dfV.setShowStaticDrawable(true);
                }
                this.dfV.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dfW.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dfU.x = this.rect.left - ((this.dfU.width - linearLayout.getWidth()) / 2);
                this.dfU.y = (this.rect.top - this.dfU.height) + this.dfZ;
                this.dfV.setVisibility(0);
                if (!this.dga) {
                    this.mWindowManager.addView(this.dfV, this.dfU);
                    this.dga = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dfV, this.dfU);
                }
                gridView.setSelection(i);
                if (this.dgb != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dgb - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dgb = i;
                this.dfS = gridView;
            }
        }
    }

    private void anS() {
        if (this.dga && this.dfV.getVisibility() != 8 && this.dfS != null) {
            this.dfS.setSelection(-1);
            this.dfV.setVisibility(8);
            if (this.dgb != -1) {
                ((LinearLayout) this.dfS.getChildAt(this.dgb - this.dfS.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dgb = -1;
            this.dfS = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dgj.set(x, y);
                break;
            case 1:
            case 3:
                anS();
                break;
            case 2:
                this.dgj.set(x, y);
                if (this.dga && this.dfV.getVisibility() != 8 && this.dfS != null) {
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
                this.dgj.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                anS();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    anS();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.dfS != null) {
                        offsetRectIntoDescendantCoords(this.dfS, this.rect);
                        int pointToPosition = this.dfS.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dfS);
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
        if (this.dga) {
            this.mWindowManager.removeView(this.dfV);
            this.dga = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aIh);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dge != null) {
            int size = this.dge.size();
            if (i >= 0 && i < size) {
                this.dgc = this.dge.get(i);
                if (this.bsv != null && this.dgc != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.bsv.setVisibility(this.dgc.aob() > 1 ? 0 : 4);
                        this.bsv.setCount(this.dgc.aob());
                        if (this.dgc != null && this.dgc.aof() != this.dgg) {
                            this.dgg = this.dgc.aof();
                            if (this.dgh != null) {
                                this.dgh.me(this.dgc.aof());
                            }
                        }
                    }
                    float aoc = this.dgc.aoc() + f;
                    this.bsv.setPosition(aoc);
                    this.dfT.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aoc) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.dgc.aob())));
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
        this.bdE = i;
        aj.f(this.dfV, d.f.bg_expression_bubble, i);
        aj.g(this, d.C0108d.cp_bg_line_d, i);
        this.bsv.setSelector(aj.au(i, d.f.dot_pb_expression_s));
        this.bsv.setDrawable(aj.au(i, d.f.dot_pb_expression_n));
        if (this.qW != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.qW.getChildCount()) {
                    View childAt = this.qW.getChildAt(i3);
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
        anS();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d dgm;

        public a(d dVar) {
            this.dgm = dVar;
        }

        public void a(d dVar) {
            this.dgm = dVar;
        }

        public int anU() {
            if (this.dgm == null) {
                return 0;
            }
            return this.dgm.aoe();
        }

        public d anV() {
            return this.dgm;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dgm == null) {
                return 0;
            }
            return this.dgm.aod();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.dgm.aoa() != 0) {
                    i2 = measuredWidth / this.dgm.aoa();
                }
                if (this.dgm.getRow() != 0) {
                    i3 = measuredHeight / this.dgm.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dfZ * 2, EmotionTabContentView.this.dfZ * 2, EmotionTabContentView.this.dfZ * 2, EmotionTabContentView.this.dfZ * 2);
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
            if (this.dgm != null) {
                int aoe = this.dgm.aoe() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.f(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bdE);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String hQ = this.dgm.anY().hQ(aoe);
                tbImageView.setTag(hQ);
                if (!TextUtils.isEmpty(hQ)) {
                    Object a = com.baidu.adp.lib.f.c.nl().a(hQ, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, hQ, false, null);
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
                TextView textView = (TextView) linearLayout3.findViewById(d.g.emotion_tab_content_tip);
                if (this.dgm.anZ() == EmotionGroupType.BIG_EMOTION) {
                    String hQ2 = this.dgm.anY().hQ(aoe);
                    if (!TextUtils.isEmpty(hQ2) && !hQ2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bdE == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0108d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0108d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(hQ2.substring(hQ2.lastIndexOf("_") + 1, hQ2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (hQ != null && hQ.length() > 3) {
                    linearLayout3.setContentDescription(hQ.substring(2, hQ.length() - 1));
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
            if (EmotionTabContentView.this.dge == null) {
                return 0;
            }
            return EmotionTabContentView.this.dge.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dgk.ar(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dgk.nj();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dge != null && i < EmotionTabContentView.this.dge.size()) {
                d dVar = (d) EmotionTabContentView.this.dge.get(i);
                gridView2.setNumColumns(dVar.aoa());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0108d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.anV() == null) {
                            return false;
                        }
                        d anV = aVar.anV();
                        if (anV.anZ() == EmotionGroupType.BIG_EMOTION || anV.anZ() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.axO != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.anV() != null) {
                                d anV = aVar.anV();
                                int anU = aVar.anU();
                                com.baidu.tbadk.editortools.emotiontool.c anY = anV.anY();
                                String hQ = anV.anY().hQ(anU + i2);
                                if (anY.KU() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.buj.equals(hQ)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(hQ);
                                nVar.a(anY.KU());
                                nVar.eO(anY.getGroupName());
                                nVar.eP(anY.getGroupId());
                                nVar.setWidth(anY.getWidth());
                                nVar.setHeight(anY.getHeight());
                                EmotionTabContentView.this.axO.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.dge != null) {
                int size = EmotionTabContentView.this.dge.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.dge.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.bsv.setVisibility(dVar.aob() > 1 ? 0 : 4);
                        EmotionTabContentView.this.bsv.setCount(dVar.aob());
                        EmotionTabContentView.this.bsv.setPosition(dVar.aoc());
                        EmotionTabContentView.this.bsv.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.aoc() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.aob())));
                    }
                    if (dVar != null && dVar.aof() != EmotionTabContentView.this.dgg) {
                        EmotionTabContentView.this.dgg = dVar.aof();
                        if (EmotionTabContentView.this.dgh != null) {
                            EmotionTabContentView.this.dgh.me(dVar.aof());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.dgh = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.axO = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aIh);
    }
}
