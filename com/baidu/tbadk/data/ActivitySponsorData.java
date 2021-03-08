package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer fBl;
    private String fBm;

    public void a(ActivitySponsor activitySponsor) {
        this.fBl = activitySponsor.is_sponsor;
        this.fBm = activitySponsor.sponsor_url;
    }
}
