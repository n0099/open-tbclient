package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer axY;
    private String axZ;

    public void a(ActivitySponsor activitySponsor) {
        this.axY = activitySponsor.is_sponsor;
        this.axZ = activitySponsor.sponsor_url;
    }
}
