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
    private i Jp;
    private CustomMessageListener SH;
    private IndicatorView aDX;
    private int apQ;
    private b caS;
    private GridView caT;
    private LinearLayout caU;
    private WindowManager.LayoutParams caV;
    private GifView caW;
    private ViewGroup caX;
    private int caY;
    private int caZ;
    private int cba;
    private boolean cbb;
    private int cbc;
    private d cbd;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cbe;
    private List<d> cbf;
    private int cbg;
    private int cbh;
    private c cbi;
    private int cbj;
    private final Point cbk;
    private com.baidu.adp.lib.e.b<GridView> cbl;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void ii(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cbc = -1;
        this.cbg = 0;
        this.cbh = -1;
        this.currentPosition = -1;
        this.cbk = new Point();
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.cbe));
                        if (EmotionTabContentView.this.caS != null) {
                            EmotionTabContentView.this.caS.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cbh < 0 || EmotionTabContentView.this.cbh >= EmotionTabContentView.this.cbe.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cbe.get(EmotionTabContentView.this.cbh)).Dk() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caS != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cbf.size()) {
                                    EmotionTabContentView.this.cbd = (d) EmotionTabContentView.this.cbf.get(EmotionTabContentView.this.currentPosition);
                                    int acD = EmotionTabContentView.this.cbd.acD();
                                    EmotionTabContentView.this.aDX.setCount(acD);
                                    EmotionTabContentView.this.aDX.setVisibility(acD > 1 ? 0 : 4);
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
                                                    int index = aVar.acx().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cbf.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.cbf.get(index));
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
        this.cbc = -1;
        this.cbg = 0;
        this.cbh = -1;
        this.currentPosition = -1;
        this.cbk = new Point();
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.cbe));
                        if (EmotionTabContentView.this.caS != null) {
                            EmotionTabContentView.this.caS.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cbh < 0 || EmotionTabContentView.this.cbh >= EmotionTabContentView.this.cbe.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cbe.get(EmotionTabContentView.this.cbh)).Dk() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caS != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cbf.size()) {
                                    EmotionTabContentView.this.cbd = (d) EmotionTabContentView.this.cbf.get(EmotionTabContentView.this.currentPosition);
                                    int acD = EmotionTabContentView.this.cbd.acD();
                                    EmotionTabContentView.this.aDX.setCount(acD);
                                    EmotionTabContentView.this.aDX.setVisibility(acD > 1 ? 0 : 4);
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
                                                    int index = aVar.acx().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cbf.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.cbf.get(index));
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
        this.cbe = new ArrayList();
        this.cbf = new ArrayList();
        this.cbl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: acv */
            public GridView fJ() {
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
        this.caW = new GifView(context);
        aj.d(this.caW, d.g.bg_expression_bubble, this.apQ);
        this.caW.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.caV = new WindowManager.LayoutParams();
        this.caY = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.caZ = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.cba = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.caV.width = this.caY;
        this.caV.height = this.caZ;
        this.caV.gravity = 51;
        this.caV.format = -3;
        this.caV.type = 1000;
        this.caV.flags |= 56;
        this.caX = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aDX = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.caU = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.caU.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.caV.type = 1000;
            this.caV.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cbe.clear();
        this.cbf.clear();
        if (list != null && !list.isEmpty()) {
            this.cbe.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dn = cVar.Dn();
                    int i4 = emotionsCount / (cols * Dn);
                    if (emotionsCount % (cols * Dn) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Dn;
                        } else {
                            i = emotionsCount - ((cols * Dn) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.in(i3);
                        dVar.b(cVar.Dk());
                        dVar.eR(Dn);
                        dVar.eQ(cols);
                        dVar.ij(i4);
                        dVar.ik(i5);
                        dVar.il(i);
                        dVar.im(i5 * cols * Dn);
                        dVar.setEndIndex((i + i2) - 1);
                        this.cbf.add(dVar);
                    }
                }
            }
            this.cbg = this.cbf.size();
            for (int i6 = 0; i6 < this.cbg; i6++) {
                if (this.cbf != null && this.cbf.get(i6) != null) {
                    this.cbf.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void ig(int i) {
        if (this.cbf != null) {
            int size = this.cbf.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.cbf.get(i2);
                    if (dVar != null && dVar.acH() == i) {
                        this.cbj = dVar.getIndex();
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
                am(list);
                ig(i);
                this.caS = new b();
                this.mViewPager.setAdapter(this.caS);
                this.mViewPager.setCurrentItem(this.cbj, true);
                if (this.cbi != null) {
                    this.cbi.ii(i);
                    this.cbh = i;
                }
            }
        }
    }

    public void ih(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cbf.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.cbf.get(i3);
                        if (dVar == null || dVar.acH() != i) {
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
        if (this.cbc != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.acx() != null) {
            d acx = aVar.acx();
            String eH = acx.acA().eH(aVar.acw() + i);
            if (acx.acB() != EmotionGroupType.USER_COLLECT || !eH.equals(com.baidu.tbadk.imageManager.d.aFH)) {
                this.caW.setTag(eH);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eH;
                if (eH.startsWith("#(meme,")) {
                    this.caW.setShowStaticDrawable(false);
                } else {
                    this.caW.setShowStaticDrawable(true);
                }
                this.caW.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.caX.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.caV.x = this.rect.left - ((this.caV.width - linearLayout.getWidth()) / 2);
                this.caV.y = (this.rect.top - this.caV.height) + this.cba;
                this.caW.setVisibility(0);
                if (!this.cbb) {
                    this.mWindowManager.addView(this.caW, this.caV);
                    this.cbb = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.caW, this.caV);
                }
                gridView.setSelection(i);
                if (this.cbc != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cbc - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cbc = i;
                this.caT = gridView;
            }
        }
    }

    private void acu() {
        if (this.cbb && this.caW.getVisibility() != 8 && this.caT != null) {
            this.caT.setSelection(-1);
            this.caW.setVisibility(8);
            if (this.cbc != -1) {
                ((LinearLayout) this.caT.getChildAt(this.cbc - this.caT.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cbc = -1;
            this.caT = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cbk.set(x, y);
                break;
            case 1:
            case 3:
                acu();
                break;
            case 2:
                this.cbk.set(x, y);
                if (this.cbb && this.caW.getVisibility() != 8 && this.caT != null) {
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
                this.cbk.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                acu();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    acu();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.caT != null) {
                        offsetRectIntoDescendantCoords(this.caT, this.rect);
                        int pointToPosition = this.caT.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.caT);
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
        if (this.cbb) {
            this.mWindowManager.removeView(this.caW);
            this.cbb = false;
        }
        MessageManager.getInstance().unRegisterListener(this.SH);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cbf != null) {
            int size = this.cbf.size();
            if (i >= 0 && i < size) {
                this.cbd = this.cbf.get(i);
                if (this.aDX != null && this.cbd != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aDX.setVisibility(this.cbd.acD() > 1 ? 0 : 4);
                        this.aDX.setCount(this.cbd.acD());
                        if (this.cbd != null && this.cbd.acH() != this.cbh) {
                            this.cbh = this.cbd.acH();
                            if (this.cbi != null) {
                                this.cbi.ii(this.cbd.acH());
                            }
                        }
                    }
                    float acE = this.cbd.acE() + f;
                    this.aDX.setPosition(acE);
                    this.caU.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) acE) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.cbd.acD())));
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
        this.apQ = i;
        aj.d(this.caW, d.g.bg_expression_bubble, i);
        aj.e(this, d.e.common_color_10255, i);
        this.aDX.setSelector(aj.u(i, d.g.dot_pb_expression_s));
        this.aDX.setDrawable(aj.u(i, d.g.dot_pb_expression_n));
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
        acu();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d cbn;

        public a(d dVar) {
            this.cbn = dVar;
        }

        public void a(d dVar) {
            this.cbn = dVar;
        }

        public int acw() {
            if (this.cbn == null) {
                return 0;
            }
            return this.cbn.acG();
        }

        public d acx() {
            return this.cbn;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cbn == null) {
                return 0;
            }
            return this.cbn.acF();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.j.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.cbn.acC() != 0) {
                    i2 = measuredWidth / this.cbn.acC();
                }
                if (this.cbn.getRow() != 0) {
                    i3 = measuredHeight / this.cbn.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cba * 2, EmotionTabContentView.this.cba * 2, EmotionTabContentView.this.cba * 2, EmotionTabContentView.this.cba * 2);
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
            if (this.cbn != null) {
                int acG = this.cbn.acG() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.apQ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eH = this.cbn.acA().eH(acG);
                tbImageView.setTag(eH);
                if (!TextUtils.isEmpty(eH)) {
                    Object a = com.baidu.adp.lib.f.c.fK().a(eH, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eH, false, null);
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
                TextView textView = (TextView) linearLayout3.findViewById(d.h.emotion_tab_content_tip);
                if (this.cbn.acB() == EmotionGroupType.BIG_EMOTION) {
                    String eH2 = this.cbn.acA().eH(acG);
                    if (!TextUtils.isEmpty(eH2) && !eH2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.apQ == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = aj.getColor(d.e.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eH2.substring(eH2.lastIndexOf("_") + 1, eH2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eH != null && eH.length() > 3) {
                    linearLayout3.setContentDescription(eH.substring(2, eH.length() - 1));
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
            if (EmotionTabContentView.this.cbf == null) {
                return 0;
            }
            return EmotionTabContentView.this.cbf.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cbl.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cbl.fI();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cbf != null && i < EmotionTabContentView.this.cbf.size()) {
                d dVar = (d) EmotionTabContentView.this.cbf.get(i);
                gridView2.setNumColumns(dVar.acC());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.acx() == null) {
                            return false;
                        }
                        d acx = aVar.acx();
                        if (acx.acB() == EmotionGroupType.BIG_EMOTION || acx.acB() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Jp != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.acx() != null) {
                                d acx = aVar.acx();
                                int acw = aVar.acw();
                                com.baidu.tbadk.editortools.emotiontool.c acA = acx.acA();
                                String eH = acx.acA().eH(acw + i2);
                                if (acA.Dk() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aFH.equals(eH)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eH);
                                lVar.a(acA.Dk());
                                lVar.eC(acA.getGroupName());
                                lVar.eD(acA.getGroupId());
                                lVar.setWidth(acA.getWidth());
                                lVar.setHeight(acA.getHeight());
                                EmotionTabContentView.this.Jp.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
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
            if (EmotionTabContentView.this.cbf != null) {
                int size = EmotionTabContentView.this.cbf.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.cbf.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aDX.setVisibility(dVar.acD() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aDX.setCount(dVar.acD());
                        EmotionTabContentView.this.aDX.setPosition(dVar.acE());
                        EmotionTabContentView.this.aDX.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.acE() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.acD())));
                    }
                    if (dVar != null && dVar.acH() != EmotionTabContentView.this.cbh) {
                        EmotionTabContentView.this.cbh = dVar.acH();
                        if (EmotionTabContentView.this.cbi != null) {
                            EmotionTabContentView.this.cbi.ii(dVar.acH());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.cbi = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.Jp = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SH);
    }
}
