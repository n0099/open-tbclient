package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    private ArrayList<TbRichTextItem> aRD;
    private int aRE;
    private ArrayList<TbRichTextData> aRF;
    private ArrayList<String> aRG;
    private String aRH;
    private String aRI;
    private String aRJ;
    private int aRK;
    private String aRL;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aRL;
    }

    public void setAuthorId(String str) {
        this.aRL = str;
    }

    public void fT(int i) {
        this.aRK = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aRD = null;
        this.aRE = 0;
        this.aRF = null;
        this.aRG = null;
        this.aRK = 0;
        this.aRL = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aRD = null;
        this.aRE = 0;
        this.aRF = null;
        this.aRG = null;
        this.aRK = 0;
        this.aRL = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aRD = null;
        this.aRE = 0;
        this.aRF = null;
        this.aRG = null;
        this.aRK = 0;
        this.aRL = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aRD = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aRD.add(tbRichTextItem);
                }
            }
            s(context, z);
            aZ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aRD = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aRD.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            aZ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aRD = null;
        this.aRE = 0;
        this.aRF = null;
        this.aRG = null;
        this.aRK = 0;
        this.aRL = "";
        this.isChanged = false;
        this.aRF = arrayList;
        aZ(context);
    }

    private void aZ(Context context) {
        this.aRH = context.getString(d.j.pic_str);
        this.aRI = context.getString(d.j.voice_str);
        this.aRJ = context.getString(d.j.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.aRD != null) {
            this.aRF = new ArrayList<>();
            this.aRE = 0;
            if (this.aRG != null) {
                this.aRG.clear();
            }
            Iterator<TbRichTextItem> it = this.aRD.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aRF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aRE++;
                        tbRichTextData2.a(next.IZ());
                        this.aRF.add(tbRichTextData2);
                        if (this.aRG == null) {
                            this.aRG = new ArrayList<>();
                        }
                        if (next.IZ() != null && next.IZ().Jn() != null) {
                            this.aRG.add(next.IZ().Jn());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aRF.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Jd());
                        this.aRF.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.IY());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aRF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Jb());
                        this.aRF.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aRF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Je());
                        this.aRF.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aRF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Jf());
                        this.aRF.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aRF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aRE++;
                        tbRichTextData7.a(next.Jh());
                        this.aRF.add(tbRichTextData7);
                        if (this.aRG == null) {
                            this.aRG = new ArrayList<>();
                        }
                        if (next.IZ() != null && next.Jh().Jx() != null) {
                            this.aRG.add(next.Jh().Jx());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.Ji());
                            this.aRF.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cd(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.IY());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aRF.add(tbRichTextData);
            }
            this.aRD.clear();
            this.aRD = null;
        }
    }

    public ArrayList<TbRichTextData> IT() {
        return this.aRF;
    }

    public String toString() {
        if (this.aRF == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aRF.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aRF.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Jg() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Jg());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aRH);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aRI);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Jd() != null) {
                if (StringUtils.isNull(tbRichTextData.Jd().JF())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aRJ).append(tbRichTextData.Jd().JF());
                }
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
