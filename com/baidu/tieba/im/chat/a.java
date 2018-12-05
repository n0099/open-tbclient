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
    private static final HashMap<String, String> eHc = new HashMap<>();

    static {
        eHc.put("#(呵呵)", "image_emoticon");
        eHc.put("#(哈哈)", "image_emoticon2");
        eHc.put("#(吐舌)", "image_emoticon3");
        eHc.put("#(啊)", "image_emoticon4");
        eHc.put("#(啊?)", "image_emoticon4");
        eHc.put("#(酷)", "image_emoticon5");
        eHc.put("#(怒)", "image_emoticon6");
        eHc.put("#(开心)", "image_emoticon7");
        eHc.put("#(汗)", "image_emoticon8");
        eHc.put("#(泪)", "image_emoticon9");
        eHc.put("#(黑线)", "image_emoticon10");
        eHc.put("#(鄙视)", "image_emoticon11");
        eHc.put("#(不高兴)", "image_emoticon12");
        eHc.put("#(真棒)", "image_emoticon13");
        eHc.put("#(钱)", "image_emoticon14");
        eHc.put("#(疑问)", "image_emoticon15");
        eHc.put("#(阴险)", "image_emoticon16");
        eHc.put("#(吐)", "image_emoticon17");
        eHc.put("#(咦)", "image_emoticon18");
        eHc.put("#(咦?)", "image_emoticon18");
        eHc.put("#(委屈)", "image_emoticon19");
        eHc.put("#(花心)", "image_emoticon20");
        eHc.put("#(呼~)", "image_emoticon21");
        eHc.put("#(笑眼)", "image_emoticon22");
        eHc.put("#(冷)", "image_emoticon23");
        eHc.put("#(太开心)", "image_emoticon24");
        eHc.put("#(滑稽)", "image_emoticon25");
        eHc.put("#(勉强)", "image_emoticon26");
        eHc.put("#(狂汗)", "image_emoticon27");
        eHc.put("#(乖)", "image_emoticon28");
        eHc.put("#(睡觉)", "image_emoticon29");
        eHc.put("#(惊哭)", "image_emoticon30");
        eHc.put("#(升起)", "image_emoticon31");
        eHc.put("#(惊讶)", "image_emoticon32");
        eHc.put("#(喷)", "image_emoticon33");
        eHc.put("#(爱心)", "image_emoticon34");
        eHc.put("#(心碎)", "image_emoticon35");
        eHc.put("#(玫瑰)", "image_emoticon36");
        eHc.put("#(礼物)", "image_emoticon37");
        eHc.put("#(彩虹)", "image_emoticon38");
        eHc.put("#(星星月亮)", "image_emoticon39");
        eHc.put("#(太阳)", "image_emoticon40");
        eHc.put("#(钱币)", "image_emoticon41");
        eHc.put("#(灯泡)", "image_emoticon42");
        eHc.put("#(茶杯)", "image_emoticon43");
        eHc.put("#(蛋糕)", "image_emoticon44");
        eHc.put("#(音乐)", "image_emoticon45");
        eHc.put("#(haha)", "image_emoticon46");
        eHc.put("#(胜利)", "image_emoticon47");
        eHc.put("#(大拇指)", "image_emoticon48");
        eHc.put("#(弱)", "image_emoticon49");
        eHc.put("#(OK)", "image_emoticon50");
        eHc.put("#(哼)", "image_emoticon61");
        eHc.put("#(吃瓜)", "image_emoticon62");
        eHc.put("#(扔便便)", "image_emoticon63");
        eHc.put("#(惊恐)", "image_emoticon64");
        eHc.put("#(哎呦)", "image_emoticon65");
        eHc.put("#(小乖)", "image_emoticon66");
        eHc.put("#(捂嘴笑)", "image_emoticon67");
        eHc.put("#(你懂的)", "image_emoticon68");
        eHc.put("#(what)", "image_emoticon69");
        eHc.put("#(酸爽)", "image_emoticon70");
        eHc.put("#(呀咩爹)", "image_emoticon71");
        eHc.put("#(笑尿)", "image_emoticon72");
        eHc.put("#(挖鼻)", "image_emoticon73");
        eHc.put("#(犀利)", "image_emoticon74");
        eHc.put("#(小红脸)", "image_emoticon75");
        eHc.put("#(懒得理)", "image_emoticon76");
        eHc.put("#(沙发)", "image_emoticon77");
        eHc.put("#(手纸)", "image_emoticon78");
        eHc.put("#(香蕉)", "image_emoticon79");
        eHc.put("#(便便)", "image_emoticon80");
        eHc.put("#(药丸)", "image_emoticon81");
        eHc.put("#(红领巾)", "image_emoticon82");
        eHc.put("#(蜡烛)", "image_emoticon83");
        eHc.put("#(三道杠)", "image_emoticon84");
        eHc.put("#(赖皮)", "ali_001");
        eHc.put("#(感动)", "ali_002");
        eHc.put("#(十分惊讶)", "ali_003");
        eHc.put("#(怒气)", "ali_004");
        eHc.put("#(哭泣)", "ali_005");
        eHc.put("#(吃惊)", "ali_006");
        eHc.put("#(嘲弄)", "ali_007");
        eHc.put("#(飘过)", "ali_008");
        eHc.put("#(转圈哭)", "ali_009");
        eHc.put("#(神经病)", "ali_010");
        eHc.put("#(揪耳朵)", "ali_011");
        eHc.put("#(惊汗)", "ali_012");
        eHc.put("#(隐身)", "ali_013");
        eHc.put("#(不要嘛)", "ali_014");
        eHc.put("#(遁)", "ali_015");
        eHc.put("#(不公平)", "ali_016");
        eHc.put("#(爬来了)", "ali_017");
        eHc.put("#(蛋花哭)", "ali_018");
        eHc.put("#(温暖)", "ali_019");
        eHc.put("#(点头)", "ali_020");
        eHc.put("#(撒钱)", "ali_021");
        eHc.put("#(献花)", "ali_022");
        eHc.put("#(寒)", "ali_023");
        eHc.put("#(傻笑)", "ali_024");
        eHc.put("#(扭扭)", "ali_025");
        eHc.put("#(疯)", "ali_026");
        eHc.put("#(抓狂)", "ali_027");
        eHc.put("#(抓)", "ali_028");
        eHc.put("#(蜷)", "ali_029");
        eHc.put("#(挠墙)", "ali_030");
        eHc.put("#(狂笑)", "ali_031");
        eHc.put("#(抱枕)", "ali_032");
        eHc.put("#(吼叫)", "ali_033");
        eHc.put("#(嚷)", "ali_034");
        eHc.put("#(唠叨)", "ali_035");
        eHc.put("#(捏脸)", "ali_036");
        eHc.put("#(爆笑)", "ali_037");
        eHc.put("#(郁闷)", "ali_038");
        eHc.put("#(潜水)", "ali_039");
        eHc.put("#(十分开心)", "ali_040");
        eHc.put("#(冷笑话)", "ali_041");
        eHc.put("#(顶！)", "ali_042");
        eHc.put("#(潜)", "ali_043");
        eHc.put("#(画圈圈)", "ali_044");
        eHc.put("#(玩电脑)", "ali_045");
        eHc.put("#(狂吐)", "ali_046");
        eHc.put("#(哭着跑)", "ali_047");
        eHc.put("#(阿狸侠)", "ali_048");
        eHc.put("#(冷死了)", "ali_049");
        eHc.put("#(惆怅~)", "ali_050");
        eHc.put("#(摸头)", "ali_051");
        eHc.put("#(蹭)", "ali_052");
        eHc.put("#(打滚)", "ali_053");
        eHc.put("#(叩拜)", "ali_054");
        eHc.put("#(摸)", "ali_055");
        eHc.put("#(数钱)", "ali_056");
        eHc.put("#(拖走)", "ali_057");
        eHc.put("#(热)", "ali_058");
        eHc.put("#(加1)", "ali_059");
        eHc.put("#(压力)", "ali_060");
        eHc.put("#(表逼我)", "ali_061");
        eHc.put("#(人呢)", "ali_062");
        eHc.put("#(摇晃)", "ali_063");
        eHc.put("#(打地鼠)", "ali_064");
        eHc.put("#(这个屌)", "ali_065");
        eHc.put("#(恐慌)", "ali_066");
        eHc.put("#(晕乎乎)", "ali_067");
        eHc.put("#(浮云)", "ali_068");
        eHc.put("#(给力)", "ali_069");
        eHc.put("#(杯具了)", "ali_070");
        eHc.put("#(焦糖舞)", "yz_001");
        eHc.put("#(翻滚)", "yz_002");
        eHc.put("#(拍屁股做鬼脸)", "yz_003");
        eHc.put("#(不)", "yz_004");
        eHc.put("#(河蟹掉啦)", "yz_005");
        eHc.put("#(哦耶)", "yz_006");
        eHc.put("#(我倒)", "yz_007");
        eHc.put("#(投降)", "yz_008");
        eHc.put("#(微笑)", "b01");
        eHc.put("#(帅哥)", "b02");
        eHc.put("#(美女)", "b03");
        eHc.put("#(老大)", "b04");
        eHc.put("#(哈哈哈)", "b05");
        eHc.put("#(奸笑)", "b06");
        eHc.put("#(傻乐)", "b07");
        eHc.put("#(飞吻)", "b08");
        eHc.put("#(害羞)", "b09");
        eHc.put("#(花痴)", "b10");
        eHc.put("#(憧憬)", "b11");
        eHc.put("#(你牛)", "b12");
        eHc.put("#(鼓掌)", "b13");
        eHc.put("#(可爱)", "b14");
        eHc.put("#(太委屈)", "b15");
        eHc.put("#(大哭)", "b16");
        eHc.put("#(泪奔)", "b17");
        eHc.put("#(寻死)", "b18");
        eHc.put("#(非常惊讶)", "b19");
        eHc.put("#(表示疑问)", "b20");
        eHc.put("#(暗中观察)", "image_emoticon85");
        eHc.put("#(吃瓜)", "image_emoticon86");
        eHc.put("#(喝酒)", "image_emoticon87");
        eHc.put("#(嘿嘿嘿)", "image_emoticon88");
        eHc.put("#(噗)", "image_emoticon89");
        eHc.put("#(困成狗)", "image_emoticon90");
        eHc.put("#(微微一笑)", "image_emoticon91");
        eHc.put("#(托腮)", "image_emoticon92");
        eHc.put("#(摊手)", "image_emoticon93");
        eHc.put("#(柯基暗中观察)", "image_emoticon94");
        eHc.put("#(欢呼)", "image_emoticon95");
        eHc.put("#(炸药)", "image_emoticon96");
        eHc.put("#(突然兴奋)", "image_emoticon97");
        eHc.put("#(紧张)", "image_emoticon98");
        eHc.put("#(黑头瞪眼)", "image_emoticon99");
        eHc.put("#(黑头高兴)", "image_emoticon100");
        eHc.put("#(不跟丑人说话)", "image_emoticon101");
        eHc.put("#(么么哒)", "image_emoticon102");
        eHc.put("#(亲亲才能起来)", "image_emoticon103");
        eHc.put("#(伦家只是宝宝)", "image_emoticon104");
        eHc.put("#(你是我的人)", "image_emoticon105");
        eHc.put("#(假装看不见)", "image_emoticon106");
        eHc.put("#(单身等撩)", "image_emoticon107");
        eHc.put("#(吓到宝宝了)", "image_emoticon108");
        eHc.put("#(哈哈哈)", "image_emoticon109");
        eHc.put("#(嗯嗯)", "image_emoticon110");
        eHc.put("#(好幸福)", "image_emoticon111");
        eHc.put("#(宝宝不开心)", "image_emoticon112");
        eHc.put("#(小姐姐别走)", "image_emoticon113");
        eHc.put("#(小姐姐在吗)", "image_emoticon114");
        eHc.put("#(小姐姐来啦)", "image_emoticon115");
        eHc.put("#(小姐姐来玩呀)", "image_emoticon116");
        eHc.put("#(我养你)", "image_emoticon117");
        eHc.put("#(我是不会骗你的)", "image_emoticon118");
        eHc.put("#(扎心了)", "image_emoticon119");
        eHc.put("#(无聊)", "image_emoticon120");
        eHc.put("#(月亮代表我的心)", "image_emoticon121");
        eHc.put("#(来追我呀)", "image_emoticon122");
        eHc.put("#(爱你的形状)", "image_emoticon123");
        eHc.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return eHc.get(str);
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
                        SpannableString b = b(tbRichTextData.Se(), name, str3);
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
        int hD = TbFaceManager.Nt().hD(str);
        if (hD != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), hD);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0171a ib = TbFaceManager.Nt().ib(str);
            if (ib != null) {
                int width = (int) (0.5d * ib.getWidth());
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
