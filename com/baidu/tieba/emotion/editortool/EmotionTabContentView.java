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
    private int Bq;
    private EditorTools CJ;
    private final Rect aoK;
    private CustomMessageListener bVa;
    private int csg;
    private IndicatorView csm;
    private EmotionViewPagerAdapter eXG;
    private GridView eXH;
    private LinearLayout eXI;
    private WindowManager.LayoutParams eXJ;
    private GifView eXK;
    private ViewGroup eXL;
    private int eXM;
    private int eXN;
    private int eXO;
    private boolean eXP;
    private int eXQ;
    private com.baidu.tieba.emotion.editortool.b eXR;
    private List<com.baidu.tbadk.editortools.emotiontool.c> eXS;
    private List<com.baidu.tieba.emotion.editortool.b> eXT;
    private int eXU;
    private int eXV;
    private b eXW;
    private int eXX;
    private final Point eXY;
    private com.baidu.adp.lib.e.b<GridView> eXZ;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes2.dex */
    public interface b {
        void pk(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoK = new Rect();
        this.eXQ = -1;
        this.eXU = 0;
        this.eXV = -1;
        this.Bq = -1;
        this.eXY = new Point();
        this.bVa = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bN(new ArrayList(EmotionTabContentView.this.eXS));
                        if (EmotionTabContentView.this.eXG != null) {
                            EmotionTabContentView.this.eXG.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eXV < 0 || EmotionTabContentView.this.eXV >= EmotionTabContentView.this.eXS.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eXS.get(EmotionTabContentView.this.eXV)).aum() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eXG != null) {
                                if (EmotionTabContentView.this.Bq >= 0 && EmotionTabContentView.this.Bq < EmotionTabContentView.this.eXT.size()) {
                                    EmotionTabContentView.this.eXR = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eXT.get(EmotionTabContentView.this.Bq);
                                    int bdp = EmotionTabContentView.this.eXR.bdp();
                                    EmotionTabContentView.this.csm.setCount(bdp);
                                    EmotionTabContentView.this.csm.setVisibility(bdp > 1 ? 0 : 4);
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
                                                    int index = aVar.bdj().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eXT.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eXT.get(index));
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
        this.aoK = new Rect();
        this.eXQ = -1;
        this.eXU = 0;
        this.eXV = -1;
        this.Bq = -1;
        this.eXY = new Point();
        this.bVa = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bN(new ArrayList(EmotionTabContentView.this.eXS));
                        if (EmotionTabContentView.this.eXG != null) {
                            EmotionTabContentView.this.eXG.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.eXV < 0 || EmotionTabContentView.this.eXV >= EmotionTabContentView.this.eXS.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.eXS.get(EmotionTabContentView.this.eXV)).aum() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.eXG != null) {
                                if (EmotionTabContentView.this.Bq >= 0 && EmotionTabContentView.this.Bq < EmotionTabContentView.this.eXT.size()) {
                                    EmotionTabContentView.this.eXR = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eXT.get(EmotionTabContentView.this.Bq);
                                    int bdp = EmotionTabContentView.this.eXR.bdp();
                                    EmotionTabContentView.this.csm.setCount(bdp);
                                    EmotionTabContentView.this.csm.setVisibility(bdp > 1 ? 0 : 4);
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
                                                    int index = aVar.bdj().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.eXT.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eXT.get(index));
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
        this.eXS = new ArrayList();
        this.eXT = new ArrayList();
        this.eXZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bdh */
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
        this.eXK = new GifView(context);
        am.setBackgroundResource(this.eXK, R.drawable.bg_expression_bubble, this.csg);
        this.eXK.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.eXJ = new WindowManager.LayoutParams();
        this.eXM = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.eXN = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.eXO = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eXJ.width = this.eXM;
        this.eXJ.height = this.eXN;
        this.eXJ.gravity = 51;
        this.eXJ.format = -3;
        this.eXJ.type = 1000;
        this.eXJ.flags |= 56;
        this.eXL = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.csm = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.eXI = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.eXI.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.eXJ.type = 1000;
            this.eXJ.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.eXS.clear();
        this.eXT.clear();
        if (list != null && !list.isEmpty()) {
            this.eXS.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aup = cVar.aup();
                    int auq = cVar.auq();
                    int i4 = emotionsCount / (aup * auq);
                    if (emotionsCount % (aup * auq) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aup * auq;
                        } else {
                            i = emotionsCount - ((aup * auq) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.pr(i3);
                        bVar.b(cVar.aum());
                        bVar.jU(auq);
                        bVar.jT(aup);
                        bVar.pl(i4);
                        bVar.pm(i5);
                        bVar.po(i);
                        bVar.pp(i5 * aup * auq);
                        bVar.pq((i + i2) - 1);
                        this.eXT.add(bVar);
                    }
                }
            }
            this.eXU = this.eXT.size();
            for (int i6 = 0; i6 < this.eXU; i6++) {
                if (this.eXT != null && this.eXT.get(i6) != null) {
                    this.eXT.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void pi(int i) {
        if (this.eXT != null) {
            int size = this.eXT.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.eXT.get(i2);
                    if (bVar != null && bVar.bdt() == i) {
                        this.eXX = bVar.getIndex();
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
                pi(i);
                this.eXG = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.eXG);
                this.mViewPager.setCurrentItem(this.eXX, true);
                if (this.eXW != null) {
                    this.eXW.pk(i);
                    this.eXV = i;
                }
            }
        }
    }

    public void pj(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.eXT.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.eXT.get(i3);
                        if (bVar == null || bVar.bdt() != i) {
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
        if (this.eXQ != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bdj() != null) {
            com.baidu.tieba.emotion.editortool.b bdj = aVar.bdj();
            String jN = bdj.bdm().jN(aVar.bdi() + i);
            if (bdj.bdn() != EmotionGroupType.USER_COLLECT || !jN.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.eXK.setTag(jN);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = jN;
                if (jN.startsWith("#(meme,")) {
                    this.eXK.setShowStaticDrawable(false);
                } else {
                    this.eXK.setShowStaticDrawable(true);
                }
                this.eXK.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.aoK);
                this.eXL.offsetDescendantRectToMyCoords(linearLayout, this.aoK);
                this.eXJ.x = this.aoK.left - ((this.eXJ.width - linearLayout.getWidth()) / 2);
                this.eXJ.y = (this.aoK.top - this.eXJ.height) + this.eXO;
                this.eXK.setVisibility(0);
                if (!this.eXP) {
                    this.mWindowManager.addView(this.eXK, this.eXJ);
                    this.eXP = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.eXK, this.eXJ);
                }
                gridView.setSelection(i);
                if (this.eXQ != -1) {
                    ((LinearLayout) gridView.getChildAt(this.eXQ - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.eXQ = i;
                this.eXH = gridView;
            }
        }
    }

    private void PT() {
        if (this.eXP && this.eXK.getVisibility() != 8 && this.eXH != null) {
            this.eXH.setSelection(-1);
            this.eXK.setVisibility(8);
            if (this.eXQ != -1) {
                ((LinearLayout) this.eXH.getChildAt(this.eXQ - this.eXH.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.eXQ = -1;
            this.eXH = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.eXY.set(x, y);
                break;
            case 1:
            case 3:
                PT();
                break;
            case 2:
                this.eXY.set(x, y);
                if (this.eXP && this.eXK.getVisibility() != 8 && this.eXH != null) {
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
                this.eXY.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                PT();
                break;
            case 2:
                getFocusedRect(this.aoK);
                if (!this.aoK.contains(x, y)) {
                    PT();
                    break;
                } else {
                    this.aoK.set(x, y, x + 1, y + 1);
                    if (this.eXH != null) {
                        offsetRectIntoDescendantCoords(this.eXH, this.aoK);
                        int pointToPosition = this.eXH.pointToPosition(this.aoK.left, this.aoK.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.eXH);
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
        if (this.eXP) {
            this.mWindowManager.removeView(this.eXK);
            this.eXP = false;
        }
        MessageManager.getInstance().unRegisterListener(this.bVa);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.eXT != null) {
            int size = this.eXT.size();
            if (i >= 0 && i < size) {
                this.eXR = this.eXT.get(i);
                if (this.csm != null && this.eXR != null) {
                    if (this.Bq != i) {
                        this.Bq = i;
                        this.csm.setVisibility(this.eXR.bdp() > 1 ? 0 : 4);
                        this.csm.setCount(this.eXR.bdp());
                        if (this.eXR != null && this.eXR.bdt() != this.eXV) {
                            this.eXV = this.eXR.bdt();
                            if (this.eXW != null) {
                                this.eXW.pk(this.eXR.bdt());
                            }
                        }
                    }
                    float bdq = this.eXR.bdq() + f;
                    this.csm.setPosition(bdq);
                    this.eXI.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bdq) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.eXR.bdp())));
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
        this.csg = i;
        am.setBackgroundResource(this.eXK, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.csm.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.csm.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        PT();
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b eYb;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eYb = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.eYb = bVar;
        }

        public int bdi() {
            if (this.eYb == null) {
                return 0;
            }
            return this.eYb.bds();
        }

        public com.baidu.tieba.emotion.editortool.b bdj() {
            return this.eYb;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eYb == null) {
                return 0;
            }
            return this.eYb.bdr();
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
                if (this.eYb.bdo() != 0) {
                    i2 = measuredWidth / this.eYb.bdo();
                }
                if (this.eYb.getRow() != 0) {
                    i3 = measuredHeight / this.eYb.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.eXO * 2, EmotionTabContentView.this.eXO * 2, EmotionTabContentView.this.eXO * 2, EmotionTabContentView.this.eXO * 2);
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
            if (this.eYb != null) {
                int bds = this.eYb.bds() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.csg);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String jN = this.eYb.bdm().jN(bds);
                tbImageView.setTag(jN);
                if (!TextUtils.isEmpty(jN)) {
                    Object a = com.baidu.adp.lib.f.c.fT().a(jN, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, jN, false, null);
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
                if (this.eYb.bdn() == EmotionGroupType.BIG_EMOTION) {
                    String jN2 = this.eYb.bdm().jN(bds);
                    if (!TextUtils.isEmpty(jN2) && !jN2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.csg == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(jN2.substring(jN2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, jN2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (jN != null && jN.length() > 3) {
                    linearLayout3.setContentDescription(jN.substring(2, jN.length() - 1));
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
            if (EmotionTabContentView.this.eXT == null) {
                return 0;
            }
            return EmotionTabContentView.this.eXT.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.eXZ.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.eXZ.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.eXT != null && i < EmotionTabContentView.this.eXT.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eXT.get(i);
                gridView2.setNumColumns(bVar.bdo());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bdj() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bdj = aVar.bdj();
                        if (bdj.bdn() == EmotionGroupType.BIG_EMOTION || bdj.bdn() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.CJ != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bdj() != null) {
                                com.baidu.tieba.emotion.editortool.b bdj = aVar.bdj();
                                int bdi = aVar.bdi();
                                com.baidu.tbadk.editortools.emotiontool.c bdm = bdj.bdm();
                                String jN = bdj.bdm().jN(bdi + i2);
                                if (bdm.aum() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(jN)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(jN);
                                pVar.a(bdm.aum());
                                pVar.oK(bdm.getGroupName());
                                pVar.setPid(bdm.getGroupId());
                                pVar.setWidth(bdm.getWidth());
                                pVar.setHeight(bdm.getHeight());
                                EmotionTabContentView.this.CJ.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.eXT != null) {
                int size = EmotionTabContentView.this.eXT.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Bq) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.eXT.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Bq = i;
                        EmotionTabContentView.this.csm.setVisibility(bVar.bdp() > 1 ? 0 : 4);
                        EmotionTabContentView.this.csm.setCount(bVar.bdp());
                        EmotionTabContentView.this.csm.setPosition(bVar.bdq());
                        EmotionTabContentView.this.csm.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bdq() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bdp())));
                    }
                    if (bVar != null && bVar.bdt() != EmotionTabContentView.this.eXV) {
                        EmotionTabContentView.this.eXV = bVar.bdt();
                        if (EmotionTabContentView.this.eXW != null) {
                            EmotionTabContentView.this.eXW.pk(bVar.bdt());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.eXW = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bVa);
    }
}
