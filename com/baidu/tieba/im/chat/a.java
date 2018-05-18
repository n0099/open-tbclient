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
    private static final HashMap<String, String> dQR = new HashMap<>();

    static {
        dQR.put("#(呵呵)", "image_emoticon");
        dQR.put("#(哈哈)", "image_emoticon2");
        dQR.put("#(吐舌)", "image_emoticon3");
        dQR.put("#(啊)", "image_emoticon4");
        dQR.put("#(啊?)", "image_emoticon4");
        dQR.put("#(酷)", "image_emoticon5");
        dQR.put("#(怒)", "image_emoticon6");
        dQR.put("#(开心)", "image_emoticon7");
        dQR.put("#(汗)", "image_emoticon8");
        dQR.put("#(泪)", "image_emoticon9");
        dQR.put("#(黑线)", "image_emoticon10");
        dQR.put("#(鄙视)", "image_emoticon11");
        dQR.put("#(不高兴)", "image_emoticon12");
        dQR.put("#(真棒)", "image_emoticon13");
        dQR.put("#(钱)", "image_emoticon14");
        dQR.put("#(疑问)", "image_emoticon15");
        dQR.put("#(阴险)", "image_emoticon16");
        dQR.put("#(吐)", "image_emoticon17");
        dQR.put("#(咦)", "image_emoticon18");
        dQR.put("#(咦?)", "image_emoticon18");
        dQR.put("#(委屈)", "image_emoticon19");
        dQR.put("#(花心)", "image_emoticon20");
        dQR.put("#(呼~)", "image_emoticon21");
        dQR.put("#(笑眼)", "image_emoticon22");
        dQR.put("#(冷)", "image_emoticon23");
        dQR.put("#(太开心)", "image_emoticon24");
        dQR.put("#(滑稽)", "image_emoticon25");
        dQR.put("#(勉强)", "image_emoticon26");
        dQR.put("#(狂汗)", "image_emoticon27");
        dQR.put("#(乖)", "image_emoticon28");
        dQR.put("#(睡觉)", "image_emoticon29");
        dQR.put("#(惊哭)", "image_emoticon30");
        dQR.put("#(升起)", "image_emoticon31");
        dQR.put("#(惊讶)", "image_emoticon32");
        dQR.put("#(喷)", "image_emoticon33");
        dQR.put("#(爱心)", "image_emoticon34");
        dQR.put("#(心碎)", "image_emoticon35");
        dQR.put("#(玫瑰)", "image_emoticon36");
        dQR.put("#(礼物)", "image_emoticon37");
        dQR.put("#(彩虹)", "image_emoticon38");
        dQR.put("#(星星月亮)", "image_emoticon39");
        dQR.put("#(太阳)", "image_emoticon40");
        dQR.put("#(钱币)", "image_emoticon41");
        dQR.put("#(灯泡)", "image_emoticon42");
        dQR.put("#(茶杯)", "image_emoticon43");
        dQR.put("#(蛋糕)", "image_emoticon44");
        dQR.put("#(音乐)", "image_emoticon45");
        dQR.put("#(haha)", "image_emoticon46");
        dQR.put("#(胜利)", "image_emoticon47");
        dQR.put("#(大拇指)", "image_emoticon48");
        dQR.put("#(弱)", "image_emoticon49");
        dQR.put("#(OK)", "image_emoticon50");
        dQR.put("#(哼)", "image_emoticon61");
        dQR.put("#(吃瓜)", "image_emoticon62");
        dQR.put("#(扔便便)", "image_emoticon63");
        dQR.put("#(惊恐)", "image_emoticon64");
        dQR.put("#(哎呦)", "image_emoticon65");
        dQR.put("#(小乖)", "image_emoticon66");
        dQR.put("#(捂嘴笑)", "image_emoticon67");
        dQR.put("#(你懂的)", "image_emoticon68");
        dQR.put("#(what)", "image_emoticon69");
        dQR.put("#(酸爽)", "image_emoticon70");
        dQR.put("#(呀咩爹)", "image_emoticon71");
        dQR.put("#(笑尿)", "image_emoticon72");
        dQR.put("#(挖鼻)", "image_emoticon73");
        dQR.put("#(犀利)", "image_emoticon74");
        dQR.put("#(小红脸)", "image_emoticon75");
        dQR.put("#(懒得理)", "image_emoticon76");
        dQR.put("#(沙发)", "image_emoticon77");
        dQR.put("#(手纸)", "image_emoticon78");
        dQR.put("#(香蕉)", "image_emoticon79");
        dQR.put("#(便便)", "image_emoticon80");
        dQR.put("#(药丸)", "image_emoticon81");
        dQR.put("#(红领巾)", "image_emoticon82");
        dQR.put("#(蜡烛)", "image_emoticon83");
        dQR.put("#(三道杠)", "image_emoticon84");
        dQR.put("#(赖皮)", "ali_001");
        dQR.put("#(感动)", "ali_002");
        dQR.put("#(十分惊讶)", "ali_003");
        dQR.put("#(怒气)", "ali_004");
        dQR.put("#(哭泣)", "ali_005");
        dQR.put("#(吃惊)", "ali_006");
        dQR.put("#(嘲弄)", "ali_007");
        dQR.put("#(飘过)", "ali_008");
        dQR.put("#(转圈哭)", "ali_009");
        dQR.put("#(神经病)", "ali_010");
        dQR.put("#(揪耳朵)", "ali_011");
        dQR.put("#(惊汗)", "ali_012");
        dQR.put("#(隐身)", "ali_013");
        dQR.put("#(不要嘛)", "ali_014");
        dQR.put("#(遁)", "ali_015");
        dQR.put("#(不公平)", "ali_016");
        dQR.put("#(爬来了)", "ali_017");
        dQR.put("#(蛋花哭)", "ali_018");
        dQR.put("#(温暖)", "ali_019");
        dQR.put("#(点头)", "ali_020");
        dQR.put("#(撒钱)", "ali_021");
        dQR.put("#(献花)", "ali_022");
        dQR.put("#(寒)", "ali_023");
        dQR.put("#(傻笑)", "ali_024");
        dQR.put("#(扭扭)", "ali_025");
        dQR.put("#(疯)", "ali_026");
        dQR.put("#(抓狂)", "ali_027");
        dQR.put("#(抓)", "ali_028");
        dQR.put("#(蜷)", "ali_029");
        dQR.put("#(挠墙)", "ali_030");
        dQR.put("#(狂笑)", "ali_031");
        dQR.put("#(抱枕)", "ali_032");
        dQR.put("#(吼叫)", "ali_033");
        dQR.put("#(嚷)", "ali_034");
        dQR.put("#(唠叨)", "ali_035");
        dQR.put("#(捏脸)", "ali_036");
        dQR.put("#(爆笑)", "ali_037");
        dQR.put("#(郁闷)", "ali_038");
        dQR.put("#(潜水)", "ali_039");
        dQR.put("#(十分开心)", "ali_040");
        dQR.put("#(冷笑话)", "ali_041");
        dQR.put("#(顶！)", "ali_042");
        dQR.put("#(潜)", "ali_043");
        dQR.put("#(画圈圈)", "ali_044");
        dQR.put("#(玩电脑)", "ali_045");
        dQR.put("#(狂吐)", "ali_046");
        dQR.put("#(哭着跑)", "ali_047");
        dQR.put("#(阿狸侠)", "ali_048");
        dQR.put("#(冷死了)", "ali_049");
        dQR.put("#(惆怅~)", "ali_050");
        dQR.put("#(摸头)", "ali_051");
        dQR.put("#(蹭)", "ali_052");
        dQR.put("#(打滚)", "ali_053");
        dQR.put("#(叩拜)", "ali_054");
        dQR.put("#(摸)", "ali_055");
        dQR.put("#(数钱)", "ali_056");
        dQR.put("#(拖走)", "ali_057");
        dQR.put("#(热)", "ali_058");
        dQR.put("#(加1)", "ali_059");
        dQR.put("#(压力)", "ali_060");
        dQR.put("#(表逼我)", "ali_061");
        dQR.put("#(人呢)", "ali_062");
        dQR.put("#(摇晃)", "ali_063");
        dQR.put("#(打地鼠)", "ali_064");
        dQR.put("#(这个屌)", "ali_065");
        dQR.put("#(恐慌)", "ali_066");
        dQR.put("#(晕乎乎)", "ali_067");
        dQR.put("#(浮云)", "ali_068");
        dQR.put("#(给力)", "ali_069");
        dQR.put("#(杯具了)", "ali_070");
        dQR.put("#(焦糖舞)", "yz_001");
        dQR.put("#(翻滚)", "yz_002");
        dQR.put("#(拍屁股做鬼脸)", "yz_003");
        dQR.put("#(不)", "yz_004");
        dQR.put("#(河蟹掉啦)", "yz_005");
        dQR.put("#(哦耶)", "yz_006");
        dQR.put("#(我倒)", "yz_007");
        dQR.put("#(投降)", "yz_008");
        dQR.put("#(微笑)", "b01");
        dQR.put("#(帅哥)", "b02");
        dQR.put("#(美女)", "b03");
        dQR.put("#(老大)", "b04");
        dQR.put("#(哈哈哈)", "b05");
        dQR.put("#(奸笑)", "b06");
        dQR.put("#(傻乐)", "b07");
        dQR.put("#(飞吻)", "b08");
        dQR.put("#(害羞)", "b09");
        dQR.put("#(花痴)", "b10");
        dQR.put("#(憧憬)", "b11");
        dQR.put("#(你牛)", "b12");
        dQR.put("#(鼓掌)", "b13");
        dQR.put("#(可爱)", "b14");
        dQR.put("#(太委屈)", "b15");
        dQR.put("#(大哭)", "b16");
        dQR.put("#(泪奔)", "b17");
        dQR.put("#(寻死)", "b18");
        dQR.put("#(非常惊讶)", "b19");
        dQR.put("#(表示疑问)", "b20");
        dQR.put("#(暗中观察)", "image_emoticon85");
        dQR.put("#(吃瓜)", "image_emoticon86");
        dQR.put("#(喝酒)", "image_emoticon87");
        dQR.put("#(嘿嘿嘿)", "image_emoticon88");
        dQR.put("#(噗)", "image_emoticon89");
        dQR.put("#(困成狗)", "image_emoticon90");
        dQR.put("#(微微一笑)", "image_emoticon91");
        dQR.put("#(托腮)", "image_emoticon92");
        dQR.put("#(摊手)", "image_emoticon93");
        dQR.put("#(柯基暗中观察)", "image_emoticon94");
        dQR.put("#(欢呼)", "image_emoticon95");
        dQR.put("#(炸药)", "image_emoticon96");
        dQR.put("#(突然兴奋)", "image_emoticon97");
        dQR.put("#(紧张)", "image_emoticon98");
        dQR.put("#(黑头瞪眼)", "image_emoticon99");
        dQR.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dQR.get(str);
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
                        SpannableString b = b(tbRichTextData.JM(), name, str3);
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
        int gb = TbFaceManager.EX().gb(str);
        if (gb != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gb);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0098a gB = TbFaceManager.EX().gB(str);
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
