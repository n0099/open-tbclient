package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e asR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.asR = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cv() {
        BaseActivity baseActivity;
        baseActivity = this.asR.asE;
        baseActivity.showToast(n.i.no_network_guide);
        this.asR.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fs(String str) {
        BaseActivity baseActivity;
        baseActivity = this.asR.asE;
        if (StringUtils.isNull(str)) {
            str = this.asR.Bu().getContext().getString(n.i.location_fail);
        }
        baseActivity.showToast(str);
        this.asR.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aDF())) {
            fs(null);
        } else {
            this.asR.a(2, true, aVar.aDF());
        }
    }
}
