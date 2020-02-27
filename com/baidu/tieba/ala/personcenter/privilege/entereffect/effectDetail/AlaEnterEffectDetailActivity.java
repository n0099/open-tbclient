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
    private com.baidu.tieba.ala.personcenter.privilege.b fvl;
    private com.baidu.tieba.ala.personcenter.privilege.a fvm;
    private AlaEnterEffectData fxp;
    private String fxq;
    private a fxr;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b fxs;
    private b fxt;
    private b.a fxu = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void jY(boolean z) {
            if (AlaEnterEffectDetailActivity.this.fxp != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.fxp.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.fxp.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void zG(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0484a fxv = new a.InterfaceC0484a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0484a
        public void Bl() {
            if (AlaEnterEffectDetailActivity.this.fxp != null) {
                if (AlaEnterEffectDetailActivity.this.fxp.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.fxq) || AlaEnterEffectDetailActivity.this.fxq.equals(AlaEnterEffectDetailActivity.this.fxp.id)) {
                        if (AlaEnterEffectDetailActivity.this.fxp != null) {
                            AlaEnterEffectDetailActivity.this.fxt.ac(AlaEnterEffectDetailActivity.this.fxp.id, AlaEnterEffectDetailActivity.this.fxp.use_status != 1);
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
                            if (AlaEnterEffectDetailActivity.this.fxp != null) {
                                AlaEnterEffectDetailActivity.this.fxt.ac(AlaEnterEffectDetailActivity.this.fxp.id, AlaEnterEffectDetailActivity.this.fxp.use_status != 1);
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
                    aVar.aEA();
                } else if (3 != AlaEnterEffectDetailActivity.this.fxp.categoryType && 2 == AlaEnterEffectDetailActivity.this.fxp.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.fxp.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.fvl != null) {
                            AlaEnterEffectDetailActivity.this.fvl.de(AlaEnterEffectDetailActivity.this.fxp.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.fvm != null) {
                        AlaEnterEffectDetailActivity.this.fvm.au(AlaEnterEffectDetailActivity.this.fxp.id, AlaEnterEffectDetailActivity.this.fxp.propId);
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
        this.fxt = new b(this.fxu);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.fxp = (AlaEnterEffectData) serializableExtra;
        this.fxq = getIntent().getStringExtra("key_selected_effect_id");
        this.fxr = new a(getActivity(), this.fxp);
        this.fxr.a(this.fxv);
        this.fxr.bsC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.fxr.bsC());
        this.fxs = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.fxr.bsC());
        this.fvl = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.fvl.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jX(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.fxp != null) {
                    if (AlaEnterEffectDetailActivity.this.fxp.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.fxr.zH(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.fxr.zH(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.fvm = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.fxp != null && AlaEnterEffectDetailActivity.this.fxr != null) {
                        AlaEnterEffectDetailActivity.this.fxp.isOwn = true;
                        AlaEnterEffectDetailActivity.this.fxr.d(AlaEnterEffectDetailActivity.this.fxp);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.fxp.id));
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
        if (this.fxp != null && this.fxs != null) {
            this.fxs.a(this.fxp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fxt != null) {
            this.fxt.onDestroy();
        }
        if (this.fxs != null) {
            this.fxs.onDestory();
        }
    }
}
