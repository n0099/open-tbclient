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
    private ArrayList<TbRichTextImageInfo> fNc;
    private String fPA;
    private String fPB;
    private int fPC;
    private String fPD;
    private ArrayList<TbRichTextItem> fPx;
    private ArrayList<TbRichTextData> fPy;
    private String fPz;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fPD;
    }

    public void setAuthorId(String str) {
        this.fPD = str;
    }

    public void tz(int i) {
        this.fPC = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fPx = null;
        this.fPy = null;
        this.fPC = 0;
        this.fPD = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.fPx = null;
        this.fPy = null;
        this.fPC = 0;
        this.fPD = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fPx = null;
        this.fPy = null;
        this.fPC = 0;
        this.fPD = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fPx = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fPx.add(tbRichTextItem);
                }
            }
            u(context, z);
            fi(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.fPx = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fPx.add(tbRichTextItem);
                    }
                }
            }
            u(context, z);
            fi(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fPx = null;
        this.fPy = null;
        this.fPC = 0;
        this.fPD = "";
        this.isChanged = false;
        this.fPy = arrayList;
        fi(context);
    }

    private void fi(Context context) {
        this.fPz = context.getString(R.string.pic_str);
        this.fPA = context.getString(R.string.voice_str);
        this.fPB = context.getString(R.string.video_text);
    }

    private void u(Context context, boolean z) {
        if (this.fPx != null) {
            this.fPy = new ArrayList<>();
            if (this.fNc != null) {
                this.fNc.clear();
            } else {
                this.fNc = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fPx.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fPy.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bII());
                        this.fPy.add(tbRichTextData2);
                        this.fNc.add(next.bII());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fPy.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bIM());
                        this.fPy.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bIH());
                        if (U != null) {
                            tbRichTextData.q(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fPy.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bIK());
                        this.fPy.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fPy.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bIN());
                        this.fPy.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fPy.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bIO());
                        this.fPy.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fPy.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bIQ());
                        this.fPy.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bJf());
                            this.fPy.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.lp(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bIH());
                        if (U2 != null) {
                            tbRichTextData.q(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fPy.add(tbRichTextData);
            }
            this.fPx.clear();
            this.fPx = null;
        }
    }

    public ArrayList<TbRichTextData> bIC() {
        return this.fPy;
    }

    public String toString() {
        if (this.fPy == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fPy.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fPy.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bIP() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bIP());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fPz);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fPA);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bIM() != null) {
                if (StringUtils.isNull(tbRichTextData.bIM().bJt())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fPB).append(tbRichTextData.bIM().bJt());
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

    public int aDz() {
        if (this.fNc == null) {
            return 0;
        }
        return this.fNc.size();
    }

    public ArrayList<TbRichTextImageInfo> bID() {
        return this.fNc;
    }
}
