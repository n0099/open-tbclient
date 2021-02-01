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
/* loaded from: classes10.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b iaH;
    private com.baidu.tieba.ala.personcenter.privilege.a iaI;
    private AlaEnterEffectData icJ;
    private String icK;
    private a icL;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b icM;
    private b icN;
    private b.a icO = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void pa(boolean z) {
            if (AlaEnterEffectDetailActivity.this.icJ != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.icJ.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.icJ.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Ip(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0692a icP = new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0692a
        public void Qa() {
            if (AlaEnterEffectDetailActivity.this.icJ != null) {
                if (AlaEnterEffectDetailActivity.this.icJ.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.icK) || AlaEnterEffectDetailActivity.this.icK.equals(AlaEnterEffectDetailActivity.this.icJ.id)) {
                        if (AlaEnterEffectDetailActivity.this.icJ != null) {
                            AlaEnterEffectDetailActivity.this.icN.aG(AlaEnterEffectDetailActivity.this.icJ.id, AlaEnterEffectDetailActivity.this.icJ.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.jG(false);
                    aVar.setAutoNight(false);
                    aVar.nx(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.icJ != null) {
                                AlaEnterEffectDetailActivity.this.icN.aG(AlaEnterEffectDetailActivity.this.icJ.id, AlaEnterEffectDetailActivity.this.icJ.use_status != 1);
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
                    aVar.bqx();
                } else if (3 != AlaEnterEffectDetailActivity.this.icJ.categoryType && 2 == AlaEnterEffectDetailActivity.this.icJ.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.icJ.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.iaH != null) {
                            AlaEnterEffectDetailActivity.this.iaH.fT(AlaEnterEffectDetailActivity.this.icJ.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.iaI != null) {
                        AlaEnterEffectDetailActivity.this.iaI.aS(AlaEnterEffectDetailActivity.this.icJ.id, AlaEnterEffectDetailActivity.this.icJ.propId);
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
        this.icN = new b(this.icO);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.icJ = (AlaEnterEffectData) serializableExtra;
        this.icK = getIntent().getStringExtra("key_selected_effect_id");
        this.icL = new a(getActivity(), this.icJ);
        this.icL.a(this.icP);
        this.icL.cnn().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.icL.cnn());
        this.icM = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.icL.cnn());
        this.iaH = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.iaH.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oZ(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.icJ != null) {
                    if (AlaEnterEffectDetailActivity.this.icJ.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.icL.Iq(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.icL.Iq(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.iaI = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0685a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0685a
            public void y(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.icJ != null && AlaEnterEffectDetailActivity.this.icL != null) {
                        AlaEnterEffectDetailActivity.this.icJ.isOwn = true;
                        AlaEnterEffectDetailActivity.this.icL.d(AlaEnterEffectDetailActivity.this.icJ);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.icJ.id));
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
        if (this.icJ != null && this.icM != null) {
            this.icM.a(this.icJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.icN != null) {
            this.icN.onDestroy();
        }
        if (this.icM != null) {
            this.icM.onDestory();
        }
    }
}
