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
    private String bIA;
    private int bIB;
    private String bIC;
    private ArrayList<TbRichTextItem> bIv;
    private ArrayList<TbRichTextData> bIw;
    private ArrayList<String> bIx;
    private String bIy;
    private String bIz;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bIC;
    }

    public void setAuthorId(String str) {
        this.bIC = str;
    }

    public void ja(int i) {
        this.bIB = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bIv = null;
        this.mImageCount = 0;
        this.bIw = null;
        this.bIx = null;
        this.bIB = 0;
        this.bIC = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bIv = null;
        this.mImageCount = 0;
        this.bIw = null;
        this.bIx = null;
        this.bIB = 0;
        this.bIC = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bIv = null;
        this.mImageCount = 0;
        this.bIw = null;
        this.bIx = null;
        this.bIB = 0;
        this.bIC = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bIv = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bIv.add(tbRichTextItem);
                }
            }
            t(context, z);
            bn(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bIv = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bIv.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            bn(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bIv = null;
        this.mImageCount = 0;
        this.bIw = null;
        this.bIx = null;
        this.bIB = 0;
        this.bIC = "";
        this.isChanged = false;
        this.bIw = arrayList;
        bn(context);
    }

    private void bn(Context context) {
        this.bIy = context.getString(d.j.pic_str);
        this.bIz = context.getString(d.j.voice_str);
        this.bIA = context.getString(d.j.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.bIv != null) {
            this.bIw = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bIx != null) {
                this.bIx.clear();
            }
            Iterator<TbRichTextItem> it = this.bIv.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bIw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.QT());
                        this.bIw.add(tbRichTextData2);
                        if (this.bIx == null) {
                            this.bIx = new ArrayList<>();
                        }
                        if (next.QT() != null && next.QT().Rh() != null) {
                            this.bIx.add(next.QT().Rh());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bIw.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.QX());
                        this.bIw.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence y = next.y(tbRichTextData.QS());
                        if (y != null) {
                            tbRichTextData.append(y);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bIw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.QV());
                        this.bIw.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bIw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.QY());
                        this.bIw.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bIw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.QZ());
                        this.bIw.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bIw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.Rb());
                        this.bIw.add(tbRichTextData7);
                        if (this.bIx == null) {
                            this.bIx = new ArrayList<>();
                        }
                        if (next.QT() != null && next.Rb().Rs() != null) {
                            this.bIx.add(next.Rb().Rs());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.Rc());
                            this.bIw.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cK(true);
                        }
                        CharSequence y2 = next.y(tbRichTextData.QS());
                        if (y2 != null) {
                            tbRichTextData.append(y2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bIw.add(tbRichTextData);
            }
            this.bIv.clear();
            this.bIv = null;
        }
    }

    public ArrayList<TbRichTextData> QN() {
        return this.bIw;
    }

    public String toString() {
        if (this.bIw == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bIw.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bIw.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.Ra() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.Ra());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bIy);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bIz);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.QX() != null) {
                if (StringUtils.isNull(tbRichTextData.QX().RA())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bIA).append(tbRichTextData.QX().RA());
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
