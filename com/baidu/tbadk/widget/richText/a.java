package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<h> aAX;
    private int aAY;
    private ArrayList<c> aAZ;
    public boolean aBa;
    public int aBb;
    private String aBc;
    private String aBd;
    private String aBe;

    public a(Context context, List<PbContent> list, boolean z) {
        this.aAX = null;
        this.aAY = 0;
        this.aAZ = null;
        a(context, list, -1, z);
    }

    public a(Context context, JSONArray jSONArray, int i) {
        this.aAX = null;
        this.aAY = 0;
        this.aAZ = null;
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
        this.aAX = null;
        this.aAY = 0;
        this.aAZ = null;
        this.aAZ = arrayList;
        ao(context);
    }

    private void ao(Context context) {
        this.aBc = context.getString(i.C0057i.pic_str);
        this.aBd = context.getString(i.C0057i.voice_str);
        this.aBe = context.getString(i.C0057i.video_text);
    }

    private void b(Context context, int i, boolean z) {
        if (this.aAX != null) {
            this.aAZ = new ArrayList<>();
            this.aAY = 0;
            Iterator<h> it = this.aAX.iterator();
            c cVar = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next.getType() == 8) {
                    if (cVar != null) {
                        this.aAZ.add(cVar);
                        cVar = null;
                    }
                    c cVar2 = new c(8);
                    this.aAY++;
                    cVar2.a(next.Fb());
                    this.aAZ.add(cVar2);
                } else if (z && next.getType() == 32) {
                    if (cVar != null) {
                        this.aAZ.add(cVar);
                    }
                    c cVar3 = new c(32);
                    cVar3.fD(next.getVideoUrl());
                    cVar3.a(next.Ff());
                    this.aAZ.add(cVar3);
                    cVar = new c(1);
                    CharSequence y = next.y(cVar.Fa());
                    if (y != null) {
                        cVar.append(y);
                    }
                } else if (next.getType() == 512) {
                    if (cVar != null) {
                        this.aAZ.add(cVar);
                        cVar = null;
                    }
                    c cVar4 = new c(512);
                    cVar4.a(next.Fd());
                    this.aAZ.add(cVar4);
                } else if (next.getType() == 17) {
                    if (cVar != null) {
                        this.aAZ.add(cVar);
                        cVar = null;
                    }
                    c cVar5 = new c(17);
                    cVar5.a(next.Fg());
                    this.aAZ.add(cVar5);
                } else {
                    if (cVar == null) {
                        cVar = new c(1);
                    }
                    CharSequence y2 = next.y(cVar.Fa());
                    if (y2 != null) {
                        cVar.append(y2);
                    }
                }
            }
            if (cVar != null) {
                this.aAZ.add(cVar);
            }
            this.aAX.clear();
            this.aAX = null;
        }
    }

    private void b(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aAX = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                h hVar = new h();
                hVar.parserJson(jSONArray.optJSONObject(i2));
                if ((hVar.getType() & i) != 0) {
                    this.aAX.add(hVar);
                }
            }
            b(context, i, z);
        }
    }

    private void b(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aAX = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    h hVar = new h();
                    hVar.a(pbContent);
                    if ((hVar.getType() & i) != 0) {
                        this.aAX.add(hVar);
                    }
                }
            }
            b(context, i, z);
        }
    }

    public ArrayList<c> EW() {
        return this.aAZ;
    }

    public String toString() {
        if (this.aAZ == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aAZ.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.aAZ.get(i);
            String cVar2 = cVar.toString();
            if (cVar.getType() == 1 && cVar.Fh() > 0) {
                cVar2 = cVar2.substring(cVar.Fh());
            }
            if (i == size - 1 && cVar.getType() == 1 && this.aBa) {
                sb.append(cVar2.substring(0, cVar2.length() - this.aBb));
            } else if (cVar.getType() == 8) {
                sb.append(this.aBc);
            } else if (cVar.getType() == 512) {
                sb.append(this.aBd);
            } else if (cVar.getType() == 32 && cVar.Ff() != null) {
                if (StringUtils.isNull(cVar.Ff().getVideoUrl())) {
                    sb.append(cVar2);
                } else {
                    sb.append(this.aBe).append(cVar.Ff().getVideoUrl());
                }
            } else {
                sb.append(cVar2);
            }
        }
        return sb.toString();
    }
}
