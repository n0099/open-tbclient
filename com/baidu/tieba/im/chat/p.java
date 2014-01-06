package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    private static final HashMap<String, String> a = new HashMap<>();

    static {
        a.put("#(蹦蹦跳跳)", "10th_001");
        a.put("#(晃悠)", "10th_002");
        a.put("#(摇摇摆摆)", "10th_003");
        a.put("#(大撒花)", "10th_004");
        a.put("#(高高兴兴)", "10th_005");
        a.put("#(弹吉他)", "10th_006");
        a.put("#(魔法棒)", "10th_007");
        a.put("#(扛大旗)", "10th_008");
        a.put("#(点蜡烛)", "10th_009");
        a.put("#(大秧歌)", "10th_010");
        a.put("#(贴吧十周年)", "10th_011");
        a.put("#(十周年)", "10th_012");
        a.put("#(呵呵)", "image_emoticon");
        a.put("#(哈哈)", "image_emoticon2");
        a.put("#(吐舌)", "image_emoticon3");
        a.put("#(啊)", "image_emoticon4");
        a.put("#(啊?)", "image_emoticon4");
        a.put("#(酷)", "image_emoticon5");
        a.put("#(怒)", "image_emoticon6");
        a.put("#(开心)", "image_emoticon7");
        a.put("#(汗)", "image_emoticon8");
        a.put("#(泪)", "image_emoticon9");
        a.put("#(黑线)", "image_emoticon10");
        a.put("#(鄙视)", "image_emoticon11");
        a.put("#(不高兴)", "image_emoticon12");
        a.put("#(真棒)", "image_emoticon13");
        a.put("#(钱)", "image_emoticon14");
        a.put("#(疑问)", "image_emoticon15");
        a.put("#(阴险)", "image_emoticon16");
        a.put("#(吐)", "image_emoticon17");
        a.put("#(咦)", "image_emoticon18");
        a.put("#(咦?)", "image_emoticon18");
        a.put("#(委屈)", "image_emoticon19");
        a.put("#(花心)", "image_emoticon20");
        a.put("#(呼~)", "image_emoticon21");
        a.put("#(笑眼)", "image_emoticon22");
        a.put("#(冷)", "image_emoticon23");
        a.put("#(太开心)", "image_emoticon24");
        a.put("#(滑稽)", "image_emoticon25");
        a.put("#(勉强)", "image_emoticon26");
        a.put("#(狂汗)", "image_emoticon27");
        a.put("#(乖)", "image_emoticon28");
        a.put("#(睡觉)", "image_emoticon29");
        a.put("#(惊哭)", "image_emoticon30");
        a.put("#(升起)", "image_emoticon31");
        a.put("#(惊讶)", "image_emoticon32");
        a.put("#(喷)", "image_emoticon33");
        a.put("#(爱心)", "image_emoticon34");
        a.put("#(心碎)", "image_emoticon35");
        a.put("#(玫瑰)", "image_emoticon36");
        a.put("#(礼物)", "image_emoticon37");
        a.put("#(彩虹)", "image_emoticon38");
        a.put("#(星星月亮)", "image_emoticon39");
        a.put("#(太阳)", "image_emoticon40");
        a.put("#(钱币)", "image_emoticon41");
        a.put("#(灯泡)", "image_emoticon42");
        a.put("#(茶杯)", "image_emoticon43");
        a.put("#(蛋糕)", "image_emoticon44");
        a.put("#(音乐)", "image_emoticon45");
        a.put("#(haha)", "image_emoticon46");
        a.put("#(胜利)", "image_emoticon47");
        a.put("#(大拇指)", "image_emoticon48");
        a.put("#(弱)", "image_emoticon49");
        a.put("#(OK)", "image_emoticon50");
        a.put("#(哭着跑)", "ali_047");
        a.put("#(惆怅~)", "ali_050");
        a.put("#(摸头)", "ali_051");
        a.put("#(蹭)", "ali_052");
        a.put("#(打滚)", "ali_053");
        a.put("#(叩拜)", "ali_054");
        a.put("#(摸)", "ali_055");
        a.put("#(数钱)", "ali_056");
        a.put("#(加1)", "ali_059");
        a.put("#(压力)", "ali_060");
        a.put("#(表逼我)", "ali_061");
        a.put("#(摇晃)", "ali_063");
        a.put("#(打地鼠)", "ali_064");
        a.put("#(这个屌)", "ali_065");
        a.put("#(恐慌)", "ali_066");
        a.put("#(晕乎乎)", "ali_067");
        a.put("#(浮云)", "ali_068");
        a.put("#(给力)", "ali_069");
        a.put("#(杯具了)", "ali_070");
        a.put("#(焦糖舞)", "yz_001");
        a.put("#(翻滚)", "yz_002");
        a.put("#(拍屁股做鬼脸)", "yz_003");
        a.put("#(不)", "yz_004");
        a.put("#(河蟹掉啦)", "yz_005");
        a.put("#(哦耶)", "yz_006");
        a.put("#(我倒)", "yz_007");
        a.put("#(投降)", "yz_008");
        a.put("#(听音乐)", "yz_009");
        a.put("#(被砸)", "yz_010");
        a.put("#(吐舌头)", "yz_011");
        a.put("#(太好啦)", "yz_012");
        a.put("#(财源滚滚)", "yz_013");
        a.put("#(人去哪了)", "yz_014");
        a.put("#(偷笑)", "yz_016");
        a.put("#(卷被)", "yz_017");
        a.put("#(看楼上)", "yz_018");
        a.put("#(我抽)", "yz_019");
        a.put("#(有木有)", "yz_020");
        a.put("#(哭)", "yz_021");
        a.put("#(微笑)", "b01");
        a.put("#(帅哥)", "b02");
        a.put("#(美女)", "b03");
        a.put("#(老大)", "b04");
        a.put("#(哈哈哈)", "b05");
        a.put("#(奸笑)", "b06");
        a.put("#(傻乐)", "b07");
        a.put("#(飞吻)", "b08");
        a.put("#(害羞)", "b09");
        a.put("#(花痴)", "b10");
        a.put("#(憧憬)", "b11");
        a.put("#(你牛)", "b12");
        a.put("#(鼓掌)", "b13");
        a.put("#(可爱)", "b14");
        a.put("#(太委屈)", "b15");
        a.put("#(大哭)", "b16");
        a.put("#(泪奔)", "b17");
        a.put("#(寻死)", "b18");
        a.put("#(非常惊讶)", "b19");
        a.put("#(表示疑问)", "b20");
        a.put("#(打人)", "B_0028");
        a.put("#(摇摆)", "B_0053");
        a.put("#(理想)", "B_0059");
        a.put("#(鬼脸~)", "B_0010");
        a.put("#(十分惊讶)", "ali_003");
        a.put("#(思考者)", "yz_043");
        a.put("#(流泪)", "B_0016");
        a.put("#(吃惊)", "ali_006");
        a.put("#(狂笑)", "ali_031");
        a.put("#(苹果)", "B_0041");
        a.put("#(嚷)", "ali_034");
        a.put("#(转圈哭)", "ali_009");
        a.put("#(套娃娃)", "B_0047");
        a.put("#(人呢)", "ali_062");
        a.put("#(爆笑)", "ali_037");
        a.put("#(不要)", "B_0004");
        a.put("#(没有钱)", "yz_031");
        a.put("#(隆重介绍)", "yz_037");
        a.put("#(大变身)", "B_0035");
        a.put("#(殴打)", "B_0060");
        a.put("#(拍手)", "yz_025");
        a.put("#(点头)", "ali_020");
        a.put("#(汗~)", "B_0023");
        a.put("#(寒)", "ali_023");
        a.put("#(疯)", "ali_026");
        a.put("#(蹦跳)", "B_0029");
        a.put("#(蜷)", "ali_029");
        a.put("#(杂耍)", "B_0054");
        a.put("#(拖走)", "ali_057");
        a.put("#(害羞~)", "B_0011");
        a.put("#(抽风)", "yz_044");
        a.put("#(生气)", "B_0017");
        a.put("#(亲)", "B_0042");
        a.put("#(捅捅)", "B_0048");
        a.put("#(变脸)", "B_0030");
        a.put("#(惊汗)", "ali_012");
        a.put("#(扯花)", "B_0005");
        a.put("#(拿玩偶)", "yz_032");
        a.put("#(十分开心)", "ali_040");
        a.put("#(遁)", "ali_015");
        a.put("#(飞天舞)", "B_0036");
        a.put("#(蛋花哭)", "ali_018");
        a.put("#(潜)", "ali_043");
        a.put("#(呕吐~)", "B_0061");
        a.put("#(狂吐)", "ali_046");
        a.put("#(求你了)", "yz_038");
        a.put("#(冷死了)", "ali_049");
        a.put("#(紧张)", "yz_026");
        a.put("#(鄙视！)", "B_0024");
        a.put("#(招财)", "B_0055");
        a.put("#(赖皮)", "ali_001");
        a.put("#(口水)", "B_0012");
        a.put("#(怒气)", "ali_004");
        a.put("#(吃苹果)", "yz_045");
        a.put("#(抱枕)", "ali_032");
        a.put("#(嘲弄)", "ali_007");
        a.put("#(吐舌~)", "B_0018");
        a.put("#(耍赖)", "B_0043");
        a.put("#(唠叨)", "ali_035");
        a.put("#(舞倒)", "B_0049");
        a.put("#(郁闷)", "ali_038");
        a.put("#(扯肉)", "B_0031");
        a.put("#(大心)", "B_0006");
        a.put("#(来看看)", "yz_033");
        a.put("#(撞玻璃)", "yz_039");
        a.put("#(回眸)", "B_0037");
        a.put("#(碎)", "B_0062");
        a.put("#(撒钱)", "ali_021");
        a.put("#(洗澡)", "yz_027");
        a.put("#(拜~)", "B_0025");
        a.put("#(西红柿)", "B_0050");
        a.put("#(傻笑)", "ali_024");
        a.put("#(抓狂)", "ali_027");
        a.put("#(被殴)", "B_0056");
        a.put("#(热)", "ali_058");
        a.put("#(挥手帕)", "yz_015");
        a.put("#(狂哭)", "B_0013");
        a.put("#(眺望)", "yz_040");
        a.put("#(光棍)", "yz_046");
        a.put("#(喜欢)", "B_0019");
        a.put("#(骚舞)", "B_0044");
        a.put("#(HI)", "B_0001");
        a.put("#(神经病)", "ali_010");
        a.put("#(哇哇叫)", "yz_034");
        a.put("#(顶)", "B_0007");
        a.put("#(吃To)", "B_0032");
        a.put("#(隐身)", "ali_013");
        a.put("#(不公平)", "ali_016");
        a.put("#(冷笑话)", "ali_041");
        a.put("#(可怜)", "B_0038");
        a.put("#(画圈圈)", "ali_044");
        a.put("#(温暖)", "ali_019");
        a.put("#(吐痰)", "B_0063");
        a.put("#(欢呼)", "yz_022");
        a.put("#(旋转~)", "B_0020");
        a.put("#(耶)", "yz_028");
        a.put("#(吐血)", "B_0026");
        a.put("#(爱慕)", "B_0051");
        a.put("#(被球闷)", "B_0057");
        a.put("#(感动)", "ali_002");
        a.put("#(来)", "B_0014");
        a.put("#(挠墙)", "ali_030");
        a.put("#(哭泣)", "ali_005");
        a.put("#(撒花)", "yz_041");
        a.put("#(飘过)", "ali_008");
        a.put("#(吼叫)", "ali_033");
        a.put("#(捏脸)", "ali_036");
        a.put("#(烧香)", "B_0045");
        a.put("#(潜水)", "ali_039");
        a.put("#(KISS)", "B_0002");
        a.put("#(招财猫)", "yz_035");
        a.put("#(大惊)", "B_0008");
        a.put("#(吃花)", "B_0033");
        a.put("#(猛抽)", "B_0039");
        a.put("#(傻兮兮)", "yz_023");
        a.put("#(再见)", "B_0021");
        a.put("#(献花)", "ali_022");
        a.put("#(嘘)", "B_0027");
        a.put("#(扭扭)", "ali_025");
        a.put("#(摇)", "B_0052");
        a.put("#(吃西瓜)", "yz_029");
        a.put("#(抓)", "ali_028");
        a.put("#(大惊~)", "B_0058");
        a.put("#(玩铃铛)", "yz_042");
        a.put("#(泪眼)", "B_0015");
        a.put("#(泡泡)", "B_0040");
        a.put("#(睡)", "B_0046");
        a.put("#(不说)", "B_0003");
        a.put("#(揪耳朵)", "ali_011");
        a.put("#(纳尼)", "yz_030");
        a.put("#(放屁)", "yz_036");
        a.put("#(不要嘛)", "ali_014");
        a.put("#(吹泡泡糖)", "B_0034");
        a.put("#(飞个吻)", "B_0009");
        a.put("#(顶！)", "ali_042");
        a.put("#(爬来了)", "ali_017");
        a.put("#(玩电脑)", "ali_045");
        a.put("#(阿狸侠)", "ali_048");
        a.put("#(扇扇子)", "yz_024");
        a.put("#(抓狂~)", "B_0022");
    }

    private static String a(String str) {
        return a.get(str);
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> a(Context context, String str) {
        String str2;
        String str3;
        String str4;
        ArrayList<com.baidu.tbadk.widget.richText.c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        arrayList.add(cVar);
        try {
            String str5 = "";
            int length = str.length();
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                    int i2 = i + 2;
                    String str6 = "#(";
                    while (true) {
                        if (i2 >= length) {
                            str3 = str6;
                            break;
                        }
                        char charAt2 = str.charAt(i2);
                        str6 = str6 + charAt2;
                        if (charAt2 != ')') {
                            if (i2 + 1 < length && str.charAt(i2 + 1) == '#') {
                                str3 = str6;
                                break;
                            }
                            i2++;
                        } else {
                            str3 = str6;
                            break;
                        }
                    }
                    String a2 = a(str3);
                    if (TextUtils.isEmpty(a2)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            SpannableString b = b(context, str5);
                            if (b != null) {
                                cVar.a(b);
                            }
                            str4 = "";
                        }
                        SpannableString a3 = a(context, cVar.b(), a2, str3);
                        if (a3 != null) {
                            cVar.a(a3);
                        }
                    }
                    int i3 = i2;
                    str2 = str4;
                    i = i3;
                } else {
                    str2 = str5 + charAt;
                }
                i++;
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str5)) {
                SpannableString b2 = b(context, str5);
                if (b2 != null) {
                    cVar.a(b2);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("error = " + e.getMessage());
        }
        return arrayList;
    }

    private static SpannableString a(Context context, ArrayList<com.baidu.tbadk.widget.richText.f> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int b = TbFaceManager.a().b(str);
        if (b != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(context, b);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.b c = TbFaceManager.a().c(str);
            if (c != null) {
                fVar.setBounds(new Rect(0, 0, c.a(), c.b()));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString b(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tieba.im.d.h.a(context, str);
    }
}
