package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer azs;
    private String azt;

    public void a(ActivitySponsor activitySponsor) {
        this.azs = activitySponsor.is_sponsor;
        this.azt = activitySponsor.sponsor_url;
    }
}
