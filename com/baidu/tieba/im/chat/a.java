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
    private static final HashMap<String, String> dCX = new HashMap<>();

    static {
        dCX.put("#(呵呵)", "image_emoticon");
        dCX.put("#(哈哈)", "image_emoticon2");
        dCX.put("#(吐舌)", "image_emoticon3");
        dCX.put("#(啊)", "image_emoticon4");
        dCX.put("#(啊?)", "image_emoticon4");
        dCX.put("#(酷)", "image_emoticon5");
        dCX.put("#(怒)", "image_emoticon6");
        dCX.put("#(开心)", "image_emoticon7");
        dCX.put("#(汗)", "image_emoticon8");
        dCX.put("#(泪)", "image_emoticon9");
        dCX.put("#(黑线)", "image_emoticon10");
        dCX.put("#(鄙视)", "image_emoticon11");
        dCX.put("#(不高兴)", "image_emoticon12");
        dCX.put("#(真棒)", "image_emoticon13");
        dCX.put("#(钱)", "image_emoticon14");
        dCX.put("#(疑问)", "image_emoticon15");
        dCX.put("#(阴险)", "image_emoticon16");
        dCX.put("#(吐)", "image_emoticon17");
        dCX.put("#(咦)", "image_emoticon18");
        dCX.put("#(咦?)", "image_emoticon18");
        dCX.put("#(委屈)", "image_emoticon19");
        dCX.put("#(花心)", "image_emoticon20");
        dCX.put("#(呼~)", "image_emoticon21");
        dCX.put("#(笑眼)", "image_emoticon22");
        dCX.put("#(冷)", "image_emoticon23");
        dCX.put("#(太开心)", "image_emoticon24");
        dCX.put("#(滑稽)", "image_emoticon25");
        dCX.put("#(勉强)", "image_emoticon26");
        dCX.put("#(狂汗)", "image_emoticon27");
        dCX.put("#(乖)", "image_emoticon28");
        dCX.put("#(睡觉)", "image_emoticon29");
        dCX.put("#(惊哭)", "image_emoticon30");
        dCX.put("#(升起)", "image_emoticon31");
        dCX.put("#(惊讶)", "image_emoticon32");
        dCX.put("#(喷)", "image_emoticon33");
        dCX.put("#(爱心)", "image_emoticon34");
        dCX.put("#(心碎)", "image_emoticon35");
        dCX.put("#(玫瑰)", "image_emoticon36");
        dCX.put("#(礼物)", "image_emoticon37");
        dCX.put("#(彩虹)", "image_emoticon38");
        dCX.put("#(星星月亮)", "image_emoticon39");
        dCX.put("#(太阳)", "image_emoticon40");
        dCX.put("#(钱币)", "image_emoticon41");
        dCX.put("#(灯泡)", "image_emoticon42");
        dCX.put("#(茶杯)", "image_emoticon43");
        dCX.put("#(蛋糕)", "image_emoticon44");
        dCX.put("#(音乐)", "image_emoticon45");
        dCX.put("#(haha)", "image_emoticon46");
        dCX.put("#(胜利)", "image_emoticon47");
        dCX.put("#(大拇指)", "image_emoticon48");
        dCX.put("#(弱)", "image_emoticon49");
        dCX.put("#(OK)", "image_emoticon50");
        dCX.put("#(哼)", "image_emoticon61");
        dCX.put("#(吃瓜)", "image_emoticon62");
        dCX.put("#(扔便便)", "image_emoticon63");
        dCX.put("#(惊恐)", "image_emoticon64");
        dCX.put("#(哎呦)", "image_emoticon65");
        dCX.put("#(小乖)", "image_emoticon66");
        dCX.put("#(捂嘴笑)", "image_emoticon67");
        dCX.put("#(你懂的)", "image_emoticon68");
        dCX.put("#(what)", "image_emoticon69");
        dCX.put("#(酸爽)", "image_emoticon70");
        dCX.put("#(呀咩爹)", "image_emoticon71");
        dCX.put("#(笑尿)", "image_emoticon72");
        dCX.put("#(挖鼻)", "image_emoticon73");
        dCX.put("#(犀利)", "image_emoticon74");
        dCX.put("#(小红脸)", "image_emoticon75");
        dCX.put("#(懒得理)", "image_emoticon76");
        dCX.put("#(沙发)", "image_emoticon77");
        dCX.put("#(手纸)", "image_emoticon78");
        dCX.put("#(香蕉)", "image_emoticon79");
        dCX.put("#(便便)", "image_emoticon80");
        dCX.put("#(药丸)", "image_emoticon81");
        dCX.put("#(红领巾)", "image_emoticon82");
        dCX.put("#(蜡烛)", "image_emoticon83");
        dCX.put("#(三道杠)", "image_emoticon84");
        dCX.put("#(赖皮)", "ali_001");
        dCX.put("#(感动)", "ali_002");
        dCX.put("#(十分惊讶)", "ali_003");
        dCX.put("#(怒气)", "ali_004");
        dCX.put("#(哭泣)", "ali_005");
        dCX.put("#(吃惊)", "ali_006");
        dCX.put("#(嘲弄)", "ali_007");
        dCX.put("#(飘过)", "ali_008");
        dCX.put("#(转圈哭)", "ali_009");
        dCX.put("#(神经病)", "ali_010");
        dCX.put("#(揪耳朵)", "ali_011");
        dCX.put("#(惊汗)", "ali_012");
        dCX.put("#(隐身)", "ali_013");
        dCX.put("#(不要嘛)", "ali_014");
        dCX.put("#(遁)", "ali_015");
        dCX.put("#(不公平)", "ali_016");
        dCX.put("#(爬来了)", "ali_017");
        dCX.put("#(蛋花哭)", "ali_018");
        dCX.put("#(温暖)", "ali_019");
        dCX.put("#(点头)", "ali_020");
        dCX.put("#(撒钱)", "ali_021");
        dCX.put("#(献花)", "ali_022");
        dCX.put("#(寒)", "ali_023");
        dCX.put("#(傻笑)", "ali_024");
        dCX.put("#(扭扭)", "ali_025");
        dCX.put("#(疯)", "ali_026");
        dCX.put("#(抓狂)", "ali_027");
        dCX.put("#(抓)", "ali_028");
        dCX.put("#(蜷)", "ali_029");
        dCX.put("#(挠墙)", "ali_030");
        dCX.put("#(狂笑)", "ali_031");
        dCX.put("#(抱枕)", "ali_032");
        dCX.put("#(吼叫)", "ali_033");
        dCX.put("#(嚷)", "ali_034");
        dCX.put("#(唠叨)", "ali_035");
        dCX.put("#(捏脸)", "ali_036");
        dCX.put("#(爆笑)", "ali_037");
        dCX.put("#(郁闷)", "ali_038");
        dCX.put("#(潜水)", "ali_039");
        dCX.put("#(十分开心)", "ali_040");
        dCX.put("#(冷笑话)", "ali_041");
        dCX.put("#(顶！)", "ali_042");
        dCX.put("#(潜)", "ali_043");
        dCX.put("#(画圈圈)", "ali_044");
        dCX.put("#(玩电脑)", "ali_045");
        dCX.put("#(狂吐)", "ali_046");
        dCX.put("#(哭着跑)", "ali_047");
        dCX.put("#(阿狸侠)", "ali_048");
        dCX.put("#(冷死了)", "ali_049");
        dCX.put("#(惆怅~)", "ali_050");
        dCX.put("#(摸头)", "ali_051");
        dCX.put("#(蹭)", "ali_052");
        dCX.put("#(打滚)", "ali_053");
        dCX.put("#(叩拜)", "ali_054");
        dCX.put("#(摸)", "ali_055");
        dCX.put("#(数钱)", "ali_056");
        dCX.put("#(拖走)", "ali_057");
        dCX.put("#(热)", "ali_058");
        dCX.put("#(加1)", "ali_059");
        dCX.put("#(压力)", "ali_060");
        dCX.put("#(表逼我)", "ali_061");
        dCX.put("#(人呢)", "ali_062");
        dCX.put("#(摇晃)", "ali_063");
        dCX.put("#(打地鼠)", "ali_064");
        dCX.put("#(这个屌)", "ali_065");
        dCX.put("#(恐慌)", "ali_066");
        dCX.put("#(晕乎乎)", "ali_067");
        dCX.put("#(浮云)", "ali_068");
        dCX.put("#(给力)", "ali_069");
        dCX.put("#(杯具了)", "ali_070");
        dCX.put("#(焦糖舞)", "yz_001");
        dCX.put("#(翻滚)", "yz_002");
        dCX.put("#(拍屁股做鬼脸)", "yz_003");
        dCX.put("#(不)", "yz_004");
        dCX.put("#(河蟹掉啦)", "yz_005");
        dCX.put("#(哦耶)", "yz_006");
        dCX.put("#(我倒)", "yz_007");
        dCX.put("#(投降)", "yz_008");
        dCX.put("#(微笑)", "b01");
        dCX.put("#(帅哥)", "b02");
        dCX.put("#(美女)", "b03");
        dCX.put("#(老大)", "b04");
        dCX.put("#(哈哈哈)", "b05");
        dCX.put("#(奸笑)", "b06");
        dCX.put("#(傻乐)", "b07");
        dCX.put("#(飞吻)", "b08");
        dCX.put("#(害羞)", "b09");
        dCX.put("#(花痴)", "b10");
        dCX.put("#(憧憬)", "b11");
        dCX.put("#(你牛)", "b12");
        dCX.put("#(鼓掌)", "b13");
        dCX.put("#(可爱)", "b14");
        dCX.put("#(太委屈)", "b15");
        dCX.put("#(大哭)", "b16");
        dCX.put("#(泪奔)", "b17");
        dCX.put("#(寻死)", "b18");
        dCX.put("#(非常惊讶)", "b19");
        dCX.put("#(表示疑问)", "b20");
        dCX.put("#(暗中观察)", "image_emoticon85");
        dCX.put("#(吃瓜)", "image_emoticon86");
        dCX.put("#(喝酒)", "image_emoticon87");
        dCX.put("#(嘿嘿嘿)", "image_emoticon88");
        dCX.put("#(噗)", "image_emoticon89");
        dCX.put("#(困成狗)", "image_emoticon90");
        dCX.put("#(微微一笑)", "image_emoticon91");
        dCX.put("#(托腮)", "image_emoticon92");
        dCX.put("#(摊手)", "image_emoticon93");
        dCX.put("#(柯基暗中观察)", "image_emoticon94");
        dCX.put("#(欢呼)", "image_emoticon95");
        dCX.put("#(炸药)", "image_emoticon96");
        dCX.put("#(突然兴奋)", "image_emoticon97");
        dCX.put("#(紧张)", "image_emoticon98");
        dCX.put("#(黑头瞪眼)", "image_emoticon99");
        dCX.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dCX.get(str);
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
            a.C0071a gk = TbFaceManager.Ez().gk(str);
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
