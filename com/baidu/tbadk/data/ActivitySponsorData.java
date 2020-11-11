package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer flR;
    private String flS;

    public void a(ActivitySponsor activitySponsor) {
        this.flR = activitySponsor.is_sponsor;
        this.flS = activitySponsor.sponsor_url;
    }
}
