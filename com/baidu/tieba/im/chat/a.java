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
    private static final HashMap<String, String> evh = new HashMap<>();

    static {
        evh.put("#(呵呵)", "image_emoticon");
        evh.put("#(哈哈)", "image_emoticon2");
        evh.put("#(吐舌)", "image_emoticon3");
        evh.put("#(啊)", "image_emoticon4");
        evh.put("#(啊?)", "image_emoticon4");
        evh.put("#(酷)", "image_emoticon5");
        evh.put("#(怒)", "image_emoticon6");
        evh.put("#(开心)", "image_emoticon7");
        evh.put("#(汗)", "image_emoticon8");
        evh.put("#(泪)", "image_emoticon9");
        evh.put("#(黑线)", "image_emoticon10");
        evh.put("#(鄙视)", "image_emoticon11");
        evh.put("#(不高兴)", "image_emoticon12");
        evh.put("#(真棒)", "image_emoticon13");
        evh.put("#(钱)", "image_emoticon14");
        evh.put("#(疑问)", "image_emoticon15");
        evh.put("#(阴险)", "image_emoticon16");
        evh.put("#(吐)", "image_emoticon17");
        evh.put("#(咦)", "image_emoticon18");
        evh.put("#(咦?)", "image_emoticon18");
        evh.put("#(委屈)", "image_emoticon19");
        evh.put("#(花心)", "image_emoticon20");
        evh.put("#(呼~)", "image_emoticon21");
        evh.put("#(笑眼)", "image_emoticon22");
        evh.put("#(冷)", "image_emoticon23");
        evh.put("#(太开心)", "image_emoticon24");
        evh.put("#(滑稽)", "image_emoticon25");
        evh.put("#(勉强)", "image_emoticon26");
        evh.put("#(狂汗)", "image_emoticon27");
        evh.put("#(乖)", "image_emoticon28");
        evh.put("#(睡觉)", "image_emoticon29");
        evh.put("#(惊哭)", "image_emoticon30");
        evh.put("#(升起)", "image_emoticon31");
        evh.put("#(惊讶)", "image_emoticon32");
        evh.put("#(喷)", "image_emoticon33");
        evh.put("#(爱心)", "image_emoticon34");
        evh.put("#(心碎)", "image_emoticon35");
        evh.put("#(玫瑰)", "image_emoticon36");
        evh.put("#(礼物)", "image_emoticon37");
        evh.put("#(彩虹)", "image_emoticon38");
        evh.put("#(星星月亮)", "image_emoticon39");
        evh.put("#(太阳)", "image_emoticon40");
        evh.put("#(钱币)", "image_emoticon41");
        evh.put("#(灯泡)", "image_emoticon42");
        evh.put("#(茶杯)", "image_emoticon43");
        evh.put("#(蛋糕)", "image_emoticon44");
        evh.put("#(音乐)", "image_emoticon45");
        evh.put("#(haha)", "image_emoticon46");
        evh.put("#(胜利)", "image_emoticon47");
        evh.put("#(大拇指)", "image_emoticon48");
        evh.put("#(弱)", "image_emoticon49");
        evh.put("#(OK)", "image_emoticon50");
        evh.put("#(哼)", "image_emoticon61");
        evh.put("#(吃瓜)", "image_emoticon62");
        evh.put("#(扔便便)", "image_emoticon63");
        evh.put("#(惊恐)", "image_emoticon64");
        evh.put("#(哎呦)", "image_emoticon65");
        evh.put("#(小乖)", "image_emoticon66");
        evh.put("#(捂嘴笑)", "image_emoticon67");
        evh.put("#(你懂的)", "image_emoticon68");
        evh.put("#(what)", "image_emoticon69");
        evh.put("#(酸爽)", "image_emoticon70");
        evh.put("#(呀咩爹)", "image_emoticon71");
        evh.put("#(笑尿)", "image_emoticon72");
        evh.put("#(挖鼻)", "image_emoticon73");
        evh.put("#(犀利)", "image_emoticon74");
        evh.put("#(小红脸)", "image_emoticon75");
        evh.put("#(懒得理)", "image_emoticon76");
        evh.put("#(沙发)", "image_emoticon77");
        evh.put("#(手纸)", "image_emoticon78");
        evh.put("#(香蕉)", "image_emoticon79");
        evh.put("#(便便)", "image_emoticon80");
        evh.put("#(药丸)", "image_emoticon81");
        evh.put("#(红领巾)", "image_emoticon82");
        evh.put("#(蜡烛)", "image_emoticon83");
        evh.put("#(三道杠)", "image_emoticon84");
        evh.put("#(赖皮)", "ali_001");
        evh.put("#(感动)", "ali_002");
        evh.put("#(十分惊讶)", "ali_003");
        evh.put("#(怒气)", "ali_004");
        evh.put("#(哭泣)", "ali_005");
        evh.put("#(吃惊)", "ali_006");
        evh.put("#(嘲弄)", "ali_007");
        evh.put("#(飘过)", "ali_008");
        evh.put("#(转圈哭)", "ali_009");
        evh.put("#(神经病)", "ali_010");
        evh.put("#(揪耳朵)", "ali_011");
        evh.put("#(惊汗)", "ali_012");
        evh.put("#(隐身)", "ali_013");
        evh.put("#(不要嘛)", "ali_014");
        evh.put("#(遁)", "ali_015");
        evh.put("#(不公平)", "ali_016");
        evh.put("#(爬来了)", "ali_017");
        evh.put("#(蛋花哭)", "ali_018");
        evh.put("#(温暖)", "ali_019");
        evh.put("#(点头)", "ali_020");
        evh.put("#(撒钱)", "ali_021");
        evh.put("#(献花)", "ali_022");
        evh.put("#(寒)", "ali_023");
        evh.put("#(傻笑)", "ali_024");
        evh.put("#(扭扭)", "ali_025");
        evh.put("#(疯)", "ali_026");
        evh.put("#(抓狂)", "ali_027");
        evh.put("#(抓)", "ali_028");
        evh.put("#(蜷)", "ali_029");
        evh.put("#(挠墙)", "ali_030");
        evh.put("#(狂笑)", "ali_031");
        evh.put("#(抱枕)", "ali_032");
        evh.put("#(吼叫)", "ali_033");
        evh.put("#(嚷)", "ali_034");
        evh.put("#(唠叨)", "ali_035");
        evh.put("#(捏脸)", "ali_036");
        evh.put("#(爆笑)", "ali_037");
        evh.put("#(郁闷)", "ali_038");
        evh.put("#(潜水)", "ali_039");
        evh.put("#(十分开心)", "ali_040");
        evh.put("#(冷笑话)", "ali_041");
        evh.put("#(顶！)", "ali_042");
        evh.put("#(潜)", "ali_043");
        evh.put("#(画圈圈)", "ali_044");
        evh.put("#(玩电脑)", "ali_045");
        evh.put("#(狂吐)", "ali_046");
        evh.put("#(哭着跑)", "ali_047");
        evh.put("#(阿狸侠)", "ali_048");
        evh.put("#(冷死了)", "ali_049");
        evh.put("#(惆怅~)", "ali_050");
        evh.put("#(摸头)", "ali_051");
        evh.put("#(蹭)", "ali_052");
        evh.put("#(打滚)", "ali_053");
        evh.put("#(叩拜)", "ali_054");
        evh.put("#(摸)", "ali_055");
        evh.put("#(数钱)", "ali_056");
        evh.put("#(拖走)", "ali_057");
        evh.put("#(热)", "ali_058");
        evh.put("#(加1)", "ali_059");
        evh.put("#(压力)", "ali_060");
        evh.put("#(表逼我)", "ali_061");
        evh.put("#(人呢)", "ali_062");
        evh.put("#(摇晃)", "ali_063");
        evh.put("#(打地鼠)", "ali_064");
        evh.put("#(这个屌)", "ali_065");
        evh.put("#(恐慌)", "ali_066");
        evh.put("#(晕乎乎)", "ali_067");
        evh.put("#(浮云)", "ali_068");
        evh.put("#(给力)", "ali_069");
        evh.put("#(杯具了)", "ali_070");
        evh.put("#(焦糖舞)", "yz_001");
        evh.put("#(翻滚)", "yz_002");
        evh.put("#(拍屁股做鬼脸)", "yz_003");
        evh.put("#(不)", "yz_004");
        evh.put("#(河蟹掉啦)", "yz_005");
        evh.put("#(哦耶)", "yz_006");
        evh.put("#(我倒)", "yz_007");
        evh.put("#(投降)", "yz_008");
        evh.put("#(微笑)", "b01");
        evh.put("#(帅哥)", "b02");
        evh.put("#(美女)", "b03");
        evh.put("#(老大)", "b04");
        evh.put("#(哈哈哈)", "b05");
        evh.put("#(奸笑)", "b06");
        evh.put("#(傻乐)", "b07");
        evh.put("#(飞吻)", "b08");
        evh.put("#(害羞)", "b09");
        evh.put("#(花痴)", "b10");
        evh.put("#(憧憬)", "b11");
        evh.put("#(你牛)", "b12");
        evh.put("#(鼓掌)", "b13");
        evh.put("#(可爱)", "b14");
        evh.put("#(太委屈)", "b15");
        evh.put("#(大哭)", "b16");
        evh.put("#(泪奔)", "b17");
        evh.put("#(寻死)", "b18");
        evh.put("#(非常惊讶)", "b19");
        evh.put("#(表示疑问)", "b20");
        evh.put("#(暗中观察)", "image_emoticon85");
        evh.put("#(吃瓜)", "image_emoticon86");
        evh.put("#(喝酒)", "image_emoticon87");
        evh.put("#(嘿嘿嘿)", "image_emoticon88");
        evh.put("#(噗)", "image_emoticon89");
        evh.put("#(困成狗)", "image_emoticon90");
        evh.put("#(微微一笑)", "image_emoticon91");
        evh.put("#(托腮)", "image_emoticon92");
        evh.put("#(摊手)", "image_emoticon93");
        evh.put("#(柯基暗中观察)", "image_emoticon94");
        evh.put("#(欢呼)", "image_emoticon95");
        evh.put("#(炸药)", "image_emoticon96");
        evh.put("#(突然兴奋)", "image_emoticon97");
        evh.put("#(紧张)", "image_emoticon98");
        evh.put("#(黑头瞪眼)", "image_emoticon99");
        evh.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return evh.get(str);
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
            a.C0109a gK = TbFaceManager.Mw().gK(str);
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
