package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class cm extends com.baidu.adp.base.f {
    private cn aMU;
    private String mForumId;
    private String mForumName;

    public cm(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.aMU = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void KA() {
        if (this.aMU != null) {
            this.aMU.cancel();
            this.aMU = null;
        }
    }

    public void ap(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.aMU == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.aMU = new cn(this, null);
            this.aMU.setPriority(2);
            this.aMU.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
