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
    private ArrayList<i> aHK;
    private int aHL;
    private ArrayList<c> aHM;
    public boolean aHN;
    public int aHO;
    private String aHP;
    private String aHQ;
    private String aHR;
    private String aHS;
    private String aHT;
    private int aHU;
    private String aHV;
    public boolean aHW;
    private long postId;

    public String getAuthorId() {
        return this.aHV;
    }

    public void setAuthorId(String str) {
        this.aHV = str;
    }

    public void fs(int i) {
        this.aHU = i;
    }

    public int HY() {
        return this.aHU;
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aHK = null;
        this.aHL = 0;
        this.aHM = null;
        this.aHU = 0;
        this.aHV = "";
        this.aHW = false;
        a(context, jSONArray, i, false);
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aHK = null;
        this.aHL = 0;
        this.aHM = null;
        this.aHU = 0;
        this.aHV = "";
        this.aHW = false;
        a(context, list, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aHK = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aHK.add(iVar);
                }
            }
            b(context, z);
            aq(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aHK = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aHK.add(iVar);
                    }
                }
            }
            b(context, z);
            aq(context);
        }
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aHK = null;
        this.aHL = 0;
        this.aHM = null;
        this.aHU = 0;
        this.aHV = "";
        this.aHW = false;
        this.aHM = arrayList;
        aq(context);
    }

    private void aq(Context context) {
        this.aHP = context.getString(r.j.pic_str);
        this.aHQ = context.getString(r.j.voice_str);
        this.aHR = context.getString(r.j.video_text);
        this.aHS = context.getString(r.j.graffiti_str);
        this.aHT = context.getString(r.j.togetherhi_str);
    }

    private void b(Context context, boolean z) {
        if (this.aHK != null) {
            this.aHM = new ArrayList<>();
            this.aHL = 0;
            Iterator<i> it = this.aHK.iterator();
            boolean z2 = false;
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aHL++;
                    cVar2.a(next.Ie());
                    this.aHM.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.Ii());
                    this.aHM.add(cVar3);
                    cVar = new c(1);
                    CharSequence x = next.x(cVar.Id());
                    if (x != null) {
                        cVar.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Ig());
                    this.aHM.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Ij());
                    this.aHM.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aHL++;
                    cVar6.a(next.Il());
                    this.aHM.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.In());
                    this.aHM.add(cVar7);
                } else if (next.getType() == 1792) {
                    if (cVar != null) {
                        this.aHM.add(cVar);
                        cVar = null;
                    }
                    c cVar8 = new c(1792);
                    cVar8.a(next.Io());
                    if (z2) {
                        this.aHM.add(1, cVar8);
                    } else {
                        this.aHM.add(0, cVar8);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar9 = new c(1024);
                        cVar9.a(next.Im());
                        this.aHM.add(cVar9);
                    }
                    if (next.getType() == 18) {
                        cVar.bX(true);
                    } else {
                        cVar.bX(false);
                    }
                    CharSequence x2 = next.x(cVar.Id());
                    if (x2 != null) {
                        cVar.append(x2);
                    }
                    z2 = true;
                }
            }
            if (cVar != null) {
                this.aHM.add(cVar);
            }
            this.aHK.clear();
            this.aHK = null;
        }
    }

    public ArrayList<c> HZ() {
        return this.aHM;
    }

    public String toString() {
        if (this.aHM == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aHM.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aHM.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Ik() > 0) {
                cVar2 = cVar2.substring(cVar.Ik());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aHN) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aHO));
            } else if (cVar.getType() == 8) {
                sb.append(this.aHP);
            } else if (cVar.getType() == 512) {
                sb.append(this.aHQ);
            } else if (cVar.getType() == 32 && cVar.Ii() != null) {
                if (StringUtils.isNull(cVar.Ii().IJ())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aHR).append(cVar.Ii().IJ());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aHS);
            } else if (cVar.getType() == 1792) {
                sb.append(this.aHT);
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
