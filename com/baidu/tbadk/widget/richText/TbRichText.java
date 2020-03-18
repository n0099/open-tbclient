package com.baidu.tbadk.widget.richText;

import android.content.Context;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichText extends OrmObject {
    public int appendLength;
    private ArrayList<TbRichTextImageInfo> dMT;
    private ArrayList<TbRichTextItem> dOM;
    private ArrayList<TbRichTextData> dON;
    private String dOO;
    private String dOP;
    private String dOQ;
    private int dOR;
    private String dOS;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.dOS;
    }

    public void setAuthorId(String str) {
        this.dOS = str;
    }

    public void nu(int i) {
        this.dOR = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.dOM = null;
        this.dON = null;
        this.dOR = 0;
        this.dOS = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.dOM = null;
        this.dON = null;
        this.dOR = 0;
        this.dOS = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.dOM = null;
        this.dON = null;
        this.dOR = 0;
        this.dOS = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.dOM = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.dOM.add(tbRichTextItem);
                }
            }
            j(context, z);
            ei(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.dOM = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.dOM.add(tbRichTextItem);
                    }
                }
            }
            j(context, z);
            ei(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.dOM = null;
        this.dON = null;
        this.dOR = 0;
        this.dOS = "";
        this.isChanged = false;
        this.dON = arrayList;
        ei(context);
    }

    private void ei(Context context) {
        this.dOO = context.getString(R.string.pic_str);
        this.dOP = context.getString(R.string.voice_str);
        this.dOQ = context.getString(R.string.video_text);
    }

    private void j(Context context, boolean z) {
        if (this.dOM != null) {
            this.dON = new ArrayList<>();
            if (this.dMT != null) {
                this.dMT.clear();
            } else {
                this.dMT = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.dOM.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.dON.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.aUd());
                        this.dON.add(tbRichTextData2);
                        this.dMT.add(next.aUd());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.dON.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.aUh());
                        this.dON.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence N = next.N(tbRichTextData.aUc());
                        if (N != null) {
                            tbRichTextData.j(N);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.dON.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.aUf());
                        this.dON.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.dON.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.aUi());
                        this.dON.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.dON.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.aUj());
                        this.dON.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.dON.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.aUl());
                        this.dON.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.aUx());
                            this.dON.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.hn(true);
                        }
                        CharSequence N2 = next.N(tbRichTextData.aUc());
                        if (N2 != null) {
                            tbRichTextData.j(N2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.dON.add(tbRichTextData);
            }
            this.dOM.clear();
            this.dOM = null;
        }
    }

    public ArrayList<TbRichTextData> aTX() {
        return this.dON;
    }

    public String toString() {
        if (this.dON == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.dON.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.dON.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.aUk() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.aUk());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.dOO);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.dOP);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.aUh() != null) {
                if (StringUtils.isNull(tbRichTextData.aUh().aUL())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.dOQ).append(tbRichTextData.aUh().aUL());
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

    public int getImageCount() {
        if (this.dMT == null) {
            return 0;
        }
        return this.dMT.size();
    }

    public ArrayList<TbRichTextImageInfo> aTY() {
        return this.dMT;
    }
}
