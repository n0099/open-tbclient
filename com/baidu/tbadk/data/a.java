package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer axl;
    private String axm;

    public void a(ActivitySponsor activitySponsor) {
        this.axl = activitySponsor.is_sponsor;
        this.axm = activitySponsor.sponsor_url;
    }
}
