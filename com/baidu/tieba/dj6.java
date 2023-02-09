package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class dj6 extends cc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947706521, "Lcom/baidu/tieba/dj6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947706521, "Lcom/baidu/tieba/dj6;");
                return;
            }
        }
        cc5.a.put("video_icon", Integer.valueOf((int) R.drawable.ico_link_video));
        HashMap<String, Integer> hashMap = cc5.a;
        Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c05);
        hashMap.put("image_emoticon34", valueOf);
        HashMap<String, Integer> hashMap2 = cc5.a;
        Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c06);
        hashMap2.put("image_emoticon35", valueOf2);
        HashMap<String, Integer> hashMap3 = cc5.a;
        Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c07);
        hashMap3.put("image_emoticon36", valueOf3);
        HashMap<String, Integer> hashMap4 = cc5.a;
        Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c08);
        hashMap4.put("image_emoticon37", valueOf4);
        HashMap<String, Integer> hashMap5 = cc5.a;
        Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c09);
        hashMap5.put("image_emoticon38", valueOf5);
        HashMap<String, Integer> hashMap6 = cc5.a;
        Integer valueOf6 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c0c);
        hashMap6.put("image_emoticon40", valueOf6);
        HashMap<String, Integer> hashMap7 = cc5.a;
        Integer valueOf7 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c0a);
        hashMap7.put("image_emoticon39", valueOf7);
        HashMap<String, Integer> hashMap8 = cc5.a;
        Integer valueOf8 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c0d);
        hashMap8.put("image_emoticon41", valueOf8);
        HashMap<String, Integer> hashMap9 = cc5.a;
        Integer valueOf9 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c0e);
        hashMap9.put("image_emoticon42", valueOf9);
        HashMap<String, Integer> hashMap10 = cc5.a;
        Integer valueOf10 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c0f);
        hashMap10.put("image_emoticon43", valueOf10);
        HashMap<String, Integer> hashMap11 = cc5.a;
        Integer valueOf11 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c10);
        hashMap11.put("image_emoticon44", valueOf11);
        HashMap<String, Integer> hashMap12 = cc5.a;
        Integer valueOf12 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c11);
        hashMap12.put("image_emoticon45", valueOf12);
        HashMap<String, Integer> hashMap13 = cc5.a;
        Integer valueOf13 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c12);
        hashMap13.put("image_emoticon46", valueOf13);
        HashMap<String, Integer> hashMap14 = cc5.a;
        Integer valueOf14 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c13);
        hashMap14.put("image_emoticon47", valueOf14);
        HashMap<String, Integer> hashMap15 = cc5.a;
        Integer valueOf15 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c14);
        hashMap15.put("image_emoticon48", valueOf15);
        cc5.a.put("image_emoticon49", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c15));
        cc5.a.put("image_emoticon50", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c17));
        cc5.a.put("image_emoticon77", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2a));
        cc5.a.put("image_emoticon78", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2b));
        cc5.a.put("image_emoticon79", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2c));
        cc5.a.put("image_emoticon80", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2e));
        cc5.a.put("image_emoticon81", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2f));
        cc5.a.put("image_emoticon82", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c30));
        cc5.a.put("image_emoticon83", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c31));
        cc5.a.put("image_emoticon84", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c32));
        cc5.a.put("image_emoticon101", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc7));
        cc5.a.put("image_emoticon102", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc8));
        cc5.a.put("image_emoticon103", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc9));
        cc5.a.put("image_emoticon104", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bca));
        cc5.a.put("image_emoticon105", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcb));
        cc5.a.put("image_emoticon106", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcc));
        cc5.a.put("image_emoticon107", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcd));
        cc5.a.put("image_emoticon108", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bce));
        cc5.a.put("image_emoticon109", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcf));
        cc5.a.put("image_emoticon110", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd1));
        cc5.a.put("image_emoticon111", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd2));
        cc5.a.put("image_emoticon112", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd3));
        cc5.a.put("image_emoticon113", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd4));
        cc5.a.put("image_emoticon114", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd5));
        cc5.a.put("image_emoticon115", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd6));
        cc5.a.put("image_emoticon116", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd7));
        cc5.a.put("image_emoticon117", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd8));
        cc5.a.put("image_emoticon118", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd9));
        cc5.a.put("image_emoticon119", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bda));
        cc5.a.put("image_emoticon120", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bdc));
        cc5.a.put("image_emoticon121", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bdd));
        cc5.a.put("image_emoticon122", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bde));
        cc5.a.put("image_emoticon123", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bdf));
        cc5.a.put("image_emoticon124", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080be0));
        cc5.b.add(valueOf);
        cc5.b.add(valueOf2);
        cc5.b.add(valueOf3);
        cc5.b.add(valueOf4);
        cc5.b.add(valueOf5);
        cc5.b.add(valueOf6);
        cc5.b.add(valueOf7);
        cc5.b.add(valueOf8);
        cc5.b.add(valueOf10);
        cc5.b.add(valueOf11);
        cc5.b.add(valueOf15);
        cc5.b.add(valueOf14);
        cc5.b.add(valueOf13);
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c17));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2a));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2b));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2c));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2e));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2f));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c30));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c31));
        cc5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c32));
        cc5.b.add(valueOf12);
        cc5.b.add(valueOf9);
        cc5.c.put("#(爱心)", valueOf);
        cc5.c.put("#(心碎)", valueOf2);
        cc5.c.put("#(玫瑰)", valueOf3);
        cc5.c.put("#(礼物)", valueOf4);
        cc5.c.put("#(彩虹)", valueOf5);
        cc5.c.put("#(星星月亮)", valueOf7);
        cc5.c.put("#(太阳)", valueOf6);
        cc5.c.put("#(钱币)", valueOf8);
        cc5.c.put("#(灯泡)", valueOf9);
        cc5.c.put("#(茶杯)", valueOf10);
        cc5.c.put("#(蛋糕)", valueOf11);
        cc5.c.put("#(音乐)", valueOf12);
        cc5.c.put("#(haha)", valueOf13);
        cc5.c.put("#(胜利)", valueOf14);
        cc5.c.put("#(大拇指)", valueOf15);
        cc5.c.put("#(弱)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c15));
        cc5.c.put("#(OK)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c17));
        cc5.c.put("#(沙发)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2a));
        cc5.c.put("#(手纸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2b));
        cc5.c.put("#(香蕉)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2c));
        cc5.c.put("#(便便)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2e));
        cc5.c.put("#(药丸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c2f));
        cc5.c.put("#(红领巾)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c30));
        cc5.c.put("#(蜡烛)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c31));
        cc5.c.put("#(三道杠)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c32));
        cc5.c.put("#(不跟丑人说话)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc7));
        cc5.c.put("#(么么哒)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc8));
        cc5.c.put("#(亲亲才能起来)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc9));
        cc5.c.put("#(伦家只是宝宝)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bca));
        cc5.c.put("#(你是我的人)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcb));
        cc5.c.put("#(假装看不见)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcc));
        cc5.c.put("#(单身等撩)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcd));
        cc5.c.put("#(吓到宝宝了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bce));
        cc5.c.put("#(哈哈哈)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bcf));
        cc5.c.put("#(嗯嗯)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd1));
        cc5.c.put("#(好幸福)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd2));
        cc5.c.put("#(宝宝不开心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd3));
        cc5.c.put("#(小姐姐别走)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd4));
        cc5.c.put("#(小姐姐在吗)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd5));
        cc5.c.put("#(小姐姐来啦)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd6));
        cc5.c.put("#(小姐姐来玩呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd7));
        cc5.c.put("#(我养你)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd8));
        cc5.c.put("#(我是不会骗你的)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd9));
        cc5.c.put("#(扎心了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bda));
        cc5.c.put("#(无聊)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bdc));
        cc5.c.put("#(月亮代表我的心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bdd));
        cc5.c.put("#(来追我呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bde));
        cc5.c.put("#(爱你的形状)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bdf));
        cc5.c.put("#(白眼)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080be0));
    }

    public dj6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
