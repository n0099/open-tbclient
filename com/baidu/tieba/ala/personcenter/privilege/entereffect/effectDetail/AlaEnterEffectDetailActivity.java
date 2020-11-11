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
    private com.baidu.tieba.ala.personcenter.privilege.b hFi;
    private com.baidu.tieba.ala.personcenter.privilege.a hFj;
    private AlaEnterEffectData hHk;
    private String hHl;
    private a hHm;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hHn;
    private b hHo;
    private b.a hHp = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void nZ(boolean z) {
            if (AlaEnterEffectDetailActivity.this.hHk != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.hHk.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.hHk.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void IJ(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0704a hHq = new a.InterfaceC0704a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0704a
        public void PI() {
            if (AlaEnterEffectDetailActivity.this.hHk != null) {
                if (AlaEnterEffectDetailActivity.this.hHk.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.hHl) || AlaEnterEffectDetailActivity.this.hHl.equals(AlaEnterEffectDetailActivity.this.hHk.id)) {
                        if (AlaEnterEffectDetailActivity.this.hHk != null) {
                            AlaEnterEffectDetailActivity.this.hHo.aF(AlaEnterEffectDetailActivity.this.hHk.id, AlaEnterEffectDetailActivity.this.hHk.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.iW(false);
                    aVar.setAutoNight(false);
                    aVar.ow(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.hHk != null) {
                                AlaEnterEffectDetailActivity.this.hHo.aF(AlaEnterEffectDetailActivity.this.hHk.id, AlaEnterEffectDetailActivity.this.hHk.use_status != 1);
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
                    aVar.bpc();
                } else if (3 != AlaEnterEffectDetailActivity.this.hHk.categoryType && 2 == AlaEnterEffectDetailActivity.this.hHk.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.hHk.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.hFi != null) {
                            AlaEnterEffectDetailActivity.this.hFi.fj(AlaEnterEffectDetailActivity.this.hHk.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.hFj != null) {
                        AlaEnterEffectDetailActivity.this.hFj.aK(AlaEnterEffectDetailActivity.this.hHk.id, AlaEnterEffectDetailActivity.this.hHk.propId);
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
        this.hHo = new b(this.hHp);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.hHk = (AlaEnterEffectData) serializableExtra;
        this.hHl = getIntent().getStringExtra("key_selected_effect_id");
        this.hHm = new a(getActivity(), this.hHk);
        this.hHm.a(this.hHq);
        this.hHm.cka().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hHm.cka());
        this.hHn = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hHm.cka());
        this.hFi = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.hFi.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void nY(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.hHk != null) {
                    if (AlaEnterEffectDetailActivity.this.hHk.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hHm.IK(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hHm.IK(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.hFj = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0697a
            public void r(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.hHk != null && AlaEnterEffectDetailActivity.this.hHm != null) {
                        AlaEnterEffectDetailActivity.this.hHk.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hHm.d(AlaEnterEffectDetailActivity.this.hHk);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.hHk.id));
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
        if (this.hHk != null && this.hHn != null) {
            this.hHn.a(this.hHk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hHo != null) {
            this.hHo.onDestroy();
        }
        if (this.hHn != null) {
            this.hHn.onDestory();
        }
    }
}
