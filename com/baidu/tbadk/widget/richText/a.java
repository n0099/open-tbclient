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
    private ArrayList<i> aIA;
    private int aIB;
    private ArrayList<c> aIC;
    public boolean aID;
    public int aIE;
    private String aIF;
    private String aIG;
    private String aIH;
    private String aII;
    private String aIJ;
    private int aIK;
    private String aIL;
    public boolean aIM;
    private long postId;

    public String getAuthorId() {
        return this.aIL;
    }

    public void setAuthorId(String str) {
        this.aIL = str;
    }

    public void fv(int i) {
        this.aIK = i;
    }

    public int Ib() {
        return this.aIK;
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aIA = null;
        this.aIB = 0;
        this.aIC = null;
        this.aIK = 0;
        this.aIL = "";
        this.aIM = false;
        a(context, jSONArray, i, false);
    }

    public a(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aIA = null;
        this.aIB = 0;
        this.aIC = null;
        this.aIK = 0;
        this.aIL = "";
        this.aIM = false;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aIA = null;
        this.aIB = 0;
        this.aIC = null;
        this.aIK = 0;
        this.aIL = "";
        this.aIM = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aIA = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                i iVar = new i();
                iVar.parserJson(jSONArray.optJSONObject(i2));
                if ((iVar.getType() & i) != 0) {
                    this.aIA.add(iVar);
                }
            }
            b(context, z);
            aq(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aIA = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    i iVar = new i();
                    iVar.b(pbContent);
                    if ((iVar.getType() & i) != 0) {
                        this.aIA.add(iVar);
                    }
                }
            }
            b(context, z);
            aq(context);
        }
    }

    public a(Context context, ArrayList<c> arrayList) {
        this.postId = -1L;
        this.aIA = null;
        this.aIB = 0;
        this.aIC = null;
        this.aIK = 0;
        this.aIL = "";
        this.aIM = false;
        this.aIC = arrayList;
        aq(context);
    }

    private void aq(Context context) {
        this.aIF = context.getString(r.j.pic_str);
        this.aIG = context.getString(r.j.voice_str);
        this.aIH = context.getString(r.j.video_text);
        this.aII = context.getString(r.j.graffiti_str);
        this.aIJ = context.getString(r.j.togetherhi_str);
    }

    private void b(Context context, boolean z) {
        if (this.aIA != null) {
            this.aIC = new ArrayList<>();
            this.aIB = 0;
            Iterator<i> it = this.aIA.iterator();
            boolean z2 = false;
            c cVar = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aIB++;
                    cVar2.a(next.Ih());
                    this.aIC.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.setVideoUrl(next.getVideoUrl());
                    cVar3.a(next.Il());
                    this.aIC.add(cVar3);
                    cVar = new c(1);
                    CharSequence y = next.y(cVar.Ig());
                    if (y != null) {
                        cVar.append(y);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Ij());
                    this.aIC.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Im());
                    this.aIC.add(cVar5);
                } else if (next.getType() == 1280) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                        cVar = null;
                    }
                    c cVar6 = new c(1280);
                    this.aIB++;
                    cVar6.a(next.Io());
                    this.aIC.add(cVar6);
                } else if (next.getType() == 1536) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                        cVar = null;
                    }
                    c cVar7 = new c(1536);
                    cVar7.a(next.Iq());
                    this.aIC.add(cVar7);
                } else if (next.getType() == 1792) {
                    if (cVar != null) {
                        this.aIC.add(cVar);
                        cVar = null;
                    }
                    c cVar8 = new c(1792);
                    cVar8.a(next.Ir());
                    if (z2) {
                        this.aIC.add(1, cVar8);
                    } else {
                        this.aIC.add(0, cVar8);
                    }
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    if (next.getType() == 1024) {
                        c cVar9 = new c(1024);
                        cVar9.a(next.Ip());
                        this.aIC.add(cVar9);
                    }
                    if (next.getType() == 18) {
                        cVar.cc(true);
                    } else {
                        cVar.cc(false);
                    }
                    CharSequence y2 = next.y(cVar.Ig());
                    if (y2 != null) {
                        cVar.append(y2);
                    }
                    z2 = true;
                }
            }
            if (cVar != null) {
                this.aIC.add(cVar);
            }
            this.aIA.clear();
            this.aIA = null;
        }
    }

    public ArrayList<c> Ic() {
        return this.aIC;
    }

    public String toString() {
        if (this.aIC == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aIC.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aIC.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.In() > 0) {
                cVar2 = cVar2.substring(cVar.In());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aID) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aIE));
            } else if (cVar.getType() == 8) {
                sb.append(this.aIF);
            } else if (cVar.getType() == 512) {
                sb.append(this.aIG);
            } else if (cVar.getType() == 32 && cVar.Il() != null) {
                if (StringUtils.isNull(cVar.Il().IM())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aIH).append(cVar.Il().IM());
                }
            } else if (cVar.getType() == 1536) {
                sb.append(this.aII);
            } else if (cVar.getType() == 1792) {
                sb.append(this.aIJ);
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
