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
    private com.baidu.tieba.ala.personcenter.privilege.b fsJ;
    private com.baidu.tieba.ala.personcenter.privilege.a fsK;
    private AlaEnterEffectData fuO;
    private String fuP;
    private a fuQ;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b fuR;
    private b fuS;
    private b.a fuT = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void jW(boolean z) {
            if (AlaEnterEffectDetailActivity.this.fuO != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.fuO.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.fuO.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void zp(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0476a fuU = new a.InterfaceC0476a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0476a
        public void yV() {
            if (AlaEnterEffectDetailActivity.this.fuO != null) {
                if (AlaEnterEffectDetailActivity.this.fuO.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.fuP) || AlaEnterEffectDetailActivity.this.fuP.equals(AlaEnterEffectDetailActivity.this.fuO.id)) {
                        if (AlaEnterEffectDetailActivity.this.fuO != null) {
                            AlaEnterEffectDetailActivity.this.fuS.ac(AlaEnterEffectDetailActivity.this.fuO.id, AlaEnterEffectDetailActivity.this.fuO.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.fA(false);
                    aVar.setAutoNight(false);
                    aVar.jF(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.fuO != null) {
                                AlaEnterEffectDetailActivity.this.fuS.ac(AlaEnterEffectDetailActivity.this.fuO.id, AlaEnterEffectDetailActivity.this.fuO.use_status != 1);
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
                    aVar.aCp();
                } else if (3 != AlaEnterEffectDetailActivity.this.fuO.categoryType && 2 == AlaEnterEffectDetailActivity.this.fuO.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.fuO.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.fsJ != null) {
                            AlaEnterEffectDetailActivity.this.fsJ.dc(AlaEnterEffectDetailActivity.this.fuO.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.fsK != null) {
                        AlaEnterEffectDetailActivity.this.fsK.aw(AlaEnterEffectDetailActivity.this.fuO.id, AlaEnterEffectDetailActivity.this.fuO.propId);
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
        this.fuS = new b(this.fuT);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.fuO = (AlaEnterEffectData) serializableExtra;
        this.fuP = getIntent().getStringExtra("key_selected_effect_id");
        this.fuQ = new a(getActivity(), this.fuO);
        this.fuQ.a(this.fuU);
        this.fuQ.bqY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.fuQ.bqY());
        this.fuR = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.fuQ.bqY());
        this.fsJ = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.fsJ.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jV(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.fuO != null) {
                    if (AlaEnterEffectDetailActivity.this.fuO.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.fuQ.zq(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.fuQ.zq(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.fsK = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0469a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0469a
            public void k(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.fuO != null && AlaEnterEffectDetailActivity.this.fuQ != null) {
                        AlaEnterEffectDetailActivity.this.fuO.isOwn = true;
                        AlaEnterEffectDetailActivity.this.fuQ.d(AlaEnterEffectDetailActivity.this.fuO);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.fuO.id));
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
        if (this.fuO != null && this.fuR != null) {
            this.fuR.a(this.fuO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fuS != null) {
            this.fuS.onDestroy();
        }
        if (this.fuR != null) {
            this.fuR.onDestory();
        }
    }
}
