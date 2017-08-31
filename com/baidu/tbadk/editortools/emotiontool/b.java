package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCi = new HashMap<>(200);
    public static final ArrayList<Integer> aCj = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCk = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCl = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCl.put("image_emoticon", "呵呵");
        aCl.put("image_emoticon2", "哈哈");
        aCl.put("image_emoticon3", "吐舌");
        aCl.put("image_emoticon4", "啊");
        aCl.put("image_emoticon5", "酷");
        aCl.put("image_emoticon6", "怒");
        aCl.put("image_emoticon7", "开心");
        aCl.put("image_emoticon8", "汗");
        aCl.put("image_emoticon9", "泪");
        aCl.put("image_emoticon10", "黑线");
        aCl.put("image_emoticon11", "鄙视");
        aCl.put("image_emoticon12", "不高兴");
        aCl.put("image_emoticon13", "真棒");
        aCl.put("image_emoticon14", "钱");
        aCl.put("image_emoticon15", "疑问");
        aCl.put("image_emoticon16", "阴险");
        aCl.put("image_emoticon17", "吐");
        aCl.put("image_emoticon18", "咦");
        aCl.put("image_emoticon19", "委屈");
        aCl.put("image_emoticon20", "花心");
        aCl.put("image_emoticon21", "呼~");
        aCl.put("image_emoticon22", "笑眼");
        aCl.put("image_emoticon23", "冷");
        aCl.put("image_emoticon24", "太开心");
        aCl.put("image_emoticon25", "滑稽");
        aCl.put("image_emoticon26", "勉强");
        aCl.put("image_emoticon27", "狂汗");
        aCl.put("image_emoticon28", "乖");
        aCl.put("image_emoticon29", "睡觉");
        aCl.put("image_emoticon30", "惊哭");
        aCl.put("image_emoticon31", "生气");
        aCl.put("image_emoticon32", "惊讶");
        aCl.put("image_emoticon33", "喷");
        aCl.put("image_emoticon34", "爱心");
        aCl.put("image_emoticon35", "心碎");
        aCl.put("image_emoticon36", "玫瑰");
        aCl.put("image_emoticon37", "礼物");
        aCl.put("image_emoticon38", "彩虹");
        aCl.put("image_emoticon39", "星星月亮");
        aCl.put("image_emoticon40", "太阳");
        aCl.put("image_emoticon41", "钱币");
        aCl.put("image_emoticon42", "灯泡");
        aCl.put("image_emoticon43", "茶杯");
        aCl.put("image_emoticon44", "蛋糕");
        aCl.put("image_emoticon45", "音乐");
        aCl.put("image_emoticon46", "haha");
        aCl.put("image_emoticon47", "胜利");
        aCl.put("image_emoticon48", "大拇指");
        aCl.put("image_emoticon49", "弱");
        aCl.put("image_emoticon50", "OK");
        aCl.put("image_emoticon61", "哼");
        aCl.put("image_emoticon62", "吃瓜");
        aCl.put("image_emoticon63", "扔便便");
        aCl.put("image_emoticon64", "惊恐");
        aCl.put("image_emoticon65", "哎呦");
        aCl.put("image_emoticon66", "小乖");
        aCl.put("image_emoticon67", "捂嘴笑");
        aCl.put("image_emoticon68", "你懂的");
        aCl.put("image_emoticon69", "what");
        aCl.put("image_emoticon70", "酸爽");
        aCl.put("image_emoticon71", "呀咩爹");
        aCl.put("image_emoticon72", "笑尿");
        aCl.put("image_emoticon73", "挖鼻");
        aCl.put("image_emoticon74", "犀利");
        aCl.put("image_emoticon75", "小红脸");
        aCl.put("image_emoticon76", "懒得理");
        aCl.put("image_emoticon77", "沙发");
        aCl.put("image_emoticon78", "手纸");
        aCl.put("image_emoticon79", "香蕉");
        aCl.put("image_emoticon80", "便便");
        aCl.put("image_emoticon81", "药丸");
        aCl.put("image_emoticon82", "红领巾");
        aCl.put("image_emoticon83", "蜡烛");
        aCl.put("image_emoticon84", "三道杠");
        aCl.put("ali_001", "赖皮");
        aCl.put("ali_002", "感动");
        aCl.put("ali_003", "十分惊讶");
        aCl.put("ali_004", "怒气");
        aCl.put("ali_005", "哭泣");
        aCl.put("ali_006", "吃惊");
        aCl.put("ali_007", "嘲弄");
        aCl.put("ali_008", "飘过");
        aCl.put("ali_009", "转圈哭");
        aCl.put("ali_010", "神经病");
        aCl.put("ali_011", "揪耳朵");
        aCl.put("ali_012", "惊汗");
        aCl.put("ali_013", "隐身");
        aCl.put("ali_014", "不要嘛");
        aCl.put("ali_015", "遁");
        aCl.put("ali_016", "不公平");
        aCl.put("ali_017", "爬来了");
        aCl.put("ali_018", "蛋花哭");
        aCl.put("ali_019", "温暖");
        aCl.put("ali_020", "点头");
        aCl.put("ali_021", "撒钱");
        aCl.put("ali_022", "献花");
        aCl.put("ali_023", "寒");
        aCl.put("ali_024", "傻笑");
        aCl.put("ali_025", "扭扭");
        aCl.put("ali_026", "疯");
        aCl.put("ali_027", "抓狂");
        aCl.put("ali_028", "抓");
        aCl.put("ali_029", "蜷");
        aCl.put("ali_030", "挠墙");
        aCl.put("ali_031", "狂笑");
        aCl.put("ali_032", "抱枕");
        aCl.put("ali_033", "吼叫");
        aCl.put("ali_034", "嚷");
        aCl.put("ali_035", "唠叨");
        aCl.put("ali_036", "捏脸");
        aCl.put("ali_037", "爆笑");
        aCl.put("ali_038", "郁闷");
        aCl.put("ali_039", "潜水");
        aCl.put("ali_040", "十分开心");
        aCl.put("ali_041", "冷笑话");
        aCl.put("ali_042", "顶！");
        aCl.put("ali_043", "潜");
        aCl.put("ali_044", "画圈圈");
        aCl.put("ali_045", "玩电脑");
        aCl.put("ali_046", "狂吐");
        aCl.put("ali_047", "哭着跑");
        aCl.put("ali_048", "阿狸侠");
        aCl.put("ali_049", "冷死了");
        aCl.put("ali_050", "惆怅~");
        aCl.put("ali_051", "摸头");
        aCl.put("ali_052", "蹭");
        aCl.put("ali_053", "打滚");
        aCl.put("ali_054", "叩拜");
        aCl.put("ali_055", "摸");
        aCl.put("ali_056", "数钱");
        aCl.put("ali_057", "拖走");
        aCl.put("ali_058", "热");
        aCl.put("ali_059", "加1");
        aCl.put("ali_060", "压力");
        aCl.put("ali_061", "表逼我");
        aCl.put("ali_062", "人呢");
        aCl.put("ali_063", "摇晃");
        aCl.put("ali_064", "打地鼠");
        aCl.put("ali_065", "这个屌");
        aCl.put("ali_066", "恐慌");
        aCl.put("ali_067", "晕乎乎");
        aCl.put("ali_068", "浮云");
        aCl.put("ali_069", "给力");
        aCl.put("ali_070", "杯具了");
        aCl.put("b01", "微笑");
        aCl.put("b02", "帅哥");
        aCl.put("b03", "美女");
        aCl.put("b04", "老大");
        aCl.put("b05", "哈哈哈");
        aCl.put("b06", "奸笑");
        aCl.put("b07", "傻乐");
        aCl.put("b08", "飞吻");
        aCl.put("b09", "害羞");
        aCl.put("b10", "花痴");
        aCl.put("b11", "憧憬");
        aCl.put("b12", "你牛");
        aCl.put("b13", "鼓掌");
        aCl.put("b14", "可爱");
        aCl.put("b15", "太委屈");
        aCl.put("b16", "大哭");
        aCl.put("b17", "泪奔");
        aCl.put("b18", "寻死");
        aCl.put("b19", "非常惊讶");
        aCl.put("b20", "表示疑问");
        aCl.put("yz_001", "焦糖舞");
        aCl.put("yz_002", "翻滚");
        aCl.put("yz_003", "拍屁股做鬼脸");
        aCl.put("yz_004", "不");
        aCl.put("yz_005", "河蟹掉啦");
        aCl.put("yz_006", "哦耶");
        aCl.put("yz_007", "我倒");
        aCl.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fG(String str) {
        Integer num = aCi.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fH(String str) {
        Integer num = aCk.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fI(String str) {
        return aCl.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Di() {
        return aCj.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0060a X(Context context, String str) {
        return null;
    }
}
