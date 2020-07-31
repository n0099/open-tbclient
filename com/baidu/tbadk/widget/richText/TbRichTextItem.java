package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextItem extends OrmObject {
    private TbRichTextMemeInfo eUv;
    private int mType = 0;
    private TbRichTextCommInfo eUQ = null;
    private TbRichTextImageInfo eUo = null;
    private TbRichTextVoiceInfo ekK = null;
    private TbRichTextEmotionInfo eUr = null;
    private j eUs = null;
    private TbRichTextLinkButtonInfo eUu = null;
    private TbRichTextLinkImageInfo eUt = null;

    public int getType() {
        return this.mType;
    }

    public void a(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.mType = i;
        this.eUQ = tbRichTextCommInfo;
        this.eUo = tbRichTextImageInfo;
        this.ekK = tbRichTextVoiceInfo;
        this.eUr = tbRichTextEmotionInfo;
        this.eUu = tbRichTextLinkButtonInfo;
        this.eUt = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkImageInfo boX() {
        if (this.mType == 1280) {
            return this.eUt;
        }
        return null;
    }

    public TbRichTextLinkButtonInfo bpm() {
        if (this.mType == 1024) {
            return this.eUu;
        }
        return null;
    }

    public TbRichTextImageInfo boP() {
        if (this.mType == 8) {
            return this.eUo;
        }
        return null;
    }

    public j boT() {
        if (this.mType != 32) {
            return null;
        }
        return this.eUs;
    }

    public TbRichTextVoiceInfo boR() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ekK;
        }
        return null;
    }

    public TbRichTextEmotionInfo boU() {
        if (this.mType == 17) {
            return this.eUr;
        }
        return null;
    }

    public TbRichTextMemeInfo boV() {
        if (this.mType == 20) {
            return this.eUv;
        }
        return null;
    }

    private SpannableString bpn() {
        if (this.mType != 1 || this.eUQ == null) {
            return null;
        }
        return new SpannableString(this.eUQ.getText());
    }

    private CharSequence K(ArrayList<d> arrayList) {
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 32 && this.eUQ != null) {
            spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
            CharSequence M = M(arrayList);
            if (M != null) {
                spannableStringBuilder.append(M);
            }
            if (this.eUQ.boL() == 1) {
                a = a(this.mType, this.eUQ.getText(), this.eUQ.boM(), 0);
            } else {
                a = a(this.mType, this.eUQ.getText(), this.eUQ.getText(), 0);
            }
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence L(ArrayList<d> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mType == 128 && this.eUQ != null) {
            CharSequence M = M(arrayList);
            if (M != null) {
                spannableStringBuilder.append(M);
            }
            SpannableString a = a(this.mType, this.eUQ.getLink(), this.eUQ.getLink(), 0);
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence M(ArrayList<d> arrayList) {
        TbRichTextItem tbRichTextItem = new TbRichTextItem();
        tbRichTextItem.a(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
        return tbRichTextItem.O(arrayList);
    }

    public String getVideoUrl() {
        if (this.mType != 32 || this.eUQ == null) {
            return null;
        }
        if (this.eUQ.boL() == 1) {
            return this.eUQ.boM();
        }
        return this.eUQ.getText();
    }

    private SpannableString bpo() {
        if ((this.mType != 2 && this.mType != 18) || this.eUQ == null) {
            return null;
        }
        if (this.eUQ.boL() == 1) {
            return a(this.mType, this.eUQ.getText(), this.eUQ.boM(), 0);
        }
        return a(this.mType, this.eUQ.getText(), this.eUQ.getLink(), this.eUQ.boN());
    }

    private SpannableString bpp() {
        if (this.mType != 256 || this.eUQ == null) {
            return null;
        }
        String text = this.eUQ.getText();
        if (text == null) {
            return null;
        }
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        SpannableString spannableString = new SpannableString(text);
        f fVar = new f(this.mType, text);
        fVar.AD(this.eUQ.getLink());
        spannableString.setSpan(fVar, 0, text.length() - 1, 33);
        return spannableString;
    }

    private SpannableString bpq() {
        if (this.mType != 16 || this.eUQ == null) {
            return null;
        }
        return a(this.mType, this.eUQ.getText(), this.eUQ.getLink(), 0);
    }

    private SpannableString N(ArrayList<d> arrayList) {
        String text;
        int zx;
        String str;
        a.C0508a zS;
        if (this.mType != 4 || this.eUQ == null || this.eUQ.getText() == null || this.eUQ.getLink() == null || (zx = TbFaceManager.bkj().zx((text = this.eUQ.getText()))) == 0) {
            return null;
        }
        String zz = TbFaceManager.bkj().zz(text);
        if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
            str = "[" + zz + "]";
        } else {
            str = "#(" + zz + ")";
        }
        SpannableString spannableString = new SpannableString(str + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), zx);
        if (arrayList != null) {
            arrayList.add(dVar);
        }
        if (TbFaceManager.bkj().zS(text) != null) {
            int width = (int) (zS.getWidth() * 0.5d);
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 1), 0, str.length(), 33);
        return spannableString;
    }

    private SpannableString a(int i, String str, final String str2, int i2) {
        f fVar;
        SpannableString spannableString = null;
        if (str != null) {
            boolean z = i == 2 && e.dw(str, str2);
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            if (z) {
                spannableString = new SpannableString(" " + str);
            } else {
                spannableString = new SpannableString(str);
            }
            if (this.mType == 18) {
                fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.TbRichTextItem.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        view.setTag(R.id.tag_subpb_ban_display_keyboard, true);
                        TbRichTextItem.this.AE(str2);
                    }
                };
            } else {
                fVar = new f(i, str2);
            }
            fVar.pg(i2);
            if (i2 == 1) {
                fVar.setTextColor(R.color.cp_cont_d);
            } else {
                fVar.setTextColor(-1);
            }
            if (z) {
                h hVar = new h();
                hVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
                spannableString.setSpan(hVar, 0, " ".length(), 33);
                spannableString.setSpan(fVar, " ".length(), (" ".length() + str.length()) - 1, 33);
            } else {
                spannableString.setSpan(fVar, 0, str.length() - 1, 33);
            }
        }
        return spannableString;
    }

    private SpannableString bpr() {
        if (this.mType != 1024 || this.eUu == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(Config.APP_VERSION_CODE);
        Drawable ph = g.ph(this.eUu.btn_type);
        ph.setBounds(0, 0, ph.getIntrinsicWidth(), ph.getIntrinsicHeight());
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(ph);
        dVar.setVerticalOffset(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds4));
        spannableString.setSpan(dVar, 0, 1, 33);
        spannableString.setSpan(new f(1024, this.eUu.link), spannableString.length() - 1, Config.APP_VERSION_CODE.length(), 33);
        return spannableString;
    }

    public CharSequence O(ArrayList<d> arrayList) {
        switch (this.mType) {
            case 1:
                return bpn();
            case 2:
                return bpo();
            case 4:
                return N(arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return bpq();
            case 18:
                return bpo();
            case 32:
                return K(arrayList);
            case 128:
                return L(arrayList);
            case 256:
                return bpp();
            case 1024:
                return bpr();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r7.eUs.bpB() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbContent pbContent) {
        String str;
        int i = 0;
        try {
            this.mType = pe(pbContent.type.intValue());
            switch (this.mType) {
                case 8:
                    this.eUo = new TbRichTextImageInfo(pbContent);
                    break;
                case 16:
                    this.eUQ = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                    break;
                case 17:
                    this.eUr = new TbRichTextEmotionInfo();
                    this.eUr.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                    this.eUr.mGifInfo.mDynamicUrl = pbContent.dynamic;
                    this.eUr.mGifInfo.mStaticUrl = pbContent._static;
                    this.eUr.mType = this.mType;
                    this.eUr.mGifInfo.mGifWidth = pbContent.width.intValue();
                    this.eUr.mGifInfo.mGifHeight = pbContent.height.intValue();
                    this.eUr.mGifInfo.mPackageName = pbContent.packet_name;
                    this.eUr.mGifInfo.mIcon = pbContent._static;
                    String[] split = this.eUr.mGifInfo.mDynamicUrl.split("/");
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            this.eUr.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                            break;
                        }
                    }
                    this.eUr.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
                case 20:
                    this.eUv = new TbRichTextMemeInfo();
                    this.eUv.memeInfo = pbContent.meme_info;
                    break;
                case 512:
                    this.ekK = new TbRichTextVoiceInfo(pbContent);
                    break;
                case 1024:
                    this.eUu = new TbRichTextLinkButtonInfo(pbContent);
                    break;
                case PlatformPlugin.DEFAULT_SYSTEM_UI /* 1280 */:
                    this.eUt = new TbRichTextLinkImageInfo(pbContent);
                    break;
                default:
                    if (this.mType == 32) {
                        this.eUs = new j();
                        this.eUs.b(pbContent);
                        break;
                    }
                    this.eUQ = new TbRichTextCommInfo(pbContent);
                    if (this.mType == 4) {
                        if (TbFaceManager.bkj().zx(this.eUQ.getText()) <= 0) {
                            this.mType = 1;
                            if (StringUtils.isNull(pbContent.c)) {
                                str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                            } else {
                                str = "[" + pbContent.c + "]";
                            }
                            this.eUQ.setText(str);
                            break;
                        } else {
                            this.eUQ.setLink("[" + pbContent.c + "]");
                            break;
                        }
                    } else if (this.mType == 256) {
                        this.eUQ.setLink(pbContent.phonetype);
                        break;
                    }
                    break;
            }
            if (this.mType != 1 && this.eUQ != null) {
                this.eUQ.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        int i = 0;
        try {
            this.mType = pe(jSONObject.optInt("type", 0));
            if (this.mType == 8) {
                this.eUo = new TbRichTextImageInfo(jSONObject);
            } else if (this.mType == 512) {
                this.ekK = new TbRichTextVoiceInfo(jSONObject);
            } else if (this.mType == 16) {
                this.eUQ = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.mType == 17) {
                this.eUr = new TbRichTextEmotionInfo();
                this.eUr.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                this.eUr.mGifInfo.mDynamicUrl = jSONObject.optString(PraiseUBCHelper.SOURCE_DYNAMIC);
                this.eUr.mGifInfo.mStaticUrl = jSONObject.optString("static");
                this.eUr.mType = this.mType;
                this.eUr.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                this.eUr.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                this.eUr.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                this.eUr.mGifInfo.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                String[] split = this.eUr.mGifInfo.mDynamicUrl.split("/");
                for (String str2 : split) {
                    i++;
                    if (str2.equals("faceshop")) {
                        break;
                    }
                }
                this.eUr.mGifInfo.mGid = split[i].split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[0];
            } else {
                this.eUQ = new TbRichTextCommInfo(jSONObject);
                if (this.mType == 4) {
                    int zx = TbFaceManager.bkj().zx(this.eUQ.getText());
                    String optString = jSONObject.optString("c");
                    if (zx <= 0) {
                        this.mType = 1;
                        if (StringUtils.isNull(optString)) {
                            str = "[" + TbadkCoreApplication.getInst().getString(R.string.editor_express) + "]";
                        } else {
                            str = "[" + optString + "]";
                        }
                        this.eUQ.setText(str);
                    } else {
                        this.eUQ.setLink("[" + optString + "]");
                    }
                } else if (this.mType == 256) {
                    this.eUQ.setLink(jSONObject.optString("phonetype"));
                }
            }
            if (this.mType != 1 && this.eUQ != null) {
                this.eUQ.trim();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int pe(int i) {
        return e.pe(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE(String str) {
        if (!TextUtils.isEmpty(str)) {
            k kVar = new k();
            kVar.mLink = str;
            kVar.type = 0;
            kVar.ezd = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }
}
