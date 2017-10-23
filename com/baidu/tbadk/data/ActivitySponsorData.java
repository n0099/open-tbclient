package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer ayA;
    private String ayB;

    public void a(ActivitySponsor activitySponsor) {
        this.ayA = activitySponsor.is_sponsor;
        this.ayB = activitySponsor.sponsor_url;
    }
}
