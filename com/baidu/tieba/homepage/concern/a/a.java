package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes2.dex */
public class a extends bt {
    public static final Integer kdM = 6;
    private boolean eQY;
    private List<MetaData> eQZ = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bt
    public void bp(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eQZ.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(kdM);
    }

    @Override // com.baidu.tbadk.core.data.bt, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eOw;
    }

    @Override // com.baidu.tbadk.core.data.bt
    public List<MetaData> bnf() {
        return this.eQZ;
    }

    @Override // com.baidu.tbadk.core.data.bt, com.baidu.tbadk.core.data.a
    public cb blp() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bt, com.baidu.tbadk.core.data.a
    public av blr() {
        return new av();
    }

    @Override // com.baidu.tbadk.core.data.bt
    public boolean bng() {
        return this.eQY;
    }

    @Override // com.baidu.tbadk.core.data.bt
    public void jv(boolean z) {
        this.eQY = z;
    }
}
