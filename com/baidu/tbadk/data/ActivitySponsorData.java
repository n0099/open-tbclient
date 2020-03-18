package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private String dvA;
    private Integer dvz;

    public void a(ActivitySponsor activitySponsor) {
        this.dvz = activitySponsor.is_sponsor;
        this.dvA = activitySponsor.sponsor_url;
    }
}
