package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e asC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.asC = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cm() {
        BaseActivity baseActivity;
        baseActivity = this.asC.asp;
        baseActivity.showToast(u.j.no_network_guide);
        this.asC.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fF(String str) {
        BaseActivity baseActivity;
        baseActivity = this.asC.asp;
        if (StringUtils.isNull(str)) {
            str = this.asC.Bl().getContext().getString(u.j.location_fail);
        }
        baseActivity.showToast(str);
        this.asC.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fF(null);
        } else {
            this.asC.a(2, true, aVar.getFormatted_address());
        }
    }
}
