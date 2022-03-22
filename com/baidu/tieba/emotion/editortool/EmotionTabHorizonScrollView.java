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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
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
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public EmotionLinearLayout f31785b;

    /* renamed from: c  reason: collision with root package name */
    public int f31786c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c.a.o0.w.p.d> f31787d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabWidgetView.c f31788e;

    /* renamed from: f  reason: collision with root package name */
    public int f31789f;

    /* renamed from: g  reason: collision with root package name */
    public int f31790g;

    /* renamed from: h  reason: collision with root package name */
    public int f31791h;
    public LinearLayout i;
    public ImageView j;
    public TextView k;
    public LinearLayout.LayoutParams l;
    public boolean m;
    public View n;
    public TbImageView o;
    public boolean p;
    public EditorTools q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHorizonScrollView a;

        public a(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.c(this.a.getContext(), this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0527)).q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHorizonScrollView a;

        public b(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.k != null) {
                    this.a.f31785b.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (this.a.q != null) {
                    this.a.q.A(new c.a.o0.w.a(2, 5, null));
                }
                if (l.z()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(this.a.getContext())));
                } else {
                    n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHorizonScrollView a;

        public c(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.c(this.a.getContext(), this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0527)).q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public View f31792b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.o0.w.p.d f31793c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f31794b;

        public /* synthetic */ e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, a aVar) {
            this(emotionTabHorizonScrollView, str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || c.a.d.f.m.b.e(this.a, 0) <= 0) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f31794b.getContext(), c.a.d.f.m.b.e(this.a, 0), 0)));
        }

        public e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31794b = emotionTabHorizonScrollView;
            this.a = str;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f31795b;

        public /* synthetic */ f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(emotionTabHorizonScrollView, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f31795b.q.n(5).b() && (((c.a.o0.w.p.d) this.f31795b.f31787d.get(this.a)).h() == EmotionGroupType.USER_COLLECT || ((c.a.o0.w.p.d) this.f31795b.f31787d.get(this.a)).h() == EmotionGroupType.BIG_EMOTION)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921500, Boolean.TRUE));
                    return;
                }
                if ((view instanceof TbImageView) && (tbImageView = (TbImageView) view) != this.f31795b.o) {
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                    if (this.f31795b.o != null) {
                        if (!this.f31795b.p) {
                            this.f31795b.o.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                        } else {
                            this.f31795b.o.setForegroundColor(this.f31795b.getResources().getColor(R.color.common_color_10287));
                        }
                    }
                    this.f31795b.o = tbImageView;
                }
                this.f31795b.setCurrentTab(this.a);
                this.f31795b.f31788e.a(this.a);
            }
        }

        public f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31795b = emotionTabHorizonScrollView;
            this.a = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31786c = -1;
        this.m = true;
        m();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.j = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageView imageView2 = this.j;
            int i = this.f31790g;
            int i2 = this.f31789f;
            imageView2.setPadding(i, i2, i, i2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.i = linearLayout;
            linearLayout.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05de));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.j.setLayoutParams(layoutParams);
            SkinManager.setImageResource(this.j, R.drawable.face_store, this.f31791h);
            this.i.addView(this.j);
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), -1);
            layoutParams2.gravity = 5;
            layoutParams2.weight = 0.0f;
            view.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(view, R.color.common_color_10288, this.f31791h);
            TextView textView = new TextView(getContext());
            this.k = textView;
            textView.setGravity(17);
            this.k.setTextSize(10.0f);
            this.k.setText("N");
            this.k.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f31785b.addView(this.i, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07022b), -1));
            this.f31785b.setNewView(this.k);
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
                this.f31785b.setNewViewVisible(true);
            } else {
                this.f31785b.setNewViewVisible(false);
            }
            this.i.setOnClickListener(new b(this));
            this.n = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            this.n.setLayoutParams(layoutParams3);
            this.f31785b.addView(this.n);
            if (appResponseToIntentClass) {
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void j(c.a.o0.w.p.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            k(dVar);
        }
    }

    public final TbImageView k(c.a.o0.w.p.d dVar) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            d dVar2 = new d(null);
            dVar2.f31793c = dVar;
            tbImageView.setAutoChangeStyle(false);
            dVar2.a = tbImageView;
            if (dVar.h() == EmotionGroupType.SINGLE_FORUM) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.addView(tbImageView);
                int i3 = this.f31790g;
                int i4 = this.f31789f;
                tbImageView.setPadding(i3, i4, i3, i4);
                ImageView imageView = new ImageView(getContext());
                SkinManager.setImageResource(imageView, R.drawable.icon_emotion_recommend);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, n.f(getContext(), R.dimen.obfuscated_res_0x7f070234), n.f(getContext(), R.dimen.obfuscated_res_0x7f070229));
                relativeLayout.addView(imageView, layoutParams);
                View view = new View(getContext());
                new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), -1).addRule(11);
                relativeLayout.setClickable(true);
                relativeLayout.setFocusable(true);
                relativeLayout.setTag(dVar2);
                this.f31785b.addView(relativeLayout, this.f31785b.getChildCount() - 1, this.l);
                if (dVar.e() != null) {
                    dVar.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new e(this, dVar.f(), null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04f6) + dVar.f());
                if (!this.p && ((i2 = this.f31791h) == 1 || i2 == 4)) {
                    view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                } else {
                    view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
                }
                if (this.o == null) {
                    this.o = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.f31791h);
            } else {
                LinearLayout linearLayout = new LinearLayout(getContext());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                layoutParams2.weight = 1.0f;
                tbImageView.setLayoutParams(layoutParams2);
                linearLayout.addView(tbImageView);
                int i5 = this.f31790g;
                int i6 = this.f31789f;
                tbImageView.setPadding(i5, i6, i5, i6);
                View view2 = new View(getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), -1);
                layoutParams3.gravity = 5;
                layoutParams3.weight = 0.0f;
                linearLayout.setClickable(true);
                linearLayout.setFocusable(true);
                linearLayout.setTag(dVar2);
                this.f31785b.addView(linearLayout, this.f31785b.getChildCount() - 1, this.l);
                EmotionGroupType h2 = dVar.h();
                if (h2 == EmotionGroupType.LOCAL) {
                    if (dVar.d() != null) {
                        dVar.d().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f31785b.getChildCount() - 3, null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a39));
                } else if (h2 == EmotionGroupType.PROMOTION) {
                    if (dVar.e() != null) {
                        dVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, dVar.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04f5) + dVar.f());
                } else if (h2 == EmotionGroupType.BIG_EMOTION) {
                    if (this.m) {
                        if (dVar.d() != null) {
                            dVar.d().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new f(this, this.f31785b.getChildCount() - 3, null));
                    } else {
                        if (dVar.e() != null) {
                            dVar.e().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new a(this));
                    }
                    tbImageView.setContentDescription(dVar.g());
                } else if (h2 == EmotionGroupType.USER_COLLECT) {
                    if (dVar.e() != null) {
                        dVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f31785b.getChildCount() - 3, null));
                    tbImageView.setContentDescription("");
                } else if (h2 == EmotionGroupType.SINGLE_FORUM) {
                    if (dVar.e() != null) {
                        dVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, dVar.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04f6) + dVar.f());
                }
                if (!this.p && ((i = this.f31791h) == 1 || i == 4)) {
                    view2.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                } else {
                    view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
                }
                if (this.o == null) {
                    this.o = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.f31791h);
            }
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final boolean l(c.a.o0.w.p.d dVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, dVar, z)) == null) {
            if (dVar == null) {
                return true;
            }
            if (z) {
                return false;
            }
            return dVar.h() == EmotionGroupType.BIG_EMOTION || dVar.h() == EmotionGroupType.PROMOTION;
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
            this.f31785b = emotionLinearLayout;
            emotionLinearLayout.setOrientation(0);
            this.f31785b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f31785b.setBaselineAligned(false);
            addView(this.f31785b);
            this.f31789f = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb);
            this.f31790g = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
            this.l = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070236), -1);
            this.f31785b.setPadding(0, 0, 0, 0);
            i();
        }
    }

    public void n(int i) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f31791h = i;
            ImageView imageView = this.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.face_store, i);
            }
            LinearLayout linearLayout = this.i;
            if (linearLayout != null) {
                SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, i);
                if (this.i.getChildCount() > 0) {
                    SkinManager.setBackgroundColor(this.i.getChildAt(1), R.color.common_color_10288, i);
                }
            }
            View view = this.n;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.bg_emotion_tab_horizonscrollview, i);
            }
            TextView textView = this.k;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i);
            }
            int childCount = this.f31785b.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                View childAt = this.f31785b.getChildAt(i2);
                if (childAt != null) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                    d dVar = (d) childAt.getTag();
                    if (dVar != null) {
                        if (dVar.a != null) {
                            if (i == 0) {
                                color = getResources().getColor(R.color.common_color_10287);
                            } else {
                                color = SkinManager.getColor(R.color.common_color_10287);
                            }
                            dVar.a.setForegroundColor(color);
                        }
                        View view2 = dVar.f31792b;
                        if (view2 != null) {
                            SkinManager.setBackgroundColor(view2, R.color.common_color_10288, i);
                        }
                    }
                }
            }
            TbImageView tbImageView = this.o;
            if (tbImageView != null) {
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                if (this.o.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.o.getParent()).setSelected(true);
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f31786c = -1;
            this.f31785b.removeAllViews();
            i();
            n(this.f31791h);
        }
    }

    public void setCurrentTab(int i) {
        int i2;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || i == (i2 = this.f31786c)) {
            return;
        }
        if (i2 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f31785b.getChildAt(i2 + 1);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (tbImageView != null) {
                if (this.f31791h == 0) {
                    color = getResources().getColor(R.color.common_color_10287);
                } else {
                    color = SkinManager.getColor(R.color.common_color_10287);
                }
                tbImageView.setForegroundColor(color);
            }
            linearLayout.setSelected(false);
        }
        this.f31786c = i;
        LinearLayout linearLayout2 = (LinearLayout) this.f31785b.getChildAt(i + 1);
        linearLayout2.setSelected(true);
        int[] iArr = new int[2];
        linearLayout2.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int width = linearLayout2.getWidth() + i3;
        if (i3 < 0) {
            scrollBy(i3, 0);
        }
        if (getParent() instanceof ViewGroup) {
            View findViewById = ((ViewGroup) getParent()).findViewById(R.id.obfuscated_res_0x7f09095b);
            int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
            if (width > width2) {
                scrollBy(width - width2, 0);
            }
        }
        TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
        c.a.o0.w.p.d dVar = this.f31787d.get(this.f31786c);
        if (dVar.d() != null) {
            dVar.d().h(tbImageView2);
        }
        if (tbImageView2 != null) {
            tbImageView2.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            this.o = tbImageView2;
        }
    }

    public void setDatas(ArrayList<c.a.o0.w.p.d> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f31787d = arrayList;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.q = editorTools;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    public void setIsInChat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f31788e = cVar;
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            int childCount = this.f31785b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f31785b.getChildAt(i);
                if (childAt != null) {
                    if (l(childAt.getTag() instanceof d ? ((d) childAt.getTag()).f31793c : null, z)) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                    }
                }
            }
            if (z && appResponseToIntentClass) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.m = z;
            int i2 = i + 1;
            int childCount = this.f31785b.getChildCount();
            int i3 = i2 - 1;
            c.a.o0.w.p.d dVar = this.f31787d.get(i3);
            if (i2 < childCount) {
                if (dVar.h() == EmotionGroupType.BIG_EMOTION || dVar.h() == EmotionGroupType.USER_COLLECT) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) this.f31785b.getChildAt(i2)).getChildAt(0);
                    if (!this.m) {
                        tbImageView.setOnClickListener(new c(this));
                        if (dVar.e() != null) {
                            dVar.e().h(tbImageView);
                            return;
                        }
                        return;
                    }
                    tbImageView.setOnClickListener(new f(this, i3, null));
                    if (dVar.d() != null) {
                        dVar.d().h(tbImageView);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31786c = -1;
        this.m = true;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31786c = -1;
        this.m = true;
        m();
    }
}
