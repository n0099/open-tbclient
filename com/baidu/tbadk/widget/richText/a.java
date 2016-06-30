package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<i> aEk;
    private int aEl;
    private ArrayList<c> aEm;
    public boolean aEn;
    public int aEo;
    private String aEp;
    private String aEq;
    private String aEr;
    private String aEs;
    private String aEt;
    private int aEu;
    private String aEv;
    public boolean aEw;
    private long postId;

    public String getAuthorId() {
        return this.aEv;
    }

    public void setAuthorId(String str) {
        this.aEv = str;
    }

    public void ff(int i) {
        this.aEu = i;
    }

    public int GE() {
        return this.aEu;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aEk = null;
        this.aEl = 0;
        this.aEm = null;
        this.aEu = 0;
        this.aEv = "";
        this.aEw = false;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aEk = null;
        this.aEl = 0;
        this.aEm = null;
        this.aEu = 0;
        this.aEv = "";
        this.aEw = false;
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        ai(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        ai(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aEk = null;
        this.aEl = 0;
        this.aEm = null;
        this.aEu = 0;
        this.aEv = "";
        this.aEw = false;
        this.aEm = arrayList;
        ai(context);
    }

    private void ai(Context context) {
        this.aEp = context.getString(u.j.pic_str);
        this.aEq = context.getString(u.j.voice_str);
        this.aEr = context.getString(u.j.video_text);
        this.aEs = context.getString(u.j.graffiti_str);
        this.aEt = context.getString(u.j.togetherhi_str);
    }

    private void d(Context context, int i, boolean z) {
        if (this.aEk != null) {
            this.aEm = new ArrayList<>();
            this.aEl = 0;
            Iterator<i> it = this.aEk.iterator();
            boolean z2 = false;
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aEl++;
                    cVar2.a(next.GK());
                    this.aEm.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.GO());
                    this.aEm.add(cVar3);
                    cVar = new c(1);
                    CharSequence w = next.w(cVar.GJ());
                    if (w != null) {
                        cVar.append(w);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.GM());
                    this.aEm.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.GP());
                    this.aEm.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aEl++;
                    cVar6.a(next.GR());
                    this.aEm.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.GT());
                    this.aEm.add(cVar7);
                } else if (next.getType() == 1792) {
                    if (cVar != null) {
                        this.aEm.add(cVar);
                        cVar = null;
                    }
                    c cVar8 = new c(1792);
                    cVar8.a(next.GU());
                    if (z2) {
                        this.aEm.add(1, cVar8);
                    } else {
                        this.aEm.add(0, cVar8);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar9 = new c(1024);
                        cVar9.a(next.GS());
                        this.aEm.add(cVar9);
                    }
                    CharSequence w2 = next.w(cVar.GJ());
                    if (w2 != null) {
                        cVar.append(w2);
                    }
                    z2 = true;
                }
            }
            if (cVar != null) {
                this.aEm.add(cVar);
            }
            this.aEk.clear();
            this.aEk = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aEk = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aEk.add(iVar);
                }
            }
            d(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aEk = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aEk.add(iVar);
                    }
                }
            }
            d(context, i, z);
        }
    }

    public ArrayList<c> GF() {
        return this.aEm;
    }

    public String toString() {
        if (this.aEm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aEm.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aEm.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.GQ() > 0) {
                cVar2 = cVar2.substring(cVar.GQ());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aEn) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aEo));
            } else if (cVar.getType() == 8) {
                sb.append(this.aEp);
            } else if (cVar.getType() == 512) {
                sb.append(this.aEq);
            } else if (cVar.getType() == 32 && cVar.GO() != null) {
                if (StringUtils.isNull(cVar.GO().Hn())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aEr).append(cVar.GO().Hn());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aEs);
            } else if (cVar.getType() == 1792) {
                sb.append(this.aEt);
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
