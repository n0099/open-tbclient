package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer azT;
    private String azU;

    public void a(ActivitySponsor activitySponsor) {
        this.azT = activitySponsor.is_sponsor;
        this.azU = activitySponsor.sponsor_url;
    }
}
