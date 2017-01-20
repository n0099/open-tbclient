package com.baidu.tbadk.data;

import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class a {
    private Integer art;
    private String aru;

    public void a(ActivitySponsor activitySponsor) {
        this.art = activitySponsor.is_sponsor;
        this.aru = activitySponsor.sponsor_url;
    }
}
