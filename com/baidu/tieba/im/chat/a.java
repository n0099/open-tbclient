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
    private static final HashMap<String, String> kAj = new HashMap<>();

    static {
        kAj.put("#(呵呵)", "image_emoticon");
        kAj.put("#(哈哈)", "image_emoticon2");
        kAj.put("#(吐舌)", "image_emoticon3");
        kAj.put("#(啊)", "image_emoticon4");
        kAj.put("#(啊?)", "image_emoticon4");
        kAj.put("#(酷)", "image_emoticon5");
        kAj.put("#(怒)", "image_emoticon6");
        kAj.put("#(开心)", "image_emoticon7");
        kAj.put("#(汗)", "image_emoticon8");
        kAj.put("#(泪)", "image_emoticon9");
        kAj.put("#(黑线)", "image_emoticon10");
        kAj.put("#(鄙视)", "image_emoticon11");
        kAj.put("#(不高兴)", "image_emoticon12");
        kAj.put("#(真棒)", "image_emoticon13");
        kAj.put("#(钱)", "image_emoticon14");
        kAj.put("#(疑问)", "image_emoticon15");
        kAj.put("#(阴险)", "image_emoticon16");
        kAj.put("#(吐)", "image_emoticon17");
        kAj.put("#(咦)", "image_emoticon18");
        kAj.put("#(咦?)", "image_emoticon18");
        kAj.put("#(委屈)", "image_emoticon19");
        kAj.put("#(花心)", "image_emoticon20");
        kAj.put("#(呼~)", "image_emoticon21");
        kAj.put("#(笑眼)", "image_emoticon22");
        kAj.put("#(冷)", "image_emoticon23");
        kAj.put("#(太开心)", "image_emoticon24");
        kAj.put("#(滑稽)", "image_emoticon25");
        kAj.put("#(勉强)", "image_emoticon26");
        kAj.put("#(狂汗)", "image_emoticon27");
        kAj.put("#(乖)", "image_emoticon28");
        kAj.put("#(睡觉)", "image_emoticon29");
        kAj.put("#(惊哭)", "image_emoticon30");
        kAj.put("#(升起)", "image_emoticon31");
        kAj.put("#(惊讶)", "image_emoticon32");
        kAj.put("#(喷)", "image_emoticon33");
        kAj.put("#(爱心)", "image_emoticon34");
        kAj.put("#(心碎)", "image_emoticon35");
        kAj.put("#(玫瑰)", "image_emoticon36");
        kAj.put("#(礼物)", "image_emoticon37");
        kAj.put("#(彩虹)", "image_emoticon38");
        kAj.put("#(星星月亮)", "image_emoticon39");
        kAj.put("#(太阳)", "image_emoticon40");
        kAj.put("#(钱币)", "image_emoticon41");
        kAj.put("#(灯泡)", "image_emoticon42");
        kAj.put("#(茶杯)", "image_emoticon43");
        kAj.put("#(蛋糕)", "image_emoticon44");
        kAj.put("#(音乐)", "image_emoticon45");
        kAj.put("#(haha)", "image_emoticon46");
        kAj.put("#(胜利)", "image_emoticon47");
        kAj.put("#(大拇指)", "image_emoticon48");
        kAj.put("#(弱)", "image_emoticon49");
        kAj.put("#(OK)", "image_emoticon50");
        kAj.put("#(哼)", "image_emoticon61");
        kAj.put("#(吃瓜)", "image_emoticon62");
        kAj.put("#(扔便便)", "image_emoticon63");
        kAj.put("#(惊恐)", "image_emoticon64");
        kAj.put("#(哎呦)", "image_emoticon65");
        kAj.put("#(小乖)", "image_emoticon66");
        kAj.put("#(捂嘴笑)", "image_emoticon67");
        kAj.put("#(你懂的)", "image_emoticon68");
        kAj.put("#(what)", "image_emoticon69");
        kAj.put("#(酸爽)", "image_emoticon70");
        kAj.put("#(呀咩爹)", "image_emoticon71");
        kAj.put("#(笑尿)", "image_emoticon72");
        kAj.put("#(挖鼻)", "image_emoticon73");
        kAj.put("#(犀利)", "image_emoticon74");
        kAj.put("#(小红脸)", "image_emoticon75");
        kAj.put("#(懒得理)", "image_emoticon76");
        kAj.put("#(沙发)", "image_emoticon77");
        kAj.put("#(手纸)", "image_emoticon78");
        kAj.put("#(香蕉)", "image_emoticon79");
        kAj.put("#(便便)", "image_emoticon80");
        kAj.put("#(药丸)", "image_emoticon81");
        kAj.put("#(红领巾)", "image_emoticon82");
        kAj.put("#(蜡烛)", "image_emoticon83");
        kAj.put("#(三道杠)", "image_emoticon84");
        kAj.put("#(赖皮)", "ali_001");
        kAj.put("#(感动)", "ali_002");
        kAj.put("#(十分惊讶)", "ali_003");
        kAj.put("#(怒气)", "ali_004");
        kAj.put("#(哭泣)", "ali_005");
        kAj.put("#(吃惊)", "ali_006");
        kAj.put("#(嘲弄)", "ali_007");
        kAj.put("#(飘过)", "ali_008");
        kAj.put("#(转圈哭)", "ali_009");
        kAj.put("#(神经病)", "ali_010");
        kAj.put("#(揪耳朵)", "ali_011");
        kAj.put("#(惊汗)", "ali_012");
        kAj.put("#(隐身)", "ali_013");
        kAj.put("#(不要嘛)", "ali_014");
        kAj.put("#(遁)", "ali_015");
        kAj.put("#(不公平)", "ali_016");
        kAj.put("#(爬来了)", "ali_017");
        kAj.put("#(蛋花哭)", "ali_018");
        kAj.put("#(温暖)", "ali_019");
        kAj.put("#(点头)", "ali_020");
        kAj.put("#(撒钱)", "ali_021");
        kAj.put("#(献花)", "ali_022");
        kAj.put("#(寒)", "ali_023");
        kAj.put("#(傻笑)", "ali_024");
        kAj.put("#(扭扭)", "ali_025");
        kAj.put("#(疯)", "ali_026");
        kAj.put("#(抓狂)", "ali_027");
        kAj.put("#(抓)", "ali_028");
        kAj.put("#(蜷)", "ali_029");
        kAj.put("#(挠墙)", "ali_030");
        kAj.put("#(狂笑)", "ali_031");
        kAj.put("#(抱枕)", "ali_032");
        kAj.put("#(吼叫)", "ali_033");
        kAj.put("#(嚷)", "ali_034");
        kAj.put("#(唠叨)", "ali_035");
        kAj.put("#(捏脸)", "ali_036");
        kAj.put("#(爆笑)", "ali_037");
        kAj.put("#(郁闷)", "ali_038");
        kAj.put("#(潜水)", "ali_039");
        kAj.put("#(十分开心)", "ali_040");
        kAj.put("#(冷笑话)", "ali_041");
        kAj.put("#(顶！)", "ali_042");
        kAj.put("#(潜)", "ali_043");
        kAj.put("#(画圈圈)", "ali_044");
        kAj.put("#(玩电脑)", "ali_045");
        kAj.put("#(狂吐)", "ali_046");
        kAj.put("#(哭着跑)", "ali_047");
        kAj.put("#(阿狸侠)", "ali_048");
        kAj.put("#(冷死了)", "ali_049");
        kAj.put("#(惆怅~)", "ali_050");
        kAj.put("#(摸头)", "ali_051");
        kAj.put("#(蹭)", "ali_052");
        kAj.put("#(打滚)", "ali_053");
        kAj.put("#(叩拜)", "ali_054");
        kAj.put("#(摸)", "ali_055");
        kAj.put("#(数钱)", "ali_056");
        kAj.put("#(拖走)", "ali_057");
        kAj.put("#(热)", "ali_058");
        kAj.put("#(加1)", "ali_059");
        kAj.put("#(压力)", "ali_060");
        kAj.put("#(表逼我)", "ali_061");
        kAj.put("#(人呢)", "ali_062");
        kAj.put("#(摇晃)", "ali_063");
        kAj.put("#(打地鼠)", "ali_064");
        kAj.put("#(这个屌)", "ali_065");
        kAj.put("#(恐慌)", "ali_066");
        kAj.put("#(晕乎乎)", "ali_067");
        kAj.put("#(浮云)", "ali_068");
        kAj.put("#(给力)", "ali_069");
        kAj.put("#(杯具了)", "ali_070");
        kAj.put("#(焦糖舞)", "yz_001");
        kAj.put("#(翻滚)", "yz_002");
        kAj.put("#(拍屁股做鬼脸)", "yz_003");
        kAj.put("#(不)", "yz_004");
        kAj.put("#(河蟹掉啦)", "yz_005");
        kAj.put("#(哦耶)", "yz_006");
        kAj.put("#(我倒)", "yz_007");
        kAj.put("#(投降)", "yz_008");
        kAj.put("#(微笑)", "b01");
        kAj.put("#(帅哥)", "b02");
        kAj.put("#(美女)", "b03");
        kAj.put("#(老大)", "b04");
        kAj.put("#(哈哈哈)", "b05");
        kAj.put("#(奸笑)", "b06");
        kAj.put("#(傻乐)", "b07");
        kAj.put("#(飞吻)", "b08");
        kAj.put("#(害羞)", "b09");
        kAj.put("#(花痴)", "b10");
        kAj.put("#(憧憬)", "b11");
        kAj.put("#(你牛)", "b12");
        kAj.put("#(鼓掌)", "b13");
        kAj.put("#(可爱)", "b14");
        kAj.put("#(太委屈)", "b15");
        kAj.put("#(大哭)", "b16");
        kAj.put("#(泪奔)", "b17");
        kAj.put("#(寻死)", "b18");
        kAj.put("#(非常惊讶)", "b19");
        kAj.put("#(表示疑问)", "b20");
        kAj.put("#(暗中观察)", "image_emoticon85");
        kAj.put("#(吃瓜)", "image_emoticon86");
        kAj.put("#(喝酒)", "image_emoticon87");
        kAj.put("#(嘿嘿嘿)", "image_emoticon88");
        kAj.put("#(噗)", "image_emoticon89");
        kAj.put("#(困成狗)", "image_emoticon90");
        kAj.put("#(微微一笑)", "image_emoticon91");
        kAj.put("#(托腮)", "image_emoticon92");
        kAj.put("#(摊手)", "image_emoticon93");
        kAj.put("#(柯基暗中观察)", "image_emoticon94");
        kAj.put("#(欢呼)", "image_emoticon95");
        kAj.put("#(炸药)", "image_emoticon96");
        kAj.put("#(突然兴奋)", "image_emoticon97");
        kAj.put("#(紧张)", "image_emoticon98");
        kAj.put("#(黑头瞪眼)", "image_emoticon99");
        kAj.put("#(黑头高兴)", "image_emoticon100");
        kAj.put("#(奥特曼)", "image_emoticon125");
        kAj.put("#(不听)", "image_emoticon126");
        kAj.put("#(干饭)", "image_emoticon127");
        kAj.put("#(望远镜)", "image_emoticon128");
        kAj.put("#(不跟丑人说话)", "image_emoticon101");
        kAj.put("#(么么哒)", "image_emoticon102");
        kAj.put("#(亲亲才能起来)", "image_emoticon103");
        kAj.put("#(伦家只是宝宝)", "image_emoticon104");
        kAj.put("#(你是我的人)", "image_emoticon105");
        kAj.put("#(假装看不见)", "image_emoticon106");
        kAj.put("#(单身等撩)", "image_emoticon107");
        kAj.put("#(吓到宝宝了)", "image_emoticon108");
        kAj.put("#(哈哈哈)", "image_emoticon109");
        kAj.put("#(嗯嗯)", "image_emoticon110");
        kAj.put("#(好幸福)", "image_emoticon111");
        kAj.put("#(宝宝不开心)", "image_emoticon112");
        kAj.put("#(小姐姐别走)", "image_emoticon113");
        kAj.put("#(小姐姐在吗)", "image_emoticon114");
        kAj.put("#(小姐姐来啦)", "image_emoticon115");
        kAj.put("#(小姐姐来玩呀)", "image_emoticon116");
        kAj.put("#(我养你)", "image_emoticon117");
        kAj.put("#(我是不会骗你的)", "image_emoticon118");
        kAj.put("#(扎心了)", "image_emoticon119");
        kAj.put("#(无聊)", "image_emoticon120");
        kAj.put("#(月亮代表我的心)", "image_emoticon121");
        kAj.put("#(来追我呀)", "image_emoticon122");
        kAj.put("#(爱你的形状)", "image_emoticon123");
        kAj.put("#(白眼)", "image_emoticon124");
        kAj.put("#(熊-88)", "bearchildren_01");
        kAj.put("#(熊-HI)", "bearchildren_02");
        kAj.put("#(熊-人艰不拆)", "bearchildren_03");
        kAj.put("#(熊-啥)", "bearchildren_04");
        kAj.put("#(熊-大哭)", "bearchildren_05");
        kAj.put("#(熊-失落)", "bearchildren_06");
        kAj.put("#(熊-怒赞)", "bearchildren_07");
        kAj.put("#(熊-惊呆了)", "bearchildren_08");
        kAj.put("#(熊-李菊福)", "bearchildren_09");
        kAj.put("#(熊-来信砍)", "bearchildren_10");
        kAj.put("#(熊-欢迎入群)", "bearchildren_11");
        kAj.put("#(熊-牛闪闪)", "bearchildren_12");
        kAj.put("#(熊-生日快乐)", "bearchildren_13");
        kAj.put("#(熊-石化)", "bearchildren_14");
        kAj.put("#(熊-羞羞哒)", "bearchildren_15");
        kAj.put("#(熊-肥皂必杀)", "bearchildren_16");
        kAj.put("#(熊-谢谢你)", "bearchildren_17");
        kAj.put("#(熊-跳舞)", "bearchildren_18");
        kAj.put("#(熊-霹雳舞)", "bearchildren_19");
        kAj.put("#(熊-鼓掌)", "bearchildren_20");
    }

    private static String Ms(String str) {
        return kAj.get(str);
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
                    String Ms = Ms(str2);
                    if (TextUtils.isEmpty(Ms)) {
                        str3 = str4 + str2;
                    } else {
                        if (TextUtils.isEmpty(str4)) {
                            str3 = str4;
                        } else {
                            if (i == 1) {
                                tbRichTextData.p(str4);
                            } else {
                                SpannableString aT = aT(context, str4);
                                if (aT != null) {
                                    tbRichTextData.p(aT);
                                }
                            }
                            str3 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bHE(), Ms, str2);
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
                    SpannableString aT2 = aT(context, str4);
                    if (aT2 != null) {
                        tbRichTextData.p(aT2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int CK = TbFaceManager.bCO().CK(str);
        if (CK != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), CK);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0576a Df = TbFaceManager.bCO().Df(str);
            if (Df != null) {
                int width = (int) (0.5d * Df.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aT(Context context, String str) {
        if (str == null) {
            return null;
        }
        return bf.aB(context, str);
    }
}
