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
    private static final HashMap<String, String> iPQ = new HashMap<>();

    static {
        iPQ.put("#(呵呵)", "image_emoticon");
        iPQ.put("#(哈哈)", "image_emoticon2");
        iPQ.put("#(吐舌)", "image_emoticon3");
        iPQ.put("#(啊)", "image_emoticon4");
        iPQ.put("#(啊?)", "image_emoticon4");
        iPQ.put("#(酷)", "image_emoticon5");
        iPQ.put("#(怒)", "image_emoticon6");
        iPQ.put("#(开心)", "image_emoticon7");
        iPQ.put("#(汗)", "image_emoticon8");
        iPQ.put("#(泪)", "image_emoticon9");
        iPQ.put("#(黑线)", "image_emoticon10");
        iPQ.put("#(鄙视)", "image_emoticon11");
        iPQ.put("#(不高兴)", "image_emoticon12");
        iPQ.put("#(真棒)", "image_emoticon13");
        iPQ.put("#(钱)", "image_emoticon14");
        iPQ.put("#(疑问)", "image_emoticon15");
        iPQ.put("#(阴险)", "image_emoticon16");
        iPQ.put("#(吐)", "image_emoticon17");
        iPQ.put("#(咦)", "image_emoticon18");
        iPQ.put("#(咦?)", "image_emoticon18");
        iPQ.put("#(委屈)", "image_emoticon19");
        iPQ.put("#(花心)", "image_emoticon20");
        iPQ.put("#(呼~)", "image_emoticon21");
        iPQ.put("#(笑眼)", "image_emoticon22");
        iPQ.put("#(冷)", "image_emoticon23");
        iPQ.put("#(太开心)", "image_emoticon24");
        iPQ.put("#(滑稽)", "image_emoticon25");
        iPQ.put("#(勉强)", "image_emoticon26");
        iPQ.put("#(狂汗)", "image_emoticon27");
        iPQ.put("#(乖)", "image_emoticon28");
        iPQ.put("#(睡觉)", "image_emoticon29");
        iPQ.put("#(惊哭)", "image_emoticon30");
        iPQ.put("#(升起)", "image_emoticon31");
        iPQ.put("#(惊讶)", "image_emoticon32");
        iPQ.put("#(喷)", "image_emoticon33");
        iPQ.put("#(爱心)", "image_emoticon34");
        iPQ.put("#(心碎)", "image_emoticon35");
        iPQ.put("#(玫瑰)", "image_emoticon36");
        iPQ.put("#(礼物)", "image_emoticon37");
        iPQ.put("#(彩虹)", "image_emoticon38");
        iPQ.put("#(星星月亮)", "image_emoticon39");
        iPQ.put("#(太阳)", "image_emoticon40");
        iPQ.put("#(钱币)", "image_emoticon41");
        iPQ.put("#(灯泡)", "image_emoticon42");
        iPQ.put("#(茶杯)", "image_emoticon43");
        iPQ.put("#(蛋糕)", "image_emoticon44");
        iPQ.put("#(音乐)", "image_emoticon45");
        iPQ.put("#(haha)", "image_emoticon46");
        iPQ.put("#(胜利)", "image_emoticon47");
        iPQ.put("#(大拇指)", "image_emoticon48");
        iPQ.put("#(弱)", "image_emoticon49");
        iPQ.put("#(OK)", "image_emoticon50");
        iPQ.put("#(哼)", "image_emoticon61");
        iPQ.put("#(吃瓜)", "image_emoticon62");
        iPQ.put("#(扔便便)", "image_emoticon63");
        iPQ.put("#(惊恐)", "image_emoticon64");
        iPQ.put("#(哎呦)", "image_emoticon65");
        iPQ.put("#(小乖)", "image_emoticon66");
        iPQ.put("#(捂嘴笑)", "image_emoticon67");
        iPQ.put("#(你懂的)", "image_emoticon68");
        iPQ.put("#(what)", "image_emoticon69");
        iPQ.put("#(酸爽)", "image_emoticon70");
        iPQ.put("#(呀咩爹)", "image_emoticon71");
        iPQ.put("#(笑尿)", "image_emoticon72");
        iPQ.put("#(挖鼻)", "image_emoticon73");
        iPQ.put("#(犀利)", "image_emoticon74");
        iPQ.put("#(小红脸)", "image_emoticon75");
        iPQ.put("#(懒得理)", "image_emoticon76");
        iPQ.put("#(沙发)", "image_emoticon77");
        iPQ.put("#(手纸)", "image_emoticon78");
        iPQ.put("#(香蕉)", "image_emoticon79");
        iPQ.put("#(便便)", "image_emoticon80");
        iPQ.put("#(药丸)", "image_emoticon81");
        iPQ.put("#(红领巾)", "image_emoticon82");
        iPQ.put("#(蜡烛)", "image_emoticon83");
        iPQ.put("#(三道杠)", "image_emoticon84");
        iPQ.put("#(赖皮)", "ali_001");
        iPQ.put("#(感动)", "ali_002");
        iPQ.put("#(十分惊讶)", "ali_003");
        iPQ.put("#(怒气)", "ali_004");
        iPQ.put("#(哭泣)", "ali_005");
        iPQ.put("#(吃惊)", "ali_006");
        iPQ.put("#(嘲弄)", "ali_007");
        iPQ.put("#(飘过)", "ali_008");
        iPQ.put("#(转圈哭)", "ali_009");
        iPQ.put("#(神经病)", "ali_010");
        iPQ.put("#(揪耳朵)", "ali_011");
        iPQ.put("#(惊汗)", "ali_012");
        iPQ.put("#(隐身)", "ali_013");
        iPQ.put("#(不要嘛)", "ali_014");
        iPQ.put("#(遁)", "ali_015");
        iPQ.put("#(不公平)", "ali_016");
        iPQ.put("#(爬来了)", "ali_017");
        iPQ.put("#(蛋花哭)", "ali_018");
        iPQ.put("#(温暖)", "ali_019");
        iPQ.put("#(点头)", "ali_020");
        iPQ.put("#(撒钱)", "ali_021");
        iPQ.put("#(献花)", "ali_022");
        iPQ.put("#(寒)", "ali_023");
        iPQ.put("#(傻笑)", "ali_024");
        iPQ.put("#(扭扭)", "ali_025");
        iPQ.put("#(疯)", "ali_026");
        iPQ.put("#(抓狂)", "ali_027");
        iPQ.put("#(抓)", "ali_028");
        iPQ.put("#(蜷)", "ali_029");
        iPQ.put("#(挠墙)", "ali_030");
        iPQ.put("#(狂笑)", "ali_031");
        iPQ.put("#(抱枕)", "ali_032");
        iPQ.put("#(吼叫)", "ali_033");
        iPQ.put("#(嚷)", "ali_034");
        iPQ.put("#(唠叨)", "ali_035");
        iPQ.put("#(捏脸)", "ali_036");
        iPQ.put("#(爆笑)", "ali_037");
        iPQ.put("#(郁闷)", "ali_038");
        iPQ.put("#(潜水)", "ali_039");
        iPQ.put("#(十分开心)", "ali_040");
        iPQ.put("#(冷笑话)", "ali_041");
        iPQ.put("#(顶！)", "ali_042");
        iPQ.put("#(潜)", "ali_043");
        iPQ.put("#(画圈圈)", "ali_044");
        iPQ.put("#(玩电脑)", "ali_045");
        iPQ.put("#(狂吐)", "ali_046");
        iPQ.put("#(哭着跑)", "ali_047");
        iPQ.put("#(阿狸侠)", "ali_048");
        iPQ.put("#(冷死了)", "ali_049");
        iPQ.put("#(惆怅~)", "ali_050");
        iPQ.put("#(摸头)", "ali_051");
        iPQ.put("#(蹭)", "ali_052");
        iPQ.put("#(打滚)", "ali_053");
        iPQ.put("#(叩拜)", "ali_054");
        iPQ.put("#(摸)", "ali_055");
        iPQ.put("#(数钱)", "ali_056");
        iPQ.put("#(拖走)", "ali_057");
        iPQ.put("#(热)", "ali_058");
        iPQ.put("#(加1)", "ali_059");
        iPQ.put("#(压力)", "ali_060");
        iPQ.put("#(表逼我)", "ali_061");
        iPQ.put("#(人呢)", "ali_062");
        iPQ.put("#(摇晃)", "ali_063");
        iPQ.put("#(打地鼠)", "ali_064");
        iPQ.put("#(这个屌)", "ali_065");
        iPQ.put("#(恐慌)", "ali_066");
        iPQ.put("#(晕乎乎)", "ali_067");
        iPQ.put("#(浮云)", "ali_068");
        iPQ.put("#(给力)", "ali_069");
        iPQ.put("#(杯具了)", "ali_070");
        iPQ.put("#(焦糖舞)", "yz_001");
        iPQ.put("#(翻滚)", "yz_002");
        iPQ.put("#(拍屁股做鬼脸)", "yz_003");
        iPQ.put("#(不)", "yz_004");
        iPQ.put("#(河蟹掉啦)", "yz_005");
        iPQ.put("#(哦耶)", "yz_006");
        iPQ.put("#(我倒)", "yz_007");
        iPQ.put("#(投降)", "yz_008");
        iPQ.put("#(微笑)", "b01");
        iPQ.put("#(帅哥)", "b02");
        iPQ.put("#(美女)", "b03");
        iPQ.put("#(老大)", "b04");
        iPQ.put("#(哈哈哈)", "b05");
        iPQ.put("#(奸笑)", "b06");
        iPQ.put("#(傻乐)", "b07");
        iPQ.put("#(飞吻)", "b08");
        iPQ.put("#(害羞)", "b09");
        iPQ.put("#(花痴)", "b10");
        iPQ.put("#(憧憬)", "b11");
        iPQ.put("#(你牛)", "b12");
        iPQ.put("#(鼓掌)", "b13");
        iPQ.put("#(可爱)", "b14");
        iPQ.put("#(太委屈)", "b15");
        iPQ.put("#(大哭)", "b16");
        iPQ.put("#(泪奔)", "b17");
        iPQ.put("#(寻死)", "b18");
        iPQ.put("#(非常惊讶)", "b19");
        iPQ.put("#(表示疑问)", "b20");
        iPQ.put("#(暗中观察)", "image_emoticon85");
        iPQ.put("#(吃瓜)", "image_emoticon86");
        iPQ.put("#(喝酒)", "image_emoticon87");
        iPQ.put("#(嘿嘿嘿)", "image_emoticon88");
        iPQ.put("#(噗)", "image_emoticon89");
        iPQ.put("#(困成狗)", "image_emoticon90");
        iPQ.put("#(微微一笑)", "image_emoticon91");
        iPQ.put("#(托腮)", "image_emoticon92");
        iPQ.put("#(摊手)", "image_emoticon93");
        iPQ.put("#(柯基暗中观察)", "image_emoticon94");
        iPQ.put("#(欢呼)", "image_emoticon95");
        iPQ.put("#(炸药)", "image_emoticon96");
        iPQ.put("#(突然兴奋)", "image_emoticon97");
        iPQ.put("#(紧张)", "image_emoticon98");
        iPQ.put("#(黑头瞪眼)", "image_emoticon99");
        iPQ.put("#(黑头高兴)", "image_emoticon100");
        iPQ.put("#(不跟丑人说话)", "image_emoticon101");
        iPQ.put("#(么么哒)", "image_emoticon102");
        iPQ.put("#(亲亲才能起来)", "image_emoticon103");
        iPQ.put("#(伦家只是宝宝)", "image_emoticon104");
        iPQ.put("#(你是我的人)", "image_emoticon105");
        iPQ.put("#(假装看不见)", "image_emoticon106");
        iPQ.put("#(单身等撩)", "image_emoticon107");
        iPQ.put("#(吓到宝宝了)", "image_emoticon108");
        iPQ.put("#(哈哈哈)", "image_emoticon109");
        iPQ.put("#(嗯嗯)", "image_emoticon110");
        iPQ.put("#(好幸福)", "image_emoticon111");
        iPQ.put("#(宝宝不开心)", "image_emoticon112");
        iPQ.put("#(小姐姐别走)", "image_emoticon113");
        iPQ.put("#(小姐姐在吗)", "image_emoticon114");
        iPQ.put("#(小姐姐来啦)", "image_emoticon115");
        iPQ.put("#(小姐姐来玩呀)", "image_emoticon116");
        iPQ.put("#(我养你)", "image_emoticon117");
        iPQ.put("#(我是不会骗你的)", "image_emoticon118");
        iPQ.put("#(扎心了)", "image_emoticon119");
        iPQ.put("#(无聊)", "image_emoticon120");
        iPQ.put("#(月亮代表我的心)", "image_emoticon121");
        iPQ.put("#(来追我呀)", "image_emoticon122");
        iPQ.put("#(爱你的形状)", "image_emoticon123");
        iPQ.put("#(白眼)", "image_emoticon124");
    }

    private static String He(String str) {
        return iPQ.get(str);
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
