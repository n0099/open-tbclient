package com.baidu.tieba.im.searchfriend.cache;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestRecommendReadMessage)) {
            return null;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        String str = com.baidu.tbadk.core.a.a.nV().bT("tb.recommend_friend").get(currentAccount);
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar.i(new JSONObject(str));
            } catch (Exception e) {
            }
        }
        return new ResponseRecommendReadMessage(aVar);
    }
}
