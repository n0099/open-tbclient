package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId gSG = BdUniqueId.gen();
    public static final Integer gSH = 6;
    private boolean gSI;
    private List<MetaData> gSJ = new ArrayList();

    public void bL(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gSJ.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(gSH);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gSG;
    }

    public List<MetaData> bKD() {
        return this.gSJ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axx() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axz() {
        return new al();
    }

    public boolean bKE() {
        return this.gSI;
    }

    public void ml(boolean z) {
        this.gSI = z;
    }
}
