package com.baidu.tieba.frs.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class r {
    public static boolean a(FrsActivity frsActivity, String str, String str2, boolean z) {
        if (!z || frsActivity == null || TextUtils.isEmpty(str) || !u.L(TbadkCoreApplication.m9getInst().getApplicationContext(), frsActivity.getClass().getName())) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra(str2, "short_cut");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(frsActivity.getPageContext().getPageActivity(), intent)));
        frsActivity.finish();
        return false;
    }

    public static a b(FrsActivity frsActivity, String str) {
        if (TextUtils.isEmpty(str) || frsActivity == null) {
            return null;
        }
        TiebaStatic.eventStat(frsActivity.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        a aVar = new a(frsActivity, str);
        aVar.setSelfExecute(true);
        aVar.execute(new String[0]);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(FrsActivity frsActivity, String str) {
        Intent K;
        if (!TextUtils.isEmpty(str) && frsActivity != null && frsActivity.abW() != null && (K = u.K(frsActivity.getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + frsActivity.getPageContext().getString(r.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView ahB = frsActivity.abW().ahB();
            if (ahB != null && ahB.getBdImage() != null && ahB.getBdImage().jV() != null) {
                Bitmap jV = ahB.getBdImage().jV();
                Float valueOf = Float.valueOf(frsActivity.getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.fT().a(com.baidu.adp.lib.util.d.fT().resizeBitmap(jV, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(frsActivity.getPageContext().getPageActivity(), r.f.icon));
            }
            frsActivity.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private final WeakReference<FrsActivity> aRP;
        private final String name;

        public a(FrsActivity frsActivity, String str) {
            this.name = str;
            this.aRP = new WeakReference<>(frsActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            FrsActivity frsActivity = this.aRP.get();
            if (frsActivity == null) {
                return false;
            }
            return Boolean.valueOf(u.M(frsActivity.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            FrsActivity frsActivity = this.aRP.get();
            if (frsActivity != null) {
                if (!bool.booleanValue()) {
                    r.c(frsActivity, this.name);
                } else {
                    frsActivity.showToast(r.j.shortcut_has_add);
                }
            }
        }
    }
}
