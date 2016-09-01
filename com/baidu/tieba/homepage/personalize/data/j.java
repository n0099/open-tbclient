package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class j implements v {
    public static final BdUniqueId cGP = BdUniqueId.gen();
    public List<i> cGQ = null;
    public List<i> cGR = null;

    public static j b(DataRes.Builder builder) {
        if (builder == null || builder.age_sex == null) {
            return null;
        }
        if ((builder.age_sex.sex_tag == null || builder.age_sex.sex_tag.size() == 0) && (builder.age_sex.age_tag == null || builder.age_sex.age_tag.size() == 0)) {
            return null;
        }
        j jVar = new j();
        jVar.cGQ = new ArrayList();
        jVar.cGR = new ArrayList();
        if (builder.age_sex.sex_tag != null && builder.age_sex.sex_tag.size() == 2) {
            i a = i.a(builder.age_sex.sex_tag.get(0));
            i a2 = i.a(builder.age_sex.sex_tag.get(1));
            if (a != null && a2 != null) {
                jVar.cGQ.add(a);
                jVar.cGQ.add(a2);
            }
        }
        if (builder.age_sex.age_tag != null && builder.age_sex.age_tag.size() > 0) {
            for (int i = 0; i < builder.age_sex.age_tag.size() && i < 5; i++) {
                i a3 = i.a(builder.age_sex.age_tag.get(i));
                if (a3 != null) {
                    jVar.cGR.add(a3);
                }
            }
        }
        return jVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cGP;
    }
}
