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
    private ArrayList<TbRichTextImageInfo> dMq;
    private ArrayList<TbRichTextItem> dOi;
    private ArrayList<TbRichTextData> dOj;
    private String dOk;
    private String dOl;
    private String dOm;
    private int dOn;
    private String dOo;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.dOo;
    }

    public void setAuthorId(String str) {
        this.dOo = str;
    }

    public void ns(int i) {
        this.dOn = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.dOi = null;
        this.dOj = null;
        this.dOn = 0;
        this.dOo = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.dOi = null;
        this.dOj = null;
        this.dOn = 0;
        this.dOo = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.dOi = null;
        this.dOj = null;
        this.dOn = 0;
        this.dOo = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.dOi = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.dOi.add(tbRichTextItem);
                }
            }
            j(context, z);
            ej(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.dOi = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.dOi.add(tbRichTextItem);
                    }
                }
            }
            j(context, z);
            ej(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.dOi = null;
        this.dOj = null;
        this.dOn = 0;
        this.dOo = "";
        this.isChanged = false;
        this.dOj = arrayList;
        ej(context);
    }

    private void ej(Context context) {
        this.dOk = context.getString(R.string.pic_str);
        this.dOl = context.getString(R.string.voice_str);
        this.dOm = context.getString(R.string.video_text);
    }

    private void j(Context context, boolean z) {
        if (this.dOi != null) {
            this.dOj = new ArrayList<>();
            if (this.dMq != null) {
                this.dMq.clear();
            } else {
                this.dMq = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.dOi.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.dOj.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.aTY());
                        this.dOj.add(tbRichTextData2);
                        this.dMq.add(next.aTY());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.dOj.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.aUc());
                        this.dOj.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence N = next.N(tbRichTextData.aTX());
                        if (N != null) {
                            tbRichTextData.j(N);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.dOj.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.aUa());
                        this.dOj.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.dOj.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.aUd());
                        this.dOj.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.dOj.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.aUe());
                        this.dOj.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.dOj.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.aUg());
                        this.dOj.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.aUs());
                            this.dOj.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.hm(true);
                        }
                        CharSequence N2 = next.N(tbRichTextData.aTX());
                        if (N2 != null) {
                            tbRichTextData.j(N2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.dOj.add(tbRichTextData);
            }
            this.dOi.clear();
            this.dOi = null;
        }
    }

    public ArrayList<TbRichTextData> aTS() {
        return this.dOj;
    }

    public String toString() {
        if (this.dOj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.dOj.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.dOj.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.aUf() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.aUf());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.dOk);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.dOl);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.aUc() != null) {
                if (StringUtils.isNull(tbRichTextData.aUc().aUG())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.dOm).append(tbRichTextData.aUc().aUG());
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
        if (this.dMq == null) {
            return 0;
        }
        return this.dMq.size();
    }

    public ArrayList<TbRichTextImageInfo> aTT() {
        return this.dMq;
    }
}
