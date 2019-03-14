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
    private int Us;
    private EditorTools VN;
    private int bUK;
    private IndicatorView bUQ;
    private CustomMessageListener bvt;
    private final Point eAa;
    private com.baidu.adp.lib.e.b<GridView> eAb;
    private EmotionViewPagerAdapter ezI;
    private GridView ezJ;
    private LinearLayout ezK;
    private WindowManager.LayoutParams ezL;
    private GifView ezM;
    private ViewGroup ezN;
    private int ezO;
    private int ezP;
    private int ezQ;
    private boolean ezR;
    private int ezS;
    private com.baidu.tieba.emotion.editortool.b ezT;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ezU;
    private List<com.baidu.tieba.emotion.editortool.b> ezV;
    private int ezW;
    private int ezX;
    private b ezY;
    private int ezZ;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes2.dex */
    public interface b {
        void oV(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.ezS = -1;
        this.ezW = 0;
        this.ezX = -1;
        this.Us = -1;
        this.eAa = new Point();
        this.bvt = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bs(new ArrayList(EmotionTabContentView.this.ezU));
                        if (EmotionTabContentView.this.ezI != null) {
                            EmotionTabContentView.this.ezI.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ezX < 0 || EmotionTabContentView.this.ezX >= EmotionTabContentView.this.ezU.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ezU.get(EmotionTabContentView.this.ezX)).ami() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ezI != null) {
                                if (EmotionTabContentView.this.Us >= 0 && EmotionTabContentView.this.Us < EmotionTabContentView.this.ezV.size()) {
                                    EmotionTabContentView.this.ezT = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezV.get(EmotionTabContentView.this.Us);
                                    int aVG = EmotionTabContentView.this.ezT.aVG();
                                    EmotionTabContentView.this.bUQ.setCount(aVG);
                                    EmotionTabContentView.this.bUQ.setVisibility(aVG > 1 ? 0 : 4);
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
                                                    int index = aVar.aVA().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ezV.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezV.get(index));
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
        this.ezS = -1;
        this.ezW = 0;
        this.ezX = -1;
        this.Us = -1;
        this.eAa = new Point();
        this.bvt = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bs(new ArrayList(EmotionTabContentView.this.ezU));
                        if (EmotionTabContentView.this.ezI != null) {
                            EmotionTabContentView.this.ezI.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ezX < 0 || EmotionTabContentView.this.ezX >= EmotionTabContentView.this.ezU.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ezU.get(EmotionTabContentView.this.ezX)).ami() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ezI != null) {
                                if (EmotionTabContentView.this.Us >= 0 && EmotionTabContentView.this.Us < EmotionTabContentView.this.ezV.size()) {
                                    EmotionTabContentView.this.ezT = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezV.get(EmotionTabContentView.this.Us);
                                    int aVG = EmotionTabContentView.this.ezT.aVG();
                                    EmotionTabContentView.this.bUQ.setCount(aVG);
                                    EmotionTabContentView.this.bUQ.setVisibility(aVG > 1 ? 0 : 4);
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
                                                    int index = aVar.aVA().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ezV.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezV.get(index));
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
        this.ezU = new ArrayList();
        this.ezV = new ArrayList();
        this.eAb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aVy */
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
        this.ezM = new GifView(context);
        al.e(this.ezM, d.f.bg_expression_bubble, this.bUK);
        this.ezM.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ezL = new WindowManager.LayoutParams();
        this.ezO = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.ezP = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.ezQ = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ezL.width = this.ezO;
        this.ezL.height = this.ezP;
        this.ezL.gravity = 51;
        this.ezL.format = -3;
        this.ezL.type = 1000;
        this.ezL.flags |= 56;
        this.ezN = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.bUQ = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.ezK = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.ezK.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ezL.type = 1000;
            this.ezL.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ezU.clear();
        this.ezV.clear();
        if (list != null && !list.isEmpty()) {
            this.ezU.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aml = cVar.aml();
                    int amm = cVar.amm();
                    int i4 = emotionsCount / (aml * amm);
                    if (emotionsCount % (aml * amm) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aml * amm;
                        } else {
                            i = emotionsCount - ((aml * amm) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.pa(i3);
                        bVar.b(cVar.ami());
                        bVar.jG(amm);
                        bVar.jF(aml);
                        bVar.oW(i4);
                        bVar.oX(i5);
                        bVar.oY(i);
                        bVar.oZ(i5 * aml * amm);
                        bVar.setEndIndex((i + i2) - 1);
                        this.ezV.add(bVar);
                    }
                }
            }
            this.ezW = this.ezV.size();
            for (int i6 = 0; i6 < this.ezW; i6++) {
                if (this.ezV != null && this.ezV.get(i6) != null) {
                    this.ezV.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void oT(int i) {
        if (this.ezV != null) {
            int size = this.ezV.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.ezV.get(i2);
                    if (bVar != null && bVar.aVK() == i) {
                        this.ezZ = bVar.getIndex();
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
                bs(list);
                oT(i);
                this.ezI = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.ezI);
                this.mViewPager.setCurrentItem(this.ezZ, true);
                if (this.ezY != null) {
                    this.ezY.oV(i);
                    this.ezX = i;
                }
            }
        }
    }

    public void oU(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ezV.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.ezV.get(i3);
                        if (bVar == null || bVar.aVK() != i) {
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
        if (this.ezS != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aVA() != null) {
            com.baidu.tieba.emotion.editortool.b aVA = aVar.aVA();
            String jz = aVA.aVD().jz(aVar.aVz() + i);
            if (aVA.aVE() != EmotionGroupType.USER_COLLECT || !jz.equals(com.baidu.tbadk.imageManager.d.cmF)) {
                this.ezM.setTag(jz);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = jz;
                if (jz.startsWith("#(meme,")) {
                    this.ezM.setShowStaticDrawable(false);
                } else {
                    this.ezM.setShowStaticDrawable(true);
                }
                this.ezM.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.ezN.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.ezL.x = this.rect.left - ((this.ezL.width - linearLayout.getWidth()) / 2);
                this.ezL.y = (this.rect.top - this.ezL.height) + this.ezQ;
                this.ezM.setVisibility(0);
                if (!this.ezR) {
                    this.mWindowManager.addView(this.ezM, this.ezL);
                    this.ezR = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ezM, this.ezL);
                }
                gridView.setSelection(i);
                if (this.ezS != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ezS - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ezS = i;
                this.ezJ = gridView;
            }
        }
    }

    private void HU() {
        if (this.ezR && this.ezM.getVisibility() != 8 && this.ezJ != null) {
            this.ezJ.setSelection(-1);
            this.ezM.setVisibility(8);
            if (this.ezS != -1) {
                ((LinearLayout) this.ezJ.getChildAt(this.ezS - this.ezJ.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ezS = -1;
            this.ezJ = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eAa.set(x, y);
                break;
            case 1:
            case 3:
                HU();
                break;
            case 2:
                this.eAa.set(x, y);
                if (this.ezR && this.ezM.getVisibility() != 8 && this.ezJ != null) {
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
                this.eAa.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                HU();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    HU();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.ezJ != null) {
                        offsetRectIntoDescendantCoords(this.ezJ, this.rect);
                        int pointToPosition = this.ezJ.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.ezJ);
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
        if (this.ezR) {
            this.mWindowManager.removeView(this.ezM);
            this.ezR = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bvt);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ezV != null) {
            int size = this.ezV.size();
            if (i >= 0 && i < size) {
                this.ezT = this.ezV.get(i);
                if (this.bUQ != null && this.ezT != null) {
                    if (this.Us != i) {
                        this.Us = i;
                        this.bUQ.setVisibility(this.ezT.aVG() > 1 ? 0 : 4);
                        this.bUQ.setCount(this.ezT.aVG());
                        if (this.ezT != null && this.ezT.aVK() != this.ezX) {
                            this.ezX = this.ezT.aVK();
                            if (this.ezY != null) {
                                this.ezY.oV(this.ezT.aVK());
                            }
                        }
                    }
                    float aVH = this.ezT.aVH() + f;
                    this.bUQ.setPosition(aVH);
                    this.ezK.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aVH) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.ezT.aVG())));
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
        this.bUK = i;
        al.e(this.ezM, d.f.bg_expression_bubble, i);
        al.f(this, d.C0277d.cp_bg_line_d, i);
        this.bUQ.setSelector(al.T(i, d.f.dot_pb_expression_s));
        this.bUQ.setDrawable(al.T(i, d.f.dot_pb_expression_n));
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
        HU();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b eAd;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eAd = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eAd = bVar;
        }

        public int aVz() {
            if (this.eAd == null) {
                return 0;
            }
            return this.eAd.aVJ();
        }

        public com.baidu.tieba.emotion.editortool.b aVA() {
            return this.eAd;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eAd == null) {
                return 0;
            }
            return this.eAd.aVI();
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
                if (this.eAd.aVF() != 0) {
                    i2 = measuredWidth / this.eAd.aVF();
                }
                if (this.eAd.getRow() != 0) {
                    i3 = measuredHeight / this.eAd.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ezQ * 2, EmotionTabContentView.this.ezQ * 2, EmotionTabContentView.this.ezQ * 2, EmotionTabContentView.this.ezQ * 2);
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
            if (this.eAd != null) {
                int aVJ = this.eAd.aVJ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.e(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bUK);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String jz = this.eAd.aVD().jz(aVJ);
                tbImageView.setTag(jz);
                if (!TextUtils.isEmpty(jz)) {
                    Object a = com.baidu.adp.lib.f.c.jB().a(jz, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, jz, false, null);
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
                if (this.eAd.aVE() == EmotionGroupType.BIG_EMOTION) {
                    String jz2 = this.eAd.aVD().jz(aVJ);
                    if (!TextUtils.isEmpty(jz2) && !jz2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bUK == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0277d.cp_cont_c);
                        } else {
                            color = al.getColor(d.C0277d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(jz2.substring(jz2.lastIndexOf("_") + 1, jz2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (jz != null && jz.length() > 3) {
                    linearLayout3.setContentDescription(jz.substring(2, jz.length() - 1));
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
            if (EmotionTabContentView.this.ezV == null) {
                return 0;
            }
            return EmotionTabContentView.this.ezV.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eAb.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eAb.jA();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ezV != null && i < EmotionTabContentView.this.ezV.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezV.get(i);
                gridView2.setNumColumns(bVar.aVF());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0277d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aVA() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b aVA = aVar.aVA();
                        if (aVA.aVE() == EmotionGroupType.BIG_EMOTION || aVA.aVE() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.VN != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aVA() != null) {
                                com.baidu.tieba.emotion.editortool.b aVA = aVar.aVA();
                                int aVz = aVar.aVz();
                                com.baidu.tbadk.editortools.emotiontool.c aVD = aVA.aVD();
                                String jz = aVA.aVD().jz(aVz + i2);
                                if (aVD.ami() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cmF.equals(jz)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(jz);
                                pVar.a(aVD.ami());
                                pVar.nD(aVD.getGroupName());
                                pVar.setPid(aVD.getGroupId());
                                pVar.setWidth(aVD.getWidth());
                                pVar.setHeight(aVD.getHeight());
                                EmotionTabContentView.this.VN.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.ezV != null) {
                int size = EmotionTabContentView.this.ezV.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Us) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezV.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Us = i;
                        EmotionTabContentView.this.bUQ.setVisibility(bVar.aVG() > 1 ? 0 : 4);
                        EmotionTabContentView.this.bUQ.setCount(bVar.aVG());
                        EmotionTabContentView.this.bUQ.setPosition(bVar.aVH());
                        EmotionTabContentView.this.bUQ.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(bVar.aVH() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(bVar.aVG())));
                    }
                    if (bVar != null && bVar.aVK() != EmotionTabContentView.this.ezX) {
                        EmotionTabContentView.this.ezX = bVar.aVK();
                        if (EmotionTabContentView.this.ezY != null) {
                            EmotionTabContentView.this.ezY.oV(bVar.aVK());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.ezY = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvt);
    }
}
