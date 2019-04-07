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
    private ArrayList<TbRichTextImageInfo> cAx;
    private ArrayList<TbRichTextItem> cCs;
    private ArrayList<TbRichTextData> cCt;
    private String cCu;
    private String cCv;
    private String cCw;
    private int cCx;
    private String cCy;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cCy;
    }

    public void setAuthorId(String str) {
        this.cCy = str;
    }

    public void kI(int i) {
        this.cCx = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cCs = null;
        this.cCt = null;
        this.cCx = 0;
        this.cCy = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cCs = null;
        this.cCt = null;
        this.cCx = 0;
        this.cCy = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cCs = null;
        this.cCt = null;
        this.cCx = 0;
        this.cCy = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cCs = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cCs.add(tbRichTextItem);
                }
            }
            k(context, z);
            dj(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cCs = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cCs.add(tbRichTextItem);
                    }
                }
            }
            k(context, z);
            dj(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cCs = null;
        this.cCt = null;
        this.cCx = 0;
        this.cCy = "";
        this.isChanged = false;
        this.cCt = arrayList;
        dj(context);
    }

    private void dj(Context context) {
        this.cCu = context.getString(d.j.pic_str);
        this.cCv = context.getString(d.j.voice_str);
        this.cCw = context.getString(d.j.video_text);
    }

    private void k(Context context, boolean z) {
        if (this.cCs != null) {
            this.cCt = new ArrayList<>();
            if (this.cAx != null) {
                this.cAx.clear();
            } else {
                this.cAx = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cCs.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cCt.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.asA());
                        this.cCt.add(tbRichTextData2);
                        this.cAx.add(next.asA());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cCt.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.asE());
                        this.cCt.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence D = next.D(tbRichTextData.asz());
                        if (D != null) {
                            tbRichTextData.append(D);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cCt.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.asC());
                        this.cCt.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cCt.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.asF());
                        this.cCt.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cCt.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.asG());
                        this.cCt.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cCt.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.asI());
                        this.cCt.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.asJ());
                            this.cCt.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fu(true);
                        }
                        CharSequence D2 = next.D(tbRichTextData.asz());
                        if (D2 != null) {
                            tbRichTextData.append(D2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cCt.add(tbRichTextData);
            }
            this.cCs.clear();
            this.cCs = null;
        }
    }

    public ArrayList<TbRichTextData> ast() {
        return this.cCt;
    }

    public String toString() {
        if (this.cCt == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cCt.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cCt.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.asH() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.asH());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cCu);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cCv);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.asE() != null) {
                if (StringUtils.isNull(tbRichTextData.asE().ath())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cCw).append(tbRichTextData.asE().ath());
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

    public int getImageCount() {
        if (this.cAx == null) {
            return 0;
        }
        return this.cAx.size();
    }

    public ArrayList<TbRichTextImageInfo> asu() {
        return this.cAx;
    }
}
