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
/* loaded from: classes5.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Ec;
    private EditorTools Fv;
    private int MH;
    private CustomMessageListener cHC;
    private IndicatorView dgm;
    private WindowManager.LayoutParams fPA;
    private GifView fPB;
    private ViewGroup fPC;
    private int fPD;
    private int fPE;
    private int fPF;
    private boolean fPG;
    private int fPH;
    private com.baidu.tieba.emotion.editortool.b fPI;
    private List<com.baidu.tbadk.editortools.emotiontool.c> fPJ;
    private List<com.baidu.tieba.emotion.editortool.b> fPK;
    private int fPL;
    private int fPM;
    private b fPN;
    private int fPO;
    private final Point fPP;
    private com.baidu.adp.lib.d.b<GridView> fPQ;
    private EmotionViewPagerAdapter fPx;
    private GridView fPy;
    private LinearLayout fPz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes5.dex */
    public interface b {
        void rw(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.fPH = -1;
        this.fPL = 0;
        this.fPM = -1;
        this.Ec = -1;
        this.fPP = new Point();
        this.cHC = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fPJ));
                        if (EmotionTabContentView.this.fPx != null) {
                            EmotionTabContentView.this.fPx.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fPM < 0 || EmotionTabContentView.this.fPM >= EmotionTabContentView.this.fPJ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fPJ.get(EmotionTabContentView.this.fPM)).aMk() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fPx != null) {
                                if (EmotionTabContentView.this.Ec >= 0 && EmotionTabContentView.this.Ec < EmotionTabContentView.this.fPK.size()) {
                                    EmotionTabContentView.this.fPI = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fPK.get(EmotionTabContentView.this.Ec);
                                    int bvN = EmotionTabContentView.this.fPI.bvN();
                                    EmotionTabContentView.this.dgm.setCount(bvN);
                                    EmotionTabContentView.this.dgm.setVisibility(bvN > 1 ? 0 : 4);
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
                                                    int index = aVar.bvH().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fPK.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fPK.get(index));
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
        this.fPH = -1;
        this.fPL = 0;
        this.fPM = -1;
        this.Ec = -1;
        this.fPP = new Point();
        this.cHC = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fPJ));
                        if (EmotionTabContentView.this.fPx != null) {
                            EmotionTabContentView.this.fPx.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fPM < 0 || EmotionTabContentView.this.fPM >= EmotionTabContentView.this.fPJ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fPJ.get(EmotionTabContentView.this.fPM)).aMk() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fPx != null) {
                                if (EmotionTabContentView.this.Ec >= 0 && EmotionTabContentView.this.Ec < EmotionTabContentView.this.fPK.size()) {
                                    EmotionTabContentView.this.fPI = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fPK.get(EmotionTabContentView.this.Ec);
                                    int bvN = EmotionTabContentView.this.fPI.bvN();
                                    EmotionTabContentView.this.dgm.setCount(bvN);
                                    EmotionTabContentView.this.dgm.setVisibility(bvN > 1 ? 0 : 4);
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
                                                    int index = aVar.bvH().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fPK.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fPK.get(index));
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
        this.fPJ = new ArrayList();
        this.fPK = new ArrayList();
        this.fPQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvF */
            public GridView makeObject() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public GridView activateObject(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
        this.fPB = new GifView(context);
        am.setBackgroundResource(this.fPB, R.drawable.bg_expression_bubble, this.MH);
        this.fPB.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.fPA = new WindowManager.LayoutParams();
        this.fPD = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.fPE = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.fPF = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fPA.width = this.fPD;
        this.fPA.height = this.fPE;
        this.fPA.gravity = 51;
        this.fPA.format = -3;
        this.fPA.type = 1000;
        this.fPA.flags |= 56;
        this.fPC = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dgm = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.fPz = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.fPz.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.fPA.type = 1000;
            this.fPA.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.fPJ.clear();
        this.fPK.clear();
        if (list != null && !list.isEmpty()) {
            this.fPJ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aMn = cVar.aMn();
                    int aMo = cVar.aMo();
                    int i4 = emotionsCount / (aMn * aMo);
                    if (emotionsCount % (aMn * aMo) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aMn * aMo;
                        } else {
                            i = emotionsCount - ((aMn * aMo) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.rC(i3);
                        bVar.b(cVar.aMk());
                        bVar.mh(aMo);
                        bVar.mg(aMn);
                        bVar.rx(i4);
                        bVar.ry(i5);
                        bVar.rz(i);
                        bVar.rA(i5 * aMn * aMo);
                        bVar.rB((i + i2) - 1);
                        this.fPK.add(bVar);
                    }
                }
            }
            this.fPL = this.fPK.size();
            for (int i6 = 0; i6 < this.fPL; i6++) {
                if (this.fPK != null && this.fPK.get(i6) != null) {
                    this.fPK.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void ru(int i) {
        if (this.fPK != null) {
            int size = this.fPK.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.fPK.get(i2);
                    if (bVar != null && bVar.bvR() == i) {
                        this.fPO = bVar.getIndex();
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
                bJ(list);
                ru(i);
                this.fPx = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.fPx);
                this.mViewPager.setCurrentItem(this.fPO, true);
                if (this.fPN != null) {
                    this.fPN.rw(i);
                    this.fPM = i;
                }
            }
        }
    }

    public void rv(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.fPK.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.fPK.get(i3);
                        if (bVar == null || bVar.bvR() != i) {
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
        if (this.fPH != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bvH() != null) {
            com.baidu.tieba.emotion.editortool.b bvH = aVar.bvH();
            String ma = bvH.bvK().ma(aVar.bvG() + i);
            if (bvH.bvL() != EmotionGroupType.USER_COLLECT || !ma.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.fPB.setTag(ma);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ma;
                if (ma.startsWith("#(meme,")) {
                    this.fPB.setShowStaticDrawable(false);
                } else {
                    this.fPB.setShowStaticDrawable(true);
                }
                this.fPB.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.fPC.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.fPA.x = this.rect.left - ((this.fPA.width - linearLayout.getWidth()) / 2);
                this.fPA.y = (this.rect.top - this.fPA.height) + this.fPF;
                this.fPB.setVisibility(0);
                if (!this.fPG) {
                    this.mWindowManager.addView(this.fPB, this.fPA);
                    this.fPG = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.fPB, this.fPA);
                }
                gridView.setSelection(i);
                if (this.fPH != -1) {
                    ((LinearLayout) gridView.getChildAt(this.fPH - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.fPH = i;
                this.fPy = gridView;
            }
        }
    }

    private void onUp() {
        if (this.fPG && this.fPB.getVisibility() != 8 && this.fPy != null) {
            this.fPy.setSelection(-1);
            this.fPB.setVisibility(8);
            if (this.fPH != -1) {
                ((LinearLayout) this.fPy.getChildAt(this.fPH - this.fPy.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.fPH = -1;
            this.fPy = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.fPP.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.fPP.set(x, y);
                if (this.fPG && this.fPB.getVisibility() != 8 && this.fPy != null) {
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
                this.fPP.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.fPy != null) {
                        offsetRectIntoDescendantCoords(this.fPy, this.rect);
                        int pointToPosition = this.fPy.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.fPy);
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
        if (this.fPG) {
            this.mWindowManager.removeView(this.fPB);
            this.fPG = false;
        }
        MessageManager.getInstance().unRegisterListener(this.cHC);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fPK != null) {
            int size = this.fPK.size();
            if (i >= 0 && i < size) {
                this.fPI = this.fPK.get(i);
                if (this.dgm != null && this.fPI != null) {
                    if (this.Ec != i) {
                        this.Ec = i;
                        this.dgm.setVisibility(this.fPI.bvN() > 1 ? 0 : 4);
                        this.dgm.setCount(this.fPI.bvN());
                        if (this.fPI != null && this.fPI.bvR() != this.fPM) {
                            this.fPM = this.fPI.bvR();
                            if (this.fPN != null) {
                                this.fPN.rw(this.fPI.bvR());
                            }
                        }
                    }
                    float bvO = this.fPI.bvO() + f;
                    this.dgm.setPosition(bvO);
                    this.fPz.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bvO) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.fPI.bvN())));
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
        this.MH = i;
        am.setBackgroundResource(this.fPB, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dgm.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dgm.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        onUp();
    }

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b fPS;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fPS = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fPS = bVar;
        }

        public int bvG() {
            if (this.fPS == null) {
                return 0;
            }
            return this.fPS.bvQ();
        }

        public com.baidu.tieba.emotion.editortool.b bvH() {
            return this.fPS;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fPS == null) {
                return 0;
            }
            return this.fPS.bvP();
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
                if (this.fPS.bvM() != 0) {
                    i2 = measuredWidth / this.fPS.bvM();
                }
                if (this.fPS.getRow() != 0) {
                    i3 = measuredHeight / this.fPS.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.fPF * 2, EmotionTabContentView.this.fPF * 2, EmotionTabContentView.this.fPF * 2, EmotionTabContentView.this.fPF * 2);
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
            if (this.fPS != null) {
                int bvQ = this.fPS.bvQ() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.MH);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ma = this.fPS.bvK().ma(bvQ);
                tbImageView.setTag(ma);
                if (!TextUtils.isEmpty(ma)) {
                    Object a = com.baidu.adp.lib.e.c.gr().a(ma, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.drawImageTo(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, ma, false, null);
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
                if (this.fPS.bvL() == EmotionGroupType.BIG_EMOTION) {
                    String ma2 = this.fPS.bvK().ma(bvQ);
                    if (!TextUtils.isEmpty(ma2) && !ma2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.MH == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ma2.substring(ma2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, ma2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ma != null && ma.length() > 3) {
                    linearLayout3.setContentDescription(ma.substring(2, ma.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes5.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.fPK == null) {
                return 0;
            }
            return EmotionTabContentView.this.fPK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.fPQ.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.fPQ.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.fPK != null && i < EmotionTabContentView.this.fPK.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fPK.get(i);
                gridView2.setNumColumns(bVar.bvM());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bvH() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bvH = aVar.bvH();
                        if (bvH.bvL() == EmotionGroupType.BIG_EMOTION || bvH.bvL() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Fv != null) {
                            p pVar = new p();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bvH() != null) {
                                com.baidu.tieba.emotion.editortool.b bvH = aVar.bvH();
                                int bvG = aVar.bvG();
                                com.baidu.tbadk.editortools.emotiontool.c bvK = bvH.bvK();
                                String ma = bvH.bvK().ma(bvG + i2);
                                if (bvK.aMk() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(ma)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                pVar.setName(ma);
                                pVar.a(bvK.aMk());
                                pVar.tR(bvK.getGroupName());
                                pVar.setPid(bvK.getGroupId());
                                pVar.setWidth(bvK.getWidth());
                                pVar.setHeight(bvK.getHeight());
                                EmotionTabContentView.this.Fv.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
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
            if (EmotionTabContentView.this.fPK != null) {
                int size = EmotionTabContentView.this.fPK.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ec) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fPK.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ec = i;
                        EmotionTabContentView.this.dgm.setVisibility(bVar.bvN() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dgm.setCount(bVar.bvN());
                        EmotionTabContentView.this.dgm.setPosition(bVar.bvO());
                        EmotionTabContentView.this.dgm.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bvO() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bvN())));
                    }
                    if (bVar != null && bVar.bvR() != EmotionTabContentView.this.fPM) {
                        EmotionTabContentView.this.fPM = bVar.bvR();
                        if (EmotionTabContentView.this.fPN != null) {
                            EmotionTabContentView.this.fPN.rw(bVar.bvR());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.fPN = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cHC);
    }
}
