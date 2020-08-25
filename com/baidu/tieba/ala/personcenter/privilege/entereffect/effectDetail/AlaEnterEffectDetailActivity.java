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
    private com.baidu.tieba.ala.personcenter.privilege.b gUE;
    private com.baidu.tieba.ala.personcenter.privilege.a gUF;
    private AlaEnterEffectData gWG;
    private String gWH;
    private a gWI;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b gWJ;
    private b gWK;
    private b.a gWL = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void mQ(boolean z) {
            if (AlaEnterEffectDetailActivity.this.gWG != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.gWG.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.gWG.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void GL(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0659a gWM = new a.InterfaceC0659a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0659a
        public void Nb() {
            if (AlaEnterEffectDetailActivity.this.gWG != null) {
                if (AlaEnterEffectDetailActivity.this.gWG.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.gWH) || AlaEnterEffectDetailActivity.this.gWH.equals(AlaEnterEffectDetailActivity.this.gWG.id)) {
                        if (AlaEnterEffectDetailActivity.this.gWG != null) {
                            AlaEnterEffectDetailActivity.this.gWK.az(AlaEnterEffectDetailActivity.this.gWG.id, AlaEnterEffectDetailActivity.this.gWG.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.ig(false);
                    aVar.setAutoNight(false);
                    aVar.nt(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.gWG != null) {
                                AlaEnterEffectDetailActivity.this.gWK.az(AlaEnterEffectDetailActivity.this.gWG.id, AlaEnterEffectDetailActivity.this.gWG.use_status != 1);
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
                } else if (3 != AlaEnterEffectDetailActivity.this.gWG.categoryType && 2 == AlaEnterEffectDetailActivity.this.gWG.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.gWG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gUE != null) {
                            AlaEnterEffectDetailActivity.this.gUE.eo(AlaEnterEffectDetailActivity.this.gWG.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gUF != null) {
                        AlaEnterEffectDetailActivity.this.gUF.aG(AlaEnterEffectDetailActivity.this.gWG.id, AlaEnterEffectDetailActivity.this.gWG.propId);
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
        this.gWK = new b(this.gWL);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.gWG = (AlaEnterEffectData) serializableExtra;
        this.gWH = getIntent().getStringExtra("key_selected_effect_id");
        this.gWI = new a(getActivity(), this.gWG);
        this.gWI.a(this.gWM);
        this.gWI.bZb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.gWI.bZb());
        this.gWJ = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.gWI.bZb());
        this.gUE = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gUE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mP(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.gWG != null) {
                    if (AlaEnterEffectDetailActivity.this.gWG.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.gWI.GM(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.gWI.GM(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gUF = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0652a
            public void p(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.gWG != null && AlaEnterEffectDetailActivity.this.gWI != null) {
                        AlaEnterEffectDetailActivity.this.gWG.isOwn = true;
                        AlaEnterEffectDetailActivity.this.gWI.d(AlaEnterEffectDetailActivity.this.gWG);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.gWG.id));
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
        if (this.gWG != null && this.gWJ != null) {
            this.gWJ.a(this.gWG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gWK != null) {
            this.gWK.onDestroy();
        }
        if (this.gWJ != null) {
            this.gWJ.onDestory();
        }
    }
}
