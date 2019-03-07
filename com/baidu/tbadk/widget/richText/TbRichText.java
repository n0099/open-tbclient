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
    private ArrayList<TbRichTextImageInfo> cAy;
    private ArrayList<TbRichTextItem> cCt;
    private ArrayList<TbRichTextData> cCu;
    private String cCv;
    private String cCw;
    private String cCx;
    private int cCy;
    private String cCz;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cCz;
    }

    public void setAuthorId(String str) {
        this.cCz = str;
    }

    public void kJ(int i) {
        this.cCy = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cCt = null;
        this.cCu = null;
        this.cCy = 0;
        this.cCz = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cCt = null;
        this.cCu = null;
        this.cCy = 0;
        this.cCz = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cCt = null;
        this.cCu = null;
        this.cCy = 0;
        this.cCz = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cCt = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cCt.add(tbRichTextItem);
                }
            }
            k(context, z);
            dk(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cCt = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cCt.add(tbRichTextItem);
                    }
                }
            }
            k(context, z);
            dk(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cCt = null;
        this.cCu = null;
        this.cCy = 0;
        this.cCz = "";
        this.isChanged = false;
        this.cCu = arrayList;
        dk(context);
    }

    private void dk(Context context) {
        this.cCv = context.getString(d.j.pic_str);
        this.cCw = context.getString(d.j.voice_str);
        this.cCx = context.getString(d.j.video_text);
    }

    private void k(Context context, boolean z) {
        if (this.cCt != null) {
            this.cCu = new ArrayList<>();
            if (this.cAy != null) {
                this.cAy.clear();
            } else {
                this.cAy = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cCt.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cCu.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.asD());
                        this.cCu.add(tbRichTextData2);
                        this.cAy.add(next.asD());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cCu.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.asH());
                        this.cCu.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence D = next.D(tbRichTextData.asC());
                        if (D != null) {
                            tbRichTextData.append(D);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cCu.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.asF());
                        this.cCu.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cCu.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.asI());
                        this.cCu.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cCu.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.asJ());
                        this.cCu.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cCu.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.asL());
                        this.cCu.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.asM());
                            this.cCu.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fu(true);
                        }
                        CharSequence D2 = next.D(tbRichTextData.asC());
                        if (D2 != null) {
                            tbRichTextData.append(D2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cCu.add(tbRichTextData);
            }
            this.cCt.clear();
            this.cCt = null;
        }
    }

    public ArrayList<TbRichTextData> asw() {
        return this.cCu;
    }

    public String toString() {
        if (this.cCu == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cCu.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cCu.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.asK() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.asK());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cCv);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cCw);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.asH() != null) {
                if (StringUtils.isNull(tbRichTextData.asH().atk())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cCx).append(tbRichTextData.asH().atk());
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
        if (this.cAy == null) {
            return 0;
        }
        return this.cAy.size();
    }

    public ArrayList<TbRichTextImageInfo> asx() {
        return this.cAy;
    }
}
