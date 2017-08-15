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
import com.baidu.tbadk.core.util.ai;
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
    private i Lt;
    private CustomMessageListener TD;
    private IndicatorView aEI;
    private int aqm;
    private b bXd;
    private GridView bXe;
    private LinearLayout bXf;
    private WindowManager.LayoutParams bXg;
    private GifView bXh;
    private ViewGroup bXi;
    private int bXj;
    private int bXk;
    private int bXl;
    private boolean bXm;
    private int bXn;
    private d bXo;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bXp;
    private List<d> bXq;
    private int bXr;
    private int bXs;
    private c bXt;
    private int bXu;
    private final Point bXv;
    private com.baidu.adp.lib.e.b<GridView> bXw;
    private int currentPosition;
    private WindowManager jn;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void hW(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.bXn = -1;
        this.bXr = 0;
        this.bXs = -1;
        this.currentPosition = -1;
        this.bXv = new Point();
        this.TD = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bXp));
                        if (EmotionTabContentView.this.bXd != null) {
                            EmotionTabContentView.this.bXd.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bXs < 0 || EmotionTabContentView.this.bXs >= EmotionTabContentView.this.bXp.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bXp.get(EmotionTabContentView.this.bXs)).Dp() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bXd != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bXq.size()) {
                                    EmotionTabContentView.this.bXo = (d) EmotionTabContentView.this.bXq.get(EmotionTabContentView.this.currentPosition);
                                    int abs = EmotionTabContentView.this.bXo.abs();
                                    EmotionTabContentView.this.aEI.setCount(abs);
                                    EmotionTabContentView.this.aEI.setVisibility(abs > 1 ? 0 : 4);
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
                                                    int index = aVar.abm().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bXq.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bXq.get(index));
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
        this.bXn = -1;
        this.bXr = 0;
        this.bXs = -1;
        this.currentPosition = -1;
        this.bXv = new Point();
        this.TD = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bXp));
                        if (EmotionTabContentView.this.bXd != null) {
                            EmotionTabContentView.this.bXd.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bXs < 0 || EmotionTabContentView.this.bXs >= EmotionTabContentView.this.bXp.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bXp.get(EmotionTabContentView.this.bXs)).Dp() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bXd != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bXq.size()) {
                                    EmotionTabContentView.this.bXo = (d) EmotionTabContentView.this.bXq.get(EmotionTabContentView.this.currentPosition);
                                    int abs = EmotionTabContentView.this.bXo.abs();
                                    EmotionTabContentView.this.aEI.setCount(abs);
                                    EmotionTabContentView.this.aEI.setVisibility(abs > 1 ? 0 : 4);
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
                                                    int index = aVar.abm().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bXq.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bXq.get(index));
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
        this.bXp = new ArrayList();
        this.bXq = new ArrayList();
        this.bXw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: abk */
            public GridView fT() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView p(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView q(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.j.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.h.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.bXh = new GifView(context);
        ai.d(this.bXh, d.g.bg_expression_bubble, this.aqm);
        this.bXh.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bXg = new WindowManager.LayoutParams();
        this.bXj = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.bXk = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.bXl = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.bXg.width = this.bXj;
        this.bXg.height = this.bXk;
        this.bXg.gravity = 51;
        this.bXg.format = -3;
        this.bXg.type = 1000;
        this.bXg.flags |= 56;
        this.bXi = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEI = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.bXf = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.bXf.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bXg.type = 1000;
            this.bXg.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bXp.clear();
        this.bXq.clear();
        if (list != null && !list.isEmpty()) {
            this.bXp.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Ds = cVar.Ds();
                    int i4 = emotionsCount / (cols * Ds);
                    if (emotionsCount % (cols * Ds) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Ds;
                        } else {
                            i = emotionsCount - ((cols * Ds) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.ib(i3);
                        dVar.b(cVar.Dp());
                        dVar.eR(Ds);
                        dVar.eQ(cols);
                        dVar.hX(i4);
                        dVar.hY(i5);
                        dVar.hZ(i);
                        dVar.ia(i5 * cols * Ds);
                        dVar.setEndIndex((i + i2) - 1);
                        this.bXq.add(dVar);
                    }
                }
            }
            this.bXr = this.bXq.size();
            for (int i6 = 0; i6 < this.bXr; i6++) {
                if (this.bXq != null && this.bXq.get(i6) != null) {
                    this.bXq.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hU(int i) {
        if (this.bXq != null) {
            int size = this.bXq.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.bXq.get(i2);
                    if (dVar != null && dVar.abw() == i) {
                        this.bXu = dVar.getIndex();
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
                hU(i);
                this.bXd = new b();
                this.mViewPager.setAdapter(this.bXd);
                this.mViewPager.setCurrentItem(this.bXu, true);
                if (this.bXt != null) {
                    this.bXt.hW(i);
                    this.bXs = i;
                }
            }
        }
    }

    public void hV(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bXq.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.bXq.get(i3);
                        if (dVar == null || dVar.abw() != i) {
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
        if (this.bXn != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.abm() != null) {
            d abm = aVar.abm();
            String eH = abm.abp().eH(aVar.abl() + i);
            if (abm.abq() != EmotionGroupType.USER_COLLECT || !eH.equals(com.baidu.tbadk.imageManager.d.aGr)) {
                this.bXh.setTag(eH);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eH;
                if (eH.startsWith("#(meme,")) {
                    this.bXh.setShowStaticDrawable(false);
                } else {
                    this.bXh.setShowStaticDrawable(true);
                }
                this.bXh.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.bXi.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.bXg.x = this.rect.left - ((this.bXg.width - linearLayout.getWidth()) / 2);
                this.bXg.y = (this.rect.top - this.bXg.height) + this.bXl;
                this.bXh.setVisibility(0);
                if (!this.bXm) {
                    this.jn.addView(this.bXh, this.bXg);
                    this.bXm = true;
                } else {
                    this.jn.updateViewLayout(this.bXh, this.bXg);
                }
                gridView.setSelection(i);
                if (this.bXn != -1) {
                    ((LinearLayout) gridView.getChildAt(this.bXn - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.bXn = i;
                this.bXe = gridView;
            }
        }
    }

    private void abj() {
        if (this.bXm && this.bXh.getVisibility() != 8 && this.bXe != null) {
            this.bXe.setSelection(-1);
            this.bXh.setVisibility(8);
            if (this.bXn != -1) {
                ((LinearLayout) this.bXe.getChildAt(this.bXn - this.bXe.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bXn = -1;
            this.bXe = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bXv.set(x, y);
                break;
            case 1:
            case 3:
                abj();
                break;
            case 2:
                this.bXv.set(x, y);
                if (this.bXm && this.bXh.getVisibility() != 8 && this.bXe != null) {
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
                this.bXv.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                abj();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    abj();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bXe != null) {
                        offsetRectIntoDescendantCoords(this.bXe, this.rect);
                        int pointToPosition = this.bXe.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bXe);
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
        if (this.bXm) {
            this.jn.removeView(this.bXh);
            this.bXm = false;
        }
        MessageManager.getInstance().unRegisterListener(this.TD);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bXq != null) {
            int size = this.bXq.size();
            if (i >= 0 && i < size) {
                this.bXo = this.bXq.get(i);
                if (this.aEI != null && this.bXo != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEI.setVisibility(this.bXo.abs() > 1 ? 0 : 4);
                        this.aEI.setCount(this.bXo.abs());
                        if (this.bXo != null && this.bXo.abw() != this.bXs) {
                            this.bXs = this.bXo.abw();
                            if (this.bXt != null) {
                                this.bXt.hW(this.bXo.abw());
                            }
                        }
                    }
                    float abt = this.bXo.abt() + f;
                    this.aEI.setPosition(abt);
                    this.bXf.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) abt) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.bXo.abs())));
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
        this.aqm = i;
        ai.d(this.bXh, d.g.bg_expression_bubble, i);
        ai.e(this, d.e.common_color_10255, i);
        this.aEI.setSelector(ai.v(i, d.g.dot_pb_expression_s));
        this.aEI.setDrawable(ai.v(i, d.g.dot_pb_expression_n));
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
        abj();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d bXy;

        public a(d dVar) {
            this.bXy = dVar;
        }

        public void a(d dVar) {
            this.bXy = dVar;
        }

        public int abl() {
            if (this.bXy == null) {
                return 0;
            }
            return this.bXy.abv();
        }

        public d abm() {
            return this.bXy;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bXy == null) {
                return 0;
            }
            return this.bXy.abu();
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
                if (this.bXy.abr() != 0) {
                    i2 = measuredWidth / this.bXy.abr();
                }
                if (this.bXy.getRow() != 0) {
                    i3 = measuredHeight / this.bXy.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bXl * 2, EmotionTabContentView.this.bXl * 2, EmotionTabContentView.this.bXl * 2, EmotionTabContentView.this.bXl * 2);
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
            if (this.bXy != null) {
                int abv = this.bXy.abv() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ai.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.aqm);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eH = this.bXy.abp().eH(abv);
                tbImageView.setTag(eH);
                if (!TextUtils.isEmpty(eH)) {
                    Object a = com.baidu.adp.lib.f.c.fU().a(eH, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.e(tbImageView2);
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
                        aVar.e(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(d.h.emotion_tab_content_tip);
                if (this.bXy.abq() == EmotionGroupType.BIG_EMOTION) {
                    String eH2 = this.bXy.abp().eH(abv);
                    if (!TextUtils.isEmpty(eH2) && !eH2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aqm == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = ai.getColor(d.e.cp_cont_c);
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
            if (EmotionTabContentView.this.bXq == null) {
                return 0;
            }
            return EmotionTabContentView.this.bXq.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bXw.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bXw.fS();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bXq != null && i < EmotionTabContentView.this.bXq.size()) {
                d dVar = (d) EmotionTabContentView.this.bXq.get(i);
                gridView2.setNumColumns(dVar.abr());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.abm() == null) {
                            return false;
                        }
                        d abm = aVar.abm();
                        if (abm.abq() == EmotionGroupType.BIG_EMOTION || abm.abq() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Lt != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.abm() != null) {
                                d abm = aVar.abm();
                                int abl = aVar.abl();
                                com.baidu.tbadk.editortools.emotiontool.c abp = abm.abp();
                                String eH = abm.abp().eH(abl + i2);
                                if (abp.Dp() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGr.equals(eH)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eH);
                                lVar.a(abp.Dp());
                                lVar.eE(abp.getGroupName());
                                lVar.eF(abp.getGroupId());
                                lVar.setWidth(abp.getWidth());
                                lVar.setHeight(abp.getHeight());
                                EmotionTabContentView.this.Lt.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
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
            if (EmotionTabContentView.this.bXq != null) {
                int size = EmotionTabContentView.this.bXq.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.bXq.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEI.setVisibility(dVar.abs() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEI.setCount(dVar.abs());
                        EmotionTabContentView.this.aEI.setPosition(dVar.abt());
                        EmotionTabContentView.this.aEI.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.abt() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.abs())));
                    }
                    if (dVar != null && dVar.abw() != EmotionTabContentView.this.bXs) {
                        EmotionTabContentView.this.bXs = dVar.abw();
                        if (EmotionTabContentView.this.bXt != null) {
                            EmotionTabContentView.this.bXt.hW(dVar.abw());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bXt = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.Lt = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TD);
    }
}
