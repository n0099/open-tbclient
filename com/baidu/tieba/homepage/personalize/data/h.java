package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class h implements v {
    public static final BdUniqueId cvg = BdUniqueId.gen();
    public List<i> cvh = new ArrayList();
    public String cvi;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cvg;
    }

    public static h a(DataRes.Builder builder) {
        i a;
        if (builder == null || builder.interestion == null || builder.interestion.size() == 0) {
            return null;
        }
        h hVar = new h();
        for (TagStruct tagStruct : builder.interestion) {
            if (tagStruct != null && (a = i.a(tagStruct)) != null) {
                hVar.cvh.add(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < hVar.cvh.size()) {
                i iVar = hVar.cvh.get(i2);
                if (iVar != null && !StringUtils.isNull(iVar.cvj)) {
                    sb.append(iVar.cvj);
                    if (i2 != hVar.cvh.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                hVar.cvi = sb.toString();
                return hVar;
            }
        }
    }
}
