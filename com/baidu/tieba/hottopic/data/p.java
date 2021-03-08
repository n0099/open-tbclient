package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes7.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kxz = BdUniqueId.gen();
    public String heN;
    public String kqJ;
    public String kxA;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kxz;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.heN = tabList.tab_type;
            this.kqJ = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.kxA = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
