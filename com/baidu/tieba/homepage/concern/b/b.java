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
    public static final BdUniqueId gYd = BdUniqueId.gen();
    public static final Integer gYe = 6;
    private boolean gYf;
    private List<MetaData> gYg = new ArrayList();

    public void bK(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gYg.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(gYe);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gYd;
    }

    public List<MetaData> bNn() {
        return this.gYg;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAg() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAi() {
        return new al();
    }

    public boolean bNo() {
        return this.gYf;
    }

    public void my(boolean z) {
        this.gYf = z;
    }
}
