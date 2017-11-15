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
import com.baidu.tbadk.coreExtra.data.m;
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
    private i Jb;
    private CustomMessageListener Tc;
    private ViewPager aDT;
    private IndicatorView aDU;
    private int aph;
    private GridView ciA;
    private LinearLayout ciB;
    private WindowManager.LayoutParams ciC;
    private GifView ciD;
    private ViewGroup ciE;
    private int ciF;
    private int ciG;
    private int ciH;
    private boolean ciI;
    private int ciJ;
    private d ciK;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ciL;
    private List<d> ciM;
    private int ciN;
    private int ciO;
    private c ciP;
    private int ciQ;
    private final Point ciR;
    private com.baidu.adp.lib.e.b<GridView> ciS;
    private b ciz;
    private int currentPosition;
    private Context mContext;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void iG(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.ciJ = -1;
        this.ciN = 0;
        this.ciO = -1;
        this.currentPosition = -1;
        this.ciR = new Point();
        this.Tc = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.an(new ArrayList(EmotionTabContentView.this.ciL));
                        if (EmotionTabContentView.this.ciz != null) {
                            EmotionTabContentView.this.ciz.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ciO < 0 || EmotionTabContentView.this.ciO >= EmotionTabContentView.this.ciL.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ciL.get(EmotionTabContentView.this.ciO)).Di() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ciz != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.ciM.size()) {
                                    EmotionTabContentView.this.ciK = (d) EmotionTabContentView.this.ciM.get(EmotionTabContentView.this.currentPosition);
                                    int aeH = EmotionTabContentView.this.ciK.aeH();
                                    EmotionTabContentView.this.aDU.setCount(aeH);
                                    EmotionTabContentView.this.aDU.setVisibility(aeH > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aDT == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aDT.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aDT.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.aeB().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ciM.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.ciM.get(index));
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
        this.ciJ = -1;
        this.ciN = 0;
        this.ciO = -1;
        this.currentPosition = -1;
        this.ciR = new Point();
        this.Tc = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.an(new ArrayList(EmotionTabContentView.this.ciL));
                        if (EmotionTabContentView.this.ciz != null) {
                            EmotionTabContentView.this.ciz.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ciO < 0 || EmotionTabContentView.this.ciO >= EmotionTabContentView.this.ciL.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ciL.get(EmotionTabContentView.this.ciO)).Di() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ciz != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.ciM.size()) {
                                    EmotionTabContentView.this.ciK = (d) EmotionTabContentView.this.ciM.get(EmotionTabContentView.this.currentPosition);
                                    int aeH = EmotionTabContentView.this.ciK.aeH();
                                    EmotionTabContentView.this.aDU.setCount(aeH);
                                    EmotionTabContentView.this.aDU.setVisibility(aeH > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aDT == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aDT.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aDT.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.aeB().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ciM.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.ciM.get(index));
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
        this.ciL = new ArrayList();
        this.ciM = new ArrayList();
        this.ciS = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aez */
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_content, (ViewGroup) this, true);
        this.aDT = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.aDT.setFadingEdgeLength(0);
        this.aDT.setOnPageChangeListener(this);
        this.ciD = new GifView(context);
        aj.d(this.ciD, d.f.bg_expression_bubble, this.aph);
        this.ciD.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ciC = new WindowManager.LayoutParams();
        this.ciF = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.ciG = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.ciH = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ciC.width = this.ciF;
        this.ciC.height = this.ciG;
        this.ciC.gravity = 51;
        this.ciC.format = -3;
        this.ciC.type = 1000;
        this.ciC.flags |= 56;
        this.ciE = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aDU = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.ciB = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.ciB.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ciC.type = 1000;
            this.ciC.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ciL.clear();
        this.ciM.clear();
        if (list != null && !list.isEmpty()) {
            this.ciL.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dl = cVar.Dl();
                    int i4 = emotionsCount / (cols * Dl);
                    if (emotionsCount % (cols * Dl) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Dl;
                        } else {
                            i = emotionsCount - ((cols * Dl) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.iL(i3);
                        dVar.b(cVar.Di());
                        dVar.fb(Dl);
                        dVar.fa(cols);
                        dVar.iH(i4);
                        dVar.iI(i5);
                        dVar.iJ(i);
                        dVar.iK(i5 * cols * Dl);
                        dVar.setEndIndex((i + i2) - 1);
                        this.ciM.add(dVar);
                    }
                }
            }
            this.ciN = this.ciM.size();
            for (int i6 = 0; i6 < this.ciN; i6++) {
                if (this.ciM != null && this.ciM.get(i6) != null) {
                    this.ciM.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void iE(int i) {
        if (this.ciM != null) {
            int size = this.ciM.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.ciM.get(i2);
                    if (dVar != null && dVar.aeL() == i) {
                        this.ciQ = dVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void i(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                an(list);
                iE(i);
                this.ciz = new b();
                this.aDT.setAdapter(this.ciz);
                this.aDT.setCurrentItem(this.ciQ, true);
                if (this.ciP != null) {
                    this.ciP.iG(i);
                    this.ciO = i;
                }
            }
        }
    }

    public void iF(int i) {
        int i2;
        if (this.aDT != null) {
            int size = this.ciM.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.ciM.get(i3);
                        if (dVar == null || dVar.aeL() != i) {
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
                this.aDT.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.ciJ != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aeB() != null) {
            d aeB = aVar.aeB();
            String eR = aeB.aeE().eR(aVar.aeA() + i);
            if (aeB.aeF() != EmotionGroupType.USER_COLLECT || !eR.equals(com.baidu.tbadk.imageManager.d.aFH)) {
                this.ciD.setTag(eR);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eR;
                if (eR.startsWith("#(meme,")) {
                    this.ciD.setShowStaticDrawable(false);
                } else {
                    this.ciD.setShowStaticDrawable(true);
                }
                this.ciD.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.ciE.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.ciC.x = this.rect.left - ((this.ciC.width - linearLayout.getWidth()) / 2);
                this.ciC.y = (this.rect.top - this.ciC.height) + this.ciH;
                this.ciD.setVisibility(0);
                if (!this.ciI) {
                    this.mWindowManager.addView(this.ciD, this.ciC);
                    this.ciI = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ciD, this.ciC);
                }
                gridView.setSelection(i);
                if (this.ciJ != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ciJ - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ciJ = i;
                this.ciA = gridView;
            }
        }
    }

    private void aey() {
        if (this.ciI && this.ciD.getVisibility() != 8 && this.ciA != null) {
            this.ciA.setSelection(-1);
            this.ciD.setVisibility(8);
            if (this.ciJ != -1) {
                ((LinearLayout) this.ciA.getChildAt(this.ciJ - this.ciA.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ciJ = -1;
            this.ciA = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ciR.set(x, y);
                break;
            case 1:
            case 3:
                aey();
                break;
            case 2:
                this.ciR.set(x, y);
                if (this.ciI && this.ciD.getVisibility() != 8 && this.ciA != null) {
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
                this.ciR.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                aey();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    aey();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.ciA != null) {
                        offsetRectIntoDescendantCoords(this.ciA, this.rect);
                        int pointToPosition = this.ciA.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.ciA);
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
        if (this.ciI) {
            this.mWindowManager.removeView(this.ciD);
            this.ciI = false;
        }
        MessageManager.getInstance().unRegisterListener(this.Tc);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ciM != null) {
            int size = this.ciM.size();
            if (i >= 0 && i < size) {
                this.ciK = this.ciM.get(i);
                if (this.aDU != null && this.ciK != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aDU.setVisibility(this.ciK.aeH() > 1 ? 0 : 4);
                        this.aDU.setCount(this.ciK.aeH());
                        if (this.ciK != null && this.ciK.aeL() != this.ciO) {
                            this.ciO = this.ciK.aeL();
                            if (this.ciP != null) {
                                this.ciP.iG(this.ciK.aeL());
                            }
                        }
                    }
                    float aeI = this.ciK.aeI() + f;
                    this.aDU.setPosition(aeI);
                    this.ciB.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aeI) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.ciK.aeH())));
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
        this.aph = i;
        aj.d(this.ciD, d.f.bg_expression_bubble, i);
        aj.e(this, d.C0080d.common_color_10255, i);
        this.aDU.setSelector(aj.u(i, d.f.dot_pb_expression_s));
        this.aDU.setDrawable(aj.u(i, d.f.dot_pb_expression_n));
        if (this.aDT != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aDT.getChildCount()) {
                    View childAt = this.aDT.getChildAt(i3);
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
        aey();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d ciU;

        public a(d dVar) {
            this.ciU = dVar;
        }

        public void a(d dVar) {
            this.ciU = dVar;
        }

        public int aeA() {
            if (this.ciU == null) {
                return 0;
            }
            return this.ciU.aeK();
        }

        public d aeB() {
            return this.ciU;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ciU == null) {
                return 0;
            }
            return this.ciU.aeJ();
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
                if (this.ciU.aeG() != 0) {
                    i2 = measuredWidth / this.ciU.aeG();
                }
                if (this.ciU.getRow() != 0) {
                    i3 = measuredHeight / this.ciU.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ciH * 2, EmotionTabContentView.this.ciH * 2, EmotionTabContentView.this.ciH * 2, EmotionTabContentView.this.ciH * 2);
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
            if (this.ciU != null) {
                int aeK = this.ciU.aeK() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.aph);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eR = this.ciU.aeE().eR(aeK);
                tbImageView.setTag(eR);
                if (!TextUtils.isEmpty(eR)) {
                    Object a = com.baidu.adp.lib.f.c.fJ().a(eR, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eR, false, null);
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
                if (this.ciU.aeF() == EmotionGroupType.BIG_EMOTION) {
                    String eR2 = this.ciU.aeE().eR(aeK);
                    if (!TextUtils.isEmpty(eR2) && !eR2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aph == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0080d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0080d.cp_cont_c);
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
            if (EmotionTabContentView.this.ciM == null) {
                return 0;
            }
            return EmotionTabContentView.this.ciM.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ciS.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ciS.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ciM != null && i < EmotionTabContentView.this.ciM.size()) {
                d dVar = (d) EmotionTabContentView.this.ciM.get(i);
                gridView2.setNumColumns(dVar.aeG());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0080d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aeB() == null) {
                            return false;
                        }
                        d aeB = aVar.aeB();
                        if (aeB.aeF() == EmotionGroupType.BIG_EMOTION || aeB.aeF() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Jb != null) {
                            m mVar = new m();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aeB() != null) {
                                d aeB = aVar.aeB();
                                int aeA = aVar.aeA();
                                com.baidu.tbadk.editortools.emotiontool.c aeE = aeB.aeE();
                                String eR = aeB.aeE().eR(aeA + i2);
                                if (aeE.Di() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aFH.equals(eR)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                mVar.setName(eR);
                                mVar.a(aeE.Di());
                                mVar.eC(aeE.getGroupName());
                                mVar.eD(aeE.getGroupId());
                                mVar.setWidth(aeE.getWidth());
                                mVar.setHeight(aeE.getHeight());
                                EmotionTabContentView.this.Jb.b(new com.baidu.tbadk.editortools.a(24, -1, mVar));
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
            if (EmotionTabContentView.this.ciM != null) {
                int size = EmotionTabContentView.this.ciM.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.ciM.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aDU.setVisibility(dVar.aeH() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aDU.setCount(dVar.aeH());
                        EmotionTabContentView.this.aDU.setPosition(dVar.aeI());
                        EmotionTabContentView.this.aDU.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.aeI() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.aeH())));
                    }
                    if (dVar != null && dVar.aeL() != EmotionTabContentView.this.ciO) {
                        EmotionTabContentView.this.ciO = dVar.aeL();
                        if (EmotionTabContentView.this.ciP != null) {
                            EmotionTabContentView.this.ciP.iG(dVar.aeL());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.ciP = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.Jb = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Tc);
    }
}
