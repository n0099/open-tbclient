package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.a0.a;
import d.a.m0.b1.d;
import d.a.m0.b1.m.e;
import d.a.m0.b1.m.f;
import d.a.m0.b1.m.g;
import d.a.m0.b1.m.i;
import d.a.n0.e3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextItem extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13262e = 0;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextCommInfo f13263f = null;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f13264g = null;

    /* renamed from: h  reason: collision with root package name */
    public TbRichTextVoiceInfo f13265h = null;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextEmotionInfo f13266i = null;
    public i j = null;
    public TbRichTextLinkButtonInfo k = null;
    public TbRichTextLinkImageInfo l = null;
    public TbRichTextMemeInfo m;

    /* loaded from: classes3.dex */
    public class a extends f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, String str, String str2) {
            super(i2, str);
            this.l = str2;
        }

        @Override // d.a.m0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            view.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
            TbRichTextItem.this.R(this.l);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, String str, String str2) {
            super(i2, str);
            this.l = str2;
        }

        @Override // d.a.m0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            if (TbRichTextItem.this.f13263f != null) {
                TbRichTextItem.O(TbRichTextItem.this.f13263f.t(), this.l);
            }
        }
    }

    public static void O(String str, String str2) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
        statisticItem.param("tid", str2);
        statisticItem.param("obj_locate", 4);
        statisticItem.param("obj_type", str);
        TiebaStatic.log(statisticItem);
        HashMap hashMap = new HashMap(1);
        hashMap.put("itemID", str);
        hashMap.put("source", 8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
    }

    public TbRichTextImageInfo A() {
        if (this.f13262e == 8) {
            return this.f13264g;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo B() {
        if (this.f13262e == 1024) {
            return this.k;
        }
        return null;
    }

    public final SpannableString C() {
        if (this.f13262e != 1024 || this.k == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable a2 = g.a(this.k.btn_type);
        a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
        d dVar = new d(a2);
        dVar.d(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.k.link), spannableString.length() - 1, 1, 33);
        return spannableString;
    }

    public TbRichTextLinkImageInfo D() {
        if (this.f13262e == 1280) {
            return this.l;
        }
        return null;
    }

    public final SpannableString E(String str) {
        TbRichTextCommInfo tbRichTextCommInfo;
        int i2 = this.f13262e;
        if ((i2 == 2 || i2 == 18 || i2 == 39) && (tbRichTextCommInfo = this.f13263f) != null) {
            if (tbRichTextCommInfo.s() == 1) {
                return I(this.f13262e, this.f13263f.getText(), this.f13263f.u(), 0, str);
            }
            return I(this.f13262e, this.f13263f.getText(), this.f13263f.getLink(), this.f13263f.v(), str);
        }
        return null;
    }

    public TbRichTextMemeInfo F() {
        if (this.f13262e == 20) {
            return this.m;
        }
        return null;
    }

    public final SpannableString G() {
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        if (this.f13262e != 256 || (tbRichTextCommInfo = this.f13263f) == null || (text = tbRichTextCommInfo.getText()) == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.f13262e, text);
        fVar.i(this.f13263f.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    public CharSequence H(ArrayList<d.a.m0.b1.m.d> arrayList, String str) {
        int i2 = this.f13262e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 16) {
                        if (i2 != 18) {
                            if (i2 != 32) {
                                if (i2 != 39) {
                                    if (i2 != 128) {
                                        if (i2 != 256) {
                                            if (i2 != 1024) {
                                                return null;
                                            }
                                            return C();
                                        }
                                        return G();
                                    }
                                    return L(arrayList);
                                }
                                return E(str);
                            }
                            return M(arrayList);
                        }
                        return E(str);
                    }
                    return x();
                }
                return z(arrayList);
            }
            return E(str);
        }
        return J();
    }

    public final SpannableString I(int i2, String str, String str2, int i3, String str3) {
        SpannableString spannableString;
        f fVar;
        if (str != null) {
            boolean z = i2 == 2 && e.r(str, str2);
            boolean z2 = i2 == 39;
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            if (z) {
                spannableString = new SpannableString("m" + str);
            } else if (z2) {
                spannableString = new SpannableString(str + "m");
            } else {
                spannableString = new SpannableString(str);
            }
            int i4 = this.f13262e;
            if (i4 == 18) {
                fVar = new a(i2, str2, str2);
            } else if (i4 == 39) {
                fVar = new b(i2, str2, str3);
            } else {
                fVar = new f(i2, str2);
            }
            fVar.k(i3);
            if (i3 == 1) {
                fVar.j(R.color.CAM_X0109);
            } else {
                fVar.j(-1);
            }
            if (z) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                spannableString.setSpan(fVar, 1, (str.length() + 1) - 1, 33);
                return spannableString;
            } else if (z2) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan2.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                eMRichTextAnyIconSpan2.d(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                spannableString.setSpan(eMRichTextAnyIconSpan2, str.length() - 1, str.length() + 1, 33);
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
                if (TextUtils.isEmpty(str3) || TextUtils.equals("0", str3)) {
                    return spannableString;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                statisticItem.param("tid", str3);
                statisticItem.param("obj_locate", 4);
                TiebaStatic.log(statisticItem);
                return spannableString;
            } else {
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
                return spannableString;
            }
        }
        return null;
    }

    public final SpannableString J() {
        if (this.f13262e != 1 || this.f13263f == null) {
            return null;
        }
        return new SpannableString(this.f13263f.getText());
    }

    public i K() {
        if (this.f13262e != 32) {
            return null;
        }
        return this.j;
    }

    public final CharSequence L(ArrayList<d.a.m0.b1.m.d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f13262e == 128 && this.f13263f != null) {
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            SpannableString I = I(this.f13262e, this.f13263f.getLink(), this.f13263f.getLink(), 0, null);
            if (I != null) {
                spannableStringBuilder.append((CharSequence) I);
            }
        }
        return spannableStringBuilder;
    }

    public final CharSequence M(ArrayList<d.a.m0.b1.m.d> arrayList) {
        SpannableString I;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f13262e == 32 && this.f13263f != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence w = w(arrayList);
            if (w != null) {
                spannableStringBuilder.append(w);
            }
            if (this.f13263f.s() == 1) {
                I = I(this.f13262e, this.f13263f.getText(), this.f13263f.u(), 0, null);
            } else {
                I = I(this.f13262e, this.f13263f.getText(), this.f13263f.getText(), 0, null);
            }
            if (I != null) {
                spannableStringBuilder.append((CharSequence) I);
            }
        }
        return spannableStringBuilder;
    }

    public TbRichTextVoiceInfo N() {
        int i2 = this.f13262e;
        if (i2 == 512 || i2 == 768) {
            return this.f13265h;
        }
        return null;
    }

    public void P(PbContent pbContent) {
        try {
            int v = v(pbContent.type.intValue());
            this.f13262e = v;
            if (v == 8) {
                this.f13264g = new TbRichTextImageInfo(pbContent);
            } else if (v == 20) {
                TbRichTextMemeInfo tbRichTextMemeInfo = new TbRichTextMemeInfo();
                this.m = tbRichTextMemeInfo;
                tbRichTextMemeInfo.memeInfo = pbContent.meme_info;
            } else if (v == 512) {
                this.f13265h = new TbRichTextVoiceInfo(pbContent);
            } else if (v == 1024) {
                this.k = new TbRichTextLinkButtonInfo(pbContent);
            } else if (v == 1280) {
                this.l = new TbRichTextLinkImageInfo(pbContent);
            } else if (v == 16) {
                this.f13263f = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
            } else if (v != 17) {
                if (v == 32) {
                    i iVar = new i();
                    this.j = iVar;
                    iVar.j(pbContent);
                    if (this.j.i()) {
                    }
                }
                TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(pbContent);
                this.f13263f = tbRichTextCommInfo;
                if (this.f13262e == 4) {
                    if (TbFaceManager.e().b(this.f13263f.getText()) <= 0) {
                        this.f13262e = 1;
                        this.f13263f.setText(StringUtils.isNull(pbContent.f69485c) ? "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]" : "[" + pbContent.f69485c + "]");
                    } else {
                        this.f13263f.setLink("[" + pbContent.f69485c + "]");
                    }
                } else if (this.f13262e == 256) {
                    tbRichTextCommInfo.setLink(pbContent.phonetype);
                }
            } else {
                TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                this.f13266i = tbRichTextEmotionInfo;
                tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", pbContent.f69485c);
                this.f13266i.mGifInfo.mDynamicUrl = pbContent.dynamic;
                this.f13266i.mGifInfo.mStaticUrl = pbContent._static;
                this.f13266i.mType = this.f13262e;
                this.f13266i.mGifInfo.mGifWidth = pbContent.width.intValue();
                this.f13266i.mGifInfo.mGifHeight = pbContent.height.intValue();
                this.f13266i.mGifInfo.mPackageName = pbContent.packet_name;
                this.f13266i.mGifInfo.mIcon = pbContent._static;
                String[] split = this.f13266i.mGifInfo.mDynamicUrl.split("/");
                int i2 = 0;
                for (String str : split) {
                    i2++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                this.f13266i.mGifInfo.mGid = split[i2].split("_")[0];
            }
            if (this.f13262e == 1 || this.f13263f == null) {
                return;
            }
            this.f13263f.w();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void Q(int i2, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.f13262e = i2;
        this.f13263f = tbRichTextCommInfo;
        this.f13264g = tbRichTextImageInfo;
        this.f13265h = tbRichTextVoiceInfo;
        this.f13266i = tbRichTextEmotionInfo;
        this.k = tbRichTextLinkButtonInfo;
        this.l = tbRichTextLinkImageInfo;
    }

    public final void R(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.m0.t.m mVar = new d.a.m0.t.m();
        mVar.f50797a = str;
        mVar.f50798b = 0;
        mVar.f50799c = "1";
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
    }

    public int getType() {
        return this.f13262e;
    }

    public String getVideoUrl() {
        TbRichTextCommInfo tbRichTextCommInfo;
        if (this.f13262e != 32 || (tbRichTextCommInfo = this.f13263f) == null) {
            return null;
        }
        if (tbRichTextCommInfo.s() == 1) {
            return this.f13263f.u();
        }
        return this.f13263f.getText();
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            int v = v(jSONObject.optInt("type", 0));
            this.f13262e = v;
            if (v == 8) {
                this.f13264g = new TbRichTextImageInfo(jSONObject);
            } else if (v == 512) {
                this.f13265h = new TbRichTextVoiceInfo(jSONObject);
            } else if (v == 16) {
                this.f13263f = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (v == 17) {
                TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                this.f13266i = tbRichTextEmotionInfo;
                tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.f13266i.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.f13266i.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.f13266i.mType = this.f13262e;
                this.f13266i.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.f13266i.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.f13266i.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.f13266i.mGifInfo.mIcon = jSONObject.optString("icon");
                String[] split = this.f13266i.mGifInfo.mDynamicUrl.split("/");
                int i2 = 0;
                for (String str : split) {
                    i2++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                this.f13266i.mGifInfo.mGid = split[i2].split("_")[0];
            } else {
                TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(jSONObject);
                this.f13263f = tbRichTextCommInfo;
                if (this.f13262e == 4) {
                    int b2 = TbFaceManager.e().b(this.f13263f.getText());
                    String optString = jSONObject.optString("c");
                    if (b2 <= 0) {
                        this.f13262e = 1;
                        this.f13263f.setText(StringUtils.isNull(optString) ? "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]" : "[" + optString + "]");
                    } else {
                        this.f13263f.setLink("[" + optString + "]");
                    }
                } else if (this.f13262e == 256) {
                    tbRichTextCommInfo.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.f13262e == 1 || this.f13263f == null) {
                return;
            }
            this.f13263f.w();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final int v(int i2) {
        return e.g(i2);
    }

    public final CharSequence w(ArrayList<d.a.m0.b1.m.d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.Q(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.H(arrayList, null);
    }

    public final SpannableString x() {
        TbRichTextCommInfo tbRichTextCommInfo;
        int i2 = this.f13262e;
        if (i2 != 16 || (tbRichTextCommInfo = this.f13263f) == null) {
            return null;
        }
        return I(i2, tbRichTextCommInfo.getText(), this.f13263f.getLink(), 0, null);
    }

    public TbRichTextEmotionInfo y() {
        if (this.f13262e == 17) {
            return this.f13266i;
        }
        return null;
    }

    public final SpannableString z(ArrayList<d.a.m0.b1.m.d> arrayList) {
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        int b2;
        String str;
        a.C1099a c2;
        if (this.f13262e != 4 || (tbRichTextCommInfo = this.f13263f) == null || tbRichTextCommInfo.getText() == null || this.f13263f.getLink() == null || (b2 = TbFaceManager.e().b((text = this.f13263f.getText()))) == 0) {
            return null;
        }
        String f2 = TbFaceManager.e().f(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + f2 + "]";
        } else {
            str = SmallTailInfo.EMOTION_PREFIX + f2 + SmallTailInfo.EMOTION_SUFFIX;
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d.a.m0.b1.m.d dVar = new d.a.m0.b1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.e().c(text) != null) {
            int a2 = (int) (c2.a() * 0.5d);
            dVar.setBounds(new Rect(0, 0, a2, a2));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new d.a.m0.b1.b(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }
}
