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
    private ArrayList<TbRichTextItem> bKD;
    private ArrayList<TbRichTextData> bKE;
    private ArrayList<String> bKF;
    private String bKG;
    private String bKH;
    private String bKI;
    private int bKJ;
    private String bKK;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bKK;
    }

    public void setAuthorId(String str) {
        this.bKK = str;
    }

    public void iT(int i) {
        this.bKJ = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bKD = null;
        this.mImageCount = 0;
        this.bKE = null;
        this.bKF = null;
        this.bKJ = 0;
        this.bKK = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bKD = null;
        this.mImageCount = 0;
        this.bKE = null;
        this.bKF = null;
        this.bKJ = 0;
        this.bKK = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bKD = null;
        this.mImageCount = 0;
        this.bKE = null;
        this.bKF = null;
        this.bKJ = 0;
        this.bKK = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bKD = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bKD.add(tbRichTextItem);
                }
            }
            u(context, z);
            bj(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bKD = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bKD.add(tbRichTextItem);
                    }
                }
            }
            u(context, z);
            bj(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bKD = null;
        this.mImageCount = 0;
        this.bKE = null;
        this.bKF = null;
        this.bKJ = 0;
        this.bKK = "";
        this.isChanged = false;
        this.bKE = arrayList;
        bj(context);
    }

    private void bj(Context context) {
        this.bKG = context.getString(d.j.pic_str);
        this.bKH = context.getString(d.j.voice_str);
        this.bKI = context.getString(d.j.video_text);
    }

    private void u(Context context, boolean z) {
        if (this.bKD != null) {
            this.bKE = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bKF != null) {
                this.bKF.clear();
            }
            Iterator<TbRichTextItem> it = this.bKD.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bKE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.Rn());
                        this.bKE.add(tbRichTextData2);
                        if (this.bKF == null) {
                            this.bKF = new ArrayList<>();
                        }
                        if (next.Rn() != null && next.Rn().RB() != null) {
                            this.bKF.add(next.Rn().RB());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bKE.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Rr());
                        this.bKE.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence y = next.y(tbRichTextData.Rm());
                        if (y != null) {
                            tbRichTextData.append(y);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bKE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Rp());
                        this.bKE.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bKE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Rs());
                        this.bKE.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bKE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Rt());
                        this.bKE.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bKE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.Rv());
                        this.bKE.add(tbRichTextData7);
                        if (this.bKF == null) {
                            this.bKF = new ArrayList<>();
                        }
                        if (next.Rn() != null && next.Rv().RM() != null) {
                            this.bKF.add(next.Rv().RM());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.Rw());
                            this.bKE.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cN(true);
                        }
                        CharSequence y2 = next.y(tbRichTextData.Rm());
                        if (y2 != null) {
                            tbRichTextData.append(y2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bKE.add(tbRichTextData);
            }
            this.bKD.clear();
            this.bKD = null;
        }
    }

    public ArrayList<TbRichTextData> Rh() {
        return this.bKE;
    }

    public String toString() {
        if (this.bKE == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bKE.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bKE.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Ru() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Ru());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bKG);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bKH);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Rr() != null) {
                if (StringUtils.isNull(tbRichTextData.Rr().RU())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bKI).append(tbRichTextData.Rr().RU());
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
