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
    private i IR;
    private CustomMessageListener TF;
    private ViewPager aEy;
    private IndicatorView aEz;
    private int apD;
    private d crA;
    private List<com.baidu.tbadk.editortools.emotiontool.c> crB;
    private List<d> crC;
    private int crD;
    private int crE;
    private c crF;
    private int crG;
    private final Point crH;
    private com.baidu.adp.lib.e.b<GridView> crI;
    private b crp;
    private GridView crq;
    private LinearLayout crr;
    private WindowManager.LayoutParams crs;
    private GifView crt;
    private ViewGroup cru;
    private int crv;
    private int crw;
    private int crx;
    private boolean cry;
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
        this.crz = -1;
        this.crD = 0;
        this.crE = -1;
        this.currentPosition = -1;
        this.crH = new Point();
        this.TF = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.az(new ArrayList(EmotionTabContentView.this.crB));
                        if (EmotionTabContentView.this.crp != null) {
                            EmotionTabContentView.this.crp.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.crE < 0 || EmotionTabContentView.this.crE >= EmotionTabContentView.this.crB.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.crB.get(EmotionTabContentView.this.crE)).Dt() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.crp != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.crC.size()) {
                                    EmotionTabContentView.this.crA = (d) EmotionTabContentView.this.crC.get(EmotionTabContentView.this.currentPosition);
                                    int agB = EmotionTabContentView.this.crA.agB();
                                    EmotionTabContentView.this.aEz.setCount(agB);
                                    EmotionTabContentView.this.aEz.setVisibility(agB > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aEy == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aEy.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aEy.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.agv().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.crC.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.crC.get(index));
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
        this.crz = -1;
        this.crD = 0;
        this.crE = -1;
        this.currentPosition = -1;
        this.crH = new Point();
        this.TF = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.az(new ArrayList(EmotionTabContentView.this.crB));
                        if (EmotionTabContentView.this.crp != null) {
                            EmotionTabContentView.this.crp.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.crE < 0 || EmotionTabContentView.this.crE >= EmotionTabContentView.this.crB.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.crB.get(EmotionTabContentView.this.crE)).Dt() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.crp != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.crC.size()) {
                                    EmotionTabContentView.this.crA = (d) EmotionTabContentView.this.crC.get(EmotionTabContentView.this.currentPosition);
                                    int agB = EmotionTabContentView.this.crA.agB();
                                    EmotionTabContentView.this.aEz.setCount(agB);
                                    EmotionTabContentView.this.aEz.setVisibility(agB > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aEy == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aEy.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aEy.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.agv().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.crC.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.crC.get(index));
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
        this.crB = new ArrayList();
        this.crC = new ArrayList();
        this.crI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agt */
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
        this.aEy = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.aEy.setFadingEdgeLength(0);
        this.aEy.setOnPageChangeListener(this);
        this.crt = new GifView(context);
        aj.d(this.crt, d.f.bg_expression_bubble, this.apD);
        this.crt.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.crs = new WindowManager.LayoutParams();
        this.crv = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.crw = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.crx = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.crs.width = this.crv;
        this.crs.height = this.crw;
        this.crs.gravity = 51;
        this.crs.format = -3;
        this.crs.type = 1000;
        this.crs.flags |= 56;
        this.cru = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEz = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.crr = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.crr.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.crs.type = 1000;
            this.crs.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.crB.clear();
        this.crC.clear();
        if (list != null && !list.isEmpty()) {
            this.crB.addAll(list);
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
                        this.crC.add(dVar);
                    }
                }
            }
            this.crD = this.crC.size();
            for (int i6 = 0; i6 < this.crD; i6++) {
                if (this.crC != null && this.crC.get(i6) != null) {
                    this.crC.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void je(int i) {
        if (this.crC != null) {
            int size = this.crC.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.crC.get(i2);
                    if (dVar != null && dVar.agF() == i) {
                        this.crG = dVar.getIndex();
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
                this.crp = new b();
                this.aEy.setAdapter(this.crp);
                this.aEy.setCurrentItem(this.crG, true);
                if (this.crF != null) {
                    this.crF.jg(i);
                    this.crE = i;
                }
            }
        }
    }

    public void jf(int i) {
        int i2;
        if (this.aEy != null) {
            int size = this.crC.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.crC.get(i3);
                        if (dVar == null || dVar.agF() != i) {
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
                this.aEy.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.crz != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.agv() != null) {
            d agv = aVar.agv();
            String eS = agv.agy().eS(aVar.agu() + i);
            if (agv.agz() != EmotionGroupType.USER_COLLECT || !eS.equals(com.baidu.tbadk.imageManager.d.aGm)) {
                this.crt.setTag(eS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eS;
                if (eS.startsWith("#(meme,")) {
                    this.crt.setShowStaticDrawable(false);
                } else {
                    this.crt.setShowStaticDrawable(true);
                }
                this.crt.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cru.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.crs.x = this.rect.left - ((this.crs.width - linearLayout.getWidth()) / 2);
                this.crs.y = (this.rect.top - this.crs.height) + this.crx;
                this.crt.setVisibility(0);
                if (!this.cry) {
                    this.mWindowManager.addView(this.crt, this.crs);
                    this.cry = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.crt, this.crs);
                }
                gridView.setSelection(i);
                if (this.crz != -1) {
                    ((LinearLayout) gridView.getChildAt(this.crz - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.crz = i;
                this.crq = gridView;
            }
        }
    }

    private void ags() {
        if (this.cry && this.crt.getVisibility() != 8 && this.crq != null) {
            this.crq.setSelection(-1);
            this.crt.setVisibility(8);
            if (this.crz != -1) {
                ((LinearLayout) this.crq.getChildAt(this.crz - this.crq.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.crz = -1;
            this.crq = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.crH.set(x, y);
                break;
            case 1:
            case 3:
                ags();
                break;
            case 2:
                this.crH.set(x, y);
                if (this.cry && this.crt.getVisibility() != 8 && this.crq != null) {
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
                this.crH.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                ags();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    ags();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.crq != null) {
                        offsetRectIntoDescendantCoords(this.crq, this.rect);
                        int pointToPosition = this.crq.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.crq);
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
        if (this.cry) {
            this.mWindowManager.removeView(this.crt);
            this.cry = false;
        }
        MessageManager.getInstance().unRegisterListener(this.TF);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.crC != null) {
            int size = this.crC.size();
            if (i >= 0 && i < size) {
                this.crA = this.crC.get(i);
                if (this.aEz != null && this.crA != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEz.setVisibility(this.crA.agB() > 1 ? 0 : 4);
                        this.aEz.setCount(this.crA.agB());
                        if (this.crA != null && this.crA.agF() != this.crE) {
                            this.crE = this.crA.agF();
                            if (this.crF != null) {
                                this.crF.jg(this.crA.agF());
                            }
                        }
                    }
                    float agC = this.crA.agC() + f;
                    this.aEz.setPosition(agC);
                    this.crr.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) agC) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.crA.agB())));
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
        this.apD = i;
        aj.d(this.crt, d.f.bg_expression_bubble, i);
        aj.e(this, d.C0096d.cp_bg_line_d, i);
        this.aEz.setSelector(aj.v(i, d.f.dot_pb_expression_s));
        this.aEz.setDrawable(aj.v(i, d.f.dot_pb_expression_n));
        if (this.aEy != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aEy.getChildCount()) {
                    View childAt = this.aEy.getChildAt(i3);
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
        ags();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d crK;

        public a(d dVar) {
            this.crK = dVar;
        }

        public void a(d dVar) {
            this.crK = dVar;
        }

        public int agu() {
            if (this.crK == null) {
                return 0;
            }
            return this.crK.agE();
        }

        public d agv() {
            return this.crK;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.crK == null) {
                return 0;
            }
            return this.crK.agD();
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
                if (this.crK.agA() != 0) {
                    i2 = measuredWidth / this.crK.agA();
                }
                if (this.crK.getRow() != 0) {
                    i3 = measuredHeight / this.crK.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.crx * 2, EmotionTabContentView.this.crx * 2, EmotionTabContentView.this.crx * 2, EmotionTabContentView.this.crx * 2);
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
            if (this.crK != null) {
                int agE = this.crK.agE() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.apD);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eS = this.crK.agy().eS(agE);
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
                if (this.crK.agz() == EmotionGroupType.BIG_EMOTION) {
                    String eS2 = this.crK.agy().eS(agE);
                    if (!TextUtils.isEmpty(eS2) && !eS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.apD == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0096d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0096d.cp_cont_c);
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
            if (EmotionTabContentView.this.crC == null) {
                return 0;
            }
            return EmotionTabContentView.this.crC.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.crI.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.crI.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.crC != null && i < EmotionTabContentView.this.crC.size()) {
                d dVar = (d) EmotionTabContentView.this.crC.get(i);
                gridView2.setNumColumns(dVar.agA());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0096d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.agv() == null) {
                            return false;
                        }
                        d agv = aVar.agv();
                        if (agv.agz() == EmotionGroupType.BIG_EMOTION || agv.agz() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.IR != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.agv() != null) {
                                d agv = aVar.agv();
                                int agu = aVar.agu();
                                com.baidu.tbadk.editortools.emotiontool.c agy = agv.agy();
                                String eS = agv.agy().eS(agu + i2);
                                if (agy.Dt() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGm.equals(eS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(eS);
                                nVar.a(agy.Dt());
                                nVar.eH(agy.getGroupName());
                                nVar.eI(agy.getGroupId());
                                nVar.setWidth(agy.getWidth());
                                nVar.setHeight(agy.getHeight());
                                EmotionTabContentView.this.IR.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.crC != null) {
                int size = EmotionTabContentView.this.crC.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.crC.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEz.setVisibility(dVar.agB() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEz.setCount(dVar.agB());
                        EmotionTabContentView.this.aEz.setPosition(dVar.agC());
                        EmotionTabContentView.this.aEz.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.agC() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.agB())));
                    }
                    if (dVar != null && dVar.agF() != EmotionTabContentView.this.crE) {
                        EmotionTabContentView.this.crE = dVar.agF();
                        if (EmotionTabContentView.this.crF != null) {
                            EmotionTabContentView.this.crF.jg(dVar.agF());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.crF = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.IR = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TF);
    }
}
