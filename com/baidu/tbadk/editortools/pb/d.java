package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationModel.a {
    final /* synthetic */ c avv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.avv = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Do() {
        BaseActivity baseActivity;
        baseActivity = this.avv.mContext;
        baseActivity.showToast(r.l.no_network_guide);
        this.avv.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fG(String str) {
        BaseActivity baseActivity;
        baseActivity = this.avv.mContext;
        if (StringUtils.isNull(str)) {
            str = this.avv.Cw().getContext().getString(r.l.location_fail);
        }
        baseActivity.showToast(str);
        this.avv.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bip())) {
            fG(null);
        } else {
            this.avv.b(2, true, aVar.bip());
        }
    }
}
