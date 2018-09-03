package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> ejJ = new HashMap<>();

    static {
        ejJ.put("#(呵呵)", "image_emoticon");
        ejJ.put("#(哈哈)", "image_emoticon2");
        ejJ.put("#(吐舌)", "image_emoticon3");
        ejJ.put("#(啊)", "image_emoticon4");
        ejJ.put("#(啊?)", "image_emoticon4");
        ejJ.put("#(酷)", "image_emoticon5");
        ejJ.put("#(怒)", "image_emoticon6");
        ejJ.put("#(开心)", "image_emoticon7");
        ejJ.put("#(汗)", "image_emoticon8");
        ejJ.put("#(泪)", "image_emoticon9");
        ejJ.put("#(黑线)", "image_emoticon10");
        ejJ.put("#(鄙视)", "image_emoticon11");
        ejJ.put("#(不高兴)", "image_emoticon12");
        ejJ.put("#(真棒)", "image_emoticon13");
        ejJ.put("#(钱)", "image_emoticon14");
        ejJ.put("#(疑问)", "image_emoticon15");
        ejJ.put("#(阴险)", "image_emoticon16");
        ejJ.put("#(吐)", "image_emoticon17");
        ejJ.put("#(咦)", "image_emoticon18");
        ejJ.put("#(咦?)", "image_emoticon18");
        ejJ.put("#(委屈)", "image_emoticon19");
        ejJ.put("#(花心)", "image_emoticon20");
        ejJ.put("#(呼~)", "image_emoticon21");
        ejJ.put("#(笑眼)", "image_emoticon22");
        ejJ.put("#(冷)", "image_emoticon23");
        ejJ.put("#(太开心)", "image_emoticon24");
        ejJ.put("#(滑稽)", "image_emoticon25");
        ejJ.put("#(勉强)", "image_emoticon26");
        ejJ.put("#(狂汗)", "image_emoticon27");
        ejJ.put("#(乖)", "image_emoticon28");
        ejJ.put("#(睡觉)", "image_emoticon29");
        ejJ.put("#(惊哭)", "image_emoticon30");
        ejJ.put("#(升起)", "image_emoticon31");
        ejJ.put("#(惊讶)", "image_emoticon32");
        ejJ.put("#(喷)", "image_emoticon33");
        ejJ.put("#(爱心)", "image_emoticon34");
        ejJ.put("#(心碎)", "image_emoticon35");
        ejJ.put("#(玫瑰)", "image_emoticon36");
        ejJ.put("#(礼物)", "image_emoticon37");
        ejJ.put("#(彩虹)", "image_emoticon38");
        ejJ.put("#(星星月亮)", "image_emoticon39");
        ejJ.put("#(太阳)", "image_emoticon40");
        ejJ.put("#(钱币)", "image_emoticon41");
        ejJ.put("#(灯泡)", "image_emoticon42");
        ejJ.put("#(茶杯)", "image_emoticon43");
        ejJ.put("#(蛋糕)", "image_emoticon44");
        ejJ.put("#(音乐)", "image_emoticon45");
        ejJ.put("#(haha)", "image_emoticon46");
        ejJ.put("#(胜利)", "image_emoticon47");
        ejJ.put("#(大拇指)", "image_emoticon48");
        ejJ.put("#(弱)", "image_emoticon49");
        ejJ.put("#(OK)", "image_emoticon50");
        ejJ.put("#(哼)", "image_emoticon61");
        ejJ.put("#(吃瓜)", "image_emoticon62");
        ejJ.put("#(扔便便)", "image_emoticon63");
        ejJ.put("#(惊恐)", "image_emoticon64");
        ejJ.put("#(哎呦)", "image_emoticon65");
        ejJ.put("#(小乖)", "image_emoticon66");
        ejJ.put("#(捂嘴笑)", "image_emoticon67");
        ejJ.put("#(你懂的)", "image_emoticon68");
        ejJ.put("#(what)", "image_emoticon69");
        ejJ.put("#(酸爽)", "image_emoticon70");
        ejJ.put("#(呀咩爹)", "image_emoticon71");
        ejJ.put("#(笑尿)", "image_emoticon72");
        ejJ.put("#(挖鼻)", "image_emoticon73");
        ejJ.put("#(犀利)", "image_emoticon74");
        ejJ.put("#(小红脸)", "image_emoticon75");
        ejJ.put("#(懒得理)", "image_emoticon76");
        ejJ.put("#(沙发)", "image_emoticon77");
        ejJ.put("#(手纸)", "image_emoticon78");
        ejJ.put("#(香蕉)", "image_emoticon79");
        ejJ.put("#(便便)", "image_emoticon80");
        ejJ.put("#(药丸)", "image_emoticon81");
        ejJ.put("#(红领巾)", "image_emoticon82");
        ejJ.put("#(蜡烛)", "image_emoticon83");
        ejJ.put("#(三道杠)", "image_emoticon84");
        ejJ.put("#(赖皮)", "ali_001");
        ejJ.put("#(感动)", "ali_002");
        ejJ.put("#(十分惊讶)", "ali_003");
        ejJ.put("#(怒气)", "ali_004");
        ejJ.put("#(哭泣)", "ali_005");
        ejJ.put("#(吃惊)", "ali_006");
        ejJ.put("#(嘲弄)", "ali_007");
        ejJ.put("#(飘过)", "ali_008");
        ejJ.put("#(转圈哭)", "ali_009");
        ejJ.put("#(神经病)", "ali_010");
        ejJ.put("#(揪耳朵)", "ali_011");
        ejJ.put("#(惊汗)", "ali_012");
        ejJ.put("#(隐身)", "ali_013");
        ejJ.put("#(不要嘛)", "ali_014");
        ejJ.put("#(遁)", "ali_015");
        ejJ.put("#(不公平)", "ali_016");
        ejJ.put("#(爬来了)", "ali_017");
        ejJ.put("#(蛋花哭)", "ali_018");
        ejJ.put("#(温暖)", "ali_019");
        ejJ.put("#(点头)", "ali_020");
        ejJ.put("#(撒钱)", "ali_021");
        ejJ.put("#(献花)", "ali_022");
        ejJ.put("#(寒)", "ali_023");
        ejJ.put("#(傻笑)", "ali_024");
        ejJ.put("#(扭扭)", "ali_025");
        ejJ.put("#(疯)", "ali_026");
        ejJ.put("#(抓狂)", "ali_027");
        ejJ.put("#(抓)", "ali_028");
        ejJ.put("#(蜷)", "ali_029");
        ejJ.put("#(挠墙)", "ali_030");
        ejJ.put("#(狂笑)", "ali_031");
        ejJ.put("#(抱枕)", "ali_032");
        ejJ.put("#(吼叫)", "ali_033");
        ejJ.put("#(嚷)", "ali_034");
        ejJ.put("#(唠叨)", "ali_035");
        ejJ.put("#(捏脸)", "ali_036");
        ejJ.put("#(爆笑)", "ali_037");
        ejJ.put("#(郁闷)", "ali_038");
        ejJ.put("#(潜水)", "ali_039");
        ejJ.put("#(十分开心)", "ali_040");
        ejJ.put("#(冷笑话)", "ali_041");
        ejJ.put("#(顶！)", "ali_042");
        ejJ.put("#(潜)", "ali_043");
        ejJ.put("#(画圈圈)", "ali_044");
        ejJ.put("#(玩电脑)", "ali_045");
        ejJ.put("#(狂吐)", "ali_046");
        ejJ.put("#(哭着跑)", "ali_047");
        ejJ.put("#(阿狸侠)", "ali_048");
        ejJ.put("#(冷死了)", "ali_049");
        ejJ.put("#(惆怅~)", "ali_050");
        ejJ.put("#(摸头)", "ali_051");
        ejJ.put("#(蹭)", "ali_052");
        ejJ.put("#(打滚)", "ali_053");
        ejJ.put("#(叩拜)", "ali_054");
        ejJ.put("#(摸)", "ali_055");
        ejJ.put("#(数钱)", "ali_056");
        ejJ.put("#(拖走)", "ali_057");
        ejJ.put("#(热)", "ali_058");
        ejJ.put("#(加1)", "ali_059");
        ejJ.put("#(压力)", "ali_060");
        ejJ.put("#(表逼我)", "ali_061");
        ejJ.put("#(人呢)", "ali_062");
        ejJ.put("#(摇晃)", "ali_063");
        ejJ.put("#(打地鼠)", "ali_064");
        ejJ.put("#(这个屌)", "ali_065");
        ejJ.put("#(恐慌)", "ali_066");
        ejJ.put("#(晕乎乎)", "ali_067");
        ejJ.put("#(浮云)", "ali_068");
        ejJ.put("#(给力)", "ali_069");
        ejJ.put("#(杯具了)", "ali_070");
        ejJ.put("#(焦糖舞)", "yz_001");
        ejJ.put("#(翻滚)", "yz_002");
        ejJ.put("#(拍屁股做鬼脸)", "yz_003");
        ejJ.put("#(不)", "yz_004");
        ejJ.put("#(河蟹掉啦)", "yz_005");
        ejJ.put("#(哦耶)", "yz_006");
        ejJ.put("#(我倒)", "yz_007");
        ejJ.put("#(投降)", "yz_008");
        ejJ.put("#(微笑)", "b01");
        ejJ.put("#(帅哥)", "b02");
        ejJ.put("#(美女)", "b03");
        ejJ.put("#(老大)", "b04");
        ejJ.put("#(哈哈哈)", "b05");
        ejJ.put("#(奸笑)", "b06");
        ejJ.put("#(傻乐)", "b07");
        ejJ.put("#(飞吻)", "b08");
        ejJ.put("#(害羞)", "b09");
        ejJ.put("#(花痴)", "b10");
        ejJ.put("#(憧憬)", "b11");
        ejJ.put("#(你牛)", "b12");
        ejJ.put("#(鼓掌)", "b13");
        ejJ.put("#(可爱)", "b14");
        ejJ.put("#(太委屈)", "b15");
        ejJ.put("#(大哭)", "b16");
        ejJ.put("#(泪奔)", "b17");
        ejJ.put("#(寻死)", "b18");
        ejJ.put("#(非常惊讶)", "b19");
        ejJ.put("#(表示疑问)", "b20");
        ejJ.put("#(暗中观察)", "image_emoticon85");
        ejJ.put("#(吃瓜)", "image_emoticon86");
        ejJ.put("#(喝酒)", "image_emoticon87");
        ejJ.put("#(嘿嘿嘿)", "image_emoticon88");
        ejJ.put("#(噗)", "image_emoticon89");
        ejJ.put("#(困成狗)", "image_emoticon90");
        ejJ.put("#(微微一笑)", "image_emoticon91");
        ejJ.put("#(托腮)", "image_emoticon92");
        ejJ.put("#(摊手)", "image_emoticon93");
        ejJ.put("#(柯基暗中观察)", "image_emoticon94");
        ejJ.put("#(欢呼)", "image_emoticon95");
        ejJ.put("#(炸药)", "image_emoticon96");
        ejJ.put("#(突然兴奋)", "image_emoticon97");
        ejJ.put("#(紧张)", "image_emoticon98");
        ejJ.put("#(黑头瞪眼)", "image_emoticon99");
        ejJ.put("#(黑头高兴)", "image_emoticon100");
        ejJ.put("#(不跟丑人说话)", "image_emoticon101");
        ejJ.put("#(么么哒)", "image_emoticon102");
        ejJ.put("#(亲亲才能起来)", "image_emoticon103");
        ejJ.put("#(伦家只是宝宝)", "image_emoticon104");
        ejJ.put("#(你是我的人)", "image_emoticon105");
        ejJ.put("#(假装看不见)", "image_emoticon106");
        ejJ.put("#(单身等撩)", "image_emoticon107");
        ejJ.put("#(吓到宝宝了)", "image_emoticon108");
        ejJ.put("#(哈哈哈)", "image_emoticon109");
        ejJ.put("#(嗯嗯)", "image_emoticon110");
        ejJ.put("#(好幸福)", "image_emoticon111");
        ejJ.put("#(宝宝不开心)", "image_emoticon112");
        ejJ.put("#(小姐姐别走)", "image_emoticon113");
        ejJ.put("#(小姐姐在吗)", "image_emoticon114");
        ejJ.put("#(小姐姐来啦)", "image_emoticon115");
        ejJ.put("#(小姐姐来玩呀)", "image_emoticon116");
        ejJ.put("#(我养你)", "image_emoticon117");
        ejJ.put("#(我是不会骗你的)", "image_emoticon118");
        ejJ.put("#(扎心了)", "image_emoticon119");
        ejJ.put("#(无聊)", "image_emoticon120");
        ejJ.put("#(月亮代表我的心)", "image_emoticon121");
        ejJ.put("#(来追我呀)", "image_emoticon122");
        ejJ.put("#(爱你的形状)", "image_emoticon123");
        ejJ.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return ejJ.get(str);
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
                        SpannableString b = b(tbRichTextData.NB(), name, str3);
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
        return az.U(context, str);
    }
}
