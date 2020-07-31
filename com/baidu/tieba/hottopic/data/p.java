package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes15.dex */
public class p implements q {
    public static final BdUniqueId iKY = BdUniqueId.gen();
    public String fSN;
    public String iEh;
    public String iKZ;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iKY;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.fSN = tabList.tab_type;
            this.iEh = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.iKZ = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
