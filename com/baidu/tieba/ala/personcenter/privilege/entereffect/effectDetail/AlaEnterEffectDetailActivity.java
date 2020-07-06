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
    private com.baidu.tieba.ala.personcenter.privilege.b gCE;
    private com.baidu.tieba.ala.personcenter.privilege.a gCF;
    private AlaEnterEffectData gEH;
    private String gEI;
    private a gEJ;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b gEK;
    private b gEL;
    private b.a gEM = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void lK(boolean z) {
            if (AlaEnterEffectDetailActivity.this.gEH != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.gEH.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.gEH.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void DB(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0600a gEN = new a.InterfaceC0600a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0600a
        public void Hd() {
            if (AlaEnterEffectDetailActivity.this.gEH != null) {
                if (AlaEnterEffectDetailActivity.this.gEH.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.gEI) || AlaEnterEffectDetailActivity.this.gEI.equals(AlaEnterEffectDetailActivity.this.gEH.id)) {
                        if (AlaEnterEffectDetailActivity.this.gEH != null) {
                            AlaEnterEffectDetailActivity.this.gEL.ax(AlaEnterEffectDetailActivity.this.gEH.id, AlaEnterEffectDetailActivity.this.gEH.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.hg(false);
                    aVar.setAutoNight(false);
                    aVar.kT(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.gEH != null) {
                                AlaEnterEffectDetailActivity.this.gEL.ax(AlaEnterEffectDetailActivity.this.gEH.id, AlaEnterEffectDetailActivity.this.gEH.use_status != 1);
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
                    aVar.aUN();
                } else if (3 != AlaEnterEffectDetailActivity.this.gEH.categoryType && 2 == AlaEnterEffectDetailActivity.this.gEH.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.gEH.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gCE != null) {
                            AlaEnterEffectDetailActivity.this.gCE.dQ(AlaEnterEffectDetailActivity.this.gEH.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gCF != null) {
                        AlaEnterEffectDetailActivity.this.gCF.aE(AlaEnterEffectDetailActivity.this.gEH.id, AlaEnterEffectDetailActivity.this.gEH.propId);
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
        this.gEL = new b(this.gEM);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.gEH = (AlaEnterEffectData) serializableExtra;
        this.gEI = getIntent().getStringExtra("key_selected_effect_id");
        this.gEJ = new a(getActivity(), this.gEH);
        this.gEJ.a(this.gEN);
        this.gEJ.bLT().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.gEJ.bLT());
        this.gEK = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.gEJ.bLT());
        this.gCE = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gCE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void lJ(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.gEH != null) {
                    if (AlaEnterEffectDetailActivity.this.gEH.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.gEJ.DC(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.gEJ.DC(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gCF = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0593a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0593a
            public void o(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.gEH != null && AlaEnterEffectDetailActivity.this.gEJ != null) {
                        AlaEnterEffectDetailActivity.this.gEH.isOwn = true;
                        AlaEnterEffectDetailActivity.this.gEJ.d(AlaEnterEffectDetailActivity.this.gEH);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.gEH.id));
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
        if (this.gEH != null && this.gEK != null) {
            this.gEK.a(this.gEH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gEL != null) {
            this.gEL.onDestroy();
        }
        if (this.gEK != null) {
            this.gEK.onDestory();
        }
    }
}
