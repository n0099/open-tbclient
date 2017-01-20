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
    public static final BdUniqueId cyY = BdUniqueId.gen();
    public List<g> cyZ = new ArrayList();
    public String cza;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cyY;
    }

    public static f a(DataRes.Builder builder) {
        g a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        f fVar = new f();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = g.a(tagStruct)) != null) {
                fVar.cyZ.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVar.cyZ.size()) {
                g gVar = fVar.cyZ.get(i2);
                if (gVar != null && !StringUtils.isNull(gVar.OZ)) {
                    sb.append(gVar.OZ);
                    if (i2 != fVar.cyZ.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                fVar.cza = sb.toString();
                return fVar;
            }
        }
    }
}
