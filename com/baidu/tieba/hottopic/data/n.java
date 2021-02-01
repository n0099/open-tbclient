package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes8.dex */
public class n extends com.baidu.tieba.card.data.a {
    public static final BdUniqueId kve = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.n> kvf = null;
    public boolean kvg = true;
    public boolean kvh = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kve;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.showTopDivider = true;
            this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
            this.kvf = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.kvf.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.kvf == null || this.kvf.size() == 0) {
            return 0;
        }
        return this.kvf.size();
    }
}
