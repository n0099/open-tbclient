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
    private ArrayList<TbRichTextImageInfo> fFq;
    private ArrayList<TbRichTextItem> fHK;
    private ArrayList<TbRichTextData> fHL;
    private String fHM;
    private String fHN;
    private String fHO;
    private int fHP;
    private String fHQ;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fHQ;
    }

    public void setAuthorId(String str) {
        this.fHQ = str;
    }

    public void sW(int i) {
        this.fHP = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fHK = null;
        this.fHL = null;
        this.fHP = 0;
        this.fHQ = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.fHK = null;
        this.fHL = null;
        this.fHP = 0;
        this.fHQ = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fHK = null;
        this.fHL = null;
        this.fHP = 0;
        this.fHQ = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fHK = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fHK.add(tbRichTextItem);
                }
            }
            p(context, z);
            eC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.fHK = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fHK.add(tbRichTextItem);
                    }
                }
            }
            p(context, z);
            eC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fHK = null;
        this.fHL = null;
        this.fHP = 0;
        this.fHQ = "";
        this.isChanged = false;
        this.fHL = arrayList;
        eC(context);
    }

    private void eC(Context context) {
        this.fHM = context.getString(R.string.pic_str);
        this.fHN = context.getString(R.string.voice_str);
        this.fHO = context.getString(R.string.video_text);
    }

    private void p(Context context, boolean z) {
        if (this.fHK != null) {
            this.fHL = new ArrayList<>();
            if (this.fFq != null) {
                this.fFq.clear();
            } else {
                this.fFq = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fHK.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fHL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bFh());
                        this.fHL.add(tbRichTextData2);
                        this.fFq.add(next.bFh());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fHL.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bFl());
                        this.fHL.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bFg());
                        if (U != null) {
                            tbRichTextData.p(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fHL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bFj());
                        this.fHL.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fHL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bFm());
                        this.fHL.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fHL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bFn());
                        this.fHL.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fHL.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bFp());
                        this.fHL.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bFF());
                            this.fHL.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.kV(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bFg());
                        if (U2 != null) {
                            tbRichTextData.p(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fHL.add(tbRichTextData);
            }
            this.fHK.clear();
            this.fHK = null;
        }
    }

    public ArrayList<TbRichTextData> bFb() {
        return this.fHL;
    }

    public String toString() {
        if (this.fHL == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fHL.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fHL.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bFo() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bFo());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fHM);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fHN);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bFl() != null) {
                if (StringUtils.isNull(tbRichTextData.bFl().bFT())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fHO).append(tbRichTextData.bFl().bFT());
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

    public int aAq() {
        if (this.fFq == null) {
            return 0;
        }
        return this.fFq.size();
    }

    public ArrayList<TbRichTextImageInfo> bFc() {
        return this.fFq;
    }
}
