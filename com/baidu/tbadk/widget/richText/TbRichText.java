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
    private ArrayList<TbRichTextImageInfo> fUo;
    private ArrayList<TbRichTextItem> fWH;
    private ArrayList<TbRichTextData> fWI;
    private String fWJ;
    private String fWK;
    private String fWL;
    private int fWM;
    private String fWN;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fWN;
    }

    public void setAuthorId(String str) {
        this.fWN = str;
    }

    public void sj(int i) {
        this.fWM = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fWH = null;
        this.fWI = null;
        this.fWM = 0;
        this.fWN = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        this.postId = -1L;
        this.fWH = null;
        this.fWI = null;
        this.fWM = 0;
        this.fWN = "";
        this.isChanged = false;
        a(context, list, -1, z, str);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fWH = null;
        this.fWI = null;
        this.fWM = 0;
        this.fWN = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fWH = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fWH.add(tbRichTextItem);
                }
            }
            b(context, z, null);
            fz(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z, String str) {
        if (list != null) {
            this.fWH = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fWH.add(tbRichTextItem);
                    }
                }
            }
            b(context, z, str);
            fz(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fWH = null;
        this.fWI = null;
        this.fWM = 0;
        this.fWN = "";
        this.isChanged = false;
        this.fWI = arrayList;
        fz(context);
    }

    private void fz(Context context) {
        this.fWJ = context.getString(R.string.pic_str);
        this.fWK = context.getString(R.string.voice_str);
        this.fWL = context.getString(R.string.video_text);
    }

    private void b(Context context, boolean z, String str) {
        if (this.fWH != null) {
            this.fWI = new ArrayList<>();
            if (this.fUo != null) {
                this.fUo.clear();
            } else {
                this.fUo = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fWH.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fWI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bHF());
                        this.fWI.add(tbRichTextData2);
                        this.fUo.add(next.bHF());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fWI.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bHJ());
                        this.fWI.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence e = next.e(tbRichTextData.bHE(), str);
                        if (e != null) {
                            tbRichTextData.p(e);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fWI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bHH());
                        this.fWI.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fWI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bHK());
                        this.fWI.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fWI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bHL());
                        this.fWI.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fWI.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.bHN());
                        this.fWI.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bIa());
                            this.fWI.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2 || next.getType() == 39) {
                            tbRichTextData.lL(true);
                        }
                        CharSequence e2 = next.e(tbRichTextData.bHE(), str);
                        if (e2 != null) {
                            tbRichTextData.p(e2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fWI.add(tbRichTextData);
            }
            this.fWH.clear();
            this.fWH = null;
        }
    }

    public ArrayList<TbRichTextData> bHz() {
        return this.fWI;
    }

    public String toString() {
        if (this.fWI == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fWI.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fWI.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bHM() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bHM());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fWJ);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fWK);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bHJ() != null) {
                if (StringUtils.isNull(tbRichTextData.bHJ().bIn())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fWL).append(tbRichTextData.bHJ().bIn());
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
        if (this.fUo == null) {
            return 0;
        }
        return this.fUo.size();
    }

    public ArrayList<TbRichTextImageInfo> bHA() {
        return this.fUo;
    }
}
