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
    private ArrayList<TbRichTextItem> aUC;
    private int aUD;
    private ArrayList<TbRichTextData> aUE;
    private ArrayList<String> aUF;
    private String aUG;
    private String aUH;
    private String aUI;
    private int aUJ;
    private String aUK;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aUK;
    }

    public void setAuthorId(String str) {
        this.aUK = str;
    }

    public void gb(int i) {
        this.aUJ = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aUC = null;
        this.aUD = 0;
        this.aUE = null;
        this.aUF = null;
        this.aUJ = 0;
        this.aUK = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aUC = null;
        this.aUD = 0;
        this.aUE = null;
        this.aUF = null;
        this.aUJ = 0;
        this.aUK = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aUC = null;
        this.aUD = 0;
        this.aUE = null;
        this.aUF = null;
        this.aUJ = 0;
        this.aUK = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aUC = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aUC.add(tbRichTextItem);
                }
            }
            s(context, z);
            be(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aUC = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aUC.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            be(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aUC = null;
        this.aUD = 0;
        this.aUE = null;
        this.aUF = null;
        this.aUJ = 0;
        this.aUK = "";
        this.isChanged = false;
        this.aUE = arrayList;
        be(context);
    }

    private void be(Context context) {
        this.aUG = context.getString(d.j.pic_str);
        this.aUH = context.getString(d.j.voice_str);
        this.aUI = context.getString(d.j.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.aUC != null) {
            this.aUE = new ArrayList<>();
            this.aUD = 0;
            if (this.aUF != null) {
                this.aUF.clear();
            }
            Iterator<TbRichTextItem> it = this.aUC.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aUE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aUD++;
                        tbRichTextData2.a(next.Jw());
                        this.aUE.add(tbRichTextData2);
                        if (this.aUF == null) {
                            this.aUF = new ArrayList<>();
                        }
                        if (next.Jw() != null && next.Jw().JK() != null) {
                            this.aUF.add(next.Jw().JK());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aUE.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.JA());
                        this.aUE.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.Jv());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aUE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Jy());
                        this.aUE.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aUE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.JB());
                        this.aUE.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aUE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.JC());
                        this.aUE.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aUE.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aUD++;
                        tbRichTextData7.a(next.JE());
                        this.aUE.add(tbRichTextData7);
                        if (this.aUF == null) {
                            this.aUF = new ArrayList<>();
                        }
                        if (next.Jw() != null && next.JE().JU() != null) {
                            this.aUF.add(next.JE().JU());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.JF());
                            this.aUE.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cg(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.Jv());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aUE.add(tbRichTextData);
            }
            this.aUC.clear();
            this.aUC = null;
        }
    }

    public ArrayList<TbRichTextData> Jq() {
        return this.aUE;
    }

    public String toString() {
        if (this.aUE == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aUE.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aUE.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.JD() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.JD());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aUG);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aUH);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.JA() != null) {
                if (StringUtils.isNull(tbRichTextData.JA().Kc())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aUI).append(tbRichTextData.JA().Kc());
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
