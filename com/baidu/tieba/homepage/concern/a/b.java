package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes21.dex */
public class b extends bo {
    public static final Integer iPD = 6;
    private boolean ect;
    private List<MetaData> ecu = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bo
    public void aQ(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.ecu.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(iPD);
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZT;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public List<MetaData> beL() {
        return this.ecu;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        return new ar();
    }

    @Override // com.baidu.tbadk.core.data.bo
    public boolean beM() {
        return this.ect;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public void hT(boolean z) {
        this.ect = z;
    }
}
