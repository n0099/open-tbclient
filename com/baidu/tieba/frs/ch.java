package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cg aFl;
    private final /* synthetic */ String aFm;
    private final /* synthetic */ String aFn;
    private final /* synthetic */ String aFo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, String str, String str2, String str3) {
        this.aFl = cgVar;
        this.aFm = str;
        this.aFn = str2;
        this.aFo = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (TbadkCoreApplication.m255getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.aFm) && !StringUtils.isNull(this.aFn)) {
            if (!com.baidu.adp.lib.util.i.fg()) {
                frsActivity3 = this.aFl.aDc;
                frsActivity3.showToast(com.baidu.tieba.z.neterror);
                return;
            }
            frsActivity = this.aFl.aDc;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.aFm) + "," + this.aFn, this.aFo, this.aFo, frsActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.app_info_for_map));
            frsActivity2 = this.aFl.aDc;
            com.baidu.tbadk.browser.a.y(frsActivity2.getPageContext().getPageActivity(), format);
        }
    }
}
