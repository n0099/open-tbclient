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
    private ArrayList<TbRichTextItem> bqK;
    private ArrayList<TbRichTextData> bqL;
    private ArrayList<String> bqM;
    private String bqN;
    private String bqO;
    private String bqP;
    private int bqQ;
    private String bqR;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bqR;
    }

    public void setAuthorId(String str) {
        this.bqR = str;
    }

    public void gT(int i) {
        this.bqQ = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bqK = null;
        this.mImageCount = 0;
        this.bqL = null;
        this.bqM = null;
        this.bqQ = 0;
        this.bqR = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bqK = null;
        this.mImageCount = 0;
        this.bqL = null;
        this.bqM = null;
        this.bqQ = 0;
        this.bqR = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bqK = null;
        this.mImageCount = 0;
        this.bqL = null;
        this.bqM = null;
        this.bqQ = 0;
        this.bqR = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bqK = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bqK.add(tbRichTextItem);
                }
            }
            k(context, z);
            bS(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bqK = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bqK.add(tbRichTextItem);
                    }
                }
            }
            k(context, z);
            bS(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bqK = null;
        this.mImageCount = 0;
        this.bqL = null;
        this.bqM = null;
        this.bqQ = 0;
        this.bqR = "";
        this.isChanged = false;
        this.bqL = arrayList;
        bS(context);
    }

    private void bS(Context context) {
        this.bqN = context.getString(e.j.pic_str);
        this.bqO = context.getString(e.j.voice_str);
        this.bqP = context.getString(e.j.video_text);
    }

    private void k(Context context, boolean z) {
        if (this.bqK != null) {
            this.bqL = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bqM != null) {
                this.bqM.clear();
            }
            Iterator<TbRichTextItem> it = this.bqK.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bqL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.Sf());
                        this.bqL.add(tbRichTextData2);
                        if (this.bqM == null) {
                            this.bqM = new ArrayList<>();
                        }
                        if (next.Sf() != null && next.Sf().Su() != null) {
                            this.bqM.add(next.Sf().Su());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bqL.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Sj());
                        this.bqL.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence A = next.A(tbRichTextData.Se());
                        if (A != null) {
                            tbRichTextData.append(A);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bqL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Sh());
                        this.bqL.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bqL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Sk());
                        this.bqL.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bqL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Sl());
                        this.bqL.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bqL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.Sn());
                        this.bqL.add(tbRichTextData7);
                        if (this.bqM == null) {
                            this.bqM = new ArrayList<>();
                        }
                        if (next.Sf() != null && next.Sn().SF() != null) {
                            this.bqM.add(next.Sn().SF());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.So());
                            this.bqL.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.db(true);
                        }
                        CharSequence A2 = next.A(tbRichTextData.Se());
                        if (A2 != null) {
                            tbRichTextData.append(A2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bqL.add(tbRichTextData);
            }
            this.bqK.clear();
            this.bqK = null;
        }
    }

    public ArrayList<TbRichTextData> RZ() {
        return this.bqL;
    }

    public int getImageCount() {
        return this.mImageCount;
    }

    public String toString() {
        if (this.bqL == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bqL.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bqL.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Sm() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Sm());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bqN);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bqO);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Sj() != null) {
                if (StringUtils.isNull(tbRichTextData.Sj().SN())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bqP).append(tbRichTextData.Sj().SN());
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
