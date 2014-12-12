package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<i> aja;
    private int ajb;
    private ArrayList<c> ajc;
    public boolean ajd;
    public int aje;
    private Context mContext;

    public a() {
        this.aja = null;
        this.ajb = 0;
        this.ajc = null;
        this.mContext = null;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.aja = null;
        this.ajb = 0;
        this.ajc = null;
        this.mContext = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.aja = null;
        this.ajb = 0;
        this.ajc = null;
        this.mContext = null;
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        this.mContext = context;
        a(jSONArray, i, z);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        this.mContext = context;
        a(list, i, z);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.aja = null;
        this.ajb = 0;
        this.ajc = null;
        this.mContext = null;
        this.mContext = context;
        this.ajc = arrayList;
    }

    private void j(int i, boolean z) {
        if (this.aja != null) {
            this.ajc = new ArrayList<>();
            this.ajb = 0;
            Iterator<i> it = this.aja.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.ajc.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.ajb++;
                    cVar2.a(next.zQ());
                    this.ajc.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.ajc.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.eJ(next.getVideoUrl());
                    this.ajc.add(cVar3);
                    cVar = new c(1);
                    CharSequence f = next.f(this.mContext, cVar.zP());
                    if (f != null) {
                        cVar.append(f);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.ajc.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.zS());
                    this.ajc.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.ajc.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.zU());
                    this.ajc.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence f2 = next.f(this.mContext, cVar.zP());
                    if (f2 != null) {
                        cVar.append(f2);
                    }
                }
            }
            if (cVar != null) {
                this.ajc.add(cVar);
            }
            this.aja.clear();
            this.aja = null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aja = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aja.add(iVar);
                }
            }
            j(i, z);
        }
    }

    private void a(List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aja = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.a(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aja.add(iVar);
                    }
                }
            }
            j(i, z);
        }
    }

    public ArrayList<c> zL() {
        return this.ajc;
    }

    public String toString() {
        if (this.ajc == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.ajc.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.ajc.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.zV() > 0) {
                cVar2 = cVar2.substring(cVar.zV());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.ajd) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aje));
            } else if (cVar.getType() == 8) {
                sb.append(this.mContext.getString(z.pic_str));
            } else if (cVar.getType() == 512) {
                sb.append(this.mContext.getString(z.voice_str));
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
