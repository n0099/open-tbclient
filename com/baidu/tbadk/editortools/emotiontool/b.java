package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> azP = new HashMap<>();
    public static final ArrayList<Integer> azQ = new ArrayList<>();
    public static final HashMap<String, Integer> azR = new HashMap<>();
    private static final HashMap<String, String> azS = new HashMap<>();

    static {
        azS.put("image_emoticon", "呵呵");
        azS.put("image_emoticon2", "哈哈");
        azS.put("image_emoticon3", "吐舌");
        azS.put("image_emoticon4", "啊");
        azS.put("image_emoticon5", "酷");
        azS.put("image_emoticon6", "怒");
        azS.put("image_emoticon7", "开心");
        azS.put("image_emoticon8", "汗");
        azS.put("image_emoticon9", "泪");
        azS.put("image_emoticon10", "黑线");
        azS.put("image_emoticon11", "鄙视");
        azS.put("image_emoticon12", "不高兴");
        azS.put("image_emoticon13", "真棒");
        azS.put("image_emoticon14", "钱");
        azS.put("image_emoticon15", "疑问");
        azS.put("image_emoticon16", "阴险");
        azS.put("image_emoticon17", "吐");
        azS.put("image_emoticon18", "咦");
        azS.put("image_emoticon19", "委屈");
        azS.put("image_emoticon20", "花心");
        azS.put("image_emoticon21", "呼~");
        azS.put("image_emoticon22", "笑眼");
        azS.put("image_emoticon23", "冷");
        azS.put("image_emoticon24", "太开心");
        azS.put("image_emoticon25", "滑稽");
        azS.put("image_emoticon26", "勉强");
        azS.put("image_emoticon27", "狂汗");
        azS.put("image_emoticon28", "乖");
        azS.put("image_emoticon29", "睡觉");
        azS.put("image_emoticon30", "惊哭");
        azS.put("image_emoticon31", "生气");
        azS.put("image_emoticon32", "惊讶");
        azS.put("image_emoticon33", "喷");
        azS.put("image_emoticon34", "爱心");
        azS.put("image_emoticon35", "心碎");
        azS.put("image_emoticon36", "玫瑰");
        azS.put("image_emoticon37", "礼物");
        azS.put("image_emoticon38", "彩虹");
        azS.put("image_emoticon39", "星星月亮");
        azS.put("image_emoticon40", "太阳");
        azS.put("image_emoticon41", "钱币");
        azS.put("image_emoticon42", "灯泡");
        azS.put("image_emoticon43", "茶杯");
        azS.put("image_emoticon44", "蛋糕");
        azS.put("image_emoticon45", "音乐");
        azS.put("image_emoticon46", "haha");
        azS.put("image_emoticon47", "胜利");
        azS.put("image_emoticon48", "大拇指");
        azS.put("image_emoticon49", "弱");
        azS.put("image_emoticon50", "OK");
        azS.put("image_emoticon61", "哼");
        azS.put("image_emoticon62", "吃瓜");
        azS.put("image_emoticon63", "扔便便");
        azS.put("image_emoticon64", "惊恐");
        azS.put("image_emoticon65", "哎呦");
        azS.put("image_emoticon66", "小乖");
        azS.put("image_emoticon67", "捂嘴笑");
        azS.put("image_emoticon68", "你懂的");
        azS.put("image_emoticon69", "what");
        azS.put("image_emoticon70", "酸爽");
        azS.put("image_emoticon71", "呀咩爹");
        azS.put("image_emoticon72", "笑尿");
        azS.put("image_emoticon73", "挖鼻");
        azS.put("image_emoticon74", "犀利");
        azS.put("image_emoticon75", "小红脸");
        azS.put("image_emoticon76", "懒得理");
        azS.put("image_emoticon77", "沙发");
        azS.put("image_emoticon78", "手纸");
        azS.put("image_emoticon79", "香蕉");
        azS.put("image_emoticon80", "便便");
        azS.put("image_emoticon81", "药丸");
        azS.put("image_emoticon82", "红领巾");
        azS.put("image_emoticon83", "蜡烛");
        azS.put("image_emoticon84", "三道杠");
        azS.put("ali_001", "赖皮");
        azS.put("ali_002", "感动");
        azS.put("ali_003", "十分惊讶");
        azS.put("ali_004", "怒气");
        azS.put("ali_005", "哭泣");
        azS.put("ali_006", "吃惊");
        azS.put("ali_007", "嘲弄");
        azS.put("ali_008", "飘过");
        azS.put("ali_009", "转圈哭");
        azS.put("ali_010", "神经病");
        azS.put("ali_011", "揪耳朵");
        azS.put("ali_012", "惊汗");
        azS.put("ali_013", "隐身");
        azS.put("ali_014", "不要嘛");
        azS.put("ali_015", "遁");
        azS.put("ali_016", "不公平");
        azS.put("ali_017", "爬来了");
        azS.put("ali_018", "蛋花哭");
        azS.put("ali_019", "温暖");
        azS.put("ali_020", "点头");
        azS.put("ali_021", "撒钱");
        azS.put("ali_022", "献花");
        azS.put("ali_023", "寒");
        azS.put("ali_024", "傻笑");
        azS.put("ali_025", "扭扭");
        azS.put("ali_026", "疯");
        azS.put("ali_027", "抓狂");
        azS.put("ali_028", "抓");
        azS.put("ali_029", "蜷");
        azS.put("ali_030", "挠墙");
        azS.put("ali_031", "狂笑");
        azS.put("ali_032", "抱枕");
        azS.put("ali_033", "吼叫");
        azS.put("ali_034", "嚷");
        azS.put("ali_035", "唠叨");
        azS.put("ali_036", "捏脸");
        azS.put("ali_037", "爆笑");
        azS.put("ali_038", "郁闷");
        azS.put("ali_039", "潜水");
        azS.put("ali_040", "十分开心");
        azS.put("ali_041", "冷笑话");
        azS.put("ali_042", "顶！");
        azS.put("ali_043", "潜");
        azS.put("ali_044", "画圈圈");
        azS.put("ali_045", "玩电脑");
        azS.put("ali_046", "狂吐");
        azS.put("ali_047", "哭着跑");
        azS.put("ali_048", "阿狸侠");
        azS.put("ali_049", "冷死了");
        azS.put("ali_050", "惆怅~");
        azS.put("ali_051", "摸头");
        azS.put("ali_052", "蹭");
        azS.put("ali_053", "打滚");
        azS.put("ali_054", "叩拜");
        azS.put("ali_055", "摸");
        azS.put("ali_056", "数钱");
        azS.put("ali_057", "拖走");
        azS.put("ali_058", "热");
        azS.put("ali_059", "加1");
        azS.put("ali_060", "压力");
        azS.put("ali_061", "表逼我");
        azS.put("ali_062", "人呢");
        azS.put("ali_063", "摇晃");
        azS.put("ali_064", "打地鼠");
        azS.put("ali_065", "这个屌");
        azS.put("ali_066", "恐慌");
        azS.put("ali_067", "晕乎乎");
        azS.put("ali_068", "浮云");
        azS.put("ali_069", "给力");
        azS.put("ali_070", "杯具了");
        azS.put("b01", "微笑");
        azS.put("b02", "帅哥");
        azS.put("b03", "美女");
        azS.put("b04", "老大");
        azS.put("b05", "哈哈哈");
        azS.put("b06", "奸笑");
        azS.put("b07", "傻乐");
        azS.put("b08", "飞吻");
        azS.put("b09", "害羞");
        azS.put("b10", "花痴");
        azS.put("b11", "憧憬");
        azS.put("b12", "你牛");
        azS.put("b13", "鼓掌");
        azS.put("b14", "可爱");
        azS.put("b15", "太委屈");
        azS.put("b16", "大哭");
        azS.put("b17", "泪奔");
        azS.put("b18", "寻死");
        azS.put("b19", "非常惊讶");
        azS.put("b20", "表示疑问");
        azS.put("yz_001", "焦糖舞");
        azS.put("yz_002", "翻滚");
        azS.put("yz_003", "拍屁股做鬼脸");
        azS.put("yz_004", "不");
        azS.put("yz_005", "河蟹掉啦");
        azS.put("yz_006", "哦耶");
        azS.put("yz_007", "我倒");
        azS.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fi(String str) {
        Integer num = azP.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(w.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fj(String str) {
        Integer num = azR.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fk(String str) {
        return azS.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int DA() {
        return azQ.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0041a W(Context context, String str) {
        return null;
    }
}
