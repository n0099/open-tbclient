package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes20.dex */
public class p implements q {
    public static final BdUniqueId jiK = BdUniqueId.gen();
    public String gia;
    public String jbT;
    public String jiL;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jiK;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.gia = tabList.tab_type;
            this.jbT = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.jiL = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
