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
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int Ev;
    private EditorTools FO;
    private int Ni;
    private CustomMessageListener cLH;
    private IndicatorView dkG;
    private com.baidu.adp.lib.d.b<GridView> fSA;
    private EmotionViewPagerAdapter fSh;
    private GridView fSi;
    private LinearLayout fSj;
    private WindowManager.LayoutParams fSk;
    private GifView fSl;
    private ViewGroup fSm;
    private int fSn;
    private int fSo;
    private int fSp;
    private boolean fSq;
    private int fSr;
    private com.baidu.tieba.emotion.editortool.b fSs;
    private List<com.baidu.tbadk.editortools.emotiontool.c> fSt;
    private List<com.baidu.tieba.emotion.editortool.b> fSu;
    private int fSv;
    private int fSw;
    private b fSx;
    private int fSy;
    private final Point fSz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void rD(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.fSr = -1;
        this.fSv = 0;
        this.fSw = -1;
        this.Ev = -1;
        this.fSz = new Point();
        this.cLH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fSt));
                        if (EmotionTabContentView.this.fSh != null) {
                            EmotionTabContentView.this.fSh.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fSw < 0 || EmotionTabContentView.this.fSw >= EmotionTabContentView.this.fSt.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fSt.get(EmotionTabContentView.this.fSw)).aOJ() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fSh != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fSu.size()) {
                                    EmotionTabContentView.this.fSs = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSu.get(EmotionTabContentView.this.Ev);
                                    int bxu = EmotionTabContentView.this.fSs.bxu();
                                    EmotionTabContentView.this.dkG.setCount(bxu);
                                    EmotionTabContentView.this.dkG.setVisibility(bxu > 1 ? 0 : 4);
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
                                                    int index = aVar.bxo().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fSu.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSu.get(index));
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
        this.fSr = -1;
        this.fSv = 0;
        this.fSw = -1;
        this.Ev = -1;
        this.fSz = new Point();
        this.cLH = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bJ(new ArrayList(EmotionTabContentView.this.fSt));
                        if (EmotionTabContentView.this.fSh != null) {
                            EmotionTabContentView.this.fSh.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.fSw < 0 || EmotionTabContentView.this.fSw >= EmotionTabContentView.this.fSt.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.fSt.get(EmotionTabContentView.this.fSw)).aOJ() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.fSh != null) {
                                if (EmotionTabContentView.this.Ev >= 0 && EmotionTabContentView.this.Ev < EmotionTabContentView.this.fSu.size()) {
                                    EmotionTabContentView.this.fSs = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSu.get(EmotionTabContentView.this.Ev);
                                    int bxu = EmotionTabContentView.this.fSs.bxu();
                                    EmotionTabContentView.this.dkG.setCount(bxu);
                                    EmotionTabContentView.this.dkG.setVisibility(bxu > 1 ? 0 : 4);
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
                                                    int index = aVar.bxo().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.fSu.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSu.get(index));
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
        this.fSt = new ArrayList();
        this.fSu = new ArrayList();
        this.fSA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bxm */
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
        this.fSl = new GifView(context);
        am.setBackgroundResource(this.fSl, R.drawable.bg_expression_bubble, this.Ni);
        this.fSl.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.fSk = new WindowManager.LayoutParams();
        this.fSn = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.fSo = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.fSp = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fSk.width = this.fSn;
        this.fSk.height = this.fSo;
        this.fSk.gravity = 51;
        this.fSk.format = -3;
        this.fSk.type = 1000;
        this.fSk.flags |= 56;
        this.fSm = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dkG = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.fSj = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.fSj.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.fSk.type = 1000;
            this.fSk.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.fSt.clear();
        this.fSu.clear();
        if (list != null && !list.isEmpty()) {
            this.fSt.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aOM = cVar.aOM();
                    int aON = cVar.aON();
                    int i4 = emotionsCount / (aOM * aON);
                    if (emotionsCount % (aOM * aON) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aOM * aON;
                        } else {
                            i = emotionsCount - ((aOM * aON) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.rJ(i3);
                        bVar.b(cVar.aOJ());
                        bVar.mz(aON);
                        bVar.my(aOM);
                        bVar.rE(i4);
                        bVar.rF(i5);
                        bVar.rG(i);
                        bVar.rH(i5 * aOM * aON);
                        bVar.rI((i + i2) - 1);
                        this.fSu.add(bVar);
                    }
                }
            }
            this.fSv = this.fSu.size();
            for (int i6 = 0; i6 < this.fSv; i6++) {
                if (this.fSu != null && this.fSu.get(i6) != null) {
                    this.fSu.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rB(int i) {
        if (this.fSu != null) {
            int size = this.fSu.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.fSu.get(i2);
                    if (bVar != null && bVar.bxy() == i) {
                        this.fSy = bVar.getIndex();
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
                rB(i);
                this.fSh = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.fSh);
                this.mViewPager.setCurrentItem(this.fSy, true);
                if (this.fSx != null) {
                    this.fSx.rD(i);
                    this.fSw = i;
                }
            }
        }
    }

    public void rC(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.fSu.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.fSu.get(i3);
                        if (bVar == null || bVar.bxy() != i) {
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
        if (this.fSr != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bxo() != null) {
            com.baidu.tieba.emotion.editortool.b bxo = aVar.bxo();
            String ms = bxo.bxr().ms(aVar.bxn() + i);
            if (bxo.bxs() != EmotionGroupType.USER_COLLECT || !ms.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.fSl.setTag(ms);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = ms;
                if (ms.startsWith("#(meme,")) {
                    this.fSl.setShowStaticDrawable(false);
                } else {
                    this.fSl.setShowStaticDrawable(true);
                }
                this.fSl.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.fSm.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.fSk.x = this.rect.left - ((this.fSk.width - linearLayout.getWidth()) / 2);
                this.fSk.y = (this.rect.top - this.fSk.height) + this.fSp;
                this.fSl.setVisibility(0);
                if (!this.fSq) {
                    this.mWindowManager.addView(this.fSl, this.fSk);
                    this.fSq = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.fSl, this.fSk);
                }
                gridView.setSelection(i);
                if (this.fSr != -1) {
                    ((LinearLayout) gridView.getChildAt(this.fSr - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.fSr = i;
                this.fSi = gridView;
            }
        }
    }

    private void onUp() {
        if (this.fSq && this.fSl.getVisibility() != 8 && this.fSi != null) {
            this.fSi.setSelection(-1);
            this.fSl.setVisibility(8);
            if (this.fSr != -1) {
                ((LinearLayout) this.fSi.getChildAt(this.fSr - this.fSi.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.fSr = -1;
            this.fSi = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.fSz.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.fSz.set(x, y);
                if (this.fSq && this.fSl.getVisibility() != 8 && this.fSi != null) {
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
                this.fSz.set(x, y);
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
                    if (this.fSi != null) {
                        offsetRectIntoDescendantCoords(this.fSi, this.rect);
                        int pointToPosition = this.fSi.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.fSi);
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
        if (this.fSq) {
            this.mWindowManager.removeView(this.fSl);
            this.fSq = false;
        }
        MessageManager.getInstance().unRegisterListener(this.cLH);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.fSu != null) {
            int size = this.fSu.size();
            if (i >= 0 && i < size) {
                this.fSs = this.fSu.get(i);
                if (this.dkG != null && this.fSs != null) {
                    if (this.Ev != i) {
                        this.Ev = i;
                        this.dkG.setVisibility(this.fSs.bxu() > 1 ? 0 : 4);
                        this.dkG.setCount(this.fSs.bxu());
                        if (this.fSs != null && this.fSs.bxy() != this.fSw) {
                            this.fSw = this.fSs.bxy();
                            if (this.fSx != null) {
                                this.fSx.rD(this.fSs.bxy());
                            }
                        }
                    }
                    float bxv = this.fSs.bxv() + f;
                    this.dkG.setPosition(bxv);
                    this.fSj.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bxv) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.fSs.bxu())));
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
        this.Ni = i;
        am.setBackgroundResource(this.fSl, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dkG.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dkG.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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

    /* loaded from: classes6.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b fSC;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fSC = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.fSC = bVar;
        }

        public int bxn() {
            if (this.fSC == null) {
                return 0;
            }
            return this.fSC.bxx();
        }

        public com.baidu.tieba.emotion.editortool.b bxo() {
            return this.fSC;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fSC == null) {
                return 0;
            }
            return this.fSC.bxw();
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
                if (this.fSC.bxt() != 0) {
                    i2 = measuredWidth / this.fSC.bxt();
                }
                if (this.fSC.getRow() != 0) {
                    i3 = measuredHeight / this.fSC.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.fSp * 2, EmotionTabContentView.this.fSp * 2, EmotionTabContentView.this.fSp * 2, EmotionTabContentView.this.fSp * 2);
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
            if (this.fSC != null) {
                int bxx = this.fSC.bxx() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.Ni);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ms = this.fSC.bxr().ms(bxx);
                tbImageView.setTag(ms);
                if (!TextUtils.isEmpty(ms)) {
                    Object a = com.baidu.adp.lib.e.c.gr().a(ms, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, ms, false, null);
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
                if (this.fSC.bxs() == EmotionGroupType.BIG_EMOTION) {
                    String ms2 = this.fSC.bxr().ms(bxx);
                    if (!TextUtils.isEmpty(ms2) && !ms2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.Ni == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ms2.substring(ms2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, ms2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (ms != null && ms.length() > 3) {
                    linearLayout3.setContentDescription(ms.substring(2, ms.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes6.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.fSu == null) {
                return 0;
            }
            return EmotionTabContentView.this.fSu.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.fSA.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.fSA.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.fSu != null && i < EmotionTabContentView.this.fSu.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSu.get(i);
                gridView2.setNumColumns(bVar.bxt());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bxo() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bxo = aVar.bxo();
                        if (bxo.bxs() == EmotionGroupType.BIG_EMOTION || bxo.bxs() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.FO != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bxo() != null) {
                                com.baidu.tieba.emotion.editortool.b bxo = aVar.bxo();
                                int bxn = aVar.bxn();
                                com.baidu.tbadk.editortools.emotiontool.c bxr = bxo.bxr();
                                String ms = bxo.bxr().ms(bxn + i2);
                                if (bxr.aOJ() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(ms)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(ms);
                                qVar.a(bxr.aOJ());
                                qVar.uj(bxr.getGroupName());
                                qVar.setPid(bxr.getGroupId());
                                qVar.setWidth(bxr.getWidth());
                                qVar.setHeight(bxr.getHeight());
                                EmotionTabContentView.this.FO.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.fSu != null) {
                int size = EmotionTabContentView.this.fSu.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Ev) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.fSu.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Ev = i;
                        EmotionTabContentView.this.dkG.setVisibility(bVar.bxu() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dkG.setCount(bVar.bxu());
                        EmotionTabContentView.this.dkG.setPosition(bVar.bxv());
                        EmotionTabContentView.this.dkG.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bxv() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bxu())));
                    }
                    if (bVar != null && bVar.bxy() != EmotionTabContentView.this.fSw) {
                        EmotionTabContentView.this.fSw = bVar.bxy();
                        if (EmotionTabContentView.this.fSx != null) {
                            EmotionTabContentView.this.fSx.rD(bVar.bxy());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.fSx = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cLH);
    }
}
