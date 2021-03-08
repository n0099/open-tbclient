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
    private static final HashMap<String, String> kCl = new HashMap<>();

    static {
        kCl.put("#(呵呵)", "image_emoticon");
        kCl.put("#(哈哈)", "image_emoticon2");
        kCl.put("#(吐舌)", "image_emoticon3");
        kCl.put("#(啊)", "image_emoticon4");
        kCl.put("#(啊?)", "image_emoticon4");
        kCl.put("#(酷)", "image_emoticon5");
        kCl.put("#(怒)", "image_emoticon6");
        kCl.put("#(开心)", "image_emoticon7");
        kCl.put("#(汗)", "image_emoticon8");
        kCl.put("#(泪)", "image_emoticon9");
        kCl.put("#(黑线)", "image_emoticon10");
        kCl.put("#(鄙视)", "image_emoticon11");
        kCl.put("#(不高兴)", "image_emoticon12");
        kCl.put("#(真棒)", "image_emoticon13");
        kCl.put("#(钱)", "image_emoticon14");
        kCl.put("#(疑问)", "image_emoticon15");
        kCl.put("#(阴险)", "image_emoticon16");
        kCl.put("#(吐)", "image_emoticon17");
        kCl.put("#(咦)", "image_emoticon18");
        kCl.put("#(咦?)", "image_emoticon18");
        kCl.put("#(委屈)", "image_emoticon19");
        kCl.put("#(花心)", "image_emoticon20");
        kCl.put("#(呼~)", "image_emoticon21");
        kCl.put("#(笑眼)", "image_emoticon22");
        kCl.put("#(冷)", "image_emoticon23");
        kCl.put("#(太开心)", "image_emoticon24");
        kCl.put("#(滑稽)", "image_emoticon25");
        kCl.put("#(勉强)", "image_emoticon26");
        kCl.put("#(狂汗)", "image_emoticon27");
        kCl.put("#(乖)", "image_emoticon28");
        kCl.put("#(睡觉)", "image_emoticon29");
        kCl.put("#(惊哭)", "image_emoticon30");
        kCl.put("#(升起)", "image_emoticon31");
        kCl.put("#(惊讶)", "image_emoticon32");
        kCl.put("#(喷)", "image_emoticon33");
        kCl.put("#(爱心)", "image_emoticon34");
        kCl.put("#(心碎)", "image_emoticon35");
        kCl.put("#(玫瑰)", "image_emoticon36");
        kCl.put("#(礼物)", "image_emoticon37");
        kCl.put("#(彩虹)", "image_emoticon38");
        kCl.put("#(星星月亮)", "image_emoticon39");
        kCl.put("#(太阳)", "image_emoticon40");
        kCl.put("#(钱币)", "image_emoticon41");
        kCl.put("#(灯泡)", "image_emoticon42");
        kCl.put("#(茶杯)", "image_emoticon43");
        kCl.put("#(蛋糕)", "image_emoticon44");
        kCl.put("#(音乐)", "image_emoticon45");
        kCl.put("#(haha)", "image_emoticon46");
        kCl.put("#(胜利)", "image_emoticon47");
        kCl.put("#(大拇指)", "image_emoticon48");
        kCl.put("#(弱)", "image_emoticon49");
        kCl.put("#(OK)", "image_emoticon50");
        kCl.put("#(哼)", "image_emoticon61");
        kCl.put("#(吃瓜)", "image_emoticon62");
        kCl.put("#(扔便便)", "image_emoticon63");
        kCl.put("#(惊恐)", "image_emoticon64");
        kCl.put("#(哎呦)", "image_emoticon65");
        kCl.put("#(小乖)", "image_emoticon66");
        kCl.put("#(捂嘴笑)", "image_emoticon67");
        kCl.put("#(你懂的)", "image_emoticon68");
        kCl.put("#(what)", "image_emoticon69");
        kCl.put("#(酸爽)", "image_emoticon70");
        kCl.put("#(呀咩爹)", "image_emoticon71");
        kCl.put("#(笑尿)", "image_emoticon72");
        kCl.put("#(挖鼻)", "image_emoticon73");
        kCl.put("#(犀利)", "image_emoticon74");
        kCl.put("#(小红脸)", "image_emoticon75");
        kCl.put("#(懒得理)", "image_emoticon76");
        kCl.put("#(沙发)", "image_emoticon77");
        kCl.put("#(手纸)", "image_emoticon78");
        kCl.put("#(香蕉)", "image_emoticon79");
        kCl.put("#(便便)", "image_emoticon80");
        kCl.put("#(药丸)", "image_emoticon81");
        kCl.put("#(红领巾)", "image_emoticon82");
        kCl.put("#(蜡烛)", "image_emoticon83");
        kCl.put("#(三道杠)", "image_emoticon84");
        kCl.put("#(赖皮)", "ali_001");
        kCl.put("#(感动)", "ali_002");
        kCl.put("#(十分惊讶)", "ali_003");
        kCl.put("#(怒气)", "ali_004");
        kCl.put("#(哭泣)", "ali_005");
        kCl.put("#(吃惊)", "ali_006");
        kCl.put("#(嘲弄)", "ali_007");
        kCl.put("#(飘过)", "ali_008");
        kCl.put("#(转圈哭)", "ali_009");
        kCl.put("#(神经病)", "ali_010");
        kCl.put("#(揪耳朵)", "ali_011");
        kCl.put("#(惊汗)", "ali_012");
        kCl.put("#(隐身)", "ali_013");
        kCl.put("#(不要嘛)", "ali_014");
        kCl.put("#(遁)", "ali_015");
        kCl.put("#(不公平)", "ali_016");
        kCl.put("#(爬来了)", "ali_017");
        kCl.put("#(蛋花哭)", "ali_018");
        kCl.put("#(温暖)", "ali_019");
        kCl.put("#(点头)", "ali_020");
        kCl.put("#(撒钱)", "ali_021");
        kCl.put("#(献花)", "ali_022");
        kCl.put("#(寒)", "ali_023");
        kCl.put("#(傻笑)", "ali_024");
        kCl.put("#(扭扭)", "ali_025");
        kCl.put("#(疯)", "ali_026");
        kCl.put("#(抓狂)", "ali_027");
        kCl.put("#(抓)", "ali_028");
        kCl.put("#(蜷)", "ali_029");
        kCl.put("#(挠墙)", "ali_030");
        kCl.put("#(狂笑)", "ali_031");
        kCl.put("#(抱枕)", "ali_032");
        kCl.put("#(吼叫)", "ali_033");
        kCl.put("#(嚷)", "ali_034");
        kCl.put("#(唠叨)", "ali_035");
        kCl.put("#(捏脸)", "ali_036");
        kCl.put("#(爆笑)", "ali_037");
        kCl.put("#(郁闷)", "ali_038");
        kCl.put("#(潜水)", "ali_039");
        kCl.put("#(十分开心)", "ali_040");
        kCl.put("#(冷笑话)", "ali_041");
        kCl.put("#(顶！)", "ali_042");
        kCl.put("#(潜)", "ali_043");
        kCl.put("#(画圈圈)", "ali_044");
        kCl.put("#(玩电脑)", "ali_045");
        kCl.put("#(狂吐)", "ali_046");
        kCl.put("#(哭着跑)", "ali_047");
        kCl.put("#(阿狸侠)", "ali_048");
        kCl.put("#(冷死了)", "ali_049");
        kCl.put("#(惆怅~)", "ali_050");
        kCl.put("#(摸头)", "ali_051");
        kCl.put("#(蹭)", "ali_052");
        kCl.put("#(打滚)", "ali_053");
        kCl.put("#(叩拜)", "ali_054");
        kCl.put("#(摸)", "ali_055");
        kCl.put("#(数钱)", "ali_056");
        kCl.put("#(拖走)", "ali_057");
        kCl.put("#(热)", "ali_058");
        kCl.put("#(加1)", "ali_059");
        kCl.put("#(压力)", "ali_060");
        kCl.put("#(表逼我)", "ali_061");
        kCl.put("#(人呢)", "ali_062");
        kCl.put("#(摇晃)", "ali_063");
        kCl.put("#(打地鼠)", "ali_064");
        kCl.put("#(这个屌)", "ali_065");
        kCl.put("#(恐慌)", "ali_066");
        kCl.put("#(晕乎乎)", "ali_067");
        kCl.put("#(浮云)", "ali_068");
        kCl.put("#(给力)", "ali_069");
        kCl.put("#(杯具了)", "ali_070");
        kCl.put("#(焦糖舞)", "yz_001");
        kCl.put("#(翻滚)", "yz_002");
        kCl.put("#(拍屁股做鬼脸)", "yz_003");
        kCl.put("#(不)", "yz_004");
        kCl.put("#(河蟹掉啦)", "yz_005");
        kCl.put("#(哦耶)", "yz_006");
        kCl.put("#(我倒)", "yz_007");
        kCl.put("#(投降)", "yz_008");
        kCl.put("#(微笑)", "b01");
        kCl.put("#(帅哥)", "b02");
        kCl.put("#(美女)", "b03");
        kCl.put("#(老大)", "b04");
        kCl.put("#(哈哈哈)", "b05");
        kCl.put("#(奸笑)", "b06");
        kCl.put("#(傻乐)", "b07");
        kCl.put("#(飞吻)", "b08");
        kCl.put("#(害羞)", "b09");
        kCl.put("#(花痴)", "b10");
        kCl.put("#(憧憬)", "b11");
        kCl.put("#(你牛)", "b12");
        kCl.put("#(鼓掌)", "b13");
        kCl.put("#(可爱)", "b14");
        kCl.put("#(太委屈)", "b15");
        kCl.put("#(大哭)", "b16");
        kCl.put("#(泪奔)", "b17");
        kCl.put("#(寻死)", "b18");
        kCl.put("#(非常惊讶)", "b19");
        kCl.put("#(表示疑问)", "b20");
        kCl.put("#(暗中观察)", "image_emoticon85");
        kCl.put("#(吃瓜)", "image_emoticon86");
        kCl.put("#(喝酒)", "image_emoticon87");
        kCl.put("#(嘿嘿嘿)", "image_emoticon88");
        kCl.put("#(噗)", "image_emoticon89");
        kCl.put("#(困成狗)", "image_emoticon90");
        kCl.put("#(微微一笑)", "image_emoticon91");
        kCl.put("#(托腮)", "image_emoticon92");
        kCl.put("#(摊手)", "image_emoticon93");
        kCl.put("#(柯基暗中观察)", "image_emoticon94");
        kCl.put("#(欢呼)", "image_emoticon95");
        kCl.put("#(炸药)", "image_emoticon96");
        kCl.put("#(突然兴奋)", "image_emoticon97");
        kCl.put("#(紧张)", "image_emoticon98");
        kCl.put("#(黑头瞪眼)", "image_emoticon99");
        kCl.put("#(黑头高兴)", "image_emoticon100");
        kCl.put("#(奥特曼)", "image_emoticon125");
        kCl.put("#(不听)", "image_emoticon126");
        kCl.put("#(干饭)", "image_emoticon127");
        kCl.put("#(望远镜)", "image_emoticon128");
        kCl.put("#(不跟丑人说话)", "image_emoticon101");
        kCl.put("#(么么哒)", "image_emoticon102");
        kCl.put("#(亲亲才能起来)", "image_emoticon103");
        kCl.put("#(伦家只是宝宝)", "image_emoticon104");
        kCl.put("#(你是我的人)", "image_emoticon105");
        kCl.put("#(假装看不见)", "image_emoticon106");
        kCl.put("#(单身等撩)", "image_emoticon107");
        kCl.put("#(吓到宝宝了)", "image_emoticon108");
        kCl.put("#(哈哈哈)", "image_emoticon109");
        kCl.put("#(嗯嗯)", "image_emoticon110");
        kCl.put("#(好幸福)", "image_emoticon111");
        kCl.put("#(宝宝不开心)", "image_emoticon112");
        kCl.put("#(小姐姐别走)", "image_emoticon113");
        kCl.put("#(小姐姐在吗)", "image_emoticon114");
        kCl.put("#(小姐姐来啦)", "image_emoticon115");
        kCl.put("#(小姐姐来玩呀)", "image_emoticon116");
        kCl.put("#(我养你)", "image_emoticon117");
        kCl.put("#(我是不会骗你的)", "image_emoticon118");
        kCl.put("#(扎心了)", "image_emoticon119");
        kCl.put("#(无聊)", "image_emoticon120");
        kCl.put("#(月亮代表我的心)", "image_emoticon121");
        kCl.put("#(来追我呀)", "image_emoticon122");
        kCl.put("#(爱你的形状)", "image_emoticon123");
        kCl.put("#(白眼)", "image_emoticon124");
        kCl.put("#(熊-88)", "bearchildren_01");
        kCl.put("#(熊-HI)", "bearchildren_02");
        kCl.put("#(熊-人艰不拆)", "bearchildren_03");
        kCl.put("#(熊-啥)", "bearchildren_04");
        kCl.put("#(熊-大哭)", "bearchildren_05");
        kCl.put("#(熊-失落)", "bearchildren_06");
        kCl.put("#(熊-怒赞)", "bearchildren_07");
        kCl.put("#(熊-惊呆了)", "bearchildren_08");
        kCl.put("#(熊-李菊福)", "bearchildren_09");
        kCl.put("#(熊-来信砍)", "bearchildren_10");
        kCl.put("#(熊-欢迎入群)", "bearchildren_11");
        kCl.put("#(熊-牛闪闪)", "bearchildren_12");
        kCl.put("#(熊-生日快乐)", "bearchildren_13");
        kCl.put("#(熊-石化)", "bearchildren_14");
        kCl.put("#(熊-羞羞哒)", "bearchildren_15");
        kCl.put("#(熊-肥皂必杀)", "bearchildren_16");
        kCl.put("#(熊-谢谢你)", "bearchildren_17");
        kCl.put("#(熊-跳舞)", "bearchildren_18");
        kCl.put("#(熊-霹雳舞)", "bearchildren_19");
        kCl.put("#(熊-鼓掌)", "bearchildren_20");
    }

    private static String My(String str) {
        return kCl.get(str);
    }

    public static ArrayList<TbRichTextData> e(Context context, String str, int i) {
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
                    String My = My(str2);
                    if (TextUtils.isEmpty(My)) {
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
                        SpannableString a2 = a(tbRichTextData.bHI(), My, str2);
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
        int CR = TbFaceManager.bCR().CR(str);
        if (CR != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), CR);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0582a Dm = TbFaceManager.bCR().Dm(str);
            if (Dm != null) {
                int width = (int) (0.5d * Dm.getWidth());
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
