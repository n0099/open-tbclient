package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes21.dex */
public class p implements q {
    public static final BdUniqueId jQf = BdUniqueId.gen();
    public String gKf;
    public String jJp;
    public String jQg;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jQf;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.gKf = tabList.tab_type;
            this.jJp = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.jQg = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
