package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer azk;
    private String azl;

    public void a(ActivitySponsor activitySponsor) {
        this.azk = activitySponsor.is_sponsor;
        this.azl = activitySponsor.sponsor_url;
    }
}
