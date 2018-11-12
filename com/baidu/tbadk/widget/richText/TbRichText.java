package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextItem> bnn;
    private ArrayList<TbRichTextData> bno;
    private ArrayList<String> bnp;
    private String bnq;
    private String bnr;
    private String bns;
    private int bnt;
    private String bnu;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bnu;
    }

    public void setAuthorId(String str) {
        this.bnu = str;
    }

    public void gF(int i) {
        this.bnt = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bnn = null;
        this.mImageCount = 0;
        this.bno = null;
        this.bnp = null;
        this.bnt = 0;
        this.bnu = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bnn = null;
        this.mImageCount = 0;
        this.bno = null;
        this.bnp = null;
        this.bnt = 0;
        this.bnu = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bnn = null;
        this.mImageCount = 0;
        this.bno = null;
        this.bnp = null;
        this.bnt = 0;
        this.bnu = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bnn = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bnn.add(tbRichTextItem);
                }
            }
            k(context, z);
            bP(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bnn = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bnn.add(tbRichTextItem);
                    }
                }
            }
            k(context, z);
            bP(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bnn = null;
        this.mImageCount = 0;
        this.bno = null;
        this.bnp = null;
        this.bnt = 0;
        this.bnu = "";
        this.isChanged = false;
        this.bno = arrayList;
        bP(context);
    }

    private void bP(Context context) {
        this.bnq = context.getString(e.j.pic_str);
        this.bnr = context.getString(e.j.voice_str);
        this.bns = context.getString(e.j.video_text);
    }

    private void k(Context context, boolean z) {
        if (this.bnn != null) {
            this.bno = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bnp != null) {
                this.bnp.clear();
            }
            Iterator<TbRichTextItem> it = this.bnn.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bno.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.QZ());
                        this.bno.add(tbRichTextData2);
                        if (this.bnp == null) {
                            this.bnp = new ArrayList<>();
                        }
                        if (next.QZ() != null && next.QZ().Ro() != null) {
                            this.bnp.add(next.QZ().Ro());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bno.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Rd());
                        this.bno.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence A = next.A(tbRichTextData.QY());
                        if (A != null) {
                            tbRichTextData.append(A);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bno.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Rb());
                        this.bno.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bno.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Re());
                        this.bno.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bno.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Rf());
                        this.bno.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bno.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.Rh());
                        this.bno.add(tbRichTextData7);
                        if (this.bnp == null) {
                            this.bnp = new ArrayList<>();
                        }
                        if (next.QZ() != null && next.Rh().Rz() != null) {
                            this.bnp.add(next.Rh().Rz());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.Ri());
                            this.bno.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.da(true);
                        }
                        CharSequence A2 = next.A(tbRichTextData.QY());
                        if (A2 != null) {
                            tbRichTextData.append(A2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bno.add(tbRichTextData);
            }
            this.bnn.clear();
            this.bnn = null;
        }
    }

    public ArrayList<TbRichTextData> QT() {
        return this.bno;
    }

    public int getImageCount() {
        return this.mImageCount;
    }

    public String toString() {
        if (this.bno == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bno.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bno.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Rg() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Rg());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bnq);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bnr);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Rd() != null) {
                if (StringUtils.isNull(tbRichTextData.Rd().RH())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bns).append(tbRichTextData.Rd().RH());
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
