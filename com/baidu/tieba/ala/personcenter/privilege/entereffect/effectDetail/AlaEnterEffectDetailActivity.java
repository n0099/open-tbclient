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
    private com.baidu.tieba.ala.personcenter.privilege.b gUI;
    private com.baidu.tieba.ala.personcenter.privilege.a gUJ;
    private AlaEnterEffectData gWK;
    private String gWL;
    private a gWM;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b gWN;
    private b gWO;
    private b.a gWP = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void mS(boolean z) {
            if (AlaEnterEffectDetailActivity.this.gWK != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.gWK.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.gWK.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void GM(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0659a gWQ = new a.InterfaceC0659a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0659a
        public void Nb() {
            if (AlaEnterEffectDetailActivity.this.gWK != null) {
                if (AlaEnterEffectDetailActivity.this.gWK.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.gWL) || AlaEnterEffectDetailActivity.this.gWL.equals(AlaEnterEffectDetailActivity.this.gWK.id)) {
                        if (AlaEnterEffectDetailActivity.this.gWK != null) {
                            AlaEnterEffectDetailActivity.this.gWO.az(AlaEnterEffectDetailActivity.this.gWK.id, AlaEnterEffectDetailActivity.this.gWK.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.ih(false);
                    aVar.setAutoNight(false);
                    aVar.nt(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.gWK != null) {
                                AlaEnterEffectDetailActivity.this.gWO.az(AlaEnterEffectDetailActivity.this.gWK.id, AlaEnterEffectDetailActivity.this.gWK.use_status != 1);
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
                    aVar.bhg();
                } else if (3 != AlaEnterEffectDetailActivity.this.gWK.categoryType && 2 == AlaEnterEffectDetailActivity.this.gWK.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.gWK.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gUI != null) {
                            AlaEnterEffectDetailActivity.this.gUI.eo(AlaEnterEffectDetailActivity.this.gWK.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gUJ != null) {
                        AlaEnterEffectDetailActivity.this.gUJ.aG(AlaEnterEffectDetailActivity.this.gWK.id, AlaEnterEffectDetailActivity.this.gWK.propId);
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
        this.gWO = new b(this.gWP);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.gWK = (AlaEnterEffectData) serializableExtra;
        this.gWL = getIntent().getStringExtra("key_selected_effect_id");
        this.gWM = new a(getActivity(), this.gWK);
        this.gWM.a(this.gWQ);
        this.gWM.bZc().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.gWM.bZc());
        this.gWN = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.gWM.bZc());
        this.gUI = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gUI.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mR(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.gWK != null) {
                    if (AlaEnterEffectDetailActivity.this.gWK.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.gWM.GN(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.gWM.GN(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gUJ = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0652a
            public void p(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.gWK != null && AlaEnterEffectDetailActivity.this.gWM != null) {
                        AlaEnterEffectDetailActivity.this.gWK.isOwn = true;
                        AlaEnterEffectDetailActivity.this.gWM.d(AlaEnterEffectDetailActivity.this.gWK);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.gWK.id));
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
        if (this.gWK != null && this.gWN != null) {
            this.gWN.a(this.gWK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gWO != null) {
            this.gWO.onDestroy();
        }
        if (this.gWN != null) {
            this.gWN.onDestory();
        }
    }
}
