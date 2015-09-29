package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<h> aAY;
    private int aAZ;
    private ArrayList<c> aBa;
    public boolean aBb;
    public int aBc;
    private String aBd;
    private String aBe;
    private String aBf;

    public a(Context context, List<PbContent> list, boolean z) {
        this.aAY = null;
        this.aAZ = 0;
        this.aBa = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.aAY = null;
        this.aAZ = 0;
        this.aBa = null;
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        am(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        am(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.aAY = null;
        this.aAZ = 0;
        this.aBa = null;
        this.aBa = arrayList;
        am(context);
    }

    private void am(Context context) {
        this.aBd = context.getString(i.h.pic_str);
        this.aBe = context.getString(i.h.voice_str);
        this.aBf = context.getString(i.h.video_text);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aAY != null) {
            this.aBa = new ArrayList<>();
            this.aAZ = 0;
            Iterator<h> it = this.aAY.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aBa.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aAZ++;
                    cVar2.a(next.EY());
                    this.aBa.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aBa.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.fP(next.getVideoUrl());
                    cVar3.a(next.Fc());
                    this.aBa.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.EX());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aBa.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Fa());
                    this.aBa.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aBa.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Fd());
                    this.aBa.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence x2 = next.x(cVar.EX());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                }
            }
            if (cVar != null) {
                this.aBa.add(cVar);
            }
            this.aAY.clear();
            this.aAY = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aAY = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aAY.add(hVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aAY = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aAY.add(hVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> ET() {
        return this.aBa;
    }

    public String toString() {
        if (this.aBa == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aBa.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aBa.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Fe() > 0) {
                cVar2 = cVar2.substring(cVar.Fe());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aBb) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aBc));
            } else if (cVar.getType() == 8) {
                sb.append(this.aBd);
            } else if (cVar.getType() == 512) {
                sb.append(this.aBe);
            } else if (cVar.getType() == 32 && cVar.Fc() != null) {
                if (StringUtils.isNull(cVar.Fc().getVideoUrl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aBf).append(cVar.Fc().getVideoUrl());
                }
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
