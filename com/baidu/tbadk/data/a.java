package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer asg;
    private String ash;

    public void a(ActivitySponsor activitySponsor) {
        this.asg = activitySponsor.is_sponsor;
        this.ash = activitySponsor.sponsor_url;
    }
}
