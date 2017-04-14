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
    private String aMA;
    private String aMB;
    private String aMC;
    private int aMD;
    private String aME;
    private ArrayList<TbRichTextItem> aMw;
    private int aMx;
    private ArrayList<TbRichTextData> aMy;
    private String aMz;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aME;
    }

    public void setAuthorId(String str) {
        this.aME = str;
    }

    public void fs(int i) {
        this.aMD = i;
    }

    public int In() {
        return this.aMD;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aMw = null;
        this.aMx = 0;
        this.aMy = null;
        this.aMD = 0;
        this.aME = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aMw = null;
        this.aMx = 0;
        this.aMy = null;
        this.aMD = 0;
        this.aME = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aMw = null;
        this.aMx = 0;
        this.aMy = null;
        this.aMD = 0;
        this.aME = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aMw = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aMw.add(tbRichTextItem);
                }
            }
            c(context, z);
            aQ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aMw = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aMw.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aQ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aMw = null;
        this.aMx = 0;
        this.aMy = null;
        this.aMD = 0;
        this.aME = "";
        this.isChanged = false;
        this.aMy = arrayList;
        aQ(context);
    }

    private void aQ(Context context) {
        this.aMz = context.getString(w.l.pic_str);
        this.aMA = context.getString(w.l.voice_str);
        this.aMB = context.getString(w.l.video_text);
        this.aMC = context.getString(w.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aMw != null) {
            this.aMy = new ArrayList<>();
            this.aMx = 0;
            Iterator<TbRichTextItem> it = this.aMw.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.aMy.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    this.aMx++;
                    tbRichTextData2.a(next.Iu());
                    this.aMy.add(tbRichTextData2);
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.aMy.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.a(next.Iy());
                    this.aMy.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence x = next.x(tbRichTextData.It());
                    if (x != null) {
                        tbRichTextData.append(x);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.aMy.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.a(next.Iw());
                    this.aMy.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.aMy.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.a(next.Iz());
                    this.aMy.add(tbRichTextData5);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.aMy.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(1280);
                    this.aMx++;
                    tbRichTextData6.a(next.IB());
                    this.aMy.add(tbRichTextData6);
                } else if (next.getType() == 1536) {
                    if (tbRichTextData != null) {
                        this.aMy.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1536);
                    tbRichTextData7.a(next.ID());
                    this.aMy.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.a(next.IC());
                        this.aMy.add(tbRichTextData8);
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
                this.aMy.add(tbRichTextData);
            }
            this.aMw.clear();
            this.aMw = null;
        }
    }

    public ArrayList<TbRichTextData> Io() {
        return this.aMy;
    }

    public String toString() {
        if (this.aMy == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aMy.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aMy.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IA() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IA());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aMz);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aMA);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Iy() != null) {
                if (StringUtils.isNull(tbRichTextData.Iy().IY())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aMB).append(tbRichTextData.Iy().IY());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aMC);
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
