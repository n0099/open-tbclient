package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichText extends OrmObject {
    public int appendLength;

    /* renamed from: e  reason: collision with root package name */
    public long f13957e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TbRichTextItem> f13958f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TbRichTextData> f13959g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f13960h;
    public boolean hasAppendTime;
    public String i;
    public boolean isChanged;
    public String j;
    public String k;
    public String l;

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.f13957e = -1L;
        this.f13958f = null;
        this.f13959g = null;
        this.l = "";
        this.isChanged = false;
        t(context, jSONArray, i, false);
    }

    public void A(long j) {
        this.f13957e = j;
    }

    public String getAuthorId() {
        return this.l;
    }

    public long getPostId() {
        return this.f13957e;
    }

    public final void s(Context context, List<PbContent> list, int i, boolean z, String str) {
        if (list == null) {
            return;
        }
        this.f13958f = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            PbContent pbContent = list.get(i2);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.P(pbContent);
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.f13958f.add(tbRichTextItem);
                }
            }
        }
        y(context, z, str);
        x(context);
    }

    public void setAuthorId(String str) {
        this.l = str;
    }

    public final void t(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray == null) {
            return;
        }
        this.f13958f = new ArrayList<>();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
            if ((tbRichTextItem.getType() & i) != 0) {
                this.f13958f.add(tbRichTextItem);
            }
        }
        y(context, z, null);
        x(context);
    }

    public String toString() {
        if (this.f13959g == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.f13959g.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.f13959g.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.B() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.B());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.i);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.j);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.D() != null) {
                if (StringUtils.isNull(tbRichTextData.D().a())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.k);
                    sb.append(tbRichTextData.D().a());
                }
            } else {
                sb.append(tbRichTextData2);
            }
        }
        return sb.toString();
    }

    public ArrayList<TbRichTextData> u() {
        return this.f13959g;
    }

    public int v() {
        ArrayList<TbRichTextImageInfo> arrayList = this.f13960h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<TbRichTextImageInfo> w() {
        return this.f13960h;
    }

    public final void x(Context context) {
        this.i = context.getString(R.string.pic_str);
        this.j = context.getString(R.string.voice_str);
        this.k = context.getString(R.string.video_text);
    }

    public final void y(Context context, boolean z, String str) {
        if (this.f13958f == null) {
            return;
        }
        this.f13959g = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.f13960h;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f13960h = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.f13958f.iterator();
        TbRichTextData tbRichTextData = null;
        while (it.hasNext()) {
            TbRichTextItem next = it.next();
            if (next != null) {
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.f13959g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    tbRichTextData2.K(next.A());
                    this.f13959g.add(tbRichTextData2);
                    this.f13960h.add(next.A());
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.f13959g.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.P(next.K());
                    this.f13959g.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence H = next.H(tbRichTextData.t(), str);
                    if (H != null) {
                        tbRichTextData.s(H);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.f13959g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.Q(next.N());
                    this.f13959g.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.f13959g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.G(next.y());
                    this.f13959g.add(tbRichTextData5);
                } else if (next.getType() == 20) {
                    if (tbRichTextData != null) {
                        this.f13959g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                    tbRichTextData6.N(next.F());
                    this.f13959g.add(tbRichTextData6);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.f13959g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                    tbRichTextData7.M(next.D());
                    this.f13959g.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.L(next.B());
                        this.f13959g.add(tbRichTextData8);
                    }
                    if (next.getType() == 18 || next.getType() == 2 || next.getType() == 39) {
                        tbRichTextData.J(true);
                    }
                    CharSequence H2 = next.H(tbRichTextData.t(), str);
                    if (H2 != null) {
                        tbRichTextData.s(H2);
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.f13959g.add(tbRichTextData);
        }
        this.f13958f.clear();
        this.f13958f = null;
    }

    public void z(int i) {
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        this.f13957e = -1L;
        this.f13958f = null;
        this.f13959g = null;
        this.l = "";
        this.isChanged = false;
        s(context, list, -1, z, str);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.f13957e = -1L;
        this.f13958f = null;
        this.f13959g = null;
        this.l = "";
        this.isChanged = false;
        t(context, jSONArray, -1, z);
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.f13957e = -1L;
        this.f13958f = null;
        this.f13959g = null;
        this.l = "";
        this.isChanged = false;
        this.f13959g = arrayList;
        x(context);
    }
}
