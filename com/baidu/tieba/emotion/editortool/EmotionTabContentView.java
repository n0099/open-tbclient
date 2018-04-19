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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private EditorTools JS;
    private CustomMessageListener UN;
    private int aqQ;
    private IndicatorView aqW;
    private EmotionViewPagerAdapter cFB;
    private GridView cFC;
    private LinearLayout cFD;
    private WindowManager.LayoutParams cFE;
    private GifView cFF;
    private ViewGroup cFG;
    private int cFH;
    private int cFI;
    private int cFJ;
    private boolean cFK;
    private int cFL;
    private com.baidu.tieba.emotion.editortool.b cFM;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cFN;
    private List<com.baidu.tieba.emotion.editortool.b> cFO;
    private int cFP;
    private int cFQ;
    private b cFR;
    private int cFS;
    private final Point cFT;
    private com.baidu.adp.lib.e.b<GridView> cFU;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface b {
        void jp(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cFL = -1;
        this.cFP = 0;
        this.cFQ = -1;
        this.currentPosition = -1;
        this.cFT = new Point();
        this.UN = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aF(new ArrayList(EmotionTabContentView.this.cFN));
                        if (EmotionTabContentView.this.cFB != null) {
                            EmotionTabContentView.this.cFB.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cFQ < 0 || EmotionTabContentView.this.cFQ >= EmotionTabContentView.this.cFN.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cFN.get(EmotionTabContentView.this.cFQ)).DU() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cFB != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cFO.size()) {
                                    EmotionTabContentView.this.cFM = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFO.get(EmotionTabContentView.this.currentPosition);
                                    int akg = EmotionTabContentView.this.cFM.akg();
                                    EmotionTabContentView.this.aqW.setCount(akg);
                                    EmotionTabContentView.this.aqW.setVisibility(akg > 1 ? 0 : 4);
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
                                                    int index = aVar.aka().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cFO.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFO.get(index));
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
        this.cFL = -1;
        this.cFP = 0;
        this.cFQ = -1;
        this.currentPosition = -1;
        this.cFT = new Point();
        this.UN = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aF(new ArrayList(EmotionTabContentView.this.cFN));
                        if (EmotionTabContentView.this.cFB != null) {
                            EmotionTabContentView.this.cFB.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cFQ < 0 || EmotionTabContentView.this.cFQ >= EmotionTabContentView.this.cFN.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cFN.get(EmotionTabContentView.this.cFQ)).DU() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cFB != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cFO.size()) {
                                    EmotionTabContentView.this.cFM = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFO.get(EmotionTabContentView.this.currentPosition);
                                    int akg = EmotionTabContentView.this.cFM.akg();
                                    EmotionTabContentView.this.aqW.setCount(akg);
                                    EmotionTabContentView.this.aqW.setVisibility(akg > 1 ? 0 : 4);
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
                                                    int index = aVar.aka().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cFO.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFO.get(index));
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
        this.cFN = new ArrayList();
        this.cFO = new ArrayList();
        this.cFU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajY */
            public GridView fo() {
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
        LayoutInflater.from(context).inflate(d.i.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.cFF = new GifView(context);
        ak.d(this.cFF, d.f.bg_expression_bubble, this.aqQ);
        this.cFF.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cFE = new WindowManager.LayoutParams();
        this.cFH = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.cFI = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.cFJ = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.cFE.width = this.cFH;
        this.cFE.height = this.cFI;
        this.cFE.gravity = 51;
        this.cFE.format = -3;
        this.cFE.type = 1000;
        this.cFE.flags |= 56;
        this.cFG = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aqW = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cFD = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cFD.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cFE.type = 1000;
            this.cFE.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cFN.clear();
        this.cFO.clear();
        if (list != null && !list.isEmpty()) {
            this.cFN.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int DX = cVar.DX();
                    int DY = cVar.DY();
                    int i4 = emotionsCount / (DX * DY);
                    if (emotionsCount % (DX * DY) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = DX * DY;
                        } else {
                            i = emotionsCount - ((DX * DY) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.ju(i3);
                        bVar.b(cVar.DU());
                        bVar.eR(DY);
                        bVar.eQ(DX);
                        bVar.jq(i4);
                        bVar.jr(i5);
                        bVar.js(i);
                        bVar.jt(i5 * DX * DY);
                        bVar.setEndIndex((i + i2) - 1);
                        this.cFO.add(bVar);
                    }
                }
            }
            this.cFP = this.cFO.size();
            for (int i6 = 0; i6 < this.cFP; i6++) {
                if (this.cFO != null && this.cFO.get(i6) != null) {
                    this.cFO.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jn(int i) {
        if (this.cFO != null) {
            int size = this.cFO.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cFO.get(i2);
                    if (bVar != null && bVar.akk() == i) {
                        this.cFS = bVar.getIndex();
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
                aF(list);
                jn(i);
                this.cFB = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cFB);
                this.mViewPager.setCurrentItem(this.cFS, true);
                if (this.cFR != null) {
                    this.cFR.jp(i);
                    this.cFQ = i;
                }
            }
        }
    }

    public void jo(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cFO.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cFO.get(i3);
                        if (bVar == null || bVar.akk() != i) {
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
        if (this.cFL != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aka() != null) {
            com.baidu.tieba.emotion.editortool.b aka = aVar.aka();
            String eK = aka.akd().eK(aVar.ajZ() + i);
            if (aka.ake() != EmotionGroupType.USER_COLLECT || !eK.equals(com.baidu.tbadk.imageManager.d.aGY)) {
                this.cFF.setTag(eK);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eK;
                if (eK.startsWith("#(meme,")) {
                    this.cFF.setShowStaticDrawable(false);
                } else {
                    this.cFF.setShowStaticDrawable(true);
                }
                this.cFF.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cFG.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cFE.x = this.rect.left - ((this.cFE.width - linearLayout.getWidth()) / 2);
                this.cFE.y = (this.rect.top - this.cFE.height) + this.cFJ;
                this.cFF.setVisibility(0);
                if (!this.cFK) {
                    this.mWindowManager.addView(this.cFF, this.cFE);
                    this.cFK = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cFF, this.cFE);
                }
                gridView.setSelection(i);
                if (this.cFL != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cFL - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cFL = i;
                this.cFC = gridView;
            }
        }
    }

    private void ajX() {
        if (this.cFK && this.cFF.getVisibility() != 8 && this.cFC != null) {
            this.cFC.setSelection(-1);
            this.cFF.setVisibility(8);
            if (this.cFL != -1) {
                ((LinearLayout) this.cFC.getChildAt(this.cFL - this.cFC.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cFL = -1;
            this.cFC = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cFT.set(x, y);
                break;
            case 1:
            case 3:
                ajX();
                break;
            case 2:
                this.cFT.set(x, y);
                if (this.cFK && this.cFF.getVisibility() != 8 && this.cFC != null) {
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
                this.cFT.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                ajX();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    ajX();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cFC != null) {
                        offsetRectIntoDescendantCoords(this.cFC, this.rect);
                        int pointToPosition = this.cFC.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cFC);
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
        if (this.cFK) {
            this.mWindowManager.removeView(this.cFF);
            this.cFK = false;
        }
        MessageManager.getInstance().unRegisterListener(this.UN);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cFO != null) {
            int size = this.cFO.size();
            if (i >= 0 && i < size) {
                this.cFM = this.cFO.get(i);
                if (this.aqW != null && this.cFM != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aqW.setVisibility(this.cFM.akg() > 1 ? 0 : 4);
                        this.aqW.setCount(this.cFM.akg());
                        if (this.cFM != null && this.cFM.akk() != this.cFQ) {
                            this.cFQ = this.cFM.akk();
                            if (this.cFR != null) {
                                this.cFR.jp(this.cFM.akk());
                            }
                        }
                    }
                    float akh = this.cFM.akh() + f;
                    this.aqW.setPosition(akh);
                    this.cFD.setContentDescription(String.format(getResources().getString(d.k.emotion_selection), Integer.valueOf(((int) akh) + 1)) + String.format(getResources().getString(d.k.emotion_page), Integer.valueOf(this.cFM.akg())));
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
        this.aqQ = i;
        ak.d(this.cFF, d.f.bg_expression_bubble, i);
        ak.e(this, d.C0126d.cp_bg_line_d, i);
        this.aqW.setSelector(ak.u(i, d.f.dot_pb_expression_s));
        this.aqW.setDrawable(ak.u(i, d.f.dot_pb_expression_n));
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
        ajX();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b cFW;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cFW = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cFW = bVar;
        }

        public int ajZ() {
            if (this.cFW == null) {
                return 0;
            }
            return this.cFW.akj();
        }

        public com.baidu.tieba.emotion.editortool.b aka() {
            return this.cFW;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cFW == null) {
                return 0;
            }
            return this.cFW.aki();
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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            int color;
            com.baidu.adp.widget.ImageView.a aVar;
            if (view2 == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cFW.akf() != 0) {
                    i2 = measuredWidth / this.cFW.akf();
                }
                if (this.cFW.getRow() != 0) {
                    i3 = measuredHeight / this.cFW.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cFJ * 2, EmotionTabContentView.this.cFJ * 2, EmotionTabContentView.this.cFJ * 2, EmotionTabContentView.this.cFJ * 2);
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
                linearLayout = view2;
            }
            LinearLayout linearLayout3 = (LinearLayout) linearLayout;
            if (this.cFW != null) {
                int akj = this.cFW.akj() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ak.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.aqQ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eK = this.cFW.akd().eK(akj);
                tbImageView.setTag(eK);
                if (!TextUtils.isEmpty(eK)) {
                    Object a = com.baidu.adp.lib.f.c.fp().a(eK, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eK, false, null);
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
                TextView textView = (TextView) linearLayout3.findViewById(d.g.emotion_tab_content_tip);
                if (this.cFW.ake() == EmotionGroupType.BIG_EMOTION) {
                    String eK2 = this.cFW.akd().eK(akj);
                    if (!TextUtils.isEmpty(eK2) && !eK2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aqQ == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0126d.cp_cont_c);
                        } else {
                            color = ak.getColor(d.C0126d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eK2.substring(eK2.lastIndexOf("_") + 1, eK2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eK != null && eK.length() > 3) {
                    linearLayout3.setContentDescription(eK.substring(2, eK.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.cFO == null) {
                return 0;
            }
            return EmotionTabContentView.this.cFO.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cFU.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cFU.fn();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cFO != null && i < EmotionTabContentView.this.cFO.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFO.get(i);
                gridView2.setNumColumns(bVar.akf());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0126d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aka() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b aka = aVar.aka();
                        if (aka.ake() == EmotionGroupType.BIG_EMOTION || aka.ake() == EmotionGroupType.USER_COLLECT) {
                            EmotionTabContentView.this.a(i2, (GridView) adapterView);
                            return true;
                        }
                        return false;
                    }
                });
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j) {
                        adapterView.setSelection(-1);
                        if (EmotionTabContentView.this.JS != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aka() != null) {
                                com.baidu.tieba.emotion.editortool.b aka = aVar.aka();
                                int ajZ = aVar.ajZ();
                                com.baidu.tbadk.editortools.emotiontool.c akd = aka.akd();
                                String eK = aka.akd().eK(ajZ + i2);
                                if (akd.DU() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGY.equals(eK)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eK);
                                nVar.a(akd.DU());
                                nVar.eZ(akd.getGroupName());
                                nVar.fa(akd.getGroupId());
                                nVar.setWidth(akd.getWidth());
                                nVar.setHeight(akd.getHeight());
                                EmotionTabContentView.this.JS.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.cFO != null) {
                int size = EmotionTabContentView.this.cFO.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFO.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aqW.setVisibility(bVar.akg() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aqW.setCount(bVar.akg());
                        EmotionTabContentView.this.aqW.setPosition(bVar.akh());
                        EmotionTabContentView.this.aqW.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_selection), Integer.valueOf(bVar.akh() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_page), Integer.valueOf(bVar.akg())));
                    }
                    if (bVar != null && bVar.akk() != EmotionTabContentView.this.cFQ) {
                        EmotionTabContentView.this.cFQ = bVar.akk();
                        if (EmotionTabContentView.this.cFR != null) {
                            EmotionTabContentView.this.cFR.jp(bVar.akk());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cFR = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.UN);
    }
}
