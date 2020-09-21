package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer eLv;
    private String eLw;

    public void a(ActivitySponsor activitySponsor) {
        this.eLv = activitySponsor.is_sponsor;
        this.eLw = activitySponsor.sponsor_url;
    }
}
