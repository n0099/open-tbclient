package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> arh = new HashMap<>();
    public static final ArrayList<Integer> ari = new ArrayList<>();
    public static final HashMap<String, Integer> arj = new HashMap<>();
    private static final HashMap<String, String> ark = new HashMap<>();

    static {
        ark.put("image_emoticon", "呵呵");
        ark.put("image_emoticon2", "哈哈");
        ark.put("image_emoticon3", "吐舌");
        ark.put("image_emoticon4", "啊");
        ark.put("image_emoticon5", "酷");
        ark.put("image_emoticon6", "怒");
        ark.put("image_emoticon7", "开心");
        ark.put("image_emoticon8", "汗");
        ark.put("image_emoticon9", "泪");
        ark.put("image_emoticon10", "黑线");
        ark.put("image_emoticon11", "鄙视");
        ark.put("image_emoticon12", "不高兴");
        ark.put("image_emoticon13", "真棒");
        ark.put("image_emoticon14", "钱");
        ark.put("image_emoticon15", "疑问");
        ark.put("image_emoticon16", "阴险");
        ark.put("image_emoticon17", "吐");
        ark.put("image_emoticon18", "咦");
        ark.put("image_emoticon19", "委屈");
        ark.put("image_emoticon20", "花心");
        ark.put("image_emoticon21", "呼~");
        ark.put("image_emoticon22", "笑眼");
        ark.put("image_emoticon23", "冷");
        ark.put("image_emoticon24", "太开心");
        ark.put("image_emoticon25", "滑稽");
        ark.put("image_emoticon26", "勉强");
        ark.put("image_emoticon27", "狂汗");
        ark.put("image_emoticon28", "乖");
        ark.put("image_emoticon29", "睡觉");
        ark.put("image_emoticon30", "惊哭");
        ark.put("image_emoticon31", "生气");
        ark.put("image_emoticon32", "惊讶");
        ark.put("image_emoticon33", "喷");
        ark.put("image_emoticon34", "爱心");
        ark.put("image_emoticon35", "心碎");
        ark.put("image_emoticon36", "玫瑰");
        ark.put("image_emoticon37", "礼物");
        ark.put("image_emoticon38", "彩虹");
        ark.put("image_emoticon39", "星星月亮");
        ark.put("image_emoticon40", "太阳");
        ark.put("image_emoticon41", "钱币");
        ark.put("image_emoticon42", "灯泡");
        ark.put("image_emoticon43", "茶杯");
        ark.put("image_emoticon44", "蛋糕");
        ark.put("image_emoticon45", "音乐");
        ark.put("image_emoticon46", "haha");
        ark.put("image_emoticon47", "胜利");
        ark.put("image_emoticon48", "大拇指");
        ark.put("image_emoticon49", "弱");
        ark.put("image_emoticon50", "OK");
        ark.put("image_emoticon61", "哼");
        ark.put("image_emoticon62", "吃瓜");
        ark.put("image_emoticon63", "扔便便");
        ark.put("image_emoticon64", "惊恐");
        ark.put("image_emoticon65", "哎呦");
        ark.put("image_emoticon66", "小乖");
        ark.put("image_emoticon67", "捂嘴笑");
        ark.put("image_emoticon68", "你懂的");
        ark.put("image_emoticon69", "what");
        ark.put("image_emoticon70", "酸爽");
        ark.put("image_emoticon71", "呀咩爹");
        ark.put("image_emoticon72", "笑尿");
        ark.put("image_emoticon73", "挖鼻");
        ark.put("image_emoticon74", "犀利");
        ark.put("image_emoticon75", "小红脸");
        ark.put("image_emoticon76", "懒得理");
        ark.put("image_emoticon77", "沙发");
        ark.put("image_emoticon78", "手纸");
        ark.put("image_emoticon79", "香蕉");
        ark.put("image_emoticon80", "便便");
        ark.put("image_emoticon81", "药丸");
        ark.put("image_emoticon82", "红领巾");
        ark.put("image_emoticon83", "蜡烛");
        ark.put("image_emoticon84", "三道杠");
        ark.put("ali_001", "赖皮");
        ark.put("ali_002", "感动");
        ark.put("ali_003", "十分惊讶");
        ark.put("ali_004", "怒气");
        ark.put("ali_005", "哭泣");
        ark.put("ali_006", "吃惊");
        ark.put("ali_007", "嘲弄");
        ark.put("ali_008", "飘过");
        ark.put("ali_009", "转圈哭");
        ark.put("ali_010", "神经病");
        ark.put("ali_011", "揪耳朵");
        ark.put("ali_012", "惊汗");
        ark.put("ali_013", "隐身");
        ark.put("ali_014", "不要嘛");
        ark.put("ali_015", "遁");
        ark.put("ali_016", "不公平");
        ark.put("ali_017", "爬来了");
        ark.put("ali_018", "蛋花哭");
        ark.put("ali_019", "温暖");
        ark.put("ali_020", "点头");
        ark.put("ali_021", "撒钱");
        ark.put("ali_022", "献花");
        ark.put("ali_023", "寒");
        ark.put("ali_024", "傻笑");
        ark.put("ali_025", "扭扭");
        ark.put("ali_026", "疯");
        ark.put("ali_027", "抓狂");
        ark.put("ali_028", "抓");
        ark.put("ali_029", "蜷");
        ark.put("ali_030", "挠墙");
        ark.put("ali_031", "狂笑");
        ark.put("ali_032", "抱枕");
        ark.put("ali_033", "吼叫");
        ark.put("ali_034", "嚷");
        ark.put("ali_035", "唠叨");
        ark.put("ali_036", "捏脸");
        ark.put("ali_037", "爆笑");
        ark.put("ali_038", "郁闷");
        ark.put("ali_039", "潜水");
        ark.put("ali_040", "十分开心");
        ark.put("ali_041", "冷笑话");
        ark.put("ali_042", "顶！");
        ark.put("ali_043", "潜");
        ark.put("ali_044", "画圈圈");
        ark.put("ali_045", "玩电脑");
        ark.put("ali_046", "狂吐");
        ark.put("ali_047", "哭着跑");
        ark.put("ali_048", "阿狸侠");
        ark.put("ali_049", "冷死了");
        ark.put("ali_050", "惆怅~");
        ark.put("ali_051", "摸头");
        ark.put("ali_052", "蹭");
        ark.put("ali_053", "打滚");
        ark.put("ali_054", "叩拜");
        ark.put("ali_055", "摸");
        ark.put("ali_056", "数钱");
        ark.put("ali_057", "拖走");
        ark.put("ali_058", "热");
        ark.put("ali_059", "加1");
        ark.put("ali_060", "压力");
        ark.put("ali_061", "表逼我");
        ark.put("ali_062", "人呢");
        ark.put("ali_063", "摇晃");
        ark.put("ali_064", "打地鼠");
        ark.put("ali_065", "这个屌");
        ark.put("ali_066", "恐慌");
        ark.put("ali_067", "晕乎乎");
        ark.put("ali_068", "浮云");
        ark.put("ali_069", "给力");
        ark.put("ali_070", "杯具了");
        ark.put("b01", "微笑");
        ark.put("b02", "帅哥");
        ark.put("b03", "美女");
        ark.put("b04", "老大");
        ark.put("b05", "哈哈哈");
        ark.put("b06", "奸笑");
        ark.put("b07", "傻乐");
        ark.put("b08", "飞吻");
        ark.put("b09", "害羞");
        ark.put("b10", "花痴");
        ark.put("b11", "憧憬");
        ark.put("b12", "你牛");
        ark.put("b13", "鼓掌");
        ark.put("b14", "可爱");
        ark.put("b15", "太委屈");
        ark.put("b16", "大哭");
        ark.put("b17", "泪奔");
        ark.put("b18", "寻死");
        ark.put("b19", "非常惊讶");
        ark.put("b20", "表示疑问");
        ark.put("yz_001", "焦糖舞");
        ark.put("yz_002", "翻滚");
        ark.put("yz_003", "拍屁股做鬼脸");
        ark.put("yz_004", "不");
        ark.put("yz_005", "河蟹掉啦");
        ark.put("yz_006", "哦耶");
        ark.put("yz_007", "我倒");
        ark.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fo(String str) {
        Integer num = arh.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(u.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fp(String str) {
        Integer num = arj.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fq(String str) {
        return ark.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int BD() {
        return ari.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0043a y(Context context, String str) {
        return null;
    }
}
