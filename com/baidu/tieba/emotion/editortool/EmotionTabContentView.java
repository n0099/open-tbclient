package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
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
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.l LE;
    private GridView aZi;
    private WindowManager.LayoutParams aZj;
    private GifView aZk;
    private ViewGroup aZl;
    private int aZm;
    private int aZn;
    private int aZo;
    private boolean aZp;
    private int aZq;
    private t aZr;
    private List<com.baidu.tbadk.editortools.emotiontool.c> aZs;
    private List<t> aZt;
    private int aZu;
    private int aZv;
    private c aZw;
    private int aZx;
    private final Point aZy;
    private com.baidu.adp.lib.f.b<GridView> aZz;
    private int aik;
    private ViewPager aim;
    private IndicatorView ain;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void fV(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.aZq = -1;
        this.aZu = 0;
        this.aZv = -1;
        this.currentPosition = -1;
        this.aZy = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.aZq = -1;
        this.aZu = 0;
        this.aZv = -1;
        this.currentPosition = -1;
        this.aZy = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aZs = new ArrayList();
        this.aZt = new ArrayList();
        this.aZz = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.emotion_tab_content, (ViewGroup) this, true);
        this.aim = (ViewPager) findViewById(t.g.face_tab_viewpager);
        this.aim.setFadingEdgeLength(0);
        this.aim.setOnPageChangeListener(this);
        this.aZk = new GifView(context);
        at.c(this.aZk, t.f.bg_expression_bubble, this.aik);
        this.aZk.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.aZj = new WindowManager.LayoutParams();
        this.aZm = context.getResources().getDimensionPixelSize(t.e.ds240);
        this.aZn = context.getResources().getDimensionPixelSize(t.e.ds252);
        this.aZo = context.getResources().getDimensionPixelSize(t.e.face_tab_content_float_space);
        this.aZj.width = this.aZm;
        this.aZj.height = this.aZn;
        this.aZj.gravity = 51;
        this.aZj.format = -3;
        this.aZj.type = 1000;
        this.aZj.flags |= 56;
        this.aZl = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ain = (IndicatorView) findViewById(t.g.face_tab_indicator);
        this.ain.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aZj.type = 1000;
            this.aZj.flags = 25165832;
        }
    }

    private void L(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.aZs.clear();
        this.aZt.clear();
        if (list != null && !list.isEmpty()) {
            this.aZs.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int DE = cVar.DE();
                    int rows = cVar.getRows();
                    int i4 = emotionsCount / (DE * rows);
                    if (emotionsCount % (DE * rows) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = DE * rows;
                        } else {
                            i = emotionsCount - ((DE * rows) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.ga(i3);
                        tVar.b(cVar.DB());
                        tVar.eO(rows);
                        tVar.eN(DE);
                        tVar.fW(i4);
                        tVar.fX(i5);
                        tVar.fY(i);
                        tVar.fZ(i5 * DE * rows);
                        tVar.setEndIndex((i + i2) - 1);
                        this.aZt.add(tVar);
                    }
                }
            }
            this.aZu = this.aZt.size();
            for (int i6 = 0; i6 < this.aZu; i6++) {
                if (this.aZt != null && this.aZt.get(i6) != null) {
                    this.aZt.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void fT(int i) {
        if (this.aZt != null) {
            int size = this.aZt.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.aZt.get(i2);
                    if (tVar != null && tVar.Nl() == i) {
                        this.aZx = tVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void f(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                L(list);
                fT(i);
                this.aim.setAdapter(new b());
                this.aim.setCurrentItem(this.aZx, true);
                if (this.aZw != null) {
                    this.aZw.fV(i);
                    this.aZv = i;
                }
            }
        }
    }

    public void fU(int i) {
        int i2;
        if (this.aim != null) {
            int size = this.aZt.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.aZt.get(i3);
                    if (tVar == null || tVar.Nl() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.aim.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.aZq != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Nb() != null) {
            String eF = aVar.Nb().Ne().eF(aVar.Na() + i);
            this.aZk.setTag(eF);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.awY = eF;
            this.aZk.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.aZl.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.aZj.x = this.rect.left - ((this.aZj.width - linearLayout.getWidth()) / 2);
            this.aZj.y = (this.rect.top - this.aZj.height) + this.aZo;
            this.aZk.setVisibility(0);
            if (!this.aZp) {
                this.lB.addView(this.aZk, this.aZj);
                this.aZp = true;
            } else {
                this.lB.updateViewLayout(this.aZk, this.aZj);
            }
            gridView.setSelection(i);
            if (this.aZq != -1) {
                ((LinearLayout) gridView.getChildAt(this.aZq - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aZq = i;
            this.aZi = gridView;
        }
    }

    private void MY() {
        if (this.aZp && this.aZk.getVisibility() != 8 && this.aZi != null) {
            this.aZi.setSelection(-1);
            this.aZk.setVisibility(8);
            if (this.aZq != -1) {
                ((LinearLayout) this.aZi.getChildAt(this.aZq - this.aZi.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aZq = -1;
            this.aZi = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aZy.set(x, y);
                break;
            case 1:
            case 3:
                MY();
                break;
            case 2:
                this.aZy.set(x, y);
                if (this.aZp && this.aZk.getVisibility() != 8 && this.aZi != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aZy.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                MY();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    MY();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.aZi != null) {
                        offsetRectIntoDescendantCoords(this.aZi, this.rect);
                        int pointToPosition = this.aZi.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aZi);
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
        if (this.aZp) {
            this.lB.removeView(this.aZk);
            this.aZp = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aZt != null) {
            int size = this.aZt.size();
            if (i >= 0 && i < size) {
                this.aZr = this.aZt.get(i);
                if (this.ain != null && this.aZr != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ain.setVisibility(this.aZr.Nh() > 1 ? 0 : 4);
                        this.ain.setCount(this.aZr.Nh());
                        if (this.aZr != null && this.aZr.Nl() != this.aZv) {
                            this.aZv = this.aZr.Nl();
                            if (this.aZw != null) {
                                this.aZw.fV(this.aZr.Nl());
                            }
                        }
                    }
                    float Ni = this.aZr.Ni() + f;
                    this.ain.setPosition(Ni);
                    this.ain.setContentDescription(String.valueOf(String.format(getResources().getString(t.j.emotion_selection), Integer.valueOf(((int) Ni) + 1))) + String.format(getResources().getString(t.j.emotion_page), Integer.valueOf(this.aZr.Nh())));
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
        this.aik = i;
        at.c(this.aZk, t.f.bg_expression_bubble, i);
        at.d(this, t.d.write_editor_background, i);
        this.ain.setSelector(at.o(i, t.f.dot_pb_expression_s));
        this.ain.setDrawable(at.o(i, t.f.dot_pb_expression_n));
    }

    public void reset() {
        MY();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t aZB;

        public a(t tVar) {
            this.aZB = tVar;
        }

        public int Na() {
            if (this.aZB == null) {
                return 0;
            }
            return this.aZB.Nk();
        }

        public t Nb() {
            return this.aZB;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aZB == null) {
                return 0;
            }
            return this.aZB.Nj();
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
            com.baidu.adp.widget.a.a aVar;
            int color;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(t.h.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int i2 = 0;
                int i3 = 0;
                if (this.aZB.Ng() != 0) {
                    i2 = measuredWidth / this.aZB.Ng();
                }
                if (this.aZB.getRow() != 0) {
                    i3 = measuredHeight / this.aZB.getRow();
                }
                linearLayout2.setPadding(EmotionTabContentView.this.aZo * 2, EmotionTabContentView.this.aZo * 2, EmotionTabContentView.this.aZo * 2, EmotionTabContentView.this.aZo * 2);
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
            if (this.aZB != null) {
                int Nk = this.aZB.Nk() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(t.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                at.c(tbImageView, t.f.btn_choose_face_selector, EmotionTabContentView.this.aik);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String eF = this.aZB.Ne().eF(Nk);
                tbImageView.setTag(eF);
                Object a = com.baidu.adp.lib.g.c.hr().a(eF, 20, new j(this), 0, 0, null, null, eF, false, null);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout3.findViewById(t.g.emotion_tab_content_tip);
                if (this.aZB.Nf() == EmotionGroupType.BIG_EMOTION) {
                    String eF2 = this.aZB.Ne().eF(Nk);
                    if (!TextUtils.isEmpty(eF2)) {
                        if (EmotionTabContentView.this.aik == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(t.d.cp_cont_c);
                        } else {
                            color = at.getColor(t.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(eF2.substring(eF2.lastIndexOf("_") + 1, eF2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (eF.length() > 3) {
                    linearLayout3.setContentDescription(eF.substring(2, eF.length() - 1));
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
            if (EmotionTabContentView.this.aZt == null) {
                return 0;
            }
            return EmotionTabContentView.this.aZt.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.aZz.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.aZz.hp();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.aZt != null && i < EmotionTabContentView.this.aZt.size()) {
                t tVar = (t) EmotionTabContentView.this.aZt.get(i);
                gridView2.setNumColumns(tVar.Ng());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(t.d.transparent);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(t.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(t.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.aZt != null) {
                int size = EmotionTabContentView.this.aZt.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.aZt.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ain.setVisibility(tVar.Nh() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ain.setCount(tVar.Nh());
                        EmotionTabContentView.this.ain.setPosition(tVar.Ni());
                        EmotionTabContentView.this.ain.setContentDescription(String.valueOf(String.format(EmotionTabContentView.this.getResources().getString(t.j.emotion_selection), Integer.valueOf(tVar.Ni() + 1))) + String.format(EmotionTabContentView.this.getResources().getString(t.j.emotion_page), Integer.valueOf(tVar.Nh())));
                    }
                    if (tVar != null && tVar.Nl() != EmotionTabContentView.this.aZv) {
                        EmotionTabContentView.this.aZv = tVar.Nl();
                        if (EmotionTabContentView.this.aZw != null) {
                            EmotionTabContentView.this.aZw.fV(tVar.Nl());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aZw = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
    }
}
