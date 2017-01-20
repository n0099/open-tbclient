package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    private ArrayList<TbRichTextItem> aGJ;
    private int aGK;
    private ArrayList<TbRichTextData> aGL;
    private String aGM;
    private String aGN;
    private String aGO;
    private String aGP;
    private int aGQ;
    private String aGR;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aGR;
    }

    public void setAuthorId(String str) {
        this.aGR = str;
    }

    public void fw(int i) {
        this.aGQ = i;
    }

    public int Hp() {
        return this.aGQ;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aGJ = null;
        this.aGK = 0;
        this.aGL = null;
        this.aGQ = 0;
        this.aGR = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aGJ = null;
        this.aGK = 0;
        this.aGL = null;
        this.aGQ = 0;
        this.aGR = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aGJ = null;
        this.aGK = 0;
        this.aGL = null;
        this.aGQ = 0;
        this.aGR = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aGJ = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aGJ.add(tbRichTextItem);
                }
            }
            b(context, z);
            aq(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aGJ = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aGJ.add(tbRichTextItem);
                    }
                }
            }
            b(context, z);
            aq(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aGJ = null;
        this.aGK = 0;
        this.aGL = null;
        this.aGQ = 0;
        this.aGR = "";
        this.isChanged = false;
        this.aGL = arrayList;
        aq(context);
    }

    private void aq(Context context) {
        this.aGM = context.getString(r.l.pic_str);
        this.aGN = context.getString(r.l.voice_str);
        this.aGO = context.getString(r.l.video_text);
        this.aGP = context.getString(r.l.graffiti_str);
    }

    private void b(Context context, boolean z) {
        if (this.aGJ != null) {
            this.aGL = new ArrayList<>();
            this.aGK = 0;
            Iterator<TbRichTextItem> it = this.aGJ.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next.getType() == 8) {
                    if (tbRichTextData != null) {
                        this.aGL.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                    this.aGK++;
                    tbRichTextData2.a(next.Hv());
                    this.aGL.add(tbRichTextData2);
                } else if (z && next.getType() == 32) {
                    if (tbRichTextData != null) {
                        this.aGL.add(tbRichTextData);
                    }
                    TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                    tbRichTextData3.setVideoUrl(next.getVideoUrl());
                    tbRichTextData3.a(next.Hz());
                    this.aGL.add(tbRichTextData3);
                    tbRichTextData = new TbRichTextData(1);
                    CharSequence y = next.y(tbRichTextData.Hu());
                    if (y != null) {
                        tbRichTextData.append(y);
                    }
                } else if (next.getType() == 512) {
                    if (tbRichTextData != null) {
                        this.aGL.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                    tbRichTextData4.a(next.Hx());
                    this.aGL.add(tbRichTextData4);
                } else if (next.getType() == 17) {
                    if (tbRichTextData != null) {
                        this.aGL.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                    tbRichTextData5.a(next.HA());
                    this.aGL.add(tbRichTextData5);
                } else if (next.getType() == 1280) {
                    if (tbRichTextData != null) {
                        this.aGL.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData6 = new TbRichTextData(1280);
                    this.aGK++;
                    tbRichTextData6.a(next.HC());
                    this.aGL.add(tbRichTextData6);
                } else if (next.getType() == 1536) {
                    if (tbRichTextData != null) {
                        this.aGL.add(tbRichTextData);
                        tbRichTextData = null;
                    }
                    TbRichTextData tbRichTextData7 = new TbRichTextData(1536);
                    tbRichTextData7.a(next.HE());
                    this.aGL.add(tbRichTextData7);
                } else {
                    if (tbRichTextData == null) {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    if (next.getType() == 1024) {
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                        tbRichTextData8.a(next.HD());
                        this.aGL.add(tbRichTextData8);
                    }
                    if (next.getType() == 18) {
                        tbRichTextData.cb(true);
                    } else {
                        tbRichTextData.cb(false);
                    }
                    CharSequence y2 = next.y(tbRichTextData.Hu());
                    if (y2 != null) {
                        tbRichTextData.append(y2);
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aGL.add(tbRichTextData);
            }
            this.aGJ.clear();
            this.aGJ = null;
        }
    }

    public ArrayList<TbRichTextData> Hq() {
        return this.aGL;
    }

    public String toString() {
        if (this.aGL == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aGL.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aGL.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.HB() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.HB());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aGM);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aGN);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Hz() != null) {
                if (StringUtils.isNull(tbRichTextData.Hz().HZ())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aGO).append(tbRichTextData.Hz().HZ());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aGP);
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
