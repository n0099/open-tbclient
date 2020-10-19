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
    public static final Integer jex = 6;
    private boolean eoy;
    private List<MetaData> eoz = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bo
    public void aT(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eoz.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jex);
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return elV;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public List<MetaData> bhu() {
        return this.eoz;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        return new ar();
    }

    @Override // com.baidu.tbadk.core.data.bo
    public boolean bhv() {
        return this.eoy;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public void ip(boolean z) {
        this.eoy = z;
    }
}
