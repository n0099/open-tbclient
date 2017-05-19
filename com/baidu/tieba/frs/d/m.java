package com.baidu.tieba.frs.d;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class m {
    public static boolean a(com.baidu.tieba.frs.r rVar, String str, String str2, boolean z) {
        if (!z || rVar == null || TextUtils.isEmpty(str) || !p.aj(TbadkCoreApplication.m9getInst().getApplicationContext(), rVar.getActivity().getClass().getName())) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("class", 2);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra(str2, "short_cut");
        rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(rVar.getPageContext().getPageActivity(), intent)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.tieba.frs.r rVar, String str) {
        Intent ai;
        if (!TextUtils.isEmpty(str) && rVar != null && rVar.YW() != null && (ai = p.ai(rVar.getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + rVar.getPageContext().getString(w.l.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", ai);
            BarImageView ada = rVar.YW().ada();
            if (ada != null && ada.getBdImage() != null && ada.getBdImage().kR() != null) {
                Bitmap kR = ada.getBdImage().kR();
                Float valueOf = Float.valueOf(rVar.getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.gS().a(com.baidu.adp.lib.util.d.gS().resizeBitmap(kR, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(rVar.getPageContext().getPageActivity(), w.g.icon));
            }
            rVar.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private final WeakReference<com.baidu.tieba.frs.r> cas;
        private final String name;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            com.baidu.tieba.frs.r rVar = this.cas.get();
            if (rVar == null) {
                return false;
            }
            return Boolean.valueOf(p.ak(rVar.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            com.baidu.tieba.frs.r rVar = this.cas.get();
            if (rVar != null) {
                if (!bool.booleanValue()) {
                    m.a(rVar, this.name);
                } else {
                    rVar.showToast(w.l.shortcut_has_add);
                }
            }
        }
    }
}
