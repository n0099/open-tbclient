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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.c.x;
import com.baidu.tbadk.core.util.y;
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
    private static com.baidu.adp.lib.e.b fIH = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.e.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass4) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bBd().addBitmap(str, aVar.getRawBitmap());
            }
        }
    };

    public static int sA(int i) {
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

    public static SpannableStringBuilder a(bw bwVar, List<PbContent> list, String str) {
        int size;
        CharSequence a2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!y.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a2 = a(bwVar, pbContent)) != null) {
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

    public static SpannableStringBuilder h(List<PbContent> list, String str) {
        return a((bw) null, list, str);
    }

    public static SpannableStringBuilder bE(List<PbContent> list) {
        return h(list, "");
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
                        CharSequence a2 = a((bw) null, pbContent);
                        if (i != 0 || list2 == null) {
                            spannableStringBuilder = null;
                            z = true;
                        } else {
                            SpannableStringBuilder bF = bF(list2);
                            if (sA(pbContent.type.intValue()) == 16) {
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

    public static CharSequence a(bw bwVar, PbContent pbContent) {
        switch (sA(pbContent.type.intValue())) {
            case 2:
                return a(bwVar, 2, pbContent.text, pbContent.link);
            case 4:
                return EF(pbContent.text);
            case 16:
                return b(bwVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(bwVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bw bwVar, int i, String str, final String str2, int i2) {
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
                    e.a(str2, (bw) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.i(bwVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.EG(str2);
                }
            };
        }
        fVar.sC(i2);
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

    private static SpannableString a(bw bwVar, String str, String str2) {
        SpannableString a2 = a(bwVar, 18, str, str2);
        a(bwVar, a2, a2.toString(), 0);
        return a2;
    }

    private static SpannableString b(bw bwVar, String str, String str2) {
        return a(bwVar, 16, str, str2);
    }

    private static SpannableString a(bw bwVar, int i, String str, String str2) {
        return a(bwVar, i, str, str2, 0);
    }

    private static SpannableString EF(String str) {
        int DD;
        String str2;
        a.C0593a DY;
        int width;
        if (str == null || (DD = TbFaceManager.bBc().DD(str)) == 0) {
            return null;
        }
        String DF = TbFaceManager.bBc().DF(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + DF + "]";
            DY = TbFaceManager.bBc().DY("image_emoticon");
        } else {
            str2 = "#(" + DF + ")";
            DY = TbFaceManager.bBc().DY(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), DD);
        if (DY != null) {
            if (str != null && str.startsWith("bearchildren_")) {
                width = (int) (0.25d * DY.getWidth());
            } else {
                width = (int) (0.4d * DY.getWidth());
            }
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    private static void a(bw bwVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a ao;
        com.baidu.adp.widget.ImageView.a ao2;
        BitmapDrawable bitmapDrawable;
        if (bwVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String str2 = bwVar.mUrl;
            String str3 = bwVar.eFG;
            if (!StringUtils.isNull(str2) && !StringUtils.isNull(str2)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bBd().getBitmap(str2);
                if ((bitmap == null || !x.an(str2, 10)) && (ao = x.ao(str2, 10)) != null) {
                    bitmap = ao.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bBd().addBitmap(str2, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bBd().getBitmap(str3);
                if ((bitmap2 == null || !x.an(str3, 10)) && (ao2 = x.ao(str3, 10)) != null) {
                    bitmap2 = ao2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bBd().addBitmap(str3, bitmap2);
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
                            kVar.setOffset(l.dip2px(TbadkCoreApplication.getInst(), bwVar.eEr));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                com.baidu.adp.lib.e.c.mS().a(str2, 10, fIH, null);
                com.baidu.adp.lib.e.c.mS().a(str3, 10, fIH, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bw bwVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            if (bwVar != null) {
                lVar.type = bwVar.bmo();
                lVar.fmn = bwVar.bmn();
            }
            com.baidu.tbadk.plugins.b.a(lVar);
            be.brr().b(tbPageContextSupport.getPageContext(), new String[]{lVar.mLink, lVar.fmn});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(bw bwVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (bwVar != null) {
                aq aqVar = new aq("c13564");
                if (bwVar.bos()) {
                    aqVar = new aq("c12352");
                    aqVar.al("obj_source", 1);
                    a(aqVar, bwVar);
                } else if (bwVar.eGO) {
                    aqVar.al("obj_source", 2);
                    if (bwVar.getBaijiahaoData() != null) {
                        aqVar.al("obj_type", bwVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    aqVar.al("obj_source", 3);
                    if (bwVar.getBaijiahaoData() != null) {
                        aqVar.al("obj_type", bwVar.getBaijiahaoData().oriUgcType);
                    }
                }
                aqVar.al("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        }
    }

    private static void a(aq aqVar, bw bwVar) {
        if (bwVar.blg()) {
            aqVar.al("obj_type", 2);
        } else if (bwVar.isLinkThread()) {
            aqVar.al("obj_type", 4);
        } else if (bwVar.isShareThread) {
            aqVar.al("obj_type", 5);
        } else if (bwVar.bli()) {
            aqVar.al("obj_type", 6);
        } else if (bwVar.bov()) {
            aqVar.al("obj_type", 7);
        } else if (bwVar.blj()) {
            aqVar.al("obj_type", 8);
        } else if (bwVar.bow()) {
            aqVar.al("obj_type", 9);
        } else if (bwVar.getType() == bw.eDA) {
            aqVar.al("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void EG(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            be.brr().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
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
        if (at.isEmpty(str) || at.isEmpty(str2)) {
            return false;
        }
        if (be.brr().k(str2)) {
            if (be.brr().k(str)) {
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
