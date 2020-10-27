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
    private AlaEnterEffectData hBn;
    private String hBo;
    private a hBp;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b hBq;
    private b hBr;
    private b.a hBs = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void nQ(boolean z) {
            if (AlaEnterEffectDetailActivity.this.hBn != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.hBn.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.hBn.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Is(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0690a hBt = new a.InterfaceC0690a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0690a
        public void Pi() {
            if (AlaEnterEffectDetailActivity.this.hBn != null) {
                if (AlaEnterEffectDetailActivity.this.hBn.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.hBo) || AlaEnterEffectDetailActivity.this.hBo.equals(AlaEnterEffectDetailActivity.this.hBn.id)) {
                        if (AlaEnterEffectDetailActivity.this.hBn != null) {
                            AlaEnterEffectDetailActivity.this.hBr.aF(AlaEnterEffectDetailActivity.this.hBn.id, AlaEnterEffectDetailActivity.this.hBn.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.iN(false);
                    aVar.setAutoNight(false);
                    aVar.om(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.hBn != null) {
                                AlaEnterEffectDetailActivity.this.hBr.aF(AlaEnterEffectDetailActivity.this.hBn.id, AlaEnterEffectDetailActivity.this.hBn.use_status != 1);
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
                    aVar.bmC();
                } else if (3 != AlaEnterEffectDetailActivity.this.hBn.categoryType && 2 == AlaEnterEffectDetailActivity.this.hBn.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.hBn.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.hzl != null) {
                            AlaEnterEffectDetailActivity.this.hzl.eN(AlaEnterEffectDetailActivity.this.hBn.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.hzm != null) {
                        AlaEnterEffectDetailActivity.this.hzm.aI(AlaEnterEffectDetailActivity.this.hBn.id, AlaEnterEffectDetailActivity.this.hBn.propId);
                    }
                }
            }
        }
    };
    private com.baidu.tieba.ala.personcenter.privilege.b hzl;
    private com.baidu.tieba.ala.personcenter.privilege.a hzm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.hBr = new b(this.hBs);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.hBn = (AlaEnterEffectData) serializableExtra;
        this.hBo = getIntent().getStringExtra("key_selected_effect_id");
        this.hBp = new a(getActivity(), this.hBn);
        this.hBp.a(this.hBt);
        this.hBp.chy().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.hBp.chy());
        this.hBq = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.hBp.chy());
        this.hzl = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.hzl.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void nP(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.hBn != null) {
                    if (AlaEnterEffectDetailActivity.this.hBn.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.hBp.It(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.hBp.It(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.hzm = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0683a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0683a
            public void r(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.hBn != null && AlaEnterEffectDetailActivity.this.hBp != null) {
                        AlaEnterEffectDetailActivity.this.hBn.isOwn = true;
                        AlaEnterEffectDetailActivity.this.hBp.d(AlaEnterEffectDetailActivity.this.hBn);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.hBn.id));
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
        if (this.hBn != null && this.hBq != null) {
            this.hBq.a(this.hBn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hBr != null) {
            this.hBr.onDestroy();
        }
        if (this.hBq != null) {
            this.hBq.onDestory();
        }
    }
}
