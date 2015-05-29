package com.baidu.tbadk.widget.richText;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<i> atL;
    private int atM;
    private ArrayList<c> atN;
    public boolean atO;
    public int atP;
    private String atQ;
    private String atR;

    public a(Context context, List<PbContent> list, boolean z) {
        this.atL = null;
        this.atM = 0;
        this.atN = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.atL = null;
        this.atM = 0;
        this.atN = null;
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        ak(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        ak(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.atL = null;
        this.atM = 0;
        this.atN = null;
        this.atN = arrayList;
        ak(context);
    }

    private void ak(Context context) {
        this.atQ = context.getString(com.baidu.tieba.t.pic_str);
        this.atR = context.getString(com.baidu.tieba.t.voice_str);
    }

    private void b(Context context, int i, boolean z) {
        if (this.atL != null) {
            this.atN = new ArrayList<>();
            this.atM = 0;
            Iterator<i> it = this.atL.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.atN.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.atM++;
                    cVar2.a(next.Eq());
                    this.atN.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.atN.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.fk(next.getVideoUrl());
                    this.atN.add(cVar3);
                    cVar = new c(1);
                    CharSequence f = next.f(context, cVar.Ep());
                    if (f != null) {
                        cVar.append(f);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.atN.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Es());
                    this.atN.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.atN.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Eu());
                    this.atN.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence f2 = next.f(context, cVar.Ep());
                    if (f2 != null) {
                        cVar.append(f2);
                    }
                }
            }
            if (cVar != null) {
                this.atN.add(cVar);
            }
            this.atL.clear();
            this.atL = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.atL = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.atL.add(iVar);
                }
            }
            b(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.atL = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.a(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.atL.add(iVar);
                    }
                }
            }
            b(context, i, z);
        }
    }

    public ArrayList<c> El() {
        return this.atN;
    }

    public String toString() {
        if (this.atN == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.atN.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.atN.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Ev() > 0) {
                cVar2 = cVar2.substring(cVar.Ev());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.atO) {
                sb.append(cVar2.substring(0, cVar2.length() - this.atP));
            } else if (cVar.getType() == 8) {
                sb.append(this.atQ);
            } else if (cVar.getType() == 512) {
                sb.append(this.atR);
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
