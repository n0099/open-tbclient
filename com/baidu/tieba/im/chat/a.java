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
    private static final HashMap<String, String> jUS = new HashMap<>();

    static {
        jUS.put("#(呵呵)", "image_emoticon");
        jUS.put("#(哈哈)", "image_emoticon2");
        jUS.put("#(吐舌)", "image_emoticon3");
        jUS.put("#(啊)", "image_emoticon4");
        jUS.put("#(啊?)", "image_emoticon4");
        jUS.put("#(酷)", "image_emoticon5");
        jUS.put("#(怒)", "image_emoticon6");
        jUS.put("#(开心)", "image_emoticon7");
        jUS.put("#(汗)", "image_emoticon8");
        jUS.put("#(泪)", "image_emoticon9");
        jUS.put("#(黑线)", "image_emoticon10");
        jUS.put("#(鄙视)", "image_emoticon11");
        jUS.put("#(不高兴)", "image_emoticon12");
        jUS.put("#(真棒)", "image_emoticon13");
        jUS.put("#(钱)", "image_emoticon14");
        jUS.put("#(疑问)", "image_emoticon15");
        jUS.put("#(阴险)", "image_emoticon16");
        jUS.put("#(吐)", "image_emoticon17");
        jUS.put("#(咦)", "image_emoticon18");
        jUS.put("#(咦?)", "image_emoticon18");
        jUS.put("#(委屈)", "image_emoticon19");
        jUS.put("#(花心)", "image_emoticon20");
        jUS.put("#(呼~)", "image_emoticon21");
        jUS.put("#(笑眼)", "image_emoticon22");
        jUS.put("#(冷)", "image_emoticon23");
        jUS.put("#(太开心)", "image_emoticon24");
        jUS.put("#(滑稽)", "image_emoticon25");
        jUS.put("#(勉强)", "image_emoticon26");
        jUS.put("#(狂汗)", "image_emoticon27");
        jUS.put("#(乖)", "image_emoticon28");
        jUS.put("#(睡觉)", "image_emoticon29");
        jUS.put("#(惊哭)", "image_emoticon30");
        jUS.put("#(升起)", "image_emoticon31");
        jUS.put("#(惊讶)", "image_emoticon32");
        jUS.put("#(喷)", "image_emoticon33");
        jUS.put("#(爱心)", "image_emoticon34");
        jUS.put("#(心碎)", "image_emoticon35");
        jUS.put("#(玫瑰)", "image_emoticon36");
        jUS.put("#(礼物)", "image_emoticon37");
        jUS.put("#(彩虹)", "image_emoticon38");
        jUS.put("#(星星月亮)", "image_emoticon39");
        jUS.put("#(太阳)", "image_emoticon40");
        jUS.put("#(钱币)", "image_emoticon41");
        jUS.put("#(灯泡)", "image_emoticon42");
        jUS.put("#(茶杯)", "image_emoticon43");
        jUS.put("#(蛋糕)", "image_emoticon44");
        jUS.put("#(音乐)", "image_emoticon45");
        jUS.put("#(haha)", "image_emoticon46");
        jUS.put("#(胜利)", "image_emoticon47");
        jUS.put("#(大拇指)", "image_emoticon48");
        jUS.put("#(弱)", "image_emoticon49");
        jUS.put("#(OK)", "image_emoticon50");
        jUS.put("#(哼)", "image_emoticon61");
        jUS.put("#(吃瓜)", "image_emoticon62");
        jUS.put("#(扔便便)", "image_emoticon63");
        jUS.put("#(惊恐)", "image_emoticon64");
        jUS.put("#(哎呦)", "image_emoticon65");
        jUS.put("#(小乖)", "image_emoticon66");
        jUS.put("#(捂嘴笑)", "image_emoticon67");
        jUS.put("#(你懂的)", "image_emoticon68");
        jUS.put("#(what)", "image_emoticon69");
        jUS.put("#(酸爽)", "image_emoticon70");
        jUS.put("#(呀咩爹)", "image_emoticon71");
        jUS.put("#(笑尿)", "image_emoticon72");
        jUS.put("#(挖鼻)", "image_emoticon73");
        jUS.put("#(犀利)", "image_emoticon74");
        jUS.put("#(小红脸)", "image_emoticon75");
        jUS.put("#(懒得理)", "image_emoticon76");
        jUS.put("#(沙发)", "image_emoticon77");
        jUS.put("#(手纸)", "image_emoticon78");
        jUS.put("#(香蕉)", "image_emoticon79");
        jUS.put("#(便便)", "image_emoticon80");
        jUS.put("#(药丸)", "image_emoticon81");
        jUS.put("#(红领巾)", "image_emoticon82");
        jUS.put("#(蜡烛)", "image_emoticon83");
        jUS.put("#(三道杠)", "image_emoticon84");
        jUS.put("#(赖皮)", "ali_001");
        jUS.put("#(感动)", "ali_002");
        jUS.put("#(十分惊讶)", "ali_003");
        jUS.put("#(怒气)", "ali_004");
        jUS.put("#(哭泣)", "ali_005");
        jUS.put("#(吃惊)", "ali_006");
        jUS.put("#(嘲弄)", "ali_007");
        jUS.put("#(飘过)", "ali_008");
        jUS.put("#(转圈哭)", "ali_009");
        jUS.put("#(神经病)", "ali_010");
        jUS.put("#(揪耳朵)", "ali_011");
        jUS.put("#(惊汗)", "ali_012");
        jUS.put("#(隐身)", "ali_013");
        jUS.put("#(不要嘛)", "ali_014");
        jUS.put("#(遁)", "ali_015");
        jUS.put("#(不公平)", "ali_016");
        jUS.put("#(爬来了)", "ali_017");
        jUS.put("#(蛋花哭)", "ali_018");
        jUS.put("#(温暖)", "ali_019");
        jUS.put("#(点头)", "ali_020");
        jUS.put("#(撒钱)", "ali_021");
        jUS.put("#(献花)", "ali_022");
        jUS.put("#(寒)", "ali_023");
        jUS.put("#(傻笑)", "ali_024");
        jUS.put("#(扭扭)", "ali_025");
        jUS.put("#(疯)", "ali_026");
        jUS.put("#(抓狂)", "ali_027");
        jUS.put("#(抓)", "ali_028");
        jUS.put("#(蜷)", "ali_029");
        jUS.put("#(挠墙)", "ali_030");
        jUS.put("#(狂笑)", "ali_031");
        jUS.put("#(抱枕)", "ali_032");
        jUS.put("#(吼叫)", "ali_033");
        jUS.put("#(嚷)", "ali_034");
        jUS.put("#(唠叨)", "ali_035");
        jUS.put("#(捏脸)", "ali_036");
        jUS.put("#(爆笑)", "ali_037");
        jUS.put("#(郁闷)", "ali_038");
        jUS.put("#(潜水)", "ali_039");
        jUS.put("#(十分开心)", "ali_040");
        jUS.put("#(冷笑话)", "ali_041");
        jUS.put("#(顶！)", "ali_042");
        jUS.put("#(潜)", "ali_043");
        jUS.put("#(画圈圈)", "ali_044");
        jUS.put("#(玩电脑)", "ali_045");
        jUS.put("#(狂吐)", "ali_046");
        jUS.put("#(哭着跑)", "ali_047");
        jUS.put("#(阿狸侠)", "ali_048");
        jUS.put("#(冷死了)", "ali_049");
        jUS.put("#(惆怅~)", "ali_050");
        jUS.put("#(摸头)", "ali_051");
        jUS.put("#(蹭)", "ali_052");
        jUS.put("#(打滚)", "ali_053");
        jUS.put("#(叩拜)", "ali_054");
        jUS.put("#(摸)", "ali_055");
        jUS.put("#(数钱)", "ali_056");
        jUS.put("#(拖走)", "ali_057");
        jUS.put("#(热)", "ali_058");
        jUS.put("#(加1)", "ali_059");
        jUS.put("#(压力)", "ali_060");
        jUS.put("#(表逼我)", "ali_061");
        jUS.put("#(人呢)", "ali_062");
        jUS.put("#(摇晃)", "ali_063");
        jUS.put("#(打地鼠)", "ali_064");
        jUS.put("#(这个屌)", "ali_065");
        jUS.put("#(恐慌)", "ali_066");
        jUS.put("#(晕乎乎)", "ali_067");
        jUS.put("#(浮云)", "ali_068");
        jUS.put("#(给力)", "ali_069");
        jUS.put("#(杯具了)", "ali_070");
        jUS.put("#(焦糖舞)", "yz_001");
        jUS.put("#(翻滚)", "yz_002");
        jUS.put("#(拍屁股做鬼脸)", "yz_003");
        jUS.put("#(不)", "yz_004");
        jUS.put("#(河蟹掉啦)", "yz_005");
        jUS.put("#(哦耶)", "yz_006");
        jUS.put("#(我倒)", "yz_007");
        jUS.put("#(投降)", "yz_008");
        jUS.put("#(微笑)", "b01");
        jUS.put("#(帅哥)", "b02");
        jUS.put("#(美女)", "b03");
        jUS.put("#(老大)", "b04");
        jUS.put("#(哈哈哈)", "b05");
        jUS.put("#(奸笑)", "b06");
        jUS.put("#(傻乐)", "b07");
        jUS.put("#(飞吻)", "b08");
        jUS.put("#(害羞)", "b09");
        jUS.put("#(花痴)", "b10");
        jUS.put("#(憧憬)", "b11");
        jUS.put("#(你牛)", "b12");
        jUS.put("#(鼓掌)", "b13");
        jUS.put("#(可爱)", "b14");
        jUS.put("#(太委屈)", "b15");
        jUS.put("#(大哭)", "b16");
        jUS.put("#(泪奔)", "b17");
        jUS.put("#(寻死)", "b18");
        jUS.put("#(非常惊讶)", "b19");
        jUS.put("#(表示疑问)", "b20");
        jUS.put("#(暗中观察)", "image_emoticon85");
        jUS.put("#(吃瓜)", "image_emoticon86");
        jUS.put("#(喝酒)", "image_emoticon87");
        jUS.put("#(嘿嘿嘿)", "image_emoticon88");
        jUS.put("#(噗)", "image_emoticon89");
        jUS.put("#(困成狗)", "image_emoticon90");
        jUS.put("#(微微一笑)", "image_emoticon91");
        jUS.put("#(托腮)", "image_emoticon92");
        jUS.put("#(摊手)", "image_emoticon93");
        jUS.put("#(柯基暗中观察)", "image_emoticon94");
        jUS.put("#(欢呼)", "image_emoticon95");
        jUS.put("#(炸药)", "image_emoticon96");
        jUS.put("#(突然兴奋)", "image_emoticon97");
        jUS.put("#(紧张)", "image_emoticon98");
        jUS.put("#(黑头瞪眼)", "image_emoticon99");
        jUS.put("#(黑头高兴)", "image_emoticon100");
        jUS.put("#(不跟丑人说话)", "image_emoticon101");
        jUS.put("#(么么哒)", "image_emoticon102");
        jUS.put("#(亲亲才能起来)", "image_emoticon103");
        jUS.put("#(伦家只是宝宝)", "image_emoticon104");
        jUS.put("#(你是我的人)", "image_emoticon105");
        jUS.put("#(假装看不见)", "image_emoticon106");
        jUS.put("#(单身等撩)", "image_emoticon107");
        jUS.put("#(吓到宝宝了)", "image_emoticon108");
        jUS.put("#(哈哈哈)", "image_emoticon109");
        jUS.put("#(嗯嗯)", "image_emoticon110");
        jUS.put("#(好幸福)", "image_emoticon111");
        jUS.put("#(宝宝不开心)", "image_emoticon112");
        jUS.put("#(小姐姐别走)", "image_emoticon113");
        jUS.put("#(小姐姐在吗)", "image_emoticon114");
        jUS.put("#(小姐姐来啦)", "image_emoticon115");
        jUS.put("#(小姐姐来玩呀)", "image_emoticon116");
        jUS.put("#(我养你)", "image_emoticon117");
        jUS.put("#(我是不会骗你的)", "image_emoticon118");
        jUS.put("#(扎心了)", "image_emoticon119");
        jUS.put("#(无聊)", "image_emoticon120");
        jUS.put("#(月亮代表我的心)", "image_emoticon121");
        jUS.put("#(来追我呀)", "image_emoticon122");
        jUS.put("#(爱你的形状)", "image_emoticon123");
        jUS.put("#(白眼)", "image_emoticon124");
    }

    private static String Md(String str) {
        return jUS.get(str);
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
                    String Md = Md(str3);
                    if (TextUtils.isEmpty(Md)) {
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
                        SpannableString a2 = a(tbRichTextData.bFN(), Md, str3);
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
        int DD = TbFaceManager.bBc().DD(str);
        if (DD != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), DD);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0593a DY = TbFaceManager.bBc().DY(str);
            if (DY != null) {
                int width = (int) (0.5d * DY.getWidth());
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
