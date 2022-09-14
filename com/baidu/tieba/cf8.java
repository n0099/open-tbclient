package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.bp5;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cf8 extends ff8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout h;
    public RoundTbImageView i;
    public TextView j;
    public TextView k;
    public ApkDownloadView l;
    public TextView m;
    public CountDownTextView n;
    public AdAppInfoView o;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cf8 cf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf8 a;

        public b(cf8 cf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.a.g) == null) {
                return;
            }
            onClickListener.onClick(view2);
            this.a.n.c();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe8 a;
        public final /* synthetic */ cf8 b;

        public c(cf8 cf8Var, pe8 pe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf8Var, pe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf8Var;
            this.a = pe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pe8 pe8Var = this.a;
                String str = pe8Var.d;
                if (!ji0.n(pe8Var.j) ? ii0.b(this.b.e.getPageActivity(), this.b.c.p) : false) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.b.c;
                    i = nd8.b(this.b.e, str, advertAppInfo.h() ? this.b.c.getDownloadId() : this.b.c.a, advertAppInfo.g, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.y(ClogBuilder.LogType.CLICK).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.b.c.position + 1)).p(this.b.c.g);
                uz0.b(clogBuilder);
                hg7.c(this.b.c);
                this.b.n.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements bp5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf8 a;

        public d(cf8 cf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf8Var;
        }

        @Override // com.baidu.tieba.bp5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                qo5.a(this.a.f.getButtonCmdScheme());
                hg7.c(this.a.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf8(View view2, String str) {
        super(view2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l();
    }

    @Override // com.baidu.tieba.ff8
    public void c(pe8 pe8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pe8Var) == null) {
            super.c(pe8Var);
            if (pe8Var == null) {
                return;
            }
            this.i.K(pe8Var.c, 30, false);
            this.j.setText(pe8Var.b);
            this.k.setText(pe8Var.i);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00b9));
            this.h.setOnClickListener(new c(this, pe8Var));
            AdvertAppInfo advertAppInfo = this.c;
            if (advertAppInfo == null || this.f == null || !advertAppInfo.h()) {
                return;
            }
            this.o.setAd(this.c);
            this.o.setAppInfo(this.c.h.getAppInfoModel());
            m();
        }
    }

    @Override // com.baidu.tieba.ff8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.n.update(5);
            this.n.e();
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.c.position + 1)).p(this.c.g);
            uz0.b(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.ff8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e();
        }
    }

    @Override // com.baidu.tieba.ff8
    public void j(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.j(cVar);
            this.n.setTimeoutListener(cVar);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f090099);
            this.i = (RoundTbImageView) a(R.id.obfuscated_res_0x7f09249d);
            this.j = (TextView) a(R.id.obfuscated_res_0x7f0924b4);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f09248d);
            this.l = (ApkDownloadView) a(R.id.obfuscated_res_0x7f09082f);
            this.m = (TextView) a(R.id.obfuscated_res_0x7f091bd5);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f090708);
            this.o = (AdAppInfoView) a(R.id.obfuscated_res_0x7f0900b4);
            this.l.setTextColorInitSkin(R.color.CAM_X0101);
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.l.setTextSize(R.dimen.T_X06);
            this.l.setForegroundSkin(R.color.black_alpha15);
            this.l.setBackgroundSkin(R.drawable.obfuscated_res_0x7f08127b);
            this.l.setRatio(0);
            this.l.c();
        }
    }

    public final void m() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (adCard = this.f) == null || adCard.downloadInfo == null) {
            return;
        }
        this.l.setInitText(adCard.operate.a);
        this.l.setOnClickInterceptListener(new d(this));
        new ap5(this.l, qe8.d(this.f));
    }
}
