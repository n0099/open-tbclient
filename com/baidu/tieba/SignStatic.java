package com.baidu.tieba;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumAdvertActivity;
import com.baidu.tieba.supplementSign.SupplementSignActivity;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SignStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(SupplementSignActivityConfig.class, SupplementSignActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumActivityConfig.class, SignAllForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumAdvertActivityConfig.class, SignAllForumAdvertActivity.class);
        bnI();
        xp();
    }

    private static void xp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SIGN_MODEL_TASK, new CustomMessageTask.CustomRunnable<ForumData>() { // from class: com.baidu.tieba.SignStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumData> customMessage) {
                SignData signData;
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                ForumData data = customMessage.getData();
                String name = data.getName();
                String id = data.getId();
                if (name == null || name.length() <= 0 || id == null || id.length() <= 0) {
                    return null;
                }
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_start_time", System.currentTimeMillis() + "");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_do_time", System.currentTimeMillis() + "");
                SignMessage signMessage = new SignMessage();
                try {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_do_time", System.currentTimeMillis() + "");
                    y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                    yVar.addPostData("kw", name);
                    yVar.addPostData("fid", id);
                    if (!TextUtils.isEmpty(data.getFromPage())) {
                        yVar.addPostData("sign_from", data.getFromPage());
                    }
                    SignStatic.a(yVar);
                    yVar.aWu().aWV().mIsNeedTbs = true;
                    yVar.hj(true);
                    String postNetData = yVar.postNetData();
                    if (yVar.isNetSuccess()) {
                        if (yVar.aWu().aWW().isRequestSuccess()) {
                            signData = new SignData();
                            signData.parserJson(postNetData);
                            signData.forumId = id;
                            signData.forumName = name;
                        } else if (!ar.isEmpty(postNetData)) {
                            JSONObject jSONObject = new JSONObject(postNetData);
                            signMessage.parserJson(yVar, jSONObject);
                            if (AntiHelper.Fe(yVar.getServerErrorCode()) || "199901".equals(jSONObject.optString("error_code"))) {
                                signData = new SignData();
                                signData.parserJson(postNetData);
                                signData.is_signed = 1;
                                signData.count_sign_num = 1;
                                signData.sign_bonus_point = 0;
                                signData.forumId = id;
                                signData.forumName = name;
                            } else {
                                signData = null;
                            }
                        } else {
                            signMessage.parserJson(yVar, null);
                            signData = null;
                        }
                        signMessage.signData = signData;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                return signMessage;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void a(y yVar) {
        Address address;
        String locationLng = TbadkCoreApplication.getInst().getLocationLng();
        String locationLat = TbadkCoreApplication.getInst().getLocationLat();
        if ((TextUtils.isEmpty(locationLat) || TextUtils.isEmpty(locationLng)) && (address = com.baidu.adp.lib.c.a.kG().getAddress(false)) != null) {
            locationLng = String.valueOf(address.getLongitude());
            locationLat = String.valueOf(address.getLatitude());
        }
        if (!TextUtils.isEmpty(locationLat) && !TextUtils.isEmpty(locationLng)) {
            yVar.addPostData("location", locationLng + Constants.ACCEPT_TIME_SEPARATOR_SP + locationLat);
        }
    }

    private static void bnI() {
        bc.aWU().a(new bc.a() { // from class: com.baidu.tieba.SignStatic.2
            @Override // com.baidu.tbadk.core.util.bc.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_ONE_KEY_SIGN)) {
                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(tbPageContext.getPageActivity());
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, signAllForumActivityConfig));
                        return 0;
                    } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, signAllForumActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}
