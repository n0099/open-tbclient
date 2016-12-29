package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<i> aHU;
    private int aHV;
    private ArrayList<c> aHW;
    public boolean aHX;
    public int aHY;
    private String aHZ;
    private String aIa;
    private String aIb;
    private String aIc;
    private int aId;
    private String aIe;
    public boolean aIf;
    private long postId;

    public String getAuthorId() {
        return this.aIe;
    }

    public void setAuthorId(String str) {
        this.aIe = str;
    }

    public void fv(int i) {
        this.aId = i;
    }

    public int Hx() {
        return this.aId;
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aHU = null;
        this.aHV = 0;
        this.aHW = null;
        this.aId = 0;
        this.aIe = "";
        this.aIf = false;
        a(context, jSONArray, i, false);
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aHU = null;
        this.aHV = 0;
        this.aHW = null;
        this.aId = 0;
        this.aIe = "";
        this.aIf = false;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aHU = null;
        this.aHV = 0;
        this.aHW = null;
        this.aId = 0;
        this.aIe = "";
        this.aIf = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aHU = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aHU.add(iVar);
                }
            }
            b(context, z);
            ao(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aHU = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aHU.add(iVar);
                    }
                }
            }
            b(context, z);
            ao(context);
        }
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aHU = null;
        this.aHV = 0;
        this.aHW = null;
        this.aId = 0;
        this.aIe = "";
        this.aIf = false;
        this.aHW = arrayList;
        ao(context);
    }

    private void ao(Context context) {
        this.aHZ = context.getString(r.j.pic_str);
        this.aIa = context.getString(r.j.voice_str);
        this.aIb = context.getString(r.j.video_text);
        this.aIc = context.getString(r.j.graffiti_str);
    }

    private void b(Context context, boolean z) {
        if (this.aHU != null) {
            this.aHW = new ArrayList<>();
            this.aHV = 0;
            Iterator<i> it = this.aHU.iterator();
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aHW.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aHV++;
                    cVar2.a(next.HD());
                    this.aHW.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aHW.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.HH());
                    this.aHW.add(cVar3);
                    cVar = new c(1);
                    CharSequence y = next.y(cVar.HC());
                    if (y != null) {
                        cVar.append(y);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aHW.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.HF());
                    this.aHW.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aHW.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.HI());
                    this.aHW.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aHW.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aHV++;
                    cVar6.a(next.HK());
                    this.aHW.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aHW.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.HM());
                    this.aHW.add(cVar7);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar8 = new c(1024);
                        cVar8.a(next.HL());
                        this.aHW.add(cVar8);
                    }
                    if (next.getType() == 18) {
                        cVar.cb(true);
                    } else {
                        cVar.cb(false);
                    }
                    CharSequence y2 = next.y(cVar.HC());
                    if (y2 != null) {
                        cVar.append(y2);
                    }
                }
            }
            if (cVar != null) {
                this.aHW.add(cVar);
            }
            this.aHU.clear();
            this.aHU = null;
        }
    }

    public ArrayList<c> Hy() {
        return this.aHW;
    }

    public String toString() {
        if (this.aHW == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aHW.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aHW.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.HJ() > 0) {
                cVar2 = cVar2.substring(cVar.HJ());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aHX) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aHY));
            } else if (cVar.getType() == 8) {
                sb.append(this.aHZ);
            } else if (cVar.getType() == 512) {
                sb.append(this.aIa);
            } else if (cVar.getType() == 32 && cVar.HH() != null) {
                if (StringUtils.isNull(cVar.HH().Ih())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aIb).append(cVar.HH().Ih());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aIc);
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
