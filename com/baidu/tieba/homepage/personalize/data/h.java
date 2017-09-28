package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId daz = BdUniqueId.gen();
    public List<g> daA = null;
    public List<g> daB = null;

    public static h c(DataRes.Builder builder) {
        if (builder == null || builder.age_sex == null) {
            return null;
        }
        if ((builder.age_sex.sex_tag == null || builder.age_sex.sex_tag.size() == 0) && (builder.age_sex.age_tag == null || builder.age_sex.age_tag.size() == 0)) {
            return null;
        }
        h hVar = new h();
        hVar.daA = new ArrayList();
        hVar.daB = new ArrayList();
        if (builder.age_sex.sex_tag != null && builder.age_sex.sex_tag.size() == 2) {
            g a = g.a(builder.age_sex.sex_tag.get(0));
            g a2 = g.a(builder.age_sex.sex_tag.get(1));
            if (a != null && a2 != null) {
                hVar.daA.add(a);
                hVar.daA.add(a2);
            }
        }
        if (builder.age_sex.age_tag != null && builder.age_sex.age_tag.size() > 0) {
            for (int i = 0; i < builder.age_sex.age_tag.size() && i < 5; i++) {
                g a3 = g.a(builder.age_sex.age_tag.get(i));
                if (a3 != null) {
                    hVar.daB.add(a3);
                }
            }
        }
        return hVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return daz;
    }
}
