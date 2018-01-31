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
    public int appendLength;
    private ArrayList<TbRichTextItem> bIL;
    private ArrayList<TbRichTextData> bIM;
    private ArrayList<String> bIN;
    private String bIO;
    private String bIP;
    private String bIQ;
    private int bIR;
    private String bIS;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bIS;
    }

    public void setAuthorId(String str) {
        this.bIS = str;
    }

    public void iW(int i) {
        this.bIR = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bIL = null;
        this.mImageCount = 0;
        this.bIM = null;
        this.bIN = null;
        this.bIR = 0;
        this.bIS = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bIL = null;
        this.mImageCount = 0;
        this.bIM = null;
        this.bIN = null;
        this.bIR = 0;
        this.bIS = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bIL = null;
        this.mImageCount = 0;
        this.bIM = null;
        this.bIN = null;
        this.bIR = 0;
        this.bIS = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bIL = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bIL.add(tbRichTextItem);
                }
            }
            t(context, z);
            bk(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bIL = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bIL.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            bk(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bIL = null;
        this.mImageCount = 0;
        this.bIM = null;
        this.bIN = null;
        this.bIR = 0;
        this.bIS = "";
        this.isChanged = false;
        this.bIM = arrayList;
        bk(context);
    }

    private void bk(Context context) {
        this.bIO = context.getString(d.j.pic_str);
        this.bIP = context.getString(d.j.voice_str);
        this.bIQ = context.getString(d.j.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.bIL != null) {
            this.bIM = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bIN != null) {
                this.bIN.clear();
            }
            Iterator<TbRichTextItem> it = this.bIL.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bIM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.QJ());
                        this.bIM.add(tbRichTextData2);
                        if (this.bIN == null) {
                            this.bIN = new ArrayList<>();
                        }
                        if (next.QJ() != null && next.QJ().QX() != null) {
                            this.bIN.add(next.QJ().QX());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bIM.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.QN());
                        this.bIM.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence y = next.y(tbRichTextData.QI());
                        if (y != null) {
                            tbRichTextData.append(y);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bIM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.QL());
                        this.bIM.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bIM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.QO());
                        this.bIM.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bIM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.QP());
                        this.bIM.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bIM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.QR());
                        this.bIM.add(tbRichTextData7);
                        if (this.bIN == null) {
                            this.bIN = new ArrayList<>();
                        }
                        if (next.QJ() != null && next.QR().Ri() != null) {
                            this.bIN.add(next.QR().Ri());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.QS());
                            this.bIM.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cJ(true);
                        }
                        CharSequence y2 = next.y(tbRichTextData.QI());
                        if (y2 != null) {
                            tbRichTextData.append(y2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bIM.add(tbRichTextData);
            }
            this.bIL.clear();
            this.bIL = null;
        }
    }

    public ArrayList<TbRichTextData> QD() {
        return this.bIM;
    }

    public String toString() {
        if (this.bIM == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bIM.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bIM.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.QQ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.QQ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bIO);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bIP);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.QN() != null) {
                if (StringUtils.isNull(tbRichTextData.QN().Rq())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bIQ).append(tbRichTextData.QN().Rq());
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
