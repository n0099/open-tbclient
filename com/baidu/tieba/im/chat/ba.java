package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static final HashMap<String, String> aOb = new HashMap<>();

    static {
        aOb.put("#(呵呵)", "image_emoticon");
        aOb.put("#(哈哈)", "image_emoticon2");
        aOb.put("#(吐舌)", "image_emoticon3");
        aOb.put("#(啊)", "image_emoticon4");
        aOb.put("#(啊?)", "image_emoticon4");
        aOb.put("#(酷)", "image_emoticon5");
        aOb.put("#(怒)", "image_emoticon6");
        aOb.put("#(开心)", "image_emoticon7");
        aOb.put("#(汗)", "image_emoticon8");
        aOb.put("#(泪)", "image_emoticon9");
        aOb.put("#(黑线)", "image_emoticon10");
        aOb.put("#(鄙视)", "image_emoticon11");
        aOb.put("#(不高兴)", "image_emoticon12");
        aOb.put("#(真棒)", "image_emoticon13");
        aOb.put("#(钱)", "image_emoticon14");
        aOb.put("#(疑问)", "image_emoticon15");
        aOb.put("#(阴险)", "image_emoticon16");
        aOb.put("#(吐)", "image_emoticon17");
        aOb.put("#(咦)", "image_emoticon18");
        aOb.put("#(咦?)", "image_emoticon18");
        aOb.put("#(委屈)", "image_emoticon19");
        aOb.put("#(花心)", "image_emoticon20");
        aOb.put("#(呼~)", "image_emoticon21");
        aOb.put("#(笑眼)", "image_emoticon22");
        aOb.put("#(冷)", "image_emoticon23");
        aOb.put("#(太开心)", "image_emoticon24");
        aOb.put("#(滑稽)", "image_emoticon25");
        aOb.put("#(勉强)", "image_emoticon26");
        aOb.put("#(狂汗)", "image_emoticon27");
        aOb.put("#(乖)", "image_emoticon28");
        aOb.put("#(睡觉)", "image_emoticon29");
        aOb.put("#(惊哭)", "image_emoticon30");
        aOb.put("#(升起)", "image_emoticon31");
        aOb.put("#(惊讶)", "image_emoticon32");
        aOb.put("#(喷)", "image_emoticon33");
        aOb.put("#(爱心)", "image_emoticon34");
        aOb.put("#(心碎)", "image_emoticon35");
        aOb.put("#(玫瑰)", "image_emoticon36");
        aOb.put("#(礼物)", "image_emoticon37");
        aOb.put("#(彩虹)", "image_emoticon38");
        aOb.put("#(星星月亮)", "image_emoticon39");
        aOb.put("#(太阳)", "image_emoticon40");
        aOb.put("#(钱币)", "image_emoticon41");
        aOb.put("#(灯泡)", "image_emoticon42");
        aOb.put("#(茶杯)", "image_emoticon43");
        aOb.put("#(蛋糕)", "image_emoticon44");
        aOb.put("#(音乐)", "image_emoticon45");
        aOb.put("#(haha)", "image_emoticon46");
        aOb.put("#(胜利)", "image_emoticon47");
        aOb.put("#(大拇指)", "image_emoticon48");
        aOb.put("#(弱)", "image_emoticon49");
        aOb.put("#(OK)", "image_emoticon50");
        aOb.put("#(哭着跑)", "ali_047");
        aOb.put("#(惆怅~)", "ali_050");
        aOb.put("#(摸头)", "ali_051");
        aOb.put("#(蹭)", "ali_052");
        aOb.put("#(打滚)", "ali_053");
        aOb.put("#(叩拜)", "ali_054");
        aOb.put("#(摸)", "ali_055");
        aOb.put("#(数钱)", "ali_056");
        aOb.put("#(加1)", "ali_059");
        aOb.put("#(压力)", "ali_060");
        aOb.put("#(表逼我)", "ali_061");
        aOb.put("#(摇晃)", "ali_063");
        aOb.put("#(打地鼠)", "ali_064");
        aOb.put("#(这个屌)", "ali_065");
        aOb.put("#(恐慌)", "ali_066");
        aOb.put("#(晕乎乎)", "ali_067");
        aOb.put("#(浮云)", "ali_068");
        aOb.put("#(给力)", "ali_069");
        aOb.put("#(杯具了)", "ali_070");
        aOb.put("#(焦糖舞)", "yz_001");
        aOb.put("#(翻滚)", "yz_002");
        aOb.put("#(拍屁股做鬼脸)", "yz_003");
        aOb.put("#(不)", "yz_004");
        aOb.put("#(河蟹掉啦)", "yz_005");
        aOb.put("#(哦耶)", "yz_006");
        aOb.put("#(我倒)", "yz_007");
        aOb.put("#(投降)", "yz_008");
        aOb.put("#(微笑)", "b01");
        aOb.put("#(帅哥)", "b02");
        aOb.put("#(美女)", "b03");
        aOb.put("#(老大)", "b04");
        aOb.put("#(哈哈哈)", "b05");
        aOb.put("#(奸笑)", "b06");
        aOb.put("#(傻乐)", "b07");
        aOb.put("#(飞吻)", "b08");
        aOb.put("#(害羞)", "b09");
        aOb.put("#(花痴)", "b10");
        aOb.put("#(憧憬)", "b11");
        aOb.put("#(你牛)", "b12");
        aOb.put("#(鼓掌)", "b13");
        aOb.put("#(可爱)", "b14");
        aOb.put("#(太委屈)", "b15");
        aOb.put("#(大哭)", "b16");
        aOb.put("#(泪奔)", "b17");
        aOb.put("#(寻死)", "b18");
        aOb.put("#(非常惊讶)", "b19");
        aOb.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return aOb.get(str);
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> C(Context context, String str) {
        ArrayList<com.baidu.tbadk.widget.richText.c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        arrayList.add(cVar);
        try {
            String str2 = "";
            int length = str.length();
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                    String str3 = "#(";
                    i += 2;
                    while (i < length) {
                        char charAt2 = str.charAt(i);
                        str3 = String.valueOf(str3) + charAt2;
                        if (charAt2 == ')' || (i + 1 < length && str.charAt(i + 1) == '#')) {
                            break;
                        }
                        i++;
                    }
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str2 = String.valueOf(str2) + str3;
                    } else {
                        if (!TextUtils.isEmpty(str2)) {
                            SpannableString D = D(context, str2);
                            if (D != null) {
                                cVar.append(D);
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.vC(), name, str3);
                        if (a != null) {
                            cVar.append(a);
                        }
                    }
                } else {
                    str2 = String.valueOf(str2) + charAt;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str2)) {
                SpannableString D2 = D(context, str2);
                if (D2 != null) {
                    cVar.append(D2);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.f> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int dd = TbFaceManager.sf().dd(str);
        if (dd != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkApplication.m251getInst(), dd);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c dp = TbFaceManager.sf().dp(str);
            if (dp != null) {
                fVar.setBounds(new Rect(0, 0, dp.getWidth(), dp.getHeight()));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString D(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bf.n(context, str);
    }
}
