package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import android.app.Activity;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gv5;
import com.repackage.jv5;
import com.repackage.kv5;
import com.repackage.nr4;
import com.repackage.wu5;
import com.repackage.xu5;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_EFFECT_DATA = "key_effect_data";
    public static final String KEY_SELECTED_EFFECT_ID = "key_selected_effect_id";
    public static final String KEY_STATUS_IS_SELECTED = "key_status_is_selected";
    public static final int REQUEST_CODE_EFFECT_DETAIL = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public wu5 mBuyPropModel;
    public AlaEnterEffectData mData;
    public jv5 mMainView;
    public kv5 mModel;
    public kv5.b mModelCallback;
    public gv5 mPreViewController;
    public String mSelectedEffectId;
    public xu5 mTDouBuyController;
    public jv5.b mViewClickListener;

    /* loaded from: classes3.dex */
    public class a implements kv5.b {
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

        @Override // com.repackage.kv5.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.showToast(str);
            }
        }

        @Override // com.repackage.kv5.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a.mData == null) {
                return;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f0cf6);
            Intent intent = new Intent();
            if (z != (this.a.mData.use_status == 1)) {
                intent.putExtra(AlaEnterEffectDetailActivity.KEY_SELECTED_EFFECT_ID, this.a.mData.id);
                intent.putExtra(AlaEnterEffectDetailActivity.KEY_STATUS_IS_SELECTED, z);
            }
            this.a.setResult(-1, intent);
            this.a.finish();
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
    public class c implements xu5.c {
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

        @Override // com.repackage.xu5.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.mData != null) {
                if (this.a.mData.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    this.a.mMainView.d(this.a.getString(R.string.obfuscated_res_0x7f0f020f));
                } else {
                    this.a.mMainView.d(this.a.getString(R.string.obfuscated_res_0x7f0f0208));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements wu5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

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

        @Override // com.repackage.wu5.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a.mData == null || this.a.mMainView == null) {
                        return;
                    }
                    this.a.mData.isOwn = true;
                    this.a.mMainView.c(this.a.mData);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0211);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, this.a.mData.id));
                } else if (!StringUtils.isNull(str)) {
                    this.a.showToast(str);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0210);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements jv5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEnterEffectDetailActivity a;

        /* loaded from: classes3.dex */
        public class a implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                    if (this.a.a.mData != null) {
                        this.a.a.mModel.b(this.a.a.mData.id, this.a.a.mData.use_status != 1);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        public e(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
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

        @Override // com.repackage.jv5.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mData == null) {
                return;
            }
            if (!this.a.mData.isOwn) {
                if (3 != this.a.mData.categoryType && 2 == this.a.mData.categoryType) {
                    if (this.a.mData.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (this.a.mTDouBuyController != null) {
                            this.a.mTDouBuyController.c(this.a.mData.price);
                            return;
                        }
                        return;
                    } else if (this.a.mBuyPropModel != null) {
                        this.a.mBuyPropModel.b(this.a.mData.id, this.a.mData.propId);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(this.a.mSelectedEffectId) || this.a.mSelectedEffectId.equals(this.a.mData.id)) {
                if (this.a.mData != null) {
                    this.a.mModel.b(this.a.mData.id, this.a.mData.use_status != 1);
                    return;
                }
                return;
            }
            nr4 nr4Var = new nr4(this.a.getActivity());
            nr4Var.setCanceledOnTouchOutside(false);
            nr4Var.setAutoNight(false);
            nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0202);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new a(this));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new b(this));
            nr4Var.create(this.a.getPageContext());
            nr4Var.show();
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
        this.mModelCallback = new a(this);
        this.mViewClickListener = new e(this);
    }

    public static void startActivityForResult(Activity activity, AlaEnterEffectData alaEnterEffectData, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65543, null, activity, alaEnterEffectData, str, i) == null) || activity == null || alaEnterEffectData == null) {
            return;
        }
        Intent intent = new Intent(activity, AlaEnterEffectDetailActivity.class);
        intent.putExtra(KEY_EFFECT_DATA, alaEnterEffectData);
        intent.putExtra(KEY_SELECTED_EFFECT_ID, str);
        activity.startActivityForResult(intent, i);
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.mModel = new kv5(this.mModelCallback);
            Serializable serializableExtra = getIntent().getSerializableExtra(KEY_EFFECT_DATA);
            if (!(serializableExtra instanceof AlaEnterEffectData)) {
                showToast(R.string.obfuscated_res_0x7f0f1385);
                setResult(0);
                finish();
                return;
            }
            this.mData = (AlaEnterEffectData) serializableExtra;
            this.mSelectedEffectId = getIntent().getStringExtra(KEY_SELECTED_EFFECT_ID);
            jv5 jv5Var = new jv5(getActivity(), this.mData);
            this.mMainView = jv5Var;
            jv5Var.e(this.mViewClickListener);
            this.mMainView.b().setOnClickListener(new b(this));
            setContentView(this.mMainView.b());
            this.mPreViewController = new gv5(getActivity(), this.mMainView.b());
            xu5 xu5Var = new xu5(getPageContext());
            this.mTDouBuyController = xu5Var;
            xu5Var.e(new c(this));
            this.mBuyPropModel = new wu5(getPageContext(), new d(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            kv5 kv5Var = this.mModel;
            if (kv5Var != null) {
                kv5Var.c();
            }
            gv5 gv5Var = this.mPreViewController;
            if (gv5Var != null) {
                gv5Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        gv5 gv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            AlaEnterEffectData alaEnterEffectData = this.mData;
            if (alaEnterEffectData == null || (gv5Var = this.mPreViewController) == null) {
                return;
            }
            gv5Var.g(alaEnterEffectData);
        }
    }
}
