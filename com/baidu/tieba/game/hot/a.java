package com.baidu.tieba.game.hot;

import com.baidu.adp.widget.ListView.aa;
import java.util.List;
/* loaded from: classes.dex */
class a implements aa {
    final /* synthetic */ HotGameActivity aKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HotGameActivity hotGameActivity) {
        this.aKb = hotGameActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        int i;
        int i2;
        List fg;
        HotGameActivity hotGameActivity = this.aKb;
        i = hotGameActivity.Ui;
        hotGameActivity.Ui = i + 1;
        HotGameActivity hotGameActivity2 = this.aKb;
        HotGameActivity hotGameActivity3 = this.aKb;
        i2 = this.aKb.Ui;
        fg = hotGameActivity3.fg(i2 * 20);
        hotGameActivity2.H(fg);
    }
}
