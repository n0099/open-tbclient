package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<i> arZ;
    private int asa;
    private ArrayList<c> asb;
    public boolean asc;
    public int asd;
    private Context mContext;

    public a() {
        this.arZ = null;
        this.asa = 0;
        this.asb = null;
        this.mContext = null;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.arZ = null;
        this.asa = 0;
        this.asb = null;
        this.mContext = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.arZ = null;
        this.asa = 0;
        this.asb = null;
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
        this.arZ = null;
        this.asa = 0;
        this.asb = null;
        this.mContext = null;
        this.mContext = context;
        this.asb = arrayList;
    }

    private void j(int i, boolean z) {
        if (this.arZ != null) {
            this.asb = new ArrayList<>();
            this.asa = 0;
            Iterator<i> it = this.arZ.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.asb.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.asa++;
                    cVar2.a(next.DA());
                    this.asb.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.asb.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.eM(next.getVideoUrl());
                    this.asb.add(cVar3);
                    cVar = new c(1);
                    CharSequence f = next.f(this.mContext, cVar.Dz());
                    if (f != null) {
                        cVar.append(f);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.asb.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.DC());
                    this.asb.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.asb.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.DE());
                    this.asb.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence f2 = next.f(this.mContext, cVar.Dz());
                    if (f2 != null) {
                        cVar.append(f2);
                    }
                }
            }
            if (cVar != null) {
                this.asb.add(cVar);
            }
            this.arZ.clear();
            this.arZ = null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.arZ = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.arZ.add(iVar);
                }
            }
            j(i, z);
        }
    }

    private void a(List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.arZ = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.a(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.arZ.add(iVar);
                    }
                }
            }
            j(i, z);
        }
    }

    public ArrayList<c> Dv() {
        return this.asb;
    }

    public String toString() {
        if (this.asb == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.asb.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.asb.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.DF() > 0) {
                cVar2 = cVar2.substring(cVar.DF());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.asc) {
                sb.append(cVar2.substring(0, cVar2.length() - this.asd));
            } else if (cVar.getType() == 8) {
                sb.append(this.mContext.getString(y.pic_str));
            } else if (cVar.getType() == 512) {
                sb.append(this.mContext.getString(y.voice_str));
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
