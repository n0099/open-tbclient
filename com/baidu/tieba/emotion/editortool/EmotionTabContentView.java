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
    private int Zh;
    private EditorTools aaA;
    private int aiD;
    private CustomMessageListener dUF;
    private IndicatorView eyu;
    private EmotionViewPagerAdapter hrZ;
    private GridView hsa;
    private LinearLayout hsb;
    private WindowManager.LayoutParams hsc;
    private GifView hsd;
    private ViewGroup hse;
    private int hsf;
    private int hsg;
    private int hsh;
    private boolean hsi;
    private int hsj;
    private com.baidu.tieba.emotion.editortool.b hsk;
    private List<com.baidu.tbadk.editortools.emotiontool.c> hsl;
    private List<com.baidu.tieba.emotion.editortool.b> hsm;
    private int hsn;
    private int hso;
    private b hsp;
    private int hsq;
    private final Point hsr;
    private com.baidu.adp.lib.d.b<GridView> hss;
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
        this.hsj = -1;
        this.hsn = 0;
        this.hso = -1;
        this.Zh = -1;
        this.hsr = new Point();
        this.dUF = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.ch(new ArrayList(EmotionTabContentView.this.hsl));
                        if (EmotionTabContentView.this.hrZ != null) {
                            EmotionTabContentView.this.hrZ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hso < 0 || EmotionTabContentView.this.hso >= EmotionTabContentView.this.hsl.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hsl.get(EmotionTabContentView.this.hso)).brN() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hrZ != null) {
                                if (EmotionTabContentView.this.Zh >= 0 && EmotionTabContentView.this.Zh < EmotionTabContentView.this.hsm.size()) {
                                    EmotionTabContentView.this.hsk = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsm.get(EmotionTabContentView.this.Zh);
                                    int cej = EmotionTabContentView.this.hsk.cej();
                                    EmotionTabContentView.this.eyu.setCount(cej);
                                    EmotionTabContentView.this.eyu.setVisibility(cej > 1 ? 0 : 4);
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
                                                    int index = aVar.ced().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hsm.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsm.get(index));
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
        this.hsj = -1;
        this.hsn = 0;
        this.hso = -1;
        this.Zh = -1;
        this.hsr = new Point();
        this.dUF = new CustomMessageListener(CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                        EmotionTabContentView.this.ch(new ArrayList(EmotionTabContentView.this.hsl));
                        if (EmotionTabContentView.this.hrZ != null) {
                            EmotionTabContentView.this.hrZ.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.hso < 0 || EmotionTabContentView.this.hso >= EmotionTabContentView.this.hsl.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.hsl.get(EmotionTabContentView.this.hso)).brN() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.hrZ != null) {
                                if (EmotionTabContentView.this.Zh >= 0 && EmotionTabContentView.this.Zh < EmotionTabContentView.this.hsm.size()) {
                                    EmotionTabContentView.this.hsk = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsm.get(EmotionTabContentView.this.Zh);
                                    int cej = EmotionTabContentView.this.hsk.cej();
                                    EmotionTabContentView.this.eyu.setCount(cej);
                                    EmotionTabContentView.this.eyu.setVisibility(cej > 1 ? 0 : 4);
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
                                                    int index = aVar.ced().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.hsm.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsm.get(index));
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
        this.hsl = new ArrayList();
        this.hsm = new ArrayList();
        this.hss = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ceb */
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
        this.hsd = new GifView(context);
        ap.setBackgroundResource(this.hsd, R.drawable.bg_expression_bubble, this.aiD);
        this.hsd.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.hsc = new WindowManager.LayoutParams();
        this.hsf = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.hsg = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.hsh = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.hsc.width = this.hsf;
        this.hsc.height = this.hsg;
        this.hsc.gravity = 51;
        this.hsc.format = -3;
        this.hsc.type = 1000;
        this.hsc.flags |= 56;
        this.hse = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.eyu = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.hsb = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.hsb.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.hsc.type = 1000;
            this.hsc.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.hsl.clear();
        this.hsm.clear();
        if (list != null && !list.isEmpty()) {
            this.hsl.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int brQ = cVar.brQ();
                    int brR = cVar.brR();
                    int i4 = emotionsCount / (brQ * brR);
                    if (emotionsCount % (brQ * brR) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = brQ * brR;
                        } else {
                            i = emotionsCount - ((brQ * brR) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.vR(i3);
                        bVar.b(cVar.brN());
                        bVar.qn(brR);
                        bVar.setColumn(brQ);
                        bVar.vM(i4);
                        bVar.vN(i5);
                        bVar.vO(i);
                        bVar.vP(i5 * brQ * brR);
                        bVar.vQ((i + i2) - 1);
                        this.hsm.add(bVar);
                    }
                }
            }
            this.hsn = this.hsm.size();
            for (int i6 = 0; i6 < this.hsn; i6++) {
                if (this.hsm != null && this.hsm.get(i6) != null) {
                    this.hsm.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void vJ(int i) {
        if (this.hsm != null) {
            int size = this.hsm.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.hsm.get(i2);
                    if (bVar != null && bVar.cen() == i) {
                        this.hsq = bVar.getIndex();
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
                this.hrZ = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.hrZ);
                this.mViewPager.setCurrentItem(this.hsq, true);
                if (this.hsp != null) {
                    this.hsp.vL(i);
                    this.hso = i;
                }
            }
        }
    }

    public void vK(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.hsm.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.hsm.get(i3);
                        if (bVar == null || bVar.cen() != i) {
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
        if (this.hsj != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.ced() != null) {
            com.baidu.tieba.emotion.editortool.b ced = aVar.ced();
            String qh = ced.ceg().qh(aVar.cec() + i);
            if (ced.ceh() != EmotionGroupType.USER_COLLECT || !qh.equals(com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT)) {
                this.hsd.setTag(qh);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = qh;
                if (qh.startsWith("#(meme,")) {
                    this.hsd.setShowStaticDrawable(false);
                } else {
                    this.hsd.setShowStaticDrawable(true);
                }
                this.hsd.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.hse.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.hsc.x = this.rect.left - ((this.hsc.width - linearLayout.getWidth()) / 2);
                this.hsc.y = (this.rect.top - this.hsc.height) + this.hsh;
                this.hsd.setVisibility(0);
                if (!this.hsi) {
                    this.mWindowManager.addView(this.hsd, this.hsc);
                    this.hsi = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.hsd, this.hsc);
                }
                gridView.setSelection(i);
                if (this.hsj != -1) {
                    ((LinearLayout) gridView.getChildAt(this.hsj - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.hsj = i;
                this.hsa = gridView;
            }
        }
    }

    private void onUp() {
        if (this.hsi && this.hsd.getVisibility() != 8 && this.hsa != null) {
            this.hsa.setSelection(-1);
            this.hsd.setVisibility(8);
            if (this.hsj != -1) {
                ((LinearLayout) this.hsa.getChildAt(this.hsj - this.hsa.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.hsj = -1;
            this.hsa = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.hsr.set(x, y);
                break;
            case 1:
            case 3:
                onUp();
                break;
            case 2:
                this.hsr.set(x, y);
                if (this.hsi && this.hsd.getVisibility() != 8 && this.hsa != null) {
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
                this.hsr.set(x, y);
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
                    if (this.hsa != null) {
                        offsetRectIntoDescendantCoords(this.hsa, this.rect);
                        int pointToPosition = this.hsa.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.hsa);
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
        if (this.hsi) {
            this.mWindowManager.removeView(this.hsd);
            this.hsi = false;
        }
        MessageManager.getInstance().unRegisterListener(this.dUF);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.hsm != null) {
            int size = this.hsm.size();
            if (i >= 0 && i < size) {
                this.hsk = this.hsm.get(i);
                if (this.eyu != null && this.hsk != null) {
                    if (this.Zh != i) {
                        this.Zh = i;
                        this.eyu.setVisibility(this.hsk.cej() > 1 ? 0 : 4);
                        this.eyu.setCount(this.hsk.cej());
                        if (this.hsk != null && this.hsk.cen() != this.hso) {
                            this.hso = this.hsk.cen();
                            if (this.hsp != null) {
                                this.hsp.vL(this.hsk.cen());
                            }
                        }
                    }
                    float cek = this.hsk.cek() + f;
                    this.eyu.setPosition(cek);
                    this.hsb.setContentDescription(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(((int) cek) + 1)) + String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.hsk.cej())));
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
        this.aiD = i;
        ap.setBackgroundResource(this.hsd, R.drawable.bg_expression_bubble, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
        this.eyu.setSelector(ap.getDrawable(i, R.drawable.dot_pb_expression_s));
        this.eyu.setDrawable(ap.getDrawable(i, R.drawable.dot_pb_expression_n));
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
        private com.baidu.tieba.emotion.editortool.b hsu;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hsu = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.hsu = bVar;
        }

        public int cec() {
            if (this.hsu == null) {
                return 0;
            }
            return this.hsu.cem();
        }

        public com.baidu.tieba.emotion.editortool.b ced() {
            return this.hsu;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.hsu == null) {
                return 0;
            }
            return this.hsu.cel();
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
                if (this.hsu.cei() != 0) {
                    i2 = measuredWidth / this.hsu.cei();
                }
                if (this.hsu.getRow() != 0) {
                    i3 = measuredHeight / this.hsu.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.hsh * 2, EmotionTabContentView.this.hsh * 2, EmotionTabContentView.this.hsh * 2, EmotionTabContentView.this.hsh * 2);
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
            if (this.hsu != null) {
                int cem = this.hsu.cem() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                ap.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.aiD);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String qh = this.hsu.ceg().qh(cem);
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
                if (this.hsu.ceh() == EmotionGroupType.BIG_EMOTION) {
                    String qh2 = this.hsu.ceg().qh(cem);
                    if (!TextUtils.isEmpty(qh2) && !qh2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aiD == 0) {
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
            if (EmotionTabContentView.this.hsm == null) {
                return 0;
            }
            return EmotionTabContentView.this.hsm.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.hss.returnObject(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.hss.borrowObject();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.hsm != null && i < EmotionTabContentView.this.hsm.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsm.get(i);
                gridView2.setNumColumns(bVar.cei());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(R.color.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.ced() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b ced = aVar.ced();
                        if (ced.ceh() == EmotionGroupType.BIG_EMOTION || ced.ceh() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.aaA != null) {
                            t tVar = new t();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.ced() != null) {
                                com.baidu.tieba.emotion.editortool.b ced = aVar.ced();
                                int cec = aVar.cec();
                                com.baidu.tbadk.editortools.emotiontool.c ceg = ced.ceg();
                                String qh = ced.ceg().qh(cec + i2);
                                if (ceg.brN() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(qh)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                tVar.setName(qh);
                                tVar.a(ceg.brN());
                                tVar.AV(ceg.getGroupName());
                                tVar.setPid(ceg.getGroupId());
                                tVar.setWidth(ceg.getWidth());
                                tVar.setHeight(ceg.getHeight());
                                EmotionTabContentView.this.aaA.b(new com.baidu.tbadk.editortools.a(24, -1, tVar));
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
            if (EmotionTabContentView.this.hsm != null) {
                int size = EmotionTabContentView.this.hsm.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.Zh) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.hsm.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.Zh = i;
                        EmotionTabContentView.this.eyu.setVisibility(bVar.cej() > 1 ? 0 : 4);
                        EmotionTabContentView.this.eyu.setCount(bVar.cej());
                        EmotionTabContentView.this.eyu.setPosition(bVar.cek());
                        EmotionTabContentView.this.eyu.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.cek() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.cej())));
                    }
                    if (bVar != null && bVar.cen() != EmotionTabContentView.this.hso) {
                        EmotionTabContentView.this.hso = bVar.cen();
                        if (EmotionTabContentView.this.hsp != null) {
                            EmotionTabContentView.this.hsp.vL(bVar.cen());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.hsp = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dUF);
    }
}
