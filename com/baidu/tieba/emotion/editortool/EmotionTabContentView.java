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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int DX;
    private EditorTools Fq;
    private int MA;
    private CustomMessageListener cHq;
    private IndicatorView dga;
    private List<com.baidu.tbadk.editortools.emotiontool.c> fMA;
    private List<com.baidu.tieba.emotion.editortool.b> fMB;
    private int fMC;
    private int fMD;
    private b fME;
    private int fMF;
    private final Point fMG;
    private com.baidu.adp.lib.d.b<GridView> fMH;
    private EmotionViewPagerAdapter fMo;
    private GridView fMp;
    private LinearLayout fMq;
    private WindowManager.LayoutParams fMr;
    private GifView fMs;
    private ViewGroup fMt;
    private int fMu;
    private int fMv;
    private int fMw;
    private boolean fMx;
    private int fMy;
    private com.baidu.tieba.emotion.editortool.b fMz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes4.dex */
    public interface b {
        void rr(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.fMy = -1;
        this.fMC = 0;
        this.fMD = -1;
        this.DX = -1;
        this.fMG = new Point();
        this.cHq = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fMA));
                        if (EmotionTabContentView.this.fMo != null) {
                            EmotionTabContentView.this.fMo.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fMD < 0 || EmotionTabContentView.this.fMD >= EmotionTabContentView.this.fMA.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fMA.get(EmotionTabContentView.this.fMD)).aLR() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fMo != null) {
                                if (EmotionTabContentView.this.DX >= 0 && EmotionTabContentView.this.DX < EmotionTabContentView.this.fMB.size()) {
                                    EmotionTabContentView.this.fMz = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fMB.get(EmotionTabContentView.this.DX);
                                    int buL = EmotionTabContentView.this.fMz.buL();
                                    EmotionTabContentView.this.dga.setCount(buL);
                                    EmotionTabContentView.this.dga.setVisibility(buL > 1 ? 0 : 4);
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
                                                    int index = aVar.buF().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fMB.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fMB.get(index));
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
        this.fMy = -1;
        this.fMC = 0;
        this.fMD = -1;
        this.DX = -1;
        this.fMG = new Point();
        this.cHq = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fMA));
                        if (EmotionTabContentView.this.fMo != null) {
                            EmotionTabContentView.this.fMo.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fMD < 0 || EmotionTabContentView.this.fMD >= EmotionTabContentView.this.fMA.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fMA.get(EmotionTabContentView.this.fMD)).aLR() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fMo != null) {
                                if (EmotionTabContentView.this.DX >= 0 && EmotionTabContentView.this.DX < EmotionTabContentView.this.fMB.size()) {
                                    EmotionTabContentView.this.fMz = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fMB.get(EmotionTabContentView.this.DX);
                                    int buL = EmotionTabContentView.this.fMz.buL();
                                    EmotionTabContentView.this.dga.setCount(buL);
                                    EmotionTabContentView.this.dga.setVisibility(buL > 1 ? 0 : 4);
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
                                                    int index = aVar.buF().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fMB.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fMB.get(index));
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
        this.fMA = new ArrayList();
        this.fMB = new ArrayList();
        this.fMH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buD */
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
        this.fMs = new GifView(context);
        am.setBackgroundResource(this.fMs, R.drawable.bg_expression_bubble, this.MA);
        this.fMs.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.fMr = new WindowManager.LayoutParams();
        this.fMu = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.fMv = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.fMw = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fMr.width = this.fMu;
        this.fMr.height = this.fMv;
        this.fMr.gravity = 51;
        this.fMr.format = -3;
        this.fMr.type = 1000;
        this.fMr.flags |= 56;
        this.fMt = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dga = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.fMq = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.fMq.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.fMr.type = 1000;
            this.fMr.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.fMA.clear();
        this.fMB.clear();
        if (list != null && !list.isEmpty()) {
            this.fMA.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aLU = cVar.aLU();
                    int aLV = cVar.aLV();
                    int i4 = emotionsCount / (aLU * aLV);
                    if (emotionsCount % (aLU * aLV) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aLU * aLV;
                        } else {
                            i = emotionsCount - ((aLU * aLV) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.rx(i3);
                        bVar.b(cVar.aLR());
                        bVar.mh(aLV);
                        bVar.mg(aLU);
                        bVar.rs(i4);
                        bVar.rt(i5);
                        bVar.ru(i);
                        bVar.rv(i5 * aLU * aLV);
                        bVar.rw((i + i2) - 1);
                        this.fMB.add(bVar);
                    }
                }
            }
            this.fMC = this.fMB.size();
            for (int i6 = 0; i6 < this.fMC; i6++) {
                if (this.fMB != null && this.fMB.get(i6) != null) {
                    this.fMB.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rp(int i) {
        if (this.fMB != null) {
            int size = this.fMB.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.fMB.get(i2);
                    if (bVar != null && bVar.buP() == i) {
                        this.fMF = bVar.getIndex();
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
                rp(i);
                this.fMo = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.fMo);
                this.mViewPager.setCurrentItem(this.fMF, true);
                if (this.fME != null) {
                    this.fME.rr(i);
                    this.fMD = i;
                }
            }
        }
    }

    public void rq(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.fMB.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.fMB.get(i3);
                        if (bVar == null || bVar.buP() != i) {
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
        if (this.fMy != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.buF() != null) {
            com.baidu.tieba.emotion.editortool.b buF = aVar.buF();
            String ma = buF.buI().ma(aVar.buE() + i);
            if (buF.buJ() != EmotionGroupType.USER_COLLECT || !ma.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.fMs.setTag(ma);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ma;
                if (ma.startsWith("#(meme,")) {
                    this.fMs.setShowStaticDrawable(false);
                } else {
                    this.fMs.setShowStaticDrawable(true);
                }
                this.fMs.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.fMt.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.fMr.x = this.rect.left - ((this.fMr.width - linearLayout.getWidth()) / 2);
                this.fMr.y = (this.rect.top - this.fMr.height) + this.fMw;
                this.fMs.setVisibility(0);
                if (!this.fMx) {
                    this.mWindowManager.addView(this.fMs, this.fMr);
                    this.fMx = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.fMs, this.fMr);
                }
                gridView.setSelection(i);
                if (this.fMy != -1) {
                    ((LinearLayout) gridView.getChildAt(this.fMy - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.fMy = i;
                this.fMp = gridView;
            }
        }
    }

    private void onUp() {
        if (this.fMx && this.fMs.getVisibility() != 8 && this.fMp != null) {
            this.fMp.setSelection(-1);
            this.fMs.setVisibility(8);
            if (this.fMy != -1) {
                ((LinearLayout) this.fMp.getChildAt(this.fMy - this.fMp.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.fMy = -1;
            this.fMp = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.fMG.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.fMG.set(x, y);
                if (this.fMx && this.fMs.getVisibility() != 8 && this.fMp != null) {
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
                this.fMG.set(x, y);
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
                    if (this.fMp != null) {
                        offsetRectIntoDescendantCoords(this.fMp, this.rect);
                        int pointToPosition = this.fMp.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.fMp);
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
        if (this.fMx) {
            this.mWindowManager.removeView(this.fMs);
            this.fMx = false;
        }
        MessageManager.getInstance().unRegisterListener(this.cHq);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fMB != null) {
            int size = this.fMB.size();
            if (i >= 0 && i < size) {
                this.fMz = this.fMB.get(i);
                if (this.dga != null && this.fMz != null) {
                    if (this.DX != i) {
                        this.DX = i;
                        this.dga.setVisibility(this.fMz.buL() > 1 ? 0 : 4);
                        this.dga.setCount(this.fMz.buL());
                        if (this.fMz != null && this.fMz.buP() != this.fMD) {
                            this.fMD = this.fMz.buP();
                            if (this.fME != null) {
                                this.fME.rr(this.fMz.buP());
                            }
                        }
                    }
                    float buM = this.fMz.buM() + f;
                    this.dga.setPosition(buM);
                    this.fMq.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) buM) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.fMz.buL())));
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
        this.MA = i;
        am.setBackgroundResource(this.fMs, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dga.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dga.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b fMJ;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fMJ = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fMJ = bVar;
        }

        public int buE() {
            if (this.fMJ == null) {
                return 0;
            }
            return this.fMJ.buO();
        }

        public com.baidu.tieba.emotion.editortool.b buF() {
            return this.fMJ;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fMJ == null) {
                return 0;
            }
            return this.fMJ.buN();
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
                if (this.fMJ.buK() != 0) {
                    i2 = measuredWidth / this.fMJ.buK();
                }
                if (this.fMJ.getRow() != 0) {
                    i3 = measuredHeight / this.fMJ.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.fMw * 2, EmotionTabContentView.this.fMw * 2, EmotionTabContentView.this.fMw * 2, EmotionTabContentView.this.fMw * 2);
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
            if (this.fMJ != null) {
                int buO = this.fMJ.buO() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.MA);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ma = this.fMJ.buI().ma(buO);
                tbImageView.setTag(ma);
                if (!TextUtils.isEmpty(ma)) {
                    Object a = com.baidu.adp.lib.e.c.gs().a(ma, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, ma, false, null);
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
                if (this.fMJ.buJ() == EmotionGroupType.BIG_EMOTION) {
                    String ma2 = this.fMJ.buI().ma(buO);
                    if (!TextUtils.isEmpty(ma2) && !ma2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.MA == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ma2.substring(ma2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, ma2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ma != null && ma.length() > 3) {
                    linearLayout3.setContentDescription(ma.substring(2, ma.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes4.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.fMB == null) {
                return 0;
            }
            return EmotionTabContentView.this.fMB.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.fMH.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.fMH.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.fMB != null && i < EmotionTabContentView.this.fMB.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fMB.get(i);
                gridView2.setNumColumns(bVar.buK());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.buF() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b buF = aVar.buF();
                        if (buF.buJ() == EmotionGroupType.BIG_EMOTION || buF.buJ() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Fq != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.buF() != null) {
                                com.baidu.tieba.emotion.editortool.b buF = aVar.buF();
                                int buE = aVar.buE();
                                com.baidu.tbadk.editortools.emotiontool.c buI = buF.buI();
                                String ma = buF.buI().ma(buE + i2);
                                if (buI.aLR() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(ma)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(ma);
                                pVar.a(buI.aLR());
                                pVar.tN(buI.getGroupName());
                                pVar.setPid(buI.getGroupId());
                                pVar.setWidth(buI.getWidth());
                                pVar.setHeight(buI.getHeight());
                                EmotionTabContentView.this.Fq.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.fMB != null) {
                int size = EmotionTabContentView.this.fMB.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.DX) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fMB.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.DX = i;
                        EmotionTabContentView.this.dga.setVisibility(bVar.buL() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dga.setCount(bVar.buL());
                        EmotionTabContentView.this.dga.setPosition(bVar.buM());
                        EmotionTabContentView.this.dga.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.buM() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.buL())));
                    }
                    if (bVar != null && bVar.buP() != EmotionTabContentView.this.fMD) {
                        EmotionTabContentView.this.fMD = bVar.buP();
                        if (EmotionTabContentView.this.fME != null) {
                            EmotionTabContentView.this.fME.rr(bVar.buP());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.fME = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cHq);
    }
}
