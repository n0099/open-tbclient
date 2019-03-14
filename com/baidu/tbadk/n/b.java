package com.baidu.tbadk.n;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
import java.io.Serializable;
/* loaded from: classes.dex */
public class b {
    private static b coC = null;
    private a coD;

    public static b anU() {
        if (coC == null) {
            synchronized (b.class) {
                if (coC == null) {
                    coC = new b();
                }
            }
        }
        return coC;
    }

    public void c(Application application) {
        if (application != null) {
            try {
                if (this.coD == null) {
                    this.coD = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.setPriority(1000);
                    intentFilter.addAction("com.baidu.tieba.action.mutiProcess");
                    application.registerReceiver(this.coD, intentFilter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && Process.myPid() != intent.getIntExtra("process_id", -1) && "com.baidu.tieba.action.mutiProcess".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("broadcast_type");
                if ("broadcast_type_agree".equals(stringExtra)) {
                    b.this.S(intent);
                } else if ("broadcast_type_thread_history".equals(stringExtra)) {
                    b.this.R(intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("broadcast_data");
            if (serializableExtra instanceof String) {
                n.tA((String) serializableExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("broadcast_data");
            String stringExtra = intent.getStringExtra("broadcast_extra_data");
            if (serializableExtra != null && !TextUtils.isEmpty(stringExtra) && (serializableExtra instanceof AgreeData)) {
                e eVar = new e();
                eVar.agreeData = (AgreeData) serializableExtra;
                if ("isInThread".equals(stringExtra)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                } else if ("isInPost".equals(stringExtra)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
                }
            }
        }
    }
}
