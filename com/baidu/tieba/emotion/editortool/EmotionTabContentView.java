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
    private CustomMessageListener cLG;
    private IndicatorView dkt;
    private EmotionViewPagerAdapter fRU;
    private GridView fRV;
    private LinearLayout fRW;
    private WindowManager.LayoutParams fRX;
    private GifView fRY;
    private ViewGroup fRZ;
    private int fSa;
    private int fSb;
    private int fSc;
    private boolean fSd;
    private int fSe;
    private com.baidu.tieba.emotion.editortool.b fSf;
    private List<com.baidu.tbadk.editortools.emotiontool.c> fSg;
    private List<com.baidu.tieba.emotion.editortool.b> fSh;
    private int fSi;
    private int fSj;
    private b fSk;
    private int fSl;
    private final Point fSm;
    private com.baidu.adp.lib.d.b<GridView> fSn;
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
        this.fSe = -1;
        this.fSi = 0;
        this.fSj = -1;
        this.Ev = -1;
        this.fSm = new Point();
        this.cLG = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fSg));
                        if (EmotionTabContentView.this.fRU != null) {
                            EmotionTabContentView.this.fRU.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fSj < 0 || EmotionTabContentView.this.fSj >= EmotionTabContentView.this.fSg.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fSg.get(EmotionTabContentView.this.fSj)).aOI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fRU != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fSh.size()) {
                                    EmotionTabContentView.this.fSf = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSh.get(EmotionTabContentView.this.Ev);
                                    int bxt = EmotionTabContentView.this.fSf.bxt();
                                    EmotionTabContentView.this.dkt.setCount(bxt);
                                    EmotionTabContentView.this.dkt.setVisibility(bxt > 1 ? 0 : 4);
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
                                                    int index = aVar.bxn().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fSh.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSh.get(index));
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
        this.fSe = -1;
        this.fSi = 0;
        this.fSj = -1;
        this.Ev = -1;
        this.fSm = new Point();
        this.cLG = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fSg));
                        if (EmotionTabContentView.this.fRU != null) {
                            EmotionTabContentView.this.fRU.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fSj < 0 || EmotionTabContentView.this.fSj >= EmotionTabContentView.this.fSg.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fSg.get(EmotionTabContentView.this.fSj)).aOI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fRU != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fSh.size()) {
                                    EmotionTabContentView.this.fSf = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSh.get(EmotionTabContentView.this.Ev);
                                    int bxt = EmotionTabContentView.this.fSf.bxt();
                                    EmotionTabContentView.this.dkt.setCount(bxt);
                                    EmotionTabContentView.this.dkt.setVisibility(bxt > 1 ? 0 : 4);
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
                                                    int index = aVar.bxn().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fSh.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSh.get(index));
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
        this.fSg = new ArrayList();
        this.fSh = new ArrayList();
        this.fSn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bxl */
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
        this.fRY = new GifView(context);
        am.setBackgroundResource(this.fRY, R.drawable.bg_expression_bubble, this.Ni);
        this.fRY.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.fRX = new WindowManager.LayoutParams();
        this.fSa = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.fSb = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.fSc = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fRX.width = this.fSa;
        this.fRX.height = this.fSb;
        this.fRX.gravity = 51;
        this.fRX.format = -3;
        this.fRX.type = 1000;
        this.fRX.flags |= 56;
        this.fRZ = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dkt = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.fRW = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.fRW.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.fRX.type = 1000;
            this.fRX.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.fSg.clear();
        this.fSh.clear();
        if (list != null && !list.isEmpty()) {
            this.fSg.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aOL = cVar.aOL();
                    int aOM = cVar.aOM();
                    int i4 = emotionsCount / (aOL * aOM);
                    if (emotionsCount % (aOL * aOM) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aOL * aOM;
                        } else {
                            i = emotionsCount - ((aOL * aOM) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.rJ(i3);
                        bVar.b(cVar.aOI());
                        bVar.mz(aOM);
                        bVar.my(aOL);
                        bVar.rE(i4);
                        bVar.rF(i5);
                        bVar.rG(i);
                        bVar.rH(i5 * aOL * aOM);
                        bVar.rI((i + i2) - 1);
                        this.fSh.add(bVar);
                    }
                }
            }
            this.fSi = this.fSh.size();
            for (int i6 = 0; i6 < this.fSi; i6++) {
                if (this.fSh != null && this.fSh.get(i6) != null) {
                    this.fSh.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rB(int i) {
        if (this.fSh != null) {
            int size = this.fSh.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.fSh.get(i2);
                    if (bVar != null && bVar.bxx() == i) {
                        this.fSl = bVar.getIndex();
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
                this.fRU = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.fRU);
                this.mViewPager.setCurrentItem(this.fSl, true);
                if (this.fSk != null) {
                    this.fSk.rD(i);
                    this.fSj = i;
                }
            }
        }
    }

    public void rC(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.fSh.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.fSh.get(i3);
                        if (bVar == null || bVar.bxx() != i) {
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
        if (this.fSe != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bxn() != null) {
            com.baidu.tieba.emotion.editortool.b bxn = aVar.bxn();
            String ms = bxn.bxq().ms(aVar.bxm() + i);
            if (bxn.bxr() != EmotionGroupType.USER_COLLECT || !ms.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.fRY.setTag(ms);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ms;
                if (ms.startsWith("#(meme,")) {
                    this.fRY.setShowStaticDrawable(false);
                } else {
                    this.fRY.setShowStaticDrawable(true);
                }
                this.fRY.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.fRZ.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.fRX.x = this.rect.left - ((this.fRX.width - linearLayout.getWidth()) / 2);
                this.fRX.y = (this.rect.top - this.fRX.height) + this.fSc;
                this.fRY.setVisibility(0);
                if (!this.fSd) {
                    this.mWindowManager.addView(this.fRY, this.fRX);
                    this.fSd = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.fRY, this.fRX);
                }
                gridView.setSelection(i);
                if (this.fSe != -1) {
                    ((LinearLayout) gridView.getChildAt(this.fSe - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.fSe = i;
                this.fRV = gridView;
            }
        }
    }

    private void onUp() {
        if (this.fSd && this.fRY.getVisibility() != 8 && this.fRV != null) {
            this.fRV.setSelection(-1);
            this.fRY.setVisibility(8);
            if (this.fSe != -1) {
                ((LinearLayout) this.fRV.getChildAt(this.fSe - this.fRV.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.fSe = -1;
            this.fRV = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.fSm.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.fSm.set(x, y);
                if (this.fSd && this.fRY.getVisibility() != 8 && this.fRV != null) {
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
                this.fSm.set(x, y);
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
                    if (this.fRV != null) {
                        offsetRectIntoDescendantCoords(this.fRV, this.rect);
                        int pointToPosition = this.fRV.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.fRV);
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
        if (this.fSd) {
            this.mWindowManager.removeView(this.fRY);
            this.fSd = false;
        }
        MessageManager.getInstance().unRegisterListener(this.cLG);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fSh != null) {
            int size = this.fSh.size();
            if (i >= 0 && i < size) {
                this.fSf = this.fSh.get(i);
                if (this.dkt != null && this.fSf != null) {
                    if (this.Ev != i) {
                        this.Ev = i;
                        this.dkt.setVisibility(this.fSf.bxt() > 1 ? 0 : 4);
                        this.dkt.setCount(this.fSf.bxt());
                        if (this.fSf != null && this.fSf.bxx() != this.fSj) {
                            this.fSj = this.fSf.bxx();
                            if (this.fSk != null) {
                                this.fSk.rD(this.fSf.bxx());
                            }
                        }
                    }
                    float bxu = this.fSf.bxu() + f;
                    this.dkt.setPosition(bxu);
                    this.fRW.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bxu) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.fSf.bxt())));
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
        am.setBackgroundResource(this.fRY, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dkt.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dkt.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b fSp;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fSp = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fSp = bVar;
        }

        public int bxm() {
            if (this.fSp == null) {
                return 0;
            }
            return this.fSp.bxw();
        }

        public com.baidu.tieba.emotion.editortool.b bxn() {
            return this.fSp;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fSp == null) {
                return 0;
            }
            return this.fSp.bxv();
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
                if (this.fSp.bxs() != 0) {
                    i2 = measuredWidth / this.fSp.bxs();
                }
                if (this.fSp.getRow() != 0) {
                    i3 = measuredHeight / this.fSp.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.fSc * 2, EmotionTabContentView.this.fSc * 2, EmotionTabContentView.this.fSc * 2, EmotionTabContentView.this.fSc * 2);
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
            if (this.fSp != null) {
                int bxw = this.fSp.bxw() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.Ni);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ms = this.fSp.bxq().ms(bxw);
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
                if (this.fSp.bxr() == EmotionGroupType.BIG_EMOTION) {
                    String ms2 = this.fSp.bxq().ms(bxw);
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
            if (EmotionTabContentView.this.fSh == null) {
                return 0;
            }
            return EmotionTabContentView.this.fSh.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.fSn.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.fSn.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.fSh != null && i < EmotionTabContentView.this.fSh.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSh.get(i);
                gridView2.setNumColumns(bVar.bxs());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bxn() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bxn = aVar.bxn();
                        if (bxn.bxr() == EmotionGroupType.BIG_EMOTION || bxn.bxr() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.bxn() != null) {
                                com.baidu.tieba.emotion.editortool.b bxn = aVar.bxn();
                                int bxm = aVar.bxm();
                                com.baidu.tbadk.editortools.emotiontool.c bxq = bxn.bxq();
                                String ms = bxn.bxq().ms(bxm + i2);
                                if (bxq.aOI() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(ms)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(ms);
                                qVar.a(bxq.aOI());
                                qVar.ui(bxq.getGroupName());
                                qVar.setPid(bxq.getGroupId());
                                qVar.setWidth(bxq.getWidth());
                                qVar.setHeight(bxq.getHeight());
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
            if (EmotionTabContentView.this.fSh != null) {
                int size = EmotionTabContentView.this.fSh.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ev) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSh.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ev = i;
                        EmotionTabContentView.this.dkt.setVisibility(bVar.bxt() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dkt.setCount(bVar.bxt());
                        EmotionTabContentView.this.dkt.setPosition(bVar.bxu());
                        EmotionTabContentView.this.dkt.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bxu() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bxt())));
                    }
                    if (bVar != null && bVar.bxx() != EmotionTabContentView.this.fSj) {
                        EmotionTabContentView.this.fSj = bVar.bxx();
                        if (EmotionTabContentView.this.fSk != null) {
                            EmotionTabContentView.this.fSk.rD(bVar.bxx());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.fSk = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLG);
    }
}
