package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private static final HashMap<String, String> cLU = new HashMap<>();

    static {
        cLU.put("#(呵呵)", "image_emoticon");
        cLU.put("#(哈哈)", "image_emoticon2");
        cLU.put("#(吐舌)", "image_emoticon3");
        cLU.put("#(啊)", "image_emoticon4");
        cLU.put("#(啊?)", "image_emoticon4");
        cLU.put("#(酷)", "image_emoticon5");
        cLU.put("#(怒)", "image_emoticon6");
        cLU.put("#(开心)", "image_emoticon7");
        cLU.put("#(汗)", "image_emoticon8");
        cLU.put("#(泪)", "image_emoticon9");
        cLU.put("#(黑线)", "image_emoticon10");
        cLU.put("#(鄙视)", "image_emoticon11");
        cLU.put("#(不高兴)", "image_emoticon12");
        cLU.put("#(真棒)", "image_emoticon13");
        cLU.put("#(钱)", "image_emoticon14");
        cLU.put("#(疑问)", "image_emoticon15");
        cLU.put("#(阴险)", "image_emoticon16");
        cLU.put("#(吐)", "image_emoticon17");
        cLU.put("#(咦)", "image_emoticon18");
        cLU.put("#(咦?)", "image_emoticon18");
        cLU.put("#(委屈)", "image_emoticon19");
        cLU.put("#(花心)", "image_emoticon20");
        cLU.put("#(呼~)", "image_emoticon21");
        cLU.put("#(笑眼)", "image_emoticon22");
        cLU.put("#(冷)", "image_emoticon23");
        cLU.put("#(太开心)", "image_emoticon24");
        cLU.put("#(滑稽)", "image_emoticon25");
        cLU.put("#(勉强)", "image_emoticon26");
        cLU.put("#(狂汗)", "image_emoticon27");
        cLU.put("#(乖)", "image_emoticon28");
        cLU.put("#(睡觉)", "image_emoticon29");
        cLU.put("#(惊哭)", "image_emoticon30");
        cLU.put("#(升起)", "image_emoticon31");
        cLU.put("#(惊讶)", "image_emoticon32");
        cLU.put("#(喷)", "image_emoticon33");
        cLU.put("#(爱心)", "image_emoticon34");
        cLU.put("#(心碎)", "image_emoticon35");
        cLU.put("#(玫瑰)", "image_emoticon36");
        cLU.put("#(礼物)", "image_emoticon37");
        cLU.put("#(彩虹)", "image_emoticon38");
        cLU.put("#(星星月亮)", "image_emoticon39");
        cLU.put("#(太阳)", "image_emoticon40");
        cLU.put("#(钱币)", "image_emoticon41");
        cLU.put("#(灯泡)", "image_emoticon42");
        cLU.put("#(茶杯)", "image_emoticon43");
        cLU.put("#(蛋糕)", "image_emoticon44");
        cLU.put("#(音乐)", "image_emoticon45");
        cLU.put("#(haha)", "image_emoticon46");
        cLU.put("#(胜利)", "image_emoticon47");
        cLU.put("#(大拇指)", "image_emoticon48");
        cLU.put("#(弱)", "image_emoticon49");
        cLU.put("#(OK)", "image_emoticon50");
        cLU.put("#(哼)", "image_emoticon61");
        cLU.put("#(吃瓜)", "image_emoticon62");
        cLU.put("#(扔便便)", "image_emoticon63");
        cLU.put("#(惊恐)", "image_emoticon64");
        cLU.put("#(哎呦)", "image_emoticon65");
        cLU.put("#(小乖)", "image_emoticon66");
        cLU.put("#(捂嘴笑)", "image_emoticon67");
        cLU.put("#(你懂的)", "image_emoticon68");
        cLU.put("#(what)", "image_emoticon69");
        cLU.put("#(酸爽)", "image_emoticon70");
        cLU.put("#(呀咩爹)", "image_emoticon71");
        cLU.put("#(笑尿)", "image_emoticon72");
        cLU.put("#(挖鼻)", "image_emoticon73");
        cLU.put("#(犀利)", "image_emoticon74");
        cLU.put("#(小红脸)", "image_emoticon75");
        cLU.put("#(懒得理)", "image_emoticon76");
        cLU.put("#(沙发)", "image_emoticon77");
        cLU.put("#(手纸)", "image_emoticon78");
        cLU.put("#(香蕉)", "image_emoticon79");
        cLU.put("#(便便)", "image_emoticon80");
        cLU.put("#(药丸)", "image_emoticon81");
        cLU.put("#(红领巾)", "image_emoticon82");
        cLU.put("#(蜡烛)", "image_emoticon83");
        cLU.put("#(三道杠)", "image_emoticon84");
        cLU.put("#(赖皮)", "ali_001");
        cLU.put("#(感动)", "ali_002");
        cLU.put("#(十分惊讶)", "ali_003");
        cLU.put("#(怒气)", "ali_004");
        cLU.put("#(哭泣)", "ali_005");
        cLU.put("#(吃惊)", "ali_006");
        cLU.put("#(嘲弄)", "ali_007");
        cLU.put("#(飘过)", "ali_008");
        cLU.put("#(转圈哭)", "ali_009");
        cLU.put("#(神经病)", "ali_010");
        cLU.put("#(揪耳朵)", "ali_011");
        cLU.put("#(惊汗)", "ali_012");
        cLU.put("#(隐身)", "ali_013");
        cLU.put("#(不要嘛)", "ali_014");
        cLU.put("#(遁)", "ali_015");
        cLU.put("#(不公平)", "ali_016");
        cLU.put("#(爬来了)", "ali_017");
        cLU.put("#(蛋花哭)", "ali_018");
        cLU.put("#(温暖)", "ali_019");
        cLU.put("#(点头)", "ali_020");
        cLU.put("#(撒钱)", "ali_021");
        cLU.put("#(献花)", "ali_022");
        cLU.put("#(寒)", "ali_023");
        cLU.put("#(傻笑)", "ali_024");
        cLU.put("#(扭扭)", "ali_025");
        cLU.put("#(疯)", "ali_026");
        cLU.put("#(抓狂)", "ali_027");
        cLU.put("#(抓)", "ali_028");
        cLU.put("#(蜷)", "ali_029");
        cLU.put("#(挠墙)", "ali_030");
        cLU.put("#(狂笑)", "ali_031");
        cLU.put("#(抱枕)", "ali_032");
        cLU.put("#(吼叫)", "ali_033");
        cLU.put("#(嚷)", "ali_034");
        cLU.put("#(唠叨)", "ali_035");
        cLU.put("#(捏脸)", "ali_036");
        cLU.put("#(爆笑)", "ali_037");
        cLU.put("#(郁闷)", "ali_038");
        cLU.put("#(潜水)", "ali_039");
        cLU.put("#(十分开心)", "ali_040");
        cLU.put("#(冷笑话)", "ali_041");
        cLU.put("#(顶！)", "ali_042");
        cLU.put("#(潜)", "ali_043");
        cLU.put("#(画圈圈)", "ali_044");
        cLU.put("#(玩电脑)", "ali_045");
        cLU.put("#(狂吐)", "ali_046");
        cLU.put("#(哭着跑)", "ali_047");
        cLU.put("#(阿狸侠)", "ali_048");
        cLU.put("#(冷死了)", "ali_049");
        cLU.put("#(惆怅~)", "ali_050");
        cLU.put("#(摸头)", "ali_051");
        cLU.put("#(蹭)", "ali_052");
        cLU.put("#(打滚)", "ali_053");
        cLU.put("#(叩拜)", "ali_054");
        cLU.put("#(摸)", "ali_055");
        cLU.put("#(数钱)", "ali_056");
        cLU.put("#(拖走)", "ali_057");
        cLU.put("#(热)", "ali_058");
        cLU.put("#(加1)", "ali_059");
        cLU.put("#(压力)", "ali_060");
        cLU.put("#(表逼我)", "ali_061");
        cLU.put("#(人呢)", "ali_062");
        cLU.put("#(摇晃)", "ali_063");
        cLU.put("#(打地鼠)", "ali_064");
        cLU.put("#(这个屌)", "ali_065");
        cLU.put("#(恐慌)", "ali_066");
        cLU.put("#(晕乎乎)", "ali_067");
        cLU.put("#(浮云)", "ali_068");
        cLU.put("#(给力)", "ali_069");
        cLU.put("#(杯具了)", "ali_070");
        cLU.put("#(焦糖舞)", "yz_001");
        cLU.put("#(翻滚)", "yz_002");
        cLU.put("#(拍屁股做鬼脸)", "yz_003");
        cLU.put("#(不)", "yz_004");
        cLU.put("#(河蟹掉啦)", "yz_005");
        cLU.put("#(哦耶)", "yz_006");
        cLU.put("#(我倒)", "yz_007");
        cLU.put("#(投降)", "yz_008");
        cLU.put("#(微笑)", "b01");
        cLU.put("#(帅哥)", "b02");
        cLU.put("#(美女)", "b03");
        cLU.put("#(老大)", "b04");
        cLU.put("#(哈哈哈)", "b05");
        cLU.put("#(奸笑)", "b06");
        cLU.put("#(傻乐)", "b07");
        cLU.put("#(飞吻)", "b08");
        cLU.put("#(害羞)", "b09");
        cLU.put("#(花痴)", "b10");
        cLU.put("#(憧憬)", "b11");
        cLU.put("#(你牛)", "b12");
        cLU.put("#(鼓掌)", "b13");
        cLU.put("#(可爱)", "b14");
        cLU.put("#(太委屈)", "b15");
        cLU.put("#(大哭)", "b16");
        cLU.put("#(泪奔)", "b17");
        cLU.put("#(寻死)", "b18");
        cLU.put("#(非常惊讶)", "b19");
        cLU.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cLU.get(str);
    }

    public static List<TbFaceManager.RichUnit> kk(String str) {
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                String str3 = "#(";
                i += 2;
                while (i < length) {
                    char charAt2 = str.charAt(i);
                    str3 = String.valueOf(str3) + charAt2;
                    if (charAt2 == ')') {
                        break;
                    }
                    i++;
                }
                String name = getName(str3);
                if (TextUtils.isEmpty(name)) {
                    str2 = String.valueOf(str2) + str3;
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(kl(str2));
                        str2 = "";
                    }
                    arrayList.add(bd(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(kl(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit kl(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit bd(String str, String str2) {
        String substring = str.substring(2, str.length() - 1);
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str2;
        richUnit.type = 2;
        richUnit.c = substring;
        return richUnit;
    }

    public static ArrayList<TbRichTextData> b(Context context, String str, int i) {
        ArrayList<TbRichTextData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        arrayList.add(tbRichTextData);
        try {
            String str2 = "";
            int length = str.length();
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt == '#' && i2 < length - 1 && str.charAt(i2 + 1) == '(') {
                    String str3 = "#(";
                    i2 += 2;
                    while (i2 < length) {
                        char charAt2 = str.charAt(i2);
                        str3 = String.valueOf(str3) + charAt2;
                        if (charAt2 == ')' || (i2 + 1 < length && str.charAt(i2 + 1) == '#')) {
                            break;
                        }
                        i2++;
                    }
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str2 = String.valueOf(str2) + str3;
                    } else {
                        if (!TextUtils.isEmpty(str2)) {
                            if (i == 1) {
                                tbRichTextData.append(str2);
                            } else {
                                SpannableString P = P(context, str2);
                                if (P != null) {
                                    tbRichTextData.append(P);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(tbRichTextData.Hu(), name, str3);
                        if (a != null) {
                            tbRichTextData.append(a);
                        }
                    }
                } else {
                    str2 = String.valueOf(str2) + charAt;
                }
                i2++;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (i == 1) {
                    tbRichTextData.append(str2);
                } else {
                    SpannableString P2 = P(context, str2);
                    if (P2 != null) {
                        tbRichTextData.append(P2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.a> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fn = TbFaceManager.DR().fn(str);
        if (fn != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.m9getInst(), fn);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0044a fP = TbFaceManager.DR().fP(str);
            if (fP != null) {
                int width = (int) (0.5d * fP.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(aVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString P(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.ba.x(context, str);
    }
}
