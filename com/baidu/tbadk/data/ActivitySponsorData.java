package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aAb;
    private String aAc;

    public void a(ActivitySponsor activitySponsor) {
        this.aAb = activitySponsor.is_sponsor;
        this.aAc = activitySponsor.sponsor_url;
    }
}
