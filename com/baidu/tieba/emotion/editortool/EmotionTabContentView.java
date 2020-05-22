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
    private int Yf;
    private EditorTools Zt;
    private int agt;
    private IndicatorView dZi;
    private CustomMessageListener dzd;
    private List<com.baidu.tbadk.editortools.emotiontool.c> gMA;
    private List<com.baidu.tieba.emotion.editortool.b> gMB;
    private int gMC;
    private int gMD;
    private b gME;
    private int gMF;
    private final Point gMG;
    private com.baidu.adp.lib.d.b<GridView> gMH;
    private EmotionViewPagerAdapter gMo;
    private GridView gMp;
    private LinearLayout gMq;
    private WindowManager.LayoutParams gMr;
    private GifView gMs;
    private ViewGroup gMt;
    private int gMu;
    private int gMv;
    private int gMw;
    private boolean gMx;
    private int gMy;
    private com.baidu.tieba.emotion.editortool.b gMz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void sB(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.gMy = -1;
        this.gMC = 0;
        this.gMD = -1;
        this.Yf = -1;
        this.gMG = new Point();
        this.dzd = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bP(new ArrayList(EmotionTabContentView.this.gMA));
                        if (EmotionTabContentView.this.gMo != null) {
                            EmotionTabContentView.this.gMo.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gMD < 0 || EmotionTabContentView.this.gMD >= EmotionTabContentView.this.gMA.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gMA.get(EmotionTabContentView.this.gMD)).bdl() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gMo != null) {
                                if (EmotionTabContentView.this.Yf >= 0 && EmotionTabContentView.this.Yf < EmotionTabContentView.this.gMB.size()) {
                                    EmotionTabContentView.this.gMz = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMB.get(EmotionTabContentView.this.Yf);
                                    int bND = EmotionTabContentView.this.gMz.bND();
                                    EmotionTabContentView.this.dZi.setCount(bND);
                                    EmotionTabContentView.this.dZi.setVisibility(bND > 1 ? 0 : 4);
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
                                                    int index = aVar.bNx().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gMB.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMB.get(index));
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
        this.gMy = -1;
        this.gMC = 0;
        this.gMD = -1;
        this.Yf = -1;
        this.gMG = new Point();
        this.dzd = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bP(new ArrayList(EmotionTabContentView.this.gMA));
                        if (EmotionTabContentView.this.gMo != null) {
                            EmotionTabContentView.this.gMo.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gMD < 0 || EmotionTabContentView.this.gMD >= EmotionTabContentView.this.gMA.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gMA.get(EmotionTabContentView.this.gMD)).bdl() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gMo != null) {
                                if (EmotionTabContentView.this.Yf >= 0 && EmotionTabContentView.this.Yf < EmotionTabContentView.this.gMB.size()) {
                                    EmotionTabContentView.this.gMz = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMB.get(EmotionTabContentView.this.Yf);
                                    int bND = EmotionTabContentView.this.gMz.bND();
                                    EmotionTabContentView.this.dZi.setCount(bND);
                                    EmotionTabContentView.this.dZi.setVisibility(bND > 1 ? 0 : 4);
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
                                                    int index = aVar.bNx().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gMB.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMB.get(index));
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
        this.gMA = new ArrayList();
        this.gMB = new ArrayList();
        this.gMH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bNv */
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
        this.gMs = new GifView(context);
        am.setBackgroundResource(this.gMs, R.drawable.bg_expression_bubble, this.agt);
        this.gMs.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.gMr = new WindowManager.LayoutParams();
        this.gMu = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.gMv = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.gMw = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.gMr.width = this.gMu;
        this.gMr.height = this.gMv;
        this.gMr.gravity = 51;
        this.gMr.format = -3;
        this.gMr.type = 1000;
        this.gMr.flags |= 56;
        this.gMt = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dZi = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.gMq = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.gMq.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.gMr.type = 1000;
            this.gMr.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.gMA.clear();
        this.gMB.clear();
        if (list != null && !list.isEmpty()) {
            this.gMA.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bdo = cVar.bdo();
                    int bdp = cVar.bdp();
                    int i4 = emotionsCount / (bdo * bdp);
                    if (emotionsCount % (bdo * bdp) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bdo * bdp;
                        } else {
                            i = emotionsCount - ((bdo * bdp) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.sH(i3);
                        bVar.b(cVar.bdl());
                        bVar.no(bdp);
                        bVar.setColumn(bdo);
                        bVar.sC(i4);
                        bVar.sD(i5);
                        bVar.sE(i);
                        bVar.sF(i5 * bdo * bdp);
                        bVar.sG((i + i2) - 1);
                        this.gMB.add(bVar);
                    }
                }
            }
            this.gMC = this.gMB.size();
            for (int i6 = 0; i6 < this.gMC; i6++) {
                if (this.gMB != null && this.gMB.get(i6) != null) {
                    this.gMB.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void sz(int i) {
        if (this.gMB != null) {
            int size = this.gMB.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.gMB.get(i2);
                    if (bVar != null && bVar.bNH() == i) {
                        this.gMF = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void h(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                bP(list);
                sz(i);
                this.gMo = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.gMo);
                this.mViewPager.setCurrentItem(this.gMF, true);
                if (this.gME != null) {
                    this.gME.sB(i);
                    this.gMD = i;
                }
            }
        }
    }

    public void sA(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.gMB.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.gMB.get(i3);
                        if (bVar == null || bVar.bNH() != i) {
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
        if (this.gMy != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bNx() != null) {
            com.baidu.tieba.emotion.editortool.b bNx = aVar.bNx();
            String ni = bNx.bNA().ni(aVar.bNw() + i);
            if (bNx.bNB() != EmotionGroupType.USER_COLLECT || !ni.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.gMs.setTag(ni);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ni;
                if (ni.startsWith("#(meme,")) {
                    this.gMs.setShowStaticDrawable(false);
                } else {
                    this.gMs.setShowStaticDrawable(true);
                }
                this.gMs.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.gMt.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.gMr.x = this.rect.left - ((this.gMr.width - linearLayout.getWidth()) / 2);
                this.gMr.y = (this.rect.top - this.gMr.height) + this.gMw;
                this.gMs.setVisibility(0);
                if (!this.gMx) {
                    this.mWindowManager.addView(this.gMs, this.gMr);
                    this.gMx = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.gMs, this.gMr);
                }
                gridView.setSelection(i);
                if (this.gMy != -1) {
                    ((LinearLayout) gridView.getChildAt(this.gMy - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.gMy = i;
                this.gMp = gridView;
            }
        }
    }

    private void onUp() {
        if (this.gMx && this.gMs.getVisibility() != 8 && this.gMp != null) {
            this.gMp.setSelection(-1);
            this.gMs.setVisibility(8);
            if (this.gMy != -1) {
                ((LinearLayout) this.gMp.getChildAt(this.gMy - this.gMp.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.gMy = -1;
            this.gMp = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.gMG.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.gMG.set(x, y);
                if (this.gMx && this.gMs.getVisibility() != 8 && this.gMp != null) {
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
                this.gMG.set(x, y);
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
                    if (this.gMp != null) {
                        offsetRectIntoDescendantCoords(this.gMp, this.rect);
                        int pointToPosition = this.gMp.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.gMp);
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
        if (this.gMx) {
            this.mWindowManager.removeView(this.gMs);
            this.gMx = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dzd);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gMB != null) {
            int size = this.gMB.size();
            if (i >= 0 && i < size) {
                this.gMz = this.gMB.get(i);
                if (this.dZi != null && this.gMz != null) {
                    if (this.Yf != i) {
                        this.Yf = i;
                        this.dZi.setVisibility(this.gMz.bND() > 1 ? 0 : 4);
                        this.dZi.setCount(this.gMz.bND());
                        if (this.gMz != null && this.gMz.bNH() != this.gMD) {
                            this.gMD = this.gMz.bNH();
                            if (this.gME != null) {
                                this.gME.sB(this.gMz.bNH());
                            }
                        }
                    }
                    float bNE = this.gMz.bNE() + f;
                    this.dZi.setPosition(bNE);
                    this.gMq.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bNE) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.gMz.bND())));
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
        this.agt = i;
        am.setBackgroundResource(this.gMs, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dZi.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dZi.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b gMJ;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gMJ = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gMJ = bVar;
        }

        public int bNw() {
            if (this.gMJ == null) {
                return 0;
            }
            return this.gMJ.bNG();
        }

        public com.baidu.tieba.emotion.editortool.b bNx() {
            return this.gMJ;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gMJ == null) {
                return 0;
            }
            return this.gMJ.bNF();
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
                if (this.gMJ.bNC() != 0) {
                    i2 = measuredWidth / this.gMJ.bNC();
                }
                if (this.gMJ.getRow() != 0) {
                    i3 = measuredHeight / this.gMJ.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.gMw * 2, EmotionTabContentView.this.gMw * 2, EmotionTabContentView.this.gMw * 2, EmotionTabContentView.this.gMw * 2);
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
            if (this.gMJ != null) {
                int bNG = this.gMJ.bNG() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.agt);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ni = this.gMJ.bNA().ni(bNG);
                tbImageView.setTag(ni);
                if (!TextUtils.isEmpty(ni)) {
                    Object a = com.baidu.adp.lib.e.c.kX().a(ni, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, ni, false, null);
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
                if (this.gMJ.bNB() == EmotionGroupType.BIG_EMOTION) {
                    String ni2 = this.gMJ.bNA().ni(bNG);
                    if (!TextUtils.isEmpty(ni2) && !ni2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.agt == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ni2.substring(ni2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, ni2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ni != null && ni.length() > 3) {
                    linearLayout3.setContentDescription(ni.substring(2, ni.length() - 1));
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
            if (EmotionTabContentView.this.gMB == null) {
                return 0;
            }
            return EmotionTabContentView.this.gMB.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.gMH.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.gMH.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.gMB != null && i < EmotionTabContentView.this.gMB.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMB.get(i);
                gridView2.setNumColumns(bVar.bNC());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bNx() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bNx = aVar.bNx();
                        if (bNx.bNB() == EmotionGroupType.BIG_EMOTION || bNx.bNB() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Zt != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bNx() != null) {
                                com.baidu.tieba.emotion.editortool.b bNx = aVar.bNx();
                                int bNw = aVar.bNw();
                                com.baidu.tbadk.editortools.emotiontool.c bNA = bNx.bNA();
                                String ni = bNx.bNA().ni(bNw + i2);
                                if (bNA.bdl() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(ni)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(ni);
                                qVar.a(bNA.bdl());
                                qVar.xg(bNA.getGroupName());
                                qVar.setPid(bNA.getGroupId());
                                qVar.setWidth(bNA.getWidth());
                                qVar.setHeight(bNA.getHeight());
                                EmotionTabContentView.this.Zt.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.gMB != null) {
                int size = EmotionTabContentView.this.gMB.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Yf) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMB.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Yf = i;
                        EmotionTabContentView.this.dZi.setVisibility(bVar.bND() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dZi.setCount(bVar.bND());
                        EmotionTabContentView.this.dZi.setPosition(bVar.bNE());
                        EmotionTabContentView.this.dZi.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bNE() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bND())));
                    }
                    if (bVar != null && bVar.bNH() != EmotionTabContentView.this.gMD) {
                        EmotionTabContentView.this.gMD = bVar.bNH();
                        if (EmotionTabContentView.this.gME != null) {
                            EmotionTabContentView.this.gME.sB(bVar.bNH());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.gME = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dzd);
    }
}
