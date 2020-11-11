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
    private ArrayList<TbRichTextImageInfo> fFO;
    private ArrayList<TbRichTextItem> fIg;
    private ArrayList<TbRichTextData> fIh;
    private String fIi;
    private String fIj;
    private String fIk;
    private int fIl;
    private String fIm;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fIm;
    }

    public void setAuthorId(String str) {
        this.fIm = str;
    }

    public void sy(int i) {
        this.fIl = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fIg = null;
        this.fIh = null;
        this.fIl = 0;
        this.fIm = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.fIg = null;
        this.fIh = null;
        this.fIl = 0;
        this.fIm = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fIg = null;
        this.fIh = null;
        this.fIl = 0;
        this.fIm = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fIg = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fIg.add(tbRichTextItem);
                }
            }
            q(context, z);
            eC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.fIg = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fIg.add(tbRichTextItem);
                    }
                }
            }
            q(context, z);
            eC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fIg = null;
        this.fIh = null;
        this.fIl = 0;
        this.fIm = "";
        this.isChanged = false;
        this.fIh = arrayList;
        eC(context);
    }

    private void eC(Context context) {
        this.fIi = context.getString(R.string.pic_str);
        this.fIj = context.getString(R.string.voice_str);
        this.fIk = context.getString(R.string.video_text);
    }

    private void q(Context context, boolean z) {
        if (this.fIg != null) {
            this.fIh = new ArrayList<>();
            if (this.fFO != null) {
                this.fFO.clear();
            } else {
                this.fFO = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fIg.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fIh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bFO());
                        this.fIh.add(tbRichTextData2);
                        this.fFO.add(next.bFO());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fIh.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bFS());
                        this.fIh.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bFN());
                        if (U != null) {
                            tbRichTextData.o(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fIh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bFQ());
                        this.fIh.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fIh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bFT());
                        this.fIh.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fIh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bFU());
                        this.fIh.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fIh.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bFW());
                        this.fIh.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bGm());
                            this.fIh.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.kU(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bFN());
                        if (U2 != null) {
                            tbRichTextData.o(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fIh.add(tbRichTextData);
            }
            this.fIg.clear();
            this.fIg = null;
        }
    }

    public ArrayList<TbRichTextData> bFI() {
        return this.fIh;
    }

    public String toString() {
        if (this.fIh == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fIh.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fIh.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bFV() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bFV());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fIi);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fIj);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bFS() != null) {
                if (StringUtils.isNull(tbRichTextData.bFS().bGA())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fIk).append(tbRichTextData.bFS().bGA());
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

    public int aAY() {
        if (this.fFO == null) {
            return 0;
        }
        return this.fFO.size();
    }

    public ArrayList<TbRichTextImageInfo> bFJ() {
        return this.fFO;
    }
}
