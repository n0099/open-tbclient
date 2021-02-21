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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes8.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager Ze;
    private int abv;
    private EditorTools acR;
    private int ajU;
    private CustomMessageListener eJz;
    private IndicatorView foO;
    private EmotionViewPagerAdapter iFL;
    private GridView iFM;
    private LinearLayout iFN;
    private WindowManager.LayoutParams iFO;
    private GifView iFP;
    private ViewGroup iFQ;
    private int iFR;
    private int iFS;
    private int iFT;
    private boolean iFU;
    private int iFV;
    private com.baidu.tieba.emotion.editortool.b iFW;
    private List<com.baidu.tbadk.editortools.emotiontool.c> iFX;
    private List<com.baidu.tieba.emotion.editortool.b> iFY;
    private int iFZ;
    private int iGa;
    private b iGb;
    private int iGc;
    private com.baidu.adp.lib.d.b<GridView> iGd;
    private Context mContext;
    private final Point mStartPoint;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes8.dex */
    public interface b {
        void xq(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.iFV = -1;
        this.iFZ = 0;
        this.iGa = -1;
        this.abv = -1;
        this.mStartPoint = new Point();
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cN(new ArrayList(EmotionTabContentView.this.iFX));
                        if (EmotionTabContentView.this.iFL != null) {
                            EmotionTabContentView.this.iFL.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iGa < 0 || EmotionTabContentView.this.iGa >= EmotionTabContentView.this.iFX.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iFX.get(EmotionTabContentView.this.iGa)).bBB() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iFL != null) {
                                if (EmotionTabContentView.this.abv >= 0 && EmotionTabContentView.this.abv < EmotionTabContentView.this.iFY.size()) {
                                    EmotionTabContentView.this.iFW = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iFY.get(EmotionTabContentView.this.abv);
                                    int cuP = EmotionTabContentView.this.iFW.cuP();
                                    EmotionTabContentView.this.foO.setCount(cuP);
                                    EmotionTabContentView.this.foO.setVisibility(cuP > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.Ze == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.Ze.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.Ze.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.cuJ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iFY.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iFY.get(index));
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
        this.iFV = -1;
        this.iFZ = 0;
        this.iGa = -1;
        this.abv = -1;
        this.mStartPoint = new Point();
        this.eJz = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cN(new ArrayList(EmotionTabContentView.this.iFX));
                        if (EmotionTabContentView.this.iFL != null) {
                            EmotionTabContentView.this.iFL.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iGa < 0 || EmotionTabContentView.this.iGa >= EmotionTabContentView.this.iFX.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iFX.get(EmotionTabContentView.this.iGa)).bBB() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iFL != null) {
                                if (EmotionTabContentView.this.abv >= 0 && EmotionTabContentView.this.abv < EmotionTabContentView.this.iFY.size()) {
                                    EmotionTabContentView.this.iFW = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iFY.get(EmotionTabContentView.this.abv);
                                    int cuP = EmotionTabContentView.this.iFW.cuP();
                                    EmotionTabContentView.this.foO.setCount(cuP);
                                    EmotionTabContentView.this.foO.setVisibility(cuP > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.Ze == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.Ze.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.Ze.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.cuJ().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iFY.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iFY.get(index));
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
        this.iFX = new ArrayList();
        this.iFY = new ArrayList();
        this.iGd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cuH */
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
        this.Ze = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.Ze.setFadingEdgeLength(0);
        this.Ze.setOnPageChangeListener(this);
        this.iFP = new GifView(context);
        ap.setBackgroundResource(this.iFP, R.drawable.bg_expression_bubble, this.ajU);
        this.iFP.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.iFO = new WindowManager.LayoutParams();
        this.iFR = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iFS = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.iFT = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.iFO.width = this.iFR;
        this.iFO.height = this.iFS;
        this.iFO.gravity = 51;
        this.iFO.format = -3;
        this.iFO.type = 1000;
        this.iFO.flags |= 56;
        this.iFQ = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.foO = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.iFN = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.iFN.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.iFO.type = 1000;
            this.iFO.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.iFX.clear();
        this.iFY.clear();
        if (list != null && !list.isEmpty()) {
            this.iFX.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bBE = cVar.bBE();
                    int bBF = cVar.bBF();
                    int i4 = emotionsCount / (bBE * bBF);
                    if (emotionsCount % (bBE * bBF) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bBE * bBF;
                        } else {
                            i = emotionsCount - ((bBE * bBF) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.xw(i3);
                        bVar.b(cVar.bBB());
                        bVar.rh(bBF);
                        bVar.setColumn(bBE);
                        bVar.xr(i4);
                        bVar.xs(i5);
                        bVar.xt(i);
                        bVar.xu(i5 * bBE * bBF);
                        bVar.xv((i + i2) - 1);
                        this.iFY.add(bVar);
                    }
                }
            }
            this.iFZ = this.iFY.size();
            for (int i6 = 0; i6 < this.iFZ; i6++) {
                if (this.iFY != null && this.iFY.get(i6) != null) {
                    this.iFY.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void xo(int i) {
        if (this.iFY != null) {
            int size = this.iFY.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.iFY.get(i2);
                    if (bVar != null && bVar.cuT() == i) {
                        this.iGc = bVar.getIndex();
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
                cN(list);
                xo(i);
                this.iFL = new EmotionViewPagerAdapter();
                this.Ze.setAdapter(this.iFL);
                this.Ze.setCurrentItem(this.iGc, true);
                if (this.iGb != null) {
                    this.iGb.xq(i);
                    this.iGa = i;
                }
            }
        }
    }

    public void xp(int i) {
        int i2;
        if (this.Ze != null) {
            int size = this.iFY.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.iFY.get(i3);
                        if (bVar == null || bVar.cuT() != i) {
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
                this.Ze.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.iFV != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cuJ() != null) {
            com.baidu.tieba.emotion.editortool.b cuJ = aVar.cuJ();
            String qX = cuJ.cuM().qX(aVar.cuI() + i);
            if (cuJ.cuN() != EmotionGroupType.USER_COLLECT || !com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qX)) {
                this.iFP.setTag(qX);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qX;
                if (qX.startsWith("#(meme,")) {
                    this.iFP.setShowStaticDrawable(false);
                } else {
                    this.iFP.setShowStaticDrawable(true);
                }
                this.iFP.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.iFQ.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.iFO.x = this.rect.left - ((this.iFO.width - linearLayout.getWidth()) / 2);
                this.iFO.y = (this.rect.top - this.iFO.height) + this.iFT;
                this.iFP.setVisibility(0);
                if (!this.iFU) {
                    this.mWindowManager.addView(this.iFP, this.iFO);
                    this.iFU = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.iFP, this.iFO);
                }
                gridView.setSelection(i);
                if (this.iFV != -1) {
                    ((LinearLayout) gridView.getChildAt(this.iFV - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.iFV = i;
                this.iFM = gridView;
            }
        }
    }

    private void cuG() {
        if (this.iFU && this.iFP.getVisibility() != 8 && this.iFM != null) {
            this.iFM.setSelection(-1);
            this.iFP.setVisibility(8);
            if (this.iFV != -1) {
                ((LinearLayout) this.iFM.getChildAt(this.iFV - this.iFM.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.iFV = -1;
            this.iFM = null;
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
                cuG();
                break;
            case 2:
                this.mStartPoint.set(x, y);
                if (this.iFU && this.iFP.getVisibility() != 8 && this.iFM != null) {
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
                cuG();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    cuG();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.iFM != null) {
                        offsetRectIntoDescendantCoords(this.iFM, this.rect);
                        int pointToPosition = this.iFM.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.iFM);
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
        if (this.iFU) {
            this.mWindowManager.removeView(this.iFP);
            this.iFU = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eJz);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.iFY != null) {
            int size = this.iFY.size();
            if (i >= 0 && i < size) {
                this.iFW = this.iFY.get(i);
                if (this.foO != null && this.iFW != null) {
                    if (this.abv != i) {
                        this.abv = i;
                        this.foO.setVisibility(this.iFW.cuP() > 1 ? 0 : 4);
                        this.foO.setCount(this.iFW.cuP());
                        if (this.iFW != null && this.iFW.cuT() != this.iGa) {
                            this.iGa = this.iFW.cuT();
                            if (this.iGb != null) {
                                this.iGb.xq(this.iFW.cuT());
                            }
                        }
                    }
                    float cuQ = this.iFW.cuQ() + f;
                    this.foO.setPosition(cuQ);
                    this.iFN.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cuQ) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.iFW.cuP())));
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
        this.ajU = i;
        ap.setBackgroundResource(this.iFP, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.CAM_X0206, i);
        this.foO.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.foO.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
        if (this.Ze != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.Ze.getChildCount()) {
                    View childAt = this.Ze.getChildAt(i3);
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
        cuG();
    }

    /* loaded from: classes8.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b iGf;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iGf = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iGf = bVar;
        }

        public int cuI() {
            if (this.iGf == null) {
                return 0;
            }
            return this.iGf.cuS();
        }

        public com.baidu.tieba.emotion.editortool.b cuJ() {
            return this.iGf;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.iGf == null) {
                return 0;
            }
            return this.iGf.cuR();
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
                if (this.iGf.cuO() != 0) {
                    i2 = measuredWidth / this.iGf.cuO();
                }
                if (this.iGf.getRow() != 0) {
                    i3 = measuredHeight / this.iGf.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.iFT * 2, EmotionTabContentView.this.iFT * 2, EmotionTabContentView.this.iFT * 2, EmotionTabContentView.this.iFT * 2);
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
            if (this.iGf != null) {
                int cuS = this.iGf.cuS() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ajU);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qX = this.iGf.cuM().qX(cuS);
                tbImageView.setTag(qX);
                if (!TextUtils.isEmpty(qX)) {
                    Object a2 = com.baidu.adp.lib.e.d.mw().a(qX, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, qX, false, null);
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
                if (this.iGf.cuN() == EmotionGroupType.BIG_EMOTION) {
                    String qX2 = this.iGf.cuM().qX(cuS);
                    if (!TextUtils.isEmpty(qX2) && !qX2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ajU == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = ap.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(qX2.substring(qX2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, qX2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (qX != null && qX.length() > 3) {
                    linearLayout3.setContentDescription(qX.substring(2, qX.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes8.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.iFY == null) {
                return 0;
            }
            return EmotionTabContentView.this.iFY.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.iGd.returnObject(gridView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.iGd.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.iFY != null && i < EmotionTabContentView.this.iFY.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iFY.get(i);
                gridView2.setNumColumns(bVar.cuO());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cuJ() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cuJ = aVar.cuJ();
                        if (cuJ.cuN() == EmotionGroupType.BIG_EMOTION || cuJ.cuN() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.acR != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cuJ() != null) {
                                com.baidu.tieba.emotion.editortool.b cuJ = aVar.cuJ();
                                int cuI = aVar.cuI();
                                com.baidu.tbadk.editortools.emotiontool.c cuM = cuJ.cuM();
                                String qX = cuJ.cuM().qX(cuI + i2);
                                if (cuM.bBB() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qX)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(qX);
                                uVar.a(cuM.bBB());
                                uVar.BU(cuM.getGroupName());
                                uVar.setPid(cuM.getGroupId());
                                uVar.setWidth(cuM.getWidth());
                                uVar.setHeight(cuM.getHeight());
                                EmotionTabContentView.this.acR.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.iFY != null) {
                int size = EmotionTabContentView.this.iFY.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.abv) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iFY.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.abv = i;
                        EmotionTabContentView.this.foO.setVisibility(bVar.cuP() > 1 ? 0 : 4);
                        EmotionTabContentView.this.foO.setCount(bVar.cuP());
                        EmotionTabContentView.this.foO.setPosition(bVar.cuQ());
                        EmotionTabContentView.this.foO.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cuQ() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cuP())));
                    }
                    if (bVar != null && bVar.cuT() != EmotionTabContentView.this.iGa) {
                        EmotionTabContentView.this.iGa = bVar.cuT();
                        if (EmotionTabContentView.this.iGb != null) {
                            EmotionTabContentView.this.iGb.xq(bVar.cuT());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.iGb = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eJz);
    }
}
