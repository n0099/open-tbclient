package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> duc = new HashMap<>();

    static {
        duc.put("#(呵呵)", "image_emoticon");
        duc.put("#(哈哈)", "image_emoticon2");
        duc.put("#(吐舌)", "image_emoticon3");
        duc.put("#(啊)", "image_emoticon4");
        duc.put("#(啊?)", "image_emoticon4");
        duc.put("#(酷)", "image_emoticon5");
        duc.put("#(怒)", "image_emoticon6");
        duc.put("#(开心)", "image_emoticon7");
        duc.put("#(汗)", "image_emoticon8");
        duc.put("#(泪)", "image_emoticon9");
        duc.put("#(黑线)", "image_emoticon10");
        duc.put("#(鄙视)", "image_emoticon11");
        duc.put("#(不高兴)", "image_emoticon12");
        duc.put("#(真棒)", "image_emoticon13");
        duc.put("#(钱)", "image_emoticon14");
        duc.put("#(疑问)", "image_emoticon15");
        duc.put("#(阴险)", "image_emoticon16");
        duc.put("#(吐)", "image_emoticon17");
        duc.put("#(咦)", "image_emoticon18");
        duc.put("#(咦?)", "image_emoticon18");
        duc.put("#(委屈)", "image_emoticon19");
        duc.put("#(花心)", "image_emoticon20");
        duc.put("#(呼~)", "image_emoticon21");
        duc.put("#(笑眼)", "image_emoticon22");
        duc.put("#(冷)", "image_emoticon23");
        duc.put("#(太开心)", "image_emoticon24");
        duc.put("#(滑稽)", "image_emoticon25");
        duc.put("#(勉强)", "image_emoticon26");
        duc.put("#(狂汗)", "image_emoticon27");
        duc.put("#(乖)", "image_emoticon28");
        duc.put("#(睡觉)", "image_emoticon29");
        duc.put("#(惊哭)", "image_emoticon30");
        duc.put("#(升起)", "image_emoticon31");
        duc.put("#(惊讶)", "image_emoticon32");
        duc.put("#(喷)", "image_emoticon33");
        duc.put("#(爱心)", "image_emoticon34");
        duc.put("#(心碎)", "image_emoticon35");
        duc.put("#(玫瑰)", "image_emoticon36");
        duc.put("#(礼物)", "image_emoticon37");
        duc.put("#(彩虹)", "image_emoticon38");
        duc.put("#(星星月亮)", "image_emoticon39");
        duc.put("#(太阳)", "image_emoticon40");
        duc.put("#(钱币)", "image_emoticon41");
        duc.put("#(灯泡)", "image_emoticon42");
        duc.put("#(茶杯)", "image_emoticon43");
        duc.put("#(蛋糕)", "image_emoticon44");
        duc.put("#(音乐)", "image_emoticon45");
        duc.put("#(haha)", "image_emoticon46");
        duc.put("#(胜利)", "image_emoticon47");
        duc.put("#(大拇指)", "image_emoticon48");
        duc.put("#(弱)", "image_emoticon49");
        duc.put("#(OK)", "image_emoticon50");
        duc.put("#(哼)", "image_emoticon61");
        duc.put("#(吃瓜)", "image_emoticon62");
        duc.put("#(扔便便)", "image_emoticon63");
        duc.put("#(惊恐)", "image_emoticon64");
        duc.put("#(哎呦)", "image_emoticon65");
        duc.put("#(小乖)", "image_emoticon66");
        duc.put("#(捂嘴笑)", "image_emoticon67");
        duc.put("#(你懂的)", "image_emoticon68");
        duc.put("#(what)", "image_emoticon69");
        duc.put("#(酸爽)", "image_emoticon70");
        duc.put("#(呀咩爹)", "image_emoticon71");
        duc.put("#(笑尿)", "image_emoticon72");
        duc.put("#(挖鼻)", "image_emoticon73");
        duc.put("#(犀利)", "image_emoticon74");
        duc.put("#(小红脸)", "image_emoticon75");
        duc.put("#(懒得理)", "image_emoticon76");
        duc.put("#(沙发)", "image_emoticon77");
        duc.put("#(手纸)", "image_emoticon78");
        duc.put("#(香蕉)", "image_emoticon79");
        duc.put("#(便便)", "image_emoticon80");
        duc.put("#(药丸)", "image_emoticon81");
        duc.put("#(红领巾)", "image_emoticon82");
        duc.put("#(蜡烛)", "image_emoticon83");
        duc.put("#(三道杠)", "image_emoticon84");
        duc.put("#(赖皮)", "ali_001");
        duc.put("#(感动)", "ali_002");
        duc.put("#(十分惊讶)", "ali_003");
        duc.put("#(怒气)", "ali_004");
        duc.put("#(哭泣)", "ali_005");
        duc.put("#(吃惊)", "ali_006");
        duc.put("#(嘲弄)", "ali_007");
        duc.put("#(飘过)", "ali_008");
        duc.put("#(转圈哭)", "ali_009");
        duc.put("#(神经病)", "ali_010");
        duc.put("#(揪耳朵)", "ali_011");
        duc.put("#(惊汗)", "ali_012");
        duc.put("#(隐身)", "ali_013");
        duc.put("#(不要嘛)", "ali_014");
        duc.put("#(遁)", "ali_015");
        duc.put("#(不公平)", "ali_016");
        duc.put("#(爬来了)", "ali_017");
        duc.put("#(蛋花哭)", "ali_018");
        duc.put("#(温暖)", "ali_019");
        duc.put("#(点头)", "ali_020");
        duc.put("#(撒钱)", "ali_021");
        duc.put("#(献花)", "ali_022");
        duc.put("#(寒)", "ali_023");
        duc.put("#(傻笑)", "ali_024");
        duc.put("#(扭扭)", "ali_025");
        duc.put("#(疯)", "ali_026");
        duc.put("#(抓狂)", "ali_027");
        duc.put("#(抓)", "ali_028");
        duc.put("#(蜷)", "ali_029");
        duc.put("#(挠墙)", "ali_030");
        duc.put("#(狂笑)", "ali_031");
        duc.put("#(抱枕)", "ali_032");
        duc.put("#(吼叫)", "ali_033");
        duc.put("#(嚷)", "ali_034");
        duc.put("#(唠叨)", "ali_035");
        duc.put("#(捏脸)", "ali_036");
        duc.put("#(爆笑)", "ali_037");
        duc.put("#(郁闷)", "ali_038");
        duc.put("#(潜水)", "ali_039");
        duc.put("#(十分开心)", "ali_040");
        duc.put("#(冷笑话)", "ali_041");
        duc.put("#(顶！)", "ali_042");
        duc.put("#(潜)", "ali_043");
        duc.put("#(画圈圈)", "ali_044");
        duc.put("#(玩电脑)", "ali_045");
        duc.put("#(狂吐)", "ali_046");
        duc.put("#(哭着跑)", "ali_047");
        duc.put("#(阿狸侠)", "ali_048");
        duc.put("#(冷死了)", "ali_049");
        duc.put("#(惆怅~)", "ali_050");
        duc.put("#(摸头)", "ali_051");
        duc.put("#(蹭)", "ali_052");
        duc.put("#(打滚)", "ali_053");
        duc.put("#(叩拜)", "ali_054");
        duc.put("#(摸)", "ali_055");
        duc.put("#(数钱)", "ali_056");
        duc.put("#(拖走)", "ali_057");
        duc.put("#(热)", "ali_058");
        duc.put("#(加1)", "ali_059");
        duc.put("#(压力)", "ali_060");
        duc.put("#(表逼我)", "ali_061");
        duc.put("#(人呢)", "ali_062");
        duc.put("#(摇晃)", "ali_063");
        duc.put("#(打地鼠)", "ali_064");
        duc.put("#(这个屌)", "ali_065");
        duc.put("#(恐慌)", "ali_066");
        duc.put("#(晕乎乎)", "ali_067");
        duc.put("#(浮云)", "ali_068");
        duc.put("#(给力)", "ali_069");
        duc.put("#(杯具了)", "ali_070");
        duc.put("#(焦糖舞)", "yz_001");
        duc.put("#(翻滚)", "yz_002");
        duc.put("#(拍屁股做鬼脸)", "yz_003");
        duc.put("#(不)", "yz_004");
        duc.put("#(河蟹掉啦)", "yz_005");
        duc.put("#(哦耶)", "yz_006");
        duc.put("#(我倒)", "yz_007");
        duc.put("#(投降)", "yz_008");
        duc.put("#(微笑)", "b01");
        duc.put("#(帅哥)", "b02");
        duc.put("#(美女)", "b03");
        duc.put("#(老大)", "b04");
        duc.put("#(哈哈哈)", "b05");
        duc.put("#(奸笑)", "b06");
        duc.put("#(傻乐)", "b07");
        duc.put("#(飞吻)", "b08");
        duc.put("#(害羞)", "b09");
        duc.put("#(花痴)", "b10");
        duc.put("#(憧憬)", "b11");
        duc.put("#(你牛)", "b12");
        duc.put("#(鼓掌)", "b13");
        duc.put("#(可爱)", "b14");
        duc.put("#(太委屈)", "b15");
        duc.put("#(大哭)", "b16");
        duc.put("#(泪奔)", "b17");
        duc.put("#(寻死)", "b18");
        duc.put("#(非常惊讶)", "b19");
        duc.put("#(表示疑问)", "b20");
        duc.put("#(暗中观察)", "image_emoticon85");
        duc.put("#(吃瓜)", "image_emoticon86");
        duc.put("#(喝酒)", "image_emoticon87");
        duc.put("#(嘿嘿嘿)", "image_emoticon88");
        duc.put("#(噗)", "image_emoticon89");
        duc.put("#(困成狗)", "image_emoticon90");
        duc.put("#(微微一笑)", "image_emoticon91");
        duc.put("#(托腮)", "image_emoticon92");
        duc.put("#(摊手)", "image_emoticon93");
        duc.put("#(柯基暗中观察)", "image_emoticon94");
        duc.put("#(欢呼)", "image_emoticon95");
        duc.put("#(炸药)", "image_emoticon96");
        duc.put("#(突然兴奋)", "image_emoticon97");
        duc.put("#(紧张)", "image_emoticon98");
        duc.put("#(黑头瞪眼)", "image_emoticon99");
        duc.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return duc.get(str);
    }

    public static List<TbFaceManager.RichUnit> lZ(String str) {
        String str2;
        String str3;
        String str4;
        String str5 = "";
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (true) {
            str2 = str5;
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                int i2 = i + 2;
                String str6 = "#(";
                while (true) {
                    if (i2 >= length) {
                        str3 = str6;
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    str6 = str6 + charAt2;
                    if (charAt2 == ')') {
                        str3 = str6;
                        break;
                    }
                    i2++;
                }
                String name = getName(str3);
                if (TextUtils.isEmpty(name)) {
                    str4 = str2 + str3;
                } else {
                    if (TextUtils.isEmpty(str2)) {
                        str4 = str2;
                    } else {
                        arrayList.add(ma(str2));
                        str4 = "";
                    }
                    arrayList.add(aX(str3, name));
                }
                int i3 = i2;
                str5 = str4;
                i = i3;
            } else {
                str5 = str2 + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(ma(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit ma(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aX(String str, String str2) {
        String substring = str.substring(2, str.length() - 1);
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str2;
        richUnit.type = 2;
        richUnit.c = substring;
        return richUnit;
    }

    public static ArrayList<TbRichTextData> f(Context context, String str, int i) {
        String str2;
        String str3;
        String str4;
        ArrayList<TbRichTextData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        arrayList.add(tbRichTextData);
        try {
            String str5 = "";
            int length = str.length();
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt == '#' && i2 < length - 1 && str.charAt(i2 + 1) == '(') {
                    int i3 = i2 + 2;
                    String str6 = "#(";
                    while (true) {
                        if (i3 >= length) {
                            str3 = str6;
                            break;
                        }
                        char charAt2 = str.charAt(i3);
                        str6 = str6 + charAt2;
                        if (charAt2 != ')') {
                            if (i3 + 1 < length && str.charAt(i3 + 1) == '#') {
                                str3 = str6;
                                break;
                            }
                            i3++;
                        } else {
                            str3 = str6;
                            break;
                        }
                    }
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.append(str5);
                            } else {
                                SpannableString ah = ah(context, str5);
                                if (ah != null) {
                                    tbRichTextData.append(ah);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.IY(), name, str3);
                        if (b != null) {
                            tbRichTextData.append(b);
                        }
                    }
                    int i4 = i3;
                    str2 = str4;
                    i2 = i4;
                } else {
                    str2 = str5 + charAt;
                }
                i2++;
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str5)) {
                if (i == 1) {
                    tbRichTextData.append(str5);
                } else {
                    SpannableString ah2 = ah(context, str5);
                    if (ah2 != null) {
                        tbRichTextData.append(ah2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fG = TbFaceManager.Er().fG(str);
        if (fG != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), fG);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0058a gi = TbFaceManager.Er().gi(str);
            if (gi != null) {
                int width = (int) (0.5d * gi.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ah(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.R(context, str);
    }
}
