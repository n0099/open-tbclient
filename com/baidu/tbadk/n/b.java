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
    private static b cJG = null;
    private a cJH;

    public static b avH() {
        if (cJG == null) {
            synchronized (b.class) {
                if (cJG == null) {
                    cJG = new b();
                }
            }
        }
        return cJG;
    }

    public void d(Application application) {
        if (application != null) {
            try {
                if (this.cJH == null) {
                    this.cJH = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.setPriority(1000);
                    intentFilter.addAction("com.baidu.tieba.action.mutiProcess");
                    application.registerReceiver(this.cJH, intentFilter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str, Parcelable parcelable) {
        avH().a(str, parcelable, null);
    }

    public static void b(String str, Serializable serializable) {
        avH().c(str, serializable);
    }

    public Intent qb(String str) {
        Intent intent = new Intent();
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("com.baidu.tieba.action.mutiProcess");
        intent.putExtra("broadcast_type", str);
        return intent;
    }

    private void a(String str, Parcelable parcelable, String str2) {
        try {
            Intent qb = qb(str);
            qb.putExtra("broadcast_data", parcelable);
            qb.putExtra("process_id", Process.myPid());
            qb.putExtra("broadcast_extra_data", str2);
            TbadkCoreApplication.getInst().sendBroadcast(qb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(String str, Serializable serializable) {
        try {
            Intent qb = qb(str);
            qb.putExtra("broadcast_data", serializable);
            TbadkCoreApplication.getInst().sendBroadcast(qb);
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
                    b.this.aa(intent);
                } else if ("broadcast_type_thread_history".equals(stringExtra)) {
                    b.this.Z(intent);
                } else if ("broadcast_type_mission_message".equals(stringExtra)) {
                    b.this.ab(intent);
                } else if ("broadcast_type_share_toast_status".equals(stringExtra)) {
                    b.this.ad(intent);
                } else if ("broadcast_type_mission_completed".equals(stringExtra)) {
                    b.this.ac(intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("broadcast_data");
            if (serializableExtra instanceof String) {
                n.uz((String) serializableExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Intent intent) {
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
    public void ab(Intent intent) {
        if (TbadkCoreApplication.getInst().isMainProcess(true) && intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("broadcast_data");
            if (parcelableExtra instanceof Bundle) {
                Bundle bundle = (Bundle) parcelableExtra;
                int i = bundle.getInt("key_pageId");
                long j = bundle.getLong("thread_id");
                String string = bundle.getString("key_message_type");
                if ("onResume".equals(string)) {
                    int i2 = bundle.getInt("key_pageType");
                    c.adX().g(i, j);
                    c.adX().i(i2, j);
                } else if ("onPause".equals(string)) {
                    c.adX().aec();
                } else if ("onTouch".equals(string)) {
                    c.adX().aee();
                } else if ("onActivity".equals(string)) {
                    c.adX().g(i, j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(Intent intent) {
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
    public void ad(Intent intent) {
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
