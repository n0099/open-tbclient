package com.baidu.tieba.game.gamesearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements TextWatcher {
    final /* synthetic */ GameSearchActivity aJU;

    private i(GameSearchActivity gameSearchActivity) {
        this.aJU = gameSearchActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(GameSearchActivity gameSearchActivity, i iVar) {
        this(gameSearchActivity);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        BdListView bdListView;
        String str;
        int i4;
        int i5;
        this.aJU.Ih();
        if (charSequence.toString().trim().length() == 0) {
            this.aJU.aJO = "";
            bdListView = this.aJU.aJA;
            bdListView.setVisibility(8);
            return;
        }
        this.aJU.aJO = charSequence.toString();
        this.aJU.aJQ = true;
        GameSearchNetMessage gameSearchNetMessage = new GameSearchNetMessage();
        str = this.aJU.aJO;
        gameSearchNetMessage.setQuery(str);
        i4 = this.aJU.rn;
        gameSearchNetMessage.setRn(Integer.valueOf(i4));
        this.aJU.aJP = 0;
        i5 = this.aJU.aJP;
        gameSearchNetMessage.setPageNum(Integer.valueOf(i5 + 1));
        this.aJU.sendMessage(gameSearchNetMessage);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        o oVar;
        BdListView bdListView;
        TextView textView2;
        o oVar2;
        BdListView bdListView2;
        if (editable.toString().trim().length() == 0) {
            textView2 = this.aJU.aJL;
            textView2.setVisibility(8);
            oVar2 = this.aJU.aJN;
            oVar2.setVisibility(0);
            bdListView2 = this.aJU.aJA;
            bdListView2.setVisibility(8);
            this.aJU.Ih();
            return;
        }
        textView = this.aJU.aJL;
        textView.setVisibility(0);
        oVar = this.aJU.aJN;
        oVar.setVisibility(8);
        bdListView = this.aJU.aJA;
        bdListView.setVisibility(0);
    }
}
