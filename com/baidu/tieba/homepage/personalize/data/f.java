package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cTp = BdUniqueId.gen();
    public List<g> cTq = new ArrayList();
    public String cTr;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cTp;
    }

    public static f b(DataRes.Builder builder) {
        g a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        f fVar = new f();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = g.a(tagStruct)) != null) {
                fVar.cTq.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVar.cTq.size()) {
                g gVar = fVar.cTq.get(i2);
                if (gVar != null && !StringUtils.isNull(gVar.TL)) {
                    sb.append(gVar.TL);
                    if (i2 != fVar.cTq.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                fVar.cTr = sb.toString();
                return fVar;
            }
        }
    }
}
