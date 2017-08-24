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
    private CustomMessageListener TE;
    private IndicatorView aEJ;
    private int aqm;
    private b bXe;
    private GridView bXf;
    private LinearLayout bXg;
    private WindowManager.LayoutParams bXh;
    private GifView bXi;
    private ViewGroup bXj;
    private int bXk;
    private int bXl;
    private int bXm;
    private boolean bXn;
    private int bXo;
    private d bXp;
    private List<com.baidu.tbadk.editortools.emotiontool.c> bXq;
    private List<d> bXr;
    private int bXs;
    private int bXt;
    private c bXu;
    private int bXv;
    private final Point bXw;
    private com.baidu.adp.lib.e.b<GridView> bXx;
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
        this.bXo = -1;
        this.bXs = 0;
        this.bXt = -1;
        this.currentPosition = -1;
        this.bXw = new Point();
        this.TE = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bXq));
                        if (EmotionTabContentView.this.bXe != null) {
                            EmotionTabContentView.this.bXe.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bXt < 0 || EmotionTabContentView.this.bXt >= EmotionTabContentView.this.bXq.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bXq.get(EmotionTabContentView.this.bXt)).Dp() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bXe != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bXr.size()) {
                                    EmotionTabContentView.this.bXp = (d) EmotionTabContentView.this.bXr.get(EmotionTabContentView.this.currentPosition);
                                    int abp = EmotionTabContentView.this.bXp.abp();
                                    EmotionTabContentView.this.aEJ.setCount(abp);
                                    EmotionTabContentView.this.aEJ.setVisibility(abp > 1 ? 0 : 4);
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
                                                    int index = aVar.abj().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bXr.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bXr.get(index));
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
        this.bXo = -1;
        this.bXs = 0;
        this.bXt = -1;
        this.currentPosition = -1;
        this.bXw = new Point();
        this.TE = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.am(new ArrayList(EmotionTabContentView.this.bXq));
                        if (EmotionTabContentView.this.bXe != null) {
                            EmotionTabContentView.this.bXe.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.bXt < 0 || EmotionTabContentView.this.bXt >= EmotionTabContentView.this.bXq.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.bXq.get(EmotionTabContentView.this.bXt)).Dp() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.bXe != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.bXr.size()) {
                                    EmotionTabContentView.this.bXp = (d) EmotionTabContentView.this.bXr.get(EmotionTabContentView.this.currentPosition);
                                    int abp = EmotionTabContentView.this.bXp.abp();
                                    EmotionTabContentView.this.aEJ.setCount(abp);
                                    EmotionTabContentView.this.aEJ.setVisibility(abp > 1 ? 0 : 4);
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
                                                    int index = aVar.abj().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.bXr.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.bXr.get(index));
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
        this.bXq = new ArrayList();
        this.bXr = new ArrayList();
        this.bXx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: abh */
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
        this.bXi = new GifView(context);
        ai.d(this.bXi, d.g.bg_expression_bubble, this.aqm);
        this.bXi.setVisibility(8);
        this.jn = (WindowManager) context.getSystemService("window");
        this.bXh = new WindowManager.LayoutParams();
        this.bXk = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.bXl = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.bXm = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.bXh.width = this.bXk;
        this.bXh.height = this.bXl;
        this.bXh.gravity = 51;
        this.bXh.format = -3;
        this.bXh.type = 1000;
        this.bXh.flags |= 56;
        this.bXj = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEJ = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.bXg = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.bXg.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.bXh.type = 1000;
            this.bXh.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.bXq.clear();
        this.bXr.clear();
        if (list != null && !list.isEmpty()) {
            this.bXq.addAll(list);
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
                        this.bXr.add(dVar);
                    }
                }
            }
            this.bXs = this.bXr.size();
            for (int i6 = 0; i6 < this.bXs; i6++) {
                if (this.bXr != null && this.bXr.get(i6) != null) {
                    this.bXr.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void hU(int i) {
        if (this.bXr != null) {
            int size = this.bXr.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.bXr.get(i2);
                    if (dVar != null && dVar.abt() == i) {
                        this.bXv = dVar.getIndex();
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
                this.bXe = new b();
                this.mViewPager.setAdapter(this.bXe);
                this.mViewPager.setCurrentItem(this.bXv, true);
                if (this.bXu != null) {
                    this.bXu.hW(i);
                    this.bXt = i;
                }
            }
        }
    }

    public void hV(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.bXr.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.bXr.get(i3);
                        if (dVar == null || dVar.abt() != i) {
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
        if (this.bXo != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.abj() != null) {
            d abj = aVar.abj();
            String eH = abj.abm().eH(aVar.abi() + i);
            if (abj.abn() != EmotionGroupType.USER_COLLECT || !eH.equals(com.baidu.tbadk.imageManager.d.aGs)) {
                this.bXi.setTag(eH);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eH;
                if (eH.startsWith("#(meme,")) {
                    this.bXi.setShowStaticDrawable(false);
                } else {
                    this.bXi.setShowStaticDrawable(true);
                }
                this.bXi.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.bXj.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.bXh.x = this.rect.left - ((this.bXh.width - linearLayout.getWidth()) / 2);
                this.bXh.y = (this.rect.top - this.bXh.height) + this.bXm;
                this.bXi.setVisibility(0);
                if (!this.bXn) {
                    this.jn.addView(this.bXi, this.bXh);
                    this.bXn = true;
                } else {
                    this.jn.updateViewLayout(this.bXi, this.bXh);
                }
                gridView.setSelection(i);
                if (this.bXo != -1) {
                    ((LinearLayout) gridView.getChildAt(this.bXo - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.bXo = i;
                this.bXf = gridView;
            }
        }
    }

    private void abg() {
        if (this.bXn && this.bXi.getVisibility() != 8 && this.bXf != null) {
            this.bXf.setSelection(-1);
            this.bXi.setVisibility(8);
            if (this.bXo != -1) {
                ((LinearLayout) this.bXf.getChildAt(this.bXo - this.bXf.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.bXo = -1;
            this.bXf = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.bXw.set(x, y);
                break;
            case 1:
            case 3:
                abg();
                break;
            case 2:
                this.bXw.set(x, y);
                if (this.bXn && this.bXi.getVisibility() != 8 && this.bXf != null) {
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
                this.bXw.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                abg();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    abg();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.bXf != null) {
                        offsetRectIntoDescendantCoords(this.bXf, this.rect);
                        int pointToPosition = this.bXf.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.bXf);
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
        if (this.bXn) {
            this.jn.removeView(this.bXi);
            this.bXn = false;
        }
        MessageManager.getInstance().unRegisterListener(this.TE);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bXr != null) {
            int size = this.bXr.size();
            if (i >= 0 && i < size) {
                this.bXp = this.bXr.get(i);
                if (this.aEJ != null && this.bXp != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEJ.setVisibility(this.bXp.abp() > 1 ? 0 : 4);
                        this.aEJ.setCount(this.bXp.abp());
                        if (this.bXp != null && this.bXp.abt() != this.bXt) {
                            this.bXt = this.bXp.abt();
                            if (this.bXu != null) {
                                this.bXu.hW(this.bXp.abt());
                            }
                        }
                    }
                    float abq = this.bXp.abq() + f;
                    this.aEJ.setPosition(abq);
                    this.bXg.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) abq) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.bXp.abp())));
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
        ai.d(this.bXi, d.g.bg_expression_bubble, i);
        ai.e(this, d.e.common_color_10255, i);
        this.aEJ.setSelector(ai.v(i, d.g.dot_pb_expression_s));
        this.aEJ.setDrawable(ai.v(i, d.g.dot_pb_expression_n));
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
        abg();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d bXz;

        public a(d dVar) {
            this.bXz = dVar;
        }

        public void a(d dVar) {
            this.bXz = dVar;
        }

        public int abi() {
            if (this.bXz == null) {
                return 0;
            }
            return this.bXz.abs();
        }

        public d abj() {
            return this.bXz;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bXz == null) {
                return 0;
            }
            return this.bXz.abr();
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
                if (this.bXz.abo() != 0) {
                    i2 = measuredWidth / this.bXz.abo();
                }
                if (this.bXz.getRow() != 0) {
                    i3 = measuredHeight / this.bXz.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.bXm * 2, EmotionTabContentView.this.bXm * 2, EmotionTabContentView.this.bXm * 2, EmotionTabContentView.this.bXm * 2);
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
            if (this.bXz != null) {
                int abs = this.bXz.abs() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ai.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.aqm);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eH = this.bXz.abm().eH(abs);
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
                if (this.bXz.abn() == EmotionGroupType.BIG_EMOTION) {
                    String eH2 = this.bXz.abm().eH(abs);
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
            if (EmotionTabContentView.this.bXr == null) {
                return 0;
            }
            return EmotionTabContentView.this.bXr.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.bXx.n(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.bXx.fS();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.bXr != null && i < EmotionTabContentView.this.bXr.size()) {
                d dVar = (d) EmotionTabContentView.this.bXr.get(i);
                gridView2.setNumColumns(dVar.abo());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.abj() == null) {
                            return false;
                        }
                        d abj = aVar.abj();
                        if (abj.abn() == EmotionGroupType.BIG_EMOTION || abj.abn() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.abj() != null) {
                                d abj = aVar.abj();
                                int abi = aVar.abi();
                                com.baidu.tbadk.editortools.emotiontool.c abm = abj.abm();
                                String eH = abj.abm().eH(abi + i2);
                                if (abm.Dp() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGs.equals(eH)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eH);
                                lVar.a(abm.Dp());
                                lVar.eI(abm.getGroupName());
                                lVar.eJ(abm.getGroupId());
                                lVar.setWidth(abm.getWidth());
                                lVar.setHeight(abm.getHeight());
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
            if (EmotionTabContentView.this.bXr != null) {
                int size = EmotionTabContentView.this.bXr.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.bXr.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEJ.setVisibility(dVar.abp() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEJ.setCount(dVar.abp());
                        EmotionTabContentView.this.aEJ.setPosition(dVar.abq());
                        EmotionTabContentView.this.aEJ.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.abq() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.abp())));
                    }
                    if (dVar != null && dVar.abt() != EmotionTabContentView.this.bXt) {
                        EmotionTabContentView.this.bXt = dVar.abt();
                        if (EmotionTabContentView.this.bXu != null) {
                            EmotionTabContentView.this.bXu.hW(dVar.abt());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.bXu = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.Lt = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TE);
    }
}
