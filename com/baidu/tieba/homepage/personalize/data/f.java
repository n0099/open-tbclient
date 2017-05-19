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
    public static final BdUniqueId cws = BdUniqueId.gen();
    public List<g> cwt = new ArrayList();
    public String cwu;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cws;
    }

    public static f b(DataRes.Builder builder) {
        g a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        f fVar = new f();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = g.a(tagStruct)) != null) {
                fVar.cwt.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVar.cwt.size()) {
                g gVar = fVar.cwt.get(i2);
                if (gVar != null && !StringUtils.isNull(gVar.TP)) {
                    sb.append(gVar.TP);
                    if (i2 != fVar.cwt.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                fVar.cwu = sb.toString();
                return fVar;
            }
        }
    }
}
