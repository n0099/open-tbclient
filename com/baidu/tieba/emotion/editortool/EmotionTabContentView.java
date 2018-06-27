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
import com.baidu.tbadk.core.util.am;
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
    private EditorTools Qj;
    private CustomMessageListener acM;
    private int azP;
    private IndicatorView azV;
    private EmotionViewPagerAdapter cNJ;
    private GridView cNK;
    private LinearLayout cNL;
    private WindowManager.LayoutParams cNM;
    private GifView cNN;
    private ViewGroup cNO;
    private int cNP;
    private int cNQ;
    private int cNR;
    private boolean cNS;
    private int cNT;
    private com.baidu.tieba.emotion.editortool.b cNU;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cNV;
    private List<com.baidu.tieba.emotion.editortool.b> cNW;
    private int cNX;
    private int cNY;
    private b cNZ;
    private int cOa;
    private final Point cOb;
    private com.baidu.adp.lib.e.b<GridView> cOc;
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
        this.cNT = -1;
        this.cNX = 0;
        this.cNY = -1;
        this.currentPosition = -1;
        this.cOb = new Point();
        this.acM = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aM(new ArrayList(EmotionTabContentView.this.cNV));
                        if (EmotionTabContentView.this.cNJ != null) {
                            EmotionTabContentView.this.cNJ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cNY < 0 || EmotionTabContentView.this.cNY >= EmotionTabContentView.this.cNV.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cNV.get(EmotionTabContentView.this.cNY)).HN() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cNJ != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cNW.size()) {
                                    EmotionTabContentView.this.cNU = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cNW.get(EmotionTabContentView.this.currentPosition);
                                    int anG = EmotionTabContentView.this.cNU.anG();
                                    EmotionTabContentView.this.azV.setCount(anG);
                                    EmotionTabContentView.this.azV.setVisibility(anG > 1 ? 0 : 4);
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
                                                    int index = aVar.anA().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cNW.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cNW.get(index));
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
        this.cNT = -1;
        this.cNX = 0;
        this.cNY = -1;
        this.currentPosition = -1;
        this.cOb = new Point();
        this.acM = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aM(new ArrayList(EmotionTabContentView.this.cNV));
                        if (EmotionTabContentView.this.cNJ != null) {
                            EmotionTabContentView.this.cNJ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cNY < 0 || EmotionTabContentView.this.cNY >= EmotionTabContentView.this.cNV.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cNV.get(EmotionTabContentView.this.cNY)).HN() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cNJ != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cNW.size()) {
                                    EmotionTabContentView.this.cNU = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cNW.get(EmotionTabContentView.this.currentPosition);
                                    int anG = EmotionTabContentView.this.cNU.anG();
                                    EmotionTabContentView.this.azV.setCount(anG);
                                    EmotionTabContentView.this.azV.setVisibility(anG > 1 ? 0 : 4);
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
                                                    int index = aVar.anA().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cNW.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cNW.get(index));
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
        this.cNV = new ArrayList();
        this.cNW = new ArrayList();
        this.cOc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: any */
            public GridView mo9if() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView r(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView s(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.i.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.cNN = new GifView(context);
        am.d(this.cNN, d.f.bg_expression_bubble, this.azP);
        this.cNN.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cNM = new WindowManager.LayoutParams();
        this.cNP = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.cNQ = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.cNR = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.cNM.width = this.cNP;
        this.cNM.height = this.cNQ;
        this.cNM.gravity = 51;
        this.cNM.format = -3;
        this.cNM.type = 1000;
        this.cNM.flags |= 56;
        this.cNO = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.azV = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cNL = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cNL.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cNM.type = 1000;
            this.cNM.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cNV.clear();
        this.cNW.clear();
        if (list != null && !list.isEmpty()) {
            this.cNV.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int HQ = cVar.HQ();
                    int HR = cVar.HR();
                    int i4 = emotionsCount / (HQ * HR);
                    if (emotionsCount % (HQ * HR) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = HQ * HR;
                        } else {
                            i = emotionsCount - ((HQ * HR) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.ju(i3);
                        bVar.b(cVar.HN());
                        bVar.eX(HR);
                        bVar.eW(HQ);
                        bVar.jq(i4);
                        bVar.jr(i5);
                        bVar.js(i);
                        bVar.jt(i5 * HQ * HR);
                        bVar.setEndIndex((i + i2) - 1);
                        this.cNW.add(bVar);
                    }
                }
            }
            this.cNX = this.cNW.size();
            for (int i6 = 0; i6 < this.cNX; i6++) {
                if (this.cNW != null && this.cNW.get(i6) != null) {
                    this.cNW.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jn(int i) {
        if (this.cNW != null) {
            int size = this.cNW.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cNW.get(i2);
                    if (bVar != null && bVar.anK() == i) {
                        this.cOa = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void i(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                aM(list);
                jn(i);
                this.cNJ = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cNJ);
                this.mViewPager.setCurrentItem(this.cOa, true);
                if (this.cNZ != null) {
                    this.cNZ.jp(i);
                    this.cNY = i;
                }
            }
        }
    }

    public void jo(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cNW.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cNW.get(i3);
                        if (bVar == null || bVar.anK() != i) {
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
        if (this.cNT != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.anA() != null) {
            com.baidu.tieba.emotion.editortool.b anA = aVar.anA();
            String eQ = anA.anD().eQ(aVar.anz() + i);
            if (anA.anE() != EmotionGroupType.USER_COLLECT || !eQ.equals(com.baidu.tbadk.imageManager.d.aQs)) {
                this.cNN.setTag(eQ);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eQ;
                if (eQ.startsWith("#(meme,")) {
                    this.cNN.setShowStaticDrawable(false);
                } else {
                    this.cNN.setShowStaticDrawable(true);
                }
                this.cNN.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cNO.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cNM.x = this.rect.left - ((this.cNM.width - linearLayout.getWidth()) / 2);
                this.cNM.y = (this.rect.top - this.cNM.height) + this.cNR;
                this.cNN.setVisibility(0);
                if (!this.cNS) {
                    this.mWindowManager.addView(this.cNN, this.cNM);
                    this.cNS = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cNN, this.cNM);
                }
                gridView.setSelection(i);
                if (this.cNT != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cNT - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cNT = i;
                this.cNK = gridView;
            }
        }
    }

    private void anx() {
        if (this.cNS && this.cNN.getVisibility() != 8 && this.cNK != null) {
            this.cNK.setSelection(-1);
            this.cNN.setVisibility(8);
            if (this.cNT != -1) {
                ((LinearLayout) this.cNK.getChildAt(this.cNT - this.cNK.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cNT = -1;
            this.cNK = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cOb.set(x, y);
                break;
            case 1:
            case 3:
                anx();
                break;
            case 2:
                this.cOb.set(x, y);
                if (this.cNS && this.cNN.getVisibility() != 8 && this.cNK != null) {
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
                this.cOb.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                anx();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    anx();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cNK != null) {
                        offsetRectIntoDescendantCoords(this.cNK, this.rect);
                        int pointToPosition = this.cNK.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cNK);
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
        if (this.cNS) {
            this.mWindowManager.removeView(this.cNN);
            this.cNS = false;
        }
        MessageManager.getInstance().unRegisterListener(this.acM);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cNW != null) {
            int size = this.cNW.size();
            if (i >= 0 && i < size) {
                this.cNU = this.cNW.get(i);
                if (this.azV != null && this.cNU != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.azV.setVisibility(this.cNU.anG() > 1 ? 0 : 4);
                        this.azV.setCount(this.cNU.anG());
                        if (this.cNU != null && this.cNU.anK() != this.cNY) {
                            this.cNY = this.cNU.anK();
                            if (this.cNZ != null) {
                                this.cNZ.jp(this.cNU.anK());
                            }
                        }
                    }
                    float anH = this.cNU.anH() + f;
                    this.azV.setPosition(anH);
                    this.cNL.setContentDescription(String.format(getResources().getString(d.k.emotion_selection), Integer.valueOf(((int) anH) + 1)) + String.format(getResources().getString(d.k.emotion_page), Integer.valueOf(this.cNU.anG())));
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
        this.azP = i;
        am.d(this.cNN, d.f.bg_expression_bubble, i);
        am.e(this, d.C0142d.cp_bg_line_d, i);
        this.azV.setSelector(am.v(i, d.f.dot_pb_expression_s));
        this.azV.setDrawable(am.v(i, d.f.dot_pb_expression_n));
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
        anx();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b cOe;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cOe = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cOe = bVar;
        }

        public int anz() {
            if (this.cOe == null) {
                return 0;
            }
            return this.cOe.anJ();
        }

        public com.baidu.tieba.emotion.editortool.b anA() {
            return this.cOe;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cOe == null) {
                return 0;
            }
            return this.cOe.anI();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.i.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cOe.anF() != 0) {
                    i2 = measuredWidth / this.cOe.anF();
                }
                if (this.cOe.getRow() != 0) {
                    i3 = measuredHeight / this.cOe.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cNR * 2, EmotionTabContentView.this.cNR * 2, EmotionTabContentView.this.cNR * 2, EmotionTabContentView.this.cNR * 2);
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
            if (this.cOe != null) {
                int anJ = this.cOe.anJ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.azP);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eQ = this.cOe.anD().eQ(anJ);
                tbImageView.setTag(eQ);
                if (!TextUtils.isEmpty(eQ)) {
                    Object a = com.baidu.adp.lib.f.c.ig().a(eQ, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eQ, false, null);
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
                if (this.cOe.anE() == EmotionGroupType.BIG_EMOTION) {
                    String eQ2 = this.cOe.anD().eQ(anJ);
                    if (!TextUtils.isEmpty(eQ2) && !eQ2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.azP == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0142d.cp_cont_c);
                        } else {
                            color = am.getColor(d.C0142d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eQ2.substring(eQ2.lastIndexOf("_") + 1, eQ2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eQ != null && eQ.length() > 3) {
                    linearLayout3.setContentDescription(eQ.substring(2, eQ.length() - 1));
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
            if (EmotionTabContentView.this.cNW == null) {
                return 0;
            }
            return EmotionTabContentView.this.cNW.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cOc.p(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cOc.ie();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cNW != null && i < EmotionTabContentView.this.cNW.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cNW.get(i);
                gridView2.setNumColumns(bVar.anF());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0142d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.anA() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b anA = aVar.anA();
                        if (anA.anE() == EmotionGroupType.BIG_EMOTION || anA.anE() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Qj != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.anA() != null) {
                                com.baidu.tieba.emotion.editortool.b anA = aVar.anA();
                                int anz = aVar.anz();
                                com.baidu.tbadk.editortools.emotiontool.c anD = anA.anD();
                                String eQ = anA.anD().eQ(anz + i2);
                                if (anD.HN() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aQs.equals(eQ)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eQ);
                                nVar.a(anD.HN());
                                nVar.fB(anD.getGroupName());
                                nVar.setPid(anD.getGroupId());
                                nVar.setWidth(anD.getWidth());
                                nVar.setHeight(anD.getHeight());
                                EmotionTabContentView.this.Qj.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.cNW != null) {
                int size = EmotionTabContentView.this.cNW.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cNW.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.azV.setVisibility(bVar.anG() > 1 ? 0 : 4);
                        EmotionTabContentView.this.azV.setCount(bVar.anG());
                        EmotionTabContentView.this.azV.setPosition(bVar.anH());
                        EmotionTabContentView.this.azV.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_selection), Integer.valueOf(bVar.anH() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_page), Integer.valueOf(bVar.anG())));
                    }
                    if (bVar != null && bVar.anK() != EmotionTabContentView.this.cNY) {
                        EmotionTabContentView.this.cNY = bVar.anK();
                        if (EmotionTabContentView.this.cNZ != null) {
                            EmotionTabContentView.this.cNZ.jp(bVar.anK());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cNZ = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acM);
    }
}
