package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aSp;
    private String aSq;

    public void a(ActivitySponsor activitySponsor) {
        this.aSp = activitySponsor.is_sponsor;
        this.aSq = activitySponsor.sponsor_url;
    }
}
