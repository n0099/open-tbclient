package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.w;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aAC = new HashMap<>(200);
    public static final ArrayList<Integer> aAD = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aAE = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aAF = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aAF.put("image_emoticon", "呵呵");
        aAF.put("image_emoticon2", "哈哈");
        aAF.put("image_emoticon3", "吐舌");
        aAF.put("image_emoticon4", "啊");
        aAF.put("image_emoticon5", "酷");
        aAF.put("image_emoticon6", "怒");
        aAF.put("image_emoticon7", "开心");
        aAF.put("image_emoticon8", "汗");
        aAF.put("image_emoticon9", "泪");
        aAF.put("image_emoticon10", "黑线");
        aAF.put("image_emoticon11", "鄙视");
        aAF.put("image_emoticon12", "不高兴");
        aAF.put("image_emoticon13", "真棒");
        aAF.put("image_emoticon14", "钱");
        aAF.put("image_emoticon15", "疑问");
        aAF.put("image_emoticon16", "阴险");
        aAF.put("image_emoticon17", "吐");
        aAF.put("image_emoticon18", "咦");
        aAF.put("image_emoticon19", "委屈");
        aAF.put("image_emoticon20", "花心");
        aAF.put("image_emoticon21", "呼~");
        aAF.put("image_emoticon22", "笑眼");
        aAF.put("image_emoticon23", "冷");
        aAF.put("image_emoticon24", "太开心");
        aAF.put("image_emoticon25", "滑稽");
        aAF.put("image_emoticon26", "勉强");
        aAF.put("image_emoticon27", "狂汗");
        aAF.put("image_emoticon28", "乖");
        aAF.put("image_emoticon29", "睡觉");
        aAF.put("image_emoticon30", "惊哭");
        aAF.put("image_emoticon31", "生气");
        aAF.put("image_emoticon32", "惊讶");
        aAF.put("image_emoticon33", "喷");
        aAF.put("image_emoticon34", "爱心");
        aAF.put("image_emoticon35", "心碎");
        aAF.put("image_emoticon36", "玫瑰");
        aAF.put("image_emoticon37", "礼物");
        aAF.put("image_emoticon38", "彩虹");
        aAF.put("image_emoticon39", "星星月亮");
        aAF.put("image_emoticon40", "太阳");
        aAF.put("image_emoticon41", "钱币");
        aAF.put("image_emoticon42", "灯泡");
        aAF.put("image_emoticon43", "茶杯");
        aAF.put("image_emoticon44", "蛋糕");
        aAF.put("image_emoticon45", "音乐");
        aAF.put("image_emoticon46", "haha");
        aAF.put("image_emoticon47", "胜利");
        aAF.put("image_emoticon48", "大拇指");
        aAF.put("image_emoticon49", "弱");
        aAF.put("image_emoticon50", "OK");
        aAF.put("image_emoticon61", "哼");
        aAF.put("image_emoticon62", "吃瓜");
        aAF.put("image_emoticon63", "扔便便");
        aAF.put("image_emoticon64", "惊恐");
        aAF.put("image_emoticon65", "哎呦");
        aAF.put("image_emoticon66", "小乖");
        aAF.put("image_emoticon67", "捂嘴笑");
        aAF.put("image_emoticon68", "你懂的");
        aAF.put("image_emoticon69", "what");
        aAF.put("image_emoticon70", "酸爽");
        aAF.put("image_emoticon71", "呀咩爹");
        aAF.put("image_emoticon72", "笑尿");
        aAF.put("image_emoticon73", "挖鼻");
        aAF.put("image_emoticon74", "犀利");
        aAF.put("image_emoticon75", "小红脸");
        aAF.put("image_emoticon76", "懒得理");
        aAF.put("image_emoticon77", "沙发");
        aAF.put("image_emoticon78", "手纸");
        aAF.put("image_emoticon79", "香蕉");
        aAF.put("image_emoticon80", "便便");
        aAF.put("image_emoticon81", "药丸");
        aAF.put("image_emoticon82", "红领巾");
        aAF.put("image_emoticon83", "蜡烛");
        aAF.put("image_emoticon84", "三道杠");
        aAF.put("ali_001", "赖皮");
        aAF.put("ali_002", "感动");
        aAF.put("ali_003", "十分惊讶");
        aAF.put("ali_004", "怒气");
        aAF.put("ali_005", "哭泣");
        aAF.put("ali_006", "吃惊");
        aAF.put("ali_007", "嘲弄");
        aAF.put("ali_008", "飘过");
        aAF.put("ali_009", "转圈哭");
        aAF.put("ali_010", "神经病");
        aAF.put("ali_011", "揪耳朵");
        aAF.put("ali_012", "惊汗");
        aAF.put("ali_013", "隐身");
        aAF.put("ali_014", "不要嘛");
        aAF.put("ali_015", "遁");
        aAF.put("ali_016", "不公平");
        aAF.put("ali_017", "爬来了");
        aAF.put("ali_018", "蛋花哭");
        aAF.put("ali_019", "温暖");
        aAF.put("ali_020", "点头");
        aAF.put("ali_021", "撒钱");
        aAF.put("ali_022", "献花");
        aAF.put("ali_023", "寒");
        aAF.put("ali_024", "傻笑");
        aAF.put("ali_025", "扭扭");
        aAF.put("ali_026", "疯");
        aAF.put("ali_027", "抓狂");
        aAF.put("ali_028", "抓");
        aAF.put("ali_029", "蜷");
        aAF.put("ali_030", "挠墙");
        aAF.put("ali_031", "狂笑");
        aAF.put("ali_032", "抱枕");
        aAF.put("ali_033", "吼叫");
        aAF.put("ali_034", "嚷");
        aAF.put("ali_035", "唠叨");
        aAF.put("ali_036", "捏脸");
        aAF.put("ali_037", "爆笑");
        aAF.put("ali_038", "郁闷");
        aAF.put("ali_039", "潜水");
        aAF.put("ali_040", "十分开心");
        aAF.put("ali_041", "冷笑话");
        aAF.put("ali_042", "顶！");
        aAF.put("ali_043", "潜");
        aAF.put("ali_044", "画圈圈");
        aAF.put("ali_045", "玩电脑");
        aAF.put("ali_046", "狂吐");
        aAF.put("ali_047", "哭着跑");
        aAF.put("ali_048", "阿狸侠");
        aAF.put("ali_049", "冷死了");
        aAF.put("ali_050", "惆怅~");
        aAF.put("ali_051", "摸头");
        aAF.put("ali_052", "蹭");
        aAF.put("ali_053", "打滚");
        aAF.put("ali_054", "叩拜");
        aAF.put("ali_055", "摸");
        aAF.put("ali_056", "数钱");
        aAF.put("ali_057", "拖走");
        aAF.put("ali_058", "热");
        aAF.put("ali_059", "加1");
        aAF.put("ali_060", "压力");
        aAF.put("ali_061", "表逼我");
        aAF.put("ali_062", "人呢");
        aAF.put("ali_063", "摇晃");
        aAF.put("ali_064", "打地鼠");
        aAF.put("ali_065", "这个屌");
        aAF.put("ali_066", "恐慌");
        aAF.put("ali_067", "晕乎乎");
        aAF.put("ali_068", "浮云");
        aAF.put("ali_069", "给力");
        aAF.put("ali_070", "杯具了");
        aAF.put("b01", "微笑");
        aAF.put("b02", "帅哥");
        aAF.put("b03", "美女");
        aAF.put("b04", "老大");
        aAF.put("b05", "哈哈哈");
        aAF.put("b06", "奸笑");
        aAF.put("b07", "傻乐");
        aAF.put("b08", "飞吻");
        aAF.put("b09", "害羞");
        aAF.put("b10", "花痴");
        aAF.put("b11", "憧憬");
        aAF.put("b12", "你牛");
        aAF.put("b13", "鼓掌");
        aAF.put("b14", "可爱");
        aAF.put("b15", "太委屈");
        aAF.put("b16", "大哭");
        aAF.put("b17", "泪奔");
        aAF.put("b18", "寻死");
        aAF.put("b19", "非常惊讶");
        aAF.put("b20", "表示疑问");
        aAF.put("yz_001", "焦糖舞");
        aAF.put("yz_002", "翻滚");
        aAF.put("yz_003", "拍屁股做鬼脸");
        aAF.put("yz_004", "不");
        aAF.put("yz_005", "河蟹掉啦");
        aAF.put("yz_006", "哦耶");
        aAF.put("yz_007", "我倒");
        aAF.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fx(String str) {
        Integer num = aAC.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(w.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fy(String str) {
        Integer num = aAE.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fz(String str) {
        return aAF.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CT() {
        return aAD.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0047a X(Context context, String str) {
        return null;
    }
}
