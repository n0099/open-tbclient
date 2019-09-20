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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Sv;
    private EditorTools TT;
    private CustomMessageListener bDW;
    private int ceL;
    private IndicatorView ceR;
    private final Rect cyf;
    private EmotionViewPagerAdapter eVL;
    private GridView eVM;
    private LinearLayout eVN;
    private WindowManager.LayoutParams eVO;
    private GifView eVP;
    private ViewGroup eVQ;
    private int eVR;
    private int eVS;
    private int eVT;
    private boolean eVU;
    private int eVV;
    private com.baidu.tieba.emotion.editortool.b eVW;
    private List<com.baidu.tbadk.editortools.emotiontool.c> eVX;
    private List<com.baidu.tieba.emotion.editortool.b> eVY;
    private int eVZ;
    private int eWa;
    private b eWb;
    private int eWc;
    private final Point eWd;
    private com.baidu.adp.lib.e.b<GridView> eWe;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes2.dex */
    public interface b {
        void qq(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyf = new Rect();
        this.eVV = -1;
        this.eVZ = 0;
        this.eWa = -1;
        this.Sv = -1;
        this.eWd = new Point();
        this.bDW = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bA(new ArrayList(EmotionTabContentView.this.eVX));
                        if (EmotionTabContentView.this.eVL != null) {
                            EmotionTabContentView.this.eVL.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eWa < 0 || EmotionTabContentView.this.eWa >= EmotionTabContentView.this.eVX.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eVX.get(EmotionTabContentView.this.eWa)).asC() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eVL != null) {
                                if (EmotionTabContentView.this.Sv >= 0 && EmotionTabContentView.this.Sv < EmotionTabContentView.this.eVY.size()) {
                                    EmotionTabContentView.this.eVW = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eVY.get(EmotionTabContentView.this.Sv);
                                    int bfx = EmotionTabContentView.this.eVW.bfx();
                                    EmotionTabContentView.this.ceR.setCount(bfx);
                                    EmotionTabContentView.this.ceR.setVisibility(bfx > 1 ? 0 : 4);
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
                                                    int index = aVar.bfr().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eVY.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eVY.get(index));
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
        this.cyf = new Rect();
        this.eVV = -1;
        this.eVZ = 0;
        this.eWa = -1;
        this.Sv = -1;
        this.eWd = new Point();
        this.bDW = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bA(new ArrayList(EmotionTabContentView.this.eVX));
                        if (EmotionTabContentView.this.eVL != null) {
                            EmotionTabContentView.this.eVL.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eWa < 0 || EmotionTabContentView.this.eWa >= EmotionTabContentView.this.eVX.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eVX.get(EmotionTabContentView.this.eWa)).asC() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eVL != null) {
                                if (EmotionTabContentView.this.Sv >= 0 && EmotionTabContentView.this.Sv < EmotionTabContentView.this.eVY.size()) {
                                    EmotionTabContentView.this.eVW = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eVY.get(EmotionTabContentView.this.Sv);
                                    int bfx = EmotionTabContentView.this.eVW.bfx();
                                    EmotionTabContentView.this.ceR.setCount(bfx);
                                    EmotionTabContentView.this.ceR.setVisibility(bfx > 1 ? 0 : 4);
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
                                                    int index = aVar.bfr().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eVY.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eVY.get(index));
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
        this.eVX = new ArrayList();
        this.eVY = new ArrayList();
        this.eWe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bfp */
            public GridView makeObject() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public GridView activateObject(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public GridView passivateObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.eVP = new GifView(context);
        am.g(this.eVP, R.drawable.bg_expression_bubble, this.ceL);
        this.eVP.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.eVO = new WindowManager.LayoutParams();
        this.eVR = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.eVS = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.eVT = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eVO.width = this.eVR;
        this.eVO.height = this.eVS;
        this.eVO.gravity = 51;
        this.eVO.format = -3;
        this.eVO.type = 1000;
        this.eVO.flags |= 56;
        this.eVQ = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ceR = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.eVN = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.eVN.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.eVO.type = 1000;
            this.eVO.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.eVX.clear();
        this.eVY.clear();
        if (list != null && !list.isEmpty()) {
            this.eVX.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int asF = cVar.asF();
                    int asG = cVar.asG();
                    int i4 = emotionsCount / (asF * asG);
                    if (emotionsCount % (asF * asG) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = asF * asG;
                        } else {
                            i = emotionsCount - ((asF * asG) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.qw(i3);
                        bVar.b(cVar.asC());
                        bVar.kD(asG);
                        bVar.kC(asF);
                        bVar.qr(i4);
                        bVar.qs(i5);
                        bVar.qt(i);
                        bVar.qu(i5 * asF * asG);
                        bVar.qv((i + i2) - 1);
                        this.eVY.add(bVar);
                    }
                }
            }
            this.eVZ = this.eVY.size();
            for (int i6 = 0; i6 < this.eVZ; i6++) {
                if (this.eVY != null && this.eVY.get(i6) != null) {
                    this.eVY.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void qo(int i) {
        if (this.eVY != null) {
            int size = this.eVY.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.eVY.get(i2);
                    if (bVar != null && bVar.bfB() == i) {
                        this.eWc = bVar.getIndex();
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
                bA(list);
                qo(i);
                this.eVL = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eVL);
                this.mViewPager.setCurrentItem(this.eWc, true);
                if (this.eWb != null) {
                    this.eWb.qq(i);
                    this.eWa = i;
                }
            }
        }
    }

    public void qp(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.eVY.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.eVY.get(i3);
                        if (bVar == null || bVar.bfB() != i) {
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
        if (this.eVV != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bfr() != null) {
            com.baidu.tieba.emotion.editortool.b bfr = aVar.bfr();
            String kw = bfr.bfu().kw(aVar.bfq() + i);
            if (bfr.bfv() != EmotionGroupType.USER_COLLECT || !kw.equals(com.baidu.tbadk.imageManager.d.cxi)) {
                this.eVP.setTag(kw);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = kw;
                if (kw.startsWith("#(meme,")) {
                    this.eVP.setShowStaticDrawable(false);
                } else {
                    this.eVP.setShowStaticDrawable(true);
                }
                this.eVP.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.cyf);
                this.eVQ.offsetDescendantRectToMyCoords(linearLayout, this.cyf);
                this.eVO.x = this.cyf.left - ((this.eVO.width - linearLayout.getWidth()) / 2);
                this.eVO.y = (this.cyf.top - this.eVO.height) + this.eVT;
                this.eVP.setVisibility(0);
                if (!this.eVU) {
                    this.mWindowManager.addView(this.eVP, this.eVO);
                    this.eVU = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.eVP, this.eVO);
                }
                gridView.setSelection(i);
                if (this.eVV != -1) {
                    ((LinearLayout) gridView.getChildAt(this.eVV - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.eVV = i;
                this.eVM = gridView;
            }
        }
    }

    private void KZ() {
        if (this.eVU && this.eVP.getVisibility() != 8 && this.eVM != null) {
            this.eVM.setSelection(-1);
            this.eVP.setVisibility(8);
            if (this.eVV != -1) {
                ((LinearLayout) this.eVM.getChildAt(this.eVV - this.eVM.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.eVV = -1;
            this.eVM = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eWd.set(x, y);
                break;
            case 1:
            case 3:
                KZ();
                break;
            case 2:
                this.eWd.set(x, y);
                if (this.eVU && this.eVP.getVisibility() != 8 && this.eVM != null) {
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
                this.eWd.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                KZ();
                break;
            case 2:
                getFocusedRect(this.cyf);
                if (!this.cyf.contains(x, y)) {
                    KZ();
                    break;
                } else {
                    this.cyf.set(x, y, x + 1, y + 1);
                    if (this.eVM != null) {
                        offsetRectIntoDescendantCoords(this.eVM, this.cyf);
                        int pointToPosition = this.eVM.pointToPosition(this.cyf.left, this.cyf.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eVM);
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
        if (this.eVU) {
            this.mWindowManager.removeView(this.eVP);
            this.eVU = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bDW);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.eVY != null) {
            int size = this.eVY.size();
            if (i >= 0 && i < size) {
                this.eVW = this.eVY.get(i);
                if (this.ceR != null && this.eVW != null) {
                    if (this.Sv != i) {
                        this.Sv = i;
                        this.ceR.setVisibility(this.eVW.bfx() > 1 ? 0 : 4);
                        this.ceR.setCount(this.eVW.bfx());
                        if (this.eVW != null && this.eVW.bfB() != this.eWa) {
                            this.eWa = this.eVW.bfB();
                            if (this.eWb != null) {
                                this.eWb.qq(this.eVW.bfB());
                            }
                        }
                    }
                    float bfy = this.eVW.bfy() + f;
                    this.ceR.setPosition(bfy);
                    this.eVN.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bfy) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.eVW.bfx())));
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
        this.ceL = i;
        am.g(this.eVP, R.drawable.bg_expression_bubble, i);
        am.h(this, R.color.cp_bg_line_d, i);
        this.ceR.setSelector(am.V(i, R.drawable.dot_pb_expression_s));
        this.ceR.setDrawable(am.V(i, R.drawable.dot_pb_expression_n));
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
        KZ();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b eWg;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eWg = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eWg = bVar;
        }

        public int bfq() {
            if (this.eWg == null) {
                return 0;
            }
            return this.eWg.bfA();
        }

        public com.baidu.tieba.emotion.editortool.b bfr() {
            return this.eWg;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eWg == null) {
                return 0;
            }
            return this.eWg.bfz();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.eWg.bfw() != 0) {
                    i2 = measuredWidth / this.eWg.bfw();
                }
                if (this.eWg.atr() != 0) {
                    i3 = measuredHeight / this.eWg.atr();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.eVT * 2, EmotionTabContentView.this.eVT * 2, EmotionTabContentView.this.eVT * 2, EmotionTabContentView.this.eVT * 2);
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
            if (this.eWg != null) {
                int bfA = this.eWg.bfA() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.g(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ceL);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String kw = this.eWg.bfu().kw(bfA);
                tbImageView.setTag(kw);
                if (!TextUtils.isEmpty(kw)) {
                    Object a = com.baidu.adp.lib.f.c.iE().a(kw, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, kw, false, null);
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
                TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
                if (this.eWg.bfv() == EmotionGroupType.BIG_EMOTION) {
                    String kw2 = this.eWg.bfu().kw(bfA);
                    if (!TextUtils.isEmpty(kw2) && !kw2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ceL == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(kw2.substring(kw2.lastIndexOf("_") + 1, kw2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (kw != null && kw.length() > 3) {
                    linearLayout3.setContentDescription(kw.substring(2, kw.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes2.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.eVY == null) {
                return 0;
            }
            return EmotionTabContentView.this.eVY.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eWe.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eWe.iD();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.eVY != null && i < EmotionTabContentView.this.eVY.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eVY.get(i);
                gridView2.setNumColumns(bVar.bfw());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bfr() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bfr = aVar.bfr();
                        if (bfr.bfv() == EmotionGroupType.BIG_EMOTION || bfr.bfv() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.TT != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bfr() != null) {
                                com.baidu.tieba.emotion.editortool.b bfr = aVar.bfr();
                                int bfq = aVar.bfq();
                                com.baidu.tbadk.editortools.emotiontool.c bfu = bfr.bfu();
                                String kw = bfr.bfu().kw(bfq + i2);
                                if (bfu.asC() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cxi.equals(kw)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(kw);
                                pVar.a(bfu.asC());
                                pVar.pm(bfu.getGroupName());
                                pVar.setPid(bfu.getGroupId());
                                pVar.setWidth(bfu.getWidth());
                                pVar.setHeight(bfu.getHeight());
                                EmotionTabContentView.this.TT.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.eVY != null) {
                int size = EmotionTabContentView.this.eVY.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Sv) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eVY.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Sv = i;
                        EmotionTabContentView.this.ceR.setVisibility(bVar.bfx() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ceR.setCount(bVar.bfx());
                        EmotionTabContentView.this.ceR.setPosition(bVar.bfy());
                        EmotionTabContentView.this.ceR.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bfy() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bfx())));
                    }
                    if (bVar != null && bVar.bfB() != EmotionTabContentView.this.eWa) {
                        EmotionTabContentView.this.eWa = bVar.bfB();
                        if (EmotionTabContentView.this.eWb != null) {
                            EmotionTabContentView.this.eWb.qq(bVar.bfB());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.eWb = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bDW);
    }
}
