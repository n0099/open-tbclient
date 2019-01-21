package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aXo;
    private String aXp;

    public void a(ActivitySponsor activitySponsor) {
        this.aXo = activitySponsor.is_sponsor;
        this.aXp = activitySponsor.sponsor_url;
    }
}
