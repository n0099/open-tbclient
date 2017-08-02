package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.l;
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
    private i JT;
    private CustomMessageListener Se;
    private IndicatorView aDr;
    private int aoR;
    private int bVA;
    private c bVB;
    private int bVC;
    private final Point bVD;
    private com.baidu.adp.lib.e.b<GridView> bVE;
    private b bVl;
    private GridView bVm;
    private LinearLayout bVn;
    private WindowManager.LayoutParams bVo;
    private GifView bVp;
    private ViewGroup bVq;
    private int bVr;
    private int bVs;
    private int bVt;
    private boolean bVu;
    private int bVv;
    private d bVw;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bVx;
    private List<d> bVy;
    private int bVz;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hU(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bVv = -1;
        this.bVz = 0;
        this.bVA = -1;
        this.currentPosition = -1;
        this.bVD = new Point();
        this.Se = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bVx));
                        if (EmotionTabContentView.this.bVl != null) {
                            EmotionTabContentView.this.bVl.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bVA < 0 || EmotionTabContentView.this.bVA >= EmotionTabContentView.this.bVx.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bVx.get(EmotionTabContentView.this.bVA)).Dh() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bVl != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bVy.size()) {
                                    EmotionTabContentView.this.bVw = (d) EmotionTabContentView.this.bVy.get(EmotionTabContentView.this.currentPosition);
                                    int aaS = EmotionTabContentView.this.bVw.aaS();
                                    EmotionTabContentView.this.aDr.setCount(aaS);
                                    EmotionTabContentView.this.aDr.setVisibility(aaS > 1 ? 0 : 4);
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
                                                    int index = aVar.aaM().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bVy.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bVy.get(index));
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
        this.bVv = -1;
        this.bVz = 0;
        this.bVA = -1;
        this.currentPosition = -1;
        this.bVD = new Point();
        this.Se = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bVx));
                        if (EmotionTabContentView.this.bVl != null) {
                            EmotionTabContentView.this.bVl.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bVA < 0 || EmotionTabContentView.this.bVA >= EmotionTabContentView.this.bVx.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bVx.get(EmotionTabContentView.this.bVA)).Dh() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bVl != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bVy.size()) {
                                    EmotionTabContentView.this.bVw = (d) EmotionTabContentView.this.bVy.get(EmotionTabContentView.this.currentPosition);
                                    int aaS = EmotionTabContentView.this.bVw.aaS();
                                    EmotionTabContentView.this.aDr.setCount(aaS);
                                    EmotionTabContentView.this.aDr.setVisibility(aaS > 1 ? 0 : 4);
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
                                                    int index = aVar.aaM().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bVy.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bVy.get(index));
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
        this.bVx = new ArrayList();
        this.bVy = new ArrayList();
        this.bVE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aaK */
            public GridView fI() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView p(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView q(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bVp = new GifView(context);
        ai.d(this.bVp, d.g.bg_expression_bubble, this.aoR);
        this.bVp.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bVo = new WindowManager.LayoutParams();
        this.bVr = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.bVs = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.bVt = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.bVo.width = this.bVr;
        this.bVo.height = this.bVs;
        this.bVo.gravity = 51;
        this.bVo.format = -3;
        this.bVo.type = 1000;
        this.bVo.flags |= 56;
        this.bVq = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aDr = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.bVn = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.bVn.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bVo.type = 1000;
            this.bVo.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bVx.clear();
        this.bVy.clear();
        if (list != null && !list.isEmpty()) {
            this.bVx.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dk = cVar.Dk();
                    int i4 = emotionsCount / (cols * Dk);
                    if (emotionsCount % (cols * Dk) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Dk;
                        } else {
                            i = emotionsCount - ((cols * Dk) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.hZ(i3);
                        dVar.b(cVar.Dh());
                        dVar.eP(Dk);
                        dVar.eO(cols);
                        dVar.hV(i4);
                        dVar.hW(i5);
                        dVar.hX(i);
                        dVar.hY(i5 * cols * Dk);
                        dVar.setEndIndex((i + i2) - 1);
                        this.bVy.add(dVar);
                    }
                }
            }
            this.bVz = this.bVy.size();
            for (int i6 = 0; i6 < this.bVz; i6++) {
                if (this.bVy != null && this.bVy.get(i6) != null) {
                    this.bVy.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hS(int i) {
        if (this.bVy != null) {
            int size = this.bVy.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.bVy.get(i2);
                    if (dVar != null && dVar.aaW() == i) {
                        this.bVC = dVar.getIndex();
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
                am(list);
                hS(i);
                this.bVl = new b();
                this.mViewPager.setAdapter(this.bVl);
                this.mViewPager.setCurrentItem(this.bVC, true);
                if (this.bVB != null) {
                    this.bVB.hU(i);
                    this.bVA = i;
                }
            }
        }
    }

    public void hT(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bVy.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.bVy.get(i3);
                        if (dVar == null || dVar.aaW() != i) {
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
                this.mViewPager.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.bVv != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aaM() != null) {
            d aaM = aVar.aaM();
            String eF = aaM.aaP().eF(aVar.aaL() + i);
            if (aaM.aaQ() != EmotionGroupType.USER_COLLECT || !eF.equals(com.baidu.tbadk.imageManager.d.aFa)) {
                this.bVp.setTag(eF);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eF;
                if (eF.startsWith("#(meme,")) {
                    this.bVp.setShowStaticDrawable(false);
                } else {
                    this.bVp.setShowStaticDrawable(true);
                }
                this.bVp.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.bVq.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.bVo.x = this.rect.left - ((this.bVo.width - linearLayout.getWidth()) / 2);
                this.bVo.y = (this.rect.top - this.bVo.height) + this.bVt;
                this.bVp.setVisibility(0);
                if (!this.bVu) {
                    this.jn.addView(this.bVp, this.bVo);
                    this.bVu = true;
                } else {
                    this.jn.updateViewLayout(this.bVp, this.bVo);
                }
                gridView.setSelection(i);
                if (this.bVv != -1) {
                    ((LinearLayout) gridView.getChildAt(this.bVv - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.bVv = i;
                this.bVm = gridView;
            }
        }
    }

    private void aaJ() {
        if (this.bVu && this.bVp.getVisibility() != 8 && this.bVm != null) {
            this.bVm.setSelection(-1);
            this.bVp.setVisibility(8);
            if (this.bVv != -1) {
                ((LinearLayout) this.bVm.getChildAt(this.bVv - this.bVm.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bVv = -1;
            this.bVm = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bVD.set(x, y);
                break;
            case 1:
            case 3:
                aaJ();
                break;
            case 2:
                this.bVD.set(x, y);
                if (this.bVu && this.bVp.getVisibility() != 8 && this.bVm != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bVD.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                aaJ();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    aaJ();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bVm != null) {
                        offsetRectIntoDescendantCoords(this.bVm, this.rect);
                        int pointToPosition = this.bVm.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bVm);
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
        if (this.bVu) {
            this.jn.removeView(this.bVp);
            this.bVu = false;
        }
        MessageManager.getInstance().unRegisterListener(this.Se);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bVy != null) {
            int size = this.bVy.size();
            if (i >= 0 && i < size) {
                this.bVw = this.bVy.get(i);
                if (this.aDr != null && this.bVw != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aDr.setVisibility(this.bVw.aaS() > 1 ? 0 : 4);
                        this.aDr.setCount(this.bVw.aaS());
                        if (this.bVw != null && this.bVw.aaW() != this.bVA) {
                            this.bVA = this.bVw.aaW();
                            if (this.bVB != null) {
                                this.bVB.hU(this.bVw.aaW());
                            }
                        }
                    }
                    float aaT = this.bVw.aaT() + f;
                    this.aDr.setPosition(aaT);
                    this.bVn.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) aaT) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.bVw.aaS())));
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
        this.aoR = i;
        ai.d(this.bVp, d.g.bg_expression_bubble, i);
        ai.e(this, d.e.common_color_10255, i);
        this.aDr.setSelector(ai.u(i, d.g.dot_pb_expression_s));
        this.aDr.setDrawable(ai.u(i, d.g.dot_pb_expression_n));
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
        aaJ();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d bVG;

        public a(d dVar) {
            this.bVG = dVar;
        }

        public void a(d dVar) {
            this.bVG = dVar;
        }

        public int aaL() {
            if (this.bVG == null) {
                return 0;
            }
            return this.bVG.aaV();
        }

        public d aaM() {
            return this.bVG;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bVG == null) {
                return 0;
            }
            return this.bVG.aaU();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.bVG.aaR() != 0) {
                    i2 = measuredWidth / this.bVG.aaR();
                }
                if (this.bVG.getRow() != 0) {
                    i3 = measuredHeight / this.bVG.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bVt * 2, EmotionTabContentView.this.bVt * 2, EmotionTabContentView.this.bVt * 2, EmotionTabContentView.this.bVt * 2);
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
            if (this.bVG != null) {
                int aaV = this.bVG.aaV() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ai.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.aoR);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eF = this.bVG.aaP().eF(aaV);
                tbImageView.setTag(eF);
                if (!TextUtils.isEmpty(eF)) {
                    Object a = com.baidu.adp.lib.f.c.fJ().a(eF, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.e(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, eF, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.a.a) a;
                    }
                    if (aVar != null) {
                        aVar.e(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(d.h.emotion_tab_content_tip);
                if (this.bVG.aaQ() == EmotionGroupType.BIG_EMOTION) {
                    String eF2 = this.bVG.aaP().eF(aaV);
                    if (!TextUtils.isEmpty(eF2) && !eF2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aoR == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = ai.getColor(d.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eF2.substring(eF2.lastIndexOf("_") + 1, eF2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eF != null && eF.length() > 3) {
                    linearLayout3.setContentDescription(eF.substring(2, eF.length() - 1));
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
            if (EmotionTabContentView.this.bVy == null) {
                return 0;
            }
            return EmotionTabContentView.this.bVy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bVE.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bVE.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bVy != null && i < EmotionTabContentView.this.bVy.size()) {
                d dVar = (d) EmotionTabContentView.this.bVy.get(i);
                gridView2.setNumColumns(dVar.aaR());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aaM() == null) {
                            return false;
                        }
                        d aaM = aVar.aaM();
                        if (aaM.aaQ() == EmotionGroupType.BIG_EMOTION || aaM.aaQ() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.JT != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aaM() != null) {
                                d aaM = aVar.aaM();
                                int aaL = aVar.aaL();
                                com.baidu.tbadk.editortools.emotiontool.c aaP = aaM.aaP();
                                String eF = aaM.aaP().eF(aaL + i2);
                                if (aaP.Dh() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aFa.equals(eF)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eF);
                                lVar.a(aaP.Dh());
                                lVar.ey(aaP.getGroupName());
                                lVar.ez(aaP.getGroupId());
                                lVar.setWidth(aaP.getWidth());
                                lVar.setHeight(aaP.getHeight());
                                EmotionTabContentView.this.JT.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
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
            if (EmotionTabContentView.this.bVy != null) {
                int size = EmotionTabContentView.this.bVy.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.bVy.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aDr.setVisibility(dVar.aaS() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aDr.setCount(dVar.aaS());
                        EmotionTabContentView.this.aDr.setPosition(dVar.aaT());
                        EmotionTabContentView.this.aDr.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.aaT() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.aaS())));
                    }
                    if (dVar != null && dVar.aaW() != EmotionTabContentView.this.bVA) {
                        EmotionTabContentView.this.bVA = dVar.aaW();
                        if (EmotionTabContentView.this.bVB != null) {
                            EmotionTabContentView.this.bVB.hU(dVar.aaW());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bVB = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.JT = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Se);
    }
}
