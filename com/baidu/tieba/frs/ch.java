package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cf aGt;
    private final /* synthetic */ String aGu;
    private final /* synthetic */ String aGv;
    private final /* synthetic */ String aGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cf cfVar, String str, String str2, String str3) {
        this.aGt = cfVar;
        this.aGu = str;
        this.aGv = str2;
        this.aGw = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (TbadkCoreApplication.m255getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.aGu) && !StringUtils.isNull(this.aGv)) {
            if (!com.baidu.adp.lib.util.i.ff()) {
                frsActivity3 = this.aGt.aEd;
                frsActivity3.showToast(com.baidu.tieba.z.neterror);
                return;
            }
            frsActivity = this.aGt.aEd;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.aGu) + "," + this.aGv, this.aGw, this.aGw, frsActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.app_info_for_map));
            frsActivity2 = this.aGt.aEd;
            com.baidu.tbadk.browser.a.x(frsActivity2.getPageContext().getPageActivity(), format);
        }
    }
}
