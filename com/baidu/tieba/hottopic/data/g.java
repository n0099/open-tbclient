package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId bpp = BdUniqueId.gen();
    public List<RelateForumItemData> bpq = null;
    public boolean bpr = true;
    public boolean bps = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bpp;
    }

    public void aA(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.bpq = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.bpq.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.bpq == null || this.bpq.size() == 0) {
            return 0;
        }
        return this.bpq.size();
    }
}
