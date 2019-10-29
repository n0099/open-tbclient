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
    private ArrayList<TbRichTextImageInfo> cUy;
    private ArrayList<TbRichTextItem> cWl;
    private ArrayList<TbRichTextData> cWm;
    private String cWn;
    private String cWo;
    private String cWp;
    private int cWq;
    private String cWr;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.cWr;
    }

    public void setAuthorId(String str) {
        this.cWr = str;
    }

    public void kN(int i) {
        this.cWq = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.cWl = null;
        this.cWm = null;
        this.cWq = 0;
        this.cWr = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.cWl = null;
        this.cWm = null;
        this.cWq = 0;
        this.cWr = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.cWl = null;
        this.cWm = null;
        this.cWq = 0;
        this.cWr = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.cWl = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.cWl.add(tbRichTextItem);
                }
            }
            i(context, z);
            cC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.cWl = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.cWl.add(tbRichTextItem);
                    }
                }
            }
            i(context, z);
            cC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.cWl = null;
        this.cWm = null;
        this.cWq = 0;
        this.cWr = "";
        this.isChanged = false;
        this.cWm = arrayList;
        cC(context);
    }

    private void cC(Context context) {
        this.cWn = context.getString(R.string.pic_str);
        this.cWo = context.getString(R.string.voice_str);
        this.cWp = context.getString(R.string.video_text);
    }

    private void i(Context context, boolean z) {
        if (this.cWl != null) {
            this.cWm = new ArrayList<>();
            if (this.cUy != null) {
                this.cUy.clear();
            } else {
                this.cUy = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.cWl.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.cWm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.azp());
                        this.cWm.add(tbRichTextData2);
                        this.cUy.add(next.azp());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.cWm.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.azt());
                        this.cWm.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence I = next.I(tbRichTextData.azo());
                        if (I != null) {
                            tbRichTextData.i(I);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.cWm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.azr());
                        this.cWm.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.cWm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.azu());
                        this.cWm.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.cWm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.azv());
                        this.cWm.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.cWm.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.azx());
                        this.cWm.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.azy());
                            this.cWm.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.fN(true);
                        }
                        CharSequence I2 = next.I(tbRichTextData.azo());
                        if (I2 != null) {
                            tbRichTextData.i(I2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.cWm.add(tbRichTextData);
            }
            this.cWl.clear();
            this.cWl = null;
        }
    }

    public ArrayList<TbRichTextData> azh() {
        return this.cWm;
    }

    public String toString() {
        if (this.cWm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.cWm.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.cWm.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.azw() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.azw());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.cWn);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.cWo);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.azt() != null) {
                if (StringUtils.isNull(tbRichTextData.azt().azW())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.cWp).append(tbRichTextData.azt().azW());
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

    public int azi() {
        if (this.cUy == null) {
            return 0;
        }
        return this.cUy.size();
    }

    public ArrayList<TbRichTextImageInfo> azj() {
        return this.cUy;
    }
}
