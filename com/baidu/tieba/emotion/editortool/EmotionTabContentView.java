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
    private LinearLayout cFA;
    private WindowManager.LayoutParams cFB;
    private GifView cFC;
    private ViewGroup cFD;
    private int cFE;
    private int cFF;
    private int cFG;
    private boolean cFH;
    private int cFI;
    private com.baidu.tieba.emotion.editortool.b cFJ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cFK;
    private List<com.baidu.tieba.emotion.editortool.b> cFL;
    private int cFM;
    private int cFN;
    private b cFO;
    private int cFP;
    private final Point cFQ;
    private com.baidu.adp.lib.e.b<GridView> cFR;
    private EmotionViewPagerAdapter cFy;
    private GridView cFz;
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
        this.cFI = -1;
        this.cFM = 0;
        this.cFN = -1;
        this.currentPosition = -1;
        this.cFQ = new Point();
        this.UN = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aF(new ArrayList(EmotionTabContentView.this.cFK));
                        if (EmotionTabContentView.this.cFy != null) {
                            EmotionTabContentView.this.cFy.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cFN < 0 || EmotionTabContentView.this.cFN >= EmotionTabContentView.this.cFK.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cFK.get(EmotionTabContentView.this.cFN)).DU() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cFy != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cFL.size()) {
                                    EmotionTabContentView.this.cFJ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFL.get(EmotionTabContentView.this.currentPosition);
                                    int akg = EmotionTabContentView.this.cFJ.akg();
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
                                                    if (index >= 0 && index < EmotionTabContentView.this.cFL.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFL.get(index));
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
        this.cFI = -1;
        this.cFM = 0;
        this.cFN = -1;
        this.currentPosition = -1;
        this.cFQ = new Point();
        this.UN = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aF(new ArrayList(EmotionTabContentView.this.cFK));
                        if (EmotionTabContentView.this.cFy != null) {
                            EmotionTabContentView.this.cFy.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cFN < 0 || EmotionTabContentView.this.cFN >= EmotionTabContentView.this.cFK.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cFK.get(EmotionTabContentView.this.cFN)).DU() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cFy != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cFL.size()) {
                                    EmotionTabContentView.this.cFJ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFL.get(EmotionTabContentView.this.currentPosition);
                                    int akg = EmotionTabContentView.this.cFJ.akg();
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
                                                    if (index >= 0 && index < EmotionTabContentView.this.cFL.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFL.get(index));
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
        this.cFK = new ArrayList();
        this.cFL = new ArrayList();
        this.cFR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
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
        this.cFC = new GifView(context);
        ak.d(this.cFC, d.f.bg_expression_bubble, this.aqQ);
        this.cFC.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cFB = new WindowManager.LayoutParams();
        this.cFE = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.cFF = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.cFG = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.cFB.width = this.cFE;
        this.cFB.height = this.cFF;
        this.cFB.gravity = 51;
        this.cFB.format = -3;
        this.cFB.type = 1000;
        this.cFB.flags |= 56;
        this.cFD = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aqW = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cFA = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cFA.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cFB.type = 1000;
            this.cFB.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cFK.clear();
        this.cFL.clear();
        if (list != null && !list.isEmpty()) {
            this.cFK.addAll(list);
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
                        this.cFL.add(bVar);
                    }
                }
            }
            this.cFM = this.cFL.size();
            for (int i6 = 0; i6 < this.cFM; i6++) {
                if (this.cFL != null && this.cFL.get(i6) != null) {
                    this.cFL.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jn(int i) {
        if (this.cFL != null) {
            int size = this.cFL.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cFL.get(i2);
                    if (bVar != null && bVar.akk() == i) {
                        this.cFP = bVar.getIndex();
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
                this.cFy = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cFy);
                this.mViewPager.setCurrentItem(this.cFP, true);
                if (this.cFO != null) {
                    this.cFO.jp(i);
                    this.cFN = i;
                }
            }
        }
    }

    public void jo(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cFL.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cFL.get(i3);
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
        if (this.cFI != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aka() != null) {
            com.baidu.tieba.emotion.editortool.b aka = aVar.aka();
            String eK = aka.akd().eK(aVar.ajZ() + i);
            if (aka.ake() != EmotionGroupType.USER_COLLECT || !eK.equals(com.baidu.tbadk.imageManager.d.aGY)) {
                this.cFC.setTag(eK);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eK;
                if (eK.startsWith("#(meme,")) {
                    this.cFC.setShowStaticDrawable(false);
                } else {
                    this.cFC.setShowStaticDrawable(true);
                }
                this.cFC.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cFD.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cFB.x = this.rect.left - ((this.cFB.width - linearLayout.getWidth()) / 2);
                this.cFB.y = (this.rect.top - this.cFB.height) + this.cFG;
                this.cFC.setVisibility(0);
                if (!this.cFH) {
                    this.mWindowManager.addView(this.cFC, this.cFB);
                    this.cFH = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cFC, this.cFB);
                }
                gridView.setSelection(i);
                if (this.cFI != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cFI - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cFI = i;
                this.cFz = gridView;
            }
        }
    }

    private void ajX() {
        if (this.cFH && this.cFC.getVisibility() != 8 && this.cFz != null) {
            this.cFz.setSelection(-1);
            this.cFC.setVisibility(8);
            if (this.cFI != -1) {
                ((LinearLayout) this.cFz.getChildAt(this.cFI - this.cFz.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cFI = -1;
            this.cFz = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cFQ.set(x, y);
                break;
            case 1:
            case 3:
                ajX();
                break;
            case 2:
                this.cFQ.set(x, y);
                if (this.cFH && this.cFC.getVisibility() != 8 && this.cFz != null) {
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
                this.cFQ.set(x, y);
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
                    if (this.cFz != null) {
                        offsetRectIntoDescendantCoords(this.cFz, this.rect);
                        int pointToPosition = this.cFz.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cFz);
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
        if (this.cFH) {
            this.mWindowManager.removeView(this.cFC);
            this.cFH = false;
        }
        MessageManager.getInstance().unRegisterListener(this.UN);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cFL != null) {
            int size = this.cFL.size();
            if (i >= 0 && i < size) {
                this.cFJ = this.cFL.get(i);
                if (this.aqW != null && this.cFJ != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aqW.setVisibility(this.cFJ.akg() > 1 ? 0 : 4);
                        this.aqW.setCount(this.cFJ.akg());
                        if (this.cFJ != null && this.cFJ.akk() != this.cFN) {
                            this.cFN = this.cFJ.akk();
                            if (this.cFO != null) {
                                this.cFO.jp(this.cFJ.akk());
                            }
                        }
                    }
                    float akh = this.cFJ.akh() + f;
                    this.aqW.setPosition(akh);
                    this.cFA.setContentDescription(String.format(getResources().getString(d.k.emotion_selection), Integer.valueOf(((int) akh) + 1)) + String.format(getResources().getString(d.k.emotion_page), Integer.valueOf(this.cFJ.akg())));
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
        ak.d(this.cFC, d.f.bg_expression_bubble, i);
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
        private com.baidu.tieba.emotion.editortool.b cFT;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cFT = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cFT = bVar;
        }

        public int ajZ() {
            if (this.cFT == null) {
                return 0;
            }
            return this.cFT.akj();
        }

        public com.baidu.tieba.emotion.editortool.b aka() {
            return this.cFT;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cFT == null) {
                return 0;
            }
            return this.cFT.aki();
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
                if (this.cFT.akf() != 0) {
                    i2 = measuredWidth / this.cFT.akf();
                }
                if (this.cFT.getRow() != 0) {
                    i3 = measuredHeight / this.cFT.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cFG * 2, EmotionTabContentView.this.cFG * 2, EmotionTabContentView.this.cFG * 2, EmotionTabContentView.this.cFG * 2);
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
            if (this.cFT != null) {
                int akj = this.cFT.akj() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ak.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.aqQ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eK = this.cFT.akd().eK(akj);
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
                if (this.cFT.ake() == EmotionGroupType.BIG_EMOTION) {
                    String eK2 = this.cFT.akd().eK(akj);
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
            if (EmotionTabContentView.this.cFL == null) {
                return 0;
            }
            return EmotionTabContentView.this.cFL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cFR.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cFR.fn();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cFL != null && i < EmotionTabContentView.this.cFL.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFL.get(i);
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
            if (EmotionTabContentView.this.cFL != null) {
                int size = EmotionTabContentView.this.cFL.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cFL.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aqW.setVisibility(bVar.akg() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aqW.setCount(bVar.akg());
                        EmotionTabContentView.this.aqW.setPosition(bVar.akh());
                        EmotionTabContentView.this.aqW.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_selection), Integer.valueOf(bVar.akh() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_page), Integer.valueOf(bVar.akg())));
                    }
                    if (bVar != null && bVar.akk() != EmotionTabContentView.this.cFN) {
                        EmotionTabContentView.this.cFN = bVar.akk();
                        if (EmotionTabContentView.this.cFO != null) {
                            EmotionTabContentView.this.cFO.jp(bVar.akk());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cFO = bVar;
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
