package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes16.dex */
public class b extends bo {
    public static final Integer iHH = 6;
    private boolean eaf;
    private List<MetaData> eag = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bo
    public void aM(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eag.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(iHH);
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dXF;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public List<MetaData> bdR() {
        return this.eag;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        return new ar();
    }

    @Override // com.baidu.tbadk.core.data.bo
    public boolean bdS() {
        return this.eaf;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public void hV(boolean z) {
        this.eaf = z;
    }
}
