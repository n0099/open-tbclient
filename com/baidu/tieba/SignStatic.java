package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SignStatic {
    static {
        HP();
    }

    private static void HP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001425, new CustomMessageTask.CustomRunnable<ForumData>() { // from class: com.baidu.tieba.SignStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumData> customMessage) {
                SignData signData = null;
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                String name = customMessage.getData().getName();
                String id = customMessage.getData().getId();
                if (name == null || name.length() <= 0 || id == null || id.length() <= 0) {
                    return null;
                }
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_start_time", System.currentTimeMillis() + "");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_do_time", System.currentTimeMillis() + "");
                SignMessage signMessage = new SignMessage();
                try {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_do_time", System.currentTimeMillis() + "");
                    x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                    xVar.n("kw", name);
                    xVar.n(ImageViewerConfig.FORUM_ID, id);
                    xVar.Cy().Dv().mIsNeedTbs = true;
                    String Ca = xVar.Ca();
                    if (xVar.CB()) {
                        if (xVar.Cy().Dw().isRequestSuccess()) {
                            signData = new SignData();
                            signData.parserJson(Ca);
                            signData.forumId = id;
                            signData.forumName = name;
                        } else {
                            if (!am.isEmpty(Ca)) {
                                JSONObject jSONObject = new JSONObject(Ca);
                                if (AntiHelper.vR(xVar.CC()) || "199901".equals(jSONObject.optString("error_code"))) {
                                    signData = new SignData();
                                    signData.parserJson(Ca);
                                    signData.is_signed = 1;
                                    signData.count_sign_num = 1;
                                    signData.sign_bonus_point = 0;
                                    signData.forumId = id;
                                    signData.forumName = name;
                                }
                            }
                            signMessage.mSignErrorCode = xVar.CC();
                            signMessage.mSignErrorString = xVar.getErrorString();
                        }
                        signMessage.signData = signData;
                        return signMessage;
                    }
                    return signMessage;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return signMessage;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
