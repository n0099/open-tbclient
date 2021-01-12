package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager Zi;
    private int abA;
    private EditorTools acX;
    private int akf;
    private CustomMessageListener eHt;
    private IndicatorView fmw;
    private List<com.baidu.tieba.emotion.editortool.b> iAa;
    private int iAb;
    private int iAc;
    private b iAd;
    private int iAe;
    private com.baidu.adp.lib.d.b<GridView> iAf;
    private EmotionViewPagerAdapter izN;
    private GridView izO;
    private LinearLayout izP;
    private WindowManager.LayoutParams izQ;
    private GifView izR;
    private ViewGroup izS;
    private int izT;
    private int izU;
    private int izV;
    private boolean izW;
    private int izX;
    private com.baidu.tieba.emotion.editortool.b izY;
    private List<com.baidu.tbadk.editortools.emotiontool.c> izZ;
    private Context mContext;
    private final Point mStartPoint;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes7.dex */
    public interface b {
        void xg(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.izX = -1;
        this.iAb = 0;
        this.iAc = -1;
        this.abA = -1;
        this.mStartPoint = new Point();
        this.eHt = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cS(new ArrayList(EmotionTabContentView.this.izZ));
                        if (EmotionTabContentView.this.izN != null) {
                            EmotionTabContentView.this.izN.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iAc < 0 || EmotionTabContentView.this.iAc >= EmotionTabContentView.this.izZ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.izZ.get(EmotionTabContentView.this.iAc)).bBj() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.izN != null) {
                                if (EmotionTabContentView.this.abA >= 0 && EmotionTabContentView.this.abA < EmotionTabContentView.this.iAa.size()) {
                                    EmotionTabContentView.this.izY = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iAa.get(EmotionTabContentView.this.abA);
                                    int ctw = EmotionTabContentView.this.izY.ctw();
                                    EmotionTabContentView.this.fmw.setCount(ctw);
                                    EmotionTabContentView.this.fmw.setVisibility(ctw > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.Zi == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.Zi.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.Zi.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.ctq().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iAa.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iAa.get(index));
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
        this.izX = -1;
        this.iAb = 0;
        this.iAc = -1;
        this.abA = -1;
        this.mStartPoint = new Point();
        this.eHt = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cS(new ArrayList(EmotionTabContentView.this.izZ));
                        if (EmotionTabContentView.this.izN != null) {
                            EmotionTabContentView.this.izN.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iAc < 0 || EmotionTabContentView.this.iAc >= EmotionTabContentView.this.izZ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.izZ.get(EmotionTabContentView.this.iAc)).bBj() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.izN != null) {
                                if (EmotionTabContentView.this.abA >= 0 && EmotionTabContentView.this.abA < EmotionTabContentView.this.iAa.size()) {
                                    EmotionTabContentView.this.izY = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iAa.get(EmotionTabContentView.this.abA);
                                    int ctw = EmotionTabContentView.this.izY.ctw();
                                    EmotionTabContentView.this.fmw.setCount(ctw);
                                    EmotionTabContentView.this.fmw.setVisibility(ctw > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.Zi == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.Zi.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.Zi.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.ctq().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iAa.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iAa.get(index));
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
        this.izZ = new ArrayList();
        this.iAa = new ArrayList();
        this.iAf = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cto */
            public GridView makeObject() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public void destroyObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public GridView activateObject(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: f */
            public GridView passivateObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
        this.Zi = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.Zi.setFadingEdgeLength(0);
        this.Zi.setOnPageChangeListener(this);
        this.izR = new GifView(context);
        ao.setBackgroundResource(this.izR, R.drawable.bg_expression_bubble, this.akf);
        this.izR.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.izQ = new WindowManager.LayoutParams();
        this.izT = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.izU = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.izV = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.izQ.width = this.izT;
        this.izQ.height = this.izU;
        this.izQ.gravity = 51;
        this.izQ.format = -3;
        this.izQ.type = 1000;
        this.izQ.flags |= 56;
        this.izS = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.fmw = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.izP = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.izP.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.izQ.type = 1000;
            this.izQ.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.izZ.clear();
        this.iAa.clear();
        if (list != null && !list.isEmpty()) {
            this.izZ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bBm = cVar.bBm();
                    int bBn = cVar.bBn();
                    int i4 = emotionsCount / (bBm * bBn);
                    if (emotionsCount % (bBm * bBn) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bBm * bBn;
                        } else {
                            i = emotionsCount - ((bBm * bBn) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.xm(i3);
                        bVar.b(cVar.bBj());
                        bVar.rc(bBn);
                        bVar.setColumn(bBm);
                        bVar.xh(i4);
                        bVar.xi(i5);
                        bVar.xj(i);
                        bVar.xk(i5 * bBm * bBn);
                        bVar.xl((i + i2) - 1);
                        this.iAa.add(bVar);
                    }
                }
            }
            this.iAb = this.iAa.size();
            for (int i6 = 0; i6 < this.iAb; i6++) {
                if (this.iAa != null && this.iAa.get(i6) != null) {
                    this.iAa.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void xe(int i) {
        if (this.iAa != null) {
            int size = this.iAa.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.iAa.get(i2);
                    if (bVar != null && bVar.ctA() == i) {
                        this.iAe = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void g(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                cS(list);
                xe(i);
                this.izN = new EmotionViewPagerAdapter();
                this.Zi.setAdapter(this.izN);
                this.Zi.setCurrentItem(this.iAe, true);
                if (this.iAd != null) {
                    this.iAd.xg(i);
                    this.iAc = i;
                }
            }
        }
    }

    public void xf(int i) {
        int i2;
        if (this.Zi != null) {
            int size = this.iAa.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.iAa.get(i3);
                        if (bVar == null || bVar.ctA() != i) {
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
                this.Zi.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.izX != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.ctq() != null) {
            com.baidu.tieba.emotion.editortool.b ctq = aVar.ctq();
            String qS = ctq.ctt().qS(aVar.ctp() + i);
            if (ctq.ctu() != EmotionGroupType.USER_COLLECT || !com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qS)) {
                this.izR.setTag(qS);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qS;
                if (qS.startsWith("#(meme,")) {
                    this.izR.setShowStaticDrawable(false);
                } else {
                    this.izR.setShowStaticDrawable(true);
                }
                this.izR.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.izS.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.izQ.x = this.rect.left - ((this.izQ.width - linearLayout.getWidth()) / 2);
                this.izQ.y = (this.rect.top - this.izQ.height) + this.izV;
                this.izR.setVisibility(0);
                if (!this.izW) {
                    this.mWindowManager.addView(this.izR, this.izQ);
                    this.izW = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.izR, this.izQ);
                }
                gridView.setSelection(i);
                if (this.izX != -1) {
                    ((LinearLayout) gridView.getChildAt(this.izX - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.izX = i;
                this.izO = gridView;
            }
        }
    }

    private void ctn() {
        if (this.izW && this.izR.getVisibility() != 8 && this.izO != null) {
            this.izO.setSelection(-1);
            this.izR.setVisibility(8);
            if (this.izX != -1) {
                ((LinearLayout) this.izO.getChildAt(this.izX - this.izO.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.izX = -1;
            this.izO = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.mStartPoint.set(x, y);
                break;
            case 1:
            case 3:
                ctn();
                break;
            case 2:
                this.mStartPoint.set(x, y);
                if (this.izW && this.izR.getVisibility() != 8 && this.izO != null) {
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
                this.mStartPoint.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                ctn();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    ctn();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.izO != null) {
                        offsetRectIntoDescendantCoords(this.izO, this.rect);
                        int pointToPosition = this.izO.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.izO);
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
        if (this.izW) {
            this.mWindowManager.removeView(this.izR);
            this.izW = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eHt);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.iAa != null) {
            int size = this.iAa.size();
            if (i >= 0 && i < size) {
                this.izY = this.iAa.get(i);
                if (this.fmw != null && this.izY != null) {
                    if (this.abA != i) {
                        this.abA = i;
                        this.fmw.setVisibility(this.izY.ctw() > 1 ? 0 : 4);
                        this.fmw.setCount(this.izY.ctw());
                        if (this.izY != null && this.izY.ctA() != this.iAc) {
                            this.iAc = this.izY.ctA();
                            if (this.iAd != null) {
                                this.iAd.xg(this.izY.ctA());
                            }
                        }
                    }
                    float ctx = this.izY.ctx() + f;
                    this.fmw.setPosition(ctx);
                    this.izP.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) ctx) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.izY.ctw())));
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        this.akf = i;
        ao.setBackgroundResource(this.izR, R.drawable.bg_expression_bubble, i);
        ao.setBackgroundColor(this, R.color.CAM_X0206, i);
        this.fmw.setSelector(ao.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.fmw.setDrawable(ao.getDrawable(i, R.drawable.dot_pb_expression_n));
        if (this.Zi != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.Zi.getChildCount()) {
                    View childAt = this.Zi.getChildAt(i3);
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
        ctn();
    }

    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b iAh;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iAh = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iAh = bVar;
        }

        public int ctp() {
            if (this.iAh == null) {
                return 0;
            }
            return this.iAh.ctz();
        }

        public com.baidu.tieba.emotion.editortool.b ctq() {
            return this.iAh;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.iAh == null) {
                return 0;
            }
            return this.iAh.cty();
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
                if (this.iAh.ctv() != 0) {
                    i2 = measuredWidth / this.iAh.ctv();
                }
                if (this.iAh.getRow() != 0) {
                    i3 = measuredHeight / this.iAh.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.izV * 2, EmotionTabContentView.this.izV * 2, EmotionTabContentView.this.izV * 2, EmotionTabContentView.this.izV * 2);
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
            if (this.iAh != null) {
                int ctz = this.iAh.ctz() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ao.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.akf);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qS = this.iAh.ctt().qS(ctz);
                tbImageView.setTag(qS);
                if (!TextUtils.isEmpty(qS)) {
                    Object a2 = com.baidu.adp.lib.e.d.mx().a(qS, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.drawImageTo(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, qS, false, null);
                    if (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.ImageView.a) a2;
                    }
                    if (aVar != null) {
                        aVar.drawImageTo(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
                if (this.iAh.ctu() == EmotionGroupType.BIG_EMOTION) {
                    String qS2 = this.iAh.ctt().qS(ctz);
                    if (!TextUtils.isEmpty(qS2) && !qS2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.akf == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = ao.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(qS2.substring(qS2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, qS2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (qS != null && qS.length() > 3) {
                    linearLayout3.setContentDescription(qS.substring(2, qS.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes7.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.iAa == null) {
                return 0;
            }
            return EmotionTabContentView.this.iAa.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.iAf.returnObject(gridView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.iAf.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.iAa != null && i < EmotionTabContentView.this.iAa.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iAa.get(i);
                gridView2.setNumColumns(bVar.ctv());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.ctq() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b ctq = aVar.ctq();
                        if (ctq.ctu() == EmotionGroupType.BIG_EMOTION || ctq.ctu() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.acX != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.ctq() != null) {
                                com.baidu.tieba.emotion.editortool.b ctq = aVar.ctq();
                                int ctp = aVar.ctp();
                                com.baidu.tbadk.editortools.emotiontool.c ctt = ctq.ctt();
                                String qS = ctq.ctt().qS(ctp + i2);
                                if (ctt.bBj() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qS)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(qS);
                                uVar.a(ctt.bBj());
                                uVar.BD(ctt.getGroupName());
                                uVar.setPid(ctt.getGroupId());
                                uVar.setWidth(ctt.getWidth());
                                uVar.setHeight(ctt.getHeight());
                                EmotionTabContentView.this.acX.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
                            }
                        }
                    }
                });
                gridView2.setAdapter((ListAdapter) new a(bVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.iAa != null) {
                int size = EmotionTabContentView.this.iAa.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.abA) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iAa.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.abA = i;
                        EmotionTabContentView.this.fmw.setVisibility(bVar.ctw() > 1 ? 0 : 4);
                        EmotionTabContentView.this.fmw.setCount(bVar.ctw());
                        EmotionTabContentView.this.fmw.setPosition(bVar.ctx());
                        EmotionTabContentView.this.fmw.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.ctx() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.ctw())));
                    }
                    if (bVar != null && bVar.ctA() != EmotionTabContentView.this.iAc) {
                        EmotionTabContentView.this.iAc = bVar.ctA();
                        if (EmotionTabContentView.this.iAd != null) {
                            EmotionTabContentView.this.iAd.xg(bVar.ctA());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.iAd = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eHt);
    }
}
