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
    public static final Integer jqV = 6;
    private boolean ewV;
    private List<MetaData> ewW = new ArrayList();

    @Override // com.baidu.tbadk.core.data.bo
    public void bd(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.ewW.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(jqV);
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return euv;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public List<MetaData> bjn() {
        return this.ewW;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.bo, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        return new ar();
    }

    @Override // com.baidu.tbadk.core.data.bo
    public boolean bjo() {
        return this.ewV;
    }

    @Override // com.baidu.tbadk.core.data.bo
    public void iC(boolean z) {
        this.ewV = z;
    }
}
