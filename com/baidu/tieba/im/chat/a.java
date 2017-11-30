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
    private static final HashMap<String, String> dBP = new HashMap<>();

    static {
        dBP.put("#(呵呵)", "image_emoticon");
        dBP.put("#(哈哈)", "image_emoticon2");
        dBP.put("#(吐舌)", "image_emoticon3");
        dBP.put("#(啊)", "image_emoticon4");
        dBP.put("#(啊?)", "image_emoticon4");
        dBP.put("#(酷)", "image_emoticon5");
        dBP.put("#(怒)", "image_emoticon6");
        dBP.put("#(开心)", "image_emoticon7");
        dBP.put("#(汗)", "image_emoticon8");
        dBP.put("#(泪)", "image_emoticon9");
        dBP.put("#(黑线)", "image_emoticon10");
        dBP.put("#(鄙视)", "image_emoticon11");
        dBP.put("#(不高兴)", "image_emoticon12");
        dBP.put("#(真棒)", "image_emoticon13");
        dBP.put("#(钱)", "image_emoticon14");
        dBP.put("#(疑问)", "image_emoticon15");
        dBP.put("#(阴险)", "image_emoticon16");
        dBP.put("#(吐)", "image_emoticon17");
        dBP.put("#(咦)", "image_emoticon18");
        dBP.put("#(咦?)", "image_emoticon18");
        dBP.put("#(委屈)", "image_emoticon19");
        dBP.put("#(花心)", "image_emoticon20");
        dBP.put("#(呼~)", "image_emoticon21");
        dBP.put("#(笑眼)", "image_emoticon22");
        dBP.put("#(冷)", "image_emoticon23");
        dBP.put("#(太开心)", "image_emoticon24");
        dBP.put("#(滑稽)", "image_emoticon25");
        dBP.put("#(勉强)", "image_emoticon26");
        dBP.put("#(狂汗)", "image_emoticon27");
        dBP.put("#(乖)", "image_emoticon28");
        dBP.put("#(睡觉)", "image_emoticon29");
        dBP.put("#(惊哭)", "image_emoticon30");
        dBP.put("#(升起)", "image_emoticon31");
        dBP.put("#(惊讶)", "image_emoticon32");
        dBP.put("#(喷)", "image_emoticon33");
        dBP.put("#(爱心)", "image_emoticon34");
        dBP.put("#(心碎)", "image_emoticon35");
        dBP.put("#(玫瑰)", "image_emoticon36");
        dBP.put("#(礼物)", "image_emoticon37");
        dBP.put("#(彩虹)", "image_emoticon38");
        dBP.put("#(星星月亮)", "image_emoticon39");
        dBP.put("#(太阳)", "image_emoticon40");
        dBP.put("#(钱币)", "image_emoticon41");
        dBP.put("#(灯泡)", "image_emoticon42");
        dBP.put("#(茶杯)", "image_emoticon43");
        dBP.put("#(蛋糕)", "image_emoticon44");
        dBP.put("#(音乐)", "image_emoticon45");
        dBP.put("#(haha)", "image_emoticon46");
        dBP.put("#(胜利)", "image_emoticon47");
        dBP.put("#(大拇指)", "image_emoticon48");
        dBP.put("#(弱)", "image_emoticon49");
        dBP.put("#(OK)", "image_emoticon50");
        dBP.put("#(哼)", "image_emoticon61");
        dBP.put("#(吃瓜)", "image_emoticon62");
        dBP.put("#(扔便便)", "image_emoticon63");
        dBP.put("#(惊恐)", "image_emoticon64");
        dBP.put("#(哎呦)", "image_emoticon65");
        dBP.put("#(小乖)", "image_emoticon66");
        dBP.put("#(捂嘴笑)", "image_emoticon67");
        dBP.put("#(你懂的)", "image_emoticon68");
        dBP.put("#(what)", "image_emoticon69");
        dBP.put("#(酸爽)", "image_emoticon70");
        dBP.put("#(呀咩爹)", "image_emoticon71");
        dBP.put("#(笑尿)", "image_emoticon72");
        dBP.put("#(挖鼻)", "image_emoticon73");
        dBP.put("#(犀利)", "image_emoticon74");
        dBP.put("#(小红脸)", "image_emoticon75");
        dBP.put("#(懒得理)", "image_emoticon76");
        dBP.put("#(沙发)", "image_emoticon77");
        dBP.put("#(手纸)", "image_emoticon78");
        dBP.put("#(香蕉)", "image_emoticon79");
        dBP.put("#(便便)", "image_emoticon80");
        dBP.put("#(药丸)", "image_emoticon81");
        dBP.put("#(红领巾)", "image_emoticon82");
        dBP.put("#(蜡烛)", "image_emoticon83");
        dBP.put("#(三道杠)", "image_emoticon84");
        dBP.put("#(赖皮)", "ali_001");
        dBP.put("#(感动)", "ali_002");
        dBP.put("#(十分惊讶)", "ali_003");
        dBP.put("#(怒气)", "ali_004");
        dBP.put("#(哭泣)", "ali_005");
        dBP.put("#(吃惊)", "ali_006");
        dBP.put("#(嘲弄)", "ali_007");
        dBP.put("#(飘过)", "ali_008");
        dBP.put("#(转圈哭)", "ali_009");
        dBP.put("#(神经病)", "ali_010");
        dBP.put("#(揪耳朵)", "ali_011");
        dBP.put("#(惊汗)", "ali_012");
        dBP.put("#(隐身)", "ali_013");
        dBP.put("#(不要嘛)", "ali_014");
        dBP.put("#(遁)", "ali_015");
        dBP.put("#(不公平)", "ali_016");
        dBP.put("#(爬来了)", "ali_017");
        dBP.put("#(蛋花哭)", "ali_018");
        dBP.put("#(温暖)", "ali_019");
        dBP.put("#(点头)", "ali_020");
        dBP.put("#(撒钱)", "ali_021");
        dBP.put("#(献花)", "ali_022");
        dBP.put("#(寒)", "ali_023");
        dBP.put("#(傻笑)", "ali_024");
        dBP.put("#(扭扭)", "ali_025");
        dBP.put("#(疯)", "ali_026");
        dBP.put("#(抓狂)", "ali_027");
        dBP.put("#(抓)", "ali_028");
        dBP.put("#(蜷)", "ali_029");
        dBP.put("#(挠墙)", "ali_030");
        dBP.put("#(狂笑)", "ali_031");
        dBP.put("#(抱枕)", "ali_032");
        dBP.put("#(吼叫)", "ali_033");
        dBP.put("#(嚷)", "ali_034");
        dBP.put("#(唠叨)", "ali_035");
        dBP.put("#(捏脸)", "ali_036");
        dBP.put("#(爆笑)", "ali_037");
        dBP.put("#(郁闷)", "ali_038");
        dBP.put("#(潜水)", "ali_039");
        dBP.put("#(十分开心)", "ali_040");
        dBP.put("#(冷笑话)", "ali_041");
        dBP.put("#(顶！)", "ali_042");
        dBP.put("#(潜)", "ali_043");
        dBP.put("#(画圈圈)", "ali_044");
        dBP.put("#(玩电脑)", "ali_045");
        dBP.put("#(狂吐)", "ali_046");
        dBP.put("#(哭着跑)", "ali_047");
        dBP.put("#(阿狸侠)", "ali_048");
        dBP.put("#(冷死了)", "ali_049");
        dBP.put("#(惆怅~)", "ali_050");
        dBP.put("#(摸头)", "ali_051");
        dBP.put("#(蹭)", "ali_052");
        dBP.put("#(打滚)", "ali_053");
        dBP.put("#(叩拜)", "ali_054");
        dBP.put("#(摸)", "ali_055");
        dBP.put("#(数钱)", "ali_056");
        dBP.put("#(拖走)", "ali_057");
        dBP.put("#(热)", "ali_058");
        dBP.put("#(加1)", "ali_059");
        dBP.put("#(压力)", "ali_060");
        dBP.put("#(表逼我)", "ali_061");
        dBP.put("#(人呢)", "ali_062");
        dBP.put("#(摇晃)", "ali_063");
        dBP.put("#(打地鼠)", "ali_064");
        dBP.put("#(这个屌)", "ali_065");
        dBP.put("#(恐慌)", "ali_066");
        dBP.put("#(晕乎乎)", "ali_067");
        dBP.put("#(浮云)", "ali_068");
        dBP.put("#(给力)", "ali_069");
        dBP.put("#(杯具了)", "ali_070");
        dBP.put("#(焦糖舞)", "yz_001");
        dBP.put("#(翻滚)", "yz_002");
        dBP.put("#(拍屁股做鬼脸)", "yz_003");
        dBP.put("#(不)", "yz_004");
        dBP.put("#(河蟹掉啦)", "yz_005");
        dBP.put("#(哦耶)", "yz_006");
        dBP.put("#(我倒)", "yz_007");
        dBP.put("#(投降)", "yz_008");
        dBP.put("#(微笑)", "b01");
        dBP.put("#(帅哥)", "b02");
        dBP.put("#(美女)", "b03");
        dBP.put("#(老大)", "b04");
        dBP.put("#(哈哈哈)", "b05");
        dBP.put("#(奸笑)", "b06");
        dBP.put("#(傻乐)", "b07");
        dBP.put("#(飞吻)", "b08");
        dBP.put("#(害羞)", "b09");
        dBP.put("#(花痴)", "b10");
        dBP.put("#(憧憬)", "b11");
        dBP.put("#(你牛)", "b12");
        dBP.put("#(鼓掌)", "b13");
        dBP.put("#(可爱)", "b14");
        dBP.put("#(太委屈)", "b15");
        dBP.put("#(大哭)", "b16");
        dBP.put("#(泪奔)", "b17");
        dBP.put("#(寻死)", "b18");
        dBP.put("#(非常惊讶)", "b19");
        dBP.put("#(表示疑问)", "b20");
        dBP.put("#(暗中观察)", "image_emoticon85");
        dBP.put("#(吃瓜)", "image_emoticon86");
        dBP.put("#(喝酒)", "image_emoticon87");
        dBP.put("#(嘿嘿嘿)", "image_emoticon88");
        dBP.put("#(噗)", "image_emoticon89");
        dBP.put("#(困成狗)", "image_emoticon90");
        dBP.put("#(微微一笑)", "image_emoticon91");
        dBP.put("#(托腮)", "image_emoticon92");
        dBP.put("#(摊手)", "image_emoticon93");
        dBP.put("#(柯基暗中观察)", "image_emoticon94");
        dBP.put("#(欢呼)", "image_emoticon95");
        dBP.put("#(炸药)", "image_emoticon96");
        dBP.put("#(突然兴奋)", "image_emoticon97");
        dBP.put("#(紧张)", "image_emoticon98");
        dBP.put("#(黑头瞪眼)", "image_emoticon99");
        dBP.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dBP.get(str);
    }

    public static List<TbFaceManager.RichUnit> mi(String str) {
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
                        arrayList.add(mj(str2));
                        str4 = "";
                    }
                    arrayList.add(ba(str3, name));
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
            arrayList.add(mj(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit mj(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit ba(String str, String str2) {
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
                                SpannableString ag = ag(context, str5);
                                if (ag != null) {
                                    tbRichTextData.append(ag);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.Jv(), name, str3);
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
                    SpannableString ag2 = ag(context, str5);
                    if (ag2 != null) {
                        tbRichTextData.append(ag2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fM = TbFaceManager.Ey().fM(str);
        if (fM != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), fM);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0058a gl = TbFaceManager.Ey().gl(str);
            if (gl != null) {
                int width = (int) (0.5d * gl.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ag(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.S(context, str);
    }
}
