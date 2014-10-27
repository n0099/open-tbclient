package com.baidu.tieba.game.gamesearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements TextWatcher {
    final /* synthetic */ GameSearchActivity aJH;

    private i(GameSearchActivity gameSearchActivity) {
        this.aJH = gameSearchActivity;
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
        this.aJH.Id();
        if (charSequence.toString().trim().length() == 0) {
            this.aJH.aJB = "";
            bdListView = this.aJH.aJn;
            bdListView.setVisibility(8);
            return;
        }
        this.aJH.aJB = charSequence.toString();
        this.aJH.aJD = true;
        GameSearchNetMessage gameSearchNetMessage = new GameSearchNetMessage();
        str = this.aJH.aJB;
        gameSearchNetMessage.setQuery(str);
        i4 = this.aJH.rn;
        gameSearchNetMessage.setRn(Integer.valueOf(i4));
        this.aJH.aJC = 0;
        i5 = this.aJH.aJC;
        gameSearchNetMessage.setPageNum(Integer.valueOf(i5 + 1));
        this.aJH.sendMessage(gameSearchNetMessage);
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
            textView2 = this.aJH.aJy;
            textView2.setVisibility(8);
            oVar2 = this.aJH.aJA;
            oVar2.setVisibility(0);
            bdListView2 = this.aJH.aJn;
            bdListView2.setVisibility(8);
            this.aJH.Id();
            return;
        }
        textView = this.aJH.aJy;
        textView.setVisibility(0);
        oVar = this.aJH.aJA;
        oVar.setVisibility(8);
        bdListView = this.aJH.aJn;
        bdListView.setVisibility(0);
    }
}
