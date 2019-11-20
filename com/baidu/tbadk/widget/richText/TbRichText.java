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
    private ArrayList<TbRichTextImageInfo> cTH;
    private String cVA;
    private ArrayList<TbRichTextItem> cVu;
    private ArrayList<TbRichTextData> cVv;
    private String cVw;
    private String cVx;
    private String cVy;
    private int cVz;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cVA;
    }

    public void setAuthorId(String str) {
        this.cVA = str;
    }

    public void kM(int i) {
        this.cVz = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cVu = null;
        this.cVv = null;
        this.cVz = 0;
        this.cVA = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cVu = null;
        this.cVv = null;
        this.cVz = 0;
        this.cVA = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cVu = null;
        this.cVv = null;
        this.cVz = 0;
        this.cVA = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cVu = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cVu.add(tbRichTextItem);
                }
            }
            i(context, z);
            cC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cVu = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cVu.add(tbRichTextItem);
                    }
                }
            }
            i(context, z);
            cC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cVu = null;
        this.cVv = null;
        this.cVz = 0;
        this.cVA = "";
        this.isChanged = false;
        this.cVv = arrayList;
        cC(context);
    }

    private void cC(Context context) {
        this.cVw = context.getString(R.string.pic_str);
        this.cVx = context.getString(R.string.voice_str);
        this.cVy = context.getString(R.string.video_text);
    }

    private void i(Context context, boolean z) {
        if (this.cVu != null) {
            this.cVv = new ArrayList<>();
            if (this.cTH != null) {
                this.cTH.clear();
            } else {
                this.cTH = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cVu.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cVv.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.azn());
                        this.cVv.add(tbRichTextData2);
                        this.cTH.add(next.azn());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cVv.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.azr());
                        this.cVv.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence I = next.I(tbRichTextData.azm());
                        if (I != null) {
                            tbRichTextData.i(I);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cVv.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.azp());
                        this.cVv.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cVv.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.azs());
                        this.cVv.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cVv.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.azt());
                        this.cVv.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cVv.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.azv());
                        this.cVv.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.azw());
                            this.cVv.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fN(true);
                        }
                        CharSequence I2 = next.I(tbRichTextData.azm());
                        if (I2 != null) {
                            tbRichTextData.i(I2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cVv.add(tbRichTextData);
            }
            this.cVu.clear();
            this.cVu = null;
        }
    }

    public ArrayList<TbRichTextData> azf() {
        return this.cVv;
    }

    public String toString() {
        if (this.cVv == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cVv.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cVv.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.azu() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.azu());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cVw);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cVx);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.azr() != null) {
                if (StringUtils.isNull(tbRichTextData.azr().azU())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cVy).append(tbRichTextData.azr().azU());
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

    public int azg() {
        if (this.cTH == null) {
            return 0;
        }
        return this.cTH.size();
    }

    public ArrayList<TbRichTextImageInfo> azh() {
        return this.cTH;
    }
}
