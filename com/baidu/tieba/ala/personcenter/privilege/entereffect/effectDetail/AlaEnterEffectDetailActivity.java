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
    private com.baidu.tieba.ala.personcenter.privilege.b fwf;
    private com.baidu.tieba.ala.personcenter.privilege.a fwg;
    private AlaEnterEffectData fyj;
    private String fyk;
    private a fyl;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b fym;
    private b fyn;
    private b.a fyo = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void kb(boolean z) {
            if (AlaEnterEffectDetailActivity.this.fyj != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.fyj.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.fyj.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void zJ(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0484a fyp = new a.InterfaceC0484a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0484a
        public void Bu() {
            if (AlaEnterEffectDetailActivity.this.fyj != null) {
                if (AlaEnterEffectDetailActivity.this.fyj.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.fyk) || AlaEnterEffectDetailActivity.this.fyk.equals(AlaEnterEffectDetailActivity.this.fyj.id)) {
                        if (AlaEnterEffectDetailActivity.this.fyj != null) {
                            AlaEnterEffectDetailActivity.this.fyn.ac(AlaEnterEffectDetailActivity.this.fyj.id, AlaEnterEffectDetailActivity.this.fyj.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.fI(false);
                    aVar.setAutoNight(false);
                    aVar.jW(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.fyj != null) {
                                AlaEnterEffectDetailActivity.this.fyn.ac(AlaEnterEffectDetailActivity.this.fyj.id, AlaEnterEffectDetailActivity.this.fyj.use_status != 1);
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
                    aVar.aEG();
                } else if (3 != AlaEnterEffectDetailActivity.this.fyj.categoryType && 2 == AlaEnterEffectDetailActivity.this.fyj.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.fyj.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.fwf != null) {
                            AlaEnterEffectDetailActivity.this.fwf.de(AlaEnterEffectDetailActivity.this.fyj.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.fwg != null) {
                        AlaEnterEffectDetailActivity.this.fwg.au(AlaEnterEffectDetailActivity.this.fyj.id, AlaEnterEffectDetailActivity.this.fyj.propId);
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
        this.fyn = new b(this.fyo);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.fyj = (AlaEnterEffectData) serializableExtra;
        this.fyk = getIntent().getStringExtra("key_selected_effect_id");
        this.fyl = new a(getActivity(), this.fyj);
        this.fyl.a(this.fyp);
        this.fyl.bsL().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.fyl.bsL());
        this.fym = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.fyl.bsL());
        this.fwf = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.fwf.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ka(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.fyj != null) {
                    if (AlaEnterEffectDetailActivity.this.fyj.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.fyl.zK(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.fyl.zK(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.fwg = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.fyj != null && AlaEnterEffectDetailActivity.this.fyl != null) {
                        AlaEnterEffectDetailActivity.this.fyj.isOwn = true;
                        AlaEnterEffectDetailActivity.this.fyl.d(AlaEnterEffectDetailActivity.this.fyj);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.fyj.id));
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
        if (this.fyj != null && this.fym != null) {
            this.fym.a(this.fyj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fyn != null) {
            this.fyn.onDestroy();
        }
        if (this.fym != null) {
            this.fym.onDestory();
        }
    }
}
