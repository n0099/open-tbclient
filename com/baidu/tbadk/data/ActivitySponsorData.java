package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer duZ;
    private String dva;

    public void a(ActivitySponsor activitySponsor) {
        this.duZ = activitySponsor.is_sponsor;
        this.dva = activitySponsor.sponsor_url;
    }
}
