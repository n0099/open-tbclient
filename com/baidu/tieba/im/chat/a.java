package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> iPO = new HashMap<>();

    static {
        iPO.put("#(呵呵)", "image_emoticon");
        iPO.put("#(哈哈)", "image_emoticon2");
        iPO.put("#(吐舌)", "image_emoticon3");
        iPO.put("#(啊)", "image_emoticon4");
        iPO.put("#(啊?)", "image_emoticon4");
        iPO.put("#(酷)", "image_emoticon5");
        iPO.put("#(怒)", "image_emoticon6");
        iPO.put("#(开心)", "image_emoticon7");
        iPO.put("#(汗)", "image_emoticon8");
        iPO.put("#(泪)", "image_emoticon9");
        iPO.put("#(黑线)", "image_emoticon10");
        iPO.put("#(鄙视)", "image_emoticon11");
        iPO.put("#(不高兴)", "image_emoticon12");
        iPO.put("#(真棒)", "image_emoticon13");
        iPO.put("#(钱)", "image_emoticon14");
        iPO.put("#(疑问)", "image_emoticon15");
        iPO.put("#(阴险)", "image_emoticon16");
        iPO.put("#(吐)", "image_emoticon17");
        iPO.put("#(咦)", "image_emoticon18");
        iPO.put("#(咦?)", "image_emoticon18");
        iPO.put("#(委屈)", "image_emoticon19");
        iPO.put("#(花心)", "image_emoticon20");
        iPO.put("#(呼~)", "image_emoticon21");
        iPO.put("#(笑眼)", "image_emoticon22");
        iPO.put("#(冷)", "image_emoticon23");
        iPO.put("#(太开心)", "image_emoticon24");
        iPO.put("#(滑稽)", "image_emoticon25");
        iPO.put("#(勉强)", "image_emoticon26");
        iPO.put("#(狂汗)", "image_emoticon27");
        iPO.put("#(乖)", "image_emoticon28");
        iPO.put("#(睡觉)", "image_emoticon29");
        iPO.put("#(惊哭)", "image_emoticon30");
        iPO.put("#(升起)", "image_emoticon31");
        iPO.put("#(惊讶)", "image_emoticon32");
        iPO.put("#(喷)", "image_emoticon33");
        iPO.put("#(爱心)", "image_emoticon34");
        iPO.put("#(心碎)", "image_emoticon35");
        iPO.put("#(玫瑰)", "image_emoticon36");
        iPO.put("#(礼物)", "image_emoticon37");
        iPO.put("#(彩虹)", "image_emoticon38");
        iPO.put("#(星星月亮)", "image_emoticon39");
        iPO.put("#(太阳)", "image_emoticon40");
        iPO.put("#(钱币)", "image_emoticon41");
        iPO.put("#(灯泡)", "image_emoticon42");
        iPO.put("#(茶杯)", "image_emoticon43");
        iPO.put("#(蛋糕)", "image_emoticon44");
        iPO.put("#(音乐)", "image_emoticon45");
        iPO.put("#(haha)", "image_emoticon46");
        iPO.put("#(胜利)", "image_emoticon47");
        iPO.put("#(大拇指)", "image_emoticon48");
        iPO.put("#(弱)", "image_emoticon49");
        iPO.put("#(OK)", "image_emoticon50");
        iPO.put("#(哼)", "image_emoticon61");
        iPO.put("#(吃瓜)", "image_emoticon62");
        iPO.put("#(扔便便)", "image_emoticon63");
        iPO.put("#(惊恐)", "image_emoticon64");
        iPO.put("#(哎呦)", "image_emoticon65");
        iPO.put("#(小乖)", "image_emoticon66");
        iPO.put("#(捂嘴笑)", "image_emoticon67");
        iPO.put("#(你懂的)", "image_emoticon68");
        iPO.put("#(what)", "image_emoticon69");
        iPO.put("#(酸爽)", "image_emoticon70");
        iPO.put("#(呀咩爹)", "image_emoticon71");
        iPO.put("#(笑尿)", "image_emoticon72");
        iPO.put("#(挖鼻)", "image_emoticon73");
        iPO.put("#(犀利)", "image_emoticon74");
        iPO.put("#(小红脸)", "image_emoticon75");
        iPO.put("#(懒得理)", "image_emoticon76");
        iPO.put("#(沙发)", "image_emoticon77");
        iPO.put("#(手纸)", "image_emoticon78");
        iPO.put("#(香蕉)", "image_emoticon79");
        iPO.put("#(便便)", "image_emoticon80");
        iPO.put("#(药丸)", "image_emoticon81");
        iPO.put("#(红领巾)", "image_emoticon82");
        iPO.put("#(蜡烛)", "image_emoticon83");
        iPO.put("#(三道杠)", "image_emoticon84");
        iPO.put("#(赖皮)", "ali_001");
        iPO.put("#(感动)", "ali_002");
        iPO.put("#(十分惊讶)", "ali_003");
        iPO.put("#(怒气)", "ali_004");
        iPO.put("#(哭泣)", "ali_005");
        iPO.put("#(吃惊)", "ali_006");
        iPO.put("#(嘲弄)", "ali_007");
        iPO.put("#(飘过)", "ali_008");
        iPO.put("#(转圈哭)", "ali_009");
        iPO.put("#(神经病)", "ali_010");
        iPO.put("#(揪耳朵)", "ali_011");
        iPO.put("#(惊汗)", "ali_012");
        iPO.put("#(隐身)", "ali_013");
        iPO.put("#(不要嘛)", "ali_014");
        iPO.put("#(遁)", "ali_015");
        iPO.put("#(不公平)", "ali_016");
        iPO.put("#(爬来了)", "ali_017");
        iPO.put("#(蛋花哭)", "ali_018");
        iPO.put("#(温暖)", "ali_019");
        iPO.put("#(点头)", "ali_020");
        iPO.put("#(撒钱)", "ali_021");
        iPO.put("#(献花)", "ali_022");
        iPO.put("#(寒)", "ali_023");
        iPO.put("#(傻笑)", "ali_024");
        iPO.put("#(扭扭)", "ali_025");
        iPO.put("#(疯)", "ali_026");
        iPO.put("#(抓狂)", "ali_027");
        iPO.put("#(抓)", "ali_028");
        iPO.put("#(蜷)", "ali_029");
        iPO.put("#(挠墙)", "ali_030");
        iPO.put("#(狂笑)", "ali_031");
        iPO.put("#(抱枕)", "ali_032");
        iPO.put("#(吼叫)", "ali_033");
        iPO.put("#(嚷)", "ali_034");
        iPO.put("#(唠叨)", "ali_035");
        iPO.put("#(捏脸)", "ali_036");
        iPO.put("#(爆笑)", "ali_037");
        iPO.put("#(郁闷)", "ali_038");
        iPO.put("#(潜水)", "ali_039");
        iPO.put("#(十分开心)", "ali_040");
        iPO.put("#(冷笑话)", "ali_041");
        iPO.put("#(顶！)", "ali_042");
        iPO.put("#(潜)", "ali_043");
        iPO.put("#(画圈圈)", "ali_044");
        iPO.put("#(玩电脑)", "ali_045");
        iPO.put("#(狂吐)", "ali_046");
        iPO.put("#(哭着跑)", "ali_047");
        iPO.put("#(阿狸侠)", "ali_048");
        iPO.put("#(冷死了)", "ali_049");
        iPO.put("#(惆怅~)", "ali_050");
        iPO.put("#(摸头)", "ali_051");
        iPO.put("#(蹭)", "ali_052");
        iPO.put("#(打滚)", "ali_053");
        iPO.put("#(叩拜)", "ali_054");
        iPO.put("#(摸)", "ali_055");
        iPO.put("#(数钱)", "ali_056");
        iPO.put("#(拖走)", "ali_057");
        iPO.put("#(热)", "ali_058");
        iPO.put("#(加1)", "ali_059");
        iPO.put("#(压力)", "ali_060");
        iPO.put("#(表逼我)", "ali_061");
        iPO.put("#(人呢)", "ali_062");
        iPO.put("#(摇晃)", "ali_063");
        iPO.put("#(打地鼠)", "ali_064");
        iPO.put("#(这个屌)", "ali_065");
        iPO.put("#(恐慌)", "ali_066");
        iPO.put("#(晕乎乎)", "ali_067");
        iPO.put("#(浮云)", "ali_068");
        iPO.put("#(给力)", "ali_069");
        iPO.put("#(杯具了)", "ali_070");
        iPO.put("#(焦糖舞)", "yz_001");
        iPO.put("#(翻滚)", "yz_002");
        iPO.put("#(拍屁股做鬼脸)", "yz_003");
        iPO.put("#(不)", "yz_004");
        iPO.put("#(河蟹掉啦)", "yz_005");
        iPO.put("#(哦耶)", "yz_006");
        iPO.put("#(我倒)", "yz_007");
        iPO.put("#(投降)", "yz_008");
        iPO.put("#(微笑)", "b01");
        iPO.put("#(帅哥)", "b02");
        iPO.put("#(美女)", "b03");
        iPO.put("#(老大)", "b04");
        iPO.put("#(哈哈哈)", "b05");
        iPO.put("#(奸笑)", "b06");
        iPO.put("#(傻乐)", "b07");
        iPO.put("#(飞吻)", "b08");
        iPO.put("#(害羞)", "b09");
        iPO.put("#(花痴)", "b10");
        iPO.put("#(憧憬)", "b11");
        iPO.put("#(你牛)", "b12");
        iPO.put("#(鼓掌)", "b13");
        iPO.put("#(可爱)", "b14");
        iPO.put("#(太委屈)", "b15");
        iPO.put("#(大哭)", "b16");
        iPO.put("#(泪奔)", "b17");
        iPO.put("#(寻死)", "b18");
        iPO.put("#(非常惊讶)", "b19");
        iPO.put("#(表示疑问)", "b20");
        iPO.put("#(暗中观察)", "image_emoticon85");
        iPO.put("#(吃瓜)", "image_emoticon86");
        iPO.put("#(喝酒)", "image_emoticon87");
        iPO.put("#(嘿嘿嘿)", "image_emoticon88");
        iPO.put("#(噗)", "image_emoticon89");
        iPO.put("#(困成狗)", "image_emoticon90");
        iPO.put("#(微微一笑)", "image_emoticon91");
        iPO.put("#(托腮)", "image_emoticon92");
        iPO.put("#(摊手)", "image_emoticon93");
        iPO.put("#(柯基暗中观察)", "image_emoticon94");
        iPO.put("#(欢呼)", "image_emoticon95");
        iPO.put("#(炸药)", "image_emoticon96");
        iPO.put("#(突然兴奋)", "image_emoticon97");
        iPO.put("#(紧张)", "image_emoticon98");
        iPO.put("#(黑头瞪眼)", "image_emoticon99");
        iPO.put("#(黑头高兴)", "image_emoticon100");
        iPO.put("#(不跟丑人说话)", "image_emoticon101");
        iPO.put("#(么么哒)", "image_emoticon102");
        iPO.put("#(亲亲才能起来)", "image_emoticon103");
        iPO.put("#(伦家只是宝宝)", "image_emoticon104");
        iPO.put("#(你是我的人)", "image_emoticon105");
        iPO.put("#(假装看不见)", "image_emoticon106");
        iPO.put("#(单身等撩)", "image_emoticon107");
        iPO.put("#(吓到宝宝了)", "image_emoticon108");
        iPO.put("#(哈哈哈)", "image_emoticon109");
        iPO.put("#(嗯嗯)", "image_emoticon110");
        iPO.put("#(好幸福)", "image_emoticon111");
        iPO.put("#(宝宝不开心)", "image_emoticon112");
        iPO.put("#(小姐姐别走)", "image_emoticon113");
        iPO.put("#(小姐姐在吗)", "image_emoticon114");
        iPO.put("#(小姐姐来啦)", "image_emoticon115");
        iPO.put("#(小姐姐来玩呀)", "image_emoticon116");
        iPO.put("#(我养你)", "image_emoticon117");
        iPO.put("#(我是不会骗你的)", "image_emoticon118");
        iPO.put("#(扎心了)", "image_emoticon119");
        iPO.put("#(无聊)", "image_emoticon120");
        iPO.put("#(月亮代表我的心)", "image_emoticon121");
        iPO.put("#(来追我呀)", "image_emoticon122");
        iPO.put("#(爱你的形状)", "image_emoticon123");
        iPO.put("#(白眼)", "image_emoticon124");
    }

    private static String He(String str) {
        return iPO.get(str);
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
                    String He = He(str3);
                    if (TextUtils.isEmpty(He)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.n(str5);
                            } else {
                                SpannableString aE = aE(context, str5);
                                if (aE != null) {
                                    tbRichTextData.n(aE);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.boO(), He, str3);
                        if (a != null) {
                            tbRichTextData.n(a);
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
                    tbRichTextData.n(str5);
                } else {
                    SpannableString aE2 = aE(context, str5);
                    if (aE2 != null) {
                        tbRichTextData.n(aE2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int zx = TbFaceManager.bkj().zx(str);
        if (zx != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), zx);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0508a zS = TbFaceManager.bkj().zS(str);
            if (zS != null) {
                int width = (int) (0.5d * zS.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aE(Context context, String str) {
        if (str == null) {
            return null;
        }
        return bd.aj(context, str);
    }
}
