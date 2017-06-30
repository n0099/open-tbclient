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
    private ArrayList<TbRichTextItem> aOb;
    private int aOc;
    private ArrayList<TbRichTextData> aOd;
    private ArrayList<String> aOe;
    private String aOf;
    private String aOg;
    private String aOh;
    private String aOi;
    private int aOj;
    private String aOk;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aOk;
    }

    public void setAuthorId(String str) {
        this.aOk = str;
    }

    public void fs(int i) {
        this.aOj = i;
    }

    public int HT() {
        return this.aOj;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aOb = null;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = null;
        this.aOj = 0;
        this.aOk = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aOb = null;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = null;
        this.aOj = 0;
        this.aOk = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aOb = null;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = null;
        this.aOj = 0;
        this.aOk = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aOb = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aOb.add(tbRichTextItem);
                }
            }
            c(context, z);
            aT(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aOb = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aOb.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aT(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aOb = null;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = null;
        this.aOj = 0;
        this.aOk = "";
        this.isChanged = false;
        this.aOd = arrayList;
        aT(context);
    }

    private void aT(Context context) {
        this.aOf = context.getString(w.l.pic_str);
        this.aOg = context.getString(w.l.voice_str);
        this.aOh = context.getString(w.l.video_text);
        this.aOi = context.getString(w.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aOb != null) {
            this.aOd = new ArrayList<>();
            this.aOc = 0;
            if (this.aOe != null) {
                this.aOe.clear();
            }
            Iterator<TbRichTextItem> it = this.aOb.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aOc++;
                        tbRichTextData2.a(next.Ia());
                        this.aOd.add(tbRichTextData2);
                        if (this.aOe == null) {
                            this.aOe = new ArrayList<>();
                        }
                        if (next.Ia() != null && next.Ia().Ip() != null) {
                            this.aOe.add(next.Ia().Ip());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Ie());
                        this.aOd.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.HZ());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Ic());
                        this.aOd.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.If());
                        this.aOd.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Ig());
                        this.aOd.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aOc++;
                        tbRichTextData7.a(next.Ii());
                        this.aOd.add(tbRichTextData7);
                        if (this.aOe == null) {
                            this.aOe = new ArrayList<>();
                        }
                        if (next.Ia() != null && next.Ii().Ix() != null) {
                            this.aOe.add(next.Ii().Ix());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aOd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1536);
                        tbRichTextData8.a(next.Ik());
                        this.aOd.add(tbRichTextData8);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData9 = new TbRichTextData(1024);
                            tbRichTextData9.a(next.Ij());
                            this.aOd.add(tbRichTextData9);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ce(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.HZ());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aOd.add(tbRichTextData);
            }
            this.aOb.clear();
            this.aOb = null;
        }
    }

    public ArrayList<TbRichTextData> HU() {
        return this.aOd;
    }

    public String toString() {
        if (this.aOd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aOd.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aOd.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Ih() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Ih());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aOf);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aOg);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Ie() != null) {
                if (StringUtils.isNull(tbRichTextData.Ie().IF())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aOh).append(tbRichTextData.Ie().IF());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aOi);
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
