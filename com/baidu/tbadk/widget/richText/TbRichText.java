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
    public long f13307e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TbRichTextItem> f13308f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TbRichTextData> f13309g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TbRichTextImageInfo> f13310h;
    public boolean hasAppendTime;

    /* renamed from: i  reason: collision with root package name */
    public String f13311i;
    public boolean isChanged;
    public String j;
    public String k;
    public String l;

    public TbRichText(Context context, JSONArray jSONArray, int i2) {
        this.f13307e = -1L;
        this.f13308f = null;
        this.f13309g = null;
        this.l = "";
        this.isChanged = false;
        x(context, jSONArray, i2, false);
    }

    public ArrayList<TbRichTextImageInfo> A() {
        return this.f13310h;
    }

    public final void B(Context context) {
        this.f13311i = context.getString(R.string.pic_str);
        this.j = context.getString(R.string.voice_str);
        this.k = context.getString(R.string.video_text);
    }

    public final void C(Context context, boolean z, String str) {
        if (this.f13308f == null) {
            return;
        }
        this.f13309g = new ArrayList<>();
        ArrayList<TbRichTextImageInfo> arrayList = this.f13310h;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f13310h = new ArrayList<>();
        }
        Iterator<TbRichTextItem> it = this.f13308f.iterator();
        TbRichTextData tbRichTextData = null;
        while (it.hasNext()) {
            TbRichTextItem next = it.next();
            if (next != null) {
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.f13309g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    tbRichTextData2.O(next.E());
                    this.f13309g.add(tbRichTextData2);
                    this.f13310h.add(next.E());
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.f13309g.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.T(next.O());
                    this.f13309g.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence L = next.L(tbRichTextData.x(), str);
                    if (L != null) {
                        tbRichTextData.w(L);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.f13309g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.U(next.R());
                    this.f13309g.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.f13309g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.K(next.C());
                    this.f13309g.add(tbRichTextData5);
                } else if (next.getType() == 20) {
                    if (tbRichTextData != null) {
                        this.f13309g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                    tbRichTextData6.R(next.J());
                    this.f13309g.add(tbRichTextData6);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.f13309g.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                    tbRichTextData7.Q(next.H());
                    this.f13309g.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.P(next.F());
                        this.f13309g.add(tbRichTextData8);
                    }
                    if (next.getType() == 18 || next.getType() == 2 || next.getType() == 39) {
                        tbRichTextData.N(true);
                    }
                    CharSequence L2 = next.L(tbRichTextData.x(), str);
                    if (L2 != null) {
                        tbRichTextData.w(L2);
                    }
                }
            }
        }
        if (tbRichTextData != null) {
            this.f13309g.add(tbRichTextData);
        }
        this.f13308f.clear();
        this.f13308f = null;
    }

    public void D(int i2) {
    }

    public void E(long j) {
        this.f13307e = j;
    }

    public String getAuthorId() {
        return this.l;
    }

    public long getPostId() {
        return this.f13307e;
    }

    public void setAuthorId(String str) {
        this.l = str;
    }

    public String toString() {
        if (this.f13309g == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.f13309g.size();
        for (int i2 = 0; i2 < size; i2++) {
            TbRichTextData tbRichTextData = this.f13309g.get(i2);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.F() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.F());
            }
            if (i2 == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.f13311i);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.j);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.H() != null) {
                if (StringUtils.isNull(tbRichTextData.H().a())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.k);
                    sb.append(tbRichTextData.H().a());
                }
            } else {
                sb.append(tbRichTextData2);
            }
        }
        return sb.toString();
    }

    public final void w(Context context, List<PbContent> list, int i2, boolean z, String str) {
        if (list == null) {
            return;
        }
        this.f13308f = new ArrayList<>();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            PbContent pbContent = list.get(i3);
            if (pbContent != null) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.T(pbContent);
                if ((tbRichTextItem.getType() & i2) != 0) {
                    this.f13308f.add(tbRichTextItem);
                }
            }
        }
        C(context, z, str);
        B(context);
    }

    public final void x(Context context, JSONArray jSONArray, int i2, boolean z) {
        if (jSONArray == null) {
            return;
        }
        this.f13308f = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.parserJson(jSONArray.optJSONObject(i3));
            if ((tbRichTextItem.getType() & i2) != 0) {
                this.f13308f.add(tbRichTextItem);
            }
        }
        C(context, z, null);
        B(context);
    }

    public ArrayList<TbRichTextData> y() {
        return this.f13309g;
    }

    public int z() {
        ArrayList<TbRichTextImageInfo> arrayList = this.f13310h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        this.f13307e = -1L;
        this.f13308f = null;
        this.f13309g = null;
        this.l = "";
        this.isChanged = false;
        w(context, list, -1, z, str);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.f13307e = -1L;
        this.f13308f = null;
        this.f13309g = null;
        this.l = "";
        this.isChanged = false;
        x(context, jSONArray, -1, z);
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.f13307e = -1L;
        this.f13308f = null;
        this.f13309g = null;
        this.l = "";
        this.isChanged = false;
        this.f13309g = arrayList;
        B(context);
    }
}
