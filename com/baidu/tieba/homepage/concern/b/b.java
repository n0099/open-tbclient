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
    public static final BdUniqueId gZw = BdUniqueId.gen();
    public static final Integer gZx = 6;
    private boolean gZy;
    private List<MetaData> gZz = new ArrayList();

    public void bK(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gZz.add(metaData);
            }
        }
    }

    public static boolean a(ConcernData concernData) {
        if (concernData == null) {
            return false;
        }
        return concernData.recom_type.equals(gZx);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gZw;
    }

    public List<MetaData> bNC() {
        return this.gZz;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAj() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAl() {
        return new al();
    }

    public boolean bND() {
        return this.gZy;
    }

    public void mE(boolean z) {
        this.gZy = z;
    }
}
