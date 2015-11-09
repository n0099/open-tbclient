package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId bpT = BdUniqueId.gen();
    public List<RelateForumItemData> bpU = null;
    public boolean bpV = true;
    public boolean bpW = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bpT;
    }

    public void aE(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.bpU = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.bpU.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.bpU == null || this.bpU.size() == 0) {
            return 0;
        }
        return this.bpU.size();
    }
}
