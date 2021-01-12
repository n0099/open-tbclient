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
    private static final HashMap<String, String> krO = new HashMap<>();

    static {
        krO.put("#(呵呵)", "image_emoticon");
        krO.put("#(哈哈)", "image_emoticon2");
        krO.put("#(吐舌)", "image_emoticon3");
        krO.put("#(啊)", "image_emoticon4");
        krO.put("#(啊?)", "image_emoticon4");
        krO.put("#(酷)", "image_emoticon5");
        krO.put("#(怒)", "image_emoticon6");
        krO.put("#(开心)", "image_emoticon7");
        krO.put("#(汗)", "image_emoticon8");
        krO.put("#(泪)", "image_emoticon9");
        krO.put("#(黑线)", "image_emoticon10");
        krO.put("#(鄙视)", "image_emoticon11");
        krO.put("#(不高兴)", "image_emoticon12");
        krO.put("#(真棒)", "image_emoticon13");
        krO.put("#(钱)", "image_emoticon14");
        krO.put("#(疑问)", "image_emoticon15");
        krO.put("#(阴险)", "image_emoticon16");
        krO.put("#(吐)", "image_emoticon17");
        krO.put("#(咦)", "image_emoticon18");
        krO.put("#(咦?)", "image_emoticon18");
        krO.put("#(委屈)", "image_emoticon19");
        krO.put("#(花心)", "image_emoticon20");
        krO.put("#(呼~)", "image_emoticon21");
        krO.put("#(笑眼)", "image_emoticon22");
        krO.put("#(冷)", "image_emoticon23");
        krO.put("#(太开心)", "image_emoticon24");
        krO.put("#(滑稽)", "image_emoticon25");
        krO.put("#(勉强)", "image_emoticon26");
        krO.put("#(狂汗)", "image_emoticon27");
        krO.put("#(乖)", "image_emoticon28");
        krO.put("#(睡觉)", "image_emoticon29");
        krO.put("#(惊哭)", "image_emoticon30");
        krO.put("#(升起)", "image_emoticon31");
        krO.put("#(惊讶)", "image_emoticon32");
        krO.put("#(喷)", "image_emoticon33");
        krO.put("#(爱心)", "image_emoticon34");
        krO.put("#(心碎)", "image_emoticon35");
        krO.put("#(玫瑰)", "image_emoticon36");
        krO.put("#(礼物)", "image_emoticon37");
        krO.put("#(彩虹)", "image_emoticon38");
        krO.put("#(星星月亮)", "image_emoticon39");
        krO.put("#(太阳)", "image_emoticon40");
        krO.put("#(钱币)", "image_emoticon41");
        krO.put("#(灯泡)", "image_emoticon42");
        krO.put("#(茶杯)", "image_emoticon43");
        krO.put("#(蛋糕)", "image_emoticon44");
        krO.put("#(音乐)", "image_emoticon45");
        krO.put("#(haha)", "image_emoticon46");
        krO.put("#(胜利)", "image_emoticon47");
        krO.put("#(大拇指)", "image_emoticon48");
        krO.put("#(弱)", "image_emoticon49");
        krO.put("#(OK)", "image_emoticon50");
        krO.put("#(哼)", "image_emoticon61");
        krO.put("#(吃瓜)", "image_emoticon62");
        krO.put("#(扔便便)", "image_emoticon63");
        krO.put("#(惊恐)", "image_emoticon64");
        krO.put("#(哎呦)", "image_emoticon65");
        krO.put("#(小乖)", "image_emoticon66");
        krO.put("#(捂嘴笑)", "image_emoticon67");
        krO.put("#(你懂的)", "image_emoticon68");
        krO.put("#(what)", "image_emoticon69");
        krO.put("#(酸爽)", "image_emoticon70");
        krO.put("#(呀咩爹)", "image_emoticon71");
        krO.put("#(笑尿)", "image_emoticon72");
        krO.put("#(挖鼻)", "image_emoticon73");
        krO.put("#(犀利)", "image_emoticon74");
        krO.put("#(小红脸)", "image_emoticon75");
        krO.put("#(懒得理)", "image_emoticon76");
        krO.put("#(沙发)", "image_emoticon77");
        krO.put("#(手纸)", "image_emoticon78");
        krO.put("#(香蕉)", "image_emoticon79");
        krO.put("#(便便)", "image_emoticon80");
        krO.put("#(药丸)", "image_emoticon81");
        krO.put("#(红领巾)", "image_emoticon82");
        krO.put("#(蜡烛)", "image_emoticon83");
        krO.put("#(三道杠)", "image_emoticon84");
        krO.put("#(赖皮)", "ali_001");
        krO.put("#(感动)", "ali_002");
        krO.put("#(十分惊讶)", "ali_003");
        krO.put("#(怒气)", "ali_004");
        krO.put("#(哭泣)", "ali_005");
        krO.put("#(吃惊)", "ali_006");
        krO.put("#(嘲弄)", "ali_007");
        krO.put("#(飘过)", "ali_008");
        krO.put("#(转圈哭)", "ali_009");
        krO.put("#(神经病)", "ali_010");
        krO.put("#(揪耳朵)", "ali_011");
        krO.put("#(惊汗)", "ali_012");
        krO.put("#(隐身)", "ali_013");
        krO.put("#(不要嘛)", "ali_014");
        krO.put("#(遁)", "ali_015");
        krO.put("#(不公平)", "ali_016");
        krO.put("#(爬来了)", "ali_017");
        krO.put("#(蛋花哭)", "ali_018");
        krO.put("#(温暖)", "ali_019");
        krO.put("#(点头)", "ali_020");
        krO.put("#(撒钱)", "ali_021");
        krO.put("#(献花)", "ali_022");
        krO.put("#(寒)", "ali_023");
        krO.put("#(傻笑)", "ali_024");
        krO.put("#(扭扭)", "ali_025");
        krO.put("#(疯)", "ali_026");
        krO.put("#(抓狂)", "ali_027");
        krO.put("#(抓)", "ali_028");
        krO.put("#(蜷)", "ali_029");
        krO.put("#(挠墙)", "ali_030");
        krO.put("#(狂笑)", "ali_031");
        krO.put("#(抱枕)", "ali_032");
        krO.put("#(吼叫)", "ali_033");
        krO.put("#(嚷)", "ali_034");
        krO.put("#(唠叨)", "ali_035");
        krO.put("#(捏脸)", "ali_036");
        krO.put("#(爆笑)", "ali_037");
        krO.put("#(郁闷)", "ali_038");
        krO.put("#(潜水)", "ali_039");
        krO.put("#(十分开心)", "ali_040");
        krO.put("#(冷笑话)", "ali_041");
        krO.put("#(顶！)", "ali_042");
        krO.put("#(潜)", "ali_043");
        krO.put("#(画圈圈)", "ali_044");
        krO.put("#(玩电脑)", "ali_045");
        krO.put("#(狂吐)", "ali_046");
        krO.put("#(哭着跑)", "ali_047");
        krO.put("#(阿狸侠)", "ali_048");
        krO.put("#(冷死了)", "ali_049");
        krO.put("#(惆怅~)", "ali_050");
        krO.put("#(摸头)", "ali_051");
        krO.put("#(蹭)", "ali_052");
        krO.put("#(打滚)", "ali_053");
        krO.put("#(叩拜)", "ali_054");
        krO.put("#(摸)", "ali_055");
        krO.put("#(数钱)", "ali_056");
        krO.put("#(拖走)", "ali_057");
        krO.put("#(热)", "ali_058");
        krO.put("#(加1)", "ali_059");
        krO.put("#(压力)", "ali_060");
        krO.put("#(表逼我)", "ali_061");
        krO.put("#(人呢)", "ali_062");
        krO.put("#(摇晃)", "ali_063");
        krO.put("#(打地鼠)", "ali_064");
        krO.put("#(这个屌)", "ali_065");
        krO.put("#(恐慌)", "ali_066");
        krO.put("#(晕乎乎)", "ali_067");
        krO.put("#(浮云)", "ali_068");
        krO.put("#(给力)", "ali_069");
        krO.put("#(杯具了)", "ali_070");
        krO.put("#(焦糖舞)", "yz_001");
        krO.put("#(翻滚)", "yz_002");
        krO.put("#(拍屁股做鬼脸)", "yz_003");
        krO.put("#(不)", "yz_004");
        krO.put("#(河蟹掉啦)", "yz_005");
        krO.put("#(哦耶)", "yz_006");
        krO.put("#(我倒)", "yz_007");
        krO.put("#(投降)", "yz_008");
        krO.put("#(微笑)", "b01");
        krO.put("#(帅哥)", "b02");
        krO.put("#(美女)", "b03");
        krO.put("#(老大)", "b04");
        krO.put("#(哈哈哈)", "b05");
        krO.put("#(奸笑)", "b06");
        krO.put("#(傻乐)", "b07");
        krO.put("#(飞吻)", "b08");
        krO.put("#(害羞)", "b09");
        krO.put("#(花痴)", "b10");
        krO.put("#(憧憬)", "b11");
        krO.put("#(你牛)", "b12");
        krO.put("#(鼓掌)", "b13");
        krO.put("#(可爱)", "b14");
        krO.put("#(太委屈)", "b15");
        krO.put("#(大哭)", "b16");
        krO.put("#(泪奔)", "b17");
        krO.put("#(寻死)", "b18");
        krO.put("#(非常惊讶)", "b19");
        krO.put("#(表示疑问)", "b20");
        krO.put("#(暗中观察)", "image_emoticon85");
        krO.put("#(吃瓜)", "image_emoticon86");
        krO.put("#(喝酒)", "image_emoticon87");
        krO.put("#(嘿嘿嘿)", "image_emoticon88");
        krO.put("#(噗)", "image_emoticon89");
        krO.put("#(困成狗)", "image_emoticon90");
        krO.put("#(微微一笑)", "image_emoticon91");
        krO.put("#(托腮)", "image_emoticon92");
        krO.put("#(摊手)", "image_emoticon93");
        krO.put("#(柯基暗中观察)", "image_emoticon94");
        krO.put("#(欢呼)", "image_emoticon95");
        krO.put("#(炸药)", "image_emoticon96");
        krO.put("#(突然兴奋)", "image_emoticon97");
        krO.put("#(紧张)", "image_emoticon98");
        krO.put("#(黑头瞪眼)", "image_emoticon99");
        krO.put("#(黑头高兴)", "image_emoticon100");
        krO.put("#(不跟丑人说话)", "image_emoticon101");
        krO.put("#(么么哒)", "image_emoticon102");
        krO.put("#(亲亲才能起来)", "image_emoticon103");
        krO.put("#(伦家只是宝宝)", "image_emoticon104");
        krO.put("#(你是我的人)", "image_emoticon105");
        krO.put("#(假装看不见)", "image_emoticon106");
        krO.put("#(单身等撩)", "image_emoticon107");
        krO.put("#(吓到宝宝了)", "image_emoticon108");
        krO.put("#(哈哈哈)", "image_emoticon109");
        krO.put("#(嗯嗯)", "image_emoticon110");
        krO.put("#(好幸福)", "image_emoticon111");
        krO.put("#(宝宝不开心)", "image_emoticon112");
        krO.put("#(小姐姐别走)", "image_emoticon113");
        krO.put("#(小姐姐在吗)", "image_emoticon114");
        krO.put("#(小姐姐来啦)", "image_emoticon115");
        krO.put("#(小姐姐来玩呀)", "image_emoticon116");
        krO.put("#(我养你)", "image_emoticon117");
        krO.put("#(我是不会骗你的)", "image_emoticon118");
        krO.put("#(扎心了)", "image_emoticon119");
        krO.put("#(无聊)", "image_emoticon120");
        krO.put("#(月亮代表我的心)", "image_emoticon121");
        krO.put("#(来追我呀)", "image_emoticon122");
        krO.put("#(爱你的形状)", "image_emoticon123");
        krO.put("#(白眼)", "image_emoticon124");
    }

    private static String LC(String str) {
        return krO.get(str);
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
                    String LC = LC(str2);
                    if (TextUtils.isEmpty(LC)) {
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
                        SpannableString a2 = a(tbRichTextData.bHk(), LC, str2);
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
        int Cv = TbFaceManager.bCw().Cv(str);
        if (Cv != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), Cv);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0579a CQ = TbFaceManager.bCw().CQ(str);
            if (CQ != null) {
                int width = (int) (0.5d * CQ.getWidth());
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
