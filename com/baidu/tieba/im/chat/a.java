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
    private static final HashMap<String, String> erc = new HashMap<>();

    static {
        erc.put("#(呵呵)", "image_emoticon");
        erc.put("#(哈哈)", "image_emoticon2");
        erc.put("#(吐舌)", "image_emoticon3");
        erc.put("#(啊)", "image_emoticon4");
        erc.put("#(啊?)", "image_emoticon4");
        erc.put("#(酷)", "image_emoticon5");
        erc.put("#(怒)", "image_emoticon6");
        erc.put("#(开心)", "image_emoticon7");
        erc.put("#(汗)", "image_emoticon8");
        erc.put("#(泪)", "image_emoticon9");
        erc.put("#(黑线)", "image_emoticon10");
        erc.put("#(鄙视)", "image_emoticon11");
        erc.put("#(不高兴)", "image_emoticon12");
        erc.put("#(真棒)", "image_emoticon13");
        erc.put("#(钱)", "image_emoticon14");
        erc.put("#(疑问)", "image_emoticon15");
        erc.put("#(阴险)", "image_emoticon16");
        erc.put("#(吐)", "image_emoticon17");
        erc.put("#(咦)", "image_emoticon18");
        erc.put("#(咦?)", "image_emoticon18");
        erc.put("#(委屈)", "image_emoticon19");
        erc.put("#(花心)", "image_emoticon20");
        erc.put("#(呼~)", "image_emoticon21");
        erc.put("#(笑眼)", "image_emoticon22");
        erc.put("#(冷)", "image_emoticon23");
        erc.put("#(太开心)", "image_emoticon24");
        erc.put("#(滑稽)", "image_emoticon25");
        erc.put("#(勉强)", "image_emoticon26");
        erc.put("#(狂汗)", "image_emoticon27");
        erc.put("#(乖)", "image_emoticon28");
        erc.put("#(睡觉)", "image_emoticon29");
        erc.put("#(惊哭)", "image_emoticon30");
        erc.put("#(升起)", "image_emoticon31");
        erc.put("#(惊讶)", "image_emoticon32");
        erc.put("#(喷)", "image_emoticon33");
        erc.put("#(爱心)", "image_emoticon34");
        erc.put("#(心碎)", "image_emoticon35");
        erc.put("#(玫瑰)", "image_emoticon36");
        erc.put("#(礼物)", "image_emoticon37");
        erc.put("#(彩虹)", "image_emoticon38");
        erc.put("#(星星月亮)", "image_emoticon39");
        erc.put("#(太阳)", "image_emoticon40");
        erc.put("#(钱币)", "image_emoticon41");
        erc.put("#(灯泡)", "image_emoticon42");
        erc.put("#(茶杯)", "image_emoticon43");
        erc.put("#(蛋糕)", "image_emoticon44");
        erc.put("#(音乐)", "image_emoticon45");
        erc.put("#(haha)", "image_emoticon46");
        erc.put("#(胜利)", "image_emoticon47");
        erc.put("#(大拇指)", "image_emoticon48");
        erc.put("#(弱)", "image_emoticon49");
        erc.put("#(OK)", "image_emoticon50");
        erc.put("#(哼)", "image_emoticon61");
        erc.put("#(吃瓜)", "image_emoticon62");
        erc.put("#(扔便便)", "image_emoticon63");
        erc.put("#(惊恐)", "image_emoticon64");
        erc.put("#(哎呦)", "image_emoticon65");
        erc.put("#(小乖)", "image_emoticon66");
        erc.put("#(捂嘴笑)", "image_emoticon67");
        erc.put("#(你懂的)", "image_emoticon68");
        erc.put("#(what)", "image_emoticon69");
        erc.put("#(酸爽)", "image_emoticon70");
        erc.put("#(呀咩爹)", "image_emoticon71");
        erc.put("#(笑尿)", "image_emoticon72");
        erc.put("#(挖鼻)", "image_emoticon73");
        erc.put("#(犀利)", "image_emoticon74");
        erc.put("#(小红脸)", "image_emoticon75");
        erc.put("#(懒得理)", "image_emoticon76");
        erc.put("#(沙发)", "image_emoticon77");
        erc.put("#(手纸)", "image_emoticon78");
        erc.put("#(香蕉)", "image_emoticon79");
        erc.put("#(便便)", "image_emoticon80");
        erc.put("#(药丸)", "image_emoticon81");
        erc.put("#(红领巾)", "image_emoticon82");
        erc.put("#(蜡烛)", "image_emoticon83");
        erc.put("#(三道杠)", "image_emoticon84");
        erc.put("#(赖皮)", "ali_001");
        erc.put("#(感动)", "ali_002");
        erc.put("#(十分惊讶)", "ali_003");
        erc.put("#(怒气)", "ali_004");
        erc.put("#(哭泣)", "ali_005");
        erc.put("#(吃惊)", "ali_006");
        erc.put("#(嘲弄)", "ali_007");
        erc.put("#(飘过)", "ali_008");
        erc.put("#(转圈哭)", "ali_009");
        erc.put("#(神经病)", "ali_010");
        erc.put("#(揪耳朵)", "ali_011");
        erc.put("#(惊汗)", "ali_012");
        erc.put("#(隐身)", "ali_013");
        erc.put("#(不要嘛)", "ali_014");
        erc.put("#(遁)", "ali_015");
        erc.put("#(不公平)", "ali_016");
        erc.put("#(爬来了)", "ali_017");
        erc.put("#(蛋花哭)", "ali_018");
        erc.put("#(温暖)", "ali_019");
        erc.put("#(点头)", "ali_020");
        erc.put("#(撒钱)", "ali_021");
        erc.put("#(献花)", "ali_022");
        erc.put("#(寒)", "ali_023");
        erc.put("#(傻笑)", "ali_024");
        erc.put("#(扭扭)", "ali_025");
        erc.put("#(疯)", "ali_026");
        erc.put("#(抓狂)", "ali_027");
        erc.put("#(抓)", "ali_028");
        erc.put("#(蜷)", "ali_029");
        erc.put("#(挠墙)", "ali_030");
        erc.put("#(狂笑)", "ali_031");
        erc.put("#(抱枕)", "ali_032");
        erc.put("#(吼叫)", "ali_033");
        erc.put("#(嚷)", "ali_034");
        erc.put("#(唠叨)", "ali_035");
        erc.put("#(捏脸)", "ali_036");
        erc.put("#(爆笑)", "ali_037");
        erc.put("#(郁闷)", "ali_038");
        erc.put("#(潜水)", "ali_039");
        erc.put("#(十分开心)", "ali_040");
        erc.put("#(冷笑话)", "ali_041");
        erc.put("#(顶！)", "ali_042");
        erc.put("#(潜)", "ali_043");
        erc.put("#(画圈圈)", "ali_044");
        erc.put("#(玩电脑)", "ali_045");
        erc.put("#(狂吐)", "ali_046");
        erc.put("#(哭着跑)", "ali_047");
        erc.put("#(阿狸侠)", "ali_048");
        erc.put("#(冷死了)", "ali_049");
        erc.put("#(惆怅~)", "ali_050");
        erc.put("#(摸头)", "ali_051");
        erc.put("#(蹭)", "ali_052");
        erc.put("#(打滚)", "ali_053");
        erc.put("#(叩拜)", "ali_054");
        erc.put("#(摸)", "ali_055");
        erc.put("#(数钱)", "ali_056");
        erc.put("#(拖走)", "ali_057");
        erc.put("#(热)", "ali_058");
        erc.put("#(加1)", "ali_059");
        erc.put("#(压力)", "ali_060");
        erc.put("#(表逼我)", "ali_061");
        erc.put("#(人呢)", "ali_062");
        erc.put("#(摇晃)", "ali_063");
        erc.put("#(打地鼠)", "ali_064");
        erc.put("#(这个屌)", "ali_065");
        erc.put("#(恐慌)", "ali_066");
        erc.put("#(晕乎乎)", "ali_067");
        erc.put("#(浮云)", "ali_068");
        erc.put("#(给力)", "ali_069");
        erc.put("#(杯具了)", "ali_070");
        erc.put("#(焦糖舞)", "yz_001");
        erc.put("#(翻滚)", "yz_002");
        erc.put("#(拍屁股做鬼脸)", "yz_003");
        erc.put("#(不)", "yz_004");
        erc.put("#(河蟹掉啦)", "yz_005");
        erc.put("#(哦耶)", "yz_006");
        erc.put("#(我倒)", "yz_007");
        erc.put("#(投降)", "yz_008");
        erc.put("#(微笑)", "b01");
        erc.put("#(帅哥)", "b02");
        erc.put("#(美女)", "b03");
        erc.put("#(老大)", "b04");
        erc.put("#(哈哈哈)", "b05");
        erc.put("#(奸笑)", "b06");
        erc.put("#(傻乐)", "b07");
        erc.put("#(飞吻)", "b08");
        erc.put("#(害羞)", "b09");
        erc.put("#(花痴)", "b10");
        erc.put("#(憧憬)", "b11");
        erc.put("#(你牛)", "b12");
        erc.put("#(鼓掌)", "b13");
        erc.put("#(可爱)", "b14");
        erc.put("#(太委屈)", "b15");
        erc.put("#(大哭)", "b16");
        erc.put("#(泪奔)", "b17");
        erc.put("#(寻死)", "b18");
        erc.put("#(非常惊讶)", "b19");
        erc.put("#(表示疑问)", "b20");
        erc.put("#(暗中观察)", "image_emoticon85");
        erc.put("#(吃瓜)", "image_emoticon86");
        erc.put("#(喝酒)", "image_emoticon87");
        erc.put("#(嘿嘿嘿)", "image_emoticon88");
        erc.put("#(噗)", "image_emoticon89");
        erc.put("#(困成狗)", "image_emoticon90");
        erc.put("#(微微一笑)", "image_emoticon91");
        erc.put("#(托腮)", "image_emoticon92");
        erc.put("#(摊手)", "image_emoticon93");
        erc.put("#(柯基暗中观察)", "image_emoticon94");
        erc.put("#(欢呼)", "image_emoticon95");
        erc.put("#(炸药)", "image_emoticon96");
        erc.put("#(突然兴奋)", "image_emoticon97");
        erc.put("#(紧张)", "image_emoticon98");
        erc.put("#(黑头瞪眼)", "image_emoticon99");
        erc.put("#(黑头高兴)", "image_emoticon100");
        erc.put("#(不跟丑人说话)", "image_emoticon101");
        erc.put("#(么么哒)", "image_emoticon102");
        erc.put("#(亲亲才能起来)", "image_emoticon103");
        erc.put("#(伦家只是宝宝)", "image_emoticon104");
        erc.put("#(你是我的人)", "image_emoticon105");
        erc.put("#(假装看不见)", "image_emoticon106");
        erc.put("#(单身等撩)", "image_emoticon107");
        erc.put("#(吓到宝宝了)", "image_emoticon108");
        erc.put("#(哈哈哈)", "image_emoticon109");
        erc.put("#(嗯嗯)", "image_emoticon110");
        erc.put("#(好幸福)", "image_emoticon111");
        erc.put("#(宝宝不开心)", "image_emoticon112");
        erc.put("#(小姐姐别走)", "image_emoticon113");
        erc.put("#(小姐姐在吗)", "image_emoticon114");
        erc.put("#(小姐姐来啦)", "image_emoticon115");
        erc.put("#(小姐姐来玩呀)", "image_emoticon116");
        erc.put("#(我养你)", "image_emoticon117");
        erc.put("#(我是不会骗你的)", "image_emoticon118");
        erc.put("#(扎心了)", "image_emoticon119");
        erc.put("#(无聊)", "image_emoticon120");
        erc.put("#(月亮代表我的心)", "image_emoticon121");
        erc.put("#(来追我呀)", "image_emoticon122");
        erc.put("#(爱你的形状)", "image_emoticon123");
        erc.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return erc.get(str);
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
                                SpannableString aw = aw(context, str5);
                                if (aw != null) {
                                    tbRichTextData.append(aw);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.OU(), name, str3);
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
                    SpannableString aw2 = aw(context, str5);
                    if (aw2 != null) {
                        tbRichTextData.append(aw2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gW = TbFaceManager.Kf().gW(str);
        if (gW != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gW);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0113a hv = TbFaceManager.Kf().hv(str);
            if (hv != null) {
                int width = (int) (0.5d * hv.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aw(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ay.aj(context, str);
    }
}
