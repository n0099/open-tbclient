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
    private i Jb;
    private CustomMessageListener Tc;
    private ViewPager aDL;
    private IndicatorView aDM;
    private int api;
    private int ciA;
    private int ciB;
    private c ciC;
    private int ciD;
    private final Point ciE;
    private com.baidu.adp.lib.e.b<GridView> ciF;
    private b cim;
    private GridView cin;
    private LinearLayout cio;
    private WindowManager.LayoutParams cip;
    private GifView ciq;
    private ViewGroup cir;
    private int cis;
    private int cit;
    private int ciu;
    private boolean civ;
    private int ciw;
    private d cix;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ciy;
    private List<d> ciz;
    private int currentPosition;
    private Context mContext;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void iI(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.ciw = -1;
        this.ciA = 0;
        this.ciB = -1;
        this.currentPosition = -1;
        this.ciE = new Point();
        this.Tc = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.an(new ArrayList(EmotionTabContentView.this.ciy));
                        if (EmotionTabContentView.this.cim != null) {
                            EmotionTabContentView.this.cim.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ciB < 0 || EmotionTabContentView.this.ciB >= EmotionTabContentView.this.ciy.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ciy.get(EmotionTabContentView.this.ciB)).CW() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cim != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.ciz.size()) {
                                    EmotionTabContentView.this.cix = (d) EmotionTabContentView.this.ciz.get(EmotionTabContentView.this.currentPosition);
                                    int aev = EmotionTabContentView.this.cix.aev();
                                    EmotionTabContentView.this.aDM.setCount(aev);
                                    EmotionTabContentView.this.aDM.setVisibility(aev > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aDL == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aDL.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aDL.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.aep().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ciz.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.ciz.get(index));
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
        this.ciw = -1;
        this.ciA = 0;
        this.ciB = -1;
        this.currentPosition = -1;
        this.ciE = new Point();
        this.Tc = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.an(new ArrayList(EmotionTabContentView.this.ciy));
                        if (EmotionTabContentView.this.cim != null) {
                            EmotionTabContentView.this.cim.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.ciB < 0 || EmotionTabContentView.this.ciB >= EmotionTabContentView.this.ciy.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ciy.get(EmotionTabContentView.this.ciB)).CW() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cim != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.ciz.size()) {
                                    EmotionTabContentView.this.cix = (d) EmotionTabContentView.this.ciz.get(EmotionTabContentView.this.currentPosition);
                                    int aev = EmotionTabContentView.this.cix.aev();
                                    EmotionTabContentView.this.aDM.setCount(aev);
                                    EmotionTabContentView.this.aDM.setVisibility(aev > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aDL == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aDL.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aDL.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.aep().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.ciz.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.ciz.get(index));
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
        this.ciy = new ArrayList();
        this.ciz = new ArrayList();
        this.ciF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aen */
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
        this.aDL = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.aDL.setFadingEdgeLength(0);
        this.aDL.setOnPageChangeListener(this);
        this.ciq = new GifView(context);
        aj.d(this.ciq, d.f.bg_expression_bubble, this.api);
        this.ciq.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cip = new WindowManager.LayoutParams();
        this.cis = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.cit = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.ciu = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.cip.width = this.cis;
        this.cip.height = this.cit;
        this.cip.gravity = 51;
        this.cip.format = -3;
        this.cip.type = 1000;
        this.cip.flags |= 56;
        this.cir = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aDM = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cio = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cio.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cip.type = 1000;
            this.cip.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ciy.clear();
        this.ciz.clear();
        if (list != null && !list.isEmpty()) {
            this.ciy.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CZ = cVar.CZ();
                    int i4 = emotionsCount / (cols * CZ);
                    if (emotionsCount % (cols * CZ) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * CZ;
                        } else {
                            i = emotionsCount - ((cols * CZ) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.iN(i3);
                        dVar.b(cVar.CW());
                        dVar.fc(CZ);
                        dVar.fb(cols);
                        dVar.iJ(i4);
                        dVar.iK(i5);
                        dVar.iL(i);
                        dVar.iM(i5 * cols * CZ);
                        dVar.setEndIndex((i + i2) - 1);
                        this.ciz.add(dVar);
                    }
                }
            }
            this.ciA = this.ciz.size();
            for (int i6 = 0; i6 < this.ciA; i6++) {
                if (this.ciz != null && this.ciz.get(i6) != null) {
                    this.ciz.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void iG(int i) {
        if (this.ciz != null) {
            int size = this.ciz.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.ciz.get(i2);
                    if (dVar != null && dVar.aez() == i) {
                        this.ciD = dVar.getIndex();
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
                iG(i);
                this.cim = new b();
                this.aDL.setAdapter(this.cim);
                this.aDL.setCurrentItem(this.ciD, true);
                if (this.ciC != null) {
                    this.ciC.iI(i);
                    this.ciB = i;
                }
            }
        }
    }

    public void iH(int i) {
        int i2;
        if (this.aDL != null) {
            int size = this.ciz.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.ciz.get(i3);
                        if (dVar == null || dVar.aez() != i) {
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
                this.aDL.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.ciw != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.aep() != null) {
            d aep = aVar.aep();
            String eS = aep.aes().eS(aVar.aeo() + i);
            if (aep.aet() != EmotionGroupType.USER_COLLECT || !eS.equals(com.baidu.tbadk.imageManager.d.aFz)) {
                this.ciq.setTag(eS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eS;
                if (eS.startsWith("#(meme,")) {
                    this.ciq.setShowStaticDrawable(false);
                } else {
                    this.ciq.setShowStaticDrawable(true);
                }
                this.ciq.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cir.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cip.x = this.rect.left - ((this.cip.width - linearLayout.getWidth()) / 2);
                this.cip.y = (this.rect.top - this.cip.height) + this.ciu;
                this.ciq.setVisibility(0);
                if (!this.civ) {
                    this.mWindowManager.addView(this.ciq, this.cip);
                    this.civ = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.ciq, this.cip);
                }
                gridView.setSelection(i);
                if (this.ciw != -1) {
                    ((LinearLayout) gridView.getChildAt(this.ciw - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.ciw = i;
                this.cin = gridView;
            }
        }
    }

    private void aem() {
        if (this.civ && this.ciq.getVisibility() != 8 && this.cin != null) {
            this.cin.setSelection(-1);
            this.ciq.setVisibility(8);
            if (this.ciw != -1) {
                ((LinearLayout) this.cin.getChildAt(this.ciw - this.cin.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ciw = -1;
            this.cin = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ciE.set(x, y);
                break;
            case 1:
            case 3:
                aem();
                break;
            case 2:
                this.ciE.set(x, y);
                if (this.civ && this.ciq.getVisibility() != 8 && this.cin != null) {
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
                this.ciE.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                aem();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    aem();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cin != null) {
                        offsetRectIntoDescendantCoords(this.cin, this.rect);
                        int pointToPosition = this.cin.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cin);
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
        if (this.civ) {
            this.mWindowManager.removeView(this.ciq);
            this.civ = false;
        }
        MessageManager.getInstance().unRegisterListener(this.Tc);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ciz != null) {
            int size = this.ciz.size();
            if (i >= 0 && i < size) {
                this.cix = this.ciz.get(i);
                if (this.aDM != null && this.cix != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aDM.setVisibility(this.cix.aev() > 1 ? 0 : 4);
                        this.aDM.setCount(this.cix.aev());
                        if (this.cix != null && this.cix.aez() != this.ciB) {
                            this.ciB = this.cix.aez();
                            if (this.ciC != null) {
                                this.ciC.iI(this.cix.aez());
                            }
                        }
                    }
                    float aew = this.cix.aew() + f;
                    this.aDM.setPosition(aew);
                    this.cio.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) aew) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.cix.aev())));
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
        this.api = i;
        aj.d(this.ciq, d.f.bg_expression_bubble, i);
        aj.e(this, d.C0080d.common_color_10255, i);
        this.aDM.setSelector(aj.u(i, d.f.dot_pb_expression_s));
        this.aDM.setDrawable(aj.u(i, d.f.dot_pb_expression_n));
        if (this.aDL != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aDL.getChildCount()) {
                    View childAt = this.aDL.getChildAt(i3);
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
        aem();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d ciH;

        public a(d dVar) {
            this.ciH = dVar;
        }

        public void a(d dVar) {
            this.ciH = dVar;
        }

        public int aeo() {
            if (this.ciH == null) {
                return 0;
            }
            return this.ciH.aey();
        }

        public d aep() {
            return this.ciH;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ciH == null) {
                return 0;
            }
            return this.ciH.aex();
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
                if (this.ciH.aeu() != 0) {
                    i2 = measuredWidth / this.ciH.aeu();
                }
                if (this.ciH.getRow() != 0) {
                    i3 = measuredHeight / this.ciH.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.ciu * 2, EmotionTabContentView.this.ciu * 2, EmotionTabContentView.this.ciu * 2, EmotionTabContentView.this.ciu * 2);
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
            if (this.ciH != null) {
                int aey = this.ciH.aey() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.api);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eS = this.ciH.aes().eS(aey);
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
                if (this.ciH.aet() == EmotionGroupType.BIG_EMOTION) {
                    String eS2 = this.ciH.aes().eS(aey);
                    if (!TextUtils.isEmpty(eS2) && !eS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.api == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0080d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0080d.cp_cont_c);
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
            if (EmotionTabContentView.this.ciz == null) {
                return 0;
            }
            return EmotionTabContentView.this.ciz.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.ciF.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.ciF.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.ciz != null && i < EmotionTabContentView.this.ciz.size()) {
                d dVar = (d) EmotionTabContentView.this.ciz.get(i);
                gridView2.setNumColumns(dVar.aeu());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0080d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.aep() == null) {
                            return false;
                        }
                        d aep = aVar.aep();
                        if (aep.aet() == EmotionGroupType.BIG_EMOTION || aep.aet() == EmotionGroupType.USER_COLLECT) {
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
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.aep() != null) {
                                d aep = aVar.aep();
                                int aeo = aVar.aeo();
                                com.baidu.tbadk.editortools.emotiontool.c aes = aep.aes();
                                String eS = aep.aes().eS(aeo + i2);
                                if (aes.CW() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aFz.equals(eS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eS);
                                lVar.a(aes.CW());
                                lVar.eC(aes.getGroupName());
                                lVar.eD(aes.getGroupId());
                                lVar.setWidth(aes.getWidth());
                                lVar.setHeight(aes.getHeight());
                                EmotionTabContentView.this.Jb.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
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
            if (EmotionTabContentView.this.ciz != null) {
                int size = EmotionTabContentView.this.ciz.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.ciz.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aDM.setVisibility(dVar.aev() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aDM.setCount(dVar.aev());
                        EmotionTabContentView.this.aDM.setPosition(dVar.aew());
                        EmotionTabContentView.this.aDM.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.aew() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.aev())));
                    }
                    if (dVar != null && dVar.aez() != EmotionTabContentView.this.ciB) {
                        EmotionTabContentView.this.ciB = dVar.aez();
                        if (EmotionTabContentView.this.ciC != null) {
                            EmotionTabContentView.this.ciC.iI(dVar.aez());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.ciC = cVar;
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
