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
    private AlaEnterEffectData eAe;
    private String eAf;
    private a eAg;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b eAh;
    private b eAi;
    private b.a eAj = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void iu(boolean z) {
            if (AlaEnterEffectDetailActivity.this.eAe != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.eAe.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.eAe.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void un(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0388a eAk = new a.InterfaceC0388a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0388a
        public void qy() {
            if (AlaEnterEffectDetailActivity.this.eAe != null) {
                if (AlaEnterEffectDetailActivity.this.eAe.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.eAf) || AlaEnterEffectDetailActivity.this.eAf.equals(AlaEnterEffectDetailActivity.this.eAe.id)) {
                        if (AlaEnterEffectDetailActivity.this.eAe != null) {
                            AlaEnterEffectDetailActivity.this.eAi.Y(AlaEnterEffectDetailActivity.this.eAe.id, AlaEnterEffectDetailActivity.this.eAe.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.eh(false);
                    aVar.setAutoNight(false);
                    aVar.hT(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.eAe != null) {
                                AlaEnterEffectDetailActivity.this.eAi.Y(AlaEnterEffectDetailActivity.this.eAe.id, AlaEnterEffectDetailActivity.this.eAe.use_status != 1);
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
                    aVar.akM();
                } else if (3 != AlaEnterEffectDetailActivity.this.eAe.categoryType && 2 == AlaEnterEffectDetailActivity.this.eAe.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.eAe.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.exY != null) {
                            AlaEnterEffectDetailActivity.this.exY.cp(AlaEnterEffectDetailActivity.this.eAe.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.exZ != null) {
                        AlaEnterEffectDetailActivity.this.exZ.am(AlaEnterEffectDetailActivity.this.eAe.id, AlaEnterEffectDetailActivity.this.eAe.propId);
                    }
                }
            }
        }
    };
    private com.baidu.tieba.ala.personcenter.privilege.b exY;
    private com.baidu.tieba.ala.personcenter.privilege.a exZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.eAi = new b(this.eAj);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.eAe = (AlaEnterEffectData) serializableExtra;
        this.eAf = getIntent().getStringExtra("key_selected_effect_id");
        this.eAg = new a(getActivity(), this.eAe);
        this.eAg.a(this.eAk);
        this.eAg.aYb().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.eAg.aYb());
        this.eAh = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.eAg.aYb());
        this.exY = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.exY.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void it(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.eAe != null) {
                    if (AlaEnterEffectDetailActivity.this.eAe.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.eAg.uo(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.eAg.uo(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.exZ = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0381a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0381a
            public void j(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.eAe != null && AlaEnterEffectDetailActivity.this.eAg != null) {
                        AlaEnterEffectDetailActivity.this.eAe.isOwn = true;
                        AlaEnterEffectDetailActivity.this.eAg.d(AlaEnterEffectDetailActivity.this.eAe);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.eAe.id));
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
        if (this.eAe != null && this.eAh != null) {
            this.eAh.a(this.eAe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAi != null) {
            this.eAi.onDestroy();
        }
        if (this.eAh != null) {
            this.eAh.onDestory();
        }
    }
}
