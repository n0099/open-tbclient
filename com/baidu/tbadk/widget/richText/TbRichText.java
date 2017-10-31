package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    private String aRA;
    private String aRB;
    private int aRC;
    private String aRD;
    private ArrayList<TbRichTextItem> aRv;
    private int aRw;
    private ArrayList<TbRichTextData> aRx;
    private ArrayList<String> aRy;
    private String aRz;
    public int appendLength;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.aRD;
    }

    public void setAuthorId(String str) {
        this.aRD = str;
    }

    public void fU(int i) {
        this.aRC = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.aRv = null;
        this.aRw = 0;
        this.aRx = null;
        this.aRy = null;
        this.aRC = 0;
        this.aRD = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.aRv = null;
        this.aRw = 0;
        this.aRx = null;
        this.aRy = null;
        this.aRC = 0;
        this.aRD = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.aRv = null;
        this.aRw = 0;
        this.aRx = null;
        this.aRy = null;
        this.aRC = 0;
        this.aRD = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.aRv = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.aRv.add(tbRichTextItem);
                }
            }
            s(context, z);
            aZ(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.aRv = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.aRv.add(tbRichTextItem);
                    }
                }
            }
            s(context, z);
            aZ(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.aRv = null;
        this.aRw = 0;
        this.aRx = null;
        this.aRy = null;
        this.aRC = 0;
        this.aRD = "";
        this.isChanged = false;
        this.aRx = arrayList;
        aZ(context);
    }

    private void aZ(Context context) {
        this.aRz = context.getString(d.j.pic_str);
        this.aRA = context.getString(d.j.voice_str);
        this.aRB = context.getString(d.j.video_text);
    }

    private void s(Context context, boolean z) {
        if (this.aRv != null) {
            this.aRx = new ArrayList<>();
            this.aRw = 0;
            if (this.aRy != null) {
                this.aRy.clear();
            }
            Iterator<TbRichTextItem> it = this.aRv.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.aRx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.aRw++;
                        tbRichTextData2.a(next.IO());
                        this.aRx.add(tbRichTextData2);
                        if (this.aRy == null) {
                            this.aRy = new ArrayList<>();
                        }
                        if (next.IO() != null && next.IO().Jc() != null) {
                            this.aRy.add(next.IO().Jc());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.aRx.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.IS());
                        this.aRx.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence x = next.x(tbRichTextData.IN());
                        if (x != null) {
                            tbRichTextData.append(x);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.aRx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.IQ());
                        this.aRx.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.aRx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.IT());
                        this.aRx.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.aRx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.IU());
                        this.aRx.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.aRx.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.aRw++;
                        tbRichTextData7.a(next.IW());
                        this.aRx.add(tbRichTextData7);
                        if (this.aRy == null) {
                            this.aRy = new ArrayList<>();
                        }
                        if (next.IO() != null && next.IW().Jm() != null) {
                            this.aRy.add(next.IW().Jm());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.IX());
                            this.aRx.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cc(true);
                        }
                        CharSequence x2 = next.x(tbRichTextData.IN());
                        if (x2 != null) {
                            tbRichTextData.append(x2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.aRx.add(tbRichTextData);
            }
            this.aRv.clear();
            this.aRv = null;
        }
    }

    public ArrayList<TbRichTextData> II() {
        return this.aRx;
    }

    public String toString() {
        if (this.aRx == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.aRx.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.aRx.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.IV() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.IV());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.aRz);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.aRA);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.IS() != null) {
                if (StringUtils.isNull(tbRichTextData.IS().Ju())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.aRB).append(tbRichTextData.IS().Ju());
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
}
