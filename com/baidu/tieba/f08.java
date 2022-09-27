package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.f08;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.t16;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbContent;
import tbclient.PluginUser;
/* loaded from: classes4.dex */
public class f08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kz7 A;
    public h B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public pl5 H;
    public int I;
    public int J;
    public String K;
    public final View.OnClickListener L;
    public PbFragment a;
    public lw7 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public x36 e;
    public RelativeLayout f;
    public ImageView g;
    public tx7 h;
    public ColumnLayout i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public ImageView n;
    public HeadPendantView o;
    public TBLottieAnimationView p;
    public UserIconBox q;
    public UserIconBox r;
    public FrameLayout s;
    public HeadCustomImageView t;
    public VirtualImageStatusTip u;
    public LinearLayout v;
    public LinearLayout w;
    public ClickableHeaderImageView x;
    public PbFirstFloorUserLikeButton y;
    public PbFirstFloorMessageButton z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public a(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.a.getContext() == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 3, ((Integer) view2.getTag()).intValue());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a.getContext(), null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f08 b;

        public b(f08 f08Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.b.w.getMeasuredWidth();
                int measuredWidth2 = this.b.C.getMeasuredWidth();
                int measuredWidth3 = this.b.F.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i2 = this.a;
                if (i < i2) {
                    this.b.E.setVisibility(8);
                    this.b.D.setVisibility(8);
                } else if (i - i2 < dimenPixelSize) {
                    this.b.D.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ f08 b;

        public c(f08 f08Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.w(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ jv7 b;
        public final /* synthetic */ f08 c;

        public d(f08 f08Var, MetaData metaData, jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, metaData, jv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f08Var;
            this.a = metaData;
            this.b = jv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.w(this.a);
                pz7.a(pz7.a, this.b.Q(), pz7.b, this.c.J, this.c.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ f08 b;

        public e(f08 f08Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.n(this.b.H);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(dh.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.x(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public f(f08 f08Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public g(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.playAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ f08 d;

        public h(@NonNull f08 f08Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f08Var;
            this.a = textView;
            this.b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c = str;
            }
        }

        @NonNull
        public final TiebaPlusConfigData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? TiebaPlusConfigData.DEFAULT : tiebaPlusConfigData;
            }
            return (TiebaPlusConfigData) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ny4 ny4Var = new ny4();
                ny4Var.r(R.color.CAM_X0302);
                this.b.setConfig(ny4Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yz7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            f08.h.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                ej.M(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0c59);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.b.l(i);
                } else {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().isSwitchOpen()) {
                    this.b.setText(charSequence.toString());
                } else {
                    this.a.setText(charSequence);
                }
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.b.setVisibility(i);
                    this.a.setVisibility(8);
                    return;
                }
                this.b.setVisibility(8);
                this.a.setVisibility(i);
            }
        }
    }

    public f08(PbFragment pbFragment, lw7 lw7Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, lw7Var, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.f = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.s = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = 0;
        this.J = 0;
        this.K = null;
        this.L = new a(this);
        this.a = pbFragment;
        this.b = lw7Var;
        this.c = onClickListener;
        v();
    }

    public void A(jv7 jv7Var, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jv7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || jv7Var == null || postData == null) {
            return;
        }
        String Q = jv7Var != null ? jv7Var.Q() : "";
        int k = lz7.k(jv7Var);
        if (z && postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
        }
        if (this.A == null) {
            ThreadData O = jv7Var.O();
            int i = 1;
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    i = 4;
                } else if (O.isBJHVideoThreadType()) {
                    i = 6;
                } else if (O.isBJHVideoDynamicThreadType()) {
                    i = 7;
                } else if (O.isBJHNormalThreadType()) {
                    i = 5;
                } else if (O.isVideoWorksInfo()) {
                    i = 8;
                }
            }
            kz7 kz7Var = new kz7(this.a.getPageContext(), this.y, i);
            this.A = kz7Var;
            kz7Var.l(this.a.getUniqueId());
            this.A.v(O);
        }
        if (postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
            this.A.n(postData.s());
            this.A.x(Q);
        }
        kz7 kz7Var2 = this.A;
        kz7Var2.p = z2;
        kz7Var2.w(k);
    }

    public void B(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f);
    }

    public final void C(jv7 jv7Var, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jv7Var, postData) == null) {
            MetaData s = postData.s();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView == null || this.u == null) {
                return;
            }
            headCustomImageView.setVisibility(0);
            if (postData.j0() != null) {
                FrameLayout frameLayout = this.s;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                this.t.d(s);
                VirtualImageCustomFigure j0 = postData.j0();
                this.t.setHeadImageViewResource(j0.getFigureUrl());
                this.t.setHeadImageBackgroundColorResource(j0.getBackgroundValue());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(j0.getBackGroundType())) {
                    str = j0.getBackgroundValue();
                } else {
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(j0.getBackGroundType())) {
                        this.t.setHeadImageBackgroundResource(j0.getBackgroundValue());
                    }
                    str = "#7F66FE";
                }
                PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
                if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    this.y.setLayoutParams(marginLayoutParams);
                }
                if (postData.k0() != null && !TextUtils.isEmpty(postData.k0().b())) {
                    w45 k0 = postData.k0();
                    this.u.setData(k0.b(), k0.a(), str);
                    this.u.setVisibility(0);
                    LinearLayout linearLayout = this.v;
                    if (linearLayout != null && linearLayout.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                        marginLayoutParams2.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams2.topMargin, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams2.bottomMargin);
                        this.v.setLayoutParams(marginLayoutParams2);
                    }
                    LinearLayout linearLayout2 = this.w;
                    if (linearLayout2 != null && linearLayout2.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                        marginLayoutParams3.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.bottomMargin);
                        this.w.setLayoutParams(marginLayoutParams3);
                    }
                    this.u.setNotNeedAnimate();
                    this.J = pz7.d;
                    this.K = this.u.getData();
                } else {
                    this.J = pz7.e;
                    this.u.setVisibility(8);
                    LinearLayout linearLayout3 = this.v;
                    if (linearLayout3 != null && linearLayout3.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                        marginLayoutParams4.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams4.bottomMargin);
                        this.v.setLayoutParams(marginLayoutParams4);
                    }
                    LinearLayout linearLayout4 = this.w;
                    if (linearLayout4 != null && linearLayout4.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                        marginLayoutParams5.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams5.bottomMargin);
                        this.w.setLayoutParams(marginLayoutParams5);
                    }
                }
                this.t.setBigWidthAndHeight(ej.f(TbadkApplication.getInst(), R.dimen.tbds110), ej.f(TbadkApplication.getInst(), R.dimen.tbds144));
            }
            this.u.setOnClickListener(new c(this, s));
            this.t.setOnClickListener(new d(this, s, jv7Var));
            pz7.a(2, jv7Var.Q(), pz7.b, this.J, this.K);
        }
    }

    public void D(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void E(PostData postData, jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, postData, jv7Var) == null) || postData == null || jv7Var == null) {
            return;
        }
        if (postData.Y() != null) {
            this.j.setData(this.a.getPageContext(), jv7Var.F().get(0).Y(), pn8.a("PB", "c0132", jv7Var.l().getId(), jv7Var.l().getName(), jv7Var.O().getId(), this.a.i6() ? "FRS" : null));
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h.g(z);
        }
    }

    public void G(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jv7Var) == null) {
            if (jv7Var != null && jv7Var.u0()) {
                int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c5);
                int paddingBottom = this.i.getPaddingBottom();
                if (jv7Var.i0()) {
                    f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), f2, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (jv7Var != null && !jv7Var.O().isVideoThreadType() && jv7Var.i0() && (!StringUtils.isNull(jv7Var.O().getTitle()) || jv7Var.O().getSpan_str() != null)) {
                f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), f3, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void I(int i, jv7 jv7Var, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), jv7Var, postData, onClickListener}) == null) {
            if (postData != null && postData.s() != null) {
                MetaData s = postData.s();
                String string = s.getName_show() == null ? StringUtils.string(s.getUserName()) : StringUtils.string(s.getName_show());
                int byteLength = !StringUtils.isNull(postData.s().getSealPrefix()) ? dj.byteLength(s.getSealPrefix()) + 2 : 0;
                if (jv7Var == null || jv7Var.O() == null || !jv7Var.O().isQuestionThread()) {
                    if (byteLength > 0) {
                        if (dj.byteLength(string) > 12) {
                            string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                        }
                    } else if (dj.byteLength(string) > 14) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    }
                } else if (dj.byteLength(string) > 20) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 20, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> tShowInfoNew = s.getTShowInfoNew();
                if (this.q != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.q.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.P() != null) {
                        this.q.setOnClickListener(this.a.P().d.e);
                    }
                    int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.q.h(tShowInfoNew, 3, f2, f2, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(t(s.getSealPrefix(), string));
                this.k.setTag(R.id.obfuscated_res_0x7f092091, s.getUserId());
                this.k.setTag(R.id.obfuscated_res_0x7f092099, s.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !s.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (jv7Var.i0()) {
                    this.l.setVisibility(8);
                } else if (s.getIs_bawu() == 1 && postData.p0()) {
                    hv4 d2 = hv4.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.obfuscated_res_0x7f0f0346);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02ff);
                    this.l.setVisibility(0);
                    hv4 d3 = hv4.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0300);
                    this.l.setVisibility(0);
                    hv4 d4 = hv4.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
                    this.C.setText(StringHelper.getFormatTimeShort(postData.f0()));
                } else {
                    this.C.setText(StringHelper.getFormatTime(postData.f0()));
                }
                if (jv7Var.i0()) {
                    this.D.setVisibility(8);
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo);
                    } else {
                        this.F.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo2);
                    } else {
                        this.F.setVisibility(8);
                    }
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    j45 S = postData.S();
                    String r = r(postData);
                    if (!TextUtils.isEmpty(r)) {
                        this.D.setVisibility(0);
                        this.D.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150a) + r);
                    } else if (S != null && !TextUtils.isEmpty(S.b()) && !TextUtils.isEmpty(S.b().trim())) {
                        this.D.setVisibility(0);
                        this.D.setText(S.b());
                    } else {
                        this.D.setVisibility(8);
                    }
                    if (S != null && !TextUtils.isEmpty(S.a()) && TextUtils.isEmpty(r)) {
                        this.E.setText(S.a());
                        this.E.setVisibility(0);
                        this.w.post(new b(this, (int) this.E.getPaint().measureText(S.a(), 0, S.a().length())));
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (postData.j0() != null) {
                        C(jv7Var, postData);
                    }
                }
                if (jv7Var.O().getAuthor() == null || jv7Var.O().getAuthor().getAlaInfo() == null || jv7Var.O().getAuthor().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    J(jv7Var);
                    z = true;
                }
                this.o.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.o.j(s, 4);
                    this.o.setIsclearmode(false);
                } else {
                    this.o.setIsclearmode(true);
                }
                this.o.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.x;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.o.getHeadView().setUserId(s.getUserId());
                this.o.getHeadView().setUserName(s.getUserName());
                this.o.getHeadView().setTid(postData.L());
                this.o.getHeadView().setFid(jv7Var != null ? jv7Var.m() : "");
                this.o.getHeadView().setFName(jv7Var.n());
                this.o.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.o.l(s.getAvater());
                } else {
                    this.o.n(s);
                    this.o.setIsNeedAlpAnima(true);
                }
                String name_show = s.getName_show();
                String userName = s.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(ju7.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.obfuscated_res_0x7f092066, ju7.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && s.getUserGrowthData() != null) {
                    int a2 = s.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.m.setImageResource(kx.b(a2));
                        this.m.setVisibility(0);
                        this.m.setTag(Integer.valueOf(a2));
                        this.m.setOnClickListener(this.L);
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 3, a2);
                    } else {
                        this.m.setVisibility(8);
                    }
                }
            }
            if (jv7Var != null) {
                this.h.f(jv7Var.O());
            }
        }
    }

    public final void J(jv7 jv7Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jv7Var) == null) || (tBLottieAnimationView = this.p) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && jv7Var != null && jv7Var.O() != null && jv7Var.O().getAuthor() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", jv7Var.m());
            statisticItem.param("fname", jv7Var.n());
            statisticItem.param("obj_param1", jv7Var.O().getAuthor().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", jv7Var.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (jv7Var.O().getAuthor().getAlaInfo() != null) {
                AlaInfoData alaInfo = jv7Var.O().getAuthor().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
        this.p.setVisibility(0);
        this.p.setSpeed(0.8f);
        this.p.loop(true);
        this.p.post(new g(this));
    }

    public void K(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, postData, z) == null) {
            if (this.a.u0()) {
                this.I = 0;
                if (postData != null && postData.s() != null) {
                    this.I = postData.s().getLevel_id();
                }
                if (this.I > 0 && !z) {
                    this.n.setVisibility(0);
                    x(this.n);
                    if (postData != null && postData.s() != null) {
                        N(postData);
                    }
                    SkinManager.setImageResource(this.n, BitmapHelper.getGradeResourceIdInEnterForum(this.I));
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (postData == null || postData.s() == null) {
                return;
            }
            N(postData);
        }
    }

    public void L(jv7 jv7Var, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048587, this, jv7Var, postData, z) == null) || jv7Var == null || postData == null) {
            return;
        }
        if (3 != jv7Var.g()) {
            this.y.setVisibility(0);
            x(this.y);
        }
        if (z) {
            this.y.setVisibility(8);
            if (jv7Var != null && jv7Var.O() != null && jv7Var.O().getBaijiahaoData() != null && jv7Var.O().getBaijiahaoData().oriUgcType == 3) {
                this.B.g(8);
            } else if (jv7Var.O() != null && jv7Var.O().isQuestionThread()) {
                this.B.g(8);
            } else {
                this.B.g(0);
            }
            this.B.a(jv7Var.Q());
            this.B.f(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e8c), StringHelper.numberUniformFormatExtra(jv7Var.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.s().hadConcerned() && (jv7Var.O() == null || !jv7Var.O().isQuestionThread())) {
            this.B.g(8);
        } else {
            this.y.setVisibility(8);
            this.B.g(8);
        }
        if (jv7Var.i || 3 == jv7Var.g()) {
            this.y.setVisibility(8);
        }
    }

    public void M(jv7 jv7Var, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, jv7Var, postData) == null) || postData == null || this.a == null || postData.h0 == null || jv7Var.O() == null || jv7Var.O().getAuthor() == null) {
            return;
        }
        MetaData author = jv7Var.O().getAuthor();
        this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
        PbContent r = TiePlusHelper.r(postData.h0);
        if (r == null || r.tiebaplus_info == null) {
            return;
        }
        pl5 c2 = pl5.c(r.type.intValue(), r.tiebaplus_info, jv7Var.O());
        this.H = c2;
        c2.p(TiePlusStat.RichTextType.MESSAGE);
        this.H.q(TiePlusStat.StatType.EXPOSE);
        this.G.n(this.H);
        this.z.setVisibility(0);
        this.z.setOnClickListener(new e(this, author));
    }

    public final void N(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        MetaData s = postData.s();
        ArrayList<IconData> iconInfo = s.getIconInfo();
        UserIconBox userIconBox = this.r;
        if (userIconBox != null) {
            userIconBox.setTag(R.id.obfuscated_res_0x7f092091, s.getUserId());
            if (this.a.P() != null) {
                this.r.setOnClickListener(this.a.P().d.c);
            }
            int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            this.r.g(iconInfo, 4, f2, f2, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.r.setAutoChangedStyle(true);
            x(this.r);
        }
    }

    public void m(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f);
    }

    public void n(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, bdTypeListView, i) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f, i);
    }

    public void o(jv7 jv7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{jv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (jv7Var != null && jv7Var.j) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f3a);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z && z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f7b);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f79);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f7a);
                this.g.setVisibility(0);
                x(this.g);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void p() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (x36Var = this.e) == null) {
            return;
        }
        x36Var.N();
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h.e() : (TextView) invokeV.objValue;
    }

    public final String r(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return null;
            }
            return postData.s().getIpAddress();
        }
        return (String) invokeL.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new t16.a(str));
            return t16.h(this.a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0644, (ViewGroup) null);
            this.f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091888);
            this.g = imageView;
            imageView.getLayoutParams().height = lz7.i();
            tx7 tx7Var = new tx7(this.a.getBaseFragmentActivity(), this.f);
            this.h = tx7Var;
            tx7Var.a();
            tx7 tx7Var2 = this.h;
            tx7Var2.d(tx7Var2.e(), this.c);
            this.i = (ColumnLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09182a);
            this.j = (ThreadSkinView) this.f.findViewById(R.id.obfuscated_res_0x7f091885);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091829);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090a0e);
            this.n = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090e27);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091826);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090753);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.f.findViewById(R.id.obfuscated_res_0x7f092607);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f091864);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f091827);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091ec6);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091ec7);
            this.v = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091828);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091800);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f09183a);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091841);
            this.B = new h(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0918a9), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f0918aa));
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091830);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09182e);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09182c);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09182d);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091803);
        }
    }

    public final void w(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, metaData) == null) {
            String str2 = null;
            if (metaData != null) {
                str2 = metaData.getUserId();
                str = metaData.getUserName();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), str2, str)));
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new f(this, view2));
            ofInt.start();
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            ImageView imageView = this.n;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.I));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.z;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.r(i);
            }
            TextView textView = this.D;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            h hVar = this.B;
            if (hVar != null) {
                hVar.e(i);
            }
            TextView textView3 = this.F;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
            TextView textView4 = this.E;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.p;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            UserIconBox userIconBox = this.r;
            if (userIconBox != null) {
                userIconBox.i(i);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            x36 x36Var = this.e;
            if (x36Var != null) {
                x36Var.N();
            }
            ColumnLayout columnLayout = this.i;
            if (columnLayout != null && this.x != null) {
                columnLayout.removeView(this.s);
                this.x = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.p;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }
}
