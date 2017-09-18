package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer azr;
    private String azs;

    public void a(ActivitySponsor activitySponsor) {
        this.azr = activitySponsor.is_sponsor;
        this.azs = activitySponsor.sponsor_url;
    }
}
