package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer aok;
    private String aol;

    public void a(ActivitySponsor activitySponsor) {
        this.aok = activitySponsor.is_sponsor;
        this.aol = activitySponsor.sponsor_url;
    }
}
