package com.baidu.tieba.im.searchfriend.cache;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestRecommendReadMessage)) {
            return null;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        String a = com.baidu.tbadk.core.a.a.a().b("tb.recommend_friend").a(currentAccount);
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        if (!TextUtils.isEmpty(a)) {
            try {
                aVar.a(new JSONObject(a));
            } catch (Exception e) {
            }
        }
        return new ResponseRecommendReadMessage(aVar);
    }
}
