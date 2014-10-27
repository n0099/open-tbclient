package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> Si = new HashMap<>();
    public static final ArrayList<Integer> Sj = new ArrayList<>();
    public static final HashMap<String, Integer> Sk = new HashMap<>();
    private static final HashMap<String, String> Sl = new HashMap<>();

    static {
        Sl.put("image_emoticon", "呵呵");
        Sl.put("image_emoticon2", "哈哈");
        Sl.put("image_emoticon3", "吐舌");
        Sl.put("image_emoticon4", "啊?");
        Sl.put("image_emoticon5", "酷");
        Sl.put("image_emoticon6", "怒");
        Sl.put("image_emoticon7", "开心");
        Sl.put("image_emoticon8", "汗");
        Sl.put("image_emoticon9", "泪");
        Sl.put("image_emoticon10", "黑线");
        Sl.put("image_emoticon11", "鄙视");
        Sl.put("image_emoticon12", "不高兴");
        Sl.put("image_emoticon13", "真棒");
        Sl.put("image_emoticon14", "钱");
        Sl.put("image_emoticon15", "疑问");
        Sl.put("image_emoticon16", "阴险");
        Sl.put("image_emoticon17", "吐");
        Sl.put("image_emoticon18", "咦?");
        Sl.put("image_emoticon19", "委屈");
        Sl.put("image_emoticon20", "花心");
        Sl.put("image_emoticon21", "呼~");
        Sl.put("image_emoticon22", "笑眼");
        Sl.put("image_emoticon23", "冷");
        Sl.put("image_emoticon24", "太开心");
        Sl.put("image_emoticon25", "滑稽");
        Sl.put("image_emoticon26", "勉强");
        Sl.put("image_emoticon27", "狂汗");
        Sl.put("image_emoticon28", "乖");
        Sl.put("image_emoticon29", "睡觉");
        Sl.put("image_emoticon30", "惊哭");
        Sl.put("image_emoticon31", "升起");
        Sl.put("image_emoticon32", "惊讶");
        Sl.put("image_emoticon33", "喷");
        Sl.put("image_emoticon34", "爱心");
        Sl.put("image_emoticon35", "心碎");
        Sl.put("image_emoticon36", "玫瑰");
        Sl.put("image_emoticon37", "礼物");
        Sl.put("image_emoticon38", "彩虹");
        Sl.put("image_emoticon39", "星星月亮");
        Sl.put("image_emoticon40", "太阳");
        Sl.put("image_emoticon41", "钱币");
        Sl.put("image_emoticon42", "灯泡");
        Sl.put("image_emoticon43", "茶杯");
        Sl.put("image_emoticon44", "蛋糕");
        Sl.put("image_emoticon45", "音乐");
        Sl.put("image_emoticon46", "haha");
        Sl.put("image_emoticon47", "胜利");
        Sl.put("image_emoticon48", "大拇指");
        Sl.put("image_emoticon49", "弱");
        Sl.put("image_emoticon50", "OK");
        Sl.put("ali_047", "哭着跑");
        Sl.put("ali_050", "惆怅~");
        Sl.put("ali_051", "摸头");
        Sl.put("ali_052", "蹭");
        Sl.put("ali_053", "打滚");
        Sl.put("ali_054", "叩拜");
        Sl.put("ali_055", "摸");
        Sl.put("ali_056", "数钱");
        Sl.put("ali_059", "加1");
        Sl.put("ali_060", "压力");
        Sl.put("ali_061", "表逼我");
        Sl.put("ali_062", "人呢");
        Sl.put("ali_063", "摇晃");
        Sl.put("ali_064", "打地鼠");
        Sl.put("ali_065", "这个屌");
        Sl.put("ali_066", "恐慌");
        Sl.put("ali_067", "晕乎乎");
        Sl.put("ali_068", "浮云");
        Sl.put("ali_069", "给力");
        Sl.put("ali_070", "杯具了");
        Sl.put("b01", "微笑");
        Sl.put("b02", "帅哥");
        Sl.put("b03", "美女");
        Sl.put("b04", "老大");
        Sl.put("b05", "哈哈哈");
        Sl.put("b06", "奸笑");
        Sl.put("b07", "傻乐");
        Sl.put("b08", "飞吻");
        Sl.put("b09", "害羞");
        Sl.put("b10", "花痴");
        Sl.put("b11", "憧憬");
        Sl.put("b12", "你牛");
        Sl.put("b13", "鼓掌");
        Sl.put("b14", "可爱");
        Sl.put("b15", "太委屈");
        Sl.put("b16", "大哭");
        Sl.put("b17", "泪奔");
        Sl.put("b18", "寻死");
        Sl.put("b19", "非常惊讶");
        Sl.put("b20", "表示疑问");
        Sl.put("yz_001", "焦糖舞");
        Sl.put("yz_002", "翻滚");
        Sl.put("yz_003", "拍屁股做鬼脸");
        Sl.put("yz_004", "不");
        Sl.put("yz_005", "河蟹掉啦");
        Sl.put("yz_006", "哦耶");
        Sl.put("yz_007", "我倒");
        Sl.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int dd(String str) {
        Integer num = Si.get(str);
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
        Integer num = Sk.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String df(String str) {
        return Sl.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int rx() {
        return Sj.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c p(Context context, String str) {
        return null;
    }
}
