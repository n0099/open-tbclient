package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    private ArrayList<TbRichTextItem> aMg;
    private int aMh;
    private ArrayList<TbRichTextData> aMi;
    private String aMj;
    private String aMk;
    private String aMl;
    private String aMm;
    private int aMn;
    private String aMo;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aMo;
    }

    public void setAuthorId(String str) {
        this.aMo = str;
    }

    public void fp(int i) {
        this.aMn = i;
    }

    public int HO() {
        return this.aMn;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aMg = null;
        this.aMh = 0;
        this.aMi = null;
        this.aMn = 0;
        this.aMo = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aMg = null;
        this.aMh = 0;
        this.aMi = null;
        this.aMn = 0;
        this.aMo = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aMg = null;
        this.aMh = 0;
        this.aMi = null;
        this.aMn = 0;
        this.aMo = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aMg = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aMg.add(tbRichTextItem);
                }
            }
            c(context, z);
            aO(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aMg = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aMg.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aO(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aMg = null;
        this.aMh = 0;
        this.aMi = null;
        this.aMn = 0;
        this.aMo = "";
        this.isChanged = false;
        this.aMi = arrayList;
        aO(context);
    }

    private void aO(Context context) {
        this.aMj = context.getString(w.l.pic_str);
        this.aMk = context.getString(w.l.voice_str);
        this.aMl = context.getString(w.l.video_text);
        this.aMm = context.getString(w.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aMg != null) {
            this.aMi = new ArrayList<>();
            this.aMh = 0;
            Iterator<TbRichTextItem> it = this.aMg.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.aMi.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    this.aMh++;
                    tbRichTextData2.a(next.HV());
                    this.aMi.add(tbRichTextData2);
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.aMi.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.a(next.HZ());
                    this.aMi.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence x = next.x(tbRichTextData.HU());
                    if (x != null) {
                        tbRichTextData.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.aMi.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.a(next.HX());
                    this.aMi.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.aMi.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.a(next.Ia());
                    this.aMi.add(tbRichTextData5);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.aMi.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(1280);
                    this.aMh++;
                    tbRichTextData6.a(next.Ic());
                    this.aMi.add(tbRichTextData6);
                } else if (next.getType() == 1536) {
                    if (tbRichTextData != null) {
                        this.aMi.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1536);
                    tbRichTextData7.a(next.Ie());
                    this.aMi.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.a(next.Id());
                        this.aMi.add(tbRichTextData8);
                    }
                    if (next.getType() == 18 || next.getType() == 2) {
                        tbRichTextData.ca(true);
                    }
                    CharSequence x2 = next.x(tbRichTextData.HU());
                    if (x2 != null) {
                        tbRichTextData.append(x2);
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aMi.add(tbRichTextData);
            }
            this.aMg.clear();
            this.aMg = null;
        }
    }

    public ArrayList<TbRichTextData> HP() {
        return this.aMi;
    }

    public String toString() {
        if (this.aMi == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aMi.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aMi.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Ib() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Ib());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aMj);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aMk);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.HZ() != null) {
                if (StringUtils.isNull(tbRichTextData.HZ().Iz())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aMl).append(tbRichTextData.HZ().Iz());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aMm);
            } else {
                sb.append(tbRichTextData2);
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
