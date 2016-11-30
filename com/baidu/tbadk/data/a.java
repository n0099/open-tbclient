package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer asL;
    private String asM;

    public void a(ActivitySponsor activitySponsor) {
        this.asL = activitySponsor.is_sponsor;
        this.asM = activitySponsor.sponsor_url;
    }
}
