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
    private com.baidu.tieba.ala.personcenter.privilege.b gpE;
    private com.baidu.tieba.ala.personcenter.privilege.a gpF;
    private AlaEnterEffectData grI;
    private String grJ;
    private a grK;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b grL;
    private b grM;
    private b.a grN = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void lB(boolean z) {
            if (AlaEnterEffectDetailActivity.this.grI != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.grI.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.grI.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Da(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0591a grO = new a.InterfaceC0591a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0591a
        public void Jq() {
            if (AlaEnterEffectDetailActivity.this.grI != null) {
                if (AlaEnterEffectDetailActivity.this.grI.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.grJ) || AlaEnterEffectDetailActivity.this.grJ.equals(AlaEnterEffectDetailActivity.this.grI.id)) {
                        if (AlaEnterEffectDetailActivity.this.grI != null) {
                            AlaEnterEffectDetailActivity.this.grM.av(AlaEnterEffectDetailActivity.this.grI.id, AlaEnterEffectDetailActivity.this.grI.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.gX(false);
                    aVar.setAutoNight(false);
                    aVar.kD(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.grI != null) {
                                AlaEnterEffectDetailActivity.this.grM.av(AlaEnterEffectDetailActivity.this.grI.id, AlaEnterEffectDetailActivity.this.grI.use_status != 1);
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
                    aVar.aST();
                } else if (3 != AlaEnterEffectDetailActivity.this.grI.categoryType && 2 == AlaEnterEffectDetailActivity.this.grI.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.grI.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gpE != null) {
                            AlaEnterEffectDetailActivity.this.gpE.dN(AlaEnterEffectDetailActivity.this.grI.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gpF != null) {
                        AlaEnterEffectDetailActivity.this.gpF.aF(AlaEnterEffectDetailActivity.this.grI.id, AlaEnterEffectDetailActivity.this.grI.propId);
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
        this.grM = new b(this.grN);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.grI = (AlaEnterEffectData) serializableExtra;
        this.grJ = getIntent().getStringExtra("key_selected_effect_id");
        this.grK = new a(getActivity(), this.grI);
        this.grK.a(this.grO);
        this.grK.bIL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.grK.bIL());
        this.grL = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.grK.bIL());
        this.gpE = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gpE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void lA(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.grI != null) {
                    if (AlaEnterEffectDetailActivity.this.grI.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.grK.Db(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.grK.Db(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gpF = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0584a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0584a
            public void m(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.grI != null && AlaEnterEffectDetailActivity.this.grK != null) {
                        AlaEnterEffectDetailActivity.this.grI.isOwn = true;
                        AlaEnterEffectDetailActivity.this.grK.d(AlaEnterEffectDetailActivity.this.grI);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.grI.id));
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
        if (this.grI != null && this.grL != null) {
            this.grL.a(this.grI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.grM != null) {
            this.grM.onDestroy();
        }
        if (this.grL != null) {
            this.grL.onDestory();
        }
    }
}
