package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer bqM;
    private String bqN;

    public void a(ActivitySponsor activitySponsor) {
        this.bqM = activitySponsor.is_sponsor;
        this.bqN = activitySponsor.sponsor_url;
    }
}
