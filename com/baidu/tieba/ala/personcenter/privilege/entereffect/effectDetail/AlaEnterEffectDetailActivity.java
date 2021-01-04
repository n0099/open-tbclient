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
/* loaded from: classes10.dex */
public class AlaEnterEffectDetailActivity extends BaseActivity {
    private com.baidu.tieba.ala.personcenter.privilege.b iaT;
    private com.baidu.tieba.ala.personcenter.privilege.a iaU;
    private AlaEnterEffectData icW;
    private String icX;
    private a icY;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b icZ;
    private b ida;
    private b.a idb = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void oU(boolean z) {
            if (AlaEnterEffectDetailActivity.this.icW != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.icW.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.icW.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void IX(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0709a idc = new a.InterfaceC0709a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0709a
        public void Sw() {
            if (AlaEnterEffectDetailActivity.this.icW != null) {
                if (AlaEnterEffectDetailActivity.this.icW.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.icX) || AlaEnterEffectDetailActivity.this.icX.equals(AlaEnterEffectDetailActivity.this.icW.id)) {
                        if (AlaEnterEffectDetailActivity.this.icW != null) {
                            AlaEnterEffectDetailActivity.this.ida.aH(AlaEnterEffectDetailActivity.this.icW.id, AlaEnterEffectDetailActivity.this.icW.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.jI(false);
                    aVar.setAutoNight(false);
                    aVar.pa(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.icW != null) {
                                AlaEnterEffectDetailActivity.this.ida.aH(AlaEnterEffectDetailActivity.this.icW.id, AlaEnterEffectDetailActivity.this.icW.use_status != 1);
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
                    aVar.btX();
                } else if (3 != AlaEnterEffectDetailActivity.this.icW.categoryType && 2 == AlaEnterEffectDetailActivity.this.icW.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.icW.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.iaT != null) {
                            AlaEnterEffectDetailActivity.this.iaT.fN(AlaEnterEffectDetailActivity.this.icW.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.iaU != null) {
                        AlaEnterEffectDetailActivity.this.iaU.aS(AlaEnterEffectDetailActivity.this.icW.id, AlaEnterEffectDetailActivity.this.icW.propId);
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
        this.ida = new b(this.idb);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.icW = (AlaEnterEffectData) serializableExtra;
        this.icX = getIntent().getStringExtra("key_selected_effect_id");
        this.icY = new a(getActivity(), this.icW);
        this.icY.a(this.idc);
        this.icY.cqg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.icY.cqg());
        this.icZ = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.icY.cqg());
        this.iaT = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.iaT.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oT(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.icW != null) {
                    if (AlaEnterEffectDetailActivity.this.icW.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.icY.IY(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.icY.IY(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.iaU = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0702a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0702a
            public void r(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.icW != null && AlaEnterEffectDetailActivity.this.icY != null) {
                        AlaEnterEffectDetailActivity.this.icW.isOwn = true;
                        AlaEnterEffectDetailActivity.this.icY.d(AlaEnterEffectDetailActivity.this.icW);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.icW.id));
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
        if (this.icW != null && this.icZ != null) {
            this.icZ.a(this.icW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ida != null) {
            this.ida.onDestroy();
        }
        if (this.icZ != null) {
            this.icZ.onDestory();
        }
    }
}
