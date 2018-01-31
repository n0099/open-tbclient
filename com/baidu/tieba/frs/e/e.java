package com.baidu.tieba.frs.e;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class e {
    public static boolean a(com.baidu.tieba.frs.i iVar, String str, String str2, boolean z) {
        if (z && iVar != null && !TextUtils.isEmpty(str) && iVar.isAdded() && h.ae(TbadkCoreApplication.getInst().getApplicationContext(), iVar.getActivity().getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
            intent.putExtra(str2, "short_cut");
            iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(iVar.getPageContext().getPageActivity(), intent)));
            return false;
        }
        return true;
    }
}
