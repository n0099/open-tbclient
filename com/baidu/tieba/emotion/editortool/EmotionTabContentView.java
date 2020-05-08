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
    private int XP;
    private EditorTools Zd;
    private int afW;
    private IndicatorView dKR;
    private CustomMessageListener dld;
    private EmotionViewPagerAdapter gxE;
    private GridView gxF;
    private LinearLayout gxG;
    private WindowManager.LayoutParams gxH;
    private GifView gxI;
    private ViewGroup gxJ;
    private int gxK;
    private int gxL;
    private int gxM;
    private boolean gxN;
    private int gxO;
    private com.baidu.tieba.emotion.editortool.b gxP;
    private List<com.baidu.tbadk.editortools.emotiontool.c> gxQ;
    private List<com.baidu.tieba.emotion.editortool.b> gxR;
    private int gxS;
    private int gxT;
    private b gxU;
    private int gxV;
    private final Point gxW;
    private com.baidu.adp.lib.d.b<GridView> gxX;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes6.dex */
    public interface b {
        void rW(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.gxO = -1;
        this.gxS = 0;
        this.gxT = -1;
        this.XP = -1;
        this.gxW = new Point();
        this.dld = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bS(new ArrayList(EmotionTabContentView.this.gxQ));
                        if (EmotionTabContentView.this.gxE != null) {
                            EmotionTabContentView.this.gxE.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gxT < 0 || EmotionTabContentView.this.gxT >= EmotionTabContentView.this.gxQ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gxQ.get(EmotionTabContentView.this.gxT)).aXc() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gxE != null) {
                                if (EmotionTabContentView.this.XP >= 0 && EmotionTabContentView.this.XP < EmotionTabContentView.this.gxR.size()) {
                                    EmotionTabContentView.this.gxP = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxR.get(EmotionTabContentView.this.XP);
                                    int bHj = EmotionTabContentView.this.gxP.bHj();
                                    EmotionTabContentView.this.dKR.setCount(bHj);
                                    EmotionTabContentView.this.dKR.setVisibility(bHj > 1 ? 0 : 4);
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
                                                    int index = aVar.bHd().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gxR.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxR.get(index));
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
        this.gxO = -1;
        this.gxS = 0;
        this.gxT = -1;
        this.XP = -1;
        this.gxW = new Point();
        this.dld = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bS(new ArrayList(EmotionTabContentView.this.gxQ));
                        if (EmotionTabContentView.this.gxE != null) {
                            EmotionTabContentView.this.gxE.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gxT < 0 || EmotionTabContentView.this.gxT >= EmotionTabContentView.this.gxQ.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gxQ.get(EmotionTabContentView.this.gxT)).aXc() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gxE != null) {
                                if (EmotionTabContentView.this.XP >= 0 && EmotionTabContentView.this.XP < EmotionTabContentView.this.gxR.size()) {
                                    EmotionTabContentView.this.gxP = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxR.get(EmotionTabContentView.this.XP);
                                    int bHj = EmotionTabContentView.this.gxP.bHj();
                                    EmotionTabContentView.this.dKR.setCount(bHj);
                                    EmotionTabContentView.this.dKR.setVisibility(bHj > 1 ? 0 : 4);
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
                                                    int index = aVar.bHd().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gxR.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxR.get(index));
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
        this.gxQ = new ArrayList();
        this.gxR = new ArrayList();
        this.gxX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bHb */
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
        this.gxI = new GifView(context);
        am.setBackgroundResource(this.gxI, R.drawable.bg_expression_bubble, this.afW);
        this.gxI.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.gxH = new WindowManager.LayoutParams();
        this.gxK = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.gxL = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.gxM = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.gxH.width = this.gxK;
        this.gxH.height = this.gxL;
        this.gxH.gravity = 51;
        this.gxH.format = -3;
        this.gxH.type = 1000;
        this.gxH.flags |= 56;
        this.gxJ = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dKR = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.gxG = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.gxG.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.gxH.type = 1000;
            this.gxH.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.gxQ.clear();
        this.gxR.clear();
        if (list != null && !list.isEmpty()) {
            this.gxQ.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aXf = cVar.aXf();
                    int aXg = cVar.aXg();
                    int i4 = emotionsCount / (aXf * aXg);
                    if (emotionsCount % (aXf * aXg) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aXf * aXg;
                        } else {
                            i = emotionsCount - ((aXf * aXg) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.sc(i3);
                        bVar.b(cVar.aXc());
                        bVar.mM(aXg);
                        bVar.setColumn(aXf);
                        bVar.rX(i4);
                        bVar.rY(i5);
                        bVar.rZ(i);
                        bVar.sa(i5 * aXf * aXg);
                        bVar.sb((i + i2) - 1);
                        this.gxR.add(bVar);
                    }
                }
            }
            this.gxS = this.gxR.size();
            for (int i6 = 0; i6 < this.gxS; i6++) {
                if (this.gxR != null && this.gxR.get(i6) != null) {
                    this.gxR.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rU(int i) {
        if (this.gxR != null) {
            int size = this.gxR.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.gxR.get(i2);
                    if (bVar != null && bVar.bHn() == i) {
                        this.gxV = bVar.getIndex();
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
                bS(list);
                rU(i);
                this.gxE = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.gxE);
                this.mViewPager.setCurrentItem(this.gxV, true);
                if (this.gxU != null) {
                    this.gxU.rW(i);
                    this.gxT = i;
                }
            }
        }
    }

    public void rV(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.gxR.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.gxR.get(i3);
                        if (bVar == null || bVar.bHn() != i) {
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
        if (this.gxO != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bHd() != null) {
            com.baidu.tieba.emotion.editortool.b bHd = aVar.bHd();
            String mG = bHd.bHg().mG(aVar.bHc() + i);
            if (bHd.bHh() != EmotionGroupType.USER_COLLECT || !mG.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.gxI.setTag(mG);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = mG;
                if (mG.startsWith("#(meme,")) {
                    this.gxI.setShowStaticDrawable(false);
                } else {
                    this.gxI.setShowStaticDrawable(true);
                }
                this.gxI.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.gxJ.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.gxH.x = this.rect.left - ((this.gxH.width - linearLayout.getWidth()) / 2);
                this.gxH.y = (this.rect.top - this.gxH.height) + this.gxM;
                this.gxI.setVisibility(0);
                if (!this.gxN) {
                    this.mWindowManager.addView(this.gxI, this.gxH);
                    this.gxN = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.gxI, this.gxH);
                }
                gridView.setSelection(i);
                if (this.gxO != -1) {
                    ((LinearLayout) gridView.getChildAt(this.gxO - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.gxO = i;
                this.gxF = gridView;
            }
        }
    }

    private void onUp() {
        if (this.gxN && this.gxI.getVisibility() != 8 && this.gxF != null) {
            this.gxF.setSelection(-1);
            this.gxI.setVisibility(8);
            if (this.gxO != -1) {
                ((LinearLayout) this.gxF.getChildAt(this.gxO - this.gxF.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.gxO = -1;
            this.gxF = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.gxW.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.gxW.set(x, y);
                if (this.gxN && this.gxI.getVisibility() != 8 && this.gxF != null) {
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
                this.gxW.set(x, y);
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
                    if (this.gxF != null) {
                        offsetRectIntoDescendantCoords(this.gxF, this.rect);
                        int pointToPosition = this.gxF.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.gxF);
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
        if (this.gxN) {
            this.mWindowManager.removeView(this.gxI);
            this.gxN = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dld);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gxR != null) {
            int size = this.gxR.size();
            if (i >= 0 && i < size) {
                this.gxP = this.gxR.get(i);
                if (this.dKR != null && this.gxP != null) {
                    if (this.XP != i) {
                        this.XP = i;
                        this.dKR.setVisibility(this.gxP.bHj() > 1 ? 0 : 4);
                        this.dKR.setCount(this.gxP.bHj());
                        if (this.gxP != null && this.gxP.bHn() != this.gxT) {
                            this.gxT = this.gxP.bHn();
                            if (this.gxU != null) {
                                this.gxU.rW(this.gxP.bHn());
                            }
                        }
                    }
                    float bHk = this.gxP.bHk() + f;
                    this.dKR.setPosition(bHk);
                    this.gxG.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bHk) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.gxP.bHj())));
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
        this.afW = i;
        am.setBackgroundResource(this.gxI, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dKR.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dKR.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b gxZ;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gxZ = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gxZ = bVar;
        }

        public int bHc() {
            if (this.gxZ == null) {
                return 0;
            }
            return this.gxZ.bHm();
        }

        public com.baidu.tieba.emotion.editortool.b bHd() {
            return this.gxZ;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gxZ == null) {
                return 0;
            }
            return this.gxZ.bHl();
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
                if (this.gxZ.bHi() != 0) {
                    i2 = measuredWidth / this.gxZ.bHi();
                }
                if (this.gxZ.getRow() != 0) {
                    i3 = measuredHeight / this.gxZ.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.gxM * 2, EmotionTabContentView.this.gxM * 2, EmotionTabContentView.this.gxM * 2, EmotionTabContentView.this.gxM * 2);
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
            if (this.gxZ != null) {
                int bHm = this.gxZ.bHm() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.afW);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String mG = this.gxZ.bHg().mG(bHm);
                tbImageView.setTag(mG);
                if (!TextUtils.isEmpty(mG)) {
                    Object a = com.baidu.adp.lib.e.c.kV().a(mG, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, mG, false, null);
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
                if (this.gxZ.bHh() == EmotionGroupType.BIG_EMOTION) {
                    String mG2 = this.gxZ.bHg().mG(bHm);
                    if (!TextUtils.isEmpty(mG2) && !mG2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.afW == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = am.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(mG2.substring(mG2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, mG2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (mG != null && mG.length() > 3) {
                    linearLayout3.setContentDescription(mG.substring(2, mG.length() - 1));
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
            if (EmotionTabContentView.this.gxR == null) {
                return 0;
            }
            return EmotionTabContentView.this.gxR.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.gxX.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.gxX.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.gxR != null && i < EmotionTabContentView.this.gxR.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxR.get(i);
                gridView2.setNumColumns(bVar.bHi());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bHd() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bHd = aVar.bHd();
                        if (bHd.bHh() == EmotionGroupType.BIG_EMOTION || bHd.bHh() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Zd != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bHd() != null) {
                                com.baidu.tieba.emotion.editortool.b bHd = aVar.bHd();
                                int bHc = aVar.bHc();
                                com.baidu.tbadk.editortools.emotiontool.c bHg = bHd.bHg();
                                String mG = bHd.bHg().mG(bHc + i2);
                                if (bHg.aXc() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(mG)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(mG);
                                qVar.a(bHg.aXc());
                                qVar.vA(bHg.getGroupName());
                                qVar.setPid(bHg.getGroupId());
                                qVar.setWidth(bHg.getWidth());
                                qVar.setHeight(bHg.getHeight());
                                EmotionTabContentView.this.Zd.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.gxR != null) {
                int size = EmotionTabContentView.this.gxR.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.XP) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxR.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.XP = i;
                        EmotionTabContentView.this.dKR.setVisibility(bVar.bHj() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dKR.setCount(bVar.bHj());
                        EmotionTabContentView.this.dKR.setPosition(bVar.bHk());
                        EmotionTabContentView.this.dKR.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bHk() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bHj())));
                    }
                    if (bVar != null && bVar.bHn() != EmotionTabContentView.this.gxT) {
                        EmotionTabContentView.this.gxT = bVar.bHn();
                        if (EmotionTabContentView.this.gxU != null) {
                            EmotionTabContentView.this.gxU.rW(bVar.bHn());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.gxU = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dld);
    }
}
