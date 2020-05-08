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
    private ArrayList<TbRichTextImageInfo> emP;
    private ArrayList<TbRichTextItem> eoL;
    private ArrayList<TbRichTextData> eoM;
    private String eoN;
    private String eoO;
    private String eoP;
    private int eoQ;
    private String eoR;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.eoR;
    }

    public void setAuthorId(String str) {
        this.eoR = str;
    }

    public void nG(int i) {
        this.eoQ = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.eoL = null;
        this.eoM = null;
        this.eoQ = 0;
        this.eoR = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.eoL = null;
        this.eoM = null;
        this.eoQ = 0;
        this.eoR = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.eoL = null;
        this.eoM = null;
        this.eoQ = 0;
        this.eoR = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.eoL = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.eoL.add(tbRichTextItem);
                }
            }
            j(context, z);
            dK(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.eoL = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.eoL.add(tbRichTextItem);
                    }
                }
            }
            j(context, z);
            dK(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.eoL = null;
        this.eoM = null;
        this.eoQ = 0;
        this.eoR = "";
        this.isChanged = false;
        this.eoM = arrayList;
        dK(context);
    }

    private void dK(Context context) {
        this.eoN = context.getString(R.string.pic_str);
        this.eoO = context.getString(R.string.voice_str);
        this.eoP = context.getString(R.string.video_text);
    }

    private void j(Context context, boolean z) {
        if (this.eoL != null) {
            this.eoM = new ArrayList<>();
            if (this.emP != null) {
                this.emP.clear();
            } else {
                this.emP = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.eoL.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.eoM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bcl());
                        this.eoM.add(tbRichTextData2);
                        this.emP.add(next.bcl());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.eoM.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bcp());
                        this.eoM.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence N = next.N(tbRichTextData.bck());
                        if (N != null) {
                            tbRichTextData.j(N);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.eoM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bcn());
                        this.eoM.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.eoM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bcq());
                        this.eoM.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.eoM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bcr());
                        this.eoM.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.eoM.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.bct());
                        this.eoM.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bcF());
                            this.eoM.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.il(true);
                        }
                        CharSequence N2 = next.N(tbRichTextData.bck());
                        if (N2 != null) {
                            tbRichTextData.j(N2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.eoM.add(tbRichTextData);
            }
            this.eoL.clear();
            this.eoL = null;
        }
    }

    public ArrayList<TbRichTextData> bcf() {
        return this.eoM;
    }

    public String toString() {
        if (this.eoM == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.eoM.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.eoM.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bcs() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bcs());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.eoN);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.eoO);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bcp() != null) {
                if (StringUtils.isNull(tbRichTextData.bcp().bcT())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.eoP).append(tbRichTextData.bcp().bcT());
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

    public int afL() {
        if (this.emP == null) {
            return 0;
        }
        return this.emP.size();
    }

    public ArrayList<TbRichTextImageInfo> bcg() {
        return this.emP;
    }
}
