package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cgK;
    private String cgL;

    public void a(ActivitySponsor activitySponsor) {
        this.cgK = activitySponsor.is_sponsor;
        this.cgL = activitySponsor.sponsor_url;
    }
}
