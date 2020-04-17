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
/* loaded from: classes3.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b gaF;
    private com.baidu.tieba.ala.personcenter.privilege.a gaG;
    private AlaEnterEffectData gcJ;
    private String gcK;
    private a gcL;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b gcM;
    private b gcN;
    private b.a gcO = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void lf(boolean z) {
            if (AlaEnterEffectDetailActivity.this.gcJ != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.gcJ.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.gcJ.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Bo(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0520a gcP = new a.InterfaceC0520a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0520a
        public void Hy() {
            if (AlaEnterEffectDetailActivity.this.gcJ != null) {
                if (AlaEnterEffectDetailActivity.this.gcJ.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.gcK) || AlaEnterEffectDetailActivity.this.gcK.equals(AlaEnterEffectDetailActivity.this.gcJ.id)) {
                        if (AlaEnterEffectDetailActivity.this.gcJ != null) {
                            AlaEnterEffectDetailActivity.this.gcN.ai(AlaEnterEffectDetailActivity.this.gcJ.id, AlaEnterEffectDetailActivity.this.gcJ.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.gF(false);
                    aVar.setAutoNight(false);
                    aVar.kd(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.gcJ != null) {
                                AlaEnterEffectDetailActivity.this.gcN.ai(AlaEnterEffectDetailActivity.this.gcJ.id, AlaEnterEffectDetailActivity.this.gcJ.use_status != 1);
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
                    aVar.aMU();
                } else if (3 != AlaEnterEffectDetailActivity.this.gcJ.categoryType && 2 == AlaEnterEffectDetailActivity.this.gcJ.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.gcJ.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gaF != null) {
                            AlaEnterEffectDetailActivity.this.gaF.dM(AlaEnterEffectDetailActivity.this.gcJ.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gaG != null) {
                        AlaEnterEffectDetailActivity.this.gaG.aE(AlaEnterEffectDetailActivity.this.gcJ.id, AlaEnterEffectDetailActivity.this.gcJ.propId);
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
        this.gcN = new b(this.gcO);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.gcJ = (AlaEnterEffectData) serializableExtra;
        this.gcK = getIntent().getStringExtra("key_selected_effect_id");
        this.gcL = new a(getActivity(), this.gcJ);
        this.gcL.a(this.gcP);
        this.gcL.bCt().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.gcL.bCt());
        this.gcM = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.gcL.bCt());
        this.gaF = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gaF.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void le(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.gcJ != null) {
                    if (AlaEnterEffectDetailActivity.this.gcJ.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.gcL.Bp(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.gcL.Bp(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gaG = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0513a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0513a
            public void m(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.gcJ != null && AlaEnterEffectDetailActivity.this.gcL != null) {
                        AlaEnterEffectDetailActivity.this.gcJ.isOwn = true;
                        AlaEnterEffectDetailActivity.this.gcL.d(AlaEnterEffectDetailActivity.this.gcJ);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.gcJ.id));
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
        if (this.gcJ != null && this.gcM != null) {
            this.gcM.a(this.gcJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gcN != null) {
            this.gcN.onDestroy();
        }
        if (this.gcM != null) {
            this.gcM.onDestory();
        }
    }
}
