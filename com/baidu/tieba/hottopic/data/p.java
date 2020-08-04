package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes15.dex */
public class p implements q {
    public static final BdUniqueId iLa = BdUniqueId.gen();
    public String fSN;
    public String iEj;
    public String iLb;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iLa;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.fSN = tabList.tab_type;
            this.iEj = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.iLb = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
