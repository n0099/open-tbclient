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
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.gl9;
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
public class gl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bk9 A;
    public m B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public vw5 H;
    public TBLottieAnimationView I;
    public int J;
    public int K;
    public String L;
    public final View.OnClickListener M;
    public Runnable N;
    public int O;
    public View.OnLayoutChangeListener P;
    public PbFragment a;
    public tg9 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public RelativeLayout e;
    public ImageView f;
    public TbImageView g;
    public ki9 h;
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
        public final /* synthetic */ gl9 b;

        public a(gl9 gl9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gl9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.q(this.b.H);
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

        public b(gl9 gl9Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, view2};
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
        public final /* synthetic */ gl9 a;

        public c(gl9 gl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl9Var;
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
        public final /* synthetic */ gl9 a;

        public d(gl9 gl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl9Var;
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
        public final /* synthetic */ gl9 a;

        public e(gl9 gl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl9Var;
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
        public final /* synthetic */ gl9 b;

        public f(gl9 gl9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gl9Var;
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
        public final /* synthetic */ ye9 a;
        public final /* synthetic */ pea b;
        public final /* synthetic */ gl9 c;

        public g(gl9 gl9Var, ye9 ye9Var, pea peaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, ye9Var, peaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gl9Var;
            this.a = ye9Var;
            this.b = peaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ts5.d(this.a.l(), this.b.t().getPortrait(), "2", this.c.a.getContext());
                us5.c("c15281", this.a.l(), "2");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ gl9 b;

        public h(gl9 gl9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gl9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) != null) || i3 - i <= 0) {
                return;
            }
            this.b.F(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ CharSequence b;

        public i(gl9 gl9Var, TextView textView, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, textView, charSequence};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
            this.b = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setText(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl9 a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public j(gl9 gl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl9Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.a.P != null) {
                    this.a.v.removeOnLayoutChangeListener(this.a.P);
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
        public final /* synthetic */ gl9 b;

        public k(gl9 gl9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gl9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.B(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ye9 b;
        public final /* synthetic */ gl9 c;

        public l(gl9 gl9Var, MetaData metaData, ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, metaData, ye9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gl9Var;
            this.a = metaData;
            this.b = ye9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null) {
                fk9.a(fk9.a, this.b.Q(), fk9.b, this.c.K, this.c.L, this.a.getUserId());
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                this.c.B(this.a);
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
        public final /* synthetic */ gl9 d;

        public m(@NonNull gl9 gl9Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gl9Var;
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
                a55 a55Var = new a55();
                a55Var.u(R.color.CAM_X0302);
                this.b.setConfig(a55Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zk9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            gl9.m.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this.d.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }
    }

    public gl9(PbFragment pbFragment, tg9 tg9Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, tg9Var, onClickListener};
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
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = new d(this);
        this.N = new e(this);
        this.O = 0;
        this.P = null;
        this.a = pbFragment;
        this.b = tg9Var;
        this.c = onClickListener;
        A();
    }

    public void u(ye9 ye9Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{ye9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ye9Var != null && ye9Var.j) {
                this.f.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f.setVisibility(0);
                C(this.f);
            } else if (z && z2) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f08123a);
                this.f.setVisibility(0);
                C(this.f);
            } else if (z) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f081238);
                this.f.setVisibility(0);
                C(this.f);
            } else if (z2) {
                this.f.setImageResource(R.drawable.obfuscated_res_0x7f081239);
                this.f.setVisibility(0);
                C(this.f);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void H(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.e);
        }
    }

    public void J(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.h.f(z);
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.i.setVisibility(i2);
        }
    }

    public void q(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.e);
        }
    }

    public void s(@NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, metaData) == null) && this.v != null && this.P == null) {
            h hVar = new h(this, metaData);
            this.P = hVar;
            this.v.addOnLayoutChangeListener(hVar);
            r();
        }
    }

    public final String x(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, peaVar)) == null) {
            if (peaVar != null && peaVar.t() != null) {
                return peaVar.t().getIpAddress();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d070d, (ViewGroup) null);
            this.e = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091b80);
            this.f = imageView;
            imageView.getLayoutParams().height = ck9.s();
            this.g = (TbImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091b7c);
            ki9 ki9Var = new ki9(this.a.getBaseFragmentActivity(), this.e);
            this.h = ki9Var;
            ki9Var.a();
            ki9 ki9Var2 = this.h;
            ki9Var2.c(ki9Var2.d(), this.c);
            this.i = (ColumnLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091b1c);
            this.j = (ThreadSkinView) this.e.findViewById(R.id.obfuscated_res_0x7f091b7d);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b1b);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090b87);
            this.n = (TbLevelView) this.i.findViewById(R.id.forum_level_view);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091b18);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090849);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.e.findViewById(R.id.virtual_image_status_tip);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f091b5b);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f091b19);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f092219);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f09221a);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091b1a);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091aef);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f091b2d);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091b34);
            this.B = new m(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b96), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091b97));
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b24);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b23);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b21);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091b22);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091af2);
            y();
        }
    }

    public final void B(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData) == null) {
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

    public final void C(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new b(this, view2));
            ofInt.start();
        }
    }

    public void t(pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, peaVar) == null) && peaVar != null && this.g != null) {
            String g0 = peaVar.g0();
            if (!StringUtils.isNull(g0)) {
                this.g.startLoad(g0, 10, false);
                this.g.setVisibility(0);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
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

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (linearLayout = this.v) == null) {
            return;
        }
        linearLayout.addOnAttachStateChangeListener(new j(this));
    }

    public final void v() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (textView = this.k) == null || textView.getWidth() != 0) {
            return;
        }
        textView.post(new i(this, textView, textView.getText()));
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.h.d();
        }
        return (TextView) invokeV.objValue;
    }

    public final void F(@NonNull MetaData metaData) {
        int measuredWidth;
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, metaData) != null) || this.O == (measuredWidth = this.v.getMeasuredWidth())) {
            return;
        }
        this.O = measuredWidth;
        if (ad.isEmpty(metaData.getName_show())) {
            string = StringUtils.string(metaData.getUserName());
        } else {
            string = StringUtils.string(metaData.getName_show());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.q);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        ss5.c(measuredWidth, string, this.k, this.n, arrayList, this.r);
        v();
        us5.a(this.k, this.q, this.m, this.n, this.r, 1);
    }

    public final void T(pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, peaVar) == null) && peaVar != null && peaVar.t() != null) {
            MetaData t = peaVar.t();
            ArrayList<IconData> iconInfo = t.getIconInfo();
            UserIconBox userIconBox = this.r;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, t.getUserId());
                if (this.a.l0() != null) {
                    this.r.setOnClickListener(this.a.l0().c.c);
                }
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.r.g(iconInfo, 4, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.r.setAutoChangedStyle(true);
                C(this.r);
            }
        }
    }

    public void G(ye9 ye9Var, pea peaVar, boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{ye9Var, peaVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && ye9Var != null && peaVar != null) {
            if (ye9Var != null) {
                str = ye9Var.Q();
            } else {
                str = "";
            }
            int u = ck9.u(ye9Var);
            if (z && peaVar != null && peaVar.t() != null) {
                peaVar.t().setIsLike(peaVar.t().hadConcerned());
            }
            if (this.A == null) {
                ThreadData O = ye9Var.O();
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
                bk9 bk9Var = new bk9(this.a.getPageContext(), this.y, i2);
                this.A = bk9Var;
                bk9Var.j(this.a.getUniqueId());
                this.A.t(O);
            }
            if (peaVar != null && peaVar.t() != null) {
                peaVar.t().setIsLike(peaVar.t().hadConcerned());
                this.A.l(peaVar.t());
                this.A.x(str);
            }
            bk9 bk9Var2 = this.A;
            bk9Var2.p = z2;
            bk9Var2.u(u);
        }
    }

    public final void I(ye9 ye9Var, pea peaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ye9Var, peaVar) == null) {
            MetaData t = peaVar.t();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView != null && this.u != null) {
                headCustomImageView.setVisibility(0);
                if (peaVar.v0() != null) {
                    FrameLayout frameLayout = this.s;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.t.f(t);
                    VirtualImageCustomFigure v0 = peaVar.v0();
                    this.t.setHeadImageViewResource(v0.getFigureUrl());
                    this.t.setHeadImageBackgroundColorResource(v0.getBackgroundValue());
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(v0.getBackGroundType())) {
                        str = v0.getBackgroundValue();
                    } else {
                        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(v0.getBackGroundType())) {
                            this.t.setHeadImageBackgroundResource(v0.getBackgroundValue());
                        }
                        str = "#7F66FE";
                    }
                    PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
                    if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        this.y.setLayoutParams(marginLayoutParams);
                    }
                    if (peaVar.w0() != null && !TextUtils.isEmpty(peaVar.w0().getIcon())) {
                        this.u.setData(peaVar.w0(), true, str);
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
                        this.K = fk9.d;
                        this.L = this.u.getData();
                    } else {
                        this.K = fk9.e;
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
                    this.t.setBigWidthAndHeight(BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds110), BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds144));
                }
                this.u.setOnClickListener(new k(this, t));
                this.t.setFrom(3);
                this.t.setOnClickListener(new l(this, t, ye9Var));
                z();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.l0() != null && this.a.l0().getIntent() != null && this.a.l0().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && SharedPrefHelper.getInstance().getInt(sharedPrefKeyWithAccount, 0) == 1 && !gm9.c(ye9Var) && (peaVar.y() == null || !bd9.c())) {
                    this.I.setVisibility(0);
                    this.I.playAnimation();
                    SafeHandler.getInst().postDelayed(this.N, 4000L);
                }
                if (t != null) {
                    fk9.a(2, ye9Var.Q(), fk9.b, this.K, this.L, t.getUserId());
                }
            }
        }
    }

    public void K(pea peaVar, ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, peaVar, ye9Var) == null) && peaVar != null && ye9Var != null) {
            String str = null;
            if (peaVar.i0() != null) {
                if (this.a.W6()) {
                    str = "FRS";
                }
                this.j.setData(this.a.getPageContext(), ye9Var.F().get(0).i0(), vea.a("PB", "c0132", ye9Var.k().getId(), ye9Var.k().getName(), ye9Var.O().getId(), str));
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
                return;
            }
            this.j.setData(null, null, null);
        }
    }

    public void Q(pea peaVar, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, peaVar, z) == null) {
            if (this.a.P0()) {
                this.J = 0;
                if (peaVar != null && peaVar.t() != null) {
                    this.J = peaVar.t().getLevel_id();
                    str = peaVar.t().getLevelName();
                } else {
                    str = "";
                }
                if (this.J > 0 && !z) {
                    this.n.setVisibility(0);
                    C(this.n);
                    if (peaVar != null && peaVar.t() != null) {
                        T(peaVar);
                    }
                    this.n.setLevel(this.J, str);
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (peaVar != null && peaVar.t() != null) {
                T(peaVar);
            }
        }
    }

    public void S(ye9 ye9Var, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, ye9Var, peaVar) == null) && peaVar != null && this.a != null && peaVar.r0 != null && ye9Var.O() != null && ye9Var.O().getAuthor() != null) {
            MetaData author = ye9Var.O().getAuthor();
            this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
            PbContent A = TiePlusHelper.A(peaVar.r0);
            if (A != null && A.tiebaplus_info != null) {
                vw5 c2 = vw5.c(A.type.intValue(), A.tiebaplus_info, ye9Var.O());
                this.H = c2;
                c2.p(TiePlusStat.RichTextType.MESSAGE);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.q(this.H);
                this.z.setVisibility(0);
                this.z.setOnClickListener(new a(this, author));
            }
        }
    }

    public void M(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ye9Var) == null) {
            if (ye9Var != null && ye9Var.x0()) {
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703df);
                int paddingBottom = this.i.getPaddingBottom();
                if (ye9Var.j0()) {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), dimens, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (ye9Var != null && !ye9Var.O().isVideoThreadType() && ye9Var.j0() && (!StringUtils.isNull(ye9Var.O().getTitle()) || ye9Var.O().getSpan_str() != null)) {
                dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), dimens2, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public final void P(ye9 ye9Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, ye9Var) == null) && (tBLottieAnimationView = this.p) != null) {
            if (tBLottieAnimationView.getVisibility() != 0 && ye9Var != null && ye9Var.O() != null && ye9Var.O().getAuthor() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", ye9Var.l());
                statisticItem.param("fname", ye9Var.m());
                statisticItem.param("obj_param1", ye9Var.O().getAuthor().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", ye9Var.Q());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (ye9Var.O().getAuthor().getAlaInfo() != null) {
                    AlaInfoData alaInfo = ye9Var.O().getAuthor().getAlaInfo();
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

    public void O(int i2, ye9 ye9Var, pea peaVar, View.OnClickListener onClickListener) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), ye9Var, peaVar, onClickListener}) == null) {
            if (peaVar != null && peaVar.t() != null) {
                MetaData t = peaVar.t();
                if (t.getName_show() == null) {
                    StringUtils.string(t.getUserName());
                } else {
                    StringUtils.string(t.getName_show());
                }
                ArrayList<IconData> tShowInfoNew = t.getTShowInfoNew();
                if (this.q != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.q.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.l0() != null) {
                        this.q.setOnClickListener(this.a.l0().c.e);
                    }
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.q.h(tShowInfoNew, 3, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setTag(R.id.tag_user_id, t.getUserId());
                this.k.setTag(R.id.tag_user_target_scheme, t.getTargetScheme());
                this.k.setTag(R.id.tag_user_name, t.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !t.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (ye9Var != null && ye9Var.j0()) {
                    this.l.setVisibility(8);
                } else if (t.getIs_bawu() == 1 && peaVar.C0()) {
                    EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(peaVar.q0()), "yyyy"))) {
                    this.C.setText(StringHelper.getFormatTimeShort(peaVar.q0()));
                } else {
                    this.C.setText(StringHelper.getFormatTime(peaVar.q0()));
                }
                if (ye9Var.j0()) {
                    this.D.setVisibility(8);
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(t);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo);
                    } else {
                        this.F.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(t);
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
                    yb5 a0 = peaVar.a0();
                    String x = x(peaVar);
                    if (!TextUtils.isEmpty(x)) {
                        this.D.setVisibility(0);
                        this.D.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + x);
                    } else if (a0 != null && !TextUtils.isEmpty(a0.b()) && !TextUtils.isEmpty(a0.b().trim())) {
                        this.D.setVisibility(0);
                        this.D.setText(a0.b());
                    } else {
                        this.D.setVisibility(8);
                    }
                    if (a0 != null && !TextUtils.isEmpty(a0.a()) && TextUtils.isEmpty(x)) {
                        this.E.setText(a0.a());
                        this.E.setVisibility(0);
                        this.w.post(new f(this, (int) this.E.getPaint().measureText(a0.a(), 0, a0.a().length())));
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (peaVar.v0() != null) {
                        I(ye9Var, peaVar);
                    }
                }
                if (ye9Var.O().getAuthor() != null && ye9Var.O().getAuthor().getAlaInfo() != null && ye9Var.O().getAuthor().getAlaInfo().live_status == 1) {
                    P(ye9Var);
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
                    this.o.i(t);
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
                this.o.getHeadView().setUserId(t.getUserId());
                this.o.getHeadView().setTargetScheme(t.getTargetScheme());
                this.o.getHeadView().setUserName(t.getUserName());
                this.o.getHeadView().setTid(peaVar.U());
                if (ye9Var != null) {
                    str = ye9Var.l();
                } else {
                    str = "";
                }
                this.o.getHeadView().setFid(str);
                this.o.getHeadView().setFName(ye9Var.m());
                this.o.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.o.m(t.getAvater());
                } else {
                    this.o.o(t);
                    this.o.setIsNeedAlpAnima(true);
                }
                String name_show = t.getName_show();
                String userName = t.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(cd9.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, cd9.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && t.getUserGrowthData() != null) {
                    int a2 = t.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.m.setImageResource(as.b(a2));
                        this.m.setVisibility(0);
                        this.m.setTag(Integer.valueOf(a2));
                        this.m.setOnClickListener(this.M);
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 3, a2);
                    } else {
                        this.m.setVisibility(8);
                    }
                }
                s(t);
            }
            if (ye9Var != null) {
                this.h.e(ye9Var.O());
            }
            this.n.setOnClickListener(new g(this, ye9Var, peaVar));
        }
    }

    public void R(ye9 ye9Var, pea peaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048593, this, ye9Var, peaVar, z) == null) && ye9Var != null && peaVar != null) {
            if (3 != ye9Var.f()) {
                this.y.setVisibility(0);
                C(this.y);
            }
            if (z) {
                this.y.setVisibility(8);
                if (ye9Var != null && ye9Var.O() != null && ye9Var.O().getBaijiahaoData() != null && ye9Var.O().getBaijiahaoData().oriUgcType == 3) {
                    this.B.g(8);
                } else if (ye9Var.O() != null && ye9Var.O().isQuestionThread()) {
                    this.B.g(8);
                } else {
                    this.B.g(0);
                }
                this.B.a(ye9Var.Q());
                this.B.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(ye9Var.P())));
            } else if (PbNormalLikeButtonSwitch.getIsOn() && !peaVar.t().hadConcerned() && (ye9Var.O() == null || !ye9Var.O().isQuestionThread())) {
                this.B.g(8);
            } else {
                this.y.setVisibility(8);
                this.B.g(8);
            }
            if (ye9Var.i || 3 == ye9Var.f()) {
                this.y.setVisibility(8);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.I = new TBLottieAnimationView(this.e.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds650), BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds110), 0, 0, BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds10));
            layoutParams.addRule(8, this.i.getId());
            this.e.addView(this.I, layoutParams);
            z();
            this.I.setVisibility(8);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.I != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.I.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.I.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.I, R.raw.lottie_reactions_guide_left);
        }
    }
}
