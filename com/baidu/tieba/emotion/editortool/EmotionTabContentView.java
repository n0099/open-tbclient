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
    private EditorTools Qg;
    private CustomMessageListener acq;
    private int atO;
    private int azI;
    private IndicatorView azO;
    private int cQA;
    private boolean cQB;
    private int cQC;
    private com.baidu.tieba.emotion.editortool.b cQD;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cQE;
    private List<com.baidu.tieba.emotion.editortool.b> cQF;
    private int cQG;
    private int cQH;
    private b cQI;
    private int cQJ;
    private final Point cQK;
    private com.baidu.adp.lib.e.b<GridView> cQL;
    private EmotionViewPagerAdapter cQs;
    private GridView cQt;
    private LinearLayout cQu;
    private WindowManager.LayoutParams cQv;
    private GifView cQw;
    private ViewGroup cQx;
    private int cQy;
    private int cQz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface b {
        void jB(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cQC = -1;
        this.cQG = 0;
        this.cQH = -1;
        this.atO = -1;
        this.cQK = new Point();
        this.acq = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aL(new ArrayList(EmotionTabContentView.this.cQE));
                        if (EmotionTabContentView.this.cQs != null) {
                            EmotionTabContentView.this.cQs.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cQH < 0 || EmotionTabContentView.this.cQH >= EmotionTabContentView.this.cQE.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cQE.get(EmotionTabContentView.this.cQH)).HI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cQs != null) {
                                if (EmotionTabContentView.this.atO >= 0 && EmotionTabContentView.this.atO < EmotionTabContentView.this.cQF.size()) {
                                    EmotionTabContentView.this.cQD = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQF.get(EmotionTabContentView.this.atO);
                                    int aof = EmotionTabContentView.this.cQD.aof();
                                    EmotionTabContentView.this.azO.setCount(aof);
                                    EmotionTabContentView.this.azO.setVisibility(aof > 1 ? 0 : 4);
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
                                                    int index = aVar.anZ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cQF.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQF.get(index));
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
        this.cQC = -1;
        this.cQG = 0;
        this.cQH = -1;
        this.atO = -1;
        this.cQK = new Point();
        this.acq = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aL(new ArrayList(EmotionTabContentView.this.cQE));
                        if (EmotionTabContentView.this.cQs != null) {
                            EmotionTabContentView.this.cQs.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cQH < 0 || EmotionTabContentView.this.cQH >= EmotionTabContentView.this.cQE.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cQE.get(EmotionTabContentView.this.cQH)).HI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cQs != null) {
                                if (EmotionTabContentView.this.atO >= 0 && EmotionTabContentView.this.atO < EmotionTabContentView.this.cQF.size()) {
                                    EmotionTabContentView.this.cQD = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQF.get(EmotionTabContentView.this.atO);
                                    int aof = EmotionTabContentView.this.cQD.aof();
                                    EmotionTabContentView.this.azO.setCount(aof);
                                    EmotionTabContentView.this.azO.setVisibility(aof > 1 ? 0 : 4);
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
                                                    int index = aVar.anZ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cQF.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQF.get(index));
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
        this.cQE = new ArrayList();
        this.cQF = new ArrayList();
        this.cQL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anX */
            public GridView ig() {
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.cQw = new GifView(context);
        am.d(this.cQw, d.f.bg_expression_bubble, this.azI);
        this.cQw.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cQv = new WindowManager.LayoutParams();
        this.cQy = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.cQz = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.cQA = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.cQv.width = this.cQy;
        this.cQv.height = this.cQz;
        this.cQv.gravity = 51;
        this.cQv.format = -3;
        this.cQv.type = 1000;
        this.cQv.flags |= 56;
        this.cQx = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.azO = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cQu = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cQu.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cQv.type = 1000;
            this.cQv.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cQE.clear();
        this.cQF.clear();
        if (list != null && !list.isEmpty()) {
            this.cQE.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int HL = cVar.HL();
                    int HM = cVar.HM();
                    int i4 = emotionsCount / (HL * HM);
                    if (emotionsCount % (HL * HM) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = HL * HM;
                        } else {
                            i = emotionsCount - ((HL * HM) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.jG(i3);
                        bVar.b(cVar.HI());
                        bVar.eY(HM);
                        bVar.eX(HL);
                        bVar.jC(i4);
                        bVar.jD(i5);
                        bVar.jE(i);
                        bVar.jF(i5 * HL * HM);
                        bVar.setEndIndex((i + i2) - 1);
                        this.cQF.add(bVar);
                    }
                }
            }
            this.cQG = this.cQF.size();
            for (int i6 = 0; i6 < this.cQG; i6++) {
                if (this.cQF != null && this.cQF.get(i6) != null) {
                    this.cQF.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jz(int i) {
        if (this.cQF != null) {
            int size = this.cQF.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cQF.get(i2);
                    if (bVar != null && bVar.aoj() == i) {
                        this.cQJ = bVar.getIndex();
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
                aL(list);
                jz(i);
                this.cQs = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cQs);
                this.mViewPager.setCurrentItem(this.cQJ, true);
                if (this.cQI != null) {
                    this.cQI.jB(i);
                    this.cQH = i;
                }
            }
        }
    }

    public void jA(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cQF.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cQF.get(i3);
                        if (bVar == null || bVar.aoj() != i) {
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
        if (this.cQC != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.anZ() != null) {
            com.baidu.tieba.emotion.editortool.b anZ = aVar.anZ();
            String eR = anZ.aoc().eR(aVar.anY() + i);
            if (anZ.aod() != EmotionGroupType.USER_COLLECT || !eR.equals(com.baidu.tbadk.imageManager.d.aQs)) {
                this.cQw.setTag(eR);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eR;
                if (eR.startsWith("#(meme,")) {
                    this.cQw.setShowStaticDrawable(false);
                } else {
                    this.cQw.setShowStaticDrawable(true);
                }
                this.cQw.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cQx.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cQv.x = this.rect.left - ((this.cQv.width - linearLayout.getWidth()) / 2);
                this.cQv.y = (this.rect.top - this.cQv.height) + this.cQA;
                this.cQw.setVisibility(0);
                if (!this.cQB) {
                    this.mWindowManager.addView(this.cQw, this.cQv);
                    this.cQB = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cQw, this.cQv);
                }
                gridView.setSelection(i);
                if (this.cQC != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cQC - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cQC = i;
                this.cQt = gridView;
            }
        }
    }

    private void anW() {
        if (this.cQB && this.cQw.getVisibility() != 8 && this.cQt != null) {
            this.cQt.setSelection(-1);
            this.cQw.setVisibility(8);
            if (this.cQC != -1) {
                ((LinearLayout) this.cQt.getChildAt(this.cQC - this.cQt.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cQC = -1;
            this.cQt = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cQK.set(x, y);
                break;
            case 1:
            case 3:
                anW();
                break;
            case 2:
                this.cQK.set(x, y);
                if (this.cQB && this.cQw.getVisibility() != 8 && this.cQt != null) {
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
                this.cQK.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                anW();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    anW();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cQt != null) {
                        offsetRectIntoDescendantCoords(this.cQt, this.rect);
                        int pointToPosition = this.cQt.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cQt);
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
        if (this.cQB) {
            this.mWindowManager.removeView(this.cQw);
            this.cQB = false;
        }
        MessageManager.getInstance().unRegisterListener(this.acq);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cQF != null) {
            int size = this.cQF.size();
            if (i >= 0 && i < size) {
                this.cQD = this.cQF.get(i);
                if (this.azO != null && this.cQD != null) {
                    if (this.atO != i) {
                        this.atO = i;
                        this.azO.setVisibility(this.cQD.aof() > 1 ? 0 : 4);
                        this.azO.setCount(this.cQD.aof());
                        if (this.cQD != null && this.cQD.aoj() != this.cQH) {
                            this.cQH = this.cQD.aoj();
                            if (this.cQI != null) {
                                this.cQI.jB(this.cQD.aoj());
                            }
                        }
                    }
                    float aog = this.cQD.aog() + f;
                    this.azO.setPosition(aog);
                    this.cQu.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aog) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.cQD.aof())));
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
        this.azI = i;
        am.d(this.cQw, d.f.bg_expression_bubble, i);
        am.e(this, d.C0140d.cp_bg_line_d, i);
        this.azO.setSelector(am.v(i, d.f.dot_pb_expression_s));
        this.azO.setDrawable(am.v(i, d.f.dot_pb_expression_n));
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
        anW();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b cQN;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cQN = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cQN = bVar;
        }

        public int anY() {
            if (this.cQN == null) {
                return 0;
            }
            return this.cQN.aoi();
        }

        public com.baidu.tieba.emotion.editortool.b anZ() {
            return this.cQN;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cQN == null) {
                return 0;
            }
            return this.cQN.aoh();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cQN.aoe() != 0) {
                    i2 = measuredWidth / this.cQN.aoe();
                }
                if (this.cQN.getRow() != 0) {
                    i3 = measuredHeight / this.cQN.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cQA * 2, EmotionTabContentView.this.cQA * 2, EmotionTabContentView.this.cQA * 2, EmotionTabContentView.this.cQA * 2);
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
            if (this.cQN != null) {
                int aoi = this.cQN.aoi() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.azI);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eR = this.cQN.aoc().eR(aoi);
                tbImageView.setTag(eR);
                if (!TextUtils.isEmpty(eR)) {
                    Object a = com.baidu.adp.lib.f.c.ih().a(eR, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eR, false, null);
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
                if (this.cQN.aod() == EmotionGroupType.BIG_EMOTION) {
                    String eR2 = this.cQN.aoc().eR(aoi);
                    if (!TextUtils.isEmpty(eR2) && !eR2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.azI == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0140d.cp_cont_c);
                        } else {
                            color = am.getColor(d.C0140d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eR2.substring(eR2.lastIndexOf("_") + 1, eR2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eR != null && eR.length() > 3) {
                    linearLayout3.setContentDescription(eR.substring(2, eR.length() - 1));
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
            if (EmotionTabContentView.this.cQF == null) {
                return 0;
            }
            return EmotionTabContentView.this.cQF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cQL.p(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cQL.m9if();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cQF != null && i < EmotionTabContentView.this.cQF.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQF.get(i);
                gridView2.setNumColumns(bVar.aoe());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0140d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.anZ() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b anZ = aVar.anZ();
                        if (anZ.aod() == EmotionGroupType.BIG_EMOTION || anZ.aod() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Qg != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.anZ() != null) {
                                com.baidu.tieba.emotion.editortool.b anZ = aVar.anZ();
                                int anY = aVar.anY();
                                com.baidu.tbadk.editortools.emotiontool.c aoc = anZ.aoc();
                                String eR = anZ.aoc().eR(anY + i2);
                                if (aoc.HI() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aQs.equals(eR)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eR);
                                nVar.a(aoc.HI());
                                nVar.fz(aoc.getGroupName());
                                nVar.setPid(aoc.getGroupId());
                                nVar.setWidth(aoc.getWidth());
                                nVar.setHeight(aoc.getHeight());
                                EmotionTabContentView.this.Qg.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.cQF != null) {
                int size = EmotionTabContentView.this.cQF.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.atO) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQF.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.atO = i;
                        EmotionTabContentView.this.azO.setVisibility(bVar.aof() > 1 ? 0 : 4);
                        EmotionTabContentView.this.azO.setCount(bVar.aof());
                        EmotionTabContentView.this.azO.setPosition(bVar.aog());
                        EmotionTabContentView.this.azO.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(bVar.aog() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(bVar.aof())));
                    }
                    if (bVar != null && bVar.aoj() != EmotionTabContentView.this.cQH) {
                        EmotionTabContentView.this.cQH = bVar.aoj();
                        if (EmotionTabContentView.this.cQI != null) {
                            EmotionTabContentView.this.cQI.jB(bVar.aoj());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cQI = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acq);
    }
}
