package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationModel.a {
    final /* synthetic */ c aBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aBW = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dx() {
        BaseActivity baseActivity;
        baseActivity = this.aBW.mContext;
        baseActivity.showToast(w.l.no_network_guide);
        this.aBW.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fQ(String str) {
        BaseActivity baseActivity;
        baseActivity = this.aBW.mContext;
        if (StringUtils.isNull(str)) {
            str = this.aBW.CG().getContext().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.aBW.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bmW())) {
            fQ(null);
        } else {
            this.aBW.b(2, true, aVar.bmW());
        }
    }
}
