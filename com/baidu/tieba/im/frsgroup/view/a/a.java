package com.baidu.tieba.im.frsgroup.view.a;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.frsgroup.e;
import com.baidu.tieba.im.frsgroup.g;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();

    public List<com.baidu.adp.widget.ListView.a> bxf() {
        return this.aWf;
    }

    public a(BaseActivity baseActivity) {
        this.aWf.add(new e(baseActivity.getPageContext(), GroupInfoData.TYPE_FRS_GROUP));
        this.aWf.add(new com.baidu.tieba.im.frsgroup.a(baseActivity.getPageContext(), GroupPermData.TYPE_FRS_CREATE_GROUP));
        this.aWf.add(new g(baseActivity.getPageContext(), h.jaq));
    }
}
