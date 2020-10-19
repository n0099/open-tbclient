package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.a;
import com.baidu.tieba.ala.personcenter.privilege.b;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b hnq;
    private com.baidu.tieba.ala.personcenter.privilege.a hnr;
    private AlaEnterEffectData hps;
    private String hpt;
    private a hpu;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hpv;
    private b hpw;
    private b.a hpx = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void nz(boolean z) {
            if (AlaEnterEffectDetailActivity.this.hps != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.hps.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.hps.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void HT(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0674a hpy = new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0674a
        public void OK() {
            if (AlaEnterEffectDetailActivity.this.hps != null) {
                if (AlaEnterEffectDetailActivity.this.hps.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.hpt) || AlaEnterEffectDetailActivity.this.hpt.equals(AlaEnterEffectDetailActivity.this.hps.id)) {
                        if (AlaEnterEffectDetailActivity.this.hps != null) {
                            AlaEnterEffectDetailActivity.this.hpw.aD(AlaEnterEffectDetailActivity.this.hps.id, AlaEnterEffectDetailActivity.this.hps.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.iA(false);
                    aVar.setAutoNight(false);
                    aVar.ob(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.hps != null) {
                                AlaEnterEffectDetailActivity.this.hpw.aD(AlaEnterEffectDetailActivity.this.hps.id, AlaEnterEffectDetailActivity.this.hps.use_status != 1);
                            }
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(AlaEnterEffectDetailActivity.this.getPageContext());
                    aVar.bkJ();
                } else if (3 != AlaEnterEffectDetailActivity.this.hps.categoryType && 2 == AlaEnterEffectDetailActivity.this.hps.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.hps.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.hnq != null) {
                            AlaEnterEffectDetailActivity.this.hnq.eM(AlaEnterEffectDetailActivity.this.hps.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.hnr != null) {
                        AlaEnterEffectDetailActivity.this.hnr.aH(AlaEnterEffectDetailActivity.this.hps.id, AlaEnterEffectDetailActivity.this.hps.propId);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.hpw = new b(this.hpx);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.hps = (AlaEnterEffectData) serializableExtra;
        this.hpt = getIntent().getStringExtra("key_selected_effect_id");
        this.hpu = new a(getActivity(), this.hps);
        this.hpu.a(this.hpy);
        this.hpu.cew().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hpu.cew());
        this.hpv = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hpu.cew());
        this.hnq = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.hnq.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ny(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.hps != null) {
                    if (AlaEnterEffectDetailActivity.this.hps.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hpu.HU(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hpu.HU(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.hnr = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0667a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0667a
            public void p(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.hps != null && AlaEnterEffectDetailActivity.this.hpu != null) {
                        AlaEnterEffectDetailActivity.this.hps.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hpu.d(AlaEnterEffectDetailActivity.this.hps);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.hps.id));
                    }
                } else if (!StringUtils.isNull(str)) {
                    AlaEnterEffectDetailActivity.this.showToast(str);
                } else {
                    AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_fail);
                }
            }
        });
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hps != null && this.hpv != null) {
            this.hpv.a(this.hps);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hpw != null) {
            this.hpw.onDestroy();
        }
        if (this.hpv != null) {
            this.hpv.onDestory();
        }
    }
}
