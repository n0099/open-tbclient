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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private com.baidu.tbadk.editortools.k Li;
    private int aSA;
    private int aSB;
    private boolean aSC;
    private int aSD;
    private t aSE;
    private List<com.baidu.tbadk.editortools.emotiontool.c> aSF;
    private List<t> aSG;
    private int aSH;
    private int aSI;
    private c aSJ;
    private int aSK;
    private final Point aSL;
    private com.baidu.adp.lib.f.b<GridView> aSM;
    private GridView aSv;
    private WindowManager.LayoutParams aSw;
    private GifView aSx;
    private ViewGroup aSy;
    private int aSz;
    private int ahf;
    private IndicatorView ahm;
    private int currentPosition;
    private WindowManager lB;
    private Context mContext;
    private ViewPager mViewPager;
    private final Rect rect;

    /* loaded from: classes.dex */
    public interface c {
        void fg(int i);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.aSD = -1;
        this.aSH = 0;
        this.aSI = -1;
        this.currentPosition = -1;
        this.aSL = new Point();
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.rect = new Rect();
        this.aSD = -1;
        this.aSH = 0;
        this.aSI = -1;
        this.currentPosition = -1;
        this.aSL = new Point();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aSF = new ArrayList();
        this.aSG = new ArrayList();
        this.aSM = new com.baidu.adp.lib.f.b<>(new i(this), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(n.h.emotion_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(n.g.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.aSx = new GifView(context);
        as.c(this.aSx, n.f.bg_expression_bubble, this.ahf);
        this.aSx.setVisibility(8);
        this.lB = (WindowManager) context.getSystemService("window");
        this.aSw = new WindowManager.LayoutParams();
        this.aSz = context.getResources().getDimensionPixelSize(n.e.ds240);
        this.aSA = context.getResources().getDimensionPixelSize(n.e.ds252);
        this.aSB = context.getResources().getDimensionPixelSize(n.e.face_tab_content_float_space);
        this.aSw.width = this.aSz;
        this.aSw.height = this.aSA;
        this.aSw.gravity = 51;
        this.aSw.format = -3;
        this.aSw.type = 1000;
        this.aSw.flags |= 56;
        this.aSy = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ahm = (IndicatorView) findViewById(n.g.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aSw.type = 1000;
            this.aSw.flags = 25165832;
        }
    }

    private void K(List<com.baidu.tbadk.editortools.emotiontool.c> list) {
        int i;
        int i2;
        this.aSF.clear();
        this.aSG.clear();
        if (list != null && !list.isEmpty()) {
            this.aSF.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = list.get(i3);
                if (cVar != null) {
                    int emotionsCount = cVar.getEmotionsCount();
                    int BF = cVar.BF();
                    int BG = cVar.BG();
                    int i4 = emotionsCount / (BF * BG);
                    if (emotionsCount % (BF * BG) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        t tVar = new t();
                        if (i5 < i4 - 1) {
                            i = BF * BG;
                        } else {
                            i = emotionsCount - ((BF * BG) * (i4 - 1));
                        }
                        tVar.e(cVar);
                        tVar.fl(i3);
                        tVar.b(cVar.BC());
                        tVar.ep(BG);
                        tVar.eo(BF);
                        tVar.fh(i4);
                        tVar.fi(i5);
                        tVar.fj(i);
                        tVar.fk(i5 * BF * BG);
                        tVar.setEndIndex((i + i2) - 1);
                        this.aSG.add(tVar);
                    }
                }
            }
            this.aSH = this.aSG.size();
            for (int i6 = 0; i6 < this.aSH; i6++) {
                if (this.aSG != null && this.aSG.get(i6) != null) {
                    this.aSG.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void fe(int i) {
        if (this.aSG != null) {
            int size = this.aSG.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    t tVar = this.aSG.get(i2);
                    if (tVar != null && tVar.JJ() == i) {
                        this.aSK = tVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void c(List<com.baidu.tbadk.editortools.emotiontool.c> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                K(list);
                fe(i);
                this.mViewPager.setAdapter(new b());
                this.mViewPager.setCurrentItem(this.aSK, true);
                if (this.aSJ != null) {
                    this.aSJ.fg(i);
                    this.aSI = i;
                }
            }
        }
    }

    public void ff(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.aSG.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    t tVar = this.aSG.get(i3);
                    if (tVar == null || tVar.JJ() != i) {
                        i3++;
                    } else {
                        i2 = tVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, false);
            }
        }
    }

    public void a(int i, GridView gridView) {
        a aVar;
        if (this.aSD != i && gridView != null && (aVar = (a) gridView.getAdapter()) != null && aVar.Jz() != null) {
            String ef = aVar.Jz().JC().ef(aVar.Jy() + i);
            this.aSx.setTag(ef);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.avz = ef;
            this.aSx.a(aVar2);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.rect);
            this.aSy.offsetDescendantRectToMyCoords(linearLayout, this.rect);
            this.aSw.x = this.rect.left - ((this.aSw.width - linearLayout.getWidth()) / 2);
            this.aSw.y = (this.rect.top - this.aSw.height) + this.aSB;
            this.aSx.setVisibility(0);
            if (!this.aSC) {
                this.lB.addView(this.aSx, this.aSw);
                this.aSC = true;
            } else {
                this.lB.updateViewLayout(this.aSx, this.aSw);
            }
            gridView.setSelection(i);
            if (this.aSD != -1) {
                ((LinearLayout) gridView.getChildAt(this.aSD - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aSD = i;
            this.aSv = gridView;
        }
    }

    private void Jw() {
        if (this.aSC && this.aSx.getVisibility() != 8 && this.aSv != null) {
            this.aSv.setSelection(-1);
            this.aSx.setVisibility(8);
            if (this.aSD != -1) {
                ((LinearLayout) this.aSv.getChildAt(this.aSD - this.aSv.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aSD = -1;
            this.aSv = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aSL.set(x, y);
                break;
            case 1:
            case 3:
                Jw();
                break;
            case 2:
                this.aSL.set(x, y);
                if (this.aSC && this.aSx.getVisibility() != 8 && this.aSv != null) {
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
                this.aSL.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                Jw();
                break;
            case 2:
                getFocusedRect(this.rect);
                if (!this.rect.contains(x, y)) {
                    Jw();
                    break;
                } else {
                    this.rect.set(x, y, x + 1, y + 1);
                    if (this.aSv != null) {
                        offsetRectIntoDescendantCoords(this.aSv, this.rect);
                        int pointToPosition = this.aSv.pointToPosition(this.rect.left, this.rect.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aSv);
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
        if (this.aSC) {
            this.lB.removeView(this.aSx);
            this.aSC = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aSG != null) {
            int size = this.aSG.size();
            if (i >= 0 && i < size) {
                this.aSE = this.aSG.get(i);
                if (this.ahm != null && this.aSE != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ahm.setVisibility(this.aSE.JF() > 1 ? 0 : 4);
                        this.ahm.setCount(this.aSE.JF());
                        if (this.aSE != null && this.aSE.JJ() != this.aSI) {
                            this.aSI = this.aSE.JJ();
                            if (this.aSJ != null) {
                                this.aSJ.fg(this.aSE.JJ());
                            }
                        }
                    }
                    this.ahm.setPosition(this.aSE.JG() + f);
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
        this.ahf = i;
        as.c(this.aSx, n.f.bg_expression_bubble, i);
        as.d(this, n.d.write_editor_background, i);
        this.ahm.setSelector(as.w(i, n.f.dot_pb_expression_s));
        this.ahm.setDrawable(as.w(i, n.f.dot_pb_expression_n));
    }

    public void reset() {
        Jw();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final t aSO;

        public a(t tVar) {
            this.aSO = tVar;
        }

        public int Jy() {
            if (this.aSO == null) {
                return 0;
            }
            return this.aSO.JI();
        }

        public t Jz() {
            return this.aSO;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aSO == null) {
                return 0;
            }
            return this.aSO.JH();
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
            int color;
            LinearLayout linearLayout = (LinearLayout) (view == null ? (LinearLayout) LayoutInflater.from(TbadkCoreApplication.m411getInst().getContext()).inflate(n.h.emotion_tab_content_item, (ViewGroup) null) : view);
            if (this.aSO != null) {
                int JI = this.aSO.JI() + i;
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int JE = measuredWidth / this.aSO.JE();
                int row = measuredHeight / this.aSO.getRow();
                linearLayout.setPadding(EmotionTabContentView.this.aSB * 2, EmotionTabContentView.this.aSB * 2, EmotionTabContentView.this.aSB * 2, EmotionTabContentView.this.aSB * 2);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(JE, row));
                TbImageView tbImageView = (TbImageView) linearLayout.findViewById(n.g.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                as.c(tbImageView, n.f.btn_choose_face_selector, EmotionTabContentView.this.ahf);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String ef = this.aSO.JC().ef(JI);
                tbImageView.setTag(ef);
                Object a = com.baidu.adp.lib.g.c.hd().a(ef, 20, new j(this), 0, 0, null, null, ef, false, null);
                com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
                if (aVar != null) {
                    aVar.a(tbImageView);
                    tbImageView.setTag(null);
                }
                TextView textView = (TextView) linearLayout.findViewById(n.g.emotion_tab_content_tip);
                if (this.aSO.JD() == EmotionGroupType.BIG_EMOTION) {
                    String ef2 = this.aSO.JC().ef(JI);
                    if (!TextUtils.isEmpty(ef2)) {
                        if (EmotionTabContentView.this.ahf == 0) {
                            color = EmotionTabContentView.this.getContext().getResources().getColor(n.d.cp_cont_c);
                        } else {
                            color = as.getColor(n.d.cp_cont_c);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(ef2.substring(ef2.lastIndexOf("_") + 1, ef2.length() - 1));
                    }
                } else {
                    textView.setVisibility(8);
                }
            }
            return linearLayout;
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.aSG == null) {
                return 0;
            }
            return EmotionTabContentView.this.aSG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.aSM.k(gridView);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            GridView gridView = (GridView) EmotionTabContentView.this.aSM.hb();
            GridView gridView2 = gridView == null ? new GridView(EmotionTabContentView.this.mContext) : gridView;
            gridView2.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.aSG != null && i < EmotionTabContentView.this.aSG.size()) {
                t tVar = (t) EmotionTabContentView.this.aSG.get(i);
                gridView2.setNumColumns(tVar.JE());
                gridView2.setVerticalSpacing(0);
                gridView2.setHorizontalSpacing(0);
                gridView2.setSelector(n.d.transparent);
                gridView2.setPadding(EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(n.e.ds28), 0, EmotionTabContentView.this.mContext.getResources().getDimensionPixelSize(n.e.ds28), 0);
                gridView2.setOnItemLongClickListener(new k(this));
                gridView2.setOnItemClickListener(new l(this));
                gridView2.setAdapter((ListAdapter) new a(tVar));
            }
            viewGroup.addView(gridView2);
            return gridView2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (EmotionTabContentView.this.aSG != null) {
                int size = EmotionTabContentView.this.aSG.size();
                if (i == 0 && i < size && i != EmotionTabContentView.this.currentPosition) {
                    t tVar = (t) EmotionTabContentView.this.aSG.get(i);
                    if (tVar != null) {
                        EmotionTabContentView.this.currentPosition = i;
                        EmotionTabContentView.this.ahm.setVisibility(tVar.JF() > 1 ? 0 : 4);
                        EmotionTabContentView.this.ahm.setCount(tVar.JF());
                        EmotionTabContentView.this.ahm.setPosition(tVar.JG());
                    }
                    if (tVar != null && tVar.JJ() != EmotionTabContentView.this.aSI) {
                        EmotionTabContentView.this.aSI = tVar.JJ();
                        if (EmotionTabContentView.this.aSJ != null) {
                            EmotionTabContentView.this.aSJ.fg(tVar.JJ());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    public void setOnEmotionSwitchedListener(c cVar) {
        this.aSJ = cVar;
    }

    public void setOnDataSelected(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
    }
}
