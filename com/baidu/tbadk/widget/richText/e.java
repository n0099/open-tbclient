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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.c.w;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class e {
    private static com.baidu.adp.lib.e.b dPl = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.e.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass4) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.aPV().addBitmap(str, aVar.getRawBitmap());
            }
        }
    };

    public static int nw(int i) {
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

    public static SpannableStringBuilder a(bj bjVar, List<PbContent> list, String str) {
        int size;
        CharSequence a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!v.isEmpty(list)) {
            if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (a = a(bjVar, pbContent)) != null) {
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
        return a((bj) null, list, str);
    }

    public static SpannableStringBuilder aO(List<PbContent> list) {
        return f(list, "");
    }

    public static CharSequence a(bj bjVar, PbContent pbContent) {
        switch (nw(pbContent.type.intValue())) {
            case 2:
                return a(bjVar, pbContent.type.intValue(), pbContent.text, pbContent.link);
            case 4:
                return wd(pbContent.text);
            case 16:
                return b(bjVar, pbContent.text, String.valueOf(pbContent.uid));
            case 18:
                return a(bjVar, pbContent.text, pbContent.link);
            default:
                return new SpannableString(pbContent.text != null ? pbContent.text : "");
        }
    }

    private static SpannableString a(final bj bjVar, int i, String str, final String str2, int i2) {
        f fVar;
        if (str == null) {
            return null;
        }
        if (!str.endsWith(HanziToPinyin.Token.SEPARATOR)) {
            str = str + HanziToPinyin.Token.SEPARATOR;
        }
        SpannableString spannableString = new SpannableString(str);
        if (i == 18) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.1
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.a(str2, (bj) null);
                }
            };
        } else if (i == 16) {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.2
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.b(bjVar, str2);
                }
            };
        } else {
            fVar = new f(i, str2) { // from class: com.baidu.tbadk.widget.richText.e.3
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    e.we(str2);
                }
            };
        }
        fVar.ny(i2);
        if (i2 == 1) {
            fVar.setTextColor(R.color.cp_cont_d);
        } else {
            fVar.setTextColor(-1);
        }
        spannableString.setSpan(fVar, 0, str.length() - 1, 33);
        return spannableString;
    }

    private static SpannableString a(bj bjVar, String str, String str2) {
        SpannableString a = a(bjVar, 18, str, str2);
        a(bjVar, a, a.toString(), 0);
        return a;
    }

    private static SpannableString b(bj bjVar, String str, String str2) {
        return a(bjVar, 16, str, str2);
    }

    private static SpannableString a(bj bjVar, int i, String str, String str2) {
        return a(bjVar, i, str, str2, 0);
    }

    private static SpannableString wd(String str) {
        int vc;
        String str2;
        a.C0391a vv;
        if (str == null || (vc = TbFaceManager.aPU().vc(str)) == 0) {
            return null;
        }
        String ve = TbFaceManager.aPU().ve(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + ve + "]";
            vv = TbFaceManager.aPU().vv("image_emoticon");
        } else {
            str2 = "#(" + ve + ")";
            vv = TbFaceManager.aPU().vv(str);
        }
        SpannableString spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
        d dVar = new d(TbadkCoreApplication.getInst().getContext(), vc);
        if (vv != null) {
            int width = (int) (0.4d * vv.getWidth());
            dVar.setBounds(new Rect(0, 0, width, width));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new com.baidu.tbadk.widget.a(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    private static void a(bj bjVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a aa;
        com.baidu.adp.widget.ImageView.a aa2;
        BitmapDrawable bitmapDrawable;
        if (bjVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String str2 = bjVar.mUrl;
            String str3 = bjVar.cTx;
            if (!StringUtils.isNull(str2) && !StringUtils.isNull(str2)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.aPV().getBitmap(str2);
                if ((bitmap == null || !w.Z(str2, 10)) && (aa = w.aa(str2, 10)) != null) {
                    bitmap = aa.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.aPV().addBitmap(str2, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.aPV().getBitmap(str3);
                if ((bitmap2 == null || !w.Z(str3, 10)) && (aa2 = w.aa(str3, 10)) != null) {
                    bitmap2 = aa2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.aPV().addBitmap(str3, bitmap2);
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
                            l lVar = new l(bitmapDrawable);
                            lVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), bjVar.cSi));
                            spannableString.setSpan(lVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                com.baidu.adp.lib.e.c.gr().a(str2, 10, dPl, null);
                com.baidu.adp.lib.e.c.gr().a(str3, 10, dPl, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, bj bjVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.mLink = str;
            if (bjVar != null) {
                lVar.type = bjVar.aCf();
                lVar.dwd = bjVar.aCe();
            }
            com.baidu.tbadk.plugins.b.a(lVar);
            ba.aGK().b(tbPageContextSupport.getPageContext(), new String[]{lVar.mLink, lVar.dwd});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(bj bjVar, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (bjVar != null) {
                an anVar = new an("c13564");
                if (bjVar.aEf()) {
                    anVar = new an("c12352");
                    anVar.X("obj_source", 1);
                    a(anVar, bjVar);
                } else if (bjVar.cUF) {
                    anVar.X("obj_source", 2);
                    if (bjVar.getBaijiahaoData() != null) {
                        anVar.X("obj_type", bjVar.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    anVar.X("obj_source", 3);
                    if (bjVar.getBaijiahaoData() != null) {
                        anVar.X("obj_type", bjVar.getBaijiahaoData().oriUgcType);
                    }
                }
                anVar.X("obj_locate", 5);
                TiebaStatic.log(anVar);
            }
        }
    }

    private static void a(an anVar, bj bjVar) {
        if (bjVar.aBe()) {
            anVar.X("obj_type", 2);
        } else if (bjVar.isLinkThread()) {
            anVar.X("obj_type", 4);
        } else if (bjVar.isShareThread) {
            anVar.X("obj_type", 5);
        } else if (bjVar.aBg()) {
            anVar.X("obj_type", 6);
        } else if (bjVar.aEk()) {
            anVar.X("obj_type", 7);
        } else if (bjVar.aBh()) {
            anVar.X("obj_type", 8);
        } else if (bjVar.aEl()) {
            anVar.X("obj_type", 9);
        } else if (bjVar.getType() == bj.cRx) {
            anVar.X("obj_type", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void we(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            ba.aGK().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }
}
