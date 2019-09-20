package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumAdvertActivity;
import com.baidu.tieba.supplementSign.SupplementSignActivity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SignStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SupplementSignActivityConfig.class, SupplementSignActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumActivityConfig.class, SignAllForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumAdvertActivityConfig.class, SignAllForumAdvertActivity.class);
        aBZ();
        registerTask();
    }

    private static void registerTask() {
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
                    xVar.o("kw", name);
                    xVar.o("fid", id);
                    xVar.aiK().ajM().mIsNeedTbs = true;
                    xVar.eb(true);
                    String aim = xVar.aim();
                    if (xVar.aiN()) {
                        if (xVar.aiK().ajN().isRequestSuccess()) {
                            signData = new SignData();
                            signData.parserJson(aim);
                            signData.forumId = id;
                            signData.forumName = name;
                        } else {
                            if (!aq.isEmpty(aim)) {
                                JSONObject jSONObject = new JSONObject(aim);
                                if (AntiHelper.Bp(xVar.aiO()) || "199901".equals(jSONObject.optString("error_code"))) {
                                    signData = new SignData();
                                    signData.parserJson(aim);
                                    signData.is_signed = 1;
                                    signData.count_sign_num = 1;
                                    signData.sign_bonus_point = 0;
                                    signData.forumId = id;
                                    signData.forumName = name;
                                }
                            }
                            signMessage.mSignErrorCode = xVar.aiO();
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

    private static void aBZ() {
        ba.ajK().a(new ba.a() { // from class: com.baidu.tieba.SignStatic.2
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (!StringUtils.isNull(str) && str.contains("onekeysign:")) {
                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(tbPageContext.getPageActivity());
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                        return 0;
                    } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}
