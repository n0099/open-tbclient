package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class f implements v {
    public static final BdUniqueId crS = BdUniqueId.gen();
    public List<g> crT = new ArrayList();
    public String crU;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return crS;
    }

    public static f a(DataRes.Builder builder) {
        g a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        f fVar = new f();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = g.a(tagStruct)) != null) {
                fVar.crT.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVar.crT.size()) {
                g gVar = fVar.crT.get(i2);
                if (gVar != null && !StringUtils.isNull(gVar.PR)) {
                    sb.append(gVar.PR);
                    if (i2 != fVar.crT.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                fVar.crU = sb.toString();
                return fVar;
            }
        }
    }
}
