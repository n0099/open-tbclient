package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> evd = new HashMap<>();

    static {
        evd.put("#(呵呵)", "image_emoticon");
        evd.put("#(哈哈)", "image_emoticon2");
        evd.put("#(吐舌)", "image_emoticon3");
        evd.put("#(啊)", "image_emoticon4");
        evd.put("#(啊?)", "image_emoticon4");
        evd.put("#(酷)", "image_emoticon5");
        evd.put("#(怒)", "image_emoticon6");
        evd.put("#(开心)", "image_emoticon7");
        evd.put("#(汗)", "image_emoticon8");
        evd.put("#(泪)", "image_emoticon9");
        evd.put("#(黑线)", "image_emoticon10");
        evd.put("#(鄙视)", "image_emoticon11");
        evd.put("#(不高兴)", "image_emoticon12");
        evd.put("#(真棒)", "image_emoticon13");
        evd.put("#(钱)", "image_emoticon14");
        evd.put("#(疑问)", "image_emoticon15");
        evd.put("#(阴险)", "image_emoticon16");
        evd.put("#(吐)", "image_emoticon17");
        evd.put("#(咦)", "image_emoticon18");
        evd.put("#(咦?)", "image_emoticon18");
        evd.put("#(委屈)", "image_emoticon19");
        evd.put("#(花心)", "image_emoticon20");
        evd.put("#(呼~)", "image_emoticon21");
        evd.put("#(笑眼)", "image_emoticon22");
        evd.put("#(冷)", "image_emoticon23");
        evd.put("#(太开心)", "image_emoticon24");
        evd.put("#(滑稽)", "image_emoticon25");
        evd.put("#(勉强)", "image_emoticon26");
        evd.put("#(狂汗)", "image_emoticon27");
        evd.put("#(乖)", "image_emoticon28");
        evd.put("#(睡觉)", "image_emoticon29");
        evd.put("#(惊哭)", "image_emoticon30");
        evd.put("#(升起)", "image_emoticon31");
        evd.put("#(惊讶)", "image_emoticon32");
        evd.put("#(喷)", "image_emoticon33");
        evd.put("#(爱心)", "image_emoticon34");
        evd.put("#(心碎)", "image_emoticon35");
        evd.put("#(玫瑰)", "image_emoticon36");
        evd.put("#(礼物)", "image_emoticon37");
        evd.put("#(彩虹)", "image_emoticon38");
        evd.put("#(星星月亮)", "image_emoticon39");
        evd.put("#(太阳)", "image_emoticon40");
        evd.put("#(钱币)", "image_emoticon41");
        evd.put("#(灯泡)", "image_emoticon42");
        evd.put("#(茶杯)", "image_emoticon43");
        evd.put("#(蛋糕)", "image_emoticon44");
        evd.put("#(音乐)", "image_emoticon45");
        evd.put("#(haha)", "image_emoticon46");
        evd.put("#(胜利)", "image_emoticon47");
        evd.put("#(大拇指)", "image_emoticon48");
        evd.put("#(弱)", "image_emoticon49");
        evd.put("#(OK)", "image_emoticon50");
        evd.put("#(哼)", "image_emoticon61");
        evd.put("#(吃瓜)", "image_emoticon62");
        evd.put("#(扔便便)", "image_emoticon63");
        evd.put("#(惊恐)", "image_emoticon64");
        evd.put("#(哎呦)", "image_emoticon65");
        evd.put("#(小乖)", "image_emoticon66");
        evd.put("#(捂嘴笑)", "image_emoticon67");
        evd.put("#(你懂的)", "image_emoticon68");
        evd.put("#(what)", "image_emoticon69");
        evd.put("#(酸爽)", "image_emoticon70");
        evd.put("#(呀咩爹)", "image_emoticon71");
        evd.put("#(笑尿)", "image_emoticon72");
        evd.put("#(挖鼻)", "image_emoticon73");
        evd.put("#(犀利)", "image_emoticon74");
        evd.put("#(小红脸)", "image_emoticon75");
        evd.put("#(懒得理)", "image_emoticon76");
        evd.put("#(沙发)", "image_emoticon77");
        evd.put("#(手纸)", "image_emoticon78");
        evd.put("#(香蕉)", "image_emoticon79");
        evd.put("#(便便)", "image_emoticon80");
        evd.put("#(药丸)", "image_emoticon81");
        evd.put("#(红领巾)", "image_emoticon82");
        evd.put("#(蜡烛)", "image_emoticon83");
        evd.put("#(三道杠)", "image_emoticon84");
        evd.put("#(赖皮)", "ali_001");
        evd.put("#(感动)", "ali_002");
        evd.put("#(十分惊讶)", "ali_003");
        evd.put("#(怒气)", "ali_004");
        evd.put("#(哭泣)", "ali_005");
        evd.put("#(吃惊)", "ali_006");
        evd.put("#(嘲弄)", "ali_007");
        evd.put("#(飘过)", "ali_008");
        evd.put("#(转圈哭)", "ali_009");
        evd.put("#(神经病)", "ali_010");
        evd.put("#(揪耳朵)", "ali_011");
        evd.put("#(惊汗)", "ali_012");
        evd.put("#(隐身)", "ali_013");
        evd.put("#(不要嘛)", "ali_014");
        evd.put("#(遁)", "ali_015");
        evd.put("#(不公平)", "ali_016");
        evd.put("#(爬来了)", "ali_017");
        evd.put("#(蛋花哭)", "ali_018");
        evd.put("#(温暖)", "ali_019");
        evd.put("#(点头)", "ali_020");
        evd.put("#(撒钱)", "ali_021");
        evd.put("#(献花)", "ali_022");
        evd.put("#(寒)", "ali_023");
        evd.put("#(傻笑)", "ali_024");
        evd.put("#(扭扭)", "ali_025");
        evd.put("#(疯)", "ali_026");
        evd.put("#(抓狂)", "ali_027");
        evd.put("#(抓)", "ali_028");
        evd.put("#(蜷)", "ali_029");
        evd.put("#(挠墙)", "ali_030");
        evd.put("#(狂笑)", "ali_031");
        evd.put("#(抱枕)", "ali_032");
        evd.put("#(吼叫)", "ali_033");
        evd.put("#(嚷)", "ali_034");
        evd.put("#(唠叨)", "ali_035");
        evd.put("#(捏脸)", "ali_036");
        evd.put("#(爆笑)", "ali_037");
        evd.put("#(郁闷)", "ali_038");
        evd.put("#(潜水)", "ali_039");
        evd.put("#(十分开心)", "ali_040");
        evd.put("#(冷笑话)", "ali_041");
        evd.put("#(顶！)", "ali_042");
        evd.put("#(潜)", "ali_043");
        evd.put("#(画圈圈)", "ali_044");
        evd.put("#(玩电脑)", "ali_045");
        evd.put("#(狂吐)", "ali_046");
        evd.put("#(哭着跑)", "ali_047");
        evd.put("#(阿狸侠)", "ali_048");
        evd.put("#(冷死了)", "ali_049");
        evd.put("#(惆怅~)", "ali_050");
        evd.put("#(摸头)", "ali_051");
        evd.put("#(蹭)", "ali_052");
        evd.put("#(打滚)", "ali_053");
        evd.put("#(叩拜)", "ali_054");
        evd.put("#(摸)", "ali_055");
        evd.put("#(数钱)", "ali_056");
        evd.put("#(拖走)", "ali_057");
        evd.put("#(热)", "ali_058");
        evd.put("#(加1)", "ali_059");
        evd.put("#(压力)", "ali_060");
        evd.put("#(表逼我)", "ali_061");
        evd.put("#(人呢)", "ali_062");
        evd.put("#(摇晃)", "ali_063");
        evd.put("#(打地鼠)", "ali_064");
        evd.put("#(这个屌)", "ali_065");
        evd.put("#(恐慌)", "ali_066");
        evd.put("#(晕乎乎)", "ali_067");
        evd.put("#(浮云)", "ali_068");
        evd.put("#(给力)", "ali_069");
        evd.put("#(杯具了)", "ali_070");
        evd.put("#(焦糖舞)", "yz_001");
        evd.put("#(翻滚)", "yz_002");
        evd.put("#(拍屁股做鬼脸)", "yz_003");
        evd.put("#(不)", "yz_004");
        evd.put("#(河蟹掉啦)", "yz_005");
        evd.put("#(哦耶)", "yz_006");
        evd.put("#(我倒)", "yz_007");
        evd.put("#(投降)", "yz_008");
        evd.put("#(微笑)", "b01");
        evd.put("#(帅哥)", "b02");
        evd.put("#(美女)", "b03");
        evd.put("#(老大)", "b04");
        evd.put("#(哈哈哈)", "b05");
        evd.put("#(奸笑)", "b06");
        evd.put("#(傻乐)", "b07");
        evd.put("#(飞吻)", "b08");
        evd.put("#(害羞)", "b09");
        evd.put("#(花痴)", "b10");
        evd.put("#(憧憬)", "b11");
        evd.put("#(你牛)", "b12");
        evd.put("#(鼓掌)", "b13");
        evd.put("#(可爱)", "b14");
        evd.put("#(太委屈)", "b15");
        evd.put("#(大哭)", "b16");
        evd.put("#(泪奔)", "b17");
        evd.put("#(寻死)", "b18");
        evd.put("#(非常惊讶)", "b19");
        evd.put("#(表示疑问)", "b20");
        evd.put("#(暗中观察)", "image_emoticon85");
        evd.put("#(吃瓜)", "image_emoticon86");
        evd.put("#(喝酒)", "image_emoticon87");
        evd.put("#(嘿嘿嘿)", "image_emoticon88");
        evd.put("#(噗)", "image_emoticon89");
        evd.put("#(困成狗)", "image_emoticon90");
        evd.put("#(微微一笑)", "image_emoticon91");
        evd.put("#(托腮)", "image_emoticon92");
        evd.put("#(摊手)", "image_emoticon93");
        evd.put("#(柯基暗中观察)", "image_emoticon94");
        evd.put("#(欢呼)", "image_emoticon95");
        evd.put("#(炸药)", "image_emoticon96");
        evd.put("#(突然兴奋)", "image_emoticon97");
        evd.put("#(紧张)", "image_emoticon98");
        evd.put("#(黑头瞪眼)", "image_emoticon99");
        evd.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return evd.get(str);
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
                        SpannableString b = b(tbRichTextData.Rn(), name, str3);
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

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gk = TbFaceManager.Mw().gk(str);
        if (gk != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gk);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0108a gK = TbFaceManager.Mw().gK(str);
            if (gK != null) {
                int width = (int) (0.5d * gK.getWidth());
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
        return aw.U(context, str);
    }
}
