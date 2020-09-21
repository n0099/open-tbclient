package com.baidu.tieba.ala.live.personcenter;

import com.baidu.live.b.h;
import com.baidu.live.b.k;
import com.baidu.live.b.o;
import com.baidu.live.b.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.live.personcenter.admin.AlaAdminListActivity;
import com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity;
import com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity;
import com.baidu.tieba.ala.live.personcenter.forbidden.AlaForbiddenListActivity;
import com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity;
/* loaded from: classes4.dex */
public class AlaPersonCenterInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.a.class, AlaAdminListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(o.class, AlaPersonCenterExpActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(h.class, AlaForbiddenListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(k.class, AlaGuardianListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(v.class, PersonListActivity.class);
    }
}
