package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes7.dex */
public class PostForumData extends com.baidu.tieba.card.data.a implements Serializable {
    public static final BdUniqueId TYPE_POST_FORUM = BdUniqueId.gen();
    private static final long serialVersionUID = -2078662294751243784L;
    public List<com.baidu.adp.widget.ListView.n> mRelateForumDataList = null;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE_POST_FORUM;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (!x.isEmpty(list)) {
            this.showTopDivider = true;
            this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
            this.mRelateForumDataList = new ArrayList();
            for (RelateForum relateForum : list) {
                if (relateForum != null && !StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.mRelateForumDataList.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        return x.getCount(this.mRelateForumDataList);
    }

    public com.baidu.adp.widget.ListView.n getForumData(int i) {
        return (com.baidu.adp.widget.ListView.n) x.getItem(this.mRelateForumDataList, i);
    }
}
