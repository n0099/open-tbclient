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
    private ArrayList<i> aIl;
    private int aIm;
    private ArrayList<c> aIn;
    public boolean aIo;
    public int aIp;
    private String aIq;
    private String aIr;
    private String aIs;
    private String aIt;
    private String aIu;
    private int aIv;
    private String aIw;
    public boolean aIx;
    private long postId;

    public String getAuthorId() {
        return this.aIw;
    }

    public void setAuthorId(String str) {
        this.aIw = str;
    }

    public void ft(int i) {
        this.aIv = i;
    }

    public int HZ() {
        return this.aIv;
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aIl = null;
        this.aIm = 0;
        this.aIn = null;
        this.aIv = 0;
        this.aIw = "";
        this.aIx = false;
        a(context, jSONArray, i, false);
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aIl = null;
        this.aIm = 0;
        this.aIn = null;
        this.aIv = 0;
        this.aIw = "";
        this.aIx = false;
        a(context, list, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aIl = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aIl.add(iVar);
                }
            }
            b(context, z);
            as(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aIl = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aIl.add(iVar);
                    }
                }
            }
            b(context, z);
            as(context);
        }
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aIl = null;
        this.aIm = 0;
        this.aIn = null;
        this.aIv = 0;
        this.aIw = "";
        this.aIx = false;
        this.aIn = arrayList;
        as(context);
    }

    private void as(Context context) {
        this.aIq = context.getString(t.j.pic_str);
        this.aIr = context.getString(t.j.voice_str);
        this.aIs = context.getString(t.j.video_text);
        this.aIt = context.getString(t.j.graffiti_str);
        this.aIu = context.getString(t.j.togetherhi_str);
    }

    private void b(Context context, boolean z) {
        if (this.aIl != null) {
            this.aIn = new ArrayList<>();
            this.aIm = 0;
            Iterator<i> it = this.aIl.iterator();
            boolean z2 = false;
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aIm++;
                    cVar2.a(next.If());
                    this.aIn.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.Ij());
                    this.aIn.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.Ie());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Ih());
                    this.aIn.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Ik());
                    this.aIn.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aIm++;
                    cVar6.a(next.Im());
                    this.aIn.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.Io());
                    this.aIn.add(cVar7);
                } else if (next.getType() == 1792) {
                    if (cVar != null) {
                        this.aIn.add(cVar);
                        cVar = null;
                    }
                    c cVar8 = new c(1792);
                    cVar8.a(next.Ip());
                    if (z2) {
                        this.aIn.add(1, cVar8);
                    } else {
                        this.aIn.add(0, cVar8);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar9 = new c(1024);
                        cVar9.a(next.In());
                        this.aIn.add(cVar9);
                    }
                    if (next.getType() == 18) {
                        cVar.bY(true);
                    } else {
                        cVar.bY(false);
                    }
                    CharSequence x2 = next.x(cVar.Ie());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                    z2 = true;
                }
            }
            if (cVar != null) {
                this.aIn.add(cVar);
            }
            this.aIl.clear();
            this.aIl = null;
        }
    }

    public ArrayList<c> Ia() {
        return this.aIn;
    }

    public String toString() {
        if (this.aIn == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aIn.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aIn.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Il() > 0) {
                cVar2 = cVar2.substring(cVar.Il());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aIo) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aIp));
            } else if (cVar.getType() == 8) {
                sb.append(this.aIq);
            } else if (cVar.getType() == 512) {
                sb.append(this.aIr);
            } else if (cVar.getType() == 32 && cVar.Ij() != null) {
                if (StringUtils.isNull(cVar.Ij().IK())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aIs).append(cVar.Ij().IK());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aIt);
            } else if (cVar.getType() == 1792) {
                sb.append(this.aIu);
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
