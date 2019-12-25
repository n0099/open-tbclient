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
    private ArrayList<TbRichTextImageInfo> dIb;
    private ArrayList<TbRichTextItem> dJV;
    private ArrayList<TbRichTextData> dJW;
    private String dJX;
    private String dJY;
    private String dJZ;
    private int dKa;
    private String dKb;
    public boolean hasAppendTime;
    public boolean isChanged;
    private long postId;

    public String getAuthorId() {
        return this.dKb;
    }

    public void setAuthorId(String str) {
        this.dKb = str;
    }

    public void nb(int i) {
        this.dKa = i;
    }

    public TbRichText(Context context, JSONArray jSONArray, int i) {
        this.postId = -1L;
        this.dJV = null;
        this.dJW = null;
        this.dKa = 0;
        this.dKb = "";
        this.isChanged = false;
        a(context, jSONArray, i, false);
    }

    public TbRichText(Context context, List<PbContent> list, boolean z) {
        this.postId = -1L;
        this.dJV = null;
        this.dJW = null;
        this.dKa = 0;
        this.dKb = "";
        this.isChanged = false;
        a(context, list, -1, z);
    }

    public TbRichText(Context context, JSONArray jSONArray, boolean z) {
        this.postId = -1L;
        this.dJV = null;
        this.dJW = null;
        this.dKa = 0;
        this.dKb = "";
        this.isChanged = false;
        a(context, jSONArray, -1, z);
    }

    private void a(Context context, JSONArray jSONArray, int i, boolean z) {
        if (jSONArray != null) {
            this.dJV = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                TbRichTextItem tbRichTextItem = new TbRichTextItem();
                tbRichTextItem.parserJson(jSONArray.optJSONObject(i2));
                if ((tbRichTextItem.getType() & i) != 0) {
                    this.dJV.add(tbRichTextItem);
                }
            }
            j(context, z);
            eg(context);
        }
    }

    private void a(Context context, List<PbContent> list, int i, boolean z) {
        if (list != null) {
            this.dJV = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = list.get(i2);
                if (pbContent != null) {
                    TbRichTextItem tbRichTextItem = new TbRichTextItem();
                    tbRichTextItem.a(pbContent);
                    if ((tbRichTextItem.getType() & i) != 0) {
                        this.dJV.add(tbRichTextItem);
                    }
                }
            }
            j(context, z);
            eg(context);
        }
    }

    public TbRichText(Context context, ArrayList<TbRichTextData> arrayList) {
        this.postId = -1L;
        this.dJV = null;
        this.dJW = null;
        this.dKa = 0;
        this.dKb = "";
        this.isChanged = false;
        this.dJW = arrayList;
        eg(context);
    }

    private void eg(Context context) {
        this.dJX = context.getString(R.string.pic_str);
        this.dJY = context.getString(R.string.voice_str);
        this.dJZ = context.getString(R.string.video_text);
    }

    private void j(Context context, boolean z) {
        if (this.dJV != null) {
            this.dJW = new ArrayList<>();
            if (this.dIb != null) {
                this.dIb.clear();
            } else {
                this.dIb = new ArrayList<>();
            }
            Iterator<TbRichTextItem> it = this.dJV.iterator();
            TbRichTextData tbRichTextData = null;
            while (it.hasNext()) {
                TbRichTextItem next = it.next();
                if (next != null) {
                    if (next.getType() == 8) {
                        if (tbRichTextData != null) {
                            this.dJW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData2 = new TbRichTextData(8);
                        tbRichTextData2.a(next.aRl());
                        this.dJW.add(tbRichTextData2);
                        this.dIb.add(next.aRl());
                    } else if (z && next.getType() == 32) {
                        if (tbRichTextData != null) {
                            this.dJW.add(tbRichTextData);
                        }
                        TbRichTextData tbRichTextData3 = new TbRichTextData(32);
                        tbRichTextData3.setVideoUrl(next.getVideoUrl());
                        tbRichTextData3.a(next.aRp());
                        this.dJW.add(tbRichTextData3);
                        tbRichTextData = new TbRichTextData(1);
                        CharSequence L = next.L(tbRichTextData.aRk());
                        if (L != null) {
                            tbRichTextData.j(L);
                        }
                    } else if (next.getType() == 512) {
                        if (tbRichTextData != null) {
                            this.dJW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData4 = new TbRichTextData(512);
                        tbRichTextData4.a(next.aRn());
                        this.dJW.add(tbRichTextData4);
                    } else if (next.getType() == 17) {
                        if (tbRichTextData != null) {
                            this.dJW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData5 = new TbRichTextData(17);
                        tbRichTextData5.a(next.aRq());
                        this.dJW.add(tbRichTextData5);
                    } else if (next.getType() == 20) {
                        if (tbRichTextData != null) {
                            this.dJW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData6 = new TbRichTextData(20);
                        tbRichTextData6.a(next.aRr());
                        this.dJW.add(tbRichTextData6);
                    } else if (next.getType() == 1280) {
                        if (tbRichTextData != null) {
                            this.dJW.add(tbRichTextData);
                            tbRichTextData = null;
                        }
                        TbRichTextData tbRichTextData7 = new TbRichTextData(1280);
                        tbRichTextData7.a(next.aRt());
                        this.dJW.add(tbRichTextData7);
                    } else {
                        if (tbRichTextData == null) {
                            tbRichTextData = new TbRichTextData(1);
                        }
                        if (next.getType() == 1024) {
                            TbRichTextData tbRichTextData8 = new TbRichTextData(1024);
                            tbRichTextData8.a(next.aRu());
                            this.dJW.add(tbRichTextData8);
                        }
                        if (next.getType() == 18 || next.getType() == 2) {
                            tbRichTextData.ha(true);
                        }
                        CharSequence L2 = next.L(tbRichTextData.aRk());
                        if (L2 != null) {
                            tbRichTextData.j(L2);
                        }
                    }
                }
            }
            if (tbRichTextData != null) {
                this.dJW.add(tbRichTextData);
            }
            this.dJV.clear();
            this.dJV = null;
        }
    }

    public ArrayList<TbRichTextData> aRf() {
        return this.dJW;
    }

    public String toString() {
        if (this.dJW == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.dJW.size();
        for (int i = 0; i < size; i++) {
            TbRichTextData tbRichTextData = this.dJW.get(i);
            String tbRichTextData2 = tbRichTextData.toString();
            if (tbRichTextData.getType() == 1 && tbRichTextData.aRs() > 0) {
                tbRichTextData2 = tbRichTextData2.substring(tbRichTextData.aRs());
            }
            if (i == size - 1 && tbRichTextData.getType() == 1 && this.hasAppendTime) {
                sb.append(tbRichTextData2.substring(0, tbRichTextData2.length() - this.appendLength));
            } else if (tbRichTextData.getType() == 8) {
                sb.append(this.dJX);
            } else if (tbRichTextData.getType() == 512) {
                sb.append(this.dJY);
            } else if (tbRichTextData.getType() == 32 && tbRichTextData.aRp() != null) {
                if (StringUtils.isNull(tbRichTextData.aRp().aRT())) {
                    sb.append(tbRichTextData2);
                } else {
                    sb.append(this.dJZ).append(tbRichTextData.aRp().aRT());
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
        if (this.dIb == null) {
            return 0;
        }
        return this.dIb.size();
    }

    public ArrayList<TbRichTextImageInfo> aRg() {
        return this.dIb;
    }
}
