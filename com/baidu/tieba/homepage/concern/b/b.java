package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes9.dex */
public class b extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId gYb = BdUniqueId.gen();
    public static final Integer gYc = 6;
    private boolean gYd;
    private List<MetaData> gYe = new ArrayList();

    public void bK(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gYe.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(gYc);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gYb;
    }

    public List<MetaData> bNl() {
        return this.gYe;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAe() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAg() {
        return new al();
    }

    public boolean bNm() {
        return this.gYd;
    }

    public void my(boolean z) {
        this.gYd = z;
    }
}
