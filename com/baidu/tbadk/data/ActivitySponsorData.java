package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aTf;
    private String aTg;

    public void a(ActivitySponsor activitySponsor) {
        this.aTf = activitySponsor.is_sponsor;
        this.aTg = activitySponsor.sponsor_url;
    }
}
