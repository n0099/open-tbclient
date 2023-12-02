package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.be6;
import com.baidu.tieba.ce6;
import com.baidu.tieba.f05;
import com.baidu.tieba.le6;
import com.baidu.tieba.oe6;
import com.baidu.tieba.pe6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaEnterEffectData a;
    public String b;
    public oe6 c;
    public le6 d;
    public pe6 e;
    public ce6 f;
    public be6 g;
    public pe6.b h;
    public oe6.b i;

    /* loaded from: classes5.dex */
    public class d implements oe6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

        /* loaded from: classes5.dex */
        public class a implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    if (this.a.a.a != null) {
                        pe6 pe6Var = this.a.a.e;
                        String str = this.a.a.a.id;
                        boolean z = true;
                        if (this.a.a.a.use_status == 1) {
                            z = false;
                        }
                        pe6Var.b(str, z);
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        public d(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectDetailActivity;
        }

        @Override // com.baidu.tieba.oe6.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null) {
                return;
            }
            if (!this.a.a.isOwn) {
                if (3 != this.a.a.categoryType && 2 == this.a.a.categoryType) {
                    if (this.a.a.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (this.a.f != null) {
                            this.a.f.a(this.a.a.price);
                            return;
                        }
                        return;
                    } else if (this.a.g != null) {
                        this.a.g.b(this.a.a.id, this.a.a.propId);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            boolean z = false;
            if (!TextUtils.isEmpty(this.a.b) && !this.a.b.equals(this.a.a.id)) {
                f05 f05Var = new f05(this.a.getActivity());
                f05Var.setCanceledOnTouchOutside(false);
                f05Var.setAutoNight(false);
                f05Var.setMessageId(R.string.obfuscated_res_0x7f0f0241);
                f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new a(this));
                f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                f05Var.create(this.a.getPageContext());
                f05Var.show();
            } else if (this.a.a != null) {
                pe6 pe6Var = this.a.e;
                String str = this.a.a.id;
                if (this.a.a.use_status != 1) {
                    z = true;
                }
                pe6Var.b(str, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements pe6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

        public a(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectDetailActivity;
        }

        @Override // com.baidu.tieba.pe6.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.pe6.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a.a != null) {
                this.a.showToast(R.string.operation_success);
                Intent intent = new Intent();
                boolean z2 = true;
                if (this.a.a.use_status != 1) {
                    z2 = false;
                }
                if (z != z2) {
                    intent.putExtra("key_selected_effect_id", this.a.a.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

        public b(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements be6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

        public c(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEnterEffectDetailActivity;
        }

        @Override // com.baidu.tieba.be6.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a.a != null && this.a.c != null) {
                        this.a.a.isOwn = true;
                        this.a.c.c(this.a.a);
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0250);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, this.a.a.id));
                    }
                } else if (!StringUtils.isNull(str)) {
                    this.a.showToast(str);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f024f);
                }
            }
        }
    }

    public AlaEnterEffectDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.i = new d(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            overridePendingTransition(R.anim.alpha_in, 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            pe6 pe6Var = this.e;
            if (pe6Var != null) {
                pe6Var.c();
            }
            le6 le6Var = this.d;
            if (le6Var != null) {
                le6Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        le6 le6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            AlaEnterEffectData alaEnterEffectData = this.a;
            if (alaEnterEffectData != null && (le6Var = this.d) != null) {
                le6Var.g(alaEnterEffectData);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.e = new pe6(this.h);
            Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
            if (!(serializableExtra instanceof AlaEnterEffectData)) {
                showToast(R.string.tb_err_unknown);
                setResult(0);
                finish();
                return;
            }
            this.a = (AlaEnterEffectData) serializableExtra;
            this.b = getIntent().getStringExtra("key_selected_effect_id");
            oe6 oe6Var = new oe6(getActivity(), this.a);
            this.c = oe6Var;
            oe6Var.d(this.i);
            this.c.b().setOnClickListener(new b(this));
            setContentView(this.c.b());
            this.d = new le6(getActivity(), this.c.b());
            this.f = new ce6(getPageContext());
            this.g = new be6(getPageContext(), new c(this));
        }
    }
}
