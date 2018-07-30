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
    public int appendLength;
    private ArrayList<TbRichTextItem> beZ;
    private ArrayList<TbRichTextData> bfa;
    private ArrayList<String> bfc;
    private String bfd;
    private String bfe;
    private String bff;
    private int bfg;
    private String bfh;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bfh;
    }

    public void setAuthorId(String str) {
        this.bfh = str;
    }

    public void fY(int i) {
        this.bfg = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.beZ = null;
        this.mImageCount = 0;
        this.bfa = null;
        this.bfc = null;
        this.bfg = 0;
        this.bfh = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.beZ = null;
        this.mImageCount = 0;
        this.bfa = null;
        this.bfc = null;
        this.bfg = 0;
        this.bfh = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.beZ = null;
        this.mImageCount = 0;
        this.bfa = null;
        this.bfc = null;
        this.bfg = 0;
        this.bfh = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.beZ = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.beZ.add(tbRichTextItem);
                }
            }
            t(context, z);
            bf(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.beZ = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.beZ.add(tbRichTextItem);
                    }
                }
            }
            t(context, z);
            bf(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.beZ = null;
        this.mImageCount = 0;
        this.bfa = null;
        this.bfc = null;
        this.bfg = 0;
        this.bfh = "";
        this.isChanged = false;
        this.bfa = arrayList;
        bf(context);
    }

    private void bf(Context context) {
        this.bfd = context.getString(d.j.pic_str);
        this.bfe = context.getString(d.j.voice_str);
        this.bff = context.getString(d.j.video_text);
    }

    private void t(Context context, boolean z) {
        if (this.beZ != null) {
            this.bfa = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bfc != null) {
                this.bfc.clear();
            }
            Iterator<TbRichTextItem> it = this.beZ.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bfa.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.ND());
                        this.bfa.add(tbRichTextData2);
                        if (this.bfc == null) {
                            this.bfc = new ArrayList<>();
                        }
                        if (next.ND() != null && next.ND().NS() != null) {
                            this.bfc.add(next.ND().NS());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bfa.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.NH());
                        this.bfa.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence A = next.A(tbRichTextData.NC());
                        if (A != null) {
                            tbRichTextData.append(A);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bfa.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.NF());
                        this.bfa.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bfa.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.NI());
                        this.bfa.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bfa.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.NJ());
                        this.bfa.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bfa.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.NL());
                        this.bfa.add(tbRichTextData7);
                        if (this.bfc == null) {
                            this.bfc = new ArrayList<>();
                        }
                        if (next.ND() != null && next.NL().Od() != null) {
                            this.bfc.add(next.NL().Od());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.NM());
                            this.bfa.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.cn(true);
                        }
                        CharSequence A2 = next.A(tbRichTextData.NC());
                        if (A2 != null) {
                            tbRichTextData.append(A2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bfa.add(tbRichTextData);
            }
            this.beZ.clear();
            this.beZ = null;
        }
    }

    public ArrayList<TbRichTextData> Nx() {
        return this.bfa;
    }

    public String toString() {
        if (this.bfa == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bfa.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bfa.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.NK() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.NK());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bfd);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bfe);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.NH() != null) {
                if (StringUtils.isNull(tbRichTextData.NH().Ol())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bff).append(tbRichTextData.NH().Ol());
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
