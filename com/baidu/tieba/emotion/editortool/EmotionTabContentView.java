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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private EditorTools SY;
    private int aBL;
    private int aHp;
    private IndicatorView aHv;
    private CustomMessageListener ajQ;
    private LinearLayout deA;
    private WindowManager.LayoutParams deB;
    private GifView deC;
    private ViewGroup deD;
    private int deE;
    private int deF;
    private int deG;
    private boolean deH;
    private int deI;
    private com.baidu.tieba.emotion.editortool.b deJ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> deK;
    private List<com.baidu.tieba.emotion.editortool.b> deL;
    private int deM;
    private int deN;
    private b deO;
    private int deP;
    private final Point deQ;
    private com.baidu.adp.lib.e.b<GridView> deR;
    private EmotionViewPagerAdapter dey;
    private GridView dez;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes5.dex */
    public interface b {
        void kx(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.deI = -1;
        this.deM = 0;
        this.deN = -1;
        this.aBL = -1;
        this.deQ = new Point();
        this.ajQ = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bc(new ArrayList(EmotionTabContentView.this.deK));
                        if (EmotionTabContentView.this.dey != null) {
                            EmotionTabContentView.this.dey.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.deN < 0 || EmotionTabContentView.this.deN >= EmotionTabContentView.this.deK.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.deK.get(EmotionTabContentView.this.deN)).KW() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dey != null) {
                                if (EmotionTabContentView.this.aBL >= 0 && EmotionTabContentView.this.aBL < EmotionTabContentView.this.deL.size()) {
                                    EmotionTabContentView.this.deJ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.deL.get(EmotionTabContentView.this.aBL);
                                    int atq = EmotionTabContentView.this.deJ.atq();
                                    EmotionTabContentView.this.aHv.setCount(atq);
                                    EmotionTabContentView.this.aHv.setVisibility(atq > 1 ? 0 : 4);
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
                                                    int index = aVar.atk().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.deL.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.deL.get(index));
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
        this.deI = -1;
        this.deM = 0;
        this.deN = -1;
        this.aBL = -1;
        this.deQ = new Point();
        this.ajQ = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.bc(new ArrayList(EmotionTabContentView.this.deK));
                        if (EmotionTabContentView.this.dey != null) {
                            EmotionTabContentView.this.dey.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.deN < 0 || EmotionTabContentView.this.deN >= EmotionTabContentView.this.deK.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.deK.get(EmotionTabContentView.this.deN)).KW() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dey != null) {
                                if (EmotionTabContentView.this.aBL >= 0 && EmotionTabContentView.this.aBL < EmotionTabContentView.this.deL.size()) {
                                    EmotionTabContentView.this.deJ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.deL.get(EmotionTabContentView.this.aBL);
                                    int atq = EmotionTabContentView.this.deJ.atq();
                                    EmotionTabContentView.this.aHv.setCount(atq);
                                    EmotionTabContentView.this.aHv.setVisibility(atq > 1 ? 0 : 4);
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
                                                    int index = aVar.atk().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.deL.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.deL.get(index));
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
        this.deK = new ArrayList();
        this.deL = new ArrayList();
        this.deR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ati */
            public GridView jB() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public GridView v(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public GridView w(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(e.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(e.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.deC = new GifView(context);
        al.d(this.deC, e.f.bg_expression_bubble, this.aHp);
        this.deC.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.deB = new WindowManager.LayoutParams();
        this.deE = context.getResources().getDimensionPixelSize(e.C0175e.ds240);
        this.deF = context.getResources().getDimensionPixelSize(e.C0175e.ds252);
        this.deG = context.getResources().getDimensionPixelSize(e.C0175e.ds10);
        this.deB.width = this.deE;
        this.deB.height = this.deF;
        this.deB.gravity = 51;
        this.deB.format = -3;
        this.deB.type = 1000;
        this.deB.flags |= 56;
        this.deD = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aHv = (IndicatorView) findViewById(e.g.face_tab_indicator);
        this.deA = (LinearLayout) findViewById(e.g.face_tab_indicator_layout);
        this.deA.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.deB.type = 1000;
            this.deB.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.deK.clear();
        this.deL.clear();
        if (list != null && !list.isEmpty()) {
            this.deK.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int KZ = cVar.KZ();
                    int La = cVar.La();
                    int i4 = emotionsCount / (KZ * La);
                    if (emotionsCount % (KZ * La) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = KZ * La;
                        } else {
                            i = emotionsCount - ((KZ * La) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.kC(i3);
                        bVar.b(cVar.KW());
                        bVar.fs(La);
                        bVar.fr(KZ);
                        bVar.ky(i4);
                        bVar.kz(i5);
                        bVar.kA(i);
                        bVar.kB(i5 * KZ * La);
                        bVar.setEndIndex((i + i2) - 1);
                        this.deL.add(bVar);
                    }
                }
            }
            this.deM = this.deL.size();
            for (int i6 = 0; i6 < this.deM; i6++) {
                if (this.deL != null && this.deL.get(i6) != null) {
                    this.deL.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void kv(int i) {
        if (this.deL != null) {
            int size = this.deL.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.deL.get(i2);
                    if (bVar != null && bVar.atu() == i) {
                        this.deP = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void j(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                bc(list);
                kv(i);
                this.dey = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.dey);
                this.mViewPager.setCurrentItem(this.deP, true);
                if (this.deO != null) {
                    this.deO.kx(i);
                    this.deN = i;
                }
            }
        }
    }

    public void kw(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.deL.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.deL.get(i3);
                        if (bVar == null || bVar.atu() != i) {
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
        if (this.deI != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.atk() != null) {
            com.baidu.tieba.emotion.editortool.b atk = aVar.atk();
            String fl = atk.atn().fl(aVar.atj() + i);
            if (atk.ato() != EmotionGroupType.USER_COLLECT || !fl.equals(com.baidu.tbadk.imageManager.d.aYg)) {
                this.deC.setTag(fl);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = fl;
                if (fl.startsWith("#(meme,")) {
                    this.deC.setShowStaticDrawable(false);
                } else {
                    this.deC.setShowStaticDrawable(true);
                }
                this.deC.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.deD.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.deB.x = this.rect.left - ((this.deB.width - linearLayout.getWidth()) / 2);
                this.deB.y = (this.rect.top - this.deB.height) + this.deG;
                this.deC.setVisibility(0);
                if (!this.deH) {
                    this.mWindowManager.addView(this.deC, this.deB);
                    this.deH = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.deC, this.deB);
                }
                gridView.setSelection(i);
                if (this.deI != -1) {
                    ((LinearLayout) gridView.getChildAt(this.deI - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.deI = i;
                this.dez = gridView;
            }
        }
    }

    private void onUp() {
        if (this.deH && this.deC.getVisibility() != 8 && this.dez != null) {
            this.dez.setSelection(-1);
            this.deC.setVisibility(8);
            if (this.deI != -1) {
                ((LinearLayout) this.dez.getChildAt(this.deI - this.dez.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.deI = -1;
            this.dez = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.deQ.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.deQ.set(x, y);
                if (this.deH && this.deC.getVisibility() != 8 && this.dez != null) {
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
                this.deQ.set(x, y);
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
                    if (this.dez != null) {
                        offsetRectIntoDescendantCoords(this.dez, this.rect);
                        int pointToPosition = this.dez.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dez);
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
        if (this.deH) {
            this.mWindowManager.removeView(this.deC);
            this.deH = false;
        }
        MessageManager.getInstance().unRegisterListener(this.ajQ);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.deL != null) {
            int size = this.deL.size();
            if (i >= 0 && i < size) {
                this.deJ = this.deL.get(i);
                if (this.aHv != null && this.deJ != null) {
                    if (this.aBL != i) {
                        this.aBL = i;
                        this.aHv.setVisibility(this.deJ.atq() > 1 ? 0 : 4);
                        this.aHv.setCount(this.deJ.atq());
                        if (this.deJ != null && this.deJ.atu() != this.deN) {
                            this.deN = this.deJ.atu();
                            if (this.deO != null) {
                                this.deO.kx(this.deJ.atu());
                            }
                        }
                    }
                    float atr = this.deJ.atr() + f;
                    this.aHv.setPosition(atr);
                    this.deA.setContentDescription(String.format(getResources().getString(e.j.emotion_selection), Integer.valueOf(((int) atr) + 1)) + String.format(getResources().getString(e.j.emotion_page), Integer.valueOf(this.deJ.atq())));
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
        this.aHp = i;
        al.d(this.deC, e.f.bg_expression_bubble, i);
        al.e(this, e.d.cp_bg_line_d, i);
        this.aHv.setSelector(al.x(i, e.f.dot_pb_expression_s));
        this.aHv.setDrawable(al.x(i, e.f.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b deT;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.deT = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.deT = bVar;
        }

        public int atj() {
            if (this.deT == null) {
                return 0;
            }
            return this.deT.att();
        }

        public com.baidu.tieba.emotion.editortool.b atk() {
            return this.deT;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.deT == null) {
                return 0;
            }
            return this.deT.ats();
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
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(e.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.deT.atp() != 0) {
                    i2 = measuredWidth / this.deT.atp();
                }
                if (this.deT.getRow() != 0) {
                    i3 = measuredHeight / this.deT.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.deG * 2, EmotionTabContentView.this.deG * 2, EmotionTabContentView.this.deG * 2, EmotionTabContentView.this.deG * 2);
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
            if (this.deT != null) {
                int att = this.deT.att() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(e.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, e.f.btn_choose_face_selector, EmotionTabContentView.this.aHp);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String fl = this.deT.atn().fl(att);
                tbImageView.setTag(fl);
                if (!TextUtils.isEmpty(fl)) {
                    Object a = com.baidu.adp.lib.f.c.jC().a(fl, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, fl, false, null);
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
                TextView textView = (TextView) linearLayout3.findViewById(e.g.emotion_tab_content_tip);
                if (this.deT.ato() == EmotionGroupType.BIG_EMOTION) {
                    String fl2 = this.deT.atn().fl(att);
                    if (!TextUtils.isEmpty(fl2) && !fl2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aHp == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(e.d.cp_cont_c);
                        } else {
                            color = al.getColor(e.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(fl2.substring(fl2.lastIndexOf(BaseRequestAction.SPLITE) + 1, fl2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (fl != null && fl.length() > 3) {
                    linearLayout3.setContentDescription(fl.substring(2, fl.length() - 1));
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
            if (EmotionTabContentView.this.deL == null) {
                return 0;
            }
            return EmotionTabContentView.this.deL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.deR.t(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.deR.jA();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.deL != null && i < EmotionTabContentView.this.deL.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.deL.get(i);
                gridView2.setNumColumns(bVar.atp());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(e.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.atk() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b atk = aVar.atk();
                        if (atk.ato() == EmotionGroupType.BIG_EMOTION || atk.ato() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.SY != null) {
                            o oVar = new o();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.atk() != null) {
                                com.baidu.tieba.emotion.editortool.b atk = aVar.atk();
                                int atj = aVar.atj();
                                com.baidu.tbadk.editortools.emotiontool.c atn = atk.atn();
                                String fl = atk.atn().fl(atj + i2);
                                if (atn.KW() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aYg.equals(fl)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                oVar.setName(fl);
                                oVar.a(atn.KW());
                                oVar.gj(atn.getGroupName());
                                oVar.setPid(atn.getGroupId());
                                oVar.setWidth(atn.getWidth());
                                oVar.setHeight(atn.getHeight());
                                EmotionTabContentView.this.SY.b(new com.baidu.tbadk.editortools.a(24, -1, oVar));
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
            if (EmotionTabContentView.this.deL != null) {
                int size = EmotionTabContentView.this.deL.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aBL) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.deL.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aBL = i;
                        EmotionTabContentView.this.aHv.setVisibility(bVar.atq() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aHv.setCount(bVar.atq());
                        EmotionTabContentView.this.aHv.setPosition(bVar.atr());
                        EmotionTabContentView.this.aHv.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_selection), Integer.valueOf(bVar.atr() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_page), Integer.valueOf(bVar.atq())));
                    }
                    if (bVar != null && bVar.atu() != EmotionTabContentView.this.deN) {
                        EmotionTabContentView.this.deN = bVar.atu();
                        if (EmotionTabContentView.this.deO != null) {
                            EmotionTabContentView.this.deO.kx(bVar.atu());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.deO = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ajQ);
    }
}
