package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private i JH;
    private CustomMessageListener SH;
    private IndicatorView aDb;
    private int aoN;
    private b caF;
    private GridView caG;
    private LinearLayout caH;
    private WindowManager.LayoutParams caI;
    private GifView caJ;
    private ViewGroup caK;
    private int caL;
    private int caM;
    private int caN;
    private boolean caO;
    private int caP;
    private d caQ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> caR;
    private List<d> caS;
    private int caT;
    private int caU;
    private c caV;
    private int caW;
    private final Point caX;
    private com.baidu.adp.lib.e.b<GridView> caY;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void ip(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.caP = -1;
        this.caT = 0;
        this.caU = -1;
        this.currentPosition = -1;
        this.caX = new Point();
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.al(new ArrayList(EmotionTabContentView.this.caR));
                        if (EmotionTabContentView.this.caF != null) {
                            EmotionTabContentView.this.caF.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.caU < 0 || EmotionTabContentView.this.caU >= EmotionTabContentView.this.caR.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.caR.get(EmotionTabContentView.this.caU)).CI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caF != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.caS.size()) {
                                    EmotionTabContentView.this.caQ = (d) EmotionTabContentView.this.caS.get(EmotionTabContentView.this.currentPosition);
                                    int acm = EmotionTabContentView.this.caQ.acm();
                                    EmotionTabContentView.this.aDb.setCount(acm);
                                    EmotionTabContentView.this.aDb.setVisibility(acm > 1 ? 0 : 4);
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
                                                    int index = aVar.acg().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.caS.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.caS.get(index));
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
        this.caP = -1;
        this.caT = 0;
        this.caU = -1;
        this.currentPosition = -1;
        this.caX = new Point();
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.al(new ArrayList(EmotionTabContentView.this.caR));
                        if (EmotionTabContentView.this.caF != null) {
                            EmotionTabContentView.this.caF.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.caU < 0 || EmotionTabContentView.this.caU >= EmotionTabContentView.this.caR.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.caR.get(EmotionTabContentView.this.caU)).CI() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caF != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.caS.size()) {
                                    EmotionTabContentView.this.caQ = (d) EmotionTabContentView.this.caS.get(EmotionTabContentView.this.currentPosition);
                                    int acm = EmotionTabContentView.this.caQ.acm();
                                    EmotionTabContentView.this.aDb.setCount(acm);
                                    EmotionTabContentView.this.aDb.setVisibility(acm > 1 ? 0 : 4);
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
                                                    int index = aVar.acg().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.caS.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.caS.get(index));
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
        this.caR = new ArrayList();
        this.caS = new ArrayList();
        this.caY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ace */
            public GridView fI() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView o(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView p(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.caJ = new GifView(context);
        aj.d(this.caJ, d.g.bg_expression_bubble, this.aoN);
        this.caJ.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.caI = new WindowManager.LayoutParams();
        this.caL = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.caM = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.caN = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.caI.width = this.caL;
        this.caI.height = this.caM;
        this.caI.gravity = 51;
        this.caI.format = -3;
        this.caI.type = 1000;
        this.caI.flags |= 56;
        this.caK = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aDb = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.caH = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.caH.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.caI.type = 1000;
            this.caI.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.caR.clear();
        this.caS.clear();
        if (list != null && !list.isEmpty()) {
            this.caR.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CL = cVar.CL();
                    int i4 = emotionsCount / (cols * CL);
                    if (emotionsCount % (cols * CL) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * CL;
                        } else {
                            i = emotionsCount - ((cols * CL) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.iu(i3);
                        dVar.b(cVar.CI());
                        dVar.fb(CL);
                        dVar.fa(cols);
                        dVar.iq(i4);
                        dVar.ir(i5);
                        dVar.is(i);
                        dVar.it(i5 * cols * CL);
                        dVar.setEndIndex((i + i2) - 1);
                        this.caS.add(dVar);
                    }
                }
            }
            this.caT = this.caS.size();
            for (int i6 = 0; i6 < this.caT; i6++) {
                if (this.caS != null && this.caS.get(i6) != null) {
                    this.caS.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void in(int i) {
        if (this.caS != null) {
            int size = this.caS.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.caS.get(i2);
                    if (dVar != null && dVar.acq() == i) {
                        this.caW = dVar.getIndex();
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
                al(list);
                in(i);
                this.caF = new b();
                this.mViewPager.setAdapter(this.caF);
                this.mViewPager.setCurrentItem(this.caW, true);
                if (this.caV != null) {
                    this.caV.ip(i);
                    this.caU = i;
                }
            }
        }
    }

    public void io(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.caS.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.caS.get(i3);
                        if (dVar == null || dVar.acq() != i) {
                            i3++;
                        } else {
                            i2 = dVar.getIndex();
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
        if (this.caP != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.acg() != null) {
            d acg = aVar.acg();
            String eR = acg.acj().eR(aVar.acf() + i);
            if (acg.ack() != EmotionGroupType.USER_COLLECT || !eR.equals(com.baidu.tbadk.imageManager.d.aEP)) {
                this.caJ.setTag(eR);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eR;
                if (eR.startsWith("#(meme,")) {
                    this.caJ.setShowStaticDrawable(false);
                } else {
                    this.caJ.setShowStaticDrawable(true);
                }
                this.caJ.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.caK.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.caI.x = this.rect.left - ((this.caI.width - linearLayout.getWidth()) / 2);
                this.caI.y = (this.rect.top - this.caI.height) + this.caN;
                this.caJ.setVisibility(0);
                if (!this.caO) {
                    this.mWindowManager.addView(this.caJ, this.caI);
                    this.caO = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.caJ, this.caI);
                }
                gridView.setSelection(i);
                if (this.caP != -1) {
                    ((LinearLayout) gridView.getChildAt(this.caP - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.caP = i;
                this.caG = gridView;
            }
        }
    }

    private void acd() {
        if (this.caO && this.caJ.getVisibility() != 8 && this.caG != null) {
            this.caG.setSelection(-1);
            this.caJ.setVisibility(8);
            if (this.caP != -1) {
                ((LinearLayout) this.caG.getChildAt(this.caP - this.caG.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.caP = -1;
            this.caG = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.caX.set(x, y);
                break;
            case 1:
            case 3:
                acd();
                break;
            case 2:
                this.caX.set(x, y);
                if (this.caO && this.caJ.getVisibility() != 8 && this.caG != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.caX.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                acd();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    acd();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.caG != null) {
                        offsetRectIntoDescendantCoords(this.caG, this.rect);
                        int pointToPosition = this.caG.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.caG);
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
        if (this.caO) {
            this.mWindowManager.removeView(this.caJ);
            this.caO = false;
        }
        MessageManager.getInstance().unRegisterListener(this.SH);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.caS != null) {
            int size = this.caS.size();
            if (i >= 0 && i < size) {
                this.caQ = this.caS.get(i);
                if (this.aDb != null && this.caQ != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aDb.setVisibility(this.caQ.acm() > 1 ? 0 : 4);
                        this.aDb.setCount(this.caQ.acm());
                        if (this.caQ != null && this.caQ.acq() != this.caU) {
                            this.caU = this.caQ.acq();
                            if (this.caV != null) {
                                this.caV.ip(this.caQ.acq());
                            }
                        }
                    }
                    float acn = this.caQ.acn() + f;
                    this.aDb.setPosition(acn);
                    this.caH.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) acn) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.caQ.acm())));
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
        this.aoN = i;
        aj.d(this.caJ, d.g.bg_expression_bubble, i);
        aj.e(this, d.e.common_color_10255, i);
        this.aDb.setSelector(aj.u(i, d.g.dot_pb_expression_s));
        this.aDb.setDrawable(aj.u(i, d.g.dot_pb_expression_n));
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
        acd();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d cba;

        public a(d dVar) {
            this.cba = dVar;
        }

        public void a(d dVar) {
            this.cba = dVar;
        }

        public int acf() {
            if (this.cba == null) {
                return 0;
            }
            return this.cba.acp();
        }

        public d acg() {
            return this.cba;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cba == null) {
                return 0;
            }
            return this.cba.aco();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cba.acl() != 0) {
                    i2 = measuredWidth / this.cba.acl();
                }
                if (this.cba.getRow() != 0) {
                    i3 = measuredHeight / this.cba.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.caN * 2, EmotionTabContentView.this.caN * 2, EmotionTabContentView.this.caN * 2, EmotionTabContentView.this.caN * 2);
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
            if (this.cba != null) {
                int acp = this.cba.acp() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.aoN);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eR = this.cba.acj().eR(acp);
                tbImageView.setTag(eR);
                if (!TextUtils.isEmpty(eR)) {
                    Object a = com.baidu.adp.lib.f.c.fJ().a(eR, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.a(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, eR, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.ImageView.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.ImageView.a) a;
                    }
                    if (aVar != null) {
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(d.h.emotion_tab_content_tip);
                if (this.cba.ack() == EmotionGroupType.BIG_EMOTION) {
                    String eR2 = this.cba.acj().eR(acp);
                    if (!TextUtils.isEmpty(eR2) && !eR2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aoN == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = aj.getColor(d.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eR2.substring(eR2.lastIndexOf("_") + 1, eR2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eR != null && eR.length() > 3) {
                    linearLayout3.setContentDescription(eR.substring(2, eR.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.caS == null) {
                return 0;
            }
            return EmotionTabContentView.this.caS.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.caY.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.caY.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.caS != null && i < EmotionTabContentView.this.caS.size()) {
                d dVar = (d) EmotionTabContentView.this.caS.get(i);
                gridView2.setNumColumns(dVar.acl());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.acg() == null) {
                            return false;
                        }
                        d acg = aVar.acg();
                        if (acg.ack() == EmotionGroupType.BIG_EMOTION || acg.ack() == EmotionGroupType.USER_COLLECT) {
                            EmotionTabContentView.this.a(i2, (GridView) adapterView);
                            return true;
                        }
                        return false;
                    }
                });
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        adapterView.setSelection(-1);
                        if (EmotionTabContentView.this.JH != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.acg() != null) {
                                d acg = aVar.acg();
                                int acf = aVar.acf();
                                com.baidu.tbadk.editortools.emotiontool.c acj = acg.acj();
                                String eR = acg.acj().eR(acf + i2);
                                if (acj.CI() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aEP.equals(eR)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eR);
                                lVar.a(acj.CI());
                                lVar.ev(acj.getGroupName());
                                lVar.ew(acj.getGroupId());
                                lVar.setWidth(acj.getWidth());
                                lVar.setHeight(acj.getHeight());
                                EmotionTabContentView.this.JH.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
                            }
                        }
                    }
                });
                gridView2.setAdapter((ListAdapter) new a(dVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.caS != null) {
                int size = EmotionTabContentView.this.caS.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.caS.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aDb.setVisibility(dVar.acm() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aDb.setCount(dVar.acm());
                        EmotionTabContentView.this.aDb.setPosition(dVar.acn());
                        EmotionTabContentView.this.aDb.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.acn() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.acm())));
                    }
                    if (dVar != null && dVar.acq() != EmotionTabContentView.this.caU) {
                        EmotionTabContentView.this.caU = dVar.acq();
                        if (EmotionTabContentView.this.caV != null) {
                            EmotionTabContentView.this.caV.ip(dVar.acq());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.caV = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.JH = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SH);
    }
}
