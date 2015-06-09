package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> akh = new HashMap<>();
    public static final ArrayList<Integer> aki = new ArrayList<>();
    public static final HashMap<String, Integer> akj = new HashMap<>();
    private static final HashMap<String, String> akk = new HashMap<>();

    static {
        akk.put("image_emoticon", "呵呵");
        akk.put("image_emoticon2", "哈哈");
        akk.put("image_emoticon3", "吐舌");
        akk.put("image_emoticon4", "啊?");
        akk.put("image_emoticon5", "酷");
        akk.put("image_emoticon6", "怒");
        akk.put("image_emoticon7", "开心");
        akk.put("image_emoticon8", "汗");
        akk.put("image_emoticon9", "泪");
        akk.put("image_emoticon10", "黑线");
        akk.put("image_emoticon11", "鄙视");
        akk.put("image_emoticon12", "不高兴");
        akk.put("image_emoticon13", "真棒");
        akk.put("image_emoticon14", "钱");
        akk.put("image_emoticon15", "疑问");
        akk.put("image_emoticon16", "阴险");
        akk.put("image_emoticon17", "吐");
        akk.put("image_emoticon18", "咦?");
        akk.put("image_emoticon19", "委屈");
        akk.put("image_emoticon20", "花心");
        akk.put("image_emoticon21", "呼~");
        akk.put("image_emoticon22", "笑眼");
        akk.put("image_emoticon23", "冷");
        akk.put("image_emoticon24", "太开心");
        akk.put("image_emoticon25", "滑稽");
        akk.put("image_emoticon26", "勉强");
        akk.put("image_emoticon27", "狂汗");
        akk.put("image_emoticon28", "乖");
        akk.put("image_emoticon29", "睡觉");
        akk.put("image_emoticon30", "惊哭");
        akk.put("image_emoticon31", "升起");
        akk.put("image_emoticon32", "惊讶");
        akk.put("image_emoticon33", "喷");
        akk.put("image_emoticon34", "爱心");
        akk.put("image_emoticon35", "心碎");
        akk.put("image_emoticon36", "玫瑰");
        akk.put("image_emoticon37", "礼物");
        akk.put("image_emoticon38", "彩虹");
        akk.put("image_emoticon39", "星星月亮");
        akk.put("image_emoticon40", "太阳");
        akk.put("image_emoticon41", "钱币");
        akk.put("image_emoticon42", "灯泡");
        akk.put("image_emoticon43", "茶杯");
        akk.put("image_emoticon44", "蛋糕");
        akk.put("image_emoticon45", "音乐");
        akk.put("image_emoticon46", "haha");
        akk.put("image_emoticon47", "胜利");
        akk.put("image_emoticon48", "大拇指");
        akk.put("image_emoticon49", "弱");
        akk.put("image_emoticon50", "OK");
        akk.put("ali_047", "哭着跑");
        akk.put("ali_050", "惆怅~");
        akk.put("ali_051", "摸头");
        akk.put("ali_052", "蹭");
        akk.put("ali_053", "打滚");
        akk.put("ali_054", "叩拜");
        akk.put("ali_055", "摸");
        akk.put("ali_056", "数钱");
        akk.put("ali_059", "加1");
        akk.put("ali_060", "压力");
        akk.put("ali_061", "表逼我");
        akk.put("ali_062", "人呢");
        akk.put("ali_063", "摇晃");
        akk.put("ali_064", "打地鼠");
        akk.put("ali_065", "这个屌");
        akk.put("ali_066", "恐慌");
        akk.put("ali_067", "晕乎乎");
        akk.put("ali_068", "浮云");
        akk.put("ali_069", "给力");
        akk.put("ali_070", "杯具了");
        akk.put("b01", "微笑");
        akk.put("b02", "帅哥");
        akk.put("b03", "美女");
        akk.put("b04", "老大");
        akk.put("b05", "哈哈哈");
        akk.put("b06", "奸笑");
        akk.put("b07", "傻乐");
        akk.put("b08", "飞吻");
        akk.put("b09", "害羞");
        akk.put("b10", "花痴");
        akk.put("b11", "憧憬");
        akk.put("b12", "你牛");
        akk.put("b13", "鼓掌");
        akk.put("b14", "可爱");
        akk.put("b15", "太委屈");
        akk.put("b16", "大哭");
        akk.put("b17", "泪奔");
        akk.put("b18", "寻死");
        akk.put("b19", "非常惊讶");
        akk.put("b20", "表示疑问");
        akk.put("yz_001", "焦糖舞");
        akk.put("yz_002", "翻滚");
        akk.put("yz_003", "拍屁股做鬼脸");
        akk.put("yz_004", "不");
        akk.put("yz_005", "河蟹掉啦");
        akk.put("yz_006", "哦耶");
        akk.put("yz_007", "我倒");
        akk.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int eu(String str) {
        Integer num = akh.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(com.baidu.tieba.p.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int ev(String str) {
        Integer num = akj.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String ew(String str) {
        return akk.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int zt() {
        return aki.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c E(Context context, String str) {
        return null;
    }
}
