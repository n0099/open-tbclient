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
    private int XM;
    private EditorTools Za;
    private int afT;
    private IndicatorView dKN;
    private CustomMessageListener dkZ;
    private LinearLayout gxA;
    private WindowManager.LayoutParams gxB;
    private GifView gxC;
    private ViewGroup gxD;
    private int gxE;
    private int gxF;
    private int gxG;
    private boolean gxH;
    private int gxI;
    private com.baidu.tieba.emotion.editortool.b gxJ;
    private List<com.baidu.tbadk.editortools.emotiontool.c> gxK;
    private List<com.baidu.tieba.emotion.editortool.b> gxL;
    private int gxM;
    private int gxN;
    private b gxO;
    private int gxP;
    private final Point gxQ;
    private com.baidu.adp.lib.d.b<GridView> gxR;
    private EmotionViewPagerAdapter gxy;
    private GridView gxz;
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
        this.gxI = -1;
        this.gxM = 0;
        this.gxN = -1;
        this.XM = -1;
        this.gxQ = new Point();
        this.dkZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bS(new ArrayList(EmotionTabContentView.this.gxK));
                        if (EmotionTabContentView.this.gxy != null) {
                            EmotionTabContentView.this.gxy.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gxN < 0 || EmotionTabContentView.this.gxN >= EmotionTabContentView.this.gxK.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gxK.get(EmotionTabContentView.this.gxN)).aXe() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gxy != null) {
                                if (EmotionTabContentView.this.XM >= 0 && EmotionTabContentView.this.XM < EmotionTabContentView.this.gxL.size()) {
                                    EmotionTabContentView.this.gxJ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxL.get(EmotionTabContentView.this.XM);
                                    int bHl = EmotionTabContentView.this.gxJ.bHl();
                                    EmotionTabContentView.this.dKN.setCount(bHl);
                                    EmotionTabContentView.this.dKN.setVisibility(bHl > 1 ? 0 : 4);
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
                                                    int index = aVar.bHf().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gxL.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxL.get(index));
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
        this.gxI = -1;
        this.gxM = 0;
        this.gxN = -1;
        this.XM = -1;
        this.gxQ = new Point();
        this.dkZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.bS(new ArrayList(EmotionTabContentView.this.gxK));
                        if (EmotionTabContentView.this.gxy != null) {
                            EmotionTabContentView.this.gxy.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.gxN < 0 || EmotionTabContentView.this.gxN >= EmotionTabContentView.this.gxK.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.gxK.get(EmotionTabContentView.this.gxN)).aXe() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.gxy != null) {
                                if (EmotionTabContentView.this.XM >= 0 && EmotionTabContentView.this.XM < EmotionTabContentView.this.gxL.size()) {
                                    EmotionTabContentView.this.gxJ = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxL.get(EmotionTabContentView.this.XM);
                                    int bHl = EmotionTabContentView.this.gxJ.bHl();
                                    EmotionTabContentView.this.dKN.setCount(bHl);
                                    EmotionTabContentView.this.dKN.setVisibility(bHl > 1 ? 0 : 4);
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
                                                    int index = aVar.bHf().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.gxL.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxL.get(index));
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
        this.gxK = new ArrayList();
        this.gxL = new ArrayList();
        this.gxR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bHd */
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
        this.gxC = new GifView(context);
        am.setBackgroundResource(this.gxC, R.drawable.bg_expression_bubble, this.afT);
        this.gxC.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.gxB = new WindowManager.LayoutParams();
        this.gxE = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.gxF = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.gxG = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.gxB.width = this.gxE;
        this.gxB.height = this.gxF;
        this.gxB.gravity = 51;
        this.gxB.format = -3;
        this.gxB.type = 1000;
        this.gxB.flags |= 56;
        this.gxD = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.dKN = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.gxA = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.gxA.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.gxB.type = 1000;
            this.gxB.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.gxK.clear();
        this.gxL.clear();
        if (list != null && !list.isEmpty()) {
            this.gxK.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int aXh = cVar.aXh();
                    int aXi = cVar.aXi();
                    int i4 = emotionsCount / (aXh * aXi);
                    if (emotionsCount % (aXh * aXi) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = aXh * aXi;
                        } else {
                            i = emotionsCount - ((aXh * aXi) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.sc(i3);
                        bVar.b(cVar.aXe());
                        bVar.mM(aXi);
                        bVar.setColumn(aXh);
                        bVar.rX(i4);
                        bVar.rY(i5);
                        bVar.rZ(i);
                        bVar.sa(i5 * aXh * aXi);
                        bVar.sb((i + i2) - 1);
                        this.gxL.add(bVar);
                    }
                }
            }
            this.gxM = this.gxL.size();
            for (int i6 = 0; i6 < this.gxM; i6++) {
                if (this.gxL != null && this.gxL.get(i6) != null) {
                    this.gxL.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void rU(int i) {
        if (this.gxL != null) {
            int size = this.gxL.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.gxL.get(i2);
                    if (bVar != null && bVar.bHp() == i) {
                        this.gxP = bVar.getIndex();
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
                this.gxy = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.gxy);
                this.mViewPager.setCurrentItem(this.gxP, true);
                if (this.gxO != null) {
                    this.gxO.rW(i);
                    this.gxN = i;
                }
            }
        }
    }

    public void rV(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.gxL.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.gxL.get(i3);
                        if (bVar == null || bVar.bHp() != i) {
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
        if (this.gxI != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.bHf() != null) {
            com.baidu.tieba.emotion.editortool.b bHf = aVar.bHf();
            String mG = bHf.bHi().mG(aVar.bHe() + i);
            if (bHf.bHj() != EmotionGroupType.USER_COLLECT || !mG.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.gxC.setTag(mG);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = mG;
                if (mG.startsWith("#(meme,")) {
                    this.gxC.setShowStaticDrawable(false);
                } else {
                    this.gxC.setShowStaticDrawable(true);
                }
                this.gxC.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.gxD.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.gxB.x = this.rect.left - ((this.gxB.width - linearLayout.getWidth()) / 2);
                this.gxB.y = (this.rect.top - this.gxB.height) + this.gxG;
                this.gxC.setVisibility(0);
                if (!this.gxH) {
                    this.mWindowManager.addView(this.gxC, this.gxB);
                    this.gxH = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.gxC, this.gxB);
                }
                gridView.setSelection(i);
                if (this.gxI != -1) {
                    ((LinearLayout) gridView.getChildAt(this.gxI - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.gxI = i;
                this.gxz = gridView;
            }
        }
    }

    private void onUp() {
        if (this.gxH && this.gxC.getVisibility() != 8 && this.gxz != null) {
            this.gxz.setSelection(-1);
            this.gxC.setVisibility(8);
            if (this.gxI != -1) {
                ((LinearLayout) this.gxz.getChildAt(this.gxI - this.gxz.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.gxI = -1;
            this.gxz = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.gxQ.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.gxQ.set(x, y);
                if (this.gxH && this.gxC.getVisibility() != 8 && this.gxz != null) {
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
                this.gxQ.set(x, y);
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
                    if (this.gxz != null) {
                        offsetRectIntoDescendantCoords(this.gxz, this.rect);
                        int pointToPosition = this.gxz.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.gxz);
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
        if (this.gxH) {
            this.mWindowManager.removeView(this.gxC);
            this.gxH = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dkZ);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.gxL != null) {
            int size = this.gxL.size();
            if (i >= 0 && i < size) {
                this.gxJ = this.gxL.get(i);
                if (this.dKN != null && this.gxJ != null) {
                    if (this.XM != i) {
                        this.XM = i;
                        this.dKN.setVisibility(this.gxJ.bHl() > 1 ? 0 : 4);
                        this.dKN.setCount(this.gxJ.bHl());
                        if (this.gxJ != null && this.gxJ.bHp() != this.gxN) {
                            this.gxN = this.gxJ.bHp();
                            if (this.gxO != null) {
                                this.gxO.rW(this.gxJ.bHp());
                            }
                        }
                    }
                    float bHm = this.gxJ.bHm() + f;
                    this.dKN.setPosition(bHm);
                    this.gxA.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) bHm) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.gxJ.bHl())));
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
        this.afT = i;
        am.setBackgroundResource(this.gxC, R.drawable.bg_expression_bubble, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.dKN.setSelector(am.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
        this.dKN.setDrawable(am.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b gxT;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gxT = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.gxT = bVar;
        }

        public int bHe() {
            if (this.gxT == null) {
                return 0;
            }
            return this.gxT.bHo();
        }

        public com.baidu.tieba.emotion.editortool.b bHf() {
            return this.gxT;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gxT == null) {
                return 0;
            }
            return this.gxT.bHn();
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
                if (this.gxT.bHk() != 0) {
                    i2 = measuredWidth / this.gxT.bHk();
                }
                if (this.gxT.getRow() != 0) {
                    i3 = measuredHeight / this.gxT.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.gxG * 2, EmotionTabContentView.this.gxG * 2, EmotionTabContentView.this.gxG * 2, EmotionTabContentView.this.gxG * 2);
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
            if (this.gxT != null) {
                int bHo = this.gxT.bHo() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                am.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.afT);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String mG = this.gxT.bHi().mG(bHo);
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
                if (this.gxT.bHj() == EmotionGroupType.BIG_EMOTION) {
                    String mG2 = this.gxT.bHi().mG(bHo);
                    if (!TextUtils.isEmpty(mG2) && !mG2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.afT == 0) {
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
            if (EmotionTabContentView.this.gxL == null) {
                return 0;
            }
            return EmotionTabContentView.this.gxL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.gxR.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.gxR.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.gxL != null && i < EmotionTabContentView.this.gxL.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxL.get(i);
                gridView2.setNumColumns(bVar.bHk());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.bHf() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b bHf = aVar.bHf();
                        if (bHf.bHj() == EmotionGroupType.BIG_EMOTION || bHf.bHj() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.Za != null) {
                            q qVar = new q();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.bHf() != null) {
                                com.baidu.tieba.emotion.editortool.b bHf = aVar.bHf();
                                int bHe = aVar.bHe();
                                com.baidu.tbadk.editortools.emotiontool.c bHi = bHf.bHi();
                                String mG = bHf.bHi().mG(bHe + i2);
                                if (bHi.aXe() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(mG)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                qVar.setName(mG);
                                qVar.a(bHi.aXe());
                                qVar.vx(bHi.getGroupName());
                                qVar.setPid(bHi.getGroupId());
                                qVar.setWidth(bHi.getWidth());
                                qVar.setHeight(bHi.getHeight());
                                EmotionTabContentView.this.Za.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
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
            if (EmotionTabContentView.this.gxL != null) {
                int size = EmotionTabContentView.this.gxL.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.XM) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.gxL.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.XM = i;
                        EmotionTabContentView.this.dKN.setVisibility(bVar.bHl() > 1 ? 0 : 4);
                        EmotionTabContentView.this.dKN.setCount(bVar.bHl());
                        EmotionTabContentView.this.dKN.setPosition(bVar.bHm());
                        EmotionTabContentView.this.dKN.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.bHm() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.bHl())));
                    }
                    if (bVar != null && bVar.bHp() != EmotionTabContentView.this.gxN) {
                        EmotionTabContentView.this.gxN = bVar.bHp();
                        if (EmotionTabContentView.this.gxO != null) {
                            EmotionTabContentView.this.gxO.rW(bVar.bHp());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.gxO = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dkZ);
    }
}
