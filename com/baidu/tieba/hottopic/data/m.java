package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.a.a {
    public static final BdUniqueId bLD = BdUniqueId.gen();
    public List<u> bLE = null;
    public boolean bLF = true;
    public boolean bLG = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bLD;
    }

    public void aM(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.aRJ = true;
            this.aRF = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_recommend);
            this.bLE = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.bLE.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.bLE == null || this.bLE.size() == 0) {
            return 0;
        }
        return this.bLE.size();
    }
}
