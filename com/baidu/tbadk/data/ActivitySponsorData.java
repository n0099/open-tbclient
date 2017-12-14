package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer azY;
    private String azZ;

    public void a(ActivitySponsor activitySponsor) {
        this.azY = activitySponsor.is_sponsor;
        this.azZ = activitySponsor.sponsor_url;
    }
}
