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
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ar.model.FrsArShareModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARActivity extends BaseFragmentActivity {
    private ARFragment dHs;
    private FrsArShareModel dHt;
    private String forumName;
    private String shareTitle;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Res.addResource(this);
        DuMixARConfig.setAppId("11442818");
        DuMixARConfig.setAPIKey("1efAKnGbB8iE0UZuOXRG4ZHi");
        DuMixARConfig.setSecretKey("zrwvcK9giNBal6Bv3w4METyDljmdDmGt");
        setContentView(e.h.activity_invoke_ar);
        setRequestedOrientation(1);
        if (findViewById(e.g.bdar_id_fragment_container) != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            String stringExtra = getIntent().getStringExtra("ar_id");
            String stringExtra2 = getIntent().getStringExtra("ar_type");
            this.shareTitle = getIntent().getStringExtra("name");
            int l = b.l(stringExtra2, 0);
            this.forumName = getIntent().getStringExtra("name");
            Bundle bundle2 = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ar_key", stringExtra);
                jSONObject.put("ar_type", l);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bundle2.putString(ARConfigKey.AR_VALUE, jSONObject.toString());
            if (this.dHs != null) {
                this.dHs.release();
                this.dHs = null;
            }
            this.dHs = new ARFragment();
            this.dHs.setArguments(bundle2);
            this.dHs.setARCallbackClient(new ARCallbackClient() { // from class: com.baidu.tieba.frs.ar.ARActivity.1
                @Override // com.baidu.ar.external.ARCallbackClient
                public void openUrl(String str) {
                    a.ae(ARActivity.this, str);
                }

                @Override // com.baidu.ar.external.ARCallbackClient
                public void nonsupport(String str) {
                }

                @Override // com.baidu.ar.external.ARCallbackClient
                public void share(String str, String str2, String str3, String str4, int i) {
                    if (i == 1) {
                        ARActivity.this.showLoadingView(ARActivity.this.getActivityRootView());
                        if (ARActivity.this.dHt == null) {
                            ARActivity.this.dHt = new FrsArShareModel(ARActivity.this.getPageContext(), new FrsArShareModel.a() { // from class: com.baidu.tieba.frs.ar.ARActivity.1.1
                                @Override // com.baidu.tieba.frs.ar.model.FrsArShareModel.a
                                public void nJ(String str5) {
                                    d dVar = new d();
                                    dVar.title = ARActivity.this.shareTitle;
                                    dVar.content = ARActivity.this.getString(e.j.frs_ar_share_content);
                                    dVar.linkUrl = str5;
                                    dVar.aOH = str5;
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ARActivity.this.getPageContext().getPageActivity(), dVar, false)));
                                }

                                @Override // com.baidu.tieba.frs.ar.model.FrsArShareModel.a
                                public void nI(String str5) {
                                }
                            }, ARActivity.this.forumName, str4, str4);
                        }
                        ARActivity.this.dHt.LoadData();
                        return;
                    }
                    d dVar = new d();
                    dVar.title = ARActivity.this.shareTitle;
                    dVar.content = ARActivity.this.getString(e.j.frs_ar_share_content);
                    dVar.linkUrl = str3;
                    dVar.aOH = str3;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig(ARActivity.this.getPageContext().getPageActivity(), dVar, false)));
                }
            });
            beginTransaction.replace(e.g.bdar_id_fragment_container, this.dHs);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        getSupportFragmentManager();
        boolean z = false;
        if (this.dHs != null) {
            z = this.dHs.onFragmentBackPressed();
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
