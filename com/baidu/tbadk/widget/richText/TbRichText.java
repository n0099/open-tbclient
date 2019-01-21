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
    private ArrayList<TbRichTextItem> brC;
    private ArrayList<TbRichTextData> brD;
    private ArrayList<String> brE;
    private String brF;
    private String brG;
    private String brH;
    private int brI;
    private String brJ;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.brJ;
    }

    public void setAuthorId(String str) {
        this.brJ = str;
    }

    public void gU(int i) {
        this.brI = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.brC = null;
        this.mImageCount = 0;
        this.brD = null;
        this.brE = null;
        this.brI = 0;
        this.brJ = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.brC = null;
        this.mImageCount = 0;
        this.brD = null;
        this.brE = null;
        this.brI = 0;
        this.brJ = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.brC = null;
        this.mImageCount = 0;
        this.brD = null;
        this.brE = null;
        this.brI = 0;
        this.brJ = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.brC = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.brC.add(tbRichTextItem);
                }
            }
            k(context, z);
            bS(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.brC = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.brC.add(tbRichTextItem);
                    }
                }
            }
            k(context, z);
            bS(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.brC = null;
        this.mImageCount = 0;
        this.brD = null;
        this.brE = null;
        this.brI = 0;
        this.brJ = "";
        this.isChanged = false;
        this.brD = arrayList;
        bS(context);
    }

    private void bS(Context context) {
        this.brF = context.getString(e.j.pic_str);
        this.brG = context.getString(e.j.voice_str);
        this.brH = context.getString(e.j.video_text);
    }

    private void k(Context context, boolean z) {
        if (this.brC != null) {
            this.brD = new ArrayList<>();
            this.mImageCount = 0;
            if (this.brE != null) {
                this.brE.clear();
            }
            Iterator<TbRichTextItem> it = this.brC.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.brD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.SD());
                        this.brD.add(tbRichTextData2);
                        if (this.brE == null) {
                            this.brE = new ArrayList<>();
                        }
                        if (next.SD() != null && next.SD().SS() != null) {
                            this.brE.add(next.SD().SS());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.brD.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.SH());
                        this.brD.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence A = next.A(tbRichTextData.SC());
                        if (A != null) {
                            tbRichTextData.append(A);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.brD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.SF());
                        this.brD.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.brD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.SI());
                        this.brD.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.brD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.SJ());
                        this.brD.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.brD.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.SL());
                        this.brD.add(tbRichTextData7);
                        if (this.brE == null) {
                            this.brE = new ArrayList<>();
                        }
                        if (next.SD() != null && next.SL().Td() != null) {
                            this.brE.add(next.SL().Td());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.SM());
                            this.brD.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.de(true);
                        }
                        CharSequence A2 = next.A(tbRichTextData.SC());
                        if (A2 != null) {
                            tbRichTextData.append(A2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.brD.add(tbRichTextData);
            }
            this.brC.clear();
            this.brC = null;
        }
    }

    public ArrayList<TbRichTextData> Sx() {
        return this.brD;
    }

    public int getImageCount() {
        return this.mImageCount;
    }

    public String toString() {
        if (this.brD == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.brD.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.brD.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.SK() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.SK());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.brF);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.brG);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.SH() != null) {
                if (StringUtils.isNull(tbRichTextData.SH().Tl())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.brH).append(tbRichTextData.SH().Tl());
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
