package com.baidu.tbadk.coreExtra.service;

import android.app.ActivityManager;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.z;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class a extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ DealIntentService a;
    private Intent b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        String str;
        String str2;
        if (this.b == null || this.b.getExtras() == null) {
            return null;
        }
        int i = this.b.getExtras().getInt("class", -1);
        if (this.b.getExtras().getBoolean("is_notify", false)) {
            switch (i) {
                case 6:
                    TiebaStatic.a(this.a.getBaseContext(), "notify_to_pk_before", "click");
                    break;
                case 7:
                    TiebaStatic.a(this.a.getBaseContext(), "notify_to_pk_end", "click");
                    break;
                case 8:
                    TiebaStatic.a(this.a.getBaseContext(), "notify_to_vote_list", "click");
                    break;
                case 14:
                    g.a(this.a.getBaseContext(), "notify_group_event_click");
                    break;
            }
        }
        String string = this.b.getExtras().getString("stat");
        String stringExtra = this.b.getStringExtra("link");
        long j = this.b.getExtras().getLong("message_id");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
            TiebaStatic.a(TbadkApplication.j().b().getApplicationContext(), "cl_push_noti:" + string, "msgID:" + j);
            TiebaStatic.a(j, 2, stringExtra, string);
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) TbadkApplication.j().b().getSystemService("activity")).getRunningTasks(500)) {
            if (runningTaskInfo.baseActivity.getClassName().startsWith(this.a.getPackageName())) {
                f.e("see noti goto maintab app active");
                if (5 == this.b.getIntExtra("class", -1)) {
                    f.e("see noti goto maintab");
                    if (!runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(com.baidu.tbadk.core.d.b.b())) {
                        f.e("see noti goto maintab new");
                        this.b.putExtra("class", 11);
                    }
                } else if (10 == this.b.getIntExtra("class", -1)) {
                    this.b.putExtra("class", 12);
                }
                str2 = DealIntentService.b;
                return str2;
            }
        }
        this.b.getExtras().getBoolean("is_notify", false);
        f.e("see noti goto maintab app not active");
        str = DealIntentService.c;
        return str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        String str2;
        String str3;
        String str4 = str;
        if (str4 != null) {
            str2 = DealIntentService.b;
            if (str4.equals(str2)) {
                this.b.addFlags(268435456);
                com.baidu.adp.framework.message.a aVar = new com.baidu.adp.framework.message.a(2012000);
                aVar.a((com.baidu.adp.framework.message.a) this.b);
                com.baidu.adp.framework.c.a().a(aVar);
            } else {
                str3 = DealIntentService.c;
                if (str4.equals(str3)) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new z(this.a, this.b)));
                }
            }
        }
        this.a.stopSelf();
    }

    public a(DealIntentService dealIntentService, Intent intent) {
        this.a = dealIntentService;
        this.b = null;
        this.b = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
        String string = this.b.getExtras().getString("privateGid");
        if (!TextUtils.isEmpty(string)) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2012110, string));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
    }
}
