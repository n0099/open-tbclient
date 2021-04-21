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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.b.i0.r.s.a;
import d.b.j0.t.j.g.a;
import d.b.j0.t.j.g.b;
import d.b.j0.t.j.g.d.e.a;
import d.b.j0.t.j.g.d.e.b;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    public static final String KEY_EFFECT_DATA = "key_effect_data";
    public static final String KEY_SELECTED_EFFECT_ID = "key_selected_effect_id";
    public static final String KEY_STATUS_IS_SELECTED = "key_status_is_selected";
    public static final int REQUEST_CODE_EFFECT_DETAIL = 1001;
    public d.b.j0.t.j.g.a mBuyPropModel;
    public AlaEnterEffectData mData;
    public d.b.j0.t.j.g.d.e.a mMainView;
    public d.b.j0.t.j.g.d.e.b mModel;
    public d.b.j0.t.j.g.d.b mPreViewController;
    public String mSelectedEffectId;
    public d.b.j0.t.j.g.b mTDouBuyController;
    public b.InterfaceC1654b mModelCallback = new a();
    public a.b mViewClickListener = new e();

    /* loaded from: classes4.dex */
    public class a implements b.InterfaceC1654b {
        public a() {
        }

        @Override // d.b.j0.t.j.g.d.e.b.InterfaceC1654b
        public void a(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }

        @Override // d.b.j0.t.j.g.d.e.b.InterfaceC1654b
        public void b(boolean z) {
            if (AlaEnterEffectDetailActivity.this.mData != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.mData.use_status == 1)) {
                    intent.putExtra(AlaEnterEffectDetailActivity.KEY_SELECTED_EFFECT_ID, AlaEnterEffectDetailActivity.this.mData.id);
                    intent.putExtra(AlaEnterEffectDetailActivity.KEY_STATUS_IS_SELECTED, z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaEnterEffectDetailActivity.this.setResult(0);
            AlaEnterEffectDetailActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {
        public c() {
        }

        @Override // d.b.j0.t.j.g.b.c
        public void a(boolean z) {
            if (!z || AlaEnterEffectDetailActivity.this.mData == null) {
                return;
            }
            if (AlaEnterEffectDetailActivity.this.mData.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                AlaEnterEffectDetailActivity.this.mMainView.d(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
            } else {
                AlaEnterEffectDetailActivity.this.mMainView.d(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.b {
        public d() {
        }

        @Override // d.b.j0.t.j.g.a.b
        public void a(boolean z, String str) {
            if (z) {
                if (AlaEnterEffectDetailActivity.this.mData == null || AlaEnterEffectDetailActivity.this.mMainView == null) {
                    return;
                }
                AlaEnterEffectDetailActivity.this.mData.isOwn = true;
                AlaEnterEffectDetailActivity.this.mMainView.c(AlaEnterEffectDetailActivity.this.mData);
                AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.mData.id));
            } else if (!StringUtils.isNull(str)) {
                AlaEnterEffectDetailActivity.this.showToast(str);
            } else {
                AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_fail);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.b {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
                if (AlaEnterEffectDetailActivity.this.mData != null) {
                    AlaEnterEffectDetailActivity.this.mModel.b(AlaEnterEffectDetailActivity.this.mData.id, AlaEnterEffectDetailActivity.this.mData.use_status != 1);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(e eVar) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public e() {
        }

        @Override // d.b.j0.t.j.g.d.e.a.b
        public void a() {
            if (AlaEnterEffectDetailActivity.this.mData == null) {
                return;
            }
            if (!AlaEnterEffectDetailActivity.this.mData.isOwn) {
                if (3 != AlaEnterEffectDetailActivity.this.mData.categoryType && 2 == AlaEnterEffectDetailActivity.this.mData.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.mData.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.mTDouBuyController != null) {
                            AlaEnterEffectDetailActivity.this.mTDouBuyController.c(AlaEnterEffectDetailActivity.this.mData.price);
                            return;
                        }
                        return;
                    } else if (AlaEnterEffectDetailActivity.this.mBuyPropModel != null) {
                        AlaEnterEffectDetailActivity.this.mBuyPropModel.b(AlaEnterEffectDetailActivity.this.mData.id, AlaEnterEffectDetailActivity.this.mData.propId);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.mSelectedEffectId) || AlaEnterEffectDetailActivity.this.mSelectedEffectId.equals(AlaEnterEffectDetailActivity.this.mData.id)) {
                if (AlaEnterEffectDetailActivity.this.mData != null) {
                    AlaEnterEffectDetailActivity.this.mModel.b(AlaEnterEffectDetailActivity.this.mData.id, AlaEnterEffectDetailActivity.this.mData.use_status != 1);
                    return;
                }
                return;
            }
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(AlaEnterEffectDetailActivity.this.getActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setAutoNight(false);
            aVar.setMessageId(R.string.ala_effect_replace_tip);
            aVar.setPositiveButton(R.string.confirm, new a());
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(AlaEnterEffectDetailActivity.this.getPageContext());
            aVar.show();
        }
    }

    public static void startActivityForResult(Activity activity, AlaEnterEffectData alaEnterEffectData, String str, int i) {
        if (activity == null || alaEnterEffectData == null) {
            return;
        }
        Intent intent = new Intent(activity, AlaEnterEffectDetailActivity.class);
        intent.putExtra(KEY_EFFECT_DATA, alaEnterEffectData);
        intent.putExtra(KEY_SELECTED_EFFECT_ID, str);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(R.anim.alpha_in, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mModel = new d.b.j0.t.j.g.d.e.b(this.mModelCallback);
        Serializable serializableExtra = getIntent().getSerializableExtra(KEY_EFFECT_DATA);
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.mData = (AlaEnterEffectData) serializableExtra;
        this.mSelectedEffectId = getIntent().getStringExtra(KEY_SELECTED_EFFECT_ID);
        d.b.j0.t.j.g.d.e.a aVar = new d.b.j0.t.j.g.d.e.a(getActivity(), this.mData);
        this.mMainView = aVar;
        aVar.e(this.mViewClickListener);
        this.mMainView.b().setOnClickListener(new b());
        setContentView(this.mMainView.b());
        this.mPreViewController = new d.b.j0.t.j.g.d.b(getActivity(), this.mMainView.b());
        d.b.j0.t.j.g.b bVar = new d.b.j0.t.j.g.b(getPageContext());
        this.mTDouBuyController = bVar;
        bVar.e(new c());
        this.mBuyPropModel = new d.b.j0.t.j.g.a(getPageContext(), new d());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.t.j.g.d.e.b bVar = this.mModel;
        if (bVar != null) {
            bVar.c();
        }
        d.b.j0.t.j.g.d.b bVar2 = this.mPreViewController;
        if (bVar2 != null) {
            bVar2.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        d.b.j0.t.j.g.d.b bVar;
        super.onResume();
        AlaEnterEffectData alaEnterEffectData = this.mData;
        if (alaEnterEffectData == null || (bVar = this.mPreViewController) == null) {
            return;
        }
        bVar.g(alaEnterEffectData);
    }
}
