package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> gyR = new HashMap<>();

    static {
        gyR.put("#(呵呵)", "image_emoticon");
        gyR.put("#(哈哈)", "image_emoticon2");
        gyR.put("#(吐舌)", "image_emoticon3");
        gyR.put("#(啊)", "image_emoticon4");
        gyR.put("#(啊?)", "image_emoticon4");
        gyR.put("#(酷)", "image_emoticon5");
        gyR.put("#(怒)", "image_emoticon6");
        gyR.put("#(开心)", "image_emoticon7");
        gyR.put("#(汗)", "image_emoticon8");
        gyR.put("#(泪)", "image_emoticon9");
        gyR.put("#(黑线)", "image_emoticon10");
        gyR.put("#(鄙视)", "image_emoticon11");
        gyR.put("#(不高兴)", "image_emoticon12");
        gyR.put("#(真棒)", "image_emoticon13");
        gyR.put("#(钱)", "image_emoticon14");
        gyR.put("#(疑问)", "image_emoticon15");
        gyR.put("#(阴险)", "image_emoticon16");
        gyR.put("#(吐)", "image_emoticon17");
        gyR.put("#(咦)", "image_emoticon18");
        gyR.put("#(咦?)", "image_emoticon18");
        gyR.put("#(委屈)", "image_emoticon19");
        gyR.put("#(花心)", "image_emoticon20");
        gyR.put("#(呼~)", "image_emoticon21");
        gyR.put("#(笑眼)", "image_emoticon22");
        gyR.put("#(冷)", "image_emoticon23");
        gyR.put("#(太开心)", "image_emoticon24");
        gyR.put("#(滑稽)", "image_emoticon25");
        gyR.put("#(勉强)", "image_emoticon26");
        gyR.put("#(狂汗)", "image_emoticon27");
        gyR.put("#(乖)", "image_emoticon28");
        gyR.put("#(睡觉)", "image_emoticon29");
        gyR.put("#(惊哭)", "image_emoticon30");
        gyR.put("#(升起)", "image_emoticon31");
        gyR.put("#(惊讶)", "image_emoticon32");
        gyR.put("#(喷)", "image_emoticon33");
        gyR.put("#(爱心)", "image_emoticon34");
        gyR.put("#(心碎)", "image_emoticon35");
        gyR.put("#(玫瑰)", "image_emoticon36");
        gyR.put("#(礼物)", "image_emoticon37");
        gyR.put("#(彩虹)", "image_emoticon38");
        gyR.put("#(星星月亮)", "image_emoticon39");
        gyR.put("#(太阳)", "image_emoticon40");
        gyR.put("#(钱币)", "image_emoticon41");
        gyR.put("#(灯泡)", "image_emoticon42");
        gyR.put("#(茶杯)", "image_emoticon43");
        gyR.put("#(蛋糕)", "image_emoticon44");
        gyR.put("#(音乐)", "image_emoticon45");
        gyR.put("#(haha)", "image_emoticon46");
        gyR.put("#(胜利)", "image_emoticon47");
        gyR.put("#(大拇指)", "image_emoticon48");
        gyR.put("#(弱)", "image_emoticon49");
        gyR.put("#(OK)", "image_emoticon50");
        gyR.put("#(哼)", "image_emoticon61");
        gyR.put("#(吃瓜)", "image_emoticon62");
        gyR.put("#(扔便便)", "image_emoticon63");
        gyR.put("#(惊恐)", "image_emoticon64");
        gyR.put("#(哎呦)", "image_emoticon65");
        gyR.put("#(小乖)", "image_emoticon66");
        gyR.put("#(捂嘴笑)", "image_emoticon67");
        gyR.put("#(你懂的)", "image_emoticon68");
        gyR.put("#(what)", "image_emoticon69");
        gyR.put("#(酸爽)", "image_emoticon70");
        gyR.put("#(呀咩爹)", "image_emoticon71");
        gyR.put("#(笑尿)", "image_emoticon72");
        gyR.put("#(挖鼻)", "image_emoticon73");
        gyR.put("#(犀利)", "image_emoticon74");
        gyR.put("#(小红脸)", "image_emoticon75");
        gyR.put("#(懒得理)", "image_emoticon76");
        gyR.put("#(沙发)", "image_emoticon77");
        gyR.put("#(手纸)", "image_emoticon78");
        gyR.put("#(香蕉)", "image_emoticon79");
        gyR.put("#(便便)", "image_emoticon80");
        gyR.put("#(药丸)", "image_emoticon81");
        gyR.put("#(红领巾)", "image_emoticon82");
        gyR.put("#(蜡烛)", "image_emoticon83");
        gyR.put("#(三道杠)", "image_emoticon84");
        gyR.put("#(赖皮)", "ali_001");
        gyR.put("#(感动)", "ali_002");
        gyR.put("#(十分惊讶)", "ali_003");
        gyR.put("#(怒气)", "ali_004");
        gyR.put("#(哭泣)", "ali_005");
        gyR.put("#(吃惊)", "ali_006");
        gyR.put("#(嘲弄)", "ali_007");
        gyR.put("#(飘过)", "ali_008");
        gyR.put("#(转圈哭)", "ali_009");
        gyR.put("#(神经病)", "ali_010");
        gyR.put("#(揪耳朵)", "ali_011");
        gyR.put("#(惊汗)", "ali_012");
        gyR.put("#(隐身)", "ali_013");
        gyR.put("#(不要嘛)", "ali_014");
        gyR.put("#(遁)", "ali_015");
        gyR.put("#(不公平)", "ali_016");
        gyR.put("#(爬来了)", "ali_017");
        gyR.put("#(蛋花哭)", "ali_018");
        gyR.put("#(温暖)", "ali_019");
        gyR.put("#(点头)", "ali_020");
        gyR.put("#(撒钱)", "ali_021");
        gyR.put("#(献花)", "ali_022");
        gyR.put("#(寒)", "ali_023");
        gyR.put("#(傻笑)", "ali_024");
        gyR.put("#(扭扭)", "ali_025");
        gyR.put("#(疯)", "ali_026");
        gyR.put("#(抓狂)", "ali_027");
        gyR.put("#(抓)", "ali_028");
        gyR.put("#(蜷)", "ali_029");
        gyR.put("#(挠墙)", "ali_030");
        gyR.put("#(狂笑)", "ali_031");
        gyR.put("#(抱枕)", "ali_032");
        gyR.put("#(吼叫)", "ali_033");
        gyR.put("#(嚷)", "ali_034");
        gyR.put("#(唠叨)", "ali_035");
        gyR.put("#(捏脸)", "ali_036");
        gyR.put("#(爆笑)", "ali_037");
        gyR.put("#(郁闷)", "ali_038");
        gyR.put("#(潜水)", "ali_039");
        gyR.put("#(十分开心)", "ali_040");
        gyR.put("#(冷笑话)", "ali_041");
        gyR.put("#(顶！)", "ali_042");
        gyR.put("#(潜)", "ali_043");
        gyR.put("#(画圈圈)", "ali_044");
        gyR.put("#(玩电脑)", "ali_045");
        gyR.put("#(狂吐)", "ali_046");
        gyR.put("#(哭着跑)", "ali_047");
        gyR.put("#(阿狸侠)", "ali_048");
        gyR.put("#(冷死了)", "ali_049");
        gyR.put("#(惆怅~)", "ali_050");
        gyR.put("#(摸头)", "ali_051");
        gyR.put("#(蹭)", "ali_052");
        gyR.put("#(打滚)", "ali_053");
        gyR.put("#(叩拜)", "ali_054");
        gyR.put("#(摸)", "ali_055");
        gyR.put("#(数钱)", "ali_056");
        gyR.put("#(拖走)", "ali_057");
        gyR.put("#(热)", "ali_058");
        gyR.put("#(加1)", "ali_059");
        gyR.put("#(压力)", "ali_060");
        gyR.put("#(表逼我)", "ali_061");
        gyR.put("#(人呢)", "ali_062");
        gyR.put("#(摇晃)", "ali_063");
        gyR.put("#(打地鼠)", "ali_064");
        gyR.put("#(这个屌)", "ali_065");
        gyR.put("#(恐慌)", "ali_066");
        gyR.put("#(晕乎乎)", "ali_067");
        gyR.put("#(浮云)", "ali_068");
        gyR.put("#(给力)", "ali_069");
        gyR.put("#(杯具了)", "ali_070");
        gyR.put("#(焦糖舞)", "yz_001");
        gyR.put("#(翻滚)", "yz_002");
        gyR.put("#(拍屁股做鬼脸)", "yz_003");
        gyR.put("#(不)", "yz_004");
        gyR.put("#(河蟹掉啦)", "yz_005");
        gyR.put("#(哦耶)", "yz_006");
        gyR.put("#(我倒)", "yz_007");
        gyR.put("#(投降)", "yz_008");
        gyR.put("#(微笑)", "b01");
        gyR.put("#(帅哥)", "b02");
        gyR.put("#(美女)", "b03");
        gyR.put("#(老大)", "b04");
        gyR.put("#(哈哈哈)", "b05");
        gyR.put("#(奸笑)", "b06");
        gyR.put("#(傻乐)", "b07");
        gyR.put("#(飞吻)", "b08");
        gyR.put("#(害羞)", "b09");
        gyR.put("#(花痴)", "b10");
        gyR.put("#(憧憬)", "b11");
        gyR.put("#(你牛)", "b12");
        gyR.put("#(鼓掌)", "b13");
        gyR.put("#(可爱)", "b14");
        gyR.put("#(太委屈)", "b15");
        gyR.put("#(大哭)", "b16");
        gyR.put("#(泪奔)", "b17");
        gyR.put("#(寻死)", "b18");
        gyR.put("#(非常惊讶)", "b19");
        gyR.put("#(表示疑问)", "b20");
        gyR.put("#(暗中观察)", "image_emoticon85");
        gyR.put("#(吃瓜)", "image_emoticon86");
        gyR.put("#(喝酒)", "image_emoticon87");
        gyR.put("#(嘿嘿嘿)", "image_emoticon88");
        gyR.put("#(噗)", "image_emoticon89");
        gyR.put("#(困成狗)", "image_emoticon90");
        gyR.put("#(微微一笑)", "image_emoticon91");
        gyR.put("#(托腮)", "image_emoticon92");
        gyR.put("#(摊手)", "image_emoticon93");
        gyR.put("#(柯基暗中观察)", "image_emoticon94");
        gyR.put("#(欢呼)", "image_emoticon95");
        gyR.put("#(炸药)", "image_emoticon96");
        gyR.put("#(突然兴奋)", "image_emoticon97");
        gyR.put("#(紧张)", "image_emoticon98");
        gyR.put("#(黑头瞪眼)", "image_emoticon99");
        gyR.put("#(黑头高兴)", "image_emoticon100");
        gyR.put("#(不跟丑人说话)", "image_emoticon101");
        gyR.put("#(么么哒)", "image_emoticon102");
        gyR.put("#(亲亲才能起来)", "image_emoticon103");
        gyR.put("#(伦家只是宝宝)", "image_emoticon104");
        gyR.put("#(你是我的人)", "image_emoticon105");
        gyR.put("#(假装看不见)", "image_emoticon106");
        gyR.put("#(单身等撩)", "image_emoticon107");
        gyR.put("#(吓到宝宝了)", "image_emoticon108");
        gyR.put("#(哈哈哈)", "image_emoticon109");
        gyR.put("#(嗯嗯)", "image_emoticon110");
        gyR.put("#(好幸福)", "image_emoticon111");
        gyR.put("#(宝宝不开心)", "image_emoticon112");
        gyR.put("#(小姐姐别走)", "image_emoticon113");
        gyR.put("#(小姐姐在吗)", "image_emoticon114");
        gyR.put("#(小姐姐来啦)", "image_emoticon115");
        gyR.put("#(小姐姐来玩呀)", "image_emoticon116");
        gyR.put("#(我养你)", "image_emoticon117");
        gyR.put("#(我是不会骗你的)", "image_emoticon118");
        gyR.put("#(扎心了)", "image_emoticon119");
        gyR.put("#(无聊)", "image_emoticon120");
        gyR.put("#(月亮代表我的心)", "image_emoticon121");
        gyR.put("#(来追我呀)", "image_emoticon122");
        gyR.put("#(爱你的形状)", "image_emoticon123");
        gyR.put("#(白眼)", "image_emoticon124");
    }

    private static String yu(String str) {
        return gyR.get(str);
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
                    String yu = yu(str3);
                    if (TextUtils.isEmpty(yu)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.k(str5);
                            } else {
                                SpannableString az = az(context, str5);
                                if (az != null) {
                                    tbRichTextData.k(az);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.ayT(), yu, str3);
                        if (a != null) {
                            tbRichTextData.k(a);
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
                    tbRichTextData.k(str5);
                } else {
                    SpannableString az2 = az(context, str5);
                    if (az2 != null) {
                        tbRichTextData.k(az2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int qf = TbFaceManager.atx().qf(str);
        if (qf != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), qf);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0255a qC = TbFaceManager.atx().qC(str);
            if (qC != null) {
                int width = (int) (0.5d * qC.getWidth());
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
        return bb.ai(context, str);
    }
}
