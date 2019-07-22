package com.baidu.tbadk.n;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BdToken.c;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.BdToken.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
import java.io.Serializable;
/* loaded from: classes.dex */
public class b {
    private static b cyc = null;
    private a cyd;

    public static b auc() {
        if (cyc == null) {
            synchronized (b.class) {
                if (cyc == null) {
                    cyc = new b();
                }
            }
        }
        return cyc;
    }

    public void c(Application application) {
        if (application != null) {
            try {
                if (this.cyd == null) {
                    this.cyd = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.setPriority(1000);
                    intentFilter.addAction("com.baidu.tieba.action.mutiProcess");
                    application.registerReceiver(this.cyd, intentFilter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str, Parcelable parcelable) {
        auc().a(str, parcelable, null);
    }

    public static void a(String str, Serializable serializable) {
        auc().b(str, serializable);
    }

    public Intent qR(String str) {
        Intent intent = new Intent();
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("com.baidu.tieba.action.mutiProcess");
        intent.putExtra("broadcast_type", str);
        return intent;
    }

    private void a(String str, Parcelable parcelable, String str2) {
        try {
            Intent qR = qR(str);
            qR.putExtra("broadcast_data", parcelable);
            qR.putExtra("process_id", Process.myPid());
            qR.putExtra("broadcast_extra_data", str2);
            TbadkCoreApplication.getInst().sendBroadcast(qR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(String str, Serializable serializable) {
        try {
            Intent qR = qR(str);
            qR.putExtra("broadcast_data", serializable);
            TbadkCoreApplication.getInst().sendBroadcast(qR);
        } catch (Exception e) {
            e.printStackTrace();
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
                } else if ("broadcast_type_mission_message".equals(stringExtra)) {
                    b.this.T(intent);
                } else if ("broadcast_type_share_toast_status".equals(stringExtra)) {
                    b.this.V(intent);
                } else if ("broadcast_type_mission_completed".equals(stringExtra)) {
                    b.this.U(intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("broadcast_data");
            if (serializableExtra instanceof String) {
                n.vw((String) serializableExtra);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Intent intent) {
        if (TbadkCoreApplication.getInst().isMainProcess(true) && intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("broadcast_data");
            if (parcelableExtra instanceof Bundle) {
                Bundle bundle = (Bundle) parcelableExtra;
                int i = bundle.getInt("key_pageId");
                long j = bundle.getLong("thread_id");
                String string = bundle.getString("key_message_type");
                if ("onResume".equals(string)) {
                    int i2 = bundle.getInt("key_pageType");
                    c.Zg().i(i, j);
                    c.Zg().k(i2, j);
                } else if ("onPause".equals(string)) {
                    c.Zg().Zl();
                } else if ("onTouch".equals(string)) {
                    c.Zg().Zn();
                } else if ("onActivity".equals(string)) {
                    c.Zg().i(i, j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("broadcast_data");
            if (serializableExtra instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) serializableExtra;
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof o) {
                    ((o) currentActivity).onMissionCompleted(completeTaskToastData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Intent intent) {
        Bundle bundle;
        int i;
        if (TbadkCoreApplication.getInst().isMainProcess(true) && intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("broadcast_data");
            if ((parcelableExtra instanceof Bundle) && (i = (bundle = (Bundle) parcelableExtra).getInt("status")) == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921406, Integer.valueOf(i)));
                String string = bundle.getString(IntentConfig.SHARE_THREAD_ID, null);
                if (!TextUtils.isEmpty(string)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921417, string));
                }
            }
        }
    }
}
