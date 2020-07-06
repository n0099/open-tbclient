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
    private ArrayList<TbRichTextImageInfo> eLo;
    private ArrayList<TbRichTextItem> eNH;
    private ArrayList<TbRichTextData> eNI;
    private String eNJ;
    private String eNK;
    private String eNL;
    private int eNM;
    private String eNN;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.eNN;
    }

    public void setAuthorId(String str) {
        this.eNN = str;
    }

    public void oJ(int i) {
        this.eNM = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.eNH = null;
        this.eNI = null;
        this.eNM = 0;
        this.eNN = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.eNH = null;
        this.eNI = null;
        this.eNM = 0;
        this.eNN = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.eNH = null;
        this.eNI = null;
        this.eNM = 0;
        this.eNN = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.eNH = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.eNH.add(tbRichTextItem);
                }
            }
            n(context, z);
            ec(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.eNH = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.eNH.add(tbRichTextItem);
                    }
                }
            }
            n(context, z);
            ec(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.eNH = null;
        this.eNI = null;
        this.eNM = 0;
        this.eNN = "";
        this.isChanged = false;
        this.eNI = arrayList;
        ec(context);
    }

    private void ec(Context context) {
        this.eNJ = context.getString(R.string.pic_str);
        this.eNK = context.getString(R.string.voice_str);
        this.eNL = context.getString(R.string.video_text);
    }

    private void n(Context context, boolean z) {
        if (this.eNH != null) {
            this.eNI = new ArrayList<>();
            if (this.eLo != null) {
                this.eLo.clear();
            } else {
                this.eLo = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.eNH.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.eNI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bkV());
                        this.eNI.add(tbRichTextData2);
                        this.eLo.add(next.bkV());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.eNI.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bkZ());
                        this.eNI.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence N = next.N(tbRichTextData.bkU());
                        if (N != null) {
                            tbRichTextData.n(N);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.eNI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bkX());
                        this.eNI.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.eNI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bla());
                        this.eNI.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.eNI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.blb());
                        this.eNI.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.eNI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.bld());
                        this.eNI.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bls());
                            this.eNI.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.iU(true);
                        }
                        CharSequence N2 = next.N(tbRichTextData.bkU());
                        if (N2 != null) {
                            tbRichTextData.n(N2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.eNI.add(tbRichTextData);
            }
            this.eNH.clear();
            this.eNH = null;
        }
    }

    public ArrayList<TbRichTextData> bkP() {
        return this.eNI;
    }

    public String toString() {
        if (this.eNI == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.eNI.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.eNI.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.blc() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.blc());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.eNJ);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.eNK);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bkZ() != null) {
                if (StringUtils.isNull(tbRichTextData.bkZ().blG())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.eNL).append(tbRichTextData.bkZ().blG());
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

    public int akg() {
        if (this.eLo == null) {
            return 0;
        }
        return this.eLo.size();
    }

    public ArrayList<TbRichTextImageInfo> bkQ() {
        return this.eLo;
    }
}
