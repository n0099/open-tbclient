package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes9.dex */
public class b extends AbsThreadDataSupport {
    public static final BdUniqueId hYJ = BdUniqueId.gen();
    public static final Integer hYK = 6;
    private boolean hYL;
    private List<MetaData> hYM = new ArrayList();

    public void bQ(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.hYM.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(hYK);
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hYJ;
    }

    public List<MetaData> ceI() {
        return this.hYM;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        return new ak();
    }

    public boolean ceJ() {
        return this.hYL;
    }

    public void oe(boolean z) {
        this.hYL = z;
    }
}
