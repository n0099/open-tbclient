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
    private ArrayList<TbRichTextItem> aQA;
    private ArrayList<TbRichTextData> aQB;
    private ArrayList<String> aQC;
    private String aQD;
    private String aQE;
    private String aQF;
    private String aQG;
    private int aQH;
    private String aQI;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.aQI;
    }

    public void setAuthorId(String str) {
        this.aQI = str;
    }

    public void fx(int i) {
        this.aQH = i;
    }

    public int In() {
        return this.aQH;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aQA = null;
        this.mImageCount = 0;
        this.aQB = null;
        this.aQC = null;
        this.aQH = 0;
        this.aQI = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aQA = null;
        this.mImageCount = 0;
        this.aQB = null;
        this.aQC = null;
        this.aQH = 0;
        this.aQI = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aQA = null;
        this.mImageCount = 0;
        this.aQB = null;
        this.aQC = null;
        this.aQH = 0;
        this.aQI = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aQA = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aQA.add(tbRichTextItem);
                }
            }
            s(context, z);
            aU(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aQA = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aQA.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            aU(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aQA = null;
        this.mImageCount = 0;
        this.aQB = null;
        this.aQC = null;
        this.aQH = 0;
        this.aQI = "";
        this.isChanged = false;
        this.aQB = arrayList;
        aU(context);
    }

    private void aU(Context context) {
        this.aQD = context.getString(d.l.pic_str);
        this.aQE = context.getString(d.l.voice_str);
        this.aQF = context.getString(d.l.video_text);
        this.aQG = context.getString(d.l.graffiti_str);
    }

    private void s(Context context, boolean z) {
        if (this.aQA != null) {
            this.aQB = new ArrayList<>();
            this.mImageCount = 0;
            if (this.aQC != null) {
                this.aQC.clear();
            }
            Iterator<TbRichTextItem> it = this.aQA.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.It());
                        this.aQB.add(tbRichTextData2);
                        if (this.aQC == null) {
                            this.aQC = new ArrayList<>();
                        }
                        if (next.It() != null && next.It().II() != null) {
                            this.aQC.add(next.It().II());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Ix());
                        this.aQB.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.Is());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Iv());
                        this.aQB.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Iy());
                        this.aQB.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Iz());
                        this.aQB.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.IB());
                        this.aQB.add(tbRichTextData7);
                        if (this.aQC == null) {
                            this.aQC = new ArrayList<>();
                        }
                        if (next.It() != null && next.IB().IQ() != null) {
                            this.aQC.add(next.IB().IQ());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aQB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1536);
                        tbRichTextData8.a(next.ID());
                        this.aQB.add(tbRichTextData8);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData9 = new TbRichTextData(1024);
                            tbRichTextData9.a(next.IC());
                            this.aQB.add(tbRichTextData9);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ch(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.Is());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aQB.add(tbRichTextData);
            }
            this.aQA.clear();
            this.aQA = null;
        }
    }

    public ArrayList<TbRichTextData> Io() {
        return this.aQB;
    }

    public String toString() {
        if (this.aQB == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aQB.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aQB.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IA() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IA());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aQD);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aQE);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Ix() != null) {
                if (StringUtils.isNull(tbRichTextData.Ix().IY())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aQF).append(tbRichTextData.Ix().IY());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aQG);
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
