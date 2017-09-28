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
    private ArrayList<TbRichTextItem> aRi;
    private int aRj;
    private ArrayList<TbRichTextData> aRk;
    private ArrayList<String> aRl;
    private String aRm;
    private String aRn;
    private String aRo;
    private int aRp;
    private String aRq;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aRq;
    }

    public void setAuthorId(String str) {
        this.aRq = str;
    }

    public void fM(int i) {
        this.aRp = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aRi = null;
        this.aRj = 0;
        this.aRk = null;
        this.aRl = null;
        this.aRp = 0;
        this.aRq = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aRi = null;
        this.aRj = 0;
        this.aRk = null;
        this.aRl = null;
        this.aRp = 0;
        this.aRq = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aRi = null;
        this.aRj = 0;
        this.aRk = null;
        this.aRl = null;
        this.aRp = 0;
        this.aRq = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aRi = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aRi.add(tbRichTextItem);
                }
            }
            s(context, z);
            ba(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aRi = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aRi.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            ba(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aRi = null;
        this.aRj = 0;
        this.aRk = null;
        this.aRl = null;
        this.aRp = 0;
        this.aRq = "";
        this.isChanged = false;
        this.aRk = arrayList;
        ba(context);
    }

    private void ba(Context context) {
        this.aRm = context.getString(d.l.pic_str);
        this.aRn = context.getString(d.l.voice_str);
        this.aRo = context.getString(d.l.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.aRi != null) {
            this.aRk = new ArrayList<>();
            this.aRj = 0;
            if (this.aRl != null) {
                this.aRl.clear();
            }
            Iterator<TbRichTextItem> it = this.aRi.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aRk.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aRj++;
                        tbRichTextData2.a(next.IJ());
                        this.aRk.add(tbRichTextData2);
                        if (this.aRl == null) {
                            this.aRl = new ArrayList<>();
                        }
                        if (next.IJ() != null && next.IJ().IX() != null) {
                            this.aRl.add(next.IJ().IX());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aRk.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.IN());
                        this.aRk.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence w = next.w(tbRichTextData.II());
                        if (w != null) {
                            tbRichTextData.append(w);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aRk.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.IL());
                        this.aRk.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aRk.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.IO());
                        this.aRk.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aRk.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.IP());
                        this.aRk.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aRk.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aRj++;
                        tbRichTextData7.a(next.IR());
                        this.aRk.add(tbRichTextData7);
                        if (this.aRl == null) {
                            this.aRl = new ArrayList<>();
                        }
                        if (next.IJ() != null && next.IR().Jh() != null) {
                            this.aRl.add(next.IR().Jh());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.IS());
                            this.aRk.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ch(true);
                        }
                        CharSequence w2 = next.w(tbRichTextData.II());
                        if (w2 != null) {
                            tbRichTextData.append(w2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aRk.add(tbRichTextData);
            }
            this.aRi.clear();
            this.aRi = null;
        }
    }

    public ArrayList<TbRichTextData> ID() {
        return this.aRk;
    }

    public String toString() {
        if (this.aRk == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aRk.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aRk.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IQ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IQ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aRm);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aRn);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.IN() != null) {
                if (StringUtils.isNull(tbRichTextData.IN().Jp())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aRo).append(tbRichTextData.IN().Jp());
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
