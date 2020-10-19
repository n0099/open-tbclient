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
    private int ZP;
    private EditorTools abj;
    private int ajp;
    private final Rect bvm;
    private IndicatorView eMF;
    private CustomMessageListener eiR;
    private EmotionViewPagerAdapter hNZ;
    private GridView hOa;
    private LinearLayout hOb;
    private WindowManager.LayoutParams hOc;
    private GifView hOd;
    private ViewGroup hOe;
    private int hOf;
    private int hOg;
    private int hOh;
    private boolean hOi;
    private int hOj;
    private com.baidu.tieba.emotion.editortool.b hOk;
    private List<com.baidu.tbadk.editortools.emotiontool.c> hOl;
    private List<com.baidu.tieba.emotion.editortool.b> hOm;
    private int hOn;
    private int hOo;
    private b hOp;
    private int hOq;
    private final Point hOr;
    private com.baidu.adp.lib.d.b<GridView> hOs;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes13.dex */
    public interface b {
        void wQ(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvm = new Rect();
        this.hOj = -1;
        this.hOn = 0;
        this.hOo = -1;
        this.ZP = -1;
        this.hOr = new Point();
        this.eiR = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cq(new ArrayList(EmotionTabContentView.this.hOl));
                        if (EmotionTabContentView.this.hNZ != null) {
                            EmotionTabContentView.this.hNZ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hOo < 0 || EmotionTabContentView.this.hOo >= EmotionTabContentView.this.hOl.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hOl.get(EmotionTabContentView.this.hOo)).bvz() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hNZ != null) {
                                if (EmotionTabContentView.this.ZP >= 0 && EmotionTabContentView.this.ZP < EmotionTabContentView.this.hOm.size()) {
                                    EmotionTabContentView.this.hOk = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hOm.get(EmotionTabContentView.this.ZP);
                                    int ckU = EmotionTabContentView.this.hOk.ckU();
                                    EmotionTabContentView.this.eMF.setCount(ckU);
                                    EmotionTabContentView.this.eMF.setVisibility(ckU > 1 ? 0 : 4);
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
                                                    int index = aVar.ckO().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hOm.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hOm.get(index));
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
        this.bvm = new Rect();
        this.hOj = -1;
        this.hOn = 0;
        this.hOo = -1;
        this.ZP = -1;
        this.hOr = new Point();
        this.eiR = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cq(new ArrayList(EmotionTabContentView.this.hOl));
                        if (EmotionTabContentView.this.hNZ != null) {
                            EmotionTabContentView.this.hNZ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hOo < 0 || EmotionTabContentView.this.hOo >= EmotionTabContentView.this.hOl.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hOl.get(EmotionTabContentView.this.hOo)).bvz() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hNZ != null) {
                                if (EmotionTabContentView.this.ZP >= 0 && EmotionTabContentView.this.ZP < EmotionTabContentView.this.hOm.size()) {
                                    EmotionTabContentView.this.hOk = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hOm.get(EmotionTabContentView.this.ZP);
                                    int ckU = EmotionTabContentView.this.hOk.ckU();
                                    EmotionTabContentView.this.eMF.setCount(ckU);
                                    EmotionTabContentView.this.eMF.setVisibility(ckU > 1 ? 0 : 4);
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
                                                    int index = aVar.ckO().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hOm.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hOm.get(index));
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
        this.hOl = new ArrayList();
        this.hOm = new ArrayList();
        this.hOs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ckM */
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
        this.hOd = new GifView(context);
        ap.setBackgroundResource(this.hOd, R.drawable.bg_expression_bubble, this.ajp);
        this.hOd.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.hOc = new WindowManager.LayoutParams();
        this.hOf = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.hOg = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.hOh = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.hOc.width = this.hOf;
        this.hOc.height = this.hOg;
        this.hOc.gravity = 51;
        this.hOc.format = -3;
        this.hOc.type = 1000;
        this.hOc.flags |= 56;
        this.hOe = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eMF = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.hOb = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.hOb.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.hOc.type = 1000;
            this.hOc.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.hOl.clear();
        this.hOm.clear();
        if (list != null && !list.isEmpty()) {
            this.hOl.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bvC = cVar.bvC();
                    int bvD = cVar.bvD();
                    int i4 = emotionsCount / (bvC * bvD);
                    if (emotionsCount % (bvC * bvD) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bvC * bvD;
                        } else {
                            i = emotionsCount - ((bvC * bvD) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.wW(i3);
                        bVar.b(cVar.bvz());
                        bVar.rc(bvD);
                        bVar.setColumn(bvC);
                        bVar.wR(i4);
                        bVar.wS(i5);
                        bVar.wT(i);
                        bVar.wU(i5 * bvC * bvD);
                        bVar.wV((i + i2) - 1);
                        this.hOm.add(bVar);
                    }
                }
            }
            this.hOn = this.hOm.size();
            for (int i6 = 0; i6 < this.hOn; i6++) {
                if (this.hOm != null && this.hOm.get(i6) != null) {
                    this.hOm.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void wO(int i) {
        if (this.hOm != null) {
            int size = this.hOm.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.hOm.get(i2);
                    if (bVar != null && bVar.ckY() == i) {
                        this.hOq = bVar.getIndex();
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
                cq(list);
                wO(i);
                this.hNZ = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.hNZ);
                this.mViewPager.setCurrentItem(this.hOq, true);
                if (this.hOp != null) {
                    this.hOp.wQ(i);
                    this.hOo = i;
                }
            }
        }
    }

    public void wP(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.hOm.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.hOm.get(i3);
                        if (bVar == null || bVar.ckY() != i) {
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
        if (this.hOj != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.ckO() != null) {
            com.baidu.tieba.emotion.editortool.b ckO = aVar.ckO();
            String qS = ckO.ckR().qS(aVar.ckN() + i);
            if (ckO.ckS() != EmotionGroupType.USER_COLLECT || !qS.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.hOd.setTag(qS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qS;
                if (qS.startsWith("#(meme,")) {
                    this.hOd.setShowStaticDrawable(false);
                } else {
                    this.hOd.setShowStaticDrawable(true);
                }
                this.hOd.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bvm);
                this.hOe.offsetDescendantRectToMyCoords(linearLayout, this.bvm);
                this.hOc.x = this.bvm.left - ((this.hOc.width - linearLayout.getWidth()) / 2);
                this.hOc.y = (this.bvm.top - this.hOc.height) + this.hOh;
                this.hOd.setVisibility(0);
                if (!this.hOi) {
                    this.mWindowManager.addView(this.hOd, this.hOc);
                    this.hOi = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.hOd, this.hOc);
                }
                gridView.setSelection(i);
                if (this.hOj != -1) {
                    ((LinearLayout) gridView.getChildAt(this.hOj - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.hOj = i;
                this.hOa = gridView;
            }
        }
    }

    private void onUp() {
        if (this.hOi && this.hOd.getVisibility() != 8 && this.hOa != null) {
            this.hOa.setSelection(-1);
            this.hOd.setVisibility(8);
            if (this.hOj != -1) {
                ((LinearLayout) this.hOa.getChildAt(this.hOj - this.hOa.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.hOj = -1;
            this.hOa = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.hOr.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.hOr.set(x, y);
                if (this.hOi && this.hOd.getVisibility() != 8 && this.hOa != null) {
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
                this.hOr.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.bvm);
                if (!this.bvm.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.bvm.set(x, y, x + 1, y + 1);
                    if (this.hOa != null) {
                        offsetRectIntoDescendantCoords(this.hOa, this.bvm);
                        int pointToPosition = this.hOa.pointToPosition(this.bvm.left, this.bvm.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.hOa);
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
        if (this.hOi) {
            this.mWindowManager.removeView(this.hOd);
            this.hOi = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eiR);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hOm != null) {
            int size = this.hOm.size();
            if (i >= 0 && i < size) {
                this.hOk = this.hOm.get(i);
                if (this.eMF != null && this.hOk != null) {
                    if (this.ZP != i) {
                        this.ZP = i;
                        this.eMF.setVisibility(this.hOk.ckU() > 1 ? 0 : 4);
                        this.eMF.setCount(this.hOk.ckU());
                        if (this.hOk != null && this.hOk.ckY() != this.hOo) {
                            this.hOo = this.hOk.ckY();
                            if (this.hOp != null) {
                                this.hOp.wQ(this.hOk.ckY());
                            }
                        }
                    }
                    float ckV = this.hOk.ckV() + f;
                    this.eMF.setPosition(ckV);
                    this.hOb.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) ckV) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.hOk.ckU())));
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
        this.ajp = i;
        ap.setBackgroundResource(this.hOd, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.eMF.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eMF.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b hOu;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hOu = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hOu = bVar;
        }

        public int ckN() {
            if (this.hOu == null) {
                return 0;
            }
            return this.hOu.ckX();
        }

        public com.baidu.tieba.emotion.editortool.b ckO() {
            return this.hOu;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.hOu == null) {
                return 0;
            }
            return this.hOu.ckW();
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
                if (this.hOu.ckT() != 0) {
                    i2 = measuredWidth / this.hOu.ckT();
                }
                if (this.hOu.getRow() != 0) {
                    i3 = measuredHeight / this.hOu.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.hOh * 2, EmotionTabContentView.this.hOh * 2, EmotionTabContentView.this.hOh * 2, EmotionTabContentView.this.hOh * 2);
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
            if (this.hOu != null) {
                int ckX = this.hOu.ckX() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ajp);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qS = this.hOu.ckR().qS(ckX);
                tbImageView.setTag(qS);
                if (!TextUtils.isEmpty(qS)) {
                    Object a2 = com.baidu.adp.lib.e.c.mS().a(qS, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, qS, false, null);
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
                if (this.hOu.ckS() == EmotionGroupType.BIG_EMOTION) {
                    String qS2 = this.hOu.ckR().qS(ckX);
                    if (!TextUtils.isEmpty(qS2) && !qS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ajp == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = ap.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(qS2.substring(qS2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, qS2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (qS != null && qS.length() > 3) {
                    linearLayout3.setContentDescription(qS.substring(2, qS.length() - 1));
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
            if (EmotionTabContentView.this.hOm == null) {
                return 0;
            }
            return EmotionTabContentView.this.hOm.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.hOs.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.hOs.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.hOm != null && i < EmotionTabContentView.this.hOm.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hOm.get(i);
                gridView2.setNumColumns(bVar.ckT());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.ckO() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b ckO = aVar.ckO();
                        if (ckO.ckS() == EmotionGroupType.BIG_EMOTION || ckO.ckS() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.abj != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.ckO() != null) {
                                com.baidu.tieba.emotion.editortool.b ckO = aVar.ckO();
                                int ckN = aVar.ckN();
                                com.baidu.tbadk.editortools.emotiontool.c ckR = ckO.ckR();
                                String qS = ckO.ckR().qS(ckN + i2);
                                if (ckR.bvz() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(qS);
                                uVar.a(ckR.bvz());
                                uVar.Cd(ckR.getGroupName());
                                uVar.setPid(ckR.getGroupId());
                                uVar.setWidth(ckR.getWidth());
                                uVar.setHeight(ckR.getHeight());
                                EmotionTabContentView.this.abj.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.hOm != null) {
                int size = EmotionTabContentView.this.hOm.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.ZP) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hOm.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.ZP = i;
                        EmotionTabContentView.this.eMF.setVisibility(bVar.ckU() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eMF.setCount(bVar.ckU());
                        EmotionTabContentView.this.eMF.setPosition(bVar.ckV());
                        EmotionTabContentView.this.eMF.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.ckV() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.ckU())));
                    }
                    if (bVar != null && bVar.ckY() != EmotionTabContentView.this.hOo) {
                        EmotionTabContentView.this.hOo = bVar.ckY();
                        if (EmotionTabContentView.this.hOp != null) {
                            EmotionTabContentView.this.hOp.wQ(bVar.ckY());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.hOp = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eiR);
    }
}
