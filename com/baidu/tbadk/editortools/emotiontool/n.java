package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> asc = new HashMap<>();
    public static final ArrayList<Integer> asd = new ArrayList<>();
    public static final HashMap<String, Integer> ase = new HashMap<>();
    private static final HashMap<String, String> asf = new HashMap<>();

    static {
        asf.put("image_emoticon", "呵呵");
        asf.put("image_emoticon2", "哈哈");
        asf.put("image_emoticon3", "吐舌");
        asf.put("image_emoticon4", "啊");
        asf.put("image_emoticon5", "酷");
        asf.put("image_emoticon6", "怒");
        asf.put("image_emoticon7", "开心");
        asf.put("image_emoticon8", "汗");
        asf.put("image_emoticon9", "泪");
        asf.put("image_emoticon10", "黑线");
        asf.put("image_emoticon11", "鄙视");
        asf.put("image_emoticon12", "不高兴");
        asf.put("image_emoticon13", "真棒");
        asf.put("image_emoticon14", "钱");
        asf.put("image_emoticon15", "疑问");
        asf.put("image_emoticon16", "阴险");
        asf.put("image_emoticon17", "吐");
        asf.put("image_emoticon18", "咦");
        asf.put("image_emoticon19", "委屈");
        asf.put("image_emoticon20", "花心");
        asf.put("image_emoticon21", "呼~");
        asf.put("image_emoticon22", "笑眼");
        asf.put("image_emoticon23", "冷");
        asf.put("image_emoticon24", "太开心");
        asf.put("image_emoticon25", "滑稽");
        asf.put("image_emoticon26", "勉强");
        asf.put("image_emoticon27", "狂汗");
        asf.put("image_emoticon28", "乖");
        asf.put("image_emoticon29", "睡觉");
        asf.put("image_emoticon30", "惊哭");
        asf.put("image_emoticon31", "升起");
        asf.put("image_emoticon32", "惊讶");
        asf.put("image_emoticon33", "喷");
        asf.put("image_emoticon34", "爱心");
        asf.put("image_emoticon35", "心碎");
        asf.put("image_emoticon36", "玫瑰");
        asf.put("image_emoticon37", "礼物");
        asf.put("image_emoticon38", "彩虹");
        asf.put("image_emoticon39", "星星月亮");
        asf.put("image_emoticon40", "太阳");
        asf.put("image_emoticon41", "钱币");
        asf.put("image_emoticon42", "灯泡");
        asf.put("image_emoticon43", "茶杯");
        asf.put("image_emoticon44", "蛋糕");
        asf.put("image_emoticon45", "音乐");
        asf.put("image_emoticon46", "haha");
        asf.put("image_emoticon47", "胜利");
        asf.put("image_emoticon48", "大拇指");
        asf.put("image_emoticon49", "弱");
        asf.put("image_emoticon50", "OK");
        asf.put("ali_001", "赖皮");
        asf.put("ali_002", "感动");
        asf.put("ali_003", "十分惊讶");
        asf.put("ali_004", "怒气");
        asf.put("ali_005", "哭泣");
        asf.put("ali_006", "吃惊");
        asf.put("ali_007", "嘲弄");
        asf.put("ali_008", "飘过");
        asf.put("ali_009", "转圈哭");
        asf.put("ali_010", "神经病");
        asf.put("ali_011", "揪耳朵");
        asf.put("ali_012", "惊汗");
        asf.put("ali_013", "隐身");
        asf.put("ali_014", "不要嘛");
        asf.put("ali_015", "遁");
        asf.put("ali_016", "不公平");
        asf.put("ali_017", "爬来了");
        asf.put("ali_018", "蛋花哭");
        asf.put("ali_019", "温暖");
        asf.put("ali_020", "点头");
        asf.put("ali_021", "撒钱");
        asf.put("ali_022", "献花");
        asf.put("ali_023", "寒");
        asf.put("ali_024", "傻笑");
        asf.put("ali_025", "扭扭");
        asf.put("ali_026", "疯");
        asf.put("ali_027", "抓狂");
        asf.put("ali_028", "抓");
        asf.put("ali_029", "蜷");
        asf.put("ali_030", "挠墙");
        asf.put("ali_031", "狂笑");
        asf.put("ali_032", "抱枕");
        asf.put("ali_033", "吼叫");
        asf.put("ali_034", "嚷");
        asf.put("ali_035", "唠叨");
        asf.put("ali_036", "捏脸");
        asf.put("ali_037", "爆笑");
        asf.put("ali_038", "郁闷");
        asf.put("ali_039", "潜水");
        asf.put("ali_040", "十分开心");
        asf.put("ali_041", "冷笑话");
        asf.put("ali_042", "顶！");
        asf.put("ali_043", "潜");
        asf.put("ali_044", "画圈圈");
        asf.put("ali_045", "玩电脑");
        asf.put("ali_046", "狂吐");
        asf.put("ali_047", "哭着跑");
        asf.put("ali_048", "阿狸侠");
        asf.put("ali_049", "冷死了");
        asf.put("ali_050", "惆怅~");
        asf.put("ali_051", "摸头");
        asf.put("ali_052", "蹭");
        asf.put("ali_053", "打滚");
        asf.put("ali_054", "叩拜");
        asf.put("ali_055", "摸");
        asf.put("ali_056", "数钱");
        asf.put("ali_057", "拖走");
        asf.put("ali_058", "热");
        asf.put("ali_059", "加1");
        asf.put("ali_060", "压力");
        asf.put("ali_061", "表逼我");
        asf.put("ali_062", "人呢");
        asf.put("ali_063", "摇晃");
        asf.put("ali_064", "打地鼠");
        asf.put("ali_065", "这个屌");
        asf.put("ali_066", "恐慌");
        asf.put("ali_067", "晕乎乎");
        asf.put("ali_068", "浮云");
        asf.put("ali_069", "给力");
        asf.put("ali_070", "杯具了");
        asf.put("b01", "微笑");
        asf.put("b02", "帅哥");
        asf.put("b03", "美女");
        asf.put("b04", "老大");
        asf.put("b05", "哈哈哈");
        asf.put("b06", "奸笑");
        asf.put("b07", "傻乐");
        asf.put("b08", "飞吻");
        asf.put("b09", "害羞");
        asf.put("b10", "花痴");
        asf.put("b11", "憧憬");
        asf.put("b12", "你牛");
        asf.put("b13", "鼓掌");
        asf.put("b14", "可爱");
        asf.put("b15", "太委屈");
        asf.put("b16", "大哭");
        asf.put("b17", "泪奔");
        asf.put("b18", "寻死");
        asf.put("b19", "非常惊讶");
        asf.put("b20", "表示疑问");
        asf.put("yz_001", "焦糖舞");
        asf.put("yz_002", "翻滚");
        asf.put("yz_003", "拍屁股做鬼脸");
        asf.put("yz_004", "不");
        asf.put("yz_005", "河蟹掉啦");
        asf.put("yz_006", "哦耶");
        asf.put("yz_007", "我倒");
        asf.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eH(String str) {
        Integer num = asc.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(i.e.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eI(String str) {
        Integer num = ase.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String eJ(String str) {
        return asf.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Bd() {
        return asd.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0049a G(Context context, String str) {
        return null;
    }
}
