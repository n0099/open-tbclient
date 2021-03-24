package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AiAppsShareActivity extends Activity {
    public CustomMessageListener listener = new a(2921376);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366, Boolean.FALSE));
            AiAppsShareActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366, Boolean.valueOf(i2 == -1)));
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
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
        d.b.i0.s.b.m.a aVar = new d.b.i0.s.b.m.a();
        try {
            aVar.n(new JSONObject(stringExtra));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig(this, aVar, false)));
            MessageManager.getInstance().registerListener(this.listener);
        } catch (JSONException unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.listener);
    }
}
