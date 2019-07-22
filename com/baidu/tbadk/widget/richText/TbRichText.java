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
    private ArrayList<TbRichTextImageInfo> cKb;
    private ArrayList<TbRichTextItem> cLW;
    private ArrayList<TbRichTextData> cLX;
    private String cLY;
    private String cLZ;
    private String cMa;
    private int cMb;
    private String cMc;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cMc;
    }

    public void setAuthorId(String str) {
        this.cMc = str;
    }

    public void lD(int i) {
        this.cMb = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cLW = null;
        this.cLX = null;
        this.cMb = 0;
        this.cMc = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cLW = null;
        this.cLX = null;
        this.cMb = 0;
        this.cMc = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cLW = null;
        this.cLX = null;
        this.cMb = 0;
        this.cMc = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cLW = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cLW.add(tbRichTextItem);
                }
            }
            i(context, z);
            cQ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cLW = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cLW.add(tbRichTextItem);
                    }
                }
            }
            i(context, z);
            cQ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cLW = null;
        this.cLX = null;
        this.cMb = 0;
        this.cMc = "";
        this.isChanged = false;
        this.cLX = arrayList;
        cQ(context);
    }

    private void cQ(Context context) {
        this.cLY = context.getString(R.string.pic_str);
        this.cLZ = context.getString(R.string.voice_str);
        this.cMa = context.getString(R.string.video_text);
    }

    private void i(Context context, boolean z) {
        if (this.cLW != null) {
            this.cLX = new ArrayList<>();
            if (this.cKb != null) {
                this.cKb.clear();
            } else {
                this.cKb = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cLW.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cLX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.ayS());
                        this.cLX.add(tbRichTextData2);
                        this.cKb.add(next.ayS());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cLX.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.ayW());
                        this.cLX.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence G = next.G(tbRichTextData.ayR());
                        if (G != null) {
                            tbRichTextData.k(G);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cLX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.ayU());
                        this.cLX.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cLX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.ayX());
                        this.cLX.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cLX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.ayY());
                        this.cLX.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cLX.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.aza());
                        this.cLX.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.azb());
                            this.cLX.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fV(true);
                        }
                        CharSequence G2 = next.G(tbRichTextData.ayR());
                        if (G2 != null) {
                            tbRichTextData.k(G2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cLX.add(tbRichTextData);
            }
            this.cLW.clear();
            this.cLW = null;
        }
    }

    public ArrayList<TbRichTextData> ayL() {
        return this.cLX;
    }

    public String toString() {
        if (this.cLX == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cLX.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cLX.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.ayZ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.ayZ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cLY);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cLZ);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.ayW() != null) {
                if (StringUtils.isNull(tbRichTextData.ayW().azz())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cMa).append(tbRichTextData.ayW().azz());
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
        if (this.cKb == null) {
            return 0;
        }
        return this.cKb.size();
    }

    public ArrayList<TbRichTextImageInfo> ayM() {
        return this.cKb;
    }
}
