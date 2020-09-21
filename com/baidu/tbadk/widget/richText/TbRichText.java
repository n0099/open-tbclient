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
    private ArrayList<TbRichTextImageInfo> ffm;
    private ArrayList<TbRichTextItem> fhE;
    private ArrayList<TbRichTextData> fhF;
    private String fhG;
    private String fhH;
    private String fhI;
    private int fhJ;
    private String fhK;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fhK;
    }

    public void setAuthorId(String str) {
        this.fhK = str;
    }

    public void rF(int i) {
        this.fhJ = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.fhE = null;
        this.fhF = null;
        this.fhJ = 0;
        this.fhK = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.fhE = null;
        this.fhF = null;
        this.fhJ = 0;
        this.fhK = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.fhE = null;
        this.fhF = null;
        this.fhJ = 0;
        this.fhK = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.fhE = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.fhE.add(tbRichTextItem);
                }
            }
            p(context, z);
            ev(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.fhE = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.fhE.add(tbRichTextItem);
                    }
                }
            }
            p(context, z);
            ev(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.fhE = null;
        this.fhF = null;
        this.fhJ = 0;
        this.fhK = "";
        this.isChanged = false;
        this.fhF = arrayList;
        ev(context);
    }

    private void ev(Context context) {
        this.fhG = context.getString(R.string.pic_str);
        this.fhH = context.getString(R.string.voice_str);
        this.fhI = context.getString(R.string.video_text);
    }

    private void p(Context context, boolean z) {
        if (this.fhE != null) {
            this.fhF = new ArrayList<>();
            if (this.ffm != null) {
                this.ffm.clear();
            } else {
                this.ffm = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.fhE.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.fhF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.byM());
                        this.fhF.add(tbRichTextData2);
                        this.ffm.add(next.byM());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.fhF.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.byQ());
                        this.fhF.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.byL());
                        if (U != null) {
                            tbRichTextData.n(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.fhF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.byO());
                        this.fhF.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.fhF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.byR());
                        this.fhF.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.fhF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.byS());
                        this.fhF.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.fhF.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.byU());
                        this.fhF.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bzk());
                            this.fhF.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ka(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.byL());
                        if (U2 != null) {
                            tbRichTextData.n(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.fhF.add(tbRichTextData);
            }
            this.fhE.clear();
            this.fhE = null;
        }
    }

    public ArrayList<TbRichTextData> byG() {
        return this.fhF;
    }

    public String toString() {
        if (this.fhF == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.fhF.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.fhF.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.byT() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.byT());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.fhG);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.fhH);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.byQ() != null) {
                if (StringUtils.isNull(tbRichTextData.byQ().bzy())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.fhI).append(tbRichTextData.byQ().bzy());
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

    public int atT() {
        if (this.ffm == null) {
            return 0;
        }
        return this.ffm.size();
    }

    public ArrayList<TbRichTextImageInfo> byH() {
        return this.ffm;
    }
}
