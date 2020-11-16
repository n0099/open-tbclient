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
    private int ZV;
    private EditorTools abp;
    private int ajv;
    private final Rect bCa;
    private IndicatorView eZY;
    private CustomMessageListener evz;
    private int ihA;
    private b ihB;
    private int ihC;
    private final Point ihD;
    private com.baidu.adp.lib.d.b<GridView> ihE;
    private EmotionViewPagerAdapter ihl;
    private GridView ihm;
    private LinearLayout ihn;
    private WindowManager.LayoutParams iho;
    private GifView ihp;
    private ViewGroup ihq;
    private int ihr;
    private int ihs;
    private int iht;
    private boolean ihu;
    private int ihv;
    private com.baidu.tieba.emotion.editortool.b ihw;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ihx;
    private List<com.baidu.tieba.emotion.editortool.b> ihy;
    private int ihz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes13.dex */
    public interface b {
        void xU(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCa = new Rect();
        this.ihv = -1;
        this.ihz = 0;
        this.ihA = -1;
        this.ZV = -1;
        this.ihD = new Point();
        this.evz = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cH(new ArrayList(EmotionTabContentView.this.ihx));
                        if (EmotionTabContentView.this.ihl != null) {
                            EmotionTabContentView.this.ihl.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ihA < 0 || EmotionTabContentView.this.ihA >= EmotionTabContentView.this.ihx.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ihx.get(EmotionTabContentView.this.ihA)).bzh() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ihl != null) {
                                if (EmotionTabContentView.this.ZV >= 0 && EmotionTabContentView.this.ZV < EmotionTabContentView.this.ihy.size()) {
                                    EmotionTabContentView.this.ihw = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ihy.get(EmotionTabContentView.this.ZV);
                                    int cqf = EmotionTabContentView.this.ihw.cqf();
                                    EmotionTabContentView.this.eZY.setCount(cqf);
                                    EmotionTabContentView.this.eZY.setVisibility(cqf > 1 ? 0 : 4);
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
                                                    int index = aVar.cpZ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ihy.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ihy.get(index));
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
        this.bCa = new Rect();
        this.ihv = -1;
        this.ihz = 0;
        this.ihA = -1;
        this.ZV = -1;
        this.ihD = new Point();
        this.evz = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cH(new ArrayList(EmotionTabContentView.this.ihx));
                        if (EmotionTabContentView.this.ihl != null) {
                            EmotionTabContentView.this.ihl.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ihA < 0 || EmotionTabContentView.this.ihA >= EmotionTabContentView.this.ihx.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ihx.get(EmotionTabContentView.this.ihA)).bzh() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ihl != null) {
                                if (EmotionTabContentView.this.ZV >= 0 && EmotionTabContentView.this.ZV < EmotionTabContentView.this.ihy.size()) {
                                    EmotionTabContentView.this.ihw = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ihy.get(EmotionTabContentView.this.ZV);
                                    int cqf = EmotionTabContentView.this.ihw.cqf();
                                    EmotionTabContentView.this.eZY.setCount(cqf);
                                    EmotionTabContentView.this.eZY.setVisibility(cqf > 1 ? 0 : 4);
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
                                                    int index = aVar.cpZ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ihy.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ihy.get(index));
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
        this.ihx = new ArrayList();
        this.ihy = new ArrayList();
        this.ihE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cpX */
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
        this.ihp = new GifView(context);
        ap.setBackgroundResource(this.ihp, R.drawable.bg_expression_bubble, this.ajv);
        this.ihp.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.iho = new WindowManager.LayoutParams();
        this.ihr = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.ihs = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.iht = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.iho.width = this.ihr;
        this.iho.height = this.ihs;
        this.iho.gravity = 51;
        this.iho.format = -3;
        this.iho.type = 1000;
        this.iho.flags |= 56;
        this.ihq = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eZY = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.ihn = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.ihn.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.iho.type = 1000;
            this.iho.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ihx.clear();
        this.ihy.clear();
        if (list != null && !list.isEmpty()) {
            this.ihx.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bzk = cVar.bzk();
                    int bzl = cVar.bzl();
                    int i4 = emotionsCount / (bzk * bzl);
                    if (emotionsCount % (bzk * bzl) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bzk * bzl;
                        } else {
                            i = emotionsCount - ((bzk * bzl) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.ya(i3);
                        bVar.b(cVar.bzh());
                        bVar.rV(bzl);
                        bVar.setColumn(bzk);
                        bVar.xV(i4);
                        bVar.xW(i5);
                        bVar.xX(i);
                        bVar.xY(i5 * bzk * bzl);
                        bVar.xZ((i + i2) - 1);
                        this.ihy.add(bVar);
                    }
                }
            }
            this.ihz = this.ihy.size();
            for (int i6 = 0; i6 < this.ihz; i6++) {
                if (this.ihy != null && this.ihy.get(i6) != null) {
                    this.ihy.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void xS(int i) {
        if (this.ihy != null) {
            int size = this.ihy.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.ihy.get(i2);
                    if (bVar != null && bVar.cqj() == i) {
                        this.ihC = bVar.getIndex();
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
                xS(i);
                this.ihl = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.ihl);
                this.mViewPager.setCurrentItem(this.ihC, true);
                if (this.ihB != null) {
                    this.ihB.xU(i);
                    this.ihA = i;
                }
            }
        }
    }

    public void xT(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ihy.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.ihy.get(i3);
                        if (bVar == null || bVar.cqj() != i) {
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
        if (this.ihv != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cpZ() != null) {
            com.baidu.tieba.emotion.editortool.b cpZ = aVar.cpZ();
            String rL = cpZ.cqc().rL(aVar.cpY() + i);
            if (cpZ.cqd() != EmotionGroupType.USER_COLLECT || !rL.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.ihp.setTag(rL);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = rL;
                if (rL.startsWith("#(meme,")) {
                    this.ihp.setShowStaticDrawable(false);
                } else {
                    this.ihp.setShowStaticDrawable(true);
                }
                this.ihp.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bCa);
                this.ihq.offsetDescendantRectToMyCoords(linearLayout, this.bCa);
                this.iho.x = this.bCa.left - ((this.iho.width - linearLayout.getWidth()) / 2);
                this.iho.y = (this.bCa.top - this.iho.height) + this.iht;
                this.ihp.setVisibility(0);
                if (!this.ihu) {
                    this.mWindowManager.addView(this.ihp, this.iho);
                    this.ihu = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ihp, this.iho);
                }
                gridView.setSelection(i);
                if (this.ihv != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ihv - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ihv = i;
                this.ihm = gridView;
            }
        }
    }

    private void onUp() {
        if (this.ihu && this.ihp.getVisibility() != 8 && this.ihm != null) {
            this.ihm.setSelection(-1);
            this.ihp.setVisibility(8);
            if (this.ihv != -1) {
                ((LinearLayout) this.ihm.getChildAt(this.ihv - this.ihm.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ihv = -1;
            this.ihm = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ihD.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.ihD.set(x, y);
                if (this.ihu && this.ihp.getVisibility() != 8 && this.ihm != null) {
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
                this.ihD.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.bCa);
                if (!this.bCa.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.bCa.set(x, y, x + 1, y + 1);
                    if (this.ihm != null) {
                        offsetRectIntoDescendantCoords(this.ihm, this.bCa);
                        int pointToPosition = this.ihm.pointToPosition(this.bCa.left, this.bCa.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.ihm);
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
        if (this.ihu) {
            this.mWindowManager.removeView(this.ihp);
            this.ihu = false;
        }
        MessageManager.getInstance().unRegisterListener(this.evz);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ihy != null) {
            int size = this.ihy.size();
            if (i >= 0 && i < size) {
                this.ihw = this.ihy.get(i);
                if (this.eZY != null && this.ihw != null) {
                    if (this.ZV != i) {
                        this.ZV = i;
                        this.eZY.setVisibility(this.ihw.cqf() > 1 ? 0 : 4);
                        this.eZY.setCount(this.ihw.cqf());
                        if (this.ihw != null && this.ihw.cqj() != this.ihA) {
                            this.ihA = this.ihw.cqj();
                            if (this.ihB != null) {
                                this.ihB.xU(this.ihw.cqj());
                            }
                        }
                    }
                    float cqg = this.ihw.cqg() + f;
                    this.eZY.setPosition(cqg);
                    this.ihn.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cqg) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.ihw.cqf())));
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
        this.ajv = i;
        ap.setBackgroundResource(this.ihp, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.CAM_X0206, i);
        this.eZY.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eZY.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b ihG;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ihG = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.ihG = bVar;
        }

        public int cpY() {
            if (this.ihG == null) {
                return 0;
            }
            return this.ihG.cqi();
        }

        public com.baidu.tieba.emotion.editortool.b cpZ() {
            return this.ihG;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ihG == null) {
                return 0;
            }
            return this.ihG.cqh();
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
                if (this.ihG.cqe() != 0) {
                    i2 = measuredWidth / this.ihG.cqe();
                }
                if (this.ihG.getRow() != 0) {
                    i3 = measuredHeight / this.ihG.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.iht * 2, EmotionTabContentView.this.iht * 2, EmotionTabContentView.this.iht * 2, EmotionTabContentView.this.iht * 2);
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
            if (this.ihG != null) {
                int cqi = this.ihG.cqi() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ajv);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String rL = this.ihG.cqc().rL(cqi);
                tbImageView.setTag(rL);
                if (!TextUtils.isEmpty(rL)) {
                    Object a2 = com.baidu.adp.lib.e.c.mS().a(rL, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, rL, false, null);
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
                if (this.ihG.cqd() == EmotionGroupType.BIG_EMOTION) {
                    String rL2 = this.ihG.cqc().rL(cqi);
                    if (!TextUtils.isEmpty(rL2) && !rL2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ajv == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = ap.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(rL2.substring(rL2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, rL2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (rL != null && rL.length() > 3) {
                    linearLayout3.setContentDescription(rL.substring(2, rL.length() - 1));
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
            if (EmotionTabContentView.this.ihy == null) {
                return 0;
            }
            return EmotionTabContentView.this.ihy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ihE.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ihE.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ihy != null && i < EmotionTabContentView.this.ihy.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ihy.get(i);
                gridView2.setNumColumns(bVar.cqe());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cpZ() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cpZ = aVar.cpZ();
                        if (cpZ.cqd() == EmotionGroupType.BIG_EMOTION || cpZ.cqd() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.abp != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cpZ() != null) {
                                com.baidu.tieba.emotion.editortool.b cpZ = aVar.cpZ();
                                int cpY = aVar.cpY();
                                com.baidu.tbadk.editortools.emotiontool.c cqc = cpZ.cqc();
                                String rL = cpZ.cqc().rL(cpY + i2);
                                if (cqc.bzh() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(rL)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(rL);
                                uVar.a(cqc.bzh());
                                uVar.Cj(cqc.getGroupName());
                                uVar.setPid(cqc.getGroupId());
                                uVar.setWidth(cqc.getWidth());
                                uVar.setHeight(cqc.getHeight());
                                EmotionTabContentView.this.abp.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.ihy != null) {
                int size = EmotionTabContentView.this.ihy.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.ZV) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.ihy.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.ZV = i;
                        EmotionTabContentView.this.eZY.setVisibility(bVar.cqf() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eZY.setCount(bVar.cqf());
                        EmotionTabContentView.this.eZY.setPosition(bVar.cqg());
                        EmotionTabContentView.this.eZY.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cqg() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cqf())));
                    }
                    if (bVar != null && bVar.cqj() != EmotionTabContentView.this.ihA) {
                        EmotionTabContentView.this.ihA = bVar.cqj();
                        if (EmotionTabContentView.this.ihB != null) {
                            EmotionTabContentView.this.ihB.xU(bVar.cqj());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.ihB = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.evz);
    }
}
