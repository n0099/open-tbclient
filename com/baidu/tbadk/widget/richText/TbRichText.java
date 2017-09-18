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
    private ArrayList<TbRichTextItem> aQf;
    private int aQg;
    private ArrayList<TbRichTextData> aQh;
    private ArrayList<String> aQi;
    private String aQj;
    private String aQk;
    private String aQl;
    private String aQm;
    private int aQn;
    private String aQo;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aQo;
    }

    public void setAuthorId(String str) {
        this.aQo = str;
    }

    public void fy(int i) {
        this.aQn = i;
    }

    public int Iu() {
        return this.aQn;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aQf = null;
        this.aQg = 0;
        this.aQh = null;
        this.aQi = null;
        this.aQn = 0;
        this.aQo = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aQf = null;
        this.aQg = 0;
        this.aQh = null;
        this.aQi = null;
        this.aQn = 0;
        this.aQo = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aQf = null;
        this.aQg = 0;
        this.aQh = null;
        this.aQi = null;
        this.aQn = 0;
        this.aQo = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aQf = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aQf.add(tbRichTextItem);
                }
            }
            s(context, z);
            ba(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aQf = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.b(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aQf.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            ba(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aQf = null;
        this.aQg = 0;
        this.aQh = null;
        this.aQi = null;
        this.aQn = 0;
        this.aQo = "";
        this.isChanged = false;
        this.aQh = arrayList;
        ba(context);
    }

    private void ba(Context context) {
        this.aQj = context.getString(d.l.pic_str);
        this.aQk = context.getString(d.l.voice_str);
        this.aQl = context.getString(d.l.video_text);
        this.aQm = context.getString(d.l.graffiti_str);
    }

    private void s(Context context, boolean z) {
        if (this.aQf != null) {
            this.aQh = new ArrayList<>();
            this.aQg = 0;
            if (this.aQi != null) {
                this.aQi.clear();
            }
            Iterator<TbRichTextItem> it = this.aQf.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aQg++;
                        tbRichTextData2.a(next.IB());
                        this.aQh.add(tbRichTextData2);
                        if (this.aQi == null) {
                            this.aQi = new ArrayList<>();
                        }
                        if (next.IB() != null && next.IB().IQ() != null) {
                            this.aQi.add(next.IB().IQ());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.IF());
                        this.aQh.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.IA());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.ID());
                        this.aQh.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.IG());
                        this.aQh.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.IH());
                        this.aQh.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aQg++;
                        tbRichTextData7.a(next.IJ());
                        this.aQh.add(tbRichTextData7);
                        if (this.aQi == null) {
                            this.aQi = new ArrayList<>();
                        }
                        if (next.IB() != null && next.IJ().IY() != null) {
                            this.aQi.add(next.IJ().IY());
                        }
                    } else if (next.getType() == 1536) {
                        if (tbRichTextData != null) {
                            this.aQh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData8 = new TbRichTextData(1536);
                        tbRichTextData8.a(next.IL());
                        this.aQh.add(tbRichTextData8);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData9 = new TbRichTextData(1024);
                            tbRichTextData9.a(next.IK());
                            this.aQh.add(tbRichTextData9);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ci(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.IA());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aQh.add(tbRichTextData);
            }
            this.aQf.clear();
            this.aQf = null;
        }
    }

    public ArrayList<TbRichTextData> Iv() {
        return this.aQh;
    }

    public String toString() {
        if (this.aQh == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aQh.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aQh.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.II() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.II());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aQj);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aQk);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.IF() != null) {
                if (StringUtils.isNull(tbRichTextData.IF().Jg())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aQl).append(tbRichTextData.IF().Jg());
                }
            } else if (tbRichTextData.getType() == 1536) {
                sb.append(this.aQm);
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
