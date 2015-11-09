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
    private ArrayList<c> aAa;
    public boolean aAb;
    public int aAc;
    private String aAd;
    private String aAe;
    private String aAf;
    private ArrayList<h> azY;
    private int azZ;

    public a(Context context, List<PbContent> list, boolean z) {
        this.azY = null;
        this.azZ = 0;
        this.aAa = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.azY = null;
        this.azZ = 0;
        this.aAa = null;
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
        this.azY = null;
        this.azZ = 0;
        this.aAa = null;
        this.aAa = arrayList;
        am(context);
    }

    private void am(Context context) {
        this.aAd = context.getString(i.h.pic_str);
        this.aAe = context.getString(i.h.voice_str);
        this.aAf = context.getString(i.h.video_text);
    }

    private void c(Context context, int i, boolean z) {
        if (this.azY != null) {
            this.aAa = new ArrayList<>();
            this.azZ = 0;
            Iterator<h> it = this.azY.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aAa.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.azZ++;
                    cVar2.a(next.EN());
                    this.aAa.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aAa.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.fR(next.getVideoUrl());
                    cVar3.a(next.ER());
                    this.aAa.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.EM());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aAa.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.EP());
                    this.aAa.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aAa.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.ES());
                    this.aAa.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aAa.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.azZ++;
                    cVar6.a(next.EU());
                    this.aAa.add(cVar6);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar7 = new c(1024);
                        cVar7.a(next.EV());
                        this.aAa.add(cVar7);
                    }
                    CharSequence x2 = next.x(cVar.EM());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                }
            }
            if (cVar != null) {
                this.aAa.add(cVar);
            }
            this.azY.clear();
            this.azY = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.azY = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.azY.add(hVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.azY = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.azY.add(hVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> EI() {
        return this.aAa;
    }

    public String toString() {
        if (this.aAa == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aAa.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aAa.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.ET() > 0) {
                cVar2 = cVar2.substring(cVar.ET());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aAb) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aAc));
            } else if (cVar.getType() == 8) {
                sb.append(this.aAd);
            } else if (cVar.getType() == 512) {
                sb.append(this.aAe);
            } else if (cVar.getType() == 32 && cVar.ER() != null) {
                if (StringUtils.isNull(cVar.ER().getVideoUrl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aAf).append(cVar.ER().getVideoUrl());
                }
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
