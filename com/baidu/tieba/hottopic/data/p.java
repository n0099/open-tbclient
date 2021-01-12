package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes7.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId knc = BdUniqueId.gen();
    public String hag;
    public String kgl;
    public String knd;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return knc;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.hag = tabList.tab_type;
            this.kgl = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.knd = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
