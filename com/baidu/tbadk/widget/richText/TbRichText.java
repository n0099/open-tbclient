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
    private ArrayList<TbRichTextImageInfo> fVO;
    private ArrayList<TbRichTextItem> fYh;
    private ArrayList<TbRichTextData> fYi;
    private String fYj;
    private String fYk;
    private String fYl;
    private int fYm;
    private String fYn;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fYn;
    }

    public void setAuthorId(String str) {
        this.fYn = str;
    }

    public void sl(int i) {
        this.fYm = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fYh = null;
        this.fYi = null;
        this.fYm = 0;
        this.fYn = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, String str, boolean z) {
        this.postId = -1L;
        this.fYh = null;
        this.fYi = null;
        this.fYm = 0;
        this.fYn = "";
        this.isChanged = false;
        a(context, list, -1, z, str);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fYh = null;
        this.fYi = null;
        this.fYm = 0;
        this.fYn = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fYh = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fYh.add(tbRichTextItem);
                }
            }
            b(context, z, null);
            fy(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z, String str) {
        if (list != null) {
            this.fYh = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fYh.add(tbRichTextItem);
                    }
                }
            }
            b(context, z, str);
            fy(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fYh = null;
        this.fYi = null;
        this.fYm = 0;
        this.fYn = "";
        this.isChanged = false;
        this.fYi = arrayList;
        fy(context);
    }

    private void fy(Context context) {
        this.fYj = context.getString(R.string.pic_str);
        this.fYk = context.getString(R.string.voice_str);
        this.fYl = context.getString(R.string.video_text);
    }

    private void b(Context context, boolean z, String str) {
        if (this.fYh != null) {
            this.fYi = new ArrayList<>();
            if (this.fVO != null) {
                this.fVO.clear();
            } else {
                this.fVO = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fYh.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fYi.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bHJ());
                        this.fYi.add(tbRichTextData2);
                        this.fVO.add(next.bHJ());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fYi.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bHN());
                        this.fYi.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence e = next.e(tbRichTextData.bHI(), str);
                        if (e != null) {
                            tbRichTextData.p(e);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fYi.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bHL());
                        this.fYi.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fYi.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bHO());
                        this.fYi.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fYi.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bHP());
                        this.fYi.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fYi.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.bHR());
                        this.fYi.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bIe());
                            this.fYi.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2 || next.getType() == 39) {
                            tbRichTextData.lL(true);
                        }
                        CharSequence e2 = next.e(tbRichTextData.bHI(), str);
                        if (e2 != null) {
                            tbRichTextData.p(e2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fYi.add(tbRichTextData);
            }
            this.fYh.clear();
            this.fYh = null;
        }
    }

    public ArrayList<TbRichTextData> bHD() {
        return this.fYi;
    }

    public String toString() {
        if (this.fYi == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fYi.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fYi.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bHQ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bHQ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fYj);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fYk);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bHN() != null) {
                if (StringUtils.isNull(tbRichTextData.bHN().bIr())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fYl).append(tbRichTextData.bHN().bIr());
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
        if (this.fVO == null) {
            return 0;
        }
        return this.fVO.size();
    }

    public ArrayList<TbRichTextImageInfo> bHE() {
        return this.fVO;
    }
}
