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
/* loaded from: classes13.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int aaR;
    private EditorTools acn;
    private int aku;
    private final Rect bHi;
    private CustomMessageListener eCA;
    private IndicatorView fhv;
    private EmotionViewPagerAdapter ish;
    private GridView isi;
    private LinearLayout isj;
    private WindowManager.LayoutParams isk;
    private GifView isl;
    private ViewGroup ism;
    private int isn;
    private int iso;
    private int isp;
    private boolean isq;
    private int isr;
    private com.baidu.tieba.emotion.editortool.b iss;
    private List<com.baidu.tbadk.editortools.emotiontool.c> ist;
    private List<com.baidu.tieba.emotion.editortool.b> isu;
    private int isv;
    private int isw;
    private b isx;
    private int isy;
    private com.baidu.adp.lib.d.b<GridView> isz;
    private Context mContext;
    private final Point mStartPoint;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes13.dex */
    public interface b {
        void yz(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHi = new Rect();
        this.isr = -1;
        this.isv = 0;
        this.isw = -1;
        this.aaR = -1;
        this.mStartPoint = new Point();
        this.eCA = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cL(new ArrayList(EmotionTabContentView.this.ist));
                        if (EmotionTabContentView.this.ish != null) {
                            EmotionTabContentView.this.ish.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.isw < 0 || EmotionTabContentView.this.isw >= EmotionTabContentView.this.ist.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ist.get(EmotionTabContentView.this.isw)).bCH() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ish != null) {
                                if (EmotionTabContentView.this.aaR >= 0 && EmotionTabContentView.this.aaR < EmotionTabContentView.this.isu.size()) {
                                    EmotionTabContentView.this.iss = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.isu.get(EmotionTabContentView.this.aaR);
                                    int cuu = EmotionTabContentView.this.iss.cuu();
                                    EmotionTabContentView.this.fhv.setCount(cuu);
                                    EmotionTabContentView.this.fhv.setVisibility(cuu > 1 ? 0 : 4);
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
                                                    int index = aVar.cuo().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.isu.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.isu.get(index));
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
        this.bHi = new Rect();
        this.isr = -1;
        this.isv = 0;
        this.isw = -1;
        this.aaR = -1;
        this.mStartPoint = new Point();
        this.eCA = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cL(new ArrayList(EmotionTabContentView.this.ist));
                        if (EmotionTabContentView.this.ish != null) {
                            EmotionTabContentView.this.ish.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.isw < 0 || EmotionTabContentView.this.isw >= EmotionTabContentView.this.ist.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.ist.get(EmotionTabContentView.this.isw)).bCH() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.ish != null) {
                                if (EmotionTabContentView.this.aaR >= 0 && EmotionTabContentView.this.aaR < EmotionTabContentView.this.isu.size()) {
                                    EmotionTabContentView.this.iss = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.isu.get(EmotionTabContentView.this.aaR);
                                    int cuu = EmotionTabContentView.this.iss.cuu();
                                    EmotionTabContentView.this.fhv.setCount(cuu);
                                    EmotionTabContentView.this.fhv.setVisibility(cuu > 1 ? 0 : 4);
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
                                                    int index = aVar.cuo().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.isu.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.isu.get(index));
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
        this.ist = new ArrayList();
        this.isu = new ArrayList();
        this.isz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cum */
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
        this.isl = new GifView(context);
        ap.setBackgroundResource(this.isl, R.drawable.bg_expression_bubble, this.aku);
        this.isl.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.isk = new WindowManager.LayoutParams();
        this.isn = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iso = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.isp = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.isk.width = this.isn;
        this.isk.height = this.iso;
        this.isk.gravity = 51;
        this.isk.format = -3;
        this.isk.type = 1000;
        this.isk.flags |= 56;
        this.ism = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.fhv = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.isj = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.isj.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.isk.type = 1000;
            this.isk.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.ist.clear();
        this.isu.clear();
        if (list != null && !list.isEmpty()) {
            this.ist.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bCK = cVar.bCK();
                    int bCL = cVar.bCL();
                    int i4 = emotionsCount / (bCK * bCL);
                    if (emotionsCount % (bCK * bCL) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bCK * bCL;
                        } else {
                            i = emotionsCount - ((bCK * bCL) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.yF(i3);
                        bVar.b(cVar.bCH());
                        bVar.sw(bCL);
                        bVar.setColumn(bCK);
                        bVar.yA(i4);
                        bVar.yB(i5);
                        bVar.yC(i);
                        bVar.yD(i5 * bCK * bCL);
                        bVar.yE((i + i2) - 1);
                        this.isu.add(bVar);
                    }
                }
            }
            this.isv = this.isu.size();
            for (int i6 = 0; i6 < this.isv; i6++) {
                if (this.isu != null && this.isu.get(i6) != null) {
                    this.isu.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void yx(int i) {
        if (this.isu != null) {
            int size = this.isu.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.isu.get(i2);
                    if (bVar != null && bVar.cuy() == i) {
                        this.isy = bVar.getIndex();
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
                cL(list);
                yx(i);
                this.ish = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.ish);
                this.mViewPager.setCurrentItem(this.isy, true);
                if (this.isx != null) {
                    this.isx.yz(i);
                    this.isw = i;
                }
            }
        }
    }

    public void yy(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.isu.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.isu.get(i3);
                        if (bVar == null || bVar.cuy() != i) {
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
        if (this.isr != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cuo() != null) {
            com.baidu.tieba.emotion.editortool.b cuo = aVar.cuo();
            String sm = cuo.cur().sm(aVar.cun() + i);
            if (cuo.cus() != EmotionGroupType.USER_COLLECT || !sm.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.isl.setTag(sm);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = sm;
                if (sm.startsWith("#(meme,")) {
                    this.isl.setShowStaticDrawable(false);
                } else {
                    this.isl.setShowStaticDrawable(true);
                }
                this.isl.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bHi);
                this.ism.offsetDescendantRectToMyCoords(linearLayout, this.bHi);
                this.isk.x = this.bHi.left - ((this.isk.width - linearLayout.getWidth()) / 2);
                this.isk.y = (this.bHi.top - this.isk.height) + this.isp;
                this.isl.setVisibility(0);
                if (!this.isq) {
                    this.mWindowManager.addView(this.isl, this.isk);
                    this.isq = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.isl, this.isk);
                }
                gridView.setSelection(i);
                if (this.isr != -1) {
                    ((LinearLayout) gridView.getChildAt(this.isr - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.isr = i;
                this.isi = gridView;
            }
        }
    }

    private void onUp() {
        if (this.isq && this.isl.getVisibility() != 8 && this.isi != null) {
            this.isi.setSelection(-1);
            this.isl.setVisibility(8);
            if (this.isr != -1) {
                ((LinearLayout) this.isi.getChildAt(this.isr - this.isi.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.isr = -1;
            this.isi = null;
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
                onUp();
                break;
            case 2:
                this.mStartPoint.set(x, y);
                if (this.isq && this.isl.getVisibility() != 8 && this.isi != null) {
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
                onUp();
                break;
            case 2:
                getFocusedRect(this.bHi);
                if (!this.bHi.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.bHi.set(x, y, x + 1, y + 1);
                    if (this.isi != null) {
                        offsetRectIntoDescendantCoords(this.isi, this.bHi);
                        int pointToPosition = this.isi.pointToPosition(this.bHi.left, this.bHi.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.isi);
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
        if (this.isq) {
            this.mWindowManager.removeView(this.isl);
            this.isq = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eCA);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.isu != null) {
            int size = this.isu.size();
            if (i >= 0 && i < size) {
                this.iss = this.isu.get(i);
                if (this.fhv != null && this.iss != null) {
                    if (this.aaR != i) {
                        this.aaR = i;
                        this.fhv.setVisibility(this.iss.cuu() > 1 ? 0 : 4);
                        this.fhv.setCount(this.iss.cuu());
                        if (this.iss != null && this.iss.cuy() != this.isw) {
                            this.isw = this.iss.cuy();
                            if (this.isx != null) {
                                this.isx.yz(this.iss.cuy());
                            }
                        }
                    }
                    float cuv = this.iss.cuv() + f;
                    this.fhv.setPosition(cuv);
                    this.isj.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cuv) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.iss.cuu())));
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
        this.aku = i;
        ap.setBackgroundResource(this.isl, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.CAM_X0206, i);
        this.fhv.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.fhv.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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

    /* loaded from: classes13.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b isB;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.isB = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.isB = bVar;
        }

        public int cun() {
            if (this.isB == null) {
                return 0;
            }
            return this.isB.cux();
        }

        public com.baidu.tieba.emotion.editortool.b cuo() {
            return this.isB;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.isB == null) {
                return 0;
            }
            return this.isB.cuw();
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
                if (this.isB.cut() != 0) {
                    i2 = measuredWidth / this.isB.cut();
                }
                if (this.isB.getRow() != 0) {
                    i3 = measuredHeight / this.isB.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.isp * 2, EmotionTabContentView.this.isp * 2, EmotionTabContentView.this.isp * 2, EmotionTabContentView.this.isp * 2);
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
            if (this.isB != null) {
                int cux = this.isB.cux() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aku);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String sm = this.isB.cur().sm(cux);
                tbImageView.setTag(sm);
                if (!TextUtils.isEmpty(sm)) {
                    Object a2 = com.baidu.adp.lib.e.c.mS().a(sm, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, sm, false, null);
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
                if (this.isB.cus() == EmotionGroupType.BIG_EMOTION) {
                    String sm2 = this.isB.cur().sm(cux);
                    if (!TextUtils.isEmpty(sm2) && !sm2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aku == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = ap.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(sm2.substring(sm2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, sm2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (sm != null && sm.length() > 3) {
                    linearLayout3.setContentDescription(sm.substring(2, sm.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes13.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.isu == null) {
                return 0;
            }
            return EmotionTabContentView.this.isu.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.isz.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.isz.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.isu != null && i < EmotionTabContentView.this.isu.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.isu.get(i);
                gridView2.setNumColumns(bVar.cut());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cuo() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cuo = aVar.cuo();
                        if (cuo.cus() == EmotionGroupType.BIG_EMOTION || cuo.cus() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.acn != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cuo() != null) {
                                com.baidu.tieba.emotion.editortool.b cuo = aVar.cuo();
                                int cun = aVar.cun();
                                com.baidu.tbadk.editortools.emotiontool.c cur = cuo.cur();
                                String sm = cuo.cur().sm(cun + i2);
                                if (cur.bCH() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(sm)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(sm);
                                uVar.a(cur.bCH());
                                uVar.CR(cur.getGroupName());
                                uVar.setPid(cur.getGroupId());
                                uVar.setWidth(cur.getWidth());
                                uVar.setHeight(cur.getHeight());
                                EmotionTabContentView.this.acn.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.isu != null) {
                int size = EmotionTabContentView.this.isu.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aaR) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.isu.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aaR = i;
                        EmotionTabContentView.this.fhv.setVisibility(bVar.cuu() > 1 ? 0 : 4);
                        EmotionTabContentView.this.fhv.setCount(bVar.cuu());
                        EmotionTabContentView.this.fhv.setPosition(bVar.cuv());
                        EmotionTabContentView.this.fhv.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cuv() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cuu())));
                    }
                    if (bVar != null && bVar.cuy() != EmotionTabContentView.this.isw) {
                        EmotionTabContentView.this.isw = bVar.cuy();
                        if (EmotionTabContentView.this.isx != null) {
                            EmotionTabContentView.this.isx.yz(bVar.cuy());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.isx = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eCA);
    }
}
