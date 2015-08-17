package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aqs = new HashMap<>();
    public static final ArrayList<Integer> aqt = new ArrayList<>();
    public static final HashMap<String, Integer> aqu = new HashMap<>();
    private static final HashMap<String, String> aqv = new HashMap<>();

    static {
        aqv.put("image_emoticon", "呵呵");
        aqv.put("image_emoticon2", "哈哈");
        aqv.put("image_emoticon3", "吐舌");
        aqv.put("image_emoticon4", "啊");
        aqv.put("image_emoticon5", "酷");
        aqv.put("image_emoticon6", "怒");
        aqv.put("image_emoticon7", "开心");
        aqv.put("image_emoticon8", "汗");
        aqv.put("image_emoticon9", "泪");
        aqv.put("image_emoticon10", "黑线");
        aqv.put("image_emoticon11", "鄙视");
        aqv.put("image_emoticon12", "不高兴");
        aqv.put("image_emoticon13", "真棒");
        aqv.put("image_emoticon14", "钱");
        aqv.put("image_emoticon15", "疑问");
        aqv.put("image_emoticon16", "阴险");
        aqv.put("image_emoticon17", "吐");
        aqv.put("image_emoticon18", "咦");
        aqv.put("image_emoticon19", "委屈");
        aqv.put("image_emoticon20", "花心");
        aqv.put("image_emoticon21", "呼~");
        aqv.put("image_emoticon22", "笑眼");
        aqv.put("image_emoticon23", "冷");
        aqv.put("image_emoticon24", "太开心");
        aqv.put("image_emoticon25", "滑稽");
        aqv.put("image_emoticon26", "勉强");
        aqv.put("image_emoticon27", "狂汗");
        aqv.put("image_emoticon28", "乖");
        aqv.put("image_emoticon29", "睡觉");
        aqv.put("image_emoticon30", "惊哭");
        aqv.put("image_emoticon31", "升起");
        aqv.put("image_emoticon32", "惊讶");
        aqv.put("image_emoticon33", "喷");
        aqv.put("image_emoticon34", "爱心");
        aqv.put("image_emoticon35", "心碎");
        aqv.put("image_emoticon36", "玫瑰");
        aqv.put("image_emoticon37", "礼物");
        aqv.put("image_emoticon38", "彩虹");
        aqv.put("image_emoticon39", "星星月亮");
        aqv.put("image_emoticon40", "太阳");
        aqv.put("image_emoticon41", "钱币");
        aqv.put("image_emoticon42", "灯泡");
        aqv.put("image_emoticon43", "茶杯");
        aqv.put("image_emoticon44", "蛋糕");
        aqv.put("image_emoticon45", "音乐");
        aqv.put("image_emoticon46", "haha");
        aqv.put("image_emoticon47", "胜利");
        aqv.put("image_emoticon48", "大拇指");
        aqv.put("image_emoticon49", "弱");
        aqv.put("image_emoticon50", "OK");
        aqv.put("ali_001", "赖皮");
        aqv.put("ali_002", "感动");
        aqv.put("ali_003", "十分惊讶");
        aqv.put("ali_004", "怒气");
        aqv.put("ali_005", "哭泣");
        aqv.put("ali_006", "吃惊");
        aqv.put("ali_007", "嘲弄");
        aqv.put("ali_008", "飘过");
        aqv.put("ali_009", "转圈哭");
        aqv.put("ali_010", "神经病");
        aqv.put("ali_011", "揪耳朵");
        aqv.put("ali_012", "惊汗");
        aqv.put("ali_013", "隐身");
        aqv.put("ali_014", "不要嘛");
        aqv.put("ali_015", "遁");
        aqv.put("ali_016", "不公平");
        aqv.put("ali_017", "爬来了");
        aqv.put("ali_018", "蛋花哭");
        aqv.put("ali_019", "温暖");
        aqv.put("ali_020", "点头");
        aqv.put("ali_021", "撒钱");
        aqv.put("ali_022", "献花");
        aqv.put("ali_023", "寒");
        aqv.put("ali_024", "傻笑");
        aqv.put("ali_025", "扭扭");
        aqv.put("ali_026", "疯");
        aqv.put("ali_027", "抓狂");
        aqv.put("ali_028", "抓");
        aqv.put("ali_029", "蜷");
        aqv.put("ali_030", "挠墙");
        aqv.put("ali_031", "狂笑");
        aqv.put("ali_032", "抱枕");
        aqv.put("ali_033", "吼叫");
        aqv.put("ali_034", "嚷");
        aqv.put("ali_035", "唠叨");
        aqv.put("ali_036", "捏脸");
        aqv.put("ali_037", "爆笑");
        aqv.put("ali_038", "郁闷");
        aqv.put("ali_039", "潜水");
        aqv.put("ali_040", "十分开心");
        aqv.put("ali_041", "冷笑话");
        aqv.put("ali_042", "顶！");
        aqv.put("ali_043", "潜");
        aqv.put("ali_044", "画圈圈");
        aqv.put("ali_045", "玩电脑");
        aqv.put("ali_046", "狂吐");
        aqv.put("ali_047", "哭着跑");
        aqv.put("ali_048", "阿狸侠");
        aqv.put("ali_049", "冷死了");
        aqv.put("ali_050", "惆怅~");
        aqv.put("ali_051", "摸头");
        aqv.put("ali_052", "蹭");
        aqv.put("ali_053", "打滚");
        aqv.put("ali_054", "叩拜");
        aqv.put("ali_055", "摸");
        aqv.put("ali_056", "数钱");
        aqv.put("ali_057", "拖走");
        aqv.put("ali_058", "热");
        aqv.put("ali_059", "加1");
        aqv.put("ali_060", "压力");
        aqv.put("ali_061", "表逼我");
        aqv.put("ali_062", "人呢");
        aqv.put("ali_063", "摇晃");
        aqv.put("ali_064", "打地鼠");
        aqv.put("ali_065", "这个屌");
        aqv.put("ali_066", "恐慌");
        aqv.put("ali_067", "晕乎乎");
        aqv.put("ali_068", "浮云");
        aqv.put("ali_069", "给力");
        aqv.put("ali_070", "杯具了");
        aqv.put("b01", "微笑");
        aqv.put("b02", "帅哥");
        aqv.put("b03", "美女");
        aqv.put("b04", "老大");
        aqv.put("b05", "哈哈哈");
        aqv.put("b06", "奸笑");
        aqv.put("b07", "傻乐");
        aqv.put("b08", "飞吻");
        aqv.put("b09", "害羞");
        aqv.put("b10", "花痴");
        aqv.put("b11", "憧憬");
        aqv.put("b12", "你牛");
        aqv.put("b13", "鼓掌");
        aqv.put("b14", "可爱");
        aqv.put("b15", "太委屈");
        aqv.put("b16", "大哭");
        aqv.put("b17", "泪奔");
        aqv.put("b18", "寻死");
        aqv.put("b19", "非常惊讶");
        aqv.put("b20", "表示疑问");
        aqv.put("yz_001", "焦糖舞");
        aqv.put("yz_002", "翻滚");
        aqv.put("yz_003", "拍屁股做鬼脸");
        aqv.put("yz_004", "不");
        aqv.put("yz_005", "河蟹掉啦");
        aqv.put("yz_006", "哦耶");
        aqv.put("yz_007", "我倒");
        aqv.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int ez(String str) {
        Integer num = aqs.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(i.e.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eA(String str) {
        Integer num = aqu.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String eB(String str) {
        return aqv.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int AQ() {
        return aqt.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0049a G(Context context, String str) {
        return null;
    }
}
