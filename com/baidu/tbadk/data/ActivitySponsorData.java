package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer ess;
    private String est;

    public void a(ActivitySponsor activitySponsor) {
        this.ess = activitySponsor.is_sponsor;
        this.est = activitySponsor.sponsor_url;
    }
}
