package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.j0.x.e0.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes4.dex */
public class PostForumData extends a implements Serializable {
    public static final BdUniqueId TYPE_POST_FORUM = BdUniqueId.gen();
    public static final long serialVersionUID = -2078662294751243784L;
    public List<n> mRelateForumDataList = null;

    public int getCount() {
        return ListUtils.getCount(this.mRelateForumDataList);
    }

    public n getForumData(int i) {
        return (n) ListUtils.getItem(this.mRelateForumDataList, i);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return TYPE_POST_FORUM;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
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
