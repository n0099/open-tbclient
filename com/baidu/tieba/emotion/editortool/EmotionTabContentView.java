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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private CustomMessageListener aJs;
    private i axH;
    private int bfC;
    private IndicatorView buQ;
    private int currentPosition;
    private ViewGroup dnA;
    private int dnB;
    private int dnC;
    private int dnD;
    private boolean dnE;
    private int dnF;
    private d dnG;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dnH;
    private List<d> dnI;
    private int dnJ;
    private int dnK;
    private c dnL;
    private int dnM;
    private final Point dnN;
    private com.baidu.adp.lib.e.b<GridView> dnO;
    private b dnv;
    private GridView dnw;
    private LinearLayout dnx;
    private WindowManager.LayoutParams dny;
    private GifView dnz;
    private Context mContext;
    private WindowManager mWindowManager;
    private ViewPager qV;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void me(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.dnF = -1;
        this.dnJ = 0;
        this.dnK = -1;
        this.currentPosition = -1;
        this.dnN = new Point();
        this.aJs = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aK(new ArrayList(EmotionTabContentView.this.dnH));
                        if (EmotionTabContentView.this.dnv != null) {
                            EmotionTabContentView.this.dnv.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dnK < 0 || EmotionTabContentView.this.dnK >= EmotionTabContentView.this.dnH.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dnH.get(EmotionTabContentView.this.dnK)).Lr() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dnv != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dnI.size()) {
                                    EmotionTabContentView.this.dnG = (d) EmotionTabContentView.this.dnI.get(EmotionTabContentView.this.currentPosition);
                                    int apY = EmotionTabContentView.this.dnG.apY();
                                    EmotionTabContentView.this.buQ.setCount(apY);
                                    EmotionTabContentView.this.buQ.setVisibility(apY > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.qV == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.qV.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.qV.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.apS().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dnI.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dnI.get(index));
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
        this.dnF = -1;
        this.dnJ = 0;
        this.dnK = -1;
        this.currentPosition = -1;
        this.dnN = new Point();
        this.aJs = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aK(new ArrayList(EmotionTabContentView.this.dnH));
                        if (EmotionTabContentView.this.dnv != null) {
                            EmotionTabContentView.this.dnv.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dnK < 0 || EmotionTabContentView.this.dnK >= EmotionTabContentView.this.dnH.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dnH.get(EmotionTabContentView.this.dnK)).Lr() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dnv != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dnI.size()) {
                                    EmotionTabContentView.this.dnG = (d) EmotionTabContentView.this.dnI.get(EmotionTabContentView.this.currentPosition);
                                    int apY = EmotionTabContentView.this.dnG.apY();
                                    EmotionTabContentView.this.buQ.setCount(apY);
                                    EmotionTabContentView.this.buQ.setVisibility(apY > 1 ? 0 : 4);
                                }
                                if (EmotionTabContentView.this.qV == null) {
                                    return;
                                }
                                while (true) {
                                    try {
                                        int i2 = i;
                                        if (i2 < EmotionTabContentView.this.qV.getChildCount()) {
                                            View childAt = EmotionTabContentView.this.qV.getChildAt(i2);
                                            if (childAt != null && (childAt instanceof GridView)) {
                                                GridView gridView = (GridView) childAt;
                                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof a)) {
                                                    a aVar = (a) gridView.getAdapter();
                                                    int index = aVar.apS().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dnI.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dnI.get(index));
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
        this.dnH = new ArrayList();
        this.dnI = new ArrayList();
        this.dnO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: apQ */
            public GridView nl() {
                return new GridView(EmotionTabContentView.this.getContext());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public GridView at(GridView gridView) {
                return gridView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public GridView au(GridView gridView) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
        }, 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.emotion_tab_content, (ViewGroup) this, true);
        this.qV = (ViewPager) findViewById(d.g.face_tab_viewpager);
        this.qV.setFadingEdgeLength(0);
        this.qV.setOnPageChangeListener(this);
        this.dnz = new GifView(context);
        aj.f(this.dnz, d.f.bg_expression_bubble, this.bfC);
        this.dnz.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dny = new WindowManager.LayoutParams();
        this.dnB = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.dnC = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.dnD = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.dny.width = this.dnB;
        this.dny.height = this.dnC;
        this.dny.gravity = 51;
        this.dny.format = -3;
        this.dny.type = 1000;
        this.dny.flags |= 56;
        this.dnA = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.buQ = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.dnx = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.dnx.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dny.type = 1000;
            this.dny.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dnH.clear();
        this.dnI.clear();
        if (list != null && !list.isEmpty()) {
            this.dnH.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Lu = cVar.Lu();
                    int Lv = cVar.Lv();
                    int i4 = emotionsCount / (Lu * Lv);
                    if (emotionsCount % (Lu * Lv) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = Lu * Lv;
                        } else {
                            i = emotionsCount - ((Lu * Lv) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.mj(i3);
                        dVar.b(cVar.Lr());
                        dVar.hS(Lv);
                        dVar.hR(Lu);
                        dVar.mf(i4);
                        dVar.mg(i5);
                        dVar.mh(i);
                        dVar.mi(i5 * Lu * Lv);
                        dVar.setEndIndex((i + i2) - 1);
                        this.dnI.add(dVar);
                    }
                }
            }
            this.dnJ = this.dnI.size();
            for (int i6 = 0; i6 < this.dnJ; i6++) {
                if (this.dnI != null && this.dnI.get(i6) != null) {
                    this.dnI.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void mc(int i) {
        if (this.dnI != null) {
            int size = this.dnI.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.dnI.get(i2);
                    if (dVar != null && dVar.aqc() == i) {
                        this.dnM = dVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void l(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                aK(list);
                mc(i);
                this.dnv = new b();
                this.qV.setAdapter(this.dnv);
                this.qV.setCurrentItem(this.dnM, true);
                if (this.dnL != null) {
                    this.dnL.me(i);
                    this.dnK = i;
                }
            }
        }
    }

    public void md(int i) {
        int i2;
        if (this.qV != null) {
            int size = this.dnI.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.dnI.get(i3);
                        if (dVar == null || dVar.aqc() != i) {
                            i3++;
                        } else {
                            i2 = dVar.getIndex();
                            break;
                        }
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                this.qV.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.dnF != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.apS() != null) {
            d apS = aVar.apS();
            String hL = apS.apV().hL(aVar.apR() + i);
            if (apS.apW() != EmotionGroupType.USER_COLLECT || !hL.equals(com.baidu.tbadk.imageManager.d.bwB)) {
                this.dnz.setTag(hL);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = hL;
                if (hL.startsWith("#(meme,")) {
                    this.dnz.setShowStaticDrawable(false);
                } else {
                    this.dnz.setShowStaticDrawable(true);
                }
                this.dnz.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dnA.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dny.x = this.rect.left - ((this.dny.width - linearLayout.getWidth()) / 2);
                this.dny.y = (this.rect.top - this.dny.height) + this.dnD;
                this.dnz.setVisibility(0);
                if (!this.dnE) {
                    this.mWindowManager.addView(this.dnz, this.dny);
                    this.dnE = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dnz, this.dny);
                }
                gridView.setSelection(i);
                if (this.dnF != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dnF - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dnF = i;
                this.dnw = gridView;
            }
        }
    }

    private void apP() {
        if (this.dnE && this.dnz.getVisibility() != 8 && this.dnw != null) {
            this.dnw.setSelection(-1);
            this.dnz.setVisibility(8);
            if (this.dnF != -1) {
                ((LinearLayout) this.dnw.getChildAt(this.dnF - this.dnw.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dnF = -1;
            this.dnw = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dnN.set(x, y);
                break;
            case 1:
            case 3:
                apP();
                break;
            case 2:
                this.dnN.set(x, y);
                if (this.dnE && this.dnz.getVisibility() != 8 && this.dnw != null) {
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
                this.dnN.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                apP();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    apP();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.dnw != null) {
                        offsetRectIntoDescendantCoords(this.dnw, this.rect);
                        int pointToPosition = this.dnw.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dnw);
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
        if (this.dnE) {
            this.mWindowManager.removeView(this.dnz);
            this.dnE = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aJs);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dnI != null) {
            int size = this.dnI.size();
            if (i >= 0 && i < size) {
                this.dnG = this.dnI.get(i);
                if (this.buQ != null && this.dnG != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.buQ.setVisibility(this.dnG.apY() > 1 ? 0 : 4);
                        this.buQ.setCount(this.dnG.apY());
                        if (this.dnG != null && this.dnG.aqc() != this.dnK) {
                            this.dnK = this.dnG.aqc();
                            if (this.dnL != null) {
                                this.dnL.me(this.dnG.aqc());
                            }
                        }
                    }
                    float apZ = this.dnG.apZ() + f;
                    this.buQ.setPosition(apZ);
                    this.dnx.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) apZ) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.dnG.apY())));
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
        this.bfC = i;
        aj.f(this.dnz, d.f.bg_expression_bubble, i);
        aj.g(this, d.C0141d.cp_bg_line_d, i);
        this.buQ.setSelector(aj.au(i, d.f.dot_pb_expression_s));
        this.buQ.setDrawable(aj.au(i, d.f.dot_pb_expression_n));
        if (this.qV != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.qV.getChildCount()) {
                    View childAt = this.qV.getChildAt(i3);
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
        apP();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d dnQ;

        public a(d dVar) {
            this.dnQ = dVar;
        }

        public void a(d dVar) {
            this.dnQ = dVar;
        }

        public int apR() {
            if (this.dnQ == null) {
                return 0;
            }
            return this.dnQ.aqb();
        }

        public d apS() {
            return this.dnQ;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dnQ == null) {
                return 0;
            }
            return this.dnQ.aqa();
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
            com.baidu.adp.widget.a.a aVar;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(d.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.dnQ.apX() != 0) {
                    i2 = measuredWidth / this.dnQ.apX();
                }
                if (this.dnQ.getRow() != 0) {
                    i3 = measuredHeight / this.dnQ.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dnD * 2, EmotionTabContentView.this.dnD * 2, EmotionTabContentView.this.dnD * 2, EmotionTabContentView.this.dnD * 2);
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
            if (this.dnQ != null) {
                int aqb = this.dnQ.aqb() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.f(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bfC);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String hL = this.dnQ.apV().hL(aqb);
                tbImageView.setTag(hL);
                if (!TextUtils.isEmpty(hL)) {
                    Object a = com.baidu.adp.lib.f.c.nm().a(hL, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str, int i4) {
                            View findViewWithTag;
                            if (aVar2 != null && (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                                TbImageView tbImageView2 = (TbImageView) findViewWithTag;
                                aVar2.a(tbImageView2);
                                tbImageView2.setTag(null);
                            }
                        }
                    }, 0, 0, null, null, hL, false, null);
                    if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                        aVar = null;
                    } else {
                        aVar = (com.baidu.adp.widget.a.a) a;
                    }
                    if (aVar != null) {
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(d.g.emotion_tab_content_tip);
                if (this.dnQ.apW() == EmotionGroupType.BIG_EMOTION) {
                    String hL2 = this.dnQ.apV().hL(aqb);
                    if (!TextUtils.isEmpty(hL2) && !hL2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bfC == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(d.C0141d.cp_cont_c);
                        } else {
                            color = aj.getColor(d.C0141d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(hL2.substring(hL2.lastIndexOf("_") + 1, hL2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (hL != null && hL.length() > 3) {
                    linearLayout3.setContentDescription(hL.substring(2, hL.length() - 1));
                }
            }
            return linearLayout3;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.dnI == null) {
                return 0;
            }
            return EmotionTabContentView.this.dnI.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dnO.ar(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dnO.nk();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dnI != null && i < EmotionTabContentView.this.dnI.size()) {
                d dVar = (d) EmotionTabContentView.this.dnI.get(i);
                gridView2.setNumColumns(dVar.apX());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0141d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.apS() == null) {
                            return false;
                        }
                        d apS = aVar.apS();
                        if (apS.apW() == EmotionGroupType.BIG_EMOTION || apS.apW() == EmotionGroupType.USER_COLLECT) {
                            EmotionTabContentView.this.a(i2, (GridView) adapterView);
                            return true;
                        }
                        return false;
                    }
                });
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        adapterView.setSelection(-1);
                        if (EmotionTabContentView.this.axH != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.apS() != null) {
                                d apS = aVar.apS();
                                int apR = aVar.apR();
                                com.baidu.tbadk.editortools.emotiontool.c apV = apS.apV();
                                String hL = apS.apV().hL(apR + i2);
                                if (apV.Lr() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.bwB.equals(hL)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(hL);
                                nVar.a(apV.Lr());
                                nVar.fh(apV.getGroupName());
                                nVar.fi(apV.getGroupId());
                                nVar.setWidth(apV.getWidth());
                                nVar.setHeight(apV.getHeight());
                                EmotionTabContentView.this.axH.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
                            }
                        }
                    }
                });
                gridView2.setAdapter((ListAdapter) new a(dVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.dnI != null) {
                int size = EmotionTabContentView.this.dnI.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.dnI.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.buQ.setVisibility(dVar.apY() > 1 ? 0 : 4);
                        EmotionTabContentView.this.buQ.setCount(dVar.apY());
                        EmotionTabContentView.this.buQ.setPosition(dVar.apZ());
                        EmotionTabContentView.this.buQ.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.apZ() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.apY())));
                    }
                    if (dVar != null && dVar.aqc() != EmotionTabContentView.this.dnK) {
                        EmotionTabContentView.this.dnK = dVar.aqc();
                        if (EmotionTabContentView.this.dnL != null) {
                            EmotionTabContentView.this.dnL.me(dVar.aqc());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.dnL = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.axH = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aJs);
    }
}
