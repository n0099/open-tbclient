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
    private static final HashMap<String, String> jCw = new HashMap<>();

    static {
        jCw.put("#(呵呵)", "image_emoticon");
        jCw.put("#(哈哈)", "image_emoticon2");
        jCw.put("#(吐舌)", "image_emoticon3");
        jCw.put("#(啊)", "image_emoticon4");
        jCw.put("#(啊?)", "image_emoticon4");
        jCw.put("#(酷)", "image_emoticon5");
        jCw.put("#(怒)", "image_emoticon6");
        jCw.put("#(开心)", "image_emoticon7");
        jCw.put("#(汗)", "image_emoticon8");
        jCw.put("#(泪)", "image_emoticon9");
        jCw.put("#(黑线)", "image_emoticon10");
        jCw.put("#(鄙视)", "image_emoticon11");
        jCw.put("#(不高兴)", "image_emoticon12");
        jCw.put("#(真棒)", "image_emoticon13");
        jCw.put("#(钱)", "image_emoticon14");
        jCw.put("#(疑问)", "image_emoticon15");
        jCw.put("#(阴险)", "image_emoticon16");
        jCw.put("#(吐)", "image_emoticon17");
        jCw.put("#(咦)", "image_emoticon18");
        jCw.put("#(咦?)", "image_emoticon18");
        jCw.put("#(委屈)", "image_emoticon19");
        jCw.put("#(花心)", "image_emoticon20");
        jCw.put("#(呼~)", "image_emoticon21");
        jCw.put("#(笑眼)", "image_emoticon22");
        jCw.put("#(冷)", "image_emoticon23");
        jCw.put("#(太开心)", "image_emoticon24");
        jCw.put("#(滑稽)", "image_emoticon25");
        jCw.put("#(勉强)", "image_emoticon26");
        jCw.put("#(狂汗)", "image_emoticon27");
        jCw.put("#(乖)", "image_emoticon28");
        jCw.put("#(睡觉)", "image_emoticon29");
        jCw.put("#(惊哭)", "image_emoticon30");
        jCw.put("#(升起)", "image_emoticon31");
        jCw.put("#(惊讶)", "image_emoticon32");
        jCw.put("#(喷)", "image_emoticon33");
        jCw.put("#(爱心)", "image_emoticon34");
        jCw.put("#(心碎)", "image_emoticon35");
        jCw.put("#(玫瑰)", "image_emoticon36");
        jCw.put("#(礼物)", "image_emoticon37");
        jCw.put("#(彩虹)", "image_emoticon38");
        jCw.put("#(星星月亮)", "image_emoticon39");
        jCw.put("#(太阳)", "image_emoticon40");
        jCw.put("#(钱币)", "image_emoticon41");
        jCw.put("#(灯泡)", "image_emoticon42");
        jCw.put("#(茶杯)", "image_emoticon43");
        jCw.put("#(蛋糕)", "image_emoticon44");
        jCw.put("#(音乐)", "image_emoticon45");
        jCw.put("#(haha)", "image_emoticon46");
        jCw.put("#(胜利)", "image_emoticon47");
        jCw.put("#(大拇指)", "image_emoticon48");
        jCw.put("#(弱)", "image_emoticon49");
        jCw.put("#(OK)", "image_emoticon50");
        jCw.put("#(哼)", "image_emoticon61");
        jCw.put("#(吃瓜)", "image_emoticon62");
        jCw.put("#(扔便便)", "image_emoticon63");
        jCw.put("#(惊恐)", "image_emoticon64");
        jCw.put("#(哎呦)", "image_emoticon65");
        jCw.put("#(小乖)", "image_emoticon66");
        jCw.put("#(捂嘴笑)", "image_emoticon67");
        jCw.put("#(你懂的)", "image_emoticon68");
        jCw.put("#(what)", "image_emoticon69");
        jCw.put("#(酸爽)", "image_emoticon70");
        jCw.put("#(呀咩爹)", "image_emoticon71");
        jCw.put("#(笑尿)", "image_emoticon72");
        jCw.put("#(挖鼻)", "image_emoticon73");
        jCw.put("#(犀利)", "image_emoticon74");
        jCw.put("#(小红脸)", "image_emoticon75");
        jCw.put("#(懒得理)", "image_emoticon76");
        jCw.put("#(沙发)", "image_emoticon77");
        jCw.put("#(手纸)", "image_emoticon78");
        jCw.put("#(香蕉)", "image_emoticon79");
        jCw.put("#(便便)", "image_emoticon80");
        jCw.put("#(药丸)", "image_emoticon81");
        jCw.put("#(红领巾)", "image_emoticon82");
        jCw.put("#(蜡烛)", "image_emoticon83");
        jCw.put("#(三道杠)", "image_emoticon84");
        jCw.put("#(赖皮)", "ali_001");
        jCw.put("#(感动)", "ali_002");
        jCw.put("#(十分惊讶)", "ali_003");
        jCw.put("#(怒气)", "ali_004");
        jCw.put("#(哭泣)", "ali_005");
        jCw.put("#(吃惊)", "ali_006");
        jCw.put("#(嘲弄)", "ali_007");
        jCw.put("#(飘过)", "ali_008");
        jCw.put("#(转圈哭)", "ali_009");
        jCw.put("#(神经病)", "ali_010");
        jCw.put("#(揪耳朵)", "ali_011");
        jCw.put("#(惊汗)", "ali_012");
        jCw.put("#(隐身)", "ali_013");
        jCw.put("#(不要嘛)", "ali_014");
        jCw.put("#(遁)", "ali_015");
        jCw.put("#(不公平)", "ali_016");
        jCw.put("#(爬来了)", "ali_017");
        jCw.put("#(蛋花哭)", "ali_018");
        jCw.put("#(温暖)", "ali_019");
        jCw.put("#(点头)", "ali_020");
        jCw.put("#(撒钱)", "ali_021");
        jCw.put("#(献花)", "ali_022");
        jCw.put("#(寒)", "ali_023");
        jCw.put("#(傻笑)", "ali_024");
        jCw.put("#(扭扭)", "ali_025");
        jCw.put("#(疯)", "ali_026");
        jCw.put("#(抓狂)", "ali_027");
        jCw.put("#(抓)", "ali_028");
        jCw.put("#(蜷)", "ali_029");
        jCw.put("#(挠墙)", "ali_030");
        jCw.put("#(狂笑)", "ali_031");
        jCw.put("#(抱枕)", "ali_032");
        jCw.put("#(吼叫)", "ali_033");
        jCw.put("#(嚷)", "ali_034");
        jCw.put("#(唠叨)", "ali_035");
        jCw.put("#(捏脸)", "ali_036");
        jCw.put("#(爆笑)", "ali_037");
        jCw.put("#(郁闷)", "ali_038");
        jCw.put("#(潜水)", "ali_039");
        jCw.put("#(十分开心)", "ali_040");
        jCw.put("#(冷笑话)", "ali_041");
        jCw.put("#(顶！)", "ali_042");
        jCw.put("#(潜)", "ali_043");
        jCw.put("#(画圈圈)", "ali_044");
        jCw.put("#(玩电脑)", "ali_045");
        jCw.put("#(狂吐)", "ali_046");
        jCw.put("#(哭着跑)", "ali_047");
        jCw.put("#(阿狸侠)", "ali_048");
        jCw.put("#(冷死了)", "ali_049");
        jCw.put("#(惆怅~)", "ali_050");
        jCw.put("#(摸头)", "ali_051");
        jCw.put("#(蹭)", "ali_052");
        jCw.put("#(打滚)", "ali_053");
        jCw.put("#(叩拜)", "ali_054");
        jCw.put("#(摸)", "ali_055");
        jCw.put("#(数钱)", "ali_056");
        jCw.put("#(拖走)", "ali_057");
        jCw.put("#(热)", "ali_058");
        jCw.put("#(加1)", "ali_059");
        jCw.put("#(压力)", "ali_060");
        jCw.put("#(表逼我)", "ali_061");
        jCw.put("#(人呢)", "ali_062");
        jCw.put("#(摇晃)", "ali_063");
        jCw.put("#(打地鼠)", "ali_064");
        jCw.put("#(这个屌)", "ali_065");
        jCw.put("#(恐慌)", "ali_066");
        jCw.put("#(晕乎乎)", "ali_067");
        jCw.put("#(浮云)", "ali_068");
        jCw.put("#(给力)", "ali_069");
        jCw.put("#(杯具了)", "ali_070");
        jCw.put("#(焦糖舞)", "yz_001");
        jCw.put("#(翻滚)", "yz_002");
        jCw.put("#(拍屁股做鬼脸)", "yz_003");
        jCw.put("#(不)", "yz_004");
        jCw.put("#(河蟹掉啦)", "yz_005");
        jCw.put("#(哦耶)", "yz_006");
        jCw.put("#(我倒)", "yz_007");
        jCw.put("#(投降)", "yz_008");
        jCw.put("#(微笑)", "b01");
        jCw.put("#(帅哥)", "b02");
        jCw.put("#(美女)", "b03");
        jCw.put("#(老大)", "b04");
        jCw.put("#(哈哈哈)", "b05");
        jCw.put("#(奸笑)", "b06");
        jCw.put("#(傻乐)", "b07");
        jCw.put("#(飞吻)", "b08");
        jCw.put("#(害羞)", "b09");
        jCw.put("#(花痴)", "b10");
        jCw.put("#(憧憬)", "b11");
        jCw.put("#(你牛)", "b12");
        jCw.put("#(鼓掌)", "b13");
        jCw.put("#(可爱)", "b14");
        jCw.put("#(太委屈)", "b15");
        jCw.put("#(大哭)", "b16");
        jCw.put("#(泪奔)", "b17");
        jCw.put("#(寻死)", "b18");
        jCw.put("#(非常惊讶)", "b19");
        jCw.put("#(表示疑问)", "b20");
        jCw.put("#(暗中观察)", "image_emoticon85");
        jCw.put("#(吃瓜)", "image_emoticon86");
        jCw.put("#(喝酒)", "image_emoticon87");
        jCw.put("#(嘿嘿嘿)", "image_emoticon88");
        jCw.put("#(噗)", "image_emoticon89");
        jCw.put("#(困成狗)", "image_emoticon90");
        jCw.put("#(微微一笑)", "image_emoticon91");
        jCw.put("#(托腮)", "image_emoticon92");
        jCw.put("#(摊手)", "image_emoticon93");
        jCw.put("#(柯基暗中观察)", "image_emoticon94");
        jCw.put("#(欢呼)", "image_emoticon95");
        jCw.put("#(炸药)", "image_emoticon96");
        jCw.put("#(突然兴奋)", "image_emoticon97");
        jCw.put("#(紧张)", "image_emoticon98");
        jCw.put("#(黑头瞪眼)", "image_emoticon99");
        jCw.put("#(黑头高兴)", "image_emoticon100");
        jCw.put("#(不跟丑人说话)", "image_emoticon101");
        jCw.put("#(么么哒)", "image_emoticon102");
        jCw.put("#(亲亲才能起来)", "image_emoticon103");
        jCw.put("#(伦家只是宝宝)", "image_emoticon104");
        jCw.put("#(你是我的人)", "image_emoticon105");
        jCw.put("#(假装看不见)", "image_emoticon106");
        jCw.put("#(单身等撩)", "image_emoticon107");
        jCw.put("#(吓到宝宝了)", "image_emoticon108");
        jCw.put("#(哈哈哈)", "image_emoticon109");
        jCw.put("#(嗯嗯)", "image_emoticon110");
        jCw.put("#(好幸福)", "image_emoticon111");
        jCw.put("#(宝宝不开心)", "image_emoticon112");
        jCw.put("#(小姐姐别走)", "image_emoticon113");
        jCw.put("#(小姐姐在吗)", "image_emoticon114");
        jCw.put("#(小姐姐来啦)", "image_emoticon115");
        jCw.put("#(小姐姐来玩呀)", "image_emoticon116");
        jCw.put("#(我养你)", "image_emoticon117");
        jCw.put("#(我是不会骗你的)", "image_emoticon118");
        jCw.put("#(扎心了)", "image_emoticon119");
        jCw.put("#(无聊)", "image_emoticon120");
        jCw.put("#(月亮代表我的心)", "image_emoticon121");
        jCw.put("#(来追我呀)", "image_emoticon122");
        jCw.put("#(爱你的形状)", "image_emoticon123");
        jCw.put("#(白眼)", "image_emoticon124");
    }

    private static String Lo(String str) {
        return jCw.get(str);
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
                    String Lo = Lo(str3);
                    if (TextUtils.isEmpty(Lo)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.o(str5);
                            } else {
                                SpannableString aN = aN(context, str5);
                                if (aN != null) {
                                    tbRichTextData.o(aN);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bBv(), Lo, str3);
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
                    SpannableString aN2 = aN(context, str5);
                    if (aN2 != null) {
                        tbRichTextData.o(aN2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int CW = TbFaceManager.bwK().CW(str);
        if (CW != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), CW);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0567a Dr = TbFaceManager.bwK().Dr(str);
            if (Dr != null) {
                int width = (int) (0.5d * Dr.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aN(Context context, String str) {
        if (str == null) {
            return null;
        }
        return be.at(context, str);
    }
}
