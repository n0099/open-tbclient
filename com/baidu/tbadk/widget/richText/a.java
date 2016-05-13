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
    private ArrayList<i> aDK;
    private int aDL;
    private ArrayList<c> aDM;
    public boolean aDN;
    public int aDO;
    private String aDP;
    private String aDQ;
    private String aDR;
    private String aDS;
    private String aDT;
    private int aDU;
    private String aDV;
    private long postId;

    public String getAuthorId() {
        return this.aDV;
    }

    public void setAuthorId(String str) {
        this.aDV = str;
    }

    public void eZ(int i) {
        this.aDU = i;
    }

    public int GD() {
        return this.aDU;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aDK = null;
        this.aDL = 0;
        this.aDM = null;
        this.aDU = 0;
        this.aDV = "";
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aDK = null;
        this.aDL = 0;
        this.aDM = null;
        this.aDU = 0;
        this.aDV = "";
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        aj(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        aj(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aDK = null;
        this.aDL = 0;
        this.aDM = null;
        this.aDU = 0;
        this.aDV = "";
        this.aDM = arrayList;
        aj(context);
    }

    private void aj(Context context) {
        this.aDP = context.getString(t.j.pic_str);
        this.aDQ = context.getString(t.j.voice_str);
        this.aDR = context.getString(t.j.video_text);
        this.aDS = context.getString(t.j.graffiti_str);
        this.aDT = context.getString(t.j.togetherhi_str);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aDK != null) {
            this.aDM = new ArrayList<>();
            this.aDL = 0;
            Iterator<i> it = this.aDK.iterator();
            boolean z2 = false;
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aDL++;
                    cVar2.a(next.GJ());
                    this.aDM.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.GN());
                    this.aDM.add(cVar3);
                    cVar = new c(1);
                    CharSequence w = next.w(cVar.GI());
                    if (w != null) {
                        cVar.append(w);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.GL());
                    this.aDM.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.GO());
                    this.aDM.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aDL++;
                    cVar6.a(next.GQ());
                    this.aDM.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.GS());
                    this.aDM.add(cVar7);
                } else if (next.getType() == 1792) {
                    if (cVar != null) {
                        this.aDM.add(cVar);
                        cVar = null;
                    }
                    c cVar8 = new c(1792);
                    cVar8.a(next.GT());
                    if (z2) {
                        this.aDM.add(1, cVar8);
                    } else {
                        this.aDM.add(0, cVar8);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar9 = new c(1024);
                        cVar9.a(next.GR());
                        this.aDM.add(cVar9);
                    }
                    CharSequence w2 = next.w(cVar.GI());
                    if (w2 != null) {
                        cVar.append(w2);
                    }
                    z2 = true;
                }
            }
            if (cVar != null) {
                this.aDM.add(cVar);
            }
            this.aDK.clear();
            this.aDK = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aDK = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aDK.add(iVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aDK = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aDK.add(iVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> GE() {
        return this.aDM;
    }

    public String toString() {
        if (this.aDM == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aDM.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aDM.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.GP() > 0) {
                cVar2 = cVar2.substring(cVar.GP());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aDN) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aDO));
            } else if (cVar.getType() == 8) {
                sb.append(this.aDP);
            } else if (cVar.getType() == 512) {
                sb.append(this.aDQ);
            } else if (cVar.getType() == 32 && cVar.GN() != null) {
                if (StringUtils.isNull(cVar.GN().Hm())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aDR).append(cVar.GN().Hm());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aDS);
            } else if (cVar.getType() == 1792) {
                sb.append(this.aDT);
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
