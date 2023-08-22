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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.gn9;
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
public class gn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fm9 A;
    public m B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public o16 H;
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
    public fj9 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public RelativeLayout e;
    public ImageView f;
    public TbImageView g;
    public pk9 h;
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
        public final /* synthetic */ gn9 b;

        public a(gn9 gn9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gn9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.r(this.b.H);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(JavaTypesHelper.toLong(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.J(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(gn9 gn9Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, view2};
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
        public final /* synthetic */ gn9 a;

        public c(gn9 gn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn9Var;
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
        public final /* synthetic */ gn9 a;

        public d(gn9 gn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getContext() != null) {
                CommonStatisticUtils.staticNameplateOfUserLevel(2, 3, ((Integer) view2.getTag()).intValue());
                BrowserHelper.startWebActivity(this.a.a.getContext(), (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn9 a;

        public e(gn9 gn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn9Var;
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
        public final /* synthetic */ gn9 b;

        public f(gn9 gn9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gn9Var;
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
        public final /* synthetic */ zfa b;
        public final /* synthetic */ gn9 c;

        public g(gn9 gn9Var, MetaData metaData, zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, metaData, zfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gn9Var;
            this.a = metaData;
            this.b = zfaVar;
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
                    p26.a(this.c.a.getPageContext(), portrait, str2, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh9 a;
        public final /* synthetic */ zfa b;
        public final /* synthetic */ gn9 c;

        public h(gn9 gn9Var, yh9 yh9Var, zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, yh9Var, zfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gn9Var;
            this.a = yh9Var;
            this.b = zfaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ox5.d(this.a.l(), this.b.r().getPortrait(), "2", this.c.a.getContext());
                px5.c("c15281", this.a.l(), "2");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ gn9 b;

        public i(gn9 gn9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gn9Var;
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
        public final /* synthetic */ gn9 a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public j(gn9 gn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn9Var;
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
        public final /* synthetic */ gn9 b;

        public k(gn9 gn9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gn9Var;
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
        public final /* synthetic */ yh9 b;
        public final /* synthetic */ gn9 c;

        public l(gn9 gn9Var, MetaData metaData, yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, metaData, yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gn9Var;
            this.a = metaData;
            this.b = yh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null) {
                jm9.a(jm9.a, this.b.Q(), jm9.b, this.c.M, this.c.N, this.a.getUserId());
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
        public final /* synthetic */ gn9 d;

        public m(@NonNull gn9 gn9Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn9Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gn9Var;
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
                ea5 ea5Var = new ea5();
                ea5Var.u(R.color.CAM_X0302);
                this.b.setConfig(ea5Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zm9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            gn9.m.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this.d.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e29);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }
    }

    public gn9(PbFragment pbFragment, fj9 fj9Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, fj9Var, onClickListener};
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
        this.b = fj9Var;
        this.c = onClickListener;
        z();
    }

    public void u(yh9 yh9Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{yh9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (yh9Var != null && yh9Var.j) {
                this.f.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f.setVisibility(0);
                B(this.f);
            } else if (z && z2) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f08121f);
                this.f.setVisibility(0);
                B(this.f);
            } else if (z) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f08121d);
                this.f.setVisibility(0);
                B(this.f);
            } else if (z2) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f08121e);
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

    public final String w(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, zfaVar)) == null) {
            if (zfaVar != null && zfaVar.r() != null) {
                return zfaVar.r().getIpAddress();
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

    public void t(zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, zfaVar) == null) && zfaVar != null && this.g != null) {
            String f0 = zfaVar.f0();
            if (!StringUtils.isNull(f0)) {
                this.g.startLoad(f0, 10, false);
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
        if (di.isEmpty(metaData.getName_show())) {
            string = StringUtils.string(metaData.getUserName());
        } else {
            string = StringUtils.string(metaData.getName_show());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.q);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        nx5.c(measuredWidth, string, this.k, this.n, arrayList, this.r);
        px5.a(this.k, this.q, this.m, this.n, this.r, 1);
    }

    public final void S(zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, zfaVar) == null) && zfaVar != null && zfaVar.r() != null) {
            MetaData r = zfaVar.r();
            ArrayList<IconData> iconInfo = r.getIconInfo();
            UserIconBox userIconBox = this.r;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, r.getUserId());
                if (this.a.d0() != null) {
                    this.r.setOnClickListener(this.a.d0().c.c);
                }
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.r.g(iconInfo, 4, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.r.setAutoChangedStyle(true);
                B(this.r);
            }
        }
    }

    public void F(yh9 yh9Var, zfa zfaVar, boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{yh9Var, zfaVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && yh9Var != null && zfaVar != null) {
            if (yh9Var != null) {
                str = yh9Var.Q();
            } else {
                str = "";
            }
            int u = gm9.u(yh9Var);
            if (z && zfaVar != null && zfaVar.r() != null) {
                zfaVar.r().setIsLike(zfaVar.r().hadConcerned());
            }
            if (this.A == null) {
                ThreadData O = yh9Var.O();
                int i2 = 1;
                if (O != null) {
                    if (O.isBJHArticleThreadType()) {
                        i2 = 4;
                    } else if (O.isBJHVideoThreadType()) {
                        i2 = 6;
                    } else if (O.isBJHVideoDynamicThreadType()) {
                        i2 = 7;
                    } else if (O.isBJHNormalThreadType()) {
                        i2 = 5;
                    } else if (O.isVideoWorksInfo()) {
                        i2 = 8;
                    }
                }
                fm9 fm9Var = new fm9(this.a.getPageContext(), this.y, i2);
                this.A = fm9Var;
                fm9Var.j(this.a.getUniqueId());
                this.A.t(O);
            }
            if (zfaVar != null && zfaVar.r() != null) {
                zfaVar.r().setIsLike(zfaVar.r().hadConcerned());
                this.A.l(zfaVar.r());
                this.A.x(str);
            }
            fm9 fm9Var2 = this.A;
            fm9Var2.p = z2;
            fm9Var2.u(u);
        }
    }

    public final void H(yh9 yh9Var, zfa zfaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, yh9Var, zfaVar) == null) {
            MetaData r = zfaVar.r();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView != null && this.u != null) {
                headCustomImageView.setVisibility(0);
                if (zfaVar.u0() != null) {
                    FrameLayout frameLayout = this.s;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.t.f(r);
                    VirtualImageCustomFigure u0 = zfaVar.u0();
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
                    if (zfaVar.v0() != null && !TextUtils.isEmpty(zfaVar.v0().getIcon())) {
                        this.u.setData(zfaVar.v0(), true, str);
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
                        this.M = jm9.d;
                        this.N = this.u.getData();
                    } else {
                        this.M = jm9.e;
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
                        headWorldCupFlagLayout.setPadding(0, BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds24), 0, 0);
                    }
                    this.t.setBigWidthAndHeight(BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds110), BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds144));
                }
                this.u.setOnClickListener(new k(this, r));
                this.t.setFrom(3);
                this.t.setOnClickListener(new l(this, r, yh9Var));
                y();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.d0() != null && this.a.d0().getIntent() != null && this.a.d0().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && SharedPrefHelper.getInstance().getInt(sharedPrefKeyWithAccount, 0) == 1 && !fo9.c(yh9Var) && (zfaVar.x() == null || !bg9.c())) {
                    this.I.setVisibility(0);
                    this.I.playAnimation();
                    SafeHandler.getInst().postDelayed(this.P, 4000L);
                }
                if (r != null) {
                    jm9.a(2, yh9Var.Q(), jm9.b, this.M, this.N, r.getUserId());
                }
            }
        }
    }

    public void J(zfa zfaVar, yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, zfaVar, yh9Var) == null) && zfaVar != null && yh9Var != null) {
            String str = null;
            if (zfaVar.h0() != null) {
                if (this.a.n6()) {
                    str = "FRS";
                }
                this.j.setData(this.a.getPageContext(), yh9Var.F().get(0).h0(), fga.a("PB", "c0132", yh9Var.k().getId(), yh9Var.k().getName(), yh9Var.O().getId(), str));
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
                return;
            }
            this.j.setData(null, null, null);
        }
    }

    public void P(zfa zfaVar, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, zfaVar, z) == null) {
            if (this.a.H0()) {
                this.L = 0;
                if (zfaVar != null && zfaVar.r() != null) {
                    this.L = zfaVar.r().getLevel_id();
                    str = zfaVar.r().getLevelName();
                } else {
                    str = "";
                }
                if (this.L > 0 && !z) {
                    this.n.setVisibility(0);
                    B(this.n);
                    if (zfaVar != null && zfaVar.r() != null) {
                        S(zfaVar);
                    }
                    this.n.setLevel(this.L, str);
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (zfaVar != null && zfaVar.r() != null) {
                S(zfaVar);
            }
        }
    }

    public void R(yh9 yh9Var, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, yh9Var, zfaVar) == null) && zfaVar != null && this.a != null && zfaVar.j0 != null && yh9Var.O() != null && yh9Var.O().getAuthor() != null) {
            MetaData author = yh9Var.O().getAuthor();
            this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
            PbContent A = TiePlusHelper.A(zfaVar.j0);
            if (A != null && A.tiebaplus_info != null) {
                o16 c2 = o16.c(A.type.intValue(), A.tiebaplus_info, yh9Var.O());
                this.H = c2;
                c2.p(TiePlusStat.RichTextType.MESSAGE);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.r(this.H);
                this.z.setVisibility(0);
                this.z.setOnClickListener(new a(this, author));
            }
        }
    }

    public void L(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, yh9Var) == null) {
            if (yh9Var != null && yh9Var.x0()) {
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703df);
                int paddingBottom = this.i.getPaddingBottom();
                if (yh9Var.j0()) {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), dimens, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (yh9Var != null && !yh9Var.O().isVideoThreadType() && yh9Var.j0() && (!StringUtils.isNull(yh9Var.O().getTitle()) || yh9Var.O().getSpan_str() != null)) {
                dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), dimens2, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public final void O(yh9 yh9Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, yh9Var) == null) && (tBLottieAnimationView = this.p) != null) {
            if (tBLottieAnimationView.getVisibility() != 0 && yh9Var != null && yh9Var.O() != null && yh9Var.O().getAuthor() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", yh9Var.l());
                statisticItem.param("fname", yh9Var.m());
                statisticItem.param("obj_param1", yh9Var.O().getAuthor().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", yh9Var.Q());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (yh9Var.O().getAuthor().getAlaInfo() != null) {
                    AlaInfoData alaInfo = yh9Var.O().getAuthor().getAlaInfo();
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

    public void N(int i2, yh9 yh9Var, zfa zfaVar, View.OnClickListener onClickListener) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), yh9Var, zfaVar, onClickListener}) == null) {
            if (zfaVar != null && zfaVar.r() != null) {
                MetaData r = zfaVar.r();
                if (r.getName_show() == null) {
                    StringUtils.string(r.getUserName());
                } else {
                    StringUtils.string(r.getName_show());
                }
                ArrayList<IconData> tShowInfoNew = r.getTShowInfoNew();
                if (this.q != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.q.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.d0() != null) {
                        this.q.setOnClickListener(this.a.d0().c.e);
                    }
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.q.h(tShowInfoNew, 3, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setTag(R.id.tag_user_id, r.getUserId());
                this.k.setTag(R.id.tag_user_name, r.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !r.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (yh9Var != null && yh9Var.j0()) {
                    this.l.setVisibility(8);
                } else if (r.getIs_bawu() == 1 && zfaVar.B0()) {
                    EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(zfaVar.p0()), "yyyy"))) {
                    this.C.setText(StringHelper.getFormatTimeShort(zfaVar.p0()));
                } else {
                    this.C.setText(StringHelper.getFormatTime(zfaVar.p0()));
                }
                if (yh9Var.j0()) {
                    this.D.setVisibility(8);
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(r);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo);
                    } else {
                        this.F.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(r);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo2);
                    } else {
                        this.F.setVisibility(8);
                    }
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    vg5 Z = zfaVar.Z();
                    String w = w(zfaVar);
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
                    if (zfaVar.u0() != null) {
                        H(yh9Var, zfaVar);
                    }
                }
                if (yh9Var.O().getAuthor() != null && yh9Var.O().getAuthor().getAlaInfo() != null && yh9Var.O().getAuthor().getAlaInfo().live_status == 1) {
                    O(yh9Var);
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
                    this.o.i(r);
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
                this.o.getHeadView().setUserId(r.getUserId());
                this.o.getHeadView().setUserName(r.getUserName());
                this.o.getHeadView().setTid(zfaVar.S());
                if (yh9Var != null) {
                    str = yh9Var.l();
                } else {
                    str = "";
                }
                this.o.getHeadView().setFid(str);
                this.o.getHeadView().setFName(yh9Var.m());
                this.o.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.o.m(r.getAvater());
                } else {
                    this.o.o(r);
                    this.o.setIsNeedAlpAnima(true);
                }
                String name_show = r.getName_show();
                String userName = r.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(cg9.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, cg9.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && r.getUserGrowthData() != null) {
                    int a2 = r.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.m.setImageResource(dx.b(a2));
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
                        this.J.setOnClickListener(new g(this, r, zfaVar));
                        String a3 = dy5.a("https://tieba.baidu.com/mo/q/hybrid-main-activity/worldcupPortrait?support_cache=1&thrown_flag_portrait=");
                        if (a3 != null) {
                            dy5.d(TbadkCoreApplication.getInst(), a3, null);
                        }
                    }
                    HeadWorldCupFlagLayout headWorldCupFlagLayout = this.K;
                    if (headWorldCupFlagLayout != null) {
                        headWorldCupFlagLayout.b(r);
                    }
                }
                s(r);
            }
            if (yh9Var != null) {
                this.h.e(yh9Var.O());
            }
            this.n.setOnClickListener(new h(this, yh9Var, zfaVar));
        }
    }

    public void Q(yh9 yh9Var, zfa zfaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048592, this, yh9Var, zfaVar, z) == null) && yh9Var != null && zfaVar != null) {
            if (3 != yh9Var.f()) {
                this.y.setVisibility(0);
                B(this.y);
            }
            if (z) {
                this.y.setVisibility(8);
                if (yh9Var != null && yh9Var.O() != null && yh9Var.O().getBaijiahaoData() != null && yh9Var.O().getBaijiahaoData().oriUgcType == 3) {
                    this.B.g(8);
                } else if (yh9Var.O() != null && yh9Var.O().isQuestionThread()) {
                    this.B.g(8);
                } else {
                    this.B.g(0);
                }
                this.B.a(yh9Var.Q());
                this.B.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(yh9Var.P())));
            } else if (PbNormalLikeButtonSwitch.getIsOn() && !zfaVar.r().hadConcerned() && (yh9Var.O() == null || !yh9Var.O().isQuestionThread())) {
                this.B.g(8);
            } else {
                this.y.setVisibility(8);
                this.B.g(8);
            }
            if (yh9Var.i || 3 == yh9Var.f()) {
                this.y.setVisibility(8);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.I = new TBLottieAnimationView(this.e.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds650), BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds110), 0, 0, BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds10));
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
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0708, (ViewGroup) null);
            this.e = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091b52);
            this.f = imageView;
            imageView.getLayoutParams().height = gm9.s();
            this.g = (TbImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091b4e);
            pk9 pk9Var = new pk9(this.a.getBaseFragmentActivity(), this.e);
            this.h = pk9Var;
            pk9Var.a();
            pk9 pk9Var2 = this.h;
            pk9Var2.c(pk9Var2.d(), this.c);
            this.i = (ColumnLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.j = (ThreadSkinView) this.e.findViewById(R.id.obfuscated_res_0x7f091b4f);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091aed);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090b7f);
            this.n = (TbLevelView) this.i.findViewById(R.id.forum_level_view);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091aea);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090842);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.e.findViewById(R.id.virtual_image_status_tip);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f091b2d);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f091aeb);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f092206);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f092207);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091aec);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091ac0);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f091aff);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091b06);
            this.B = new m(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b68), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091b69));
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091af6);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091af5);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091af3);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091af4);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091ac3);
            this.J = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091ac4);
            this.K = (HeadWorldCupFlagLayout) this.i.findViewById(R.id.world_cup_flag);
            x();
        }
    }
}
