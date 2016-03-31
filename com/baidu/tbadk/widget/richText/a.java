package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<i> aHM;
    private int aHN;
    private ArrayList<c> aHO;
    public boolean aHP;
    public int aHQ;
    private String aHR;
    private String aHS;
    private String aHT;
    private String aHU;
    private int aHV;
    private String aHW;
    private long postId;

    public String getAuthorId() {
        return this.aHW;
    }

    public void setAuthorId(String str) {
        this.aHW = str;
    }

    public void fv(int i) {
        this.aHV = i;
    }

    public int Il() {
        return this.aHV;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aHM = null;
        this.aHN = 0;
        this.aHO = null;
        this.aHV = 0;
        this.aHW = "";
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aHM = null;
        this.aHN = 0;
        this.aHO = null;
        this.aHV = 0;
        this.aHW = "";
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        al(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        al(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aHM = null;
        this.aHN = 0;
        this.aHO = null;
        this.aHV = 0;
        this.aHW = "";
        this.aHO = arrayList;
        al(context);
    }

    private void al(Context context) {
        this.aHR = context.getString(t.j.pic_str);
        this.aHS = context.getString(t.j.voice_str);
        this.aHT = context.getString(t.j.video_text);
        this.aHU = context.getString(t.j.graffiti_str);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aHM != null) {
            this.aHO = new ArrayList<>();
            this.aHN = 0;
            Iterator<i> it = this.aHM.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aHO.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aHN++;
                    cVar2.a(next.Ir());
                    this.aHO.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aHO.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.Iv());
                    this.aHO.add(cVar3);
                    cVar = new c(1);
                    CharSequence w = next.w(cVar.Iq());
                    if (w != null) {
                        cVar.append(w);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aHO.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.It());
                    this.aHO.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aHO.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Iw());
                    this.aHO.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aHO.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aHN++;
                    cVar6.a(next.Iy());
                    this.aHO.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aHO.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.IA());
                    this.aHO.add(cVar7);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar8 = new c(1024);
                        cVar8.a(next.Iz());
                        this.aHO.add(cVar8);
                    }
                    CharSequence w2 = next.w(cVar.Iq());
                    if (w2 != null) {
                        cVar.append(w2);
                    }
                }
            }
            if (cVar != null) {
                this.aHO.add(cVar);
            }
            this.aHM.clear();
            this.aHM = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aHM = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aHM.add(iVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aHM = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aHM.add(iVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> Im() {
        return this.aHO;
    }

    public String toString() {
        if (this.aHO == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aHO.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aHO.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Ix() > 0) {
                cVar2 = cVar2.substring(cVar.Ix());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aHP) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aHQ));
            } else if (cVar.getType() == 8) {
                sb.append(this.aHR);
            } else if (cVar.getType() == 512) {
                sb.append(this.aHS);
            } else if (cVar.getType() == 32 && cVar.Iv() != null) {
                if (StringUtils.isNull(cVar.Iv().IU())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aHT).append(cVar.Iv().IU());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aHU);
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }

    public void setPostId(long j) {
        this.postId = j;
    }

    public long getPostId() {
        return this.postId;
    }
}
