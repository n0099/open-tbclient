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
    private ArrayList<h> aBj;
    private int aBk;
    private ArrayList<c> aBl;
    public boolean aBm;
    public int aBn;
    private String aBo;
    private String aBp;
    private String aBq;

    public a(Context context, List<PbContent> list, boolean z) {
        this.aBj = null;
        this.aBk = 0;
        this.aBl = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.aBj = null;
        this.aBk = 0;
        this.aBl = null;
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
        this.aBj = null;
        this.aBk = 0;
        this.aBl = null;
        this.aBl = arrayList;
        am(context);
    }

    private void am(Context context) {
        this.aBo = context.getString(i.h.pic_str);
        this.aBp = context.getString(i.h.voice_str);
        this.aBq = context.getString(i.h.video_text);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aBj != null) {
            this.aBl = new ArrayList<>();
            this.aBk = 0;
            Iterator<h> it = this.aBj.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aBl.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aBk++;
                    cVar2.a(next.EU());
                    this.aBl.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aBl.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.fP(next.getVideoUrl());
                    cVar3.a(next.EY());
                    this.aBl.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.ET());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aBl.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.EW());
                    this.aBl.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aBl.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.EZ());
                    this.aBl.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence x2 = next.x(cVar.ET());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                }
            }
            if (cVar != null) {
                this.aBl.add(cVar);
            }
            this.aBj.clear();
            this.aBj = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aBj = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aBj.add(hVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aBj = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aBj.add(hVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> EP() {
        return this.aBl;
    }

    public String toString() {
        if (this.aBl == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aBl.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aBl.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Fa() > 0) {
                cVar2 = cVar2.substring(cVar.Fa());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aBm) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aBn));
            } else if (cVar.getType() == 8) {
                sb.append(this.aBo);
            } else if (cVar.getType() == 512) {
                sb.append(this.aBp);
            } else if (cVar.getType() == 32 && cVar.EY() != null) {
                if (StringUtils.isNull(cVar.EY().getVideoUrl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aBq).append(cVar.EY().getVideoUrl());
                }
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
