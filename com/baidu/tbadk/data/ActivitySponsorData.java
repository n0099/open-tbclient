package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aWF;
    private String aWG;

    public void a(ActivitySponsor activitySponsor) {
        this.aWF = activitySponsor.is_sponsor;
        this.aWG = activitySponsor.sponsor_url;
    }
}
