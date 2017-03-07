package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> azx = new HashMap<>();
    public static final ArrayList<Integer> azy = new ArrayList<>();
    public static final HashMap<String, Integer> azz = new HashMap<>();
    private static final HashMap<String, String> azA = new HashMap<>();

    static {
        azA.put("image_emoticon", "呵呵");
        azA.put("image_emoticon2", "哈哈");
        azA.put("image_emoticon3", "吐舌");
        azA.put("image_emoticon4", "啊");
        azA.put("image_emoticon5", "酷");
        azA.put("image_emoticon6", "怒");
        azA.put("image_emoticon7", "开心");
        azA.put("image_emoticon8", "汗");
        azA.put("image_emoticon9", "泪");
        azA.put("image_emoticon10", "黑线");
        azA.put("image_emoticon11", "鄙视");
        azA.put("image_emoticon12", "不高兴");
        azA.put("image_emoticon13", "真棒");
        azA.put("image_emoticon14", "钱");
        azA.put("image_emoticon15", "疑问");
        azA.put("image_emoticon16", "阴险");
        azA.put("image_emoticon17", "吐");
        azA.put("image_emoticon18", "咦");
        azA.put("image_emoticon19", "委屈");
        azA.put("image_emoticon20", "花心");
        azA.put("image_emoticon21", "呼~");
        azA.put("image_emoticon22", "笑眼");
        azA.put("image_emoticon23", "冷");
        azA.put("image_emoticon24", "太开心");
        azA.put("image_emoticon25", "滑稽");
        azA.put("image_emoticon26", "勉强");
        azA.put("image_emoticon27", "狂汗");
        azA.put("image_emoticon28", "乖");
        azA.put("image_emoticon29", "睡觉");
        azA.put("image_emoticon30", "惊哭");
        azA.put("image_emoticon31", "生气");
        azA.put("image_emoticon32", "惊讶");
        azA.put("image_emoticon33", "喷");
        azA.put("image_emoticon34", "爱心");
        azA.put("image_emoticon35", "心碎");
        azA.put("image_emoticon36", "玫瑰");
        azA.put("image_emoticon37", "礼物");
        azA.put("image_emoticon38", "彩虹");
        azA.put("image_emoticon39", "星星月亮");
        azA.put("image_emoticon40", "太阳");
        azA.put("image_emoticon41", "钱币");
        azA.put("image_emoticon42", "灯泡");
        azA.put("image_emoticon43", "茶杯");
        azA.put("image_emoticon44", "蛋糕");
        azA.put("image_emoticon45", "音乐");
        azA.put("image_emoticon46", "haha");
        azA.put("image_emoticon47", "胜利");
        azA.put("image_emoticon48", "大拇指");
        azA.put("image_emoticon49", "弱");
        azA.put("image_emoticon50", "OK");
        azA.put("image_emoticon61", "哼");
        azA.put("image_emoticon62", "吃瓜");
        azA.put("image_emoticon63", "扔便便");
        azA.put("image_emoticon64", "惊恐");
        azA.put("image_emoticon65", "哎呦");
        azA.put("image_emoticon66", "小乖");
        azA.put("image_emoticon67", "捂嘴笑");
        azA.put("image_emoticon68", "你懂的");
        azA.put("image_emoticon69", "what");
        azA.put("image_emoticon70", "酸爽");
        azA.put("image_emoticon71", "呀咩爹");
        azA.put("image_emoticon72", "笑尿");
        azA.put("image_emoticon73", "挖鼻");
        azA.put("image_emoticon74", "犀利");
        azA.put("image_emoticon75", "小红脸");
        azA.put("image_emoticon76", "懒得理");
        azA.put("image_emoticon77", "沙发");
        azA.put("image_emoticon78", "手纸");
        azA.put("image_emoticon79", "香蕉");
        azA.put("image_emoticon80", "便便");
        azA.put("image_emoticon81", "药丸");
        azA.put("image_emoticon82", "红领巾");
        azA.put("image_emoticon83", "蜡烛");
        azA.put("image_emoticon84", "三道杠");
        azA.put("ali_001", "赖皮");
        azA.put("ali_002", "感动");
        azA.put("ali_003", "十分惊讶");
        azA.put("ali_004", "怒气");
        azA.put("ali_005", "哭泣");
        azA.put("ali_006", "吃惊");
        azA.put("ali_007", "嘲弄");
        azA.put("ali_008", "飘过");
        azA.put("ali_009", "转圈哭");
        azA.put("ali_010", "神经病");
        azA.put("ali_011", "揪耳朵");
        azA.put("ali_012", "惊汗");
        azA.put("ali_013", "隐身");
        azA.put("ali_014", "不要嘛");
        azA.put("ali_015", "遁");
        azA.put("ali_016", "不公平");
        azA.put("ali_017", "爬来了");
        azA.put("ali_018", "蛋花哭");
        azA.put("ali_019", "温暖");
        azA.put("ali_020", "点头");
        azA.put("ali_021", "撒钱");
        azA.put("ali_022", "献花");
        azA.put("ali_023", "寒");
        azA.put("ali_024", "傻笑");
        azA.put("ali_025", "扭扭");
        azA.put("ali_026", "疯");
        azA.put("ali_027", "抓狂");
        azA.put("ali_028", "抓");
        azA.put("ali_029", "蜷");
        azA.put("ali_030", "挠墙");
        azA.put("ali_031", "狂笑");
        azA.put("ali_032", "抱枕");
        azA.put("ali_033", "吼叫");
        azA.put("ali_034", "嚷");
        azA.put("ali_035", "唠叨");
        azA.put("ali_036", "捏脸");
        azA.put("ali_037", "爆笑");
        azA.put("ali_038", "郁闷");
        azA.put("ali_039", "潜水");
        azA.put("ali_040", "十分开心");
        azA.put("ali_041", "冷笑话");
        azA.put("ali_042", "顶！");
        azA.put("ali_043", "潜");
        azA.put("ali_044", "画圈圈");
        azA.put("ali_045", "玩电脑");
        azA.put("ali_046", "狂吐");
        azA.put("ali_047", "哭着跑");
        azA.put("ali_048", "阿狸侠");
        azA.put("ali_049", "冷死了");
        azA.put("ali_050", "惆怅~");
        azA.put("ali_051", "摸头");
        azA.put("ali_052", "蹭");
        azA.put("ali_053", "打滚");
        azA.put("ali_054", "叩拜");
        azA.put("ali_055", "摸");
        azA.put("ali_056", "数钱");
        azA.put("ali_057", "拖走");
        azA.put("ali_058", "热");
        azA.put("ali_059", "加1");
        azA.put("ali_060", "压力");
        azA.put("ali_061", "表逼我");
        azA.put("ali_062", "人呢");
        azA.put("ali_063", "摇晃");
        azA.put("ali_064", "打地鼠");
        azA.put("ali_065", "这个屌");
        azA.put("ali_066", "恐慌");
        azA.put("ali_067", "晕乎乎");
        azA.put("ali_068", "浮云");
        azA.put("ali_069", "给力");
        azA.put("ali_070", "杯具了");
        azA.put("b01", "微笑");
        azA.put("b02", "帅哥");
        azA.put("b03", "美女");
        azA.put("b04", "老大");
        azA.put("b05", "哈哈哈");
        azA.put("b06", "奸笑");
        azA.put("b07", "傻乐");
        azA.put("b08", "飞吻");
        azA.put("b09", "害羞");
        azA.put("b10", "花痴");
        azA.put("b11", "憧憬");
        azA.put("b12", "你牛");
        azA.put("b13", "鼓掌");
        azA.put("b14", "可爱");
        azA.put("b15", "太委屈");
        azA.put("b16", "大哭");
        azA.put("b17", "泪奔");
        azA.put("b18", "寻死");
        azA.put("b19", "非常惊讶");
        azA.put("b20", "表示疑问");
        azA.put("yz_001", "焦糖舞");
        azA.put("yz_002", "翻滚");
        azA.put("yz_003", "拍屁股做鬼脸");
        azA.put("yz_004", "不");
        azA.put("yz_005", "河蟹掉啦");
        azA.put("yz_006", "哦耶");
        azA.put("yz_007", "我倒");
        azA.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fc(String str) {
        Integer num = azx.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(w.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fd(String str) {
        Integer num = azz.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fe(String str) {
        return azA.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dc() {
        return azy.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0043a S(Context context, String str) {
        return null;
    }
}
