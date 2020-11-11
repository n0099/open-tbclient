package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class c {
    private a jux;
    private final TbPageContext<BaseFragmentActivity> jys;
    private RecPersonalizePageModel jyt;
    private ConcernNetModel jyu;
    private RecPersonalizePageModel.a jyv = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jux != null) {
                c.this.jux.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aE(int i, String str) {
            if (c.this.jux != null) {
                c.this.jux.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jyw = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jux != null) {
                c.this.jux.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aE(int i, String str) {
            if (c.this.jux != null) {
                c.this.jux.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jyx = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void qR(boolean z) {
            if (c.this.jux != null) {
                c.this.jux.qT(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes22.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void qT(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.jys = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jyt = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jyt.a(this.jyv);
        this.jyu = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jyu.a(this.jyw);
        this.jyu.a(this.jyx);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.jyt != null) {
            this.jyt.e(i, i2, i3, i4, i5);
        }
    }

    public void LI(String str) {
        if (this.jyu != null) {
            this.jyu.LI(str);
        }
    }

    public void qQ(boolean z) {
        if (this.jyu != null) {
            this.jyu.qQ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cJk() {
        return this.jys;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cJl() {
        return null;
    }

    public void a(a aVar) {
        this.jux = aVar;
    }

    public a cJm() {
        return this.jux;
    }
}
