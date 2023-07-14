package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.text.TextUtils;
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
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.hk9;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
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
/* loaded from: classes6.dex */
public class hk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gj9 A;
    public m B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public m36 H;
    public TBLottieAnimationView I;
    public TbImageView J;
    public HeadWorldCupFlagLayout K;
    public int L;
    public int M;
    public String N;
    public final View.OnClickListener O;
    public Runnable P;
    public int Q;
    public View.OnLayoutChangeListener R;
    public PbFragment a;
    public gg9 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public RelativeLayout e;
    public ImageView f;
    public TbImageView g;
    public qh9 h;
    public ColumnLayout i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public TbLevelView n;
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ hk9 b;

        public a(hk9 hk9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.r(this.b.H);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(wg.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.z(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(hk9 hk9Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, view2};
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk9 a;

        public c(hk9 hk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk9 a;

        public d(hk9 hk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getContext() != null) {
                CommonStatisticUtils.staticNameplateOfUserLevel(2, 3, ((Integer) view2.getTag()).intValue());
                nx4.v(this.a.a.getContext(), null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk9 a;

        public e(hk9 hk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.I != null) {
                this.a.I.setVisibility(8);
                this.a.I.pauseAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ hk9 b;

        public f(hk9 hk9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk9Var;
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

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ hk9 c;

        public g(hk9 hk9Var, MetaData metaData, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, metaData, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hk9Var;
            this.a = metaData;
            this.b = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getPortrait() != null) {
                String portrait = this.a.getPortrait();
                String str2 = null;
                if (this.b.u0() != null) {
                    str2 = this.b.u0().getFigureUrl();
                    str = this.b.u0().getBackgroundValue();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(portrait)) {
                    p46.a(this.c.a.getPageContext(), portrait, str2, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze9 a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ hk9 c;

        public h(hk9 hk9Var, ze9 ze9Var, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, ze9Var, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hk9Var;
            this.a = ze9Var;
            this.b = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz5.d(this.a.l(), this.b.q().getPortrait(), "2", this.c.a.getContext());
                kz5.c("c15281", this.a.l(), "2");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ hk9 b;

        public i(hk9 hk9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) != null) || i3 - i <= 0) {
                return;
            }
            this.b.E(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk9 a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public j(hk9 hk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk9Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.a.R != null) {
                    this.a.v.removeOnLayoutChangeListener(this.a.R);
                }
                this.a.v.removeOnAttachStateChangeListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ hk9 b;

        public k(hk9 hk9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.A(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ze9 b;
        public final /* synthetic */ hk9 c;

        public l(hk9 hk9Var, MetaData metaData, ze9 ze9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, metaData, ze9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hk9Var;
            this.a = metaData;
            this.b = ze9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null) {
                kj9.a(kj9.a, this.b.P(), kj9.b, this.c.M, this.c.N, this.a.getUserId());
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                this.c.A(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ hk9 d;

        public m(@NonNull hk9 hk9Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk9Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hk9Var;
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
            if ((interceptable != null && interceptable.invokeL(1048581, this, charSequence) != null) || charSequence == null) {
                return;
            }
            if (b().isSwitchOpen()) {
                this.b.setText(charSequence.toString());
            } else {
                this.a.setText(charSequence);
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

        @NonNull
        public final TiebaPlusConfigData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                if (tiebaPlusConfigData == null) {
                    return TiebaPlusConfigData.DEFAULT;
                }
                return tiebaPlusConfigData;
            }
            return (TiebaPlusConfigData) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                hb5 hb5Var = new hb5();
                hb5Var.u(R.color.CAM_X0302);
                this.b.setConfig(hb5Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ak9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            hk9.m.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                yi.Q(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0e1f);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }
    }

    public hk9(PbFragment pbFragment, gg9 gg9Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, gg9Var, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
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
        this.L = 0;
        this.M = 0;
        this.N = null;
        this.O = new d(this);
        this.P = new e(this);
        this.Q = 0;
        this.R = null;
        this.a = pbFragment;
        this.b = gg9Var;
        this.c = onClickListener;
        z();
    }

    public void u(ze9 ze9Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{ze9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ze9Var != null && ze9Var.j) {
                this.f.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f.setVisibility(0);
                B(this.f);
            } else if (z && z2) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f081201);
                this.f.setVisibility(0);
                B(this.f);
            } else if (z) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f0811ff);
                this.f.setVisibility(0);
                B(this.f);
            } else if (z2) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f081200);
                this.f.setVisibility(0);
                B(this.f);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void G(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.e);
        }
    }

    public void I(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h.f(z);
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.i.setVisibility(i2);
        }
    }

    public void q(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.e);
        }
    }

    public void s(@NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, metaData) == null) && this.v != null && this.R == null) {
            i iVar = new i(this, metaData);
            this.R = iVar;
            this.v.addOnLayoutChangeListener(iVar);
            r();
        }
    }

    public final String w(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, ycaVar)) == null) {
            if (ycaVar != null && ycaVar.q() != null) {
                return ycaVar.q().getIpAddress();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void A(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) {
            String str2 = null;
            if (metaData != null) {
                str2 = metaData.getUserId();
                str = metaData.getUserName();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), str2, str)));
            }
        }
    }

    public final void B(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new b(this, view2));
            ofInt.start();
        }
    }

    public void t(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, ycaVar) == null) && ycaVar != null && this.g != null) {
            String f0 = ycaVar.f0();
            if (!StringUtils.isNull(f0)) {
                this.g.N(f0, 10, false);
                this.g.setVisibility(0);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            TbLevelView tbLevelView = this.n;
            if (tbLevelView != null) {
                tbLevelView.a();
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.onChangeSkinType(i2);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.z;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.onChangeSkinType(i2);
            }
            TextView textView = this.D;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            m mVar = this.B;
            if (mVar != null) {
                mVar.e(i2);
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
                userIconBox.i(i2);
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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

    public final void r() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (linearLayout = this.v) == null) {
            return;
        }
        linearLayout.addOnAttachStateChangeListener(new j(this));
    }

    public TextView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.h.d();
        }
        return (TextView) invokeV.objValue;
    }

    public final void E(@NonNull MetaData metaData) {
        int measuredWidth;
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, metaData) != null) || this.Q == (measuredWidth = this.v.getMeasuredWidth())) {
            return;
        }
        this.Q = measuredWidth;
        if (xi.isEmpty(metaData.getName_show())) {
            string = StringUtils.string(metaData.getUserName());
        } else {
            string = StringUtils.string(metaData.getName_show());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.q);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        iz5.c(measuredWidth, string, this.k, this.n, arrayList, this.r);
        kz5.a(this.k, this.q, this.m, this.n, this.r, 1);
    }

    public final void S(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, ycaVar) == null) && ycaVar != null && ycaVar.q() != null) {
            MetaData q = ycaVar.q();
            ArrayList<IconData> iconInfo = q.getIconInfo();
            UserIconBox userIconBox = this.r;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, q.getUserId());
                if (this.a.X() != null) {
                    this.r.setOnClickListener(this.a.X().c.c);
                }
                int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.r.g(iconInfo, 4, g2, g2, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.r.setAutoChangedStyle(true);
                B(this.r);
            }
        }
    }

    public void F(ze9 ze9Var, yca ycaVar, boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{ze9Var, ycaVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && ze9Var != null && ycaVar != null) {
            if (ze9Var != null) {
                str = ze9Var.P();
            } else {
                str = "";
            }
            int u = hj9.u(ze9Var);
            if (z && ycaVar != null && ycaVar.q() != null) {
                ycaVar.q().setIsLike(ycaVar.q().hadConcerned());
            }
            if (this.A == null) {
                ThreadData N = ze9Var.N();
                int i2 = 1;
                if (N != null) {
                    if (N.isBJHArticleThreadType()) {
                        i2 = 4;
                    } else if (N.isBJHVideoThreadType()) {
                        i2 = 6;
                    } else if (N.isBJHVideoDynamicThreadType()) {
                        i2 = 7;
                    } else if (N.isBJHNormalThreadType()) {
                        i2 = 5;
                    } else if (N.isVideoWorksInfo()) {
                        i2 = 8;
                    }
                }
                gj9 gj9Var = new gj9(this.a.getPageContext(), this.y, i2);
                this.A = gj9Var;
                gj9Var.j(this.a.getUniqueId());
                this.A.t(N);
            }
            if (ycaVar != null && ycaVar.q() != null) {
                ycaVar.q().setIsLike(ycaVar.q().hadConcerned());
                this.A.l(ycaVar.q());
                this.A.x(str);
            }
            gj9 gj9Var2 = this.A;
            gj9Var2.p = z2;
            gj9Var2.u(u);
        }
    }

    public final void H(ze9 ze9Var, yca ycaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, ze9Var, ycaVar) == null) {
            MetaData q = ycaVar.q();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView != null && this.u != null) {
                headCustomImageView.setVisibility(0);
                if (ycaVar.u0() != null) {
                    FrameLayout frameLayout = this.s;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.t.f(q);
                    VirtualImageCustomFigure u0 = ycaVar.u0();
                    this.t.setHeadImageViewResource(u0.getFigureUrl());
                    this.t.setHeadImageBackgroundColorResource(u0.getBackgroundValue());
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(u0.getBackGroundType())) {
                        str = u0.getBackgroundValue();
                    } else {
                        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(u0.getBackGroundType())) {
                            this.t.setHeadImageBackgroundResource(u0.getBackgroundValue());
                        }
                        str = "#7F66FE";
                    }
                    PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
                    if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        this.y.setLayoutParams(marginLayoutParams);
                    }
                    TbImageView tbImageView = this.J;
                    if (tbImageView != null && (tbImageView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.J.getLayoutParams();
                        marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                        this.J.setLayoutParams(marginLayoutParams2);
                    }
                    if (ycaVar.v0() != null && !TextUtils.isEmpty(ycaVar.v0().getIcon())) {
                        this.u.setData(ycaVar.v0(), true, str);
                        this.u.setVisibility(0);
                        LinearLayout linearLayout = this.v;
                        if (linearLayout != null && linearLayout.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                            marginLayoutParams3.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.topMargin, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.bottomMargin);
                            this.v.setLayoutParams(marginLayoutParams3);
                        }
                        LinearLayout linearLayout2 = this.w;
                        if (linearLayout2 != null && linearLayout2.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                            marginLayoutParams4.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams4.bottomMargin);
                            this.w.setLayoutParams(marginLayoutParams4);
                        }
                        this.u.setNotNeedAnimate();
                        this.M = kj9.d;
                        this.N = this.u.getData();
                    } else {
                        this.M = kj9.e;
                        this.u.setVisibility(8);
                        LinearLayout linearLayout3 = this.v;
                        if (linearLayout3 != null && linearLayout3.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                            marginLayoutParams5.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams5.bottomMargin);
                            this.v.setLayoutParams(marginLayoutParams5);
                        }
                        LinearLayout linearLayout4 = this.w;
                        if (linearLayout4 != null && linearLayout4.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                            marginLayoutParams6.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams6.bottomMargin);
                            this.w.setLayoutParams(marginLayoutParams6);
                        }
                    }
                    HeadWorldCupFlagLayout headWorldCupFlagLayout = this.K;
                    if (headWorldCupFlagLayout != null) {
                        headWorldCupFlagLayout.setPadding(0, yi.g(TbadkApplication.getInst(), R.dimen.tbds24), 0, 0);
                    }
                    this.t.setBigWidthAndHeight(yi.g(TbadkApplication.getInst(), R.dimen.tbds110), yi.g(TbadkApplication.getInst(), R.dimen.tbds144));
                }
                this.u.setOnClickListener(new k(this, q));
                this.t.setFrom(3);
                this.t.setOnClickListener(new l(this, q, ze9Var));
                y();
                String t = da5.t("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.X() != null && this.a.X().getIntent() != null && this.a.X().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && da5.p().q(t, 0) == 1 && !gl9.c(ze9Var) && (ycaVar.x() == null || !zd9.c())) {
                    this.I.setVisibility(0);
                    this.I.playAnimation();
                    zg.a().postDelayed(this.P, 4000L);
                }
                if (q != null) {
                    kj9.a(2, ze9Var.P(), kj9.b, this.M, this.N, q.getUserId());
                }
            }
        }
    }

    public void J(yca ycaVar, ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, ycaVar, ze9Var) == null) && ycaVar != null && ze9Var != null) {
            String str = null;
            if (ycaVar.h0() != null) {
                if (this.a.a6()) {
                    str = "FRS";
                }
                this.j.setData(this.a.getPageContext(), ze9Var.F().get(0).h0(), eda.a("PB", "c0132", ze9Var.k().getId(), ze9Var.k().getName(), ze9Var.N().getId(), str));
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
                return;
            }
            this.j.setData(null, null, null);
        }
    }

    public void P(yca ycaVar, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, ycaVar, z) == null) {
            if (this.a.z0()) {
                this.L = 0;
                if (ycaVar != null && ycaVar.q() != null) {
                    this.L = ycaVar.q().getLevel_id();
                    str = ycaVar.q().getLevelName();
                } else {
                    str = "";
                }
                if (this.L > 0 && !z) {
                    this.n.setVisibility(0);
                    B(this.n);
                    if (ycaVar != null && ycaVar.q() != null) {
                        S(ycaVar);
                    }
                    this.n.setLevel(this.L, str);
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (ycaVar != null && ycaVar.q() != null) {
                S(ycaVar);
            }
        }
    }

    public void R(ze9 ze9Var, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, ze9Var, ycaVar) == null) && ycaVar != null && this.a != null && ycaVar.j0 != null && ze9Var.N() != null && ze9Var.N().getAuthor() != null) {
            MetaData author = ze9Var.N().getAuthor();
            this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
            PbContent r = TiePlusHelper.r(ycaVar.j0);
            if (r != null && r.tiebaplus_info != null) {
                m36 c2 = m36.c(r.type.intValue(), r.tiebaplus_info, ze9Var.N());
                this.H = c2;
                c2.p(TiePlusStat.RichTextType.MESSAGE);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.r(this.H);
                this.z.setVisibility(0);
                this.z.setOnClickListener(new a(this, author));
            }
        }
    }

    public void L(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ze9Var) == null) {
            if (ze9Var != null && ze9Var.w0()) {
                int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703df);
                int paddingBottom = this.i.getPaddingBottom();
                if (ze9Var.i0()) {
                    g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (ze9Var != null && !ze9Var.N().isVideoThreadType() && ze9Var.i0() && (!StringUtils.isNull(ze9Var.N().getTitle()) || ze9Var.N().getSpan_str() != null)) {
                g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public final void O(ze9 ze9Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, ze9Var) == null) && (tBLottieAnimationView = this.p) != null) {
            if (tBLottieAnimationView.getVisibility() != 0 && ze9Var != null && ze9Var.N() != null && ze9Var.N().getAuthor() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", ze9Var.l());
                statisticItem.param("fname", ze9Var.m());
                statisticItem.param("obj_param1", ze9Var.N().getAuthor().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", ze9Var.P());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (ze9Var.N().getAuthor().getAlaInfo() != null) {
                    AlaInfoData alaInfo = ze9Var.N().getAuthor().getAlaInfo();
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
            this.p.post(new c(this));
        }
    }

    public void N(int i2, ze9 ze9Var, yca ycaVar, View.OnClickListener onClickListener) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), ze9Var, ycaVar, onClickListener}) == null) {
            if (ycaVar != null && ycaVar.q() != null) {
                MetaData q = ycaVar.q();
                if (q.getName_show() == null) {
                    StringUtils.string(q.getUserName());
                } else {
                    StringUtils.string(q.getName_show());
                }
                ArrayList<IconData> tShowInfoNew = q.getTShowInfoNew();
                if (this.q != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.q.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.X() != null) {
                        this.q.setOnClickListener(this.a.X().c.e);
                    }
                    int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.q.h(tShowInfoNew, 3, g2, g2, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setTag(R.id.tag_user_id, q.getUserId());
                this.k.setTag(R.id.tag_user_name, q.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !q.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (ze9Var != null && ze9Var.i0()) {
                    this.l.setVisibility(8);
                } else if (q.getIs_bawu() == 1 && ycaVar.B0()) {
                    d85 d2 = d85.d(this.l);
                    d2.x(R.color.CAM_X0101);
                    d2.o(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    d85 d3 = d85.d(this.l);
                    d3.x(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    d85 d4 = d85.d(this.l);
                    d4.x(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
                    this.C.setText(StringHelper.getFormatTimeShort(ycaVar.p0()));
                } else {
                    this.C.setText(StringHelper.getFormatTime(ycaVar.p0()));
                }
                if (ze9Var.i0()) {
                    this.D.setVisibility(8);
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(q);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo);
                    } else {
                        this.F.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(q);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo2);
                    } else {
                        this.F.setVisibility(8);
                    }
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    ci5 Z = ycaVar.Z();
                    String w = w(ycaVar);
                    if (!TextUtils.isEmpty(w)) {
                        this.D.setVisibility(0);
                        this.D.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + w);
                    } else if (Z != null && !TextUtils.isEmpty(Z.b()) && !TextUtils.isEmpty(Z.b().trim())) {
                        this.D.setVisibility(0);
                        this.D.setText(Z.b());
                    } else {
                        this.D.setVisibility(8);
                    }
                    if (Z != null && !TextUtils.isEmpty(Z.a()) && TextUtils.isEmpty(w)) {
                        this.E.setText(Z.a());
                        this.E.setVisibility(0);
                        this.w.post(new f(this, (int) this.E.getPaint().measureText(Z.a(), 0, Z.a().length())));
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (ycaVar.u0() != null) {
                        H(ze9Var, ycaVar);
                    }
                }
                if (ze9Var.N().getAuthor() != null && ze9Var.N().getAuthor().getAlaInfo() != null && ze9Var.N().getAuthor().getAlaInfo().live_status == 1) {
                    O(ze9Var);
                    z = true;
                } else {
                    z = false;
                }
                if (this.p.getVisibility() == 0) {
                    ColumnLayout columnLayout = this.i;
                    columnLayout.setPadding(columnLayout.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.tbds25));
                } else {
                    ColumnLayout columnLayout2 = this.i;
                    columnLayout2.setPadding(columnLayout2.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), this.i.getPaddingBottom());
                }
                this.o.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.o.i(q);
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
                this.o.getHeadView().setUserId(q.getUserId());
                this.o.getHeadView().setUserName(q.getUserName());
                this.o.getHeadView().setTid(ycaVar.S());
                if (ze9Var != null) {
                    str = ze9Var.l();
                } else {
                    str = "";
                }
                this.o.getHeadView().setFid(str);
                this.o.getHeadView().setFName(ze9Var.m());
                this.o.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.o.m(q.getAvater());
                } else {
                    this.o.o(q);
                    this.o.setIsNeedAlpAnima(true);
                }
                String name_show = q.getName_show();
                String userName = q.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(ae9.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, ae9.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && q.getUserGrowthData() != null) {
                    int a2 = q.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.m.setImageResource(by.b(a2));
                        this.m.setVisibility(0);
                        this.m.setTag(Integer.valueOf(a2));
                        this.m.setOnClickListener(this.O);
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 3, a2);
                    } else {
                        this.m.setVisibility(8);
                    }
                }
                if (WorldCupEnableSwitch.isOn()) {
                    TbImageView tbImageView = this.J;
                    if (tbImageView != null) {
                        tbImageView.setVisibility(0);
                        this.J.setImageResource(R.drawable.icon_mask_raise_flag_button);
                        this.J.setOnClickListener(new g(this, q, ycaVar));
                        String a3 = b06.a("https://tieba.baidu.com/mo/q/hybrid-main-activity/worldcupPortrait?support_cache=1&thrown_flag_portrait=");
                        if (a3 != null) {
                            b06.d(TbadkCoreApplication.getInst(), a3, null);
                        }
                    }
                    HeadWorldCupFlagLayout headWorldCupFlagLayout = this.K;
                    if (headWorldCupFlagLayout != null) {
                        headWorldCupFlagLayout.b(q);
                    }
                }
                s(q);
            }
            if (ze9Var != null) {
                this.h.e(ze9Var.N());
            }
            this.n.setOnClickListener(new h(this, ze9Var, ycaVar));
        }
    }

    public void Q(ze9 ze9Var, yca ycaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048592, this, ze9Var, ycaVar, z) == null) && ze9Var != null && ycaVar != null) {
            if (3 != ze9Var.f()) {
                this.y.setVisibility(0);
                B(this.y);
            }
            if (z) {
                this.y.setVisibility(8);
                if (ze9Var != null && ze9Var.N() != null && ze9Var.N().getBaijiahaoData() != null && ze9Var.N().getBaijiahaoData().oriUgcType == 3) {
                    this.B.g(8);
                } else if (ze9Var.N() != null && ze9Var.N().isQuestionThread()) {
                    this.B.g(8);
                } else {
                    this.B.g(0);
                }
                this.B.a(ze9Var.P());
                this.B.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(ze9Var.O())));
            } else if (PbNormalLikeButtonSwitch.getIsOn() && !ycaVar.q().hadConcerned() && (ze9Var.N() == null || !ze9Var.N().isQuestionThread())) {
                this.B.g(8);
            } else {
                this.y.setVisibility(8);
                this.B.g(8);
            }
            if (ze9Var.i || 3 == ze9Var.f()) {
                this.y.setVisibility(8);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.I = new TBLottieAnimationView(this.e.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.g(this.e.getContext(), R.dimen.tbds650), yi.g(this.e.getContext(), R.dimen.tbds100));
            layoutParams.setMargins(yi.g(this.e.getContext(), R.dimen.tbds110), 0, 0, yi.g(this.e.getContext(), R.dimen.tbds10));
            layoutParams.addRule(8, this.i.getId());
            this.e.addView(this.I, layoutParams);
            y();
            this.I.setVisibility(8);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.I != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.I.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.I.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.I, R.raw.lottie_reactions_guide_left);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06fc, (ViewGroup) null);
            this.e = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091b13);
            this.f = imageView;
            imageView.getLayoutParams().height = hj9.s();
            this.g = (TbImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091b0f);
            qh9 qh9Var = new qh9(this.a.getBaseFragmentActivity(), this.e);
            this.h = qh9Var;
            qh9Var.a();
            qh9 qh9Var2 = this.h;
            qh9Var2.c(qh9Var2.d(), this.c);
            this.i = (ColumnLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091ab0);
            this.j = (ThreadSkinView) this.e.findViewById(R.id.obfuscated_res_0x7f091b10);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091aaf);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090b62);
            this.n = (TbLevelView) this.i.findViewById(R.id.forum_level_view);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091aac);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09082f);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.e.findViewById(R.id.virtual_image_status_tip);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f091aef);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f091aad);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f0921c2);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f0921c3);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091aae);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091a82);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f091ac1);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091ac8);
            this.B = new m(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b29), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091b2a));
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091ab8);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091ab7);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091ab5);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091ab6);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091a85);
            this.J = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091a86);
            this.K = (HeadWorldCupFlagLayout) this.i.findViewById(R.id.world_cup_flag);
            x();
        }
    }
}
