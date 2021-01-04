package com.baidu.tieba.frs.d;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class i {
    public static boolean a(FrsFragment frsFragment, String str, String str2, boolean z) {
        if (z && frsFragment != null && !TextUtils.isEmpty(str) && frsFragment.isAdded() && l.aU(TbadkCoreApplication.getInst().getApplicationContext(), frsFragment.getActivity().getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra(DealIntentService.KEY_CLASS, 2);
            intent.putExtra("fname", str);
            intent.putExtra(str2, "short_cut");
            frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(frsFragment.getPageContext().getPageActivity(), intent)));
            return false;
        }
        return true;
    }
}
