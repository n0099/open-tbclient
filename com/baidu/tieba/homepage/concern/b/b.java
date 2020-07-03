package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bu;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes9.dex */
public class b extends bm {
    public static final Integer inn = 6;
    private boolean dKA;
    private List<MetaData> dKB = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bm
    public void aF(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.dKB.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(inn);
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dIb;
    }

    @Override // com.baidu.tbadk.core.data.bm
    public List<MetaData> aRC() {
        return this.dKB;
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return new ap();
    }

    @Override // com.baidu.tbadk.core.data.bm
    public boolean aRD() {
        return this.dKA;
    }

    @Override // com.baidu.tbadk.core.data.bm
    public void gV(boolean z) {
        this.dKA = z;
    }
}
