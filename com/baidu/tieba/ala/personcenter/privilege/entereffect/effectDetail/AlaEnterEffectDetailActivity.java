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
    private com.baidu.tieba.ala.personcenter.privilege.b iaV;
    private com.baidu.tieba.ala.personcenter.privilege.a iaW;
    private AlaEnterEffectData icX;
    private String icY;
    private a icZ;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.b ida;
    private b idb;
    private b.a idc = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.1
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void pa(boolean z) {
            if (AlaEnterEffectDetailActivity.this.icX != null) {
                AlaEnterEffectDetailActivity.this.showToast(R.string.operation_success);
                Intent intent = new Intent();
                if (z != (AlaEnterEffectDetailActivity.this.icX.use_status == 1)) {
                    intent.putExtra("key_selected_effect_id", AlaEnterEffectDetailActivity.this.icX.id);
                    intent.putExtra("key_status_is_selected", z);
                }
                AlaEnterEffectDetailActivity.this.setResult(-1, intent);
                AlaEnterEffectDetailActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.a
        public void Iq(String str) {
            AlaEnterEffectDetailActivity.this.showToast(str);
        }
    };
    private a.InterfaceC0693a idd = new a.InterfaceC0693a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.InterfaceC0693a
        public void Qa() {
            if (AlaEnterEffectDetailActivity.this.icX != null) {
                if (AlaEnterEffectDetailActivity.this.icX.isOwn) {
                    if (TextUtils.isEmpty(AlaEnterEffectDetailActivity.this.icY) || AlaEnterEffectDetailActivity.this.icY.equals(AlaEnterEffectDetailActivity.this.icX.id)) {
                        if (AlaEnterEffectDetailActivity.this.icX != null) {
                            AlaEnterEffectDetailActivity.this.idb.aG(AlaEnterEffectDetailActivity.this.icX.id, AlaEnterEffectDetailActivity.this.icX.use_status != 1);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AlaEnterEffectDetailActivity.this.getActivity());
                    aVar.jG(false);
                    aVar.setAutoNight(false);
                    aVar.nx(R.string.ala_effect_replace_tip);
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.5.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (AlaEnterEffectDetailActivity.this.icX != null) {
                                AlaEnterEffectDetailActivity.this.idb.aG(AlaEnterEffectDetailActivity.this.icX.id, AlaEnterEffectDetailActivity.this.icX.use_status != 1);
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
                    aVar.bqx();
                } else if (3 != AlaEnterEffectDetailActivity.this.icX.categoryType && 2 == AlaEnterEffectDetailActivity.this.icX.categoryType) {
                    if (AlaEnterEffectDetailActivity.this.icX.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        if (AlaEnterEffectDetailActivity.this.iaV != null) {
                            AlaEnterEffectDetailActivity.this.iaV.fT(AlaEnterEffectDetailActivity.this.icX.price);
                        }
                    } else if (AlaEnterEffectDetailActivity.this.iaW != null) {
                        AlaEnterEffectDetailActivity.this.iaW.aS(AlaEnterEffectDetailActivity.this.icX.id, AlaEnterEffectDetailActivity.this.icX.propId);
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
        this.idb = new b(this.idc);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_effect_data");
        if (!(serializableExtra instanceof AlaEnterEffectData)) {
            showToast(R.string.tb_err_unknown);
            setResult(0);
            finish();
            return;
        }
        this.icX = (AlaEnterEffectData) serializableExtra;
        this.icY = getIntent().getStringExtra("key_selected_effect_id");
        this.icZ = new a(getActivity(), this.icX);
        this.icZ.a(this.idd);
        this.icZ.cnu().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaEnterEffectDetailActivity.this.setResult(0);
                AlaEnterEffectDetailActivity.this.finish();
            }
        });
        setContentView(this.icZ.cnu());
        this.ida = new com.baidu.tieba.ala.personcenter.privilege.entereffect.b(getActivity(), this.icZ.cnu());
        this.iaV = new com.baidu.tieba.ala.personcenter.privilege.b(getPageContext());
        this.iaV.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oZ(boolean z) {
                if (z && AlaEnterEffectDetailActivity.this.icX != null) {
                    if (AlaEnterEffectDetailActivity.this.icX.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        AlaEnterEffectDetailActivity.this.icZ.Ir(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_tdou_buy));
                    } else {
                        AlaEnterEffectDetailActivity.this.icZ.Ir(AlaEnterEffectDetailActivity.this.getString(R.string.ala_enter_effect_get_t_dou));
                    }
                }
            }
        });
        this.iaW = new com.baidu.tieba.ala.personcenter.privilege.a(getPageContext(), new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectDetailActivity.4
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0686a
            public void y(boolean z, String str) {
                if (z) {
                    if (AlaEnterEffectDetailActivity.this.icX != null && AlaEnterEffectDetailActivity.this.icZ != null) {
                        AlaEnterEffectDetailActivity.this.icX.isOwn = true;
                        AlaEnterEffectDetailActivity.this.icZ.d(AlaEnterEffectDetailActivity.this.icX);
                        AlaEnterEffectDetailActivity.this.showToast(R.string.ala_enter_effect_tdou_buy_success);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS, AlaEnterEffectDetailActivity.this.icX.id));
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
        if (this.icX != null && this.ida != null) {
            this.ida.a(this.icX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.idb != null) {
            this.idb.onDestroy();
        }
        if (this.ida != null) {
            this.ida.onDestory();
        }
    }
}
