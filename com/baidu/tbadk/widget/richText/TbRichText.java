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
    private ArrayList<TbRichTextItem> aPk;
    private int aPl;
    private ArrayList<TbRichTextData> aPm;
    private ArrayList<String> aPn;
    private String aPo;
    private String aPp;
    private String aPq;
    private String aPr;
    private int aPs;
    private String aPt;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aPt;
    }

    public void setAuthorId(String str) {
        this.aPt = str;
    }

    public void fv(int i) {
        this.aPs = i;
    }

    public int If() {
        return this.aPs;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aPk = null;
        this.aPl = 0;
        this.aPm = null;
        this.aPn = null;
        this.aPs = 0;
        this.aPt = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aPk = null;
        this.aPl = 0;
        this.aPm = null;
        this.aPn = null;
        this.aPs = 0;
        this.aPt = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aPk = null;
        this.aPl = 0;
        this.aPm = null;
        this.aPn = null;
        this.aPs = 0;
        this.aPt = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aPk = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aPk.add(tbRichTextItem);
                }
            }
            c(context, z);
            aT(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aPk = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aPk.add(tbRichTextItem);
                    }
                }
            }
            c(context, z);
            aT(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aPk = null;
        this.aPl = 0;
        this.aPm = null;
        this.aPn = null;
        this.aPs = 0;
        this.aPt = "";
        this.isChanged = false;
        this.aPm = arrayList;
        aT(context);
    }

    private void aT(Context context) {
        this.aPo = context.getString(d.l.pic_str);
        this.aPp = context.getString(d.l.voice_str);
        this.aPq = context.getString(d.l.video_text);
        this.aPr = context.getString(d.l.graffiti_str);
    }

    private void c(Context context, boolean z) {
        if (this.aPk != null) {
            this.aPm = new ArrayList<>();
            this.aPl = 0;
            if (this.aPn != null) {
                this.aPn.clear();
            }
            Iterator<TbRichTextItem> it = this.aPk.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aPl++;
                        tbRichTextData2.a(next.Im());
                        this.aPm.add(tbRichTextData2);
                        if (this.aPn == null) {
                            this.aPn = new ArrayList<>();
                        }
                        if (next.Im() != null && next.Im().IB() != null) {
                            this.aPn.add(next.Im().IB());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.Iq());
                        this.aPm.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.Il());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Io());
                        this.aPm.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.Ir());
                        this.aPm.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.Is());
                        this.aPm.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aPl++;
                        tbRichTextData7.a(next.Iu());
                        this.aPm.add(tbRichTextData7);
                        if (this.aPn == null) {
                            this.aPn = new ArrayList<>();
                        }
                        if (next.Im() != null && next.Iu().IJ() != null) {
                            this.aPn.add(next.Iu().IJ());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aPm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1536);
                        tbRichTextData8.a(next.Iw());
                        this.aPm.add(tbRichTextData8);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData9 = new TbRichTextData(1024);
                            tbRichTextData9.a(next.Iv());
                            this.aPm.add(tbRichTextData9);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ch(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.Il());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aPm.add(tbRichTextData);
            }
            this.aPk.clear();
            this.aPk = null;
        }
    }

    public ArrayList<TbRichTextData> Ig() {
        return this.aPm;
    }

    public String toString() {
        if (this.aPm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aPm.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aPm.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.It() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.It());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aPo);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aPp);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.Iq() != null) {
                if (StringUtils.isNull(tbRichTextData.Iq().IR())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aPq).append(tbRichTextData.Iq().IR());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aPr);
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
