package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aKu;
    private String aKv;

    public void a(ActivitySponsor activitySponsor) {
        this.aKu = activitySponsor.is_sponsor;
        this.aKv = activitySponsor.sponsor_url;
    }
}
