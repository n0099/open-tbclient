package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer fkZ;
    private String fla;

    public void a(ActivitySponsor activitySponsor) {
        this.fkZ = activitySponsor.is_sponsor;
        this.fla = activitySponsor.sponsor_url;
    }
}
