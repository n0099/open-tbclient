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
    private int aCA;
    private int aIf;
    private IndicatorView aIl;
    private CustomMessageListener akD;
    private EmotionViewPagerAdapter dfD;
    private GridView dfE;
    private LinearLayout dfF;
    private WindowManager.LayoutParams dfG;
    private GifView dfH;
    private ViewGroup dfI;
    private int dfJ;
    private int dfK;
    private int dfL;
    private boolean dfM;
    private int dfN;
    private com.baidu.tieba.emotion.editortool.b dfO;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dfP;
    private List<com.baidu.tieba.emotion.editortool.b> dfQ;
    private int dfR;
    private int dfS;
    private b dfT;
    private int dfU;
    private final Point dfV;
    private com.baidu.adp.lib.e.b<GridView> dfW;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes5.dex */
    public interface b {
        void kP(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dfN = -1;
        this.dfR = 0;
        this.dfS = -1;
        this.aCA = -1;
        this.dfV = new Point();
        this.akD = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.ba(new ArrayList(EmotionTabContentView.this.dfP));
                        if (EmotionTabContentView.this.dfD != null) {
                            EmotionTabContentView.this.dfD.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dfS < 0 || EmotionTabContentView.this.dfS >= EmotionTabContentView.this.dfP.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dfP.get(EmotionTabContentView.this.dfS)).Li() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dfD != null) {
                                if (EmotionTabContentView.this.aCA >= 0 && EmotionTabContentView.this.aCA < EmotionTabContentView.this.dfQ.size()) {
                                    EmotionTabContentView.this.dfO = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dfQ.get(EmotionTabContentView.this.aCA);
                                    int asQ = EmotionTabContentView.this.dfO.asQ();
                                    EmotionTabContentView.this.aIl.setCount(asQ);
                                    EmotionTabContentView.this.aIl.setVisibility(asQ > 1 ? 0 : 4);
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
                                                    int index = aVar.asK().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dfQ.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dfQ.get(index));
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
        this.dfN = -1;
        this.dfR = 0;
        this.dfS = -1;
        this.aCA = -1;
        this.dfV = new Point();
        this.akD = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.ba(new ArrayList(EmotionTabContentView.this.dfP));
                        if (EmotionTabContentView.this.dfD != null) {
                            EmotionTabContentView.this.dfD.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dfS < 0 || EmotionTabContentView.this.dfS >= EmotionTabContentView.this.dfP.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dfP.get(EmotionTabContentView.this.dfS)).Li() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dfD != null) {
                                if (EmotionTabContentView.this.aCA >= 0 && EmotionTabContentView.this.aCA < EmotionTabContentView.this.dfQ.size()) {
                                    EmotionTabContentView.this.dfO = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dfQ.get(EmotionTabContentView.this.aCA);
                                    int asQ = EmotionTabContentView.this.dfO.asQ();
                                    EmotionTabContentView.this.aIl.setCount(asQ);
                                    EmotionTabContentView.this.aIl.setVisibility(asQ > 1 ? 0 : 4);
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
                                                    int index = aVar.asK().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dfQ.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dfQ.get(index));
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
        this.dfP = new ArrayList();
        this.dfQ = new ArrayList();
        this.dfW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: asI */
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
        this.dfH = new GifView(context);
        al.d(this.dfH, e.f.bg_expression_bubble, this.aIf);
        this.dfH.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.dfG = new WindowManager.LayoutParams();
        this.dfJ = context.getResources().getDimensionPixelSize(e.C0200e.ds240);
        this.dfK = context.getResources().getDimensionPixelSize(e.C0200e.ds252);
        this.dfL = context.getResources().getDimensionPixelSize(e.C0200e.ds10);
        this.dfG.width = this.dfJ;
        this.dfG.height = this.dfK;
        this.dfG.gravity = 51;
        this.dfG.format = -3;
        this.dfG.type = 1000;
        this.dfG.flags |= 56;
        this.dfI = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aIl = (IndicatorView) findViewById(e.g.face_tab_indicator);
        this.dfF = (LinearLayout) findViewById(e.g.face_tab_indicator_layout);
        this.dfF.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dfG.type = 1000;
            this.dfG.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dfP.clear();
        this.dfQ.clear();
        if (list != null && !list.isEmpty()) {
            this.dfP.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Ll = cVar.Ll();
                    int Lm = cVar.Lm();
                    int i4 = emotionsCount / (Ll * Lm);
                    if (emotionsCount % (Ll * Lm) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = Ll * Lm;
                        } else {
                            i = emotionsCount - ((Ll * Lm) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.kU(i3);
                        bVar.b(cVar.Li());
                        bVar.fG(Lm);
                        bVar.fF(Ll);
                        bVar.kQ(i4);
                        bVar.kR(i5);
                        bVar.kS(i);
                        bVar.kT(i5 * Ll * Lm);
                        bVar.setEndIndex((i + i2) - 1);
                        this.dfQ.add(bVar);
                    }
                }
            }
            this.dfR = this.dfQ.size();
            for (int i6 = 0; i6 < this.dfR; i6++) {
                if (this.dfQ != null && this.dfQ.get(i6) != null) {
                    this.dfQ.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void kN(int i) {
        if (this.dfQ != null) {
            int size = this.dfQ.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.dfQ.get(i2);
                    if (bVar != null && bVar.asU() == i) {
                        this.dfU = bVar.getIndex();
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
                ba(list);
                kN(i);
                this.dfD = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.dfD);
                this.mViewPager.setCurrentItem(this.dfU, true);
                if (this.dfT != null) {
                    this.dfT.kP(i);
                    this.dfS = i;
                }
            }
        }
    }

    public void kO(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.dfQ.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.dfQ.get(i3);
                        if (bVar == null || bVar.asU() != i) {
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
        if (this.dfN != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.asK() != null) {
            com.baidu.tieba.emotion.editortool.b asK = aVar.asK();
            String fz = asK.asN().fz(aVar.asJ() + i);
            if (asK.asO() != EmotionGroupType.USER_COLLECT || !fz.equals(com.baidu.tbadk.imageManager.d.aYU)) {
                this.dfH.setTag(fz);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = fz;
                if (fz.startsWith("#(meme,")) {
                    this.dfH.setShowStaticDrawable(false);
                } else {
                    this.dfH.setShowStaticDrawable(true);
                }
                this.dfH.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dfI.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dfG.x = this.rect.left - ((this.dfG.width - linearLayout.getWidth()) / 2);
                this.dfG.y = (this.rect.top - this.dfG.height) + this.dfL;
                this.dfH.setVisibility(0);
                if (!this.dfM) {
                    this.mWindowManager.addView(this.dfH, this.dfG);
                    this.dfM = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dfH, this.dfG);
                }
                gridView.setSelection(i);
                if (this.dfN != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dfN - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dfN = i;
                this.dfE = gridView;
            }
        }
    }

    private void onUp() {
        if (this.dfM && this.dfH.getVisibility() != 8 && this.dfE != null) {
            this.dfE.setSelection(-1);
            this.dfH.setVisibility(8);
            if (this.dfN != -1) {
                ((LinearLayout) this.dfE.getChildAt(this.dfN - this.dfE.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dfN = -1;
            this.dfE = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dfV.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.dfV.set(x, y);
                if (this.dfM && this.dfH.getVisibility() != 8 && this.dfE != null) {
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
                this.dfV.set(x, y);
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
                    if (this.dfE != null) {
                        offsetRectIntoDescendantCoords(this.dfE, this.rect);
                        int pointToPosition = this.dfE.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dfE);
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
        if (this.dfM) {
            this.mWindowManager.removeView(this.dfH);
            this.dfM = false;
        }
        MessageManager.getInstance().unRegisterListener(this.akD);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dfQ != null) {
            int size = this.dfQ.size();
            if (i >= 0 && i < size) {
                this.dfO = this.dfQ.get(i);
                if (this.aIl != null && this.dfO != null) {
                    if (this.aCA != i) {
                        this.aCA = i;
                        this.aIl.setVisibility(this.dfO.asQ() > 1 ? 0 : 4);
                        this.aIl.setCount(this.dfO.asQ());
                        if (this.dfO != null && this.dfO.asU() != this.dfS) {
                            this.dfS = this.dfO.asU();
                            if (this.dfT != null) {
                                this.dfT.kP(this.dfO.asU());
                            }
                        }
                    }
                    float asR = this.dfO.asR() + f;
                    this.aIl.setPosition(asR);
                    this.dfF.setContentDescription(String.format(getResources().getString(e.j.emotion_selection), Integer.valueOf(((int) asR) + 1)) + String.format(getResources().getString(e.j.emotion_page), Integer.valueOf(this.dfO.asQ())));
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
        this.aIf = i;
        al.d(this.dfH, e.f.bg_expression_bubble, i);
        al.e(this, e.d.cp_bg_line_d, i);
        this.aIl.setSelector(al.x(i, e.f.dot_pb_expression_s));
        this.aIl.setDrawable(al.x(i, e.f.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b dfY;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dfY = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dfY = bVar;
        }

        public int asJ() {
            if (this.dfY == null) {
                return 0;
            }
            return this.dfY.asT();
        }

        public com.baidu.tieba.emotion.editortool.b asK() {
            return this.dfY;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dfY == null) {
                return 0;
            }
            return this.dfY.asS();
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
                if (this.dfY.asP() != 0) {
                    i2 = measuredWidth / this.dfY.asP();
                }
                if (this.dfY.getRow() != 0) {
                    i3 = measuredHeight / this.dfY.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dfL * 2, EmotionTabContentView.this.dfL * 2, EmotionTabContentView.this.dfL * 2, EmotionTabContentView.this.dfL * 2);
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
            if (this.dfY != null) {
                int asT = this.dfY.asT() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(e.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, e.f.btn_choose_face_selector, EmotionTabContentView.this.aIf);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String fz = this.dfY.asN().fz(asT);
                tbImageView.setTag(fz);
                if (!TextUtils.isEmpty(fz)) {
                    Object a = com.baidu.adp.lib.f.c.jA().a(fz, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, fz, false, null);
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
                if (this.dfY.asO() == EmotionGroupType.BIG_EMOTION) {
                    String fz2 = this.dfY.asN().fz(asT);
                    if (!TextUtils.isEmpty(fz2) && !fz2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aIf == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(e.d.cp_cont_c);
                        } else {
                            color = al.getColor(e.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(fz2.substring(fz2.lastIndexOf(BaseRequestAction.SPLITE) + 1, fz2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (fz != null && fz.length() > 3) {
                    linearLayout3.setContentDescription(fz.substring(2, fz.length() - 1));
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
            if (EmotionTabContentView.this.dfQ == null) {
                return 0;
            }
            return EmotionTabContentView.this.dfQ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dfW.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dfW.jy();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dfQ != null && i < EmotionTabContentView.this.dfQ.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dfQ.get(i);
                gridView2.setNumColumns(bVar.asP());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(e.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.asK() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b asK = aVar.asK();
                        if (asK.asO() == EmotionGroupType.BIG_EMOTION || asK.asO() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.asK() != null) {
                                com.baidu.tieba.emotion.editortool.b asK = aVar.asK();
                                int asJ = aVar.asJ();
                                com.baidu.tbadk.editortools.emotiontool.c asN = asK.asN();
                                String fz = asK.asN().fz(asJ + i2);
                                if (asN.Li() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aYU.equals(fz)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(fz);
                                pVar.a(asN.Li());
                                pVar.gk(asN.getGroupName());
                                pVar.setPid(asN.getGroupId());
                                pVar.setWidth(asN.getWidth());
                                pVar.setHeight(asN.getHeight());
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
            if (EmotionTabContentView.this.dfQ != null) {
                int size = EmotionTabContentView.this.dfQ.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aCA) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dfQ.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aCA = i;
                        EmotionTabContentView.this.aIl.setVisibility(bVar.asQ() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aIl.setCount(bVar.asQ());
                        EmotionTabContentView.this.aIl.setPosition(bVar.asR());
                        EmotionTabContentView.this.aIl.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_selection), Integer.valueOf(bVar.asR() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_page), Integer.valueOf(bVar.asQ())));
                    }
                    if (bVar != null && bVar.asU() != EmotionTabContentView.this.dfS) {
                        EmotionTabContentView.this.dfS = bVar.asU();
                        if (EmotionTabContentView.this.dfT != null) {
                            EmotionTabContentView.this.dfT.kP(bVar.asU());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.dfT = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.akD);
    }
}
