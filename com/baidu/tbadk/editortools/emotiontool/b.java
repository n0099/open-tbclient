package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aBz = new HashMap<>(200);
    public static final ArrayList<Integer> aBA = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aBB = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aBC = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aBC.put("image_emoticon", "呵呵");
        aBC.put("image_emoticon2", "哈哈");
        aBC.put("image_emoticon3", "吐舌");
        aBC.put("image_emoticon4", "啊");
        aBC.put("image_emoticon5", "酷");
        aBC.put("image_emoticon6", "怒");
        aBC.put("image_emoticon7", "开心");
        aBC.put("image_emoticon8", "汗");
        aBC.put("image_emoticon9", "泪");
        aBC.put("image_emoticon10", "黑线");
        aBC.put("image_emoticon11", "鄙视");
        aBC.put("image_emoticon12", "不高兴");
        aBC.put("image_emoticon13", "真棒");
        aBC.put("image_emoticon14", "钱");
        aBC.put("image_emoticon15", "疑问");
        aBC.put("image_emoticon16", "阴险");
        aBC.put("image_emoticon17", "吐");
        aBC.put("image_emoticon18", "咦");
        aBC.put("image_emoticon19", "委屈");
        aBC.put("image_emoticon20", "花心");
        aBC.put("image_emoticon21", "呼~");
        aBC.put("image_emoticon22", "笑眼");
        aBC.put("image_emoticon23", "冷");
        aBC.put("image_emoticon24", "太开心");
        aBC.put("image_emoticon25", "滑稽");
        aBC.put("image_emoticon26", "勉强");
        aBC.put("image_emoticon27", "狂汗");
        aBC.put("image_emoticon28", "乖");
        aBC.put("image_emoticon29", "睡觉");
        aBC.put("image_emoticon30", "惊哭");
        aBC.put("image_emoticon31", "生气");
        aBC.put("image_emoticon32", "惊讶");
        aBC.put("image_emoticon33", "喷");
        aBC.put("image_emoticon34", "爱心");
        aBC.put("image_emoticon35", "心碎");
        aBC.put("image_emoticon36", "玫瑰");
        aBC.put("image_emoticon37", "礼物");
        aBC.put("image_emoticon38", "彩虹");
        aBC.put("image_emoticon39", "星星月亮");
        aBC.put("image_emoticon40", "太阳");
        aBC.put("image_emoticon41", "钱币");
        aBC.put("image_emoticon42", "灯泡");
        aBC.put("image_emoticon43", "茶杯");
        aBC.put("image_emoticon44", "蛋糕");
        aBC.put("image_emoticon45", "音乐");
        aBC.put("image_emoticon46", "haha");
        aBC.put("image_emoticon47", "胜利");
        aBC.put("image_emoticon48", "大拇指");
        aBC.put("image_emoticon49", "弱");
        aBC.put("image_emoticon50", "OK");
        aBC.put("image_emoticon61", "哼");
        aBC.put("image_emoticon62", "吃瓜");
        aBC.put("image_emoticon63", "扔便便");
        aBC.put("image_emoticon64", "惊恐");
        aBC.put("image_emoticon65", "哎呦");
        aBC.put("image_emoticon66", "小乖");
        aBC.put("image_emoticon67", "捂嘴笑");
        aBC.put("image_emoticon68", "你懂的");
        aBC.put("image_emoticon69", "what");
        aBC.put("image_emoticon70", "酸爽");
        aBC.put("image_emoticon71", "呀咩爹");
        aBC.put("image_emoticon72", "笑尿");
        aBC.put("image_emoticon73", "挖鼻");
        aBC.put("image_emoticon74", "犀利");
        aBC.put("image_emoticon75", "小红脸");
        aBC.put("image_emoticon76", "懒得理");
        aBC.put("image_emoticon77", "沙发");
        aBC.put("image_emoticon78", "手纸");
        aBC.put("image_emoticon79", "香蕉");
        aBC.put("image_emoticon80", "便便");
        aBC.put("image_emoticon81", "药丸");
        aBC.put("image_emoticon82", "红领巾");
        aBC.put("image_emoticon83", "蜡烛");
        aBC.put("image_emoticon84", "三道杠");
        aBC.put("ali_001", "赖皮");
        aBC.put("ali_002", "感动");
        aBC.put("ali_003", "十分惊讶");
        aBC.put("ali_004", "怒气");
        aBC.put("ali_005", "哭泣");
        aBC.put("ali_006", "吃惊");
        aBC.put("ali_007", "嘲弄");
        aBC.put("ali_008", "飘过");
        aBC.put("ali_009", "转圈哭");
        aBC.put("ali_010", "神经病");
        aBC.put("ali_011", "揪耳朵");
        aBC.put("ali_012", "惊汗");
        aBC.put("ali_013", "隐身");
        aBC.put("ali_014", "不要嘛");
        aBC.put("ali_015", "遁");
        aBC.put("ali_016", "不公平");
        aBC.put("ali_017", "爬来了");
        aBC.put("ali_018", "蛋花哭");
        aBC.put("ali_019", "温暖");
        aBC.put("ali_020", "点头");
        aBC.put("ali_021", "撒钱");
        aBC.put("ali_022", "献花");
        aBC.put("ali_023", "寒");
        aBC.put("ali_024", "傻笑");
        aBC.put("ali_025", "扭扭");
        aBC.put("ali_026", "疯");
        aBC.put("ali_027", "抓狂");
        aBC.put("ali_028", "抓");
        aBC.put("ali_029", "蜷");
        aBC.put("ali_030", "挠墙");
        aBC.put("ali_031", "狂笑");
        aBC.put("ali_032", "抱枕");
        aBC.put("ali_033", "吼叫");
        aBC.put("ali_034", "嚷");
        aBC.put("ali_035", "唠叨");
        aBC.put("ali_036", "捏脸");
        aBC.put("ali_037", "爆笑");
        aBC.put("ali_038", "郁闷");
        aBC.put("ali_039", "潜水");
        aBC.put("ali_040", "十分开心");
        aBC.put("ali_041", "冷笑话");
        aBC.put("ali_042", "顶！");
        aBC.put("ali_043", "潜");
        aBC.put("ali_044", "画圈圈");
        aBC.put("ali_045", "玩电脑");
        aBC.put("ali_046", "狂吐");
        aBC.put("ali_047", "哭着跑");
        aBC.put("ali_048", "阿狸侠");
        aBC.put("ali_049", "冷死了");
        aBC.put("ali_050", "惆怅~");
        aBC.put("ali_051", "摸头");
        aBC.put("ali_052", "蹭");
        aBC.put("ali_053", "打滚");
        aBC.put("ali_054", "叩拜");
        aBC.put("ali_055", "摸");
        aBC.put("ali_056", "数钱");
        aBC.put("ali_057", "拖走");
        aBC.put("ali_058", "热");
        aBC.put("ali_059", "加1");
        aBC.put("ali_060", "压力");
        aBC.put("ali_061", "表逼我");
        aBC.put("ali_062", "人呢");
        aBC.put("ali_063", "摇晃");
        aBC.put("ali_064", "打地鼠");
        aBC.put("ali_065", "这个屌");
        aBC.put("ali_066", "恐慌");
        aBC.put("ali_067", "晕乎乎");
        aBC.put("ali_068", "浮云");
        aBC.put("ali_069", "给力");
        aBC.put("ali_070", "杯具了");
        aBC.put("b01", "微笑");
        aBC.put("b02", "帅哥");
        aBC.put("b03", "美女");
        aBC.put("b04", "老大");
        aBC.put("b05", "哈哈哈");
        aBC.put("b06", "奸笑");
        aBC.put("b07", "傻乐");
        aBC.put("b08", "飞吻");
        aBC.put("b09", "害羞");
        aBC.put("b10", "花痴");
        aBC.put("b11", "憧憬");
        aBC.put("b12", "你牛");
        aBC.put("b13", "鼓掌");
        aBC.put("b14", "可爱");
        aBC.put("b15", "太委屈");
        aBC.put("b16", "大哭");
        aBC.put("b17", "泪奔");
        aBC.put("b18", "寻死");
        aBC.put("b19", "非常惊讶");
        aBC.put("b20", "表示疑问");
        aBC.put("yz_001", "焦糖舞");
        aBC.put("yz_002", "翻滚");
        aBC.put("yz_003", "拍屁股做鬼脸");
        aBC.put("yz_004", "不");
        aBC.put("yz_005", "河蟹掉啦");
        aBC.put("yz_006", "哦耶");
        aBC.put("yz_007", "我倒");
        aBC.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fz(String str) {
        Integer num = aBz.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fA(String str) {
        Integer num = aBB.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fB(String str) {
        return aBC.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CM() {
        return aBA.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0058a X(Context context, String str) {
        return null;
    }
}
