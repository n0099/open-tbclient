package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes8.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kvj = BdUniqueId.gen();
    public String hcQ;
    public String kot;
    public String kvk;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kvj;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.hcQ = tabList.tab_type;
            this.kot = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.kvk = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
