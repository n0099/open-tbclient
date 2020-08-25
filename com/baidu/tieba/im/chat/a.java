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
/* loaded from: classes2.dex */
public class a {
    private static final HashMap<String, String> jeN = new HashMap<>();

    static {
        jeN.put("#(呵呵)", "image_emoticon");
        jeN.put("#(哈哈)", "image_emoticon2");
        jeN.put("#(吐舌)", "image_emoticon3");
        jeN.put("#(啊)", "image_emoticon4");
        jeN.put("#(啊?)", "image_emoticon4");
        jeN.put("#(酷)", "image_emoticon5");
        jeN.put("#(怒)", "image_emoticon6");
        jeN.put("#(开心)", "image_emoticon7");
        jeN.put("#(汗)", "image_emoticon8");
        jeN.put("#(泪)", "image_emoticon9");
        jeN.put("#(黑线)", "image_emoticon10");
        jeN.put("#(鄙视)", "image_emoticon11");
        jeN.put("#(不高兴)", "image_emoticon12");
        jeN.put("#(真棒)", "image_emoticon13");
        jeN.put("#(钱)", "image_emoticon14");
        jeN.put("#(疑问)", "image_emoticon15");
        jeN.put("#(阴险)", "image_emoticon16");
        jeN.put("#(吐)", "image_emoticon17");
        jeN.put("#(咦)", "image_emoticon18");
        jeN.put("#(咦?)", "image_emoticon18");
        jeN.put("#(委屈)", "image_emoticon19");
        jeN.put("#(花心)", "image_emoticon20");
        jeN.put("#(呼~)", "image_emoticon21");
        jeN.put("#(笑眼)", "image_emoticon22");
        jeN.put("#(冷)", "image_emoticon23");
        jeN.put("#(太开心)", "image_emoticon24");
        jeN.put("#(滑稽)", "image_emoticon25");
        jeN.put("#(勉强)", "image_emoticon26");
        jeN.put("#(狂汗)", "image_emoticon27");
        jeN.put("#(乖)", "image_emoticon28");
        jeN.put("#(睡觉)", "image_emoticon29");
        jeN.put("#(惊哭)", "image_emoticon30");
        jeN.put("#(升起)", "image_emoticon31");
        jeN.put("#(惊讶)", "image_emoticon32");
        jeN.put("#(喷)", "image_emoticon33");
        jeN.put("#(爱心)", "image_emoticon34");
        jeN.put("#(心碎)", "image_emoticon35");
        jeN.put("#(玫瑰)", "image_emoticon36");
        jeN.put("#(礼物)", "image_emoticon37");
        jeN.put("#(彩虹)", "image_emoticon38");
        jeN.put("#(星星月亮)", "image_emoticon39");
        jeN.put("#(太阳)", "image_emoticon40");
        jeN.put("#(钱币)", "image_emoticon41");
        jeN.put("#(灯泡)", "image_emoticon42");
        jeN.put("#(茶杯)", "image_emoticon43");
        jeN.put("#(蛋糕)", "image_emoticon44");
        jeN.put("#(音乐)", "image_emoticon45");
        jeN.put("#(haha)", "image_emoticon46");
        jeN.put("#(胜利)", "image_emoticon47");
        jeN.put("#(大拇指)", "image_emoticon48");
        jeN.put("#(弱)", "image_emoticon49");
        jeN.put("#(OK)", "image_emoticon50");
        jeN.put("#(哼)", "image_emoticon61");
        jeN.put("#(吃瓜)", "image_emoticon62");
        jeN.put("#(扔便便)", "image_emoticon63");
        jeN.put("#(惊恐)", "image_emoticon64");
        jeN.put("#(哎呦)", "image_emoticon65");
        jeN.put("#(小乖)", "image_emoticon66");
        jeN.put("#(捂嘴笑)", "image_emoticon67");
        jeN.put("#(你懂的)", "image_emoticon68");
        jeN.put("#(what)", "image_emoticon69");
        jeN.put("#(酸爽)", "image_emoticon70");
        jeN.put("#(呀咩爹)", "image_emoticon71");
        jeN.put("#(笑尿)", "image_emoticon72");
        jeN.put("#(挖鼻)", "image_emoticon73");
        jeN.put("#(犀利)", "image_emoticon74");
        jeN.put("#(小红脸)", "image_emoticon75");
        jeN.put("#(懒得理)", "image_emoticon76");
        jeN.put("#(沙发)", "image_emoticon77");
        jeN.put("#(手纸)", "image_emoticon78");
        jeN.put("#(香蕉)", "image_emoticon79");
        jeN.put("#(便便)", "image_emoticon80");
        jeN.put("#(药丸)", "image_emoticon81");
        jeN.put("#(红领巾)", "image_emoticon82");
        jeN.put("#(蜡烛)", "image_emoticon83");
        jeN.put("#(三道杠)", "image_emoticon84");
        jeN.put("#(赖皮)", "ali_001");
        jeN.put("#(感动)", "ali_002");
        jeN.put("#(十分惊讶)", "ali_003");
        jeN.put("#(怒气)", "ali_004");
        jeN.put("#(哭泣)", "ali_005");
        jeN.put("#(吃惊)", "ali_006");
        jeN.put("#(嘲弄)", "ali_007");
        jeN.put("#(飘过)", "ali_008");
        jeN.put("#(转圈哭)", "ali_009");
        jeN.put("#(神经病)", "ali_010");
        jeN.put("#(揪耳朵)", "ali_011");
        jeN.put("#(惊汗)", "ali_012");
        jeN.put("#(隐身)", "ali_013");
        jeN.put("#(不要嘛)", "ali_014");
        jeN.put("#(遁)", "ali_015");
        jeN.put("#(不公平)", "ali_016");
        jeN.put("#(爬来了)", "ali_017");
        jeN.put("#(蛋花哭)", "ali_018");
        jeN.put("#(温暖)", "ali_019");
        jeN.put("#(点头)", "ali_020");
        jeN.put("#(撒钱)", "ali_021");
        jeN.put("#(献花)", "ali_022");
        jeN.put("#(寒)", "ali_023");
        jeN.put("#(傻笑)", "ali_024");
        jeN.put("#(扭扭)", "ali_025");
        jeN.put("#(疯)", "ali_026");
        jeN.put("#(抓狂)", "ali_027");
        jeN.put("#(抓)", "ali_028");
        jeN.put("#(蜷)", "ali_029");
        jeN.put("#(挠墙)", "ali_030");
        jeN.put("#(狂笑)", "ali_031");
        jeN.put("#(抱枕)", "ali_032");
        jeN.put("#(吼叫)", "ali_033");
        jeN.put("#(嚷)", "ali_034");
        jeN.put("#(唠叨)", "ali_035");
        jeN.put("#(捏脸)", "ali_036");
        jeN.put("#(爆笑)", "ali_037");
        jeN.put("#(郁闷)", "ali_038");
        jeN.put("#(潜水)", "ali_039");
        jeN.put("#(十分开心)", "ali_040");
        jeN.put("#(冷笑话)", "ali_041");
        jeN.put("#(顶！)", "ali_042");
        jeN.put("#(潜)", "ali_043");
        jeN.put("#(画圈圈)", "ali_044");
        jeN.put("#(玩电脑)", "ali_045");
        jeN.put("#(狂吐)", "ali_046");
        jeN.put("#(哭着跑)", "ali_047");
        jeN.put("#(阿狸侠)", "ali_048");
        jeN.put("#(冷死了)", "ali_049");
        jeN.put("#(惆怅~)", "ali_050");
        jeN.put("#(摸头)", "ali_051");
        jeN.put("#(蹭)", "ali_052");
        jeN.put("#(打滚)", "ali_053");
        jeN.put("#(叩拜)", "ali_054");
        jeN.put("#(摸)", "ali_055");
        jeN.put("#(数钱)", "ali_056");
        jeN.put("#(拖走)", "ali_057");
        jeN.put("#(热)", "ali_058");
        jeN.put("#(加1)", "ali_059");
        jeN.put("#(压力)", "ali_060");
        jeN.put("#(表逼我)", "ali_061");
        jeN.put("#(人呢)", "ali_062");
        jeN.put("#(摇晃)", "ali_063");
        jeN.put("#(打地鼠)", "ali_064");
        jeN.put("#(这个屌)", "ali_065");
        jeN.put("#(恐慌)", "ali_066");
        jeN.put("#(晕乎乎)", "ali_067");
        jeN.put("#(浮云)", "ali_068");
        jeN.put("#(给力)", "ali_069");
        jeN.put("#(杯具了)", "ali_070");
        jeN.put("#(焦糖舞)", "yz_001");
        jeN.put("#(翻滚)", "yz_002");
        jeN.put("#(拍屁股做鬼脸)", "yz_003");
        jeN.put("#(不)", "yz_004");
        jeN.put("#(河蟹掉啦)", "yz_005");
        jeN.put("#(哦耶)", "yz_006");
        jeN.put("#(我倒)", "yz_007");
        jeN.put("#(投降)", "yz_008");
        jeN.put("#(微笑)", "b01");
        jeN.put("#(帅哥)", "b02");
        jeN.put("#(美女)", "b03");
        jeN.put("#(老大)", "b04");
        jeN.put("#(哈哈哈)", "b05");
        jeN.put("#(奸笑)", "b06");
        jeN.put("#(傻乐)", "b07");
        jeN.put("#(飞吻)", "b08");
        jeN.put("#(害羞)", "b09");
        jeN.put("#(花痴)", "b10");
        jeN.put("#(憧憬)", "b11");
        jeN.put("#(你牛)", "b12");
        jeN.put("#(鼓掌)", "b13");
        jeN.put("#(可爱)", "b14");
        jeN.put("#(太委屈)", "b15");
        jeN.put("#(大哭)", "b16");
        jeN.put("#(泪奔)", "b17");
        jeN.put("#(寻死)", "b18");
        jeN.put("#(非常惊讶)", "b19");
        jeN.put("#(表示疑问)", "b20");
        jeN.put("#(暗中观察)", "image_emoticon85");
        jeN.put("#(吃瓜)", "image_emoticon86");
        jeN.put("#(喝酒)", "image_emoticon87");
        jeN.put("#(嘿嘿嘿)", "image_emoticon88");
        jeN.put("#(噗)", "image_emoticon89");
        jeN.put("#(困成狗)", "image_emoticon90");
        jeN.put("#(微微一笑)", "image_emoticon91");
        jeN.put("#(托腮)", "image_emoticon92");
        jeN.put("#(摊手)", "image_emoticon93");
        jeN.put("#(柯基暗中观察)", "image_emoticon94");
        jeN.put("#(欢呼)", "image_emoticon95");
        jeN.put("#(炸药)", "image_emoticon96");
        jeN.put("#(突然兴奋)", "image_emoticon97");
        jeN.put("#(紧张)", "image_emoticon98");
        jeN.put("#(黑头瞪眼)", "image_emoticon99");
        jeN.put("#(黑头高兴)", "image_emoticon100");
        jeN.put("#(不跟丑人说话)", "image_emoticon101");
        jeN.put("#(么么哒)", "image_emoticon102");
        jeN.put("#(亲亲才能起来)", "image_emoticon103");
        jeN.put("#(伦家只是宝宝)", "image_emoticon104");
        jeN.put("#(你是我的人)", "image_emoticon105");
        jeN.put("#(假装看不见)", "image_emoticon106");
        jeN.put("#(单身等撩)", "image_emoticon107");
        jeN.put("#(吓到宝宝了)", "image_emoticon108");
        jeN.put("#(哈哈哈)", "image_emoticon109");
        jeN.put("#(嗯嗯)", "image_emoticon110");
        jeN.put("#(好幸福)", "image_emoticon111");
        jeN.put("#(宝宝不开心)", "image_emoticon112");
        jeN.put("#(小姐姐别走)", "image_emoticon113");
        jeN.put("#(小姐姐在吗)", "image_emoticon114");
        jeN.put("#(小姐姐来啦)", "image_emoticon115");
        jeN.put("#(小姐姐来玩呀)", "image_emoticon116");
        jeN.put("#(我养你)", "image_emoticon117");
        jeN.put("#(我是不会骗你的)", "image_emoticon118");
        jeN.put("#(扎心了)", "image_emoticon119");
        jeN.put("#(无聊)", "image_emoticon120");
        jeN.put("#(月亮代表我的心)", "image_emoticon121");
        jeN.put("#(来追我呀)", "image_emoticon122");
        jeN.put("#(爱你的形状)", "image_emoticon123");
        jeN.put("#(白眼)", "image_emoticon124");
    }

    private static String JW(String str) {
        return jeN.get(str);
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
                    String JW = JW(str3);
                    if (TextUtils.isEmpty(JW)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.n(str5);
                            } else {
                                SpannableString aI = aI(context, str5);
                                if (aI != null) {
                                    tbRichTextData.n(aI);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.bxB(), JW, str3);
                        if (a != null) {
                            tbRichTextData.n(a);
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
                    tbRichTextData.n(str5);
                } else {
                    SpannableString aI2 = aI(context, str5);
                    if (aI2 != null) {
                        tbRichTextData.n(aI2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int BN = TbFaceManager.bsV().BN(str);
        if (BN != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), BN);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0554a Ci = TbFaceManager.bsV().Ci(str);
            if (Ci != null) {
                int width = (int) (0.5d * Ci.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aI(Context context, String str) {
        if (str == null) {
            return null;
        }
        return be.an(context, str);
    }
}
