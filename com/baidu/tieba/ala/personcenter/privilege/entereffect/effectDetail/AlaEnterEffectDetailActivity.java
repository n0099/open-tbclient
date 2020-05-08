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
    private com.baidu.tieba.ala.personcenter.privilege.b gaK;
    private com.baidu.tieba.ala.personcenter.privilege.a gaL;
    private AlaEnterEffectData gcO;
    private String gcP;
    private a gcQ;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b gcR;
    private b gcS;
    private b.a gcT = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void lf(boolean z) {
            if (AlaEnterEffectDetailActivity.this.gcO != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.gcO.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.gcO.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Br(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0541a gcU = new a.InterfaceC0541a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0541a
        public void Hx() {
            if (AlaEnterEffectDetailActivity.this.gcO != null) {
                if (AlaEnterEffectDetailActivity.this.gcO.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.gcP) || AlaEnterEffectDetailActivity.this.gcP.equals(AlaEnterEffectDetailActivity.this.gcO.id)) {
                        if (AlaEnterEffectDetailActivity.this.gcO != null) {
                            AlaEnterEffectDetailActivity.this.gcS.ai(AlaEnterEffectDetailActivity.this.gcO.id, AlaEnterEffectDetailActivity.this.gcO.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.gF(false);
                    aVar.setAutoNight(false);
                    aVar.kd(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.gcO != null) {
                                AlaEnterEffectDetailActivity.this.gcS.ai(AlaEnterEffectDetailActivity.this.gcO.id, AlaEnterEffectDetailActivity.this.gcO.use_status != 1);
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
                    aVar.aMS();
                } else if (3 != AlaEnterEffectDetailActivity.this.gcO.categoryType && 2 == AlaEnterEffectDetailActivity.this.gcO.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.gcO.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gaK != null) {
                            AlaEnterEffectDetailActivity.this.gaK.dM(AlaEnterEffectDetailActivity.this.gcO.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gaL != null) {
                        AlaEnterEffectDetailActivity.this.gaL.aE(AlaEnterEffectDetailActivity.this.gcO.id, AlaEnterEffectDetailActivity.this.gcO.propId);
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
        this.gcS = new b(this.gcT);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.gcO = (AlaEnterEffectData) serializableExtra;
        this.gcP = getIntent().getStringExtra("key_selected_effect_id");
        this.gcQ = new a(getActivity(), this.gcO);
        this.gcQ.a(this.gcU);
        this.gcQ.bCr().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.gcQ.bCr());
        this.gcR = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.gcQ.bCr());
        this.gaK = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gaK.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void le(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.gcO != null) {
                    if (AlaEnterEffectDetailActivity.this.gcO.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.gcQ.Bs(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.gcQ.Bs(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gaL = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0534a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0534a
            public void m(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.gcO != null && AlaEnterEffectDetailActivity.this.gcQ != null) {
                        AlaEnterEffectDetailActivity.this.gcO.isOwn = true;
                        AlaEnterEffectDetailActivity.this.gcQ.d(AlaEnterEffectDetailActivity.this.gcO);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.gcO.id));
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
        if (this.gcO != null && this.gcR != null) {
            this.gcR.a(this.gcO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gcS != null) {
            this.gcS.onDestroy();
        }
        if (this.gcR != null) {
            this.gcR.onDestory();
        }
    }
}
