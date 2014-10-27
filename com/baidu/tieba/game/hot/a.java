package com.baidu.tieba.game.hot;

import com.baidu.adp.widget.ListView.aa;
import java.util.List;
/* loaded from: classes.dex */
class a implements aa {
    final /* synthetic */ HotGameActivity aJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HotGameActivity hotGameActivity) {
        this.aJO = hotGameActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        int i;
        int i2;
        List fg;
        HotGameActivity hotGameActivity = this.aJO;
        i = hotGameActivity.Ue;
        hotGameActivity.Ue = i + 1;
        HotGameActivity hotGameActivity2 = this.aJO;
        HotGameActivity hotGameActivity3 = this.aJO;
        i2 = this.aJO.Ue;
        fg = hotGameActivity3.fg(i2 * 20);
        hotGameActivity2.H(fg);
    }
}
