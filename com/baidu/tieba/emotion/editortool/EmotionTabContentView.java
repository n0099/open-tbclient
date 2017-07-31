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
    private i Lr;
    private CustomMessageListener TB;
    private IndicatorView aEH;
    private int aql;
    private boolean bWA;
    private int bWB;
    private d bWC;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bWD;
    private List<d> bWE;
    private int bWF;
    private int bWG;
    private c bWH;
    private int bWI;
    private final Point bWJ;
    private com.baidu.adp.lib.e.b<GridView> bWK;
    private b bWr;
    private GridView bWs;
    private LinearLayout bWt;
    private WindowManager.LayoutParams bWu;
    private GifView bWv;
    private ViewGroup bWw;
    private int bWx;
    private int bWy;
    private int bWz;
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
        this.bWB = -1;
        this.bWF = 0;
        this.bWG = -1;
        this.currentPosition = -1;
        this.bWJ = new Point();
        this.TB = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bWD));
                        if (EmotionTabContentView.this.bWr != null) {
                            EmotionTabContentView.this.bWr.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bWG < 0 || EmotionTabContentView.this.bWG >= EmotionTabContentView.this.bWD.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bWD.get(EmotionTabContentView.this.bWG)).Dp() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bWr != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bWE.size()) {
                                    EmotionTabContentView.this.bWC = (d) EmotionTabContentView.this.bWE.get(EmotionTabContentView.this.currentPosition);
                                    int aaX = EmotionTabContentView.this.bWC.aaX();
                                    EmotionTabContentView.this.aEH.setCount(aaX);
                                    EmotionTabContentView.this.aEH.setVisibility(aaX > 1 ? 0 : 4);
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
                                                    int index = aVar.aaR().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bWE.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bWE.get(index));
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
        this.bWB = -1;
        this.bWF = 0;
        this.bWG = -1;
        this.currentPosition = -1;
        this.bWJ = new Point();
        this.TB = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bWD));
                        if (EmotionTabContentView.this.bWr != null) {
                            EmotionTabContentView.this.bWr.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bWG < 0 || EmotionTabContentView.this.bWG >= EmotionTabContentView.this.bWD.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bWD.get(EmotionTabContentView.this.bWG)).Dp() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bWr != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bWE.size()) {
                                    EmotionTabContentView.this.bWC = (d) EmotionTabContentView.this.bWE.get(EmotionTabContentView.this.currentPosition);
                                    int aaX = EmotionTabContentView.this.bWC.aaX();
                                    EmotionTabContentView.this.aEH.setCount(aaX);
                                    EmotionTabContentView.this.aEH.setVisibility(aaX > 1 ? 0 : 4);
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
                                                    int index = aVar.aaR().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bWE.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bWE.get(index));
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
        this.bWD = new ArrayList();
        this.bWE = new ArrayList();
        this.bWK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aaP */
            public GridView fT() {
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
        this.bWv = new GifView(context);
        ai.d(this.bWv, d.g.bg_expression_bubble, this.aql);
        this.bWv.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bWu = new WindowManager.LayoutParams();
        this.bWx = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.bWy = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.bWz = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.bWu.width = this.bWx;
        this.bWu.height = this.bWy;
        this.bWu.gravity = 51;
        this.bWu.format = -3;
        this.bWu.type = 1000;
        this.bWu.flags |= 56;
        this.bWw = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEH = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.bWt = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.bWt.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bWu.type = 1000;
            this.bWu.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bWD.clear();
        this.bWE.clear();
        if (list != null && !list.isEmpty()) {
            this.bWD.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Ds = cVar.Ds();
                    int i4 = emotionsCount / (cols * Ds);
                    if (emotionsCount % (cols * Ds) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Ds;
                        } else {
                            i = emotionsCount - ((cols * Ds) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.hZ(i3);
                        dVar.b(cVar.Dp());
                        dVar.eR(Ds);
                        dVar.eQ(cols);
                        dVar.hV(i4);
                        dVar.hW(i5);
                        dVar.hX(i);
                        dVar.hY(i5 * cols * Ds);
                        dVar.setEndIndex((i + i2) - 1);
                        this.bWE.add(dVar);
                    }
                }
            }
            this.bWF = this.bWE.size();
            for (int i6 = 0; i6 < this.bWF; i6++) {
                if (this.bWE != null && this.bWE.get(i6) != null) {
                    this.bWE.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hS(int i) {
        if (this.bWE != null) {
            int size = this.bWE.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.bWE.get(i2);
                    if (dVar != null && dVar.abb() == i) {
                        this.bWI = dVar.getIndex();
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
                this.bWr = new b();
                this.mViewPager.setAdapter(this.bWr);
                this.mViewPager.setCurrentItem(this.bWI, true);
                if (this.bWH != null) {
                    this.bWH.hU(i);
                    this.bWG = i;
                }
            }
        }
    }

    public void hT(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bWE.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.bWE.get(i3);
                        if (dVar == null || dVar.abb() != i) {
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
        if (this.bWB != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aaR() != null) {
            d aaR = aVar.aaR();
            String eH = aaR.aaU().eH(aVar.aaQ() + i);
            if (aaR.aaV() != EmotionGroupType.USER_COLLECT || !eH.equals(com.baidu.tbadk.imageManager.d.aGq)) {
                this.bWv.setTag(eH);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eH;
                if (eH.startsWith("#(meme,")) {
                    this.bWv.setShowStaticDrawable(false);
                } else {
                    this.bWv.setShowStaticDrawable(true);
                }
                this.bWv.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.bWw.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.bWu.x = this.rect.left - ((this.bWu.width - linearLayout.getWidth()) / 2);
                this.bWu.y = (this.rect.top - this.bWu.height) + this.bWz;
                this.bWv.setVisibility(0);
                if (!this.bWA) {
                    this.jn.addView(this.bWv, this.bWu);
                    this.bWA = true;
                } else {
                    this.jn.updateViewLayout(this.bWv, this.bWu);
                }
                gridView.setSelection(i);
                if (this.bWB != -1) {
                    ((LinearLayout) gridView.getChildAt(this.bWB - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.bWB = i;
                this.bWs = gridView;
            }
        }
    }

    private void aaO() {
        if (this.bWA && this.bWv.getVisibility() != 8 && this.bWs != null) {
            this.bWs.setSelection(-1);
            this.bWv.setVisibility(8);
            if (this.bWB != -1) {
                ((LinearLayout) this.bWs.getChildAt(this.bWB - this.bWs.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bWB = -1;
            this.bWs = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bWJ.set(x, y);
                break;
            case 1:
            case 3:
                aaO();
                break;
            case 2:
                this.bWJ.set(x, y);
                if (this.bWA && this.bWv.getVisibility() != 8 && this.bWs != null) {
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
                this.bWJ.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                aaO();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    aaO();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bWs != null) {
                        offsetRectIntoDescendantCoords(this.bWs, this.rect);
                        int pointToPosition = this.bWs.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bWs);
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
        if (this.bWA) {
            this.jn.removeView(this.bWv);
            this.bWA = false;
        }
        MessageManager.getInstance().unRegisterListener(this.TB);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bWE != null) {
            int size = this.bWE.size();
            if (i >= 0 && i < size) {
                this.bWC = this.bWE.get(i);
                if (this.aEH != null && this.bWC != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEH.setVisibility(this.bWC.aaX() > 1 ? 0 : 4);
                        this.aEH.setCount(this.bWC.aaX());
                        if (this.bWC != null && this.bWC.abb() != this.bWG) {
                            this.bWG = this.bWC.abb();
                            if (this.bWH != null) {
                                this.bWH.hU(this.bWC.abb());
                            }
                        }
                    }
                    float aaY = this.bWC.aaY() + f;
                    this.aEH.setPosition(aaY);
                    this.bWt.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) aaY) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.bWC.aaX())));
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
        this.aql = i;
        ai.d(this.bWv, d.g.bg_expression_bubble, i);
        ai.e(this, d.e.common_color_10255, i);
        this.aEH.setSelector(ai.v(i, d.g.dot_pb_expression_s));
        this.aEH.setDrawable(ai.v(i, d.g.dot_pb_expression_n));
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
        aaO();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d bWM;

        public a(d dVar) {
            this.bWM = dVar;
        }

        public void a(d dVar) {
            this.bWM = dVar;
        }

        public int aaQ() {
            if (this.bWM == null) {
                return 0;
            }
            return this.bWM.aba();
        }

        public d aaR() {
            return this.bWM;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bWM == null) {
                return 0;
            }
            return this.bWM.aaZ();
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
                if (this.bWM.aaW() != 0) {
                    i2 = measuredWidth / this.bWM.aaW();
                }
                if (this.bWM.getRow() != 0) {
                    i3 = measuredHeight / this.bWM.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bWz * 2, EmotionTabContentView.this.bWz * 2, EmotionTabContentView.this.bWz * 2, EmotionTabContentView.this.bWz * 2);
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
            if (this.bWM != null) {
                int aba = this.bWM.aba() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ai.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.aql);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eH = this.bWM.aaU().eH(aba);
                tbImageView.setTag(eH);
                if (!TextUtils.isEmpty(eH)) {
                    Object a = com.baidu.adp.lib.f.c.fU().a(eH, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eH, false, null);
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
                if (this.bWM.aaV() == EmotionGroupType.BIG_EMOTION) {
                    String eH2 = this.bWM.aaU().eH(aba);
                    if (!TextUtils.isEmpty(eH2) && !eH2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aql == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = ai.getColor(d.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eH2.substring(eH2.lastIndexOf("_") + 1, eH2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eH != null && eH.length() > 3) {
                    linearLayout3.setContentDescription(eH.substring(2, eH.length() - 1));
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
            if (EmotionTabContentView.this.bWE == null) {
                return 0;
            }
            return EmotionTabContentView.this.bWE.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bWK.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bWK.fS();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bWE != null && i < EmotionTabContentView.this.bWE.size()) {
                d dVar = (d) EmotionTabContentView.this.bWE.get(i);
                gridView2.setNumColumns(dVar.aaW());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aaR() == null) {
                            return false;
                        }
                        d aaR = aVar.aaR();
                        if (aaR.aaV() == EmotionGroupType.BIG_EMOTION || aaR.aaV() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Lr != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aaR() != null) {
                                d aaR = aVar.aaR();
                                int aaQ = aVar.aaQ();
                                com.baidu.tbadk.editortools.emotiontool.c aaU = aaR.aaU();
                                String eH = aaR.aaU().eH(aaQ + i2);
                                if (aaU.Dp() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGq.equals(eH)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eH);
                                lVar.a(aaU.Dp());
                                lVar.eE(aaU.getGroupName());
                                lVar.eF(aaU.getGroupId());
                                lVar.setWidth(aaU.getWidth());
                                lVar.setHeight(aaU.getHeight());
                                EmotionTabContentView.this.Lr.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
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
            if (EmotionTabContentView.this.bWE != null) {
                int size = EmotionTabContentView.this.bWE.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.bWE.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEH.setVisibility(dVar.aaX() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEH.setCount(dVar.aaX());
                        EmotionTabContentView.this.aEH.setPosition(dVar.aaY());
                        EmotionTabContentView.this.aEH.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.aaY() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.aaX())));
                    }
                    if (dVar != null && dVar.abb() != EmotionTabContentView.this.bWG) {
                        EmotionTabContentView.this.bWG = dVar.abb();
                        if (EmotionTabContentView.this.bWH != null) {
                            EmotionTabContentView.this.bWH.hU(dVar.abb());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bWH = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.Lr = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TB);
    }
}
