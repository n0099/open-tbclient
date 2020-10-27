package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> jOV = new HashMap<>();

    static {
        jOV.put("#(呵呵)", "image_emoticon");
        jOV.put("#(哈哈)", "image_emoticon2");
        jOV.put("#(吐舌)", "image_emoticon3");
        jOV.put("#(啊)", "image_emoticon4");
        jOV.put("#(啊?)", "image_emoticon4");
        jOV.put("#(酷)", "image_emoticon5");
        jOV.put("#(怒)", "image_emoticon6");
        jOV.put("#(开心)", "image_emoticon7");
        jOV.put("#(汗)", "image_emoticon8");
        jOV.put("#(泪)", "image_emoticon9");
        jOV.put("#(黑线)", "image_emoticon10");
        jOV.put("#(鄙视)", "image_emoticon11");
        jOV.put("#(不高兴)", "image_emoticon12");
        jOV.put("#(真棒)", "image_emoticon13");
        jOV.put("#(钱)", "image_emoticon14");
        jOV.put("#(疑问)", "image_emoticon15");
        jOV.put("#(阴险)", "image_emoticon16");
        jOV.put("#(吐)", "image_emoticon17");
        jOV.put("#(咦)", "image_emoticon18");
        jOV.put("#(咦?)", "image_emoticon18");
        jOV.put("#(委屈)", "image_emoticon19");
        jOV.put("#(花心)", "image_emoticon20");
        jOV.put("#(呼~)", "image_emoticon21");
        jOV.put("#(笑眼)", "image_emoticon22");
        jOV.put("#(冷)", "image_emoticon23");
        jOV.put("#(太开心)", "image_emoticon24");
        jOV.put("#(滑稽)", "image_emoticon25");
        jOV.put("#(勉强)", "image_emoticon26");
        jOV.put("#(狂汗)", "image_emoticon27");
        jOV.put("#(乖)", "image_emoticon28");
        jOV.put("#(睡觉)", "image_emoticon29");
        jOV.put("#(惊哭)", "image_emoticon30");
        jOV.put("#(升起)", "image_emoticon31");
        jOV.put("#(惊讶)", "image_emoticon32");
        jOV.put("#(喷)", "image_emoticon33");
        jOV.put("#(爱心)", "image_emoticon34");
        jOV.put("#(心碎)", "image_emoticon35");
        jOV.put("#(玫瑰)", "image_emoticon36");
        jOV.put("#(礼物)", "image_emoticon37");
        jOV.put("#(彩虹)", "image_emoticon38");
        jOV.put("#(星星月亮)", "image_emoticon39");
        jOV.put("#(太阳)", "image_emoticon40");
        jOV.put("#(钱币)", "image_emoticon41");
        jOV.put("#(灯泡)", "image_emoticon42");
        jOV.put("#(茶杯)", "image_emoticon43");
        jOV.put("#(蛋糕)", "image_emoticon44");
        jOV.put("#(音乐)", "image_emoticon45");
        jOV.put("#(haha)", "image_emoticon46");
        jOV.put("#(胜利)", "image_emoticon47");
        jOV.put("#(大拇指)", "image_emoticon48");
        jOV.put("#(弱)", "image_emoticon49");
        jOV.put("#(OK)", "image_emoticon50");
        jOV.put("#(哼)", "image_emoticon61");
        jOV.put("#(吃瓜)", "image_emoticon62");
        jOV.put("#(扔便便)", "image_emoticon63");
        jOV.put("#(惊恐)", "image_emoticon64");
        jOV.put("#(哎呦)", "image_emoticon65");
        jOV.put("#(小乖)", "image_emoticon66");
        jOV.put("#(捂嘴笑)", "image_emoticon67");
        jOV.put("#(你懂的)", "image_emoticon68");
        jOV.put("#(what)", "image_emoticon69");
        jOV.put("#(酸爽)", "image_emoticon70");
        jOV.put("#(呀咩爹)", "image_emoticon71");
        jOV.put("#(笑尿)", "image_emoticon72");
        jOV.put("#(挖鼻)", "image_emoticon73");
        jOV.put("#(犀利)", "image_emoticon74");
        jOV.put("#(小红脸)", "image_emoticon75");
        jOV.put("#(懒得理)", "image_emoticon76");
        jOV.put("#(沙发)", "image_emoticon77");
        jOV.put("#(手纸)", "image_emoticon78");
        jOV.put("#(香蕉)", "image_emoticon79");
        jOV.put("#(便便)", "image_emoticon80");
        jOV.put("#(药丸)", "image_emoticon81");
        jOV.put("#(红领巾)", "image_emoticon82");
        jOV.put("#(蜡烛)", "image_emoticon83");
        jOV.put("#(三道杠)", "image_emoticon84");
        jOV.put("#(赖皮)", "ali_001");
        jOV.put("#(感动)", "ali_002");
        jOV.put("#(十分惊讶)", "ali_003");
        jOV.put("#(怒气)", "ali_004");
        jOV.put("#(哭泣)", "ali_005");
        jOV.put("#(吃惊)", "ali_006");
        jOV.put("#(嘲弄)", "ali_007");
        jOV.put("#(飘过)", "ali_008");
        jOV.put("#(转圈哭)", "ali_009");
        jOV.put("#(神经病)", "ali_010");
        jOV.put("#(揪耳朵)", "ali_011");
        jOV.put("#(惊汗)", "ali_012");
        jOV.put("#(隐身)", "ali_013");
        jOV.put("#(不要嘛)", "ali_014");
        jOV.put("#(遁)", "ali_015");
        jOV.put("#(不公平)", "ali_016");
        jOV.put("#(爬来了)", "ali_017");
        jOV.put("#(蛋花哭)", "ali_018");
        jOV.put("#(温暖)", "ali_019");
        jOV.put("#(点头)", "ali_020");
        jOV.put("#(撒钱)", "ali_021");
        jOV.put("#(献花)", "ali_022");
        jOV.put("#(寒)", "ali_023");
        jOV.put("#(傻笑)", "ali_024");
        jOV.put("#(扭扭)", "ali_025");
        jOV.put("#(疯)", "ali_026");
        jOV.put("#(抓狂)", "ali_027");
        jOV.put("#(抓)", "ali_028");
        jOV.put("#(蜷)", "ali_029");
        jOV.put("#(挠墙)", "ali_030");
        jOV.put("#(狂笑)", "ali_031");
        jOV.put("#(抱枕)", "ali_032");
        jOV.put("#(吼叫)", "ali_033");
        jOV.put("#(嚷)", "ali_034");
        jOV.put("#(唠叨)", "ali_035");
        jOV.put("#(捏脸)", "ali_036");
        jOV.put("#(爆笑)", "ali_037");
        jOV.put("#(郁闷)", "ali_038");
        jOV.put("#(潜水)", "ali_039");
        jOV.put("#(十分开心)", "ali_040");
        jOV.put("#(冷笑话)", "ali_041");
        jOV.put("#(顶！)", "ali_042");
        jOV.put("#(潜)", "ali_043");
        jOV.put("#(画圈圈)", "ali_044");
        jOV.put("#(玩电脑)", "ali_045");
        jOV.put("#(狂吐)", "ali_046");
        jOV.put("#(哭着跑)", "ali_047");
        jOV.put("#(阿狸侠)", "ali_048");
        jOV.put("#(冷死了)", "ali_049");
        jOV.put("#(惆怅~)", "ali_050");
        jOV.put("#(摸头)", "ali_051");
        jOV.put("#(蹭)", "ali_052");
        jOV.put("#(打滚)", "ali_053");
        jOV.put("#(叩拜)", "ali_054");
        jOV.put("#(摸)", "ali_055");
        jOV.put("#(数钱)", "ali_056");
        jOV.put("#(拖走)", "ali_057");
        jOV.put("#(热)", "ali_058");
        jOV.put("#(加1)", "ali_059");
        jOV.put("#(压力)", "ali_060");
        jOV.put("#(表逼我)", "ali_061");
        jOV.put("#(人呢)", "ali_062");
        jOV.put("#(摇晃)", "ali_063");
        jOV.put("#(打地鼠)", "ali_064");
        jOV.put("#(这个屌)", "ali_065");
        jOV.put("#(恐慌)", "ali_066");
        jOV.put("#(晕乎乎)", "ali_067");
        jOV.put("#(浮云)", "ali_068");
        jOV.put("#(给力)", "ali_069");
        jOV.put("#(杯具了)", "ali_070");
        jOV.put("#(焦糖舞)", "yz_001");
        jOV.put("#(翻滚)", "yz_002");
        jOV.put("#(拍屁股做鬼脸)", "yz_003");
        jOV.put("#(不)", "yz_004");
        jOV.put("#(河蟹掉啦)", "yz_005");
        jOV.put("#(哦耶)", "yz_006");
        jOV.put("#(我倒)", "yz_007");
        jOV.put("#(投降)", "yz_008");
        jOV.put("#(微笑)", "b01");
        jOV.put("#(帅哥)", "b02");
        jOV.put("#(美女)", "b03");
        jOV.put("#(老大)", "b04");
        jOV.put("#(哈哈哈)", "b05");
        jOV.put("#(奸笑)", "b06");
        jOV.put("#(傻乐)", "b07");
        jOV.put("#(飞吻)", "b08");
        jOV.put("#(害羞)", "b09");
        jOV.put("#(花痴)", "b10");
        jOV.put("#(憧憬)", "b11");
        jOV.put("#(你牛)", "b12");
        jOV.put("#(鼓掌)", "b13");
        jOV.put("#(可爱)", "b14");
        jOV.put("#(太委屈)", "b15");
        jOV.put("#(大哭)", "b16");
        jOV.put("#(泪奔)", "b17");
        jOV.put("#(寻死)", "b18");
        jOV.put("#(非常惊讶)", "b19");
        jOV.put("#(表示疑问)", "b20");
        jOV.put("#(暗中观察)", "image_emoticon85");
        jOV.put("#(吃瓜)", "image_emoticon86");
        jOV.put("#(喝酒)", "image_emoticon87");
        jOV.put("#(嘿嘿嘿)", "image_emoticon88");
        jOV.put("#(噗)", "image_emoticon89");
        jOV.put("#(困成狗)", "image_emoticon90");
        jOV.put("#(微微一笑)", "image_emoticon91");
        jOV.put("#(托腮)", "image_emoticon92");
        jOV.put("#(摊手)", "image_emoticon93");
        jOV.put("#(柯基暗中观察)", "image_emoticon94");
        jOV.put("#(欢呼)", "image_emoticon95");
        jOV.put("#(炸药)", "image_emoticon96");
        jOV.put("#(突然兴奋)", "image_emoticon97");
        jOV.put("#(紧张)", "image_emoticon98");
        jOV.put("#(黑头瞪眼)", "image_emoticon99");
        jOV.put("#(黑头高兴)", "image_emoticon100");
        jOV.put("#(不跟丑人说话)", "image_emoticon101");
        jOV.put("#(么么哒)", "image_emoticon102");
        jOV.put("#(亲亲才能起来)", "image_emoticon103");
        jOV.put("#(伦家只是宝宝)", "image_emoticon104");
        jOV.put("#(你是我的人)", "image_emoticon105");
        jOV.put("#(假装看不见)", "image_emoticon106");
        jOV.put("#(单身等撩)", "image_emoticon107");
        jOV.put("#(吓到宝宝了)", "image_emoticon108");
        jOV.put("#(哈哈哈)", "image_emoticon109");
        jOV.put("#(嗯嗯)", "image_emoticon110");
        jOV.put("#(好幸福)", "image_emoticon111");
        jOV.put("#(宝宝不开心)", "image_emoticon112");
        jOV.put("#(小姐姐别走)", "image_emoticon113");
        jOV.put("#(小姐姐在吗)", "image_emoticon114");
        jOV.put("#(小姐姐来啦)", "image_emoticon115");
        jOV.put("#(小姐姐来玩呀)", "image_emoticon116");
        jOV.put("#(我养你)", "image_emoticon117");
        jOV.put("#(我是不会骗你的)", "image_emoticon118");
        jOV.put("#(扎心了)", "image_emoticon119");
        jOV.put("#(无聊)", "image_emoticon120");
        jOV.put("#(月亮代表我的心)", "image_emoticon121");
        jOV.put("#(来追我呀)", "image_emoticon122");
        jOV.put("#(爱你的形状)", "image_emoticon123");
        jOV.put("#(白眼)", "image_emoticon124");
    }

    private static String LM(String str) {
        return jOV.get(str);
    }

    public static ArrayList<TbRichTextData> d(Context context, String str, int i) {
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
                    String LM = LM(str3);
                    if (TextUtils.isEmpty(LM)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.o(str5);
                            } else {
                                SpannableString aP = aP(context, str5);
                                if (aP != null) {
                                    tbRichTextData.o(aP);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bDo(), LM, str3);
                        if (a2 != null) {
                            tbRichTextData.o(a2);
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
                    tbRichTextData.o(str5);
                } else {
                    SpannableString aP2 = aP(context, str5);
                    if (aP2 != null) {
                        tbRichTextData.o(aP2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int Dp = TbFaceManager.byD().Dp(str);
        if (Dp != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), Dp);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0581a DK = TbFaceManager.byD().DK(str);
            if (DK != null) {
                int width = (int) (0.5d * DK.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aP(Context context, String str) {
        if (str == null) {
            return null;
        }
        return be.au(context, str);
    }
}
