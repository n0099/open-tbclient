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
    private com.baidu.tieba.ala.personcenter.privilege.b hEP;
    private com.baidu.tieba.ala.personcenter.privilege.a hEQ;
    private AlaEnterEffectData hGR;
    private String hGS;
    private a hGT;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hGU;
    private b hGV;
    private b.a hGW = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void oa(boolean z) {
            if (AlaEnterEffectDetailActivity.this.hGR != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.hGR.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.hGR.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Ik(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0704a hGX = new a.InterfaceC0704a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0704a
        public void OZ() {
            if (AlaEnterEffectDetailActivity.this.hGR != null) {
                if (AlaEnterEffectDetailActivity.this.hGR.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.hGS) || AlaEnterEffectDetailActivity.this.hGS.equals(AlaEnterEffectDetailActivity.this.hGR.id)) {
                        if (AlaEnterEffectDetailActivity.this.hGR != null) {
                            AlaEnterEffectDetailActivity.this.hGV.aF(AlaEnterEffectDetailActivity.this.hGR.id, AlaEnterEffectDetailActivity.this.hGR.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.iX(false);
                    aVar.setAutoNight(false);
                    aVar.os(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.hGR != null) {
                                AlaEnterEffectDetailActivity.this.hGV.aF(AlaEnterEffectDetailActivity.this.hGR.id, AlaEnterEffectDetailActivity.this.hGR.use_status != 1);
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
                    aVar.bog();
                } else if (3 != AlaEnterEffectDetailActivity.this.hGR.categoryType && 2 == AlaEnterEffectDetailActivity.this.hGR.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.hGR.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.hEP != null) {
                            AlaEnterEffectDetailActivity.this.hEP.fj(AlaEnterEffectDetailActivity.this.hGR.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.hEQ != null) {
                        AlaEnterEffectDetailActivity.this.hEQ.aJ(AlaEnterEffectDetailActivity.this.hGR.id, AlaEnterEffectDetailActivity.this.hGR.propId);
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
        this.hGV = new b(this.hGW);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.hGR = (AlaEnterEffectData) serializableExtra;
        this.hGS = getIntent().getStringExtra("key_selected_effect_id");
        this.hGT = new a(getActivity(), this.hGR);
        this.hGT.a(this.hGX);
        this.hGT.cjt().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hGT.cjt());
        this.hGU = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hGT.cjt());
        this.hEP = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.hEP.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void nZ(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.hGR != null) {
                    if (AlaEnterEffectDetailActivity.this.hGR.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hGT.Il(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hGT.Il(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.hEQ = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0697a
            public void s(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.hGR != null && AlaEnterEffectDetailActivity.this.hGT != null) {
                        AlaEnterEffectDetailActivity.this.hGR.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hGT.d(AlaEnterEffectDetailActivity.this.hGR);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.hGR.id));
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
        if (this.hGR != null && this.hGU != null) {
            this.hGU.a(this.hGR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hGV != null) {
            this.hGV.onDestroy();
        }
        if (this.hGU != null) {
            this.hGU.onDestory();
        }
    }
}
