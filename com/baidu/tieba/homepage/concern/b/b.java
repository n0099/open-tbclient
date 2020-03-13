package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes9.dex */
public class b extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId gYp = BdUniqueId.gen();
    public static final Integer gYq = 6;
    private boolean gYr;
    private List<MetaData> gYs = new ArrayList();

    public void bK(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gYs.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(gYq);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gYp;
    }

    public List<MetaData> bNo() {
        return this.gYs;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAg() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAi() {
        return new al();
    }

    public boolean bNp() {
        return this.gYr;
    }

    public void my(boolean z) {
        this.gYr = z;
    }
}
