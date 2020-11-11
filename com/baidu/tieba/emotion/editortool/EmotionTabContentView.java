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
    private final Rect bDL;
    private CustomMessageListener exi;
    private IndicatorView faQ;
    private WindowManager.LayoutParams igA;
    private GifView igB;
    private ViewGroup igC;
    private int igD;
    private int igE;
    private int igF;
    private boolean igG;
    private int igH;
    private com.baidu.tieba.emotion.editortool.b igI;
    private List<com.baidu.tbadk.editortools.emotiontool.c> igJ;
    private List<com.baidu.tieba.emotion.editortool.b> igK;
    private int igL;
    private int igM;
    private b igN;
    private int igO;
    private final Point igP;
    private com.baidu.adp.lib.d.b<GridView> igQ;
    private EmotionViewPagerAdapter igx;
    private GridView igy;
    private LinearLayout igz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes13.dex */
    public interface b {
        void xw(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bDL = new Rect();
        this.igH = -1;
        this.igL = 0;
        this.igM = -1;
        this.ZQ = -1;
        this.igP = new Point();
        this.exi = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cH(new ArrayList(EmotionTabContentView.this.igJ));
                        if (EmotionTabContentView.this.igx != null) {
                            EmotionTabContentView.this.igx.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.igM < 0 || EmotionTabContentView.this.igM >= EmotionTabContentView.this.igJ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.igJ.get(EmotionTabContentView.this.igM)).bzR() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.igx != null) {
                                if (EmotionTabContentView.this.ZQ >= 0 && EmotionTabContentView.this.ZQ < EmotionTabContentView.this.igK.size()) {
                                    EmotionTabContentView.this.igI = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.igK.get(EmotionTabContentView.this.ZQ);
                                    int cqC = EmotionTabContentView.this.igI.cqC();
                                    EmotionTabContentView.this.faQ.setCount(cqC);
                                    EmotionTabContentView.this.faQ.setVisibility(cqC > 1 ? 0 : 4);
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
                                                    int index = aVar.cqw().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.igK.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.igK.get(index));
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
        this.bDL = new Rect();
        this.igH = -1;
        this.igL = 0;
        this.igM = -1;
        this.ZQ = -1;
        this.igP = new Point();
        this.exi = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cH(new ArrayList(EmotionTabContentView.this.igJ));
                        if (EmotionTabContentView.this.igx != null) {
                            EmotionTabContentView.this.igx.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.igM < 0 || EmotionTabContentView.this.igM >= EmotionTabContentView.this.igJ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.igJ.get(EmotionTabContentView.this.igM)).bzR() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.igx != null) {
                                if (EmotionTabContentView.this.ZQ >= 0 && EmotionTabContentView.this.ZQ < EmotionTabContentView.this.igK.size()) {
                                    EmotionTabContentView.this.igI = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.igK.get(EmotionTabContentView.this.ZQ);
                                    int cqC = EmotionTabContentView.this.igI.cqC();
                                    EmotionTabContentView.this.faQ.setCount(cqC);
                                    EmotionTabContentView.this.faQ.setVisibility(cqC > 1 ? 0 : 4);
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
                                                    int index = aVar.cqw().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.igK.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.igK.get(index));
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
        this.igJ = new ArrayList();
        this.igK = new ArrayList();
        this.igQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cqu */
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
        this.igB = new GifView(context);
        ap.setBackgroundResource(this.igB, R.drawable.bg_expression_bubble, this.ajq);
        this.igB.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.igA = new WindowManager.LayoutParams();
        this.igD = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.igE = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.igF = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.igA.width = this.igD;
        this.igA.height = this.igE;
        this.igA.gravity = 51;
        this.igA.format = -3;
        this.igA.type = 1000;
        this.igA.flags |= 56;
        this.igC = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.faQ = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.igz = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.igz.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.igA.type = 1000;
            this.igA.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.igJ.clear();
        this.igK.clear();
        if (list != null && !list.isEmpty()) {
            this.igJ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bzU = cVar.bzU();
                    int bzV = cVar.bzV();
                    int i4 = emotionsCount / (bzU * bzV);
                    if (emotionsCount % (bzU * bzV) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bzU * bzV;
                        } else {
                            i = emotionsCount - ((bzU * bzV) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.xC(i3);
                        bVar.b(cVar.bzR());
                        bVar.rx(bzV);
                        bVar.setColumn(bzU);
                        bVar.xx(i4);
                        bVar.xy(i5);
                        bVar.xz(i);
                        bVar.xA(i5 * bzU * bzV);
                        bVar.xB((i + i2) - 1);
                        this.igK.add(bVar);
                    }
                }
            }
            this.igL = this.igK.size();
            for (int i6 = 0; i6 < this.igL; i6++) {
                if (this.igK != null && this.igK.get(i6) != null) {
                    this.igK.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void xu(int i) {
        if (this.igK != null) {
            int size = this.igK.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.igK.get(i2);
                    if (bVar != null && bVar.cqG() == i) {
                        this.igO = bVar.getIndex();
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
                cH(list);
                xu(i);
                this.igx = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.igx);
                this.mViewPager.setCurrentItem(this.igO, true);
                if (this.igN != null) {
                    this.igN.xw(i);
                    this.igM = i;
                }
            }
        }
    }

    public void xv(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.igK.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.igK.get(i3);
                        if (bVar == null || bVar.cqG() != i) {
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
        if (this.igH != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cqw() != null) {
            com.baidu.tieba.emotion.editortool.b cqw = aVar.cqw();
            String rn = cqw.cqz().rn(aVar.cqv() + i);
            if (cqw.cqA() != EmotionGroupType.USER_COLLECT || !rn.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.igB.setTag(rn);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = rn;
                if (rn.startsWith("#(meme,")) {
                    this.igB.setShowStaticDrawable(false);
                } else {
                    this.igB.setShowStaticDrawable(true);
                }
                this.igB.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bDL);
                this.igC.offsetDescendantRectToMyCoords(linearLayout, this.bDL);
                this.igA.x = this.bDL.left - ((this.igA.width - linearLayout.getWidth()) / 2);
                this.igA.y = (this.bDL.top - this.igA.height) + this.igF;
                this.igB.setVisibility(0);
                if (!this.igG) {
                    this.mWindowManager.addView(this.igB, this.igA);
                    this.igG = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.igB, this.igA);
                }
                gridView.setSelection(i);
                if (this.igH != -1) {
                    ((LinearLayout) gridView.getChildAt(this.igH - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.igH = i;
                this.igy = gridView;
            }
        }
    }

    private void onUp() {
        if (this.igG && this.igB.getVisibility() != 8 && this.igy != null) {
            this.igy.setSelection(-1);
            this.igB.setVisibility(8);
            if (this.igH != -1) {
                ((LinearLayout) this.igy.getChildAt(this.igH - this.igy.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.igH = -1;
            this.igy = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.igP.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.igP.set(x, y);
                if (this.igG && this.igB.getVisibility() != 8 && this.igy != null) {
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
                this.igP.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.bDL);
                if (!this.bDL.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.bDL.set(x, y, x + 1, y + 1);
                    if (this.igy != null) {
                        offsetRectIntoDescendantCoords(this.igy, this.bDL);
                        int pointToPosition = this.igy.pointToPosition(this.bDL.left, this.bDL.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.igy);
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
        if (this.igG) {
            this.mWindowManager.removeView(this.igB);
            this.igG = false;
        }
        MessageManager.getInstance().unRegisterListener(this.exi);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.igK != null) {
            int size = this.igK.size();
            if (i >= 0 && i < size) {
                this.igI = this.igK.get(i);
                if (this.faQ != null && this.igI != null) {
                    if (this.ZQ != i) {
                        this.ZQ = i;
                        this.faQ.setVisibility(this.igI.cqC() > 1 ? 0 : 4);
                        this.faQ.setCount(this.igI.cqC());
                        if (this.igI != null && this.igI.cqG() != this.igM) {
                            this.igM = this.igI.cqG();
                            if (this.igN != null) {
                                this.igN.xw(this.igI.cqG());
                            }
                        }
                    }
                    float cqD = this.igI.cqD() + f;
                    this.faQ.setPosition(cqD);
                    this.igz.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cqD) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.igI.cqC())));
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
        ap.setBackgroundResource(this.igB, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.faQ.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.faQ.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b igS;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.igS = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.igS = bVar;
        }

        public int cqv() {
            if (this.igS == null) {
                return 0;
            }
            return this.igS.cqF();
        }

        public com.baidu.tieba.emotion.editortool.b cqw() {
            return this.igS;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.igS == null) {
                return 0;
            }
            return this.igS.cqE();
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
                if (this.igS.cqB() != 0) {
                    i2 = measuredWidth / this.igS.cqB();
                }
                if (this.igS.getRow() != 0) {
                    i3 = measuredHeight / this.igS.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.igF * 2, EmotionTabContentView.this.igF * 2, EmotionTabContentView.this.igF * 2, EmotionTabContentView.this.igF * 2);
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
            if (this.igS != null) {
                int cqF = this.igS.cqF() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ajq);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String rn = this.igS.cqz().rn(cqF);
                tbImageView.setTag(rn);
                if (!TextUtils.isEmpty(rn)) {
                    Object a2 = com.baidu.adp.lib.e.c.mS().a(rn, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, rn, false, null);
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
                if (this.igS.cqA() == EmotionGroupType.BIG_EMOTION) {
                    String rn2 = this.igS.cqz().rn(cqF);
                    if (!TextUtils.isEmpty(rn2) && !rn2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ajq == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = ap.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(rn2.substring(rn2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, rn2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (rn != null && rn.length() > 3) {
                    linearLayout3.setContentDescription(rn.substring(2, rn.length() - 1));
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
            if (EmotionTabContentView.this.igK == null) {
                return 0;
            }
            return EmotionTabContentView.this.igK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.igQ.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.igQ.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.igK != null && i < EmotionTabContentView.this.igK.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.igK.get(i);
                gridView2.setNumColumns(bVar.cqB());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cqw() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cqw = aVar.cqw();
                        if (cqw.cqA() == EmotionGroupType.BIG_EMOTION || cqw.cqA() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.cqw() != null) {
                                com.baidu.tieba.emotion.editortool.b cqw = aVar.cqw();
                                int cqv = aVar.cqv();
                                com.baidu.tbadk.editortools.emotiontool.c cqz = cqw.cqz();
                                String rn = cqw.cqz().rn(cqv + i2);
                                if (cqz.bzR() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(rn)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(rn);
                                uVar.a(cqz.bzR());
                                uVar.CK(cqz.getGroupName());
                                uVar.setPid(cqz.getGroupId());
                                uVar.setWidth(cqz.getWidth());
                                uVar.setHeight(cqz.getHeight());
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
            if (EmotionTabContentView.this.igK != null) {
                int size = EmotionTabContentView.this.igK.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.ZQ) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.igK.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.ZQ = i;
                        EmotionTabContentView.this.faQ.setVisibility(bVar.cqC() > 1 ? 0 : 4);
                        EmotionTabContentView.this.faQ.setCount(bVar.cqC());
                        EmotionTabContentView.this.faQ.setPosition(bVar.cqD());
                        EmotionTabContentView.this.faQ.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cqD() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cqC())));
                    }
                    if (bVar != null && bVar.cqG() != EmotionTabContentView.this.igM) {
                        EmotionTabContentView.this.igM = bVar.cqG();
                        if (EmotionTabContentView.this.igN != null) {
                            EmotionTabContentView.this.igN.xw(bVar.cqG());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.igN = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.exi);
    }
}
