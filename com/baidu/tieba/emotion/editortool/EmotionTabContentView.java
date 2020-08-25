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
import com.baidu.tbadk.coreExtra.data.t;
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
    private int Zf;
    private EditorTools aay;
    private int aiB;
    private CustomMessageListener dUB;
    private IndicatorView eyq;
    private EmotionViewPagerAdapter hrT;
    private GridView hrU;
    private LinearLayout hrV;
    private WindowManager.LayoutParams hrW;
    private GifView hrX;
    private ViewGroup hrY;
    private int hrZ;
    private int hsa;
    private int hsb;
    private boolean hsc;
    private int hsd;
    private com.baidu.tieba.emotion.editortool.b hse;
    private List<com.baidu.tbadk.editortools.emotiontool.c> hsf;
    private List<com.baidu.tieba.emotion.editortool.b> hsg;
    private int hsh;
    private int hsi;
    private b hsj;
    private int hsk;
    private final Point hsl;
    private com.baidu.adp.lib.d.b<GridView> hsm;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes13.dex */
    public interface b {
        void vL(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.hsd = -1;
        this.hsh = 0;
        this.hsi = -1;
        this.Zf = -1;
        this.hsl = new Point();
        this.dUB = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.ch(new ArrayList(EmotionTabContentView.this.hsf));
                        if (EmotionTabContentView.this.hrT != null) {
                            EmotionTabContentView.this.hrT.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hsi < 0 || EmotionTabContentView.this.hsi >= EmotionTabContentView.this.hsf.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hsf.get(EmotionTabContentView.this.hsi)).brM() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hrT != null) {
                                if (EmotionTabContentView.this.Zf >= 0 && EmotionTabContentView.this.Zf < EmotionTabContentView.this.hsg.size()) {
                                    EmotionTabContentView.this.hse = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsg.get(EmotionTabContentView.this.Zf);
                                    int cei = EmotionTabContentView.this.hse.cei();
                                    EmotionTabContentView.this.eyq.setCount(cei);
                                    EmotionTabContentView.this.eyq.setVisibility(cei > 1 ? 0 : 4);
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
                                                    int index = aVar.cec().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hsg.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsg.get(index));
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
        this.hsd = -1;
        this.hsh = 0;
        this.hsi = -1;
        this.Zf = -1;
        this.hsl = new Point();
        this.dUB = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.ch(new ArrayList(EmotionTabContentView.this.hsf));
                        if (EmotionTabContentView.this.hrT != null) {
                            EmotionTabContentView.this.hrT.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hsi < 0 || EmotionTabContentView.this.hsi >= EmotionTabContentView.this.hsf.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hsf.get(EmotionTabContentView.this.hsi)).brM() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hrT != null) {
                                if (EmotionTabContentView.this.Zf >= 0 && EmotionTabContentView.this.Zf < EmotionTabContentView.this.hsg.size()) {
                                    EmotionTabContentView.this.hse = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsg.get(EmotionTabContentView.this.Zf);
                                    int cei = EmotionTabContentView.this.hse.cei();
                                    EmotionTabContentView.this.eyq.setCount(cei);
                                    EmotionTabContentView.this.eyq.setVisibility(cei > 1 ? 0 : 4);
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
                                                    int index = aVar.cec().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hsg.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsg.get(index));
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
        this.hsf = new ArrayList();
        this.hsg = new ArrayList();
        this.hsm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cea */
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
        this.hrX = new GifView(context);
        ap.setBackgroundResource(this.hrX, R.drawable.bg_expression_bubble, this.aiB);
        this.hrX.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.hrW = new WindowManager.LayoutParams();
        this.hrZ = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.hsa = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.hsb = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.hrW.width = this.hrZ;
        this.hrW.height = this.hsa;
        this.hrW.gravity = 51;
        this.hrW.format = -3;
        this.hrW.type = 1000;
        this.hrW.flags |= 56;
        this.hrY = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eyq = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.hrV = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.hrV.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.hrW.type = 1000;
            this.hrW.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.hsf.clear();
        this.hsg.clear();
        if (list != null && !list.isEmpty()) {
            this.hsf.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int brP = cVar.brP();
                    int brQ = cVar.brQ();
                    int i4 = emotionsCount / (brP * brQ);
                    if (emotionsCount % (brP * brQ) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = brP * brQ;
                        } else {
                            i = emotionsCount - ((brP * brQ) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.vR(i3);
                        bVar.b(cVar.brM());
                        bVar.qn(brQ);
                        bVar.setColumn(brP);
                        bVar.vM(i4);
                        bVar.vN(i5);
                        bVar.vO(i);
                        bVar.vP(i5 * brP * brQ);
                        bVar.vQ((i + i2) - 1);
                        this.hsg.add(bVar);
                    }
                }
            }
            this.hsh = this.hsg.size();
            for (int i6 = 0; i6 < this.hsh; i6++) {
                if (this.hsg != null && this.hsg.get(i6) != null) {
                    this.hsg.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void vJ(int i) {
        if (this.hsg != null) {
            int size = this.hsg.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.hsg.get(i2);
                    if (bVar != null && bVar.cem() == i) {
                        this.hsk = bVar.getIndex();
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
                ch(list);
                vJ(i);
                this.hrT = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.hrT);
                this.mViewPager.setCurrentItem(this.hsk, true);
                if (this.hsj != null) {
                    this.hsj.vL(i);
                    this.hsi = i;
                }
            }
        }
    }

    public void vK(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.hsg.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.hsg.get(i3);
                        if (bVar == null || bVar.cem() != i) {
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
        if (this.hsd != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.cec() != null) {
            com.baidu.tieba.emotion.editortool.b cec = aVar.cec();
            String qh = cec.cef().qh(aVar.ceb() + i);
            if (cec.ceg() != EmotionGroupType.USER_COLLECT || !qh.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.hrX.setTag(qh);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qh;
                if (qh.startsWith("#(meme,")) {
                    this.hrX.setShowStaticDrawable(false);
                } else {
                    this.hrX.setShowStaticDrawable(true);
                }
                this.hrX.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.hrY.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.hrW.x = this.rect.left - ((this.hrW.width - linearLayout.getWidth()) / 2);
                this.hrW.y = (this.rect.top - this.hrW.height) + this.hsb;
                this.hrX.setVisibility(0);
                if (!this.hsc) {
                    this.mWindowManager.addView(this.hrX, this.hrW);
                    this.hsc = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.hrX, this.hrW);
                }
                gridView.setSelection(i);
                if (this.hsd != -1) {
                    ((LinearLayout) gridView.getChildAt(this.hsd - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.hsd = i;
                this.hrU = gridView;
            }
        }
    }

    private void onUp() {
        if (this.hsc && this.hrX.getVisibility() != 8 && this.hrU != null) {
            this.hrU.setSelection(-1);
            this.hrX.setVisibility(8);
            if (this.hsd != -1) {
                ((LinearLayout) this.hrU.getChildAt(this.hsd - this.hrU.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.hsd = -1;
            this.hrU = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.hsl.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.hsl.set(x, y);
                if (this.hsc && this.hrX.getVisibility() != 8 && this.hrU != null) {
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
                this.hsl.set(x, y);
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
                    if (this.hrU != null) {
                        offsetRectIntoDescendantCoords(this.hrU, this.rect);
                        int pointToPosition = this.hrU.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.hrU);
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
        if (this.hsc) {
            this.mWindowManager.removeView(this.hrX);
            this.hsc = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dUB);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hsg != null) {
            int size = this.hsg.size();
            if (i >= 0 && i < size) {
                this.hse = this.hsg.get(i);
                if (this.eyq != null && this.hse != null) {
                    if (this.Zf != i) {
                        this.Zf = i;
                        this.eyq.setVisibility(this.hse.cei() > 1 ? 0 : 4);
                        this.eyq.setCount(this.hse.cei());
                        if (this.hse != null && this.hse.cem() != this.hsi) {
                            this.hsi = this.hse.cem();
                            if (this.hsj != null) {
                                this.hsj.vL(this.hse.cem());
                            }
                        }
                    }
                    float cej = this.hse.cej() + f;
                    this.eyq.setPosition(cej);
                    this.hrV.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cej) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.hse.cei())));
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
        this.aiB = i;
        ap.setBackgroundResource(this.hrX, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.eyq.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eyq.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b hso;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hso = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hso = bVar;
        }

        public int ceb() {
            if (this.hso == null) {
                return 0;
            }
            return this.hso.cel();
        }

        public com.baidu.tieba.emotion.editortool.b cec() {
            return this.hso;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.hso == null) {
                return 0;
            }
            return this.hso.cek();
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
                if (this.hso.ceh() != 0) {
                    i2 = measuredWidth / this.hso.ceh();
                }
                if (this.hso.getRow() != 0) {
                    i3 = measuredHeight / this.hso.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.hsb * 2, EmotionTabContentView.this.hsb * 2, EmotionTabContentView.this.hsb * 2, EmotionTabContentView.this.hsb * 2);
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
            if (this.hso != null) {
                int cel = this.hso.cel() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aiB);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qh = this.hso.cef().qh(cel);
                tbImageView.setTag(qh);
                if (!TextUtils.isEmpty(qh)) {
                    Object a = com.baidu.adp.lib.e.c.mM().a(qh, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, qh, false, null);
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
                if (this.hso.ceg() == EmotionGroupType.BIG_EMOTION) {
                    String qh2 = this.hso.cef().qh(cel);
                    if (!TextUtils.isEmpty(qh2) && !qh2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aiB == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.cp_cont_c);
                        } else {
                            color = ap.getColor(R.color.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(qh2.substring(qh2.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, qh2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (qh != null && qh.length() > 3) {
                    linearLayout3.setContentDescription(qh.substring(2, qh.length() - 1));
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
            if (EmotionTabContentView.this.hsg == null) {
                return 0;
            }
            return EmotionTabContentView.this.hsg.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.hsm.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.hsm.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.hsg != null && i < EmotionTabContentView.this.hsg.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsg.get(i);
                gridView2.setNumColumns(bVar.ceh());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.cec() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b cec = aVar.cec();
                        if (cec.ceg() == EmotionGroupType.BIG_EMOTION || cec.ceg() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.aay != null) {
                            t tVar = new t();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.cec() != null) {
                                com.baidu.tieba.emotion.editortool.b cec = aVar.cec();
                                int ceb = aVar.ceb();
                                com.baidu.tbadk.editortools.emotiontool.c cef = cec.cef();
                                String qh = cec.cef().qh(ceb + i2);
                                if (cef.brM() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qh)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                tVar.setName(qh);
                                tVar.a(cef.brM());
                                tVar.AU(cef.getGroupName());
                                tVar.setPid(cef.getGroupId());
                                tVar.setWidth(cef.getWidth());
                                tVar.setHeight(cef.getHeight());
                                EmotionTabContentView.this.aay.b(new com.baidu.tbadk.editortools.a(24, -1, tVar));
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
            if (EmotionTabContentView.this.hsg != null) {
                int size = EmotionTabContentView.this.hsg.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Zf) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsg.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Zf = i;
                        EmotionTabContentView.this.eyq.setVisibility(bVar.cei() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eyq.setCount(bVar.cei());
                        EmotionTabContentView.this.eyq.setPosition(bVar.cej());
                        EmotionTabContentView.this.eyq.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cej() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cei())));
                    }
                    if (bVar != null && bVar.cem() != EmotionTabContentView.this.hsi) {
                        EmotionTabContentView.this.hsi = bVar.cem();
                        if (EmotionTabContentView.this.hsj != null) {
                            EmotionTabContentView.this.hsj.vL(bVar.cem());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.hsj = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dUB);
    }
}
