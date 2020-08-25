package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes15.dex */
public class p implements q {
    public static final BdUniqueId iZY = BdUniqueId.gen();
    public String geM;
    public String iTh;
    public String iZZ;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iZY;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.geM = tabList.tab_type;
            this.iTh = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.iZZ = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
