package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.p0.s.s.a;
import c.a.q0.v.j.g.a;
import c.a.q0.v.j.g.b;
import c.a.q0.v.j.g.d.e.a;
import c.a.q0.v.j.g.d.e.b;
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
import java.io.Serializable;
/* loaded from: classes7.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_EFFECT_DATA = "key_effect_data";
    public static final String KEY_SELECTED_EFFECT_ID = "key_selected_effect_id";
    public static final String KEY_STATUS_IS_SELECTED = "key_status_is_selected";
    public static final int REQUEST_CODE_EFFECT_DETAIL = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.v.j.g.a mBuyPropModel;
    public AlaEnterEffectData mData;
    public c.a.q0.v.j.g.d.e.a mMainView;
    public c.a.q0.v.j.g.d.e.b mModel;
    public b.InterfaceC1205b mModelCallback;
    public c.a.q0.v.j.g.d.b mPreViewController;
    public String mSelectedEffectId;
    public c.a.q0.v.j.g.b mTDouBuyController;
    public a.b mViewClickListener;

    /* loaded from: classes7.dex */
    public class a implements b.InterfaceC1205b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectDetailActivity f49629a;

        public a(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49629a = alaEnterEffectDetailActivity;
        }

        @Override // c.a.q0.v.j.g.d.e.b.InterfaceC1205b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49629a.showToast(str);
            }
        }

        @Override // c.a.q0.v.j.g.d.e.b.InterfaceC1205b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f49629a.mData == null) {
                return;
            }
            this.f49629a.showToast(R.string.operation_success);
            Intent intent = new Intent();
            if (z != (this.f49629a.mData.use_status == 1)) {
                intent.putExtra(AlaEnterEffectDetailActivity.KEY_SELECTED_EFFECT_ID, this.f49629a.mData.id);
                intent.putExtra(AlaEnterEffectDetailActivity.KEY_STATUS_IS_SELECTED, z);
            }
            this.f49629a.setResult(-1, intent);
            this.f49629a.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectDetailActivity f49630e;

        public b(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49630e = alaEnterEffectDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49630e.setResult(0);
                this.f49630e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectDetailActivity f49631a;

        public c(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49631a = alaEnterEffectDetailActivity;
        }

        @Override // c.a.q0.v.j.g.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f49631a.mData != null) {
                if (this.f49631a.mData.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    this.f49631a.mMainView.d(this.f49631a.getString(R.string.ala_enter_effect_tdou_buy));
                } else {
                    this.f49631a.mMainView.d(this.f49631a.getString(R.string.ala_enter_effect_get_t_dou));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectDetailActivity f49632a;

        public d(AlaEnterEffectDetailActivity alaEnterEffectDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEnterEffectDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49632a = alaEnterEffectDetailActivity;
        }

        @Override // c.a.q0.v.j.g.a.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f49632a.mData == null || this.f49632a.mMainView == null) {
                        return;
                    }
                    this.f49632a.mData.isOwn = true;
                    this.f49632a.mMainView.c(this.f49632a.mData);
                    this.f49632a.showToast(R.string.ala_enter_effect_tdou_buy_success);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, this.f49632a.mData.id));
                } else if (!StringUtils.isNull(str)) {
                    this.f49632a.showToast(str);
                } else {
                    this.f49632a.showToast(R.string.ala_enter_effect_tdou_buy_fail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEnterEffectDetailActivity f49633a;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f49634e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49634e = eVar;
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    if (this.f49634e.f49633a.mData != null) {
                        this.f49634e.f49633a.mModel.b(this.f49634e.f49633a.mData.id, this.f49634e.f49633a.mData.use_status != 1);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49633a = alaEnterEffectDetailActivity;
        }

        @Override // c.a.q0.v.j.g.d.e.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49633a.mData == null) {
                return;
            }
            if (!this.f49633a.mData.isOwn) {
                if (3 != this.f49633a.mData.categoryType && 2 == this.f49633a.mData.categoryType) {
                    if (this.f49633a.mData.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (this.f49633a.mTDouBuyController != null) {
                            this.f49633a.mTDouBuyController.c(this.f49633a.mData.price);
                            return;
                        }
                        return;
                    } else if (this.f49633a.mBuyPropModel != null) {
                        this.f49633a.mBuyPropModel.b(this.f49633a.mData.id, this.f49633a.mData.propId);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(this.f49633a.mSelectedEffectId) || this.f49633a.mSelectedEffectId.equals(this.f49633a.mData.id)) {
                if (this.f49633a.mData != null) {
                    this.f49633a.mModel.b(this.f49633a.mData.id, this.f49633a.mData.use_status != 1);
                    return;
                }
                return;
            }
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f49633a.getActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setAutoNight(false);
            aVar.setMessageId(R.string.ala_effect_replace_tip);
            aVar.setPositiveButton(R.string.confirm, new a(this));
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(this.f49633a.getPageContext());
            aVar.show();
        }
    }

    public AlaEnterEffectDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mModelCallback = new a(this);
        this.mViewClickListener = new e(this);
    }

    public static void startActivityForResult(Activity activity, AlaEnterEffectData alaEnterEffectData, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65543, null, activity, alaEnterEffectData, str, i2) == null) || activity == null || alaEnterEffectData == null) {
            return;
        }
        Intent intent = new Intent(activity, AlaEnterEffectDetailActivity.class);
        intent.putExtra(KEY_EFFECT_DATA, alaEnterEffectData);
        intent.putExtra(KEY_SELECTED_EFFECT_ID, str);
        activity.startActivityForResult(intent, i2);
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.mModel = new c.a.q0.v.j.g.d.e.b(this.mModelCallback);
            Serializable serializableExtra = getIntent().getSerializableExtra(KEY_EFFECT_DATA);
            if (!(serializableExtra instanceof AlaEnterEffectData)) {
                showToast(R.string.tb_err_unknown);
                setResult(0);
                finish();
                return;
            }
            this.mData = (AlaEnterEffectData) serializableExtra;
            this.mSelectedEffectId = getIntent().getStringExtra(KEY_SELECTED_EFFECT_ID);
            c.a.q0.v.j.g.d.e.a aVar = new c.a.q0.v.j.g.d.e.a(getActivity(), this.mData);
            this.mMainView = aVar;
            aVar.e(this.mViewClickListener);
            this.mMainView.b().setOnClickListener(new b(this));
            setContentView(this.mMainView.b());
            this.mPreViewController = new c.a.q0.v.j.g.d.b(getActivity(), this.mMainView.b());
            c.a.q0.v.j.g.b bVar = new c.a.q0.v.j.g.b(getPageContext());
            this.mTDouBuyController = bVar;
            bVar.e(new c(this));
            this.mBuyPropModel = new c.a.q0.v.j.g.a(getPageContext(), new d(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            c.a.q0.v.j.g.d.e.b bVar = this.mModel;
            if (bVar != null) {
                bVar.c();
            }
            c.a.q0.v.j.g.d.b bVar2 = this.mPreViewController;
            if (bVar2 != null) {
                bVar2.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        c.a.q0.v.j.g.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            AlaEnterEffectData alaEnterEffectData = this.mData;
            if (alaEnterEffectData == null || (bVar = this.mPreViewController) == null) {
                return;
            }
            bVar.g(alaEnterEffectData);
        }
    }
}
