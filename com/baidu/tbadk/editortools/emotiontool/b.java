package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> arW = new HashMap<>();
    public static final ArrayList<Integer> arX = new ArrayList<>();
    public static final HashMap<String, Integer> arY = new HashMap<>();
    private static final HashMap<String, String> arZ = new HashMap<>();

    static {
        arZ.put("image_emoticon", "呵呵");
        arZ.put("image_emoticon2", "哈哈");
        arZ.put("image_emoticon3", "吐舌");
        arZ.put("image_emoticon4", "啊");
        arZ.put("image_emoticon5", "酷");
        arZ.put("image_emoticon6", "怒");
        arZ.put("image_emoticon7", "开心");
        arZ.put("image_emoticon8", "汗");
        arZ.put("image_emoticon9", "泪");
        arZ.put("image_emoticon10", "黑线");
        arZ.put("image_emoticon11", "鄙视");
        arZ.put("image_emoticon12", "不高兴");
        arZ.put("image_emoticon13", "真棒");
        arZ.put("image_emoticon14", "钱");
        arZ.put("image_emoticon15", "疑问");
        arZ.put("image_emoticon16", "阴险");
        arZ.put("image_emoticon17", "吐");
        arZ.put("image_emoticon18", "咦");
        arZ.put("image_emoticon19", "委屈");
        arZ.put("image_emoticon20", "花心");
        arZ.put("image_emoticon21", "呼~");
        arZ.put("image_emoticon22", "笑眼");
        arZ.put("image_emoticon23", "冷");
        arZ.put("image_emoticon24", "太开心");
        arZ.put("image_emoticon25", "滑稽");
        arZ.put("image_emoticon26", "勉强");
        arZ.put("image_emoticon27", "狂汗");
        arZ.put("image_emoticon28", "乖");
        arZ.put("image_emoticon29", "睡觉");
        arZ.put("image_emoticon30", "惊哭");
        arZ.put("image_emoticon31", "生气");
        arZ.put("image_emoticon32", "惊讶");
        arZ.put("image_emoticon33", "喷");
        arZ.put("image_emoticon34", "爱心");
        arZ.put("image_emoticon35", "心碎");
        arZ.put("image_emoticon36", "玫瑰");
        arZ.put("image_emoticon37", "礼物");
        arZ.put("image_emoticon38", "彩虹");
        arZ.put("image_emoticon39", "星星月亮");
        arZ.put("image_emoticon40", "太阳");
        arZ.put("image_emoticon41", "钱币");
        arZ.put("image_emoticon42", "灯泡");
        arZ.put("image_emoticon43", "茶杯");
        arZ.put("image_emoticon44", "蛋糕");
        arZ.put("image_emoticon45", "音乐");
        arZ.put("image_emoticon46", "haha");
        arZ.put("image_emoticon47", "胜利");
        arZ.put("image_emoticon48", "大拇指");
        arZ.put("image_emoticon49", "弱");
        arZ.put("image_emoticon50", "OK");
        arZ.put("image_emoticon61", "哼");
        arZ.put("image_emoticon62", "吃瓜");
        arZ.put("image_emoticon63", "扔便便");
        arZ.put("image_emoticon64", "惊恐");
        arZ.put("image_emoticon65", "哎呦");
        arZ.put("image_emoticon66", "小乖");
        arZ.put("image_emoticon67", "捂嘴笑");
        arZ.put("image_emoticon68", "你懂的");
        arZ.put("image_emoticon69", "what");
        arZ.put("image_emoticon70", "酸爽");
        arZ.put("image_emoticon71", "呀咩爹");
        arZ.put("image_emoticon72", "笑尿");
        arZ.put("image_emoticon73", "挖鼻");
        arZ.put("image_emoticon74", "犀利");
        arZ.put("image_emoticon75", "小红脸");
        arZ.put("image_emoticon76", "懒得理");
        arZ.put("image_emoticon77", "沙发");
        arZ.put("image_emoticon78", "手纸");
        arZ.put("image_emoticon79", "香蕉");
        arZ.put("image_emoticon80", "便便");
        arZ.put("image_emoticon81", "药丸");
        arZ.put("image_emoticon82", "红领巾");
        arZ.put("image_emoticon83", "蜡烛");
        arZ.put("image_emoticon84", "三道杠");
        arZ.put("ali_001", "赖皮");
        arZ.put("ali_002", "感动");
        arZ.put("ali_003", "十分惊讶");
        arZ.put("ali_004", "怒气");
        arZ.put("ali_005", "哭泣");
        arZ.put("ali_006", "吃惊");
        arZ.put("ali_007", "嘲弄");
        arZ.put("ali_008", "飘过");
        arZ.put("ali_009", "转圈哭");
        arZ.put("ali_010", "神经病");
        arZ.put("ali_011", "揪耳朵");
        arZ.put("ali_012", "惊汗");
        arZ.put("ali_013", "隐身");
        arZ.put("ali_014", "不要嘛");
        arZ.put("ali_015", "遁");
        arZ.put("ali_016", "不公平");
        arZ.put("ali_017", "爬来了");
        arZ.put("ali_018", "蛋花哭");
        arZ.put("ali_019", "温暖");
        arZ.put("ali_020", "点头");
        arZ.put("ali_021", "撒钱");
        arZ.put("ali_022", "献花");
        arZ.put("ali_023", "寒");
        arZ.put("ali_024", "傻笑");
        arZ.put("ali_025", "扭扭");
        arZ.put("ali_026", "疯");
        arZ.put("ali_027", "抓狂");
        arZ.put("ali_028", "抓");
        arZ.put("ali_029", "蜷");
        arZ.put("ali_030", "挠墙");
        arZ.put("ali_031", "狂笑");
        arZ.put("ali_032", "抱枕");
        arZ.put("ali_033", "吼叫");
        arZ.put("ali_034", "嚷");
        arZ.put("ali_035", "唠叨");
        arZ.put("ali_036", "捏脸");
        arZ.put("ali_037", "爆笑");
        arZ.put("ali_038", "郁闷");
        arZ.put("ali_039", "潜水");
        arZ.put("ali_040", "十分开心");
        arZ.put("ali_041", "冷笑话");
        arZ.put("ali_042", "顶！");
        arZ.put("ali_043", "潜");
        arZ.put("ali_044", "画圈圈");
        arZ.put("ali_045", "玩电脑");
        arZ.put("ali_046", "狂吐");
        arZ.put("ali_047", "哭着跑");
        arZ.put("ali_048", "阿狸侠");
        arZ.put("ali_049", "冷死了");
        arZ.put("ali_050", "惆怅~");
        arZ.put("ali_051", "摸头");
        arZ.put("ali_052", "蹭");
        arZ.put("ali_053", "打滚");
        arZ.put("ali_054", "叩拜");
        arZ.put("ali_055", "摸");
        arZ.put("ali_056", "数钱");
        arZ.put("ali_057", "拖走");
        arZ.put("ali_058", "热");
        arZ.put("ali_059", "加1");
        arZ.put("ali_060", "压力");
        arZ.put("ali_061", "表逼我");
        arZ.put("ali_062", "人呢");
        arZ.put("ali_063", "摇晃");
        arZ.put("ali_064", "打地鼠");
        arZ.put("ali_065", "这个屌");
        arZ.put("ali_066", "恐慌");
        arZ.put("ali_067", "晕乎乎");
        arZ.put("ali_068", "浮云");
        arZ.put("ali_069", "给力");
        arZ.put("ali_070", "杯具了");
        arZ.put("b01", "微笑");
        arZ.put("b02", "帅哥");
        arZ.put("b03", "美女");
        arZ.put("b04", "老大");
        arZ.put("b05", "哈哈哈");
        arZ.put("b06", "奸笑");
        arZ.put("b07", "傻乐");
        arZ.put("b08", "飞吻");
        arZ.put("b09", "害羞");
        arZ.put("b10", "花痴");
        arZ.put("b11", "憧憬");
        arZ.put("b12", "你牛");
        arZ.put("b13", "鼓掌");
        arZ.put("b14", "可爱");
        arZ.put("b15", "太委屈");
        arZ.put("b16", "大哭");
        arZ.put("b17", "泪奔");
        arZ.put("b18", "寻死");
        arZ.put("b19", "非常惊讶");
        arZ.put("b20", "表示疑问");
        arZ.put("yz_001", "焦糖舞");
        arZ.put("yz_002", "翻滚");
        arZ.put("yz_003", "拍屁股做鬼脸");
        arZ.put("yz_004", "不");
        arZ.put("yz_005", "河蟹掉啦");
        arZ.put("yz_006", "哦耶");
        arZ.put("yz_007", "我倒");
        arZ.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fm(String str) {
        Integer num = arW.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(u.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fn(String str) {
        Integer num = arY.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fo(String str) {
        return arZ.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int BD() {
        return arX.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0044a y(Context context, String str) {
        return null;
    }
}
