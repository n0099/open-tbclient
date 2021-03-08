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
/* loaded from: classes7.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager aaw;
    private int acR;
    private EditorTools ael;
    private int aln;
    private CustomMessageListener eLa;
    private IndicatorView fqo;
    private int iHA;
    private int iHB;
    private int iHC;
    private boolean iHD;
    private int iHE;
    private com.baidu.tieba.emotion.editortool.b iHF;
    private List<com.baidu.tbadk.editortools.emotiontool.c> iHG;
    private List<com.baidu.tieba.emotion.editortool.b> iHH;
    private int iHI;
    private int iHJ;
    private b iHK;
    private int iHL;
    private com.baidu.adp.lib.d.b<GridView> iHM;
    private EmotionViewPagerAdapter iHu;
    private GridView iHv;
    private LinearLayout iHw;
    private WindowManager.LayoutParams iHx;
    private GifView iHy;
    private ViewGroup iHz;
    private Context mContext;
    private final Point mStartPoint;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes7.dex */
    public interface b {
        void xr(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.iHE = -1;
        this.iHI = 0;
        this.iHJ = -1;
        this.acR = -1;
        this.mStartPoint = new Point();
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cN(new ArrayList(EmotionTabContentView.this.iHG));
                        if (EmotionTabContentView.this.iHu != null) {
                            EmotionTabContentView.this.iHu.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iHJ < 0 || EmotionTabContentView.this.iHJ >= EmotionTabContentView.this.iHG.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iHG.get(EmotionTabContentView.this.iHJ)).bBE() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iHu != null) {
                                if (EmotionTabContentView.this.acR >= 0 && EmotionTabContentView.this.acR < EmotionTabContentView.this.iHH.size()) {
                                    EmotionTabContentView.this.iHF = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iHH.get(EmotionTabContentView.this.acR);
                                    int cuV = EmotionTabContentView.this.iHF.cuV();
                                    EmotionTabContentView.this.fqo.setCount(cuV);
                                    EmotionTabContentView.this.fqo.setVisibility(cuV > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aaw == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aaw.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aaw.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.cuP().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iHH.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iHH.get(index));
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
        this.iHE = -1;
        this.iHI = 0;
        this.iHJ = -1;
        this.acR = -1;
        this.mStartPoint = new Point();
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cN(new ArrayList(EmotionTabContentView.this.iHG));
                        if (EmotionTabContentView.this.iHu != null) {
                            EmotionTabContentView.this.iHu.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iHJ < 0 || EmotionTabContentView.this.iHJ >= EmotionTabContentView.this.iHG.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iHG.get(EmotionTabContentView.this.iHJ)).bBE() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iHu != null) {
                                if (EmotionTabContentView.this.acR >= 0 && EmotionTabContentView.this.acR < EmotionTabContentView.this.iHH.size()) {
                                    EmotionTabContentView.this.iHF = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iHH.get(EmotionTabContentView.this.acR);
                                    int cuV = EmotionTabContentView.this.iHF.cuV();
                                    EmotionTabContentView.this.fqo.setCount(cuV);
                                    EmotionTabContentView.this.fqo.setVisibility(cuV > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.aaw == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.aaw.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.aaw.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.cuP().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iHH.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iHH.get(index));
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
        this.iHG = new ArrayList();
        this.iHH = new ArrayList();
        this.iHM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cuN */
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
        this.aaw = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.aaw.setFadingEdgeLength(0);
        this.aaw.setOnPageChangeListener(this);
        this.iHy = new GifView(context);
        ap.setBackgroundResource(this.iHy, R.drawable.bg_expression_bubble, this.aln);
        this.iHy.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.iHx = new WindowManager.LayoutParams();
        this.iHA = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iHB = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.iHC = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.iHx.width = this.iHA;
        this.iHx.height = this.iHB;
        this.iHx.gravity = 51;
        this.iHx.format = -3;
        this.iHx.type = 1000;
        this.iHx.flags |= 56;
        this.iHz = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.fqo = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.iHw = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.iHw.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.iHx.type = 1000;
            this.iHx.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.iHG.clear();
        this.iHH.clear();
        if (list != null && !list.isEmpty()) {
            this.iHG.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bBH = cVar.bBH();
                    int bBI = cVar.bBI();
                    int i4 = emotionsCount / (bBH * bBI);
                    if (emotionsCount % (bBH * bBI) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bBH * bBI;
                        } else {
                            i = emotionsCount - ((bBH * bBI) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.xx(i3);
                        bVar.b(cVar.bBE());
                        bVar.ri(bBI);
                        bVar.setColumn(bBH);
                        bVar.xs(i4);
                        bVar.xt(i5);
                        bVar.xu(i);
                        bVar.xv(i5 * bBH * bBI);
                        bVar.xw((i + i2) - 1);
                        this.iHH.add(bVar);
                    }
                }
            }
            this.iHI = this.iHH.size();
            for (int i6 = 0; i6 < this.iHI; i6++) {
                if (this.iHH != null && this.iHH.get(i6) != null) {
                    this.iHH.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void xp(int i) {
        if (this.iHH != null) {
            int size = this.iHH.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.iHH.get(i2);
                    if (bVar != null && bVar.cuZ() == i) {
                        this.iHL = bVar.getIndex();
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
                xp(i);
                this.iHu = new EmotionViewPagerAdapter();
                this.aaw.setAdapter(this.iHu);
                this.aaw.setCurrentItem(this.iHL, true);
                if (this.iHK != null) {
                    this.iHK.xr(i);
                    this.iHJ = i;
                }
            }
        }
    }

    public void xq(int i) {
        int i2;
        if (this.aaw != null) {
            int size = this.iHH.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.iHH.get(i3);
                        if (bVar == null || bVar.cuZ() != i) {
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
                this.aaw.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.iHE != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cuP() != null) {
            com.baidu.tieba.emotion.editortool.b cuP = aVar.cuP();
            String qY = cuP.cuS().qY(aVar.cuO() + i);
            if (cuP.cuT() != EmotionGroupType.USER_COLLECT || !com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qY)) {
                this.iHy.setTag(qY);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qY;
                if (qY.startsWith("#(meme,")) {
                    this.iHy.setShowStaticDrawable(false);
                } else {
                    this.iHy.setShowStaticDrawable(true);
                }
                this.iHy.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.iHz.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.iHx.x = this.rect.left - ((this.iHx.width - linearLayout.getWidth()) / 2);
                this.iHx.y = (this.rect.top - this.iHx.height) + this.iHC;
                this.iHy.setVisibility(0);
                if (!this.iHD) {
                    this.mWindowManager.addView(this.iHy, this.iHx);
                    this.iHD = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.iHy, this.iHx);
                }
                gridView.setSelection(i);
                if (this.iHE != -1) {
                    ((LinearLayout) gridView.getChildAt(this.iHE - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.iHE = i;
                this.iHv = gridView;
            }
        }
    }

    private void cuM() {
        if (this.iHD && this.iHy.getVisibility() != 8 && this.iHv != null) {
            this.iHv.setSelection(-1);
            this.iHy.setVisibility(8);
            if (this.iHE != -1) {
                ((LinearLayout) this.iHv.getChildAt(this.iHE - this.iHv.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.iHE = -1;
            this.iHv = null;
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
                cuM();
                break;
            case 2:
                this.mStartPoint.set(x, y);
                if (this.iHD && this.iHy.getVisibility() != 8 && this.iHv != null) {
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
                cuM();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    cuM();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.iHv != null) {
                        offsetRectIntoDescendantCoords(this.iHv, this.rect);
                        int pointToPosition = this.iHv.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.iHv);
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
        if (this.iHD) {
            this.mWindowManager.removeView(this.iHy);
            this.iHD = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eLa);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.iHH != null) {
            int size = this.iHH.size();
            if (i >= 0 && i < size) {
                this.iHF = this.iHH.get(i);
                if (this.fqo != null && this.iHF != null) {
                    if (this.acR != i) {
                        this.acR = i;
                        this.fqo.setVisibility(this.iHF.cuV() > 1 ? 0 : 4);
                        this.fqo.setCount(this.iHF.cuV());
                        if (this.iHF != null && this.iHF.cuZ() != this.iHJ) {
                            this.iHJ = this.iHF.cuZ();
                            if (this.iHK != null) {
                                this.iHK.xr(this.iHF.cuZ());
                            }
                        }
                    }
                    float cuW = this.iHF.cuW() + f;
                    this.fqo.setPosition(cuW);
                    this.iHw.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cuW) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.iHF.cuV())));
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
        this.aln = i;
        ap.setBackgroundResource(this.iHy, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.CAM_X0206, i);
        this.fqo.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.fqo.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
        if (this.aaw != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aaw.getChildCount()) {
                    View childAt = this.aaw.getChildAt(i3);
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
        cuM();
    }

    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b iHO;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iHO = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iHO = bVar;
        }

        public int cuO() {
            if (this.iHO == null) {
                return 0;
            }
            return this.iHO.cuY();
        }

        public com.baidu.tieba.emotion.editortool.b cuP() {
            return this.iHO;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.iHO == null) {
                return 0;
            }
            return this.iHO.cuX();
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
                if (this.iHO.cuU() != 0) {
                    i2 = measuredWidth / this.iHO.cuU();
                }
                if (this.iHO.getRow() != 0) {
                    i3 = measuredHeight / this.iHO.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.iHC * 2, EmotionTabContentView.this.iHC * 2, EmotionTabContentView.this.iHC * 2, EmotionTabContentView.this.iHC * 2);
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
            if (this.iHO != null) {
                int cuY = this.iHO.cuY() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aln);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qY = this.iHO.cuS().qY(cuY);
                tbImageView.setTag(qY);
                if (!TextUtils.isEmpty(qY)) {
                    Object a2 = com.baidu.adp.lib.e.d.mw().a(qY, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, qY, false, null);
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
                if (this.iHO.cuT() == EmotionGroupType.BIG_EMOTION) {
                    String qY2 = this.iHO.cuS().qY(cuY);
                    if (!TextUtils.isEmpty(qY2) && !qY2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aln == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = ap.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(qY2.substring(qY2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, qY2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (qY != null && qY.length() > 3) {
                    linearLayout3.setContentDescription(qY.substring(2, qY.length() - 1));
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
            if (EmotionTabContentView.this.iHH == null) {
                return 0;
            }
            return EmotionTabContentView.this.iHH.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.iHM.returnObject(gridView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.iHM.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.iHH != null && i < EmotionTabContentView.this.iHH.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iHH.get(i);
                gridView2.setNumColumns(bVar.cuU());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cuP() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cuP = aVar.cuP();
                        if (cuP.cuT() == EmotionGroupType.BIG_EMOTION || cuP.cuT() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.ael != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cuP() != null) {
                                com.baidu.tieba.emotion.editortool.b cuP = aVar.cuP();
                                int cuO = aVar.cuO();
                                com.baidu.tbadk.editortools.emotiontool.c cuS = cuP.cuS();
                                String qY = cuP.cuS().qY(cuO + i2);
                                if (cuS.bBE() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qY)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(qY);
                                uVar.a(cuS.bBE());
                                uVar.Cb(cuS.getGroupName());
                                uVar.setPid(cuS.getGroupId());
                                uVar.setWidth(cuS.getWidth());
                                uVar.setHeight(cuS.getHeight());
                                EmotionTabContentView.this.ael.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.iHH != null) {
                int size = EmotionTabContentView.this.iHH.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.acR) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iHH.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.acR = i;
                        EmotionTabContentView.this.fqo.setVisibility(bVar.cuV() > 1 ? 0 : 4);
                        EmotionTabContentView.this.fqo.setCount(bVar.cuV());
                        EmotionTabContentView.this.fqo.setPosition(bVar.cuW());
                        EmotionTabContentView.this.fqo.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cuW() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cuV())));
                    }
                    if (bVar != null && bVar.cuZ() != EmotionTabContentView.this.iHJ) {
                        EmotionTabContentView.this.iHJ = bVar.cuZ();
                        if (EmotionTabContentView.this.iHK != null) {
                            EmotionTabContentView.this.iHK.xr(bVar.cuZ());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.iHK = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eLa);
    }
}
