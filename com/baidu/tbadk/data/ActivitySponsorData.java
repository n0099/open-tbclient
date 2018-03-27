package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer bqC;
    private String bqD;

    public void a(ActivitySponsor activitySponsor) {
        this.bqC = activitySponsor.is_sponsor;
        this.bqD = activitySponsor.sponsor_url;
    }
}
