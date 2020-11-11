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
/* loaded from: classes22.dex */
public class b extends bo {
    public static final Integer jwS = 6;
    private boolean eCN;
    private List<MetaData> eCO = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bo
    public void bk(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eCO.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jwS);
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAo;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public List<MetaData> blN() {
        return this.eCO;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        return new ar();
    }

    @Override // com.baidu.tbadk.core.data.bo
    public boolean blO() {
        return this.eCN;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public void iL(boolean z) {
        this.eCN = z;
    }
}
