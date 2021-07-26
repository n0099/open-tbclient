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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public EmotionLinearLayout f14649f;

    /* renamed from: g  reason: collision with root package name */
    public int f14650g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d.a.p0.x.p.c> f14651h;

    /* renamed from: i  reason: collision with root package name */
    public EmotionTabWidgetView.c f14652i;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f14653e;

        public a(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14653e = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.c(this.f14653e.getContext(), this.f14653e.getContext().getResources().getString(R.string.emotion_cant_show)).q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f14654e;

        public b(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14654e = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14654e.o != null) {
                    this.f14654e.f14649f.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (this.f14654e.u != null) {
                    this.f14654e.u.A(new d.a.p0.x.a(2, 5, null));
                }
                if (j.z()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(this.f14654e.getContext())));
                } else {
                    l.L(this.f14654e.getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f14655e;

        public c(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14655e = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.c(this.f14655e.getContext(), this.f14655e.getContext().getResources().getString(R.string.emotion_cant_show)).q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f14656a;

        /* renamed from: b  reason: collision with root package name */
        public View f14657b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.p0.x.p.c f14658c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f14659e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f14660f;

        public /* synthetic */ e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, a aVar) {
            this(emotionTabHorizonScrollView, str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || d.a.d.e.m.b.d(this.f14659e, 0) <= 0) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f14660f.getContext(), d.a.d.e.m.b.d(this.f14659e, 0), 0)));
        }

        public e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14660f = emotionTabHorizonScrollView;
            this.f14659e = str;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f14661e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f14662f;

        public /* synthetic */ f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i2, a aVar) {
            this(emotionTabHorizonScrollView, i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f14662f.u.n(5).c() && (((d.a.p0.x.p.c) this.f14662f.f14651h.get(this.f14661e)).h() == EmotionGroupType.USER_COLLECT || ((d.a.p0.x.p.c) this.f14662f.f14651h.get(this.f14661e)).h() == EmotionGroupType.BIG_EMOTION)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921500, Boolean.TRUE));
                    return;
                }
                if ((view instanceof TbImageView) && (tbImageView = (TbImageView) view) != this.f14662f.s) {
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                    if (this.f14662f.s != null) {
                        if (!this.f14662f.t) {
                            this.f14662f.s.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                        } else {
                            this.f14662f.s.setForegroundColor(this.f14662f.getResources().getColor(R.color.common_color_10287));
                        }
                    }
                    this.f14662f.s = tbImageView;
                }
                this.f14662f.setCurrentTab(this.f14661e);
                this.f14662f.f14652i.a(this.f14661e);
            }
        }

        public f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14662f = emotionTabHorizonScrollView;
            this.f14661e = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f14650g = -1;
        this.q = true;
        m();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            this.f14649f.addView(this.m, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
            this.f14649f.setNewView(this.o);
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
                this.f14649f.setNewViewVisible(true);
            } else {
                this.f14649f.setNewViewVisible(false);
            }
            this.m.setOnClickListener(new b(this));
            this.r = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            this.r.setLayoutParams(layoutParams3);
            this.f14649f.addView(this.r);
            if (appResponseToIntentClass) {
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void j(d.a.p0.x.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            k(cVar);
        }
    }

    public final TbImageView k(d.a.p0.x.p.c cVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            d dVar = new d(null);
            dVar.f14658c = cVar;
            tbImageView.setAutoChangeStyle(false);
            dVar.f14656a = tbImageView;
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
                this.f14649f.addView(relativeLayout, this.f14649f.getChildCount() - 1, this.p);
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
                this.f14649f.addView(linearLayout, this.f14649f.getChildCount() - 1, this.p);
                EmotionGroupType h2 = cVar.h();
                if (h2 == EmotionGroupType.LOCAL) {
                    if (cVar.d() != null) {
                        cVar.d().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f14649f.getChildCount() - 3, null));
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
                        tbImageView.setOnClickListener(new f(this, this.f14649f.getChildCount() - 3, null));
                    } else {
                        if (cVar.e() != null) {
                            cVar.e().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new a(this));
                    }
                    tbImageView.setContentDescription(cVar.g());
                } else if (h2 == EmotionGroupType.USER_COLLECT) {
                    if (cVar.e() != null) {
                        cVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f14649f.getChildCount() - 3, null));
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
        return (TbImageView) invokeL.objValue;
    }

    public final boolean l(d.a.p0.x.p.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, cVar, z)) == null) {
            if (cVar == null) {
                return true;
            }
            if (z) {
                return false;
            }
            return cVar.h() == EmotionGroupType.BIG_EMOTION || cVar.h() == EmotionGroupType.PROMOTION;
        }
        return invokeLZ.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeAllViews();
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            EmotionLinearLayout emotionLinearLayout = new EmotionLinearLayout(getContext());
            this.f14649f = emotionLinearLayout;
            emotionLinearLayout.setOrientation(0);
            this.f14649f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f14649f.setBaselineAligned(false);
            addView(this.f14649f);
            this.j = getResources().getDimensionPixelSize(R.dimen.ds8);
            this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
            this.p = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
            this.f14649f.setPadding(0, 0, 0, 0);
            i();
        }
    }

    public void n(int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
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
            int childCount = this.f14649f.getChildCount();
            for (int i3 = 1; i3 < childCount; i3++) {
                View childAt = this.f14649f.getChildAt(i3);
                if (childAt != null) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i2);
                    d dVar = (d) childAt.getTag();
                    if (dVar != null) {
                        if (dVar.f14656a != null) {
                            if (i2 == 0) {
                                color = getResources().getColor(R.color.common_color_10287);
                            } else {
                                color = SkinManager.getColor(R.color.common_color_10287);
                            }
                            dVar.f14656a.setForegroundColor(color);
                        }
                        View view2 = dVar.f14657b;
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
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f14650g = -1;
            this.f14649f.removeAllViews();
            i();
            n(this.l);
        }
    }

    public void setCurrentTab(int i2) {
        int i3;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 == (i3 = this.f14650g)) {
            return;
        }
        if (i3 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f14649f.getChildAt(i3 + 1);
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
        this.f14650g = i2;
        LinearLayout linearLayout2 = (LinearLayout) this.f14649f.getChildAt(i2 + 1);
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
        d.a.p0.x.p.c cVar = this.f14651h.get(this.f14650g);
        if (cVar.d() != null) {
            cVar.d().h(tbImageView2);
        }
        if (tbImageView2 != null) {
            tbImageView2.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            this.s = tbImageView2;
        }
    }

    public void setDatas(ArrayList<d.a.p0.x.p.c> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f14651h = arrayList;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.u = editorTools;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public void setIsInChat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.t = z;
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f14652i = cVar;
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            int childCount = this.f14649f.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f14649f.getChildAt(i2);
                if (childAt != null) {
                    if (l(childAt.getTag() instanceof d ? ((d) childAt.getTag()).f14658c : null, z)) {
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
    }

    public void setTabWidgetVisibility(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.q = z;
            int i3 = i2 + 1;
            int childCount = this.f14649f.getChildCount();
            int i4 = i3 - 1;
            d.a.p0.x.p.c cVar = this.f14651h.get(i4);
            if (i3 < childCount) {
                if (cVar.h() == EmotionGroupType.BIG_EMOTION || cVar.h() == EmotionGroupType.USER_COLLECT) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) this.f14649f.getChildAt(i3)).getChildAt(0);
                    if (!this.q) {
                        tbImageView.setOnClickListener(new c(this));
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14650g = -1;
        this.q = true;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14650g = -1;
        this.q = true;
        m();
    }
}
