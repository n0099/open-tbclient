package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class h implements v {
    public static final BdUniqueId czc = BdUniqueId.gen();
    public List<g> czd = null;
    public List<g> cze = null;

    public static h b(DataRes.Builder builder) {
        if (builder == null || builder.age_sex == null) {
            return null;
        }
        if ((builder.age_sex.sex_tag == null || builder.age_sex.sex_tag.size() == 0) && (builder.age_sex.age_tag == null || builder.age_sex.age_tag.size() == 0)) {
            return null;
        }
        h hVar = new h();
        hVar.czd = new ArrayList();
        hVar.cze = new ArrayList();
        if (builder.age_sex.sex_tag != null && builder.age_sex.sex_tag.size() == 2) {
            g a = g.a(builder.age_sex.sex_tag.get(0));
            g a2 = g.a(builder.age_sex.sex_tag.get(1));
            if (a != null && a2 != null) {
                hVar.czd.add(a);
                hVar.czd.add(a2);
            }
        }
        if (builder.age_sex.age_tag != null && builder.age_sex.age_tag.size() > 0) {
            for (int i = 0; i < builder.age_sex.age_tag.size() && i < 5; i++) {
                g a3 = g.a(builder.age_sex.age_tag.get(i));
                if (a3 != null) {
                    hVar.cze.add(a3);
                }
            }
        }
        return hVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return czc;
    }
}
