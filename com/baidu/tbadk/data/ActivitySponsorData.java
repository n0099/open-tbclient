package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer dVt;
    private String dVu;

    public void a(ActivitySponsor activitySponsor) {
        this.dVt = activitySponsor.is_sponsor;
        this.dVu = activitySponsor.sponsor_url;
    }
}
