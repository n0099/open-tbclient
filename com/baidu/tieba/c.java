package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b avh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.avh = bVar;
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
        LogoActivity logoActivity12;
        LogoActivity logoActivity13;
        int loadInt = TbadkSettings.getInst().loadInt("url_type", 0);
        if (loadInt == 1) {
            String loadString = TbadkSettings.getInst().loadString(ImageViewerConfig.URL, "");
            if (!StringUtils.isNull(loadString)) {
                Intent intent = new Intent();
                intent.putExtra("class", 30);
                intent.putExtra("jump_url", loadString);
                TbadkCoreApplication.setIntent(intent);
                logoActivity13 = this.avh.avg;
                logoActivity13.EN();
            }
        } else if (loadInt == 3) {
            String loadString2 = TbadkSettings.getInst().loadString("apk_url", "");
            String loadString3 = TbadkSettings.getInst().loadString("apk_name", "");
            if (!StringUtils.isNull(loadString2) && !StringUtils.isNull(loadString3)) {
                logoActivity = this.avh.avg;
                if (UtilHelper.isInstallApk(logoActivity.getPageContext().getPageActivity(), loadString3)) {
                    logoActivity12 = this.avh.avg;
                    logoActivity12.showToast(t.logo_down_app_has_installed);
                    return;
                }
                String loadString4 = TbadkSettings.getInst().loadString("apk_size", "");
                if (StringUtils.isNull(loadString4)) {
                    logoActivity11 = this.avh.avg;
                    format = logoActivity11.getResources().getString(t.logo_down_dialog_msg);
                } else {
                    logoActivity2 = this.avh.avg;
                    format = String.format(logoActivity2.getResources().getString(t.logo_down_dialog_fmt_msg), loadString4);
                }
                String loadString5 = TbadkSettings.getInst().loadString("app_name", "");
                if (StringUtils.isNull(loadString5)) {
                    loadString5 = "应用安装包";
                }
                logoActivity3 = this.avh.avg;
                logoActivity4 = this.avh.avg;
                logoActivity3.Ll = new com.baidu.tbadk.core.dialog.a(logoActivity4.getPageContext().getPageActivity());
                logoActivity5 = this.avh.avg;
                aVar = logoActivity5.Ll;
                aVar.cn(format);
                logoActivity6 = this.avh.avg;
                aVar2 = logoActivity6.Ll;
                aVar2.ag(false);
                logoActivity7 = this.avh.avg;
                aVar3 = logoActivity7.Ll;
                aVar3.a(TbadkCoreApplication.m411getInst().getString(t.logo_down_dialog_yes), new d(this, loadString3, loadString2, loadString5));
                logoActivity8 = this.avh.avg;
                aVar4 = logoActivity8.Ll;
                aVar4.b(TbadkCoreApplication.m411getInst().getString(t.logo_down_dialog_no), new e(this));
                logoActivity9 = this.avh.avg;
                aVar5 = logoActivity9.Ll;
                baseActivity = this.avh.avg;
                aVar5.b(baseActivity.getPageContext());
                logoActivity10 = this.avh.avg;
                aVar6 = logoActivity10.Ll;
                aVar6.rL();
            }
        }
    }
}
