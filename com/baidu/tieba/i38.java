package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.qf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class i38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pf a;
    public final WeakReference<Activity> b;
    public final ViewGroup c;
    public of d;
    public String e;
    public String f;
    public String g;
    public final Handler h;
    public Runnable i;

    /* loaded from: classes4.dex */
    public class c implements of {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 a;

        @Override // com.baidu.tieba.of
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Activity activity;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (activity = (Activity) this.a.a.b.get()) == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(activity).createNormalCfg(this.a.a.f, null)));
                if (this.a.a.i != null) {
                    this.a.a.h.removeCallbacks(this.a.a.i);
                    this.a.a.h.postDelayed(this.a.a.i, 1000L);
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FORUM_GUIDE_VIEW_CLICK);
                if (!TextUtils.isEmpty(this.a.a.g)) {
                    statisticItem.addParam("tid", this.a.a.g);
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!TextUtils.isEmpty(currentAccount)) {
                    statisticItem.addParam("uid", currentAccount);
                }
                statisticItem.addParam("obj_locate", kz7.b().c());
                TiebaStatic.log(statisticItem);
            }
        }

        public c(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i38Var;
        }

        @Override // com.baidu.tieba.of
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06ee, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0918c4);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0918c3);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setStrokeWith(yi.g(inflate.getContext(), R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(this.a.e)) {
                    barImageView.K(this.a.e, 10, false);
                }
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918c8), (int) R.color.CAM_X0302);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f0918c6);
                pz4 pz4Var = new pz4();
                pz4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
                tBSpecificationBtn.setConfig(pz4Var);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                tBSpecificationBtn.setOnClickListener(new a(this));
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(findViewById);
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 a;

        public a(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.e(this.a.c);
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements qf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 a;

        @Override // com.baidu.tieba.qf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i38Var;
        }

        @Override // com.baidu.tieba.qf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.a = null;
            this.a.h.removeCallbacks(this.a.i);
        }
    }

    public i38(Activity activity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new Handler();
        this.b = new WeakReference<>(activity);
        this.c = viewGroup;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f = str;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.g = str;
        }
    }

    public final of j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new c(this);
        }
        return (of) invokeV.objValue;
    }

    public void k() {
        pf pfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pfVar = this.a) != null) {
            pfVar.e(this.c);
            this.c.setVisibility(8);
        }
    }

    public void l() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (runnable = this.i) != null) {
            this.h.removeCallbacks(runnable);
        }
    }

    public void p() {
        Activity activity;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (activity = this.b.get()) == null || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        pf pfVar = this.a;
        if (pfVar != null) {
            pfVar.e(this.c);
        }
        this.i = new a(this);
        qf qfVar = new qf();
        qfVar.d(true);
        qfVar.h(new b(this));
        if (this.d == null) {
            this.d = j();
        }
        qfVar.a(this.d);
        qfVar.e(R.anim.obfuscated_res_0x7f0100ea);
        qfVar.f(R.anim.obfuscated_res_0x7f0100eb);
        pf b2 = qfVar.b();
        this.a = b2;
        b2.q(activity, this.c, false);
        this.h.postDelayed(this.i, 4000L);
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FORUM_GUIDE_VIEW_SHOW);
        if (!TextUtils.isEmpty(this.g)) {
            statisticItem.addParam("tid", this.g);
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            statisticItem.addParam("uid", currentAccount);
        }
        statisticItem.addParam("obj_locate", kz7.b().c());
        TiebaStatic.log(statisticItem);
    }
}
