package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import d.b.c.e.p.k;
import d.b.j0.e1.t.d;
import d.b.j0.t2.a;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class UtilityMessage implements TiebaUtilityMessageAuto.HostUtilityMessage {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void clearNewMessage(TiebaUtilityMessageAuto.MessageStringParam messageStringParam) {
        String result = messageStringParam.getResult();
        if (StringUtils.isNull(result)) {
            return;
        }
        if ("bookmarkNum".equals(result)) {
            a.v().L(3, false, true);
        } else if ("fansNum".equals(result)) {
            a.v().L(2, false, true);
        } else if ("giftNum".equals(result)) {
            a.v().L(1, false, true);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void delAllMsgInForumUser(TiebaUtilityMessageAuto.MessageStringParam messageStringParam) {
        if (k.isEmpty(messageStringParam.getResult())) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(messageStringParam.getResult(), 4, null, 1)));
        MessageManager.getInstance().sendMessage(new CustomMessage(2001151, messageStringParam.getResult()));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void getIsOfficalForumLetterReminderOpen(TiebaUtilityMessageAuto.MessageStringParam messageStringParam, TiebaUtilityMessageAuto.Result<TiebaUtilityMessageAuto.MessageBoolResult> result) {
        TiebaUtilityMessageAuto.MessageBoolResult messageBoolResult = new TiebaUtilityMessageAuto.MessageBoolResult();
        OfficialSettingItemData a2 = d.j().a(TbadkCoreApplication.getCurrentAccount(), messageStringParam.getResult());
        if (a2 != null) {
            messageBoolResult.setResult(Boolean.valueOf(a2.isAcceptNotify()));
        } else {
            messageBoolResult.setResult(Boolean.TRUE);
        }
        result.success(messageBoolResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void readNewMessage(TiebaUtilityMessageAuto.Result<TiebaUtilityMessageAuto.NewMessage> result) {
        HashMap hashMap = new HashMap();
        hashMap.put("bookmarkNum", Integer.valueOf(a.v().A() ? 1 : 0));
        hashMap.put("fansNum", Integer.valueOf(a.v().B() ? 1 : 0));
        TiebaUtilityMessageAuto.NewMessage newMessage = new TiebaUtilityMessageAuto.NewMessage();
        newMessage.setResult(hashMap);
        result.success(newMessage);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void readVipCenterNewMessage(TiebaUtilityMessageAuto.Result<TiebaUtilityMessageAuto.MessageBoolResult> result) {
        TiebaUtilityMessageAuto.MessageBoolResult messageBoolResult = new TiebaUtilityMessageAuto.MessageBoolResult();
        messageBoolResult.setResult(Boolean.valueOf(a.v().C()));
        result.success(messageBoolResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void resetFansNumCount() {
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void setOfficalForumLetterReminderOpen(TiebaUtilityMessageAuto.SetForumBroadcastParam setForumBroadcastParam) {
        final String forumId = setForumBroadcastParam.getForumId();
        final boolean booleanValue = setForumBroadcastParam.getOpen().booleanValue();
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.UtilityMessage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (TextUtils.isEmpty(forumId)) {
                    return null;
                }
                d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(forumId), booleanValue);
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }
}
