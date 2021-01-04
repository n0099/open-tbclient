package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer fCe;
    private String fCf;

    public void a(ActivitySponsor activitySponsor) {
        this.fCe = activitySponsor.is_sponsor;
        this.fCf = activitySponsor.sponsor_url;
    }
}
