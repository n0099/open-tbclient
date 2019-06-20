package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextImageInfo> cIH;
    private ArrayList<TbRichTextItem> cKC;
    private ArrayList<TbRichTextData> cKD;
    private String cKE;
    private String cKF;
    private String cKG;
    private int cKH;
    private String cKI;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cKI;
    }

    public void setAuthorId(String str) {
        this.cKI = str;
    }

    public void lx(int i) {
        this.cKH = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cKC = null;
        this.cKD = null;
        this.cKH = 0;
        this.cKI = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cKC = null;
        this.cKD = null;
        this.cKH = 0;
        this.cKI = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cKC = null;
        this.cKD = null;
        this.cKH = 0;
        this.cKI = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cKC = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cKC.add(tbRichTextItem);
                }
            }
            i(context, z);
            cP(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cKC = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cKC.add(tbRichTextItem);
                    }
                }
            }
            i(context, z);
            cP(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cKC = null;
        this.cKD = null;
        this.cKH = 0;
        this.cKI = "";
        this.isChanged = false;
        this.cKD = arrayList;
        cP(context);
    }

    private void cP(Context context) {
        this.cKE = context.getString(R.string.pic_str);
        this.cKF = context.getString(R.string.voice_str);
        this.cKG = context.getString(R.string.video_text);
    }

    private void i(Context context, boolean z) {
        if (this.cKC != null) {
            this.cKD = new ArrayList<>();
            if (this.cIH != null) {
                this.cIH.clear();
            } else {
                this.cIH = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cKC.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cKD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.axG());
                        this.cKD.add(tbRichTextData2);
                        this.cIH.add(next.axG());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cKD.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.axK());
                        this.cKD.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence G = next.G(tbRichTextData.axF());
                        if (G != null) {
                            tbRichTextData.append(G);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cKD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.axI());
                        this.cKD.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cKD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.axL());
                        this.cKD.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cKD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.axM());
                        this.cKD.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cKD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.axO());
                        this.cKD.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.axP());
                            this.cKD.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fR(true);
                        }
                        CharSequence G2 = next.G(tbRichTextData.axF());
                        if (G2 != null) {
                            tbRichTextData.append(G2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cKD.add(tbRichTextData);
            }
            this.cKC.clear();
            this.cKC = null;
        }
    }

    public ArrayList<TbRichTextData> axz() {
        return this.cKD;
    }

    public String toString() {
        if (this.cKD == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cKD.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cKD.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.axN() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.axN());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cKE);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cKF);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.axK() != null) {
                if (StringUtils.isNull(tbRichTextData.axK().ayn())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cKG).append(tbRichTextData.axK().ayn());
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

    public int getImageCount() {
        if (this.cIH == null) {
            return 0;
        }
        return this.cIH.size();
    }

    public ArrayList<TbRichTextImageInfo> axA() {
        return this.cIH;
    }
}
