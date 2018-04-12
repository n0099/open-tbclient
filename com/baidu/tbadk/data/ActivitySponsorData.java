package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aBb;
    private String aBc;

    public void a(ActivitySponsor activitySponsor) {
        this.aBb = activitySponsor.is_sponsor;
        this.aBc = activitySponsor.sponsor_url;
    }
}
