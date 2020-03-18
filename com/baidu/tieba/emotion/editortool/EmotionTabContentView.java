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
    private int Nj;
    private CustomMessageListener cLS;
    private IndicatorView dkT;
    private EmotionViewPagerAdapter fSQ;
    private GridView fSR;
    private LinearLayout fSS;
    private WindowManager.LayoutParams fST;
    private GifView fSU;
    private ViewGroup fSV;
    private int fSW;
    private int fSX;
    private int fSY;
    private boolean fSZ;
    private int fTa;
    private com.baidu.tieba.emotion.editortool.b fTb;
    private List<com.baidu.tbadk.editortools.emotiontool.c> fTc;
    private List<com.baidu.tieba.emotion.editortool.b> fTd;
    private int fTe;
    private int fTf;
    private b fTg;
    private int fTh;
    private final Point fTi;
    private com.baidu.adp.lib.d.b<GridView> fTj;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void rF(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.fTa = -1;
        this.fTe = 0;
        this.fTf = -1;
        this.Ev = -1;
        this.fTi = new Point();
        this.cLS = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fTc));
                        if (EmotionTabContentView.this.fSQ != null) {
                            EmotionTabContentView.this.fSQ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fTf < 0 || EmotionTabContentView.this.fTf >= EmotionTabContentView.this.fTc.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fTc.get(EmotionTabContentView.this.fTf)).aON() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fSQ != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fTd.size()) {
                                    EmotionTabContentView.this.fTb = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fTd.get(EmotionTabContentView.this.Ev);
                                    int bxz = EmotionTabContentView.this.fTb.bxz();
                                    EmotionTabContentView.this.dkT.setCount(bxz);
                                    EmotionTabContentView.this.dkT.setVisibility(bxz > 1 ? 0 : 4);
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
                                                    int index = aVar.bxt().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fTd.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fTd.get(index));
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
        this.fTa = -1;
        this.fTe = 0;
        this.fTf = -1;
        this.Ev = -1;
        this.fTi = new Point();
        this.cLS = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fTc));
                        if (EmotionTabContentView.this.fSQ != null) {
                            EmotionTabContentView.this.fSQ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fTf < 0 || EmotionTabContentView.this.fTf >= EmotionTabContentView.this.fTc.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fTc.get(EmotionTabContentView.this.fTf)).aON() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fSQ != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fTd.size()) {
                                    EmotionTabContentView.this.fTb = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fTd.get(EmotionTabContentView.this.Ev);
                                    int bxz = EmotionTabContentView.this.fTb.bxz();
                                    EmotionTabContentView.this.dkT.setCount(bxz);
                                    EmotionTabContentView.this.dkT.setVisibility(bxz > 1 ? 0 : 4);
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
                                                    int index = aVar.bxt().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fTd.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fTd.get(index));
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
        this.fTc = new ArrayList();
        this.fTd = new ArrayList();
        this.fTj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bxr */
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
        this.fSU = new GifView(context);
        am.setBackgroundResource(this.fSU, R.drawable.bg_expression_bubble, this.Nj);
        this.fSU.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.fST = new WindowManager.LayoutParams();
        this.fSW = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.fSX = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.fSY = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fST.width = this.fSW;
        this.fST.height = this.fSX;
        this.fST.gravity = 51;
        this.fST.format = -3;
        this.fST.type = 1000;
        this.fST.flags |= 56;
        this.fSV = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dkT = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.fSS = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.fSS.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.fST.type = 1000;
            this.fST.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.fTc.clear();
        this.fTd.clear();
        if (list != null && !list.isEmpty()) {
            this.fTc.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aOQ = cVar.aOQ();
                    int aOR = cVar.aOR();
                    int i4 = emotionsCount / (aOQ * aOR);
                    if (emotionsCount % (aOQ * aOR) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aOQ * aOR;
                        } else {
                            i = emotionsCount - ((aOQ * aOR) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.rL(i3);
                        bVar.b(cVar.aON());
                        bVar.mB(aOR);
                        bVar.mA(aOQ);
                        bVar.rG(i4);
                        bVar.rH(i5);
                        bVar.rI(i);
                        bVar.rJ(i5 * aOQ * aOR);
                        bVar.rK((i + i2) - 1);
                        this.fTd.add(bVar);
                    }
                }
            }
            this.fTe = this.fTd.size();
            for (int i6 = 0; i6 < this.fTe; i6++) {
                if (this.fTd != null && this.fTd.get(i6) != null) {
                    this.fTd.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rD(int i) {
        if (this.fTd != null) {
            int size = this.fTd.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.fTd.get(i2);
                    if (bVar != null && bVar.bxD() == i) {
                        this.fTh = bVar.getIndex();
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
                rD(i);
                this.fSQ = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.fSQ);
                this.mViewPager.setCurrentItem(this.fTh, true);
                if (this.fTg != null) {
                    this.fTg.rF(i);
                    this.fTf = i;
                }
            }
        }
    }

    public void rE(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.fTd.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.fTd.get(i3);
                        if (bVar == null || bVar.bxD() != i) {
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
        if (this.fTa != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bxt() != null) {
            com.baidu.tieba.emotion.editortool.b bxt = aVar.bxt();
            String mu = bxt.bxw().mu(aVar.bxs() + i);
            if (bxt.bxx() != EmotionGroupType.USER_COLLECT || !mu.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.fSU.setTag(mu);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = mu;
                if (mu.startsWith("#(meme,")) {
                    this.fSU.setShowStaticDrawable(false);
                } else {
                    this.fSU.setShowStaticDrawable(true);
                }
                this.fSU.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.fSV.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.fST.x = this.rect.left - ((this.fST.width - linearLayout.getWidth()) / 2);
                this.fST.y = (this.rect.top - this.fST.height) + this.fSY;
                this.fSU.setVisibility(0);
                if (!this.fSZ) {
                    this.mWindowManager.addView(this.fSU, this.fST);
                    this.fSZ = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.fSU, this.fST);
                }
                gridView.setSelection(i);
                if (this.fTa != -1) {
                    ((LinearLayout) gridView.getChildAt(this.fTa - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.fTa = i;
                this.fSR = gridView;
            }
        }
    }

    private void onUp() {
        if (this.fSZ && this.fSU.getVisibility() != 8 && this.fSR != null) {
            this.fSR.setSelection(-1);
            this.fSU.setVisibility(8);
            if (this.fTa != -1) {
                ((LinearLayout) this.fSR.getChildAt(this.fTa - this.fSR.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.fTa = -1;
            this.fSR = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.fTi.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.fTi.set(x, y);
                if (this.fSZ && this.fSU.getVisibility() != 8 && this.fSR != null) {
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
                this.fTi.set(x, y);
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
                    if (this.fSR != null) {
                        offsetRectIntoDescendantCoords(this.fSR, this.rect);
                        int pointToPosition = this.fSR.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.fSR);
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
        if (this.fSZ) {
            this.mWindowManager.removeView(this.fSU);
            this.fSZ = false;
        }
        MessageManager.getInstance().unRegisterListener(this.cLS);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fTd != null) {
            int size = this.fTd.size();
            if (i >= 0 && i < size) {
                this.fTb = this.fTd.get(i);
                if (this.dkT != null && this.fTb != null) {
                    if (this.Ev != i) {
                        this.Ev = i;
                        this.dkT.setVisibility(this.fTb.bxz() > 1 ? 0 : 4);
                        this.dkT.setCount(this.fTb.bxz());
                        if (this.fTb != null && this.fTb.bxD() != this.fTf) {
                            this.fTf = this.fTb.bxD();
                            if (this.fTg != null) {
                                this.fTg.rF(this.fTb.bxD());
                            }
                        }
                    }
                    float bxA = this.fTb.bxA() + f;
                    this.dkT.setPosition(bxA);
                    this.fSS.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bxA) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.fTb.bxz())));
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
        this.Nj = i;
        am.setBackgroundResource(this.fSU, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dkT.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dkT.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b fTl;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fTl = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fTl = bVar;
        }

        public int bxs() {
            if (this.fTl == null) {
                return 0;
            }
            return this.fTl.bxC();
        }

        public com.baidu.tieba.emotion.editortool.b bxt() {
            return this.fTl;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fTl == null) {
                return 0;
            }
            return this.fTl.bxB();
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
                if (this.fTl.bxy() != 0) {
                    i2 = measuredWidth / this.fTl.bxy();
                }
                if (this.fTl.getRow() != 0) {
                    i3 = measuredHeight / this.fTl.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.fSY * 2, EmotionTabContentView.this.fSY * 2, EmotionTabContentView.this.fSY * 2, EmotionTabContentView.this.fSY * 2);
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
            if (this.fTl != null) {
                int bxC = this.fTl.bxC() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.Nj);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String mu = this.fTl.bxw().mu(bxC);
                tbImageView.setTag(mu);
                if (!TextUtils.isEmpty(mu)) {
                    Object a = com.baidu.adp.lib.e.c.gr().a(mu, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, mu, false, null);
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
                if (this.fTl.bxx() == EmotionGroupType.BIG_EMOTION) {
                    String mu2 = this.fTl.bxw().mu(bxC);
                    if (!TextUtils.isEmpty(mu2) && !mu2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.Nj == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(mu2.substring(mu2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, mu2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (mu != null && mu.length() > 3) {
                    linearLayout3.setContentDescription(mu.substring(2, mu.length() - 1));
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
            if (EmotionTabContentView.this.fTd == null) {
                return 0;
            }
            return EmotionTabContentView.this.fTd.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.fTj.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.fTj.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.fTd != null && i < EmotionTabContentView.this.fTd.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fTd.get(i);
                gridView2.setNumColumns(bVar.bxy());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bxt() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bxt = aVar.bxt();
                        if (bxt.bxx() == EmotionGroupType.BIG_EMOTION || bxt.bxx() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.bxt() != null) {
                                com.baidu.tieba.emotion.editortool.b bxt = aVar.bxt();
                                int bxs = aVar.bxs();
                                com.baidu.tbadk.editortools.emotiontool.c bxw = bxt.bxw();
                                String mu = bxt.bxw().mu(bxs + i2);
                                if (bxw.aON() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(mu)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(mu);
                                qVar.a(bxw.aON());
                                qVar.ui(bxw.getGroupName());
                                qVar.setPid(bxw.getGroupId());
                                qVar.setWidth(bxw.getWidth());
                                qVar.setHeight(bxw.getHeight());
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
            if (EmotionTabContentView.this.fTd != null) {
                int size = EmotionTabContentView.this.fTd.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ev) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fTd.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ev = i;
                        EmotionTabContentView.this.dkT.setVisibility(bVar.bxz() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dkT.setCount(bVar.bxz());
                        EmotionTabContentView.this.dkT.setPosition(bVar.bxA());
                        EmotionTabContentView.this.dkT.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bxA() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bxz())));
                    }
                    if (bVar != null && bVar.bxD() != EmotionTabContentView.this.fTf) {
                        EmotionTabContentView.this.fTf = bVar.bxD();
                        if (EmotionTabContentView.this.fTg != null) {
                            EmotionTabContentView.this.fTg.rF(bVar.bxD());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.fTg = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLS);
    }
}
