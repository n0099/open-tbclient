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
    private ArrayList<TbRichTextImageInfo> frB;
    private ArrayList<TbRichTextItem> ftV;
    private ArrayList<TbRichTextData> ftW;
    private String ftX;
    private String ftY;
    private String ftZ;
    private int fua;
    private String fub;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.fub;
    }

    public void setAuthorId(String str) {
        this.fub = str;
    }

    public void sd(int i) {
        this.fua = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.ftV = null;
        this.ftW = null;
        this.fua = 0;
        this.fub = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.ftV = null;
        this.ftW = null;
        this.fua = 0;
        this.fub = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.ftV = null;
        this.ftW = null;
        this.fua = 0;
        this.fub = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.ftV = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.ftV.add(tbRichTextItem);
                }
            }
            p(context, z);
            eC(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.ftV = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.ftV.add(tbRichTextItem);
                    }
                }
            }
            p(context, z);
            eC(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.ftV = null;
        this.ftW = null;
        this.fua = 0;
        this.fub = "";
        this.isChanged = false;
        this.ftW = arrayList;
        eC(context);
    }

    private void eC(Context context) {
        this.ftX = context.getString(R.string.pic_str);
        this.ftY = context.getString(R.string.voice_str);
        this.ftZ = context.getString(R.string.video_text);
    }

    private void p(Context context, boolean z) {
        if (this.ftV != null) {
            this.ftW = new ArrayList<>();
            if (this.frB != null) {
                this.frB.clear();
            } else {
                this.frB = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.ftV.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.ftW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.bBw());
                        this.ftW.add(tbRichTextData2);
                        this.frB.add(next.bBw());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.ftW.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.bBA());
                        this.ftW.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence U = next.U(tbRichTextData.bBv());
                        if (U != null) {
                            tbRichTextData.o(U);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.ftW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.bBy());
                        this.ftW.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.ftW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.bBB());
                        this.ftW.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.ftW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.bBC());
                        this.ftW.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.ftW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(PlatformPlugin.DEFAULT_SYSTEM_UI);
                        tbRichTextData7.a(next.bBE());
                        this.ftW.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.bBU());
                            this.ftW.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ky(true);
                        }
                        CharSequence U2 = next.U(tbRichTextData.bBv());
                        if (U2 != null) {
                            tbRichTextData.o(U2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.ftW.add(tbRichTextData);
            }
            this.ftV.clear();
            this.ftV = null;
        }
    }

    public ArrayList<TbRichTextData> bBq() {
        return this.ftW;
    }

    public String toString() {
        if (this.ftW == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.ftW.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.ftW.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.bBD() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.bBD());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.ftX);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.ftY);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.bBA() != null) {
                if (StringUtils.isNull(tbRichTextData.bBA().bCi())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.ftZ).append(tbRichTextData.bBA().bCi());
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

    public int awE() {
        if (this.frB == null) {
            return 0;
        }
        return this.frB.size();
    }

    public ArrayList<TbRichTextImageInfo> bBr() {
        return this.frB;
    }
}
