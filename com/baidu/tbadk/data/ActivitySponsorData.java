package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aNN;
    private String aNO;

    public void a(ActivitySponsor activitySponsor) {
        this.aNN = activitySponsor.is_sponsor;
        this.aNO = activitySponsor.sponsor_url;
    }
}
