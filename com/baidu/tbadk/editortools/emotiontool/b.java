package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aBW = new HashMap<>(200);
    public static final ArrayList<Integer> aBX = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aBY = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aBZ = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aBZ.put("image_emoticon", "呵呵");
        aBZ.put("image_emoticon2", "哈哈");
        aBZ.put("image_emoticon3", "吐舌");
        aBZ.put("image_emoticon4", "啊");
        aBZ.put("image_emoticon5", "酷");
        aBZ.put("image_emoticon6", "怒");
        aBZ.put("image_emoticon7", "开心");
        aBZ.put("image_emoticon8", "汗");
        aBZ.put("image_emoticon9", "泪");
        aBZ.put("image_emoticon10", "黑线");
        aBZ.put("image_emoticon11", "鄙视");
        aBZ.put("image_emoticon12", "不高兴");
        aBZ.put("image_emoticon13", "真棒");
        aBZ.put("image_emoticon14", "钱");
        aBZ.put("image_emoticon15", "疑问");
        aBZ.put("image_emoticon16", "阴险");
        aBZ.put("image_emoticon17", "吐");
        aBZ.put("image_emoticon18", "咦");
        aBZ.put("image_emoticon19", "委屈");
        aBZ.put("image_emoticon20", "花心");
        aBZ.put("image_emoticon21", "呼~");
        aBZ.put("image_emoticon22", "笑眼");
        aBZ.put("image_emoticon23", "冷");
        aBZ.put("image_emoticon24", "太开心");
        aBZ.put("image_emoticon25", "滑稽");
        aBZ.put("image_emoticon26", "勉强");
        aBZ.put("image_emoticon27", "狂汗");
        aBZ.put("image_emoticon28", "乖");
        aBZ.put("image_emoticon29", "睡觉");
        aBZ.put("image_emoticon30", "惊哭");
        aBZ.put("image_emoticon31", "生气");
        aBZ.put("image_emoticon32", "惊讶");
        aBZ.put("image_emoticon33", "喷");
        aBZ.put("image_emoticon34", "爱心");
        aBZ.put("image_emoticon35", "心碎");
        aBZ.put("image_emoticon36", "玫瑰");
        aBZ.put("image_emoticon37", "礼物");
        aBZ.put("image_emoticon38", "彩虹");
        aBZ.put("image_emoticon39", "星星月亮");
        aBZ.put("image_emoticon40", "太阳");
        aBZ.put("image_emoticon41", "钱币");
        aBZ.put("image_emoticon42", "灯泡");
        aBZ.put("image_emoticon43", "茶杯");
        aBZ.put("image_emoticon44", "蛋糕");
        aBZ.put("image_emoticon45", "音乐");
        aBZ.put("image_emoticon46", "haha");
        aBZ.put("image_emoticon47", "胜利");
        aBZ.put("image_emoticon48", "大拇指");
        aBZ.put("image_emoticon49", "弱");
        aBZ.put("image_emoticon50", "OK");
        aBZ.put("image_emoticon61", "哼");
        aBZ.put("image_emoticon62", "吃瓜");
        aBZ.put("image_emoticon63", "扔便便");
        aBZ.put("image_emoticon64", "惊恐");
        aBZ.put("image_emoticon65", "哎呦");
        aBZ.put("image_emoticon66", "小乖");
        aBZ.put("image_emoticon67", "捂嘴笑");
        aBZ.put("image_emoticon68", "你懂的");
        aBZ.put("image_emoticon69", "what");
        aBZ.put("image_emoticon70", "酸爽");
        aBZ.put("image_emoticon71", "呀咩爹");
        aBZ.put("image_emoticon72", "笑尿");
        aBZ.put("image_emoticon73", "挖鼻");
        aBZ.put("image_emoticon74", "犀利");
        aBZ.put("image_emoticon75", "小红脸");
        aBZ.put("image_emoticon76", "懒得理");
        aBZ.put("image_emoticon77", "沙发");
        aBZ.put("image_emoticon78", "手纸");
        aBZ.put("image_emoticon79", "香蕉");
        aBZ.put("image_emoticon80", "便便");
        aBZ.put("image_emoticon81", "药丸");
        aBZ.put("image_emoticon82", "红领巾");
        aBZ.put("image_emoticon83", "蜡烛");
        aBZ.put("image_emoticon84", "三道杠");
        aBZ.put("ali_001", "赖皮");
        aBZ.put("ali_002", "感动");
        aBZ.put("ali_003", "十分惊讶");
        aBZ.put("ali_004", "怒气");
        aBZ.put("ali_005", "哭泣");
        aBZ.put("ali_006", "吃惊");
        aBZ.put("ali_007", "嘲弄");
        aBZ.put("ali_008", "飘过");
        aBZ.put("ali_009", "转圈哭");
        aBZ.put("ali_010", "神经病");
        aBZ.put("ali_011", "揪耳朵");
        aBZ.put("ali_012", "惊汗");
        aBZ.put("ali_013", "隐身");
        aBZ.put("ali_014", "不要嘛");
        aBZ.put("ali_015", "遁");
        aBZ.put("ali_016", "不公平");
        aBZ.put("ali_017", "爬来了");
        aBZ.put("ali_018", "蛋花哭");
        aBZ.put("ali_019", "温暖");
        aBZ.put("ali_020", "点头");
        aBZ.put("ali_021", "撒钱");
        aBZ.put("ali_022", "献花");
        aBZ.put("ali_023", "寒");
        aBZ.put("ali_024", "傻笑");
        aBZ.put("ali_025", "扭扭");
        aBZ.put("ali_026", "疯");
        aBZ.put("ali_027", "抓狂");
        aBZ.put("ali_028", "抓");
        aBZ.put("ali_029", "蜷");
        aBZ.put("ali_030", "挠墙");
        aBZ.put("ali_031", "狂笑");
        aBZ.put("ali_032", "抱枕");
        aBZ.put("ali_033", "吼叫");
        aBZ.put("ali_034", "嚷");
        aBZ.put("ali_035", "唠叨");
        aBZ.put("ali_036", "捏脸");
        aBZ.put("ali_037", "爆笑");
        aBZ.put("ali_038", "郁闷");
        aBZ.put("ali_039", "潜水");
        aBZ.put("ali_040", "十分开心");
        aBZ.put("ali_041", "冷笑话");
        aBZ.put("ali_042", "顶！");
        aBZ.put("ali_043", "潜");
        aBZ.put("ali_044", "画圈圈");
        aBZ.put("ali_045", "玩电脑");
        aBZ.put("ali_046", "狂吐");
        aBZ.put("ali_047", "哭着跑");
        aBZ.put("ali_048", "阿狸侠");
        aBZ.put("ali_049", "冷死了");
        aBZ.put("ali_050", "惆怅~");
        aBZ.put("ali_051", "摸头");
        aBZ.put("ali_052", "蹭");
        aBZ.put("ali_053", "打滚");
        aBZ.put("ali_054", "叩拜");
        aBZ.put("ali_055", "摸");
        aBZ.put("ali_056", "数钱");
        aBZ.put("ali_057", "拖走");
        aBZ.put("ali_058", "热");
        aBZ.put("ali_059", "加1");
        aBZ.put("ali_060", "压力");
        aBZ.put("ali_061", "表逼我");
        aBZ.put("ali_062", "人呢");
        aBZ.put("ali_063", "摇晃");
        aBZ.put("ali_064", "打地鼠");
        aBZ.put("ali_065", "这个屌");
        aBZ.put("ali_066", "恐慌");
        aBZ.put("ali_067", "晕乎乎");
        aBZ.put("ali_068", "浮云");
        aBZ.put("ali_069", "给力");
        aBZ.put("ali_070", "杯具了");
        aBZ.put("b01", "微笑");
        aBZ.put("b02", "帅哥");
        aBZ.put("b03", "美女");
        aBZ.put("b04", "老大");
        aBZ.put("b05", "哈哈哈");
        aBZ.put("b06", "奸笑");
        aBZ.put("b07", "傻乐");
        aBZ.put("b08", "飞吻");
        aBZ.put("b09", "害羞");
        aBZ.put("b10", "花痴");
        aBZ.put("b11", "憧憬");
        aBZ.put("b12", "你牛");
        aBZ.put("b13", "鼓掌");
        aBZ.put("b14", "可爱");
        aBZ.put("b15", "太委屈");
        aBZ.put("b16", "大哭");
        aBZ.put("b17", "泪奔");
        aBZ.put("b18", "寻死");
        aBZ.put("b19", "非常惊讶");
        aBZ.put("b20", "表示疑问");
        aBZ.put("yz_001", "焦糖舞");
        aBZ.put("yz_002", "翻滚");
        aBZ.put("yz_003", "拍屁股做鬼脸");
        aBZ.put("yz_004", "不");
        aBZ.put("yz_005", "河蟹掉啦");
        aBZ.put("yz_006", "哦耶");
        aBZ.put("yz_007", "我倒");
        aBZ.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fF(String str) {
        Integer num = aBW.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fG(String str) {
        Integer num = aBY.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fH(String str) {
        return aBZ.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CU() {
        return aBX.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0058a S(Context context, String str) {
        return null;
    }
}
