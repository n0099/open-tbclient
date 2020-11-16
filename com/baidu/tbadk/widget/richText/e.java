package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.elementsMaven.view.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    public static int sY(int i) {
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

    public static SpannableStringBuilder a(bx bxVar, List<PbContent> list, String str) {
        int size;
        CharSequence a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!y.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a2 = a(bxVar, pbContent)) != null) {
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
        return a((bx) null, list, str);
    }

    public static SpannableStringBuilder bE(List<PbContent> list) {
        return g(list, "");
    }

    public static SpannableStringBuilder p(List<PbContent> list, List<HeadItem> list2) {
        int size;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (!y.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text)) {
                        CharSequence a2 = a((bx) null, pbContent);
                        if (i != 0 || list2 == null) {
                            spannableStringBuilder = null;
                            z = true;
                        } else {
                            SpannableStringBuilder bF = bF(list2);
                            if (sY(pbContent.type.intValue()) == 16) {
                                z = true;
                                spannableStringBuilder = bF;
                            } else {
                                spannableStringBuilder = bF;
                                z = false;
                            }
                        }
                        if (z) {
                            if (a2 != null) {
                                spannableStringBuilder2.append(a2);
                            }
                        } else if (!z) {
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

    public static CharSequence a(bx bxVar, PbContent pbContent) {
        switch (sY(pbContent.type.intValue())) {
            case 2:
                return a(bxVar, 2, pbContent.text, pbContent.link);
            case 4:
                return Eg(pbContent.text);
            case 16:
                return b(bxVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(bxVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bx bxVar, int i, String str, final String str2, int i2) {
        SpannableString spannableString;
        f fVar;
        if (str == null) {
            return null;
        }
        boolean z = i == 2 && eb(str, str2);
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
                    e.a(str2, (bx) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.i(bxVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.Eh(str2);
                }
            };
        }
        fVar.ta(i2);
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

    private static SpannableString a(bx bxVar, String str, String str2) {
        SpannableString a2 = a(bxVar, 18, str, str2);
        aq.a(bxVar, a2, a2.toString(), 0);
        return a2;
    }

    private static SpannableString b(bx bxVar, String str, String str2) {
        return a(bxVar, 16, str, str2);
    }

    private static SpannableString a(bx bxVar, int i, String str, String str2) {
        return a(bxVar, i, str, str2, 0);
    }

    private static SpannableString Eg(String str) {
        int Dc;
        String str2;
        a.C0592a Dx;
        int width;
        if (str == null || (Dc = TbFaceManager.bAs().Dc(str)) == 0) {
            return null;
        }
        String De = TbFaceManager.bAs().De(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + De + "]";
            Dx = TbFaceManager.bAs().Dx("image_emoticon");
        } else {
            str2 = "#(" + De + ")";
            Dx = TbFaceManager.bAs().Dx(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), Dc);
        if (Dx != null) {
            if (str != null && str.startsWith("bearchildren_")) {
                width = (int) (0.25d * Dx.getWidth());
            } else {
                width = (int) (0.4d * Dx.getWidth());
            }
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bx bxVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            l lVar = new l();
            lVar.mLink = str;
            if (bxVar != null) {
                lVar.type = bxVar.blq();
                lVar.flv = bxVar.blp();
            }
            com.baidu.tbadk.plugins.b.a(lVar);
            bf.bqF().b(tbPageContextSupport.getPageContext(), new String[]{lVar.mLink, lVar.flv});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(bx bxVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (bxVar != null) {
                ar arVar = new ar("c13564");
                if (bxVar.bnw()) {
                    arVar = new ar("c12352");
                    arVar.ak("obj_source", 1);
                    a(arVar, bxVar);
                } else if (bxVar.eFg) {
                    arVar.ak("obj_source", 2);
                    if (bxVar.getBaijiahaoData() != null) {
                        arVar.ak("obj_type", bxVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    arVar.ak("obj_source", 3);
                    if (bxVar.getBaijiahaoData() != null) {
                        arVar.ak("obj_type", bxVar.getBaijiahaoData().oriUgcType);
                    }
                }
                arVar.ak("obj_locate", 5);
                TiebaStatic.log(arVar);
            }
        }
    }

    private static void a(ar arVar, bx bxVar) {
        if (bxVar.bki()) {
            arVar.ak("obj_type", 2);
        } else if (bxVar.isLinkThread()) {
            arVar.ak("obj_type", 4);
        } else if (bxVar.isShareThread) {
            arVar.ak("obj_type", 5);
        } else if (bxVar.bkk()) {
            arVar.ak("obj_type", 6);
        } else if (bxVar.bnz()) {
            arVar.ak("obj_type", 7);
        } else if (bxVar.bkl()) {
            arVar.ak("obj_type", 8);
        } else if (bxVar.bnA()) {
            arVar.ak("obj_type", 9);
        } else if (bxVar.getType() == bx.eBR) {
            arVar.ak("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Eh(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            bf.bqF().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static SpannableString I(int i, boolean z) {
        if (i < 0 || i > 5) {
            return null;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
        SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
        spannableString.setSpan(new com.baidu.tbadk.core.view.a.c(i, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static SpannableStringBuilder bF(List<HeadItem> list) {
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
        int count = y.getCount(itemStarData.list);
        if (count == 0) {
            return spannableStringBuilder;
        }
        if (count == 1) {
            try {
                i2 = Integer.parseInt(((ItemStarData.SingleItemStar) y.getItem(itemStarData.list, 0)).content);
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

    public static boolean eb(@NonNull String str, @NonNull String str2) {
        if (au.isEmpty(str) || au.isEmpty(str2)) {
            return false;
        }
        if (bf.bqF().l(str2)) {
            if (bf.bqF().l(str)) {
                if (str.equals(str2)) {
                    return false;
                }
                List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
                if (y.isEmpty(queryParameters)) {
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
