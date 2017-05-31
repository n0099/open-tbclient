package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer awV;
    private String awW;

    public void a(ActivitySponsor activitySponsor) {
        this.awV = activitySponsor.is_sponsor;
        this.awW = activitySponsor.sponsor_url;
    }
}
