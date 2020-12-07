package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> kjh = new HashMap<>();

    static {
        kjh.put("#(呵呵)", "image_emoticon");
        kjh.put("#(哈哈)", "image_emoticon2");
        kjh.put("#(吐舌)", "image_emoticon3");
        kjh.put("#(啊)", "image_emoticon4");
        kjh.put("#(啊?)", "image_emoticon4");
        kjh.put("#(酷)", "image_emoticon5");
        kjh.put("#(怒)", "image_emoticon6");
        kjh.put("#(开心)", "image_emoticon7");
        kjh.put("#(汗)", "image_emoticon8");
        kjh.put("#(泪)", "image_emoticon9");
        kjh.put("#(黑线)", "image_emoticon10");
        kjh.put("#(鄙视)", "image_emoticon11");
        kjh.put("#(不高兴)", "image_emoticon12");
        kjh.put("#(真棒)", "image_emoticon13");
        kjh.put("#(钱)", "image_emoticon14");
        kjh.put("#(疑问)", "image_emoticon15");
        kjh.put("#(阴险)", "image_emoticon16");
        kjh.put("#(吐)", "image_emoticon17");
        kjh.put("#(咦)", "image_emoticon18");
        kjh.put("#(咦?)", "image_emoticon18");
        kjh.put("#(委屈)", "image_emoticon19");
        kjh.put("#(花心)", "image_emoticon20");
        kjh.put("#(呼~)", "image_emoticon21");
        kjh.put("#(笑眼)", "image_emoticon22");
        kjh.put("#(冷)", "image_emoticon23");
        kjh.put("#(太开心)", "image_emoticon24");
        kjh.put("#(滑稽)", "image_emoticon25");
        kjh.put("#(勉强)", "image_emoticon26");
        kjh.put("#(狂汗)", "image_emoticon27");
        kjh.put("#(乖)", "image_emoticon28");
        kjh.put("#(睡觉)", "image_emoticon29");
        kjh.put("#(惊哭)", "image_emoticon30");
        kjh.put("#(升起)", "image_emoticon31");
        kjh.put("#(惊讶)", "image_emoticon32");
        kjh.put("#(喷)", "image_emoticon33");
        kjh.put("#(爱心)", "image_emoticon34");
        kjh.put("#(心碎)", "image_emoticon35");
        kjh.put("#(玫瑰)", "image_emoticon36");
        kjh.put("#(礼物)", "image_emoticon37");
        kjh.put("#(彩虹)", "image_emoticon38");
        kjh.put("#(星星月亮)", "image_emoticon39");
        kjh.put("#(太阳)", "image_emoticon40");
        kjh.put("#(钱币)", "image_emoticon41");
        kjh.put("#(灯泡)", "image_emoticon42");
        kjh.put("#(茶杯)", "image_emoticon43");
        kjh.put("#(蛋糕)", "image_emoticon44");
        kjh.put("#(音乐)", "image_emoticon45");
        kjh.put("#(haha)", "image_emoticon46");
        kjh.put("#(胜利)", "image_emoticon47");
        kjh.put("#(大拇指)", "image_emoticon48");
        kjh.put("#(弱)", "image_emoticon49");
        kjh.put("#(OK)", "image_emoticon50");
        kjh.put("#(哼)", "image_emoticon61");
        kjh.put("#(吃瓜)", "image_emoticon62");
        kjh.put("#(扔便便)", "image_emoticon63");
        kjh.put("#(惊恐)", "image_emoticon64");
        kjh.put("#(哎呦)", "image_emoticon65");
        kjh.put("#(小乖)", "image_emoticon66");
        kjh.put("#(捂嘴笑)", "image_emoticon67");
        kjh.put("#(你懂的)", "image_emoticon68");
        kjh.put("#(what)", "image_emoticon69");
        kjh.put("#(酸爽)", "image_emoticon70");
        kjh.put("#(呀咩爹)", "image_emoticon71");
        kjh.put("#(笑尿)", "image_emoticon72");
        kjh.put("#(挖鼻)", "image_emoticon73");
        kjh.put("#(犀利)", "image_emoticon74");
        kjh.put("#(小红脸)", "image_emoticon75");
        kjh.put("#(懒得理)", "image_emoticon76");
        kjh.put("#(沙发)", "image_emoticon77");
        kjh.put("#(手纸)", "image_emoticon78");
        kjh.put("#(香蕉)", "image_emoticon79");
        kjh.put("#(便便)", "image_emoticon80");
        kjh.put("#(药丸)", "image_emoticon81");
        kjh.put("#(红领巾)", "image_emoticon82");
        kjh.put("#(蜡烛)", "image_emoticon83");
        kjh.put("#(三道杠)", "image_emoticon84");
        kjh.put("#(赖皮)", "ali_001");
        kjh.put("#(感动)", "ali_002");
        kjh.put("#(十分惊讶)", "ali_003");
        kjh.put("#(怒气)", "ali_004");
        kjh.put("#(哭泣)", "ali_005");
        kjh.put("#(吃惊)", "ali_006");
        kjh.put("#(嘲弄)", "ali_007");
        kjh.put("#(飘过)", "ali_008");
        kjh.put("#(转圈哭)", "ali_009");
        kjh.put("#(神经病)", "ali_010");
        kjh.put("#(揪耳朵)", "ali_011");
        kjh.put("#(惊汗)", "ali_012");
        kjh.put("#(隐身)", "ali_013");
        kjh.put("#(不要嘛)", "ali_014");
        kjh.put("#(遁)", "ali_015");
        kjh.put("#(不公平)", "ali_016");
        kjh.put("#(爬来了)", "ali_017");
        kjh.put("#(蛋花哭)", "ali_018");
        kjh.put("#(温暖)", "ali_019");
        kjh.put("#(点头)", "ali_020");
        kjh.put("#(撒钱)", "ali_021");
        kjh.put("#(献花)", "ali_022");
        kjh.put("#(寒)", "ali_023");
        kjh.put("#(傻笑)", "ali_024");
        kjh.put("#(扭扭)", "ali_025");
        kjh.put("#(疯)", "ali_026");
        kjh.put("#(抓狂)", "ali_027");
        kjh.put("#(抓)", "ali_028");
        kjh.put("#(蜷)", "ali_029");
        kjh.put("#(挠墙)", "ali_030");
        kjh.put("#(狂笑)", "ali_031");
        kjh.put("#(抱枕)", "ali_032");
        kjh.put("#(吼叫)", "ali_033");
        kjh.put("#(嚷)", "ali_034");
        kjh.put("#(唠叨)", "ali_035");
        kjh.put("#(捏脸)", "ali_036");
        kjh.put("#(爆笑)", "ali_037");
        kjh.put("#(郁闷)", "ali_038");
        kjh.put("#(潜水)", "ali_039");
        kjh.put("#(十分开心)", "ali_040");
        kjh.put("#(冷笑话)", "ali_041");
        kjh.put("#(顶！)", "ali_042");
        kjh.put("#(潜)", "ali_043");
        kjh.put("#(画圈圈)", "ali_044");
        kjh.put("#(玩电脑)", "ali_045");
        kjh.put("#(狂吐)", "ali_046");
        kjh.put("#(哭着跑)", "ali_047");
        kjh.put("#(阿狸侠)", "ali_048");
        kjh.put("#(冷死了)", "ali_049");
        kjh.put("#(惆怅~)", "ali_050");
        kjh.put("#(摸头)", "ali_051");
        kjh.put("#(蹭)", "ali_052");
        kjh.put("#(打滚)", "ali_053");
        kjh.put("#(叩拜)", "ali_054");
        kjh.put("#(摸)", "ali_055");
        kjh.put("#(数钱)", "ali_056");
        kjh.put("#(拖走)", "ali_057");
        kjh.put("#(热)", "ali_058");
        kjh.put("#(加1)", "ali_059");
        kjh.put("#(压力)", "ali_060");
        kjh.put("#(表逼我)", "ali_061");
        kjh.put("#(人呢)", "ali_062");
        kjh.put("#(摇晃)", "ali_063");
        kjh.put("#(打地鼠)", "ali_064");
        kjh.put("#(这个屌)", "ali_065");
        kjh.put("#(恐慌)", "ali_066");
        kjh.put("#(晕乎乎)", "ali_067");
        kjh.put("#(浮云)", "ali_068");
        kjh.put("#(给力)", "ali_069");
        kjh.put("#(杯具了)", "ali_070");
        kjh.put("#(焦糖舞)", "yz_001");
        kjh.put("#(翻滚)", "yz_002");
        kjh.put("#(拍屁股做鬼脸)", "yz_003");
        kjh.put("#(不)", "yz_004");
        kjh.put("#(河蟹掉啦)", "yz_005");
        kjh.put("#(哦耶)", "yz_006");
        kjh.put("#(我倒)", "yz_007");
        kjh.put("#(投降)", "yz_008");
        kjh.put("#(微笑)", "b01");
        kjh.put("#(帅哥)", "b02");
        kjh.put("#(美女)", "b03");
        kjh.put("#(老大)", "b04");
        kjh.put("#(哈哈哈)", "b05");
        kjh.put("#(奸笑)", "b06");
        kjh.put("#(傻乐)", "b07");
        kjh.put("#(飞吻)", "b08");
        kjh.put("#(害羞)", "b09");
        kjh.put("#(花痴)", "b10");
        kjh.put("#(憧憬)", "b11");
        kjh.put("#(你牛)", "b12");
        kjh.put("#(鼓掌)", "b13");
        kjh.put("#(可爱)", "b14");
        kjh.put("#(太委屈)", "b15");
        kjh.put("#(大哭)", "b16");
        kjh.put("#(泪奔)", "b17");
        kjh.put("#(寻死)", "b18");
        kjh.put("#(非常惊讶)", "b19");
        kjh.put("#(表示疑问)", "b20");
        kjh.put("#(暗中观察)", "image_emoticon85");
        kjh.put("#(吃瓜)", "image_emoticon86");
        kjh.put("#(喝酒)", "image_emoticon87");
        kjh.put("#(嘿嘿嘿)", "image_emoticon88");
        kjh.put("#(噗)", "image_emoticon89");
        kjh.put("#(困成狗)", "image_emoticon90");
        kjh.put("#(微微一笑)", "image_emoticon91");
        kjh.put("#(托腮)", "image_emoticon92");
        kjh.put("#(摊手)", "image_emoticon93");
        kjh.put("#(柯基暗中观察)", "image_emoticon94");
        kjh.put("#(欢呼)", "image_emoticon95");
        kjh.put("#(炸药)", "image_emoticon96");
        kjh.put("#(突然兴奋)", "image_emoticon97");
        kjh.put("#(紧张)", "image_emoticon98");
        kjh.put("#(黑头瞪眼)", "image_emoticon99");
        kjh.put("#(黑头高兴)", "image_emoticon100");
        kjh.put("#(不跟丑人说话)", "image_emoticon101");
        kjh.put("#(么么哒)", "image_emoticon102");
        kjh.put("#(亲亲才能起来)", "image_emoticon103");
        kjh.put("#(伦家只是宝宝)", "image_emoticon104");
        kjh.put("#(你是我的人)", "image_emoticon105");
        kjh.put("#(假装看不见)", "image_emoticon106");
        kjh.put("#(单身等撩)", "image_emoticon107");
        kjh.put("#(吓到宝宝了)", "image_emoticon108");
        kjh.put("#(哈哈哈)", "image_emoticon109");
        kjh.put("#(嗯嗯)", "image_emoticon110");
        kjh.put("#(好幸福)", "image_emoticon111");
        kjh.put("#(宝宝不开心)", "image_emoticon112");
        kjh.put("#(小姐姐别走)", "image_emoticon113");
        kjh.put("#(小姐姐在吗)", "image_emoticon114");
        kjh.put("#(小姐姐来啦)", "image_emoticon115");
        kjh.put("#(小姐姐来玩呀)", "image_emoticon116");
        kjh.put("#(我养你)", "image_emoticon117");
        kjh.put("#(我是不会骗你的)", "image_emoticon118");
        kjh.put("#(扎心了)", "image_emoticon119");
        kjh.put("#(无聊)", "image_emoticon120");
        kjh.put("#(月亮代表我的心)", "image_emoticon121");
        kjh.put("#(来追我呀)", "image_emoticon122");
        kjh.put("#(爱你的形状)", "image_emoticon123");
        kjh.put("#(白眼)", "image_emoticon124");
    }

    private static String ML(String str) {
        return kjh.get(str);
    }

    public static ArrayList<TbRichTextData> e(Context context, String str, int i) {
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
                    String ML = ML(str3);
                    if (TextUtils.isEmpty(ML)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.q(str5);
                            } else {
                                SpannableString aQ = aQ(context, str5);
                                if (aQ != null) {
                                    tbRichTextData.q(aQ);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bIH(), ML, str3);
                        if (a2 != null) {
                            tbRichTextData.q(a2);
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
                    tbRichTextData.q(str5);
                } else {
                    SpannableString aQ2 = aQ(context, str5);
                    if (aQ2 != null) {
                        tbRichTextData.q(aQ2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int DK = TbFaceManager.bDU().DK(str);
        if (DK != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), DK);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0605a Ef = TbFaceManager.bDU().Ef(str);
            if (Ef != null) {
                int width = (int) (0.5d * Ef.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aQ(Context context, String str) {
        if (str == null) {
            return null;
        }
        return bf.au(context, str);
    }
}
