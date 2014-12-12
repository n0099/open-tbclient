package com.baidu.tbadk.coreExtra.service;

import android.app.ActivityManager;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.b.b;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ DealIntentService Ss;
    private Intent intent;

    public a(DealIntentService dealIntentService, Intent intent) {
        this.Ss = dealIntentService;
        this.intent = null;
        this.intent = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        String string = this.intent.getExtras().getString("privateGid");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2012110, string));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        String str2;
        if (this.intent == null || this.intent.getExtras() == null) {
            return null;
        }
        int i = this.intent.getExtras().getInt("class", -1);
        if (this.intent.getExtras().getBoolean("is_notify", false)) {
            cQ(i);
        }
        String string = this.intent.getExtras().getString("stat");
        String stringExtra = this.intent.getStringExtra("link");
        long j = this.intent.getExtras().getLong("task_id");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp().getApplicationContext(), "cl_push_noti:" + string, "taskId:" + j + ";link:" + stringExtra + ";uid:" + TbadkCoreApplication.getCurrentAccount());
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkCoreApplication.m255getInst().getApp().getSystemService("activity")).getRunningTasks(500);
        String mentionActivityClassName = SingleMentionActivityConfig.getMentionActivityClassName();
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(this.Ss.getPackageName())) {
                if (5 == this.intent.getIntExtra("class", -1)) {
                    if (!runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(b.oa())) {
                        this.intent.putExtra("class", 11);
                    }
                    if (mentionActivityClassName != null && runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(mentionActivityClassName)) {
                        this.intent.putExtra("class", 21);
                    }
                } else if (10 == this.intent.getIntExtra("class", -1)) {
                    this.intent.putExtra("class", 12);
                }
                str2 = DealIntentService.ACTION_ON_POST_EXSIT;
                return str2;
            }
        }
        if (i == 27) {
            TiebaStatic.eventStat(this.Ss.getBaseContext(), "open_push", com.baidu.tbadk.core.frameworkData.a.START, 1, new Object[0]);
        }
        if (this.intent.getExtras().getBoolean("is_notify", false)) {
            cP(i);
        }
        str = DealIntentService.ACTION_ON_POST_START;
        return str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        String str2;
        String str3;
        if (str != null) {
            str2 = DealIntentService.ACTION_ON_POST_EXSIT;
            if (!str.equals(str2)) {
                str3 = DealIntentService.ACTION_ON_POST_START;
                if (str.equals(str3)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this.Ss, this.intent)));
                }
            } else {
                this.intent.addFlags(268435456);
                CustomMessage customMessage = new CustomMessage(2012000);
                customMessage.setData(this.intent);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
        this.Ss.stopSelf();
    }

    private void cP(int i) {
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
            default:
                return;
        }
    }

    private void cQ(int i) {
        switch (i) {
            case 6:
                TiebaStatic.eventStat(this.Ss.getBaseContext(), "notify_to_pk_before", "click");
                return;
            case 7:
                TiebaStatic.eventStat(this.Ss.getBaseContext(), "notify_to_pk_end", "click");
                return;
            case 8:
                TiebaStatic.eventStat(this.Ss.getBaseContext(), "notify_to_vote_list", "click");
                return;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return;
            case 14:
                i.B(this.Ss.getBaseContext(), "notify_group_event_click");
                return;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }
}
