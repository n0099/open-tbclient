package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b aDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aDm = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        String format;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        com.baidu.tbadk.core.dialog.a aVar;
        LogoActivity logoActivity6;
        com.baidu.tbadk.core.dialog.a aVar2;
        LogoActivity logoActivity7;
        com.baidu.tbadk.core.dialog.a aVar3;
        LogoActivity logoActivity8;
        com.baidu.tbadk.core.dialog.a aVar4;
        LogoActivity logoActivity9;
        com.baidu.tbadk.core.dialog.a aVar5;
        BaseActivity baseActivity;
        LogoActivity logoActivity10;
        com.baidu.tbadk.core.dialog.a aVar6;
        LogoActivity logoActivity11;
        LogoActivity.a aVar7;
        LogoActivity logoActivity12;
        LogoActivity logoActivity13;
        LogoActivity logoActivity14;
        int loadInt = TbadkSettings.getInst().loadInt("url_type", 0);
        if (loadInt == 1) {
            String loadString = TbadkSettings.getInst().loadString("url", "");
            if (!StringUtils.isNull(loadString)) {
                Intent intent = new Intent();
                intent.putExtra("class", 30);
                intent.putExtra("jump_url", loadString);
                TbadkCoreApplication.setIntent(intent);
                logoActivity14 = this.aDm.aDl;
                logoActivity14.FH();
            }
        } else if (loadInt == 3) {
            String loadString2 = TbadkSettings.getInst().loadString("apk_url", "");
            String loadString3 = TbadkSettings.getInst().loadString("apk_name", "");
            if (!StringUtils.isNull(loadString2) && !StringUtils.isNull(loadString3)) {
                logoActivity = this.aDm.aDl;
                if (UtilHelper.isInstallApk(logoActivity.getPageContext().getPageActivity(), loadString3)) {
                    logoActivity13 = this.aDm.aDl;
                    logoActivity13.showToast(i.h.logo_down_app_has_installed);
                    return;
                }
                String loadString4 = TbadkSettings.getInst().loadString("apk_size", "");
                if (StringUtils.isNull(loadString4)) {
                    logoActivity12 = this.aDm.aDl;
                    format = logoActivity12.getResources().getString(i.h.logo_down_dialog_msg);
                } else {
                    logoActivity2 = this.aDm.aDl;
                    format = String.format(logoActivity2.getResources().getString(i.h.logo_down_dialog_fmt_msg), loadString4);
                }
                String loadString5 = TbadkSettings.getInst().loadString("app_name", "");
                if (StringUtils.isNull(loadString5)) {
                    loadString5 = "应用安装包";
                }
                logoActivity3 = this.aDm.aDl;
                logoActivity4 = this.aDm.aDl;
                logoActivity3.Lt = new com.baidu.tbadk.core.dialog.a(logoActivity4.getPageContext().getPageActivity());
                logoActivity5 = this.aDm.aDl;
                aVar = logoActivity5.Lt;
                aVar.ct(format);
                logoActivity6 = this.aDm.aDl;
                aVar2 = logoActivity6.Lt;
                aVar2.aj(false);
                logoActivity7 = this.aDm.aDl;
                aVar3 = logoActivity7.Lt;
                aVar3.a(TbadkCoreApplication.m411getInst().getString(i.h.logo_down_dialog_yes), new d(this, loadString3, loadString2, loadString5));
                logoActivity8 = this.aDm.aDl;
                aVar4 = logoActivity8.Lt;
                aVar4.b(TbadkCoreApplication.m411getInst().getString(i.h.logo_down_dialog_no), new e(this));
                logoActivity9 = this.aDm.aDl;
                aVar5 = logoActivity9.Lt;
                baseActivity = this.aDm.aDl;
                aVar5.b(baseActivity.getPageContext());
                logoActivity10 = this.aDm.aDl;
                aVar6 = logoActivity10.Lt;
                aVar6.sR();
                com.baidu.adp.lib.g.h hg = com.baidu.adp.lib.g.h.hg();
                logoActivity11 = this.aDm.aDl;
                aVar7 = logoActivity11.aDj;
                hg.removeCallbacks(aVar7);
            }
        }
    }
}
