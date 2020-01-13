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
    private ArrayList<TbRichTextImageInfo> dIk;
    private ArrayList<TbRichTextItem> dKc;
    private ArrayList<TbRichTextData> dKd;
    private String dKe;
    private String dKf;
    private String dKg;
    private int dKh;
    private String dKi;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.dKi;
    }

    public void setAuthorId(String str) {
        this.dKi = str;
    }

    public void nb(int i) {
        this.dKh = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.dKc = null;
        this.dKd = null;
        this.dKh = 0;
        this.dKi = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.dKc = null;
        this.dKd = null;
        this.dKh = 0;
        this.dKi = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.dKc = null;
        this.dKd = null;
        this.dKh = 0;
        this.dKi = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.dKc = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.dKc.add(tbRichTextItem);
                }
            }
            j(context, z);
            eg(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.dKc = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.dKc.add(tbRichTextItem);
                    }
                }
            }
            j(context, z);
            eg(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.dKc = null;
        this.dKd = null;
        this.dKh = 0;
        this.dKi = "";
        this.isChanged = false;
        this.dKd = arrayList;
        eg(context);
    }

    private void eg(Context context) {
        this.dKe = context.getString(R.string.pic_str);
        this.dKf = context.getString(R.string.voice_str);
        this.dKg = context.getString(R.string.video_text);
    }

    private void j(Context context, boolean z) {
        if (this.dKc != null) {
            this.dKd = new ArrayList<>();
            if (this.dIk != null) {
                this.dIk.clear();
            } else {
                this.dIk = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.dKc.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.dKd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.aRF());
                        this.dKd.add(tbRichTextData2);
                        this.dIk.add(next.aRF());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.dKd.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.aRJ());
                        this.dKd.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence L = next.L(tbRichTextData.aRE());
                        if (L != null) {
                            tbRichTextData.j(L);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.dKd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.aRH());
                        this.dKd.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.dKd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.aRK());
                        this.dKd.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.dKd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.aRL());
                        this.dKd.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.dKd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.aRN());
                        this.dKd.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.aRO());
                            this.dKd.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.hf(true);
                        }
                        CharSequence L2 = next.L(tbRichTextData.aRE());
                        if (L2 != null) {
                            tbRichTextData.j(L2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.dKd.add(tbRichTextData);
            }
            this.dKc.clear();
            this.dKc = null;
        }
    }

    public ArrayList<TbRichTextData> aRz() {
        return this.dKd;
    }

    public String toString() {
        if (this.dKd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.dKd.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.dKd.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.aRM() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.aRM());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.dKe);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.dKf);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.aRJ() != null) {
                if (StringUtils.isNull(tbRichTextData.aRJ().aSn())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.dKg).append(tbRichTextData.aRJ().aSn());
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
        if (this.dIk == null) {
            return 0;
        }
        return this.dIk.size();
    }

    public ArrayList<TbRichTextImageInfo> aRA() {
        return this.dIk;
    }
}
