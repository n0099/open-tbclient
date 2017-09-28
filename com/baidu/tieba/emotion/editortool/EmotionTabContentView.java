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
    private i JG;
    private CustomMessageListener SV;
    private IndicatorView aDo;
    private int aoZ;
    private b caR;
    private GridView caS;
    private LinearLayout caT;
    private WindowManager.LayoutParams caU;
    private GifView caV;
    private ViewGroup caW;
    private int caX;
    private int caY;
    private int caZ;
    private boolean cba;
    private int cbb;
    private d cbc;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cbd;
    private List<d> cbe;
    private int cbf;
    private int cbg;
    private c cbh;
    private int cbi;
    private final Point cbj;
    private com.baidu.adp.lib.e.b<GridView> cbk;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void iq(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cbb = -1;
        this.cbf = 0;
        this.cbg = -1;
        this.currentPosition = -1;
        this.cbj = new Point();
        this.SV = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.al(new ArrayList(EmotionTabContentView.this.cbd));
                        if (EmotionTabContentView.this.caR != null) {
                            EmotionTabContentView.this.caR.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cbg < 0 || EmotionTabContentView.this.cbg >= EmotionTabContentView.this.cbd.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cbd.get(EmotionTabContentView.this.cbg)).CO() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caR != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cbe.size()) {
                                    EmotionTabContentView.this.cbc = (d) EmotionTabContentView.this.cbe.get(EmotionTabContentView.this.currentPosition);
                                    int acq = EmotionTabContentView.this.cbc.acq();
                                    EmotionTabContentView.this.aDo.setCount(acq);
                                    EmotionTabContentView.this.aDo.setVisibility(acq > 1 ? 0 : 4);
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
                                                    int index = aVar.ack().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cbe.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.cbe.get(index));
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
        this.cbb = -1;
        this.cbf = 0;
        this.cbg = -1;
        this.currentPosition = -1;
        this.cbj = new Point();
        this.SV = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.al(new ArrayList(EmotionTabContentView.this.cbd));
                        if (EmotionTabContentView.this.caR != null) {
                            EmotionTabContentView.this.caR.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cbg < 0 || EmotionTabContentView.this.cbg >= EmotionTabContentView.this.cbd.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cbd.get(EmotionTabContentView.this.cbg)).CO() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.caR != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.cbe.size()) {
                                    EmotionTabContentView.this.cbc = (d) EmotionTabContentView.this.cbe.get(EmotionTabContentView.this.currentPosition);
                                    int acq = EmotionTabContentView.this.cbc.acq();
                                    EmotionTabContentView.this.aDo.setCount(acq);
                                    EmotionTabContentView.this.aDo.setVisibility(acq > 1 ? 0 : 4);
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
                                                    int index = aVar.ack().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cbe.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.cbe.get(index));
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
        this.cbd = new ArrayList();
        this.cbe = new ArrayList();
        this.cbk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aci */
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
        this.caV = new GifView(context);
        aj.d(this.caV, d.g.bg_expression_bubble, this.aoZ);
        this.caV.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.caU = new WindowManager.LayoutParams();
        this.caX = context.getResources().getDimensionPixelSize(d.f.ds240);
        this.caY = context.getResources().getDimensionPixelSize(d.f.ds252);
        this.caZ = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.caU.width = this.caX;
        this.caU.height = this.caY;
        this.caU.gravity = 51;
        this.caU.format = -3;
        this.caU.type = 1000;
        this.caU.flags |= 56;
        this.caW = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aDo = (IndicatorView) findViewById(d.h.face_tab_indicator);
        this.caT = (LinearLayout) findViewById(d.h.face_tab_indicator_layout);
        this.caT.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.caU.type = 1000;
            this.caU.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cbd.clear();
        this.cbe.clear();
        if (list != null && !list.isEmpty()) {
            this.cbd.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int cols = cVar.getCols();
                    int CR = cVar.CR();
                    int i4 = emotionsCount / (cols * CR);
                    if (emotionsCount % (cols * CR) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = cols * CR;
                        } else {
                            i = emotionsCount - ((cols * CR) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.iv(i3);
                        dVar.b(cVar.CO());
                        dVar.fc(CR);
                        dVar.fb(cols);
                        dVar.ir(i4);
                        dVar.is(i5);
                        dVar.it(i);
                        dVar.iu(i5 * cols * CR);
                        dVar.setEndIndex((i + i2) - 1);
                        this.cbe.add(dVar);
                    }
                }
            }
            this.cbf = this.cbe.size();
            for (int i6 = 0; i6 < this.cbf; i6++) {
                if (this.cbe != null && this.cbe.get(i6) != null) {
                    this.cbe.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void io(int i) {
        if (this.cbe != null) {
            int size = this.cbe.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.cbe.get(i2);
                    if (dVar != null && dVar.acu() == i) {
                        this.cbi = dVar.getIndex();
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
                io(i);
                this.caR = new b();
                this.mViewPager.setAdapter(this.caR);
                this.mViewPager.setCurrentItem(this.cbi, true);
                if (this.cbh != null) {
                    this.cbh.iq(i);
                    this.cbg = i;
                }
            }
        }
    }

    public void ip(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cbe.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.cbe.get(i3);
                        if (dVar == null || dVar.acu() != i) {
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
        if (this.cbb != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.ack() != null) {
            d ack = aVar.ack();
            String eS = ack.acn().eS(aVar.acj() + i);
            if (ack.aco() != EmotionGroupType.USER_COLLECT || !eS.equals(com.baidu.tbadk.imageManager.d.aFc)) {
                this.caV.setTag(eS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = eS;
                if (eS.startsWith("#(meme,")) {
                    this.caV.setShowStaticDrawable(false);
                } else {
                    this.caV.setShowStaticDrawable(true);
                }
                this.caV.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.caW.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.caU.x = this.rect.left - ((this.caU.width - linearLayout.getWidth()) / 2);
                this.caU.y = (this.rect.top - this.caU.height) + this.caZ;
                this.caV.setVisibility(0);
                if (!this.cba) {
                    this.mWindowManager.addView(this.caV, this.caU);
                    this.cba = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.caV, this.caU);
                }
                gridView.setSelection(i);
                if (this.cbb != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cbb - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cbb = i;
                this.caS = gridView;
            }
        }
    }

    private void ach() {
        if (this.cba && this.caV.getVisibility() != 8 && this.caS != null) {
            this.caS.setSelection(-1);
            this.caV.setVisibility(8);
            if (this.cbb != -1) {
                ((LinearLayout) this.caS.getChildAt(this.cbb - this.caS.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cbb = -1;
            this.caS = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cbj.set(x, y);
                break;
            case 1:
            case 3:
                ach();
                break;
            case 2:
                this.cbj.set(x, y);
                if (this.cba && this.caV.getVisibility() != 8 && this.caS != null) {
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
                this.cbj.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                ach();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    ach();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.caS != null) {
                        offsetRectIntoDescendantCoords(this.caS, this.rect);
                        int pointToPosition = this.caS.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.caS);
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
        if (this.cba) {
            this.mWindowManager.removeView(this.caV);
            this.cba = false;
        }
        MessageManager.getInstance().unRegisterListener(this.SV);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cbe != null) {
            int size = this.cbe.size();
            if (i >= 0 && i < size) {
                this.cbc = this.cbe.get(i);
                if (this.aDo != null && this.cbc != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aDo.setVisibility(this.cbc.acq() > 1 ? 0 : 4);
                        this.aDo.setCount(this.cbc.acq());
                        if (this.cbc != null && this.cbc.acu() != this.cbg) {
                            this.cbg = this.cbc.acu();
                            if (this.cbh != null) {
                                this.cbh.iq(this.cbc.acu());
                            }
                        }
                    }
                    float acr = this.cbc.acr() + f;
                    this.aDo.setPosition(acr);
                    this.caT.setContentDescription(String.format(getResources().getString(d.l.emotion_selection), Integer.valueOf(((int) acr) + 1)) + String.format(getResources().getString(d.l.emotion_page), Integer.valueOf(this.cbc.acq())));
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
        this.aoZ = i;
        aj.d(this.caV, d.g.bg_expression_bubble, i);
        aj.e(this, d.e.common_color_10255, i);
        this.aDo.setSelector(aj.u(i, d.g.dot_pb_expression_s));
        this.aDo.setDrawable(aj.u(i, d.g.dot_pb_expression_n));
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
        ach();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d cbm;

        public a(d dVar) {
            this.cbm = dVar;
        }

        public void a(d dVar) {
            this.cbm = dVar;
        }

        public int acj() {
            if (this.cbm == null) {
                return 0;
            }
            return this.cbm.act();
        }

        public d ack() {
            return this.cbm;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cbm == null) {
                return 0;
            }
            return this.cbm.acs();
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
                if (this.cbm.acp() != 0) {
                    i2 = measuredWidth / this.cbm.acp();
                }
                if (this.cbm.getRow() != 0) {
                    i3 = measuredHeight / this.cbm.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.caZ * 2, EmotionTabContentView.this.caZ * 2, EmotionTabContentView.this.caZ * 2, EmotionTabContentView.this.caZ * 2);
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
            if (this.cbm != null) {
                int act = this.cbm.act() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.h.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.d(tbImageView, d.g.btn_choose_face_selector, EmotionTabContentView.this.aoZ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eS = this.cbm.acn().eS(act);
                tbImageView.setTag(eS);
                if (!TextUtils.isEmpty(eS)) {
                    Object a = com.baidu.adp.lib.f.c.fJ().a(eS, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, eS, false, null);
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
                if (this.cbm.aco() == EmotionGroupType.BIG_EMOTION) {
                    String eS2 = this.cbm.acn().eS(act);
                    if (!TextUtils.isEmpty(eS2) && !eS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aoZ == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.e.cp_cont_c);
                        } else {
                            color = aj.getColor(d.e.cp_cont_c);
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
            if (EmotionTabContentView.this.cbe == null) {
                return 0;
            }
            return EmotionTabContentView.this.cbe.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cbk.m(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cbk.fH();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cbe != null && i < EmotionTabContentView.this.cbe.size()) {
                d dVar = (d) EmotionTabContentView.this.cbe.get(i);
                gridView2.setNumColumns(dVar.acp());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.e.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.f.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.ack() == null) {
                            return false;
                        }
                        d ack = aVar.ack();
                        if (ack.aco() == EmotionGroupType.BIG_EMOTION || ack.aco() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.JG != null) {
                            l lVar = new l();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.ack() != null) {
                                d ack = aVar.ack();
                                int acj = aVar.acj();
                                com.baidu.tbadk.editortools.emotiontool.c acn = ack.acn();
                                String eS = ack.acn().eS(acj + i2);
                                if (acn.CO() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aFc.equals(eS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                lVar.setName(eS);
                                lVar.a(acn.CO());
                                lVar.ew(acn.getGroupName());
                                lVar.ex(acn.getGroupId());
                                lVar.setWidth(acn.getWidth());
                                lVar.setHeight(acn.getHeight());
                                EmotionTabContentView.this.JG.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
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
            if (EmotionTabContentView.this.cbe != null) {
                int size = EmotionTabContentView.this.cbe.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.cbe.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.aDo.setVisibility(dVar.acq() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aDo.setCount(dVar.acq());
                        EmotionTabContentView.this.aDo.setPosition(dVar.acr());
                        EmotionTabContentView.this.aDo.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_selection), Integer.valueOf(dVar.acr() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.l.emotion_page), Integer.valueOf(dVar.acq())));
                    }
                    if (dVar != null && dVar.acu() != EmotionTabContentView.this.cbg) {
                        EmotionTabContentView.this.cbg = dVar.acu();
                        if (EmotionTabContentView.this.cbh != null) {
                            EmotionTabContentView.this.cbh.iq(dVar.acu());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.cbh = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.JG = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SV);
    }
}
