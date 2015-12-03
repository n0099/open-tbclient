package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class j implements u {
    public static final BdUniqueId bEv = BdUniqueId.gen();
    public List<u> bEw = null;
    public boolean bEx = true;
    public boolean bEy = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bEv;
    }

    public void aP(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.bEw = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.bEw.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.bEw == null || this.bEw.size() == 0) {
            return 0;
        }
        return this.bEw.size();
    }
}
