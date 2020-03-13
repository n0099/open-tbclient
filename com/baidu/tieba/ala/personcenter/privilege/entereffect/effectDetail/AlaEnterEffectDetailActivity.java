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
    private com.baidu.tieba.ala.personcenter.privilege.a fvA;
    private com.baidu.tieba.ala.personcenter.privilege.b fvz;
    private AlaEnterEffectData fxD;
    private String fxE;
    private a fxF;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b fxG;
    private b fxH;
    private b.a fxI = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void jY(boolean z) {
            if (AlaEnterEffectDetailActivity.this.fxD != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.fxD.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.fxD.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void zH(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0484a fxJ = new a.InterfaceC0484a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0484a
        public void Bn() {
            if (AlaEnterEffectDetailActivity.this.fxD != null) {
                if (AlaEnterEffectDetailActivity.this.fxD.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.fxE) || AlaEnterEffectDetailActivity.this.fxE.equals(AlaEnterEffectDetailActivity.this.fxD.id)) {
                        if (AlaEnterEffectDetailActivity.this.fxD != null) {
                            AlaEnterEffectDetailActivity.this.fxH.ac(AlaEnterEffectDetailActivity.this.fxD.id, AlaEnterEffectDetailActivity.this.fxD.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.fH(false);
                    aVar.setAutoNight(false);
                    aVar.jW(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.fxD != null) {
                                AlaEnterEffectDetailActivity.this.fxH.ac(AlaEnterEffectDetailActivity.this.fxD.id, AlaEnterEffectDetailActivity.this.fxD.use_status != 1);
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
                    aVar.aEC();
                } else if (3 != AlaEnterEffectDetailActivity.this.fxD.categoryType && 2 == AlaEnterEffectDetailActivity.this.fxD.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.fxD.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.fvz != null) {
                            AlaEnterEffectDetailActivity.this.fvz.de(AlaEnterEffectDetailActivity.this.fxD.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.fvA != null) {
                        AlaEnterEffectDetailActivity.this.fvA.au(AlaEnterEffectDetailActivity.this.fxD.id, AlaEnterEffectDetailActivity.this.fxD.propId);
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
        this.fxH = new b(this.fxI);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.fxD = (AlaEnterEffectData) serializableExtra;
        this.fxE = getIntent().getStringExtra("key_selected_effect_id");
        this.fxF = new a(getActivity(), this.fxD);
        this.fxF.a(this.fxJ);
        this.fxF.bsF().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.fxF.bsF());
        this.fxG = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.fxF.bsF());
        this.fvz = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.fvz.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jX(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.fxD != null) {
                    if (AlaEnterEffectDetailActivity.this.fxD.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.fxF.zI(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.fxF.zI(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.fvA = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.fxD != null && AlaEnterEffectDetailActivity.this.fxF != null) {
                        AlaEnterEffectDetailActivity.this.fxD.isOwn = true;
                        AlaEnterEffectDetailActivity.this.fxF.d(AlaEnterEffectDetailActivity.this.fxD);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.fxD.id));
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
        if (this.fxD != null && this.fxG != null) {
            this.fxG.a(this.fxD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fxH != null) {
            this.fxH.onDestroy();
        }
        if (this.fxG != null) {
            this.fxG.onDestory();
        }
    }
}
