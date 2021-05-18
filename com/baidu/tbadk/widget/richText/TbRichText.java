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
    public long f13334e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TbRichTextItem> f13335f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TbRichTextData> f13336g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f13337h;
    public boolean hasAppendTime;

    /* renamed from: i  reason: collision with root package name */
    public String f13338i;
    public boolean isChanged;
    public String j;
    public String k;
    public String l;

    public TbRichText(Context context, JSONArray jSONArray, int i2) {
        this.f13334e = -1L;
        this.f13335f = null;
        this.f13336g = null;
        this.l = "";
        this.isChanged = false;
        t(context, jSONArray, i2, false);
    }

    public void A(long j) {
        this.f13334e = j;
    }

    public String getAuthorId() {
        return this.l;
    }

    public long getPostId() {
        return this.f13334e;
    }

    public final void s(Context context, List<PbContent> list, int i2, boolean z, String str) {
        if (list == null) {
            return;
        }
        this.f13335f = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PbContent pbContent = list.get(i3);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.P(pbContent);
                if ((tbRichTextItem.getType() & i2) != 0) {
                    this.f13335f.add(tbRichTextItem);
                }
            }
        }
        y(context, z, str);
        x(context);
    }

    public void setAuthorId(String str) {
        this.l = str;
    }

    public final void t(Context context, JSONArray jSONArray, int i2, boolean z) {
        if (jSONArray == null) {
            return;
        }
        this.f13335f = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i3));
            if ((tbRichTextItem.getType() & i2) != 0) {
                this.f13335f.add(tbRichTextItem);
            }
        }
        y(context, z, null);
        x(context);
    }

    public String toString() {
        if (this.f13336g == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.f13336g.size();
        for (int i2 = 0; i2 < size; i2++) {
            TbRichTextData tbRichTextData = this.f13336g.get(i2);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.B() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.B());
            }
            if (i2 == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.f13338i);
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
        return this.f13336g;
    }

    public int v() {
        ArrayList<TbRichTextImageInfo> arrayList = this.f13337h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<TbRichTextImageInfo> w() {
        return this.f13337h;
    }

    public final void x(Context context) {
        this.f13338i = context.getString(R.string.pic_str);
        this.j = context.getString(R.string.voice_str);
        this.k = context.getString(R.string.video_text);
    }

    public final void y(Context context, boolean z, String str) {
        if (this.f13335f == null) {
            return;
        }
        this.f13336g = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.f13337h;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f13337h = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.f13335f.iterator();
        TbRichTextData tbRichTextData = null;
        while (it.hasNext()) {
            TbRichTextItem next = it.next();
            if (next != null) {
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.f13336g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    tbRichTextData2.K(next.A());
                    this.f13336g.add(tbRichTextData2);
                    this.f13337h.add(next.A());
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.f13336g.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.P(next.K());
                    this.f13336g.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence H = next.H(tbRichTextData.t(), str);
                    if (H != null) {
                        tbRichTextData.s(H);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.f13336g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.Q(next.N());
                    this.f13336g.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.f13336g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.G(next.y());
                    this.f13336g.add(tbRichTextData5);
                } else if (next.getType() == 20) {
                    if (tbRichTextData != null) {
                        this.f13336g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                    tbRichTextData6.N(next.F());
                    this.f13336g.add(tbRichTextData6);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.f13336g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                    tbRichTextData7.M(next.D());
                    this.f13336g.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.L(next.B());
                        this.f13336g.add(tbRichTextData8);
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
            this.f13336g.add(tbRichTextData);
        }
        this.f13335f.clear();
        this.f13335f = null;
    }

    public void z(int i2) {
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        this.f13334e = -1L;
        this.f13335f = null;
        this.f13336g = null;
        this.l = "";
        this.isChanged = false;
        s(context, list, -1, z, str);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.f13334e = -1L;
        this.f13335f = null;
        this.f13336g = null;
        this.l = "";
        this.isChanged = false;
        t(context, jSONArray, -1, z);
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.f13334e = -1L;
        this.f13335f = null;
        this.f13336g = null;
        this.l = "";
        this.isChanged = false;
        this.f13336g = arrayList;
        x(context);
    }
}
