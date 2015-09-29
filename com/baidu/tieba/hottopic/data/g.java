package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId bpe = BdUniqueId.gen();
    public List<RelateForumItemData> bpf = null;
    public boolean bpg = true;
    public boolean bph = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bpe;
    }

    public void aA(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.bpf = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.bpf.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.bpf == null || this.bpf.size() == 0) {
            return 0;
        }
        return this.bpf.size();
    }
}
