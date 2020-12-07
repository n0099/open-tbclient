package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes21.dex */
public class p implements q {
    public static final BdUniqueId kes = BdUniqueId.gen();
    public String gSX;
    public String jXD;
    public String ket;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kes;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.gSX = tabList.tab_type;
            this.jXD = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.ket = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
