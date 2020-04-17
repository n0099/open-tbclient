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
    public static final BdUniqueId hJm = BdUniqueId.gen();
    public static final Integer hJn = 6;
    private boolean hJo;
    private List<MetaData> hJp = new ArrayList();

    public void bT(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.hJp.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(hJn);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hJm;
    }

    public List<MetaData> bYd() {
        return this.hJp;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIw() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIy() {
        return new al();
    }

    public boolean bYe() {
        return this.hJo;
    }

    public void nI(boolean z) {
        this.hJo = z;
    }
}
