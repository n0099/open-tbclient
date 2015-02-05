package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cf aGq;
    private final /* synthetic */ String aGr;
    private final /* synthetic */ String aGs;
    private final /* synthetic */ String aGt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cf cfVar, String str, String str2, String str3) {
        this.aGq = cfVar;
        this.aGr = str;
        this.aGs = str2;
        this.aGt = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (TbadkCoreApplication.m255getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(this.aGr) && !StringUtils.isNull(this.aGs)) {
            if (!com.baidu.adp.lib.util.i.ff()) {
                frsActivity3 = this.aGq.aEa;
                frsActivity3.showToast(com.baidu.tieba.z.neterror);
                return;
            }
            frsActivity = this.aGq.aEa;
            String format = String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", String.valueOf(this.aGr) + "," + this.aGs, this.aGt, this.aGt, frsActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.app_info_for_map));
            frsActivity2 = this.aGq.aEa;
            com.baidu.tbadk.browser.a.x(frsActivity2.getPageContext().getPageActivity(), format);
        }
    }
}
