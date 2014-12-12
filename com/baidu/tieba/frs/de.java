package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class de extends com.baidu.adp.base.f {
    private df aGx;
    private String mForumId;
    private String mForumName;

    public de(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.aGx = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void GZ() {
        if (this.aGx != null) {
            this.aGx.cancel();
            this.aGx = null;
        }
    }

    public void an(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.aGx == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.aGx = new df(this, null);
            this.aGx.setPriority(2);
            this.aGx.execute(new Object[0]);
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getContext(), "sign_start_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        }
    }
}
