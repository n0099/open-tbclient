package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.by;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes22.dex */
public class a extends bq {
    public static final Integer jLm = 6;
    private boolean eIe;
    private List<MetaData> eIf = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bq
    public void bn(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eIf.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jLm);
    }

    @Override // com.baidu.tbadk.core.data.bq, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eFE;
    }

    @Override // com.baidu.tbadk.core.data.bq
    public List<MetaData> boc() {
        return this.eIf;
    }

    @Override // com.baidu.tbadk.core.data.bq, com.baidu.tbadk.core.data.a
    public by bmn() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bq, com.baidu.tbadk.core.data.a
    public at bmp() {
        return new at();
    }

    @Override // com.baidu.tbadk.core.data.bq
    public boolean bod() {
        return this.eIe;
    }

    @Override // com.baidu.tbadk.core.data.bq
    public void jb(boolean z) {
        this.eIe = z;
    }
}
