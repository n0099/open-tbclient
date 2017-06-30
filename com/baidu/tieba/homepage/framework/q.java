package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private a cGz;
    private final TbPageContext<BaseFragmentActivity> cHv;
    private RecPersonalizePageModel cHw;
    private RecPersonalizePageModel.a cHx = new r(this);
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cHv = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cHw = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cHw.a(this.cHx);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.cHw != null) {
            this.cHw.d(i, i2, i3, i4, i5);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> amf() {
        return this.cHv;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a amg() {
        return null;
    }

    public void a(a aVar) {
        this.cGz = aVar;
    }

    public a amh() {
        return this.cGz;
    }
}
