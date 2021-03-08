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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo fYA;
    private int mType = 0;
    private TbRichTextCommInfo fYU = null;
    private TbRichTextImageInfo fYt = null;
    private TbRichTextVoiceInfo fmD = null;
    private TbRichTextEmotionInfo fYw = null;
    private i fYx = null;
    private TbRichTextLinkButtonInfo fYz = null;
    private TbRichTextLinkImageInfo fYy = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.fYU = tbRichTextCommInfo;
        this.fYt = tbRichTextImageInfo;
        this.fmD = tbRichTextVoiceInfo;
        this.fYw = tbRichTextEmotionInfo;
        this.fYz = tbRichTextLinkButtonInfo;
        this.fYy = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo bHR() {
        if (this.mType == 1280) {
            return this.fYy;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bIe() {
        if (this.mType == 1024) {
            return this.fYz;
        }
        return null;
    }

    public TbRichTextImageInfo bHJ() {
        if (this.mType == 8) {
            return this.fYt;
        }
        return null;
    }

    public i bHN() {
        if (this.mType != 32) {
            return null;
        }
        return this.fYx;
    }

    public TbRichTextVoiceInfo bHL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fmD;
        }
        return null;
    }

    public TbRichTextEmotionInfo bHO() {
        if (this.mType == 17) {
            return this.fYw;
        }
        return null;
    }

    public TbRichTextMemeInfo bHP() {
        if (this.mType == 20) {
            return this.fYA;
        }
        return null;
    }

    private SpannableString bIf() {
        if (this.mType != 1 || this.fYU == null) {
            return null;
        }
        return new SpannableString(this.fYU.getText());
    }

    private CharSequence L(ArrayList<d> arrayList) {
        SpannableString a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.fYU != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence N = N(arrayList);
            if (N != null) {
                spannableStringBuilder.append(N);
            }
            if (this.fYU.bHF() == 1) {
                a2 = a(this.mType, this.fYU.getText(), this.fYU.bHG(), 0, null);
            } else {
                a2 = a(this.mType, this.fYU.getText(), this.fYU.getText(), 0, null);
            }
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence M(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.fYU != null) {
            CharSequence N = N(arrayList);
            if (N != null) {
                spannableStringBuilder.append(N);
            }
            SpannableString a2 = a(this.mType, this.fYU.getLink(), this.fYU.getLink(), 0, null);
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence N(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.e(arrayList, null);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.fYU == null) {
            return null;
        }
        if (this.fYU.bHF() == 1) {
            return this.fYU.bHG();
        }
        return this.fYU.getText();
    }

    private SpannableString Ek(String str) {
        if ((this.mType != 2 && this.mType != 18 && this.mType != 39) || this.fYU == null) {
            return null;
        }
        if (this.fYU.bHF() == 1) {
            return a(this.mType, this.fYU.getText(), this.fYU.bHG(), 0, str);
        }
        return a(this.mType, this.fYU.getText(), this.fYU.getLink(), this.fYU.bHH(), str);
    }

    private SpannableString bIg() {
        if (this.mType != 256 || this.fYU == null) {
            return null;
        }
        String text = this.fYU.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.Ej(this.fYU.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bIh() {
        if (this.mType != 16 || this.fYU == null) {
            return null;
        }
        return a(this.mType, this.fYU.getText(), this.fYU.getLink(), 0, null);
    }

    private SpannableString O(ArrayList<d> arrayList) {
        String text;
        int CR;
        String str;
        a.C0582a Dm;
        if (this.mType != 4 || this.fYU == null || this.fYU.getText() == null || this.fYU.getLink() == null || (CR = TbFaceManager.bCR().CR((text = this.fYU.getText()))) == 0) {
            return null;
        }
        String CT = TbFaceManager.bCR().CT(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + CT + "]";
        } else {
            str = "#(" + CT + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), CR);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bCR().Dm(text) != null) {
            int width = (int) (Dm.getWidth() * 0.5d);
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2, final String str3) {
        f fVar;
        SpannableString spannableString = null;
        if (str != null) {
            boolean z = i == 2 && e.eb(str, str2);
            boolean z2 = i == 39;
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            if (z) {
                spannableString = new SpannableString(" " + str);
            } else if (z2) {
                spannableString = new SpannableString(str + " ");
            } else {
                spannableString = new SpannableString(str);
            }
            if (this.mType == 18) {
                fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        view.setTag(R.id.tag_subpb_ban_display_keyboard, true);
                        TbRichTextItem.this.El(str2);
                    }
                };
            } else if (this.mType == 39) {
                fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.2
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (TbRichTextItem.this.fYU != null) {
                            TbRichTextItem.ec(TbRichTextItem.this.fYU.getItemId(), str3);
                        }
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.sp(i2);
            if (i2 == 1) {
                fVar.setTextColor(R.color.CAM_X0109);
            } else {
                fVar.setTextColor(-1);
            }
            if (z) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                spannableString.setSpan(eMRichTextAnyIconSpan, 0, " ".length(), 33);
                spannableString.setSpan(fVar, " ".length(), (" ".length() + str.length()) - 1, 33);
            } else if (z2) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                eMRichTextAnyIconSpan2.oo(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
                spannableString.setSpan(eMRichTextAnyIconSpan2, str.length() - 1, " ".length() + str.length(), 33);
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
                if (!TextUtils.isEmpty(str3) && !TextUtils.equals("0", str3)) {
                    ar arVar = new ar("c14072");
                    arVar.dR("tid", str3);
                    arVar.aq("obj_locate", 4);
                    TiebaStatic.log(arVar);
                }
            } else {
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
            }
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ec(String str, String str2) {
        ar arVar = new ar("c14073");
        arVar.dR("tid", str2);
        arVar.aq("obj_locate", 4);
        arVar.dR("obj_type", str);
        TiebaStatic.log(arVar);
        HashMap hashMap = new HashMap(1);
        hashMap.put("itemID", str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
    }

    private SpannableString bIi() {
        if (this.mType != 1024 || this.fYz == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString("a");
        Drawable sq = g.sq(this.fYz.btn_type);
        sq.setBounds(0, 0, sq.getIntrinsicWidth(), sq.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(sq);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.fYz.link), spannableString.length() - 1, "a".length(), 33);
        return spannableString;
    }

    public CharSequence e(ArrayList<d> arrayList, String str) {
        switch (this.mType) {
            case 1:
                return bIf();
            case 2:
                return Ek(str);
            case 4:
                return O(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bIh();
            case 18:
                return Ek(str);
            case 32:
                return L(arrayList);
            case 39:
                return Ek(str);
            case 128:
                return M(arrayList);
            case 256:
                return bIg();
            case 1024:
                return bIi();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.fYx.bIs() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        try {
            this.mType = sn(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.fYt = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.fYU = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.fYw = new TbRichTextEmotionInfo();
                    this.fYw.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.fYw.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.fYw.mGifInfo.mStaticUrl = pbContent._static;
                    this.fYw.mType = this.mType;
                    this.fYw.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.fYw.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.fYw.mGifInfo.mPackageName = pbContent.packet_name;
                    this.fYw.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.fYw.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.fYw.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.fYw.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.fYA = new TbRichTextMemeInfo();
                    this.fYA.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.fmD = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.fYz = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case 1280:
                    this.fYy = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.fYx = new i();
                        this.fYx.b(pbContent);
                        break;
                    }
                    this.fYU = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bCR().CR(this.fYU.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.fYU.setText(str);
                            break;
                        } else {
                            this.fYU.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.fYU.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.fYU != null) {
                this.fYU.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        try {
            this.mType = sn(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.fYt = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.fmD = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.fYU = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.fYw = new TbRichTextEmotionInfo();
                this.fYw.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.fYw.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                this.fYw.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.fYw.mType = this.mType;
                this.fYw.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.fYw.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.fYw.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.fYw.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.fYw.mGifInfo.mDynamicUrl.split("/");
                int i = 0;
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.fYw.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.fYU = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int CR = TbFaceManager.bCR().CR(this.fYU.getText());
                    String optString = jSONObject.optString("c");
                    if (CR <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.fYU.setText(str);
                    } else {
                        this.fYU.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.fYU.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.fYU != null) {
                this.fYU.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int sn(int i) {
        return e.sn(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void El(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
            mVar.mLink = str;
            mVar.type = 0;
            mVar.fBL = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
        }
    }
}
