package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aWC;
    private String aWD;

    public void a(ActivitySponsor activitySponsor) {
        this.aWC = activitySponsor.is_sponsor;
        this.aWD = activitySponsor.sponsor_url;
    }
}
