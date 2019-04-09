package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cgL;
    private String cgM;

    public void a(ActivitySponsor activitySponsor) {
        this.cgL = activitySponsor.is_sponsor;
        this.cgM = activitySponsor.sponsor_url;
    }
}
