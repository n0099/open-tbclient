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
    private EditorTools Tj;
    private int aGD;
    private int aMj;
    private IndicatorView aMp;
    private CustomMessageListener aoH;
    private EmotionViewPagerAdapter dpO;
    private GridView dpP;
    private LinearLayout dpQ;
    private WindowManager.LayoutParams dpR;
    private GifView dpS;
    private ViewGroup dpT;
    private int dpU;
    private int dpV;
    private int dpW;
    private boolean dpX;
    private int dpY;
    private com.baidu.tieba.emotion.editortool.b dpZ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dqa;
    private List<com.baidu.tieba.emotion.editortool.b> dqb;
    private int dqc;
    private int dqd;
    private b dqe;
    private int dqf;
    private final Point dqg;
    private com.baidu.adp.lib.e.b<GridView> dqh;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes5.dex */
    public interface b {
        void lt(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dpY = -1;
        this.dqc = 0;
        this.dqd = -1;
        this.aGD = -1;
        this.dqg = new Point();
        this.aoH = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.be(new ArrayList(EmotionTabContentView.this.dqa));
                        if (EmotionTabContentView.this.dpO != null) {
                            EmotionTabContentView.this.dpO.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dqd < 0 || EmotionTabContentView.this.dqd >= EmotionTabContentView.this.dqa.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dqa.get(EmotionTabContentView.this.dqd)).ME() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dpO != null) {
                                if (EmotionTabContentView.this.aGD >= 0 && EmotionTabContentView.this.aGD < EmotionTabContentView.this.dqb.size()) {
                                    EmotionTabContentView.this.dpZ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dqb.get(EmotionTabContentView.this.aGD);
                                    int avP = EmotionTabContentView.this.dpZ.avP();
                                    EmotionTabContentView.this.aMp.setCount(avP);
                                    EmotionTabContentView.this.aMp.setVisibility(avP > 1 ? 0 : 4);
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
                                                    int index = aVar.avJ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dqb.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dqb.get(index));
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
        this.dpY = -1;
        this.dqc = 0;
        this.dqd = -1;
        this.aGD = -1;
        this.dqg = new Point();
        this.aoH = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.be(new ArrayList(EmotionTabContentView.this.dqa));
                        if (EmotionTabContentView.this.dpO != null) {
                            EmotionTabContentView.this.dpO.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dqd < 0 || EmotionTabContentView.this.dqd >= EmotionTabContentView.this.dqa.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dqa.get(EmotionTabContentView.this.dqd)).ME() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dpO != null) {
                                if (EmotionTabContentView.this.aGD >= 0 && EmotionTabContentView.this.aGD < EmotionTabContentView.this.dqb.size()) {
                                    EmotionTabContentView.this.dpZ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dqb.get(EmotionTabContentView.this.aGD);
                                    int avP = EmotionTabContentView.this.dpZ.avP();
                                    EmotionTabContentView.this.aMp.setCount(avP);
                                    EmotionTabContentView.this.aMp.setVisibility(avP > 1 ? 0 : 4);
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
                                                    int index = aVar.avJ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dqb.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dqb.get(index));
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
        this.dqa = new ArrayList();
        this.dqb = new ArrayList();
        this.dqh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avH */
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
        this.dpS = new GifView(context);
        al.d(this.dpS, e.f.bg_expression_bubble, this.aMj);
        this.dpS.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.dpR = new WindowManager.LayoutParams();
        this.dpU = context.getResources().getDimensionPixelSize(e.C0210e.ds240);
        this.dpV = context.getResources().getDimensionPixelSize(e.C0210e.ds252);
        this.dpW = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.dpR.width = this.dpU;
        this.dpR.height = this.dpV;
        this.dpR.gravity = 51;
        this.dpR.format = -3;
        this.dpR.type = 1000;
        this.dpR.flags |= 56;
        this.dpT = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aMp = (IndicatorView) findViewById(e.g.face_tab_indicator);
        this.dpQ = (LinearLayout) findViewById(e.g.face_tab_indicator_layout);
        this.dpQ.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dpR.type = 1000;
            this.dpR.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dqa.clear();
        this.dqb.clear();
        if (list != null && !list.isEmpty()) {
            this.dqa.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int MH = cVar.MH();
                    int MI = cVar.MI();
                    int i4 = emotionsCount / (MH * MI);
                    if (emotionsCount % (MH * MI) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = MH * MI;
                        } else {
                            i = emotionsCount - ((MH * MI) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.ly(i3);
                        bVar.b(cVar.ME());
                        bVar.fV(MI);
                        bVar.fU(MH);
                        bVar.lu(i4);
                        bVar.lv(i5);
                        bVar.lw(i);
                        bVar.lx(i5 * MH * MI);
                        bVar.setEndIndex((i + i2) - 1);
                        this.dqb.add(bVar);
                    }
                }
            }
            this.dqc = this.dqb.size();
            for (int i6 = 0; i6 < this.dqc; i6++) {
                if (this.dqb != null && this.dqb.get(i6) != null) {
                    this.dqb.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void lr(int i) {
        if (this.dqb != null) {
            int size = this.dqb.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.dqb.get(i2);
                    if (bVar != null && bVar.avT() == i) {
                        this.dqf = bVar.getIndex();
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
                be(list);
                lr(i);
                this.dpO = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.dpO);
                this.mViewPager.setCurrentItem(this.dqf, true);
                if (this.dqe != null) {
                    this.dqe.lt(i);
                    this.dqd = i;
                }
            }
        }
    }

    public void ls(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.dqb.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.dqb.get(i3);
                        if (bVar == null || bVar.avT() != i) {
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
        if (this.dpY != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.avJ() != null) {
            com.baidu.tieba.emotion.editortool.b avJ = aVar.avJ();
            String fO = avJ.avM().fO(aVar.avI() + i);
            if (avJ.avN() != EmotionGroupType.USER_COLLECT || !fO.equals(com.baidu.tbadk.imageManager.d.bdf)) {
                this.dpS.setTag(fO);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = fO;
                if (fO.startsWith("#(meme,")) {
                    this.dpS.setShowStaticDrawable(false);
                } else {
                    this.dpS.setShowStaticDrawable(true);
                }
                this.dpS.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dpT.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dpR.x = this.rect.left - ((this.dpR.width - linearLayout.getWidth()) / 2);
                this.dpR.y = (this.rect.top - this.dpR.height) + this.dpW;
                this.dpS.setVisibility(0);
                if (!this.dpX) {
                    this.mWindowManager.addView(this.dpS, this.dpR);
                    this.dpX = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dpS, this.dpR);
                }
                gridView.setSelection(i);
                if (this.dpY != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dpY - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dpY = i;
                this.dpP = gridView;
            }
        }
    }

    private void onUp() {
        if (this.dpX && this.dpS.getVisibility() != 8 && this.dpP != null) {
            this.dpP.setSelection(-1);
            this.dpS.setVisibility(8);
            if (this.dpY != -1) {
                ((LinearLayout) this.dpP.getChildAt(this.dpY - this.dpP.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dpY = -1;
            this.dpP = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dqg.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.dqg.set(x, y);
                if (this.dpX && this.dpS.getVisibility() != 8 && this.dpP != null) {
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
                this.dqg.set(x, y);
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
                    if (this.dpP != null) {
                        offsetRectIntoDescendantCoords(this.dpP, this.rect);
                        int pointToPosition = this.dpP.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dpP);
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
        if (this.dpX) {
            this.mWindowManager.removeView(this.dpS);
            this.dpX = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aoH);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dqb != null) {
            int size = this.dqb.size();
            if (i >= 0 && i < size) {
                this.dpZ = this.dqb.get(i);
                if (this.aMp != null && this.dpZ != null) {
                    if (this.aGD != i) {
                        this.aGD = i;
                        this.aMp.setVisibility(this.dpZ.avP() > 1 ? 0 : 4);
                        this.aMp.setCount(this.dpZ.avP());
                        if (this.dpZ != null && this.dpZ.avT() != this.dqd) {
                            this.dqd = this.dpZ.avT();
                            if (this.dqe != null) {
                                this.dqe.lt(this.dpZ.avT());
                            }
                        }
                    }
                    float avQ = this.dpZ.avQ() + f;
                    this.aMp.setPosition(avQ);
                    this.dpQ.setContentDescription(String.format(getResources().getString(e.j.emotion_selection), Integer.valueOf(((int) avQ) + 1)) + String.format(getResources().getString(e.j.emotion_page), Integer.valueOf(this.dpZ.avP())));
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
        this.aMj = i;
        al.d(this.dpS, e.f.bg_expression_bubble, i);
        al.e(this, e.d.cp_bg_line_d, i);
        this.aMp.setSelector(al.y(i, e.f.dot_pb_expression_s));
        this.aMp.setDrawable(al.y(i, e.f.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b dqj;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dqj = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dqj = bVar;
        }

        public int avI() {
            if (this.dqj == null) {
                return 0;
            }
            return this.dqj.avS();
        }

        public com.baidu.tieba.emotion.editortool.b avJ() {
            return this.dqj;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dqj == null) {
                return 0;
            }
            return this.dqj.avR();
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
                if (this.dqj.avO() != 0) {
                    i2 = measuredWidth / this.dqj.avO();
                }
                if (this.dqj.getRow() != 0) {
                    i3 = measuredHeight / this.dqj.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dpW * 2, EmotionTabContentView.this.dpW * 2, EmotionTabContentView.this.dpW * 2, EmotionTabContentView.this.dpW * 2);
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
            if (this.dqj != null) {
                int avS = this.dqj.avS() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(e.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, e.f.btn_choose_face_selector, EmotionTabContentView.this.aMj);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String fO = this.dqj.avM().fO(avS);
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
                if (this.dqj.avN() == EmotionGroupType.BIG_EMOTION) {
                    String fO2 = this.dqj.avM().fO(avS);
                    if (!TextUtils.isEmpty(fO2) && !fO2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aMj == 0) {
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
            if (EmotionTabContentView.this.dqb == null) {
                return 0;
            }
            return EmotionTabContentView.this.dqb.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dqh.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dqh.jy();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dqb != null && i < EmotionTabContentView.this.dqb.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dqb.get(i);
                gridView2.setNumColumns(bVar.avO());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(e.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.avJ() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b avJ = aVar.avJ();
                        if (avJ.avN() == EmotionGroupType.BIG_EMOTION || avJ.avN() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Tj != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.avJ() != null) {
                                com.baidu.tieba.emotion.editortool.b avJ = aVar.avJ();
                                int avI = aVar.avI();
                                com.baidu.tbadk.editortools.emotiontool.c avM = avJ.avM();
                                String fO = avJ.avM().fO(avI + i2);
                                if (avM.ME() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.bdf.equals(fO)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(fO);
                                pVar.a(avM.ME());
                                pVar.gR(avM.getGroupName());
                                pVar.setPid(avM.getGroupId());
                                pVar.setWidth(avM.getWidth());
                                pVar.setHeight(avM.getHeight());
                                EmotionTabContentView.this.Tj.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.dqb != null) {
                int size = EmotionTabContentView.this.dqb.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aGD) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dqb.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aGD = i;
                        EmotionTabContentView.this.aMp.setVisibility(bVar.avP() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aMp.setCount(bVar.avP());
                        EmotionTabContentView.this.aMp.setPosition(bVar.avQ());
                        EmotionTabContentView.this.aMp.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_selection), Integer.valueOf(bVar.avQ() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_page), Integer.valueOf(bVar.avP())));
                    }
                    if (bVar != null && bVar.avT() != EmotionTabContentView.this.dqd) {
                        EmotionTabContentView.this.dqd = bVar.avT();
                        if (EmotionTabContentView.this.dqe != null) {
                            EmotionTabContentView.this.dqe.lt(bVar.avT());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.dqe = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aoH);
    }
}
