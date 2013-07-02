package com.baidu.tieba.hp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.write.WriteActivity;
import com.mofamulu.tieba.ch.a;
import com.mofamulu.tieba.ch.au;
import com.mofamulu.tieba.ch.bg;
/* loaded from: classes.dex */
public class LayoutProxy {
    public static void a(final Activity activity, final Bundle bundle) {
        if ((activity instanceof WriteActivity) || (activity instanceof MoreActivity) || (activity instanceof FrsActivity) || (activity instanceof NewPbActivity) || (activity instanceof PersonInfoActivity)) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.hp.LayoutProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    a.b(activity, bundle);
                }
            }, 100L);
        }
    }

    public static void b(Activity activity, Bundle bundle) {
        a.a(activity, bundle);
    }

    public static void a(Activity activity) {
        a.a(activity);
    }

    public static void a(Activity activity, int i) {
        a.a(activity, i);
    }

    public static void b(Activity activity) {
        a.b(activity);
    }

    public static void c(Activity activity) {
        a.c(activity);
    }

    public static void b(Activity activity, int i) {
        a.b(activity, i);
    }

    public static int a() {
        return au.a;
    }

    public static void a(TiebaApplication tiebaApplication) {
        bg.a(tiebaApplication);
    }
}
