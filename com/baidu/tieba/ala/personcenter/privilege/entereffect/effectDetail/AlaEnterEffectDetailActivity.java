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
/* loaded from: classes9.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b icE;
    private com.baidu.tieba.ala.personcenter.privilege.a icF;
    private AlaEnterEffectData ieK;
    private String ieL;
    private a ieM;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b ieN;
    private b ieO;
    private b.a ieP = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void pa(boolean z) {
            if (AlaEnterEffectDetailActivity.this.ieK != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.ieK.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.ieK.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Iz(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0699a ieQ = new a.InterfaceC0699a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0699a
        public void Qd() {
            if (AlaEnterEffectDetailActivity.this.ieK != null) {
                if (AlaEnterEffectDetailActivity.this.ieK.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.ieL) || AlaEnterEffectDetailActivity.this.ieL.equals(AlaEnterEffectDetailActivity.this.ieK.id)) {
                        if (AlaEnterEffectDetailActivity.this.ieK != null) {
                            AlaEnterEffectDetailActivity.this.ieO.aG(AlaEnterEffectDetailActivity.this.ieK.id, AlaEnterEffectDetailActivity.this.ieK.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.jG(false);
                    aVar.setAutoNight(false);
                    aVar.ny(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.ieK != null) {
                                AlaEnterEffectDetailActivity.this.ieO.aG(AlaEnterEffectDetailActivity.this.ieK.id, AlaEnterEffectDetailActivity.this.ieK.use_status != 1);
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
                    aVar.bqz();
                } else if (3 != AlaEnterEffectDetailActivity.this.ieK.categoryType && 2 == AlaEnterEffectDetailActivity.this.ieK.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.ieK.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.icE != null) {
                            AlaEnterEffectDetailActivity.this.icE.fT(AlaEnterEffectDetailActivity.this.ieK.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.icF != null) {
                        AlaEnterEffectDetailActivity.this.icF.aT(AlaEnterEffectDetailActivity.this.ieK.id, AlaEnterEffectDetailActivity.this.ieK.propId);
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
        this.ieO = new b(this.ieP);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.ieK = (AlaEnterEffectData) serializableExtra;
        this.ieL = getIntent().getStringExtra("key_selected_effect_id");
        this.ieM = new a(getActivity(), this.ieK);
        this.ieM.a(this.ieQ);
        this.ieM.cnA().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.ieM.cnA());
        this.ieN = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.ieM.cnA());
        this.icE = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.icE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oZ(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.ieK != null) {
                    if (AlaEnterEffectDetailActivity.this.ieK.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.ieM.IA(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.ieM.IA(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.icF = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0692a
            public void y(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.ieK != null && AlaEnterEffectDetailActivity.this.ieM != null) {
                        AlaEnterEffectDetailActivity.this.ieK.isOwn = true;
                        AlaEnterEffectDetailActivity.this.ieM.d(AlaEnterEffectDetailActivity.this.ieK);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.ieK.id));
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
        if (this.ieK != null && this.ieN != null) {
            this.ieN.a(this.ieK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ieO != null) {
            this.ieO.onDestroy();
        }
        if (this.ieN != null) {
            this.ieN.onDestory();
        }
    }
}
