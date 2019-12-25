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
/* loaded from: classes2.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b fpA;
    private com.baidu.tieba.ala.personcenter.privilege.a fpB;
    private AlaEnterEffectData frF;
    private String frG;
    private a frH;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b frI;
    private b frJ;
    private b.a frK = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void jL(boolean z) {
            if (AlaEnterEffectDetailActivity.this.frF != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.frF.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.frF.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void zg(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0472a frL = new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0472a
        public void yC() {
            if (AlaEnterEffectDetailActivity.this.frF != null) {
                if (AlaEnterEffectDetailActivity.this.frF.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.frG) || AlaEnterEffectDetailActivity.this.frG.equals(AlaEnterEffectDetailActivity.this.frF.id)) {
                        if (AlaEnterEffectDetailActivity.this.frF != null) {
                            AlaEnterEffectDetailActivity.this.frJ.ac(AlaEnterEffectDetailActivity.this.frF.id, AlaEnterEffectDetailActivity.this.frF.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.fv(false);
                    aVar.setAutoNight(false);
                    aVar.jF(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.frF != null) {
                                AlaEnterEffectDetailActivity.this.frJ.ac(AlaEnterEffectDetailActivity.this.frF.id, AlaEnterEffectDetailActivity.this.frF.use_status != 1);
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
                    aVar.aBW();
                } else if (3 != AlaEnterEffectDetailActivity.this.frF.categoryType && 2 == AlaEnterEffectDetailActivity.this.frF.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.frF.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.fpA != null) {
                            AlaEnterEffectDetailActivity.this.fpA.cX(AlaEnterEffectDetailActivity.this.frF.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.fpB != null) {
                        AlaEnterEffectDetailActivity.this.fpB.av(AlaEnterEffectDetailActivity.this.frF.id, AlaEnterEffectDetailActivity.this.frF.propId);
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
        this.frJ = new b(this.frK);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.frF = (AlaEnterEffectData) serializableExtra;
        this.frG = getIntent().getStringExtra("key_selected_effect_id");
        this.frH = new a(getActivity(), this.frF);
        this.frH.a(this.frL);
        this.frH.bpX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.frH.bpX());
        this.frI = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.frH.bpX());
        this.fpA = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.fpA.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jK(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.frF != null) {
                    if (AlaEnterEffectDetailActivity.this.frF.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.frH.zh(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.frH.zh(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.fpB = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0465a
            public void k(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.frF != null && AlaEnterEffectDetailActivity.this.frH != null) {
                        AlaEnterEffectDetailActivity.this.frF.isOwn = true;
                        AlaEnterEffectDetailActivity.this.frH.d(AlaEnterEffectDetailActivity.this.frF);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.frF.id));
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
        if (this.frF != null && this.frI != null) {
            this.frI.a(this.frF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.frJ != null) {
            this.frJ.onDestroy();
        }
        if (this.frI != null) {
            this.frI.onDestory();
        }
    }
}
