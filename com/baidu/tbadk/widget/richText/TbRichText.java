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
    private String aVA;
    private int aVB;
    private String aVC;
    private ArrayList<TbRichTextItem> aVv;
    private ArrayList<TbRichTextData> aVw;
    private ArrayList<String> aVx;
    private String aVy;
    private String aVz;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.aVC;
    }

    public void setAuthorId(String str) {
        this.aVC = str;
    }

    public void fU(int i) {
        this.aVB = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aVv = null;
        this.mImageCount = 0;
        this.aVw = null;
        this.aVx = null;
        this.aVB = 0;
        this.aVC = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aVv = null;
        this.mImageCount = 0;
        this.aVw = null;
        this.aVx = null;
        this.aVB = 0;
        this.aVC = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aVv = null;
        this.mImageCount = 0;
        this.aVw = null;
        this.aVx = null;
        this.aVB = 0;
        this.aVC = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aVv = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aVv.add(tbRichTextItem);
                }
            }
            t(context, z);
            aU(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aVv = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aVv.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            aU(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aVv = null;
        this.mImageCount = 0;
        this.aVw = null;
        this.aVx = null;
        this.aVB = 0;
        this.aVC = "";
        this.isChanged = false;
        this.aVw = arrayList;
        aU(context);
    }

    private void aU(Context context) {
        this.aVy = context.getString(d.k.pic_str);
        this.aVz = context.getString(d.k.voice_str);
        this.aVA = context.getString(d.k.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.aVv != null) {
            this.aVw = new ArrayList<>();
            this.mImageCount = 0;
            if (this.aVx != null) {
                this.aVx.clear();
            }
            Iterator<TbRichTextItem> it = this.aVv.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aVw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.JP());
                        this.aVw.add(tbRichTextData2);
                        if (this.aVx == null) {
                            this.aVx = new ArrayList<>();
                        }
                        if (next.JP() != null && next.JP().Kc() != null) {
                            this.aVx.add(next.JP().Kc());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aVw.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.JT());
                        this.aVw.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.JO());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aVw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.JR());
                        this.aVw.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aVw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.JU());
                        this.aVw.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aVw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.JV());
                        this.aVw.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aVw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.JX());
                        this.aVw.add(tbRichTextData7);
                        if (this.aVx == null) {
                            this.aVx = new ArrayList<>();
                        }
                        if (next.JP() != null && next.JX().Kn() != null) {
                            this.aVx.add(next.JX().Kn());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.JY());
                            this.aVw.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cf(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.JO());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aVw.add(tbRichTextData);
            }
            this.aVv.clear();
            this.aVv = null;
        }
    }

    public ArrayList<TbRichTextData> JJ() {
        return this.aVw;
    }

    public String toString() {
        if (this.aVw == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aVw.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aVw.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.JW() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.JW());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aVy);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aVz);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.JT() != null) {
                if (StringUtils.isNull(tbRichTextData.JT().Kv())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aVA).append(tbRichTextData.JT().Kv());
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
