package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCM = new HashMap<>(200);
    public static final ArrayList<Integer> aCN = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCO = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCP = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCP.put("image_emoticon", "呵呵");
        aCP.put("image_emoticon2", "哈哈");
        aCP.put("image_emoticon3", "吐舌");
        aCP.put("image_emoticon4", "啊");
        aCP.put("image_emoticon5", "酷");
        aCP.put("image_emoticon6", "怒");
        aCP.put("image_emoticon7", "开心");
        aCP.put("image_emoticon8", "汗");
        aCP.put("image_emoticon9", "泪");
        aCP.put("image_emoticon10", "黑线");
        aCP.put("image_emoticon11", "鄙视");
        aCP.put("image_emoticon12", "不高兴");
        aCP.put("image_emoticon13", "真棒");
        aCP.put("image_emoticon14", "钱");
        aCP.put("image_emoticon15", "疑问");
        aCP.put("image_emoticon16", "阴险");
        aCP.put("image_emoticon17", "吐");
        aCP.put("image_emoticon18", "咦");
        aCP.put("image_emoticon19", "委屈");
        aCP.put("image_emoticon20", "花心");
        aCP.put("image_emoticon21", "呼~");
        aCP.put("image_emoticon22", "笑眼");
        aCP.put("image_emoticon23", "冷");
        aCP.put("image_emoticon24", "太开心");
        aCP.put("image_emoticon25", "滑稽");
        aCP.put("image_emoticon26", "勉强");
        aCP.put("image_emoticon27", "狂汗");
        aCP.put("image_emoticon28", "乖");
        aCP.put("image_emoticon29", "睡觉");
        aCP.put("image_emoticon30", "惊哭");
        aCP.put("image_emoticon31", "生气");
        aCP.put("image_emoticon32", "惊讶");
        aCP.put("image_emoticon33", "喷");
        aCP.put("image_emoticon34", "爱心");
        aCP.put("image_emoticon35", "心碎");
        aCP.put("image_emoticon36", "玫瑰");
        aCP.put("image_emoticon37", "礼物");
        aCP.put("image_emoticon38", "彩虹");
        aCP.put("image_emoticon39", "星星月亮");
        aCP.put("image_emoticon40", "太阳");
        aCP.put("image_emoticon41", "钱币");
        aCP.put("image_emoticon42", "灯泡");
        aCP.put("image_emoticon43", "茶杯");
        aCP.put("image_emoticon44", "蛋糕");
        aCP.put("image_emoticon45", "音乐");
        aCP.put("image_emoticon46", "haha");
        aCP.put("image_emoticon47", "胜利");
        aCP.put("image_emoticon48", "大拇指");
        aCP.put("image_emoticon49", "弱");
        aCP.put("image_emoticon50", "OK");
        aCP.put("image_emoticon61", "哼");
        aCP.put("image_emoticon62", "吃瓜");
        aCP.put("image_emoticon63", "扔便便");
        aCP.put("image_emoticon64", "惊恐");
        aCP.put("image_emoticon65", "哎呦");
        aCP.put("image_emoticon66", "小乖");
        aCP.put("image_emoticon67", "捂嘴笑");
        aCP.put("image_emoticon68", "你懂的");
        aCP.put("image_emoticon69", "what");
        aCP.put("image_emoticon70", "酸爽");
        aCP.put("image_emoticon71", "呀咩爹");
        aCP.put("image_emoticon72", "笑尿");
        aCP.put("image_emoticon73", "挖鼻");
        aCP.put("image_emoticon74", "犀利");
        aCP.put("image_emoticon75", "小红脸");
        aCP.put("image_emoticon76", "懒得理");
        aCP.put("image_emoticon77", "沙发");
        aCP.put("image_emoticon78", "手纸");
        aCP.put("image_emoticon79", "香蕉");
        aCP.put("image_emoticon80", "便便");
        aCP.put("image_emoticon81", "药丸");
        aCP.put("image_emoticon82", "红领巾");
        aCP.put("image_emoticon83", "蜡烛");
        aCP.put("image_emoticon84", "三道杠");
        aCP.put("ali_001", "赖皮");
        aCP.put("ali_002", "感动");
        aCP.put("ali_003", "十分惊讶");
        aCP.put("ali_004", "怒气");
        aCP.put("ali_005", "哭泣");
        aCP.put("ali_006", "吃惊");
        aCP.put("ali_007", "嘲弄");
        aCP.put("ali_008", "飘过");
        aCP.put("ali_009", "转圈哭");
        aCP.put("ali_010", "神经病");
        aCP.put("ali_011", "揪耳朵");
        aCP.put("ali_012", "惊汗");
        aCP.put("ali_013", "隐身");
        aCP.put("ali_014", "不要嘛");
        aCP.put("ali_015", "遁");
        aCP.put("ali_016", "不公平");
        aCP.put("ali_017", "爬来了");
        aCP.put("ali_018", "蛋花哭");
        aCP.put("ali_019", "温暖");
        aCP.put("ali_020", "点头");
        aCP.put("ali_021", "撒钱");
        aCP.put("ali_022", "献花");
        aCP.put("ali_023", "寒");
        aCP.put("ali_024", "傻笑");
        aCP.put("ali_025", "扭扭");
        aCP.put("ali_026", "疯");
        aCP.put("ali_027", "抓狂");
        aCP.put("ali_028", "抓");
        aCP.put("ali_029", "蜷");
        aCP.put("ali_030", "挠墙");
        aCP.put("ali_031", "狂笑");
        aCP.put("ali_032", "抱枕");
        aCP.put("ali_033", "吼叫");
        aCP.put("ali_034", "嚷");
        aCP.put("ali_035", "唠叨");
        aCP.put("ali_036", "捏脸");
        aCP.put("ali_037", "爆笑");
        aCP.put("ali_038", "郁闷");
        aCP.put("ali_039", "潜水");
        aCP.put("ali_040", "十分开心");
        aCP.put("ali_041", "冷笑话");
        aCP.put("ali_042", "顶！");
        aCP.put("ali_043", "潜");
        aCP.put("ali_044", "画圈圈");
        aCP.put("ali_045", "玩电脑");
        aCP.put("ali_046", "狂吐");
        aCP.put("ali_047", "哭着跑");
        aCP.put("ali_048", "阿狸侠");
        aCP.put("ali_049", "冷死了");
        aCP.put("ali_050", "惆怅~");
        aCP.put("ali_051", "摸头");
        aCP.put("ali_052", "蹭");
        aCP.put("ali_053", "打滚");
        aCP.put("ali_054", "叩拜");
        aCP.put("ali_055", "摸");
        aCP.put("ali_056", "数钱");
        aCP.put("ali_057", "拖走");
        aCP.put("ali_058", "热");
        aCP.put("ali_059", "加1");
        aCP.put("ali_060", "压力");
        aCP.put("ali_061", "表逼我");
        aCP.put("ali_062", "人呢");
        aCP.put("ali_063", "摇晃");
        aCP.put("ali_064", "打地鼠");
        aCP.put("ali_065", "这个屌");
        aCP.put("ali_066", "恐慌");
        aCP.put("ali_067", "晕乎乎");
        aCP.put("ali_068", "浮云");
        aCP.put("ali_069", "给力");
        aCP.put("ali_070", "杯具了");
        aCP.put("b01", "微笑");
        aCP.put("b02", "帅哥");
        aCP.put("b03", "美女");
        aCP.put("b04", "老大");
        aCP.put("b05", "哈哈哈");
        aCP.put("b06", "奸笑");
        aCP.put("b07", "傻乐");
        aCP.put("b08", "飞吻");
        aCP.put("b09", "害羞");
        aCP.put("b10", "花痴");
        aCP.put("b11", "憧憬");
        aCP.put("b12", "你牛");
        aCP.put("b13", "鼓掌");
        aCP.put("b14", "可爱");
        aCP.put("b15", "太委屈");
        aCP.put("b16", "大哭");
        aCP.put("b17", "泪奔");
        aCP.put("b18", "寻死");
        aCP.put("b19", "非常惊讶");
        aCP.put("b20", "表示疑问");
        aCP.put("yz_001", "焦糖舞");
        aCP.put("yz_002", "翻滚");
        aCP.put("yz_003", "拍屁股做鬼脸");
        aCP.put("yz_004", "不");
        aCP.put("yz_005", "河蟹掉啦");
        aCP.put("yz_006", "哦耶");
        aCP.put("yz_007", "我倒");
        aCP.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fL(String str) {
        Integer num = aCM.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fM(String str) {
        Integer num = aCO.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fN(String str) {
        return aCP.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dr() {
        return aCN.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0072a S(Context context, String str) {
        return null;
    }
}
