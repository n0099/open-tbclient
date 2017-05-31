package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private a cyN;
    private final TbPageContext<BaseFragmentActivity> czJ;
    private RecPersonalizePageModel czK;
    private RecPersonalizePageModel.a czL = new r(this);
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.czJ = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.czK = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.czK.a(this.czL);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.czK != null) {
            this.czK.d(i, i2, i3, i4, i5);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aiu() {
        return this.czJ;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aiv() {
        return null;
    }

    public void a(a aVar) {
        this.cyN = aVar;
    }

    public a aiw() {
        return this.cyN;
    }
}
