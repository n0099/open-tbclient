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
    private com.baidu.tieba.ala.personcenter.privilege.b gYp;
    private com.baidu.tieba.ala.personcenter.privilege.a gYq;
    private AlaEnterEffectData har;
    private String has;
    private a hat;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hau;
    private b hav;
    private b.a haw = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void mW(boolean z) {
            if (AlaEnterEffectDetailActivity.this.har != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.har.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.har.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Hf(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0656a hax = new a.InterfaceC0656a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0656a
        public void NF() {
            if (AlaEnterEffectDetailActivity.this.har != null) {
                if (AlaEnterEffectDetailActivity.this.har.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.has) || AlaEnterEffectDetailActivity.this.has.equals(AlaEnterEffectDetailActivity.this.har.id)) {
                        if (AlaEnterEffectDetailActivity.this.har != null) {
                            AlaEnterEffectDetailActivity.this.hav.az(AlaEnterEffectDetailActivity.this.har.id, AlaEnterEffectDetailActivity.this.har.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.ie(false);
                    aVar.setAutoNight(false);
                    aVar.nE(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.har != null) {
                                AlaEnterEffectDetailActivity.this.hav.az(AlaEnterEffectDetailActivity.this.har.id, AlaEnterEffectDetailActivity.this.har.use_status != 1);
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
                    aVar.bia();
                } else if (3 != AlaEnterEffectDetailActivity.this.har.categoryType && 2 == AlaEnterEffectDetailActivity.this.har.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.har.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gYp != null) {
                            AlaEnterEffectDetailActivity.this.gYp.ev(AlaEnterEffectDetailActivity.this.har.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gYq != null) {
                        AlaEnterEffectDetailActivity.this.gYq.aG(AlaEnterEffectDetailActivity.this.har.id, AlaEnterEffectDetailActivity.this.har.propId);
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
        this.hav = new b(this.haw);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.har = (AlaEnterEffectData) serializableExtra;
        this.has = getIntent().getStringExtra("key_selected_effect_id");
        this.hat = new a(getActivity(), this.har);
        this.hat.a(this.hax);
        this.hat.caY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hat.caY());
        this.hau = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hat.caY());
        this.gYp = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gYp.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mV(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.har != null) {
                    if (AlaEnterEffectDetailActivity.this.har.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hat.Hg(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hat.Hg(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gYq = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0649a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0649a
            public void p(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.har != null && AlaEnterEffectDetailActivity.this.hat != null) {
                        AlaEnterEffectDetailActivity.this.har.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hat.d(AlaEnterEffectDetailActivity.this.har);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.har.id));
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
        if (this.har != null && this.hau != null) {
            this.hau.a(this.har);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hav != null) {
            this.hav.onDestroy();
        }
        if (this.hau != null) {
            this.hau.onDestory();
        }
    }
}
