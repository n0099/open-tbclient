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
    private ArrayList<i> ash;
    private int asi;
    private ArrayList<c> asj;
    public boolean ask;
    public int asl;
    private Context mContext;

    public a() {
        this.ash = null;
        this.asi = 0;
        this.asj = null;
        this.mContext = null;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.ash = null;
        this.asi = 0;
        this.asj = null;
        this.mContext = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.ash = null;
        this.asi = 0;
        this.asj = null;
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
        this.ash = null;
        this.asi = 0;
        this.asj = null;
        this.mContext = null;
        this.mContext = context;
        this.asj = arrayList;
    }

    private void j(int i, boolean z) {
        if (this.ash != null) {
            this.asj = new ArrayList<>();
            this.asi = 0;
            Iterator<i> it = this.ash.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.asj.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.asi++;
                    cVar2.a(next.DG());
                    this.asj.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.asj.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.eP(next.getVideoUrl());
                    this.asj.add(cVar3);
                    cVar = new c(1);
                    CharSequence f = next.f(this.mContext, cVar.DF());
                    if (f != null) {
                        cVar.append(f);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.asj.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.DI());
                    this.asj.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.asj.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.DK());
                    this.asj.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence f2 = next.f(this.mContext, cVar.DF());
                    if (f2 != null) {
                        cVar.append(f2);
                    }
                }
            }
            if (cVar != null) {
                this.asj.add(cVar);
            }
            this.ash.clear();
            this.ash = null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.ash = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.ash.add(iVar);
                }
            }
            j(i, z);
        }
    }

    private void a(List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.ash = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.a(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.ash.add(iVar);
                    }
                }
            }
            j(i, z);
        }
    }

    public ArrayList<c> DB() {
        return this.asj;
    }

    public String toString() {
        if (this.asj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.asj.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.asj.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.DL() > 0) {
                cVar2 = cVar2.substring(cVar.DL());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.ask) {
                sb.append(cVar2.substring(0, cVar2.length() - this.asl));
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
