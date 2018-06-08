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
    private ArrayList<TbRichTextItem> bdA;
    private ArrayList<TbRichTextData> bdB;
    private ArrayList<String> bdC;
    private String bdD;
    private String bdE;
    private String bdF;
    private int bdG;
    private String bdH;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bdH;
    }

    public void setAuthorId(String str) {
        this.bdH = str;
    }

    public void fV(int i) {
        this.bdG = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bdA = null;
        this.mImageCount = 0;
        this.bdB = null;
        this.bdC = null;
        this.bdG = 0;
        this.bdH = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bdA = null;
        this.mImageCount = 0;
        this.bdB = null;
        this.bdC = null;
        this.bdG = 0;
        this.bdH = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bdA = null;
        this.mImageCount = 0;
        this.bdB = null;
        this.bdC = null;
        this.bdG = 0;
        this.bdH = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bdA = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bdA.add(tbRichTextItem);
                }
            }
            t(context, z);
            be(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bdA = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bdA.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            be(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bdA = null;
        this.mImageCount = 0;
        this.bdB = null;
        this.bdC = null;
        this.bdG = 0;
        this.bdH = "";
        this.isChanged = false;
        this.bdB = arrayList;
        be(context);
    }

    private void be(Context context) {
        this.bdD = context.getString(d.k.pic_str);
        this.bdE = context.getString(d.k.voice_str);
        this.bdF = context.getString(d.k.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.bdA != null) {
            this.bdB = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bdC != null) {
                this.bdC.clear();
            }
            Iterator<TbRichTextItem> it = this.bdA.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bdB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.Nm());
                        this.bdB.add(tbRichTextData2);
                        if (this.bdC == null) {
                            this.bdC = new ArrayList<>();
                        }
                        if (next.Nm() != null && next.Nm().Nz() != null) {
                            this.bdC.add(next.Nm().Nz());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bdB.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Nq());
                        this.bdB.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence w = next.w(tbRichTextData.Nl());
                        if (w != null) {
                            tbRichTextData.append(w);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bdB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.No());
                        this.bdB.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bdB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Nr());
                        this.bdB.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bdB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Ns());
                        this.bdB.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bdB.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.Nu());
                        this.bdB.add(tbRichTextData7);
                        if (this.bdC == null) {
                            this.bdC = new ArrayList<>();
                        }
                        if (next.Nm() != null && next.Nu().NK() != null) {
                            this.bdC.add(next.Nu().NK());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.Nv());
                            this.bdB.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ck(true);
                        }
                        CharSequence w2 = next.w(tbRichTextData.Nl());
                        if (w2 != null) {
                            tbRichTextData.append(w2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bdB.add(tbRichTextData);
            }
            this.bdA.clear();
            this.bdA = null;
        }
    }

    public ArrayList<TbRichTextData> Ng() {
        return this.bdB;
    }

    public String toString() {
        if (this.bdB == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bdB.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bdB.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Nt() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Nt());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bdD);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bdE);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Nq() != null) {
                if (StringUtils.isNull(tbRichTextData.Nq().NS())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bdF).append(tbRichTextData.Nq().NS());
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
