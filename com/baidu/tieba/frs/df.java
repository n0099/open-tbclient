package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class df extends com.baidu.adp.base.f {
    private dg aHH;
    private String mForumId;
    private String mForumName;

    public df(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.aHH = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void Hx() {
        if (this.aHH != null) {
            this.aHH.cancel();
            this.aHH = null;
        }
    }

    public void aq(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.aHH == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.aHH = new dg(this, null);
            this.aHH.setPriority(2);
            this.aHH.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
