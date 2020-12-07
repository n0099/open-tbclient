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
    private EmotionViewPagerAdapter isf;
    private GridView isg;
    private LinearLayout ish;
    private WindowManager.LayoutParams isi;
    private GifView isj;
    private ViewGroup isk;
    private int isl;
    private int ism;
    private int isn;
    private boolean iso;
    private int isp;
    private com.baidu.tieba.emotion.editortool.b isq;
    private List<com.baidu.tbadk.editortools.emotiontool.c> isr;
    private List<com.baidu.tieba.emotion.editortool.b> iss;
    private int ist;
    private int isu;
    private b isv;
    private int isw;
    private com.baidu.adp.lib.d.b<GridView> isx;
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
        this.isp = -1;
        this.ist = 0;
        this.isu = -1;
        this.aaR = -1;
        this.mStartPoint = new Point();
        this.eCA = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cL(new ArrayList(EmotionTabContentView.this.isr));
                        if (EmotionTabContentView.this.isf != null) {
                            EmotionTabContentView.this.isf.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.isu < 0 || EmotionTabContentView.this.isu >= EmotionTabContentView.this.isr.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.isr.get(EmotionTabContentView.this.isu)).bCH() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.isf != null) {
                                if (EmotionTabContentView.this.aaR >= 0 && EmotionTabContentView.this.aaR < EmotionTabContentView.this.iss.size()) {
                                    EmotionTabContentView.this.isq = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iss.get(EmotionTabContentView.this.aaR);
                                    int cut = EmotionTabContentView.this.isq.cut();
                                    EmotionTabContentView.this.fhv.setCount(cut);
                                    EmotionTabContentView.this.fhv.setVisibility(cut > 1 ? 0 : 4);
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
                                                    int index = aVar.cun().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iss.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iss.get(index));
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
        this.isp = -1;
        this.ist = 0;
        this.isu = -1;
        this.aaR = -1;
        this.mStartPoint = new Point();
        this.eCA = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cL(new ArrayList(EmotionTabContentView.this.isr));
                        if (EmotionTabContentView.this.isf != null) {
                            EmotionTabContentView.this.isf.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.isu < 0 || EmotionTabContentView.this.isu >= EmotionTabContentView.this.isr.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.isr.get(EmotionTabContentView.this.isu)).bCH() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.isf != null) {
                                if (EmotionTabContentView.this.aaR >= 0 && EmotionTabContentView.this.aaR < EmotionTabContentView.this.iss.size()) {
                                    EmotionTabContentView.this.isq = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iss.get(EmotionTabContentView.this.aaR);
                                    int cut = EmotionTabContentView.this.isq.cut();
                                    EmotionTabContentView.this.fhv.setCount(cut);
                                    EmotionTabContentView.this.fhv.setVisibility(cut > 1 ? 0 : 4);
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
                                                    int index = aVar.cun().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iss.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iss.get(index));
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
        this.isr = new ArrayList();
        this.iss = new ArrayList();
        this.isx = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cul */
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
        this.isj = new GifView(context);
        ap.setBackgroundResource(this.isj, R.drawable.bg_expression_bubble, this.aku);
        this.isj.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.isi = new WindowManager.LayoutParams();
        this.isl = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.ism = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.isn = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.isi.width = this.isl;
        this.isi.height = this.ism;
        this.isi.gravity = 51;
        this.isi.format = -3;
        this.isi.type = 1000;
        this.isi.flags |= 56;
        this.isk = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.fhv = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.ish = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.ish.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.isi.type = 1000;
            this.isi.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.isr.clear();
        this.iss.clear();
        if (list != null && !list.isEmpty()) {
            this.isr.addAll(list);
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
                        this.iss.add(bVar);
                    }
                }
            }
            this.ist = this.iss.size();
            for (int i6 = 0; i6 < this.ist; i6++) {
                if (this.iss != null && this.iss.get(i6) != null) {
                    this.iss.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void yx(int i) {
        if (this.iss != null) {
            int size = this.iss.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.iss.get(i2);
                    if (bVar != null && bVar.cux() == i) {
                        this.isw = bVar.getIndex();
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
                this.isf = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.isf);
                this.mViewPager.setCurrentItem(this.isw, true);
                if (this.isv != null) {
                    this.isv.yz(i);
                    this.isu = i;
                }
            }
        }
    }

    public void yy(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.iss.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.iss.get(i3);
                        if (bVar == null || bVar.cux() != i) {
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
        if (this.isp != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cun() != null) {
            com.baidu.tieba.emotion.editortool.b cun = aVar.cun();
            String sm = cun.cuq().sm(aVar.cum() + i);
            if (cun.cur() != EmotionGroupType.USER_COLLECT || !sm.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.isj.setTag(sm);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = sm;
                if (sm.startsWith("#(meme,")) {
                    this.isj.setShowStaticDrawable(false);
                } else {
                    this.isj.setShowStaticDrawable(true);
                }
                this.isj.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bHi);
                this.isk.offsetDescendantRectToMyCoords(linearLayout, this.bHi);
                this.isi.x = this.bHi.left - ((this.isi.width - linearLayout.getWidth()) / 2);
                this.isi.y = (this.bHi.top - this.isi.height) + this.isn;
                this.isj.setVisibility(0);
                if (!this.iso) {
                    this.mWindowManager.addView(this.isj, this.isi);
                    this.iso = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.isj, this.isi);
                }
                gridView.setSelection(i);
                if (this.isp != -1) {
                    ((LinearLayout) gridView.getChildAt(this.isp - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.isp = i;
                this.isg = gridView;
            }
        }
    }

    private void onUp() {
        if (this.iso && this.isj.getVisibility() != 8 && this.isg != null) {
            this.isg.setSelection(-1);
            this.isj.setVisibility(8);
            if (this.isp != -1) {
                ((LinearLayout) this.isg.getChildAt(this.isp - this.isg.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.isp = -1;
            this.isg = null;
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
                if (this.iso && this.isj.getVisibility() != 8 && this.isg != null) {
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
                    if (this.isg != null) {
                        offsetRectIntoDescendantCoords(this.isg, this.bHi);
                        int pointToPosition = this.isg.pointToPosition(this.bHi.left, this.bHi.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.isg);
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
        if (this.iso) {
            this.mWindowManager.removeView(this.isj);
            this.iso = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eCA);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.iss != null) {
            int size = this.iss.size();
            if (i >= 0 && i < size) {
                this.isq = this.iss.get(i);
                if (this.fhv != null && this.isq != null) {
                    if (this.aaR != i) {
                        this.aaR = i;
                        this.fhv.setVisibility(this.isq.cut() > 1 ? 0 : 4);
                        this.fhv.setCount(this.isq.cut());
                        if (this.isq != null && this.isq.cux() != this.isu) {
                            this.isu = this.isq.cux();
                            if (this.isv != null) {
                                this.isv.yz(this.isq.cux());
                            }
                        }
                    }
                    float cuu = this.isq.cuu() + f;
                    this.fhv.setPosition(cuu);
                    this.ish.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cuu) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.isq.cut())));
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
        ap.setBackgroundResource(this.isj, R.drawable.bg_expression_bubble, i);
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
        private com.baidu.tieba.emotion.editortool.b isz;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.isz = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.isz = bVar;
        }

        public int cum() {
            if (this.isz == null) {
                return 0;
            }
            return this.isz.cuw();
        }

        public com.baidu.tieba.emotion.editortool.b cun() {
            return this.isz;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.isz == null) {
                return 0;
            }
            return this.isz.cuv();
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
                if (this.isz.cus() != 0) {
                    i2 = measuredWidth / this.isz.cus();
                }
                if (this.isz.getRow() != 0) {
                    i3 = measuredHeight / this.isz.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.isn * 2, EmotionTabContentView.this.isn * 2, EmotionTabContentView.this.isn * 2, EmotionTabContentView.this.isn * 2);
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
            if (this.isz != null) {
                int cuw = this.isz.cuw() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aku);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String sm = this.isz.cuq().sm(cuw);
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
                if (this.isz.cur() == EmotionGroupType.BIG_EMOTION) {
                    String sm2 = this.isz.cuq().sm(cuw);
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
            if (EmotionTabContentView.this.iss == null) {
                return 0;
            }
            return EmotionTabContentView.this.iss.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.isx.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.isx.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.iss != null && i < EmotionTabContentView.this.iss.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iss.get(i);
                gridView2.setNumColumns(bVar.cus());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cun() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cun = aVar.cun();
                        if (cun.cur() == EmotionGroupType.BIG_EMOTION || cun.cur() == EmotionGroupType.USER_COLLECT) {
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
                            if (aVar != null && aVar.cun() != null) {
                                com.baidu.tieba.emotion.editortool.b cun = aVar.cun();
                                int cum = aVar.cum();
                                com.baidu.tbadk.editortools.emotiontool.c cuq = cun.cuq();
                                String sm = cun.cuq().sm(cum + i2);
                                if (cuq.bCH() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(sm)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(sm);
                                uVar.a(cuq.bCH());
                                uVar.CR(cuq.getGroupName());
                                uVar.setPid(cuq.getGroupId());
                                uVar.setWidth(cuq.getWidth());
                                uVar.setHeight(cuq.getHeight());
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
            if (EmotionTabContentView.this.iss != null) {
                int size = EmotionTabContentView.this.iss.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.aaR) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iss.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.aaR = i;
                        EmotionTabContentView.this.fhv.setVisibility(bVar.cut() > 1 ? 0 : 4);
                        EmotionTabContentView.this.fhv.setCount(bVar.cut());
                        EmotionTabContentView.this.fhv.setPosition(bVar.cuu());
                        EmotionTabContentView.this.fhv.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cuu() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cut())));
                    }
                    if (bVar != null && bVar.cux() != EmotionTabContentView.this.isu) {
                        EmotionTabContentView.this.isu = bVar.cux();
                        if (EmotionTabContentView.this.isv != null) {
                            EmotionTabContentView.this.isv.yz(bVar.cux());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.isv = bVar;
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
