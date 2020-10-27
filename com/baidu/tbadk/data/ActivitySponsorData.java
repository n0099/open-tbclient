package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer ffY;
    private String ffZ;

    public void a(ActivitySponsor activitySponsor) {
        this.ffY = activitySponsor.is_sponsor;
        this.ffZ = activitySponsor.sponsor_url;
    }
}
