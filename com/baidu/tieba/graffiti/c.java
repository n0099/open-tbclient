package com.baidu.tieba.graffiti;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiPaintActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tieba.tbadkCore.util.o;
/* loaded from: classes.dex */
public class c {
    private static final com.baidu.tbadk.n.r cmJ = new com.baidu.tbadk.n.r();

    public static boolean b(Context context, String str, String str2, int i) {
        return a(context, str, str2, null, i);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i) {
        o oVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
        if (runTask != null && (oVar = (o) runTask.getData()) != null) {
            if (oVar.agk() <= 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GRAFFITI_JUMP_PAINT, new GraffitiPaintActivityConfig(context, i, str, str2)));
            } else {
                new GraffitiTabActivityConfig(context, str, str2, str3).start();
            }
            return true;
        }
        return false;
    }

    public static void n(Context context, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GRAFFITI_JUMP_PAINT, new GraffitiPaintActivityConfig(context, i)));
    }

    public static boolean afn() {
        return cmJ.fV() && TbadkCoreApplication.m9getInst().appResponseToIntentClass(GraffitiPaintActivityConfig.class);
    }

    public static boolean aj(View view) {
        boolean fV = cmJ.fV();
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(fV ? 8 : 0);
        }
        return !fV;
    }

    public static String f(String str, int i, int i2) {
        return com.baidu.adp.lib.util.t.aI(String.format("%s_%d_%d_%s", str, Integer.valueOf(i), Integer.valueOf(i2), "graffiti@TB#ub2016"));
    }

    public static String a(UploadedImageInfo uploadedImageInfo) {
        if (uploadedImageInfo == null || StringUtils.isNull(uploadedImageInfo.getPic_id())) {
            return null;
        }
        return String.format("#(graffiti,%s,%d,%d,%s)", uploadedImageInfo.getPic_id(), Integer.valueOf(uploadedImageInfo.getWidth()), Integer.valueOf(uploadedImageInfo.getHeight()), f(uploadedImageInfo.getPic_id(), uploadedImageInfo.getWidth(), uploadedImageInfo.getHeight()));
    }

    public static void M(Intent intent) {
        if (intent != null || afn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new i(intent.getStringExtra(GraffitiPaintActivityConfig.GRAFFITO_FILE_NAME), intent.getIntExtra("from", -1))));
        }
    }

    public static void b(WriteData writeData) {
        if (writeData == null || StringUtils.isNull(writeData.getGraffitiImageId())) {
            return;
        }
        TiebaStatic.log(new as("c11001").aa("obj_id", writeData.getGraffitiImageId()).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, writeData.getType() == 0 ? 1 : 2));
    }

    public static boolean N(Intent intent) {
        return intent != null && intent.getIntExtra("from", -1) == 5;
    }
}
