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
    private com.baidu.tieba.ala.personcenter.privilege.b gIb;
    private com.baidu.tieba.ala.personcenter.privilege.a gIc;
    private AlaEnterEffectData gKe;
    private String gKf;
    private a gKg;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b gKh;
    private b gKi;
    private b.a gKj = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void mo(boolean z) {
            if (AlaEnterEffectDetailActivity.this.gKe != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.gKe.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.gKe.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Em(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0609a gKk = new a.InterfaceC0609a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0609a
        public void Hj() {
            if (AlaEnterEffectDetailActivity.this.gKe != null) {
                if (AlaEnterEffectDetailActivity.this.gKe.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.gKf) || AlaEnterEffectDetailActivity.this.gKf.equals(AlaEnterEffectDetailActivity.this.gKe.id)) {
                        if (AlaEnterEffectDetailActivity.this.gKe != null) {
                            AlaEnterEffectDetailActivity.this.gKi.av(AlaEnterEffectDetailActivity.this.gKe.id, AlaEnterEffectDetailActivity.this.gKe.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.hK(false);
                    aVar.setAutoNight(false);
                    aVar.ln(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.gKe != null) {
                                AlaEnterEffectDetailActivity.this.gKi.av(AlaEnterEffectDetailActivity.this.gKe.id, AlaEnterEffectDetailActivity.this.gKe.use_status != 1);
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
                    aVar.aYL();
                } else if (3 != AlaEnterEffectDetailActivity.this.gKe.categoryType && 2 == AlaEnterEffectDetailActivity.this.gKe.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.gKe.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gIb != null) {
                            AlaEnterEffectDetailActivity.this.gIb.ed(AlaEnterEffectDetailActivity.this.gKe.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gIc != null) {
                        AlaEnterEffectDetailActivity.this.gIc.aD(AlaEnterEffectDetailActivity.this.gKe.id, AlaEnterEffectDetailActivity.this.gKe.propId);
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
        this.gKi = new b(this.gKj);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.gKe = (AlaEnterEffectData) serializableExtra;
        this.gKf = getIntent().getStringExtra("key_selected_effect_id");
        this.gKg = new a(getActivity(), this.gKe);
        this.gKg.a(this.gKk);
        this.gKg.bPb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.gKg.bPb());
        this.gKh = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.gKg.bPb());
        this.gIb = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gIb.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mn(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.gKe != null) {
                    if (AlaEnterEffectDetailActivity.this.gKe.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.gKg.En(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.gKg.En(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gIc = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0602a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0602a
            public void o(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.gKe != null && AlaEnterEffectDetailActivity.this.gKg != null) {
                        AlaEnterEffectDetailActivity.this.gKe.isOwn = true;
                        AlaEnterEffectDetailActivity.this.gKg.d(AlaEnterEffectDetailActivity.this.gKe);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.gKe.id));
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
        if (this.gKe != null && this.gKh != null) {
            this.gKh.a(this.gKe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gKi != null) {
            this.gKi.onDestroy();
        }
        if (this.gKh != null) {
            this.gKh.onDestory();
        }
    }
}
