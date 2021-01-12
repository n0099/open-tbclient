package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes7.dex */
public class n extends com.baidu.tieba.card.data.a {
    public static final BdUniqueId kmX = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.n> kmY = null;
    public boolean kmZ = true;
    public boolean kna = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kmX;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.showTopDivider = true;
            this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
            this.kmY = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.kmY.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.kmY == null || this.kmY.size() == 0) {
            return 0;
        }
        return this.kmY.size();
    }
}
