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
    private ArrayList<TbRichTextImageInfo> dMD;
    private int dOA;
    private String dOB;
    private ArrayList<TbRichTextItem> dOv;
    private ArrayList<TbRichTextData> dOw;
    private String dOx;
    private String dOy;
    private String dOz;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.dOB;
    }

    public void setAuthorId(String str) {
        this.dOB = str;
    }

    public void ns(int i) {
        this.dOA = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.dOv = null;
        this.dOw = null;
        this.dOA = 0;
        this.dOB = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.dOv = null;
        this.dOw = null;
        this.dOA = 0;
        this.dOB = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.dOv = null;
        this.dOw = null;
        this.dOA = 0;
        this.dOB = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.dOv = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.dOv.add(tbRichTextItem);
                }
            }
            j(context, z);
            ej(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.dOv = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.dOv.add(tbRichTextItem);
                    }
                }
            }
            j(context, z);
            ej(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.dOv = null;
        this.dOw = null;
        this.dOA = 0;
        this.dOB = "";
        this.isChanged = false;
        this.dOw = arrayList;
        ej(context);
    }

    private void ej(Context context) {
        this.dOx = context.getString(R.string.pic_str);
        this.dOy = context.getString(R.string.voice_str);
        this.dOz = context.getString(R.string.video_text);
    }

    private void j(Context context, boolean z) {
        if (this.dOv != null) {
            this.dOw = new ArrayList<>();
            if (this.dMD != null) {
                this.dMD.clear();
            } else {
                this.dMD = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.dOv.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.dOw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.aTZ());
                        this.dOw.add(tbRichTextData2);
                        this.dMD.add(next.aTZ());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.dOw.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.aUd());
                        this.dOw.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence N = next.N(tbRichTextData.aTY());
                        if (N != null) {
                            tbRichTextData.j(N);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.dOw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.aUb());
                        this.dOw.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.dOw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.aUe());
                        this.dOw.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.dOw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.aUf());
                        this.dOw.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.dOw.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.aUh());
                        this.dOw.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.aUt());
                            this.dOw.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.hm(true);
                        }
                        CharSequence N2 = next.N(tbRichTextData.aTY());
                        if (N2 != null) {
                            tbRichTextData.j(N2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.dOw.add(tbRichTextData);
            }
            this.dOv.clear();
            this.dOv = null;
        }
    }

    public ArrayList<TbRichTextData> aTT() {
        return this.dOw;
    }

    public String toString() {
        if (this.dOw == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.dOw.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.dOw.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.aUg() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.aUg());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.dOx);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.dOy);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.aUd() != null) {
                if (StringUtils.isNull(tbRichTextData.aUd().aUH())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.dOz).append(tbRichTextData.aUd().aUH());
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
        if (this.dMD == null) {
            return 0;
        }
        return this.dMD.size();
    }

    public ArrayList<TbRichTextImageInfo> aTU() {
        return this.dMD;
    }
}
