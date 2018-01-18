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
    private ArrayList<TbRichTextItem> bID;
    private ArrayList<TbRichTextData> bIE;
    private ArrayList<String> bIF;
    private String bIG;
    private String bIH;
    private String bII;
    private int bIJ;
    private String bIK;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bIK;
    }

    public void setAuthorId(String str) {
        this.bIK = str;
    }

    public void iW(int i) {
        this.bIJ = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bID = null;
        this.mImageCount = 0;
        this.bIE = null;
        this.bIF = null;
        this.bIJ = 0;
        this.bIK = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bID = null;
        this.mImageCount = 0;
        this.bIE = null;
        this.bIF = null;
        this.bIJ = 0;
        this.bIK = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bID = null;
        this.mImageCount = 0;
        this.bIE = null;
        this.bIF = null;
        this.bIJ = 0;
        this.bIK = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bID = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bID.add(tbRichTextItem);
                }
            }
            t(context, z);
            bn(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bID = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bID.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            bn(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bID = null;
        this.mImageCount = 0;
        this.bIE = null;
        this.bIF = null;
        this.bIJ = 0;
        this.bIK = "";
        this.isChanged = false;
        this.bIE = arrayList;
        bn(context);
    }

    private void bn(Context context) {
        this.bIG = context.getString(d.j.pic_str);
        this.bIH = context.getString(d.j.voice_str);
        this.bII = context.getString(d.j.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.bID != null) {
            this.bIE = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bIF != null) {
                this.bIF.clear();
            }
            Iterator<TbRichTextItem> it = this.bID.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bIE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.QH());
                        this.bIE.add(tbRichTextData2);
                        if (this.bIF == null) {
                            this.bIF = new ArrayList<>();
                        }
                        if (next.QH() != null && next.QH().QV() != null) {
                            this.bIF.add(next.QH().QV());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bIE.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.QL());
                        this.bIE.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence y = next.y(tbRichTextData.QG());
                        if (y != null) {
                            tbRichTextData.append(y);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bIE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.QJ());
                        this.bIE.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bIE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.QM());
                        this.bIE.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bIE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.QN());
                        this.bIE.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bIE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.QP());
                        this.bIE.add(tbRichTextData7);
                        if (this.bIF == null) {
                            this.bIF = new ArrayList<>();
                        }
                        if (next.QH() != null && next.QP().Rg() != null) {
                            this.bIF.add(next.QP().Rg());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.QQ());
                            this.bIE.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cI(true);
                        }
                        CharSequence y2 = next.y(tbRichTextData.QG());
                        if (y2 != null) {
                            tbRichTextData.append(y2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bIE.add(tbRichTextData);
            }
            this.bID.clear();
            this.bID = null;
        }
    }

    public ArrayList<TbRichTextData> QB() {
        return this.bIE;
    }

    public String toString() {
        if (this.bIE == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bIE.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bIE.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.QO() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.QO());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bIG);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bIH);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.QL() != null) {
                if (StringUtils.isNull(tbRichTextData.QL().Ro())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bII).append(tbRichTextData.QL().Ro());
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
