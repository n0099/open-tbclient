package com.baidu.tieba.frs.ar;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.ar.ARFragment;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.external.ARCallbackClient;
import com.baidu.ar.util.Res;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar.model.FrsArShareModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARActivity extends BaseFragmentActivity {
    private ARFragment drP;
    private FrsArShareModel drQ;
    private String forumName;
    private String shareTitle;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Res.addResource(this);
        DuMixARConfig.setAppId("11442818");
        DuMixARConfig.setAPIKey("1efAKnGbB8iE0UZuOXRG4ZHi");
        DuMixARConfig.setSecretKey("zrwvcK9giNBal6Bv3w4METyDljmdDmGt");
        setContentView(d.h.activity_invoke_ar);
        setRequestedOrientation(1);
        if (findViewById(d.g.bdar_id_fragment_container) != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            String stringExtra = getIntent().getStringExtra("ar_id");
            String stringExtra2 = getIntent().getStringExtra("ar_type");
            this.shareTitle = getIntent().getStringExtra("name");
            int g = b.g(stringExtra2, 0);
            this.forumName = getIntent().getStringExtra("name");
            Bundle bundle2 = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ar_key", stringExtra);
                jSONObject.put("ar_type", g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bundle2.putString(ARConfigKey.AR_VALUE, jSONObject.toString());
            if (this.drP != null) {
                this.drP.release();
                this.drP = null;
            }
            this.drP = new ARFragment();
            this.drP.setArguments(bundle2);
            this.drP.setARCallbackClient(new ARCallbackClient() { // from class: com.baidu.tieba.frs.ar.ARActivity.1
                @Override // com.baidu.ar.external.ARCallbackClient
                public void openUrl(String str) {
                    a.S(ARActivity.this, str);
                }

                @Override // com.baidu.ar.external.ARCallbackClient
                public void nonsupport(String str) {
                }

                @Override // com.baidu.ar.external.ARCallbackClient
                public void share(String str, String str2, String str3, String str4, int i) {
                    if (i == 1) {
                        ARActivity.this.showLoadingView(ARActivity.this.getActivityRootView());
                        if (ARActivity.this.drQ == null) {
                            ARActivity.this.drQ = new FrsArShareModel(ARActivity.this.getPageContext(), new FrsArShareModel.a() { // from class: com.baidu.tieba.frs.ar.ARActivity.1.1
                                @Override // com.baidu.tieba.frs.ar.model.FrsArShareModel.a
                                public void mB(String str5) {
                                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                    dVar.title = ARActivity.this.shareTitle;
                                    dVar.content = ARActivity.this.getString(d.j.frs_ar_share_content);
                                    dVar.linkUrl = str5;
                                    dVar.aGc = str5;
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ARActivity.this.getPageContext().getPageActivity(), dVar, false)));
                                }

                                @Override // com.baidu.tieba.frs.ar.model.FrsArShareModel.a
                                public void mA(String str5) {
                                }
                            }, ARActivity.this.forumName, str4, str4);
                        }
                        ARActivity.this.drQ.LoadData();
                        return;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = ARActivity.this.shareTitle;
                    dVar.content = ARActivity.this.getString(d.j.frs_ar_share_content);
                    dVar.linkUrl = str3;
                    dVar.aGc = str3;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ARActivity.this.getPageContext().getPageActivity(), dVar, false)));
                }
            });
            beginTransaction.replace(d.g.bdar_id_fragment_container, this.drP);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        getSupportFragmentManager();
        boolean z = false;
        if (this.drP != null) {
            z = this.drP.onFragmentBackPressed();
        }
        if (!z) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Res.removeResource(getPackageName());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
