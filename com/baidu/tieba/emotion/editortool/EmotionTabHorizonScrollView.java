package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {

    /* renamed from: f  reason: collision with root package name */
    public EmotionLinearLayout f15118f;

    /* renamed from: g  reason: collision with root package name */
    public int f15119g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d.a.i0.w.p.c> f15120h;

    /* renamed from: i  reason: collision with root package name */
    public EmotionTabWidgetView.c f15121i;
    public int j;
    public int k;
    public int l;
    public LinearLayout m;
    public ImageView n;
    public TextView o;
    public LinearLayout.LayoutParams p;
    public boolean q;
    public View r;
    public TbImageView s;
    public boolean t;
    public EditorTools u;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdToast.c(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (EmotionTabHorizonScrollView.this.o != null) {
                EmotionTabHorizonScrollView.this.f15118f.setNewViewVisible(false);
            }
            TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
            TbadkCoreApplication.getInst().setFaceShopNew(false);
            if (EmotionTabHorizonScrollView.this.u != null) {
                EmotionTabHorizonScrollView.this.u.A(new d.a.i0.w.a(2, 5, null));
            }
            if (j.z()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
            } else {
                l.L(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdToast.c(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).q();
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15125a;

        /* renamed from: b  reason: collision with root package name */
        public View f15126b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.i0.w.p.c f15127c;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final String f15128e;

        public /* synthetic */ e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, a aVar) {
            this(str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.m.b.d(this.f15128e, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), d.a.c.e.m.b.d(this.f15128e, 0), 0)));
            }
        }

        public e(String str) {
            this.f15128e = str;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f15130e;

        public /* synthetic */ f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i2, a aVar) {
            this(i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView;
            if (!EmotionTabHorizonScrollView.this.u.n(5).c() && (((d.a.i0.w.p.c) EmotionTabHorizonScrollView.this.f15120h.get(this.f15130e)).h() == EmotionGroupType.USER_COLLECT || ((d.a.i0.w.p.c) EmotionTabHorizonScrollView.this.f15120h.get(this.f15130e)).h() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, Boolean.TRUE));
                return;
            }
            if ((view instanceof TbImageView) && (tbImageView = (TbImageView) view) != EmotionTabHorizonScrollView.this.s) {
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.s != null) {
                    if (!EmotionTabHorizonScrollView.this.t) {
                        EmotionTabHorizonScrollView.this.s.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.s.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.s = tbImageView;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.f15130e);
            EmotionTabHorizonScrollView.this.f15121i.a(this.f15130e);
        }

        public f(int i2) {
            this.f15130e = i2;
        }
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15119g = -1;
        this.q = true;
        m();
    }

    public void i() {
        ImageView imageView = new ImageView(getContext());
        this.n = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView2 = this.n;
        int i2 = this.k;
        int i3 = this.j;
        imageView2.setPadding(i2, i3, i2, i3);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.m = linearLayout;
        linearLayout.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.n.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.n, R.drawable.face_store, this.l);
        this.m.addView(this.n);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        SkinManager.setBackgroundColor(view, R.color.common_color_10288, this.l);
        TextView textView = new TextView(getContext());
        this.o = textView;
        textView.setGravity(17);
        this.o.setTextSize(10.0f);
        this.o.setText("N");
        this.o.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f15118f.addView(this.m, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.f15118f.setNewView(this.o);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.f15118f.setNewViewVisible(true);
        } else {
            this.f15118f.setNewViewVisible(false);
        }
        this.m.setOnClickListener(new b());
        this.r = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.r.setLayoutParams(layoutParams3);
        this.f15118f.addView(this.r);
        if (appResponseToIntentClass) {
            return;
        }
        this.m.setVisibility(8);
    }

    public void j(d.a.i0.w.p.c cVar) {
        k(cVar);
    }

    public final TbImageView k(d.a.i0.w.p.c cVar) {
        int i2;
        int i3;
        TbImageView tbImageView = new TbImageView(getContext());
        d dVar = new d(null);
        dVar.f15127c = cVar;
        tbImageView.setAutoChangeStyle(false);
        dVar.f15125a = tbImageView;
        if (cVar.h() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            int i4 = this.k;
            int i5 = this.j;
            tbImageView.setPadding(i4, i5, i4, i5);
            ImageView imageView = new ImageView(getContext());
            SkinManager.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.g(getContext(), R.dimen.ds12), l.g(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1).addRule(11);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(dVar);
            this.f15118f.addView(relativeLayout, this.f15118f.getChildCount() - 1, this.p);
            if (cVar.e() != null) {
                cVar.e().h(tbImageView);
            }
            tbImageView.setOnClickListener(new e(this, cVar.f(), null));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.f());
            if (!this.t && ((i3 = this.l) == 1 || i3 == 4)) {
                view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.s == null) {
                this.s = tbImageView;
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            }
            SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.l);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            int i6 = this.k;
            int i7 = this.j;
            tbImageView.setPadding(i6, i7, i6, i7);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(dVar);
            this.f15118f.addView(linearLayout, this.f15118f.getChildCount() - 1, this.p);
            EmotionGroupType h2 = cVar.h();
            if (h2 == EmotionGroupType.LOCAL) {
                if (cVar.d() != null) {
                    cVar.d().h(tbImageView);
                }
                tbImageView.setOnClickListener(new f(this, this.f15118f.getChildCount() - 3, null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (h2 == EmotionGroupType.PROMOTION) {
                if (cVar.e() != null) {
                    cVar.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new e(this, cVar.f(), null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.f());
            } else if (h2 == EmotionGroupType.BIG_EMOTION) {
                if (this.q) {
                    if (cVar.d() != null) {
                        cVar.d().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f15118f.getChildCount() - 3, null));
                } else {
                    if (cVar.e() != null) {
                        cVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new a());
                }
                tbImageView.setContentDescription(cVar.g());
            } else if (h2 == EmotionGroupType.USER_COLLECT) {
                if (cVar.e() != null) {
                    cVar.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new f(this, this.f15118f.getChildCount() - 3, null));
                tbImageView.setContentDescription("");
            } else if (h2 == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.e() != null) {
                    cVar.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new e(this, cVar.f(), null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.f());
            }
            if (!this.t && ((i2 = this.l) == 1 || i2 == 4)) {
                view2.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.s == null) {
                this.s = tbImageView;
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            }
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.l);
        }
        return tbImageView;
    }

    public final boolean l(d.a.i0.w.p.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        if (z) {
            return false;
        }
        return cVar.h() == EmotionGroupType.BIG_EMOTION || cVar.h() == EmotionGroupType.PROMOTION;
    }

    public final void m() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        EmotionLinearLayout emotionLinearLayout = new EmotionLinearLayout(getContext());
        this.f15118f = emotionLinearLayout;
        emotionLinearLayout.setOrientation(0);
        this.f15118f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f15118f.setBaselineAligned(false);
        addView(this.f15118f);
        this.j = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.p = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.f15118f.setPadding(0, 0, 0, 0);
        i();
    }

    public void n(int i2) {
        int color;
        this.l = i2;
        ImageView imageView = this.n;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.face_store, i2);
        }
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, i2);
            if (this.m.getChildCount() > 0) {
                SkinManager.setBackgroundColor(this.m.getChildAt(1), R.color.common_color_10288, i2);
            }
        }
        View view = this.r;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.drawable.bg_emotion_tab_horizonscrollview, i2);
        }
        TextView textView = this.o;
        if (textView != null) {
            SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i2);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1, i2);
        }
        int childCount = this.f15118f.getChildCount();
        for (int i3 = 1; i3 < childCount; i3++) {
            View childAt = this.f15118f.getChildAt(i3);
            if (childAt != null) {
                SkinManager.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i2);
                d dVar = (d) childAt.getTag();
                if (dVar != null) {
                    if (dVar.f15125a != null) {
                        if (i2 == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = SkinManager.getColor(R.color.common_color_10287);
                        }
                        dVar.f15125a.setForegroundColor(color);
                    }
                    View view2 = dVar.f15126b;
                    if (view2 != null) {
                        SkinManager.setBackgroundColor(view2, R.color.common_color_10288, i2);
                    }
                }
            }
        }
        TbImageView tbImageView = this.s;
        if (tbImageView != null) {
            tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            if (this.s.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.s.getParent()).setSelected(true);
            }
        }
    }

    public void o() {
        this.f15119g = -1;
        this.f15118f.removeAllViews();
        i();
        n(this.l);
    }

    public void setCurrentTab(int i2) {
        int color;
        int i3 = this.f15119g;
        if (i2 == i3) {
            return;
        }
        if (i3 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f15118f.getChildAt(i3 + 1);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (tbImageView != null) {
                if (this.l == 0) {
                    color = getResources().getColor(R.color.common_color_10287);
                } else {
                    color = SkinManager.getColor(R.color.common_color_10287);
                }
                tbImageView.setForegroundColor(color);
            }
            linearLayout.setSelected(false);
        }
        this.f15119g = i2;
        LinearLayout linearLayout2 = (LinearLayout) this.f15118f.getChildAt(i2 + 1);
        linearLayout2.setSelected(true);
        int[] iArr = new int[2];
        linearLayout2.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int width = linearLayout2.getWidth() + i4;
        if (i4 < 0) {
            scrollBy(i4, 0);
        }
        if (getParent() instanceof ViewGroup) {
            View findViewById = ((ViewGroup) getParent()).findViewById(R.id.face_tab_delete);
            int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
            if (width > width2) {
                scrollBy(width - width2, 0);
            }
        }
        TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
        d.a.i0.w.p.c cVar = this.f15120h.get(this.f15119g);
        if (cVar.d() != null) {
            cVar.d().h(tbImageView2);
        }
        if (tbImageView2 != null) {
            tbImageView2.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            this.s = tbImageView2;
        }
    }

    public void setDatas(ArrayList<d.a.i0.w.p.c> arrayList) {
        this.f15120h = arrayList;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.u = editorTools;
    }

    public void setFrom(int i2) {
    }

    public void setIsInChat(boolean z) {
        this.t = z;
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.c cVar) {
        this.f15121i = cVar;
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.f15118f.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f15118f.getChildAt(i2);
            if (childAt != null) {
                if (l(childAt.getTag() instanceof d ? ((d) childAt.getTag()).f15127c : null, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (z && appResponseToIntentClass) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i2, boolean z) {
        this.q = z;
        int i3 = i2 + 1;
        int childCount = this.f15118f.getChildCount();
        int i4 = i3 - 1;
        d.a.i0.w.p.c cVar = this.f15120h.get(i4);
        if (i3 < childCount) {
            if (cVar.h() == EmotionGroupType.BIG_EMOTION || cVar.h() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.f15118f.getChildAt(i3)).getChildAt(0);
                if (!this.q) {
                    tbImageView.setOnClickListener(new c());
                    if (cVar.e() != null) {
                        cVar.e().h(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new f(this, i4, null));
                if (cVar.d() != null) {
                    cVar.d().h(tbImageView);
                }
            }
        }
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15119g = -1;
        this.q = true;
        m();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.f15119g = -1;
        this.q = true;
        m();
    }
}
