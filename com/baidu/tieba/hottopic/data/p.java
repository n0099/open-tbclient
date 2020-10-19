package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TabList;
/* loaded from: classes21.dex */
public class p implements q {
    public static final BdUniqueId jxI = BdUniqueId.gen();
    public String guo;
    public String jqS;
    public String jxJ;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jxI;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.guo = tabList.tab_type;
            this.jqS = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.jxJ = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
