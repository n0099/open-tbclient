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
    private int aGa;
    private int aLF;
    private IndicatorView aLL;
    private CustomMessageListener aof;
    private b dmA;
    private int dmB;
    private final Point dmC;
    private com.baidu.adp.lib.e.b<GridView> dmD;
    private EmotionViewPagerAdapter dmk;
    private GridView dml;
    private LinearLayout dmm;
    private WindowManager.LayoutParams dmn;
    private GifView dmo;
    private ViewGroup dmp;
    private int dmq;
    private int dmr;
    private int dms;
    private boolean dmt;
    private int dmu;
    private com.baidu.tieba.emotion.editortool.b dmv;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dmw;
    private List<com.baidu.tieba.emotion.editortool.b> dmx;
    private int dmy;
    private int dmz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes5.dex */
    public interface b {
        void lf(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dmu = -1;
        this.dmy = 0;
        this.dmz = -1;
        this.aGa = -1;
        this.dmC = new Point();
        this.aof = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bc(new ArrayList(EmotionTabContentView.this.dmw));
                        if (EmotionTabContentView.this.dmk != null) {
                            EmotionTabContentView.this.dmk.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dmz < 0 || EmotionTabContentView.this.dmz >= EmotionTabContentView.this.dmw.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dmw.get(EmotionTabContentView.this.dmz)).Mm() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dmk != null) {
                                if (EmotionTabContentView.this.aGa >= 0 && EmotionTabContentView.this.aGa < EmotionTabContentView.this.dmx.size()) {
                                    EmotionTabContentView.this.dmv = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dmx.get(EmotionTabContentView.this.aGa);
                                    int auC = EmotionTabContentView.this.dmv.auC();
                                    EmotionTabContentView.this.aLL.setCount(auC);
                                    EmotionTabContentView.this.aLL.setVisibility(auC > 1 ? 0 : 4);
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
                                                    int index = aVar.auw().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dmx.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dmx.get(index));
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
        this.dmu = -1;
        this.dmy = 0;
        this.dmz = -1;
        this.aGa = -1;
        this.dmC = new Point();
        this.aof = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bc(new ArrayList(EmotionTabContentView.this.dmw));
                        if (EmotionTabContentView.this.dmk != null) {
                            EmotionTabContentView.this.dmk.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dmz < 0 || EmotionTabContentView.this.dmz >= EmotionTabContentView.this.dmw.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dmw.get(EmotionTabContentView.this.dmz)).Mm() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dmk != null) {
                                if (EmotionTabContentView.this.aGa >= 0 && EmotionTabContentView.this.aGa < EmotionTabContentView.this.dmx.size()) {
                                    EmotionTabContentView.this.dmv = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dmx.get(EmotionTabContentView.this.aGa);
                                    int auC = EmotionTabContentView.this.dmv.auC();
                                    EmotionTabContentView.this.aLL.setCount(auC);
                                    EmotionTabContentView.this.aLL.setVisibility(auC > 1 ? 0 : 4);
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
                                                    int index = aVar.auw().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dmx.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dmx.get(index));
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
        this.dmw = new ArrayList();
        this.dmx = new ArrayList();
        this.dmD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: auu */
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
        this.dmo = new GifView(context);
        al.d(this.dmo, e.f.bg_expression_bubble, this.aLF);
        this.dmo.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.dmn = new WindowManager.LayoutParams();
        this.dmq = context.getResources().getDimensionPixelSize(e.C0210e.ds240);
        this.dmr = context.getResources().getDimensionPixelSize(e.C0210e.ds252);
        this.dms = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.dmn.width = this.dmq;
        this.dmn.height = this.dmr;
        this.dmn.gravity = 51;
        this.dmn.format = -3;
        this.dmn.type = 1000;
        this.dmn.flags |= 56;
        this.dmp = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aLL = (IndicatorView) findViewById(e.g.face_tab_indicator);
        this.dmm = (LinearLayout) findViewById(e.g.face_tab_indicator_layout);
        this.dmm.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dmn.type = 1000;
            this.dmn.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dmw.clear();
        this.dmx.clear();
        if (list != null && !list.isEmpty()) {
            this.dmw.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Mp = cVar.Mp();
                    int Mq = cVar.Mq();
                    int i4 = emotionsCount / (Mp * Mq);
                    if (emotionsCount % (Mp * Mq) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = Mp * Mq;
                        } else {
                            i = emotionsCount - ((Mp * Mq) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.lk(i3);
                        bVar.b(cVar.Mm());
                        bVar.fU(Mq);
                        bVar.fT(Mp);
                        bVar.lg(i4);
                        bVar.lh(i5);
                        bVar.li(i);
                        bVar.lj(i5 * Mp * Mq);
                        bVar.setEndIndex((i + i2) - 1);
                        this.dmx.add(bVar);
                    }
                }
            }
            this.dmy = this.dmx.size();
            for (int i6 = 0; i6 < this.dmy; i6++) {
                if (this.dmx != null && this.dmx.get(i6) != null) {
                    this.dmx.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void ld(int i) {
        if (this.dmx != null) {
            int size = this.dmx.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.dmx.get(i2);
                    if (bVar != null && bVar.auG() == i) {
                        this.dmB = bVar.getIndex();
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
                bc(list);
                ld(i);
                this.dmk = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.dmk);
                this.mViewPager.setCurrentItem(this.dmB, true);
                if (this.dmA != null) {
                    this.dmA.lf(i);
                    this.dmz = i;
                }
            }
        }
    }

    public void le(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.dmx.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.dmx.get(i3);
                        if (bVar == null || bVar.auG() != i) {
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
        if (this.dmu != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.auw() != null) {
            com.baidu.tieba.emotion.editortool.b auw = aVar.auw();
            String fN = auw.auz().fN(aVar.auv() + i);
            if (auw.auA() != EmotionGroupType.USER_COLLECT || !fN.equals(com.baidu.tbadk.imageManager.d.bcs)) {
                this.dmo.setTag(fN);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = fN;
                if (fN.startsWith("#(meme,")) {
                    this.dmo.setShowStaticDrawable(false);
                } else {
                    this.dmo.setShowStaticDrawable(true);
                }
                this.dmo.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dmp.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dmn.x = this.rect.left - ((this.dmn.width - linearLayout.getWidth()) / 2);
                this.dmn.y = (this.rect.top - this.dmn.height) + this.dms;
                this.dmo.setVisibility(0);
                if (!this.dmt) {
                    this.mWindowManager.addView(this.dmo, this.dmn);
                    this.dmt = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dmo, this.dmn);
                }
                gridView.setSelection(i);
                if (this.dmu != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dmu - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dmu = i;
                this.dml = gridView;
            }
        }
    }

    private void onUp() {
        if (this.dmt && this.dmo.getVisibility() != 8 && this.dml != null) {
            this.dml.setSelection(-1);
            this.dmo.setVisibility(8);
            if (this.dmu != -1) {
                ((LinearLayout) this.dml.getChildAt(this.dmu - this.dml.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dmu = -1;
            this.dml = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dmC.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.dmC.set(x, y);
                if (this.dmt && this.dmo.getVisibility() != 8 && this.dml != null) {
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
                this.dmC.set(x, y);
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
                    if (this.dml != null) {
                        offsetRectIntoDescendantCoords(this.dml, this.rect);
                        int pointToPosition = this.dml.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dml);
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
        if (this.dmt) {
            this.mWindowManager.removeView(this.dmo);
            this.dmt = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aof);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dmx != null) {
            int size = this.dmx.size();
            if (i >= 0 && i < size) {
                this.dmv = this.dmx.get(i);
                if (this.aLL != null && this.dmv != null) {
                    if (this.aGa != i) {
                        this.aGa = i;
                        this.aLL.setVisibility(this.dmv.auC() > 1 ? 0 : 4);
                        this.aLL.setCount(this.dmv.auC());
                        if (this.dmv != null && this.dmv.auG() != this.dmz) {
                            this.dmz = this.dmv.auG();
                            if (this.dmA != null) {
                                this.dmA.lf(this.dmv.auG());
                            }
                        }
                    }
                    float auD = this.dmv.auD() + f;
                    this.aLL.setPosition(auD);
                    this.dmm.setContentDescription(String.format(getResources().getString(e.j.emotion_selection), Integer.valueOf(((int) auD) + 1)) + String.format(getResources().getString(e.j.emotion_page), Integer.valueOf(this.dmv.auC())));
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
        this.aLF = i;
        al.d(this.dmo, e.f.bg_expression_bubble, i);
        al.e(this, e.d.cp_bg_line_d, i);
        this.aLL.setSelector(al.y(i, e.f.dot_pb_expression_s));
        this.aLL.setDrawable(al.y(i, e.f.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b dmF;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dmF = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.dmF = bVar;
        }

        public int auv() {
            if (this.dmF == null) {
                return 0;
            }
            return this.dmF.auF();
        }

        public com.baidu.tieba.emotion.editortool.b auw() {
            return this.dmF;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dmF == null) {
                return 0;
            }
            return this.dmF.auE();
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
                if (this.dmF.auB() != 0) {
                    i2 = measuredWidth / this.dmF.auB();
                }
                if (this.dmF.getRow() != 0) {
                    i3 = measuredHeight / this.dmF.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dms * 2, EmotionTabContentView.this.dms * 2, EmotionTabContentView.this.dms * 2, EmotionTabContentView.this.dms * 2);
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
            if (this.dmF != null) {
                int auF = this.dmF.auF() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(e.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, e.f.btn_choose_face_selector, EmotionTabContentView.this.aLF);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String fN = this.dmF.auz().fN(auF);
                tbImageView.setTag(fN);
                if (!TextUtils.isEmpty(fN)) {
                    Object a = com.baidu.adp.lib.f.c.jA().a(fN, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, fN, false, null);
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
                if (this.dmF.auA() == EmotionGroupType.BIG_EMOTION) {
                    String fN2 = this.dmF.auz().fN(auF);
                    if (!TextUtils.isEmpty(fN2) && !fN2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aLF == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(e.d.cp_cont_c);
                        } else {
                            color = al.getColor(e.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(fN2.substring(fN2.lastIndexOf(BaseRequestAction.SPLITE) + 1, fN2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (fN != null && fN.length() > 3) {
                    linearLayout3.setContentDescription(fN.substring(2, fN.length() - 1));
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
            if (EmotionTabContentView.this.dmx == null) {
                return 0;
            }
            return EmotionTabContentView.this.dmx.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dmD.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dmD.jy();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dmx != null && i < EmotionTabContentView.this.dmx.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dmx.get(i);
                gridView2.setNumColumns(bVar.auB());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(e.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.auw() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b auw = aVar.auw();
                        if (auw.auA() == EmotionGroupType.BIG_EMOTION || auw.auA() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.auw() != null) {
                                com.baidu.tieba.emotion.editortool.b auw = aVar.auw();
                                int auv = aVar.auv();
                                com.baidu.tbadk.editortools.emotiontool.c auz = auw.auz();
                                String fN = auw.auz().fN(auv + i2);
                                if (auz.Mm() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.bcs.equals(fN)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(fN);
                                pVar.a(auz.Mm());
                                pVar.gD(auz.getGroupName());
                                pVar.setPid(auz.getGroupId());
                                pVar.setWidth(auz.getWidth());
                                pVar.setHeight(auz.getHeight());
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
            if (EmotionTabContentView.this.dmx != null) {
                int size = EmotionTabContentView.this.dmx.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aGa) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.dmx.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aGa = i;
                        EmotionTabContentView.this.aLL.setVisibility(bVar.auC() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aLL.setCount(bVar.auC());
                        EmotionTabContentView.this.aLL.setPosition(bVar.auD());
                        EmotionTabContentView.this.aLL.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_selection), Integer.valueOf(bVar.auD() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_page), Integer.valueOf(bVar.auC())));
                    }
                    if (bVar != null && bVar.auG() != EmotionTabContentView.this.dmz) {
                        EmotionTabContentView.this.dmz = bVar.auG();
                        if (EmotionTabContentView.this.dmA != null) {
                            EmotionTabContentView.this.dmA.lf(bVar.auG());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.dmA = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aof);
    }
}
