package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<h> aCJ;
    private int aCK;
    private ArrayList<c> aCL;
    public boolean aCM;
    public int aCN;
    private String aCO;
    private String aCP;
    private String aCQ;

    public a(Context context, List<PbContent> list, boolean z) {
        this.aCJ = null;
        this.aCK = 0;
        this.aCL = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.aCJ = null;
        this.aCK = 0;
        this.aCL = null;
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
        this.aCJ = null;
        this.aCK = 0;
        this.aCL = null;
        this.aCL = arrayList;
        an(context);
    }

    private void an(Context context) {
        this.aCO = context.getString(n.i.pic_str);
        this.aCP = context.getString(n.i.voice_str);
        this.aCQ = context.getString(n.i.video_text);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aCJ != null) {
            this.aCL = new ArrayList<>();
            this.aCK = 0;
            Iterator<h> it = this.aCJ.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aCL.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aCK++;
                    cVar2.a(next.FQ());
                    this.aCL.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aCL.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.FU());
                    this.aCL.add(cVar3);
                    cVar = new c(1);
                    CharSequence A = next.A(cVar.FP());
                    if (A != null) {
                        cVar.append(A);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aCL.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.FS());
                    this.aCL.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aCL.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.FV());
                    this.aCL.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aCL.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aCK++;
                    cVar6.a(next.FX());
                    this.aCL.add(cVar6);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar7 = new c(1024);
                        cVar7.a(next.FY());
                        this.aCL.add(cVar7);
                    }
                    CharSequence A2 = next.A(cVar.FP());
                    if (A2 != null) {
                        cVar.append(A2);
                    }
                }
            }
            if (cVar != null) {
                this.aCL.add(cVar);
            }
            this.aCJ.clear();
            this.aCJ = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aCJ = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aCJ.add(hVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aCJ = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aCJ.add(hVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> FL() {
        return this.aCL;
    }

    public String toString() {
        if (this.aCL == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aCL.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aCL.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.FW() > 0) {
                cVar2 = cVar2.substring(cVar.FW());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aCM) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aCN));
            } else if (cVar.getType() == 8) {
                sb.append(this.aCO);
            } else if (cVar.getType() == 512) {
                sb.append(this.aCP);
            } else if (cVar.getType() == 32 && cVar.FU() != null) {
                if (StringUtils.isNull(cVar.FU().Gl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aCQ).append(cVar.FU().Gl());
                }
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
