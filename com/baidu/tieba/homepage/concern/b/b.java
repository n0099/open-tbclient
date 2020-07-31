package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bv;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes16.dex */
public class b extends bn {
    public static final Integer itq = 6;
    private boolean dQM;
    private List<MetaData> dQN = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bn
    public void aM(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.dQN.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(itq);
    }

    @Override // com.baidu.tbadk.core.data.bn, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dOm;
    }

    @Override // com.baidu.tbadk.core.data.bn
    public List<MetaData> aVy() {
        return this.dQN;
    }

    @Override // com.baidu.tbadk.core.data.bn, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bn, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        return new aq();
    }

    @Override // com.baidu.tbadk.core.data.bn
    public boolean aVz() {
        return this.dQM;
    }

    @Override // com.baidu.tbadk.core.data.bn
    public void hz(boolean z) {
        this.dQM = z;
    }
}
