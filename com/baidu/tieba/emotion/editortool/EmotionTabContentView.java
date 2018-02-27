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
    private CustomMessageListener aJr;
    private i axG;
    private int bfz;
    private IndicatorView buN;
    private int currentPosition;
    private int dnA;
    private boolean dnB;
    private int dnC;
    private d dnD;
    private List<com.baidu.tbadk.editortools.emotiontool.c> dnE;
    private List<d> dnF;
    private int dnG;
    private int dnH;
    private c dnI;
    private int dnJ;
    private final Point dnK;
    private com.baidu.adp.lib.e.b<GridView> dnL;
    private b dns;
    private GridView dnt;
    private LinearLayout dnu;
    private WindowManager.LayoutParams dnv;
    private GifView dnw;
    private ViewGroup dnx;
    private int dny;
    private int dnz;
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
        this.dnC = -1;
        this.dnG = 0;
        this.dnH = -1;
        this.currentPosition = -1;
        this.dnK = new Point();
        this.aJr = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aK(new ArrayList(EmotionTabContentView.this.dnE));
                        if (EmotionTabContentView.this.dns != null) {
                            EmotionTabContentView.this.dns.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dnH < 0 || EmotionTabContentView.this.dnH >= EmotionTabContentView.this.dnE.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dnE.get(EmotionTabContentView.this.dnH)).Lq() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dns != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dnF.size()) {
                                    EmotionTabContentView.this.dnD = (d) EmotionTabContentView.this.dnF.get(EmotionTabContentView.this.currentPosition);
                                    int apX = EmotionTabContentView.this.dnD.apX();
                                    EmotionTabContentView.this.buN.setCount(apX);
                                    EmotionTabContentView.this.buN.setVisibility(apX > 1 ? 0 : 4);
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
                                                    int index = aVar.apR().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dnF.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dnF.get(index));
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
        this.dnC = -1;
        this.dnG = 0;
        this.dnH = -1;
        this.currentPosition = -1;
        this.dnK = new Point();
        this.aJr = new CustomMessageListener(2921028) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                switch (customResponsedMessage.getCmd()) {
                    case 2921028:
                        EmotionTabContentView.this.aK(new ArrayList(EmotionTabContentView.this.dnE));
                        if (EmotionTabContentView.this.dns != null) {
                            EmotionTabContentView.this.dns.notifyDataSetChanged();
                            if ((EmotionTabContentView.this.dnH < 0 || EmotionTabContentView.this.dnH >= EmotionTabContentView.this.dnE.size() || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabContentView.this.dnE.get(EmotionTabContentView.this.dnH)).Lq() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.dns != null) {
                                if (EmotionTabContentView.this.currentPosition >= 0 && EmotionTabContentView.this.currentPosition < EmotionTabContentView.this.dnF.size()) {
                                    EmotionTabContentView.this.dnD = (d) EmotionTabContentView.this.dnF.get(EmotionTabContentView.this.currentPosition);
                                    int apX = EmotionTabContentView.this.dnD.apX();
                                    EmotionTabContentView.this.buN.setCount(apX);
                                    EmotionTabContentView.this.buN.setVisibility(apX > 1 ? 0 : 4);
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
                                                    int index = aVar.apR().getIndex();
                                                    if (index >= 0 && index < EmotionTabContentView.this.dnF.size()) {
                                                        aVar.a((d) EmotionTabContentView.this.dnF.get(index));
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
        this.dnE = new ArrayList();
        this.dnF = new ArrayList();
        this.dnL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GridView>() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: apP */
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
        this.dnw = new GifView(context);
        aj.f(this.dnw, d.f.bg_expression_bubble, this.bfz);
        this.dnw.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dnv = new WindowManager.LayoutParams();
        this.dny = context.getResources().getDimensionPixelSize(d.e.ds240);
        this.dnz = context.getResources().getDimensionPixelSize(d.e.ds252);
        this.dnA = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.dnv.width = this.dny;
        this.dnv.height = this.dnz;
        this.dnv.gravity = 51;
        this.dnv.format = -3;
        this.dnv.type = 1000;
        this.dnv.flags |= 56;
        this.dnx = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.buN = (IndicatorView) findViewById(d.g.face_tab_indicator);
        this.dnu = (LinearLayout) findViewById(d.g.face_tab_indicator_layout);
        this.dnu.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.dnv.type = 1000;
            this.dnv.flags = 25165832;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.dnE.clear();
        this.dnF.clear();
        if (list != null && !list.isEmpty()) {
            this.dnE.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int Lt = cVar.Lt();
                    int Lu = cVar.Lu();
                    int i4 = emotionsCount / (Lt * Lu);
                    if (emotionsCount % (Lt * Lu) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        d dVar = new d();
                        if (i5 < i4 - 1) {
                            i = Lt * Lu;
                        } else {
                            i = emotionsCount - ((Lt * Lu) * (i4 - 1));
                        }
                        dVar.e(cVar);
                        dVar.mj(i3);
                        dVar.b(cVar.Lq());
                        dVar.hS(Lu);
                        dVar.hR(Lt);
                        dVar.mf(i4);
                        dVar.mg(i5);
                        dVar.mh(i);
                        dVar.mi(i5 * Lt * Lu);
                        dVar.setEndIndex((i + i2) - 1);
                        this.dnF.add(dVar);
                    }
                }
            }
            this.dnG = this.dnF.size();
            for (int i6 = 0; i6 < this.dnG; i6++) {
                if (this.dnF != null && this.dnF.get(i6) != null) {
                    this.dnF.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void mc(int i) {
        if (this.dnF != null) {
            int size = this.dnF.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    d dVar = this.dnF.get(i2);
                    if (dVar != null && dVar.aqb() == i) {
                        this.dnJ = dVar.getIndex();
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
                this.dns = new b();
                this.qV.setAdapter(this.dns);
                this.qV.setCurrentItem(this.dnJ, true);
                if (this.dnI != null) {
                    this.dnI.me(i);
                    this.dnH = i;
                }
            }
        }
    }

    public void md(int i) {
        int i2;
        if (this.qV != null) {
            int size = this.dnF.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        d dVar = this.dnF.get(i3);
                        if (dVar == null || dVar.aqb() != i) {
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
        if (this.dnC != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.apR() != null) {
            d apR = aVar.apR();
            String hL = apR.apU().hL(aVar.apQ() + i);
            if (apR.apV() != EmotionGroupType.USER_COLLECT || !hL.equals(com.baidu.tbadk.imageManager.d.bwy)) {
                this.dnw.setTag(hL);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = hL;
                if (hL.startsWith("#(meme,")) {
                    this.dnw.setShowStaticDrawable(false);
                } else {
                    this.dnw.setShowStaticDrawable(true);
                }
                this.dnw.a(gifInfo);
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
                linearLayout.getDrawingRect(this.rect);
                this.dnx.offsetDescendantRectToMyCoords(linearLayout, this.rect);
                this.dnv.x = this.rect.left - ((this.dnv.width - linearLayout.getWidth()) / 2);
                this.dnv.y = (this.rect.top - this.dnv.height) + this.dnA;
                this.dnw.setVisibility(0);
                if (!this.dnB) {
                    this.mWindowManager.addView(this.dnw, this.dnv);
                    this.dnB = true;
                } else {
                    this.mWindowManager.updateViewLayout(this.dnw, this.dnv);
                }
                gridView.setSelection(i);
                if (this.dnC != -1) {
                    ((LinearLayout) gridView.getChildAt(this.dnC - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.dnC = i;
                this.dnt = gridView;
            }
        }
    }

    private void apO() {
        if (this.dnB && this.dnw.getVisibility() != 8 && this.dnt != null) {
            this.dnt.setSelection(-1);
            this.dnw.setVisibility(8);
            if (this.dnC != -1) {
                ((LinearLayout) this.dnt.getChildAt(this.dnC - this.dnt.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.dnC = -1;
            this.dnt = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.dnK.set(x, y);
                break;
            case 1:
            case 3:
                apO();
                break;
            case 2:
                this.dnK.set(x, y);
                if (this.dnB && this.dnw.getVisibility() != 8 && this.dnt != null) {
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
                this.dnK.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                apO();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    apO();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.dnt != null) {
                        offsetRectIntoDescendantCoords(this.dnt, this.rect);
                        int pointToPosition = this.dnt.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.dnt);
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
        if (this.dnB) {
            this.mWindowManager.removeView(this.dnw);
            this.dnB = false;
        }
        MessageManager.getInstance().unRegisterListener(this.aJr);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.dnF != null) {
            int size = this.dnF.size();
            if (i >= 0 && i < size) {
                this.dnD = this.dnF.get(i);
                if (this.buN != null && this.dnD != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.buN.setVisibility(this.dnD.apX() > 1 ? 0 : 4);
                        this.buN.setCount(this.dnD.apX());
                        if (this.dnD != null && this.dnD.aqb() != this.dnH) {
                            this.dnH = this.dnD.aqb();
                            if (this.dnI != null) {
                                this.dnI.me(this.dnD.aqb());
                            }
                        }
                    }
                    float apY = this.dnD.apY() + f;
                    this.buN.setPosition(apY);
                    this.dnu.setContentDescription(String.format(getResources().getString(d.j.emotion_selection), Integer.valueOf(((int) apY) + 1)) + String.format(getResources().getString(d.j.emotion_page), Integer.valueOf(this.dnD.apX())));
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
        this.bfz = i;
        aj.f(this.dnw, d.f.bg_expression_bubble, i);
        aj.g(this, d.C0141d.cp_bg_line_d, i);
        this.buN.setSelector(aj.au(i, d.f.dot_pb_expression_s));
        this.buN.setDrawable(aj.au(i, d.f.dot_pb_expression_n));
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
        apO();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private d dnN;

        public a(d dVar) {
            this.dnN = dVar;
        }

        public void a(d dVar) {
            this.dnN = dVar;
        }

        public int apQ() {
            if (this.dnN == null) {
                return 0;
            }
            return this.dnN.aqa();
        }

        public d apR() {
            return this.dnN;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dnN == null) {
                return 0;
            }
            return this.dnN.apZ();
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
                if (this.dnN.apW() != 0) {
                    i2 = measuredWidth / this.dnN.apW();
                }
                if (this.dnN.getRow() != 0) {
                    i3 = measuredHeight / this.dnN.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.dnA * 2, EmotionTabContentView.this.dnA * 2, EmotionTabContentView.this.dnA * 2, EmotionTabContentView.this.dnA * 2);
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
            if (this.dnN != null) {
                int aqa = this.dnN.aqa() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(d.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                aj.f(tbImageView, d.f.btn_choose_face_selector, EmotionTabContentView.this.bfz);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String hL = this.dnN.apU().hL(aqa);
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
                if (this.dnN.apV() == EmotionGroupType.BIG_EMOTION) {
                    String hL2 = this.dnN.apU().hL(aqa);
                    if (!TextUtils.isEmpty(hL2) && !hL2.startsWith("#(meme,")) {
                        if (EmotionTabContentView.this.bfz == 0) {
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
            if (EmotionTabContentView.this.dnF == null) {
                return 0;
            }
            return EmotionTabContentView.this.dnF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.dnL.ar(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.dnL.nk();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.dnF != null && i < EmotionTabContentView.this.dnF.size()) {
                d dVar = (d) EmotionTabContentView.this.dnF.get(i);
                gridView2.setNumColumns(dVar.apW());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(d.C0141d.common_color_10022);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(d.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabContentView.b.1
                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        a aVar = (a) adapterView.getAdapter();
                        if (aVar == null || aVar.apR() == null) {
                            return false;
                        }
                        d apR = aVar.apR();
                        if (apR.apV() == EmotionGroupType.BIG_EMOTION || apR.apV() == EmotionGroupType.USER_COLLECT) {
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
                        if (EmotionTabContentView.this.axG != null) {
                            n nVar = new n();
                            a aVar = (a) adapterView.getAdapter();
                            if (aVar != null && aVar.apR() != null) {
                                d apR = aVar.apR();
                                int apQ = aVar.apQ();
                                com.baidu.tbadk.editortools.emotiontool.c apU = apR.apU();
                                String hL = apR.apU().hL(apQ + i2);
                                if (apU.Lq() == EmotionGroupType.USER_COLLECT && com.baidu.tbadk.imageManager.d.bwy.equals(hL)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.mContext)));
                                    return;
                                }
                                nVar.setName(hL);
                                nVar.a(apU.Lq());
                                nVar.fh(apU.getGroupName());
                                nVar.fi(apU.getGroupId());
                                nVar.setWidth(apU.getWidth());
                                nVar.setHeight(apU.getHeight());
                                EmotionTabContentView.this.axG.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
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
            if (EmotionTabContentView.this.dnF != null) {
                int size = EmotionTabContentView.this.dnF.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    d dVar = (d) EmotionTabContentView.this.dnF.get(i);
                    if (dVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.buN.setVisibility(dVar.apX() > 1 ? 0 : 4);
                        EmotionTabContentView.this.buN.setCount(dVar.apX());
                        EmotionTabContentView.this.buN.setPosition(dVar.apY());
                        EmotionTabContentView.this.buN.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_selection), Integer.valueOf(dVar.apY() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(d.j.emotion_page), Integer.valueOf(dVar.apX())));
                    }
                    if (dVar != null && dVar.aqb() != EmotionTabContentView.this.dnH) {
                        EmotionTabContentView.this.dnH = dVar.aqb();
                        if (EmotionTabContentView.this.dnI != null) {
                            EmotionTabContentView.this.dnI.me(dVar.aqb());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.dnI = cVar;
    }

    public void setOnDataSelected(i iVar) {
        this.axG = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aJr);
    }
}
