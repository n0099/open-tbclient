package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cUI = BdUniqueId.gen();
    public List<g> cUJ = new ArrayList();
    public String cUK;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cUI;
    }

    public static f b(DataRes.Builder builder) {
        g a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        f fVar = new f();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = g.a(tagStruct)) != null) {
                fVar.cUJ.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVar.cUJ.size()) {
                g gVar = fVar.cUJ.get(i2);
                if (gVar != null && !StringUtils.isNull(gVar.Vl)) {
                    sb.append(gVar.Vl);
                    if (i2 != fVar.cUJ.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                fVar.cUK = sb.toString();
                return fVar;
            }
        }
    }
}
