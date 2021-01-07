package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes2.dex */
public class a extends br {
    public static final Integer jYA = 6;
    private boolean eRW;
    private List<MetaData> eRX = new ArrayList();

    @Override // com.baidu.tbadk.core.data.br
    public void bu(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eRX.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jYA);
    }

    @Override // com.baidu.tbadk.core.data.br, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ePu;
    }

    @Override // com.baidu.tbadk.core.data.br
    public List<MetaData> bqE() {
        return this.eRX;
    }

    @Override // com.baidu.tbadk.core.data.br, com.baidu.tbadk.core.data.a
    public bz boP() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.br, com.baidu.tbadk.core.data.a
    public at boR() {
        return new at();
    }

    @Override // com.baidu.tbadk.core.data.br
    public boolean bqF() {
        return this.eRW;
    }

    @Override // com.baidu.tbadk.core.data.br
    public void jx(boolean z) {
        this.eRW = z;
    }
}
