package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes21.dex */
public class p implements q {
    public static final BdUniqueId jKh = BdUniqueId.gen();
    public String gEs;
    public String jDs;
    public String jKi;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jKh;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.gEs = tabList.tab_type;
            this.jDs = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.jKi = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
