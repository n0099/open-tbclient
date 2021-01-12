package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    public static int sg(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
            case 12:
            case 15:
            case 16:
            case 17:
            case 19:
            default:
                return 0;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 17;
            case 13:
                return 1024;
            case 14:
                return PlatformPlugin.DEFAULT_SYSTEM_UI;
            case 18:
                return 18;
            case 20:
                return 20;
        }
    }

    public static SpannableStringBuilder a(bz bzVar, List<PbContent> list, String str) {
        int size;
        CharSequence a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!x.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a2 = a(bzVar, pbContent)) != null) {
                        spannableStringBuilder.append(a2);
                    }
                }
            }
        } else {
            if (str == null) {
                str = "";
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder g(List<PbContent> list, String str) {
        return a((bz) null, list, str);
    }

    public static SpannableStringBuilder bP(List<PbContent> list) {
        return g(list, "");
    }

    public static SpannableStringBuilder a(List<PbContent> list, List<HeadItem> list2, boolean z) {
        int size;
        SpannableStringBuilder spannableStringBuilder;
        boolean z2;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (!x.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text)) {
                        CharSequence a2 = a((bz) null, pbContent);
                        if (i != 0 || list2 == null) {
                            spannableStringBuilder = null;
                            z2 = true;
                        } else {
                            SpannableStringBuilder bQ = bQ(list2);
                            if (sg(pbContent.type.intValue()) == 16) {
                                z2 = true;
                                spannableStringBuilder = bQ;
                            } else {
                                spannableStringBuilder = bQ;
                                z2 = false;
                            }
                        }
                        if (z2) {
                            if (a2 != null) {
                                spannableStringBuilder2.append(a2);
                            }
                        } else if (!z2) {
                            if (spannableStringBuilder != null) {
                                spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
                            }
                            if (a2 != null) {
                                spannableStringBuilder2.append(a2);
                            }
                        } else {
                            if (a2 != null) {
                                spannableStringBuilder2.append(a2);
                            }
                            if (spannableStringBuilder != null) {
                                if (z) {
                                    spannableStringBuilder2.append((CharSequence) "\n");
                                }
                                spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
                            }
                        }
                    }
                }
            }
        } else {
            spannableStringBuilder2.append((CharSequence) "");
        }
        return spannableStringBuilder2;
    }

    public static CharSequence a(bz bzVar, PbContent pbContent) {
        switch (sg(pbContent.type.intValue())) {
            case 2:
                return a(bzVar, 2, pbContent.text, pbContent.link);
            case 4:
                return DF(pbContent.text);
            case 16:
                return b(bzVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(bzVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bz bzVar, int i, String str, final String str2, int i2) {
        SpannableString spannableString;
        f fVar;
        if (str == null) {
            return null;
        }
        boolean z = i == 2 && eg(str, str2);
        if (!str.endsWith(" ")) {
            str = str + " ";
        }
        if (z) {
            spannableString = new SpannableString(" " + str);
        } else {
            spannableString = new SpannableString(str);
        }
        if (i == 18) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.1
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.a(str2, (bz) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.i(bzVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.DG(str2);
                }
            };
        }
        fVar.si(i2);
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
            return spannableString;
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private static SpannableString a(bz bzVar, String str, String str2) {
        SpannableString a2 = a(bzVar, 18, str, str2);
        ap.a(bzVar, a2, a2.toString(), 0);
        return a2;
    }

    private static SpannableString b(bz bzVar, String str, String str2) {
        return a(bzVar, 16, str, str2);
    }

    private static SpannableString a(bz bzVar, int i, String str, String str2) {
        return a(bzVar, i, str, str2, 0);
    }

    private static SpannableString DF(String str) {
        int Cv;
        String str2;
        a.C0579a CQ;
        int width;
        if (str == null || (Cv = TbFaceManager.bCw().Cv(str)) == 0) {
            return null;
        }
        String Cx = TbFaceManager.bCw().Cx(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + Cx + "]";
            CQ = TbFaceManager.bCw().CQ("image_emoticon");
        } else {
            str2 = "#(" + Cx + ")";
            CQ = TbFaceManager.bCw().CQ(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), Cv);
        if (CQ != null) {
            if (str != null && str.startsWith("bearchildren_")) {
                width = (int) (0.25d * CQ.getWidth());
            } else {
                width = (int) (0.4d * CQ.getWidth());
            }
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bz bzVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            m mVar = new m();
            mVar.mLink = str;
            if (bzVar != null) {
                mVar.type = bzVar.bnl();
                mVar.fxW = bzVar.bnk();
            }
            com.baidu.tbadk.plugins.b.a(mVar);
            be.bsB().b(tbPageContextSupport.getPageContext(), new String[]{mVar.mLink, mVar.fxW});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(bz bzVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (bzVar != null) {
                aq aqVar = new aq("c13564");
                if (bzVar.bps()) {
                    aqVar = new aq("c12352");
                    aqVar.an("obj_source", 1);
                    a(aqVar, bzVar);
                } else if (bzVar.eRs) {
                    aqVar.an("obj_source", 2);
                    if (bzVar.getBaijiahaoData() != null) {
                        aqVar.an("obj_type", bzVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    aqVar.an("obj_source", 3);
                    if (bzVar.getBaijiahaoData() != null) {
                        aqVar.an("obj_type", bzVar.getBaijiahaoData().oriUgcType);
                    }
                }
                aqVar.an("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private static void a(aq aqVar, bz bzVar) {
        if (bzVar.bmc()) {
            aqVar.an("obj_type", 2);
        } else if (bzVar.isLinkThread()) {
            aqVar.an("obj_type", 4);
        } else if (bzVar.isShareThread) {
            aqVar.an("obj_type", 5);
        } else if (bzVar.bme()) {
            aqVar.an("obj_type", 6);
        } else if (bzVar.bpv()) {
            aqVar.an("obj_type", 7);
        } else if (bzVar.bmf()) {
            aqVar.an("obj_type", 8);
        } else if (bzVar.bpw()) {
            aqVar.an("obj_type", 9);
        } else if (bzVar.getType() == bz.eOa) {
            aqVar.an("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DG(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            be.bsB().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static SpannableString I(int i, boolean z) {
        if (i < 0) {
            return null;
        }
        int i2 = i <= 5 ? i : 5;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
        SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
        spannableString.setSpan(new com.baidu.tbadk.core.view.a.c(i2, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static SpannableStringBuilder bQ(List<HeadItem> list) {
        ItemStarData itemStarData = new ItemStarData();
        itemStarData.parseProto(list);
        return a(itemStarData);
    }

    public static SpannableStringBuilder a(ItemStarData itemStarData) {
        int i;
        int i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (itemStarData == null || itemStarData.list == null) {
            return spannableStringBuilder;
        }
        int count = x.getCount(itemStarData.list);
        if (count == 0) {
            return spannableStringBuilder;
        }
        if (count == 1) {
            try {
                i2 = Integer.parseInt(((ItemStarData.SingleItemStar) x.getItem(itemStarData.list, 0)).content);
            } catch (NumberFormatException e) {
                i2 = 0;
            }
            spannableStringBuilder.append((CharSequence) I(i2, false));
        } else {
            for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                spannableStringBuilder.append((CharSequence) new SpannableString(singleItemStar.name + ": " + (singleItemStar.type == 1 ? singleItemStar.content : " ")));
                if (singleItemStar.type == 2) {
                    try {
                        i = Integer.parseInt(singleItemStar.content);
                    } catch (NumberFormatException e2) {
                        i = 0;
                    }
                    spannableStringBuilder.append((CharSequence) I(i, false));
                }
                if (!spannableStringBuilder.toString().endsWith("\n")) {
                    spannableStringBuilder.append((CharSequence) "\n");
                }
            }
        }
        return spannableStringBuilder;
    }

    public static boolean eg(@NonNull String str, @NonNull String str2) {
        if (at.isEmpty(str) || at.isEmpty(str2)) {
            return false;
        }
        if (be.bsB().l(str2)) {
            if (be.bsB().l(str)) {
                if (str.equals(str2)) {
                    return false;
                }
                List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
                if (x.isEmpty(queryParameters)) {
                    return true;
                }
                String str3 = queryParameters.get(0);
                if (str.equals(str3) || ("http://" + str).equals(str3) || (SapiUtils.COOKIE_HTTPS_URL_PREFIX + str).equals(str3)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
