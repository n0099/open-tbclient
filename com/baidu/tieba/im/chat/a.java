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
    private static final HashMap<String, String> dtI = new HashMap<>();

    static {
        dtI.put("#(呵呵)", "image_emoticon");
        dtI.put("#(哈哈)", "image_emoticon2");
        dtI.put("#(吐舌)", "image_emoticon3");
        dtI.put("#(啊)", "image_emoticon4");
        dtI.put("#(啊?)", "image_emoticon4");
        dtI.put("#(酷)", "image_emoticon5");
        dtI.put("#(怒)", "image_emoticon6");
        dtI.put("#(开心)", "image_emoticon7");
        dtI.put("#(汗)", "image_emoticon8");
        dtI.put("#(泪)", "image_emoticon9");
        dtI.put("#(黑线)", "image_emoticon10");
        dtI.put("#(鄙视)", "image_emoticon11");
        dtI.put("#(不高兴)", "image_emoticon12");
        dtI.put("#(真棒)", "image_emoticon13");
        dtI.put("#(钱)", "image_emoticon14");
        dtI.put("#(疑问)", "image_emoticon15");
        dtI.put("#(阴险)", "image_emoticon16");
        dtI.put("#(吐)", "image_emoticon17");
        dtI.put("#(咦)", "image_emoticon18");
        dtI.put("#(咦?)", "image_emoticon18");
        dtI.put("#(委屈)", "image_emoticon19");
        dtI.put("#(花心)", "image_emoticon20");
        dtI.put("#(呼~)", "image_emoticon21");
        dtI.put("#(笑眼)", "image_emoticon22");
        dtI.put("#(冷)", "image_emoticon23");
        dtI.put("#(太开心)", "image_emoticon24");
        dtI.put("#(滑稽)", "image_emoticon25");
        dtI.put("#(勉强)", "image_emoticon26");
        dtI.put("#(狂汗)", "image_emoticon27");
        dtI.put("#(乖)", "image_emoticon28");
        dtI.put("#(睡觉)", "image_emoticon29");
        dtI.put("#(惊哭)", "image_emoticon30");
        dtI.put("#(升起)", "image_emoticon31");
        dtI.put("#(惊讶)", "image_emoticon32");
        dtI.put("#(喷)", "image_emoticon33");
        dtI.put("#(爱心)", "image_emoticon34");
        dtI.put("#(心碎)", "image_emoticon35");
        dtI.put("#(玫瑰)", "image_emoticon36");
        dtI.put("#(礼物)", "image_emoticon37");
        dtI.put("#(彩虹)", "image_emoticon38");
        dtI.put("#(星星月亮)", "image_emoticon39");
        dtI.put("#(太阳)", "image_emoticon40");
        dtI.put("#(钱币)", "image_emoticon41");
        dtI.put("#(灯泡)", "image_emoticon42");
        dtI.put("#(茶杯)", "image_emoticon43");
        dtI.put("#(蛋糕)", "image_emoticon44");
        dtI.put("#(音乐)", "image_emoticon45");
        dtI.put("#(haha)", "image_emoticon46");
        dtI.put("#(胜利)", "image_emoticon47");
        dtI.put("#(大拇指)", "image_emoticon48");
        dtI.put("#(弱)", "image_emoticon49");
        dtI.put("#(OK)", "image_emoticon50");
        dtI.put("#(哼)", "image_emoticon61");
        dtI.put("#(吃瓜)", "image_emoticon62");
        dtI.put("#(扔便便)", "image_emoticon63");
        dtI.put("#(惊恐)", "image_emoticon64");
        dtI.put("#(哎呦)", "image_emoticon65");
        dtI.put("#(小乖)", "image_emoticon66");
        dtI.put("#(捂嘴笑)", "image_emoticon67");
        dtI.put("#(你懂的)", "image_emoticon68");
        dtI.put("#(what)", "image_emoticon69");
        dtI.put("#(酸爽)", "image_emoticon70");
        dtI.put("#(呀咩爹)", "image_emoticon71");
        dtI.put("#(笑尿)", "image_emoticon72");
        dtI.put("#(挖鼻)", "image_emoticon73");
        dtI.put("#(犀利)", "image_emoticon74");
        dtI.put("#(小红脸)", "image_emoticon75");
        dtI.put("#(懒得理)", "image_emoticon76");
        dtI.put("#(沙发)", "image_emoticon77");
        dtI.put("#(手纸)", "image_emoticon78");
        dtI.put("#(香蕉)", "image_emoticon79");
        dtI.put("#(便便)", "image_emoticon80");
        dtI.put("#(药丸)", "image_emoticon81");
        dtI.put("#(红领巾)", "image_emoticon82");
        dtI.put("#(蜡烛)", "image_emoticon83");
        dtI.put("#(三道杠)", "image_emoticon84");
        dtI.put("#(赖皮)", "ali_001");
        dtI.put("#(感动)", "ali_002");
        dtI.put("#(十分惊讶)", "ali_003");
        dtI.put("#(怒气)", "ali_004");
        dtI.put("#(哭泣)", "ali_005");
        dtI.put("#(吃惊)", "ali_006");
        dtI.put("#(嘲弄)", "ali_007");
        dtI.put("#(飘过)", "ali_008");
        dtI.put("#(转圈哭)", "ali_009");
        dtI.put("#(神经病)", "ali_010");
        dtI.put("#(揪耳朵)", "ali_011");
        dtI.put("#(惊汗)", "ali_012");
        dtI.put("#(隐身)", "ali_013");
        dtI.put("#(不要嘛)", "ali_014");
        dtI.put("#(遁)", "ali_015");
        dtI.put("#(不公平)", "ali_016");
        dtI.put("#(爬来了)", "ali_017");
        dtI.put("#(蛋花哭)", "ali_018");
        dtI.put("#(温暖)", "ali_019");
        dtI.put("#(点头)", "ali_020");
        dtI.put("#(撒钱)", "ali_021");
        dtI.put("#(献花)", "ali_022");
        dtI.put("#(寒)", "ali_023");
        dtI.put("#(傻笑)", "ali_024");
        dtI.put("#(扭扭)", "ali_025");
        dtI.put("#(疯)", "ali_026");
        dtI.put("#(抓狂)", "ali_027");
        dtI.put("#(抓)", "ali_028");
        dtI.put("#(蜷)", "ali_029");
        dtI.put("#(挠墙)", "ali_030");
        dtI.put("#(狂笑)", "ali_031");
        dtI.put("#(抱枕)", "ali_032");
        dtI.put("#(吼叫)", "ali_033");
        dtI.put("#(嚷)", "ali_034");
        dtI.put("#(唠叨)", "ali_035");
        dtI.put("#(捏脸)", "ali_036");
        dtI.put("#(爆笑)", "ali_037");
        dtI.put("#(郁闷)", "ali_038");
        dtI.put("#(潜水)", "ali_039");
        dtI.put("#(十分开心)", "ali_040");
        dtI.put("#(冷笑话)", "ali_041");
        dtI.put("#(顶！)", "ali_042");
        dtI.put("#(潜)", "ali_043");
        dtI.put("#(画圈圈)", "ali_044");
        dtI.put("#(玩电脑)", "ali_045");
        dtI.put("#(狂吐)", "ali_046");
        dtI.put("#(哭着跑)", "ali_047");
        dtI.put("#(阿狸侠)", "ali_048");
        dtI.put("#(冷死了)", "ali_049");
        dtI.put("#(惆怅~)", "ali_050");
        dtI.put("#(摸头)", "ali_051");
        dtI.put("#(蹭)", "ali_052");
        dtI.put("#(打滚)", "ali_053");
        dtI.put("#(叩拜)", "ali_054");
        dtI.put("#(摸)", "ali_055");
        dtI.put("#(数钱)", "ali_056");
        dtI.put("#(拖走)", "ali_057");
        dtI.put("#(热)", "ali_058");
        dtI.put("#(加1)", "ali_059");
        dtI.put("#(压力)", "ali_060");
        dtI.put("#(表逼我)", "ali_061");
        dtI.put("#(人呢)", "ali_062");
        dtI.put("#(摇晃)", "ali_063");
        dtI.put("#(打地鼠)", "ali_064");
        dtI.put("#(这个屌)", "ali_065");
        dtI.put("#(恐慌)", "ali_066");
        dtI.put("#(晕乎乎)", "ali_067");
        dtI.put("#(浮云)", "ali_068");
        dtI.put("#(给力)", "ali_069");
        dtI.put("#(杯具了)", "ali_070");
        dtI.put("#(焦糖舞)", "yz_001");
        dtI.put("#(翻滚)", "yz_002");
        dtI.put("#(拍屁股做鬼脸)", "yz_003");
        dtI.put("#(不)", "yz_004");
        dtI.put("#(河蟹掉啦)", "yz_005");
        dtI.put("#(哦耶)", "yz_006");
        dtI.put("#(我倒)", "yz_007");
        dtI.put("#(投降)", "yz_008");
        dtI.put("#(微笑)", "b01");
        dtI.put("#(帅哥)", "b02");
        dtI.put("#(美女)", "b03");
        dtI.put("#(老大)", "b04");
        dtI.put("#(哈哈哈)", "b05");
        dtI.put("#(奸笑)", "b06");
        dtI.put("#(傻乐)", "b07");
        dtI.put("#(飞吻)", "b08");
        dtI.put("#(害羞)", "b09");
        dtI.put("#(花痴)", "b10");
        dtI.put("#(憧憬)", "b11");
        dtI.put("#(你牛)", "b12");
        dtI.put("#(鼓掌)", "b13");
        dtI.put("#(可爱)", "b14");
        dtI.put("#(太委屈)", "b15");
        dtI.put("#(大哭)", "b16");
        dtI.put("#(泪奔)", "b17");
        dtI.put("#(寻死)", "b18");
        dtI.put("#(非常惊讶)", "b19");
        dtI.put("#(表示疑问)", "b20");
        dtI.put("#(暗中观察)", "image_emoticon85");
        dtI.put("#(吃瓜)", "image_emoticon86");
        dtI.put("#(喝酒)", "image_emoticon87");
        dtI.put("#(嘿嘿嘿)", "image_emoticon88");
        dtI.put("#(噗)", "image_emoticon89");
        dtI.put("#(困成狗)", "image_emoticon90");
        dtI.put("#(微微一笑)", "image_emoticon91");
        dtI.put("#(托腮)", "image_emoticon92");
        dtI.put("#(摊手)", "image_emoticon93");
        dtI.put("#(柯基暗中观察)", "image_emoticon94");
        dtI.put("#(欢呼)", "image_emoticon95");
        dtI.put("#(炸药)", "image_emoticon96");
        dtI.put("#(突然兴奋)", "image_emoticon97");
        dtI.put("#(紧张)", "image_emoticon98");
        dtI.put("#(黑头瞪眼)", "image_emoticon99");
        dtI.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dtI.get(str);
    }

    public static List<TbFaceManager.RichUnit> lX(String str) {
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
                        arrayList.add(lY(str2));
                        str4 = "";
                    }
                    arrayList.add(aW(str3, name));
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
            arrayList.add(lY(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lY(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aW(String str, String str2) {
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
                        SpannableString b = b(tbRichTextData.IN(), name, str3);
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
        int fF = TbFaceManager.Ef().fF(str);
        if (fF != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), fF);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0058a gh = TbFaceManager.Ef().gh(str);
            if (gh != null) {
                int width = (int) (0.5d * gh.getWidth());
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
