package com.baidu.tieba.im.frsgroup.view.a;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.e;
import com.baidu.tieba.im.frsgroup.g;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();

    public List<com.baidu.adp.widget.ListView.a> aJs() {
        return this.agQ;
    }

    public a(BaseActivity baseActivity) {
        this.agQ.add(new e(baseActivity.getPageContext(), GroupInfoData.TYPE_FRS_GROUP));
        this.agQ.add(new com.baidu.tieba.im.frsgroup.a(baseActivity.getPageContext(), GroupPermData.TYPE_FRS_CREATE_GROUP));
        this.agQ.add(new g(baseActivity.getPageContext(), h.gHj));
    }
}
