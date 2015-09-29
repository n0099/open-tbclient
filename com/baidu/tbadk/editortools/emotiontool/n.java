package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aqC = new HashMap<>();
    public static final ArrayList<Integer> aqD = new ArrayList<>();
    public static final HashMap<String, Integer> aqE = new HashMap<>();
    private static final HashMap<String, String> aqF = new HashMap<>();

    static {
        aqF.put("image_emoticon", "呵呵");
        aqF.put("image_emoticon2", "哈哈");
        aqF.put("image_emoticon3", "吐舌");
        aqF.put("image_emoticon4", "啊");
        aqF.put("image_emoticon5", "酷");
        aqF.put("image_emoticon6", "怒");
        aqF.put("image_emoticon7", "开心");
        aqF.put("image_emoticon8", "汗");
        aqF.put("image_emoticon9", "泪");
        aqF.put("image_emoticon10", "黑线");
        aqF.put("image_emoticon11", "鄙视");
        aqF.put("image_emoticon12", "不高兴");
        aqF.put("image_emoticon13", "真棒");
        aqF.put("image_emoticon14", "钱");
        aqF.put("image_emoticon15", "疑问");
        aqF.put("image_emoticon16", "阴险");
        aqF.put("image_emoticon17", "吐");
        aqF.put("image_emoticon18", "咦");
        aqF.put("image_emoticon19", "委屈");
        aqF.put("image_emoticon20", "花心");
        aqF.put("image_emoticon21", "呼~");
        aqF.put("image_emoticon22", "笑眼");
        aqF.put("image_emoticon23", "冷");
        aqF.put("image_emoticon24", "太开心");
        aqF.put("image_emoticon25", "滑稽");
        aqF.put("image_emoticon26", "勉强");
        aqF.put("image_emoticon27", "狂汗");
        aqF.put("image_emoticon28", "乖");
        aqF.put("image_emoticon29", "睡觉");
        aqF.put("image_emoticon30", "惊哭");
        aqF.put("image_emoticon31", "升起");
        aqF.put("image_emoticon32", "惊讶");
        aqF.put("image_emoticon33", "喷");
        aqF.put("image_emoticon34", "爱心");
        aqF.put("image_emoticon35", "心碎");
        aqF.put("image_emoticon36", "玫瑰");
        aqF.put("image_emoticon37", "礼物");
        aqF.put("image_emoticon38", "彩虹");
        aqF.put("image_emoticon39", "星星月亮");
        aqF.put("image_emoticon40", "太阳");
        aqF.put("image_emoticon41", "钱币");
        aqF.put("image_emoticon42", "灯泡");
        aqF.put("image_emoticon43", "茶杯");
        aqF.put("image_emoticon44", "蛋糕");
        aqF.put("image_emoticon45", "音乐");
        aqF.put("image_emoticon46", "haha");
        aqF.put("image_emoticon47", "胜利");
        aqF.put("image_emoticon48", "大拇指");
        aqF.put("image_emoticon49", "弱");
        aqF.put("image_emoticon50", "OK");
        aqF.put("ali_001", "赖皮");
        aqF.put("ali_002", "感动");
        aqF.put("ali_003", "十分惊讶");
        aqF.put("ali_004", "怒气");
        aqF.put("ali_005", "哭泣");
        aqF.put("ali_006", "吃惊");
        aqF.put("ali_007", "嘲弄");
        aqF.put("ali_008", "飘过");
        aqF.put("ali_009", "转圈哭");
        aqF.put("ali_010", "神经病");
        aqF.put("ali_011", "揪耳朵");
        aqF.put("ali_012", "惊汗");
        aqF.put("ali_013", "隐身");
        aqF.put("ali_014", "不要嘛");
        aqF.put("ali_015", "遁");
        aqF.put("ali_016", "不公平");
        aqF.put("ali_017", "爬来了");
        aqF.put("ali_018", "蛋花哭");
        aqF.put("ali_019", "温暖");
        aqF.put("ali_020", "点头");
        aqF.put("ali_021", "撒钱");
        aqF.put("ali_022", "献花");
        aqF.put("ali_023", "寒");
        aqF.put("ali_024", "傻笑");
        aqF.put("ali_025", "扭扭");
        aqF.put("ali_026", "疯");
        aqF.put("ali_027", "抓狂");
        aqF.put("ali_028", "抓");
        aqF.put("ali_029", "蜷");
        aqF.put("ali_030", "挠墙");
        aqF.put("ali_031", "狂笑");
        aqF.put("ali_032", "抱枕");
        aqF.put("ali_033", "吼叫");
        aqF.put("ali_034", "嚷");
        aqF.put("ali_035", "唠叨");
        aqF.put("ali_036", "捏脸");
        aqF.put("ali_037", "爆笑");
        aqF.put("ali_038", "郁闷");
        aqF.put("ali_039", "潜水");
        aqF.put("ali_040", "十分开心");
        aqF.put("ali_041", "冷笑话");
        aqF.put("ali_042", "顶！");
        aqF.put("ali_043", "潜");
        aqF.put("ali_044", "画圈圈");
        aqF.put("ali_045", "玩电脑");
        aqF.put("ali_046", "狂吐");
        aqF.put("ali_047", "哭着跑");
        aqF.put("ali_048", "阿狸侠");
        aqF.put("ali_049", "冷死了");
        aqF.put("ali_050", "惆怅~");
        aqF.put("ali_051", "摸头");
        aqF.put("ali_052", "蹭");
        aqF.put("ali_053", "打滚");
        aqF.put("ali_054", "叩拜");
        aqF.put("ali_055", "摸");
        aqF.put("ali_056", "数钱");
        aqF.put("ali_057", "拖走");
        aqF.put("ali_058", "热");
        aqF.put("ali_059", "加1");
        aqF.put("ali_060", "压力");
        aqF.put("ali_061", "表逼我");
        aqF.put("ali_062", "人呢");
        aqF.put("ali_063", "摇晃");
        aqF.put("ali_064", "打地鼠");
        aqF.put("ali_065", "这个屌");
        aqF.put("ali_066", "恐慌");
        aqF.put("ali_067", "晕乎乎");
        aqF.put("ali_068", "浮云");
        aqF.put("ali_069", "给力");
        aqF.put("ali_070", "杯具了");
        aqF.put("b01", "微笑");
        aqF.put("b02", "帅哥");
        aqF.put("b03", "美女");
        aqF.put("b04", "老大");
        aqF.put("b05", "哈哈哈");
        aqF.put("b06", "奸笑");
        aqF.put("b07", "傻乐");
        aqF.put("b08", "飞吻");
        aqF.put("b09", "害羞");
        aqF.put("b10", "花痴");
        aqF.put("b11", "憧憬");
        aqF.put("b12", "你牛");
        aqF.put("b13", "鼓掌");
        aqF.put("b14", "可爱");
        aqF.put("b15", "太委屈");
        aqF.put("b16", "大哭");
        aqF.put("b17", "泪奔");
        aqF.put("b18", "寻死");
        aqF.put("b19", "非常惊讶");
        aqF.put("b20", "表示疑问");
        aqF.put("yz_001", "焦糖舞");
        aqF.put("yz_002", "翻滚");
        aqF.put("yz_003", "拍屁股做鬼脸");
        aqF.put("yz_004", "不");
        aqF.put("yz_005", "河蟹掉啦");
        aqF.put("yz_006", "哦耶");
        aqF.put("yz_007", "我倒");
        aqF.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eM(String str) {
        Integer num = aqC.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(i.e.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eN(String str) {
        Integer num = aqE.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String eO(String str) {
        return aqF.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int AQ() {
        return aqD.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0049a F(Context context, String str) {
        return null;
    }
}
