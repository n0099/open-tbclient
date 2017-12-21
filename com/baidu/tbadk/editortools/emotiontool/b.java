package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCP = new HashMap<>(200);
    public static final ArrayList<Integer> aCQ = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCR = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCS = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCS.put("image_emoticon", "呵呵");
        aCS.put("image_emoticon2", "哈哈");
        aCS.put("image_emoticon3", "吐舌");
        aCS.put("image_emoticon4", "啊");
        aCS.put("image_emoticon5", "酷");
        aCS.put("image_emoticon6", "怒");
        aCS.put("image_emoticon7", "开心");
        aCS.put("image_emoticon8", "汗");
        aCS.put("image_emoticon9", "泪");
        aCS.put("image_emoticon10", "黑线");
        aCS.put("image_emoticon11", "鄙视");
        aCS.put("image_emoticon12", "不高兴");
        aCS.put("image_emoticon13", "真棒");
        aCS.put("image_emoticon14", "钱");
        aCS.put("image_emoticon15", "疑问");
        aCS.put("image_emoticon16", "阴险");
        aCS.put("image_emoticon17", "吐");
        aCS.put("image_emoticon18", "咦");
        aCS.put("image_emoticon19", "委屈");
        aCS.put("image_emoticon20", "花心");
        aCS.put("image_emoticon21", "呼~");
        aCS.put("image_emoticon22", "笑眼");
        aCS.put("image_emoticon23", "冷");
        aCS.put("image_emoticon24", "太开心");
        aCS.put("image_emoticon25", "滑稽");
        aCS.put("image_emoticon26", "勉强");
        aCS.put("image_emoticon27", "狂汗");
        aCS.put("image_emoticon28", "乖");
        aCS.put("image_emoticon29", "睡觉");
        aCS.put("image_emoticon30", "惊哭");
        aCS.put("image_emoticon31", "生气");
        aCS.put("image_emoticon32", "惊讶");
        aCS.put("image_emoticon33", "喷");
        aCS.put("image_emoticon34", "爱心");
        aCS.put("image_emoticon35", "心碎");
        aCS.put("image_emoticon36", "玫瑰");
        aCS.put("image_emoticon37", "礼物");
        aCS.put("image_emoticon38", "彩虹");
        aCS.put("image_emoticon39", "星星月亮");
        aCS.put("image_emoticon40", "太阳");
        aCS.put("image_emoticon41", "钱币");
        aCS.put("image_emoticon42", "灯泡");
        aCS.put("image_emoticon43", "茶杯");
        aCS.put("image_emoticon44", "蛋糕");
        aCS.put("image_emoticon45", "音乐");
        aCS.put("image_emoticon46", "haha");
        aCS.put("image_emoticon47", "胜利");
        aCS.put("image_emoticon48", "大拇指");
        aCS.put("image_emoticon49", "弱");
        aCS.put("image_emoticon50", "OK");
        aCS.put("image_emoticon61", "哼");
        aCS.put("image_emoticon62", "吃瓜");
        aCS.put("image_emoticon63", "扔便便");
        aCS.put("image_emoticon64", "惊恐");
        aCS.put("image_emoticon65", "哎呦");
        aCS.put("image_emoticon66", "小乖");
        aCS.put("image_emoticon67", "捂嘴笑");
        aCS.put("image_emoticon68", "你懂的");
        aCS.put("image_emoticon69", "what");
        aCS.put("image_emoticon70", "酸爽");
        aCS.put("image_emoticon71", "呀咩爹");
        aCS.put("image_emoticon72", "笑尿");
        aCS.put("image_emoticon73", "挖鼻");
        aCS.put("image_emoticon74", "犀利");
        aCS.put("image_emoticon75", "小红脸");
        aCS.put("image_emoticon76", "懒得理");
        aCS.put("image_emoticon77", "沙发");
        aCS.put("image_emoticon78", "手纸");
        aCS.put("image_emoticon79", "香蕉");
        aCS.put("image_emoticon80", "便便");
        aCS.put("image_emoticon81", "药丸");
        aCS.put("image_emoticon82", "红领巾");
        aCS.put("image_emoticon83", "蜡烛");
        aCS.put("image_emoticon84", "三道杠");
        aCS.put("ali_001", "赖皮");
        aCS.put("ali_002", "感动");
        aCS.put("ali_003", "十分惊讶");
        aCS.put("ali_004", "怒气");
        aCS.put("ali_005", "哭泣");
        aCS.put("ali_006", "吃惊");
        aCS.put("ali_007", "嘲弄");
        aCS.put("ali_008", "飘过");
        aCS.put("ali_009", "转圈哭");
        aCS.put("ali_010", "神经病");
        aCS.put("ali_011", "揪耳朵");
        aCS.put("ali_012", "惊汗");
        aCS.put("ali_013", "隐身");
        aCS.put("ali_014", "不要嘛");
        aCS.put("ali_015", "遁");
        aCS.put("ali_016", "不公平");
        aCS.put("ali_017", "爬来了");
        aCS.put("ali_018", "蛋花哭");
        aCS.put("ali_019", "温暖");
        aCS.put("ali_020", "点头");
        aCS.put("ali_021", "撒钱");
        aCS.put("ali_022", "献花");
        aCS.put("ali_023", "寒");
        aCS.put("ali_024", "傻笑");
        aCS.put("ali_025", "扭扭");
        aCS.put("ali_026", "疯");
        aCS.put("ali_027", "抓狂");
        aCS.put("ali_028", "抓");
        aCS.put("ali_029", "蜷");
        aCS.put("ali_030", "挠墙");
        aCS.put("ali_031", "狂笑");
        aCS.put("ali_032", "抱枕");
        aCS.put("ali_033", "吼叫");
        aCS.put("ali_034", "嚷");
        aCS.put("ali_035", "唠叨");
        aCS.put("ali_036", "捏脸");
        aCS.put("ali_037", "爆笑");
        aCS.put("ali_038", "郁闷");
        aCS.put("ali_039", "潜水");
        aCS.put("ali_040", "十分开心");
        aCS.put("ali_041", "冷笑话");
        aCS.put("ali_042", "顶！");
        aCS.put("ali_043", "潜");
        aCS.put("ali_044", "画圈圈");
        aCS.put("ali_045", "玩电脑");
        aCS.put("ali_046", "狂吐");
        aCS.put("ali_047", "哭着跑");
        aCS.put("ali_048", "阿狸侠");
        aCS.put("ali_049", "冷死了");
        aCS.put("ali_050", "惆怅~");
        aCS.put("ali_051", "摸头");
        aCS.put("ali_052", "蹭");
        aCS.put("ali_053", "打滚");
        aCS.put("ali_054", "叩拜");
        aCS.put("ali_055", "摸");
        aCS.put("ali_056", "数钱");
        aCS.put("ali_057", "拖走");
        aCS.put("ali_058", "热");
        aCS.put("ali_059", "加1");
        aCS.put("ali_060", "压力");
        aCS.put("ali_061", "表逼我");
        aCS.put("ali_062", "人呢");
        aCS.put("ali_063", "摇晃");
        aCS.put("ali_064", "打地鼠");
        aCS.put("ali_065", "这个屌");
        aCS.put("ali_066", "恐慌");
        aCS.put("ali_067", "晕乎乎");
        aCS.put("ali_068", "浮云");
        aCS.put("ali_069", "给力");
        aCS.put("ali_070", "杯具了");
        aCS.put("b01", "微笑");
        aCS.put("b02", "帅哥");
        aCS.put("b03", "美女");
        aCS.put("b04", "老大");
        aCS.put("b05", "哈哈哈");
        aCS.put("b06", "奸笑");
        aCS.put("b07", "傻乐");
        aCS.put("b08", "飞吻");
        aCS.put("b09", "害羞");
        aCS.put("b10", "花痴");
        aCS.put("b11", "憧憬");
        aCS.put("b12", "你牛");
        aCS.put("b13", "鼓掌");
        aCS.put("b14", "可爱");
        aCS.put("b15", "太委屈");
        aCS.put("b16", "大哭");
        aCS.put("b17", "泪奔");
        aCS.put("b18", "寻死");
        aCS.put("b19", "非常惊讶");
        aCS.put("b20", "表示疑问");
        aCS.put("yz_001", "焦糖舞");
        aCS.put("yz_002", "翻滚");
        aCS.put("yz_003", "拍屁股做鬼脸");
        aCS.put("yz_004", "不");
        aCS.put("yz_005", "河蟹掉啦");
        aCS.put("yz_006", "哦耶");
        aCS.put("yz_007", "我倒");
        aCS.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fL(String str) {
        Integer num = aCP.get(str);
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
        Integer num = aCR.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fN(String str) {
        return aCS.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dr() {
        return aCQ.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0071a S(Context context, String str) {
        return null;
    }
}
