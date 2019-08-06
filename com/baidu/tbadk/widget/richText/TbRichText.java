package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextImageInfo> cKi;
    private ArrayList<TbRichTextItem> cMd;
    private ArrayList<TbRichTextData> cMe;
    private String cMf;
    private String cMg;
    private String cMh;
    private int cMi;
    private String cMj;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cMj;
    }

    public void setAuthorId(String str) {
        this.cMj = str;
    }

    public void lE(int i) {
        this.cMi = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cMd = null;
        this.cMe = null;
        this.cMi = 0;
        this.cMj = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cMd = null;
        this.cMe = null;
        this.cMi = 0;
        this.cMj = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cMd = null;
        this.cMe = null;
        this.cMi = 0;
        this.cMj = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cMd = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cMd.add(tbRichTextItem);
                }
            }
            i(context, z);
            cQ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cMd = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cMd.add(tbRichTextItem);
                    }
                }
            }
            i(context, z);
            cQ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cMd = null;
        this.cMe = null;
        this.cMi = 0;
        this.cMj = "";
        this.isChanged = false;
        this.cMe = arrayList;
        cQ(context);
    }

    private void cQ(Context context) {
        this.cMf = context.getString(R.string.pic_str);
        this.cMg = context.getString(R.string.voice_str);
        this.cMh = context.getString(R.string.video_text);
    }

    private void i(Context context, boolean z) {
        if (this.cMd != null) {
            this.cMe = new ArrayList<>();
            if (this.cKi != null) {
                this.cKi.clear();
            } else {
                this.cKi = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cMd.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cMe.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.ayU());
                        this.cMe.add(tbRichTextData2);
                        this.cKi.add(next.ayU());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cMe.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.ayY());
                        this.cMe.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence G = next.G(tbRichTextData.ayT());
                        if (G != null) {
                            tbRichTextData.k(G);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cMe.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.ayW());
                        this.cMe.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cMe.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.ayZ());
                        this.cMe.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cMe.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.aza());
                        this.cMe.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cMe.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.azc());
                        this.cMe.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.azd());
                            this.cMe.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fV(true);
                        }
                        CharSequence G2 = next.G(tbRichTextData.ayT());
                        if (G2 != null) {
                            tbRichTextData.k(G2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cMe.add(tbRichTextData);
            }
            this.cMd.clear();
            this.cMd = null;
        }
    }

    public ArrayList<TbRichTextData> ayN() {
        return this.cMe;
    }

    public String toString() {
        if (this.cMe == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cMe.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cMe.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.azb() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.azb());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cMf);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cMg);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.ayY() != null) {
                if (StringUtils.isNull(tbRichTextData.ayY().azB())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cMh).append(tbRichTextData.ayY().azB());
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
        if (this.cKi == null) {
            return 0;
        }
        return this.cKi.size();
    }

    public ArrayList<TbRichTextImageInfo> ayO() {
        return this.cKi;
    }
}
