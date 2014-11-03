package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.util.at {
    private String amk;
    private ArrayList<ak> amn;
    private ArrayList<ak> amp;
    private int amr;
    private b ams;
    private ab amt;
    private String authorId;
    private String bimg_url;
    private HashMap<String, MetaData> userMap;
    private com.baidu.tbadk.widget.richText.a amq = null;
    private String id = null;
    private String title = null;
    private int amj = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<g> alf = new ArrayList<>();
    private ArrayList<g> aml = new ArrayList<>();
    private int amm = 0;
    private int amo = 0;

    public ak() {
        this.amn = null;
        this.amp = null;
        this.amn = new ArrayList<>();
        this.amp = new ArrayList<>();
    }

    public ArrayList<ak> Ad() {
        return this.amn;
    }

    public void Ae() {
        this.amm--;
    }

    public void ef(int i) {
        this.amm = i;
    }

    public ArrayList<ak> Af() {
        return this.amp;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int Ag() {
        return this.amj;
    }

    public void eg(int i) {
        this.amj = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void a(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a Ah() {
        return this.amq;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public b Ai() {
        return this.ams;
    }

    public ab Aj() {
        return this.amt;
    }

    public void a(Context context, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        if (context != null && this.amq != null && this.amq.vA() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int a = com.baidu.adp.lib.util.m.a(context, 15.0f);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.m mVar = new com.baidu.tbadk.widget.m(new al(this, it.next(), context), com.baidu.tieba.u.pic_image_h_not, 1);
                    mVar.d(0, 0, com.baidu.tieba.aj.wm().getApp().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), com.baidu.tieba.aj.wm().getApp().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height));
                    arrayList.add(mVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            an anVar = new an(this, str, str2);
            if (z) {
                TbadkApplication.m251getInst().getSkinType();
                Bitmap bA = aw.bA(com.baidu.tieba.u.icon_floorhost);
                if (bA != null) {
                    int width = (bA.getWidth() * a) / bA.getHeight();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bA);
                    bitmapDrawable.setBounds(0, 0, width, a);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                    if (this.author != null) {
                        spannableString.setSpan(imageSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, sb2.length(), str3.length() + sb2.length(), 17);
                    }
                }
            }
            spannableString.setSpan(anVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> vA = this.amq.vA();
            if (vA != null && vA.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = vA.get(0);
                if (cVar.vG() != null) {
                    cVar.du(sb.length());
                    cVar.vG().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.du(sb.length());
                cVar2.append(spannableString);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < vA.size()) {
                        if (vA.get(i4).getType() != 512) {
                            i3 = i4 + 1;
                        } else {
                            cVar2.a(vA.get(i4).vH());
                            vA.remove(i4);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                vA.add(0, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable e(com.baidu.adp.widget.a.a aVar) {
        Bitmap hl;
        if (aVar == null || (hl = aVar.hl()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(hl);
        bitmapDrawable.setBounds(0, 0, com.baidu.tieba.aj.wm().getApp().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), com.baidu.tieba.aj.wm().getApp().getApplicationContext().getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height));
        return bitmapDrawable;
    }

    public void setContent(ArrayList<g> arrayList) {
        this.alf = arrayList;
    }

    public int Ak() {
        return this.amm;
    }

    public int Al() {
        return this.amo;
    }

    public void O(Context context) {
        int type;
        int i;
        int i2;
        if (this.alf != null) {
            int i3 = -1;
            int size = this.aml.size();
            if (size > 0) {
                try {
                    i3 = this.aml.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.alf.size()) {
                g gVar = this.alf.get(i4);
                if (g.F(i5, gVar.getType())) {
                    this.aml.get(size - 1).a(gVar.M(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (gVar.getType() == 3 || gVar.getType() == 2 || gVar.getType() == 11) {
                        this.aml.add(gVar);
                        type = gVar.getType();
                    } else {
                        g gVar2 = new g();
                        gVar2.setType(0);
                        gVar2.a(gVar.M(context));
                        this.aml.add(gVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void P(Context context) {
        int i;
        int i2;
        int i3;
        if (this.alf != null) {
            int i4 = -1;
            int size = this.aml.size();
            if (size > 0) {
                try {
                    i4 = this.aml.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.alf.size()) {
                g gVar = this.alf.get(i5);
                if (g.E(i6, gVar.getType())) {
                    this.aml.get(size - 1).a(gVar.M(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (gVar.getType() == 3) {
                        this.aml.add(gVar);
                        i = 3;
                    } else if (gVar.getType() == 11) {
                        this.aml.add(gVar);
                        i = 11;
                    } else {
                        g gVar2 = new g();
                        gVar2.setType(0);
                        gVar2.a(gVar.M(context));
                        this.aml.add(gVar2);
                        i = 0;
                    }
                    i2 = i;
                    i3 = size + 1;
                }
                i5++;
                i6 = i2;
                size = i3;
            }
        }
    }

    public void Q(Context context) {
        try {
            if (this.amq != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.amq.toString());
                clipboardManager.getText();
                return;
            }
            if (this.aml == null || this.aml.size() == 0) {
                O(context);
            }
            ArrayList<g> arrayList = this.aml;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<g> it = arrayList.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.getType() == 0) {
                        if (next.yF() != null) {
                            sb.append((CharSequence) next.yF());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(com.baidu.tieba.y.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(com.baidu.tieba.y.voice_str));
                    } else if (next.getType() == 2) {
                        String df = TbFaceManager.sh().df(next.getText());
                        if (df != null) {
                            sb.append("[");
                            sb.append(df);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !az.aA(next.yE())) {
                        sb.append("[").append(next.yE()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.amj = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.amq = TbRichTextView.a(context, subPostList.content, z);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        MetaData metaData;
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.title = jSONObject.optString("title");
                this.amj = jSONObject.optInt("floor", 0);
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.amk = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.amm = jSONObject.optInt("sub_post_number");
                this.amo = jSONObject.optInt("add_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            g gVar = new g();
                            gVar.parserJson(optJSONArray.optJSONObject(i));
                            this.alf.add(gVar);
                        }
                    }
                } else {
                    this.amq = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.amm > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        ak akVar = new ak();
                        akVar.setUserMap(this.userMap);
                        akVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.amn.add(akVar);
                    }
                }
                if (this.amo > 0) {
                    JSONArray optJSONArray3 = jSONObject.optJSONObject("add_post_list").optJSONArray("add_post_list");
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        ak akVar2 = new ak();
                        akVar2.setUserMap(this.userMap);
                        akVar2.a(optJSONArray3.getJSONObject(i3), context);
                        this.amp.add(akVar2);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                if (this.amp.size() >= 5) {
                    this.amr = 5;
                } else {
                    this.amr = this.amp.size();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("tail_info");
                if (optJSONObject != null) {
                    this.ams = new b();
                    this.ams.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject2 != null) {
                    this.amt = new ab();
                    this.amt.parserJson(optJSONObject2);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.amj = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.amk = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.amm = post.sub_post_number.intValue();
                this.amo = post.add_post_number.intValue();
                this.amq = TbRichTextView.a(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size() && i < 2; i++) {
                            ak akVar = new ak();
                            akVar.setUserMap(this.userMap);
                            akVar.a(list.get(i), context);
                            this.amn.add(akVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList : list2) {
                            ak akVar2 = new ak();
                            akVar2.setUserMap(this.userMap);
                            akVar2.a(subPostList, context);
                            this.amp.add(akVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.amp.size() >= 5) {
                    this.amr = 5;
                } else {
                    this.amr = this.amp.size();
                }
                if (post.tail_info != null) {
                    this.ams = new b();
                    this.ams.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.amt = new ab();
                    this.amt.a(post.lbs_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String R(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> vA;
        if (this.amq == null || (vA = this.amq.vA()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = vA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.vG().toString());
            } else if (next.getType() == 17) {
                String str = next.vJ().TJ.Tj;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.y.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.y.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(com.baidu.tieba.y.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int Am() {
        return this.amr;
    }

    public void eh(int i) {
        this.amr = i;
    }

    public com.baidu.tbadk.core.util.as An() {
        ArrayList<com.baidu.tbadk.widget.richText.c> vA;
        if (this.amq != null && (vA = this.amq.vA()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = vA.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as();
                    asVar.width = next.vF().getWidth();
                    asVar.height = next.vF().getHeight();
                    asVar.AI = next.vF().vN();
                    asVar.ES = 17;
                    return asVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<com.baidu.tbadk.core.util.as> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> vA;
        if (this.amq == null || (vA = this.amq.vA()) == null) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.as> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = vA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as();
                asVar.width = next.vF().getWidth();
                asVar.height = next.vF().getHeight();
                asVar.AI = next.vF().vN();
                asVar.ES = 17;
                arrayList.add(asVar);
            } else if (next.vJ() != null) {
                com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as();
                asVar2.width = next.vJ().TJ.Tn;
                asVar2.height = next.vJ().TJ.To;
                asVar2.ET = next.vJ();
                asVar2.ES = 20;
                arrayList.add(asVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.amr) {
                break;
            }
            arrayList.addAll(this.amp.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as();
            asVar3.AI = this.bimg_url;
            asVar3.width = 105;
            asVar3.width = 105;
            asVar3.ES = 19;
            arrayList.add(asVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        com.baidu.tbadk.core.util.as asVar4 = new com.baidu.tbadk.core.util.as();
        asVar4.AI = this.author.getPortrait();
        asVar4.ES = 12;
        arrayList.add(asVar4);
        if (this.amn != null) {
            Iterator<ak> it2 = this.amn.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        if (this.amp != null) {
            Iterator<ak> it3 = this.amp.iterator();
            while (it3.hasNext()) {
                arrayList.addAll(it3.next().getImages());
            }
        }
        return arrayList;
    }
}
