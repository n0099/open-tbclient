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
    private ArrayList<TbRichTextData> aMA;
    private String aMB;
    private String aMC;
    private String aMD;
    private String aME;
    private int aMF;
    private String aMG;
    private ArrayList<TbRichTextItem> aMy;
    private int aMz;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aMG;
    }

    public void setAuthorId(String str) {
        this.aMG = str;
    }

    public void fs(int i) {
        this.aMF = i;
    }

    public int In() {
        return this.aMF;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aMy = null;
        this.aMz = 0;
        this.aMA = null;
        this.aMF = 0;
        this.aMG = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aMy = null;
        this.aMz = 0;
        this.aMA = null;
        this.aMF = 0;
        this.aMG = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aMy = null;
        this.aMz = 0;
        this.aMA = null;
        this.aMF = 0;
        this.aMG = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aMy = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aMy.add(tbRichTextItem);
                }
            }
            c(context, z);
            aQ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aMy = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aMy.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aQ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aMy = null;
        this.aMz = 0;
        this.aMA = null;
        this.aMF = 0;
        this.aMG = "";
        this.isChanged = false;
        this.aMA = arrayList;
        aQ(context);
    }

    private void aQ(Context context) {
        this.aMB = context.getString(w.l.pic_str);
        this.aMC = context.getString(w.l.voice_str);
        this.aMD = context.getString(w.l.video_text);
        this.aME = context.getString(w.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aMy != null) {
            this.aMA = new ArrayList<>();
            this.aMz = 0;
            Iterator<TbRichTextItem> it = this.aMy.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.aMA.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    this.aMz++;
                    tbRichTextData2.a(next.Iu());
                    this.aMA.add(tbRichTextData2);
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.aMA.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.a(next.Iy());
                    this.aMA.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence x = next.x(tbRichTextData.It());
                    if (x != null) {
                        tbRichTextData.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.aMA.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.a(next.Iw());
                    this.aMA.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.aMA.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.a(next.Iz());
                    this.aMA.add(tbRichTextData5);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.aMA.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(1280);
                    this.aMz++;
                    tbRichTextData6.a(next.IB());
                    this.aMA.add(tbRichTextData6);
                } else if (next.getType() == 1536) {
                    if (tbRichTextData != null) {
                        this.aMA.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1536);
                    tbRichTextData7.a(next.ID());
                    this.aMA.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.a(next.IC());
                        this.aMA.add(tbRichTextData8);
                    }
                    if (next.getType() == 18 || next.getType() == 2) {
                        tbRichTextData.cc(true);
                    }
                    CharSequence x2 = next.x(tbRichTextData.It());
                    if (x2 != null) {
                        tbRichTextData.append(x2);
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aMA.add(tbRichTextData);
            }
            this.aMy.clear();
            this.aMy = null;
        }
    }

    public ArrayList<TbRichTextData> Io() {
        return this.aMA;
    }

    public String toString() {
        if (this.aMA == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aMA.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aMA.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IA() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IA());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aMB);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aMC);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Iy() != null) {
                if (StringUtils.isNull(tbRichTextData.Iy().IY())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aMD).append(tbRichTextData.Iy().IY());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aME);
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
