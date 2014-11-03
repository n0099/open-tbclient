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
    private ArrayList<i> abo;
    private int abp;
    private ArrayList<c> abq;
    public boolean abr;
    public int abt;
    private Context mContext;

    public a() {
        this.abo = null;
        this.abp = 0;
        this.abq = null;
        this.mContext = null;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.abo = null;
        this.abp = 0;
        this.abq = null;
        this.mContext = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.abo = null;
        this.abp = 0;
        this.abq = null;
        this.mContext = null;
        a(context, jSONArray, i, false);
    }

    public a(Context context, JSONArray jSONArray, boolean z) {
        this.abo = null;
        this.abp = 0;
        this.abq = null;
        this.mContext = null;
        a(context, jSONArray, -1, z);
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
        this.abo = null;
        this.abp = 0;
        this.abq = null;
        this.mContext = null;
        this.mContext = context;
        this.abq = arrayList;
    }

    private void j(int i, boolean z) {
        if (this.abo != null) {
            this.abq = new ArrayList<>();
            this.abp = 0;
            Iterator<i> it = this.abo.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.abq.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.abp++;
                    cVar2.a(next.vF());
                    this.abq.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.abq.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.dQ(next.getVideoUrl());
                    this.abq.add(cVar3);
                    cVar = new c(1);
                    CharSequence e = next.e(this.mContext, cVar.vE());
                    if (e != null) {
                        cVar.append(e);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.abq.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.vH());
                    this.abq.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.abq.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.vJ());
                    this.abq.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence e2 = next.e(this.mContext, cVar.vE());
                    if (e2 != null) {
                        cVar.append(e2);
                    }
                }
            }
            if (cVar != null) {
                this.abq.add(cVar);
            }
            this.abo.clear();
            this.abo = null;
        }
    }

    private void a(JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.abo = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.abo.add(iVar);
                }
            }
            j(i, z);
        }
    }

    private void a(List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.abo = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.a(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.abo.add(iVar);
                    }
                }
            }
            j(i, z);
        }
    }

    public ArrayList<c> vA() {
        return this.abq;
    }

    public String toString() {
        if (this.abq == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.abq.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.abq.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.vK() > 0) {
                cVar2 = cVar2.substring(cVar.vK());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.abr) {
                sb.append(cVar2.substring(0, cVar2.length() - this.abt));
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
