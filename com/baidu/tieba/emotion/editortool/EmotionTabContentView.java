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
    private int Ur;
    private EditorTools VM;
    private int bUJ;
    private IndicatorView bUP;
    private CustomMessageListener bvr;
    private int eAa;
    private int eAb;
    private b eAc;
    private int eAd;
    private final Point eAe;
    private com.baidu.adp.lib.e.b<GridView> eAf;
    private EmotionViewPagerAdapter ezM;
    private GridView ezN;
    private LinearLayout ezO;
    private WindowManager.LayoutParams ezP;
    private GifView ezQ;
    private ViewGroup ezR;
    private int ezS;
    private int ezT;
    private int ezU;
    private boolean ezV;
    private int ezW;
    private com.baidu.tieba.emotion.editortool.b ezX;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ezY;
    private List<com.baidu.tieba.emotion.editortool.b> ezZ;
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
        this.ezW = -1;
        this.eAa = 0;
        this.eAb = -1;
        this.Ur = -1;
        this.eAe = new Point();
        this.bvr = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bs(new ArrayList(EmotionTabContentView.this.ezY));
                        if (EmotionTabContentView.this.ezM != null) {
                            EmotionTabContentView.this.ezM.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eAb < 0 || EmotionTabContentView.this.eAb >= EmotionTabContentView.this.ezY.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ezY.get(EmotionTabContentView.this.eAb)).amj() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ezM != null) {
                                if (EmotionTabContentView.this.Ur >= 0 && EmotionTabContentView.this.Ur < EmotionTabContentView.this.ezZ.size()) {
                                    EmotionTabContentView.this.ezX = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezZ.get(EmotionTabContentView.this.Ur);
                                    int aVG = EmotionTabContentView.this.ezX.aVG();
                                    EmotionTabContentView.this.bUP.setCount(aVG);
                                    EmotionTabContentView.this.bUP.setVisibility(aVG > 1 ? 0 : 4);
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
                                                    if (index >= 0 && index < EmotionTabContentView.this.ezZ.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezZ.get(index));
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
        this.ezW = -1;
        this.eAa = 0;
        this.eAb = -1;
        this.Ur = -1;
        this.eAe = new Point();
        this.bvr = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bs(new ArrayList(EmotionTabContentView.this.ezY));
                        if (EmotionTabContentView.this.ezM != null) {
                            EmotionTabContentView.this.ezM.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eAb < 0 || EmotionTabContentView.this.eAb >= EmotionTabContentView.this.ezY.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ezY.get(EmotionTabContentView.this.eAb)).amj() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ezM != null) {
                                if (EmotionTabContentView.this.Ur >= 0 && EmotionTabContentView.this.Ur < EmotionTabContentView.this.ezZ.size()) {
                                    EmotionTabContentView.this.ezX = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezZ.get(EmotionTabContentView.this.Ur);
                                    int aVG = EmotionTabContentView.this.ezX.aVG();
                                    EmotionTabContentView.this.bUP.setCount(aVG);
                                    EmotionTabContentView.this.bUP.setVisibility(aVG > 1 ? 0 : 4);
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
                                                    if (index >= 0 && index < EmotionTabContentView.this.ezZ.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezZ.get(index));
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
        this.ezY = new ArrayList();
        this.ezZ = new ArrayList();
        this.eAf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
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
        this.ezQ = new GifView(context);
        al.e(this.ezQ, d.f.bg_expression_bubble, this.bUJ);
        this.ezQ.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ezP = new WindowManager.LayoutParams();
        this.ezS = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.ezT = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.ezU = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ezP.width = this.ezS;
        this.ezP.height = this.ezT;
        this.ezP.gravity = 51;
        this.ezP.format = -3;
        this.ezP.type = 1000;
        this.ezP.flags |= 56;
        this.ezR = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.bUP = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.ezO = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.ezO.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ezP.type = 1000;
            this.ezP.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ezY.clear();
        this.ezZ.clear();
        if (list != null && !list.isEmpty()) {
            this.ezY.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int amm = cVar.amm();
                    int amn = cVar.amn();
                    int i4 = emotionsCount / (amm * amn);
                    if (emotionsCount % (amm * amn) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = amm * amn;
                        } else {
                            i = emotionsCount - ((amm * amn) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.pa(i3);
                        bVar.b(cVar.amj());
                        bVar.jG(amn);
                        bVar.jF(amm);
                        bVar.oW(i4);
                        bVar.oX(i5);
                        bVar.oY(i);
                        bVar.oZ(i5 * amm * amn);
                        bVar.setEndIndex((i + i2) - 1);
                        this.ezZ.add(bVar);
                    }
                }
            }
            this.eAa = this.ezZ.size();
            for (int i6 = 0; i6 < this.eAa; i6++) {
                if (this.ezZ != null && this.ezZ.get(i6) != null) {
                    this.ezZ.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void oT(int i) {
        if (this.ezZ != null) {
            int size = this.ezZ.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.ezZ.get(i2);
                    if (bVar != null && bVar.aVK() == i) {
                        this.eAd = bVar.getIndex();
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
                this.ezM = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.ezM);
                this.mViewPager.setCurrentItem(this.eAd, true);
                if (this.eAc != null) {
                    this.eAc.oV(i);
                    this.eAb = i;
                }
            }
        }
    }

    public void oU(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ezZ.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.ezZ.get(i3);
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
        if (this.ezW != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aVA() != null) {
            com.baidu.tieba.emotion.editortool.b aVA = aVar.aVA();
            String jz = aVA.aVD().jz(aVar.aVz() + i);
            if (aVA.aVE() != EmotionGroupType.USER_COLLECT || !jz.equals(com.baidu.tbadk.imageManager.d.cmF)) {
                this.ezQ.setTag(jz);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = jz;
                if (jz.startsWith("#(meme,")) {
                    this.ezQ.setShowStaticDrawable(false);
                } else {
                    this.ezQ.setShowStaticDrawable(true);
                }
                this.ezQ.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.ezR.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.ezP.x = this.rect.left - ((this.ezP.width - linearLayout.getWidth()) / 2);
                this.ezP.y = (this.rect.top - this.ezP.height) + this.ezU;
                this.ezQ.setVisibility(0);
                if (!this.ezV) {
                    this.mWindowManager.addView(this.ezQ, this.ezP);
                    this.ezV = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ezQ, this.ezP);
                }
                gridView.setSelection(i);
                if (this.ezW != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ezW - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ezW = i;
                this.ezN = gridView;
            }
        }
    }

    private void HU() {
        if (this.ezV && this.ezQ.getVisibility() != 8 && this.ezN != null) {
            this.ezN.setSelection(-1);
            this.ezQ.setVisibility(8);
            if (this.ezW != -1) {
                ((LinearLayout) this.ezN.getChildAt(this.ezW - this.ezN.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ezW = -1;
            this.ezN = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eAe.set(x, y);
                break;
            case 1:
            case 3:
                HU();
                break;
            case 2:
                this.eAe.set(x, y);
                if (this.ezV && this.ezQ.getVisibility() != 8 && this.ezN != null) {
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
                this.eAe.set(x, y);
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
                    if (this.ezN != null) {
                        offsetRectIntoDescendantCoords(this.ezN, this.rect);
                        int pointToPosition = this.ezN.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.ezN);
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
        if (this.ezV) {
            this.mWindowManager.removeView(this.ezQ);
            this.ezV = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bvr);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ezZ != null) {
            int size = this.ezZ.size();
            if (i >= 0 && i < size) {
                this.ezX = this.ezZ.get(i);
                if (this.bUP != null && this.ezX != null) {
                    if (this.Ur != i) {
                        this.Ur = i;
                        this.bUP.setVisibility(this.ezX.aVG() > 1 ? 0 : 4);
                        this.bUP.setCount(this.ezX.aVG());
                        if (this.ezX != null && this.ezX.aVK() != this.eAb) {
                            this.eAb = this.ezX.aVK();
                            if (this.eAc != null) {
                                this.eAc.oV(this.ezX.aVK());
                            }
                        }
                    }
                    float aVH = this.ezX.aVH() + f;
                    this.bUP.setPosition(aVH);
                    this.ezO.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aVH) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.ezX.aVG())));
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
        this.bUJ = i;
        al.e(this.ezQ, d.f.bg_expression_bubble, i);
        al.f(this, d.C0236d.cp_bg_line_d, i);
        this.bUP.setSelector(al.T(i, d.f.dot_pb_expression_s));
        this.bUP.setDrawable(al.T(i, d.f.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b eAh;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eAh = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eAh = bVar;
        }

        public int aVz() {
            if (this.eAh == null) {
                return 0;
            }
            return this.eAh.aVJ();
        }

        public com.baidu.tieba.emotion.editortool.b aVA() {
            return this.eAh;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eAh == null) {
                return 0;
            }
            return this.eAh.aVI();
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
                if (this.eAh.aVF() != 0) {
                    i2 = measuredWidth / this.eAh.aVF();
                }
                if (this.eAh.getRow() != 0) {
                    i3 = measuredHeight / this.eAh.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ezU * 2, EmotionTabContentView.this.ezU * 2, EmotionTabContentView.this.ezU * 2, EmotionTabContentView.this.ezU * 2);
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
            if (this.eAh != null) {
                int aVJ = this.eAh.aVJ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.e(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bUJ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String jz = this.eAh.aVD().jz(aVJ);
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
                if (this.eAh.aVE() == EmotionGroupType.BIG_EMOTION) {
                    String jz2 = this.eAh.aVD().jz(aVJ);
                    if (!TextUtils.isEmpty(jz2) && !jz2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bUJ == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0236d.cp_cont_c);
                        } else {
                            color = al.getColor(d.C0236d.cp_cont_c);
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
            if (EmotionTabContentView.this.ezZ == null) {
                return 0;
            }
            return EmotionTabContentView.this.ezZ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eAf.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eAf.jA();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ezZ != null && i < EmotionTabContentView.this.ezZ.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezZ.get(i);
                gridView2.setNumColumns(bVar.aVF());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0236d.common_color_10022);
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
                        if (EmotionTabContentView.this.VM != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aVA() != null) {
                                com.baidu.tieba.emotion.editortool.b aVA = aVar.aVA();
                                int aVz = aVar.aVz();
                                com.baidu.tbadk.editortools.emotiontool.c aVD = aVA.aVD();
                                String jz = aVA.aVD().jz(aVz + i2);
                                if (aVD.amj() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cmF.equals(jz)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(jz);
                                pVar.a(aVD.amj());
                                pVar.nD(aVD.getGroupName());
                                pVar.setPid(aVD.getGroupId());
                                pVar.setWidth(aVD.getWidth());
                                pVar.setHeight(aVD.getHeight());
                                EmotionTabContentView.this.VM.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.ezZ != null) {
                int size = EmotionTabContentView.this.ezZ.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ur) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ezZ.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ur = i;
                        EmotionTabContentView.this.bUP.setVisibility(bVar.aVG() > 1 ? 0 : 4);
                        EmotionTabContentView.this.bUP.setCount(bVar.aVG());
                        EmotionTabContentView.this.bUP.setPosition(bVar.aVH());
                        EmotionTabContentView.this.bUP.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(bVar.aVH() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(bVar.aVG())));
                    }
                    if (bVar != null && bVar.aVK() != EmotionTabContentView.this.eAb) {
                        EmotionTabContentView.this.eAb = bVar.aVK();
                        if (EmotionTabContentView.this.eAc != null) {
                            EmotionTabContentView.this.eAc.oV(bVar.aVK());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.eAc = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VM = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvr);
    }
}
