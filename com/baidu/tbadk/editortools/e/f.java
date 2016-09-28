package com.baidu.tbadk.editortools.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e awb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awb = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DG() {
        BaseActivity baseActivity;
        baseActivity = this.awb.avO;
        baseActivity.showToast(r.j.no_network_guide);
        this.awb.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fK(String str) {
        BaseActivity baseActivity;
        baseActivity = this.awb.avO;
        if (StringUtils.isNull(str)) {
            str = this.awb.CG().getContext().getString(r.j.location_fail);
        }
        baseActivity.showToast(str);
        this.awb.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fK(null);
        } else {
            this.awb.b(2, true, aVar.getFormatted_address());
        }
    }
}
