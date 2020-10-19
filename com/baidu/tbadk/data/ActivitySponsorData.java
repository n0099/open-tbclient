package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer eXC;
    private String eXD;

    public void a(ActivitySponsor activitySponsor) {
        this.eXC = activitySponsor.is_sponsor;
        this.eXD = activitySponsor.sponsor_url;
    }
}
