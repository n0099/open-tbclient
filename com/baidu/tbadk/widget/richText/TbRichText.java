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
    private ArrayList<TbRichTextItem> aMO;
    private int aMP;
    private ArrayList<TbRichTextData> aMQ;
    private ArrayList<String> aMR;
    private String aMS;
    private String aMT;
    private String aMU;
    private String aMV;
    private int aMW;
    private String aMX;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aMX;
    }

    public void setAuthorId(String str) {
        this.aMX = str;
    }

    public void fp(int i) {
        this.aMW = i;
    }

    public int HB() {
        return this.aMW;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aMO = null;
        this.aMP = 0;
        this.aMQ = null;
        this.aMR = null;
        this.aMW = 0;
        this.aMX = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aMO = null;
        this.aMP = 0;
        this.aMQ = null;
        this.aMR = null;
        this.aMW = 0;
        this.aMX = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aMO = null;
        this.aMP = 0;
        this.aMQ = null;
        this.aMR = null;
        this.aMW = 0;
        this.aMX = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aMO = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aMO.add(tbRichTextItem);
                }
            }
            c(context, z);
            aT(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aMO = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aMO.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aT(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aMO = null;
        this.aMP = 0;
        this.aMQ = null;
        this.aMR = null;
        this.aMW = 0;
        this.aMX = "";
        this.isChanged = false;
        this.aMQ = arrayList;
        aT(context);
    }

    private void aT(Context context) {
        this.aMS = context.getString(w.l.pic_str);
        this.aMT = context.getString(w.l.voice_str);
        this.aMU = context.getString(w.l.video_text);
        this.aMV = context.getString(w.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aMO != null) {
            this.aMQ = new ArrayList<>();
            this.aMP = 0;
            if (this.aMR != null) {
                this.aMR.clear();
            }
            Iterator<TbRichTextItem> it = this.aMO.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aMQ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aMP++;
                        tbRichTextData2.a(next.HI());
                        this.aMQ.add(tbRichTextData2);
                        if (this.aMR == null) {
                            this.aMR = new ArrayList<>();
                        }
                        if (next.HI() != null && next.HI().HW() != null) {
                            this.aMR.add(next.HI().HW());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aMQ.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.HM());
                        this.aMQ.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.HH());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aMQ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.HK());
                        this.aMQ.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aMQ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.HN());
                        this.aMQ.add(tbRichTextData5);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aMQ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(1280);
                        this.aMP++;
                        tbRichTextData6.a(next.HP());
                        this.aMQ.add(tbRichTextData6);
                        if (this.aMR == null) {
                            this.aMR = new ArrayList<>();
                        }
                        if (next.HI() != null && next.HP().Ie() != null) {
                            this.aMR.add(next.HP().Ie());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aMQ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1536);
                        tbRichTextData7.a(next.HR());
                        this.aMQ.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.HQ());
                            this.aMQ.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cf(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.HH());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aMQ.add(tbRichTextData);
            }
            this.aMO.clear();
            this.aMO = null;
        }
    }

    public ArrayList<TbRichTextData> HC() {
        return this.aMQ;
    }

    public String toString() {
        if (this.aMQ == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aMQ.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aMQ.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.HO() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.HO());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aMS);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aMT);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.HM() != null) {
                if (StringUtils.isNull(tbRichTextData.HM().Im())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aMU).append(tbRichTextData.HM().Im());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aMV);
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
