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
    private ArrayList<h> aCF;
    private int aCG;
    private ArrayList<c> aCH;
    public boolean aCI;
    public int aCJ;
    private String aCK;
    private String aCL;
    private String aCM;

    public a(Context context, List<PbContent> list, boolean z) {
        this.aCF = null;
        this.aCG = 0;
        this.aCH = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.aCF = null;
        this.aCG = 0;
        this.aCH = null;
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        an(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        an(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.aCF = null;
        this.aCG = 0;
        this.aCH = null;
        this.aCH = arrayList;
        an(context);
    }

    private void an(Context context) {
        this.aCK = context.getString(i.h.pic_str);
        this.aCL = context.getString(i.h.voice_str);
        this.aCM = context.getString(i.h.video_text);
    }

    private void b(Context context, int i, boolean z) {
        if (this.aCF != null) {
            this.aCH = new ArrayList<>();
            this.aCG = 0;
            Iterator<h> it = this.aCF.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aCH.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aCG++;
                    cVar2.a(next.Fl());
                    this.aCH.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aCH.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.fL(next.getVideoUrl());
                    cVar3.a(next.Fp());
                    this.aCH.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.Fk());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aCH.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Fn());
                    this.aCH.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aCH.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Fq());
                    this.aCH.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence x2 = next.x(cVar.Fk());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                }
            }
            if (cVar != null) {
                this.aCH.add(cVar);
            }
            this.aCF.clear();
            this.aCF = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aCF = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aCF.add(hVar);
                }
            }
            b(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aCF = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aCF.add(hVar);
                    }
                }
            }
            b(context, i, z);
        }
    }

    public ArrayList<c> Fg() {
        return this.aCH;
    }

    public String toString() {
        if (this.aCH == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aCH.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aCH.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Fr() > 0) {
                cVar2 = cVar2.substring(cVar.Fr());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aCI) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aCJ));
            } else if (cVar.getType() == 8) {
                sb.append(this.aCK);
            } else if (cVar.getType() == 512) {
                sb.append(this.aCL);
            } else if (cVar.getType() == 32 && cVar.Fp() != null) {
                if (StringUtils.isNull(cVar.Fp().getVideoUrl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aCM).append(cVar.Fp().getVideoUrl());
                }
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
