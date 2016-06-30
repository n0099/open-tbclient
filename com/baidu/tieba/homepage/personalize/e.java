package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.cqR = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Incorrect condition in loop: B:15:0x0040 */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        int intValue;
        DataRes.Builder builder5;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            builder = this.cqR.cqo;
            if (builder != null) {
                builder2 = this.cqR.cqo;
                if (!com.baidu.tbadk.core.util.y.t(builder2.thread_list)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        return;
                    }
                    for (int i = 0; i < builder3.thread_list.size(); i++) {
                        builder4 = this.cqR.cqo;
                        ThreadInfo threadInfo = builder4.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.h.b.c(updateAttentionMessage.getData().toUid, -1L)) {
                            ThreadInfo.Builder builder6 = new ThreadInfo.Builder(threadInfo);
                            User.Builder builder7 = new User.Builder(builder6.author);
                            GodInfo.Builder builder8 = new GodInfo.Builder(builder7.god_data);
                            if (updateAttentionMessage.getData().ahd) {
                                intValue = builder7.fans_num.intValue() + 1;
                                builder8.followed = 1;
                            } else {
                                intValue = builder7.fans_num.intValue() - 1;
                                builder8.followed = 0;
                            }
                            builder7.fans_num = Integer.valueOf(intValue);
                            builder7.god_data = builder8.build(true);
                            builder6.author = builder7.build(true);
                            builder5 = this.cqR.cqo;
                            builder5.thread_list.set(i, builder6.build(true));
                            return;
                        }
                    }
                }
            }
        }
    }
}
