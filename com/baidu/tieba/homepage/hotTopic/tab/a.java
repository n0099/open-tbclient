package com.baidu.tieba.homepage.hotTopic.tab;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes16.dex */
public class a {
    public static void b(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.b) {
            com.baidu.tieba.homepage.hotTopic.tab.b.b bVar = (com.baidu.tieba.homepage.hotTopic.tab.b.b) obj;
            ap apVar = new ap(str);
            if (!bVar.ixb) {
                apVar.ah("obj_locate", i);
                apVar.t("topic_id", bVar.topicId);
            }
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.baO();
        } else if (obj instanceof e) {
            e eVar = (e) obj;
            ap apVar2 = new ap(str);
            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
            if (eVar.dLK != null) {
                apVar2.dn("tid", eVar.dLK.getTid());
            }
            apVar2.baO();
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            ap apVar = new ap(str);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            if (eVar.dLK != null) {
                apVar.dn("tid", eVar.dLK.getTid());
            }
            apVar.baO();
        }
    }
}
