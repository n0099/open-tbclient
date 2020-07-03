package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes8.dex */
public class p implements q {
    public static final BdUniqueId iEU = BdUniqueId.gen();
    public String fNu;
    public String iEV;
    public String iyd;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEU;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.fNu = tabList.tab_type;
            this.iyd = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.iEV = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
