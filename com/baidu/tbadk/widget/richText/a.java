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
    private ArrayList<i> aFb;
    private int aFc;
    private ArrayList<c> aFd;
    public boolean aFe;
    public int aFf;
    private String aFg;
    private String aFh;
    private String aFi;
    private String aFj;
    private String aFk;
    private int aFl;
    private String aFm;
    public boolean aFn;
    private long postId;

    public String getAuthorId() {
        return this.aFm;
    }

    public void setAuthorId(String str) {
        this.aFm = str;
    }

    public void fe(int i) {
        this.aFl = i;
    }

    public int GC() {
        return this.aFl;
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aFb = null;
        this.aFc = 0;
        this.aFd = null;
        this.aFl = 0;
        this.aFm = "";
        this.aFn = false;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aFb = null;
        this.aFc = 0;
        this.aFd = null;
        this.aFl = 0;
        this.aFm = "";
        this.aFn = false;
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
        this.aFb = null;
        this.aFc = 0;
        this.aFd = null;
        this.aFl = 0;
        this.aFm = "";
        this.aFn = false;
        this.aFd = arrayList;
        ai(context);
    }

    private void ai(Context context) {
        this.aFg = context.getString(u.j.pic_str);
        this.aFh = context.getString(u.j.voice_str);
        this.aFi = context.getString(u.j.video_text);
        this.aFj = context.getString(u.j.graffiti_str);
        this.aFk = context.getString(u.j.togetherhi_str);
    }

    private void d(Context context, int i, boolean z) {
        if (this.aFb != null) {
            this.aFd = new ArrayList<>();
            this.aFc = 0;
            Iterator<i> it = this.aFb.iterator();
            boolean z2 = false;
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aFc++;
                    cVar2.a(next.GI());
                    this.aFd.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.GM());
                    this.aFd.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.GH());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.GK());
                    this.aFd.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.GN());
                    this.aFd.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aFc++;
                    cVar6.a(next.GP());
                    this.aFd.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.GR());
                    this.aFd.add(cVar7);
                } else if (next.getType() == 1792) {
                    if (cVar != null) {
                        this.aFd.add(cVar);
                        cVar = null;
                    }
                    c cVar8 = new c(1792);
                    cVar8.a(next.GS());
                    if (z2) {
                        this.aFd.add(1, cVar8);
                    } else {
                        this.aFd.add(0, cVar8);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar9 = new c(1024);
                        cVar9.a(next.GQ());
                        this.aFd.add(cVar9);
                    }
                    CharSequence x2 = next.x(cVar.GH());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                    z2 = true;
                }
            }
            if (cVar != null) {
                this.aFd.add(cVar);
            }
            this.aFb.clear();
            this.aFb = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aFb = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aFb.add(iVar);
                }
            }
            d(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aFb = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aFb.add(iVar);
                    }
                }
            }
            d(context, i, z);
        }
    }

    public ArrayList<c> GD() {
        return this.aFd;
    }

    public String toString() {
        if (this.aFd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aFd.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aFd.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.GO() > 0) {
                cVar2 = cVar2.substring(cVar.GO());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aFe) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aFf));
            } else if (cVar.getType() == 8) {
                sb.append(this.aFg);
            } else if (cVar.getType() == 512) {
                sb.append(this.aFh);
            } else if (cVar.getType() == 32 && cVar.GM() != null) {
                if (StringUtils.isNull(cVar.GM().Hl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aFi).append(cVar.GM().Hl());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aFj);
            } else if (cVar.getType() == 1792) {
                sb.append(this.aFk);
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
