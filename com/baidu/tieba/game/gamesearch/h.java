package com.baidu.tieba.game.gamesearch;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ GameSearchActivity aJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GameSearchActivity gameSearchActivity) {
        this.aJH = gameSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BdListView bdListView;
        o oVar;
        editText = this.aJH.aJx;
        editText.setText("");
        bdListView = this.aJH.aJn;
        bdListView.setVisibility(8);
        this.aJH.Id();
        oVar = this.aJH.aJA;
        oVar.setVisibility(0);
    }
}
