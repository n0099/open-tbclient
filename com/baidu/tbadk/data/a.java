package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer arR;
    private String arS;

    public void a(ActivitySponsor activitySponsor) {
        this.arR = activitySponsor.is_sponsor;
        this.arS = activitySponsor.sponsor_url;
    }
}
