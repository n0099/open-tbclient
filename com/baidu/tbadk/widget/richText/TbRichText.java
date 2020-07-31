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
    private ArrayList<TbRichTextImageInfo> eRJ;
    private ArrayList<TbRichTextItem> eUc;
    private ArrayList<TbRichTextData> eUd;
    private String eUe;
    private String eUf;
    private String eUg;
    private int eUh;
    private String eUi;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.eUi;
    }

    public void setAuthorId(String str) {
        this.eUi = str;
    }

    public void pc(int i) {
        this.eUh = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.eUc = null;
        this.eUd = null;
        this.eUh = 0;
        this.eUi = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.eUc = null;
        this.eUd = null;
        this.eUh = 0;
        this.eUi = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.eUc = null;
        this.eUd = null;
        this.eUh = 0;
        this.eUi = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.eUc = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.eUc.add(tbRichTextItem);
                }
            }
            n(context, z);
            eh(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.eUc = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.eUc.add(tbRichTextItem);
                    }
                }
            }
            n(context, z);
            eh(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.eUc = null;
        this.eUd = null;
        this.eUh = 0;
        this.eUi = "";
        this.isChanged = false;
        this.eUd = arrayList;
        eh(context);
    }

    private void eh(Context context) {
        this.eUe = context.getString(R.string.pic_str);
        this.eUf = context.getString(R.string.voice_str);
        this.eUg = context.getString(R.string.video_text);
    }

    private void n(Context context, boolean z) {
        if (this.eUc != null) {
            this.eUd = new ArrayList<>();
            if (this.eRJ != null) {
                this.eRJ.clear();
            } else {
                this.eRJ = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.eUc.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.eUd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.boP());
                        this.eUd.add(tbRichTextData2);
                        this.eRJ.add(next.boP());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.eUd.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.boT());
                        this.eUd.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence O = next.O(tbRichTextData.boO());
                        if (O != null) {
                            tbRichTextData.n(O);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.eUd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.boR());
                        this.eUd.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.eUd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.boU());
                        this.eUd.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.eUd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.boV());
                        this.eUd.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.eUd.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.boX());
                        this.eUd.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bpm());
                            this.eUd.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.jz(true);
                        }
                        CharSequence O2 = next.O(tbRichTextData.boO());
                        if (O2 != null) {
                            tbRichTextData.n(O2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.eUd.add(tbRichTextData);
            }
            this.eUc.clear();
            this.eUc = null;
        }
    }

    public ArrayList<TbRichTextData> boJ() {
        return this.eUd;
    }

    public String toString() {
        if (this.eUd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.eUd.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.eUd.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.boW() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.boW());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.eUe);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.eUf);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.boT() != null) {
                if (StringUtils.isNull(tbRichTextData.boT().bpA())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.eUg).append(tbRichTextData.boT().bpA());
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

    public int alw() {
        if (this.eRJ == null) {
            return 0;
        }
        return this.eRJ.size();
    }

    public ArrayList<TbRichTextImageInfo> boK() {
        return this.eRJ;
    }
}
