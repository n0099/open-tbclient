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
    private CustomMessageListener aIf;
    private i axN;
    private int bdK;
    private IndicatorView bsE;
    private int currentPosition;
    private int dkA;
    private int dkB;
    private boolean dkC;
    private int dkD;
    private d dkE;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dkF;
    private List<d> dkG;
    private int dkH;
    private int dkI;
    private c dkJ;
    private int dkK;
    private final Point dkL;
    private com.baidu.adp.lib.e.b<GridView> dkM;
    private b dkt;
    private GridView dku;
    private LinearLayout dkv;
    private WindowManager.LayoutParams dkw;
    private GifView dkx;
    private ViewGroup dky;
    private int dkz;
    private Context mContext;
    private WindowManager mWindowManager;
    private ViewPager qW;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void mh(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dkD = -1;
        this.dkH = 0;
        this.dkI = -1;
        this.currentPosition = -1;
        this.dkL = new Point();
        this.aIf = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.aI(new ArrayList(EmotionTabContentView.this.dkF));
                        if (EmotionTabContentView.this.dkt != null) {
                            EmotionTabContentView.this.dkt.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dkI < 0 || EmotionTabContentView.this.dkI >= EmotionTabContentView.this.dkF.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dkF.get(EmotionTabContentView.this.dkI)).KJ() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dkt != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dkG.size()) {
                                    EmotionTabContentView.this.dkE = (d) EmotionTabContentView.this.dkG.get(EmotionTabContentView.this.currentPosition);
                                    int ape = EmotionTabContentView.this.dkE.ape();
                                    EmotionTabContentView.this.bsE.setCount(ape);
                                    EmotionTabContentView.this.bsE.setVisibility(ape > 1 ? 0 : 4);
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
                                                    int index = aVar.aoY().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dkG.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dkG.get(index));
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
        this.dkD = -1;
        this.dkH = 0;
        this.dkI = -1;
        this.currentPosition = -1;
        this.dkL = new Point();
        this.aIf = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.aI(new ArrayList(EmotionTabContentView.this.dkF));
                        if (EmotionTabContentView.this.dkt != null) {
                            EmotionTabContentView.this.dkt.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dkI < 0 || EmotionTabContentView.this.dkI >= EmotionTabContentView.this.dkF.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dkF.get(EmotionTabContentView.this.dkI)).KJ() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dkt != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dkG.size()) {
                                    EmotionTabContentView.this.dkE = (d) EmotionTabContentView.this.dkG.get(EmotionTabContentView.this.currentPosition);
                                    int ape = EmotionTabContentView.this.dkE.ape();
                                    EmotionTabContentView.this.bsE.setCount(ape);
                                    EmotionTabContentView.this.bsE.setVisibility(ape > 1 ? 0 : 4);
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
                                                    int index = aVar.aoY().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dkG.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dkG.get(index));
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
        this.dkF = new ArrayList();
        this.dkG = new ArrayList();
        this.dkM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoW */
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
        this.dkx = new GifView(context);
        aj.f(this.dkx, d.f.bg_expression_bubble, this.bdK);
        this.dkx.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dkw = new WindowManager.LayoutParams();
        this.dkz = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.dkA = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.dkB = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.dkw.width = this.dkz;
        this.dkw.height = this.dkA;
        this.dkw.gravity = 51;
        this.dkw.format = -3;
        this.dkw.type = 1000;
        this.dkw.flags |= 56;
        this.dky = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.bsE = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.dkv = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.dkv.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dkw.type = 1000;
            this.dkw.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dkF.clear();
        this.dkG.clear();
        if (list != null && !list.isEmpty()) {
            this.dkF.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int KM = cVar.KM();
                    int i4 = emotionsCount / (cols * KM);
                    if (emotionsCount % (cols * KM) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * KM;
                        } else {
                            i = emotionsCount - ((cols * KM) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.mm(i3);
                        dVar.b(cVar.KJ());
                        dVar.hU(KM);
                        dVar.hT(cols);
                        dVar.mi(i4);
                        dVar.mj(i5);
                        dVar.mk(i);
                        dVar.ml(i5 * cols * KM);
                        dVar.setEndIndex((i + i2) - 1);
                        this.dkG.add(dVar);
                    }
                }
            }
            this.dkH = this.dkG.size();
            for (int i6 = 0; i6 < this.dkH; i6++) {
                if (this.dkG != null && this.dkG.get(i6) != null) {
                    this.dkG.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void mf(int i) {
        if (this.dkG != null) {
            int size = this.dkG.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.dkG.get(i2);
                    if (dVar != null && dVar.api() == i) {
                        this.dkK = dVar.getIndex();
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
                aI(list);
                mf(i);
                this.dkt = new b();
                this.qW.setAdapter(this.dkt);
                this.qW.setCurrentItem(this.dkK, true);
                if (this.dkJ != null) {
                    this.dkJ.mh(i);
                    this.dkI = i;
                }
            }
        }
    }

    public void mg(int i) {
        int i2;
        if (this.qW != null) {
            int size = this.dkG.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.dkG.get(i3);
                        if (dVar == null || dVar.api() != i) {
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
        if (this.dkD != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aoY() != null) {
            d aoY = aVar.aoY();
            String hM = aoY.apb().hM(aVar.aoX() + i);
            if (aoY.apc() != EmotionGroupType.USER_COLLECT || !hM.equals(com.baidu.tbadk.imageManager.d.bus)) {
                this.dkx.setTag(hM);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = hM;
                if (hM.startsWith("#(meme,")) {
                    this.dkx.setShowStaticDrawable(false);
                } else {
                    this.dkx.setShowStaticDrawable(true);
                }
                this.dkx.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dky.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dkw.x = this.rect.left - ((this.dkw.width - linearLayout.getWidth()) / 2);
                this.dkw.y = (this.rect.top - this.dkw.height) + this.dkB;
                this.dkx.setVisibility(0);
                if (!this.dkC) {
                    this.mWindowManager.addView(this.dkx, this.dkw);
                    this.dkC = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dkx, this.dkw);
                }
                gridView.setSelection(i);
                if (this.dkD != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dkD - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dkD = i;
                this.dku = gridView;
            }
        }
    }

    private void aoV() {
        if (this.dkC && this.dkx.getVisibility() != 8 && this.dku != null) {
            this.dku.setSelection(-1);
            this.dkx.setVisibility(8);
            if (this.dkD != -1) {
                ((LinearLayout) this.dku.getChildAt(this.dkD - this.dku.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dkD = -1;
            this.dku = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dkL.set(x, y);
                break;
            case 1:
            case 3:
                aoV();
                break;
            case 2:
                this.dkL.set(x, y);
                if (this.dkC && this.dkx.getVisibility() != 8 && this.dku != null) {
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
                this.dkL.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                aoV();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    aoV();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.dku != null) {
                        offsetRectIntoDescendantCoords(this.dku, this.rect);
                        int pointToPosition = this.dku.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dku);
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
        if (this.dkC) {
            this.mWindowManager.removeView(this.dkx);
            this.dkC = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aIf);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dkG != null) {
            int size = this.dkG.size();
            if (i >= 0 && i < size) {
                this.dkE = this.dkG.get(i);
                if (this.bsE != null && this.dkE != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.bsE.setVisibility(this.dkE.ape() > 1 ? 0 : 4);
                        this.bsE.setCount(this.dkE.ape());
                        if (this.dkE != null && this.dkE.api() != this.dkI) {
                            this.dkI = this.dkE.api();
                            if (this.dkJ != null) {
                                this.dkJ.mh(this.dkE.api());
                            }
                        }
                    }
                    float apf = this.dkE.apf() + f;
                    this.bsE.setPosition(apf);
                    this.dkv.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) apf) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.dkE.ape())));
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
        this.bdK = i;
        aj.f(this.dkx, d.f.bg_expression_bubble, i);
        aj.g(this, d.C0107d.cp_bg_line_d, i);
        this.bsE.setSelector(aj.au(i, d.f.dot_pb_expression_s));
        this.bsE.setDrawable(aj.au(i, d.f.dot_pb_expression_n));
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
        aoV();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d dkO;

        public a(d dVar) {
            this.dkO = dVar;
        }

        public void a(d dVar) {
            this.dkO = dVar;
        }

        public int aoX() {
            if (this.dkO == null) {
                return 0;
            }
            return this.dkO.aph();
        }

        public d aoY() {
            return this.dkO;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dkO == null) {
                return 0;
            }
            return this.dkO.apg();
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
                if (this.dkO.apd() != 0) {
                    i2 = measuredWidth / this.dkO.apd();
                }
                if (this.dkO.getRow() != 0) {
                    i3 = measuredHeight / this.dkO.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dkB * 2, EmotionTabContentView.this.dkB * 2, EmotionTabContentView.this.dkB * 2, EmotionTabContentView.this.dkB * 2);
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
            if (this.dkO != null) {
                int aph = this.dkO.aph() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.f(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bdK);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String hM = this.dkO.apb().hM(aph);
                tbImageView.setTag(hM);
                if (!TextUtils.isEmpty(hM)) {
                    Object a = com.baidu.adp.lib.f.c.nl().a(hM, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, hM, false, null);
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
                if (this.dkO.apc() == EmotionGroupType.BIG_EMOTION) {
                    String hM2 = this.dkO.apb().hM(aph);
                    if (!TextUtils.isEmpty(hM2) && !hM2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bdK == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0107d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0107d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(hM2.substring(hM2.lastIndexOf("_") + 1, hM2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (hM != null && hM.length() > 3) {
                    linearLayout3.setContentDescription(hM.substring(2, hM.length() - 1));
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
            if (EmotionTabContentView.this.dkG == null) {
                return 0;
            }
            return EmotionTabContentView.this.dkG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dkM.ar(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dkM.nj();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dkG != null && i < EmotionTabContentView.this.dkG.size()) {
                d dVar = (d) EmotionTabContentView.this.dkG.get(i);
                gridView2.setNumColumns(dVar.apd());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0107d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aoY() == null) {
                            return false;
                        }
                        d aoY = aVar.aoY();
                        if (aoY.apc() == EmotionGroupType.BIG_EMOTION || aoY.apc() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.axN != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aoY() != null) {
                                d aoY = aVar.aoY();
                                int aoX = aVar.aoX();
                                com.baidu.tbadk.editortools.emotiontool.c apb = aoY.apb();
                                String hM = aoY.apb().hM(aoX + i2);
                                if (apb.KJ() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.bus.equals(hM)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(hM);
                                nVar.a(apb.KJ());
                                nVar.eO(apb.getGroupName());
                                nVar.eP(apb.getGroupId());
                                nVar.setWidth(apb.getWidth());
                                nVar.setHeight(apb.getHeight());
                                EmotionTabContentView.this.axN.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.dkG != null) {
                int size = EmotionTabContentView.this.dkG.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.dkG.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.bsE.setVisibility(dVar.ape() > 1 ? 0 : 4);
                        EmotionTabContentView.this.bsE.setCount(dVar.ape());
                        EmotionTabContentView.this.bsE.setPosition(dVar.apf());
                        EmotionTabContentView.this.bsE.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.apf() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.ape())));
                    }
                    if (dVar != null && dVar.api() != EmotionTabContentView.this.dkI) {
                        EmotionTabContentView.this.dkI = dVar.api();
                        if (EmotionTabContentView.this.dkJ != null) {
                            EmotionTabContentView.this.dkJ.mh(dVar.api());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.dkJ = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.axN = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aIf);
    }
}
