package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer coS;
    private String coT;

    public void a(ActivitySponsor activitySponsor) {
        this.coS = activitySponsor.is_sponsor;
        this.coT = activitySponsor.sponsor_url;
    }
}
