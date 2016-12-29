package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer aso;
    private String asp;

    public void a(ActivitySponsor activitySponsor) {
        this.aso = activitySponsor.is_sponsor;
        this.asp = activitySponsor.sponsor_url;
    }
}
