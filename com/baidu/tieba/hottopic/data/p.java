package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes8.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId krH = BdUniqueId.gen();
    public String heM;
    public String kkR;
    public String krI;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return krH;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.heM = tabList.tab_type;
            this.kkR = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.krI = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
