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
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Sf;
    private EditorTools TB;
    private CustomMessageListener bCA;
    private int ccI;
    private IndicatorView ccO;
    private EmotionViewPagerAdapter eOY;
    private GridView eOZ;
    private LinearLayout ePa;
    private WindowManager.LayoutParams ePb;
    private GifView ePc;
    private ViewGroup ePd;
    private int ePe;
    private int ePf;
    private int ePg;
    private boolean ePh;
    private int ePi;
    private com.baidu.tieba.emotion.editortool.b ePj;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ePk;
    private List<com.baidu.tieba.emotion.editortool.b> ePl;
    private int ePm;
    private int ePn;
    private b ePo;
    private int ePp;
    private final Point ePq;
    private com.baidu.adp.lib.e.b<GridView> ePr;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes2.dex */
    public interface b {
        void pV(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.ePi = -1;
        this.ePm = 0;
        this.ePn = -1;
        this.Sf = -1;
        this.ePq = new Point();
        this.bCA = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.by(new ArrayList(EmotionTabContentView.this.ePk));
                        if (EmotionTabContentView.this.eOY != null) {
                            EmotionTabContentView.this.eOY.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ePn < 0 || EmotionTabContentView.this.ePn >= EmotionTabContentView.this.ePk.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ePk.get(EmotionTabContentView.this.ePn)).ari() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eOY != null) {
                                if (EmotionTabContentView.this.Sf >= 0 && EmotionTabContentView.this.Sf < EmotionTabContentView.this.ePl.size()) {
                                    EmotionTabContentView.this.ePj = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePl.get(EmotionTabContentView.this.Sf);
                                    int bcP = EmotionTabContentView.this.ePj.bcP();
                                    EmotionTabContentView.this.ccO.setCount(bcP);
                                    EmotionTabContentView.this.ccO.setVisibility(bcP > 1 ? 0 : 4);
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
                                                    int index = aVar.bcJ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ePl.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePl.get(index));
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
        this.ePi = -1;
        this.ePm = 0;
        this.ePn = -1;
        this.Sf = -1;
        this.ePq = new Point();
        this.bCA = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.by(new ArrayList(EmotionTabContentView.this.ePk));
                        if (EmotionTabContentView.this.eOY != null) {
                            EmotionTabContentView.this.eOY.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ePn < 0 || EmotionTabContentView.this.ePn >= EmotionTabContentView.this.ePk.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ePk.get(EmotionTabContentView.this.ePn)).ari() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eOY != null) {
                                if (EmotionTabContentView.this.Sf >= 0 && EmotionTabContentView.this.Sf < EmotionTabContentView.this.ePl.size()) {
                                    EmotionTabContentView.this.ePj = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePl.get(EmotionTabContentView.this.Sf);
                                    int bcP = EmotionTabContentView.this.ePj.bcP();
                                    EmotionTabContentView.this.ccO.setCount(bcP);
                                    EmotionTabContentView.this.ccO.setVisibility(bcP > 1 ? 0 : 4);
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
                                                    int index = aVar.bcJ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ePl.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePl.get(index));
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
        this.ePk = new ArrayList();
        this.ePl = new ArrayList();
        this.ePr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcH */
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
        this.ePc = new GifView(context);
        al.g(this.ePc, R.drawable.bg_expression_bubble, this.ccI);
        this.ePc.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ePb = new WindowManager.LayoutParams();
        this.ePe = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.ePf = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.ePg = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ePb.width = this.ePe;
        this.ePb.height = this.ePf;
        this.ePb.gravity = 51;
        this.ePb.format = -3;
        this.ePb.type = 1000;
        this.ePb.flags |= 56;
        this.ePd = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ccO = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.ePa = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.ePa.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ePb.type = 1000;
            this.ePb.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ePk.clear();
        this.ePl.clear();
        if (list != null && !list.isEmpty()) {
            this.ePk.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int arl = cVar.arl();
                    int arm = cVar.arm();
                    int i4 = emotionsCount / (arl * arm);
                    if (emotionsCount % (arl * arm) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = arl * arm;
                        } else {
                            i = emotionsCount - ((arl * arm) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.qa(i3);
                        bVar.b(cVar.ari());
                        bVar.kt(arm);
                        bVar.ks(arl);
                        bVar.pW(i4);
                        bVar.pX(i5);
                        bVar.pY(i);
                        bVar.pZ(i5 * arl * arm);
                        bVar.setEndIndex((i + i2) - 1);
                        this.ePl.add(bVar);
                    }
                }
            }
            this.ePm = this.ePl.size();
            for (int i6 = 0; i6 < this.ePm; i6++) {
                if (this.ePl != null && this.ePl.get(i6) != null) {
                    this.ePl.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void pT(int i) {
        if (this.ePl != null) {
            int size = this.ePl.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.ePl.get(i2);
                    if (bVar != null && bVar.bcT() == i) {
                        this.ePp = bVar.getIndex();
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
                by(list);
                pT(i);
                this.eOY = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eOY);
                this.mViewPager.setCurrentItem(this.ePp, true);
                if (this.ePo != null) {
                    this.ePo.pV(i);
                    this.ePn = i;
                }
            }
        }
    }

    public void pU(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ePl.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.ePl.get(i3);
                        if (bVar == null || bVar.bcT() != i) {
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
        if (this.ePi != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bcJ() != null) {
            com.baidu.tieba.emotion.editortool.b bcJ = aVar.bcJ();
            String km = bcJ.bcM().km(aVar.bcI() + i);
            if (bcJ.bcN() != EmotionGroupType.USER_COLLECT || !km.equals(com.baidu.tbadk.imageManager.d.cuQ)) {
                this.ePc.setTag(km);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = km;
                if (km.startsWith("#(meme,")) {
                    this.ePc.setShowStaticDrawable(false);
                } else {
                    this.ePc.setShowStaticDrawable(true);
                }
                this.ePc.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.ePd.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.ePb.x = this.rect.left - ((this.ePb.width - linearLayout.getWidth()) / 2);
                this.ePb.y = (this.rect.top - this.ePb.height) + this.ePg;
                this.ePc.setVisibility(0);
                if (!this.ePh) {
                    this.mWindowManager.addView(this.ePc, this.ePb);
                    this.ePh = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ePc, this.ePb);
                }
                gridView.setSelection(i);
                if (this.ePi != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ePi - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ePi = i;
                this.eOZ = gridView;
            }
        }
    }

    private void Ki() {
        if (this.ePh && this.ePc.getVisibility() != 8 && this.eOZ != null) {
            this.eOZ.setSelection(-1);
            this.ePc.setVisibility(8);
            if (this.ePi != -1) {
                ((LinearLayout) this.eOZ.getChildAt(this.ePi - this.eOZ.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ePi = -1;
            this.eOZ = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ePq.set(x, y);
                break;
            case 1:
            case 3:
                Ki();
                break;
            case 2:
                this.ePq.set(x, y);
                if (this.ePh && this.ePc.getVisibility() != 8 && this.eOZ != null) {
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
                this.ePq.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Ki();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Ki();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.eOZ != null) {
                        offsetRectIntoDescendantCoords(this.eOZ, this.rect);
                        int pointToPosition = this.eOZ.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eOZ);
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
        if (this.ePh) {
            this.mWindowManager.removeView(this.ePc);
            this.ePh = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bCA);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ePl != null) {
            int size = this.ePl.size();
            if (i >= 0 && i < size) {
                this.ePj = this.ePl.get(i);
                if (this.ccO != null && this.ePj != null) {
                    if (this.Sf != i) {
                        this.Sf = i;
                        this.ccO.setVisibility(this.ePj.bcP() > 1 ? 0 : 4);
                        this.ccO.setCount(this.ePj.bcP());
                        if (this.ePj != null && this.ePj.bcT() != this.ePn) {
                            this.ePn = this.ePj.bcT();
                            if (this.ePo != null) {
                                this.ePo.pV(this.ePj.bcT());
                            }
                        }
                    }
                    float bcQ = this.ePj.bcQ() + f;
                    this.ccO.setPosition(bcQ);
                    this.ePa.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bcQ) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.ePj.bcP())));
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
        this.ccI = i;
        al.g(this.ePc, R.drawable.bg_expression_bubble, i);
        al.h(this, R.color.cp_bg_line_d, i);
        this.ccO.setSelector(al.S(i, R.drawable.dot_pb_expression_s));
        this.ccO.setDrawable(al.S(i, R.drawable.dot_pb_expression_n));
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
        Ki();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b ePt;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ePt = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ePt = bVar;
        }

        public int bcI() {
            if (this.ePt == null) {
                return 0;
            }
            return this.ePt.bcS();
        }

        public com.baidu.tieba.emotion.editortool.b bcJ() {
            return this.ePt;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ePt == null) {
                return 0;
            }
            return this.ePt.bcR();
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
                if (this.ePt.bcO() != 0) {
                    i2 = measuredWidth / this.ePt.bcO();
                }
                if (this.ePt.getRow() != 0) {
                    i3 = measuredHeight / this.ePt.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ePg * 2, EmotionTabContentView.this.ePg * 2, EmotionTabContentView.this.ePg * 2, EmotionTabContentView.this.ePg * 2);
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
            if (this.ePt != null) {
                int bcS = this.ePt.bcS() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.g(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ccI);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String km = this.ePt.bcM().km(bcS);
                tbImageView.setTag(km);
                if (!TextUtils.isEmpty(km)) {
                    Object a = com.baidu.adp.lib.f.c.iv().a(km, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, km, false, null);
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
                if (this.ePt.bcN() == EmotionGroupType.BIG_EMOTION) {
                    String km2 = this.ePt.bcM().km(bcS);
                    if (!TextUtils.isEmpty(km2) && !km2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ccI == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = al.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(km2.substring(km2.lastIndexOf("_") + 1, km2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (km != null && km.length() > 3) {
                    linearLayout3.setContentDescription(km.substring(2, km.length() - 1));
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
            if (EmotionTabContentView.this.ePl == null) {
                return 0;
            }
            return EmotionTabContentView.this.ePl.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ePr.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ePr.iu();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ePl != null && i < EmotionTabContentView.this.ePl.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePl.get(i);
                gridView2.setNumColumns(bVar.bcO());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bcJ() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bcJ = aVar.bcJ();
                        if (bcJ.bcN() == EmotionGroupType.BIG_EMOTION || bcJ.bcN() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.TB != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bcJ() != null) {
                                com.baidu.tieba.emotion.editortool.b bcJ = aVar.bcJ();
                                int bcI = aVar.bcI();
                                com.baidu.tbadk.editortools.emotiontool.c bcM = bcJ.bcM();
                                String km = bcJ.bcM().km(bcI + i2);
                                if (bcM.ari() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cuQ.equals(km)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(km);
                                pVar.a(bcM.ari());
                                pVar.oO(bcM.getGroupName());
                                pVar.setPid(bcM.getGroupId());
                                pVar.setWidth(bcM.getWidth());
                                pVar.setHeight(bcM.getHeight());
                                EmotionTabContentView.this.TB.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.ePl != null) {
                int size = EmotionTabContentView.this.ePl.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Sf) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePl.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Sf = i;
                        EmotionTabContentView.this.ccO.setVisibility(bVar.bcP() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ccO.setCount(bVar.bcP());
                        EmotionTabContentView.this.ccO.setPosition(bVar.bcQ());
                        EmotionTabContentView.this.ccO.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bcQ() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bcP())));
                    }
                    if (bVar != null && bVar.bcT() != EmotionTabContentView.this.ePn) {
                        EmotionTabContentView.this.ePn = bVar.bcT();
                        if (EmotionTabContentView.this.ePo != null) {
                            EmotionTabContentView.this.ePo.pV(bVar.bcT());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.ePo = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bCA);
    }
}
