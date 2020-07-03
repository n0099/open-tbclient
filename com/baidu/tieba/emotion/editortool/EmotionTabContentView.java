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
import com.baidu.tbadk.core.util.an;
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
    private int YJ;
    private EditorTools ZX;
    private int ahx;
    private CustomMessageListener dFw;
    private IndicatorView ehS;
    private ViewGroup gZA;
    private int gZB;
    private int gZC;
    private int gZD;
    private boolean gZE;
    private int gZF;
    private com.baidu.tieba.emotion.editortool.b gZG;
    private List<com.baidu.tbadk.editortools.emotiontool.c> gZH;
    private List<com.baidu.tieba.emotion.editortool.b> gZI;
    private int gZJ;
    private int gZK;
    private b gZL;
    private int gZM;
    private final Point gZN;
    private com.baidu.adp.lib.d.b<GridView> gZO;
    private EmotionViewPagerAdapter gZv;
    private GridView gZw;
    private LinearLayout gZx;
    private WindowManager.LayoutParams gZy;
    private GifView gZz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void te(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.gZF = -1;
        this.gZJ = 0;
        this.gZK = -1;
        this.YJ = -1;
        this.gZN = new Point();
        this.dFw = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.ca(new ArrayList(EmotionTabContentView.this.gZH));
                        if (EmotionTabContentView.this.gZv != null) {
                            EmotionTabContentView.this.gZv.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gZK < 0 || EmotionTabContentView.this.gZK >= EmotionTabContentView.this.gZH.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gZH.get(EmotionTabContentView.this.gZK)).bfq() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gZv != null) {
                                if (EmotionTabContentView.this.YJ >= 0 && EmotionTabContentView.this.YJ < EmotionTabContentView.this.gZI.size()) {
                                    EmotionTabContentView.this.gZG = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gZI.get(EmotionTabContentView.this.YJ);
                                    int bQK = EmotionTabContentView.this.gZG.bQK();
                                    EmotionTabContentView.this.ehS.setCount(bQK);
                                    EmotionTabContentView.this.ehS.setVisibility(bQK > 1 ? 0 : 4);
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
                                                    int index = aVar.bQE().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gZI.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gZI.get(index));
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
        this.gZF = -1;
        this.gZJ = 0;
        this.gZK = -1;
        this.YJ = -1;
        this.gZN = new Point();
        this.dFw = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.ca(new ArrayList(EmotionTabContentView.this.gZH));
                        if (EmotionTabContentView.this.gZv != null) {
                            EmotionTabContentView.this.gZv.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gZK < 0 || EmotionTabContentView.this.gZK >= EmotionTabContentView.this.gZH.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gZH.get(EmotionTabContentView.this.gZK)).bfq() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gZv != null) {
                                if (EmotionTabContentView.this.YJ >= 0 && EmotionTabContentView.this.YJ < EmotionTabContentView.this.gZI.size()) {
                                    EmotionTabContentView.this.gZG = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gZI.get(EmotionTabContentView.this.YJ);
                                    int bQK = EmotionTabContentView.this.gZG.bQK();
                                    EmotionTabContentView.this.ehS.setCount(bQK);
                                    EmotionTabContentView.this.ehS.setVisibility(bQK > 1 ? 0 : 4);
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
                                                    int index = aVar.bQE().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gZI.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gZI.get(index));
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
        this.gZH = new ArrayList();
        this.gZI = new ArrayList();
        this.gZO = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQC */
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
        this.gZz = new GifView(context);
        an.setBackgroundResource(this.gZz, R.drawable.bg_expression_bubble, this.ahx);
        this.gZz.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.gZy = new WindowManager.LayoutParams();
        this.gZB = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.gZC = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.gZD = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.gZy.width = this.gZB;
        this.gZy.height = this.gZC;
        this.gZy.gravity = 51;
        this.gZy.format = -3;
        this.gZy.type = 1000;
        this.gZy.flags |= 56;
        this.gZA = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ehS = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.gZx = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.gZx.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.gZy.type = 1000;
            this.gZy.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.gZH.clear();
        this.gZI.clear();
        if (list != null && !list.isEmpty()) {
            this.gZH.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bft = cVar.bft();
                    int bfu = cVar.bfu();
                    int i4 = emotionsCount / (bft * bfu);
                    if (emotionsCount % (bft * bfu) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bft * bfu;
                        } else {
                            i = emotionsCount - ((bft * bfu) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.tk(i3);
                        bVar.b(cVar.bfq());
                        bVar.nK(bfu);
                        bVar.setColumn(bft);
                        bVar.tf(i4);
                        bVar.tg(i5);
                        bVar.th(i);
                        bVar.ti(i5 * bft * bfu);
                        bVar.tj((i + i2) - 1);
                        this.gZI.add(bVar);
                    }
                }
            }
            this.gZJ = this.gZI.size();
            for (int i6 = 0; i6 < this.gZJ; i6++) {
                if (this.gZI != null && this.gZI.get(i6) != null) {
                    this.gZI.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void tc(int i) {
        if (this.gZI != null) {
            int size = this.gZI.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.gZI.get(i2);
                    if (bVar != null && bVar.bQO() == i) {
                        this.gZM = bVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void i(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                ca(list);
                tc(i);
                this.gZv = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.gZv);
                this.mViewPager.setCurrentItem(this.gZM, true);
                if (this.gZL != null) {
                    this.gZL.te(i);
                    this.gZK = i;
                }
            }
        }
    }

    public void td(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.gZI.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.gZI.get(i3);
                        if (bVar == null || bVar.bQO() != i) {
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
        if (this.gZF != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bQE() != null) {
            com.baidu.tieba.emotion.editortool.b bQE = aVar.bQE();
            String nE = bQE.bQH().nE(aVar.bQD() + i);
            if (bQE.bQI() != EmotionGroupType.USER_COLLECT || !nE.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.gZz.setTag(nE);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = nE;
                if (nE.startsWith("#(meme,")) {
                    this.gZz.setShowStaticDrawable(false);
                } else {
                    this.gZz.setShowStaticDrawable(true);
                }
                this.gZz.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.gZA.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.gZy.x = this.rect.left - ((this.gZy.width - linearLayout.getWidth()) / 2);
                this.gZy.y = (this.rect.top - this.gZy.height) + this.gZD;
                this.gZz.setVisibility(0);
                if (!this.gZE) {
                    this.mWindowManager.addView(this.gZz, this.gZy);
                    this.gZE = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.gZz, this.gZy);
                }
                gridView.setSelection(i);
                if (this.gZF != -1) {
                    ((LinearLayout) gridView.getChildAt(this.gZF - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.gZF = i;
                this.gZw = gridView;
            }
        }
    }

    private void onUp() {
        if (this.gZE && this.gZz.getVisibility() != 8 && this.gZw != null) {
            this.gZw.setSelection(-1);
            this.gZz.setVisibility(8);
            if (this.gZF != -1) {
                ((LinearLayout) this.gZw.getChildAt(this.gZF - this.gZw.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.gZF = -1;
            this.gZw = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.gZN.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.gZN.set(x, y);
                if (this.gZE && this.gZz.getVisibility() != 8 && this.gZw != null) {
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
                this.gZN.set(x, y);
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
                    if (this.gZw != null) {
                        offsetRectIntoDescendantCoords(this.gZw, this.rect);
                        int pointToPosition = this.gZw.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.gZw);
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
        if (this.gZE) {
            this.mWindowManager.removeView(this.gZz);
            this.gZE = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dFw);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gZI != null) {
            int size = this.gZI.size();
            if (i >= 0 && i < size) {
                this.gZG = this.gZI.get(i);
                if (this.ehS != null && this.gZG != null) {
                    if (this.YJ != i) {
                        this.YJ = i;
                        this.ehS.setVisibility(this.gZG.bQK() > 1 ? 0 : 4);
                        this.ehS.setCount(this.gZG.bQK());
                        if (this.gZG != null && this.gZG.bQO() != this.gZK) {
                            this.gZK = this.gZG.bQO();
                            if (this.gZL != null) {
                                this.gZL.te(this.gZG.bQO());
                            }
                        }
                    }
                    float bQL = this.gZG.bQL() + f;
                    this.ehS.setPosition(bQL);
                    this.gZx.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bQL) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.gZG.bQK())));
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
        this.ahx = i;
        an.setBackgroundResource(this.gZz, R.drawable.bg_expression_bubble, i);
        an.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.ehS.setSelector(an.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.ehS.setDrawable(an.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b gZQ;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gZQ = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gZQ = bVar;
        }

        public int bQD() {
            if (this.gZQ == null) {
                return 0;
            }
            return this.gZQ.bQN();
        }

        public com.baidu.tieba.emotion.editortool.b bQE() {
            return this.gZQ;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gZQ == null) {
                return 0;
            }
            return this.gZQ.bQM();
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
                if (this.gZQ.bQJ() != 0) {
                    i2 = measuredWidth / this.gZQ.bQJ();
                }
                if (this.gZQ.getRow() != 0) {
                    i3 = measuredHeight / this.gZQ.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.gZD * 2, EmotionTabContentView.this.gZD * 2, EmotionTabContentView.this.gZD * 2, EmotionTabContentView.this.gZD * 2);
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
            if (this.gZQ != null) {
                int bQN = this.gZQ.bQN() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                an.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.ahx);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String nE = this.gZQ.bQH().nE(bQN);
                tbImageView.setTag(nE);
                if (!TextUtils.isEmpty(nE)) {
                    Object a = com.baidu.adp.lib.e.c.ln().a(nE, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, nE, false, null);
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
                if (this.gZQ.bQI() == EmotionGroupType.BIG_EMOTION) {
                    String nE2 = this.gZQ.bQH().nE(bQN);
                    if (!TextUtils.isEmpty(nE2) && !nE2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.ahx == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = an.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(nE2.substring(nE2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, nE2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (nE != null && nE.length() > 3) {
                    linearLayout3.setContentDescription(nE.substring(2, nE.length() - 1));
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
            if (EmotionTabContentView.this.gZI == null) {
                return 0;
            }
            return EmotionTabContentView.this.gZI.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.gZO.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.gZO.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.gZI != null && i < EmotionTabContentView.this.gZI.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gZI.get(i);
                gridView2.setNumColumns(bVar.bQJ());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bQE() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bQE = aVar.bQE();
                        if (bQE.bQI() == EmotionGroupType.BIG_EMOTION || bQE.bQI() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.ZX != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bQE() != null) {
                                com.baidu.tieba.emotion.editortool.b bQE = aVar.bQE();
                                int bQD = aVar.bQD();
                                com.baidu.tbadk.editortools.emotiontool.c bQH = bQE.bQH();
                                String nE = bQE.bQH().nE(bQD + i2);
                                if (bQH.bfq() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(nE)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(nE);
                                qVar.a(bQH.bfq());
                                qVar.xz(bQH.getGroupName());
                                qVar.setPid(bQH.getGroupId());
                                qVar.setWidth(bQH.getWidth());
                                qVar.setHeight(bQH.getHeight());
                                EmotionTabContentView.this.ZX.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.gZI != null) {
                int size = EmotionTabContentView.this.gZI.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.YJ) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gZI.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.YJ = i;
                        EmotionTabContentView.this.ehS.setVisibility(bVar.bQK() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ehS.setCount(bVar.bQK());
                        EmotionTabContentView.this.ehS.setPosition(bVar.bQL());
                        EmotionTabContentView.this.ehS.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bQL() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bQK())));
                    }
                    if (bVar != null && bVar.bQO() != EmotionTabContentView.this.gZK) {
                        EmotionTabContentView.this.gZK = bVar.bQO();
                        if (EmotionTabContentView.this.gZL != null) {
                            EmotionTabContentView.this.gZL.te(bVar.bQO());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.gZL = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dFw);
    }
}
