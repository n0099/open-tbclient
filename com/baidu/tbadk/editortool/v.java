package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> Sm = new HashMap<>();
    public static final ArrayList<Integer> Sn = new ArrayList<>();
    public static final HashMap<String, Integer> So = new HashMap<>();
    private static final HashMap<String, String> Sp = new HashMap<>();

    static {
        Sp.put("image_emoticon", "呵呵");
        Sp.put("image_emoticon2", "哈哈");
        Sp.put("image_emoticon3", "吐舌");
        Sp.put("image_emoticon4", "啊?");
        Sp.put("image_emoticon5", "酷");
        Sp.put("image_emoticon6", "怒");
        Sp.put("image_emoticon7", "开心");
        Sp.put("image_emoticon8", "汗");
        Sp.put("image_emoticon9", "泪");
        Sp.put("image_emoticon10", "黑线");
        Sp.put("image_emoticon11", "鄙视");
        Sp.put("image_emoticon12", "不高兴");
        Sp.put("image_emoticon13", "真棒");
        Sp.put("image_emoticon14", "钱");
        Sp.put("image_emoticon15", "疑问");
        Sp.put("image_emoticon16", "阴险");
        Sp.put("image_emoticon17", "吐");
        Sp.put("image_emoticon18", "咦?");
        Sp.put("image_emoticon19", "委屈");
        Sp.put("image_emoticon20", "花心");
        Sp.put("image_emoticon21", "呼~");
        Sp.put("image_emoticon22", "笑眼");
        Sp.put("image_emoticon23", "冷");
        Sp.put("image_emoticon24", "太开心");
        Sp.put("image_emoticon25", "滑稽");
        Sp.put("image_emoticon26", "勉强");
        Sp.put("image_emoticon27", "狂汗");
        Sp.put("image_emoticon28", "乖");
        Sp.put("image_emoticon29", "睡觉");
        Sp.put("image_emoticon30", "惊哭");
        Sp.put("image_emoticon31", "升起");
        Sp.put("image_emoticon32", "惊讶");
        Sp.put("image_emoticon33", "喷");
        Sp.put("image_emoticon34", "爱心");
        Sp.put("image_emoticon35", "心碎");
        Sp.put("image_emoticon36", "玫瑰");
        Sp.put("image_emoticon37", "礼物");
        Sp.put("image_emoticon38", "彩虹");
        Sp.put("image_emoticon39", "星星月亮");
        Sp.put("image_emoticon40", "太阳");
        Sp.put("image_emoticon41", "钱币");
        Sp.put("image_emoticon42", "灯泡");
        Sp.put("image_emoticon43", "茶杯");
        Sp.put("image_emoticon44", "蛋糕");
        Sp.put("image_emoticon45", "音乐");
        Sp.put("image_emoticon46", "haha");
        Sp.put("image_emoticon47", "胜利");
        Sp.put("image_emoticon48", "大拇指");
        Sp.put("image_emoticon49", "弱");
        Sp.put("image_emoticon50", "OK");
        Sp.put("ali_047", "哭着跑");
        Sp.put("ali_050", "惆怅~");
        Sp.put("ali_051", "摸头");
        Sp.put("ali_052", "蹭");
        Sp.put("ali_053", "打滚");
        Sp.put("ali_054", "叩拜");
        Sp.put("ali_055", "摸");
        Sp.put("ali_056", "数钱");
        Sp.put("ali_059", "加1");
        Sp.put("ali_060", "压力");
        Sp.put("ali_061", "表逼我");
        Sp.put("ali_062", "人呢");
        Sp.put("ali_063", "摇晃");
        Sp.put("ali_064", "打地鼠");
        Sp.put("ali_065", "这个屌");
        Sp.put("ali_066", "恐慌");
        Sp.put("ali_067", "晕乎乎");
        Sp.put("ali_068", "浮云");
        Sp.put("ali_069", "给力");
        Sp.put("ali_070", "杯具了");
        Sp.put("b01", "微笑");
        Sp.put("b02", "帅哥");
        Sp.put("b03", "美女");
        Sp.put("b04", "老大");
        Sp.put("b05", "哈哈哈");
        Sp.put("b06", "奸笑");
        Sp.put("b07", "傻乐");
        Sp.put("b08", "飞吻");
        Sp.put("b09", "害羞");
        Sp.put("b10", "花痴");
        Sp.put("b11", "憧憬");
        Sp.put("b12", "你牛");
        Sp.put("b13", "鼓掌");
        Sp.put("b14", "可爱");
        Sp.put("b15", "太委屈");
        Sp.put("b16", "大哭");
        Sp.put("b17", "泪奔");
        Sp.put("b18", "寻死");
        Sp.put("b19", "非常惊讶");
        Sp.put("b20", "表示疑问");
        Sp.put("yz_001", "焦糖舞");
        Sp.put("yz_002", "翻滚");
        Sp.put("yz_003", "拍屁股做鬼脸");
        Sp.put("yz_004", "不");
        Sp.put("yz_005", "河蟹掉啦");
        Sp.put("yz_006", "哦耶");
        Sp.put("yz_007", "我倒");
        Sp.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int dd(String str) {
        Integer num = Sm.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(com.baidu.tieba.u.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int de(String str) {
        Integer num = So.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String df(String str) {
        return Sp.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int rz() {
        return Sn.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c p(Context context, String str) {
        return null;
    }
}
