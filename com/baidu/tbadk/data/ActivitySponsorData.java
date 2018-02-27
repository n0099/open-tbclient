package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private String bqA;
    private Integer bqz;

    public void a(ActivitySponsor activitySponsor) {
        this.bqz = activitySponsor.is_sponsor;
        this.bqA = activitySponsor.sponsor_url;
    }
}
