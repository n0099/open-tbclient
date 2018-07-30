package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> ejN = new HashMap<>();

    static {
        ejN.put("#(呵呵)", "image_emoticon");
        ejN.put("#(哈哈)", "image_emoticon2");
        ejN.put("#(吐舌)", "image_emoticon3");
        ejN.put("#(啊)", "image_emoticon4");
        ejN.put("#(啊?)", "image_emoticon4");
        ejN.put("#(酷)", "image_emoticon5");
        ejN.put("#(怒)", "image_emoticon6");
        ejN.put("#(开心)", "image_emoticon7");
        ejN.put("#(汗)", "image_emoticon8");
        ejN.put("#(泪)", "image_emoticon9");
        ejN.put("#(黑线)", "image_emoticon10");
        ejN.put("#(鄙视)", "image_emoticon11");
        ejN.put("#(不高兴)", "image_emoticon12");
        ejN.put("#(真棒)", "image_emoticon13");
        ejN.put("#(钱)", "image_emoticon14");
        ejN.put("#(疑问)", "image_emoticon15");
        ejN.put("#(阴险)", "image_emoticon16");
        ejN.put("#(吐)", "image_emoticon17");
        ejN.put("#(咦)", "image_emoticon18");
        ejN.put("#(咦?)", "image_emoticon18");
        ejN.put("#(委屈)", "image_emoticon19");
        ejN.put("#(花心)", "image_emoticon20");
        ejN.put("#(呼~)", "image_emoticon21");
        ejN.put("#(笑眼)", "image_emoticon22");
        ejN.put("#(冷)", "image_emoticon23");
        ejN.put("#(太开心)", "image_emoticon24");
        ejN.put("#(滑稽)", "image_emoticon25");
        ejN.put("#(勉强)", "image_emoticon26");
        ejN.put("#(狂汗)", "image_emoticon27");
        ejN.put("#(乖)", "image_emoticon28");
        ejN.put("#(睡觉)", "image_emoticon29");
        ejN.put("#(惊哭)", "image_emoticon30");
        ejN.put("#(升起)", "image_emoticon31");
        ejN.put("#(惊讶)", "image_emoticon32");
        ejN.put("#(喷)", "image_emoticon33");
        ejN.put("#(爱心)", "image_emoticon34");
        ejN.put("#(心碎)", "image_emoticon35");
        ejN.put("#(玫瑰)", "image_emoticon36");
        ejN.put("#(礼物)", "image_emoticon37");
        ejN.put("#(彩虹)", "image_emoticon38");
        ejN.put("#(星星月亮)", "image_emoticon39");
        ejN.put("#(太阳)", "image_emoticon40");
        ejN.put("#(钱币)", "image_emoticon41");
        ejN.put("#(灯泡)", "image_emoticon42");
        ejN.put("#(茶杯)", "image_emoticon43");
        ejN.put("#(蛋糕)", "image_emoticon44");
        ejN.put("#(音乐)", "image_emoticon45");
        ejN.put("#(haha)", "image_emoticon46");
        ejN.put("#(胜利)", "image_emoticon47");
        ejN.put("#(大拇指)", "image_emoticon48");
        ejN.put("#(弱)", "image_emoticon49");
        ejN.put("#(OK)", "image_emoticon50");
        ejN.put("#(哼)", "image_emoticon61");
        ejN.put("#(吃瓜)", "image_emoticon62");
        ejN.put("#(扔便便)", "image_emoticon63");
        ejN.put("#(惊恐)", "image_emoticon64");
        ejN.put("#(哎呦)", "image_emoticon65");
        ejN.put("#(小乖)", "image_emoticon66");
        ejN.put("#(捂嘴笑)", "image_emoticon67");
        ejN.put("#(你懂的)", "image_emoticon68");
        ejN.put("#(what)", "image_emoticon69");
        ejN.put("#(酸爽)", "image_emoticon70");
        ejN.put("#(呀咩爹)", "image_emoticon71");
        ejN.put("#(笑尿)", "image_emoticon72");
        ejN.put("#(挖鼻)", "image_emoticon73");
        ejN.put("#(犀利)", "image_emoticon74");
        ejN.put("#(小红脸)", "image_emoticon75");
        ejN.put("#(懒得理)", "image_emoticon76");
        ejN.put("#(沙发)", "image_emoticon77");
        ejN.put("#(手纸)", "image_emoticon78");
        ejN.put("#(香蕉)", "image_emoticon79");
        ejN.put("#(便便)", "image_emoticon80");
        ejN.put("#(药丸)", "image_emoticon81");
        ejN.put("#(红领巾)", "image_emoticon82");
        ejN.put("#(蜡烛)", "image_emoticon83");
        ejN.put("#(三道杠)", "image_emoticon84");
        ejN.put("#(赖皮)", "ali_001");
        ejN.put("#(感动)", "ali_002");
        ejN.put("#(十分惊讶)", "ali_003");
        ejN.put("#(怒气)", "ali_004");
        ejN.put("#(哭泣)", "ali_005");
        ejN.put("#(吃惊)", "ali_006");
        ejN.put("#(嘲弄)", "ali_007");
        ejN.put("#(飘过)", "ali_008");
        ejN.put("#(转圈哭)", "ali_009");
        ejN.put("#(神经病)", "ali_010");
        ejN.put("#(揪耳朵)", "ali_011");
        ejN.put("#(惊汗)", "ali_012");
        ejN.put("#(隐身)", "ali_013");
        ejN.put("#(不要嘛)", "ali_014");
        ejN.put("#(遁)", "ali_015");
        ejN.put("#(不公平)", "ali_016");
        ejN.put("#(爬来了)", "ali_017");
        ejN.put("#(蛋花哭)", "ali_018");
        ejN.put("#(温暖)", "ali_019");
        ejN.put("#(点头)", "ali_020");
        ejN.put("#(撒钱)", "ali_021");
        ejN.put("#(献花)", "ali_022");
        ejN.put("#(寒)", "ali_023");
        ejN.put("#(傻笑)", "ali_024");
        ejN.put("#(扭扭)", "ali_025");
        ejN.put("#(疯)", "ali_026");
        ejN.put("#(抓狂)", "ali_027");
        ejN.put("#(抓)", "ali_028");
        ejN.put("#(蜷)", "ali_029");
        ejN.put("#(挠墙)", "ali_030");
        ejN.put("#(狂笑)", "ali_031");
        ejN.put("#(抱枕)", "ali_032");
        ejN.put("#(吼叫)", "ali_033");
        ejN.put("#(嚷)", "ali_034");
        ejN.put("#(唠叨)", "ali_035");
        ejN.put("#(捏脸)", "ali_036");
        ejN.put("#(爆笑)", "ali_037");
        ejN.put("#(郁闷)", "ali_038");
        ejN.put("#(潜水)", "ali_039");
        ejN.put("#(十分开心)", "ali_040");
        ejN.put("#(冷笑话)", "ali_041");
        ejN.put("#(顶！)", "ali_042");
        ejN.put("#(潜)", "ali_043");
        ejN.put("#(画圈圈)", "ali_044");
        ejN.put("#(玩电脑)", "ali_045");
        ejN.put("#(狂吐)", "ali_046");
        ejN.put("#(哭着跑)", "ali_047");
        ejN.put("#(阿狸侠)", "ali_048");
        ejN.put("#(冷死了)", "ali_049");
        ejN.put("#(惆怅~)", "ali_050");
        ejN.put("#(摸头)", "ali_051");
        ejN.put("#(蹭)", "ali_052");
        ejN.put("#(打滚)", "ali_053");
        ejN.put("#(叩拜)", "ali_054");
        ejN.put("#(摸)", "ali_055");
        ejN.put("#(数钱)", "ali_056");
        ejN.put("#(拖走)", "ali_057");
        ejN.put("#(热)", "ali_058");
        ejN.put("#(加1)", "ali_059");
        ejN.put("#(压力)", "ali_060");
        ejN.put("#(表逼我)", "ali_061");
        ejN.put("#(人呢)", "ali_062");
        ejN.put("#(摇晃)", "ali_063");
        ejN.put("#(打地鼠)", "ali_064");
        ejN.put("#(这个屌)", "ali_065");
        ejN.put("#(恐慌)", "ali_066");
        ejN.put("#(晕乎乎)", "ali_067");
        ejN.put("#(浮云)", "ali_068");
        ejN.put("#(给力)", "ali_069");
        ejN.put("#(杯具了)", "ali_070");
        ejN.put("#(焦糖舞)", "yz_001");
        ejN.put("#(翻滚)", "yz_002");
        ejN.put("#(拍屁股做鬼脸)", "yz_003");
        ejN.put("#(不)", "yz_004");
        ejN.put("#(河蟹掉啦)", "yz_005");
        ejN.put("#(哦耶)", "yz_006");
        ejN.put("#(我倒)", "yz_007");
        ejN.put("#(投降)", "yz_008");
        ejN.put("#(微笑)", "b01");
        ejN.put("#(帅哥)", "b02");
        ejN.put("#(美女)", "b03");
        ejN.put("#(老大)", "b04");
        ejN.put("#(哈哈哈)", "b05");
        ejN.put("#(奸笑)", "b06");
        ejN.put("#(傻乐)", "b07");
        ejN.put("#(飞吻)", "b08");
        ejN.put("#(害羞)", "b09");
        ejN.put("#(花痴)", "b10");
        ejN.put("#(憧憬)", "b11");
        ejN.put("#(你牛)", "b12");
        ejN.put("#(鼓掌)", "b13");
        ejN.put("#(可爱)", "b14");
        ejN.put("#(太委屈)", "b15");
        ejN.put("#(大哭)", "b16");
        ejN.put("#(泪奔)", "b17");
        ejN.put("#(寻死)", "b18");
        ejN.put("#(非常惊讶)", "b19");
        ejN.put("#(表示疑问)", "b20");
        ejN.put("#(暗中观察)", "image_emoticon85");
        ejN.put("#(吃瓜)", "image_emoticon86");
        ejN.put("#(喝酒)", "image_emoticon87");
        ejN.put("#(嘿嘿嘿)", "image_emoticon88");
        ejN.put("#(噗)", "image_emoticon89");
        ejN.put("#(困成狗)", "image_emoticon90");
        ejN.put("#(微微一笑)", "image_emoticon91");
        ejN.put("#(托腮)", "image_emoticon92");
        ejN.put("#(摊手)", "image_emoticon93");
        ejN.put("#(柯基暗中观察)", "image_emoticon94");
        ejN.put("#(欢呼)", "image_emoticon95");
        ejN.put("#(炸药)", "image_emoticon96");
        ejN.put("#(突然兴奋)", "image_emoticon97");
        ejN.put("#(紧张)", "image_emoticon98");
        ejN.put("#(黑头瞪眼)", "image_emoticon99");
        ejN.put("#(黑头高兴)", "image_emoticon100");
        ejN.put("#(不跟丑人说话)", "image_emoticon101");
        ejN.put("#(么么哒)", "image_emoticon102");
        ejN.put("#(亲亲才能起来)", "image_emoticon103");
        ejN.put("#(伦家只是宝宝)", "image_emoticon104");
        ejN.put("#(你是我的人)", "image_emoticon105");
        ejN.put("#(假装看不见)", "image_emoticon106");
        ejN.put("#(单身等撩)", "image_emoticon107");
        ejN.put("#(吓到宝宝了)", "image_emoticon108");
        ejN.put("#(哈哈哈)", "image_emoticon109");
        ejN.put("#(嗯嗯)", "image_emoticon110");
        ejN.put("#(好幸福)", "image_emoticon111");
        ejN.put("#(宝宝不开心)", "image_emoticon112");
        ejN.put("#(小姐姐别走)", "image_emoticon113");
        ejN.put("#(小姐姐在吗)", "image_emoticon114");
        ejN.put("#(小姐姐来啦)", "image_emoticon115");
        ejN.put("#(小姐姐来玩呀)", "image_emoticon116");
        ejN.put("#(我养你)", "image_emoticon117");
        ejN.put("#(我是不会骗你的)", "image_emoticon118");
        ejN.put("#(扎心了)", "image_emoticon119");
        ejN.put("#(无聊)", "image_emoticon120");
        ejN.put("#(月亮代表我的心)", "image_emoticon121");
        ejN.put("#(来追我呀)", "image_emoticon122");
        ejN.put("#(爱你的形状)", "image_emoticon123");
        ejN.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return ejN.get(str);
    }

    public static ArrayList<TbRichTextData> g(Context context, String str, int i) {
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
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.append(str5);
                            } else {
                                SpannableString ah = ah(context, str5);
                                if (ah != null) {
                                    tbRichTextData.append(ah);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.NC(), name, str3);
                        if (b != null) {
                            tbRichTextData.append(b);
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
                    tbRichTextData.append(str5);
                } else {
                    SpannableString ah2 = ah(context, str5);
                    if (ah2 != null) {
                        tbRichTextData.append(ah2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gA = TbFaceManager.IP().gA(str);
        if (gA != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gA);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0113a gZ = TbFaceManager.IP().gZ(str);
            if (gZ != null) {
                int width = (int) (0.5d * gZ.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ah(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ay.U(context, str);
    }
}
