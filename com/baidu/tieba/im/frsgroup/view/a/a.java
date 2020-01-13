package com.baidu.tieba.im.frsgroup.view.a;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.e;
import com.baidu.tieba.im.frsgroup.g;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();

    public List<com.baidu.adp.widget.ListView.a> ban() {
        return this.apl;
    }

    public a(BaseActivity baseActivity) {
        this.apl.add(new e(baseActivity.getPageContext(), GroupInfoData.TYPE_FRS_GROUP));
        this.apl.add(new com.baidu.tieba.im.frsgroup.a(baseActivity.getPageContext(), GroupPermData.TYPE_FRS_CREATE_GROUP));
        this.apl.add(new g(baseActivity.getPageContext(), h.hxZ));
    }
}
