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
    private i IS;
    private CustomMessageListener TG;
    private ViewPager aEB;
    private IndicatorView aEC;
    private int apG;
    private int crA;
    private int crB;
    private boolean crC;
    private int crD;
    private d crE;
    private List<com.baidu.tbadk.editortools.emotiontool.c> crF;
    private List<d> crG;
    private int crH;
    private int crI;
    private c crJ;
    private int crK;
    private final Point crL;
    private com.baidu.adp.lib.e.b<GridView> crM;
    private b crt;
    private GridView cru;
    private LinearLayout crv;
    private WindowManager.LayoutParams crw;
    private GifView crx;
    private ViewGroup cry;
    private int crz;
    private int currentPosition;
    private Context mContext;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void jg(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.crD = -1;
        this.crH = 0;
        this.crI = -1;
        this.currentPosition = -1;
        this.crL = new Point();
        this.TG = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.az(new ArrayList(EmotionTabContentView.this.crF));
                        if (EmotionTabContentView.this.crt != null) {
                            EmotionTabContentView.this.crt.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.crI < 0 || EmotionTabContentView.this.crI >= EmotionTabContentView.this.crF.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.crF.get(EmotionTabContentView.this.crI)).Dt() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.crt != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.crG.size()) {
                                    EmotionTabContentView.this.crE = (d) EmotionTabContentView.this.crG.get(EmotionTabContentView.this.currentPosition);
                                    int agA = EmotionTabContentView.this.crE.agA();
                                    EmotionTabContentView.this.aEC.setCount(agA);
                                    EmotionTabContentView.this.aEC.setVisibility(agA > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aEB == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aEB.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aEB.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.agu().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.crG.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.crG.get(index));
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
        this.crD = -1;
        this.crH = 0;
        this.crI = -1;
        this.currentPosition = -1;
        this.crL = new Point();
        this.TG = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.az(new ArrayList(EmotionTabContentView.this.crF));
                        if (EmotionTabContentView.this.crt != null) {
                            EmotionTabContentView.this.crt.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.crI < 0 || EmotionTabContentView.this.crI >= EmotionTabContentView.this.crF.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.crF.get(EmotionTabContentView.this.crI)).Dt() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.crt != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.crG.size()) {
                                    EmotionTabContentView.this.crE = (d) EmotionTabContentView.this.crG.get(EmotionTabContentView.this.currentPosition);
                                    int agA = EmotionTabContentView.this.crE.agA();
                                    EmotionTabContentView.this.aEC.setCount(agA);
                                    EmotionTabContentView.this.aEC.setVisibility(agA > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aEB == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aEB.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aEB.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.agu().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.crG.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.crG.get(index));
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
        this.crF = new ArrayList();
        this.crG = new ArrayList();
        this.crM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ags */
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
        this.aEB = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.aEB.setFadingEdgeLength(0);
        this.aEB.setOnPageChangeListener(this);
        this.crx = new GifView(context);
        aj.d(this.crx, d.f.bg_expression_bubble, this.apG);
        this.crx.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.crw = new WindowManager.LayoutParams();
        this.crz = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.crA = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.crB = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.crw.width = this.crz;
        this.crw.height = this.crA;
        this.crw.gravity = 51;
        this.crw.format = -3;
        this.crw.type = 1000;
        this.crw.flags |= 56;
        this.cry = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEC = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.crv = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.crv.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.crw.type = 1000;
            this.crw.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.crF.clear();
        this.crG.clear();
        if (list != null && !list.isEmpty()) {
            this.crF.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dw = cVar.Dw();
                    int i4 = emotionsCount / (cols * Dw);
                    if (emotionsCount % (cols * Dw) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Dw;
                        } else {
                            i = emotionsCount - ((cols * Dw) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.jl(i3);
                        dVar.b(cVar.Dt());
                        dVar.fa(Dw);
                        dVar.eZ(cols);
                        dVar.jh(i4);
                        dVar.ji(i5);
                        dVar.jj(i);
                        dVar.jk(i5 * cols * Dw);
                        dVar.setEndIndex((i + i2) - 1);
                        this.crG.add(dVar);
                    }
                }
            }
            this.crH = this.crG.size();
            for (int i6 = 0; i6 < this.crH; i6++) {
                if (this.crG != null && this.crG.get(i6) != null) {
                    this.crG.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void je(int i) {
        if (this.crG != null) {
            int size = this.crG.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.crG.get(i2);
                    if (dVar != null && dVar.agE() == i) {
                        this.crK = dVar.getIndex();
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
                az(list);
                je(i);
                this.crt = new b();
                this.aEB.setAdapter(this.crt);
                this.aEB.setCurrentItem(this.crK, true);
                if (this.crJ != null) {
                    this.crJ.jg(i);
                    this.crI = i;
                }
            }
        }
    }

    public void jf(int i) {
        int i2;
        if (this.aEB != null) {
            int size = this.crG.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.crG.get(i3);
                        if (dVar == null || dVar.agE() != i) {
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
                this.aEB.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.crD != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.agu() != null) {
            d agu = aVar.agu();
            String eS = agu.agx().eS(aVar.agt() + i);
            if (agu.agy() != EmotionGroupType.USER_COLLECT || !eS.equals(com.baidu.tbadk.imageManager.d.aGp)) {
                this.crx.setTag(eS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eS;
                if (eS.startsWith("#(meme,")) {
                    this.crx.setShowStaticDrawable(false);
                } else {
                    this.crx.setShowStaticDrawable(true);
                }
                this.crx.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cry.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.crw.x = this.rect.left - ((this.crw.width - linearLayout.getWidth()) / 2);
                this.crw.y = (this.rect.top - this.crw.height) + this.crB;
                this.crx.setVisibility(0);
                if (!this.crC) {
                    this.mWindowManager.addView(this.crx, this.crw);
                    this.crC = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.crx, this.crw);
                }
                gridView.setSelection(i);
                if (this.crD != -1) {
                    ((LinearLayout) gridView.getChildAt(this.crD - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.crD = i;
                this.cru = gridView;
            }
        }
    }

    private void agr() {
        if (this.crC && this.crx.getVisibility() != 8 && this.cru != null) {
            this.cru.setSelection(-1);
            this.crx.setVisibility(8);
            if (this.crD != -1) {
                ((LinearLayout) this.cru.getChildAt(this.crD - this.cru.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.crD = -1;
            this.cru = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.crL.set(x, y);
                break;
            case 1:
            case 3:
                agr();
                break;
            case 2:
                this.crL.set(x, y);
                if (this.crC && this.crx.getVisibility() != 8 && this.cru != null) {
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
                this.crL.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                agr();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    agr();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cru != null) {
                        offsetRectIntoDescendantCoords(this.cru, this.rect);
                        int pointToPosition = this.cru.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cru);
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
        if (this.crC) {
            this.mWindowManager.removeView(this.crx);
            this.crC = false;
        }
        MessageManager.getInstance().unRegisterListener(this.TG);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.crG != null) {
            int size = this.crG.size();
            if (i >= 0 && i < size) {
                this.crE = this.crG.get(i);
                if (this.aEC != null && this.crE != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEC.setVisibility(this.crE.agA() > 1 ? 0 : 4);
                        this.aEC.setCount(this.crE.agA());
                        if (this.crE != null && this.crE.agE() != this.crI) {
                            this.crI = this.crE.agE();
                            if (this.crJ != null) {
                                this.crJ.jg(this.crE.agE());
                            }
                        }
                    }
                    float agB = this.crE.agB() + f;
                    this.aEC.setPosition(agB);
                    this.crv.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) agB) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.crE.agA())));
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
        this.apG = i;
        aj.d(this.crx, d.f.bg_expression_bubble, i);
        aj.e(this, d.C0095d.cp_bg_line_d, i);
        this.aEC.setSelector(aj.v(i, d.f.dot_pb_expression_s));
        this.aEC.setDrawable(aj.v(i, d.f.dot_pb_expression_n));
        if (this.aEB != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aEB.getChildCount()) {
                    View childAt = this.aEB.getChildAt(i3);
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
        agr();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d crO;

        public a(d dVar) {
            this.crO = dVar;
        }

        public void a(d dVar) {
            this.crO = dVar;
        }

        public int agt() {
            if (this.crO == null) {
                return 0;
            }
            return this.crO.agD();
        }

        public d agu() {
            return this.crO;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.crO == null) {
                return 0;
            }
            return this.crO.agC();
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
                if (this.crO.agz() != 0) {
                    i2 = measuredWidth / this.crO.agz();
                }
                if (this.crO.getRow() != 0) {
                    i3 = measuredHeight / this.crO.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.crB * 2, EmotionTabContentView.this.crB * 2, EmotionTabContentView.this.crB * 2, EmotionTabContentView.this.crB * 2);
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
            if (this.crO != null) {
                int agD = this.crO.agD() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.apG);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eS = this.crO.agx().eS(agD);
                tbImageView.setTag(eS);
                if (!TextUtils.isEmpty(eS)) {
                    Object a = com.baidu.adp.lib.f.c.fJ().a(eS, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eS, false, null);
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
                if (this.crO.agy() == EmotionGroupType.BIG_EMOTION) {
                    String eS2 = this.crO.agx().eS(agD);
                    if (!TextUtils.isEmpty(eS2) && !eS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.apG == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0095d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0095d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eS2.substring(eS2.lastIndexOf("_") + 1, eS2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eS != null && eS.length() > 3) {
                    linearLayout3.setContentDescription(eS.substring(2, eS.length() - 1));
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
            if (EmotionTabContentView.this.crG == null) {
                return 0;
            }
            return EmotionTabContentView.this.crG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.crM.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.crM.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.crG != null && i < EmotionTabContentView.this.crG.size()) {
                d dVar = (d) EmotionTabContentView.this.crG.get(i);
                gridView2.setNumColumns(dVar.agz());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0095d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.agu() == null) {
                            return false;
                        }
                        d agu = aVar.agu();
                        if (agu.agy() == EmotionGroupType.BIG_EMOTION || agu.agy() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.IS != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.agu() != null) {
                                d agu = aVar.agu();
                                int agt = aVar.agt();
                                com.baidu.tbadk.editortools.emotiontool.c agx = agu.agx();
                                String eS = agu.agx().eS(agt + i2);
                                if (agx.Dt() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGp.equals(eS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eS);
                                nVar.a(agx.Dt());
                                nVar.eH(agx.getGroupName());
                                nVar.eI(agx.getGroupId());
                                nVar.setWidth(agx.getWidth());
                                nVar.setHeight(agx.getHeight());
                                EmotionTabContentView.this.IS.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.crG != null) {
                int size = EmotionTabContentView.this.crG.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.crG.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEC.setVisibility(dVar.agA() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEC.setCount(dVar.agA());
                        EmotionTabContentView.this.aEC.setPosition(dVar.agB());
                        EmotionTabContentView.this.aEC.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.agB() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.agA())));
                    }
                    if (dVar != null && dVar.agE() != EmotionTabContentView.this.crI) {
                        EmotionTabContentView.this.crI = dVar.agE();
                        if (EmotionTabContentView.this.crJ != null) {
                            EmotionTabContentView.this.crJ.jg(dVar.agE());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.crJ = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.IS = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TG);
    }
}
