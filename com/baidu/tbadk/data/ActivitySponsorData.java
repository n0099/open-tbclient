package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer ayM;
    private String ayN;

    public void a(ActivitySponsor activitySponsor) {
        this.ayM = activitySponsor.is_sponsor;
        this.ayN = activitySponsor.sponsor_url;
    }
}
