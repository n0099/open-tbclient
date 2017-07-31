package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aAh;
    private String aAi;

    public void a(ActivitySponsor activitySponsor) {
        this.aAh = activitySponsor.is_sponsor;
        this.aAi = activitySponsor.sponsor_url;
    }
}
