package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.b16;
import com.baidu.tieba.c16;
import com.baidu.tieba.iv4;
import com.baidu.tieba.l16;
import com.baidu.tieba.o16;
import com.baidu.tieba.p16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaEnterEffectData a;
    public String b;
    public o16 c;
    public l16 d;
    public p16 e;
    public c16 f;
    public b16 g;
    public p16.b h;
    public o16.b i;

    /* loaded from: classes3.dex */
    public class d implements o16.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

        /* loaded from: classes3.dex */
        public class a implements iv4.e {
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

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    iv4Var.dismiss();
                    if (this.a.a.a != null) {
                        p16 p16Var = this.a.a.e;
                        String str = this.a.a.a.id;
                        boolean z = true;
                        if (this.a.a.a.use_status == 1) {
                            z = false;
                        }
                        p16Var.b(str, z);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements iv4.e {
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

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    iv4Var.dismiss();
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

        @Override // com.baidu.tieba.o16.b
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
                iv4 iv4Var = new iv4(this.a.getActivity());
                iv4Var.setCanceledOnTouchOutside(false);
                iv4Var.setAutoNight(false);
                iv4Var.setMessageId(R.string.obfuscated_res_0x7f0f020a);
                iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043f, new a(this));
                iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                iv4Var.create(this.a.getPageContext());
                iv4Var.show();
            } else if (this.a.a != null) {
                p16 p16Var = this.a.e;
                String str = this.a.a.id;
                if (this.a.a.use_status != 1) {
                    z = true;
                }
                p16Var.b(str, z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements p16.b {
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

        @Override // com.baidu.tieba.p16.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.p16.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a.a != null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d4b);
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class c implements b16.b {
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

        @Override // com.baidu.tieba.b16.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a.a != null && this.a.c != null) {
                        this.a.a.isOwn = true;
                        this.a.c.c(this.a.a);
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0219);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, this.a.a.id));
                    }
                } else if (!StringUtils.isNull(str)) {
                    this.a.showToast(str);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0218);
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
            overridePendingTransition(R.anim.obfuscated_res_0x7f01002f, 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            overridePendingTransition(R.anim.obfuscated_res_0x7f01002f, R.anim.obfuscated_res_0x7f010030);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            p16 p16Var = this.e;
            if (p16Var != null) {
                p16Var.c();
            }
            l16 l16Var = this.d;
            if (l16Var != null) {
                l16Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        l16 l16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            AlaEnterEffectData alaEnterEffectData = this.a;
            if (alaEnterEffectData != null && (l16Var = this.d) != null) {
                l16Var.g(alaEnterEffectData);
            }
        }
    }

    public static void startActivityForResult(Activity activity, AlaEnterEffectData alaEnterEffectData, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, alaEnterEffectData, str, i) == null) && activity != null && alaEnterEffectData != null) {
            Intent intent = new Intent(activity, AlaEnterEffectDetailActivity.class);
            intent.putExtra("key_effect_data", alaEnterEffectData);
            intent.putExtra("key_selected_effect_id", str);
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.e = new p16(this.h);
            Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
            if (!(serializableExtra instanceof AlaEnterEffectData)) {
                showToast(R.string.obfuscated_res_0x7f0f13df);
                setResult(0);
                finish();
                return;
            }
            this.a = (AlaEnterEffectData) serializableExtra;
            this.b = getIntent().getStringExtra("key_selected_effect_id");
            o16 o16Var = new o16(getActivity(), this.a);
            this.c = o16Var;
            o16Var.d(this.i);
            this.c.b().setOnClickListener(new b(this));
            setContentView(this.c.b());
            this.d = new l16(getActivity(), this.c.b());
            this.f = new c16(getPageContext());
            this.g = new b16(getPageContext(), new c(this));
        }
    }
}
