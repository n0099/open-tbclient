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
    private ArrayList<TbRichTextImageInfo> eBu;
    private ArrayList<TbRichTextItem> eDm;
    private ArrayList<TbRichTextData> eDn;
    private String eDo;
    private String eDp;
    private String eDq;
    private int eDr;
    private String eDs;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.eDs;
    }

    public void setAuthorId(String str) {
        this.eDs = str;
    }

    public void oj(int i) {
        this.eDr = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.eDm = null;
        this.eDn = null;
        this.eDr = 0;
        this.eDs = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.eDm = null;
        this.eDn = null;
        this.eDr = 0;
        this.eDs = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.eDm = null;
        this.eDn = null;
        this.eDr = 0;
        this.eDs = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.eDm = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.eDm.add(tbRichTextItem);
                }
            }
            n(context, z);
            eb(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.eDm = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.eDm.add(tbRichTextItem);
                    }
                }
            }
            n(context, z);
            eb(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.eDm = null;
        this.eDn = null;
        this.eDr = 0;
        this.eDs = "";
        this.isChanged = false;
        this.eDn = arrayList;
        eb(context);
    }

    private void eb(Context context) {
        this.eDo = context.getString(R.string.pic_str);
        this.eDp = context.getString(R.string.voice_str);
        this.eDq = context.getString(R.string.video_text);
    }

    private void n(Context context, boolean z) {
        if (this.eDm != null) {
            this.eDn = new ArrayList<>();
            if (this.eBu != null) {
                this.eBu.clear();
            } else {
                this.eBu = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.eDm.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.eDn.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.biw());
                        this.eDn.add(tbRichTextData2);
                        this.eBu.add(next.biw());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.eDn.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.biA());
                        this.eDn.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence N = next.N(tbRichTextData.biv());
                        if (N != null) {
                            tbRichTextData.j(N);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.eDn.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.biy());
                        this.eDn.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.eDn.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.biB());
                        this.eDn.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.eDn.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.biC());
                        this.eDn.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.eDn.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.biE());
                        this.eDn.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.biQ());
                            this.eDn.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.iI(true);
                        }
                        CharSequence N2 = next.N(tbRichTextData.biv());
                        if (N2 != null) {
                            tbRichTextData.j(N2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.eDn.add(tbRichTextData);
            }
            this.eDm.clear();
            this.eDm = null;
        }
    }

    public ArrayList<TbRichTextData> biq() {
        return this.eDn;
    }

    public String toString() {
        if (this.eDn == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.eDn.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.eDn.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.biD() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.biD());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.eDo);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.eDp);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.biA() != null) {
                if (StringUtils.isNull(tbRichTextData.biA().bje())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.eDq).append(tbRichTextData.biA().bje());
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

    public int aja() {
        if (this.eBu == null) {
            return 0;
        }
        return this.eBu.size();
    }

    public ArrayList<TbRichTextImageInfo> bir() {
        return this.eBu;
    }
}
