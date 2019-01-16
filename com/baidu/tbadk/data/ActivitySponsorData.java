package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aXn;
    private String aXo;

    public void a(ActivitySponsor activitySponsor) {
        this.aXn = activitySponsor.is_sponsor;
        this.aXo = activitySponsor.sponsor_url;
    }
}
