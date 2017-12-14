package com.baidu.tieba.frs.f;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class e {
    public static boolean a(com.baidu.tieba.frs.g gVar, String str, String str2, boolean z) {
        if (z && gVar != null && !TextUtils.isEmpty(str) && gVar.isAdded() && h.ad(TbadkCoreApplication.getInst().getApplicationContext(), gVar.getActivity().getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
            intent.putExtra(str2, "short_cut");
            gVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(gVar.getPageContext().getPageActivity(), intent)));
            return false;
        }
        return true;
    }
}
