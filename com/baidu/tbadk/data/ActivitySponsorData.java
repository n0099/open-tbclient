package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aKA;
    private String aKB;

    public void a(ActivitySponsor activitySponsor) {
        this.aKA = activitySponsor.is_sponsor;
        this.aKB = activitySponsor.sponsor_url;
    }
}
