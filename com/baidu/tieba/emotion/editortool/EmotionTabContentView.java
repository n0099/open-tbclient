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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
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
    private CustomMessageListener aIi;
    private i axQ;
    private int bdS;
    private IndicatorView bsN;
    private int currentPosition;
    private b dkO;
    private GridView dkP;
    private LinearLayout dkQ;
    private WindowManager.LayoutParams dkR;
    private GifView dkS;
    private ViewGroup dkT;
    private int dkU;
    private int dkV;
    private int dkW;
    private boolean dkX;
    private int dkY;
    private d dkZ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dla;
    private List<d> dlb;
    private int dlc;
    private int dld;
    private c dle;
    private int dlf;
    private final Point dlg;
    private com.baidu.adp.lib.e.b<GridView> dlh;
    private Context mContext;
    private WindowManager mWindowManager;
    private ViewPager qW;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void mh(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dkY = -1;
        this.dlc = 0;
        this.dld = -1;
        this.currentPosition = -1;
        this.dlg = new Point();
        this.aIi = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.aI(new ArrayList(EmotionTabContentView.this.dla));
                        if (EmotionTabContentView.this.dkO != null) {
                            EmotionTabContentView.this.dkO.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dld < 0 || EmotionTabContentView.this.dld >= EmotionTabContentView.this.dla.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dla.get(EmotionTabContentView.this.dld)).KL() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dkO != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dlb.size()) {
                                    EmotionTabContentView.this.dkZ = (d) EmotionTabContentView.this.dlb.get(EmotionTabContentView.this.currentPosition);
                                    int apj = EmotionTabContentView.this.dkZ.apj();
                                    EmotionTabContentView.this.bsN.setCount(apj);
                                    EmotionTabContentView.this.bsN.setVisibility(apj > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.qW == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.qW.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.qW.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.apd().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dlb.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dlb.get(index));
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
        this.dkY = -1;
        this.dlc = 0;
        this.dld = -1;
        this.currentPosition = -1;
        this.dlg = new Point();
        this.aIi = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.aI(new ArrayList(EmotionTabContentView.this.dla));
                        if (EmotionTabContentView.this.dkO != null) {
                            EmotionTabContentView.this.dkO.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dld < 0 || EmotionTabContentView.this.dld >= EmotionTabContentView.this.dla.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dla.get(EmotionTabContentView.this.dld)).KL() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dkO != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dlb.size()) {
                                    EmotionTabContentView.this.dkZ = (d) EmotionTabContentView.this.dlb.get(EmotionTabContentView.this.currentPosition);
                                    int apj = EmotionTabContentView.this.dkZ.apj();
                                    EmotionTabContentView.this.bsN.setCount(apj);
                                    EmotionTabContentView.this.bsN.setVisibility(apj > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.qW == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.qW.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.qW.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.apd().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dlb.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dlb.get(index));
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
        this.dla = new ArrayList();
        this.dlb = new ArrayList();
        this.dlh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: apb */
            public GridView nl() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView at(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView au(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.emotion_tab_content, (ViewGroup) this, true);
        this.qW = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.qW.setFadingEdgeLength(0);
        this.qW.setOnPageChangeListener(this);
        this.dkS = new GifView(context);
        aj.f(this.dkS, d.f.bg_expression_bubble, this.bdS);
        this.dkS.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dkR = new WindowManager.LayoutParams();
        this.dkU = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.dkV = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.dkW = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.dkR.width = this.dkU;
        this.dkR.height = this.dkV;
        this.dkR.gravity = 51;
        this.dkR.format = -3;
        this.dkR.type = 1000;
        this.dkR.flags |= 56;
        this.dkT = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.bsN = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.dkQ = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.dkQ.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dkR.type = 1000;
            this.dkR.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dla.clear();
        this.dlb.clear();
        if (list != null && !list.isEmpty()) {
            this.dla.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int KO = cVar.KO();
                    int i4 = emotionsCount / (cols * KO);
                    if (emotionsCount % (cols * KO) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * KO;
                        } else {
                            i = emotionsCount - ((cols * KO) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.mm(i3);
                        dVar.b(cVar.KL());
                        dVar.hU(KO);
                        dVar.hT(cols);
                        dVar.mi(i4);
                        dVar.mj(i5);
                        dVar.mk(i);
                        dVar.ml(i5 * cols * KO);
                        dVar.setEndIndex((i + i2) - 1);
                        this.dlb.add(dVar);
                    }
                }
            }
            this.dlc = this.dlb.size();
            for (int i6 = 0; i6 < this.dlc; i6++) {
                if (this.dlb != null && this.dlb.get(i6) != null) {
                    this.dlb.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void mf(int i) {
        if (this.dlb != null) {
            int size = this.dlb.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.dlb.get(i2);
                    if (dVar != null && dVar.apn() == i) {
                        this.dlf = dVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void l(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                aI(list);
                mf(i);
                this.dkO = new b();
                this.qW.setAdapter(this.dkO);
                this.qW.setCurrentItem(this.dlf, true);
                if (this.dle != null) {
                    this.dle.mh(i);
                    this.dld = i;
                }
            }
        }
    }

    public void mg(int i) {
        int i2;
        if (this.qW != null) {
            int size = this.dlb.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.dlb.get(i3);
                        if (dVar == null || dVar.apn() != i) {
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
                this.qW.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.dkY != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.apd() != null) {
            d apd = aVar.apd();
            String hM = apd.apg().hM(aVar.apc() + i);
            if (apd.aph() != EmotionGroupType.USER_COLLECT || !hM.equals(com.baidu.tbadk.imageManager.d.buB)) {
                this.dkS.setTag(hM);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = hM;
                if (hM.startsWith("#(meme,")) {
                    this.dkS.setShowStaticDrawable(false);
                } else {
                    this.dkS.setShowStaticDrawable(true);
                }
                this.dkS.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dkT.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dkR.x = this.rect.left - ((this.dkR.width - linearLayout.getWidth()) / 2);
                this.dkR.y = (this.rect.top - this.dkR.height) + this.dkW;
                this.dkS.setVisibility(0);
                if (!this.dkX) {
                    this.mWindowManager.addView(this.dkS, this.dkR);
                    this.dkX = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dkS, this.dkR);
                }
                gridView.setSelection(i);
                if (this.dkY != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dkY - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dkY = i;
                this.dkP = gridView;
            }
        }
    }

    private void apa() {
        if (this.dkX && this.dkS.getVisibility() != 8 && this.dkP != null) {
            this.dkP.setSelection(-1);
            this.dkS.setVisibility(8);
            if (this.dkY != -1) {
                ((LinearLayout) this.dkP.getChildAt(this.dkY - this.dkP.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dkY = -1;
            this.dkP = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dlg.set(x, y);
                break;
            case 1:
            case 3:
                apa();
                break;
            case 2:
                this.dlg.set(x, y);
                if (this.dkX && this.dkS.getVisibility() != 8 && this.dkP != null) {
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
                this.dlg.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                apa();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    apa();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.dkP != null) {
                        offsetRectIntoDescendantCoords(this.dkP, this.rect);
                        int pointToPosition = this.dkP.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dkP);
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
        if (this.dkX) {
            this.mWindowManager.removeView(this.dkS);
            this.dkX = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aIi);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dlb != null) {
            int size = this.dlb.size();
            if (i >= 0 && i < size) {
                this.dkZ = this.dlb.get(i);
                if (this.bsN != null && this.dkZ != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.bsN.setVisibility(this.dkZ.apj() > 1 ? 0 : 4);
                        this.bsN.setCount(this.dkZ.apj());
                        if (this.dkZ != null && this.dkZ.apn() != this.dld) {
                            this.dld = this.dkZ.apn();
                            if (this.dle != null) {
                                this.dle.mh(this.dkZ.apn());
                            }
                        }
                    }
                    float apk = this.dkZ.apk() + f;
                    this.bsN.setPosition(apk);
                    this.dkQ.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) apk) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.dkZ.apj())));
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
        this.bdS = i;
        aj.f(this.dkS, d.f.bg_expression_bubble, i);
        aj.g(this, d.C0108d.cp_bg_line_d, i);
        this.bsN.setSelector(aj.au(i, d.f.dot_pb_expression_s));
        this.bsN.setDrawable(aj.au(i, d.f.dot_pb_expression_n));
        if (this.qW != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.qW.getChildCount()) {
                    View childAt = this.qW.getChildAt(i3);
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
        apa();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d dlj;

        public a(d dVar) {
            this.dlj = dVar;
        }

        public void a(d dVar) {
            this.dlj = dVar;
        }

        public int apc() {
            if (this.dlj == null) {
                return 0;
            }
            return this.dlj.apm();
        }

        public d apd() {
            return this.dlj;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dlj == null) {
                return 0;
            }
            return this.dlj.apl();
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
            com.baidu.adp.widget.a.a aVar;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.dlj.api() != 0) {
                    i2 = measuredWidth / this.dlj.api();
                }
                if (this.dlj.getRow() != 0) {
                    i3 = measuredHeight / this.dlj.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dkW * 2, EmotionTabContentView.this.dkW * 2, EmotionTabContentView.this.dkW * 2, EmotionTabContentView.this.dkW * 2);
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
            if (this.dlj != null) {
                int apm = this.dlj.apm() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.f(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bdS);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String hM = this.dlj.apg().hM(apm);
                tbImageView.setTag(hM);
                if (!TextUtils.isEmpty(hM)) {
                    Object a = com.baidu.adp.lib.f.c.nm().a(hM, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.a(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, hM, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.a.a) a;
                    }
                    if (aVar != null) {
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(d.g.emotion_tab_content_tip);
                if (this.dlj.aph() == EmotionGroupType.BIG_EMOTION) {
                    String hM2 = this.dlj.apg().hM(apm);
                    if (!TextUtils.isEmpty(hM2) && !hM2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bdS == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0108d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0108d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(hM2.substring(hM2.lastIndexOf("_") + 1, hM2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (hM != null && hM.length() > 3) {
                    linearLayout3.setContentDescription(hM.substring(2, hM.length() - 1));
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
            if (EmotionTabContentView.this.dlb == null) {
                return 0;
            }
            return EmotionTabContentView.this.dlb.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dlh.ar(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dlh.nk();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dlb != null && i < EmotionTabContentView.this.dlb.size()) {
                d dVar = (d) EmotionTabContentView.this.dlb.get(i);
                gridView2.setNumColumns(dVar.api());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0108d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.apd() == null) {
                            return false;
                        }
                        d apd = aVar.apd();
                        if (apd.aph() == EmotionGroupType.BIG_EMOTION || apd.aph() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.axQ != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.apd() != null) {
                                d apd = aVar.apd();
                                int apc = aVar.apc();
                                com.baidu.tbadk.editortools.emotiontool.c apg = apd.apg();
                                String hM = apd.apg().hM(apc + i2);
                                if (apg.KL() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.buB.equals(hM)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(hM);
                                nVar.a(apg.KL());
                                nVar.eW(apg.getGroupName());
                                nVar.eX(apg.getGroupId());
                                nVar.setWidth(apg.getWidth());
                                nVar.setHeight(apg.getHeight());
                                EmotionTabContentView.this.axQ.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.dlb != null) {
                int size = EmotionTabContentView.this.dlb.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.dlb.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.bsN.setVisibility(dVar.apj() > 1 ? 0 : 4);
                        EmotionTabContentView.this.bsN.setCount(dVar.apj());
                        EmotionTabContentView.this.bsN.setPosition(dVar.apk());
                        EmotionTabContentView.this.bsN.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.apk() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.apj())));
                    }
                    if (dVar != null && dVar.apn() != EmotionTabContentView.this.dld) {
                        EmotionTabContentView.this.dld = dVar.apn();
                        if (EmotionTabContentView.this.dle != null) {
                            EmotionTabContentView.this.dle.mh(dVar.apn());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.dle = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.axQ = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aIi);
    }
}
