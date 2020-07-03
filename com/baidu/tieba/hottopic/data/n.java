package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes8.dex */
public class n extends com.baidu.tieba.card.data.a {
    public static final BdUniqueId iEP = BdUniqueId.gen();
    public List<q> iEQ = null;
    public boolean iER = true;
    public boolean iES = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEP;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list != null && list.size() != 0) {
            this.showTopDivider = true;
            this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
            this.iEQ = new ArrayList();
            for (RelateForum relateForum : list) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    RelateForumItemData relateForumItemData = new RelateForumItemData();
                    relateForumItemData.parserProtobuf(relateForum);
                    this.iEQ.add(relateForumItemData);
                }
            }
        }
    }

    public int getCount() {
        if (this.iEQ == null || this.iEQ.size() == 0) {
            return 0;
        }
        return this.iEQ.size();
    }
}
