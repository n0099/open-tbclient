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
    private ArrayList<TbRichTextItem> bmB;
    private ArrayList<TbRichTextData> bmC;
    private ArrayList<String> bmD;
    private String bmE;
    private String bmF;
    private String bmG;
    private int bmH;
    private String bmI;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bmI;
    }

    public void setAuthorId(String str) {
        this.bmI = str;
    }

    public void gr(int i) {
        this.bmH = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bmB = null;
        this.mImageCount = 0;
        this.bmC = null;
        this.bmD = null;
        this.bmH = 0;
        this.bmI = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bmB = null;
        this.mImageCount = 0;
        this.bmC = null;
        this.bmD = null;
        this.bmH = 0;
        this.bmI = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bmB = null;
        this.mImageCount = 0;
        this.bmC = null;
        this.bmD = null;
        this.bmH = 0;
        this.bmI = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bmB = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bmB.add(tbRichTextItem);
                }
            }
            k(context, z);
            bS(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bmB = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bmB.add(tbRichTextItem);
                    }
                }
            }
            k(context, z);
            bS(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bmB = null;
        this.mImageCount = 0;
        this.bmC = null;
        this.bmD = null;
        this.bmH = 0;
        this.bmI = "";
        this.isChanged = false;
        this.bmC = arrayList;
        bS(context);
    }

    private void bS(Context context) {
        this.bmE = context.getString(e.j.pic_str);
        this.bmF = context.getString(e.j.voice_str);
        this.bmG = context.getString(e.j.video_text);
    }

    private void k(Context context, boolean z) {
        if (this.bmB != null) {
            this.bmC = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bmD != null) {
                this.bmD.clear();
            }
            Iterator<TbRichTextItem> it = this.bmB.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bmC.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.QQ());
                        this.bmC.add(tbRichTextData2);
                        if (this.bmD == null) {
                            this.bmD = new ArrayList<>();
                        }
                        if (next.QQ() != null && next.QQ().Rf() != null) {
                            this.bmD.add(next.QQ().Rf());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bmC.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.QU());
                        this.bmC.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence A = next.A(tbRichTextData.QP());
                        if (A != null) {
                            tbRichTextData.append(A);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bmC.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.QS());
                        this.bmC.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bmC.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.QV());
                        this.bmC.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bmC.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.QW());
                        this.bmC.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bmC.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.QY());
                        this.bmC.add(tbRichTextData7);
                        if (this.bmD == null) {
                            this.bmD = new ArrayList<>();
                        }
                        if (next.QQ() != null && next.QY().Rq() != null) {
                            this.bmD.add(next.QY().Rq());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.QZ());
                            this.bmC.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cJ(true);
                        }
                        CharSequence A2 = next.A(tbRichTextData.QP());
                        if (A2 != null) {
                            tbRichTextData.append(A2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bmC.add(tbRichTextData);
            }
            this.bmB.clear();
            this.bmB = null;
        }
    }

    public ArrayList<TbRichTextData> QK() {
        return this.bmC;
    }

    public int getImageCount() {
        return this.mImageCount;
    }

    public String toString() {
        if (this.bmC == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bmC.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bmC.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.QX() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.QX());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bmE);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bmF);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.QU() != null) {
                if (StringUtils.isNull(tbRichTextData.QU().Ry())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bmG).append(tbRichTextData.QU().Ry());
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
