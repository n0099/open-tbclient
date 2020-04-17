package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> icX = new HashMap<>();

    static {
        icX.put("#(呵呵)", "image_emoticon");
        icX.put("#(哈哈)", "image_emoticon2");
        icX.put("#(吐舌)", "image_emoticon3");
        icX.put("#(啊)", "image_emoticon4");
        icX.put("#(啊?)", "image_emoticon4");
        icX.put("#(酷)", "image_emoticon5");
        icX.put("#(怒)", "image_emoticon6");
        icX.put("#(开心)", "image_emoticon7");
        icX.put("#(汗)", "image_emoticon8");
        icX.put("#(泪)", "image_emoticon9");
        icX.put("#(黑线)", "image_emoticon10");
        icX.put("#(鄙视)", "image_emoticon11");
        icX.put("#(不高兴)", "image_emoticon12");
        icX.put("#(真棒)", "image_emoticon13");
        icX.put("#(钱)", "image_emoticon14");
        icX.put("#(疑问)", "image_emoticon15");
        icX.put("#(阴险)", "image_emoticon16");
        icX.put("#(吐)", "image_emoticon17");
        icX.put("#(咦)", "image_emoticon18");
        icX.put("#(咦?)", "image_emoticon18");
        icX.put("#(委屈)", "image_emoticon19");
        icX.put("#(花心)", "image_emoticon20");
        icX.put("#(呼~)", "image_emoticon21");
        icX.put("#(笑眼)", "image_emoticon22");
        icX.put("#(冷)", "image_emoticon23");
        icX.put("#(太开心)", "image_emoticon24");
        icX.put("#(滑稽)", "image_emoticon25");
        icX.put("#(勉强)", "image_emoticon26");
        icX.put("#(狂汗)", "image_emoticon27");
        icX.put("#(乖)", "image_emoticon28");
        icX.put("#(睡觉)", "image_emoticon29");
        icX.put("#(惊哭)", "image_emoticon30");
        icX.put("#(升起)", "image_emoticon31");
        icX.put("#(惊讶)", "image_emoticon32");
        icX.put("#(喷)", "image_emoticon33");
        icX.put("#(爱心)", "image_emoticon34");
        icX.put("#(心碎)", "image_emoticon35");
        icX.put("#(玫瑰)", "image_emoticon36");
        icX.put("#(礼物)", "image_emoticon37");
        icX.put("#(彩虹)", "image_emoticon38");
        icX.put("#(星星月亮)", "image_emoticon39");
        icX.put("#(太阳)", "image_emoticon40");
        icX.put("#(钱币)", "image_emoticon41");
        icX.put("#(灯泡)", "image_emoticon42");
        icX.put("#(茶杯)", "image_emoticon43");
        icX.put("#(蛋糕)", "image_emoticon44");
        icX.put("#(音乐)", "image_emoticon45");
        icX.put("#(haha)", "image_emoticon46");
        icX.put("#(胜利)", "image_emoticon47");
        icX.put("#(大拇指)", "image_emoticon48");
        icX.put("#(弱)", "image_emoticon49");
        icX.put("#(OK)", "image_emoticon50");
        icX.put("#(哼)", "image_emoticon61");
        icX.put("#(吃瓜)", "image_emoticon62");
        icX.put("#(扔便便)", "image_emoticon63");
        icX.put("#(惊恐)", "image_emoticon64");
        icX.put("#(哎呦)", "image_emoticon65");
        icX.put("#(小乖)", "image_emoticon66");
        icX.put("#(捂嘴笑)", "image_emoticon67");
        icX.put("#(你懂的)", "image_emoticon68");
        icX.put("#(what)", "image_emoticon69");
        icX.put("#(酸爽)", "image_emoticon70");
        icX.put("#(呀咩爹)", "image_emoticon71");
        icX.put("#(笑尿)", "image_emoticon72");
        icX.put("#(挖鼻)", "image_emoticon73");
        icX.put("#(犀利)", "image_emoticon74");
        icX.put("#(小红脸)", "image_emoticon75");
        icX.put("#(懒得理)", "image_emoticon76");
        icX.put("#(沙发)", "image_emoticon77");
        icX.put("#(手纸)", "image_emoticon78");
        icX.put("#(香蕉)", "image_emoticon79");
        icX.put("#(便便)", "image_emoticon80");
        icX.put("#(药丸)", "image_emoticon81");
        icX.put("#(红领巾)", "image_emoticon82");
        icX.put("#(蜡烛)", "image_emoticon83");
        icX.put("#(三道杠)", "image_emoticon84");
        icX.put("#(赖皮)", "ali_001");
        icX.put("#(感动)", "ali_002");
        icX.put("#(十分惊讶)", "ali_003");
        icX.put("#(怒气)", "ali_004");
        icX.put("#(哭泣)", "ali_005");
        icX.put("#(吃惊)", "ali_006");
        icX.put("#(嘲弄)", "ali_007");
        icX.put("#(飘过)", "ali_008");
        icX.put("#(转圈哭)", "ali_009");
        icX.put("#(神经病)", "ali_010");
        icX.put("#(揪耳朵)", "ali_011");
        icX.put("#(惊汗)", "ali_012");
        icX.put("#(隐身)", "ali_013");
        icX.put("#(不要嘛)", "ali_014");
        icX.put("#(遁)", "ali_015");
        icX.put("#(不公平)", "ali_016");
        icX.put("#(爬来了)", "ali_017");
        icX.put("#(蛋花哭)", "ali_018");
        icX.put("#(温暖)", "ali_019");
        icX.put("#(点头)", "ali_020");
        icX.put("#(撒钱)", "ali_021");
        icX.put("#(献花)", "ali_022");
        icX.put("#(寒)", "ali_023");
        icX.put("#(傻笑)", "ali_024");
        icX.put("#(扭扭)", "ali_025");
        icX.put("#(疯)", "ali_026");
        icX.put("#(抓狂)", "ali_027");
        icX.put("#(抓)", "ali_028");
        icX.put("#(蜷)", "ali_029");
        icX.put("#(挠墙)", "ali_030");
        icX.put("#(狂笑)", "ali_031");
        icX.put("#(抱枕)", "ali_032");
        icX.put("#(吼叫)", "ali_033");
        icX.put("#(嚷)", "ali_034");
        icX.put("#(唠叨)", "ali_035");
        icX.put("#(捏脸)", "ali_036");
        icX.put("#(爆笑)", "ali_037");
        icX.put("#(郁闷)", "ali_038");
        icX.put("#(潜水)", "ali_039");
        icX.put("#(十分开心)", "ali_040");
        icX.put("#(冷笑话)", "ali_041");
        icX.put("#(顶！)", "ali_042");
        icX.put("#(潜)", "ali_043");
        icX.put("#(画圈圈)", "ali_044");
        icX.put("#(玩电脑)", "ali_045");
        icX.put("#(狂吐)", "ali_046");
        icX.put("#(哭着跑)", "ali_047");
        icX.put("#(阿狸侠)", "ali_048");
        icX.put("#(冷死了)", "ali_049");
        icX.put("#(惆怅~)", "ali_050");
        icX.put("#(摸头)", "ali_051");
        icX.put("#(蹭)", "ali_052");
        icX.put("#(打滚)", "ali_053");
        icX.put("#(叩拜)", "ali_054");
        icX.put("#(摸)", "ali_055");
        icX.put("#(数钱)", "ali_056");
        icX.put("#(拖走)", "ali_057");
        icX.put("#(热)", "ali_058");
        icX.put("#(加1)", "ali_059");
        icX.put("#(压力)", "ali_060");
        icX.put("#(表逼我)", "ali_061");
        icX.put("#(人呢)", "ali_062");
        icX.put("#(摇晃)", "ali_063");
        icX.put("#(打地鼠)", "ali_064");
        icX.put("#(这个屌)", "ali_065");
        icX.put("#(恐慌)", "ali_066");
        icX.put("#(晕乎乎)", "ali_067");
        icX.put("#(浮云)", "ali_068");
        icX.put("#(给力)", "ali_069");
        icX.put("#(杯具了)", "ali_070");
        icX.put("#(焦糖舞)", "yz_001");
        icX.put("#(翻滚)", "yz_002");
        icX.put("#(拍屁股做鬼脸)", "yz_003");
        icX.put("#(不)", "yz_004");
        icX.put("#(河蟹掉啦)", "yz_005");
        icX.put("#(哦耶)", "yz_006");
        icX.put("#(我倒)", "yz_007");
        icX.put("#(投降)", "yz_008");
        icX.put("#(微笑)", "b01");
        icX.put("#(帅哥)", "b02");
        icX.put("#(美女)", "b03");
        icX.put("#(老大)", "b04");
        icX.put("#(哈哈哈)", "b05");
        icX.put("#(奸笑)", "b06");
        icX.put("#(傻乐)", "b07");
        icX.put("#(飞吻)", "b08");
        icX.put("#(害羞)", "b09");
        icX.put("#(花痴)", "b10");
        icX.put("#(憧憬)", "b11");
        icX.put("#(你牛)", "b12");
        icX.put("#(鼓掌)", "b13");
        icX.put("#(可爱)", "b14");
        icX.put("#(太委屈)", "b15");
        icX.put("#(大哭)", "b16");
        icX.put("#(泪奔)", "b17");
        icX.put("#(寻死)", "b18");
        icX.put("#(非常惊讶)", "b19");
        icX.put("#(表示疑问)", "b20");
        icX.put("#(暗中观察)", "image_emoticon85");
        icX.put("#(吃瓜)", "image_emoticon86");
        icX.put("#(喝酒)", "image_emoticon87");
        icX.put("#(嘿嘿嘿)", "image_emoticon88");
        icX.put("#(噗)", "image_emoticon89");
        icX.put("#(困成狗)", "image_emoticon90");
        icX.put("#(微微一笑)", "image_emoticon91");
        icX.put("#(托腮)", "image_emoticon92");
        icX.put("#(摊手)", "image_emoticon93");
        icX.put("#(柯基暗中观察)", "image_emoticon94");
        icX.put("#(欢呼)", "image_emoticon95");
        icX.put("#(炸药)", "image_emoticon96");
        icX.put("#(突然兴奋)", "image_emoticon97");
        icX.put("#(紧张)", "image_emoticon98");
        icX.put("#(黑头瞪眼)", "image_emoticon99");
        icX.put("#(黑头高兴)", "image_emoticon100");
        icX.put("#(不跟丑人说话)", "image_emoticon101");
        icX.put("#(么么哒)", "image_emoticon102");
        icX.put("#(亲亲才能起来)", "image_emoticon103");
        icX.put("#(伦家只是宝宝)", "image_emoticon104");
        icX.put("#(你是我的人)", "image_emoticon105");
        icX.put("#(假装看不见)", "image_emoticon106");
        icX.put("#(单身等撩)", "image_emoticon107");
        icX.put("#(吓到宝宝了)", "image_emoticon108");
        icX.put("#(哈哈哈)", "image_emoticon109");
        icX.put("#(嗯嗯)", "image_emoticon110");
        icX.put("#(好幸福)", "image_emoticon111");
        icX.put("#(宝宝不开心)", "image_emoticon112");
        icX.put("#(小姐姐别走)", "image_emoticon113");
        icX.put("#(小姐姐在吗)", "image_emoticon114");
        icX.put("#(小姐姐来啦)", "image_emoticon115");
        icX.put("#(小姐姐来玩呀)", "image_emoticon116");
        icX.put("#(我养你)", "image_emoticon117");
        icX.put("#(我是不会骗你的)", "image_emoticon118");
        icX.put("#(扎心了)", "image_emoticon119");
        icX.put("#(无聊)", "image_emoticon120");
        icX.put("#(月亮代表我的心)", "image_emoticon121");
        icX.put("#(来追我呀)", "image_emoticon122");
        icX.put("#(爱你的形状)", "image_emoticon123");
        icX.put("#(白眼)", "image_emoticon124");
    }

    private static String Ee(String str) {
        return icX.get(str);
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
                    String Ee = Ee(str3);
                    if (TextUtils.isEmpty(Ee)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.j(str5);
                            } else {
                                SpannableString aQ = aQ(context, str5);
                                if (aQ != null) {
                                    tbRichTextData.j(aQ);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.bcm(), Ee, str3);
                        if (a != null) {
                            tbRichTextData.j(a);
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
                    tbRichTextData.j(str5);
                } else {
                    SpannableString aQ2 = aQ(context, str5);
                    if (aQ2 != null) {
                        tbRichTextData.j(aQ2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int wp = TbFaceManager.aYl().wp(str);
        if (wp != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), wp);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0422a wJ = TbFaceManager.aYl().wJ(str);
            if (wJ != null) {
                int width = (int) (0.5d * wJ.getWidth());
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
        return ba.at(context, str);
    }
}
