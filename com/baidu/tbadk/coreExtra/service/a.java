package com.baidu.tbadk.coreExtra.service;

import android.app.ActivityManager;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.aj;
import com.baidu.tbadk.core.f;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ DealIntentService a;
    private Intent b;

    public a(DealIntentService dealIntentService, Intent intent) {
        this.a = dealIntentService;
        this.b = null;
        this.b = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        String string = this.b.getExtras().getString("privateGid");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfig.SEND_PV_TJ, string));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        String str2;
        if (this.b == null || this.b.getExtras() == null) {
            return null;
        }
        int i = this.b.getExtras().getInt("class", -1);
        if (this.b.getExtras().getBoolean("is_notify", false)) {
            b(i);
        }
        String string = this.b.getExtras().getString("stat");
        String stringExtra = this.b.getStringExtra("link");
        long j = this.b.getExtras().getLong("message_id");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp().getApplicationContext(), "cl_push_noti:" + string, "msgID:" + j);
            TiebaStatic.pushMsg(j, 2, stringExtra, string);
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TbadkApplication.m252getInst().getApp().getSystemService("activity")).getRunningTasks(500)) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(this.a.getPackageName())) {
                BdLog.d("see noti goto maintab app active");
                if (5 == this.b.getIntExtra("class", -1)) {
                    BdLog.d("see noti goto maintab");
                    if (!runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(com.baidu.tbadk.core.b.b.b())) {
                        BdLog.d("see noti goto maintab new");
                        this.b.putExtra("class", 11);
                    }
                } else if (10 == this.b.getIntExtra("class", -1)) {
                    this.b.putExtra("class", 12);
                }
                str2 = DealIntentService.ACTION_ON_POST_EXSIT;
                return str2;
            }
        }
        if (this.b.getExtras().getBoolean("is_notify", false)) {
            a(i);
        }
        BdLog.d("see noti goto maintab app not active");
        str = DealIntentService.ACTION_ON_POST_START;
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        String str2;
        String str3;
        if (str != null) {
            str2 = DealIntentService.ACTION_ON_POST_EXSIT;
            if (!str.equals(str2)) {
                str3 = DealIntentService.ACTION_ON_POST_START;
                if (str.equals(str3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new aj(this.a, this.b)));
                }
            } else {
                this.b.addFlags(268435456);
                CustomMessage customMessage = new CustomMessage(CmdConfig.DEAL_INTENT);
                customMessage.setData(this.b);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
        this.a.stopSelf();
    }

    private void a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            default:
                return;
        }
    }

    private void b(int i) {
        switch (i) {
            case 6:
                TiebaStatic.eventStat(this.a.getBaseContext(), "notify_to_pk_before", "click");
                return;
            case 7:
                TiebaStatic.eventStat(this.a.getBaseContext(), "notify_to_pk_end", "click");
                return;
            case 8:
                TiebaStatic.eventStat(this.a.getBaseContext(), "notify_to_vote_list", "click");
                return;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return;
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                f.a(this.a.getBaseContext(), "notify_group_event_click");
                return;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }
}
