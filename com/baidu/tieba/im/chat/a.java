package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.b;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> eqS = new HashMap<>();

    static {
        eqS.put("#(呵呵)", "image_emoticon");
        eqS.put("#(哈哈)", "image_emoticon2");
        eqS.put("#(吐舌)", "image_emoticon3");
        eqS.put("#(啊)", "image_emoticon4");
        eqS.put("#(啊?)", "image_emoticon4");
        eqS.put("#(酷)", "image_emoticon5");
        eqS.put("#(怒)", "image_emoticon6");
        eqS.put("#(开心)", "image_emoticon7");
        eqS.put("#(汗)", "image_emoticon8");
        eqS.put("#(泪)", "image_emoticon9");
        eqS.put("#(黑线)", "image_emoticon10");
        eqS.put("#(鄙视)", "image_emoticon11");
        eqS.put("#(不高兴)", "image_emoticon12");
        eqS.put("#(真棒)", "image_emoticon13");
        eqS.put("#(钱)", "image_emoticon14");
        eqS.put("#(疑问)", "image_emoticon15");
        eqS.put("#(阴险)", "image_emoticon16");
        eqS.put("#(吐)", "image_emoticon17");
        eqS.put("#(咦)", "image_emoticon18");
        eqS.put("#(咦?)", "image_emoticon18");
        eqS.put("#(委屈)", "image_emoticon19");
        eqS.put("#(花心)", "image_emoticon20");
        eqS.put("#(呼~)", "image_emoticon21");
        eqS.put("#(笑眼)", "image_emoticon22");
        eqS.put("#(冷)", "image_emoticon23");
        eqS.put("#(太开心)", "image_emoticon24");
        eqS.put("#(滑稽)", "image_emoticon25");
        eqS.put("#(勉强)", "image_emoticon26");
        eqS.put("#(狂汗)", "image_emoticon27");
        eqS.put("#(乖)", "image_emoticon28");
        eqS.put("#(睡觉)", "image_emoticon29");
        eqS.put("#(惊哭)", "image_emoticon30");
        eqS.put("#(升起)", "image_emoticon31");
        eqS.put("#(惊讶)", "image_emoticon32");
        eqS.put("#(喷)", "image_emoticon33");
        eqS.put("#(爱心)", "image_emoticon34");
        eqS.put("#(心碎)", "image_emoticon35");
        eqS.put("#(玫瑰)", "image_emoticon36");
        eqS.put("#(礼物)", "image_emoticon37");
        eqS.put("#(彩虹)", "image_emoticon38");
        eqS.put("#(星星月亮)", "image_emoticon39");
        eqS.put("#(太阳)", "image_emoticon40");
        eqS.put("#(钱币)", "image_emoticon41");
        eqS.put("#(灯泡)", "image_emoticon42");
        eqS.put("#(茶杯)", "image_emoticon43");
        eqS.put("#(蛋糕)", "image_emoticon44");
        eqS.put("#(音乐)", "image_emoticon45");
        eqS.put("#(haha)", "image_emoticon46");
        eqS.put("#(胜利)", "image_emoticon47");
        eqS.put("#(大拇指)", "image_emoticon48");
        eqS.put("#(弱)", "image_emoticon49");
        eqS.put("#(OK)", "image_emoticon50");
        eqS.put("#(哼)", "image_emoticon61");
        eqS.put("#(吃瓜)", "image_emoticon62");
        eqS.put("#(扔便便)", "image_emoticon63");
        eqS.put("#(惊恐)", "image_emoticon64");
        eqS.put("#(哎呦)", "image_emoticon65");
        eqS.put("#(小乖)", "image_emoticon66");
        eqS.put("#(捂嘴笑)", "image_emoticon67");
        eqS.put("#(你懂的)", "image_emoticon68");
        eqS.put("#(what)", "image_emoticon69");
        eqS.put("#(酸爽)", "image_emoticon70");
        eqS.put("#(呀咩爹)", "image_emoticon71");
        eqS.put("#(笑尿)", "image_emoticon72");
        eqS.put("#(挖鼻)", "image_emoticon73");
        eqS.put("#(犀利)", "image_emoticon74");
        eqS.put("#(小红脸)", "image_emoticon75");
        eqS.put("#(懒得理)", "image_emoticon76");
        eqS.put("#(沙发)", "image_emoticon77");
        eqS.put("#(手纸)", "image_emoticon78");
        eqS.put("#(香蕉)", "image_emoticon79");
        eqS.put("#(便便)", "image_emoticon80");
        eqS.put("#(药丸)", "image_emoticon81");
        eqS.put("#(红领巾)", "image_emoticon82");
        eqS.put("#(蜡烛)", "image_emoticon83");
        eqS.put("#(三道杠)", "image_emoticon84");
        eqS.put("#(赖皮)", "ali_001");
        eqS.put("#(感动)", "ali_002");
        eqS.put("#(十分惊讶)", "ali_003");
        eqS.put("#(怒气)", "ali_004");
        eqS.put("#(哭泣)", "ali_005");
        eqS.put("#(吃惊)", "ali_006");
        eqS.put("#(嘲弄)", "ali_007");
        eqS.put("#(飘过)", "ali_008");
        eqS.put("#(转圈哭)", "ali_009");
        eqS.put("#(神经病)", "ali_010");
        eqS.put("#(揪耳朵)", "ali_011");
        eqS.put("#(惊汗)", "ali_012");
        eqS.put("#(隐身)", "ali_013");
        eqS.put("#(不要嘛)", "ali_014");
        eqS.put("#(遁)", "ali_015");
        eqS.put("#(不公平)", "ali_016");
        eqS.put("#(爬来了)", "ali_017");
        eqS.put("#(蛋花哭)", "ali_018");
        eqS.put("#(温暖)", "ali_019");
        eqS.put("#(点头)", "ali_020");
        eqS.put("#(撒钱)", "ali_021");
        eqS.put("#(献花)", "ali_022");
        eqS.put("#(寒)", "ali_023");
        eqS.put("#(傻笑)", "ali_024");
        eqS.put("#(扭扭)", "ali_025");
        eqS.put("#(疯)", "ali_026");
        eqS.put("#(抓狂)", "ali_027");
        eqS.put("#(抓)", "ali_028");
        eqS.put("#(蜷)", "ali_029");
        eqS.put("#(挠墙)", "ali_030");
        eqS.put("#(狂笑)", "ali_031");
        eqS.put("#(抱枕)", "ali_032");
        eqS.put("#(吼叫)", "ali_033");
        eqS.put("#(嚷)", "ali_034");
        eqS.put("#(唠叨)", "ali_035");
        eqS.put("#(捏脸)", "ali_036");
        eqS.put("#(爆笑)", "ali_037");
        eqS.put("#(郁闷)", "ali_038");
        eqS.put("#(潜水)", "ali_039");
        eqS.put("#(十分开心)", "ali_040");
        eqS.put("#(冷笑话)", "ali_041");
        eqS.put("#(顶！)", "ali_042");
        eqS.put("#(潜)", "ali_043");
        eqS.put("#(画圈圈)", "ali_044");
        eqS.put("#(玩电脑)", "ali_045");
        eqS.put("#(狂吐)", "ali_046");
        eqS.put("#(哭着跑)", "ali_047");
        eqS.put("#(阿狸侠)", "ali_048");
        eqS.put("#(冷死了)", "ali_049");
        eqS.put("#(惆怅~)", "ali_050");
        eqS.put("#(摸头)", "ali_051");
        eqS.put("#(蹭)", "ali_052");
        eqS.put("#(打滚)", "ali_053");
        eqS.put("#(叩拜)", "ali_054");
        eqS.put("#(摸)", "ali_055");
        eqS.put("#(数钱)", "ali_056");
        eqS.put("#(拖走)", "ali_057");
        eqS.put("#(热)", "ali_058");
        eqS.put("#(加1)", "ali_059");
        eqS.put("#(压力)", "ali_060");
        eqS.put("#(表逼我)", "ali_061");
        eqS.put("#(人呢)", "ali_062");
        eqS.put("#(摇晃)", "ali_063");
        eqS.put("#(打地鼠)", "ali_064");
        eqS.put("#(这个屌)", "ali_065");
        eqS.put("#(恐慌)", "ali_066");
        eqS.put("#(晕乎乎)", "ali_067");
        eqS.put("#(浮云)", "ali_068");
        eqS.put("#(给力)", "ali_069");
        eqS.put("#(杯具了)", "ali_070");
        eqS.put("#(焦糖舞)", "yz_001");
        eqS.put("#(翻滚)", "yz_002");
        eqS.put("#(拍屁股做鬼脸)", "yz_003");
        eqS.put("#(不)", "yz_004");
        eqS.put("#(河蟹掉啦)", "yz_005");
        eqS.put("#(哦耶)", "yz_006");
        eqS.put("#(我倒)", "yz_007");
        eqS.put("#(投降)", "yz_008");
        eqS.put("#(微笑)", "b01");
        eqS.put("#(帅哥)", "b02");
        eqS.put("#(美女)", "b03");
        eqS.put("#(老大)", "b04");
        eqS.put("#(哈哈哈)", "b05");
        eqS.put("#(奸笑)", "b06");
        eqS.put("#(傻乐)", "b07");
        eqS.put("#(飞吻)", "b08");
        eqS.put("#(害羞)", "b09");
        eqS.put("#(花痴)", "b10");
        eqS.put("#(憧憬)", "b11");
        eqS.put("#(你牛)", "b12");
        eqS.put("#(鼓掌)", "b13");
        eqS.put("#(可爱)", "b14");
        eqS.put("#(太委屈)", "b15");
        eqS.put("#(大哭)", "b16");
        eqS.put("#(泪奔)", "b17");
        eqS.put("#(寻死)", "b18");
        eqS.put("#(非常惊讶)", "b19");
        eqS.put("#(表示疑问)", "b20");
        eqS.put("#(暗中观察)", "image_emoticon85");
        eqS.put("#(吃瓜)", "image_emoticon86");
        eqS.put("#(喝酒)", "image_emoticon87");
        eqS.put("#(嘿嘿嘿)", "image_emoticon88");
        eqS.put("#(噗)", "image_emoticon89");
        eqS.put("#(困成狗)", "image_emoticon90");
        eqS.put("#(微微一笑)", "image_emoticon91");
        eqS.put("#(托腮)", "image_emoticon92");
        eqS.put("#(摊手)", "image_emoticon93");
        eqS.put("#(柯基暗中观察)", "image_emoticon94");
        eqS.put("#(欢呼)", "image_emoticon95");
        eqS.put("#(炸药)", "image_emoticon96");
        eqS.put("#(突然兴奋)", "image_emoticon97");
        eqS.put("#(紧张)", "image_emoticon98");
        eqS.put("#(黑头瞪眼)", "image_emoticon99");
        eqS.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return eqS.get(str);
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
                                SpannableString ag = ag(context, str5);
                                if (ag != null) {
                                    tbRichTextData.append(ag);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.QI(), name, str3);
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
                    SpannableString ag2 = ag(context, str5);
                    if (ag2 != null) {
                        tbRichTextData.append(ag2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gb = TbFaceManager.LQ().gb(str);
        if (gb != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), gb);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0085a gB = TbFaceManager.LQ().gB(str);
            if (gB != null) {
                int width = (int) (0.5d * gB.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ag(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.S(context, str);
    }
}
