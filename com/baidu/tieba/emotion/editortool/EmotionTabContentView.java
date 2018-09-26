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
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private EditorTools SG;
    private int aCJ;
    private IndicatorView aCP;
    private CustomMessageListener aeT;
    private int axb;
    private EmotionViewPagerAdapter cWg;
    private GridView cWh;
    private LinearLayout cWi;
    private WindowManager.LayoutParams cWj;
    private GifView cWk;
    private ViewGroup cWl;
    private int cWm;
    private int cWn;
    private int cWo;
    private boolean cWp;
    private int cWq;
    private com.baidu.tieba.emotion.editortool.b cWr;
    private List<com.baidu.tbadk.editortools.emotiontool.c> cWs;
    private List<com.baidu.tieba.emotion.editortool.b> cWt;
    private int cWu;
    private int cWv;
    private b cWw;
    private int cWx;
    private final Point cWy;
    private com.baidu.adp.lib.e.b<GridView> cWz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface b {
        void jZ(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.cWq = -1;
        this.cWu = 0;
        this.cWv = -1;
        this.axb = -1;
        this.cWy = new Point();
        this.aeT = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aM(new ArrayList(EmotionTabContentView.this.cWs));
                        if (EmotionTabContentView.this.cWg != null) {
                            EmotionTabContentView.this.cWg.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cWv < 0 || EmotionTabContentView.this.cWv >= EmotionTabContentView.this.cWs.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cWs.get(EmotionTabContentView.this.cWv)).IY() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cWg != null) {
                                if (EmotionTabContentView.this.axb >= 0 && EmotionTabContentView.this.axb < EmotionTabContentView.this.cWt.size()) {
                                    EmotionTabContentView.this.cWr = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cWt.get(EmotionTabContentView.this.axb);
                                    int apU = EmotionTabContentView.this.cWr.apU();
                                    EmotionTabContentView.this.aCP.setCount(apU);
                                    EmotionTabContentView.this.aCP.setVisibility(apU > 1 ? 0 : 4);
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
                                                    int index = aVar.apO().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cWt.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cWt.get(index));
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
        this.cWq = -1;
        this.cWu = 0;
        this.cWv = -1;
        this.axb = -1;
        this.cWy = new Point();
        this.aeT = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aM(new ArrayList(EmotionTabContentView.this.cWs));
                        if (EmotionTabContentView.this.cWg != null) {
                            EmotionTabContentView.this.cWg.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.cWv < 0 || EmotionTabContentView.this.cWv >= EmotionTabContentView.this.cWs.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.cWs.get(EmotionTabContentView.this.cWv)).IY() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.cWg != null) {
                                if (EmotionTabContentView.this.axb >= 0 && EmotionTabContentView.this.axb < EmotionTabContentView.this.cWt.size()) {
                                    EmotionTabContentView.this.cWr = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cWt.get(EmotionTabContentView.this.axb);
                                    int apU = EmotionTabContentView.this.cWr.apU();
                                    EmotionTabContentView.this.aCP.setCount(apU);
                                    EmotionTabContentView.this.aCP.setVisibility(apU > 1 ? 0 : 4);
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
                                                    int index = aVar.apO().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.cWt.size()) {
                                                        aVar.a((com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cWt.get(index));
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
        this.cWs = new ArrayList();
        this.cWt = new ArrayList();
        this.cWz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: apM */
            public GridView jm() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public GridView s(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public GridView t(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(e.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(e.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.cWk = new GifView(context);
        al.d(this.cWk, e.f.bg_expression_bubble, this.aCJ);
        this.cWk.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cWj = new WindowManager.LayoutParams();
        this.cWm = context.getResources().getDimensionPixelSize(e.C0141e.ds240);
        this.cWn = context.getResources().getDimensionPixelSize(e.C0141e.ds252);
        this.cWo = context.getResources().getDimensionPixelSize(e.C0141e.ds10);
        this.cWj.width = this.cWm;
        this.cWj.height = this.cWn;
        this.cWj.gravity = 51;
        this.cWj.format = -3;
        this.cWj.type = 1000;
        this.cWj.flags |= 56;
        this.cWl = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aCP = (IndicatorView) findViewById(e.g.face_tab_indicator);
        this.cWi = (LinearLayout) findViewById(e.g.face_tab_indicator_layout);
        this.cWi.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.cWj.type = 1000;
            this.cWj.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.cWs.clear();
        this.cWt.clear();
        if (list != null && !list.isEmpty()) {
            this.cWs.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Jb = cVar.Jb();
                    int Jc = cVar.Jc();
                    int i4 = emotionsCount / (Jb * Jc);
                    if (emotionsCount % (Jb * Jc) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        com.baidu.tieba.emotion.editortool.b bVar = new com.baidu.tieba.emotion.editortool.b();
                        if (i5 < i4 - 1) {
                            i = Jb * Jc;
                        } else {
                            i = emotionsCount - ((Jb * Jc) * (i4 - 1));
                        }
                        bVar.e(cVar);
                        bVar.ke(i3);
                        bVar.b(cVar.IY());
                        bVar.fj(Jc);
                        bVar.fi(Jb);
                        bVar.ka(i4);
                        bVar.kb(i5);
                        bVar.kc(i);
                        bVar.kd(i5 * Jb * Jc);
                        bVar.setEndIndex((i + i2) - 1);
                        this.cWt.add(bVar);
                    }
                }
            }
            this.cWu = this.cWt.size();
            for (int i6 = 0; i6 < this.cWu; i6++) {
                if (this.cWt != null && this.cWt.get(i6) != null) {
                    this.cWt.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void jX(int i) {
        if (this.cWt != null) {
            int size = this.cWt.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.emotion.editortool.b bVar = this.cWt.get(i2);
                    if (bVar != null && bVar.apY() == i) {
                        this.cWx = bVar.getIndex();
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
                aM(list);
                jX(i);
                this.cWg = new EmotionViewPagerAdapter();
                this.mViewPager.setAdapter(this.cWg);
                this.mViewPager.setCurrentItem(this.cWx, true);
                if (this.cWw != null) {
                    this.cWw.jZ(i);
                    this.cWv = i;
                }
            }
        }
    }

    public void jY(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.cWt.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        com.baidu.tieba.emotion.editortool.b bVar = this.cWt.get(i3);
                        if (bVar == null || bVar.apY() != i) {
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
        if (this.cWq != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.apO() != null) {
            com.baidu.tieba.emotion.editortool.b apO = aVar.apO();
            String fc = apO.apR().fc(aVar.apN() + i);
            if (apO.apS() != EmotionGroupType.USER_COLLECT || !fc.equals(com.baidu.tbadk.imageManager.d.aTH)) {
                this.cWk.setTag(fc);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = fc;
                if (fc.startsWith("#(meme,")) {
                    this.cWk.setShowStaticDrawable(false);
                } else {
                    this.cWk.setShowStaticDrawable(true);
                }
                this.cWk.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.cWl.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.cWj.x = this.rect.left - ((this.cWj.width - linearLayout.getWidth()) / 2);
                this.cWj.y = (this.rect.top - this.cWj.height) + this.cWo;
                this.cWk.setVisibility(0);
                if (!this.cWp) {
                    this.mWindowManager.addView(this.cWk, this.cWj);
                    this.cWp = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.cWk, this.cWj);
                }
                gridView.setSelection(i);
                if (this.cWq != -1) {
                    ((LinearLayout) gridView.getChildAt(this.cWq - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.cWq = i;
                this.cWh = gridView;
            }
        }
    }

    private void apL() {
        if (this.cWp && this.cWk.getVisibility() != 8 && this.cWh != null) {
            this.cWh.setSelection(-1);
            this.cWk.setVisibility(8);
            if (this.cWq != -1) {
                ((LinearLayout) this.cWh.getChildAt(this.cWq - this.cWh.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.cWq = -1;
            this.cWh = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.cWy.set(x, y);
                break;
            case 1:
            case 3:
                apL();
                break;
            case 2:
                this.cWy.set(x, y);
                if (this.cWp && this.cWk.getVisibility() != 8 && this.cWh != null) {
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
                this.cWy.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                apL();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    apL();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.cWh != null) {
                        offsetRectIntoDescendantCoords(this.cWh, this.rect);
                        int pointToPosition = this.cWh.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.cWh);
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
        if (this.cWp) {
            this.mWindowManager.removeView(this.cWk);
            this.cWp = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aeT);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.cWt != null) {
            int size = this.cWt.size();
            if (i >= 0 && i < size) {
                this.cWr = this.cWt.get(i);
                if (this.aCP != null && this.cWr != null) {
                    if (this.axb != i) {
                        this.axb = i;
                        this.aCP.setVisibility(this.cWr.apU() > 1 ? 0 : 4);
                        this.aCP.setCount(this.cWr.apU());
                        if (this.cWr != null && this.cWr.apY() != this.cWv) {
                            this.cWv = this.cWr.apY();
                            if (this.cWw != null) {
                                this.cWw.jZ(this.cWr.apY());
                            }
                        }
                    }
                    float apV = this.cWr.apV() + f;
                    this.aCP.setPosition(apV);
                    this.cWi.setContentDescription(String.format(getResources().getString(e.j.emotion_selection), Integer.valueOf(((int) apV) + 1)) + String.format(getResources().getString(e.j.emotion_page), Integer.valueOf(this.cWr.apU())));
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
        this.aCJ = i;
        al.d(this.cWk, e.f.bg_expression_bubble, i);
        al.e(this, e.d.cp_bg_line_d, i);
        this.aCP.setSelector(al.x(i, e.f.dot_pb_expression_s));
        this.aCP.setDrawable(al.x(i, e.f.dot_pb_expression_n));
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
        apL();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private com.baidu.tieba.emotion.editortool.b cWB;

        public a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cWB = bVar;
        }

        public void a(com.baidu.tieba.emotion.editortool.b bVar) {
            this.cWB = bVar;
        }

        public int apN() {
            if (this.cWB == null) {
                return 0;
            }
            return this.cWB.apX();
        }

        public com.baidu.tieba.emotion.editortool.b apO() {
            return this.cWB;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cWB == null) {
                return 0;
            }
            return this.cWB.apW();
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
                if (this.cWB.apT() != 0) {
                    i2 = measuredWidth / this.cWB.apT();
                }
                if (this.cWB.getRow() != 0) {
                    i3 = measuredHeight / this.cWB.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.cWo * 2, EmotionTabContentView.this.cWo * 2, EmotionTabContentView.this.cWo * 2, EmotionTabContentView.this.cWo * 2);
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
            if (this.cWB != null) {
                int apX = this.cWB.apX() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(e.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                al.d(tbImageView, e.f.btn_choose_face_selector, EmotionTabContentView.this.aCJ);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String fc = this.cWB.apR().fc(apX);
                tbImageView.setTag(fc);
                if (!TextUtils.isEmpty(fc)) {
                    Object a = com.baidu.adp.lib.f.c.jn().a(fc, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
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
                    }, 0, 0, null, null, fc, false, null);
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
                if (this.cWB.apS() == EmotionGroupType.BIG_EMOTION) {
                    String fc2 = this.cWB.apR().fc(apX);
                    if (!TextUtils.isEmpty(fc2) && !fc2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.aCJ == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(e.d.cp_cont_c);
                        } else {
                            color = al.getColor(e.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(fc2.substring(fc2.lastIndexOf("_") + 1, fc2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (fc != null && fc.length() > 3) {
                    linearLayout3.setContentDescription(fc.substring(2, fc.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public EmotionViewPagerAdapter() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.cWt == null) {
                return 0;
            }
            return EmotionTabContentView.this.cWt.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.cWz.q(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.cWz.jl();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.cWt != null && i < EmotionTabContentView.this.cWt.size()) {
                com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cWt.get(i);
                gridView2.setNumColumns(bVar.apT());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(e.d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.EmotionViewPagerAdapter.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.apO() == null) {
                            return false;
                        }
                        com.baidu.tieba.emotion.editortool.b apO = aVar.apO();
                        if (apO.apS() == EmotionGroupType.BIG_EMOTION || apO.apS() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.SG != null) {
                            o oVar = new o();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.apO() != null) {
                                com.baidu.tieba.emotion.editortool.b apO = aVar.apO();
                                int apN = aVar.apN();
                                com.baidu.tbadk.editortools.emotiontool.c apR = apO.apR();
                                String fc = apO.apR().fc(apN + i2);
                                if (apR.IY() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.aTH.equals(fc)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                oVar.setName(fc);
                                oVar.a(apR.IY());
                                oVar.fV(apR.getGroupName());
                                oVar.setPid(apR.getGroupId());
                                oVar.setWidth(apR.getWidth());
                                oVar.setHeight(apR.getHeight());
                                EmotionTabContentView.this.SG.b(new com.baidu.tbadk.editortools.a(24, -1, oVar));
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
            if (EmotionTabContentView.this.cWt != null) {
                int size = EmotionTabContentView.this.cWt.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.axb) {
                    com.baidu.tieba.emotion.editortool.b bVar = (com.baidu.tieba.emotion.editortool.b) EmotionTabContentView.this.cWt.get(i);
                    if (bVar != null) {
                        EmotionTabContentView.this.axb = i;
                        EmotionTabContentView.this.aCP.setVisibility(bVar.apU() > 1 ? 0 : 4);
                        EmotionTabContentView.this.aCP.setCount(bVar.apU());
                        EmotionTabContentView.this.aCP.setPosition(bVar.apV());
                        EmotionTabContentView.this.aCP.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_selection), Integer.valueOf(bVar.apV() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(e.j.emotion_page), Integer.valueOf(bVar.apU())));
                    }
                    if (bVar != null && bVar.apY() != EmotionTabContentView.this.cWv) {
                        EmotionTabContentView.this.cWv = bVar.apY();
                        if (EmotionTabContentView.this.cWw != null) {
                            EmotionTabContentView.this.cWw.jZ(bVar.apY());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(b bVar) {
        this.cWw = bVar;
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aeT);
    }
}
