package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a gcH;
    private final TbPageContext<BaseFragmentActivity> ggf;
    private RecPersonalizePageModel ggg;
    private ConcernNetModel ggh;
    private RecPersonalizePageModel.a ggi = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gcH != null) {
                c.this.gcH.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void O(int i, String str) {
            if (c.this.gcH != null) {
                c.this.gcH.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ggj = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gcH != null) {
                c.this.gcH.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void O(int i, String str) {
            if (c.this.gcH != null) {
                c.this.gcH.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ggk = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void kZ(boolean z) {
            if (c.this.gcH != null) {
                c.this.gcH.lb(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void lb(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ggf = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ggg = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ggg.a(this.ggi);
        this.ggh = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ggh.a(this.ggj);
        this.ggh.a(this.ggk);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.ggg != null) {
            this.ggg.e(i, i2, i3, i4, i5);
        }
    }

    public void wQ(String str) {
        if (this.ggh != null) {
            this.ggh.wQ(str);
        }
    }

    public void kY(boolean z) {
        if (this.ggh != null) {
            this.ggh.kY(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> btw() {
        return this.ggf;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a btx() {
        return null;
    }

    public void a(a aVar) {
        this.gcH = aVar;
    }

    public a bty() {
        return this.gcH;
    }
}
