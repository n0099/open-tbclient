package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes21.dex */
public class n extends com.baidu.tieba.card.data.a {
    public static final BdUniqueId kep = BdUniqueId.gen();
    public List<q> keq = null;
    public boolean ker = true;
    public boolean kes = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kep;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.showTopDivider = true;
            this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
            this.keq = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.keq.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.keq == null || this.keq.size() == 0) {
            return 0;
        }
        return this.keq.size();
    }
}
