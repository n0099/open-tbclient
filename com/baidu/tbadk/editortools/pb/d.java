package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationModel.a {
    final /* synthetic */ c aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aAQ = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void DH() {
        BaseActivity baseActivity;
        baseActivity = this.aAQ.mContext;
        baseActivity.showToast(w.l.no_network_guide);
        this.aAQ.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fv(String str) {
        BaseActivity baseActivity;
        baseActivity = this.aAQ.mContext;
        if (StringUtils.isNull(str)) {
            str = this.aAQ.CP().getContext().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.aAQ.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bif())) {
            fv(null);
        } else {
            this.aAQ.b(2, true, aVar.bif());
        }
    }
}
