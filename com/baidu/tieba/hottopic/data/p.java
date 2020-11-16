package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes20.dex */
public class p implements q {
    public static final BdUniqueId jQP = BdUniqueId.gen();
    public String gJM;
    public String jKa;
    public String jQQ;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jQP;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.gJM = tabList.tab_type;
            this.jKa = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.jQQ = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
