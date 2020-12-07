package com.baidu.tieba.ala.live.personcenter;

import com.baidu.live.d.i;
import com.baidu.live.d.m;
import com.baidu.live.d.q;
import com.baidu.live.d.y;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.live.personcenter.admin.AlaAdminListActivity;
import com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity;
import com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity;
import com.baidu.tieba.ala.live.personcenter.forbidden.AlaForbiddenListActivity;
import com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity;
/* loaded from: classes4.dex */
public class AlaPersonCenterInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.d.a.class, AlaAdminListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(q.class, AlaPersonCenterExpActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(i.class, AlaForbiddenListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(m.class, AlaGuardianListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(y.class, PersonListActivity.class);
    }
}
