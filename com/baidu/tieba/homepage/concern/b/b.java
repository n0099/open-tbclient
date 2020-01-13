package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes7.dex */
public class b extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId gWa = BdUniqueId.gen();
    public static final Integer gWb = 6;
    private boolean gWc;
    private List<MetaData> gWd = new ArrayList();

    public void bL(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gWd.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(gWb);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gWa;
    }

    public List<MetaData> bLI() {
        return this.gWd;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axQ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axS() {
        return new al();
    }

    public boolean bLJ() {
        return this.gWc;
    }

    public void mw(boolean z) {
        this.gWc = z;
    }
}
