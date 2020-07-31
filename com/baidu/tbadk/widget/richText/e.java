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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private static com.baidu.adp.lib.e.b eUC = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.e.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass4) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bkk().addBitmap(str, aVar.getRawBitmap());
            }
        }
    };

    public static int pe(int i) {
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

    public static SpannableStringBuilder a(bv bvVar, List<PbContent> list, String str) {
        int size;
        CharSequence a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!x.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a = a(bvVar, pbContent)) != null) {
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
        if (!x.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text)) {
                        CharSequence a = a((bv) null, pbContent);
                        if (i != 0 || list2 == null) {
                            spannableStringBuilder = null;
                            z = true;
                        } else {
                            SpannableStringBuilder bh = bh(list2);
                            if (pe(pbContent.type.intValue()) == 16) {
                                z = true;
                                spannableStringBuilder = bh;
                            } else {
                                spannableStringBuilder = bh;
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

    public static CharSequence a(bv bvVar, PbContent pbContent) {
        switch (pe(pbContent.type.intValue())) {
            case 2:
                return a(bvVar, 2, pbContent.text, pbContent.link);
            case 4:
                return Az(pbContent.text);
            case 16:
                return b(bvVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(bvVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bv bvVar, int i, String str, final String str2, int i2) {
        SpannableString spannableString;
        f fVar;
        if (str == null) {
            return null;
        }
        boolean z = i == 2 && dw(str, str2);
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
                    e.a(str2, (bv) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.i(bvVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.AA(str2);
                }
            };
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
            return spannableString;
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private static SpannableString a(bv bvVar, String str, String str2) {
        SpannableString a = a(bvVar, 18, str, str2);
        a(bvVar, a, a.toString(), 0);
        return a;
    }

    private static SpannableString b(bv bvVar, String str, String str2) {
        return a(bvVar, 16, str, str2);
    }

    private static SpannableString a(bv bvVar, int i, String str, String str2) {
        return a(bvVar, i, str, str2, 0);
    }

    private static SpannableString Az(String str) {
        int zx;
        String str2;
        a.C0508a zS;
        int width;
        if (str == null || (zx = TbFaceManager.bkj().zx(str)) == 0) {
            return null;
        }
        String zz = TbFaceManager.bkj().zz(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + zz + "]";
            zS = TbFaceManager.bkj().zS("image_emoticon");
        } else {
            str2 = "#(" + zz + ")";
            zS = TbFaceManager.bkj().zS(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), zx);
        if (zS != null) {
            if (str != null && str.startsWith("bearchildren_")) {
                width = (int) (0.25d * zS.getWidth());
            } else {
                width = (int) (0.4d * zS.getWidth());
            }
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    private static void a(bv bvVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a ak;
        com.baidu.adp.widget.ImageView.a ak2;
        BitmapDrawable bitmapDrawable;
        if (bvVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String str2 = bvVar.mUrl;
            String str3 = bvVar.dTB;
            if (!StringUtils.isNull(str2) && !StringUtils.isNull(str2)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bkk().getBitmap(str2);
                if ((bitmap == null || !com.baidu.tbadk.core.util.c.x.aj(str2, 10)) && (ak = com.baidu.tbadk.core.util.c.x.ak(str2, 10)) != null) {
                    bitmap = ak.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bkk().addBitmap(str2, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bkk().getBitmap(str3);
                if ((bitmap2 == null || !com.baidu.tbadk.core.util.c.x.aj(str3, 10)) && (ak2 = com.baidu.tbadk.core.util.c.x.ak(str3, 10)) != null) {
                    bitmap2 = ak2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bkk().addBitmap(str3, bitmap2);
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
                            kVar.setOffset(l.dip2px(TbadkCoreApplication.getInst(), bvVar.dSm));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                com.baidu.adp.lib.e.c.ln().a(str2, 10, eUC, null);
                com.baidu.adp.lib.e.c.ln().a(str3, 10, eUC, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bv bvVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            if (bvVar != null) {
                kVar.type = bvVar.aVZ();
                kVar.ezd = bvVar.aVY();
            }
            com.baidu.tbadk.plugins.b.a(kVar);
            bd.baV().b(tbPageContextSupport.getPageContext(), new String[]{kVar.mLink, kVar.ezd});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(bv bvVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (bvVar != null) {
                ap apVar = new ap("c13564");
                if (bvVar.aYd()) {
                    apVar = new ap("c12352");
                    apVar.ah("obj_source", 1);
                    a(apVar, bvVar);
                } else if (bvVar.dUJ) {
                    apVar.ah("obj_source", 2);
                    if (bvVar.getBaijiahaoData() != null) {
                        apVar.ah("obj_type", bvVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    apVar.ah("obj_source", 3);
                    if (bvVar.getBaijiahaoData() != null) {
                        apVar.ah("obj_type", bvVar.getBaijiahaoData().oriUgcType);
                    }
                }
                apVar.ah("obj_locate", 5);
                TiebaStatic.log(apVar);
            }
        }
    }

    private static void a(ap apVar, bv bvVar) {
        if (bvVar.aUR()) {
            apVar.ah("obj_type", 2);
        } else if (bvVar.isLinkThread()) {
            apVar.ah("obj_type", 4);
        } else if (bvVar.isShareThread) {
            apVar.ah("obj_type", 5);
        } else if (bvVar.aUT()) {
            apVar.ah("obj_type", 6);
        } else if (bvVar.aYg()) {
            apVar.ah("obj_type", 7);
        } else if (bvVar.aUU()) {
            apVar.ah("obj_type", 8);
        } else if (bvVar.aYh()) {
            apVar.ah("obj_type", 9);
        } else if (bvVar.getType() == bv.dRx) {
            apVar.ah("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AA(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            bd.baV().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
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

    public static SpannableStringBuilder bh(List<HeadItem> list) {
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

    public static boolean dw(@NonNull String str, @NonNull String str2) {
        if (as.isEmpty(str) || as.isEmpty(str2)) {
            return false;
        }
        if (bd.baV().j(str2)) {
            if (bd.baV().j(str)) {
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
