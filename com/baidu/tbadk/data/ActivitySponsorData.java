package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer dVy;
    private String dVz;

    public void a(ActivitySponsor activitySponsor) {
        this.dVy = activitySponsor.is_sponsor;
        this.dVz = activitySponsor.sponsor_url;
    }
}
