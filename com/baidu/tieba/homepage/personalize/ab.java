package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(x xVar, int i) {
        super(i);
        this.this$0 = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.homepage.personalize.b.af afVar;
        com.baidu.tieba.homepage.personalize.b.af afVar2;
        List list2;
        bm bmVar;
        List list3;
        if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
            List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
            List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
            list = this.this$0.mDataList;
            if (!com.baidu.tbadk.core.util.z.t(list) && !com.baidu.tbadk.core.util.z.t(ids) && !com.baidu.tbadk.core.util.z.t(originData)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= originData.size()) {
                        break;
                    }
                    if ((originData.get(i2) instanceof bm) && (bmVar = (bm) originData.get(i2)) != null && bmVar.rJ() != null && ids.contains(Long.valueOf(bmVar.rJ().live_id))) {
                        list3 = this.this$0.mDataList;
                        list3.remove(bmVar);
                    }
                    i = i2 + 1;
                }
                afVar = this.this$0.cIz;
                if (afVar != null) {
                    afVar2 = this.this$0.cIz;
                    list2 = this.this$0.mDataList;
                    afVar2.bg(new ArrayList(list2));
                }
            }
        }
    }
}
