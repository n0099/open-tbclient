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
import com.baidu.tieba.f;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private EditorTools Qg;
    private CustomMessageListener acr;
    private int atP;
    private int azF;
    private IndicatorView azL;
    private com.baidu.tieba.emotion.editortool.b cQA;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cQB;
    private List<com.baidu.tieba.emotion.editortool.b> cQC;
    private int cQD;
    private int cQE;
    private b cQF;
    private int cQG;
    private final Point cQH;
    private com.baidu.adp.lib.e.b<GridView> cQI;
    private EmotionViewPagerAdapter cQp;
    private GridView cQq;
    private LinearLayout cQr;
    private WindowManager.LayoutParams cQs;
    private GifView cQt;
    private ViewGroup cQu;
    private int cQv;
    private int cQw;
    private int cQx;
    private boolean cQy;
    private int cQz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface b {
        void jA(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cQz = -1;
        this.cQD = 0;
        this.cQE = -1;
        this.atP = -1;
        this.cQH = new Point();
        this.acr = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aL(new ArrayList(EmotionTabContentView.this.cQB));
                        if (EmotionTabContentView.this.cQp != null) {
                            EmotionTabContentView.this.cQp.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cQE < 0 || EmotionTabContentView.this.cQE >= EmotionTabContentView.this.cQB.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cQB.get(EmotionTabContentView.this.cQE)).HI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cQp != null) {
                                if (EmotionTabContentView.this.atP >= 0 && EmotionTabContentView.this.atP < EmotionTabContentView.this.cQC.size()) {
                                    EmotionTabContentView.this.cQA = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQC.get(EmotionTabContentView.this.atP);
                                    int aof = EmotionTabContentView.this.cQA.aof();
                                    EmotionTabContentView.this.azL.setCount(aof);
                                    EmotionTabContentView.this.azL.setVisibility(aof > 1 ? 0 : 4);
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
                                                    if (index >= 0 && index < EmotionTabContentView.this.cQC.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQC.get(index));
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
        this.cQz = -1;
        this.cQD = 0;
        this.cQE = -1;
        this.atP = -1;
        this.cQH = new Point();
        this.acr = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aL(new ArrayList(EmotionTabContentView.this.cQB));
                        if (EmotionTabContentView.this.cQp != null) {
                            EmotionTabContentView.this.cQp.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cQE < 0 || EmotionTabContentView.this.cQE >= EmotionTabContentView.this.cQB.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cQB.get(EmotionTabContentView.this.cQE)).HI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cQp != null) {
                                if (EmotionTabContentView.this.atP >= 0 && EmotionTabContentView.this.atP < EmotionTabContentView.this.cQC.size()) {
                                    EmotionTabContentView.this.cQA = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQC.get(EmotionTabContentView.this.atP);
                                    int aof = EmotionTabContentView.this.cQA.aof();
                                    EmotionTabContentView.this.azL.setCount(aof);
                                    EmotionTabContentView.this.azL.setVisibility(aof > 1 ? 0 : 4);
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
                                                    if (index >= 0 && index < EmotionTabContentView.this.cQC.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQC.get(index));
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
        this.cQB = new ArrayList();
        this.cQC = new ArrayList();
        this.cQI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
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
        LayoutInflater.from(context).inflate(f.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(f.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.cQt = new GifView(context);
        am.d(this.cQt, f.C0146f.bg_expression_bubble, this.azF);
        this.cQt.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cQs = new WindowManager.LayoutParams();
        this.cQv = context.getResources().getDimensionPixelSize(f.e.ds240);
        this.cQw = context.getResources().getDimensionPixelSize(f.e.ds252);
        this.cQx = context.getResources().getDimensionPixelSize(f.e.ds10);
        this.cQs.width = this.cQv;
        this.cQs.height = this.cQw;
        this.cQs.gravity = 51;
        this.cQs.format = -3;
        this.cQs.type = 1000;
        this.cQs.flags |= 56;
        this.cQu = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.azL = (IndicatorView) findViewById(f.g.face_tab_indicator);
        this.cQr = (LinearLayout) findViewById(f.g.face_tab_indicator_layout);
        this.cQr.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cQs.type = 1000;
            this.cQs.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cQB.clear();
        this.cQC.clear();
        if (list != null && !list.isEmpty()) {
            this.cQB.addAll(list);
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
                        bVar.jF(i3);
                        bVar.b(cVar.HI());
                        bVar.eX(HM);
                        bVar.eW(HL);
                        bVar.jB(i4);
                        bVar.jC(i5);
                        bVar.jD(i);
                        bVar.jE(i5 * HL * HM);
                        bVar.setEndIndex((i + i2) - 1);
                        this.cQC.add(bVar);
                    }
                }
            }
            this.cQD = this.cQC.size();
            for (int i6 = 0; i6 < this.cQD; i6++) {
                if (this.cQC != null && this.cQC.get(i6) != null) {
                    this.cQC.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jy(int i) {
        if (this.cQC != null) {
            int size = this.cQC.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cQC.get(i2);
                    if (bVar != null && bVar.aoj() == i) {
                        this.cQG = bVar.getIndex();
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
                jy(i);
                this.cQp = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cQp);
                this.mViewPager.setCurrentItem(this.cQG, true);
                if (this.cQF != null) {
                    this.cQF.jA(i);
                    this.cQE = i;
                }
            }
        }
    }

    public void jz(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cQC.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cQC.get(i3);
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
        if (this.cQz != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.anZ() != null) {
            com.baidu.tieba.emotion.editortool.b anZ = aVar.anZ();
            String eQ = anZ.aoc().eQ(aVar.anY() + i);
            if (anZ.aod() != EmotionGroupType.USER_COLLECT || !eQ.equals(com.baidu.tbadk.imageManager.d.aQp)) {
                this.cQt.setTag(eQ);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eQ;
                if (eQ.startsWith("#(meme,")) {
                    this.cQt.setShowStaticDrawable(false);
                } else {
                    this.cQt.setShowStaticDrawable(true);
                }
                this.cQt.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cQu.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cQs.x = this.rect.left - ((this.cQs.width - linearLayout.getWidth()) / 2);
                this.cQs.y = (this.rect.top - this.cQs.height) + this.cQx;
                this.cQt.setVisibility(0);
                if (!this.cQy) {
                    this.mWindowManager.addView(this.cQt, this.cQs);
                    this.cQy = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cQt, this.cQs);
                }
                gridView.setSelection(i);
                if (this.cQz != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cQz - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cQz = i;
                this.cQq = gridView;
            }
        }
    }

    private void anW() {
        if (this.cQy && this.cQt.getVisibility() != 8 && this.cQq != null) {
            this.cQq.setSelection(-1);
            this.cQt.setVisibility(8);
            if (this.cQz != -1) {
                ((LinearLayout) this.cQq.getChildAt(this.cQz - this.cQq.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cQz = -1;
            this.cQq = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cQH.set(x, y);
                break;
            case 1:
            case 3:
                anW();
                break;
            case 2:
                this.cQH.set(x, y);
                if (this.cQy && this.cQt.getVisibility() != 8 && this.cQq != null) {
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
                this.cQH.set(x, y);
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
                    if (this.cQq != null) {
                        offsetRectIntoDescendantCoords(this.cQq, this.rect);
                        int pointToPosition = this.cQq.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cQq);
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
        if (this.cQy) {
            this.mWindowManager.removeView(this.cQt);
            this.cQy = false;
        }
        MessageManager.getInstance().unRegisterListener(this.acr);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cQC != null) {
            int size = this.cQC.size();
            if (i >= 0 && i < size) {
                this.cQA = this.cQC.get(i);
                if (this.azL != null && this.cQA != null) {
                    if (this.atP != i) {
                        this.atP = i;
                        this.azL.setVisibility(this.cQA.aof() > 1 ? 0 : 4);
                        this.azL.setCount(this.cQA.aof());
                        if (this.cQA != null && this.cQA.aoj() != this.cQE) {
                            this.cQE = this.cQA.aoj();
                            if (this.cQF != null) {
                                this.cQF.jA(this.cQA.aoj());
                            }
                        }
                    }
                    float aog = this.cQA.aog() + f;
                    this.azL.setPosition(aog);
                    this.cQr.setContentDescription(String.format(getResources().getString(f.j.emotion_selection), Integer.valueOf(((int) aog) + 1)) + String.format(getResources().getString(f.j.emotion_page), Integer.valueOf(this.cQA.aof())));
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
        this.azF = i;
        am.d(this.cQt, f.C0146f.bg_expression_bubble, i);
        am.e(this, f.d.cp_bg_line_d, i);
        this.azL.setSelector(am.v(i, f.C0146f.dot_pb_expression_s));
        this.azL.setDrawable(am.v(i, f.C0146f.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b cQK;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cQK = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cQK = bVar;
        }

        public int anY() {
            if (this.cQK == null) {
                return 0;
            }
            return this.cQK.aoi();
        }

        public com.baidu.tieba.emotion.editortool.b anZ() {
            return this.cQK;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cQK == null) {
                return 0;
            }
            return this.cQK.aoh();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(f.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cQK.aoe() != 0) {
                    i2 = measuredWidth / this.cQK.aoe();
                }
                if (this.cQK.getRow() != 0) {
                    i3 = measuredHeight / this.cQK.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cQx * 2, EmotionTabContentView.this.cQx * 2, EmotionTabContentView.this.cQx * 2, EmotionTabContentView.this.cQx * 2);
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
            if (this.cQK != null) {
                int aoi = this.cQK.aoi() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(f.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.d(tbImageView, f.C0146f.btn_choose_face_selector, EmotionTabContentView.this.azF);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eQ = this.cQK.aoc().eQ(aoi);
                tbImageView.setTag(eQ);
                if (!TextUtils.isEmpty(eQ)) {
                    Object a = com.baidu.adp.lib.f.c.ih().a(eQ, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                TextView textView = (TextView) linearLayout3.findViewById(f.g.emotion_tab_content_tip);
                if (this.cQK.aod() == EmotionGroupType.BIG_EMOTION) {
                    String eQ2 = this.cQK.aoc().eQ(aoi);
                    if (!TextUtils.isEmpty(eQ2) && !eQ2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.azF == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(f.d.cp_cont_c);
                        } else {
                            color = am.getColor(f.d.cp_cont_c);
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
            if (EmotionTabContentView.this.cQC == null) {
                return 0;
            }
            return EmotionTabContentView.this.cQC.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cQI.p(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cQI.m9if();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cQC != null && i < EmotionTabContentView.this.cQC.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQC.get(i);
                gridView2.setNumColumns(bVar.aoe());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(f.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(f.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(f.e.ds28), 0);
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
                                String eQ = anZ.aoc().eQ(anY + i2);
                                if (aoc.HI() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aQp.equals(eQ)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eQ);
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
            if (EmotionTabContentView.this.cQC != null) {
                int size = EmotionTabContentView.this.cQC.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.atP) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQC.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.atP = i;
                        EmotionTabContentView.this.azL.setVisibility(bVar.aof() > 1 ? 0 : 4);
                        EmotionTabContentView.this.azL.setCount(bVar.aof());
                        EmotionTabContentView.this.azL.setPosition(bVar.aog());
                        EmotionTabContentView.this.azL.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(f.j.emotion_selection), Integer.valueOf(bVar.aog() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(f.j.emotion_page), Integer.valueOf(bVar.aof())));
                    }
                    if (bVar != null && bVar.aoj() != EmotionTabContentView.this.cQE) {
                        EmotionTabContentView.this.cQE = bVar.aoj();
                        if (EmotionTabContentView.this.cQF != null) {
                            EmotionTabContentView.this.cQF.jA(bVar.aoj());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cQF = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acr);
    }
}
