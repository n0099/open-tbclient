package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bx;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes21.dex */
public class a extends bp {
    public static final Integer jxI = 6;
    private boolean eBe;
    private List<MetaData> eBf = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bp
    public void bk(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eBf.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jxI);
    }

    @Override // com.baidu.tbadk.core.data.bp, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eyF;
    }

    @Override // com.baidu.tbadk.core.data.bp
    public List<MetaData> bkP() {
        return this.eBf;
    }

    @Override // com.baidu.tbadk.core.data.bp, com.baidu.tbadk.core.data.a
    public bx bjd() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bp, com.baidu.tbadk.core.data.a
    public as bjf() {
        return new as();
    }

    @Override // com.baidu.tbadk.core.data.bp
    public boolean bkQ() {
        return this.eBe;
    }

    @Override // com.baidu.tbadk.core.data.bp
    public void iM(boolean z) {
        this.eBe = z;
    }
}
