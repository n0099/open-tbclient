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
    private ArrayList<TbRichTextImageInfo> fcu;
    private ArrayList<TbRichTextItem> feN;
    private ArrayList<TbRichTextData> feO;
    private String feP;
    private String feQ;
    private String feR;
    private int feS;
    private String feT;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.feT;
    }

    public void setAuthorId(String str) {
        this.feT = str;
    }

    public void ro(int i) {
        this.feS = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.feN = null;
        this.feO = null;
        this.feS = 0;
        this.feT = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.feN = null;
        this.feO = null;
        this.feS = 0;
        this.feT = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.feN = null;
        this.feO = null;
        this.feS = 0;
        this.feT = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.feN = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.feN.add(tbRichTextItem);
                }
            }
            o(context, z);
            ep(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.feN = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.feN.add(tbRichTextItem);
                    }
                }
            }
            o(context, z);
            ep(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.feN = null;
        this.feO = null;
        this.feS = 0;
        this.feT = "";
        this.isChanged = false;
        this.feO = arrayList;
        ep(context);
    }

    private void ep(Context context) {
        this.feP = context.getString(R.string.pic_str);
        this.feQ = context.getString(R.string.voice_str);
        this.feR = context.getString(R.string.video_text);
    }

    private void o(Context context, boolean z) {
        if (this.feN != null) {
            this.feO = new ArrayList<>();
            if (this.fcu != null) {
                this.fcu.clear();
            } else {
                this.fcu = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.feN.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.feO.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bxD());
                        this.feO.add(tbRichTextData2);
                        this.fcu.add(next.bxD());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.feO.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bxH());
                        this.feO.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bxC());
                        if (U != null) {
                            tbRichTextData.n(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.feO.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bxF());
                        this.feO.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.feO.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bxI());
                        this.feO.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.feO.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bxJ());
                        this.feO.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.feO.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bxL());
                        this.feO.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.byb());
                            this.feO.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.jZ(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bxC());
                        if (U2 != null) {
                            tbRichTextData.n(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.feO.add(tbRichTextData);
            }
            this.feN.clear();
            this.feN = null;
        }
    }

    public ArrayList<TbRichTextData> bxx() {
        return this.feO;
    }

    public String toString() {
        if (this.feO == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.feO.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.feO.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bxK() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bxK());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.feP);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.feQ);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bxH() != null) {
                if (StringUtils.isNull(tbRichTextData.bxH().byp())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.feR).append(tbRichTextData.bxH().byp());
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

    public int atk() {
        if (this.fcu == null) {
            return 0;
        }
        return this.fcu.size();
    }

    public ArrayList<TbRichTextImageInfo> bxy() {
        return this.fcu;
    }
}
