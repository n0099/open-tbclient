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
    private ArrayList<h> aEY;
    private int aEZ;
    private ArrayList<c> aFa;
    public boolean aFb;
    public int aFc;
    private String aFd;
    private String aFe;
    private String aFf;
    private long postId;

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aEY = null;
        this.aEZ = 0;
        this.aFa = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aEY = null;
        this.aEZ = 0;
        this.aFa = null;
        a(context, jSONArray, i, false);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        b(context, jSONArray, i, z);
        ao(context);
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        b(context, list, i, z);
        ao(context);
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aEY = null;
        this.aEZ = 0;
        this.aFa = null;
        this.aFa = arrayList;
        ao(context);
    }

    private void ao(Context context) {
        this.aFd = context.getString(t.j.pic_str);
        this.aFe = context.getString(t.j.voice_str);
        this.aFf = context.getString(t.j.video_text);
    }

    private void c(Context context, int i, boolean z) {
        if (this.aEY != null) {
            this.aFa = new ArrayList<>();
            this.aEZ = 0;
            Iterator<h> it = this.aEY.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aFa.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aEZ++;
                    cVar2.a(next.GX());
                    this.aFa.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aFa.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.Hb());
                    this.aFa.add(cVar3);
                    cVar = new c(1);
                    CharSequence z2 = next.z(cVar.GW());
                    if (z2 != null) {
                        cVar.append(z2);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aFa.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.GZ());
                    this.aFa.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aFa.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Hc());
                    this.aFa.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aFa.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aEZ++;
                    cVar6.a(next.He());
                    this.aFa.add(cVar6);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar7 = new c(1024);
                        cVar7.a(next.Hf());
                        this.aFa.add(cVar7);
                    }
                    CharSequence z3 = next.z(cVar.GW());
                    if (z3 != null) {
                        cVar.append(z3);
                    }
                }
            }
            if (cVar != null) {
                this.aFa.add(cVar);
            }
            this.aEY.clear();
            this.aEY = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aEY = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aEY.add(hVar);
                }
            }
            c(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aEY = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aEY.add(hVar);
                    }
                }
            }
            c(context, i, z);
        }
    }

    public ArrayList<c> GS() {
        return this.aFa;
    }

    public String toString() {
        if (this.aFa == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aFa.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aFa.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Hd() > 0) {
                cVar2 = cVar2.substring(cVar.Hd());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aFb) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aFc));
            } else if (cVar.getType() == 8) {
                sb.append(this.aFd);
            } else if (cVar.getType() == 512) {
                sb.append(this.aFe);
            } else if (cVar.getType() == 32 && cVar.Hb() != null) {
                if (StringUtils.isNull(cVar.Hb().Hy())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aFf).append(cVar.Hb().Hy());
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
