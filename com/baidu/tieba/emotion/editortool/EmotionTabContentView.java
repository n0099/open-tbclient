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
    private int Zz;
    private EditorTools aaS;
    private int aiX;
    private final Rect bry;
    private CustomMessageListener dWP;
    private IndicatorView eAy;
    private EmotionViewPagerAdapter hze;
    private GridView hzf;
    private LinearLayout hzg;
    private WindowManager.LayoutParams hzh;
    private GifView hzi;
    private ViewGroup hzj;
    private int hzk;
    private int hzl;
    private int hzm;
    private boolean hzn;
    private int hzo;
    private com.baidu.tieba.emotion.editortool.b hzp;
    private List<com.baidu.tbadk.editortools.emotiontool.c> hzq;
    private List<com.baidu.tieba.emotion.editortool.b> hzr;
    private int hzs;
    private int hzt;
    private b hzu;
    private int hzv;
    private final Point hzw;
    private com.baidu.adp.lib.d.b<GridView> hzx;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    /* loaded from: classes13.dex */
    public interface b {
        void wk(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bry = new Rect();
        this.hzo = -1;
        this.hzs = 0;
        this.hzt = -1;
        this.Zz = -1;
        this.hzw = new Point();
        this.dWP = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cn(new ArrayList(EmotionTabContentView.this.hzq));
                        if (EmotionTabContentView.this.hze != null) {
                            EmotionTabContentView.this.hze.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hzt < 0 || EmotionTabContentView.this.hzt >= EmotionTabContentView.this.hzq.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hzq.get(EmotionTabContentView.this.hzt)).bsP() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hze != null) {
                                if (EmotionTabContentView.this.Zz >= 0 && EmotionTabContentView.this.Zz < EmotionTabContentView.this.hzr.size()) {
                                    EmotionTabContentView.this.hzp = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hzr.get(EmotionTabContentView.this.Zz);
                                    int chy = EmotionTabContentView.this.hzp.chy();
                                    EmotionTabContentView.this.eAy.setCount(chy);
                                    EmotionTabContentView.this.eAy.setVisibility(chy > 1 ? 0 : 4);
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
                                                    int index = aVar.chs().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hzr.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hzr.get(index));
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
        this.bry = new Rect();
        this.hzo = -1;
        this.hzs = 0;
        this.hzt = -1;
        this.Zz = -1;
        this.hzw = new Point();
        this.dWP = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cn(new ArrayList(EmotionTabContentView.this.hzq));
                        if (EmotionTabContentView.this.hze != null) {
                            EmotionTabContentView.this.hze.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hzt < 0 || EmotionTabContentView.this.hzt >= EmotionTabContentView.this.hzq.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hzq.get(EmotionTabContentView.this.hzt)).bsP() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hze != null) {
                                if (EmotionTabContentView.this.Zz >= 0 && EmotionTabContentView.this.Zz < EmotionTabContentView.this.hzr.size()) {
                                    EmotionTabContentView.this.hzp = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hzr.get(EmotionTabContentView.this.Zz);
                                    int chy = EmotionTabContentView.this.hzp.chy();
                                    EmotionTabContentView.this.eAy.setCount(chy);
                                    EmotionTabContentView.this.eAy.setVisibility(chy > 1 ? 0 : 4);
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
                                                    int index = aVar.chs().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hzr.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hzr.get(index));
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
        this.hzq = new ArrayList();
        this.hzr = new ArrayList();
        this.hzx = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: chq */
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
        this.hzi = new GifView(context);
        ap.setBackgroundResource(this.hzi, R.drawable.bg_expression_bubble, this.aiX);
        this.hzi.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.hzh = new WindowManager.LayoutParams();
        this.hzk = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.hzl = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.hzm = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.hzh.width = this.hzk;
        this.hzh.height = this.hzl;
        this.hzh.gravity = 51;
        this.hzh.format = -3;
        this.hzh.type = 1000;
        this.hzh.flags |= 56;
        this.hzj = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eAy = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.hzg = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.hzg.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.hzh.type = 1000;
            this.hzh.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.hzq.clear();
        this.hzr.clear();
        if (list != null && !list.isEmpty()) {
            this.hzq.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bsS = cVar.bsS();
                    int bsT = cVar.bsT();
                    int i4 = emotionsCount / (bsS * bsT);
                    if (emotionsCount % (bsS * bsT) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bsS * bsT;
                        } else {
                            i = emotionsCount - ((bsS * bsT) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.wq(i3);
                        bVar.b(cVar.bsP());
                        bVar.qE(bsT);
                        bVar.setColumn(bsS);
                        bVar.wl(i4);
                        bVar.wm(i5);
                        bVar.wn(i);
                        bVar.wo(i5 * bsS * bsT);
                        bVar.wp((i + i2) - 1);
                        this.hzr.add(bVar);
                    }
                }
            }
            this.hzs = this.hzr.size();
            for (int i6 = 0; i6 < this.hzs; i6++) {
                if (this.hzr != null && this.hzr.get(i6) != null) {
                    this.hzr.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void wi(int i) {
        if (this.hzr != null) {
            int size = this.hzr.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.hzr.get(i2);
                    if (bVar != null && bVar.chC() == i) {
                        this.hzv = bVar.getIndex();
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
                cn(list);
                wi(i);
                this.hze = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.hze);
                this.mViewPager.setCurrentItem(this.hzv, true);
                if (this.hzu != null) {
                    this.hzu.wk(i);
                    this.hzt = i;
                }
            }
        }
    }

    public void wj(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.hzr.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.hzr.get(i3);
                        if (bVar == null || bVar.chC() != i) {
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
        if (this.hzo != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.chs() != null) {
            com.baidu.tieba.emotion.editortool.b chs = aVar.chs();
            String qu = chs.chv().qu(aVar.chr() + i);
            if (chs.chw() != EmotionGroupType.USER_COLLECT || !qu.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.hzi.setTag(qu);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qu;
                if (qu.startsWith("#(meme,")) {
                    this.hzi.setShowStaticDrawable(false);
                } else {
                    this.hzi.setShowStaticDrawable(true);
                }
                this.hzi.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.bry);
                this.hzj.offsetDescendantRectToMyCoords(linearLayout, this.bry);
                this.hzh.x = this.bry.left - ((this.hzh.width - linearLayout.getWidth()) / 2);
                this.hzh.y = (this.bry.top - this.hzh.height) + this.hzm;
                this.hzi.setVisibility(0);
                if (!this.hzn) {
                    this.mWindowManager.addView(this.hzi, this.hzh);
                    this.hzn = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.hzi, this.hzh);
                }
                gridView.setSelection(i);
                if (this.hzo != -1) {
                    ((LinearLayout) gridView.getChildAt(this.hzo - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.hzo = i;
                this.hzf = gridView;
            }
        }
    }

    private void onUp() {
        if (this.hzn && this.hzi.getVisibility() != 8 && this.hzf != null) {
            this.hzf.setSelection(-1);
            this.hzi.setVisibility(8);
            if (this.hzo != -1) {
                ((LinearLayout) this.hzf.getChildAt(this.hzo - this.hzf.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.hzo = -1;
            this.hzf = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.hzw.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.hzw.set(x, y);
                if (this.hzn && this.hzi.getVisibility() != 8 && this.hzf != null) {
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
                this.hzw.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                onUp();
                break;
            case 2:
                getFocusedRect(this.bry);
                if (!this.bry.contains(x, y)) {
                    onUp();
                    break;
                } else {
                    this.bry.set(x, y, x + 1, y + 1);
                    if (this.hzf != null) {
                        offsetRectIntoDescendantCoords(this.hzf, this.bry);
                        int pointToPosition = this.hzf.pointToPosition(this.bry.left, this.bry.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.hzf);
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
        if (this.hzn) {
            this.mWindowManager.removeView(this.hzi);
            this.hzn = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dWP);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hzr != null) {
            int size = this.hzr.size();
            if (i >= 0 && i < size) {
                this.hzp = this.hzr.get(i);
                if (this.eAy != null && this.hzp != null) {
                    if (this.Zz != i) {
                        this.Zz = i;
                        this.eAy.setVisibility(this.hzp.chy() > 1 ? 0 : 4);
                        this.eAy.setCount(this.hzp.chy());
                        if (this.hzp != null && this.hzp.chC() != this.hzt) {
                            this.hzt = this.hzp.chC();
                            if (this.hzu != null) {
                                this.hzu.wk(this.hzp.chC());
                            }
                        }
                    }
                    float chz = this.hzp.chz() + f;
                    this.eAy.setPosition(chz);
                    this.hzg.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) chz) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.hzp.chy())));
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
        this.aiX = i;
        ap.setBackgroundResource(this.hzi, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.eAy.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eAy.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b hzz;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hzz = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hzz = bVar;
        }

        public int chr() {
            if (this.hzz == null) {
                return 0;
            }
            return this.hzz.chB();
        }

        public com.baidu.tieba.emotion.editortool.b chs() {
            return this.hzz;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.hzz == null) {
                return 0;
            }
            return this.hzz.chA();
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
                if (this.hzz.chx() != 0) {
                    i2 = measuredWidth / this.hzz.chx();
                }
                if (this.hzz.getRow() != 0) {
                    i3 = measuredHeight / this.hzz.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.hzm * 2, EmotionTabContentView.this.hzm * 2, EmotionTabContentView.this.hzm * 2, EmotionTabContentView.this.hzm * 2);
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
            if (this.hzz != null) {
                int chB = this.hzz.chB() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aiX);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qu = this.hzz.chv().qu(chB);
                tbImageView.setTag(qu);
                if (!TextUtils.isEmpty(qu)) {
                    Object a = com.baidu.adp.lib.e.c.mR().a(qu, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, qu, false, null);
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
                if (this.hzz.chw() == EmotionGroupType.BIG_EMOTION) {
                    String qu2 = this.hzz.chv().qu(chB);
                    if (!TextUtils.isEmpty(qu2) && !qu2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aiX == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = ap.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(qu2.substring(qu2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, qu2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (qu != null && qu.length() > 3) {
                    linearLayout3.setContentDescription(qu.substring(2, qu.length() - 1));
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
            if (EmotionTabContentView.this.hzr == null) {
                return 0;
            }
            return EmotionTabContentView.this.hzr.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.hzx.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.hzx.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.hzr != null && i < EmotionTabContentView.this.hzr.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hzr.get(i);
                gridView2.setNumColumns(bVar.chx());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.chs() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b chs = aVar.chs();
                        if (chs.chw() == EmotionGroupType.BIG_EMOTION || chs.chw() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.aaS != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.chs() != null) {
                                com.baidu.tieba.emotion.editortool.b chs = aVar.chs();
                                int chr = aVar.chr();
                                com.baidu.tbadk.editortools.emotiontool.c chv = chs.chv();
                                String qu = chs.chv().qu(chr + i2);
                                if (chv.bsP() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qu)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(qu);
                                uVar.a(chv.bsP());
                                uVar.Br(chv.getGroupName());
                                uVar.setPid(chv.getGroupId());
                                uVar.setWidth(chv.getWidth());
                                uVar.setHeight(chv.getHeight());
                                EmotionTabContentView.this.aaS.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.hzr != null) {
                int size = EmotionTabContentView.this.hzr.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Zz) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hzr.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Zz = i;
                        EmotionTabContentView.this.eAy.setVisibility(bVar.chy() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eAy.setCount(bVar.chy());
                        EmotionTabContentView.this.eAy.setPosition(bVar.chz());
                        EmotionTabContentView.this.eAy.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.chz() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.chy())));
                    }
                    if (bVar != null && bVar.chC() != EmotionTabContentView.this.hzt) {
                        EmotionTabContentView.this.hzt = bVar.chC();
                        if (EmotionTabContentView.this.hzu != null) {
                            EmotionTabContentView.this.hzu.wk(bVar.chC());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.hzu = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dWP);
    }
}
