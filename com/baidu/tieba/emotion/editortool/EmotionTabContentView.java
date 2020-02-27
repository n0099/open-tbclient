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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Ev;
    private EditorTools FO;
    private int Ni;
    private CustomMessageListener cLF;
    private IndicatorView dks;
    private EmotionViewPagerAdapter fRS;
    private GridView fRT;
    private LinearLayout fRU;
    private WindowManager.LayoutParams fRV;
    private GifView fRW;
    private ViewGroup fRX;
    private int fRY;
    private int fRZ;
    private int fSa;
    private boolean fSb;
    private int fSc;
    private com.baidu.tieba.emotion.editortool.b fSd;
    private List<com.baidu.tbadk.editortools.emotiontool.c> fSe;
    private List<com.baidu.tieba.emotion.editortool.b> fSf;
    private int fSg;
    private int fSh;
    private b fSi;
    private int fSj;
    private final Point fSk;
    private com.baidu.adp.lib.d.b<GridView> fSl;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void rD(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.fSc = -1;
        this.fSg = 0;
        this.fSh = -1;
        this.Ev = -1;
        this.fSk = new Point();
        this.cLF = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fSe));
                        if (EmotionTabContentView.this.fRS != null) {
                            EmotionTabContentView.this.fRS.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fSh < 0 || EmotionTabContentView.this.fSh >= EmotionTabContentView.this.fSe.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fSe.get(EmotionTabContentView.this.fSh)).aOG() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fRS != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fSf.size()) {
                                    EmotionTabContentView.this.fSd = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSf.get(EmotionTabContentView.this.Ev);
                                    int bxr = EmotionTabContentView.this.fSd.bxr();
                                    EmotionTabContentView.this.dks.setCount(bxr);
                                    EmotionTabContentView.this.dks.setVisibility(bxr > 1 ? 0 : 4);
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
                                                    int index = aVar.bxl().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fSf.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSf.get(index));
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
        this.fSc = -1;
        this.fSg = 0;
        this.fSh = -1;
        this.Ev = -1;
        this.fSk = new Point();
        this.cLF = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fSe));
                        if (EmotionTabContentView.this.fRS != null) {
                            EmotionTabContentView.this.fRS.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fSh < 0 || EmotionTabContentView.this.fSh >= EmotionTabContentView.this.fSe.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fSe.get(EmotionTabContentView.this.fSh)).aOG() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fRS != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fSf.size()) {
                                    EmotionTabContentView.this.fSd = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSf.get(EmotionTabContentView.this.Ev);
                                    int bxr = EmotionTabContentView.this.fSd.bxr();
                                    EmotionTabContentView.this.dks.setCount(bxr);
                                    EmotionTabContentView.this.dks.setVisibility(bxr > 1 ? 0 : 4);
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
                                                    int index = aVar.bxl().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fSf.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSf.get(index));
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
        this.fSe = new ArrayList();
        this.fSf = new ArrayList();
        this.fSl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bxj */
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
        this.fRW = new GifView(context);
        am.setBackgroundResource(this.fRW, R.drawable.bg_expression_bubble, this.Ni);
        this.fRW.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.fRV = new WindowManager.LayoutParams();
        this.fRY = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.fRZ = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.fSa = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fRV.width = this.fRY;
        this.fRV.height = this.fRZ;
        this.fRV.gravity = 51;
        this.fRV.format = -3;
        this.fRV.type = 1000;
        this.fRV.flags |= 56;
        this.fRX = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dks = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.fRU = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.fRU.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.fRV.type = 1000;
            this.fRV.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.fSe.clear();
        this.fSf.clear();
        if (list != null && !list.isEmpty()) {
            this.fSe.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aOJ = cVar.aOJ();
                    int aOK = cVar.aOK();
                    int i4 = emotionsCount / (aOJ * aOK);
                    if (emotionsCount % (aOJ * aOK) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aOJ * aOK;
                        } else {
                            i = emotionsCount - ((aOJ * aOK) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.rJ(i3);
                        bVar.b(cVar.aOG());
                        bVar.mz(aOK);
                        bVar.my(aOJ);
                        bVar.rE(i4);
                        bVar.rF(i5);
                        bVar.rG(i);
                        bVar.rH(i5 * aOJ * aOK);
                        bVar.rI((i + i2) - 1);
                        this.fSf.add(bVar);
                    }
                }
            }
            this.fSg = this.fSf.size();
            for (int i6 = 0; i6 < this.fSg; i6++) {
                if (this.fSf != null && this.fSf.get(i6) != null) {
                    this.fSf.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rB(int i) {
        if (this.fSf != null) {
            int size = this.fSf.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.fSf.get(i2);
                    if (bVar != null && bVar.bxv() == i) {
                        this.fSj = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void f(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                bJ(list);
                rB(i);
                this.fRS = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.fRS);
                this.mViewPager.setCurrentItem(this.fSj, true);
                if (this.fSi != null) {
                    this.fSi.rD(i);
                    this.fSh = i;
                }
            }
        }
    }

    public void rC(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.fSf.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.fSf.get(i3);
                        if (bVar == null || bVar.bxv() != i) {
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
        if (this.fSc != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bxl() != null) {
            com.baidu.tieba.emotion.editortool.b bxl = aVar.bxl();
            String ms = bxl.bxo().ms(aVar.bxk() + i);
            if (bxl.bxp() != EmotionGroupType.USER_COLLECT || !ms.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.fRW.setTag(ms);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ms;
                if (ms.startsWith("#(meme,")) {
                    this.fRW.setShowStaticDrawable(false);
                } else {
                    this.fRW.setShowStaticDrawable(true);
                }
                this.fRW.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.fRX.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.fRV.x = this.rect.left - ((this.fRV.width - linearLayout.getWidth()) / 2);
                this.fRV.y = (this.rect.top - this.fRV.height) + this.fSa;
                this.fRW.setVisibility(0);
                if (!this.fSb) {
                    this.mWindowManager.addView(this.fRW, this.fRV);
                    this.fSb = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.fRW, this.fRV);
                }
                gridView.setSelection(i);
                if (this.fSc != -1) {
                    ((LinearLayout) gridView.getChildAt(this.fSc - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.fSc = i;
                this.fRT = gridView;
            }
        }
    }

    private void onUp() {
        if (this.fSb && this.fRW.getVisibility() != 8 && this.fRT != null) {
            this.fRT.setSelection(-1);
            this.fRW.setVisibility(8);
            if (this.fSc != -1) {
                ((LinearLayout) this.fRT.getChildAt(this.fSc - this.fRT.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.fSc = -1;
            this.fRT = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.fSk.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.fSk.set(x, y);
                if (this.fSb && this.fRW.getVisibility() != 8 && this.fRT != null) {
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
                this.fSk.set(x, y);
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
                    if (this.fRT != null) {
                        offsetRectIntoDescendantCoords(this.fRT, this.rect);
                        int pointToPosition = this.fRT.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.fRT);
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
        if (this.fSb) {
            this.mWindowManager.removeView(this.fRW);
            this.fSb = false;
        }
        MessageManager.getInstance().unRegisterListener(this.cLF);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fSf != null) {
            int size = this.fSf.size();
            if (i >= 0 && i < size) {
                this.fSd = this.fSf.get(i);
                if (this.dks != null && this.fSd != null) {
                    if (this.Ev != i) {
                        this.Ev = i;
                        this.dks.setVisibility(this.fSd.bxr() > 1 ? 0 : 4);
                        this.dks.setCount(this.fSd.bxr());
                        if (this.fSd != null && this.fSd.bxv() != this.fSh) {
                            this.fSh = this.fSd.bxv();
                            if (this.fSi != null) {
                                this.fSi.rD(this.fSd.bxv());
                            }
                        }
                    }
                    float bxs = this.fSd.bxs() + f;
                    this.dks.setPosition(bxs);
                    this.fRU.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bxs) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.fSd.bxr())));
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
        this.Ni = i;
        am.setBackgroundResource(this.fRW, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dks.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dks.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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

    /* loaded from: classes6.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b fSn;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fSn = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fSn = bVar;
        }

        public int bxk() {
            if (this.fSn == null) {
                return 0;
            }
            return this.fSn.bxu();
        }

        public com.baidu.tieba.emotion.editortool.b bxl() {
            return this.fSn;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fSn == null) {
                return 0;
            }
            return this.fSn.bxt();
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
                if (this.fSn.bxq() != 0) {
                    i2 = measuredWidth / this.fSn.bxq();
                }
                if (this.fSn.getRow() != 0) {
                    i3 = measuredHeight / this.fSn.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.fSa * 2, EmotionTabContentView.this.fSa * 2, EmotionTabContentView.this.fSa * 2, EmotionTabContentView.this.fSa * 2);
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
            if (this.fSn != null) {
                int bxu = this.fSn.bxu() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.Ni);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ms = this.fSn.bxo().ms(bxu);
                tbImageView.setTag(ms);
                if (!TextUtils.isEmpty(ms)) {
                    Object a = com.baidu.adp.lib.e.c.gr().a(ms, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, ms, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.ImageView.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.ImageView.a) a;
                    }
                    if (aVar != null) {
                        aVar.drawImageTo(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
                if (this.fSn.bxp() == EmotionGroupType.BIG_EMOTION) {
                    String ms2 = this.fSn.bxo().ms(bxu);
                    if (!TextUtils.isEmpty(ms2) && !ms2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.Ni == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ms2.substring(ms2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, ms2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ms != null && ms.length() > 3) {
                    linearLayout3.setContentDescription(ms.substring(2, ms.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes6.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.fSf == null) {
                return 0;
            }
            return EmotionTabContentView.this.fSf.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.fSl.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.fSl.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.fSf != null && i < EmotionTabContentView.this.fSf.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSf.get(i);
                gridView2.setNumColumns(bVar.bxq());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bxl() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bxl = aVar.bxl();
                        if (bxl.bxp() == EmotionGroupType.BIG_EMOTION || bxl.bxp() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.FO != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bxl() != null) {
                                com.baidu.tieba.emotion.editortool.b bxl = aVar.bxl();
                                int bxk = aVar.bxk();
                                com.baidu.tbadk.editortools.emotiontool.c bxo = bxl.bxo();
                                String ms = bxl.bxo().ms(bxk + i2);
                                if (bxo.aOG() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(ms)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(ms);
                                qVar.a(bxo.aOG());
                                qVar.ui(bxo.getGroupName());
                                qVar.setPid(bxo.getGroupId());
                                qVar.setWidth(bxo.getWidth());
                                qVar.setHeight(bxo.getHeight());
                                EmotionTabContentView.this.FO.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.fSf != null) {
                int size = EmotionTabContentView.this.fSf.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ev) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSf.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ev = i;
                        EmotionTabContentView.this.dks.setVisibility(bVar.bxr() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dks.setCount(bVar.bxr());
                        EmotionTabContentView.this.dks.setPosition(bVar.bxs());
                        EmotionTabContentView.this.dks.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bxs() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bxr())));
                    }
                    if (bVar != null && bVar.bxv() != EmotionTabContentView.this.fSh) {
                        EmotionTabContentView.this.fSh = bVar.bxv();
                        if (EmotionTabContentView.this.fSi != null) {
                            EmotionTabContentView.this.fSi.rD(bVar.bxv());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.fSi = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLF);
    }
}
