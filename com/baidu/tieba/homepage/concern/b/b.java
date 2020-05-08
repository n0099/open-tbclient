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
    public static final BdUniqueId hJs = BdUniqueId.gen();
    public static final Integer hJt = 6;
    private boolean hJu;
    private List<MetaData> hJv = new ArrayList();

    public void bT(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.hJv.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(hJt);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hJs;
    }

    public List<MetaData> bYb() {
        return this.hJv;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIu() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIw() {
        return new al();
    }

    public boolean bYc() {
        return this.hJu;
    }

    public void nI(boolean z) {
        this.hJu = z;
    }
}
