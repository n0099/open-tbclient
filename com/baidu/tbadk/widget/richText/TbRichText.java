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
/* loaded from: classes2.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextImageInfo> fcq;
    private ArrayList<TbRichTextItem> feJ;
    private ArrayList<TbRichTextData> feK;
    private String feL;
    private String feM;
    private String feN;
    private int feO;
    private String feP;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.feP;
    }

    public void setAuthorId(String str) {
        this.feP = str;
    }

    public void ro(int i) {
        this.feO = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.feJ = null;
        this.feK = null;
        this.feO = 0;
        this.feP = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.feJ = null;
        this.feK = null;
        this.feO = 0;
        this.feP = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.feJ = null;
        this.feK = null;
        this.feO = 0;
        this.feP = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.feJ = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.feJ.add(tbRichTextItem);
                }
            }
            o(context, z);
            ep(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.feJ = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.feJ.add(tbRichTextItem);
                    }
                }
            }
            o(context, z);
            ep(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.feJ = null;
        this.feK = null;
        this.feO = 0;
        this.feP = "";
        this.isChanged = false;
        this.feK = arrayList;
        ep(context);
    }

    private void ep(Context context) {
        this.feL = context.getString(R.string.pic_str);
        this.feM = context.getString(R.string.voice_str);
        this.feN = context.getString(R.string.video_text);
    }

    private void o(Context context, boolean z) {
        if (this.feJ != null) {
            this.feK = new ArrayList<>();
            if (this.fcq != null) {
                this.fcq.clear();
            } else {
                this.fcq = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.feJ.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.feK.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bxC());
                        this.feK.add(tbRichTextData2);
                        this.fcq.add(next.bxC());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.feK.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bxG());
                        this.feK.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bxB());
                        if (U != null) {
                            tbRichTextData.n(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.feK.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bxE());
                        this.feK.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.feK.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bxH());
                        this.feK.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.feK.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bxI());
                        this.feK.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.feK.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bxK());
                        this.feK.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bya());
                            this.feK.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.jX(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bxB());
                        if (U2 != null) {
                            tbRichTextData.n(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.feK.add(tbRichTextData);
            }
            this.feJ.clear();
            this.feJ = null;
        }
    }

    public ArrayList<TbRichTextData> bxw() {
        return this.feK;
    }

    public String toString() {
        if (this.feK == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.feK.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.feK.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bxJ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bxJ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.feL);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.feM);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bxG() != null) {
                if (StringUtils.isNull(tbRichTextData.bxG().byo())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.feN).append(tbRichTextData.bxG().byo());
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
        if (this.fcq == null) {
            return 0;
        }
        return this.fcq.size();
    }

    public ArrayList<TbRichTextImageInfo> bxx() {
        return this.fcq;
    }
}
