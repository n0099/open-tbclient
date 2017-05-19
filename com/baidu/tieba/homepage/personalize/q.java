package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i) {
        super(i);
        this.this$0 = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        List<com.baidu.tieba.homepage.b.a.a> list;
        DataRes.Builder builder2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            builder = this.this$0.cuG;
            if (builder != null && (list = (List) customResponsedMessage.getData()) != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar : list) {
                    if (aVar != null && aVar.cxb != -1 && aVar.cxb != -2 && !StringUtils.isNull(aVar.cxa)) {
                        SimpleForum.Builder builder3 = new SimpleForum.Builder();
                        builder3.name = aVar.cxa;
                        builder3.level_id = Integer.valueOf(aVar.level);
                        arrayList.add(builder3.build(true));
                    }
                }
                builder2 = this.this$0.cuG;
                builder2.like_forums = arrayList;
                this.this$0.ahF();
            }
        }
    }
}
