package com.baidu.tieba.game;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class bi implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.adp.lib.cache.t<byte[]> bc;
        if ((customMessage instanceof RequestRecommendGameLocalMessage) && (bc = com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_list")) != null) {
            byte[] bArr = bc.get("key_recommend_game_list");
            ResponseRecommendGameLocalMessage responseRecommendGameLocalMessage = new ResponseRecommendGameLocalMessage();
            try {
                responseRecommendGameLocalMessage.decodeInBackGround(2001240, bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.baidu.tieba.game.a.a.In().d(responseRecommendGameLocalMessage.getGameData());
            return responseRecommendGameLocalMessage;
        }
        return null;
    }
}
