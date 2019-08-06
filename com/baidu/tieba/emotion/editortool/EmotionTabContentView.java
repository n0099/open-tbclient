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
    private int cdS;
    private IndicatorView cdY;
    private final Rect cxj;
    private EmotionViewPagerAdapter eUf;
    private GridView eUg;
    private LinearLayout eUh;
    private WindowManager.LayoutParams eUi;
    private GifView eUj;
    private ViewGroup eUk;
    private int eUl;
    private int eUm;
    private int eUn;
    private boolean eUo;
    private int eUp;
    private com.baidu.tieba.emotion.editortool.b eUq;
    private List<com.baidu.tbadk.editortools.emotiontool.c> eUr;
    private List<com.baidu.tieba.emotion.editortool.b> eUs;
    private int eUt;
    private int eUu;
    private b eUv;
    private int eUw;
    private final Point eUx;
    private com.baidu.adp.lib.e.b<GridView> eUy;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes2.dex */
    public interface b {
        void qn(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxj = new Rect();
        this.eUp = -1;
        this.eUt = 0;
        this.eUu = -1;
        this.Sw = -1;
        this.eUx = new Point();
        this.bDy = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bA(new ArrayList(EmotionTabContentView.this.eUr));
                        if (EmotionTabContentView.this.eUf != null) {
                            EmotionTabContentView.this.eUf.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eUu < 0 || EmotionTabContentView.this.eUu >= EmotionTabContentView.this.eUr.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eUr.get(EmotionTabContentView.this.eUu)).asq() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eUf != null) {
                                if (EmotionTabContentView.this.Sw >= 0 && EmotionTabContentView.this.Sw < EmotionTabContentView.this.eUs.size()) {
                                    EmotionTabContentView.this.eUq = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUs.get(EmotionTabContentView.this.Sw);
                                    int beT = EmotionTabContentView.this.eUq.beT();
                                    EmotionTabContentView.this.cdY.setCount(beT);
                                    EmotionTabContentView.this.cdY.setVisibility(beT > 1 ? 0 : 4);
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
                                                    int index = aVar.beN().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eUs.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUs.get(index));
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
        this.cxj = new Rect();
        this.eUp = -1;
        this.eUt = 0;
        this.eUu = -1;
        this.Sw = -1;
        this.eUx = new Point();
        this.bDy = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bA(new ArrayList(EmotionTabContentView.this.eUr));
                        if (EmotionTabContentView.this.eUf != null) {
                            EmotionTabContentView.this.eUf.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eUu < 0 || EmotionTabContentView.this.eUu >= EmotionTabContentView.this.eUr.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eUr.get(EmotionTabContentView.this.eUu)).asq() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eUf != null) {
                                if (EmotionTabContentView.this.Sw >= 0 && EmotionTabContentView.this.Sw < EmotionTabContentView.this.eUs.size()) {
                                    EmotionTabContentView.this.eUq = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUs.get(EmotionTabContentView.this.Sw);
                                    int beT = EmotionTabContentView.this.eUq.beT();
                                    EmotionTabContentView.this.cdY.setCount(beT);
                                    EmotionTabContentView.this.cdY.setVisibility(beT > 1 ? 0 : 4);
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
                                                    int index = aVar.beN().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eUs.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUs.get(index));
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
        this.eUr = new ArrayList();
        this.eUs = new ArrayList();
        this.eUy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beL */
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
        this.eUj = new GifView(context);
        am.g(this.eUj, R.drawable.bg_expression_bubble, this.cdS);
        this.eUj.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.eUi = new WindowManager.LayoutParams();
        this.eUl = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.eUm = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.eUn = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eUi.width = this.eUl;
        this.eUi.height = this.eUm;
        this.eUi.gravity = 51;
        this.eUi.format = -3;
        this.eUi.type = 1000;
        this.eUi.flags |= 56;
        this.eUk = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.cdY = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.eUh = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.eUh.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.eUi.type = 1000;
            this.eUi.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.eUr.clear();
        this.eUs.clear();
        if (list != null && !list.isEmpty()) {
            this.eUr.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int ast = cVar.ast();
                    int asu = cVar.asu();
                    int i4 = emotionsCount / (ast * asu);
                    if (emotionsCount % (ast * asu) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = ast * asu;
                        } else {
                            i = emotionsCount - ((ast * asu) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.qt(i3);
                        bVar.b(cVar.asq());
                        bVar.kA(asu);
                        bVar.kz(ast);
                        bVar.qo(i4);
                        bVar.qp(i5);
                        bVar.qq(i);
                        bVar.qr(i5 * ast * asu);
                        bVar.qs((i + i2) - 1);
                        this.eUs.add(bVar);
                    }
                }
            }
            this.eUt = this.eUs.size();
            for (int i6 = 0; i6 < this.eUt; i6++) {
                if (this.eUs != null && this.eUs.get(i6) != null) {
                    this.eUs.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void ql(int i) {
        if (this.eUs != null) {
            int size = this.eUs.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.eUs.get(i2);
                    if (bVar != null && bVar.beX() == i) {
                        this.eUw = bVar.getIndex();
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
                ql(i);
                this.eUf = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eUf);
                this.mViewPager.setCurrentItem(this.eUw, true);
                if (this.eUv != null) {
                    this.eUv.qn(i);
                    this.eUu = i;
                }
            }
        }
    }

    public void qm(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.eUs.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.eUs.get(i3);
                        if (bVar == null || bVar.beX() != i) {
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
        if (this.eUp != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.beN() != null) {
            com.baidu.tieba.emotion.editortool.b beN = aVar.beN();
            String kt = beN.beQ().kt(aVar.beM() + i);
            if (beN.beR() != EmotionGroupType.USER_COLLECT || !kt.equals(com.baidu.tbadk.imageManager.d.cwm)) {
                this.eUj.setTag(kt);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = kt;
                if (kt.startsWith("#(meme,")) {
                    this.eUj.setShowStaticDrawable(false);
                } else {
                    this.eUj.setShowStaticDrawable(true);
                }
                this.eUj.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.cxj);
                this.eUk.offsetDescendantRectToMyCoords(linearLayout, this.cxj);
                this.eUi.x = this.cxj.left - ((this.eUi.width - linearLayout.getWidth()) / 2);
                this.eUi.y = (this.cxj.top - this.eUi.height) + this.eUn;
                this.eUj.setVisibility(0);
                if (!this.eUo) {
                    this.mWindowManager.addView(this.eUj, this.eUi);
                    this.eUo = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.eUj, this.eUi);
                }
                gridView.setSelection(i);
                if (this.eUp != -1) {
                    ((LinearLayout) gridView.getChildAt(this.eUp - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.eUp = i;
                this.eUg = gridView;
            }
        }
    }

    private void KV() {
        if (this.eUo && this.eUj.getVisibility() != 8 && this.eUg != null) {
            this.eUg.setSelection(-1);
            this.eUj.setVisibility(8);
            if (this.eUp != -1) {
                ((LinearLayout) this.eUg.getChildAt(this.eUp - this.eUg.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.eUp = -1;
            this.eUg = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eUx.set(x, y);
                break;
            case 1:
            case 3:
                KV();
                break;
            case 2:
                this.eUx.set(x, y);
                if (this.eUo && this.eUj.getVisibility() != 8 && this.eUg != null) {
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
                this.eUx.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                KV();
                break;
            case 2:
                getFocusedRect(this.cxj);
                if (!this.cxj.contains(x, y)) {
                    KV();
                    break;
                } else {
                    this.cxj.set(x, y, x + 1, y + 1);
                    if (this.eUg != null) {
                        offsetRectIntoDescendantCoords(this.eUg, this.cxj);
                        int pointToPosition = this.eUg.pointToPosition(this.cxj.left, this.cxj.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eUg);
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
        if (this.eUo) {
            this.mWindowManager.removeView(this.eUj);
            this.eUo = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bDy);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.eUs != null) {
            int size = this.eUs.size();
            if (i >= 0 && i < size) {
                this.eUq = this.eUs.get(i);
                if (this.cdY != null && this.eUq != null) {
                    if (this.Sw != i) {
                        this.Sw = i;
                        this.cdY.setVisibility(this.eUq.beT() > 1 ? 0 : 4);
                        this.cdY.setCount(this.eUq.beT());
                        if (this.eUq != null && this.eUq.beX() != this.eUu) {
                            this.eUu = this.eUq.beX();
                            if (this.eUv != null) {
                                this.eUv.qn(this.eUq.beX());
                            }
                        }
                    }
                    float beU = this.eUq.beU() + f;
                    this.cdY.setPosition(beU);
                    this.eUh.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) beU) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.eUq.beT())));
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
        this.cdS = i;
        am.g(this.eUj, R.drawable.bg_expression_bubble, i);
        am.h(this, R.color.cp_bg_line_d, i);
        this.cdY.setSelector(am.V(i, R.drawable.dot_pb_expression_s));
        this.cdY.setDrawable(am.V(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b eUA;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eUA = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eUA = bVar;
        }

        public int beM() {
            if (this.eUA == null) {
                return 0;
            }
            return this.eUA.beW();
        }

        public com.baidu.tieba.emotion.editortool.b beN() {
            return this.eUA;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eUA == null) {
                return 0;
            }
            return this.eUA.beV();
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
                if (this.eUA.beS() != 0) {
                    i2 = measuredWidth / this.eUA.beS();
                }
                if (this.eUA.atf() != 0) {
                    i3 = measuredHeight / this.eUA.atf();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.eUn * 2, EmotionTabContentView.this.eUn * 2, EmotionTabContentView.this.eUn * 2, EmotionTabContentView.this.eUn * 2);
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
            if (this.eUA != null) {
                int beW = this.eUA.beW() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.g(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.cdS);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String kt = this.eUA.beQ().kt(beW);
                tbImageView.setTag(kt);
                if (!TextUtils.isEmpty(kt)) {
                    Object a = com.baidu.adp.lib.f.c.iE().a(kt, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, kt, false, null);
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
                if (this.eUA.beR() == EmotionGroupType.BIG_EMOTION) {
                    String kt2 = this.eUA.beQ().kt(beW);
                    if (!TextUtils.isEmpty(kt2) && !kt2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.cdS == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(kt2.substring(kt2.lastIndexOf("_") + 1, kt2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (kt != null && kt.length() > 3) {
                    linearLayout3.setContentDescription(kt.substring(2, kt.length() - 1));
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
            if (EmotionTabContentView.this.eUs == null) {
                return 0;
            }
            return EmotionTabContentView.this.eUs.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eUy.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eUy.iD();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.eUs != null && i < EmotionTabContentView.this.eUs.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUs.get(i);
                gridView2.setNumColumns(bVar.beS());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.beN() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b beN = aVar.beN();
                        if (beN.beR() == EmotionGroupType.BIG_EMOTION || beN.beR() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.beN() != null) {
                                com.baidu.tieba.emotion.editortool.b beN = aVar.beN();
                                int beM = aVar.beM();
                                com.baidu.tbadk.editortools.emotiontool.c beQ = beN.beQ();
                                String kt = beN.beQ().kt(beM + i2);
                                if (beQ.asq() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.cwm.equals(kt)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(kt);
                                pVar.a(beQ.asq());
                                pVar.pe(beQ.getGroupName());
                                pVar.setPid(beQ.getGroupId());
                                pVar.setWidth(beQ.getWidth());
                                pVar.setHeight(beQ.getHeight());
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
            if (EmotionTabContentView.this.eUs != null) {
                int size = EmotionTabContentView.this.eUs.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Sw) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eUs.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Sw = i;
                        EmotionTabContentView.this.cdY.setVisibility(bVar.beT() > 1 ? 0 : 4);
                        EmotionTabContentView.this.cdY.setCount(bVar.beT());
                        EmotionTabContentView.this.cdY.setPosition(bVar.beU());
                        EmotionTabContentView.this.cdY.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.beU() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.beT())));
                    }
                    if (bVar != null && bVar.beX() != EmotionTabContentView.this.eUu) {
                        EmotionTabContentView.this.eUu = bVar.beX();
                        if (EmotionTabContentView.this.eUv != null) {
                            EmotionTabContentView.this.eUv.qn(bVar.beX());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.eUv = bVar;
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
