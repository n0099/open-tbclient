package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class p extends c {
    public static final BdUniqueId aQu = BdUniqueId.gen();
    public static String aQv;
    public static String aQw;
    public static String aQx;
    public static String aQy;
    public static String aQz;
    public z aQp;

    public p(z zVar) {
        this.aQp = zVar;
    }

    public static boolean b(z zVar) {
        return (zVar == null || zVar.sE() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQu;
    }

    @Override // com.baidu.tieba.card.a.c
    public z Iv() {
        return this.aQp;
    }

    public av IA() {
        return gM(aQy);
    }

    public av IB() {
        return gM(aQz);
    }

    public av IC() {
        return gM(aQw);
    }

    public av ID() {
        return gM(aQv);
    }

    public av IL() {
        return gM(aQx);
    }
}
