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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
import com.baidu.tieba.a28;
import com.baidu.tieba.k36;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
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
/* loaded from: classes3.dex */
public class a28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e18 A;
    public i B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public um5 H;
    public TBLottieAnimationView I;
    public int J;
    public int K;
    public String L;
    public final View.OnClickListener M;
    public Runnable N;
    public PbFragment a;
    public fy7 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public p56 e;
    public RelativeLayout f;
    public ImageView g;
    public nz7 h;
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
        public final /* synthetic */ a28 a;

        public a(a28 a28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getContext() != null) {
                CommonStatisticUtils.staticNameplateOfUserLevel(2, 3, ((Integer) view2.getTag()).intValue());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a.getContext(), null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a28 a;

        public b(a28 a28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a28Var;
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

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ a28 b;

        public c(a28 a28Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a28Var;
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

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ a28 b;

        public d(a28 a28Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a28Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.z(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ dx7 b;
        public final /* synthetic */ a28 c;

        public e(a28 a28Var, MetaData metaData, dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, metaData, dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a28Var;
            this.a = metaData;
            this.b = dx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null) {
                j18.a(j18.a, this.b.S(), j18.b, this.c.K, this.c.L, this.a.getUserId());
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                this.c.z(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ a28 b;

        public f(a28 a28Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a28Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.n(this.b.H);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(wg.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.x(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public g(a28 a28Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, view2};
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

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a28 a;

        public h(a28 a28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a28Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ a28 d;

        public i(@NonNull a28 a28Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a28Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a28Var;
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
                jz4 jz4Var = new jz4();
                jz4Var.r(R.color.CAM_X0302);
                this.b.setConfig(jz4Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.t18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            a28.i.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                xi.O(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0c7f);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }
    }

    public a28(PbFragment pbFragment, fy7 fy7Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, fy7Var, onClickListener};
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
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = new a(this);
        this.N = new b(this);
        this.a = pbFragment;
        this.b = fy7Var;
        this.c = onClickListener;
        y();
    }

    public void p(dx7 dx7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{dx7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (dx7Var != null && dx7Var.j) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f68);
                this.g.setVisibility(0);
                A(this.g);
            } else if (z && z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080fa9);
                this.g.setVisibility(0);
                A(this.g);
            } else if (z) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080fa7);
                this.g.setVisibility(0);
                A(this.g);
            } else if (z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080fa8);
                this.g.setVisibility(0);
                A(this.g);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void E(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f);
        }
    }

    public void G(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h.g(z);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.i.setVisibility(i2);
        }
    }

    public void n(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.f);
        }
    }

    public final String s(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, postData)) == null) {
            if (postData != null && postData.s() != null) {
                return postData.s().getIpAddress();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void o(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, bdTypeListView, i2) == null) && bdTypeListView != null) {
            bdTypeListView.x(this.f, i2);
        }
    }

    public final void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new g(this, view2));
            ofInt.start();
        }
    }

    public final void z(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, metaData) == null) {
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

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            ImageView imageView = this.n;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.J));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i2);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.z;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.r(i2);
            }
            TextView textView = this.D;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            i iVar = this.B;
            if (iVar != null) {
                iVar.e(i2);
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

    public final void Q(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, postData) == null) && postData != null && postData.s() != null) {
            MetaData s = postData.s();
            ArrayList<IconData> iconInfo = s.getIconInfo();
            UserIconBox userIconBox = this.r;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f0920dd, s.getUserId());
                if (this.a.P() != null) {
                    this.r.setOnClickListener(this.a.P().d.c);
                }
                int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.r.g(iconInfo, 4, g2, g2, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.r.setAutoChangedStyle(true);
                A(this.r);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p56 p56Var = this.e;
            if (p56Var != null) {
                p56Var.h();
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

    public void q() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (p56Var = this.e) != null) {
            p56Var.h();
        }
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.h.e();
        }
        return (TextView) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public SparseArray<Object> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
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

    public void D(dx7 dx7Var, PostData postData, boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{dx7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && dx7Var != null && postData != null) {
            if (dx7Var != null) {
                str = dx7Var.S();
            } else {
                str = "";
            }
            int v = f18.v(dx7Var);
            if (z && postData != null && postData.s() != null) {
                postData.s().setIsLike(postData.s().hadConcerned());
            }
            if (this.A == null) {
                ThreadData Q = dx7Var.Q();
                int i2 = 1;
                if (Q != null) {
                    if (Q.isBJHArticleThreadType()) {
                        i2 = 4;
                    } else if (Q.isBJHVideoThreadType()) {
                        i2 = 6;
                    } else if (Q.isBJHVideoDynamicThreadType()) {
                        i2 = 7;
                    } else if (Q.isBJHNormalThreadType()) {
                        i2 = 5;
                    } else if (Q.isVideoWorksInfo()) {
                        i2 = 8;
                    }
                }
                e18 e18Var = new e18(this.a.getPageContext(), this.y, i2);
                this.A = e18Var;
                e18Var.l(this.a.getUniqueId());
                this.A.v(Q);
            }
            if (postData != null && postData.s() != null) {
                postData.s().setIsLike(postData.s().hadConcerned());
                this.A.n(postData.s());
                this.A.x(str);
            }
            e18 e18Var2 = this.A;
            e18Var2.p = z2;
            e18Var2.w(v);
        }
    }

    public final void F(dx7 dx7Var, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dx7Var, postData) == null) {
            MetaData s = postData.s();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView != null && this.u != null) {
                headCustomImageView.setVisibility(0);
                if (postData.l0() != null) {
                    FrameLayout frameLayout = this.s;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.t.e(s);
                    VirtualImageCustomFigure l0 = postData.l0();
                    this.t.setHeadImageViewResource(l0.getFigureUrl());
                    this.t.setHeadImageBackgroundColorResource(l0.getBackgroundValue());
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(l0.getBackGroundType())) {
                        str = l0.getBackgroundValue();
                    } else {
                        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(l0.getBackGroundType())) {
                            this.t.setHeadImageBackgroundResource(l0.getBackgroundValue());
                        }
                        str = "#7F66FE";
                    }
                    PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
                    if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        this.y.setLayoutParams(marginLayoutParams);
                    }
                    if (postData.m0() != null && !TextUtils.isEmpty(postData.m0().getIcon())) {
                        this.u.setData(postData.m0(), true, str);
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
                        this.K = j18.d;
                        this.L = this.u.getData();
                    } else {
                        this.K = j18.e;
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
                    this.t.setBigWidthAndHeight(xi.g(TbadkApplication.getInst(), R.dimen.tbds110), xi.g(TbadkApplication.getInst(), R.dimen.tbds144));
                }
                this.u.setOnClickListener(new d(this, s));
                this.t.setFrom(3);
                this.t.setOnClickListener(new e(this, s, dx7Var));
                x();
                String o = ky4.o("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.P() != null && this.a.P().getIntent() != null && this.a.P().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && ky4.k().l(o, 0) == 1) {
                    this.I.setVisibility(0);
                    this.I.playAnimation();
                    zg.a().postDelayed(this.N, 4000L);
                }
                if (s != null) {
                    j18.a(2, dx7Var.S(), j18.b, this.K, this.L, s.getUserId());
                }
            }
        }
    }

    public void H(PostData postData, dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, postData, dx7Var) == null) && postData != null && dx7Var != null) {
            String str = null;
            if (postData.Z() != null) {
                if (this.a.P5()) {
                    str = "FRS";
                }
                this.j.setData(this.a.getPageContext(), dx7Var.H().get(0).Z(), fp8.a("PB", "c0132", dx7Var.l().getId(), dx7Var.l().getName(), dx7Var.Q().getId(), str));
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
                return;
            }
            this.j.setData(null, null, null);
        }
    }

    public void N(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, postData, z) == null) {
            if (this.a.t0()) {
                this.J = 0;
                if (postData != null && postData.s() != null) {
                    this.J = postData.s().getLevel_id();
                }
                if (this.J > 0 && !z) {
                    this.n.setVisibility(0);
                    A(this.n);
                    if (postData != null && postData.s() != null) {
                        Q(postData);
                    }
                    SkinManager.setImageResource(this.n, BitmapHelper.getGradeResourceIdInEnterForum(this.J));
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (postData != null && postData.s() != null) {
                Q(postData);
            }
        }
    }

    public void P(dx7 dx7Var, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, dx7Var, postData) == null) && postData != null && this.a != null && postData.h0 != null && dx7Var.Q() != null && dx7Var.Q().getAuthor() != null) {
            MetaData author = dx7Var.Q().getAuthor();
            this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
            PbContent r = TiePlusHelper.r(postData.h0);
            if (r != null && r.tiebaplus_info != null) {
                um5 c2 = um5.c(r.type.intValue(), r.tiebaplus_info, dx7Var.Q());
                this.H = c2;
                c2.p(TiePlusStat.RichTextType.MESSAGE);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.n(this.H);
                this.z.setVisibility(0);
                this.z.setOnClickListener(new f(this, author));
            }
        }
    }

    public void J(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dx7Var) == null) {
            if (dx7Var != null && dx7Var.y0()) {
                int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c5);
                int paddingBottom = this.i.getPaddingBottom();
                if (dx7Var.l0()) {
                    g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (dx7Var != null && !dx7Var.Q().isVideoThreadType() && dx7Var.l0() && (!StringUtils.isNull(dx7Var.Q().getTitle()) || dx7Var.Q().getSpan_str() != null)) {
                g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public final void M(dx7 dx7Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, dx7Var) == null) && (tBLottieAnimationView = this.p) != null) {
            if (tBLottieAnimationView.getVisibility() != 0 && dx7Var != null && dx7Var.Q() != null && dx7Var.Q().getAuthor() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", dx7Var.m());
                statisticItem.param("fname", dx7Var.n());
                statisticItem.param("obj_param1", dx7Var.Q().getAuthor().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", dx7Var.S());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (dx7Var.Q().getAuthor().getAlaInfo() != null) {
                    AlaInfoData alaInfo = dx7Var.Q().getAuthor().getAlaInfo();
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
            this.p.post(new h(this));
        }
    }

    public void L(int i2, dx7 dx7Var, PostData postData, View.OnClickListener onClickListener) {
        String string;
        int i3;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), dx7Var, postData, onClickListener}) == null) {
            if (postData != null && postData.s() != null) {
                MetaData s = postData.s();
                if (s.getName_show() == null) {
                    string = StringUtils.string(s.getUserName());
                } else {
                    string = StringUtils.string(s.getName_show());
                }
                if (!StringUtils.isNull(postData.s().getSealPrefix())) {
                    i3 = wi.byteLength(s.getSealPrefix()) + 2;
                } else {
                    i3 = 0;
                }
                if (dx7Var != null && dx7Var.Q() != null && dx7Var.Q().isQuestionThread()) {
                    if (wi.byteLength(string) > 20) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 20, StringHelper.STRING_MORE);
                    }
                } else if (i3 > 0) {
                    if (wi.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    }
                } else if (wi.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> tShowInfoNew = s.getTShowInfoNew();
                if (this.q != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.q.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.P() != null) {
                        this.q.setOnClickListener(this.a.P().d.e);
                    }
                    int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.q.h(tShowInfoNew, 3, g2, g2, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(u(s.getSealPrefix(), string));
                this.k.setTag(R.id.obfuscated_res_0x7f0920dd, s.getUserId());
                this.k.setTag(R.id.obfuscated_res_0x7f0920e5, s.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !s.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (dx7Var.l0()) {
                    this.l.setVisibility(8);
                } else if (s.getIs_bawu() == 1 && postData.r0()) {
                    kw4 d2 = kw4.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.obfuscated_res_0x7f0f0347);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0300);
                    this.l.setVisibility(0);
                    kw4 d3 = kw4.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0301);
                    this.l.setVisibility(0);
                    kw4 d4 = kw4.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.h0()), "yyyy"))) {
                    this.C.setText(StringHelper.getFormatTimeShort(postData.h0()));
                } else {
                    this.C.setText(StringHelper.getFormatTime(postData.h0()));
                }
                if (dx7Var.l0()) {
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
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    i55 T = postData.T();
                    String s2 = s(postData);
                    if (!TextUtils.isEmpty(s2)) {
                        this.D.setVisibility(0);
                        this.D.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1542) + s2);
                    } else if (T != null && !TextUtils.isEmpty(T.b()) && !TextUtils.isEmpty(T.b().trim())) {
                        this.D.setVisibility(0);
                        this.D.setText(T.b());
                    } else {
                        this.D.setVisibility(8);
                    }
                    if (T != null && !TextUtils.isEmpty(T.a()) && TextUtils.isEmpty(s2)) {
                        this.E.setText(T.a());
                        this.E.setVisibility(0);
                        this.w.post(new c(this, (int) this.E.getPaint().measureText(T.a(), 0, T.a().length())));
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (postData.l0() != null) {
                        F(dx7Var, postData);
                    }
                }
                if (dx7Var.Q().getAuthor() != null && dx7Var.Q().getAuthor().getAlaInfo() != null && dx7Var.Q().getAuthor().getAlaInfo().live_status == 1) {
                    M(dx7Var);
                    z = true;
                } else {
                    z = false;
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
                this.o.getHeadView().setTid(postData.M());
                if (dx7Var != null) {
                    str = dx7Var.m();
                } else {
                    str = "";
                }
                this.o.getHeadView().setFid(str);
                this.o.getHeadView().setFName(dx7Var.n());
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
                    this.k.setText(dw7.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.obfuscated_res_0x7f0920b1, dw7.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && s.getUserGrowthData() != null) {
                    int a2 = s.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.m.setImageResource(dx.b(a2));
                        this.m.setVisibility(0);
                        this.m.setTag(Integer.valueOf(a2));
                        this.m.setOnClickListener(this.M);
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 3, a2);
                    } else {
                        this.m.setVisibility(8);
                    }
                }
            }
            if (dx7Var != null) {
                this.h.f(dx7Var.Q());
            }
        }
    }

    public void O(dx7 dx7Var, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048590, this, dx7Var, postData, z) == null) && dx7Var != null && postData != null) {
            if (3 != dx7Var.g()) {
                this.y.setVisibility(0);
                A(this.y);
            }
            if (z) {
                this.y.setVisibility(8);
                if (dx7Var != null && dx7Var.Q() != null && dx7Var.Q().getBaijiahaoData() != null && dx7Var.Q().getBaijiahaoData().oriUgcType == 3) {
                    this.B.g(8);
                } else if (dx7Var.Q() != null && dx7Var.Q().isQuestionThread()) {
                    this.B.g(8);
                } else {
                    this.B.g(0);
                }
                this.B.a(dx7Var.S());
                this.B.f(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eb5), StringHelper.numberUniformFormatExtra(dx7Var.R())));
            } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.s().hadConcerned() && (dx7Var.Q() == null || !dx7Var.Q().isQuestionThread())) {
                this.B.g(8);
            } else {
                this.y.setVisibility(8);
                this.B.g(8);
            }
            if (dx7Var.i || 3 == dx7Var.g()) {
                this.y.setVisibility(8);
            }
        }
    }

    public final SpannableStringBuilder u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new k36.a(str));
                return k36.h(this.a.getActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.I = new TBLottieAnimationView(this.f.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xi.g(this.f.getContext(), R.dimen.tbds650), xi.g(this.f.getContext(), R.dimen.tbds100));
            layoutParams.setMargins(xi.g(this.f.getContext(), R.dimen.tbds110), 0, 0, xi.g(this.f.getContext(), R.dimen.tbds10));
            layoutParams.addRule(8, this.i.getId());
            this.f.addView(this.I, layoutParams);
            x();
            this.I.setVisibility(8);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.I != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.I.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.I.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.I, R.raw.obfuscated_res_0x7f11004e);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0658, (ViewGroup) null);
            this.f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0918be);
            this.g = imageView;
            imageView.getLayoutParams().height = f18.t();
            nz7 nz7Var = new nz7(this.a.getBaseFragmentActivity(), this.f);
            this.h = nz7Var;
            nz7Var.a();
            nz7 nz7Var2 = this.h;
            nz7Var2.d(nz7Var2.e(), this.c);
            this.i = (ColumnLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09185d);
            this.j = (ThreadSkinView) this.f.findViewById(R.id.obfuscated_res_0x7f0918bb);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09185c);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090a2b);
            this.n = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090e4a);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091859);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09076a);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.f.findViewById(R.id.obfuscated_res_0x7f092647);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f091899);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f09185a);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091f11);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091f12);
            this.v = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09185b);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091833);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f09186f);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091876);
            this.B = new i(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0918df), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f0918e0));
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091865);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091863);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091861);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091862);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091836);
            w();
        }
    }
}
