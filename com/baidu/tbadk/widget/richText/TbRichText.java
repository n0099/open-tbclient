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
    private ArrayList<TbRichTextItem> bKQ;
    private ArrayList<TbRichTextData> bKR;
    private ArrayList<String> bKS;
    private String bKT;
    private String bKU;
    private String bKV;
    private int bKW;
    private String bKX;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bKX;
    }

    public void setAuthorId(String str) {
        this.bKX = str;
    }

    public void iT(int i) {
        this.bKW = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bKQ = null;
        this.mImageCount = 0;
        this.bKR = null;
        this.bKS = null;
        this.bKW = 0;
        this.bKX = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bKQ = null;
        this.mImageCount = 0;
        this.bKR = null;
        this.bKS = null;
        this.bKW = 0;
        this.bKX = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bKQ = null;
        this.mImageCount = 0;
        this.bKR = null;
        this.bKS = null;
        this.bKW = 0;
        this.bKX = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bKQ = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bKQ.add(tbRichTextItem);
                }
            }
            u(context, z);
            bj(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bKQ = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bKQ.add(tbRichTextItem);
                    }
                }
            }
            u(context, z);
            bj(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bKQ = null;
        this.mImageCount = 0;
        this.bKR = null;
        this.bKS = null;
        this.bKW = 0;
        this.bKX = "";
        this.isChanged = false;
        this.bKR = arrayList;
        bj(context);
    }

    private void bj(Context context) {
        this.bKT = context.getString(d.j.pic_str);
        this.bKU = context.getString(d.j.voice_str);
        this.bKV = context.getString(d.j.video_text);
    }

    private void u(Context context, boolean z) {
        if (this.bKQ != null) {
            this.bKR = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bKS != null) {
                this.bKS.clear();
            }
            Iterator<TbRichTextItem> it = this.bKQ.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bKR.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.Ro());
                        this.bKR.add(tbRichTextData2);
                        if (this.bKS == null) {
                            this.bKS = new ArrayList<>();
                        }
                        if (next.Ro() != null && next.Ro().RC() != null) {
                            this.bKS.add(next.Ro().RC());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bKR.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Rs());
                        this.bKR.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence y = next.y(tbRichTextData.Rn());
                        if (y != null) {
                            tbRichTextData.append(y);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bKR.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Rq());
                        this.bKR.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bKR.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Rt());
                        this.bKR.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bKR.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Ru());
                        this.bKR.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bKR.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.Rw());
                        this.bKR.add(tbRichTextData7);
                        if (this.bKS == null) {
                            this.bKS = new ArrayList<>();
                        }
                        if (next.Ro() != null && next.Rw().RN() != null) {
                            this.bKS.add(next.Rw().RN());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.Rx());
                            this.bKR.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cN(true);
                        }
                        CharSequence y2 = next.y(tbRichTextData.Rn());
                        if (y2 != null) {
                            tbRichTextData.append(y2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bKR.add(tbRichTextData);
            }
            this.bKQ.clear();
            this.bKQ = null;
        }
    }

    public ArrayList<TbRichTextData> Ri() {
        return this.bKR;
    }

    public String toString() {
        if (this.bKR == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bKR.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bKR.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Rv() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Rv());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bKT);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bKU);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Rs() != null) {
                if (StringUtils.isNull(tbRichTextData.Rs().RV())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bKV).append(tbRichTextData.Rs().RV());
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
