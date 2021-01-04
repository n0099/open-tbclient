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
/* loaded from: classes8.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager Zk;
    private int abC;
    private EditorTools acZ;
    private int akW;
    private CustomMessageListener eMe;
    private IndicatorView frg;
    private int iEA;
    private int iEB;
    private int iEC;
    private boolean iED;
    private int iEE;
    private com.baidu.tieba.emotion.editortool.b iEF;
    private List<com.baidu.tbadk.editortools.emotiontool.c> iEG;
    private List<com.baidu.tieba.emotion.editortool.b> iEH;
    private int iEI;
    private int iEJ;
    private b iEK;
    private int iEL;
    private com.baidu.adp.lib.d.b<GridView> iEM;
    private EmotionViewPagerAdapter iEu;
    private GridView iEv;
    private LinearLayout iEw;
    private WindowManager.LayoutParams iEx;
    private GifView iEy;
    private ViewGroup iEz;
    private Context mContext;
    private final Point mStartPoint;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes8.dex */
    public interface b {
        void yM(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.iEE = -1;
        this.iEI = 0;
        this.iEJ = -1;
        this.abC = -1;
        this.mStartPoint = new Point();
        this.eMe = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cS(new ArrayList(EmotionTabContentView.this.iEG));
                        if (EmotionTabContentView.this.iEu != null) {
                            EmotionTabContentView.this.iEu.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iEJ < 0 || EmotionTabContentView.this.iEJ >= EmotionTabContentView.this.iEG.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iEG.get(EmotionTabContentView.this.iEJ)).bFc() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iEu != null) {
                                if (EmotionTabContentView.this.abC >= 0 && EmotionTabContentView.this.abC < EmotionTabContentView.this.iEH.size()) {
                                    EmotionTabContentView.this.iEF = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iEH.get(EmotionTabContentView.this.abC);
                                    int cxn = EmotionTabContentView.this.iEF.cxn();
                                    EmotionTabContentView.this.frg.setCount(cxn);
                                    EmotionTabContentView.this.frg.setVisibility(cxn > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.Zk == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.Zk.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.Zk.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.cxh().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iEH.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iEH.get(index));
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
        this.iEE = -1;
        this.iEI = 0;
        this.iEJ = -1;
        this.abC = -1;
        this.mStartPoint = new Point();
        this.eMe = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.cS(new ArrayList(EmotionTabContentView.this.iEG));
                        if (EmotionTabContentView.this.iEu != null) {
                            EmotionTabContentView.this.iEu.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.iEJ < 0 || EmotionTabContentView.this.iEJ >= EmotionTabContentView.this.iEG.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.iEG.get(EmotionTabContentView.this.iEJ)).bFc() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.iEu != null) {
                                if (EmotionTabContentView.this.abC >= 0 && EmotionTabContentView.this.abC < EmotionTabContentView.this.iEH.size()) {
                                    EmotionTabContentView.this.iEF = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iEH.get(EmotionTabContentView.this.abC);
                                    int cxn = EmotionTabContentView.this.iEF.cxn();
                                    EmotionTabContentView.this.frg.setCount(cxn);
                                    EmotionTabContentView.this.frg.setVisibility(cxn > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.Zk == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.Zk.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.Zk.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.cxh().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.iEH.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iEH.get(index));
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
        this.iEG = new ArrayList();
        this.iEH = new ArrayList();
        this.iEM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cxf */
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
        this.Zk = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.Zk.setFadingEdgeLength(0);
        this.Zk.setOnPageChangeListener(this);
        this.iEy = new GifView(context);
        ao.setBackgroundResource(this.iEy, R.drawable.bg_expression_bubble, this.akW);
        this.iEy.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.iEx = new WindowManager.LayoutParams();
        this.iEA = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iEB = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.iEC = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.iEx.width = this.iEA;
        this.iEx.height = this.iEB;
        this.iEx.gravity = 51;
        this.iEx.format = -3;
        this.iEx.type = 1000;
        this.iEx.flags |= 56;
        this.iEz = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.frg = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.iEw = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.iEw.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.iEx.type = 1000;
            this.iEx.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.iEG.clear();
        this.iEH.clear();
        if (list != null && !list.isEmpty()) {
            this.iEG.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int bFf = cVar.bFf();
                    int bFg = cVar.bFg();
                    int i4 = emotionsCount / (bFf * bFg);
                    if (emotionsCount % (bFf * bFg) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = bFf * bFg;
                        } else {
                            i = emotionsCount - ((bFf * bFg) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.yS(i3);
                        bVar.b(cVar.bFc());
                        bVar.sI(bFg);
                        bVar.setColumn(bFf);
                        bVar.yN(i4);
                        bVar.yO(i5);
                        bVar.yP(i);
                        bVar.yQ(i5 * bFf * bFg);
                        bVar.yR((i + i2) - 1);
                        this.iEH.add(bVar);
                    }
                }
            }
            this.iEI = this.iEH.size();
            for (int i6 = 0; i6 < this.iEI; i6++) {
                if (this.iEH != null && this.iEH.get(i6) != null) {
                    this.iEH.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void yK(int i) {
        if (this.iEH != null) {
            int size = this.iEH.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.iEH.get(i2);
                    if (bVar != null && bVar.cxr() == i) {
                        this.iEL = bVar.getIndex();
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
                yK(i);
                this.iEu = new EmotionViewPagerAdapter();
                this.Zk.setAdapter(this.iEu);
                this.Zk.setCurrentItem(this.iEL, true);
                if (this.iEK != null) {
                    this.iEK.yM(i);
                    this.iEJ = i;
                }
            }
        }
    }

    public void yL(int i) {
        int i2;
        if (this.Zk != null) {
            int size = this.iEH.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.iEH.get(i3);
                        if (bVar == null || bVar.cxr() != i) {
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
                this.Zk.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.iEE != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cxh() != null) {
            com.baidu.tieba.emotion.editortool.b cxh = aVar.cxh();
            String sy = cxh.cxk().sy(aVar.cxg() + i);
            if (cxh.cxl() != EmotionGroupType.USER_COLLECT || !com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(sy)) {
                this.iEy.setTag(sy);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = sy;
                if (sy.startsWith("#(meme,")) {
                    this.iEy.setShowStaticDrawable(false);
                } else {
                    this.iEy.setShowStaticDrawable(true);
                }
                this.iEy.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.iEz.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.iEx.x = this.rect.left - ((this.iEx.width - linearLayout.getWidth()) / 2);
                this.iEx.y = (this.rect.top - this.iEx.height) + this.iEC;
                this.iEy.setVisibility(0);
                if (!this.iED) {
                    this.mWindowManager.addView(this.iEy, this.iEx);
                    this.iED = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.iEy, this.iEx);
                }
                gridView.setSelection(i);
                if (this.iEE != -1) {
                    ((LinearLayout) gridView.getChildAt(this.iEE - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.iEE = i;
                this.iEv = gridView;
            }
        }
    }

    private void cxe() {
        if (this.iED && this.iEy.getVisibility() != 8 && this.iEv != null) {
            this.iEv.setSelection(-1);
            this.iEy.setVisibility(8);
            if (this.iEE != -1) {
                ((LinearLayout) this.iEv.getChildAt(this.iEE - this.iEv.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.iEE = -1;
            this.iEv = null;
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
                cxe();
                break;
            case 2:
                this.mStartPoint.set(x, y);
                if (this.iED && this.iEy.getVisibility() != 8 && this.iEv != null) {
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
                cxe();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    cxe();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.iEv != null) {
                        offsetRectIntoDescendantCoords(this.iEv, this.rect);
                        int pointToPosition = this.iEv.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.iEv);
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
        if (this.iED) {
            this.mWindowManager.removeView(this.iEy);
            this.iED = false;
        }
        MessageManager.getInstance().unRegisterListener(this.eMe);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.iEH != null) {
            int size = this.iEH.size();
            if (i >= 0 && i < size) {
                this.iEF = this.iEH.get(i);
                if (this.frg != null && this.iEF != null) {
                    if (this.abC != i) {
                        this.abC = i;
                        this.frg.setVisibility(this.iEF.cxn() > 1 ? 0 : 4);
                        this.frg.setCount(this.iEF.cxn());
                        if (this.iEF != null && this.iEF.cxr() != this.iEJ) {
                            this.iEJ = this.iEF.cxr();
                            if (this.iEK != null) {
                                this.iEK.yM(this.iEF.cxr());
                            }
                        }
                    }
                    float cxo = this.iEF.cxo() + f;
                    this.frg.setPosition(cxo);
                    this.iEw.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cxo) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.iEF.cxn())));
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
        this.akW = i;
        ao.setBackgroundResource(this.iEy, R.drawable.bg_expression_bubble, i);
        ao.setBackgroundColor(this, R.color.CAM_X0206, i);
        this.frg.setSelector(ao.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.frg.setDrawable(ao.getDrawable(i, R.drawable.dot_pb_expression_n));
        if (this.Zk != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.Zk.getChildCount()) {
                    View childAt = this.Zk.getChildAt(i3);
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
        cxe();
    }

    /* loaded from: classes8.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b iEO;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iEO = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.iEO = bVar;
        }

        public int cxg() {
            if (this.iEO == null) {
                return 0;
            }
            return this.iEO.cxq();
        }

        public com.baidu.tieba.emotion.editortool.b cxh() {
            return this.iEO;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.iEO == null) {
                return 0;
            }
            return this.iEO.cxp();
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
                if (this.iEO.cxm() != 0) {
                    i2 = measuredWidth / this.iEO.cxm();
                }
                if (this.iEO.getRow() != 0) {
                    i3 = measuredHeight / this.iEO.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.iEC * 2, EmotionTabContentView.this.iEC * 2, EmotionTabContentView.this.iEC * 2, EmotionTabContentView.this.iEC * 2);
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
            if (this.iEO != null) {
                int cxq = this.iEO.cxq() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ao.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.akW);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String sy = this.iEO.cxk().sy(cxq);
                tbImageView.setTag(sy);
                if (!TextUtils.isEmpty(sy)) {
                    Object a2 = com.baidu.adp.lib.e.d.mx().a(sy, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, sy, false, null);
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
                if (this.iEO.cxl() == EmotionGroupType.BIG_EMOTION) {
                    String sy2 = this.iEO.cxk().sy(cxq);
                    if (!TextUtils.isEmpty(sy2) && !sy2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.akW == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = ao.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(sy2.substring(sy2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, sy2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (sy != null && sy.length() > 3) {
                    linearLayout3.setContentDescription(sy.substring(2, sy.length() - 1));
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
            if (EmotionTabContentView.this.iEH == null) {
                return 0;
            }
            return EmotionTabContentView.this.iEH.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.iEM.returnObject(gridView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.iEM.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.iEH != null && i < EmotionTabContentView.this.iEH.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iEH.get(i);
                gridView2.setNumColumns(bVar.cxm());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cxh() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cxh = aVar.cxh();
                        if (cxh.cxl() == EmotionGroupType.BIG_EMOTION || cxh.cxl() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.acZ != null) {
                            u uVar = new u();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cxh() != null) {
                                com.baidu.tieba.emotion.editortool.b cxh = aVar.cxh();
                                int cxg = aVar.cxg();
                                com.baidu.tbadk.editortools.emotiontool.c cxk = cxh.cxk();
                                String sy = cxh.cxk().sy(cxg + i2);
                                if (cxk.bFc() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(sy)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                uVar.setName(sy);
                                uVar.a(cxk.bFc());
                                uVar.CP(cxk.getGroupName());
                                uVar.setPid(cxk.getGroupId());
                                uVar.setWidth(cxk.getWidth());
                                uVar.setHeight(cxk.getHeight());
                                EmotionTabContentView.this.acZ.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
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
            if (EmotionTabContentView.this.iEH != null) {
                int size = EmotionTabContentView.this.iEH.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.abC) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.iEH.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.abC = i;
                        EmotionTabContentView.this.frg.setVisibility(bVar.cxn() > 1 ? 0 : 4);
                        EmotionTabContentView.this.frg.setCount(bVar.cxn());
                        EmotionTabContentView.this.frg.setPosition(bVar.cxo());
                        EmotionTabContentView.this.frg.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cxo() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cxn())));
                    }
                    if (bVar != null && bVar.cxr() != EmotionTabContentView.this.iEJ) {
                        EmotionTabContentView.this.iEJ = bVar.cxr();
                        if (EmotionTabContentView.this.iEK != null) {
                            EmotionTabContentView.this.iEK.yM(bVar.cxr());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.iEK = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eMe);
    }
}
