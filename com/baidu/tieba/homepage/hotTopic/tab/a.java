package com.baidu.tieba.homepage.hotTopic.tab;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes9.dex */
public class a {
    public static void b(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.b) {
            com.baidu.tieba.homepage.hotTopic.tab.b.b bVar = (com.baidu.tieba.homepage.hotTopic.tab.b.b) obj;
            ao aoVar = new ao(str);
            if (!bVar.iqX) {
                aoVar.ag("obj_locate", i);
                aoVar.s("topic_id", bVar.topicId);
            }
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.aWN();
        } else if (obj instanceof e) {
            e eVar = (e) obj;
            ao aoVar2 = new ao(str);
            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
            if (eVar.dLi != null) {
                aoVar2.dk("tid", eVar.dLi.getTid());
            }
            aoVar2.aWN();
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            ao aoVar = new ao(str);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            if (eVar.dLi != null) {
                aoVar.dk("tid", eVar.dLi.getTid());
            }
            aoVar.aWN();
        }
    }
}
