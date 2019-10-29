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
    private AlaEnterEffectData eAV;
    private String eAW;
    private a eAX;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b eAY;
    private b eAZ;
    private b.a eBa = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void iu(boolean z) {
            if (AlaEnterEffectDetailActivity.this.eAV != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.eAV.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.eAV.id);
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
    private a.InterfaceC0388a eBb = new a.InterfaceC0388a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0388a
        public void qx() {
            if (AlaEnterEffectDetailActivity.this.eAV != null) {
                if (AlaEnterEffectDetailActivity.this.eAV.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.eAW) || AlaEnterEffectDetailActivity.this.eAW.equals(AlaEnterEffectDetailActivity.this.eAV.id)) {
                        if (AlaEnterEffectDetailActivity.this.eAV != null) {
                            AlaEnterEffectDetailActivity.this.eAZ.Y(AlaEnterEffectDetailActivity.this.eAV.id, AlaEnterEffectDetailActivity.this.eAV.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.eh(false);
                    aVar.setAutoNight(false);
                    aVar.hU(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.eAV != null) {
                                AlaEnterEffectDetailActivity.this.eAZ.Y(AlaEnterEffectDetailActivity.this.eAV.id, AlaEnterEffectDetailActivity.this.eAV.use_status != 1);
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
                    aVar.akO();
                } else if (3 != AlaEnterEffectDetailActivity.this.eAV.categoryType && 2 == AlaEnterEffectDetailActivity.this.eAV.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.eAV.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.eyQ != null) {
                            AlaEnterEffectDetailActivity.this.eyQ.cq(AlaEnterEffectDetailActivity.this.eAV.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.eyR != null) {
                        AlaEnterEffectDetailActivity.this.eyR.am(AlaEnterEffectDetailActivity.this.eAV.id, AlaEnterEffectDetailActivity.this.eAV.propId);
                    }
                }
            }
        }
    };
    private com.baidu.tieba.ala.personcenter.privilege.b eyQ;
    private com.baidu.tieba.ala.personcenter.privilege.a eyR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.eAZ = new b(this.eBa);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.eAV = (AlaEnterEffectData) serializableExtra;
        this.eAW = getIntent().getStringExtra("key_selected_effect_id");
        this.eAX = new a(getActivity(), this.eAV);
        this.eAX.a(this.eBb);
        this.eAX.aYd().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.eAX.aYd());
        this.eAY = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.eAX.aYd());
        this.eyQ = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.eyQ.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void it(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.eAV != null) {
                    if (AlaEnterEffectDetailActivity.this.eAV.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.eAX.uo(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.eAX.uo(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.eyR = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0381a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0381a
            public void j(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.eAV != null && AlaEnterEffectDetailActivity.this.eAX != null) {
                        AlaEnterEffectDetailActivity.this.eAV.isOwn = true;
                        AlaEnterEffectDetailActivity.this.eAX.d(AlaEnterEffectDetailActivity.this.eAV);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.eAV.id));
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
        if (this.eAV != null && this.eAY != null) {
            this.eAY.a(this.eAV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAZ != null) {
            this.eAZ.onDestroy();
        }
        if (this.eAY != null) {
            this.eAY.onDestory();
        }
    }
}
