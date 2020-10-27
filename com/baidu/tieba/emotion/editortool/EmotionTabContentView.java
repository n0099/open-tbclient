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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int ZQ;
    private EditorTools abk;
    private int ajq;
    private final Rect bxA;
    private IndicatorView eVb;
    private CustomMessageListener erp;
    private GifView iaA;
    private ViewGroup iaB;
    private int iaC;
    private int iaD;
    private int iaE;
    private boolean iaF;
    private int iaG;
    private com.baidu.tieba.emotion.editortool.b iaH;
    private List<com.baidu.tbadk.editortools.emotiontool.c> iaI;
    private List<com.baidu.tieba.emotion.editortool.b> iaJ;
    private int iaK;
    private int iaL;
    private b iaM;
    private int iaN;
    private final Point iaO;
    private com.baidu.adp.lib.d.b<GridView> iaP;
    private EmotionViewPagerAdapter iaw;
    private GridView iax;
    private LinearLayout iay;
    private WindowManager.LayoutParams iaz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes13.dex */
    public interface b {
        void xj(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxA = new Rect();
        this.iaG = -1;
        this.iaK = 0;
        this.iaL = -1;
        this.ZQ = -1;
        this.iaO = new Point();
        this.erp = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cz(new ArrayList(EmotionTabContentView.this.iaI));
                        if (EmotionTabContentView.this.iaw != null) {
                            EmotionTabContentView.this.iaw.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iaL < 0 || EmotionTabContentView.this.iaL >= EmotionTabContentView.this.iaI.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iaI.get(EmotionTabContentView.this.iaL)).bxs() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iaw != null) {
                                if (EmotionTabContentView.this.ZQ >= 0 && EmotionTabContentView.this.ZQ < EmotionTabContentView.this.iaJ.size()) {
                                    EmotionTabContentView.this.iaH = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iaJ.get(EmotionTabContentView.this.ZQ);
                                    int cob = EmotionTabContentView.this.iaH.cob();
                                    EmotionTabContentView.this.eVb.setCount(cob);
                                    EmotionTabContentView.this.eVb.setVisibility(cob > 1 ? 0 : 4);
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
                                                    int index = aVar.cnV().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iaJ.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iaJ.get(index));
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
        this.bxA = new Rect();
        this.iaG = -1;
        this.iaK = 0;
        this.iaL = -1;
        this.ZQ = -1;
        this.iaO = new Point();
        this.erp = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cz(new ArrayList(EmotionTabContentView.this.iaI));
                        if (EmotionTabContentView.this.iaw != null) {
                            EmotionTabContentView.this.iaw.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iaL < 0 || EmotionTabContentView.this.iaL >= EmotionTabContentView.this.iaI.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iaI.get(EmotionTabContentView.this.iaL)).bxs() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iaw != null) {
                                if (EmotionTabContentView.this.ZQ >= 0 && EmotionTabContentView.this.ZQ < EmotionTabContentView.this.iaJ.size()) {
                                    EmotionTabContentView.this.iaH = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iaJ.get(EmotionTabContentView.this.ZQ);
                                    int cob = EmotionTabContentView.this.iaH.cob();
                                    EmotionTabContentView.this.eVb.setCount(cob);
                                    EmotionTabContentView.this.eVb.setVisibility(cob > 1 ? 0 : 4);
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
                                                    int index = aVar.cnV().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iaJ.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iaJ.get(index));
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
        this.iaI = new ArrayList();
        this.iaJ = new ArrayList();
        this.iaP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnT */
            public GridView makeObject() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public GridView activateObject(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
        this.iaA = new GifView(context);
        ap.setBackgroundResource(this.iaA, R.drawable.bg_expression_bubble, this.ajq);
        this.iaA.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.iaz = new WindowManager.LayoutParams();
        this.iaC = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iaD = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.iaE = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.iaz.width = this.iaC;
        this.iaz.height = this.iaD;
        this.iaz.gravity = 51;
        this.iaz.format = -3;
        this.iaz.type = 1000;
        this.iaz.flags |= 56;
        this.iaB = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eVb = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.iay = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.iay.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.iaz.type = 1000;
            this.iaz.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.iaI.clear();
        this.iaJ.clear();
        if (list != null && !list.isEmpty()) {
            this.iaI.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bxv = cVar.bxv();
                    int bxw = cVar.bxw();
                    int i4 = emotionsCount / (bxv * bxw);
                    if (emotionsCount % (bxv * bxw) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bxv * bxw;
                        } else {
                            i = emotionsCount - ((bxv * bxw) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.xp(i3);
                        bVar.b(cVar.bxs());
                        bVar.rn(bxw);
                        bVar.setColumn(bxv);
                        bVar.xk(i4);
                        bVar.xl(i5);
                        bVar.xm(i);
                        bVar.xn(i5 * bxv * bxw);
                        bVar.xo((i + i2) - 1);
                        this.iaJ.add(bVar);
                    }
                }
            }
            this.iaK = this.iaJ.size();
            for (int i6 = 0; i6 < this.iaK; i6++) {
                if (this.iaJ != null && this.iaJ.get(i6) != null) {
                    this.iaJ.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void xh(int i) {
        if (this.iaJ != null) {
            int size = this.iaJ.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.iaJ.get(i2);
                    if (bVar != null && bVar.cof() == i) {
                        this.iaN = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void g(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                cz(list);
                xh(i);
                this.iaw = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.iaw);
                this.mViewPager.setCurrentItem(this.iaN, true);
                if (this.iaM != null) {
                    this.iaM.xj(i);
                    this.iaL = i;
                }
            }
        }
    }

    public void xi(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.iaJ.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.iaJ.get(i3);
                        if (bVar == null || bVar.cof() != i) {
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
        if (this.iaG != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cnV() != null) {
            com.baidu.tieba.emotion.editortool.b cnV = aVar.cnV();
            String rd = cnV.cnY().rd(aVar.cnU() + i);
            if (cnV.cnZ() != EmotionGroupType.USER_COLLECT || !rd.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.iaA.setTag(rd);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = rd;
                if (rd.startsWith("#(meme,")) {
                    this.iaA.setShowStaticDrawable(false);
                } else {
                    this.iaA.setShowStaticDrawable(true);
                }
                this.iaA.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bxA);
                this.iaB.offsetDescendantRectToMyCoords(linearLayout, this.bxA);
                this.iaz.x = this.bxA.left - ((this.iaz.width - linearLayout.getWidth()) / 2);
                this.iaz.y = (this.bxA.top - this.iaz.height) + this.iaE;
                this.iaA.setVisibility(0);
                if (!this.iaF) {
                    this.mWindowManager.addView(this.iaA, this.iaz);
                    this.iaF = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.iaA, this.iaz);
                }
                gridView.setSelection(i);
                if (this.iaG != -1) {
                    ((LinearLayout) gridView.getChildAt(this.iaG - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.iaG = i;
                this.iax = gridView;
            }
        }
    }

    private void onUp() {
        if (this.iaF && this.iaA.getVisibility() != 8 && this.iax != null) {
            this.iax.setSelection(-1);
            this.iaA.setVisibility(8);
            if (this.iaG != -1) {
                ((LinearLayout) this.iax.getChildAt(this.iaG - this.iax.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.iaG = -1;
            this.iax = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.iaO.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.iaO.set(x, y);
                if (this.iaF && this.iaA.getVisibility() != 8 && this.iax != null) {
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
                this.iaO.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.bxA);
                if (!this.bxA.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.bxA.set(x, y, x + 1, y + 1);
                    if (this.iax != null) {
                        offsetRectIntoDescendantCoords(this.iax, this.bxA);
                        int pointToPosition = this.iax.pointToPosition(this.bxA.left, this.bxA.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.iax);
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
        if (this.iaF) {
            this.mWindowManager.removeView(this.iaA);
            this.iaF = false;
        }
        MessageManager.getInstance().unRegisterListener(this.erp);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.iaJ != null) {
            int size = this.iaJ.size();
            if (i >= 0 && i < size) {
                this.iaH = this.iaJ.get(i);
                if (this.eVb != null && this.iaH != null) {
                    if (this.ZQ != i) {
                        this.ZQ = i;
                        this.eVb.setVisibility(this.iaH.cob() > 1 ? 0 : 4);
                        this.eVb.setCount(this.iaH.cob());
                        if (this.iaH != null && this.iaH.cof() != this.iaL) {
                            this.iaL = this.iaH.cof();
                            if (this.iaM != null) {
                                this.iaM.xj(this.iaH.cof());
                            }
                        }
                    }
                    float coc = this.iaH.coc() + f;
                    this.eVb.setPosition(coc);
                    this.iay.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) coc) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.iaH.cob())));
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
        this.ajq = i;
        ap.setBackgroundResource(this.iaA, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.eVb.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eVb.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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

    /* loaded from: classes13.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b iaR;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iaR = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iaR = bVar;
        }

        public int cnU() {
            if (this.iaR == null) {
                return 0;
            }
            return this.iaR.coe();
        }

        public com.baidu.tieba.emotion.editortool.b cnV() {
            return this.iaR;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.iaR == null) {
                return 0;
            }
            return this.iaR.cod();
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
                if (this.iaR.coa() != 0) {
                    i2 = measuredWidth / this.iaR.coa();
                }
                if (this.iaR.getRow() != 0) {
                    i3 = measuredHeight / this.iaR.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.iaE * 2, EmotionTabContentView.this.iaE * 2, EmotionTabContentView.this.iaE * 2, EmotionTabContentView.this.iaE * 2);
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
            if (this.iaR != null) {
                int coe = this.iaR.coe() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ajq);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String rd = this.iaR.cnY().rd(coe);
                tbImageView.setTag(rd);
                if (!TextUtils.isEmpty(rd)) {
                    Object a2 = com.baidu.adp.lib.e.c.mS().a(rd, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.drawImageTo(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, rd, false, null);
                    if (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.ImageView.a) a2;
                    }
                    if (aVar != null) {
                        aVar.drawImageTo(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
                if (this.iaR.cnZ() == EmotionGroupType.BIG_EMOTION) {
                    String rd2 = this.iaR.cnY().rd(coe);
                    if (!TextUtils.isEmpty(rd2) && !rd2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ajq == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = ap.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(rd2.substring(rd2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, rd2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (rd != null && rd.length() > 3) {
                    linearLayout3.setContentDescription(rd.substring(2, rd.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes13.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.iaJ == null) {
                return 0;
            }
            return EmotionTabContentView.this.iaJ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.iaP.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.iaP.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.iaJ != null && i < EmotionTabContentView.this.iaJ.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iaJ.get(i);
                gridView2.setNumColumns(bVar.coa());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cnV() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cnV = aVar.cnV();
                        if (cnV.cnZ() == EmotionGroupType.BIG_EMOTION || cnV.cnZ() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.abk != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cnV() != null) {
                                com.baidu.tieba.emotion.editortool.b cnV = aVar.cnV();
                                int cnU = aVar.cnU();
                                com.baidu.tbadk.editortools.emotiontool.c cnY = cnV.cnY();
                                String rd = cnV.cnY().rd(cnU + i2);
                                if (cnY.bxs() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(rd)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(rd);
                                uVar.a(cnY.bxs());
                                uVar.Cw(cnY.getGroupName());
                                uVar.setPid(cnY.getGroupId());
                                uVar.setWidth(cnY.getWidth());
                                uVar.setHeight(cnY.getHeight());
                                EmotionTabContentView.this.abk.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.iaJ != null) {
                int size = EmotionTabContentView.this.iaJ.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.ZQ) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iaJ.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.ZQ = i;
                        EmotionTabContentView.this.eVb.setVisibility(bVar.cob() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eVb.setCount(bVar.cob());
                        EmotionTabContentView.this.eVb.setPosition(bVar.coc());
                        EmotionTabContentView.this.eVb.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.coc() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cob())));
                    }
                    if (bVar != null && bVar.cof() != EmotionTabContentView.this.iaL) {
                        EmotionTabContentView.this.iaL = bVar.cof();
                        if (EmotionTabContentView.this.iaM != null) {
                            EmotionTabContentView.this.iaM.xj(bVar.cof());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.iaM = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.erp);
    }
}
