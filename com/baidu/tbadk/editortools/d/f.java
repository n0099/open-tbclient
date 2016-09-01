package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e awy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awy = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DG() {
        BaseActivity baseActivity;
        baseActivity = this.awy.awl;
        baseActivity.showToast(t.j.no_network_guide);
        this.awy.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fG(String str) {
        BaseActivity baseActivity;
        baseActivity = this.awy.awl;
        if (StringUtils.isNull(str)) {
            str = this.awy.CG().getContext().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.awy.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fG(null);
        } else {
            this.awy.b(2, true, aVar.getFormatted_address());
        }
    }
}
