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
    private ArrayList<TbRichTextItem> aML;
    private int aMM;
    private ArrayList<TbRichTextData> aMN;
    private ArrayList<String> aMO;
    private String aMP;
    private String aMQ;
    private String aMR;
    private String aMS;
    private int aMT;
    private String aMU;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aMU;
    }

    public void setAuthorId(String str) {
        this.aMU = str;
    }

    public void fq(int i) {
        this.aMT = i;
    }

    public int Hw() {
        return this.aMT;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aML = null;
        this.aMM = 0;
        this.aMN = null;
        this.aMO = null;
        this.aMT = 0;
        this.aMU = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aML = null;
        this.aMM = 0;
        this.aMN = null;
        this.aMO = null;
        this.aMT = 0;
        this.aMU = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aML = null;
        this.aMM = 0;
        this.aMN = null;
        this.aMO = null;
        this.aMT = 0;
        this.aMU = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aML = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aML.add(tbRichTextItem);
                }
            }
            c(context, z);
            aT(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aML = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aML.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aT(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aML = null;
        this.aMM = 0;
        this.aMN = null;
        this.aMO = null;
        this.aMT = 0;
        this.aMU = "";
        this.isChanged = false;
        this.aMN = arrayList;
        aT(context);
    }

    private void aT(Context context) {
        this.aMP = context.getString(w.l.pic_str);
        this.aMQ = context.getString(w.l.voice_str);
        this.aMR = context.getString(w.l.video_text);
        this.aMS = context.getString(w.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aML != null) {
            this.aMN = new ArrayList<>();
            this.aMM = 0;
            if (this.aMO != null) {
                this.aMO.clear();
            }
            Iterator<TbRichTextItem> it = this.aML.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aMN.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aMM++;
                        tbRichTextData2.a(next.HD());
                        this.aMN.add(tbRichTextData2);
                        if (this.aMO == null) {
                            this.aMO = new ArrayList<>();
                        }
                        if (next.HD() != null && next.HD().HR() != null) {
                            this.aMO.add(next.HD().HR());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aMN.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.HH());
                        this.aMN.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.HC());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aMN.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.HF());
                        this.aMN.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aMN.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.HI());
                        this.aMN.add(tbRichTextData5);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aMN.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(1280);
                        this.aMM++;
                        tbRichTextData6.a(next.HK());
                        this.aMN.add(tbRichTextData6);
                        if (this.aMO == null) {
                            this.aMO = new ArrayList<>();
                        }
                        if (next.HD() != null && next.HK().HZ() != null) {
                            this.aMO.add(next.HK().HZ());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aMN.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1536);
                        tbRichTextData7.a(next.HM());
                        this.aMN.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.HL());
                            this.aMN.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cc(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.HC());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aMN.add(tbRichTextData);
            }
            this.aML.clear();
            this.aML = null;
        }
    }

    public ArrayList<TbRichTextData> Hx() {
        return this.aMN;
    }

    public String toString() {
        if (this.aMN == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aMN.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aMN.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.HJ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.HJ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aMP);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aMQ);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.HH() != null) {
                if (StringUtils.isNull(tbRichTextData.HH().Ih())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aMR).append(tbRichTextData.HH().Ih());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aMS);
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
