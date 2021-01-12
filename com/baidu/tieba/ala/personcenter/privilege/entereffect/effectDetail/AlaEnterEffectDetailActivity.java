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
    private com.baidu.tieba.ala.personcenter.privilege.b hWm;
    private com.baidu.tieba.ala.personcenter.privilege.a hWn;
    private AlaEnterEffectData hYp;
    private String hYq;
    private a hYr;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hYs;
    private b hYt;
    private b.a hYu = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void oQ(boolean z) {
            if (AlaEnterEffectDetailActivity.this.hYp != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.hYp.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.hYp.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void HL(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0692a hYv = new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0692a
        public void OB() {
            if (AlaEnterEffectDetailActivity.this.hYp != null) {
                if (AlaEnterEffectDetailActivity.this.hYp.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.hYq) || AlaEnterEffectDetailActivity.this.hYq.equals(AlaEnterEffectDetailActivity.this.hYp.id)) {
                        if (AlaEnterEffectDetailActivity.this.hYp != null) {
                            AlaEnterEffectDetailActivity.this.hYt.aH(AlaEnterEffectDetailActivity.this.hYp.id, AlaEnterEffectDetailActivity.this.hYp.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.jE(false);
                    aVar.setAutoNight(false);
                    aVar.nu(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.hYp != null) {
                                AlaEnterEffectDetailActivity.this.hYt.aH(AlaEnterEffectDetailActivity.this.hYp.id, AlaEnterEffectDetailActivity.this.hYp.use_status != 1);
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
                    aVar.bqe();
                } else if (3 != AlaEnterEffectDetailActivity.this.hYp.categoryType && 2 == AlaEnterEffectDetailActivity.this.hYp.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.hYp.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.hWm != null) {
                            AlaEnterEffectDetailActivity.this.hWm.fN(AlaEnterEffectDetailActivity.this.hYp.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.hWn != null) {
                        AlaEnterEffectDetailActivity.this.hWn.aS(AlaEnterEffectDetailActivity.this.hYp.id, AlaEnterEffectDetailActivity.this.hYp.propId);
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
        this.hYt = new b(this.hYu);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.hYp = (AlaEnterEffectData) serializableExtra;
        this.hYq = getIntent().getStringExtra("key_selected_effect_id");
        this.hYr = new a(getActivity(), this.hYp);
        this.hYr.a(this.hYv);
        this.hYr.cmp().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hYr.cmp());
        this.hYs = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hYr.cmp());
        this.hWm = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.hWm.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oP(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.hYp != null) {
                    if (AlaEnterEffectDetailActivity.this.hYp.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hYr.HM(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hYr.HM(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.hWn = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0685a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0685a
            public void r(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.hYp != null && AlaEnterEffectDetailActivity.this.hYr != null) {
                        AlaEnterEffectDetailActivity.this.hYp.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hYr.d(AlaEnterEffectDetailActivity.this.hYp);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.hYp.id));
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
        if (this.hYp != null && this.hYs != null) {
            this.hYs.a(this.hYp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hYt != null) {
            this.hYt.onDestroy();
        }
        if (this.hYs != null) {
            this.hYs.onDestory();
        }
    }
}
