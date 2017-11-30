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
    private i IT;
    private CustomMessageListener TJ;
    private ViewPager aEt;
    private IndicatorView aEu;
    private int apA;
    private b crg;
    private GridView crh;
    private LinearLayout cri;
    private WindowManager.LayoutParams crj;
    private GifView crk;
    private ViewGroup crl;
    private int crm;
    private int crn;
    private int cro;
    private boolean crp;
    private int crq;
    private d crr;
    private List<com.baidu.tbadk.editortools.emotiontool.c> crs;
    private List<d> crt;
    private int cru;
    private int crv;
    private c crw;
    private int crx;
    private final Point cry;
    private com.baidu.adp.lib.e.b<GridView> crz;
    private int currentPosition;
    private Context mContext;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void je(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.crq = -1;
        this.cru = 0;
        this.crv = -1;
        this.currentPosition = -1;
        this.cry = new Point();
        this.TJ = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.az(new ArrayList(EmotionTabContentView.this.crs));
                        if (EmotionTabContentView.this.crg != null) {
                            EmotionTabContentView.this.crg.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.crv < 0 || EmotionTabContentView.this.crv >= EmotionTabContentView.this.crs.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.crs.get(EmotionTabContentView.this.crv)).Ds() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.crg != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.crt.size()) {
                                    EmotionTabContentView.this.crr = (d) EmotionTabContentView.this.crt.get(EmotionTabContentView.this.currentPosition);
                                    int agt = EmotionTabContentView.this.crr.agt();
                                    EmotionTabContentView.this.aEu.setCount(agt);
                                    EmotionTabContentView.this.aEu.setVisibility(agt > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aEt == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aEt.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aEt.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.agn().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.crt.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.crt.get(index));
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
        this.crq = -1;
        this.cru = 0;
        this.crv = -1;
        this.currentPosition = -1;
        this.cry = new Point();
        this.TJ = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.az(new ArrayList(EmotionTabContentView.this.crs));
                        if (EmotionTabContentView.this.crg != null) {
                            EmotionTabContentView.this.crg.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.crv < 0 || EmotionTabContentView.this.crv >= EmotionTabContentView.this.crs.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.crs.get(EmotionTabContentView.this.crv)).Ds() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.crg != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.crt.size()) {
                                    EmotionTabContentView.this.crr = (d) EmotionTabContentView.this.crt.get(EmotionTabContentView.this.currentPosition);
                                    int agt = EmotionTabContentView.this.crr.agt();
                                    EmotionTabContentView.this.aEu.setCount(agt);
                                    EmotionTabContentView.this.aEu.setVisibility(agt > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aEt == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aEt.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aEt.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.agn().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.crt.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.crt.get(index));
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
        this.crs = new ArrayList();
        this.crt = new ArrayList();
        this.crz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agl */
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
        this.aEt = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.aEt.setFadingEdgeLength(0);
        this.aEt.setOnPageChangeListener(this);
        this.crk = new GifView(context);
        aj.d(this.crk, d.f.bg_expression_bubble, this.apA);
        this.crk.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.crj = new WindowManager.LayoutParams();
        this.crm = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.crn = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.cro = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.crj.width = this.crm;
        this.crj.height = this.crn;
        this.crj.gravity = 51;
        this.crj.format = -3;
        this.crj.type = 1000;
        this.crj.flags |= 56;
        this.crl = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aEu = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.cri = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.cri.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.crj.type = 1000;
            this.crj.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.crs.clear();
        this.crt.clear();
        if (list != null && !list.isEmpty()) {
            this.crs.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int Dv = cVar.Dv();
                    int i4 = emotionsCount / (cols * Dv);
                    if (emotionsCount % (cols * Dv) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * Dv;
                        } else {
                            i = emotionsCount - ((cols * Dv) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.jj(i3);
                        dVar.b(cVar.Ds());
                        dVar.fa(Dv);
                        dVar.eZ(cols);
                        dVar.jf(i4);
                        dVar.jg(i5);
                        dVar.jh(i);
                        dVar.ji(i5 * cols * Dv);
                        dVar.setEndIndex((i + i2) - 1);
                        this.crt.add(dVar);
                    }
                }
            }
            this.cru = this.crt.size();
            for (int i6 = 0; i6 < this.cru; i6++) {
                if (this.crt != null && this.crt.get(i6) != null) {
                    this.crt.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jc(int i) {
        if (this.crt != null) {
            int size = this.crt.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.crt.get(i2);
                    if (dVar != null && dVar.agx() == i) {
                        this.crx = dVar.getIndex();
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
                jc(i);
                this.crg = new b();
                this.aEt.setAdapter(this.crg);
                this.aEt.setCurrentItem(this.crx, true);
                if (this.crw != null) {
                    this.crw.je(i);
                    this.crv = i;
                }
            }
        }
    }

    public void jd(int i) {
        int i2;
        if (this.aEt != null) {
            int size = this.crt.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.crt.get(i3);
                        if (dVar == null || dVar.agx() != i) {
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
                this.aEt.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.crq != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.agn() != null) {
            d agn = aVar.agn();
            String eS = agn.agq().eS(aVar.agm() + i);
            if (agn.agr() != EmotionGroupType.USER_COLLECT || !eS.equals(com.baidu.tbadk.imageManager.d.aGi)) {
                this.crk.setTag(eS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eS;
                if (eS.startsWith("#(meme,")) {
                    this.crk.setShowStaticDrawable(false);
                } else {
                    this.crk.setShowStaticDrawable(true);
                }
                this.crk.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.crl.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.crj.x = this.rect.left - ((this.crj.width - linearLayout.getWidth()) / 2);
                this.crj.y = (this.rect.top - this.crj.height) + this.cro;
                this.crk.setVisibility(0);
                if (!this.crp) {
                    this.mWindowManager.addView(this.crk, this.crj);
                    this.crp = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.crk, this.crj);
                }
                gridView.setSelection(i);
                if (this.crq != -1) {
                    ((LinearLayout) gridView.getChildAt(this.crq - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.crq = i;
                this.crh = gridView;
            }
        }
    }

    private void agk() {
        if (this.crp && this.crk.getVisibility() != 8 && this.crh != null) {
            this.crh.setSelection(-1);
            this.crk.setVisibility(8);
            if (this.crq != -1) {
                ((LinearLayout) this.crh.getChildAt(this.crq - this.crh.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.crq = -1;
            this.crh = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cry.set(x, y);
                break;
            case 1:
            case 3:
                agk();
                break;
            case 2:
                this.cry.set(x, y);
                if (this.crp && this.crk.getVisibility() != 8 && this.crh != null) {
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
                this.cry.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                agk();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    agk();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.crh != null) {
                        offsetRectIntoDescendantCoords(this.crh, this.rect);
                        int pointToPosition = this.crh.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.crh);
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
        if (this.crp) {
            this.mWindowManager.removeView(this.crk);
            this.crp = false;
        }
        MessageManager.getInstance().unRegisterListener(this.TJ);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.crt != null) {
            int size = this.crt.size();
            if (i >= 0 && i < size) {
                this.crr = this.crt.get(i);
                if (this.aEu != null && this.crr != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aEu.setVisibility(this.crr.agt() > 1 ? 0 : 4);
                        this.aEu.setCount(this.crr.agt());
                        if (this.crr != null && this.crr.agx() != this.crv) {
                            this.crv = this.crr.agx();
                            if (this.crw != null) {
                                this.crw.je(this.crr.agx());
                            }
                        }
                    }
                    float agu = this.crr.agu() + f;
                    this.aEu.setPosition(agu);
                    this.cri.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) agu) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.crr.agt())));
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
        this.apA = i;
        aj.d(this.crk, d.f.bg_expression_bubble, i);
        aj.e(this, d.C0082d.cp_bg_line_d, i);
        this.aEu.setSelector(aj.u(i, d.f.dot_pb_expression_s));
        this.aEu.setDrawable(aj.u(i, d.f.dot_pb_expression_n));
        if (this.aEt != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aEt.getChildCount()) {
                    View childAt = this.aEt.getChildAt(i3);
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
        agk();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d crB;

        public a(d dVar) {
            this.crB = dVar;
        }

        public void a(d dVar) {
            this.crB = dVar;
        }

        public int agm() {
            if (this.crB == null) {
                return 0;
            }
            return this.crB.agw();
        }

        public d agn() {
            return this.crB;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.crB == null) {
                return 0;
            }
            return this.crB.agv();
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
                if (this.crB.ags() != 0) {
                    i2 = measuredWidth / this.crB.ags();
                }
                if (this.crB.getRow() != 0) {
                    i3 = measuredHeight / this.crB.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cro * 2, EmotionTabContentView.this.cro * 2, EmotionTabContentView.this.cro * 2, EmotionTabContentView.this.cro * 2);
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
            if (this.crB != null) {
                int agw = this.crB.agw() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.apA);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eS = this.crB.agq().eS(agw);
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
                if (this.crB.agr() == EmotionGroupType.BIG_EMOTION) {
                    String eS2 = this.crB.agq().eS(agw);
                    if (!TextUtils.isEmpty(eS2) && !eS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.apA == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0082d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0082d.cp_cont_c);
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
            if (EmotionTabContentView.this.crt == null) {
                return 0;
            }
            return EmotionTabContentView.this.crt.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.crz.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.crz.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.crt != null && i < EmotionTabContentView.this.crt.size()) {
                d dVar = (d) EmotionTabContentView.this.crt.get(i);
                gridView2.setNumColumns(dVar.ags());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0082d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.agn() == null) {
                            return false;
                        }
                        d agn = aVar.agn();
                        if (agn.agr() == EmotionGroupType.BIG_EMOTION || agn.agr() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.IT != null) {
                            m mVar = new m();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.agn() != null) {
                                d agn = aVar.agn();
                                int agm = aVar.agm();
                                com.baidu.tbadk.editortools.emotiontool.c agq = agn.agq();
                                String eS = agn.agq().eS(agm + i2);
                                if (agq.Ds() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aGi.equals(eS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                mVar.setName(eS);
                                mVar.a(agq.Ds());
                                mVar.eH(agq.getGroupName());
                                mVar.eI(agq.getGroupId());
                                mVar.setWidth(agq.getWidth());
                                mVar.setHeight(agq.getHeight());
                                EmotionTabContentView.this.IT.b(new com.baidu.tbadk.editortools.a(24, -1, mVar));
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
            if (EmotionTabContentView.this.crt != null) {
                int size = EmotionTabContentView.this.crt.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.crt.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aEu.setVisibility(dVar.agt() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aEu.setCount(dVar.agt());
                        EmotionTabContentView.this.aEu.setPosition(dVar.agu());
                        EmotionTabContentView.this.aEu.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.agu() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.agt())));
                    }
                    if (dVar != null && dVar.agx() != EmotionTabContentView.this.crv) {
                        EmotionTabContentView.this.crv = dVar.agx();
                        if (EmotionTabContentView.this.crw != null) {
                            EmotionTabContentView.this.crw.je(dVar.agx());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.crw = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.IT = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TJ);
    }
}
