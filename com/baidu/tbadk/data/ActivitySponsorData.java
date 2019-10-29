package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cDG;
    private String cDH;

    public void a(ActivitySponsor activitySponsor) {
        this.cDG = activitySponsor.is_sponsor;
        this.cDH = activitySponsor.sponsor_url;
    }
}
