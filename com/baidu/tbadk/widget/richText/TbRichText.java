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
    private ArrayList<TbRichTextItem> fCq;
    private ArrayList<TbRichTextData> fCr;
    private String fCs;
    private String fCt;
    private String fCu;
    private int fCv;
    private String fCw;
    private ArrayList<TbRichTextImageInfo> fzY;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fCw;
    }

    public void setAuthorId(String str) {
        this.fCw = str;
    }

    public void so(int i) {
        this.fCv = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fCq = null;
        this.fCr = null;
        this.fCv = 0;
        this.fCw = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.fCq = null;
        this.fCr = null;
        this.fCv = 0;
        this.fCw = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fCq = null;
        this.fCr = null;
        this.fCv = 0;
        this.fCw = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fCq = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fCq.add(tbRichTextItem);
                }
            }
            p(context, z);
            eC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.fCq = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fCq.add(tbRichTextItem);
                    }
                }
            }
            p(context, z);
            eC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fCq = null;
        this.fCr = null;
        this.fCv = 0;
        this.fCw = "";
        this.isChanged = false;
        this.fCr = arrayList;
        eC(context);
    }

    private void eC(Context context) {
        this.fCs = context.getString(R.string.pic_str);
        this.fCt = context.getString(R.string.voice_str);
        this.fCu = context.getString(R.string.video_text);
    }

    private void p(Context context, boolean z) {
        if (this.fCq != null) {
            this.fCr = new ArrayList<>();
            if (this.fzY != null) {
                this.fzY.clear();
            } else {
                this.fzY = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fCq.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fCr.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bDp());
                        this.fCr.add(tbRichTextData2);
                        this.fzY.add(next.bDp());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fCr.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bDt());
                        this.fCr.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bDo());
                        if (U != null) {
                            tbRichTextData.o(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fCr.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bDr());
                        this.fCr.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fCr.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bDu());
                        this.fCr.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fCr.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bDv());
                        this.fCr.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fCr.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bDx());
                        this.fCr.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bDN());
                            this.fCr.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.kL(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bDo());
                        if (U2 != null) {
                            tbRichTextData.o(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fCr.add(tbRichTextData);
            }
            this.fCq.clear();
            this.fCq = null;
        }
    }

    public ArrayList<TbRichTextData> bDj() {
        return this.fCr;
    }

    public String toString() {
        if (this.fCr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fCr.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fCr.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bDw() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bDw());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fCs);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fCt);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bDt() != null) {
                if (StringUtils.isNull(tbRichTextData.bDt().bEb())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fCu).append(tbRichTextData.bDt().bEb());
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

    public int ayy() {
        if (this.fzY == null) {
            return 0;
        }
        return this.fzY.size();
    }

    public ArrayList<TbRichTextImageInfo> bDk() {
        return this.fzY;
    }
}
