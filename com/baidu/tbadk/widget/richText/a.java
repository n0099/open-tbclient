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
    private ArrayList<h> aEi;
    private int aEj;
    private ArrayList<c> aEk;
    public boolean aEl;
    public int aEm;
    private String aEn;
    private String aEo;
    private String aEp;
    private long postId;

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aEi = null;
        this.aEj = 0;
        this.aEk = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aEi = null;
        this.aEj = 0;
        this.aEk = null;
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
        this.postId = -1L;
        this.aEi = null;
        this.aEj = 0;
        this.aEk = null;
        this.aEk = arrayList;
        an(context);
    }

    private void an(Context context) {
        this.aEn = context.getString(n.j.pic_str);
        this.aEo = context.getString(n.j.voice_str);
        this.aEp = context.getString(n.j.video_text);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aEi != null) {
            this.aEk = new ArrayList<>();
            this.aEj = 0;
            Iterator<h> it = this.aEi.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aEk.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aEj++;
                    cVar2.a(next.FF());
                    this.aEk.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aEk.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.FJ());
                    this.aEk.add(cVar3);
                    cVar = new c(1);
                    CharSequence y = next.y(cVar.FE());
                    if (y != null) {
                        cVar.append(y);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aEk.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.FH());
                    this.aEk.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aEk.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.FK());
                    this.aEk.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aEk.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aEj++;
                    cVar6.a(next.FM());
                    this.aEk.add(cVar6);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar7 = new c(1024);
                        cVar7.a(next.FN());
                        this.aEk.add(cVar7);
                    }
                    CharSequence y2 = next.y(cVar.FE());
                    if (y2 != null) {
                        cVar.append(y2);
                    }
                }
            }
            if (cVar != null) {
                this.aEk.add(cVar);
            }
            this.aEi.clear();
            this.aEi = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aEi = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aEi.add(hVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aEi = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aEi.add(hVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> FA() {
        return this.aEk;
    }

    public String toString() {
        if (this.aEk == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aEk.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aEk.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.FL() > 0) {
                cVar2 = cVar2.substring(cVar.FL());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aEl) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aEm));
            } else if (cVar.getType() == 8) {
                sb.append(this.aEn);
            } else if (cVar.getType() == 512) {
                sb.append(this.aEo);
            } else if (cVar.getType() == 32 && cVar.FJ() != null) {
                if (StringUtils.isNull(cVar.FJ().Ga())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aEp).append(cVar.FJ().Ga());
                }
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
