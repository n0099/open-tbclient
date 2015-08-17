package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements d.a {
    final /* synthetic */ d ase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ase = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BF() {
        BaseActivity baseActivity;
        baseActivity = this.ase.arT;
        baseActivity.showToast(i.C0057i.no_network_guide);
        this.ase.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void eO(String str) {
        BaseActivity baseActivity;
        baseActivity = this.ase.arT;
        if (StringUtils.isNull(str)) {
            str = this.ase.Ay().getContext().getString(i.C0057i.location_fail);
        }
        baseActivity.showToast(str);
        this.ase.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aqy())) {
            eO(null);
        } else {
            this.ase.a(2, true, aVar.aqy());
        }
    }
}
