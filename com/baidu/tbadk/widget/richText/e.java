package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.c.x;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private static com.baidu.adp.lib.e.b eOh = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.e.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass4) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bgz().addBitmap(str, aVar.getRawBitmap());
            }
        }
    };

    public static int oM(int i) {
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
                return 1280;
            case 18:
                return 18;
            case 20:
                return 20;
        }
    }

    public static SpannableStringBuilder a(bu buVar, List<PbContent> list, String str) {
        int size;
        CharSequence a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!w.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a = a(buVar, pbContent)) != null) {
                        spannableStringBuilder.append(a);
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

    public static SpannableStringBuilder i(List<PbContent> list, List<HeadItem> list2) {
        int size;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (!w.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text)) {
                        CharSequence a = a((bu) null, pbContent);
                        if (i != 0 || list2 == null) {
                            spannableStringBuilder = null;
                            z = true;
                        } else {
                            SpannableStringBuilder bd = bd(list2);
                            if (oM(pbContent.type.intValue()) == 16) {
                                z = true;
                                spannableStringBuilder = bd;
                            } else {
                                spannableStringBuilder = bd;
                                z = false;
                            }
                        }
                        if (z) {
                            if (a != null) {
                                spannableStringBuilder2.append(a);
                            }
                        } else if (!z) {
                            if (spannableStringBuilder != null) {
                                spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
                            }
                            if (a != null) {
                                spannableStringBuilder2.append(a);
                            }
                        } else {
                            if (a != null) {
                                spannableStringBuilder2.append(a);
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

    public static CharSequence a(bu buVar, PbContent pbContent) {
        switch (oM(pbContent.type.intValue())) {
            case 2:
                return a(buVar, 2, pbContent.text, pbContent.link);
            case 4:
                return zr(pbContent.text);
            case 16:
                return b(buVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(buVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bu buVar, int i, String str, final String str2, int i2) {
        SpannableString spannableString;
        f fVar;
        if (str == null) {
            return null;
        }
        boolean z = i == 2 && dv(str, str2);
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
                    e.a(str2, (bu) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.i(buVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.zs(str2);
                }
            };
        }
        fVar.oP(i2);
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
            return spannableString;
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private static SpannableString a(bu buVar, String str, String str2) {
        SpannableString a = a(buVar, 18, str, str2);
        a(buVar, a, a.toString(), 0);
        return a;
    }

    private static SpannableString b(bu buVar, String str, String str2) {
        return a(buVar, 16, str, str2);
    }

    private static SpannableString a(bu buVar, int i, String str, String str2) {
        return a(buVar, i, str, str2, 0);
    }

    private static SpannableString zr(String str) {
        int yr;
        String str2;
        a.C0496a yL;
        if (str == null || (yr = TbFaceManager.bgy().yr(str)) == 0) {
            return null;
        }
        String yt = TbFaceManager.bgy().yt(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + yt + "]";
            yL = TbFaceManager.bgy().yL("image_emoticon");
        } else {
            str2 = "#(" + yt + ")";
            yL = TbFaceManager.bgy().yL(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), yr);
        if (yL != null) {
            int width = (int) (0.4d * yL.getWidth());
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    private static void a(bu buVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a aj;
        com.baidu.adp.widget.ImageView.a aj2;
        BitmapDrawable bitmapDrawable;
        if (buVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String str2 = buVar.mUrl;
            String str3 = buVar.dNq;
            if (!StringUtils.isNull(str2) && !StringUtils.isNull(str2)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bgz().getBitmap(str2);
                if ((bitmap == null || !x.ai(str2, 10)) && (aj = x.aj(str2, 10)) != null) {
                    bitmap = aj.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bgz().addBitmap(str2, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bgz().getBitmap(str3);
                if ((bitmap2 == null || !x.ai(str3, 10)) && (aj2 = x.aj(str3, 10)) != null) {
                    bitmap2 = aj2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bgz().addBitmap(str3, bitmap2);
                }
                Bitmap bitmap3 = bitmap2;
                if (bitmap != null && !bitmap.isRecycled() && bitmap3 != null && !bitmap3.isRecycled()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < str.length(); i3++) {
                        if (str.charAt(i3) == '#') {
                            if (i2 % 2 == 0) {
                                bitmapDrawable = new BitmapDrawable(bitmap);
                                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            } else {
                                bitmapDrawable = new BitmapDrawable(bitmap3);
                                bitmapDrawable.setBounds(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
                            }
                            k kVar = new k(bitmapDrawable);
                            kVar.setOffset(l.dip2px(TbadkCoreApplication.getInst(), buVar.dMb));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                com.baidu.adp.lib.e.c.ln().a(str2, 10, eOh, null);
                com.baidu.adp.lib.e.c.ln().a(str3, 10, eOh, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bu buVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            if (buVar != null) {
                kVar.type = buVar.aSd();
                kVar.esJ = buVar.aSc();
            }
            com.baidu.tbadk.plugins.b.a(kVar);
            bc.aWU().b(tbPageContextSupport.getPageContext(), new String[]{kVar.mLink, kVar.esJ});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(bu buVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (buVar != null) {
                ao aoVar = new ao("c13564");
                if (buVar.aUh()) {
                    aoVar = new ao("c12352");
                    aoVar.ag("obj_source", 1);
                    a(aoVar, buVar);
                } else if (buVar.dOy) {
                    aoVar.ag("obj_source", 2);
                    if (buVar.getBaijiahaoData() != null) {
                        aoVar.ag("obj_type", buVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    aoVar.ag("obj_source", 3);
                    if (buVar.getBaijiahaoData() != null) {
                        aoVar.ag("obj_type", buVar.getBaijiahaoData().oriUgcType);
                    }
                }
                aoVar.ag("obj_locate", 5);
                TiebaStatic.log(aoVar);
            }
        }
    }

    private static void a(ao aoVar, bu buVar) {
        if (buVar.aQV()) {
            aoVar.ag("obj_type", 2);
        } else if (buVar.isLinkThread()) {
            aoVar.ag("obj_type", 4);
        } else if (buVar.isShareThread) {
            aoVar.ag("obj_type", 5);
        } else if (buVar.aQX()) {
            aoVar.ag("obj_type", 6);
        } else if (buVar.aUl()) {
            aoVar.ag("obj_type", 7);
        } else if (buVar.aQY()) {
            aoVar.ag("obj_type", 8);
        } else if (buVar.aUm()) {
            aoVar.ag("obj_type", 9);
        } else if (buVar.getType() == bu.dLm) {
            aoVar.ag("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zs(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            bc.aWU().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static SpannableString oN(int i) {
        String string;
        int i2;
        if (i == com.baidu.adp.newwidget.ImageView.b.Qo) {
            string = TbadkCoreApplication.getInst().getString(R.string.god_level_comment);
            i2 = R.color.cp_other_d;
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.wonderful_comment);
            i2 = R.color.cp_link_tip_d;
        }
        SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds8);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds11);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds0);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
        com.baidu.tbadk.core.view.a.a aVar = new com.baidu.tbadk.core.view.a.a(i2, dimenPixelSize, dimenPixelSize2, R.color.cp_cont_a, dimenPixelSize3, dimenPixelSize4, dimenPixelSize5);
        aVar.mH(dimenPixelSize6);
        spannableString.setSpan(aVar, 0, spannableString.length(), 17);
        return spannableString;
    }

    public static SpannableString F(int i, boolean z) {
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

    public static SpannableStringBuilder bd(List<HeadItem> list) {
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
        int count = w.getCount(itemStarData.list);
        if (count == 0) {
            return spannableStringBuilder;
        }
        if (count == 1) {
            try {
                i2 = Integer.parseInt(((ItemStarData.SingleItemStar) w.getItem(itemStarData.list, 0)).content);
            } catch (NumberFormatException e) {
                i2 = 0;
            }
            spannableStringBuilder.append((CharSequence) F(i2, false));
        } else {
            for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                spannableStringBuilder.append((CharSequence) new SpannableString(singleItemStar.name + ": " + (singleItemStar.type == 1 ? singleItemStar.content : " ")));
                if (singleItemStar.type == 2) {
                    try {
                        i = Integer.parseInt(singleItemStar.content);
                    } catch (NumberFormatException e2) {
                        i = 0;
                    }
                    spannableStringBuilder.append((CharSequence) F(i, false));
                }
                if (!spannableStringBuilder.toString().endsWith("\n")) {
                    spannableStringBuilder.append((CharSequence) "\n");
                }
            }
        }
        return spannableStringBuilder;
    }

    public static boolean dv(@NonNull String str, @NonNull String str2) {
        if (ar.isEmpty(str) || ar.isEmpty(str2)) {
            return false;
        }
        if (bc.aWU().j(str2)) {
            if (bc.aWU().j(str)) {
                if (str.equals(str2)) {
                    return false;
                }
                List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
                if (w.isEmpty(queryParameters)) {
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
