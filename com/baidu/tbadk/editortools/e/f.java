package com.baidu.tbadk.editortools.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e awU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awU = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DL() {
        BaseActivity baseActivity;
        baseActivity = this.awU.awH;
        baseActivity.showToast(r.j.no_network_guide);
        this.awU.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fN(String str) {
        BaseActivity baseActivity;
        baseActivity = this.awU.awH;
        if (StringUtils.isNull(str)) {
            str = this.awU.CO().getContext().getString(r.j.location_fail);
        }
        baseActivity.showToast(str);
        this.awU.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fN(null);
        } else {
            this.awU.b(2, true, aVar.getFormatted_address());
        }
    }
}
