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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int BQ;
    private EditorTools Dl;
    private final Rect apc;
    private CustomMessageListener bVR;
    private int csX;
    private IndicatorView ctd;
    private WindowManager.LayoutParams eYA;
    private GifView eYB;
    private ViewGroup eYC;
    private int eYD;
    private int eYE;
    private int eYF;
    private boolean eYG;
    private int eYH;
    private com.baidu.tieba.emotion.editortool.b eYI;
    private List<com.baidu.tbadk.editortools.emotiontool.c> eYJ;
    private List<com.baidu.tieba.emotion.editortool.b> eYK;
    private int eYL;
    private int eYM;
    private b eYN;
    private int eYO;
    private final Point eYP;
    private com.baidu.adp.lib.e.b<GridView> eYQ;
    private EmotionViewPagerAdapter eYx;
    private GridView eYy;
    private LinearLayout eYz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes2.dex */
    public interface b {
        void pl(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apc = new Rect();
        this.eYH = -1;
        this.eYL = 0;
        this.eYM = -1;
        this.BQ = -1;
        this.eYP = new Point();
        this.bVR = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bN(new ArrayList(EmotionTabContentView.this.eYJ));
                        if (EmotionTabContentView.this.eYx != null) {
                            EmotionTabContentView.this.eYx.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eYM < 0 || EmotionTabContentView.this.eYM >= EmotionTabContentView.this.eYJ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eYJ.get(EmotionTabContentView.this.eYM)).auo() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eYx != null) {
                                if (EmotionTabContentView.this.BQ >= 0 && EmotionTabContentView.this.BQ < EmotionTabContentView.this.eYK.size()) {
                                    EmotionTabContentView.this.eYI = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eYK.get(EmotionTabContentView.this.BQ);
                                    int bdr = EmotionTabContentView.this.eYI.bdr();
                                    EmotionTabContentView.this.ctd.setCount(bdr);
                                    EmotionTabContentView.this.ctd.setVisibility(bdr > 1 ? 0 : 4);
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
                                                    int index = aVar.bdl().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eYK.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eYK.get(index));
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
        this.apc = new Rect();
        this.eYH = -1;
        this.eYL = 0;
        this.eYM = -1;
        this.BQ = -1;
        this.eYP = new Point();
        this.bVR = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bN(new ArrayList(EmotionTabContentView.this.eYJ));
                        if (EmotionTabContentView.this.eYx != null) {
                            EmotionTabContentView.this.eYx.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eYM < 0 || EmotionTabContentView.this.eYM >= EmotionTabContentView.this.eYJ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eYJ.get(EmotionTabContentView.this.eYM)).auo() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eYx != null) {
                                if (EmotionTabContentView.this.BQ >= 0 && EmotionTabContentView.this.BQ < EmotionTabContentView.this.eYK.size()) {
                                    EmotionTabContentView.this.eYI = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eYK.get(EmotionTabContentView.this.BQ);
                                    int bdr = EmotionTabContentView.this.eYI.bdr();
                                    EmotionTabContentView.this.ctd.setCount(bdr);
                                    EmotionTabContentView.this.ctd.setVisibility(bdr > 1 ? 0 : 4);
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
                                                    int index = aVar.bdl().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eYK.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eYK.get(index));
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
        this.eYJ = new ArrayList();
        this.eYK = new ArrayList();
        this.eYQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bdj */
            public GridView makeObject() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public GridView activateObject(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public GridView passivateObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.eYB = new GifView(context);
        am.setBackgroundResource(this.eYB, R.drawable.bg_expression_bubble, this.csX);
        this.eYB.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.eYA = new WindowManager.LayoutParams();
        this.eYD = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.eYE = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.eYF = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eYA.width = this.eYD;
        this.eYA.height = this.eYE;
        this.eYA.gravity = 51;
        this.eYA.format = -3;
        this.eYA.type = 1000;
        this.eYA.flags |= 56;
        this.eYC = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ctd = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.eYz = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.eYz.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.eYA.type = 1000;
            this.eYA.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.eYJ.clear();
        this.eYK.clear();
        if (list != null && !list.isEmpty()) {
            this.eYJ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aur = cVar.aur();
                    int aus = cVar.aus();
                    int i4 = emotionsCount / (aur * aus);
                    if (emotionsCount % (aur * aus) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aur * aus;
                        } else {
                            i = emotionsCount - ((aur * aus) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.ps(i3);
                        bVar.b(cVar.auo());
                        bVar.jV(aus);
                        bVar.jU(aur);
                        bVar.pm(i4);
                        bVar.po(i5);
                        bVar.pp(i);
                        bVar.pq(i5 * aur * aus);
                        bVar.pr((i + i2) - 1);
                        this.eYK.add(bVar);
                    }
                }
            }
            this.eYL = this.eYK.size();
            for (int i6 = 0; i6 < this.eYL; i6++) {
                if (this.eYK != null && this.eYK.get(i6) != null) {
                    this.eYK.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void pj(int i) {
        if (this.eYK != null) {
            int size = this.eYK.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.eYK.get(i2);
                    if (bVar != null && bVar.bdv() == i) {
                        this.eYO = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void f(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                bN(list);
                pj(i);
                this.eYx = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eYx);
                this.mViewPager.setCurrentItem(this.eYO, true);
                if (this.eYN != null) {
                    this.eYN.pl(i);
                    this.eYM = i;
                }
            }
        }
    }

    public void pk(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.eYK.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.eYK.get(i3);
                        if (bVar == null || bVar.bdv() != i) {
                            i3++;
                        } else {
                            i2 = bVar.getIndex();
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
        if (this.eYH != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bdl() != null) {
            com.baidu.tieba.emotion.editortool.b bdl = aVar.bdl();
            String jO = bdl.bdo().jO(aVar.bdk() + i);
            if (bdl.bdp() != EmotionGroupType.USER_COLLECT || !jO.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.eYB.setTag(jO);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = jO;
                if (jO.startsWith("#(meme,")) {
                    this.eYB.setShowStaticDrawable(false);
                } else {
                    this.eYB.setShowStaticDrawable(true);
                }
                this.eYB.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.apc);
                this.eYC.offsetDescendantRectToMyCoords(linearLayout, this.apc);
                this.eYA.x = this.apc.left - ((this.eYA.width - linearLayout.getWidth()) / 2);
                this.eYA.y = (this.apc.top - this.eYA.height) + this.eYF;
                this.eYB.setVisibility(0);
                if (!this.eYG) {
                    this.mWindowManager.addView(this.eYB, this.eYA);
                    this.eYG = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.eYB, this.eYA);
                }
                gridView.setSelection(i);
                if (this.eYH != -1) {
                    ((LinearLayout) gridView.getChildAt(this.eYH - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.eYH = i;
                this.eYy = gridView;
            }
        }
    }

    private void PS() {
        if (this.eYG && this.eYB.getVisibility() != 8 && this.eYy != null) {
            this.eYy.setSelection(-1);
            this.eYB.setVisibility(8);
            if (this.eYH != -1) {
                ((LinearLayout) this.eYy.getChildAt(this.eYH - this.eYy.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.eYH = -1;
            this.eYy = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eYP.set(x, y);
                break;
            case 1:
            case 3:
                PS();
                break;
            case 2:
                this.eYP.set(x, y);
                if (this.eYG && this.eYB.getVisibility() != 8 && this.eYy != null) {
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
                this.eYP.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                PS();
                break;
            case 2:
                getFocusedRect(this.apc);
                if (!this.apc.contains(x, y)) {
                    PS();
                    break;
                } else {
                    this.apc.set(x, y, x + 1, y + 1);
                    if (this.eYy != null) {
                        offsetRectIntoDescendantCoords(this.eYy, this.apc);
                        int pointToPosition = this.eYy.pointToPosition(this.apc.left, this.apc.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eYy);
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
        if (this.eYG) {
            this.mWindowManager.removeView(this.eYB);
            this.eYG = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bVR);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.eYK != null) {
            int size = this.eYK.size();
            if (i >= 0 && i < size) {
                this.eYI = this.eYK.get(i);
                if (this.ctd != null && this.eYI != null) {
                    if (this.BQ != i) {
                        this.BQ = i;
                        this.ctd.setVisibility(this.eYI.bdr() > 1 ? 0 : 4);
                        this.ctd.setCount(this.eYI.bdr());
                        if (this.eYI != null && this.eYI.bdv() != this.eYM) {
                            this.eYM = this.eYI.bdv();
                            if (this.eYN != null) {
                                this.eYN.pl(this.eYI.bdv());
                            }
                        }
                    }
                    float bds = this.eYI.bds() + f;
                    this.ctd.setPosition(bds);
                    this.eYz.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bds) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.eYI.bdr())));
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
        this.csX = i;
        am.setBackgroundResource(this.eYB, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.ctd.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.ctd.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        PS();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b eYS;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eYS = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eYS = bVar;
        }

        public int bdk() {
            if (this.eYS == null) {
                return 0;
            }
            return this.eYS.bdu();
        }

        public com.baidu.tieba.emotion.editortool.b bdl() {
            return this.eYS;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eYS == null) {
                return 0;
            }
            return this.eYS.bdt();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.eYS.bdq() != 0) {
                    i2 = measuredWidth / this.eYS.bdq();
                }
                if (this.eYS.getRow() != 0) {
                    i3 = measuredHeight / this.eYS.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.eYF * 2, EmotionTabContentView.this.eYF * 2, EmotionTabContentView.this.eYF * 2, EmotionTabContentView.this.eYF * 2);
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
            if (this.eYS != null) {
                int bdu = this.eYS.bdu() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.csX);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String jO = this.eYS.bdo().jO(bdu);
                tbImageView.setTag(jO);
                if (!TextUtils.isEmpty(jO)) {
                    Object a = com.baidu.adp.lib.f.c.fT().a(jO, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.drawImageTo(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, jO, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.ImageView.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.ImageView.a) a;
                    }
                    if (aVar != null) {
                        aVar.drawImageTo(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
                if (this.eYS.bdp() == EmotionGroupType.BIG_EMOTION) {
                    String jO2 = this.eYS.bdo().jO(bdu);
                    if (!TextUtils.isEmpty(jO2) && !jO2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.csX == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(jO2.substring(jO2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, jO2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (jO != null && jO.length() > 3) {
                    linearLayout3.setContentDescription(jO.substring(2, jO.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes2.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.eYK == null) {
                return 0;
            }
            return EmotionTabContentView.this.eYK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eYQ.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eYQ.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.eYK != null && i < EmotionTabContentView.this.eYK.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eYK.get(i);
                gridView2.setNumColumns(bVar.bdq());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bdl() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bdl = aVar.bdl();
                        if (bdl.bdp() == EmotionGroupType.BIG_EMOTION || bdl.bdp() == EmotionGroupType.USER_COLLECT) {
                            EmotionTabContentView.this.a(i2, (GridView) adapterView);
                            return true;
                        }
                        return false;
                    }
                });
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        adapterView.setSelection(-1);
                        if (EmotionTabContentView.this.Dl != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bdl() != null) {
                                com.baidu.tieba.emotion.editortool.b bdl = aVar.bdl();
                                int bdk = aVar.bdk();
                                com.baidu.tbadk.editortools.emotiontool.c bdo = bdl.bdo();
                                String jO = bdl.bdo().jO(bdk + i2);
                                if (bdo.auo() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(jO)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(jO);
                                pVar.a(bdo.auo());
                                pVar.oK(bdo.getGroupName());
                                pVar.setPid(bdo.getGroupId());
                                pVar.setWidth(bdo.getWidth());
                                pVar.setHeight(bdo.getHeight());
                                EmotionTabContentView.this.Dl.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
                            }
                        }
                    }
                });
                gridView2.setAdapter((ListAdapter) new a(bVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.eYK != null) {
                int size = EmotionTabContentView.this.eYK.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.BQ) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eYK.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.BQ = i;
                        EmotionTabContentView.this.ctd.setVisibility(bVar.bdr() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ctd.setCount(bVar.bdr());
                        EmotionTabContentView.this.ctd.setPosition(bVar.bds());
                        EmotionTabContentView.this.ctd.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bds() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bdr())));
                    }
                    if (bVar != null && bVar.bdv() != EmotionTabContentView.this.eYM) {
                        EmotionTabContentView.this.eYM = bVar.bdv();
                        if (EmotionTabContentView.this.eYN != null) {
                            EmotionTabContentView.this.eYN.pl(bVar.bdv());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.eYN = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bVR);
    }
}
