package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aAi;
    private String aAj;

    public void a(ActivitySponsor activitySponsor) {
        this.aAi = activitySponsor.is_sponsor;
        this.aAj = activitySponsor.sponsor_url;
    }
}
