package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes15.dex */
public class p implements q {
    public static final BdUniqueId jae = BdUniqueId.gen();
    public String geQ;
    public String iTn;
    public String jaf;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jae;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.geQ = tabList.tab_type;
            this.iTn = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.jaf = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
