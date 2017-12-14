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
    private static final HashMap<String, String> dCT = new HashMap<>();

    static {
        dCT.put("#(呵呵)", "image_emoticon");
        dCT.put("#(哈哈)", "image_emoticon2");
        dCT.put("#(吐舌)", "image_emoticon3");
        dCT.put("#(啊)", "image_emoticon4");
        dCT.put("#(啊?)", "image_emoticon4");
        dCT.put("#(酷)", "image_emoticon5");
        dCT.put("#(怒)", "image_emoticon6");
        dCT.put("#(开心)", "image_emoticon7");
        dCT.put("#(汗)", "image_emoticon8");
        dCT.put("#(泪)", "image_emoticon9");
        dCT.put("#(黑线)", "image_emoticon10");
        dCT.put("#(鄙视)", "image_emoticon11");
        dCT.put("#(不高兴)", "image_emoticon12");
        dCT.put("#(真棒)", "image_emoticon13");
        dCT.put("#(钱)", "image_emoticon14");
        dCT.put("#(疑问)", "image_emoticon15");
        dCT.put("#(阴险)", "image_emoticon16");
        dCT.put("#(吐)", "image_emoticon17");
        dCT.put("#(咦)", "image_emoticon18");
        dCT.put("#(咦?)", "image_emoticon18");
        dCT.put("#(委屈)", "image_emoticon19");
        dCT.put("#(花心)", "image_emoticon20");
        dCT.put("#(呼~)", "image_emoticon21");
        dCT.put("#(笑眼)", "image_emoticon22");
        dCT.put("#(冷)", "image_emoticon23");
        dCT.put("#(太开心)", "image_emoticon24");
        dCT.put("#(滑稽)", "image_emoticon25");
        dCT.put("#(勉强)", "image_emoticon26");
        dCT.put("#(狂汗)", "image_emoticon27");
        dCT.put("#(乖)", "image_emoticon28");
        dCT.put("#(睡觉)", "image_emoticon29");
        dCT.put("#(惊哭)", "image_emoticon30");
        dCT.put("#(升起)", "image_emoticon31");
        dCT.put("#(惊讶)", "image_emoticon32");
        dCT.put("#(喷)", "image_emoticon33");
        dCT.put("#(爱心)", "image_emoticon34");
        dCT.put("#(心碎)", "image_emoticon35");
        dCT.put("#(玫瑰)", "image_emoticon36");
        dCT.put("#(礼物)", "image_emoticon37");
        dCT.put("#(彩虹)", "image_emoticon38");
        dCT.put("#(星星月亮)", "image_emoticon39");
        dCT.put("#(太阳)", "image_emoticon40");
        dCT.put("#(钱币)", "image_emoticon41");
        dCT.put("#(灯泡)", "image_emoticon42");
        dCT.put("#(茶杯)", "image_emoticon43");
        dCT.put("#(蛋糕)", "image_emoticon44");
        dCT.put("#(音乐)", "image_emoticon45");
        dCT.put("#(haha)", "image_emoticon46");
        dCT.put("#(胜利)", "image_emoticon47");
        dCT.put("#(大拇指)", "image_emoticon48");
        dCT.put("#(弱)", "image_emoticon49");
        dCT.put("#(OK)", "image_emoticon50");
        dCT.put("#(哼)", "image_emoticon61");
        dCT.put("#(吃瓜)", "image_emoticon62");
        dCT.put("#(扔便便)", "image_emoticon63");
        dCT.put("#(惊恐)", "image_emoticon64");
        dCT.put("#(哎呦)", "image_emoticon65");
        dCT.put("#(小乖)", "image_emoticon66");
        dCT.put("#(捂嘴笑)", "image_emoticon67");
        dCT.put("#(你懂的)", "image_emoticon68");
        dCT.put("#(what)", "image_emoticon69");
        dCT.put("#(酸爽)", "image_emoticon70");
        dCT.put("#(呀咩爹)", "image_emoticon71");
        dCT.put("#(笑尿)", "image_emoticon72");
        dCT.put("#(挖鼻)", "image_emoticon73");
        dCT.put("#(犀利)", "image_emoticon74");
        dCT.put("#(小红脸)", "image_emoticon75");
        dCT.put("#(懒得理)", "image_emoticon76");
        dCT.put("#(沙发)", "image_emoticon77");
        dCT.put("#(手纸)", "image_emoticon78");
        dCT.put("#(香蕉)", "image_emoticon79");
        dCT.put("#(便便)", "image_emoticon80");
        dCT.put("#(药丸)", "image_emoticon81");
        dCT.put("#(红领巾)", "image_emoticon82");
        dCT.put("#(蜡烛)", "image_emoticon83");
        dCT.put("#(三道杠)", "image_emoticon84");
        dCT.put("#(赖皮)", "ali_001");
        dCT.put("#(感动)", "ali_002");
        dCT.put("#(十分惊讶)", "ali_003");
        dCT.put("#(怒气)", "ali_004");
        dCT.put("#(哭泣)", "ali_005");
        dCT.put("#(吃惊)", "ali_006");
        dCT.put("#(嘲弄)", "ali_007");
        dCT.put("#(飘过)", "ali_008");
        dCT.put("#(转圈哭)", "ali_009");
        dCT.put("#(神经病)", "ali_010");
        dCT.put("#(揪耳朵)", "ali_011");
        dCT.put("#(惊汗)", "ali_012");
        dCT.put("#(隐身)", "ali_013");
        dCT.put("#(不要嘛)", "ali_014");
        dCT.put("#(遁)", "ali_015");
        dCT.put("#(不公平)", "ali_016");
        dCT.put("#(爬来了)", "ali_017");
        dCT.put("#(蛋花哭)", "ali_018");
        dCT.put("#(温暖)", "ali_019");
        dCT.put("#(点头)", "ali_020");
        dCT.put("#(撒钱)", "ali_021");
        dCT.put("#(献花)", "ali_022");
        dCT.put("#(寒)", "ali_023");
        dCT.put("#(傻笑)", "ali_024");
        dCT.put("#(扭扭)", "ali_025");
        dCT.put("#(疯)", "ali_026");
        dCT.put("#(抓狂)", "ali_027");
        dCT.put("#(抓)", "ali_028");
        dCT.put("#(蜷)", "ali_029");
        dCT.put("#(挠墙)", "ali_030");
        dCT.put("#(狂笑)", "ali_031");
        dCT.put("#(抱枕)", "ali_032");
        dCT.put("#(吼叫)", "ali_033");
        dCT.put("#(嚷)", "ali_034");
        dCT.put("#(唠叨)", "ali_035");
        dCT.put("#(捏脸)", "ali_036");
        dCT.put("#(爆笑)", "ali_037");
        dCT.put("#(郁闷)", "ali_038");
        dCT.put("#(潜水)", "ali_039");
        dCT.put("#(十分开心)", "ali_040");
        dCT.put("#(冷笑话)", "ali_041");
        dCT.put("#(顶！)", "ali_042");
        dCT.put("#(潜)", "ali_043");
        dCT.put("#(画圈圈)", "ali_044");
        dCT.put("#(玩电脑)", "ali_045");
        dCT.put("#(狂吐)", "ali_046");
        dCT.put("#(哭着跑)", "ali_047");
        dCT.put("#(阿狸侠)", "ali_048");
        dCT.put("#(冷死了)", "ali_049");
        dCT.put("#(惆怅~)", "ali_050");
        dCT.put("#(摸头)", "ali_051");
        dCT.put("#(蹭)", "ali_052");
        dCT.put("#(打滚)", "ali_053");
        dCT.put("#(叩拜)", "ali_054");
        dCT.put("#(摸)", "ali_055");
        dCT.put("#(数钱)", "ali_056");
        dCT.put("#(拖走)", "ali_057");
        dCT.put("#(热)", "ali_058");
        dCT.put("#(加1)", "ali_059");
        dCT.put("#(压力)", "ali_060");
        dCT.put("#(表逼我)", "ali_061");
        dCT.put("#(人呢)", "ali_062");
        dCT.put("#(摇晃)", "ali_063");
        dCT.put("#(打地鼠)", "ali_064");
        dCT.put("#(这个屌)", "ali_065");
        dCT.put("#(恐慌)", "ali_066");
        dCT.put("#(晕乎乎)", "ali_067");
        dCT.put("#(浮云)", "ali_068");
        dCT.put("#(给力)", "ali_069");
        dCT.put("#(杯具了)", "ali_070");
        dCT.put("#(焦糖舞)", "yz_001");
        dCT.put("#(翻滚)", "yz_002");
        dCT.put("#(拍屁股做鬼脸)", "yz_003");
        dCT.put("#(不)", "yz_004");
        dCT.put("#(河蟹掉啦)", "yz_005");
        dCT.put("#(哦耶)", "yz_006");
        dCT.put("#(我倒)", "yz_007");
        dCT.put("#(投降)", "yz_008");
        dCT.put("#(微笑)", "b01");
        dCT.put("#(帅哥)", "b02");
        dCT.put("#(美女)", "b03");
        dCT.put("#(老大)", "b04");
        dCT.put("#(哈哈哈)", "b05");
        dCT.put("#(奸笑)", "b06");
        dCT.put("#(傻乐)", "b07");
        dCT.put("#(飞吻)", "b08");
        dCT.put("#(害羞)", "b09");
        dCT.put("#(花痴)", "b10");
        dCT.put("#(憧憬)", "b11");
        dCT.put("#(你牛)", "b12");
        dCT.put("#(鼓掌)", "b13");
        dCT.put("#(可爱)", "b14");
        dCT.put("#(太委屈)", "b15");
        dCT.put("#(大哭)", "b16");
        dCT.put("#(泪奔)", "b17");
        dCT.put("#(寻死)", "b18");
        dCT.put("#(非常惊讶)", "b19");
        dCT.put("#(表示疑问)", "b20");
        dCT.put("#(暗中观察)", "image_emoticon85");
        dCT.put("#(吃瓜)", "image_emoticon86");
        dCT.put("#(喝酒)", "image_emoticon87");
        dCT.put("#(嘿嘿嘿)", "image_emoticon88");
        dCT.put("#(噗)", "image_emoticon89");
        dCT.put("#(困成狗)", "image_emoticon90");
        dCT.put("#(微微一笑)", "image_emoticon91");
        dCT.put("#(托腮)", "image_emoticon92");
        dCT.put("#(摊手)", "image_emoticon93");
        dCT.put("#(柯基暗中观察)", "image_emoticon94");
        dCT.put("#(欢呼)", "image_emoticon95");
        dCT.put("#(炸药)", "image_emoticon96");
        dCT.put("#(突然兴奋)", "image_emoticon97");
        dCT.put("#(紧张)", "image_emoticon98");
        dCT.put("#(黑头瞪眼)", "image_emoticon99");
        dCT.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dCT.get(str);
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
                                SpannableString af = af(context, str5);
                                if (af != null) {
                                    tbRichTextData.append(af);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.Jw(), name, str3);
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
                    SpannableString af2 = af(context, str5);
                    if (af2 != null) {
                        tbRichTextData.append(af2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fL = TbFaceManager.Ez().fL(str);
        if (fL != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), fL);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0072a gk = TbFaceManager.Ez().gk(str);
            if (gk != null) {
                int width = (int) (0.5d * gk.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString af(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.R(context, str);
    }
}
