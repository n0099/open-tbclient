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
import com.baidu.tbadk.core.util.am;
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
    private int Sw;
    private EditorTools TU;
    private CustomMessageListener bDy;
    private int cdL;
    private IndicatorView cdR;
    private final Rect cxc;
    private EmotionViewPagerAdapter eTY;
    private GridView eTZ;
    private LinearLayout eUa;
    private WindowManager.LayoutParams eUb;
    private GifView eUc;
    private ViewGroup eUd;
    private int eUe;
    private int eUf;
    private int eUg;
    private boolean eUh;
    private int eUi;
    private com.baidu.tieba.emotion.editortool.b eUj;
    private List<com.baidu.tbadk.editortools.emotiontool.c> eUk;
    private List<com.baidu.tieba.emotion.editortool.b> eUl;
    private int eUm;
    private int eUn;
    private b eUo;
    private int eUp;
    private final Point eUq;
    private com.baidu.adp.lib.e.b<GridView> eUr;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes2.dex */
    public interface b {
        void qm(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxc = new Rect();
        this.eUi = -1;
        this.eUm = 0;
        this.eUn = -1;
        this.Sw = -1;
        this.eUq = new Point();
        this.bDy = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bA(new ArrayList(EmotionTabContentView.this.eUk));
                        if (EmotionTabContentView.this.eTY != null) {
                            EmotionTabContentView.this.eTY.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eUn < 0 || EmotionTabContentView.this.eUn >= EmotionTabContentView.this.eUk.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eUk.get(EmotionTabContentView.this.eUn)).aso() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eTY != null) {
                                if (EmotionTabContentView.this.Sw >= 0 && EmotionTabContentView.this.Sw < EmotionTabContentView.this.eUl.size()) {
                                    EmotionTabContentView.this.eUj = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUl.get(EmotionTabContentView.this.Sw);
                                    int beR = EmotionTabContentView.this.eUj.beR();
                                    EmotionTabContentView.this.cdR.setCount(beR);
                                    EmotionTabContentView.this.cdR.setVisibility(beR > 1 ? 0 : 4);
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
                                                    int index = aVar.beL().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eUl.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUl.get(index));
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
        this.cxc = new Rect();
        this.eUi = -1;
        this.eUm = 0;
        this.eUn = -1;
        this.Sw = -1;
        this.eUq = new Point();
        this.bDy = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bA(new ArrayList(EmotionTabContentView.this.eUk));
                        if (EmotionTabContentView.this.eTY != null) {
                            EmotionTabContentView.this.eTY.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eUn < 0 || EmotionTabContentView.this.eUn >= EmotionTabContentView.this.eUk.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eUk.get(EmotionTabContentView.this.eUn)).aso() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eTY != null) {
                                if (EmotionTabContentView.this.Sw >= 0 && EmotionTabContentView.this.Sw < EmotionTabContentView.this.eUl.size()) {
                                    EmotionTabContentView.this.eUj = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUl.get(EmotionTabContentView.this.Sw);
                                    int beR = EmotionTabContentView.this.eUj.beR();
                                    EmotionTabContentView.this.cdR.setCount(beR);
                                    EmotionTabContentView.this.cdR.setVisibility(beR > 1 ? 0 : 4);
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
                                                    int index = aVar.beL().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eUl.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUl.get(index));
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
        this.eUk = new ArrayList();
        this.eUl = new ArrayList();
        this.eUr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beJ */
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
        this.eUc = new GifView(context);
        am.g(this.eUc, R.drawable.bg_expression_bubble, this.cdL);
        this.eUc.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.eUb = new WindowManager.LayoutParams();
        this.eUe = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.eUf = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.eUg = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eUb.width = this.eUe;
        this.eUb.height = this.eUf;
        this.eUb.gravity = 51;
        this.eUb.format = -3;
        this.eUb.type = 1000;
        this.eUb.flags |= 56;
        this.eUd = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.cdR = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.eUa = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.eUa.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.eUb.type = 1000;
            this.eUb.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.eUk.clear();
        this.eUl.clear();
        if (list != null && !list.isEmpty()) {
            this.eUk.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int asr = cVar.asr();
                    int ass = cVar.ass();
                    int i4 = emotionsCount / (asr * ass);
                    if (emotionsCount % (asr * ass) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = asr * ass;
                        } else {
                            i = emotionsCount - ((asr * ass) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.qs(i3);
                        bVar.b(cVar.aso());
                        bVar.kz(ass);
                        bVar.ky(asr);
                        bVar.qn(i4);
                        bVar.qo(i5);
                        bVar.qp(i);
                        bVar.qq(i5 * asr * ass);
                        bVar.qr((i + i2) - 1);
                        this.eUl.add(bVar);
                    }
                }
            }
            this.eUm = this.eUl.size();
            for (int i6 = 0; i6 < this.eUm; i6++) {
                if (this.eUl != null && this.eUl.get(i6) != null) {
                    this.eUl.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void qk(int i) {
        if (this.eUl != null) {
            int size = this.eUl.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.eUl.get(i2);
                    if (bVar != null && bVar.beV() == i) {
                        this.eUp = bVar.getIndex();
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
                bA(list);
                qk(i);
                this.eTY = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eTY);
                this.mViewPager.setCurrentItem(this.eUp, true);
                if (this.eUo != null) {
                    this.eUo.qm(i);
                    this.eUn = i;
                }
            }
        }
    }

    public void ql(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.eUl.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.eUl.get(i3);
                        if (bVar == null || bVar.beV() != i) {
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
        if (this.eUi != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.beL() != null) {
            com.baidu.tieba.emotion.editortool.b beL = aVar.beL();
            String ks = beL.beO().ks(aVar.beK() + i);
            if (beL.beP() != EmotionGroupType.USER_COLLECT || !ks.equals(com.baidu.tbadk.imageManager.d.cwf)) {
                this.eUc.setTag(ks);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ks;
                if (ks.startsWith("#(meme,")) {
                    this.eUc.setShowStaticDrawable(false);
                } else {
                    this.eUc.setShowStaticDrawable(true);
                }
                this.eUc.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.cxc);
                this.eUd.offsetDescendantRectToMyCoords(linearLayout, this.cxc);
                this.eUb.x = this.cxc.left - ((this.eUb.width - linearLayout.getWidth()) / 2);
                this.eUb.y = (this.cxc.top - this.eUb.height) + this.eUg;
                this.eUc.setVisibility(0);
                if (!this.eUh) {
                    this.mWindowManager.addView(this.eUc, this.eUb);
                    this.eUh = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.eUc, this.eUb);
                }
                gridView.setSelection(i);
                if (this.eUi != -1) {
                    ((LinearLayout) gridView.getChildAt(this.eUi - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.eUi = i;
                this.eTZ = gridView;
            }
        }
    }

    private void KV() {
        if (this.eUh && this.eUc.getVisibility() != 8 && this.eTZ != null) {
            this.eTZ.setSelection(-1);
            this.eUc.setVisibility(8);
            if (this.eUi != -1) {
                ((LinearLayout) this.eTZ.getChildAt(this.eUi - this.eTZ.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.eUi = -1;
            this.eTZ = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eUq.set(x, y);
                break;
            case 1:
            case 3:
                KV();
                break;
            case 2:
                this.eUq.set(x, y);
                if (this.eUh && this.eUc.getVisibility() != 8 && this.eTZ != null) {
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
                this.eUq.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                KV();
                break;
            case 2:
                getFocusedRect(this.cxc);
                if (!this.cxc.contains(x, y)) {
                    KV();
                    break;
                } else {
                    this.cxc.set(x, y, x + 1, y + 1);
                    if (this.eTZ != null) {
                        offsetRectIntoDescendantCoords(this.eTZ, this.cxc);
                        int pointToPosition = this.eTZ.pointToPosition(this.cxc.left, this.cxc.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eTZ);
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
        if (this.eUh) {
            this.mWindowManager.removeView(this.eUc);
            this.eUh = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bDy);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.eUl != null) {
            int size = this.eUl.size();
            if (i >= 0 && i < size) {
                this.eUj = this.eUl.get(i);
                if (this.cdR != null && this.eUj != null) {
                    if (this.Sw != i) {
                        this.Sw = i;
                        this.cdR.setVisibility(this.eUj.beR() > 1 ? 0 : 4);
                        this.cdR.setCount(this.eUj.beR());
                        if (this.eUj != null && this.eUj.beV() != this.eUn) {
                            this.eUn = this.eUj.beV();
                            if (this.eUo != null) {
                                this.eUo.qm(this.eUj.beV());
                            }
                        }
                    }
                    float beS = this.eUj.beS() + f;
                    this.cdR.setPosition(beS);
                    this.eUa.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) beS) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.eUj.beR())));
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
        this.cdL = i;
        am.g(this.eUc, R.drawable.bg_expression_bubble, i);
        am.h(this, R.color.cp_bg_line_d, i);
        this.cdR.setSelector(am.V(i, R.drawable.dot_pb_expression_s));
        this.cdR.setDrawable(am.V(i, R.drawable.dot_pb_expression_n));
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
        KV();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b eUt;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eUt = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eUt = bVar;
        }

        public int beK() {
            if (this.eUt == null) {
                return 0;
            }
            return this.eUt.beU();
        }

        public com.baidu.tieba.emotion.editortool.b beL() {
            return this.eUt;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eUt == null) {
                return 0;
            }
            return this.eUt.beT();
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
                if (this.eUt.beQ() != 0) {
                    i2 = measuredWidth / this.eUt.beQ();
                }
                if (this.eUt.atd() != 0) {
                    i3 = measuredHeight / this.eUt.atd();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.eUg * 2, EmotionTabContentView.this.eUg * 2, EmotionTabContentView.this.eUg * 2, EmotionTabContentView.this.eUg * 2);
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
            if (this.eUt != null) {
                int beU = this.eUt.beU() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.g(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.cdL);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ks = this.eUt.beO().ks(beU);
                tbImageView.setTag(ks);
                if (!TextUtils.isEmpty(ks)) {
                    Object a = com.baidu.adp.lib.f.c.iE().a(ks, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, ks, false, null);
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
                if (this.eUt.beP() == EmotionGroupType.BIG_EMOTION) {
                    String ks2 = this.eUt.beO().ks(beU);
                    if (!TextUtils.isEmpty(ks2) && !ks2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.cdL == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ks2.substring(ks2.lastIndexOf("_") + 1, ks2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ks != null && ks.length() > 3) {
                    linearLayout3.setContentDescription(ks.substring(2, ks.length() - 1));
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
            if (EmotionTabContentView.this.eUl == null) {
                return 0;
            }
            return EmotionTabContentView.this.eUl.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eUr.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eUr.iD();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.eUl != null && i < EmotionTabContentView.this.eUl.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUl.get(i);
                gridView2.setNumColumns(bVar.beQ());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.beL() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b beL = aVar.beL();
                        if (beL.beP() == EmotionGroupType.BIG_EMOTION || beL.beP() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.TU != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.beL() != null) {
                                com.baidu.tieba.emotion.editortool.b beL = aVar.beL();
                                int beK = aVar.beK();
                                com.baidu.tbadk.editortools.emotiontool.c beO = beL.beO();
                                String ks = beL.beO().ks(beK + i2);
                                if (beO.aso() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cwf.equals(ks)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(ks);
                                pVar.a(beO.aso());
                                pVar.pe(beO.getGroupName());
                                pVar.setPid(beO.getGroupId());
                                pVar.setWidth(beO.getWidth());
                                pVar.setHeight(beO.getHeight());
                                EmotionTabContentView.this.TU.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.eUl != null) {
                int size = EmotionTabContentView.this.eUl.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Sw) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUl.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Sw = i;
                        EmotionTabContentView.this.cdR.setVisibility(bVar.beR() > 1 ? 0 : 4);
                        EmotionTabContentView.this.cdR.setCount(bVar.beR());
                        EmotionTabContentView.this.cdR.setPosition(bVar.beS());
                        EmotionTabContentView.this.cdR.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.beS() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.beR())));
                    }
                    if (bVar != null && bVar.beV() != EmotionTabContentView.this.eUn) {
                        EmotionTabContentView.this.eUn = bVar.beV();
                        if (EmotionTabContentView.this.eUo != null) {
                            EmotionTabContentView.this.eUo.qm(bVar.beV());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.eUo = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bDy);
    }
}
