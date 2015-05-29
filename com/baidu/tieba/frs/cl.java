package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class cl extends com.baidu.adp.base.f {
    private cm aPr;
    private String mForumId;
    private String mForumName;

    public cl(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.aPr = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void LP() {
        if (this.aPr != null) {
            this.aPr.cancel();
            this.aPr = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.aPr == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.aPr = new cm(this, null);
            this.aPr.setPriority(2);
            this.aPr.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
