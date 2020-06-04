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
    private GridView gMA;
    private LinearLayout gMB;
    private WindowManager.LayoutParams gMC;
    private GifView gMD;
    private ViewGroup gME;
    private int gMF;
    private int gMG;
    private int gMH;
    private boolean gMI;
    private int gMJ;
    private com.baidu.tieba.emotion.editortool.b gMK;
    private List<com.baidu.tbadk.editortools.emotiontool.c> gML;
    private List<com.baidu.tieba.emotion.editortool.b> gMM;
    private int gMN;
    private int gMO;
    private b gMP;
    private int gMQ;
    private final Point gMR;
    private com.baidu.adp.lib.d.b<GridView> gMS;
    private EmotionViewPagerAdapter gMz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void sD(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.gMJ = -1;
        this.gMN = 0;
        this.gMO = -1;
        this.Yf = -1;
        this.gMR = new Point();
        this.dzd = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bP(new ArrayList(EmotionTabContentView.this.gML));
                        if (EmotionTabContentView.this.gMz != null) {
                            EmotionTabContentView.this.gMz.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gMO < 0 || EmotionTabContentView.this.gMO >= EmotionTabContentView.this.gML.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gML.get(EmotionTabContentView.this.gMO)).bdm() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gMz != null) {
                                if (EmotionTabContentView.this.Yf >= 0 && EmotionTabContentView.this.Yf < EmotionTabContentView.this.gMM.size()) {
                                    EmotionTabContentView.this.gMK = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMM.get(EmotionTabContentView.this.Yf);
                                    int bNF = EmotionTabContentView.this.gMK.bNF();
                                    EmotionTabContentView.this.dZi.setCount(bNF);
                                    EmotionTabContentView.this.dZi.setVisibility(bNF > 1 ? 0 : 4);
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
                                                    int index = aVar.bNz().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gMM.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMM.get(index));
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
        this.gMJ = -1;
        this.gMN = 0;
        this.gMO = -1;
        this.Yf = -1;
        this.gMR = new Point();
        this.dzd = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bP(new ArrayList(EmotionTabContentView.this.gML));
                        if (EmotionTabContentView.this.gMz != null) {
                            EmotionTabContentView.this.gMz.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gMO < 0 || EmotionTabContentView.this.gMO >= EmotionTabContentView.this.gML.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gML.get(EmotionTabContentView.this.gMO)).bdm() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gMz != null) {
                                if (EmotionTabContentView.this.Yf >= 0 && EmotionTabContentView.this.Yf < EmotionTabContentView.this.gMM.size()) {
                                    EmotionTabContentView.this.gMK = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMM.get(EmotionTabContentView.this.Yf);
                                    int bNF = EmotionTabContentView.this.gMK.bNF();
                                    EmotionTabContentView.this.dZi.setCount(bNF);
                                    EmotionTabContentView.this.dZi.setVisibility(bNF > 1 ? 0 : 4);
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
                                                    int index = aVar.bNz().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gMM.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMM.get(index));
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
        this.gML = new ArrayList();
        this.gMM = new ArrayList();
        this.gMS = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bNx */
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
        this.gMD = new GifView(context);
        am.setBackgroundResource(this.gMD, R.drawable.bg_expression_bubble, this.agt);
        this.gMD.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.gMC = new WindowManager.LayoutParams();
        this.gMF = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.gMG = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.gMH = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.gMC.width = this.gMF;
        this.gMC.height = this.gMG;
        this.gMC.gravity = 51;
        this.gMC.format = -3;
        this.gMC.type = 1000;
        this.gMC.flags |= 56;
        this.gME = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dZi = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.gMB = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.gMB.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.gMC.type = 1000;
            this.gMC.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.gML.clear();
        this.gMM.clear();
        if (list != null && !list.isEmpty()) {
            this.gML.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bdp = cVar.bdp();
                    int bdq = cVar.bdq();
                    int i4 = emotionsCount / (bdp * bdq);
                    if (emotionsCount % (bdp * bdq) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bdp * bdq;
                        } else {
                            i = emotionsCount - ((bdp * bdq) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.sJ(i3);
                        bVar.b(cVar.bdm());
                        bVar.nq(bdq);
                        bVar.setColumn(bdp);
                        bVar.sE(i4);
                        bVar.sF(i5);
                        bVar.sG(i);
                        bVar.sH(i5 * bdp * bdq);
                        bVar.sI((i + i2) - 1);
                        this.gMM.add(bVar);
                    }
                }
            }
            this.gMN = this.gMM.size();
            for (int i6 = 0; i6 < this.gMN; i6++) {
                if (this.gMM != null && this.gMM.get(i6) != null) {
                    this.gMM.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void sB(int i) {
        if (this.gMM != null) {
            int size = this.gMM.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.gMM.get(i2);
                    if (bVar != null && bVar.bNJ() == i) {
                        this.gMQ = bVar.getIndex();
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
                sB(i);
                this.gMz = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.gMz);
                this.mViewPager.setCurrentItem(this.gMQ, true);
                if (this.gMP != null) {
                    this.gMP.sD(i);
                    this.gMO = i;
                }
            }
        }
    }

    public void sC(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.gMM.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.gMM.get(i3);
                        if (bVar == null || bVar.bNJ() != i) {
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
        if (this.gMJ != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bNz() != null) {
            com.baidu.tieba.emotion.editortool.b bNz = aVar.bNz();
            String nk = bNz.bNC().nk(aVar.bNy() + i);
            if (bNz.bND() != EmotionGroupType.USER_COLLECT || !nk.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.gMD.setTag(nk);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = nk;
                if (nk.startsWith("#(meme,")) {
                    this.gMD.setShowStaticDrawable(false);
                } else {
                    this.gMD.setShowStaticDrawable(true);
                }
                this.gMD.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.gME.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.gMC.x = this.rect.left - ((this.gMC.width - linearLayout.getWidth()) / 2);
                this.gMC.y = (this.rect.top - this.gMC.height) + this.gMH;
                this.gMD.setVisibility(0);
                if (!this.gMI) {
                    this.mWindowManager.addView(this.gMD, this.gMC);
                    this.gMI = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.gMD, this.gMC);
                }
                gridView.setSelection(i);
                if (this.gMJ != -1) {
                    ((LinearLayout) gridView.getChildAt(this.gMJ - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.gMJ = i;
                this.gMA = gridView;
            }
        }
    }

    private void onUp() {
        if (this.gMI && this.gMD.getVisibility() != 8 && this.gMA != null) {
            this.gMA.setSelection(-1);
            this.gMD.setVisibility(8);
            if (this.gMJ != -1) {
                ((LinearLayout) this.gMA.getChildAt(this.gMJ - this.gMA.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.gMJ = -1;
            this.gMA = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.gMR.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.gMR.set(x, y);
                if (this.gMI && this.gMD.getVisibility() != 8 && this.gMA != null) {
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
                this.gMR.set(x, y);
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
                    if (this.gMA != null) {
                        offsetRectIntoDescendantCoords(this.gMA, this.rect);
                        int pointToPosition = this.gMA.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.gMA);
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
        if (this.gMI) {
            this.mWindowManager.removeView(this.gMD);
            this.gMI = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dzd);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gMM != null) {
            int size = this.gMM.size();
            if (i >= 0 && i < size) {
                this.gMK = this.gMM.get(i);
                if (this.dZi != null && this.gMK != null) {
                    if (this.Yf != i) {
                        this.Yf = i;
                        this.dZi.setVisibility(this.gMK.bNF() > 1 ? 0 : 4);
                        this.dZi.setCount(this.gMK.bNF());
                        if (this.gMK != null && this.gMK.bNJ() != this.gMO) {
                            this.gMO = this.gMK.bNJ();
                            if (this.gMP != null) {
                                this.gMP.sD(this.gMK.bNJ());
                            }
                        }
                    }
                    float bNG = this.gMK.bNG() + f;
                    this.dZi.setPosition(bNG);
                    this.gMB.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bNG) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.gMK.bNF())));
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
        am.setBackgroundResource(this.gMD, R.drawable.bg_expression_bubble, i);
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
        private com.baidu.tieba.emotion.editortool.b gMU;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gMU = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gMU = bVar;
        }

        public int bNy() {
            if (this.gMU == null) {
                return 0;
            }
            return this.gMU.bNI();
        }

        public com.baidu.tieba.emotion.editortool.b bNz() {
            return this.gMU;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gMU == null) {
                return 0;
            }
            return this.gMU.bNH();
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
                if (this.gMU.bNE() != 0) {
                    i2 = measuredWidth / this.gMU.bNE();
                }
                if (this.gMU.getRow() != 0) {
                    i3 = measuredHeight / this.gMU.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.gMH * 2, EmotionTabContentView.this.gMH * 2, EmotionTabContentView.this.gMH * 2, EmotionTabContentView.this.gMH * 2);
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
            if (this.gMU != null) {
                int bNI = this.gMU.bNI() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.agt);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String nk = this.gMU.bNC().nk(bNI);
                tbImageView.setTag(nk);
                if (!TextUtils.isEmpty(nk)) {
                    Object a = com.baidu.adp.lib.e.c.kX().a(nk, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, nk, false, null);
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
                if (this.gMU.bND() == EmotionGroupType.BIG_EMOTION) {
                    String nk2 = this.gMU.bNC().nk(bNI);
                    if (!TextUtils.isEmpty(nk2) && !nk2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.agt == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(nk2.substring(nk2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, nk2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (nk != null && nk.length() > 3) {
                    linearLayout3.setContentDescription(nk.substring(2, nk.length() - 1));
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
            if (EmotionTabContentView.this.gMM == null) {
                return 0;
            }
            return EmotionTabContentView.this.gMM.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.gMS.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.gMS.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.gMM != null && i < EmotionTabContentView.this.gMM.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMM.get(i);
                gridView2.setNumColumns(bVar.bNE());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bNz() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bNz = aVar.bNz();
                        if (bNz.bND() == EmotionGroupType.BIG_EMOTION || bNz.bND() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.bNz() != null) {
                                com.baidu.tieba.emotion.editortool.b bNz = aVar.bNz();
                                int bNy = aVar.bNy();
                                com.baidu.tbadk.editortools.emotiontool.c bNC = bNz.bNC();
                                String nk = bNz.bNC().nk(bNy + i2);
                                if (bNC.bdm() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(nk)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(nk);
                                qVar.a(bNC.bdm());
                                qVar.xg(bNC.getGroupName());
                                qVar.setPid(bNC.getGroupId());
                                qVar.setWidth(bNC.getWidth());
                                qVar.setHeight(bNC.getHeight());
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
            if (EmotionTabContentView.this.gMM != null) {
                int size = EmotionTabContentView.this.gMM.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Yf) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gMM.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Yf = i;
                        EmotionTabContentView.this.dZi.setVisibility(bVar.bNF() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dZi.setCount(bVar.bNF());
                        EmotionTabContentView.this.dZi.setPosition(bVar.bNG());
                        EmotionTabContentView.this.dZi.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bNG() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bNF())));
                    }
                    if (bVar != null && bVar.bNJ() != EmotionTabContentView.this.gMO) {
                        EmotionTabContentView.this.gMO = bVar.bNJ();
                        if (EmotionTabContentView.this.gMP != null) {
                            EmotionTabContentView.this.gMP.sD(bVar.bNJ());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.gMP = bVar;
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
