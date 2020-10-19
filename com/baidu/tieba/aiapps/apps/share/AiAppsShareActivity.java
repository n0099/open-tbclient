package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class AiAppsShareActivity extends Activity {
    private CustomMessageListener listener = new CustomMessageListener(2921376) { // from class: com.baidu.tieba.aiapps.apps.share.AiAppsShareActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366, false));
            AiAppsShareActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("options");
        if (StringUtils.isNULL(stringExtra)) {
            finish();
            return;
        }
        a aVar = new a();
        try {
            aVar.m39do(new JSONObject(stringExtra));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this, aVar, false)));
            MessageManager.getInstance().registerListener(this.listener);
        } catch (JSONException e) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.listener);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366, Boolean.valueOf(i2 == -1)));
        finish();
    }
}
