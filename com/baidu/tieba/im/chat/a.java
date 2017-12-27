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
    private static final HashMap<String, String> epa = new HashMap<>();

    static {
        epa.put("#(呵呵)", "image_emoticon");
        epa.put("#(哈哈)", "image_emoticon2");
        epa.put("#(吐舌)", "image_emoticon3");
        epa.put("#(啊)", "image_emoticon4");
        epa.put("#(啊?)", "image_emoticon4");
        epa.put("#(酷)", "image_emoticon5");
        epa.put("#(怒)", "image_emoticon6");
        epa.put("#(开心)", "image_emoticon7");
        epa.put("#(汗)", "image_emoticon8");
        epa.put("#(泪)", "image_emoticon9");
        epa.put("#(黑线)", "image_emoticon10");
        epa.put("#(鄙视)", "image_emoticon11");
        epa.put("#(不高兴)", "image_emoticon12");
        epa.put("#(真棒)", "image_emoticon13");
        epa.put("#(钱)", "image_emoticon14");
        epa.put("#(疑问)", "image_emoticon15");
        epa.put("#(阴险)", "image_emoticon16");
        epa.put("#(吐)", "image_emoticon17");
        epa.put("#(咦)", "image_emoticon18");
        epa.put("#(咦?)", "image_emoticon18");
        epa.put("#(委屈)", "image_emoticon19");
        epa.put("#(花心)", "image_emoticon20");
        epa.put("#(呼~)", "image_emoticon21");
        epa.put("#(笑眼)", "image_emoticon22");
        epa.put("#(冷)", "image_emoticon23");
        epa.put("#(太开心)", "image_emoticon24");
        epa.put("#(滑稽)", "image_emoticon25");
        epa.put("#(勉强)", "image_emoticon26");
        epa.put("#(狂汗)", "image_emoticon27");
        epa.put("#(乖)", "image_emoticon28");
        epa.put("#(睡觉)", "image_emoticon29");
        epa.put("#(惊哭)", "image_emoticon30");
        epa.put("#(升起)", "image_emoticon31");
        epa.put("#(惊讶)", "image_emoticon32");
        epa.put("#(喷)", "image_emoticon33");
        epa.put("#(爱心)", "image_emoticon34");
        epa.put("#(心碎)", "image_emoticon35");
        epa.put("#(玫瑰)", "image_emoticon36");
        epa.put("#(礼物)", "image_emoticon37");
        epa.put("#(彩虹)", "image_emoticon38");
        epa.put("#(星星月亮)", "image_emoticon39");
        epa.put("#(太阳)", "image_emoticon40");
        epa.put("#(钱币)", "image_emoticon41");
        epa.put("#(灯泡)", "image_emoticon42");
        epa.put("#(茶杯)", "image_emoticon43");
        epa.put("#(蛋糕)", "image_emoticon44");
        epa.put("#(音乐)", "image_emoticon45");
        epa.put("#(haha)", "image_emoticon46");
        epa.put("#(胜利)", "image_emoticon47");
        epa.put("#(大拇指)", "image_emoticon48");
        epa.put("#(弱)", "image_emoticon49");
        epa.put("#(OK)", "image_emoticon50");
        epa.put("#(哼)", "image_emoticon61");
        epa.put("#(吃瓜)", "image_emoticon62");
        epa.put("#(扔便便)", "image_emoticon63");
        epa.put("#(惊恐)", "image_emoticon64");
        epa.put("#(哎呦)", "image_emoticon65");
        epa.put("#(小乖)", "image_emoticon66");
        epa.put("#(捂嘴笑)", "image_emoticon67");
        epa.put("#(你懂的)", "image_emoticon68");
        epa.put("#(what)", "image_emoticon69");
        epa.put("#(酸爽)", "image_emoticon70");
        epa.put("#(呀咩爹)", "image_emoticon71");
        epa.put("#(笑尿)", "image_emoticon72");
        epa.put("#(挖鼻)", "image_emoticon73");
        epa.put("#(犀利)", "image_emoticon74");
        epa.put("#(小红脸)", "image_emoticon75");
        epa.put("#(懒得理)", "image_emoticon76");
        epa.put("#(沙发)", "image_emoticon77");
        epa.put("#(手纸)", "image_emoticon78");
        epa.put("#(香蕉)", "image_emoticon79");
        epa.put("#(便便)", "image_emoticon80");
        epa.put("#(药丸)", "image_emoticon81");
        epa.put("#(红领巾)", "image_emoticon82");
        epa.put("#(蜡烛)", "image_emoticon83");
        epa.put("#(三道杠)", "image_emoticon84");
        epa.put("#(赖皮)", "ali_001");
        epa.put("#(感动)", "ali_002");
        epa.put("#(十分惊讶)", "ali_003");
        epa.put("#(怒气)", "ali_004");
        epa.put("#(哭泣)", "ali_005");
        epa.put("#(吃惊)", "ali_006");
        epa.put("#(嘲弄)", "ali_007");
        epa.put("#(飘过)", "ali_008");
        epa.put("#(转圈哭)", "ali_009");
        epa.put("#(神经病)", "ali_010");
        epa.put("#(揪耳朵)", "ali_011");
        epa.put("#(惊汗)", "ali_012");
        epa.put("#(隐身)", "ali_013");
        epa.put("#(不要嘛)", "ali_014");
        epa.put("#(遁)", "ali_015");
        epa.put("#(不公平)", "ali_016");
        epa.put("#(爬来了)", "ali_017");
        epa.put("#(蛋花哭)", "ali_018");
        epa.put("#(温暖)", "ali_019");
        epa.put("#(点头)", "ali_020");
        epa.put("#(撒钱)", "ali_021");
        epa.put("#(献花)", "ali_022");
        epa.put("#(寒)", "ali_023");
        epa.put("#(傻笑)", "ali_024");
        epa.put("#(扭扭)", "ali_025");
        epa.put("#(疯)", "ali_026");
        epa.put("#(抓狂)", "ali_027");
        epa.put("#(抓)", "ali_028");
        epa.put("#(蜷)", "ali_029");
        epa.put("#(挠墙)", "ali_030");
        epa.put("#(狂笑)", "ali_031");
        epa.put("#(抱枕)", "ali_032");
        epa.put("#(吼叫)", "ali_033");
        epa.put("#(嚷)", "ali_034");
        epa.put("#(唠叨)", "ali_035");
        epa.put("#(捏脸)", "ali_036");
        epa.put("#(爆笑)", "ali_037");
        epa.put("#(郁闷)", "ali_038");
        epa.put("#(潜水)", "ali_039");
        epa.put("#(十分开心)", "ali_040");
        epa.put("#(冷笑话)", "ali_041");
        epa.put("#(顶！)", "ali_042");
        epa.put("#(潜)", "ali_043");
        epa.put("#(画圈圈)", "ali_044");
        epa.put("#(玩电脑)", "ali_045");
        epa.put("#(狂吐)", "ali_046");
        epa.put("#(哭着跑)", "ali_047");
        epa.put("#(阿狸侠)", "ali_048");
        epa.put("#(冷死了)", "ali_049");
        epa.put("#(惆怅~)", "ali_050");
        epa.put("#(摸头)", "ali_051");
        epa.put("#(蹭)", "ali_052");
        epa.put("#(打滚)", "ali_053");
        epa.put("#(叩拜)", "ali_054");
        epa.put("#(摸)", "ali_055");
        epa.put("#(数钱)", "ali_056");
        epa.put("#(拖走)", "ali_057");
        epa.put("#(热)", "ali_058");
        epa.put("#(加1)", "ali_059");
        epa.put("#(压力)", "ali_060");
        epa.put("#(表逼我)", "ali_061");
        epa.put("#(人呢)", "ali_062");
        epa.put("#(摇晃)", "ali_063");
        epa.put("#(打地鼠)", "ali_064");
        epa.put("#(这个屌)", "ali_065");
        epa.put("#(恐慌)", "ali_066");
        epa.put("#(晕乎乎)", "ali_067");
        epa.put("#(浮云)", "ali_068");
        epa.put("#(给力)", "ali_069");
        epa.put("#(杯具了)", "ali_070");
        epa.put("#(焦糖舞)", "yz_001");
        epa.put("#(翻滚)", "yz_002");
        epa.put("#(拍屁股做鬼脸)", "yz_003");
        epa.put("#(不)", "yz_004");
        epa.put("#(河蟹掉啦)", "yz_005");
        epa.put("#(哦耶)", "yz_006");
        epa.put("#(我倒)", "yz_007");
        epa.put("#(投降)", "yz_008");
        epa.put("#(微笑)", "b01");
        epa.put("#(帅哥)", "b02");
        epa.put("#(美女)", "b03");
        epa.put("#(老大)", "b04");
        epa.put("#(哈哈哈)", "b05");
        epa.put("#(奸笑)", "b06");
        epa.put("#(傻乐)", "b07");
        epa.put("#(飞吻)", "b08");
        epa.put("#(害羞)", "b09");
        epa.put("#(花痴)", "b10");
        epa.put("#(憧憬)", "b11");
        epa.put("#(你牛)", "b12");
        epa.put("#(鼓掌)", "b13");
        epa.put("#(可爱)", "b14");
        epa.put("#(太委屈)", "b15");
        epa.put("#(大哭)", "b16");
        epa.put("#(泪奔)", "b17");
        epa.put("#(寻死)", "b18");
        epa.put("#(非常惊讶)", "b19");
        epa.put("#(表示疑问)", "b20");
        epa.put("#(暗中观察)", "image_emoticon85");
        epa.put("#(吃瓜)", "image_emoticon86");
        epa.put("#(喝酒)", "image_emoticon87");
        epa.put("#(嘿嘿嘿)", "image_emoticon88");
        epa.put("#(噗)", "image_emoticon89");
        epa.put("#(困成狗)", "image_emoticon90");
        epa.put("#(微微一笑)", "image_emoticon91");
        epa.put("#(托腮)", "image_emoticon92");
        epa.put("#(摊手)", "image_emoticon93");
        epa.put("#(柯基暗中观察)", "image_emoticon94");
        epa.put("#(欢呼)", "image_emoticon95");
        epa.put("#(炸药)", "image_emoticon96");
        epa.put("#(突然兴奋)", "image_emoticon97");
        epa.put("#(紧张)", "image_emoticon98");
        epa.put("#(黑头瞪眼)", "image_emoticon99");
        epa.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return epa.get(str);
    }

    public static List<TbFaceManager.RichUnit> mr(String str) {
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
                        arrayList.add(ms(str2));
                        str4 = "";
                    }
                    arrayList.add(bb(str3, name));
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
            arrayList.add(ms(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit ms(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit bb(String str, String str2) {
        String substring = str.substring(2, str.length() - 1);
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str2;
        richUnit.type = 2;
        richUnit.c = substring;
        return richUnit;
    }

    public static ArrayList<TbRichTextData> g(Context context, String str, int i) {
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
                                SpannableString ai = ai(context, str5);
                                if (ai != null) {
                                    tbRichTextData.append(ai);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.QS(), name, str3);
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
                    SpannableString ai2 = ai(context, str5);
                    if (ai2 != null) {
                        tbRichTextData.append(ai2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fS = TbFaceManager.Ma().fS(str);
        if (fS != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), fS);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0085a gr = TbFaceManager.Ma().gr(str);
            if (gr != null) {
                int width = (int) (0.5d * gr.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ai(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.U(context, str);
    }
}
