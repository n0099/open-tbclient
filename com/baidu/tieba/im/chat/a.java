package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> eKF = new HashMap<>();

    static {
        eKF.put("#(呵呵)", "image_emoticon");
        eKF.put("#(哈哈)", "image_emoticon2");
        eKF.put("#(吐舌)", "image_emoticon3");
        eKF.put("#(啊)", "image_emoticon4");
        eKF.put("#(啊?)", "image_emoticon4");
        eKF.put("#(酷)", "image_emoticon5");
        eKF.put("#(怒)", "image_emoticon6");
        eKF.put("#(开心)", "image_emoticon7");
        eKF.put("#(汗)", "image_emoticon8");
        eKF.put("#(泪)", "image_emoticon9");
        eKF.put("#(黑线)", "image_emoticon10");
        eKF.put("#(鄙视)", "image_emoticon11");
        eKF.put("#(不高兴)", "image_emoticon12");
        eKF.put("#(真棒)", "image_emoticon13");
        eKF.put("#(钱)", "image_emoticon14");
        eKF.put("#(疑问)", "image_emoticon15");
        eKF.put("#(阴险)", "image_emoticon16");
        eKF.put("#(吐)", "image_emoticon17");
        eKF.put("#(咦)", "image_emoticon18");
        eKF.put("#(咦?)", "image_emoticon18");
        eKF.put("#(委屈)", "image_emoticon19");
        eKF.put("#(花心)", "image_emoticon20");
        eKF.put("#(呼~)", "image_emoticon21");
        eKF.put("#(笑眼)", "image_emoticon22");
        eKF.put("#(冷)", "image_emoticon23");
        eKF.put("#(太开心)", "image_emoticon24");
        eKF.put("#(滑稽)", "image_emoticon25");
        eKF.put("#(勉强)", "image_emoticon26");
        eKF.put("#(狂汗)", "image_emoticon27");
        eKF.put("#(乖)", "image_emoticon28");
        eKF.put("#(睡觉)", "image_emoticon29");
        eKF.put("#(惊哭)", "image_emoticon30");
        eKF.put("#(升起)", "image_emoticon31");
        eKF.put("#(惊讶)", "image_emoticon32");
        eKF.put("#(喷)", "image_emoticon33");
        eKF.put("#(爱心)", "image_emoticon34");
        eKF.put("#(心碎)", "image_emoticon35");
        eKF.put("#(玫瑰)", "image_emoticon36");
        eKF.put("#(礼物)", "image_emoticon37");
        eKF.put("#(彩虹)", "image_emoticon38");
        eKF.put("#(星星月亮)", "image_emoticon39");
        eKF.put("#(太阳)", "image_emoticon40");
        eKF.put("#(钱币)", "image_emoticon41");
        eKF.put("#(灯泡)", "image_emoticon42");
        eKF.put("#(茶杯)", "image_emoticon43");
        eKF.put("#(蛋糕)", "image_emoticon44");
        eKF.put("#(音乐)", "image_emoticon45");
        eKF.put("#(haha)", "image_emoticon46");
        eKF.put("#(胜利)", "image_emoticon47");
        eKF.put("#(大拇指)", "image_emoticon48");
        eKF.put("#(弱)", "image_emoticon49");
        eKF.put("#(OK)", "image_emoticon50");
        eKF.put("#(哼)", "image_emoticon61");
        eKF.put("#(吃瓜)", "image_emoticon62");
        eKF.put("#(扔便便)", "image_emoticon63");
        eKF.put("#(惊恐)", "image_emoticon64");
        eKF.put("#(哎呦)", "image_emoticon65");
        eKF.put("#(小乖)", "image_emoticon66");
        eKF.put("#(捂嘴笑)", "image_emoticon67");
        eKF.put("#(你懂的)", "image_emoticon68");
        eKF.put("#(what)", "image_emoticon69");
        eKF.put("#(酸爽)", "image_emoticon70");
        eKF.put("#(呀咩爹)", "image_emoticon71");
        eKF.put("#(笑尿)", "image_emoticon72");
        eKF.put("#(挖鼻)", "image_emoticon73");
        eKF.put("#(犀利)", "image_emoticon74");
        eKF.put("#(小红脸)", "image_emoticon75");
        eKF.put("#(懒得理)", "image_emoticon76");
        eKF.put("#(沙发)", "image_emoticon77");
        eKF.put("#(手纸)", "image_emoticon78");
        eKF.put("#(香蕉)", "image_emoticon79");
        eKF.put("#(便便)", "image_emoticon80");
        eKF.put("#(药丸)", "image_emoticon81");
        eKF.put("#(红领巾)", "image_emoticon82");
        eKF.put("#(蜡烛)", "image_emoticon83");
        eKF.put("#(三道杠)", "image_emoticon84");
        eKF.put("#(赖皮)", "ali_001");
        eKF.put("#(感动)", "ali_002");
        eKF.put("#(十分惊讶)", "ali_003");
        eKF.put("#(怒气)", "ali_004");
        eKF.put("#(哭泣)", "ali_005");
        eKF.put("#(吃惊)", "ali_006");
        eKF.put("#(嘲弄)", "ali_007");
        eKF.put("#(飘过)", "ali_008");
        eKF.put("#(转圈哭)", "ali_009");
        eKF.put("#(神经病)", "ali_010");
        eKF.put("#(揪耳朵)", "ali_011");
        eKF.put("#(惊汗)", "ali_012");
        eKF.put("#(隐身)", "ali_013");
        eKF.put("#(不要嘛)", "ali_014");
        eKF.put("#(遁)", "ali_015");
        eKF.put("#(不公平)", "ali_016");
        eKF.put("#(爬来了)", "ali_017");
        eKF.put("#(蛋花哭)", "ali_018");
        eKF.put("#(温暖)", "ali_019");
        eKF.put("#(点头)", "ali_020");
        eKF.put("#(撒钱)", "ali_021");
        eKF.put("#(献花)", "ali_022");
        eKF.put("#(寒)", "ali_023");
        eKF.put("#(傻笑)", "ali_024");
        eKF.put("#(扭扭)", "ali_025");
        eKF.put("#(疯)", "ali_026");
        eKF.put("#(抓狂)", "ali_027");
        eKF.put("#(抓)", "ali_028");
        eKF.put("#(蜷)", "ali_029");
        eKF.put("#(挠墙)", "ali_030");
        eKF.put("#(狂笑)", "ali_031");
        eKF.put("#(抱枕)", "ali_032");
        eKF.put("#(吼叫)", "ali_033");
        eKF.put("#(嚷)", "ali_034");
        eKF.put("#(唠叨)", "ali_035");
        eKF.put("#(捏脸)", "ali_036");
        eKF.put("#(爆笑)", "ali_037");
        eKF.put("#(郁闷)", "ali_038");
        eKF.put("#(潜水)", "ali_039");
        eKF.put("#(十分开心)", "ali_040");
        eKF.put("#(冷笑话)", "ali_041");
        eKF.put("#(顶！)", "ali_042");
        eKF.put("#(潜)", "ali_043");
        eKF.put("#(画圈圈)", "ali_044");
        eKF.put("#(玩电脑)", "ali_045");
        eKF.put("#(狂吐)", "ali_046");
        eKF.put("#(哭着跑)", "ali_047");
        eKF.put("#(阿狸侠)", "ali_048");
        eKF.put("#(冷死了)", "ali_049");
        eKF.put("#(惆怅~)", "ali_050");
        eKF.put("#(摸头)", "ali_051");
        eKF.put("#(蹭)", "ali_052");
        eKF.put("#(打滚)", "ali_053");
        eKF.put("#(叩拜)", "ali_054");
        eKF.put("#(摸)", "ali_055");
        eKF.put("#(数钱)", "ali_056");
        eKF.put("#(拖走)", "ali_057");
        eKF.put("#(热)", "ali_058");
        eKF.put("#(加1)", "ali_059");
        eKF.put("#(压力)", "ali_060");
        eKF.put("#(表逼我)", "ali_061");
        eKF.put("#(人呢)", "ali_062");
        eKF.put("#(摇晃)", "ali_063");
        eKF.put("#(打地鼠)", "ali_064");
        eKF.put("#(这个屌)", "ali_065");
        eKF.put("#(恐慌)", "ali_066");
        eKF.put("#(晕乎乎)", "ali_067");
        eKF.put("#(浮云)", "ali_068");
        eKF.put("#(给力)", "ali_069");
        eKF.put("#(杯具了)", "ali_070");
        eKF.put("#(焦糖舞)", "yz_001");
        eKF.put("#(翻滚)", "yz_002");
        eKF.put("#(拍屁股做鬼脸)", "yz_003");
        eKF.put("#(不)", "yz_004");
        eKF.put("#(河蟹掉啦)", "yz_005");
        eKF.put("#(哦耶)", "yz_006");
        eKF.put("#(我倒)", "yz_007");
        eKF.put("#(投降)", "yz_008");
        eKF.put("#(微笑)", "b01");
        eKF.put("#(帅哥)", "b02");
        eKF.put("#(美女)", "b03");
        eKF.put("#(老大)", "b04");
        eKF.put("#(哈哈哈)", "b05");
        eKF.put("#(奸笑)", "b06");
        eKF.put("#(傻乐)", "b07");
        eKF.put("#(飞吻)", "b08");
        eKF.put("#(害羞)", "b09");
        eKF.put("#(花痴)", "b10");
        eKF.put("#(憧憬)", "b11");
        eKF.put("#(你牛)", "b12");
        eKF.put("#(鼓掌)", "b13");
        eKF.put("#(可爱)", "b14");
        eKF.put("#(太委屈)", "b15");
        eKF.put("#(大哭)", "b16");
        eKF.put("#(泪奔)", "b17");
        eKF.put("#(寻死)", "b18");
        eKF.put("#(非常惊讶)", "b19");
        eKF.put("#(表示疑问)", "b20");
        eKF.put("#(暗中观察)", "image_emoticon85");
        eKF.put("#(吃瓜)", "image_emoticon86");
        eKF.put("#(喝酒)", "image_emoticon87");
        eKF.put("#(嘿嘿嘿)", "image_emoticon88");
        eKF.put("#(噗)", "image_emoticon89");
        eKF.put("#(困成狗)", "image_emoticon90");
        eKF.put("#(微微一笑)", "image_emoticon91");
        eKF.put("#(托腮)", "image_emoticon92");
        eKF.put("#(摊手)", "image_emoticon93");
        eKF.put("#(柯基暗中观察)", "image_emoticon94");
        eKF.put("#(欢呼)", "image_emoticon95");
        eKF.put("#(炸药)", "image_emoticon96");
        eKF.put("#(突然兴奋)", "image_emoticon97");
        eKF.put("#(紧张)", "image_emoticon98");
        eKF.put("#(黑头瞪眼)", "image_emoticon99");
        eKF.put("#(黑头高兴)", "image_emoticon100");
        eKF.put("#(不跟丑人说话)", "image_emoticon101");
        eKF.put("#(么么哒)", "image_emoticon102");
        eKF.put("#(亲亲才能起来)", "image_emoticon103");
        eKF.put("#(伦家只是宝宝)", "image_emoticon104");
        eKF.put("#(你是我的人)", "image_emoticon105");
        eKF.put("#(假装看不见)", "image_emoticon106");
        eKF.put("#(单身等撩)", "image_emoticon107");
        eKF.put("#(吓到宝宝了)", "image_emoticon108");
        eKF.put("#(哈哈哈)", "image_emoticon109");
        eKF.put("#(嗯嗯)", "image_emoticon110");
        eKF.put("#(好幸福)", "image_emoticon111");
        eKF.put("#(宝宝不开心)", "image_emoticon112");
        eKF.put("#(小姐姐别走)", "image_emoticon113");
        eKF.put("#(小姐姐在吗)", "image_emoticon114");
        eKF.put("#(小姐姐来啦)", "image_emoticon115");
        eKF.put("#(小姐姐来玩呀)", "image_emoticon116");
        eKF.put("#(我养你)", "image_emoticon117");
        eKF.put("#(我是不会骗你的)", "image_emoticon118");
        eKF.put("#(扎心了)", "image_emoticon119");
        eKF.put("#(无聊)", "image_emoticon120");
        eKF.put("#(月亮代表我的心)", "image_emoticon121");
        eKF.put("#(来追我呀)", "image_emoticon122");
        eKF.put("#(爱你的形状)", "image_emoticon123");
        eKF.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return eKF.get(str);
    }

    public static ArrayList<TbRichTextData> h(Context context, String str, int i) {
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
                                SpannableString ax = ax(context, str5);
                                if (ax != null) {
                                    tbRichTextData.append(ax);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.SC(), name, str3);
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
                    SpannableString ax2 = ax(context, str5);
                    if (ax2 != null) {
                        tbRichTextData.append(ax2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int hS = TbFaceManager.NL().hS(str);
        if (hS != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), hS);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0171a ir = TbFaceManager.NL().ir(str);
            if (ir != null) {
                int width = (int) (0.5d * ir.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ax(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ay.ai(context, str);
    }
}
