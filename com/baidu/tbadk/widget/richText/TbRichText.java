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
    private ArrayList<TbRichTextImageInfo> cKY;
    private ArrayList<TbRichTextItem> cMT;
    private ArrayList<TbRichTextData> cMU;
    private String cMV;
    private String cMW;
    private String cMX;
    private int cMY;
    private String cMZ;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cMZ;
    }

    public void setAuthorId(String str) {
        this.cMZ = str;
    }

    public void lI(int i) {
        this.cMY = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cMT = null;
        this.cMU = null;
        this.cMY = 0;
        this.cMZ = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cMT = null;
        this.cMU = null;
        this.cMY = 0;
        this.cMZ = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cMT = null;
        this.cMU = null;
        this.cMY = 0;
        this.cMZ = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cMT = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cMT.add(tbRichTextItem);
                }
            }
            i(context, z);
            cQ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cMT = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cMT.add(tbRichTextItem);
                    }
                }
            }
            i(context, z);
            cQ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cMT = null;
        this.cMU = null;
        this.cMY = 0;
        this.cMZ = "";
        this.isChanged = false;
        this.cMU = arrayList;
        cQ(context);
    }

    private void cQ(Context context) {
        this.cMV = context.getString(R.string.pic_str);
        this.cMW = context.getString(R.string.voice_str);
        this.cMX = context.getString(R.string.video_text);
    }

    private void i(Context context, boolean z) {
        if (this.cMT != null) {
            this.cMU = new ArrayList<>();
            if (this.cKY != null) {
                this.cKY.clear();
            } else {
                this.cKY = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cMT.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cMU.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.azg());
                        this.cMU.add(tbRichTextData2);
                        this.cKY.add(next.azg());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cMU.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.azk());
                        this.cMU.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence G = next.G(tbRichTextData.azf());
                        if (G != null) {
                            tbRichTextData.k(G);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cMU.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.azi());
                        this.cMU.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cMU.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.azl());
                        this.cMU.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cMU.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.azm());
                        this.cMU.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cMU.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.azo());
                        this.cMU.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.azp());
                            this.cMU.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fY(true);
                        }
                        CharSequence G2 = next.G(tbRichTextData.azf());
                        if (G2 != null) {
                            tbRichTextData.k(G2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cMU.add(tbRichTextData);
            }
            this.cMT.clear();
            this.cMT = null;
        }
    }

    public ArrayList<TbRichTextData> ayZ() {
        return this.cMU;
    }

    public String toString() {
        if (this.cMU == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cMU.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cMU.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.azn() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.azn());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cMV);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cMW);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.azk() != null) {
                if (StringUtils.isNull(tbRichTextData.azk().azN())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cMX).append(tbRichTextData.azk().azN());
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
        if (this.cKY == null) {
            return 0;
        }
        return this.cKY.size();
    }

    public ArrayList<TbRichTextImageInfo> aza() {
        return this.cKY;
    }
}
