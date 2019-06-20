package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer coT;
    private String coU;

    public void a(ActivitySponsor activitySponsor) {
        this.coT = activitySponsor.is_sponsor;
        this.coU = activitySponsor.sponsor_url;
    }
}
