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
    private ArrayList<TbRichTextData> aQA;
    private ArrayList<String> aQB;
    private String aQC;
    private String aQD;
    private String aQE;
    private String aQF;
    private int aQG;
    private String aQH;
    private ArrayList<TbRichTextItem> aQz;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.aQH;
    }

    public void setAuthorId(String str) {
        this.aQH = str;
    }

    public void fx(int i) {
        this.aQG = i;
    }

    public int In() {
        return this.aQG;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aQz = null;
        this.mImageCount = 0;
        this.aQA = null;
        this.aQB = null;
        this.aQG = 0;
        this.aQH = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aQz = null;
        this.mImageCount = 0;
        this.aQA = null;
        this.aQB = null;
        this.aQG = 0;
        this.aQH = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aQz = null;
        this.mImageCount = 0;
        this.aQA = null;
        this.aQB = null;
        this.aQG = 0;
        this.aQH = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aQz = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aQz.add(tbRichTextItem);
                }
            }
            c(context, z);
            aU(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aQz = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aQz.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aU(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aQz = null;
        this.mImageCount = 0;
        this.aQA = null;
        this.aQB = null;
        this.aQG = 0;
        this.aQH = "";
        this.isChanged = false;
        this.aQA = arrayList;
        aU(context);
    }

    private void aU(Context context) {
        this.aQC = context.getString(d.l.pic_str);
        this.aQD = context.getString(d.l.voice_str);
        this.aQE = context.getString(d.l.video_text);
        this.aQF = context.getString(d.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aQz != null) {
            this.aQA = new ArrayList<>();
            this.mImageCount = 0;
            if (this.aQB != null) {
                this.aQB.clear();
            }
            Iterator<TbRichTextItem> it = this.aQz.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.It());
                        this.aQA.add(tbRichTextData2);
                        if (this.aQB == null) {
                            this.aQB = new ArrayList<>();
                        }
                        if (next.It() != null && next.It().II() != null) {
                            this.aQB.add(next.It().II());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Ix());
                        this.aQA.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.Is());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Iv());
                        this.aQA.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Iy());
                        this.aQA.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Iz());
                        this.aQA.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.IB());
                        this.aQA.add(tbRichTextData7);
                        if (this.aQB == null) {
                            this.aQB = new ArrayList<>();
                        }
                        if (next.It() != null && next.IB().IQ() != null) {
                            this.aQB.add(next.IB().IQ());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aQA.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1536);
                        tbRichTextData8.a(next.ID());
                        this.aQA.add(tbRichTextData8);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData9 = new TbRichTextData(1024);
                            tbRichTextData9.a(next.IC());
                            this.aQA.add(tbRichTextData9);
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
                this.aQA.add(tbRichTextData);
            }
            this.aQz.clear();
            this.aQz = null;
        }
    }

    public ArrayList<TbRichTextData> Io() {
        return this.aQA;
    }

    public String toString() {
        if (this.aQA == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aQA.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aQA.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IA() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IA());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aQC);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aQD);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Ix() != null) {
                if (StringUtils.isNull(tbRichTextData.Ix().IY())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aQE).append(tbRichTextData.Ix().IY());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aQF);
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
