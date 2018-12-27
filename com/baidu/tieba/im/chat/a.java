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
    private static final HashMap<String, String> eJT = new HashMap<>();

    static {
        eJT.put("#(呵呵)", "image_emoticon");
        eJT.put("#(哈哈)", "image_emoticon2");
        eJT.put("#(吐舌)", "image_emoticon3");
        eJT.put("#(啊)", "image_emoticon4");
        eJT.put("#(啊?)", "image_emoticon4");
        eJT.put("#(酷)", "image_emoticon5");
        eJT.put("#(怒)", "image_emoticon6");
        eJT.put("#(开心)", "image_emoticon7");
        eJT.put("#(汗)", "image_emoticon8");
        eJT.put("#(泪)", "image_emoticon9");
        eJT.put("#(黑线)", "image_emoticon10");
        eJT.put("#(鄙视)", "image_emoticon11");
        eJT.put("#(不高兴)", "image_emoticon12");
        eJT.put("#(真棒)", "image_emoticon13");
        eJT.put("#(钱)", "image_emoticon14");
        eJT.put("#(疑问)", "image_emoticon15");
        eJT.put("#(阴险)", "image_emoticon16");
        eJT.put("#(吐)", "image_emoticon17");
        eJT.put("#(咦)", "image_emoticon18");
        eJT.put("#(咦?)", "image_emoticon18");
        eJT.put("#(委屈)", "image_emoticon19");
        eJT.put("#(花心)", "image_emoticon20");
        eJT.put("#(呼~)", "image_emoticon21");
        eJT.put("#(笑眼)", "image_emoticon22");
        eJT.put("#(冷)", "image_emoticon23");
        eJT.put("#(太开心)", "image_emoticon24");
        eJT.put("#(滑稽)", "image_emoticon25");
        eJT.put("#(勉强)", "image_emoticon26");
        eJT.put("#(狂汗)", "image_emoticon27");
        eJT.put("#(乖)", "image_emoticon28");
        eJT.put("#(睡觉)", "image_emoticon29");
        eJT.put("#(惊哭)", "image_emoticon30");
        eJT.put("#(升起)", "image_emoticon31");
        eJT.put("#(惊讶)", "image_emoticon32");
        eJT.put("#(喷)", "image_emoticon33");
        eJT.put("#(爱心)", "image_emoticon34");
        eJT.put("#(心碎)", "image_emoticon35");
        eJT.put("#(玫瑰)", "image_emoticon36");
        eJT.put("#(礼物)", "image_emoticon37");
        eJT.put("#(彩虹)", "image_emoticon38");
        eJT.put("#(星星月亮)", "image_emoticon39");
        eJT.put("#(太阳)", "image_emoticon40");
        eJT.put("#(钱币)", "image_emoticon41");
        eJT.put("#(灯泡)", "image_emoticon42");
        eJT.put("#(茶杯)", "image_emoticon43");
        eJT.put("#(蛋糕)", "image_emoticon44");
        eJT.put("#(音乐)", "image_emoticon45");
        eJT.put("#(haha)", "image_emoticon46");
        eJT.put("#(胜利)", "image_emoticon47");
        eJT.put("#(大拇指)", "image_emoticon48");
        eJT.put("#(弱)", "image_emoticon49");
        eJT.put("#(OK)", "image_emoticon50");
        eJT.put("#(哼)", "image_emoticon61");
        eJT.put("#(吃瓜)", "image_emoticon62");
        eJT.put("#(扔便便)", "image_emoticon63");
        eJT.put("#(惊恐)", "image_emoticon64");
        eJT.put("#(哎呦)", "image_emoticon65");
        eJT.put("#(小乖)", "image_emoticon66");
        eJT.put("#(捂嘴笑)", "image_emoticon67");
        eJT.put("#(你懂的)", "image_emoticon68");
        eJT.put("#(what)", "image_emoticon69");
        eJT.put("#(酸爽)", "image_emoticon70");
        eJT.put("#(呀咩爹)", "image_emoticon71");
        eJT.put("#(笑尿)", "image_emoticon72");
        eJT.put("#(挖鼻)", "image_emoticon73");
        eJT.put("#(犀利)", "image_emoticon74");
        eJT.put("#(小红脸)", "image_emoticon75");
        eJT.put("#(懒得理)", "image_emoticon76");
        eJT.put("#(沙发)", "image_emoticon77");
        eJT.put("#(手纸)", "image_emoticon78");
        eJT.put("#(香蕉)", "image_emoticon79");
        eJT.put("#(便便)", "image_emoticon80");
        eJT.put("#(药丸)", "image_emoticon81");
        eJT.put("#(红领巾)", "image_emoticon82");
        eJT.put("#(蜡烛)", "image_emoticon83");
        eJT.put("#(三道杠)", "image_emoticon84");
        eJT.put("#(赖皮)", "ali_001");
        eJT.put("#(感动)", "ali_002");
        eJT.put("#(十分惊讶)", "ali_003");
        eJT.put("#(怒气)", "ali_004");
        eJT.put("#(哭泣)", "ali_005");
        eJT.put("#(吃惊)", "ali_006");
        eJT.put("#(嘲弄)", "ali_007");
        eJT.put("#(飘过)", "ali_008");
        eJT.put("#(转圈哭)", "ali_009");
        eJT.put("#(神经病)", "ali_010");
        eJT.put("#(揪耳朵)", "ali_011");
        eJT.put("#(惊汗)", "ali_012");
        eJT.put("#(隐身)", "ali_013");
        eJT.put("#(不要嘛)", "ali_014");
        eJT.put("#(遁)", "ali_015");
        eJT.put("#(不公平)", "ali_016");
        eJT.put("#(爬来了)", "ali_017");
        eJT.put("#(蛋花哭)", "ali_018");
        eJT.put("#(温暖)", "ali_019");
        eJT.put("#(点头)", "ali_020");
        eJT.put("#(撒钱)", "ali_021");
        eJT.put("#(献花)", "ali_022");
        eJT.put("#(寒)", "ali_023");
        eJT.put("#(傻笑)", "ali_024");
        eJT.put("#(扭扭)", "ali_025");
        eJT.put("#(疯)", "ali_026");
        eJT.put("#(抓狂)", "ali_027");
        eJT.put("#(抓)", "ali_028");
        eJT.put("#(蜷)", "ali_029");
        eJT.put("#(挠墙)", "ali_030");
        eJT.put("#(狂笑)", "ali_031");
        eJT.put("#(抱枕)", "ali_032");
        eJT.put("#(吼叫)", "ali_033");
        eJT.put("#(嚷)", "ali_034");
        eJT.put("#(唠叨)", "ali_035");
        eJT.put("#(捏脸)", "ali_036");
        eJT.put("#(爆笑)", "ali_037");
        eJT.put("#(郁闷)", "ali_038");
        eJT.put("#(潜水)", "ali_039");
        eJT.put("#(十分开心)", "ali_040");
        eJT.put("#(冷笑话)", "ali_041");
        eJT.put("#(顶！)", "ali_042");
        eJT.put("#(潜)", "ali_043");
        eJT.put("#(画圈圈)", "ali_044");
        eJT.put("#(玩电脑)", "ali_045");
        eJT.put("#(狂吐)", "ali_046");
        eJT.put("#(哭着跑)", "ali_047");
        eJT.put("#(阿狸侠)", "ali_048");
        eJT.put("#(冷死了)", "ali_049");
        eJT.put("#(惆怅~)", "ali_050");
        eJT.put("#(摸头)", "ali_051");
        eJT.put("#(蹭)", "ali_052");
        eJT.put("#(打滚)", "ali_053");
        eJT.put("#(叩拜)", "ali_054");
        eJT.put("#(摸)", "ali_055");
        eJT.put("#(数钱)", "ali_056");
        eJT.put("#(拖走)", "ali_057");
        eJT.put("#(热)", "ali_058");
        eJT.put("#(加1)", "ali_059");
        eJT.put("#(压力)", "ali_060");
        eJT.put("#(表逼我)", "ali_061");
        eJT.put("#(人呢)", "ali_062");
        eJT.put("#(摇晃)", "ali_063");
        eJT.put("#(打地鼠)", "ali_064");
        eJT.put("#(这个屌)", "ali_065");
        eJT.put("#(恐慌)", "ali_066");
        eJT.put("#(晕乎乎)", "ali_067");
        eJT.put("#(浮云)", "ali_068");
        eJT.put("#(给力)", "ali_069");
        eJT.put("#(杯具了)", "ali_070");
        eJT.put("#(焦糖舞)", "yz_001");
        eJT.put("#(翻滚)", "yz_002");
        eJT.put("#(拍屁股做鬼脸)", "yz_003");
        eJT.put("#(不)", "yz_004");
        eJT.put("#(河蟹掉啦)", "yz_005");
        eJT.put("#(哦耶)", "yz_006");
        eJT.put("#(我倒)", "yz_007");
        eJT.put("#(投降)", "yz_008");
        eJT.put("#(微笑)", "b01");
        eJT.put("#(帅哥)", "b02");
        eJT.put("#(美女)", "b03");
        eJT.put("#(老大)", "b04");
        eJT.put("#(哈哈哈)", "b05");
        eJT.put("#(奸笑)", "b06");
        eJT.put("#(傻乐)", "b07");
        eJT.put("#(飞吻)", "b08");
        eJT.put("#(害羞)", "b09");
        eJT.put("#(花痴)", "b10");
        eJT.put("#(憧憬)", "b11");
        eJT.put("#(你牛)", "b12");
        eJT.put("#(鼓掌)", "b13");
        eJT.put("#(可爱)", "b14");
        eJT.put("#(太委屈)", "b15");
        eJT.put("#(大哭)", "b16");
        eJT.put("#(泪奔)", "b17");
        eJT.put("#(寻死)", "b18");
        eJT.put("#(非常惊讶)", "b19");
        eJT.put("#(表示疑问)", "b20");
        eJT.put("#(暗中观察)", "image_emoticon85");
        eJT.put("#(吃瓜)", "image_emoticon86");
        eJT.put("#(喝酒)", "image_emoticon87");
        eJT.put("#(嘿嘿嘿)", "image_emoticon88");
        eJT.put("#(噗)", "image_emoticon89");
        eJT.put("#(困成狗)", "image_emoticon90");
        eJT.put("#(微微一笑)", "image_emoticon91");
        eJT.put("#(托腮)", "image_emoticon92");
        eJT.put("#(摊手)", "image_emoticon93");
        eJT.put("#(柯基暗中观察)", "image_emoticon94");
        eJT.put("#(欢呼)", "image_emoticon95");
        eJT.put("#(炸药)", "image_emoticon96");
        eJT.put("#(突然兴奋)", "image_emoticon97");
        eJT.put("#(紧张)", "image_emoticon98");
        eJT.put("#(黑头瞪眼)", "image_emoticon99");
        eJT.put("#(黑头高兴)", "image_emoticon100");
        eJT.put("#(不跟丑人说话)", "image_emoticon101");
        eJT.put("#(么么哒)", "image_emoticon102");
        eJT.put("#(亲亲才能起来)", "image_emoticon103");
        eJT.put("#(伦家只是宝宝)", "image_emoticon104");
        eJT.put("#(你是我的人)", "image_emoticon105");
        eJT.put("#(假装看不见)", "image_emoticon106");
        eJT.put("#(单身等撩)", "image_emoticon107");
        eJT.put("#(吓到宝宝了)", "image_emoticon108");
        eJT.put("#(哈哈哈)", "image_emoticon109");
        eJT.put("#(嗯嗯)", "image_emoticon110");
        eJT.put("#(好幸福)", "image_emoticon111");
        eJT.put("#(宝宝不开心)", "image_emoticon112");
        eJT.put("#(小姐姐别走)", "image_emoticon113");
        eJT.put("#(小姐姐在吗)", "image_emoticon114");
        eJT.put("#(小姐姐来啦)", "image_emoticon115");
        eJT.put("#(小姐姐来玩呀)", "image_emoticon116");
        eJT.put("#(我养你)", "image_emoticon117");
        eJT.put("#(我是不会骗你的)", "image_emoticon118");
        eJT.put("#(扎心了)", "image_emoticon119");
        eJT.put("#(无聊)", "image_emoticon120");
        eJT.put("#(月亮代表我的心)", "image_emoticon121");
        eJT.put("#(来追我呀)", "image_emoticon122");
        eJT.put("#(爱你的形状)", "image_emoticon123");
        eJT.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return eJT.get(str);
    }

    public static ArrayList<TbRichTextData> h(Context context, String str, int i) {
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
                                SpannableString az = az(context, str5);
                                if (az != null) {
                                    tbRichTextData.append(az);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.Sg(), name, str3);
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
                    SpannableString az2 = az(context, str5);
                    if (az2 != null) {
                        tbRichTextData.append(az2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int hE = TbFaceManager.Nu().hE(str);
        if (hE != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), hE);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0171a ic = TbFaceManager.Nu().ic(str);
            if (ic != null) {
                int width = (int) (0.5d * ic.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString az(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ay.ai(context, str);
    }
}
