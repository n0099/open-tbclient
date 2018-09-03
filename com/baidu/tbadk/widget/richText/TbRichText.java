package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextItem> bfa;
    private ArrayList<TbRichTextData> bfc;
    private ArrayList<String> bfd;
    private String bfe;
    private String bff;
    private String bfg;
    private int bfh;
    private String bfi;
    public boolean hasAppendTime;
    public boolean isChanged;
    private int mImageCount;
    private long postId;

    public String getAuthorId() {
        return this.bfi;
    }

    public void setAuthorId(String str) {
        this.bfi = str;
    }

    public void fX(int i) {
        this.bfh = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.bfa = null;
        this.mImageCount = 0;
        this.bfc = null;
        this.bfd = null;
        this.bfh = 0;
        this.bfi = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.bfa = null;
        this.mImageCount = 0;
        this.bfc = null;
        this.bfd = null;
        this.bfh = 0;
        this.bfi = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.bfa = null;
        this.mImageCount = 0;
        this.bfc = null;
        this.bfd = null;
        this.bfh = 0;
        this.bfi = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.bfa = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.bfa.add(tbRichTextItem);
                }
            }
            h(context, z);
            be(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.bfa = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.bfa.add(tbRichTextItem);
                    }
                }
            }
            h(context, z);
            be(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.bfa = null;
        this.mImageCount = 0;
        this.bfc = null;
        this.bfd = null;
        this.bfh = 0;
        this.bfi = "";
        this.isChanged = false;
        this.bfc = arrayList;
        be(context);
    }

    private void be(Context context) {
        this.bfe = context.getString(f.j.pic_str);
        this.bff = context.getString(f.j.voice_str);
        this.bfg = context.getString(f.j.video_text);
    }

    private void h(Context context, boolean z) {
        if (this.bfa != null) {
            this.bfc = new ArrayList<>();
            this.mImageCount = 0;
            if (this.bfd != null) {
                this.bfd.clear();
            }
            Iterator<TbRichTextItem> it = this.bfa.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.bfc.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        this.mImageCount++;
                        tbRichTextData2.a(next.NC());
                        this.bfc.add(tbRichTextData2);
                        if (this.bfd == null) {
                            this.bfd = new ArrayList<>();
                        }
                        if (next.NC() != null && next.NC().NR() != null) {
                            this.bfd.add(next.NC().NR());
                        }
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.bfc.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.NG());
                        this.bfc.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence A = next.A(tbRichTextData.NB());
                        if (A != null) {
                            tbRichTextData.append(A);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.bfc.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.NE());
                        this.bfc.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.bfc.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.NH());
                        this.bfc.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.bfc.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.NI());
                        this.bfc.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.bfc.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        this.mImageCount++;
                        tbRichTextData7.a(next.NK());
                        this.bfc.add(tbRichTextData7);
                        if (this.bfd == null) {
                            this.bfd = new ArrayList<>();
                        }
                        if (next.NC() != null && next.NK().Oc() != null) {
                            this.bfd.add(next.NK().Oc());
                        }
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.NL());
                            this.bfc.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.co(true);
                        }
                        CharSequence A2 = next.A(tbRichTextData.NB());
                        if (A2 != null) {
                            tbRichTextData.append(A2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.bfc.add(tbRichTextData);
            }
            this.bfa.clear();
            this.bfa = null;
        }
    }

    public ArrayList<TbRichTextData> Nw() {
        return this.bfc;
    }

    public String toString() {
        if (this.bfc == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.bfc.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.bfc.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.NJ() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.NJ());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.bfe);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.bff);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.NG() != null) {
                if (StringUtils.isNull(tbRichTextData.NG().Ok())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.bfg).append(tbRichTextData.NG().Ok());
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
