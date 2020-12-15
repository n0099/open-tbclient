package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes21.dex */
public class p implements q {
    public static final BdUniqueId keu = BdUniqueId.gen();
    public String gSZ;
    public String jXF;
    public String kev;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return keu;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.gSZ = tabList.tab_type;
            this.jXF = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.kev = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
