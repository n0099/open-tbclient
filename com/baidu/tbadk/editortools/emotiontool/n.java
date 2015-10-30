package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aqD = new HashMap<>();
    public static final ArrayList<Integer> aqE = new ArrayList<>();
    public static final HashMap<String, Integer> aqF = new HashMap<>();
    private static final HashMap<String, String> aqG = new HashMap<>();

    static {
        aqG.put("image_emoticon", "呵呵");
        aqG.put("image_emoticon2", "哈哈");
        aqG.put("image_emoticon3", "吐舌");
        aqG.put("image_emoticon4", "啊");
        aqG.put("image_emoticon5", "酷");
        aqG.put("image_emoticon6", "怒");
        aqG.put("image_emoticon7", "开心");
        aqG.put("image_emoticon8", "汗");
        aqG.put("image_emoticon9", "泪");
        aqG.put("image_emoticon10", "黑线");
        aqG.put("image_emoticon11", "鄙视");
        aqG.put("image_emoticon12", "不高兴");
        aqG.put("image_emoticon13", "真棒");
        aqG.put("image_emoticon14", "钱");
        aqG.put("image_emoticon15", "疑问");
        aqG.put("image_emoticon16", "阴险");
        aqG.put("image_emoticon17", "吐");
        aqG.put("image_emoticon18", "咦");
        aqG.put("image_emoticon19", "委屈");
        aqG.put("image_emoticon20", "花心");
        aqG.put("image_emoticon21", "呼~");
        aqG.put("image_emoticon22", "笑眼");
        aqG.put("image_emoticon23", "冷");
        aqG.put("image_emoticon24", "太开心");
        aqG.put("image_emoticon25", "滑稽");
        aqG.put("image_emoticon26", "勉强");
        aqG.put("image_emoticon27", "狂汗");
        aqG.put("image_emoticon28", "乖");
        aqG.put("image_emoticon29", "睡觉");
        aqG.put("image_emoticon30", "惊哭");
        aqG.put("image_emoticon31", "升起");
        aqG.put("image_emoticon32", "惊讶");
        aqG.put("image_emoticon33", "喷");
        aqG.put("image_emoticon34", "爱心");
        aqG.put("image_emoticon35", "心碎");
        aqG.put("image_emoticon36", "玫瑰");
        aqG.put("image_emoticon37", "礼物");
        aqG.put("image_emoticon38", "彩虹");
        aqG.put("image_emoticon39", "星星月亮");
        aqG.put("image_emoticon40", "太阳");
        aqG.put("image_emoticon41", "钱币");
        aqG.put("image_emoticon42", "灯泡");
        aqG.put("image_emoticon43", "茶杯");
        aqG.put("image_emoticon44", "蛋糕");
        aqG.put("image_emoticon45", "音乐");
        aqG.put("image_emoticon46", "haha");
        aqG.put("image_emoticon47", "胜利");
        aqG.put("image_emoticon48", "大拇指");
        aqG.put("image_emoticon49", "弱");
        aqG.put("image_emoticon50", "OK");
        aqG.put("ali_001", "赖皮");
        aqG.put("ali_002", "感动");
        aqG.put("ali_003", "十分惊讶");
        aqG.put("ali_004", "怒气");
        aqG.put("ali_005", "哭泣");
        aqG.put("ali_006", "吃惊");
        aqG.put("ali_007", "嘲弄");
        aqG.put("ali_008", "飘过");
        aqG.put("ali_009", "转圈哭");
        aqG.put("ali_010", "神经病");
        aqG.put("ali_011", "揪耳朵");
        aqG.put("ali_012", "惊汗");
        aqG.put("ali_013", "隐身");
        aqG.put("ali_014", "不要嘛");
        aqG.put("ali_015", "遁");
        aqG.put("ali_016", "不公平");
        aqG.put("ali_017", "爬来了");
        aqG.put("ali_018", "蛋花哭");
        aqG.put("ali_019", "温暖");
        aqG.put("ali_020", "点头");
        aqG.put("ali_021", "撒钱");
        aqG.put("ali_022", "献花");
        aqG.put("ali_023", "寒");
        aqG.put("ali_024", "傻笑");
        aqG.put("ali_025", "扭扭");
        aqG.put("ali_026", "疯");
        aqG.put("ali_027", "抓狂");
        aqG.put("ali_028", "抓");
        aqG.put("ali_029", "蜷");
        aqG.put("ali_030", "挠墙");
        aqG.put("ali_031", "狂笑");
        aqG.put("ali_032", "抱枕");
        aqG.put("ali_033", "吼叫");
        aqG.put("ali_034", "嚷");
        aqG.put("ali_035", "唠叨");
        aqG.put("ali_036", "捏脸");
        aqG.put("ali_037", "爆笑");
        aqG.put("ali_038", "郁闷");
        aqG.put("ali_039", "潜水");
        aqG.put("ali_040", "十分开心");
        aqG.put("ali_041", "冷笑话");
        aqG.put("ali_042", "顶！");
        aqG.put("ali_043", "潜");
        aqG.put("ali_044", "画圈圈");
        aqG.put("ali_045", "玩电脑");
        aqG.put("ali_046", "狂吐");
        aqG.put("ali_047", "哭着跑");
        aqG.put("ali_048", "阿狸侠");
        aqG.put("ali_049", "冷死了");
        aqG.put("ali_050", "惆怅~");
        aqG.put("ali_051", "摸头");
        aqG.put("ali_052", "蹭");
        aqG.put("ali_053", "打滚");
        aqG.put("ali_054", "叩拜");
        aqG.put("ali_055", "摸");
        aqG.put("ali_056", "数钱");
        aqG.put("ali_057", "拖走");
        aqG.put("ali_058", "热");
        aqG.put("ali_059", "加1");
        aqG.put("ali_060", "压力");
        aqG.put("ali_061", "表逼我");
        aqG.put("ali_062", "人呢");
        aqG.put("ali_063", "摇晃");
        aqG.put("ali_064", "打地鼠");
        aqG.put("ali_065", "这个屌");
        aqG.put("ali_066", "恐慌");
        aqG.put("ali_067", "晕乎乎");
        aqG.put("ali_068", "浮云");
        aqG.put("ali_069", "给力");
        aqG.put("ali_070", "杯具了");
        aqG.put("b01", "微笑");
        aqG.put("b02", "帅哥");
        aqG.put("b03", "美女");
        aqG.put("b04", "老大");
        aqG.put("b05", "哈哈哈");
        aqG.put("b06", "奸笑");
        aqG.put("b07", "傻乐");
        aqG.put("b08", "飞吻");
        aqG.put("b09", "害羞");
        aqG.put("b10", "花痴");
        aqG.put("b11", "憧憬");
        aqG.put("b12", "你牛");
        aqG.put("b13", "鼓掌");
        aqG.put("b14", "可爱");
        aqG.put("b15", "太委屈");
        aqG.put("b16", "大哭");
        aqG.put("b17", "泪奔");
        aqG.put("b18", "寻死");
        aqG.put("b19", "非常惊讶");
        aqG.put("b20", "表示疑问");
        aqG.put("yz_001", "焦糖舞");
        aqG.put("yz_002", "翻滚");
        aqG.put("yz_003", "拍屁股做鬼脸");
        aqG.put("yz_004", "不");
        aqG.put("yz_005", "河蟹掉啦");
        aqG.put("yz_006", "哦耶");
        aqG.put("yz_007", "我倒");
        aqG.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eM(String str) {
        Integer num = aqD.get(str);
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
        Integer num = aqF.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String eO(String str) {
        return aqG.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int AN() {
        return aqE.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0049a F(Context context, String str) {
        return null;
    }
}
