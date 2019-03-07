package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cgI;
    private String cgJ;

    public void a(ActivitySponsor activitySponsor) {
        this.cgI = activitySponsor.is_sponsor;
        this.cgJ = activitySponsor.sponsor_url;
    }
}
