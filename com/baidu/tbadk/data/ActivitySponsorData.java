package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cqn;
    private String cqo;

    public void a(ActivitySponsor activitySponsor) {
        this.cqn = activitySponsor.is_sponsor;
        this.cqo = activitySponsor.sponsor_url;
    }
}
