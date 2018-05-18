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
    private String aVB;
    private int aVC;
    private String aVD;
    private ArrayList<TbRichTextItem> aVw;
    private ArrayList<TbRichTextData> aVx;
    private ArrayList<String> aVy;
    private String aVz;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.aVD;
    }

    public void setAuthorId(String str) {
        this.aVD = str;
    }

    public void fU(int i) {
        this.aVC = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aVw = null;
        this.mImageCount = 0;
        this.aVx = null;
        this.aVy = null;
        this.aVC = 0;
        this.aVD = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aVw = null;
        this.mImageCount = 0;
        this.aVx = null;
        this.aVy = null;
        this.aVC = 0;
        this.aVD = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aVw = null;
        this.mImageCount = 0;
        this.aVx = null;
        this.aVy = null;
        this.aVC = 0;
        this.aVD = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aVw = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aVw.add(tbRichTextItem);
                }
            }
            t(context, z);
            aU(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aVw = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aVw.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            aU(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aVw = null;
        this.mImageCount = 0;
        this.aVx = null;
        this.aVy = null;
        this.aVC = 0;
        this.aVD = "";
        this.isChanged = false;
        this.aVx = arrayList;
        aU(context);
    }

    private void aU(Context context) {
        this.aVz = context.getString(d.k.pic_str);
        this.aVA = context.getString(d.k.voice_str);
        this.aVB = context.getString(d.k.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.aVw != null) {
            this.aVx = new ArrayList<>();
            this.mImageCount = 0;
            if (this.aVy != null) {
                this.aVy.clear();
            }
            Iterator<TbRichTextItem> it = this.aVw.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aVx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.JN());
                        this.aVx.add(tbRichTextData2);
                        if (this.aVy == null) {
                            this.aVy = new ArrayList<>();
                        }
                        if (next.JN() != null && next.JN().Ka() != null) {
                            this.aVy.add(next.JN().Ka());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aVx.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.JR());
                        this.aVx.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.JM());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aVx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.JP());
                        this.aVx.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aVx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.JS());
                        this.aVx.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aVx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.JT());
                        this.aVx.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aVx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.JV());
                        this.aVx.add(tbRichTextData7);
                        if (this.aVy == null) {
                            this.aVy = new ArrayList<>();
                        }
                        if (next.JN() != null && next.JV().Kl() != null) {
                            this.aVy.add(next.JV().Kl());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.JW());
                            this.aVx.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cf(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.JM());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aVx.add(tbRichTextData);
            }
            this.aVw.clear();
            this.aVw = null;
        }
    }

    public ArrayList<TbRichTextData> JH() {
        return this.aVx;
    }

    public String toString() {
        if (this.aVx == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aVx.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aVx.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.JU() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.JU());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aVz);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aVA);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.JR() != null) {
                if (StringUtils.isNull(tbRichTextData.JR().Kt())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aVB).append(tbRichTextData.JR().Kt());
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
