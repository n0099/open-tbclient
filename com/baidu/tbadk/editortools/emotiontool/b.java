package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> avA = new HashMap<>();
    public static final ArrayList<Integer> avB = new ArrayList<>();
    public static final HashMap<String, Integer> avC = new HashMap<>();
    private static final HashMap<String, String> avD = new HashMap<>();

    static {
        avD.put("image_emoticon", "呵呵");
        avD.put("image_emoticon2", "哈哈");
        avD.put("image_emoticon3", "吐舌");
        avD.put("image_emoticon4", "啊");
        avD.put("image_emoticon5", "酷");
        avD.put("image_emoticon6", "怒");
        avD.put("image_emoticon7", "开心");
        avD.put("image_emoticon8", "汗");
        avD.put("image_emoticon9", "泪");
        avD.put("image_emoticon10", "黑线");
        avD.put("image_emoticon11", "鄙视");
        avD.put("image_emoticon12", "不高兴");
        avD.put("image_emoticon13", "真棒");
        avD.put("image_emoticon14", "钱");
        avD.put("image_emoticon15", "疑问");
        avD.put("image_emoticon16", "阴险");
        avD.put("image_emoticon17", "吐");
        avD.put("image_emoticon18", "咦");
        avD.put("image_emoticon19", "委屈");
        avD.put("image_emoticon20", "花心");
        avD.put("image_emoticon21", "呼~");
        avD.put("image_emoticon22", "笑眼");
        avD.put("image_emoticon23", "冷");
        avD.put("image_emoticon24", "太开心");
        avD.put("image_emoticon25", "滑稽");
        avD.put("image_emoticon26", "勉强");
        avD.put("image_emoticon27", "狂汗");
        avD.put("image_emoticon28", "乖");
        avD.put("image_emoticon29", "睡觉");
        avD.put("image_emoticon30", "惊哭");
        avD.put("image_emoticon31", "生气");
        avD.put("image_emoticon32", "惊讶");
        avD.put("image_emoticon33", "喷");
        avD.put("image_emoticon34", "爱心");
        avD.put("image_emoticon35", "心碎");
        avD.put("image_emoticon36", "玫瑰");
        avD.put("image_emoticon37", "礼物");
        avD.put("image_emoticon38", "彩虹");
        avD.put("image_emoticon39", "星星月亮");
        avD.put("image_emoticon40", "太阳");
        avD.put("image_emoticon41", "钱币");
        avD.put("image_emoticon42", "灯泡");
        avD.put("image_emoticon43", "茶杯");
        avD.put("image_emoticon44", "蛋糕");
        avD.put("image_emoticon45", "音乐");
        avD.put("image_emoticon46", "haha");
        avD.put("image_emoticon47", "胜利");
        avD.put("image_emoticon48", "大拇指");
        avD.put("image_emoticon49", "弱");
        avD.put("image_emoticon50", "OK");
        avD.put("image_emoticon61", "哼");
        avD.put("image_emoticon62", "吃瓜");
        avD.put("image_emoticon63", "扔便便");
        avD.put("image_emoticon64", "惊恐");
        avD.put("image_emoticon65", "哎呦");
        avD.put("image_emoticon66", "小乖");
        avD.put("image_emoticon67", "捂嘴笑");
        avD.put("image_emoticon68", "你懂的");
        avD.put("image_emoticon69", "what");
        avD.put("image_emoticon70", "酸爽");
        avD.put("image_emoticon71", "呀咩爹");
        avD.put("image_emoticon72", "笑尿");
        avD.put("image_emoticon73", "挖鼻");
        avD.put("image_emoticon74", "犀利");
        avD.put("image_emoticon75", "小红脸");
        avD.put("image_emoticon76", "懒得理");
        avD.put("image_emoticon77", "沙发");
        avD.put("image_emoticon78", "手纸");
        avD.put("image_emoticon79", "香蕉");
        avD.put("image_emoticon80", "便便");
        avD.put("image_emoticon81", "药丸");
        avD.put("image_emoticon82", "红领巾");
        avD.put("image_emoticon83", "蜡烛");
        avD.put("image_emoticon84", "三道杠");
        avD.put("ali_001", "赖皮");
        avD.put("ali_002", "感动");
        avD.put("ali_003", "十分惊讶");
        avD.put("ali_004", "怒气");
        avD.put("ali_005", "哭泣");
        avD.put("ali_006", "吃惊");
        avD.put("ali_007", "嘲弄");
        avD.put("ali_008", "飘过");
        avD.put("ali_009", "转圈哭");
        avD.put("ali_010", "神经病");
        avD.put("ali_011", "揪耳朵");
        avD.put("ali_012", "惊汗");
        avD.put("ali_013", "隐身");
        avD.put("ali_014", "不要嘛");
        avD.put("ali_015", "遁");
        avD.put("ali_016", "不公平");
        avD.put("ali_017", "爬来了");
        avD.put("ali_018", "蛋花哭");
        avD.put("ali_019", "温暖");
        avD.put("ali_020", "点头");
        avD.put("ali_021", "撒钱");
        avD.put("ali_022", "献花");
        avD.put("ali_023", "寒");
        avD.put("ali_024", "傻笑");
        avD.put("ali_025", "扭扭");
        avD.put("ali_026", "疯");
        avD.put("ali_027", "抓狂");
        avD.put("ali_028", "抓");
        avD.put("ali_029", "蜷");
        avD.put("ali_030", "挠墙");
        avD.put("ali_031", "狂笑");
        avD.put("ali_032", "抱枕");
        avD.put("ali_033", "吼叫");
        avD.put("ali_034", "嚷");
        avD.put("ali_035", "唠叨");
        avD.put("ali_036", "捏脸");
        avD.put("ali_037", "爆笑");
        avD.put("ali_038", "郁闷");
        avD.put("ali_039", "潜水");
        avD.put("ali_040", "十分开心");
        avD.put("ali_041", "冷笑话");
        avD.put("ali_042", "顶！");
        avD.put("ali_043", "潜");
        avD.put("ali_044", "画圈圈");
        avD.put("ali_045", "玩电脑");
        avD.put("ali_046", "狂吐");
        avD.put("ali_047", "哭着跑");
        avD.put("ali_048", "阿狸侠");
        avD.put("ali_049", "冷死了");
        avD.put("ali_050", "惆怅~");
        avD.put("ali_051", "摸头");
        avD.put("ali_052", "蹭");
        avD.put("ali_053", "打滚");
        avD.put("ali_054", "叩拜");
        avD.put("ali_055", "摸");
        avD.put("ali_056", "数钱");
        avD.put("ali_057", "拖走");
        avD.put("ali_058", "热");
        avD.put("ali_059", "加1");
        avD.put("ali_060", "压力");
        avD.put("ali_061", "表逼我");
        avD.put("ali_062", "人呢");
        avD.put("ali_063", "摇晃");
        avD.put("ali_064", "打地鼠");
        avD.put("ali_065", "这个屌");
        avD.put("ali_066", "恐慌");
        avD.put("ali_067", "晕乎乎");
        avD.put("ali_068", "浮云");
        avD.put("ali_069", "给力");
        avD.put("ali_070", "杯具了");
        avD.put("b01", "微笑");
        avD.put("b02", "帅哥");
        avD.put("b03", "美女");
        avD.put("b04", "老大");
        avD.put("b05", "哈哈哈");
        avD.put("b06", "奸笑");
        avD.put("b07", "傻乐");
        avD.put("b08", "飞吻");
        avD.put("b09", "害羞");
        avD.put("b10", "花痴");
        avD.put("b11", "憧憬");
        avD.put("b12", "你牛");
        avD.put("b13", "鼓掌");
        avD.put("b14", "可爱");
        avD.put("b15", "太委屈");
        avD.put("b16", "大哭");
        avD.put("b17", "泪奔");
        avD.put("b18", "寻死");
        avD.put("b19", "非常惊讶");
        avD.put("b20", "表示疑问");
        avD.put("yz_001", "焦糖舞");
        avD.put("yz_002", "翻滚");
        avD.put("yz_003", "拍屁股做鬼脸");
        avD.put("yz_004", "不");
        avD.put("yz_005", "河蟹掉啦");
        avD.put("yz_006", "哦耶");
        avD.put("yz_007", "我倒");
        avD.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fu(String str) {
        Integer num = avA.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(r.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fv(String str) {
        Integer num = avC.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fw(String str) {
        return avD.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dg() {
        return avB.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0044a y(Context context, String str) {
        return null;
    }
}
