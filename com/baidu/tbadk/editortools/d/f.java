package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e arM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.arM = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Ce() {
        BaseActivity baseActivity;
        baseActivity = this.arM.arz;
        baseActivity.showToast(t.j.no_network_guide);
        this.arM.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fz(String str) {
        BaseActivity baseActivity;
        baseActivity = this.arM.arz;
        if (StringUtils.isNull(str)) {
            str = this.arM.Bc().getContext().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.arM.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fz(null);
        } else {
            this.arM.a(2, true, aVar.getFormatted_address());
        }
    }
}
