package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.o56;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h3a extends m3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView h;
    public TextView i;
    public ApkDownloadView j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h3a a;

        public a(h3a h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h3aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements o56.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x2a a;
        public final /* synthetic */ h3a b;

        public b(h3a h3aVar, x2a x2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3aVar, x2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h3aVar;
            this.a = x2aVar;
        }

        @Override // com.baidu.tieba.o56.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                h3a h3aVar = this.b;
                if (h3aVar.k) {
                    d56.a(this.a.j);
                } else {
                    AdCard adCard = h3aVar.f;
                    if (adCard != null) {
                        d56.a(adCard.getButtonCmdScheme());
                    }
                }
                b29.c(this.b.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3a(View view2, String str) {
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

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    @Override // com.baidu.tieba.m3a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
            this.j.setTextColorInitSkin(R.color.CAM_X0101);
            this.j.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0814d2);
            this.j.c();
        }
    }

    @Override // com.baidu.tieba.m3a
    public void c(x2a x2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x2aVar) == null) {
            super.c(x2aVar);
            this.h.startLoad(x2aVar.c, 10, false);
            this.i.setText(x2aVar.b);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.j.setInitText(x2aVar.e);
            if (this.c != null) {
                this.b.setOnClickListener(new a(this));
                this.j.setOnClickInterceptListener(new b(this, x2aVar));
                AdCard adCard = this.f;
                if (adCard != null) {
                    new n56(this.j, y2a.d(adCard));
                }
            }
            b();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) a(R.id.obfuscated_res_0x7f092870);
            this.h = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.i = (TextView) a(R.id.user_name);
            this.j = (ApkDownloadView) a(R.id.obfuscated_res_0x7f090952);
        }
    }
}
