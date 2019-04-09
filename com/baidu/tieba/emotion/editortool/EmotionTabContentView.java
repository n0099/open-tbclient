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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Ut;
    private EditorTools VO;
    private int bUN;
    private IndicatorView bUT;
    private CustomMessageListener bvx;
    private int ezA;
    private int ezB;
    private int ezC;
    private boolean ezD;
    private int ezE;
    private com.baidu.tieba.emotion.editortool.b ezF;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ezG;
    private List<com.baidu.tieba.emotion.editortool.b> ezH;
    private int ezI;
    private int ezJ;
    private b ezK;
    private int ezL;
    private final Point ezM;
    private com.baidu.adp.lib.e.b<GridView> ezN;
    private EmotionViewPagerAdapter ezu;
    private GridView ezv;
    private LinearLayout ezw;
    private WindowManager.LayoutParams ezx;
    private GifView ezy;
    private ViewGroup ezz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes2.dex */
    public interface b {
        void oR(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.ezE = -1;
        this.ezI = 0;
        this.ezJ = -1;
        this.Ut = -1;
        this.ezM = new Point();
        this.bvx = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bq(new ArrayList(EmotionTabContentView.this.ezG));
                        if (EmotionTabContentView.this.ezu != null) {
                            EmotionTabContentView.this.ezu.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ezJ < 0 || EmotionTabContentView.this.ezJ >= EmotionTabContentView.this.ezG.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ezG.get(EmotionTabContentView.this.ezJ)).amf() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ezu != null) {
                                if (EmotionTabContentView.this.Ut >= 0 && EmotionTabContentView.this.Ut < EmotionTabContentView.this.ezH.size()) {
                                    EmotionTabContentView.this.ezF = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezH.get(EmotionTabContentView.this.Ut);
                                    int aVE = EmotionTabContentView.this.ezF.aVE();
                                    EmotionTabContentView.this.bUT.setCount(aVE);
                                    EmotionTabContentView.this.bUT.setVisibility(aVE > 1 ? 0 : 4);
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
                                                    int index = aVar.aVy().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ezH.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezH.get(index));
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
        this.ezE = -1;
        this.ezI = 0;
        this.ezJ = -1;
        this.Ut = -1;
        this.ezM = new Point();
        this.bvx = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bq(new ArrayList(EmotionTabContentView.this.ezG));
                        if (EmotionTabContentView.this.ezu != null) {
                            EmotionTabContentView.this.ezu.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ezJ < 0 || EmotionTabContentView.this.ezJ >= EmotionTabContentView.this.ezG.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ezG.get(EmotionTabContentView.this.ezJ)).amf() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ezu != null) {
                                if (EmotionTabContentView.this.Ut >= 0 && EmotionTabContentView.this.Ut < EmotionTabContentView.this.ezH.size()) {
                                    EmotionTabContentView.this.ezF = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezH.get(EmotionTabContentView.this.Ut);
                                    int aVE = EmotionTabContentView.this.ezF.aVE();
                                    EmotionTabContentView.this.bUT.setCount(aVE);
                                    EmotionTabContentView.this.bUT.setVisibility(aVE > 1 ? 0 : 4);
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
                                                    int index = aVar.aVy().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ezH.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezH.get(index));
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
        this.ezG = new ArrayList();
        this.ezH = new ArrayList();
        this.ezN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aVw */
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.ezy = new GifView(context);
        al.e(this.ezy, d.f.bg_expression_bubble, this.bUN);
        this.ezy.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ezx = new WindowManager.LayoutParams();
        this.ezA = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.ezB = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.ezC = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ezx.width = this.ezA;
        this.ezx.height = this.ezB;
        this.ezx.gravity = 51;
        this.ezx.format = -3;
        this.ezx.type = 1000;
        this.ezx.flags |= 56;
        this.ezz = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.bUT = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.ezw = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.ezw.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ezx.type = 1000;
            this.ezx.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ezG.clear();
        this.ezH.clear();
        if (list != null && !list.isEmpty()) {
            this.ezG.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int ami = cVar.ami();
                    int amj = cVar.amj();
                    int i4 = emotionsCount / (ami * amj);
                    if (emotionsCount % (ami * amj) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = ami * amj;
                        } else {
                            i = emotionsCount - ((ami * amj) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.oW(i3);
                        bVar.b(cVar.amf());
                        bVar.jF(amj);
                        bVar.jE(ami);
                        bVar.oS(i4);
                        bVar.oT(i5);
                        bVar.oU(i);
                        bVar.oV(i5 * ami * amj);
                        bVar.setEndIndex((i + i2) - 1);
                        this.ezH.add(bVar);
                    }
                }
            }
            this.ezI = this.ezH.size();
            for (int i6 = 0; i6 < this.ezI; i6++) {
                if (this.ezH != null && this.ezH.get(i6) != null) {
                    this.ezH.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void oP(int i) {
        if (this.ezH != null) {
            int size = this.ezH.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.ezH.get(i2);
                    if (bVar != null && bVar.aVI() == i) {
                        this.ezL = bVar.getIndex();
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
                bq(list);
                oP(i);
                this.ezu = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.ezu);
                this.mViewPager.setCurrentItem(this.ezL, true);
                if (this.ezK != null) {
                    this.ezK.oR(i);
                    this.ezJ = i;
                }
            }
        }
    }

    public void oQ(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ezH.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.ezH.get(i3);
                        if (bVar == null || bVar.aVI() != i) {
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
        if (this.ezE != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aVy() != null) {
            com.baidu.tieba.emotion.editortool.b aVy = aVar.aVy();
            String jy = aVy.aVB().jy(aVar.aVx() + i);
            if (aVy.aVC() != EmotionGroupType.USER_COLLECT || !jy.equals(com.baidu.tbadk.imageManager.d.cmI)) {
                this.ezy.setTag(jy);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = jy;
                if (jy.startsWith("#(meme,")) {
                    this.ezy.setShowStaticDrawable(false);
                } else {
                    this.ezy.setShowStaticDrawable(true);
                }
                this.ezy.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.ezz.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.ezx.x = this.rect.left - ((this.ezx.width - linearLayout.getWidth()) / 2);
                this.ezx.y = (this.rect.top - this.ezx.height) + this.ezC;
                this.ezy.setVisibility(0);
                if (!this.ezD) {
                    this.mWindowManager.addView(this.ezy, this.ezx);
                    this.ezD = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ezy, this.ezx);
                }
                gridView.setSelection(i);
                if (this.ezE != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ezE - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ezE = i;
                this.ezv = gridView;
            }
        }
    }

    private void HS() {
        if (this.ezD && this.ezy.getVisibility() != 8 && this.ezv != null) {
            this.ezv.setSelection(-1);
            this.ezy.setVisibility(8);
            if (this.ezE != -1) {
                ((LinearLayout) this.ezv.getChildAt(this.ezE - this.ezv.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ezE = -1;
            this.ezv = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ezM.set(x, y);
                break;
            case 1:
            case 3:
                HS();
                break;
            case 2:
                this.ezM.set(x, y);
                if (this.ezD && this.ezy.getVisibility() != 8 && this.ezv != null) {
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
                this.ezM.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                HS();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    HS();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.ezv != null) {
                        offsetRectIntoDescendantCoords(this.ezv, this.rect);
                        int pointToPosition = this.ezv.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.ezv);
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
        if (this.ezD) {
            this.mWindowManager.removeView(this.ezy);
            this.ezD = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bvx);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ezH != null) {
            int size = this.ezH.size();
            if (i >= 0 && i < size) {
                this.ezF = this.ezH.get(i);
                if (this.bUT != null && this.ezF != null) {
                    if (this.Ut != i) {
                        this.Ut = i;
                        this.bUT.setVisibility(this.ezF.aVE() > 1 ? 0 : 4);
                        this.bUT.setCount(this.ezF.aVE());
                        if (this.ezF != null && this.ezF.aVI() != this.ezJ) {
                            this.ezJ = this.ezF.aVI();
                            if (this.ezK != null) {
                                this.ezK.oR(this.ezF.aVI());
                            }
                        }
                    }
                    float aVF = this.ezF.aVF() + f;
                    this.bUT.setPosition(aVF);
                    this.ezw.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aVF) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.ezF.aVE())));
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
        this.bUN = i;
        al.e(this.ezy, d.f.bg_expression_bubble, i);
        al.f(this, d.C0277d.cp_bg_line_d, i);
        this.bUT.setSelector(al.T(i, d.f.dot_pb_expression_s));
        this.bUT.setDrawable(al.T(i, d.f.dot_pb_expression_n));
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
        HS();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b ezP;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ezP = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ezP = bVar;
        }

        public int aVx() {
            if (this.ezP == null) {
                return 0;
            }
            return this.ezP.aVH();
        }

        public com.baidu.tieba.emotion.editortool.b aVy() {
            return this.ezP;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ezP == null) {
                return 0;
            }
            return this.ezP.aVG();
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
                if (this.ezP.aVD() != 0) {
                    i2 = measuredWidth / this.ezP.aVD();
                }
                if (this.ezP.getRow() != 0) {
                    i3 = measuredHeight / this.ezP.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ezC * 2, EmotionTabContentView.this.ezC * 2, EmotionTabContentView.this.ezC * 2, EmotionTabContentView.this.ezC * 2);
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
            if (this.ezP != null) {
                int aVH = this.ezP.aVH() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.e(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bUN);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String jy = this.ezP.aVB().jy(aVH);
                tbImageView.setTag(jy);
                if (!TextUtils.isEmpty(jy)) {
                    Object a = com.baidu.adp.lib.f.c.jB().a(jy, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, jy, false, null);
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
                if (this.ezP.aVC() == EmotionGroupType.BIG_EMOTION) {
                    String jy2 = this.ezP.aVB().jy(aVH);
                    if (!TextUtils.isEmpty(jy2) && !jy2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bUN == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0277d.cp_cont_c);
                        } else {
                            color = al.getColor(d.C0277d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(jy2.substring(jy2.lastIndexOf("_") + 1, jy2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (jy != null && jy.length() > 3) {
                    linearLayout3.setContentDescription(jy.substring(2, jy.length() - 1));
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
            if (EmotionTabContentView.this.ezH == null) {
                return 0;
            }
            return EmotionTabContentView.this.ezH.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ezN.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ezN.jA();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ezH != null && i < EmotionTabContentView.this.ezH.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezH.get(i);
                gridView2.setNumColumns(bVar.aVD());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0277d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aVy() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b aVy = aVar.aVy();
                        if (aVy.aVC() == EmotionGroupType.BIG_EMOTION || aVy.aVC() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.VO != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aVy() != null) {
                                com.baidu.tieba.emotion.editortool.b aVy = aVar.aVy();
                                int aVx = aVar.aVx();
                                com.baidu.tbadk.editortools.emotiontool.c aVB = aVy.aVB();
                                String jy = aVy.aVB().jy(aVx + i2);
                                if (aVB.amf() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cmI.equals(jy)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(jy);
                                pVar.a(aVB.amf());
                                pVar.nE(aVB.getGroupName());
                                pVar.setPid(aVB.getGroupId());
                                pVar.setWidth(aVB.getWidth());
                                pVar.setHeight(aVB.getHeight());
                                EmotionTabContentView.this.VO.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.ezH != null) {
                int size = EmotionTabContentView.this.ezH.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ut) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezH.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ut = i;
                        EmotionTabContentView.this.bUT.setVisibility(bVar.aVE() > 1 ? 0 : 4);
                        EmotionTabContentView.this.bUT.setCount(bVar.aVE());
                        EmotionTabContentView.this.bUT.setPosition(bVar.aVF());
                        EmotionTabContentView.this.bUT.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(bVar.aVF() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(bVar.aVE())));
                    }
                    if (bVar != null && bVar.aVI() != EmotionTabContentView.this.ezJ) {
                        EmotionTabContentView.this.ezJ = bVar.aVI();
                        if (EmotionTabContentView.this.ezK != null) {
                            EmotionTabContentView.this.ezK.oR(bVar.aVI());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.ezK = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvx);
    }
}
