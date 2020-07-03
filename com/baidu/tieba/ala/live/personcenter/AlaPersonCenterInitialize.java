package com.baidu.tieba.ala.live.personcenter;

import com.baidu.live.c.f;
import com.baidu.live.c.j;
import com.baidu.live.c.n;
import com.baidu.live.c.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.live.personcenter.admin.AlaAdminListActivity;
import com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity;
import com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity;
import com.baidu.tieba.ala.live.personcenter.forbidden.AlaForbiddenListActivity;
import com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity;
/* loaded from: classes3.dex */
public class AlaPersonCenterInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.a.class, AlaAdminListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(n.class, AlaPersonCenterExpActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(f.class, AlaForbiddenListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(j.class, AlaGuardianListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(u.class, PersonListActivity.class);
    }
}
