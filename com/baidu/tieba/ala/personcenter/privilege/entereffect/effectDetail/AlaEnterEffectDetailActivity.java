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
    private com.baidu.tieba.ala.personcenter.privilege.b gpP;
    private com.baidu.tieba.ala.personcenter.privilege.a gpQ;
    private AlaEnterEffectData grT;
    private String grU;
    private a grV;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b grW;
    private b grX;
    private b.a grY = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void lB(boolean z) {
            if (AlaEnterEffectDetailActivity.this.grT != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.grT.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.grT.id);
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
    private a.InterfaceC0591a grZ = new a.InterfaceC0591a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0591a
        public void Jq() {
            if (AlaEnterEffectDetailActivity.this.grT != null) {
                if (AlaEnterEffectDetailActivity.this.grT.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.grU) || AlaEnterEffectDetailActivity.this.grU.equals(AlaEnterEffectDetailActivity.this.grT.id)) {
                        if (AlaEnterEffectDetailActivity.this.grT != null) {
                            AlaEnterEffectDetailActivity.this.grX.av(AlaEnterEffectDetailActivity.this.grT.id, AlaEnterEffectDetailActivity.this.grT.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.gX(false);
                    aVar.setAutoNight(false);
                    aVar.kF(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.grT != null) {
                                AlaEnterEffectDetailActivity.this.grX.av(AlaEnterEffectDetailActivity.this.grT.id, AlaEnterEffectDetailActivity.this.grT.use_status != 1);
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
                } else if (3 != AlaEnterEffectDetailActivity.this.grT.categoryType && 2 == AlaEnterEffectDetailActivity.this.grT.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.grT.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.gpP != null) {
                            AlaEnterEffectDetailActivity.this.gpP.dN(AlaEnterEffectDetailActivity.this.grT.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.gpQ != null) {
                        AlaEnterEffectDetailActivity.this.gpQ.aF(AlaEnterEffectDetailActivity.this.grT.id, AlaEnterEffectDetailActivity.this.grT.propId);
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
        this.grX = new b(this.grY);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.grT = (AlaEnterEffectData) serializableExtra;
        this.grU = getIntent().getStringExtra("key_selected_effect_id");
        this.grV = new a(getActivity(), this.grT);
        this.grV.a(this.grZ);
        this.grV.bIN().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.grV.bIN());
        this.grW = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.grV.bIN());
        this.gpP = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.gpP.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void lA(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.grT != null) {
                    if (AlaEnterEffectDetailActivity.this.grT.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.grV.Db(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.grV.Db(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.gpQ = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0584a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0584a
            public void m(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.grT != null && AlaEnterEffectDetailActivity.this.grV != null) {
                        AlaEnterEffectDetailActivity.this.grT.isOwn = true;
                        AlaEnterEffectDetailActivity.this.grV.d(AlaEnterEffectDetailActivity.this.grT);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.grT.id));
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
        if (this.grT != null && this.grW != null) {
            this.grW.a(this.grT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.grX != null) {
            this.grX.onDestroy();
        }
        if (this.grW != null) {
            this.grW.onDestory();
        }
    }
}
