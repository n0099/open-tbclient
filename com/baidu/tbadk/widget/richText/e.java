package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.c.w;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private static com.baidu.adp.lib.e.b eDL = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.e.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass4) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bet().addBitmap(str, aVar.getRawBitmap());
            }
        }
    };

    public static int om(int i) {
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

    public static SpannableStringBuilder a(bk bkVar, List<PbContent> list, String str) {
        int size;
        CharSequence a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!v.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a = a(bkVar, pbContent)) != null) {
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

    public static SpannableStringBuilder f(List<PbContent> list, String str) {
        return a((bk) null, list, str);
    }

    public static SpannableStringBuilder aT(List<PbContent> list) {
        return f(list, "");
    }

    public static CharSequence a(bk bkVar, PbContent pbContent) {
        switch (om(pbContent.type.intValue())) {
            case 2:
                return a(bkVar, pbContent.type.intValue(), pbContent.text, pbContent.link);
            case 4:
                return yY(pbContent.text);
            case 16:
                return b(bkVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(bkVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bk bkVar, int i, String str, final String str2, int i2) {
        f fVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = str + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        if (i == 18) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.1
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.a(str2, (bk) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.b(bkVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.yZ(str2);
                }
            };
        }
        fVar.op(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private static SpannableString a(bk bkVar, String str, String str2) {
        SpannableString a = a(bkVar, 18, str, str2);
        a(bkVar, a, a.toString(), 0);
        return a;
    }

    private static SpannableString b(bk bkVar, String str, String str2) {
        return a(bkVar, 16, str, str2);
    }

    private static SpannableString a(bk bkVar, int i, String str, String str2) {
        return a(bkVar, i, str, str2, 0);
    }

    private static SpannableString yY(String str) {
        int xY;
        String str2;
        a.C0490a ys;
        if (str == null || (xY = TbFaceManager.bes().xY(str)) == 0) {
            return null;
        }
        String ya = TbFaceManager.bes().ya(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + ya + "]";
            ys = TbFaceManager.bes().ys("image_emoticon");
        } else {
            str2 = "#(" + ya + ")";
            ys = TbFaceManager.bes().ys(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), xY);
        if (ys != null) {
            int width = (int) (0.4d * ys.getWidth());
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    private static void a(bk bkVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a aj;
        com.baidu.adp.widget.ImageView.a aj2;
        BitmapDrawable bitmapDrawable;
        if (bkVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String str2 = bkVar.mUrl;
            String str3 = bkVar.dGF;
            if (!StringUtils.isNull(str2) && !StringUtils.isNull(str2)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bet().getBitmap(str2);
                if ((bitmap == null || !w.ai(str2, 10)) && (aj = w.aj(str2, 10)) != null) {
                    bitmap = aj.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bet().addBitmap(str2, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bet().getBitmap(str3);
                if ((bitmap2 == null || !w.ai(str3, 10)) && (aj2 = w.aj(str3, 10)) != null) {
                    bitmap2 = aj2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bet().addBitmap(str3, bitmap2);
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
                            kVar.setOffset(l.dip2px(TbadkCoreApplication.getInst(), bkVar.dFq));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                com.baidu.adp.lib.e.c.kX().a(str2, 10, eDL, null);
                com.baidu.adp.lib.e.c.kX().a(str3, 10, eDL, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bk bkVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            if (bkVar != null) {
                kVar.type = bkVar.aQl();
                kVar.ejY = bkVar.aQk();
            }
            com.baidu.tbadk.plugins.b.a(kVar);
            ba.aUZ().b(tbPageContextSupport.getPageContext(), new String[]{kVar.mLink, kVar.ejY});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(bk bkVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (bkVar != null) {
                an anVar = new an("c13564");
                if (bkVar.aSq()) {
                    anVar = new an("c12352");
                    anVar.ag("obj_source", 1);
                    a(anVar, bkVar);
                } else if (bkVar.dHM) {
                    anVar.ag("obj_source", 2);
                    if (bkVar.getBaijiahaoData() != null) {
                        anVar.ag("obj_type", bkVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    anVar.ag("obj_source", 3);
                    if (bkVar.getBaijiahaoData() != null) {
                        anVar.ag("obj_type", bkVar.getBaijiahaoData().oriUgcType);
                    }
                }
                anVar.ag("obj_locate", 5);
                TiebaStatic.log(anVar);
            }
        }
    }

    private static void a(an anVar, bk bkVar) {
        if (bkVar.aPk()) {
            anVar.ag("obj_type", 2);
        } else if (bkVar.isLinkThread()) {
            anVar.ag("obj_type", 4);
        } else if (bkVar.isShareThread) {
            anVar.ag("obj_type", 5);
        } else if (bkVar.aPm()) {
            anVar.ag("obj_type", 6);
        } else if (bkVar.aSv()) {
            anVar.ag("obj_type", 7);
        } else if (bkVar.aPn()) {
            anVar.ag("obj_type", 8);
        } else if (bkVar.aSw()) {
            anVar.ag("obj_type", 9);
        } else if (bkVar.getType() == bk.dEE) {
            anVar.ag("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void yZ(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            ba.aUZ().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static SpannableString on(int i) {
        String string;
        int i2;
        if (i == com.baidu.adp.newwidget.ImageView.b.PI) {
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
        aVar.mn(dimenPixelSize6);
        spannableString.setSpan(aVar, 0, spannableString.length(), 17);
        return spannableString;
    }
}
