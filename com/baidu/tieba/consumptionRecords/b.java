package com.baidu.tieba.consumptionRecords;

import tbclient.DefaultInfo;
/* loaded from: classes8.dex */
public class b {
    private String iconUrl;
    private String linkUrl;

    public void a(DefaultInfo defaultInfo) {
        if (defaultInfo != null) {
            this.iconUrl = defaultInfo.icon;
            this.linkUrl = defaultInfo.url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }
}
