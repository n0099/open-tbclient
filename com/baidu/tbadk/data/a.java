package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer awO;
    private String awP;

    public void a(ActivitySponsor activitySponsor) {
        this.awO = activitySponsor.is_sponsor;
        this.awP = activitySponsor.sponsor_url;
    }
}
