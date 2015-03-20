package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> aja = new HashMap<>();
    public static final ArrayList<Integer> ajb = new ArrayList<>();
    public static final HashMap<String, Integer> ajc = new HashMap<>();
    private static final HashMap<String, String> ajd = new HashMap<>();

    static {
        ajd.put("image_emoticon", "呵呵");
        ajd.put("image_emoticon2", "哈哈");
        ajd.put("image_emoticon3", "吐舌");
        ajd.put("image_emoticon4", "啊?");
        ajd.put("image_emoticon5", "酷");
        ajd.put("image_emoticon6", "怒");
        ajd.put("image_emoticon7", "开心");
        ajd.put("image_emoticon8", "汗");
        ajd.put("image_emoticon9", "泪");
        ajd.put("image_emoticon10", "黑线");
        ajd.put("image_emoticon11", "鄙视");
        ajd.put("image_emoticon12", "不高兴");
        ajd.put("image_emoticon13", "真棒");
        ajd.put("image_emoticon14", "钱");
        ajd.put("image_emoticon15", "疑问");
        ajd.put("image_emoticon16", "阴险");
        ajd.put("image_emoticon17", "吐");
        ajd.put("image_emoticon18", "咦?");
        ajd.put("image_emoticon19", "委屈");
        ajd.put("image_emoticon20", "花心");
        ajd.put("image_emoticon21", "呼~");
        ajd.put("image_emoticon22", "笑眼");
        ajd.put("image_emoticon23", "冷");
        ajd.put("image_emoticon24", "太开心");
        ajd.put("image_emoticon25", "滑稽");
        ajd.put("image_emoticon26", "勉强");
        ajd.put("image_emoticon27", "狂汗");
        ajd.put("image_emoticon28", "乖");
        ajd.put("image_emoticon29", "睡觉");
        ajd.put("image_emoticon30", "惊哭");
        ajd.put("image_emoticon31", "升起");
        ajd.put("image_emoticon32", "惊讶");
        ajd.put("image_emoticon33", "喷");
        ajd.put("image_emoticon34", "爱心");
        ajd.put("image_emoticon35", "心碎");
        ajd.put("image_emoticon36", "玫瑰");
        ajd.put("image_emoticon37", "礼物");
        ajd.put("image_emoticon38", "彩虹");
        ajd.put("image_emoticon39", "星星月亮");
        ajd.put("image_emoticon40", "太阳");
        ajd.put("image_emoticon41", "钱币");
        ajd.put("image_emoticon42", "灯泡");
        ajd.put("image_emoticon43", "茶杯");
        ajd.put("image_emoticon44", "蛋糕");
        ajd.put("image_emoticon45", "音乐");
        ajd.put("image_emoticon46", "haha");
        ajd.put("image_emoticon47", "胜利");
        ajd.put("image_emoticon48", "大拇指");
        ajd.put("image_emoticon49", "弱");
        ajd.put("image_emoticon50", "OK");
        ajd.put("ali_047", "哭着跑");
        ajd.put("ali_050", "惆怅~");
        ajd.put("ali_051", "摸头");
        ajd.put("ali_052", "蹭");
        ajd.put("ali_053", "打滚");
        ajd.put("ali_054", "叩拜");
        ajd.put("ali_055", "摸");
        ajd.put("ali_056", "数钱");
        ajd.put("ali_059", "加1");
        ajd.put("ali_060", "压力");
        ajd.put("ali_061", "表逼我");
        ajd.put("ali_062", "人呢");
        ajd.put("ali_063", "摇晃");
        ajd.put("ali_064", "打地鼠");
        ajd.put("ali_065", "这个屌");
        ajd.put("ali_066", "恐慌");
        ajd.put("ali_067", "晕乎乎");
        ajd.put("ali_068", "浮云");
        ajd.put("ali_069", "给力");
        ajd.put("ali_070", "杯具了");
        ajd.put("b01", "微笑");
        ajd.put("b02", "帅哥");
        ajd.put("b03", "美女");
        ajd.put("b04", "老大");
        ajd.put("b05", "哈哈哈");
        ajd.put("b06", "奸笑");
        ajd.put("b07", "傻乐");
        ajd.put("b08", "飞吻");
        ajd.put("b09", "害羞");
        ajd.put("b10", "花痴");
        ajd.put("b11", "憧憬");
        ajd.put("b12", "你牛");
        ajd.put("b13", "鼓掌");
        ajd.put("b14", "可爱");
        ajd.put("b15", "太委屈");
        ajd.put("b16", "大哭");
        ajd.put("b17", "泪奔");
        ajd.put("b18", "寻死");
        ajd.put("b19", "非常惊讶");
        ajd.put("b20", "表示疑问");
        ajd.put("yz_001", "焦糖舞");
        ajd.put("yz_002", "翻滚");
        ajd.put("yz_003", "拍屁股做鬼脸");
        ajd.put("yz_004", "不");
        ajd.put("yz_005", "河蟹掉啦");
        ajd.put("yz_006", "哦耶");
        ajd.put("yz_007", "我倒");
        ajd.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int ea(String str) {
        Integer num = aja.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(com.baidu.tieba.u.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int eb(String str) {
        Integer num = ajc.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String ec(String str) {
        return ajd.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int yz() {
        return ajb.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c D(Context context, String str) {
        return null;
    }
}
