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
    private static final HashMap<String, String> kwt = new HashMap<>();

    static {
        kwt.put("#(呵呵)", "image_emoticon");
        kwt.put("#(哈哈)", "image_emoticon2");
        kwt.put("#(吐舌)", "image_emoticon3");
        kwt.put("#(啊)", "image_emoticon4");
        kwt.put("#(啊?)", "image_emoticon4");
        kwt.put("#(酷)", "image_emoticon5");
        kwt.put("#(怒)", "image_emoticon6");
        kwt.put("#(开心)", "image_emoticon7");
        kwt.put("#(汗)", "image_emoticon8");
        kwt.put("#(泪)", "image_emoticon9");
        kwt.put("#(黑线)", "image_emoticon10");
        kwt.put("#(鄙视)", "image_emoticon11");
        kwt.put("#(不高兴)", "image_emoticon12");
        kwt.put("#(真棒)", "image_emoticon13");
        kwt.put("#(钱)", "image_emoticon14");
        kwt.put("#(疑问)", "image_emoticon15");
        kwt.put("#(阴险)", "image_emoticon16");
        kwt.put("#(吐)", "image_emoticon17");
        kwt.put("#(咦)", "image_emoticon18");
        kwt.put("#(咦?)", "image_emoticon18");
        kwt.put("#(委屈)", "image_emoticon19");
        kwt.put("#(花心)", "image_emoticon20");
        kwt.put("#(呼~)", "image_emoticon21");
        kwt.put("#(笑眼)", "image_emoticon22");
        kwt.put("#(冷)", "image_emoticon23");
        kwt.put("#(太开心)", "image_emoticon24");
        kwt.put("#(滑稽)", "image_emoticon25");
        kwt.put("#(勉强)", "image_emoticon26");
        kwt.put("#(狂汗)", "image_emoticon27");
        kwt.put("#(乖)", "image_emoticon28");
        kwt.put("#(睡觉)", "image_emoticon29");
        kwt.put("#(惊哭)", "image_emoticon30");
        kwt.put("#(升起)", "image_emoticon31");
        kwt.put("#(惊讶)", "image_emoticon32");
        kwt.put("#(喷)", "image_emoticon33");
        kwt.put("#(爱心)", "image_emoticon34");
        kwt.put("#(心碎)", "image_emoticon35");
        kwt.put("#(玫瑰)", "image_emoticon36");
        kwt.put("#(礼物)", "image_emoticon37");
        kwt.put("#(彩虹)", "image_emoticon38");
        kwt.put("#(星星月亮)", "image_emoticon39");
        kwt.put("#(太阳)", "image_emoticon40");
        kwt.put("#(钱币)", "image_emoticon41");
        kwt.put("#(灯泡)", "image_emoticon42");
        kwt.put("#(茶杯)", "image_emoticon43");
        kwt.put("#(蛋糕)", "image_emoticon44");
        kwt.put("#(音乐)", "image_emoticon45");
        kwt.put("#(haha)", "image_emoticon46");
        kwt.put("#(胜利)", "image_emoticon47");
        kwt.put("#(大拇指)", "image_emoticon48");
        kwt.put("#(弱)", "image_emoticon49");
        kwt.put("#(OK)", "image_emoticon50");
        kwt.put("#(哼)", "image_emoticon61");
        kwt.put("#(吃瓜)", "image_emoticon62");
        kwt.put("#(扔便便)", "image_emoticon63");
        kwt.put("#(惊恐)", "image_emoticon64");
        kwt.put("#(哎呦)", "image_emoticon65");
        kwt.put("#(小乖)", "image_emoticon66");
        kwt.put("#(捂嘴笑)", "image_emoticon67");
        kwt.put("#(你懂的)", "image_emoticon68");
        kwt.put("#(what)", "image_emoticon69");
        kwt.put("#(酸爽)", "image_emoticon70");
        kwt.put("#(呀咩爹)", "image_emoticon71");
        kwt.put("#(笑尿)", "image_emoticon72");
        kwt.put("#(挖鼻)", "image_emoticon73");
        kwt.put("#(犀利)", "image_emoticon74");
        kwt.put("#(小红脸)", "image_emoticon75");
        kwt.put("#(懒得理)", "image_emoticon76");
        kwt.put("#(沙发)", "image_emoticon77");
        kwt.put("#(手纸)", "image_emoticon78");
        kwt.put("#(香蕉)", "image_emoticon79");
        kwt.put("#(便便)", "image_emoticon80");
        kwt.put("#(药丸)", "image_emoticon81");
        kwt.put("#(红领巾)", "image_emoticon82");
        kwt.put("#(蜡烛)", "image_emoticon83");
        kwt.put("#(三道杠)", "image_emoticon84");
        kwt.put("#(赖皮)", "ali_001");
        kwt.put("#(感动)", "ali_002");
        kwt.put("#(十分惊讶)", "ali_003");
        kwt.put("#(怒气)", "ali_004");
        kwt.put("#(哭泣)", "ali_005");
        kwt.put("#(吃惊)", "ali_006");
        kwt.put("#(嘲弄)", "ali_007");
        kwt.put("#(飘过)", "ali_008");
        kwt.put("#(转圈哭)", "ali_009");
        kwt.put("#(神经病)", "ali_010");
        kwt.put("#(揪耳朵)", "ali_011");
        kwt.put("#(惊汗)", "ali_012");
        kwt.put("#(隐身)", "ali_013");
        kwt.put("#(不要嘛)", "ali_014");
        kwt.put("#(遁)", "ali_015");
        kwt.put("#(不公平)", "ali_016");
        kwt.put("#(爬来了)", "ali_017");
        kwt.put("#(蛋花哭)", "ali_018");
        kwt.put("#(温暖)", "ali_019");
        kwt.put("#(点头)", "ali_020");
        kwt.put("#(撒钱)", "ali_021");
        kwt.put("#(献花)", "ali_022");
        kwt.put("#(寒)", "ali_023");
        kwt.put("#(傻笑)", "ali_024");
        kwt.put("#(扭扭)", "ali_025");
        kwt.put("#(疯)", "ali_026");
        kwt.put("#(抓狂)", "ali_027");
        kwt.put("#(抓)", "ali_028");
        kwt.put("#(蜷)", "ali_029");
        kwt.put("#(挠墙)", "ali_030");
        kwt.put("#(狂笑)", "ali_031");
        kwt.put("#(抱枕)", "ali_032");
        kwt.put("#(吼叫)", "ali_033");
        kwt.put("#(嚷)", "ali_034");
        kwt.put("#(唠叨)", "ali_035");
        kwt.put("#(捏脸)", "ali_036");
        kwt.put("#(爆笑)", "ali_037");
        kwt.put("#(郁闷)", "ali_038");
        kwt.put("#(潜水)", "ali_039");
        kwt.put("#(十分开心)", "ali_040");
        kwt.put("#(冷笑话)", "ali_041");
        kwt.put("#(顶！)", "ali_042");
        kwt.put("#(潜)", "ali_043");
        kwt.put("#(画圈圈)", "ali_044");
        kwt.put("#(玩电脑)", "ali_045");
        kwt.put("#(狂吐)", "ali_046");
        kwt.put("#(哭着跑)", "ali_047");
        kwt.put("#(阿狸侠)", "ali_048");
        kwt.put("#(冷死了)", "ali_049");
        kwt.put("#(惆怅~)", "ali_050");
        kwt.put("#(摸头)", "ali_051");
        kwt.put("#(蹭)", "ali_052");
        kwt.put("#(打滚)", "ali_053");
        kwt.put("#(叩拜)", "ali_054");
        kwt.put("#(摸)", "ali_055");
        kwt.put("#(数钱)", "ali_056");
        kwt.put("#(拖走)", "ali_057");
        kwt.put("#(热)", "ali_058");
        kwt.put("#(加1)", "ali_059");
        kwt.put("#(压力)", "ali_060");
        kwt.put("#(表逼我)", "ali_061");
        kwt.put("#(人呢)", "ali_062");
        kwt.put("#(摇晃)", "ali_063");
        kwt.put("#(打地鼠)", "ali_064");
        kwt.put("#(这个屌)", "ali_065");
        kwt.put("#(恐慌)", "ali_066");
        kwt.put("#(晕乎乎)", "ali_067");
        kwt.put("#(浮云)", "ali_068");
        kwt.put("#(给力)", "ali_069");
        kwt.put("#(杯具了)", "ali_070");
        kwt.put("#(焦糖舞)", "yz_001");
        kwt.put("#(翻滚)", "yz_002");
        kwt.put("#(拍屁股做鬼脸)", "yz_003");
        kwt.put("#(不)", "yz_004");
        kwt.put("#(河蟹掉啦)", "yz_005");
        kwt.put("#(哦耶)", "yz_006");
        kwt.put("#(我倒)", "yz_007");
        kwt.put("#(投降)", "yz_008");
        kwt.put("#(微笑)", "b01");
        kwt.put("#(帅哥)", "b02");
        kwt.put("#(美女)", "b03");
        kwt.put("#(老大)", "b04");
        kwt.put("#(哈哈哈)", "b05");
        kwt.put("#(奸笑)", "b06");
        kwt.put("#(傻乐)", "b07");
        kwt.put("#(飞吻)", "b08");
        kwt.put("#(害羞)", "b09");
        kwt.put("#(花痴)", "b10");
        kwt.put("#(憧憬)", "b11");
        kwt.put("#(你牛)", "b12");
        kwt.put("#(鼓掌)", "b13");
        kwt.put("#(可爱)", "b14");
        kwt.put("#(太委屈)", "b15");
        kwt.put("#(大哭)", "b16");
        kwt.put("#(泪奔)", "b17");
        kwt.put("#(寻死)", "b18");
        kwt.put("#(非常惊讶)", "b19");
        kwt.put("#(表示疑问)", "b20");
        kwt.put("#(暗中观察)", "image_emoticon85");
        kwt.put("#(吃瓜)", "image_emoticon86");
        kwt.put("#(喝酒)", "image_emoticon87");
        kwt.put("#(嘿嘿嘿)", "image_emoticon88");
        kwt.put("#(噗)", "image_emoticon89");
        kwt.put("#(困成狗)", "image_emoticon90");
        kwt.put("#(微微一笑)", "image_emoticon91");
        kwt.put("#(托腮)", "image_emoticon92");
        kwt.put("#(摊手)", "image_emoticon93");
        kwt.put("#(柯基暗中观察)", "image_emoticon94");
        kwt.put("#(欢呼)", "image_emoticon95");
        kwt.put("#(炸药)", "image_emoticon96");
        kwt.put("#(突然兴奋)", "image_emoticon97");
        kwt.put("#(紧张)", "image_emoticon98");
        kwt.put("#(黑头瞪眼)", "image_emoticon99");
        kwt.put("#(黑头高兴)", "image_emoticon100");
        kwt.put("#(不跟丑人说话)", "image_emoticon101");
        kwt.put("#(么么哒)", "image_emoticon102");
        kwt.put("#(亲亲才能起来)", "image_emoticon103");
        kwt.put("#(伦家只是宝宝)", "image_emoticon104");
        kwt.put("#(你是我的人)", "image_emoticon105");
        kwt.put("#(假装看不见)", "image_emoticon106");
        kwt.put("#(单身等撩)", "image_emoticon107");
        kwt.put("#(吓到宝宝了)", "image_emoticon108");
        kwt.put("#(哈哈哈)", "image_emoticon109");
        kwt.put("#(嗯嗯)", "image_emoticon110");
        kwt.put("#(好幸福)", "image_emoticon111");
        kwt.put("#(宝宝不开心)", "image_emoticon112");
        kwt.put("#(小姐姐别走)", "image_emoticon113");
        kwt.put("#(小姐姐在吗)", "image_emoticon114");
        kwt.put("#(小姐姐来啦)", "image_emoticon115");
        kwt.put("#(小姐姐来玩呀)", "image_emoticon116");
        kwt.put("#(我养你)", "image_emoticon117");
        kwt.put("#(我是不会骗你的)", "image_emoticon118");
        kwt.put("#(扎心了)", "image_emoticon119");
        kwt.put("#(无聊)", "image_emoticon120");
        kwt.put("#(月亮代表我的心)", "image_emoticon121");
        kwt.put("#(来追我呀)", "image_emoticon122");
        kwt.put("#(爱你的形状)", "image_emoticon123");
        kwt.put("#(白眼)", "image_emoticon124");
    }

    private static String ML(String str) {
        return kwt.get(str);
    }

    public static ArrayList<TbRichTextData> f(Context context, String str, int i) {
        int i2;
        String str2;
        String str3;
        ArrayList<TbRichTextData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        arrayList.add(tbRichTextData);
        try {
            String str4 = "";
            int length = str.length();
            int i3 = 0;
            while (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt == '#' && i3 < length - 1 && str.charAt(i3 + 1) == '(') {
                    i2 = i3 + 2;
                    String str5 = "#(";
                    while (true) {
                        if (i2 >= length) {
                            str2 = str5;
                            break;
                        }
                        char charAt2 = str.charAt(i2);
                        str5 = str5 + charAt2;
                        if (charAt2 != ')') {
                            if (i2 + 1 < length && str.charAt(i2 + 1) == '#') {
                                str2 = str5;
                                break;
                            }
                            i2++;
                        } else {
                            str2 = str5;
                            break;
                        }
                    }
                    String ML = ML(str2);
                    if (TextUtils.isEmpty(ML)) {
                        str3 = str4 + str2;
                    } else {
                        if (TextUtils.isEmpty(str4)) {
                            str3 = str4;
                        } else {
                            if (i == 1) {
                                tbRichTextData.q(str4);
                            } else {
                                SpannableString aW = aW(context, str4);
                                if (aW != null) {
                                    tbRichTextData.q(aW);
                                }
                            }
                            str3 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bLb(), ML, str2);
                        if (a2 != null) {
                            tbRichTextData.q(a2);
                        }
                    }
                    str4 = str3;
                } else {
                    str4 = str4 + charAt;
                    i2 = i3;
                }
                i3 = i2 + 1;
            }
            if (!TextUtils.isEmpty(str4)) {
                if (i == 1) {
                    tbRichTextData.q(str4);
                } else {
                    SpannableString aW2 = aW(context, str4);
                    if (aW2 != null) {
                        tbRichTextData.q(aW2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int DH = TbFaceManager.bGo().DH(str);
        if (DH != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), DH);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0596a Ec = TbFaceManager.bGo().Ec(str);
            if (Ec != null) {
                int width = (int) (0.5d * Ec.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aW(Context context, String str) {
        if (str == null) {
            return null;
        }
        return be.aC(context, str);
    }
}
