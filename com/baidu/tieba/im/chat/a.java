package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> dPN = new HashMap<>();

    static {
        dPN.put("#(呵呵)", "image_emoticon");
        dPN.put("#(哈哈)", "image_emoticon2");
        dPN.put("#(吐舌)", "image_emoticon3");
        dPN.put("#(啊)", "image_emoticon4");
        dPN.put("#(啊?)", "image_emoticon4");
        dPN.put("#(酷)", "image_emoticon5");
        dPN.put("#(怒)", "image_emoticon6");
        dPN.put("#(开心)", "image_emoticon7");
        dPN.put("#(汗)", "image_emoticon8");
        dPN.put("#(泪)", "image_emoticon9");
        dPN.put("#(黑线)", "image_emoticon10");
        dPN.put("#(鄙视)", "image_emoticon11");
        dPN.put("#(不高兴)", "image_emoticon12");
        dPN.put("#(真棒)", "image_emoticon13");
        dPN.put("#(钱)", "image_emoticon14");
        dPN.put("#(疑问)", "image_emoticon15");
        dPN.put("#(阴险)", "image_emoticon16");
        dPN.put("#(吐)", "image_emoticon17");
        dPN.put("#(咦)", "image_emoticon18");
        dPN.put("#(咦?)", "image_emoticon18");
        dPN.put("#(委屈)", "image_emoticon19");
        dPN.put("#(花心)", "image_emoticon20");
        dPN.put("#(呼~)", "image_emoticon21");
        dPN.put("#(笑眼)", "image_emoticon22");
        dPN.put("#(冷)", "image_emoticon23");
        dPN.put("#(太开心)", "image_emoticon24");
        dPN.put("#(滑稽)", "image_emoticon25");
        dPN.put("#(勉强)", "image_emoticon26");
        dPN.put("#(狂汗)", "image_emoticon27");
        dPN.put("#(乖)", "image_emoticon28");
        dPN.put("#(睡觉)", "image_emoticon29");
        dPN.put("#(惊哭)", "image_emoticon30");
        dPN.put("#(升起)", "image_emoticon31");
        dPN.put("#(惊讶)", "image_emoticon32");
        dPN.put("#(喷)", "image_emoticon33");
        dPN.put("#(爱心)", "image_emoticon34");
        dPN.put("#(心碎)", "image_emoticon35");
        dPN.put("#(玫瑰)", "image_emoticon36");
        dPN.put("#(礼物)", "image_emoticon37");
        dPN.put("#(彩虹)", "image_emoticon38");
        dPN.put("#(星星月亮)", "image_emoticon39");
        dPN.put("#(太阳)", "image_emoticon40");
        dPN.put("#(钱币)", "image_emoticon41");
        dPN.put("#(灯泡)", "image_emoticon42");
        dPN.put("#(茶杯)", "image_emoticon43");
        dPN.put("#(蛋糕)", "image_emoticon44");
        dPN.put("#(音乐)", "image_emoticon45");
        dPN.put("#(haha)", "image_emoticon46");
        dPN.put("#(胜利)", "image_emoticon47");
        dPN.put("#(大拇指)", "image_emoticon48");
        dPN.put("#(弱)", "image_emoticon49");
        dPN.put("#(OK)", "image_emoticon50");
        dPN.put("#(哼)", "image_emoticon61");
        dPN.put("#(吃瓜)", "image_emoticon62");
        dPN.put("#(扔便便)", "image_emoticon63");
        dPN.put("#(惊恐)", "image_emoticon64");
        dPN.put("#(哎呦)", "image_emoticon65");
        dPN.put("#(小乖)", "image_emoticon66");
        dPN.put("#(捂嘴笑)", "image_emoticon67");
        dPN.put("#(你懂的)", "image_emoticon68");
        dPN.put("#(what)", "image_emoticon69");
        dPN.put("#(酸爽)", "image_emoticon70");
        dPN.put("#(呀咩爹)", "image_emoticon71");
        dPN.put("#(笑尿)", "image_emoticon72");
        dPN.put("#(挖鼻)", "image_emoticon73");
        dPN.put("#(犀利)", "image_emoticon74");
        dPN.put("#(小红脸)", "image_emoticon75");
        dPN.put("#(懒得理)", "image_emoticon76");
        dPN.put("#(沙发)", "image_emoticon77");
        dPN.put("#(手纸)", "image_emoticon78");
        dPN.put("#(香蕉)", "image_emoticon79");
        dPN.put("#(便便)", "image_emoticon80");
        dPN.put("#(药丸)", "image_emoticon81");
        dPN.put("#(红领巾)", "image_emoticon82");
        dPN.put("#(蜡烛)", "image_emoticon83");
        dPN.put("#(三道杠)", "image_emoticon84");
        dPN.put("#(赖皮)", "ali_001");
        dPN.put("#(感动)", "ali_002");
        dPN.put("#(十分惊讶)", "ali_003");
        dPN.put("#(怒气)", "ali_004");
        dPN.put("#(哭泣)", "ali_005");
        dPN.put("#(吃惊)", "ali_006");
        dPN.put("#(嘲弄)", "ali_007");
        dPN.put("#(飘过)", "ali_008");
        dPN.put("#(转圈哭)", "ali_009");
        dPN.put("#(神经病)", "ali_010");
        dPN.put("#(揪耳朵)", "ali_011");
        dPN.put("#(惊汗)", "ali_012");
        dPN.put("#(隐身)", "ali_013");
        dPN.put("#(不要嘛)", "ali_014");
        dPN.put("#(遁)", "ali_015");
        dPN.put("#(不公平)", "ali_016");
        dPN.put("#(爬来了)", "ali_017");
        dPN.put("#(蛋花哭)", "ali_018");
        dPN.put("#(温暖)", "ali_019");
        dPN.put("#(点头)", "ali_020");
        dPN.put("#(撒钱)", "ali_021");
        dPN.put("#(献花)", "ali_022");
        dPN.put("#(寒)", "ali_023");
        dPN.put("#(傻笑)", "ali_024");
        dPN.put("#(扭扭)", "ali_025");
        dPN.put("#(疯)", "ali_026");
        dPN.put("#(抓狂)", "ali_027");
        dPN.put("#(抓)", "ali_028");
        dPN.put("#(蜷)", "ali_029");
        dPN.put("#(挠墙)", "ali_030");
        dPN.put("#(狂笑)", "ali_031");
        dPN.put("#(抱枕)", "ali_032");
        dPN.put("#(吼叫)", "ali_033");
        dPN.put("#(嚷)", "ali_034");
        dPN.put("#(唠叨)", "ali_035");
        dPN.put("#(捏脸)", "ali_036");
        dPN.put("#(爆笑)", "ali_037");
        dPN.put("#(郁闷)", "ali_038");
        dPN.put("#(潜水)", "ali_039");
        dPN.put("#(十分开心)", "ali_040");
        dPN.put("#(冷笑话)", "ali_041");
        dPN.put("#(顶！)", "ali_042");
        dPN.put("#(潜)", "ali_043");
        dPN.put("#(画圈圈)", "ali_044");
        dPN.put("#(玩电脑)", "ali_045");
        dPN.put("#(狂吐)", "ali_046");
        dPN.put("#(哭着跑)", "ali_047");
        dPN.put("#(阿狸侠)", "ali_048");
        dPN.put("#(冷死了)", "ali_049");
        dPN.put("#(惆怅~)", "ali_050");
        dPN.put("#(摸头)", "ali_051");
        dPN.put("#(蹭)", "ali_052");
        dPN.put("#(打滚)", "ali_053");
        dPN.put("#(叩拜)", "ali_054");
        dPN.put("#(摸)", "ali_055");
        dPN.put("#(数钱)", "ali_056");
        dPN.put("#(拖走)", "ali_057");
        dPN.put("#(热)", "ali_058");
        dPN.put("#(加1)", "ali_059");
        dPN.put("#(压力)", "ali_060");
        dPN.put("#(表逼我)", "ali_061");
        dPN.put("#(人呢)", "ali_062");
        dPN.put("#(摇晃)", "ali_063");
        dPN.put("#(打地鼠)", "ali_064");
        dPN.put("#(这个屌)", "ali_065");
        dPN.put("#(恐慌)", "ali_066");
        dPN.put("#(晕乎乎)", "ali_067");
        dPN.put("#(浮云)", "ali_068");
        dPN.put("#(给力)", "ali_069");
        dPN.put("#(杯具了)", "ali_070");
        dPN.put("#(焦糖舞)", "yz_001");
        dPN.put("#(翻滚)", "yz_002");
        dPN.put("#(拍屁股做鬼脸)", "yz_003");
        dPN.put("#(不)", "yz_004");
        dPN.put("#(河蟹掉啦)", "yz_005");
        dPN.put("#(哦耶)", "yz_006");
        dPN.put("#(我倒)", "yz_007");
        dPN.put("#(投降)", "yz_008");
        dPN.put("#(微笑)", "b01");
        dPN.put("#(帅哥)", "b02");
        dPN.put("#(美女)", "b03");
        dPN.put("#(老大)", "b04");
        dPN.put("#(哈哈哈)", "b05");
        dPN.put("#(奸笑)", "b06");
        dPN.put("#(傻乐)", "b07");
        dPN.put("#(飞吻)", "b08");
        dPN.put("#(害羞)", "b09");
        dPN.put("#(花痴)", "b10");
        dPN.put("#(憧憬)", "b11");
        dPN.put("#(你牛)", "b12");
        dPN.put("#(鼓掌)", "b13");
        dPN.put("#(可爱)", "b14");
        dPN.put("#(太委屈)", "b15");
        dPN.put("#(大哭)", "b16");
        dPN.put("#(泪奔)", "b17");
        dPN.put("#(寻死)", "b18");
        dPN.put("#(非常惊讶)", "b19");
        dPN.put("#(表示疑问)", "b20");
        dPN.put("#(暗中观察)", "image_emoticon85");
        dPN.put("#(吃瓜)", "image_emoticon86");
        dPN.put("#(喝酒)", "image_emoticon87");
        dPN.put("#(嘿嘿嘿)", "image_emoticon88");
        dPN.put("#(噗)", "image_emoticon89");
        dPN.put("#(困成狗)", "image_emoticon90");
        dPN.put("#(微微一笑)", "image_emoticon91");
        dPN.put("#(托腮)", "image_emoticon92");
        dPN.put("#(摊手)", "image_emoticon93");
        dPN.put("#(柯基暗中观察)", "image_emoticon94");
        dPN.put("#(欢呼)", "image_emoticon95");
        dPN.put("#(炸药)", "image_emoticon96");
        dPN.put("#(突然兴奋)", "image_emoticon97");
        dPN.put("#(紧张)", "image_emoticon98");
        dPN.put("#(黑头瞪眼)", "image_emoticon99");
        dPN.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dPN.get(str);
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
                                SpannableString ad = ad(context, str5);
                                if (ad != null) {
                                    tbRichTextData.append(ad);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.JO(), name, str3);
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
                    SpannableString ad2 = ad(context, str5);
                    if (ad2 != null) {
                        tbRichTextData.append(ad2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gb = TbFaceManager.EZ().gb(str);
        if (gb != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gb);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0098a gB = TbFaceManager.EZ().gB(str);
            if (gB != null) {
                int width = (int) (0.5d * gB.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ad(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ax.P(context, str);
    }
}
