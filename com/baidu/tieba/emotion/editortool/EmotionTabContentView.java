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
import com.baidu.tbadk.core.util.al;
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
    private EditorTools Qh;
    private CustomMessageListener acJ;
    private int ayX;
    private IndicatorView azd;
    private EmotionViewPagerAdapter cPO;
    private GridView cPP;
    private LinearLayout cPQ;
    private WindowManager.LayoutParams cPR;
    private GifView cPS;
    private ViewGroup cPT;
    private int cPU;
    private int cPV;
    private int cPW;
    private boolean cPX;
    private int cPY;
    private com.baidu.tieba.emotion.editortool.b cPZ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cQa;
    private List<com.baidu.tieba.emotion.editortool.b> cQb;
    private int cQc;
    private int cQd;
    private b cQe;
    private int cQf;
    private final Point cQg;
    private com.baidu.adp.lib.e.b<GridView> cQh;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface b {
        void jr(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cPY = -1;
        this.cQc = 0;
        this.cQd = -1;
        this.currentPosition = -1;
        this.cQg = new Point();
        this.acJ = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aL(new ArrayList(EmotionTabContentView.this.cQa));
                        if (EmotionTabContentView.this.cPO != null) {
                            EmotionTabContentView.this.cPO.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cQd < 0 || EmotionTabContentView.this.cQd >= EmotionTabContentView.this.cQa.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cQa.get(EmotionTabContentView.this.cQd)).Hv() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cPO != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cQb.size()) {
                                    EmotionTabContentView.this.cPZ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQb.get(EmotionTabContentView.this.currentPosition);
                                    int aom = EmotionTabContentView.this.cPZ.aom();
                                    EmotionTabContentView.this.azd.setCount(aom);
                                    EmotionTabContentView.this.azd.setVisibility(aom > 1 ? 0 : 4);
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
                                                    int index = aVar.aog().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cQb.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQb.get(index));
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
        this.cPY = -1;
        this.cQc = 0;
        this.cQd = -1;
        this.currentPosition = -1;
        this.cQg = new Point();
        this.acJ = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aL(new ArrayList(EmotionTabContentView.this.cQa));
                        if (EmotionTabContentView.this.cPO != null) {
                            EmotionTabContentView.this.cPO.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cQd < 0 || EmotionTabContentView.this.cQd >= EmotionTabContentView.this.cQa.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cQa.get(EmotionTabContentView.this.cQd)).Hv() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cPO != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cQb.size()) {
                                    EmotionTabContentView.this.cPZ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQb.get(EmotionTabContentView.this.currentPosition);
                                    int aom = EmotionTabContentView.this.cPZ.aom();
                                    EmotionTabContentView.this.azd.setCount(aom);
                                    EmotionTabContentView.this.azd.setVisibility(aom > 1 ? 0 : 4);
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
                                                    int index = aVar.aog().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cQb.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQb.get(index));
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
        this.cQa = new ArrayList();
        this.cQb = new ArrayList();
        this.cQh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoe */
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
        this.cPS = new GifView(context);
        al.d(this.cPS, d.f.bg_expression_bubble, this.ayX);
        this.cPS.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cPR = new WindowManager.LayoutParams();
        this.cPU = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.cPV = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.cPW = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.cPR.width = this.cPU;
        this.cPR.height = this.cPV;
        this.cPR.gravity = 51;
        this.cPR.format = -3;
        this.cPR.type = 1000;
        this.cPR.flags |= 56;
        this.cPT = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.azd = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cPQ = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cPQ.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cPR.type = 1000;
            this.cPR.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cQa.clear();
        this.cQb.clear();
        if (list != null && !list.isEmpty()) {
            this.cQa.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Hy = cVar.Hy();
                    int Hz = cVar.Hz();
                    int i4 = emotionsCount / (Hy * Hz);
                    if (emotionsCount % (Hy * Hz) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = Hy * Hz;
                        } else {
                            i = emotionsCount - ((Hy * Hz) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.jw(i3);
                        bVar.b(cVar.Hv());
                        bVar.eW(Hz);
                        bVar.eV(Hy);
                        bVar.js(i4);
                        bVar.jt(i5);
                        bVar.ju(i);
                        bVar.jv(i5 * Hy * Hz);
                        bVar.setEndIndex((i + i2) - 1);
                        this.cQb.add(bVar);
                    }
                }
            }
            this.cQc = this.cQb.size();
            for (int i6 = 0; i6 < this.cQc; i6++) {
                if (this.cQb != null && this.cQb.get(i6) != null) {
                    this.cQb.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jp(int i) {
        if (this.cQb != null) {
            int size = this.cQb.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cQb.get(i2);
                    if (bVar != null && bVar.aoq() == i) {
                        this.cQf = bVar.getIndex();
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
                aL(list);
                jp(i);
                this.cPO = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cPO);
                this.mViewPager.setCurrentItem(this.cQf, true);
                if (this.cQe != null) {
                    this.cQe.jr(i);
                    this.cQd = i;
                }
            }
        }
    }

    public void jq(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cQb.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cQb.get(i3);
                        if (bVar == null || bVar.aoq() != i) {
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
        if (this.cPY != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aog() != null) {
            com.baidu.tieba.emotion.editortool.b aog = aVar.aog();
            String eP = aog.aoj().eP(aVar.aof() + i);
            if (aog.aok() != EmotionGroupType.USER_COLLECT || !eP.equals(com.baidu.tbadk.imageManager.d.aPw)) {
                this.cPS.setTag(eP);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eP;
                if (eP.startsWith("#(meme,")) {
                    this.cPS.setShowStaticDrawable(false);
                } else {
                    this.cPS.setShowStaticDrawable(true);
                }
                this.cPS.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cPT.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cPR.x = this.rect.left - ((this.cPR.width - linearLayout.getWidth()) / 2);
                this.cPR.y = (this.rect.top - this.cPR.height) + this.cPW;
                this.cPS.setVisibility(0);
                if (!this.cPX) {
                    this.mWindowManager.addView(this.cPS, this.cPR);
                    this.cPX = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cPS, this.cPR);
                }
                gridView.setSelection(i);
                if (this.cPY != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cPY - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cPY = i;
                this.cPP = gridView;
            }
        }
    }

    private void aod() {
        if (this.cPX && this.cPS.getVisibility() != 8 && this.cPP != null) {
            this.cPP.setSelection(-1);
            this.cPS.setVisibility(8);
            if (this.cPY != -1) {
                ((LinearLayout) this.cPP.getChildAt(this.cPY - this.cPP.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cPY = -1;
            this.cPP = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cQg.set(x, y);
                break;
            case 1:
            case 3:
                aod();
                break;
            case 2:
                this.cQg.set(x, y);
                if (this.cPX && this.cPS.getVisibility() != 8 && this.cPP != null) {
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
                this.cQg.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                aod();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    aod();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cPP != null) {
                        offsetRectIntoDescendantCoords(this.cPP, this.rect);
                        int pointToPosition = this.cPP.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cPP);
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
        if (this.cPX) {
            this.mWindowManager.removeView(this.cPS);
            this.cPX = false;
        }
        MessageManager.getInstance().unRegisterListener(this.acJ);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cQb != null) {
            int size = this.cQb.size();
            if (i >= 0 && i < size) {
                this.cPZ = this.cQb.get(i);
                if (this.azd != null && this.cPZ != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.azd.setVisibility(this.cPZ.aom() > 1 ? 0 : 4);
                        this.azd.setCount(this.cPZ.aom());
                        if (this.cPZ != null && this.cPZ.aoq() != this.cQd) {
                            this.cQd = this.cPZ.aoq();
                            if (this.cQe != null) {
                                this.cQe.jr(this.cPZ.aoq());
                            }
                        }
                    }
                    float aon = this.cPZ.aon() + f;
                    this.azd.setPosition(aon);
                    this.cPQ.setContentDescription(String.format(getResources().getString(d.k.emotion_selection), Integer.valueOf(((int) aon) + 1)) + String.format(getResources().getString(d.k.emotion_page), Integer.valueOf(this.cPZ.aom())));
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
        this.ayX = i;
        al.d(this.cPS, d.f.bg_expression_bubble, i);
        al.e(this, d.C0141d.cp_bg_line_d, i);
        this.azd.setSelector(al.v(i, d.f.dot_pb_expression_s));
        this.azd.setDrawable(al.v(i, d.f.dot_pb_expression_n));
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
        aod();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b cQj;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cQj = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cQj = bVar;
        }

        public int aof() {
            if (this.cQj == null) {
                return 0;
            }
            return this.cQj.aop();
        }

        public com.baidu.tieba.emotion.editortool.b aog() {
            return this.cQj;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cQj == null) {
                return 0;
            }
            return this.cQj.aoo();
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
                if (this.cQj.aol() != 0) {
                    i2 = measuredWidth / this.cQj.aol();
                }
                if (this.cQj.getRow() != 0) {
                    i3 = measuredHeight / this.cQj.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cPW * 2, EmotionTabContentView.this.cPW * 2, EmotionTabContentView.this.cPW * 2, EmotionTabContentView.this.cPW * 2);
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
            if (this.cQj != null) {
                int aop = this.cQj.aop() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.ayX);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eP = this.cQj.aoj().eP(aop);
                tbImageView.setTag(eP);
                if (!TextUtils.isEmpty(eP)) {
                    Object a = com.baidu.adp.lib.f.c.ig().a(eP, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eP, false, null);
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
                if (this.cQj.aok() == EmotionGroupType.BIG_EMOTION) {
                    String eP2 = this.cQj.aoj().eP(aop);
                    if (!TextUtils.isEmpty(eP2) && !eP2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ayX == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0141d.cp_cont_c);
                        } else {
                            color = al.getColor(d.C0141d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eP2.substring(eP2.lastIndexOf("_") + 1, eP2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eP != null && eP.length() > 3) {
                    linearLayout3.setContentDescription(eP.substring(2, eP.length() - 1));
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
            if (EmotionTabContentView.this.cQb == null) {
                return 0;
            }
            return EmotionTabContentView.this.cQb.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cQh.p(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cQh.ie();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cQb != null && i < EmotionTabContentView.this.cQb.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQb.get(i);
                gridView2.setNumColumns(bVar.aol());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0141d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aog() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b aog = aVar.aog();
                        if (aog.aok() == EmotionGroupType.BIG_EMOTION || aog.aok() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Qh != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aog() != null) {
                                com.baidu.tieba.emotion.editortool.b aog = aVar.aog();
                                int aof = aVar.aof();
                                com.baidu.tbadk.editortools.emotiontool.c aoj = aog.aoj();
                                String eP = aog.aoj().eP(aof + i2);
                                if (aoj.Hv() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aPw.equals(eP)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eP);
                                nVar.a(aoj.Hv());
                                nVar.fx(aoj.getGroupName());
                                nVar.setPid(aoj.getGroupId());
                                nVar.setWidth(aoj.getWidth());
                                nVar.setHeight(aoj.getHeight());
                                EmotionTabContentView.this.Qh.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.cQb != null) {
                int size = EmotionTabContentView.this.cQb.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cQb.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.azd.setVisibility(bVar.aom() > 1 ? 0 : 4);
                        EmotionTabContentView.this.azd.setCount(bVar.aom());
                        EmotionTabContentView.this.azd.setPosition(bVar.aon());
                        EmotionTabContentView.this.azd.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_selection), Integer.valueOf(bVar.aon() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.k.emotion_page), Integer.valueOf(bVar.aom())));
                    }
                    if (bVar != null && bVar.aoq() != EmotionTabContentView.this.cQd) {
                        EmotionTabContentView.this.cQd = bVar.aoq();
                        if (EmotionTabContentView.this.cQe != null) {
                            EmotionTabContentView.this.cQe.jr(bVar.aoq());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cQe = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acJ);
    }
}
