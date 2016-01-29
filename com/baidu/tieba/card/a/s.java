package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class s extends c {
    public ah aSu;
    public static final BdUniqueId aSz = BdUniqueId.gen();
    public static String aSA = "";
    public static String aSB = "";
    public static String aSC = "";
    public static String aSD = "";
    public static String aSE = "";
    public boolean aSt = false;
    public boolean aSF = true;

    public s(ah ahVar) {
        this.aSu = ahVar;
    }

    public static boolean b(ah ahVar) {
        return (ahVar == null || ahVar.tz() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSz;
    }

    @Override // com.baidu.tieba.card.a.c
    public ah Ki() {
        return this.aSu;
    }

    public au Kt() {
        return gU(aSD);
    }

    public au Ku() {
        return gU(aSE);
    }

    public au Kv() {
        return gU(aSB);
    }

    public au Kw() {
        return gU(aSA);
    }

    public au KE() {
        return gU(aSC);
    }
}
