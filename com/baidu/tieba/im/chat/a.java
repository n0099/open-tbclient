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
    private static final HashMap<String, String> kzV = new HashMap<>();

    static {
        kzV.put("#(呵呵)", "image_emoticon");
        kzV.put("#(哈哈)", "image_emoticon2");
        kzV.put("#(吐舌)", "image_emoticon3");
        kzV.put("#(啊)", "image_emoticon4");
        kzV.put("#(啊?)", "image_emoticon4");
        kzV.put("#(酷)", "image_emoticon5");
        kzV.put("#(怒)", "image_emoticon6");
        kzV.put("#(开心)", "image_emoticon7");
        kzV.put("#(汗)", "image_emoticon8");
        kzV.put("#(泪)", "image_emoticon9");
        kzV.put("#(黑线)", "image_emoticon10");
        kzV.put("#(鄙视)", "image_emoticon11");
        kzV.put("#(不高兴)", "image_emoticon12");
        kzV.put("#(真棒)", "image_emoticon13");
        kzV.put("#(钱)", "image_emoticon14");
        kzV.put("#(疑问)", "image_emoticon15");
        kzV.put("#(阴险)", "image_emoticon16");
        kzV.put("#(吐)", "image_emoticon17");
        kzV.put("#(咦)", "image_emoticon18");
        kzV.put("#(咦?)", "image_emoticon18");
        kzV.put("#(委屈)", "image_emoticon19");
        kzV.put("#(花心)", "image_emoticon20");
        kzV.put("#(呼~)", "image_emoticon21");
        kzV.put("#(笑眼)", "image_emoticon22");
        kzV.put("#(冷)", "image_emoticon23");
        kzV.put("#(太开心)", "image_emoticon24");
        kzV.put("#(滑稽)", "image_emoticon25");
        kzV.put("#(勉强)", "image_emoticon26");
        kzV.put("#(狂汗)", "image_emoticon27");
        kzV.put("#(乖)", "image_emoticon28");
        kzV.put("#(睡觉)", "image_emoticon29");
        kzV.put("#(惊哭)", "image_emoticon30");
        kzV.put("#(升起)", "image_emoticon31");
        kzV.put("#(惊讶)", "image_emoticon32");
        kzV.put("#(喷)", "image_emoticon33");
        kzV.put("#(爱心)", "image_emoticon34");
        kzV.put("#(心碎)", "image_emoticon35");
        kzV.put("#(玫瑰)", "image_emoticon36");
        kzV.put("#(礼物)", "image_emoticon37");
        kzV.put("#(彩虹)", "image_emoticon38");
        kzV.put("#(星星月亮)", "image_emoticon39");
        kzV.put("#(太阳)", "image_emoticon40");
        kzV.put("#(钱币)", "image_emoticon41");
        kzV.put("#(灯泡)", "image_emoticon42");
        kzV.put("#(茶杯)", "image_emoticon43");
        kzV.put("#(蛋糕)", "image_emoticon44");
        kzV.put("#(音乐)", "image_emoticon45");
        kzV.put("#(haha)", "image_emoticon46");
        kzV.put("#(胜利)", "image_emoticon47");
        kzV.put("#(大拇指)", "image_emoticon48");
        kzV.put("#(弱)", "image_emoticon49");
        kzV.put("#(OK)", "image_emoticon50");
        kzV.put("#(哼)", "image_emoticon61");
        kzV.put("#(吃瓜)", "image_emoticon62");
        kzV.put("#(扔便便)", "image_emoticon63");
        kzV.put("#(惊恐)", "image_emoticon64");
        kzV.put("#(哎呦)", "image_emoticon65");
        kzV.put("#(小乖)", "image_emoticon66");
        kzV.put("#(捂嘴笑)", "image_emoticon67");
        kzV.put("#(你懂的)", "image_emoticon68");
        kzV.put("#(what)", "image_emoticon69");
        kzV.put("#(酸爽)", "image_emoticon70");
        kzV.put("#(呀咩爹)", "image_emoticon71");
        kzV.put("#(笑尿)", "image_emoticon72");
        kzV.put("#(挖鼻)", "image_emoticon73");
        kzV.put("#(犀利)", "image_emoticon74");
        kzV.put("#(小红脸)", "image_emoticon75");
        kzV.put("#(懒得理)", "image_emoticon76");
        kzV.put("#(沙发)", "image_emoticon77");
        kzV.put("#(手纸)", "image_emoticon78");
        kzV.put("#(香蕉)", "image_emoticon79");
        kzV.put("#(便便)", "image_emoticon80");
        kzV.put("#(药丸)", "image_emoticon81");
        kzV.put("#(红领巾)", "image_emoticon82");
        kzV.put("#(蜡烛)", "image_emoticon83");
        kzV.put("#(三道杠)", "image_emoticon84");
        kzV.put("#(赖皮)", "ali_001");
        kzV.put("#(感动)", "ali_002");
        kzV.put("#(十分惊讶)", "ali_003");
        kzV.put("#(怒气)", "ali_004");
        kzV.put("#(哭泣)", "ali_005");
        kzV.put("#(吃惊)", "ali_006");
        kzV.put("#(嘲弄)", "ali_007");
        kzV.put("#(飘过)", "ali_008");
        kzV.put("#(转圈哭)", "ali_009");
        kzV.put("#(神经病)", "ali_010");
        kzV.put("#(揪耳朵)", "ali_011");
        kzV.put("#(惊汗)", "ali_012");
        kzV.put("#(隐身)", "ali_013");
        kzV.put("#(不要嘛)", "ali_014");
        kzV.put("#(遁)", "ali_015");
        kzV.put("#(不公平)", "ali_016");
        kzV.put("#(爬来了)", "ali_017");
        kzV.put("#(蛋花哭)", "ali_018");
        kzV.put("#(温暖)", "ali_019");
        kzV.put("#(点头)", "ali_020");
        kzV.put("#(撒钱)", "ali_021");
        kzV.put("#(献花)", "ali_022");
        kzV.put("#(寒)", "ali_023");
        kzV.put("#(傻笑)", "ali_024");
        kzV.put("#(扭扭)", "ali_025");
        kzV.put("#(疯)", "ali_026");
        kzV.put("#(抓狂)", "ali_027");
        kzV.put("#(抓)", "ali_028");
        kzV.put("#(蜷)", "ali_029");
        kzV.put("#(挠墙)", "ali_030");
        kzV.put("#(狂笑)", "ali_031");
        kzV.put("#(抱枕)", "ali_032");
        kzV.put("#(吼叫)", "ali_033");
        kzV.put("#(嚷)", "ali_034");
        kzV.put("#(唠叨)", "ali_035");
        kzV.put("#(捏脸)", "ali_036");
        kzV.put("#(爆笑)", "ali_037");
        kzV.put("#(郁闷)", "ali_038");
        kzV.put("#(潜水)", "ali_039");
        kzV.put("#(十分开心)", "ali_040");
        kzV.put("#(冷笑话)", "ali_041");
        kzV.put("#(顶！)", "ali_042");
        kzV.put("#(潜)", "ali_043");
        kzV.put("#(画圈圈)", "ali_044");
        kzV.put("#(玩电脑)", "ali_045");
        kzV.put("#(狂吐)", "ali_046");
        kzV.put("#(哭着跑)", "ali_047");
        kzV.put("#(阿狸侠)", "ali_048");
        kzV.put("#(冷死了)", "ali_049");
        kzV.put("#(惆怅~)", "ali_050");
        kzV.put("#(摸头)", "ali_051");
        kzV.put("#(蹭)", "ali_052");
        kzV.put("#(打滚)", "ali_053");
        kzV.put("#(叩拜)", "ali_054");
        kzV.put("#(摸)", "ali_055");
        kzV.put("#(数钱)", "ali_056");
        kzV.put("#(拖走)", "ali_057");
        kzV.put("#(热)", "ali_058");
        kzV.put("#(加1)", "ali_059");
        kzV.put("#(压力)", "ali_060");
        kzV.put("#(表逼我)", "ali_061");
        kzV.put("#(人呢)", "ali_062");
        kzV.put("#(摇晃)", "ali_063");
        kzV.put("#(打地鼠)", "ali_064");
        kzV.put("#(这个屌)", "ali_065");
        kzV.put("#(恐慌)", "ali_066");
        kzV.put("#(晕乎乎)", "ali_067");
        kzV.put("#(浮云)", "ali_068");
        kzV.put("#(给力)", "ali_069");
        kzV.put("#(杯具了)", "ali_070");
        kzV.put("#(焦糖舞)", "yz_001");
        kzV.put("#(翻滚)", "yz_002");
        kzV.put("#(拍屁股做鬼脸)", "yz_003");
        kzV.put("#(不)", "yz_004");
        kzV.put("#(河蟹掉啦)", "yz_005");
        kzV.put("#(哦耶)", "yz_006");
        kzV.put("#(我倒)", "yz_007");
        kzV.put("#(投降)", "yz_008");
        kzV.put("#(微笑)", "b01");
        kzV.put("#(帅哥)", "b02");
        kzV.put("#(美女)", "b03");
        kzV.put("#(老大)", "b04");
        kzV.put("#(哈哈哈)", "b05");
        kzV.put("#(奸笑)", "b06");
        kzV.put("#(傻乐)", "b07");
        kzV.put("#(飞吻)", "b08");
        kzV.put("#(害羞)", "b09");
        kzV.put("#(花痴)", "b10");
        kzV.put("#(憧憬)", "b11");
        kzV.put("#(你牛)", "b12");
        kzV.put("#(鼓掌)", "b13");
        kzV.put("#(可爱)", "b14");
        kzV.put("#(太委屈)", "b15");
        kzV.put("#(大哭)", "b16");
        kzV.put("#(泪奔)", "b17");
        kzV.put("#(寻死)", "b18");
        kzV.put("#(非常惊讶)", "b19");
        kzV.put("#(表示疑问)", "b20");
        kzV.put("#(暗中观察)", "image_emoticon85");
        kzV.put("#(吃瓜)", "image_emoticon86");
        kzV.put("#(喝酒)", "image_emoticon87");
        kzV.put("#(嘿嘿嘿)", "image_emoticon88");
        kzV.put("#(噗)", "image_emoticon89");
        kzV.put("#(困成狗)", "image_emoticon90");
        kzV.put("#(微微一笑)", "image_emoticon91");
        kzV.put("#(托腮)", "image_emoticon92");
        kzV.put("#(摊手)", "image_emoticon93");
        kzV.put("#(柯基暗中观察)", "image_emoticon94");
        kzV.put("#(欢呼)", "image_emoticon95");
        kzV.put("#(炸药)", "image_emoticon96");
        kzV.put("#(突然兴奋)", "image_emoticon97");
        kzV.put("#(紧张)", "image_emoticon98");
        kzV.put("#(黑头瞪眼)", "image_emoticon99");
        kzV.put("#(黑头高兴)", "image_emoticon100");
        kzV.put("#(奥特曼)", "image_emoticon125");
        kzV.put("#(不听)", "image_emoticon126");
        kzV.put("#(干饭)", "image_emoticon127");
        kzV.put("#(望远镜)", "image_emoticon128");
        kzV.put("#(不跟丑人说话)", "image_emoticon101");
        kzV.put("#(么么哒)", "image_emoticon102");
        kzV.put("#(亲亲才能起来)", "image_emoticon103");
        kzV.put("#(伦家只是宝宝)", "image_emoticon104");
        kzV.put("#(你是我的人)", "image_emoticon105");
        kzV.put("#(假装看不见)", "image_emoticon106");
        kzV.put("#(单身等撩)", "image_emoticon107");
        kzV.put("#(吓到宝宝了)", "image_emoticon108");
        kzV.put("#(哈哈哈)", "image_emoticon109");
        kzV.put("#(嗯嗯)", "image_emoticon110");
        kzV.put("#(好幸福)", "image_emoticon111");
        kzV.put("#(宝宝不开心)", "image_emoticon112");
        kzV.put("#(小姐姐别走)", "image_emoticon113");
        kzV.put("#(小姐姐在吗)", "image_emoticon114");
        kzV.put("#(小姐姐来啦)", "image_emoticon115");
        kzV.put("#(小姐姐来玩呀)", "image_emoticon116");
        kzV.put("#(我养你)", "image_emoticon117");
        kzV.put("#(我是不会骗你的)", "image_emoticon118");
        kzV.put("#(扎心了)", "image_emoticon119");
        kzV.put("#(无聊)", "image_emoticon120");
        kzV.put("#(月亮代表我的心)", "image_emoticon121");
        kzV.put("#(来追我呀)", "image_emoticon122");
        kzV.put("#(爱你的形状)", "image_emoticon123");
        kzV.put("#(白眼)", "image_emoticon124");
        kzV.put("#(熊-88)", "bearchildren_01");
        kzV.put("#(熊-HI)", "bearchildren_02");
        kzV.put("#(熊-人艰不拆)", "bearchildren_03");
        kzV.put("#(熊-啥)", "bearchildren_04");
        kzV.put("#(熊-大哭)", "bearchildren_05");
        kzV.put("#(熊-失落)", "bearchildren_06");
        kzV.put("#(熊-怒赞)", "bearchildren_07");
        kzV.put("#(熊-惊呆了)", "bearchildren_08");
        kzV.put("#(熊-李菊福)", "bearchildren_09");
        kzV.put("#(熊-来信砍)", "bearchildren_10");
        kzV.put("#(熊-欢迎入群)", "bearchildren_11");
        kzV.put("#(熊-牛闪闪)", "bearchildren_12");
        kzV.put("#(熊-生日快乐)", "bearchildren_13");
        kzV.put("#(熊-石化)", "bearchildren_14");
        kzV.put("#(熊-羞羞哒)", "bearchildren_15");
        kzV.put("#(熊-肥皂必杀)", "bearchildren_16");
        kzV.put("#(熊-谢谢你)", "bearchildren_17");
        kzV.put("#(熊-跳舞)", "bearchildren_18");
        kzV.put("#(熊-霹雳舞)", "bearchildren_19");
        kzV.put("#(熊-鼓掌)", "bearchildren_20");
    }

    private static String Mr(String str) {
        return kzV.get(str);
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
                    String Mr = Mr(str2);
                    if (TextUtils.isEmpty(Mr)) {
                        str3 = str4 + str2;
                    } else {
                        if (TextUtils.isEmpty(str4)) {
                            str3 = str4;
                        } else {
                            if (i == 1) {
                                tbRichTextData.p(str4);
                            } else {
                                SpannableString aV = aV(context, str4);
                                if (aV != null) {
                                    tbRichTextData.p(aV);
                                }
                            }
                            str3 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bHE(), Mr, str2);
                        if (a2 != null) {
                            tbRichTextData.p(a2);
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
                    tbRichTextData.p(str4);
                } else {
                    SpannableString aV2 = aV(context, str4);
                    if (aV2 != null) {
                        tbRichTextData.p(aV2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int CM = TbFaceManager.bCO().CM(str);
        if (CM != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), CM);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0576a Dh = TbFaceManager.bCO().Dh(str);
            if (Dh != null) {
                int width = (int) (0.5d * Dh.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aV(Context context, String str) {
        if (str == null) {
            return null;
        }
        return bf.aB(context, str);
    }
}
