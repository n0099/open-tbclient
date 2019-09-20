package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cri;
    private String crj;

    public void a(ActivitySponsor activitySponsor) {
        this.cri = activitySponsor.is_sponsor;
        this.crj = activitySponsor.sponsor_url;
    }
}
