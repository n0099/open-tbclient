package com.baidu.tieba.homepage.alalivelist.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AlaTab.AlaTabResIdl;
import tbclient.ForcusRecommand;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.recommendfrs.data.c {
    public static final int ctu = ForcusRecommand.DEFAULT_TYPE.intValue();
    public ForcusRecommand ctv;

    @Override // com.baidu.tieba.homepage.recommendfrs.data.c, com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        try {
            a((AlaTabResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaTabResIdl.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.baidu.tieba.homepage.recommendfrs.data.c, com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        AlaTabResIdl alaTabResIdl;
        if ((message instanceof AlaTabResIdl) && (alaTabResIdl = (AlaTabResIdl) message) != null && alaTabResIdl.error != null && alaTabResIdl.error.errorno.intValue() == 0 && alaTabResIdl.data != null) {
            this.mHasMore = alaTabResIdl.data.has_more.intValue() == 1;
            this.pn = alaTabResIdl.data.pn.intValue();
            if (alaTabResIdl.data.thread_list != null) {
                this.cAa = new ArrayList();
                this.cAa.addAll(alaTabResIdl.data.thread_list);
            }
            this.ctv = alaTabResIdl.data.forcus_recommand;
        }
    }
}
