package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes2.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer eJk;
    private String eJl;

    public void a(ActivitySponsor activitySponsor) {
        this.eJk = activitySponsor.is_sponsor;
        this.eJl = activitySponsor.sponsor_url;
    }
}
