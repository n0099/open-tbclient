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
/* loaded from: classes6.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b hOw;
    private com.baidu.tieba.ala.personcenter.privilege.a hOx;
    private a hQA;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hQB;
    private b hQC;
    private b.a hQD = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void ov(boolean z) {
            if (AlaEnterEffectDetailActivity.this.hQy != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.hQy.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.hQy.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void IZ(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0717a hQE = new a.InterfaceC0717a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0717a
        public void Rt() {
            if (AlaEnterEffectDetailActivity.this.hQy != null) {
                if (AlaEnterEffectDetailActivity.this.hQy.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.hQz) || AlaEnterEffectDetailActivity.this.hQz.equals(AlaEnterEffectDetailActivity.this.hQy.id)) {
                        if (AlaEnterEffectDetailActivity.this.hQy != null) {
                            AlaEnterEffectDetailActivity.this.hQC.aG(AlaEnterEffectDetailActivity.this.hQy.id, AlaEnterEffectDetailActivity.this.hQy.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.jm(false);
                    aVar.setAutoNight(false);
                    aVar.oQ(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.hQy != null) {
                                AlaEnterEffectDetailActivity.this.hQC.aG(AlaEnterEffectDetailActivity.this.hQy.id, AlaEnterEffectDetailActivity.this.hQy.use_status != 1);
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
                    aVar.brv();
                } else if (3 != AlaEnterEffectDetailActivity.this.hQy.categoryType && 2 == AlaEnterEffectDetailActivity.this.hQy.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.hQy.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.hOw != null) {
                            AlaEnterEffectDetailActivity.this.hOw.fN(AlaEnterEffectDetailActivity.this.hQy.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.hOx != null) {
                        AlaEnterEffectDetailActivity.this.hOx.aK(AlaEnterEffectDetailActivity.this.hQy.id, AlaEnterEffectDetailActivity.this.hQy.propId);
                    }
                }
            }
        }
    };
    private AlaEnterEffectData hQy;
    private String hQz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.hQC = new b(this.hQD);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.hQy = (AlaEnterEffectData) serializableExtra;
        this.hQz = getIntent().getStringExtra("key_selected_effect_id");
        this.hQA = new a(getActivity(), this.hQy);
        this.hQA.a(this.hQE);
        this.hQA.cnn().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hQA.cnn());
        this.hQB = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hQA.cnn());
        this.hOw = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.hOw.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ou(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.hQy != null) {
                    if (AlaEnterEffectDetailActivity.this.hQy.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hQA.Ja(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hQA.Ja(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.hOx = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0710a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0710a
            public void r(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.hQy != null && AlaEnterEffectDetailActivity.this.hQA != null) {
                        AlaEnterEffectDetailActivity.this.hQy.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hQA.d(AlaEnterEffectDetailActivity.this.hQy);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.hQy.id));
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
        if (this.hQy != null && this.hQB != null) {
            this.hQB.a(this.hQy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hQC != null) {
            this.hQC.onDestroy();
        }
        if (this.hQB != null) {
            this.hQB.onDestory();
        }
    }
}
