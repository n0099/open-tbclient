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
    private ArrayList<TbRichTextItem> aUI;
    private ArrayList<TbRichTextData> aUJ;
    private ArrayList<String> aUK;
    private String aUL;
    private String aUM;
    private String aUN;
    private int aUO;
    private String aUP;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.aUP;
    }

    public void setAuthorId(String str) {
        this.aUP = str;
    }

    public void gb(int i) {
        this.aUO = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aUI = null;
        this.mImageCount = 0;
        this.aUJ = null;
        this.aUK = null;
        this.aUO = 0;
        this.aUP = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aUI = null;
        this.mImageCount = 0;
        this.aUJ = null;
        this.aUK = null;
        this.aUO = 0;
        this.aUP = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aUI = null;
        this.mImageCount = 0;
        this.aUJ = null;
        this.aUK = null;
        this.aUO = 0;
        this.aUP = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aUI = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aUI.add(tbRichTextItem);
                }
            }
            s(context, z);
            bb(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aUI = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aUI.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            bb(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aUI = null;
        this.mImageCount = 0;
        this.aUJ = null;
        this.aUK = null;
        this.aUO = 0;
        this.aUP = "";
        this.isChanged = false;
        this.aUJ = arrayList;
        bb(context);
    }

    private void bb(Context context) {
        this.aUL = context.getString(d.j.pic_str);
        this.aUM = context.getString(d.j.voice_str);
        this.aUN = context.getString(d.j.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.aUI != null) {
            this.aUJ = new ArrayList<>();
            this.mImageCount = 0;
            if (this.aUK != null) {
                this.aUK.clear();
            }
            Iterator<TbRichTextItem> it = this.aUI.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aUJ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.Jx());
                        this.aUJ.add(tbRichTextData2);
                        if (this.aUK == null) {
                            this.aUK = new ArrayList<>();
                        }
                        if (next.Jx() != null && next.Jx().JL() != null) {
                            this.aUK.add(next.Jx().JL());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aUJ.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.JB());
                        this.aUJ.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.Jw());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aUJ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.Jz());
                        this.aUJ.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aUJ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.JC());
                        this.aUJ.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aUJ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.JD());
                        this.aUJ.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aUJ.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.JF());
                        this.aUJ.add(tbRichTextData7);
                        if (this.aUK == null) {
                            this.aUK = new ArrayList<>();
                        }
                        if (next.Jx() != null && next.JF().JV() != null) {
                            this.aUK.add(next.JF().JV());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.JG());
                            this.aUJ.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ch(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.Jw());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aUJ.add(tbRichTextData);
            }
            this.aUI.clear();
            this.aUI = null;
        }
    }

    public ArrayList<TbRichTextData> Jr() {
        return this.aUJ;
    }

    public String toString() {
        if (this.aUJ == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aUJ.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aUJ.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.JE() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.JE());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aUL);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aUM);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.JB() != null) {
                if (StringUtils.isNull(tbRichTextData.JB().Kd())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aUN).append(tbRichTextData.JB().Kd());
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
