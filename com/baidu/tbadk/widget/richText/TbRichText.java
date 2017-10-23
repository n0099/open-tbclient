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
    private ArrayList<TbRichTextItem> aQV;
    private int aQW;
    private ArrayList<TbRichTextData> aQX;
    private ArrayList<String> aQY;
    private String aQZ;
    private String aRa;
    private String aRb;
    private int aRc;
    private String aRd;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aRd;
    }

    public void setAuthorId(String str) {
        this.aRd = str;
    }

    public void fL(int i) {
        this.aRc = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aQV = null;
        this.aQW = 0;
        this.aQX = null;
        this.aQY = null;
        this.aRc = 0;
        this.aRd = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aQV = null;
        this.aQW = 0;
        this.aQX = null;
        this.aQY = null;
        this.aRc = 0;
        this.aRd = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aQV = null;
        this.aQW = 0;
        this.aQX = null;
        this.aQY = null;
        this.aRc = 0;
        this.aRd = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aQV = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aQV.add(tbRichTextItem);
                }
            }
            s(context, z);
            aZ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aQV = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aQV.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            aZ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aQV = null;
        this.aQW = 0;
        this.aQX = null;
        this.aQY = null;
        this.aRc = 0;
        this.aRd = "";
        this.isChanged = false;
        this.aQX = arrayList;
        aZ(context);
    }

    private void aZ(Context context) {
        this.aQZ = context.getString(d.l.pic_str);
        this.aRa = context.getString(d.l.voice_str);
        this.aRb = context.getString(d.l.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.aQV != null) {
            this.aQX = new ArrayList<>();
            this.aQW = 0;
            if (this.aQY != null) {
                this.aQY.clear();
            }
            Iterator<TbRichTextItem> it = this.aQV.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aQX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aQW++;
                        tbRichTextData2.a(next.ID());
                        this.aQX.add(tbRichTextData2);
                        if (this.aQY == null) {
                            this.aQY = new ArrayList<>();
                        }
                        if (next.ID() != null && next.ID().IR() != null) {
                            this.aQY.add(next.ID().IR());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aQX.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.IH());
                        this.aQX.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence w = next.w(tbRichTextData.IC());
                        if (w != null) {
                            tbRichTextData.append(w);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aQX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.IF());
                        this.aQX.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aQX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.II());
                        this.aQX.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aQX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.IJ());
                        this.aQX.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aQX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aQW++;
                        tbRichTextData7.a(next.IL());
                        this.aQX.add(tbRichTextData7);
                        if (this.aQY == null) {
                            this.aQY = new ArrayList<>();
                        }
                        if (next.ID() != null && next.IL().Jb() != null) {
                            this.aQY.add(next.IL().Jb());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.IM());
                            this.aQX.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cg(true);
                        }
                        CharSequence w2 = next.w(tbRichTextData.IC());
                        if (w2 != null) {
                            tbRichTextData.append(w2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aQX.add(tbRichTextData);
            }
            this.aQV.clear();
            this.aQV = null;
        }
    }

    public ArrayList<TbRichTextData> Ix() {
        return this.aQX;
    }

    public String toString() {
        if (this.aQX == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aQX.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aQX.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IK() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IK());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aQZ);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aRa);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.IH() != null) {
                if (StringUtils.isNull(tbRichTextData.IH().Jj())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aRb).append(tbRichTextData.IH().Jj());
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
