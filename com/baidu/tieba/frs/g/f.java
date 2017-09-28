package com.baidu.tieba.frs.g;

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
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static boolean a(com.baidu.tieba.frs.f fVar, String str, String str2, boolean z) {
        if (z && fVar != null && !TextUtils.isEmpty(str) && fVar.isAdded() && i.aj(TbadkCoreApplication.getInst().getApplicationContext(), fVar.getActivity().getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
            intent.putExtra(str2, "short_cut");
            fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(fVar.getPageContext().getPageActivity(), intent)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.tieba.frs.f fVar, String str) {
        Intent ai;
        if (!TextUtils.isEmpty(str) && fVar != null && fVar.agR() != null && (ai = i.ai(fVar.getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", str + fVar.getPageContext().getString(d.l.forum));
            intent.putExtra("android.intent.extra.shortcut.INTENT", ai);
            BarImageView ama = fVar.agR().ama();
            if (ama != null && ama.getBdImage() != null && ama.getBdImage().kN() != null) {
                Bitmap kN = ama.getBdImage().kN();
                Float valueOf = Float.valueOf(fVar.getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.gP().a(com.baidu.adp.lib.util.d.gP().resizeBitmap(kN, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(fVar.getPageContext().getPageActivity(), d.g.icon));
            }
            fVar.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private final WeakReference<com.baidu.tieba.frs.f> cHs;
        private final String name;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            com.baidu.tieba.frs.f fVar = this.cHs.get();
            if (fVar == null || fVar.getPageContext() == null) {
                return false;
            }
            return Boolean.valueOf(i.ak(fVar.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            com.baidu.tieba.frs.f fVar = this.cHs.get();
            if (fVar != null) {
                if (!bool.booleanValue()) {
                    f.a(fVar, this.name);
                } else {
                    fVar.showToast(d.l.shortcut_has_add);
                }
            }
        }
    }
}
