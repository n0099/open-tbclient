package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer duY;
    private String duZ;

    public void a(ActivitySponsor activitySponsor) {
        this.duY = activitySponsor.is_sponsor;
        this.duZ = activitySponsor.sponsor_url;
    }
}
