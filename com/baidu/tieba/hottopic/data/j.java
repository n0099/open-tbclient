package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class j implements u {
    public static final BdUniqueId bHZ = BdUniqueId.gen();
    public List<u> bIa = null;
    public boolean bIb = true;
    public boolean bIc = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bHZ;
    }

    public void aM(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.bIa = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.bIa.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.bIa == null || this.bIa.size() == 0) {
            return 0;
        }
        return this.bIa.size();
    }
}
