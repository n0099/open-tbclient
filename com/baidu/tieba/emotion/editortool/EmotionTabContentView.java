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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes13.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Yz;
    private EditorTools ZS;
    private int aho;
    private CustomMessageListener dLt;
    private IndicatorView eod;
    private EmotionViewPagerAdapter hfa;
    private GridView hfb;
    private LinearLayout hfc;
    private WindowManager.LayoutParams hfd;
    private GifView hfe;
    private ViewGroup hff;
    private int hfg;
    private int hfh;
    private int hfi;
    private boolean hfj;
    private int hfk;
    private com.baidu.tieba.emotion.editortool.b hfl;
    private List<com.baidu.tbadk.editortools.emotiontool.c> hfm;
    private List<com.baidu.tieba.emotion.editortool.b> hfn;
    private int hfo;
    private int hfp;
    private b hfq;
    private int hfr;
    private final Point hfs;
    private com.baidu.adp.lib.d.b<GridView> hft;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes13.dex */
    public interface b {
        void tw(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.hfk = -1;
        this.hfo = 0;
        this.hfp = -1;
        this.Yz = -1;
        this.hfs = new Point();
        this.dLt = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cf(new ArrayList(EmotionTabContentView.this.hfm));
                        if (EmotionTabContentView.this.hfa != null) {
                            EmotionTabContentView.this.hfa.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hfp < 0 || EmotionTabContentView.this.hfp >= EmotionTabContentView.this.hfm.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hfm.get(EmotionTabContentView.this.hfp)).bja() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hfa != null) {
                                if (EmotionTabContentView.this.Yz >= 0 && EmotionTabContentView.this.Yz < EmotionTabContentView.this.hfn.size()) {
                                    EmotionTabContentView.this.hfl = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hfn.get(EmotionTabContentView.this.Yz);
                                    int bTW = EmotionTabContentView.this.hfl.bTW();
                                    EmotionTabContentView.this.eod.setCount(bTW);
                                    EmotionTabContentView.this.eod.setVisibility(bTW > 1 ? 0 : 4);
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
                                                    int index = aVar.bTQ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hfn.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hfn.get(index));
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
        this.hfk = -1;
        this.hfo = 0;
        this.hfp = -1;
        this.Yz = -1;
        this.hfs = new Point();
        this.dLt = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cf(new ArrayList(EmotionTabContentView.this.hfm));
                        if (EmotionTabContentView.this.hfa != null) {
                            EmotionTabContentView.this.hfa.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hfp < 0 || EmotionTabContentView.this.hfp >= EmotionTabContentView.this.hfm.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hfm.get(EmotionTabContentView.this.hfp)).bja() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hfa != null) {
                                if (EmotionTabContentView.this.Yz >= 0 && EmotionTabContentView.this.Yz < EmotionTabContentView.this.hfn.size()) {
                                    EmotionTabContentView.this.hfl = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hfn.get(EmotionTabContentView.this.Yz);
                                    int bTW = EmotionTabContentView.this.hfl.bTW();
                                    EmotionTabContentView.this.eod.setCount(bTW);
                                    EmotionTabContentView.this.eod.setVisibility(bTW > 1 ? 0 : 4);
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
                                                    int index = aVar.bTQ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hfn.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hfn.get(index));
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
        this.hfm = new ArrayList();
        this.hfn = new ArrayList();
        this.hft = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bTO */
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
        this.hfe = new GifView(context);
        ao.setBackgroundResource(this.hfe, R.drawable.bg_expression_bubble, this.aho);
        this.hfe.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.hfd = new WindowManager.LayoutParams();
        this.hfg = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.hfh = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.hfi = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.hfd.width = this.hfg;
        this.hfd.height = this.hfh;
        this.hfd.gravity = 51;
        this.hfd.format = -3;
        this.hfd.type = 1000;
        this.hfd.flags |= 56;
        this.hff = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eod = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.hfc = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.hfc.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.hfd.type = 1000;
            this.hfd.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.hfm.clear();
        this.hfn.clear();
        if (list != null && !list.isEmpty()) {
            this.hfm.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bjd = cVar.bjd();
                    int bje = cVar.bje();
                    int i4 = emotionsCount / (bjd * bje);
                    if (emotionsCount % (bjd * bje) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bjd * bje;
                        } else {
                            i = emotionsCount - ((bjd * bje) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.tC(i3);
                        bVar.b(cVar.bja());
                        bVar.oc(bje);
                        bVar.setColumn(bjd);
                        bVar.tx(i4);
                        bVar.ty(i5);
                        bVar.tz(i);
                        bVar.tA(i5 * bjd * bje);
                        bVar.tB((i + i2) - 1);
                        this.hfn.add(bVar);
                    }
                }
            }
            this.hfo = this.hfn.size();
            for (int i6 = 0; i6 < this.hfo; i6++) {
                if (this.hfn != null && this.hfn.get(i6) != null) {
                    this.hfn.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void tu(int i) {
        if (this.hfn != null) {
            int size = this.hfn.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.hfn.get(i2);
                    if (bVar != null && bVar.bUa() == i) {
                        this.hfr = bVar.getIndex();
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
                cf(list);
                tu(i);
                this.hfa = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.hfa);
                this.mViewPager.setCurrentItem(this.hfr, true);
                if (this.hfq != null) {
                    this.hfq.tw(i);
                    this.hfp = i;
                }
            }
        }
    }

    public void tv(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.hfn.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.hfn.get(i3);
                        if (bVar == null || bVar.bUa() != i) {
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
        if (this.hfk != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bTQ() != null) {
            com.baidu.tieba.emotion.editortool.b bTQ = aVar.bTQ();
            String nW = bTQ.bTT().nW(aVar.bTP() + i);
            if (bTQ.bTU() != EmotionGroupType.USER_COLLECT || !nW.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.hfe.setTag(nW);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = nW;
                if (nW.startsWith("#(meme,")) {
                    this.hfe.setShowStaticDrawable(false);
                } else {
                    this.hfe.setShowStaticDrawable(true);
                }
                this.hfe.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.hff.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.hfd.x = this.rect.left - ((this.hfd.width - linearLayout.getWidth()) / 2);
                this.hfd.y = (this.rect.top - this.hfd.height) + this.hfi;
                this.hfe.setVisibility(0);
                if (!this.hfj) {
                    this.mWindowManager.addView(this.hfe, this.hfd);
                    this.hfj = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.hfe, this.hfd);
                }
                gridView.setSelection(i);
                if (this.hfk != -1) {
                    ((LinearLayout) gridView.getChildAt(this.hfk - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.hfk = i;
                this.hfb = gridView;
            }
        }
    }

    private void onUp() {
        if (this.hfj && this.hfe.getVisibility() != 8 && this.hfb != null) {
            this.hfb.setSelection(-1);
            this.hfe.setVisibility(8);
            if (this.hfk != -1) {
                ((LinearLayout) this.hfb.getChildAt(this.hfk - this.hfb.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.hfk = -1;
            this.hfb = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.hfs.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.hfs.set(x, y);
                if (this.hfj && this.hfe.getVisibility() != 8 && this.hfb != null) {
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
                this.hfs.set(x, y);
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
                    if (this.hfb != null) {
                        offsetRectIntoDescendantCoords(this.hfb, this.rect);
                        int pointToPosition = this.hfb.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.hfb);
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
        if (this.hfj) {
            this.mWindowManager.removeView(this.hfe);
            this.hfj = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dLt);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hfn != null) {
            int size = this.hfn.size();
            if (i >= 0 && i < size) {
                this.hfl = this.hfn.get(i);
                if (this.eod != null && this.hfl != null) {
                    if (this.Yz != i) {
                        this.Yz = i;
                        this.eod.setVisibility(this.hfl.bTW() > 1 ? 0 : 4);
                        this.eod.setCount(this.hfl.bTW());
                        if (this.hfl != null && this.hfl.bUa() != this.hfp) {
                            this.hfp = this.hfl.bUa();
                            if (this.hfq != null) {
                                this.hfq.tw(this.hfl.bUa());
                            }
                        }
                    }
                    float bTX = this.hfl.bTX() + f;
                    this.eod.setPosition(bTX);
                    this.hfc.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bTX) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.hfl.bTW())));
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
        this.aho = i;
        ao.setBackgroundResource(this.hfe, R.drawable.bg_expression_bubble, i);
        ao.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.eod.setSelector(ao.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eod.setDrawable(ao.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b hfv;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hfv = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hfv = bVar;
        }

        public int bTP() {
            if (this.hfv == null) {
                return 0;
            }
            return this.hfv.bTZ();
        }

        public com.baidu.tieba.emotion.editortool.b bTQ() {
            return this.hfv;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.hfv == null) {
                return 0;
            }
            return this.hfv.bTY();
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
                if (this.hfv.bTV() != 0) {
                    i2 = measuredWidth / this.hfv.bTV();
                }
                if (this.hfv.getRow() != 0) {
                    i3 = measuredHeight / this.hfv.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.hfi * 2, EmotionTabContentView.this.hfi * 2, EmotionTabContentView.this.hfi * 2, EmotionTabContentView.this.hfi * 2);
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
            if (this.hfv != null) {
                int bTZ = this.hfv.bTZ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ao.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aho);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String nW = this.hfv.bTT().nW(bTZ);
                tbImageView.setTag(nW);
                if (!TextUtils.isEmpty(nW)) {
                    Object a = com.baidu.adp.lib.e.c.ln().a(nW, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, nW, false, null);
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
                if (this.hfv.bTU() == EmotionGroupType.BIG_EMOTION) {
                    String nW2 = this.hfv.bTT().nW(bTZ);
                    if (!TextUtils.isEmpty(nW2) && !nW2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aho == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = ao.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(nW2.substring(nW2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, nW2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (nW != null && nW.length() > 3) {
                    linearLayout3.setContentDescription(nW.substring(2, nW.length() - 1));
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
            if (EmotionTabContentView.this.hfn == null) {
                return 0;
            }
            return EmotionTabContentView.this.hfn.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.hft.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.hft.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.hfn != null && i < EmotionTabContentView.this.hfn.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hfn.get(i);
                gridView2.setNumColumns(bVar.bTV());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bTQ() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bTQ = aVar.bTQ();
                        if (bTQ.bTU() == EmotionGroupType.BIG_EMOTION || bTQ.bTU() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.ZS != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bTQ() != null) {
                                com.baidu.tieba.emotion.editortool.b bTQ = aVar.bTQ();
                                int bTP = aVar.bTP();
                                com.baidu.tbadk.editortools.emotiontool.c bTT = bTQ.bTT();
                                String nW = bTQ.bTT().nW(bTP + i2);
                                if (bTT.bja() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(nW)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(nW);
                                qVar.a(bTT.bja());
                                qVar.yE(bTT.getGroupName());
                                qVar.setPid(bTT.getGroupId());
                                qVar.setWidth(bTT.getWidth());
                                qVar.setHeight(bTT.getHeight());
                                EmotionTabContentView.this.ZS.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.hfn != null) {
                int size = EmotionTabContentView.this.hfn.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Yz) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hfn.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Yz = i;
                        EmotionTabContentView.this.eod.setVisibility(bVar.bTW() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eod.setCount(bVar.bTW());
                        EmotionTabContentView.this.eod.setPosition(bVar.bTX());
                        EmotionTabContentView.this.eod.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bTX() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bTW())));
                    }
                    if (bVar != null && bVar.bUa() != EmotionTabContentView.this.hfp) {
                        EmotionTabContentView.this.hfp = bVar.bUa();
                        if (EmotionTabContentView.this.hfq != null) {
                            EmotionTabContentView.this.hfq.tw(bVar.bUa());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.hfq = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dLt);
    }
}
