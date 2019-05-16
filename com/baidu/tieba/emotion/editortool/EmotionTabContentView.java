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
    private EmotionViewPagerAdapter eOX;
    private GridView eOY;
    private LinearLayout eOZ;
    private WindowManager.LayoutParams ePa;
    private GifView ePb;
    private ViewGroup ePc;
    private int ePd;
    private int ePe;
    private int ePf;
    private boolean ePg;
    private int ePh;
    private com.baidu.tieba.emotion.editortool.b ePi;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ePj;
    private List<com.baidu.tieba.emotion.editortool.b> ePk;
    private int ePl;
    private int ePm;
    private b ePn;
    private int ePo;
    private final Point ePp;
    private com.baidu.adp.lib.e.b<GridView> ePq;
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
        this.ePh = -1;
        this.ePl = 0;
        this.ePm = -1;
        this.Sf = -1;
        this.ePp = new Point();
        this.bCA = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.by(new ArrayList(EmotionTabContentView.this.ePj));
                        if (EmotionTabContentView.this.eOX != null) {
                            EmotionTabContentView.this.eOX.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ePm < 0 || EmotionTabContentView.this.ePm >= EmotionTabContentView.this.ePj.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ePj.get(EmotionTabContentView.this.ePm)).ari() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eOX != null) {
                                if (EmotionTabContentView.this.Sf >= 0 && EmotionTabContentView.this.Sf < EmotionTabContentView.this.ePk.size()) {
                                    EmotionTabContentView.this.ePi = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePk.get(EmotionTabContentView.this.Sf);
                                    int bcM = EmotionTabContentView.this.ePi.bcM();
                                    EmotionTabContentView.this.ccO.setCount(bcM);
                                    EmotionTabContentView.this.ccO.setVisibility(bcM > 1 ? 0 : 4);
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
                                                    int index = aVar.bcG().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ePk.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePk.get(index));
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
        this.ePh = -1;
        this.ePl = 0;
        this.ePm = -1;
        this.Sf = -1;
        this.ePp = new Point();
        this.bCA = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.by(new ArrayList(EmotionTabContentView.this.ePj));
                        if (EmotionTabContentView.this.eOX != null) {
                            EmotionTabContentView.this.eOX.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ePm < 0 || EmotionTabContentView.this.ePm >= EmotionTabContentView.this.ePj.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ePj.get(EmotionTabContentView.this.ePm)).ari() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eOX != null) {
                                if (EmotionTabContentView.this.Sf >= 0 && EmotionTabContentView.this.Sf < EmotionTabContentView.this.ePk.size()) {
                                    EmotionTabContentView.this.ePi = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePk.get(EmotionTabContentView.this.Sf);
                                    int bcM = EmotionTabContentView.this.ePi.bcM();
                                    EmotionTabContentView.this.ccO.setCount(bcM);
                                    EmotionTabContentView.this.ccO.setVisibility(bcM > 1 ? 0 : 4);
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
                                                    int index = aVar.bcG().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ePk.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePk.get(index));
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
        this.ePj = new ArrayList();
        this.ePk = new ArrayList();
        this.ePq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcE */
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
        this.ePb = new GifView(context);
        al.g(this.ePb, R.drawable.bg_expression_bubble, this.ccI);
        this.ePb.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ePa = new WindowManager.LayoutParams();
        this.ePd = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.ePe = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.ePf = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ePa.width = this.ePd;
        this.ePa.height = this.ePe;
        this.ePa.gravity = 51;
        this.ePa.format = -3;
        this.ePa.type = 1000;
        this.ePa.flags |= 56;
        this.ePc = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ccO = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.eOZ = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.eOZ.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ePa.type = 1000;
            this.ePa.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ePj.clear();
        this.ePk.clear();
        if (list != null && !list.isEmpty()) {
            this.ePj.addAll(list);
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
                        this.ePk.add(bVar);
                    }
                }
            }
            this.ePl = this.ePk.size();
            for (int i6 = 0; i6 < this.ePl; i6++) {
                if (this.ePk != null && this.ePk.get(i6) != null) {
                    this.ePk.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void pT(int i) {
        if (this.ePk != null) {
            int size = this.ePk.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.ePk.get(i2);
                    if (bVar != null && bVar.bcQ() == i) {
                        this.ePo = bVar.getIndex();
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
                this.eOX = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eOX);
                this.mViewPager.setCurrentItem(this.ePo, true);
                if (this.ePn != null) {
                    this.ePn.pV(i);
                    this.ePm = i;
                }
            }
        }
    }

    public void pU(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ePk.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.ePk.get(i3);
                        if (bVar == null || bVar.bcQ() != i) {
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
        if (this.ePh != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bcG() != null) {
            com.baidu.tieba.emotion.editortool.b bcG = aVar.bcG();
            String km = bcG.bcJ().km(aVar.bcF() + i);
            if (bcG.bcK() != EmotionGroupType.USER_COLLECT || !km.equals(com.baidu.tbadk.imageManager.d.cuQ)) {
                this.ePb.setTag(km);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = km;
                if (km.startsWith("#(meme,")) {
                    this.ePb.setShowStaticDrawable(false);
                } else {
                    this.ePb.setShowStaticDrawable(true);
                }
                this.ePb.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.ePc.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.ePa.x = this.rect.left - ((this.ePa.width - linearLayout.getWidth()) / 2);
                this.ePa.y = (this.rect.top - this.ePa.height) + this.ePf;
                this.ePb.setVisibility(0);
                if (!this.ePg) {
                    this.mWindowManager.addView(this.ePb, this.ePa);
                    this.ePg = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ePb, this.ePa);
                }
                gridView.setSelection(i);
                if (this.ePh != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ePh - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ePh = i;
                this.eOY = gridView;
            }
        }
    }

    private void Ki() {
        if (this.ePg && this.ePb.getVisibility() != 8 && this.eOY != null) {
            this.eOY.setSelection(-1);
            this.ePb.setVisibility(8);
            if (this.ePh != -1) {
                ((LinearLayout) this.eOY.getChildAt(this.ePh - this.eOY.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ePh = -1;
            this.eOY = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ePp.set(x, y);
                break;
            case 1:
            case 3:
                Ki();
                break;
            case 2:
                this.ePp.set(x, y);
                if (this.ePg && this.ePb.getVisibility() != 8 && this.eOY != null) {
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
                this.ePp.set(x, y);
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
                    if (this.eOY != null) {
                        offsetRectIntoDescendantCoords(this.eOY, this.rect);
                        int pointToPosition = this.eOY.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eOY);
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
        if (this.ePg) {
            this.mWindowManager.removeView(this.ePb);
            this.ePg = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bCA);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ePk != null) {
            int size = this.ePk.size();
            if (i >= 0 && i < size) {
                this.ePi = this.ePk.get(i);
                if (this.ccO != null && this.ePi != null) {
                    if (this.Sf != i) {
                        this.Sf = i;
                        this.ccO.setVisibility(this.ePi.bcM() > 1 ? 0 : 4);
                        this.ccO.setCount(this.ePi.bcM());
                        if (this.ePi != null && this.ePi.bcQ() != this.ePm) {
                            this.ePm = this.ePi.bcQ();
                            if (this.ePn != null) {
                                this.ePn.pV(this.ePi.bcQ());
                            }
                        }
                    }
                    float bcN = this.ePi.bcN() + f;
                    this.ccO.setPosition(bcN);
                    this.eOZ.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bcN) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.ePi.bcM())));
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
        al.g(this.ePb, R.drawable.bg_expression_bubble, i);
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
        private com.baidu.tieba.emotion.editortool.b ePs;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ePs = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ePs = bVar;
        }

        public int bcF() {
            if (this.ePs == null) {
                return 0;
            }
            return this.ePs.bcP();
        }

        public com.baidu.tieba.emotion.editortool.b bcG() {
            return this.ePs;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ePs == null) {
                return 0;
            }
            return this.ePs.bcO();
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
                if (this.ePs.bcL() != 0) {
                    i2 = measuredWidth / this.ePs.bcL();
                }
                if (this.ePs.getRow() != 0) {
                    i3 = measuredHeight / this.ePs.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ePf * 2, EmotionTabContentView.this.ePf * 2, EmotionTabContentView.this.ePf * 2, EmotionTabContentView.this.ePf * 2);
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
            if (this.ePs != null) {
                int bcP = this.ePs.bcP() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.g(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ccI);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String km = this.ePs.bcJ().km(bcP);
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
                if (this.ePs.bcK() == EmotionGroupType.BIG_EMOTION) {
                    String km2 = this.ePs.bcJ().km(bcP);
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
            if (EmotionTabContentView.this.ePk == null) {
                return 0;
            }
            return EmotionTabContentView.this.ePk.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ePq.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ePq.iu();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ePk != null && i < EmotionTabContentView.this.ePk.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePk.get(i);
                gridView2.setNumColumns(bVar.bcL());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bcG() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bcG = aVar.bcG();
                        if (bcG.bcK() == EmotionGroupType.BIG_EMOTION || bcG.bcK() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.bcG() != null) {
                                com.baidu.tieba.emotion.editortool.b bcG = aVar.bcG();
                                int bcF = aVar.bcF();
                                com.baidu.tbadk.editortools.emotiontool.c bcJ = bcG.bcJ();
                                String km = bcG.bcJ().km(bcF + i2);
                                if (bcJ.ari() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cuQ.equals(km)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(km);
                                pVar.a(bcJ.ari());
                                pVar.oO(bcJ.getGroupName());
                                pVar.setPid(bcJ.getGroupId());
                                pVar.setWidth(bcJ.getWidth());
                                pVar.setHeight(bcJ.getHeight());
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
            if (EmotionTabContentView.this.ePk != null) {
                int size = EmotionTabContentView.this.ePk.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Sf) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ePk.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Sf = i;
                        EmotionTabContentView.this.ccO.setVisibility(bVar.bcM() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ccO.setCount(bVar.bcM());
                        EmotionTabContentView.this.ccO.setPosition(bVar.bcN());
                        EmotionTabContentView.this.ccO.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bcN() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bcM())));
                    }
                    if (bVar != null && bVar.bcQ() != EmotionTabContentView.this.ePm) {
                        EmotionTabContentView.this.ePm = bVar.bcQ();
                        if (EmotionTabContentView.this.ePn != null) {
                            EmotionTabContentView.this.ePn.pV(bVar.bcQ());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.ePn = bVar;
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
