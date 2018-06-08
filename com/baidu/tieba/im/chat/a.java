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
    private static final HashMap<String, String> ecd = new HashMap<>();

    static {
        ecd.put("#(呵呵)", "image_emoticon");
        ecd.put("#(哈哈)", "image_emoticon2");
        ecd.put("#(吐舌)", "image_emoticon3");
        ecd.put("#(啊)", "image_emoticon4");
        ecd.put("#(啊?)", "image_emoticon4");
        ecd.put("#(酷)", "image_emoticon5");
        ecd.put("#(怒)", "image_emoticon6");
        ecd.put("#(开心)", "image_emoticon7");
        ecd.put("#(汗)", "image_emoticon8");
        ecd.put("#(泪)", "image_emoticon9");
        ecd.put("#(黑线)", "image_emoticon10");
        ecd.put("#(鄙视)", "image_emoticon11");
        ecd.put("#(不高兴)", "image_emoticon12");
        ecd.put("#(真棒)", "image_emoticon13");
        ecd.put("#(钱)", "image_emoticon14");
        ecd.put("#(疑问)", "image_emoticon15");
        ecd.put("#(阴险)", "image_emoticon16");
        ecd.put("#(吐)", "image_emoticon17");
        ecd.put("#(咦)", "image_emoticon18");
        ecd.put("#(咦?)", "image_emoticon18");
        ecd.put("#(委屈)", "image_emoticon19");
        ecd.put("#(花心)", "image_emoticon20");
        ecd.put("#(呼~)", "image_emoticon21");
        ecd.put("#(笑眼)", "image_emoticon22");
        ecd.put("#(冷)", "image_emoticon23");
        ecd.put("#(太开心)", "image_emoticon24");
        ecd.put("#(滑稽)", "image_emoticon25");
        ecd.put("#(勉强)", "image_emoticon26");
        ecd.put("#(狂汗)", "image_emoticon27");
        ecd.put("#(乖)", "image_emoticon28");
        ecd.put("#(睡觉)", "image_emoticon29");
        ecd.put("#(惊哭)", "image_emoticon30");
        ecd.put("#(升起)", "image_emoticon31");
        ecd.put("#(惊讶)", "image_emoticon32");
        ecd.put("#(喷)", "image_emoticon33");
        ecd.put("#(爱心)", "image_emoticon34");
        ecd.put("#(心碎)", "image_emoticon35");
        ecd.put("#(玫瑰)", "image_emoticon36");
        ecd.put("#(礼物)", "image_emoticon37");
        ecd.put("#(彩虹)", "image_emoticon38");
        ecd.put("#(星星月亮)", "image_emoticon39");
        ecd.put("#(太阳)", "image_emoticon40");
        ecd.put("#(钱币)", "image_emoticon41");
        ecd.put("#(灯泡)", "image_emoticon42");
        ecd.put("#(茶杯)", "image_emoticon43");
        ecd.put("#(蛋糕)", "image_emoticon44");
        ecd.put("#(音乐)", "image_emoticon45");
        ecd.put("#(haha)", "image_emoticon46");
        ecd.put("#(胜利)", "image_emoticon47");
        ecd.put("#(大拇指)", "image_emoticon48");
        ecd.put("#(弱)", "image_emoticon49");
        ecd.put("#(OK)", "image_emoticon50");
        ecd.put("#(哼)", "image_emoticon61");
        ecd.put("#(吃瓜)", "image_emoticon62");
        ecd.put("#(扔便便)", "image_emoticon63");
        ecd.put("#(惊恐)", "image_emoticon64");
        ecd.put("#(哎呦)", "image_emoticon65");
        ecd.put("#(小乖)", "image_emoticon66");
        ecd.put("#(捂嘴笑)", "image_emoticon67");
        ecd.put("#(你懂的)", "image_emoticon68");
        ecd.put("#(what)", "image_emoticon69");
        ecd.put("#(酸爽)", "image_emoticon70");
        ecd.put("#(呀咩爹)", "image_emoticon71");
        ecd.put("#(笑尿)", "image_emoticon72");
        ecd.put("#(挖鼻)", "image_emoticon73");
        ecd.put("#(犀利)", "image_emoticon74");
        ecd.put("#(小红脸)", "image_emoticon75");
        ecd.put("#(懒得理)", "image_emoticon76");
        ecd.put("#(沙发)", "image_emoticon77");
        ecd.put("#(手纸)", "image_emoticon78");
        ecd.put("#(香蕉)", "image_emoticon79");
        ecd.put("#(便便)", "image_emoticon80");
        ecd.put("#(药丸)", "image_emoticon81");
        ecd.put("#(红领巾)", "image_emoticon82");
        ecd.put("#(蜡烛)", "image_emoticon83");
        ecd.put("#(三道杠)", "image_emoticon84");
        ecd.put("#(赖皮)", "ali_001");
        ecd.put("#(感动)", "ali_002");
        ecd.put("#(十分惊讶)", "ali_003");
        ecd.put("#(怒气)", "ali_004");
        ecd.put("#(哭泣)", "ali_005");
        ecd.put("#(吃惊)", "ali_006");
        ecd.put("#(嘲弄)", "ali_007");
        ecd.put("#(飘过)", "ali_008");
        ecd.put("#(转圈哭)", "ali_009");
        ecd.put("#(神经病)", "ali_010");
        ecd.put("#(揪耳朵)", "ali_011");
        ecd.put("#(惊汗)", "ali_012");
        ecd.put("#(隐身)", "ali_013");
        ecd.put("#(不要嘛)", "ali_014");
        ecd.put("#(遁)", "ali_015");
        ecd.put("#(不公平)", "ali_016");
        ecd.put("#(爬来了)", "ali_017");
        ecd.put("#(蛋花哭)", "ali_018");
        ecd.put("#(温暖)", "ali_019");
        ecd.put("#(点头)", "ali_020");
        ecd.put("#(撒钱)", "ali_021");
        ecd.put("#(献花)", "ali_022");
        ecd.put("#(寒)", "ali_023");
        ecd.put("#(傻笑)", "ali_024");
        ecd.put("#(扭扭)", "ali_025");
        ecd.put("#(疯)", "ali_026");
        ecd.put("#(抓狂)", "ali_027");
        ecd.put("#(抓)", "ali_028");
        ecd.put("#(蜷)", "ali_029");
        ecd.put("#(挠墙)", "ali_030");
        ecd.put("#(狂笑)", "ali_031");
        ecd.put("#(抱枕)", "ali_032");
        ecd.put("#(吼叫)", "ali_033");
        ecd.put("#(嚷)", "ali_034");
        ecd.put("#(唠叨)", "ali_035");
        ecd.put("#(捏脸)", "ali_036");
        ecd.put("#(爆笑)", "ali_037");
        ecd.put("#(郁闷)", "ali_038");
        ecd.put("#(潜水)", "ali_039");
        ecd.put("#(十分开心)", "ali_040");
        ecd.put("#(冷笑话)", "ali_041");
        ecd.put("#(顶！)", "ali_042");
        ecd.put("#(潜)", "ali_043");
        ecd.put("#(画圈圈)", "ali_044");
        ecd.put("#(玩电脑)", "ali_045");
        ecd.put("#(狂吐)", "ali_046");
        ecd.put("#(哭着跑)", "ali_047");
        ecd.put("#(阿狸侠)", "ali_048");
        ecd.put("#(冷死了)", "ali_049");
        ecd.put("#(惆怅~)", "ali_050");
        ecd.put("#(摸头)", "ali_051");
        ecd.put("#(蹭)", "ali_052");
        ecd.put("#(打滚)", "ali_053");
        ecd.put("#(叩拜)", "ali_054");
        ecd.put("#(摸)", "ali_055");
        ecd.put("#(数钱)", "ali_056");
        ecd.put("#(拖走)", "ali_057");
        ecd.put("#(热)", "ali_058");
        ecd.put("#(加1)", "ali_059");
        ecd.put("#(压力)", "ali_060");
        ecd.put("#(表逼我)", "ali_061");
        ecd.put("#(人呢)", "ali_062");
        ecd.put("#(摇晃)", "ali_063");
        ecd.put("#(打地鼠)", "ali_064");
        ecd.put("#(这个屌)", "ali_065");
        ecd.put("#(恐慌)", "ali_066");
        ecd.put("#(晕乎乎)", "ali_067");
        ecd.put("#(浮云)", "ali_068");
        ecd.put("#(给力)", "ali_069");
        ecd.put("#(杯具了)", "ali_070");
        ecd.put("#(焦糖舞)", "yz_001");
        ecd.put("#(翻滚)", "yz_002");
        ecd.put("#(拍屁股做鬼脸)", "yz_003");
        ecd.put("#(不)", "yz_004");
        ecd.put("#(河蟹掉啦)", "yz_005");
        ecd.put("#(哦耶)", "yz_006");
        ecd.put("#(我倒)", "yz_007");
        ecd.put("#(投降)", "yz_008");
        ecd.put("#(微笑)", "b01");
        ecd.put("#(帅哥)", "b02");
        ecd.put("#(美女)", "b03");
        ecd.put("#(老大)", "b04");
        ecd.put("#(哈哈哈)", "b05");
        ecd.put("#(奸笑)", "b06");
        ecd.put("#(傻乐)", "b07");
        ecd.put("#(飞吻)", "b08");
        ecd.put("#(害羞)", "b09");
        ecd.put("#(花痴)", "b10");
        ecd.put("#(憧憬)", "b11");
        ecd.put("#(你牛)", "b12");
        ecd.put("#(鼓掌)", "b13");
        ecd.put("#(可爱)", "b14");
        ecd.put("#(太委屈)", "b15");
        ecd.put("#(大哭)", "b16");
        ecd.put("#(泪奔)", "b17");
        ecd.put("#(寻死)", "b18");
        ecd.put("#(非常惊讶)", "b19");
        ecd.put("#(表示疑问)", "b20");
        ecd.put("#(暗中观察)", "image_emoticon85");
        ecd.put("#(吃瓜)", "image_emoticon86");
        ecd.put("#(喝酒)", "image_emoticon87");
        ecd.put("#(嘿嘿嘿)", "image_emoticon88");
        ecd.put("#(噗)", "image_emoticon89");
        ecd.put("#(困成狗)", "image_emoticon90");
        ecd.put("#(微微一笑)", "image_emoticon91");
        ecd.put("#(托腮)", "image_emoticon92");
        ecd.put("#(摊手)", "image_emoticon93");
        ecd.put("#(柯基暗中观察)", "image_emoticon94");
        ecd.put("#(欢呼)", "image_emoticon95");
        ecd.put("#(炸药)", "image_emoticon96");
        ecd.put("#(突然兴奋)", "image_emoticon97");
        ecd.put("#(紧张)", "image_emoticon98");
        ecd.put("#(黑头瞪眼)", "image_emoticon99");
        ecd.put("#(黑头高兴)", "image_emoticon100");
        ecd.put("#(不跟丑人说话)", "image_emoticon101");
        ecd.put("#(么么哒)", "image_emoticon102");
        ecd.put("#(亲亲才能起来)", "image_emoticon103");
        ecd.put("#(伦家只是宝宝)", "image_emoticon104");
        ecd.put("#(你是我的人)", "image_emoticon105");
        ecd.put("#(假装看不见)", "image_emoticon106");
        ecd.put("#(单身等撩)", "image_emoticon107");
        ecd.put("#(吓到宝宝了)", "image_emoticon108");
        ecd.put("#(哈哈哈)", "image_emoticon109");
        ecd.put("#(嗯嗯)", "image_emoticon110");
        ecd.put("#(好幸福)", "image_emoticon111");
        ecd.put("#(宝宝不开心)", "image_emoticon112");
        ecd.put("#(小姐姐别走)", "image_emoticon113");
        ecd.put("#(小姐姐在吗)", "image_emoticon114");
        ecd.put("#(小姐姐来啦)", "image_emoticon115");
        ecd.put("#(小姐姐来玩呀)", "image_emoticon116");
        ecd.put("#(我养你)", "image_emoticon117");
        ecd.put("#(我是不会骗你的)", "image_emoticon118");
        ecd.put("#(扎心了)", "image_emoticon119");
        ecd.put("#(无聊)", "image_emoticon120");
        ecd.put("#(月亮代表我的心)", "image_emoticon121");
        ecd.put("#(来追我呀)", "image_emoticon122");
        ecd.put("#(爱你的形状)", "image_emoticon123");
        ecd.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return ecd.get(str);
    }

    public static ArrayList<TbRichTextData> f(Context context, String str, int i) {
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
                                SpannableString af = af(context, str5);
                                if (af != null) {
                                    tbRichTextData.append(af);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.Nl(), name, str3);
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
                    SpannableString af2 = af(context, str5);
                    if (af2 != null) {
                        tbRichTextData.append(af2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gA = TbFaceManager.IC().gA(str);
        if (gA != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gA);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0115a gZ = TbFaceManager.IC().gZ(str);
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

    private static SpannableString af(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ay.S(context, str);
    }
}
