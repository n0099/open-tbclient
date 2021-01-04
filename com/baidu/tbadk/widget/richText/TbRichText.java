package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextImageInfo> fWG;
    private ArrayList<TbRichTextItem> fZa;
    private ArrayList<TbRichTextData> fZb;
    private String fZc;
    private String fZd;
    private String fZe;
    private int fZf;
    private String fZg;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fZg;
    }

    public void setAuthorId(String str) {
        this.fZg = str;
    }

    public void tK(int i) {
        this.fZf = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fZa = null;
        this.fZb = null;
        this.fZf = 0;
        this.fZg = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.fZa = null;
        this.fZb = null;
        this.fZf = 0;
        this.fZg = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fZa = null;
        this.fZb = null;
        this.fZf = 0;
        this.fZg = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fZa = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fZa.add(tbRichTextItem);
                }
            }
            s(context, z);
            fC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.fZa = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fZa.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            fC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fZa = null;
        this.fZb = null;
        this.fZf = 0;
        this.fZg = "";
        this.isChanged = false;
        this.fZb = arrayList;
        fC(context);
    }

    private void fC(Context context) {
        this.fZc = context.getString(R.string.pic_str);
        this.fZd = context.getString(R.string.voice_str);
        this.fZe = context.getString(R.string.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.fZa != null) {
            this.fZb = new ArrayList<>();
            if (this.fWG != null) {
                this.fWG.clear();
            } else {
                this.fWG = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fZa.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fZb.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bLc());
                        this.fZb.add(tbRichTextData2);
                        this.fWG.add(next.bLc());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fZb.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bLg());
                        this.fZb.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bLb());
                        if (U != null) {
                            tbRichTextData.q(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fZb.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bLe());
                        this.fZb.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fZb.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bLh());
                        this.fZb.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fZb.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bLi());
                        this.fZb.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fZb.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bLk());
                        this.fZb.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bLx());
                            this.fZb.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.lL(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bLb());
                        if (U2 != null) {
                            tbRichTextData.q(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fZb.add(tbRichTextData);
            }
            this.fZa.clear();
            this.fZa = null;
        }
    }

    public ArrayList<TbRichTextData> bKW() {
        return this.fZb;
    }

    public String toString() {
        if (this.fZb == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fZb.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fZb.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bLj() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bLj());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fZc);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fZd);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bLg() != null) {
                if (StringUtils.isNull(tbRichTextData.bLg().bLL())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fZe).append(tbRichTextData.bLg().bLL());
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

    public int aES() {
        if (this.fWG == null) {
            return 0;
        }
        return this.fWG.size();
    }

    public ArrayList<TbRichTextImageInfo> bKX() {
        return this.fWG;
    }
}
