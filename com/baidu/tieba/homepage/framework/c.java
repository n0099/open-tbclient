package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a fFx;
    private final TbPageContext<BaseFragmentActivity> fIV;
    private RecPersonalizePageModel fIW;
    private ConcernNetModel fIX;
    private RecPersonalizePageModel.a fIY = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.fFx != null) {
                c.this.fFx.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void J(int i, String str) {
            if (c.this.fFx != null) {
                c.this.fFx.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b fIZ = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.fFx != null) {
                c.this.fFx.b(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void J(int i, String str) {
            if (c.this.fFx != null) {
                c.this.fFx.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a fJa = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void ki(boolean z) {
            if (c.this.fFx != null) {
                c.this.fFx.kk(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(tbclient.Userlike.DataRes dataRes, boolean z);

        void kk(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.fIV = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.fIW = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.fIW.a(this.fIY);
        this.fIX = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.fIX.a(this.fIZ);
        this.fIX.a(this.fJa);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.fIW != null) {
            this.fIW.d(i, i2, i3, i4, i5);
        }
    }

    public void wb(String str) {
        if (this.fIX != null) {
            this.fIX.wb(str);
        }
    }

    public void kh(boolean z) {
        if (this.fIX != null) {
            this.fIX.kh(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> blQ() {
        return this.fIV;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a blR() {
        return null;
    }

    public void a(a aVar) {
        this.fFx = aVar;
    }

    public a blS() {
        return this.fFx;
    }
}
