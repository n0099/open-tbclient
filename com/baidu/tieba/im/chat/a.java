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
    private static final HashMap<String, String> kjj = new HashMap<>();

    static {
        kjj.put("#(呵呵)", "image_emoticon");
        kjj.put("#(哈哈)", "image_emoticon2");
        kjj.put("#(吐舌)", "image_emoticon3");
        kjj.put("#(啊)", "image_emoticon4");
        kjj.put("#(啊?)", "image_emoticon4");
        kjj.put("#(酷)", "image_emoticon5");
        kjj.put("#(怒)", "image_emoticon6");
        kjj.put("#(开心)", "image_emoticon7");
        kjj.put("#(汗)", "image_emoticon8");
        kjj.put("#(泪)", "image_emoticon9");
        kjj.put("#(黑线)", "image_emoticon10");
        kjj.put("#(鄙视)", "image_emoticon11");
        kjj.put("#(不高兴)", "image_emoticon12");
        kjj.put("#(真棒)", "image_emoticon13");
        kjj.put("#(钱)", "image_emoticon14");
        kjj.put("#(疑问)", "image_emoticon15");
        kjj.put("#(阴险)", "image_emoticon16");
        kjj.put("#(吐)", "image_emoticon17");
        kjj.put("#(咦)", "image_emoticon18");
        kjj.put("#(咦?)", "image_emoticon18");
        kjj.put("#(委屈)", "image_emoticon19");
        kjj.put("#(花心)", "image_emoticon20");
        kjj.put("#(呼~)", "image_emoticon21");
        kjj.put("#(笑眼)", "image_emoticon22");
        kjj.put("#(冷)", "image_emoticon23");
        kjj.put("#(太开心)", "image_emoticon24");
        kjj.put("#(滑稽)", "image_emoticon25");
        kjj.put("#(勉强)", "image_emoticon26");
        kjj.put("#(狂汗)", "image_emoticon27");
        kjj.put("#(乖)", "image_emoticon28");
        kjj.put("#(睡觉)", "image_emoticon29");
        kjj.put("#(惊哭)", "image_emoticon30");
        kjj.put("#(升起)", "image_emoticon31");
        kjj.put("#(惊讶)", "image_emoticon32");
        kjj.put("#(喷)", "image_emoticon33");
        kjj.put("#(爱心)", "image_emoticon34");
        kjj.put("#(心碎)", "image_emoticon35");
        kjj.put("#(玫瑰)", "image_emoticon36");
        kjj.put("#(礼物)", "image_emoticon37");
        kjj.put("#(彩虹)", "image_emoticon38");
        kjj.put("#(星星月亮)", "image_emoticon39");
        kjj.put("#(太阳)", "image_emoticon40");
        kjj.put("#(钱币)", "image_emoticon41");
        kjj.put("#(灯泡)", "image_emoticon42");
        kjj.put("#(茶杯)", "image_emoticon43");
        kjj.put("#(蛋糕)", "image_emoticon44");
        kjj.put("#(音乐)", "image_emoticon45");
        kjj.put("#(haha)", "image_emoticon46");
        kjj.put("#(胜利)", "image_emoticon47");
        kjj.put("#(大拇指)", "image_emoticon48");
        kjj.put("#(弱)", "image_emoticon49");
        kjj.put("#(OK)", "image_emoticon50");
        kjj.put("#(哼)", "image_emoticon61");
        kjj.put("#(吃瓜)", "image_emoticon62");
        kjj.put("#(扔便便)", "image_emoticon63");
        kjj.put("#(惊恐)", "image_emoticon64");
        kjj.put("#(哎呦)", "image_emoticon65");
        kjj.put("#(小乖)", "image_emoticon66");
        kjj.put("#(捂嘴笑)", "image_emoticon67");
        kjj.put("#(你懂的)", "image_emoticon68");
        kjj.put("#(what)", "image_emoticon69");
        kjj.put("#(酸爽)", "image_emoticon70");
        kjj.put("#(呀咩爹)", "image_emoticon71");
        kjj.put("#(笑尿)", "image_emoticon72");
        kjj.put("#(挖鼻)", "image_emoticon73");
        kjj.put("#(犀利)", "image_emoticon74");
        kjj.put("#(小红脸)", "image_emoticon75");
        kjj.put("#(懒得理)", "image_emoticon76");
        kjj.put("#(沙发)", "image_emoticon77");
        kjj.put("#(手纸)", "image_emoticon78");
        kjj.put("#(香蕉)", "image_emoticon79");
        kjj.put("#(便便)", "image_emoticon80");
        kjj.put("#(药丸)", "image_emoticon81");
        kjj.put("#(红领巾)", "image_emoticon82");
        kjj.put("#(蜡烛)", "image_emoticon83");
        kjj.put("#(三道杠)", "image_emoticon84");
        kjj.put("#(赖皮)", "ali_001");
        kjj.put("#(感动)", "ali_002");
        kjj.put("#(十分惊讶)", "ali_003");
        kjj.put("#(怒气)", "ali_004");
        kjj.put("#(哭泣)", "ali_005");
        kjj.put("#(吃惊)", "ali_006");
        kjj.put("#(嘲弄)", "ali_007");
        kjj.put("#(飘过)", "ali_008");
        kjj.put("#(转圈哭)", "ali_009");
        kjj.put("#(神经病)", "ali_010");
        kjj.put("#(揪耳朵)", "ali_011");
        kjj.put("#(惊汗)", "ali_012");
        kjj.put("#(隐身)", "ali_013");
        kjj.put("#(不要嘛)", "ali_014");
        kjj.put("#(遁)", "ali_015");
        kjj.put("#(不公平)", "ali_016");
        kjj.put("#(爬来了)", "ali_017");
        kjj.put("#(蛋花哭)", "ali_018");
        kjj.put("#(温暖)", "ali_019");
        kjj.put("#(点头)", "ali_020");
        kjj.put("#(撒钱)", "ali_021");
        kjj.put("#(献花)", "ali_022");
        kjj.put("#(寒)", "ali_023");
        kjj.put("#(傻笑)", "ali_024");
        kjj.put("#(扭扭)", "ali_025");
        kjj.put("#(疯)", "ali_026");
        kjj.put("#(抓狂)", "ali_027");
        kjj.put("#(抓)", "ali_028");
        kjj.put("#(蜷)", "ali_029");
        kjj.put("#(挠墙)", "ali_030");
        kjj.put("#(狂笑)", "ali_031");
        kjj.put("#(抱枕)", "ali_032");
        kjj.put("#(吼叫)", "ali_033");
        kjj.put("#(嚷)", "ali_034");
        kjj.put("#(唠叨)", "ali_035");
        kjj.put("#(捏脸)", "ali_036");
        kjj.put("#(爆笑)", "ali_037");
        kjj.put("#(郁闷)", "ali_038");
        kjj.put("#(潜水)", "ali_039");
        kjj.put("#(十分开心)", "ali_040");
        kjj.put("#(冷笑话)", "ali_041");
        kjj.put("#(顶！)", "ali_042");
        kjj.put("#(潜)", "ali_043");
        kjj.put("#(画圈圈)", "ali_044");
        kjj.put("#(玩电脑)", "ali_045");
        kjj.put("#(狂吐)", "ali_046");
        kjj.put("#(哭着跑)", "ali_047");
        kjj.put("#(阿狸侠)", "ali_048");
        kjj.put("#(冷死了)", "ali_049");
        kjj.put("#(惆怅~)", "ali_050");
        kjj.put("#(摸头)", "ali_051");
        kjj.put("#(蹭)", "ali_052");
        kjj.put("#(打滚)", "ali_053");
        kjj.put("#(叩拜)", "ali_054");
        kjj.put("#(摸)", "ali_055");
        kjj.put("#(数钱)", "ali_056");
        kjj.put("#(拖走)", "ali_057");
        kjj.put("#(热)", "ali_058");
        kjj.put("#(加1)", "ali_059");
        kjj.put("#(压力)", "ali_060");
        kjj.put("#(表逼我)", "ali_061");
        kjj.put("#(人呢)", "ali_062");
        kjj.put("#(摇晃)", "ali_063");
        kjj.put("#(打地鼠)", "ali_064");
        kjj.put("#(这个屌)", "ali_065");
        kjj.put("#(恐慌)", "ali_066");
        kjj.put("#(晕乎乎)", "ali_067");
        kjj.put("#(浮云)", "ali_068");
        kjj.put("#(给力)", "ali_069");
        kjj.put("#(杯具了)", "ali_070");
        kjj.put("#(焦糖舞)", "yz_001");
        kjj.put("#(翻滚)", "yz_002");
        kjj.put("#(拍屁股做鬼脸)", "yz_003");
        kjj.put("#(不)", "yz_004");
        kjj.put("#(河蟹掉啦)", "yz_005");
        kjj.put("#(哦耶)", "yz_006");
        kjj.put("#(我倒)", "yz_007");
        kjj.put("#(投降)", "yz_008");
        kjj.put("#(微笑)", "b01");
        kjj.put("#(帅哥)", "b02");
        kjj.put("#(美女)", "b03");
        kjj.put("#(老大)", "b04");
        kjj.put("#(哈哈哈)", "b05");
        kjj.put("#(奸笑)", "b06");
        kjj.put("#(傻乐)", "b07");
        kjj.put("#(飞吻)", "b08");
        kjj.put("#(害羞)", "b09");
        kjj.put("#(花痴)", "b10");
        kjj.put("#(憧憬)", "b11");
        kjj.put("#(你牛)", "b12");
        kjj.put("#(鼓掌)", "b13");
        kjj.put("#(可爱)", "b14");
        kjj.put("#(太委屈)", "b15");
        kjj.put("#(大哭)", "b16");
        kjj.put("#(泪奔)", "b17");
        kjj.put("#(寻死)", "b18");
        kjj.put("#(非常惊讶)", "b19");
        kjj.put("#(表示疑问)", "b20");
        kjj.put("#(暗中观察)", "image_emoticon85");
        kjj.put("#(吃瓜)", "image_emoticon86");
        kjj.put("#(喝酒)", "image_emoticon87");
        kjj.put("#(嘿嘿嘿)", "image_emoticon88");
        kjj.put("#(噗)", "image_emoticon89");
        kjj.put("#(困成狗)", "image_emoticon90");
        kjj.put("#(微微一笑)", "image_emoticon91");
        kjj.put("#(托腮)", "image_emoticon92");
        kjj.put("#(摊手)", "image_emoticon93");
        kjj.put("#(柯基暗中观察)", "image_emoticon94");
        kjj.put("#(欢呼)", "image_emoticon95");
        kjj.put("#(炸药)", "image_emoticon96");
        kjj.put("#(突然兴奋)", "image_emoticon97");
        kjj.put("#(紧张)", "image_emoticon98");
        kjj.put("#(黑头瞪眼)", "image_emoticon99");
        kjj.put("#(黑头高兴)", "image_emoticon100");
        kjj.put("#(不跟丑人说话)", "image_emoticon101");
        kjj.put("#(么么哒)", "image_emoticon102");
        kjj.put("#(亲亲才能起来)", "image_emoticon103");
        kjj.put("#(伦家只是宝宝)", "image_emoticon104");
        kjj.put("#(你是我的人)", "image_emoticon105");
        kjj.put("#(假装看不见)", "image_emoticon106");
        kjj.put("#(单身等撩)", "image_emoticon107");
        kjj.put("#(吓到宝宝了)", "image_emoticon108");
        kjj.put("#(哈哈哈)", "image_emoticon109");
        kjj.put("#(嗯嗯)", "image_emoticon110");
        kjj.put("#(好幸福)", "image_emoticon111");
        kjj.put("#(宝宝不开心)", "image_emoticon112");
        kjj.put("#(小姐姐别走)", "image_emoticon113");
        kjj.put("#(小姐姐在吗)", "image_emoticon114");
        kjj.put("#(小姐姐来啦)", "image_emoticon115");
        kjj.put("#(小姐姐来玩呀)", "image_emoticon116");
        kjj.put("#(我养你)", "image_emoticon117");
        kjj.put("#(我是不会骗你的)", "image_emoticon118");
        kjj.put("#(扎心了)", "image_emoticon119");
        kjj.put("#(无聊)", "image_emoticon120");
        kjj.put("#(月亮代表我的心)", "image_emoticon121");
        kjj.put("#(来追我呀)", "image_emoticon122");
        kjj.put("#(爱你的形状)", "image_emoticon123");
        kjj.put("#(白眼)", "image_emoticon124");
    }

    private static String ML(String str) {
        return kjj.get(str);
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
