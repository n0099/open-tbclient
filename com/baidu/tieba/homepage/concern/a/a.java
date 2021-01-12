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
    public static final Integer jTV = 6;
    private boolean eNl;
    private List<MetaData> eNm = new ArrayList();

    @Override // com.baidu.tbadk.core.data.br
    public void bu(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eNm.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jTV);
    }

    @Override // com.baidu.tbadk.core.data.br, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eKJ;
    }

    @Override // com.baidu.tbadk.core.data.br
    public List<MetaData> bmK() {
        return this.eNm;
    }

    @Override // com.baidu.tbadk.core.data.br, com.baidu.tbadk.core.data.a
    public bz bkV() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.br, com.baidu.tbadk.core.data.a
    public at bkX() {
        return new at();
    }

    @Override // com.baidu.tbadk.core.data.br
    public boolean bmL() {
        return this.eNl;
    }

    @Override // com.baidu.tbadk.core.data.br
    public void jt(boolean z) {
        this.eNl = z;
    }
}
