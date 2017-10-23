package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aBn = new HashMap<>(200);
    public static final ArrayList<Integer> aBo = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aBp = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aBq = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aBq.put("image_emoticon", "呵呵");
        aBq.put("image_emoticon2", "哈哈");
        aBq.put("image_emoticon3", "吐舌");
        aBq.put("image_emoticon4", "啊");
        aBq.put("image_emoticon5", "酷");
        aBq.put("image_emoticon6", "怒");
        aBq.put("image_emoticon7", "开心");
        aBq.put("image_emoticon8", "汗");
        aBq.put("image_emoticon9", "泪");
        aBq.put("image_emoticon10", "黑线");
        aBq.put("image_emoticon11", "鄙视");
        aBq.put("image_emoticon12", "不高兴");
        aBq.put("image_emoticon13", "真棒");
        aBq.put("image_emoticon14", "钱");
        aBq.put("image_emoticon15", "疑问");
        aBq.put("image_emoticon16", "阴险");
        aBq.put("image_emoticon17", "吐");
        aBq.put("image_emoticon18", "咦");
        aBq.put("image_emoticon19", "委屈");
        aBq.put("image_emoticon20", "花心");
        aBq.put("image_emoticon21", "呼~");
        aBq.put("image_emoticon22", "笑眼");
        aBq.put("image_emoticon23", "冷");
        aBq.put("image_emoticon24", "太开心");
        aBq.put("image_emoticon25", "滑稽");
        aBq.put("image_emoticon26", "勉强");
        aBq.put("image_emoticon27", "狂汗");
        aBq.put("image_emoticon28", "乖");
        aBq.put("image_emoticon29", "睡觉");
        aBq.put("image_emoticon30", "惊哭");
        aBq.put("image_emoticon31", "生气");
        aBq.put("image_emoticon32", "惊讶");
        aBq.put("image_emoticon33", "喷");
        aBq.put("image_emoticon34", "爱心");
        aBq.put("image_emoticon35", "心碎");
        aBq.put("image_emoticon36", "玫瑰");
        aBq.put("image_emoticon37", "礼物");
        aBq.put("image_emoticon38", "彩虹");
        aBq.put("image_emoticon39", "星星月亮");
        aBq.put("image_emoticon40", "太阳");
        aBq.put("image_emoticon41", "钱币");
        aBq.put("image_emoticon42", "灯泡");
        aBq.put("image_emoticon43", "茶杯");
        aBq.put("image_emoticon44", "蛋糕");
        aBq.put("image_emoticon45", "音乐");
        aBq.put("image_emoticon46", "haha");
        aBq.put("image_emoticon47", "胜利");
        aBq.put("image_emoticon48", "大拇指");
        aBq.put("image_emoticon49", "弱");
        aBq.put("image_emoticon50", "OK");
        aBq.put("image_emoticon61", "哼");
        aBq.put("image_emoticon62", "吃瓜");
        aBq.put("image_emoticon63", "扔便便");
        aBq.put("image_emoticon64", "惊恐");
        aBq.put("image_emoticon65", "哎呦");
        aBq.put("image_emoticon66", "小乖");
        aBq.put("image_emoticon67", "捂嘴笑");
        aBq.put("image_emoticon68", "你懂的");
        aBq.put("image_emoticon69", "what");
        aBq.put("image_emoticon70", "酸爽");
        aBq.put("image_emoticon71", "呀咩爹");
        aBq.put("image_emoticon72", "笑尿");
        aBq.put("image_emoticon73", "挖鼻");
        aBq.put("image_emoticon74", "犀利");
        aBq.put("image_emoticon75", "小红脸");
        aBq.put("image_emoticon76", "懒得理");
        aBq.put("image_emoticon77", "沙发");
        aBq.put("image_emoticon78", "手纸");
        aBq.put("image_emoticon79", "香蕉");
        aBq.put("image_emoticon80", "便便");
        aBq.put("image_emoticon81", "药丸");
        aBq.put("image_emoticon82", "红领巾");
        aBq.put("image_emoticon83", "蜡烛");
        aBq.put("image_emoticon84", "三道杠");
        aBq.put("ali_001", "赖皮");
        aBq.put("ali_002", "感动");
        aBq.put("ali_003", "十分惊讶");
        aBq.put("ali_004", "怒气");
        aBq.put("ali_005", "哭泣");
        aBq.put("ali_006", "吃惊");
        aBq.put("ali_007", "嘲弄");
        aBq.put("ali_008", "飘过");
        aBq.put("ali_009", "转圈哭");
        aBq.put("ali_010", "神经病");
        aBq.put("ali_011", "揪耳朵");
        aBq.put("ali_012", "惊汗");
        aBq.put("ali_013", "隐身");
        aBq.put("ali_014", "不要嘛");
        aBq.put("ali_015", "遁");
        aBq.put("ali_016", "不公平");
        aBq.put("ali_017", "爬来了");
        aBq.put("ali_018", "蛋花哭");
        aBq.put("ali_019", "温暖");
        aBq.put("ali_020", "点头");
        aBq.put("ali_021", "撒钱");
        aBq.put("ali_022", "献花");
        aBq.put("ali_023", "寒");
        aBq.put("ali_024", "傻笑");
        aBq.put("ali_025", "扭扭");
        aBq.put("ali_026", "疯");
        aBq.put("ali_027", "抓狂");
        aBq.put("ali_028", "抓");
        aBq.put("ali_029", "蜷");
        aBq.put("ali_030", "挠墙");
        aBq.put("ali_031", "狂笑");
        aBq.put("ali_032", "抱枕");
        aBq.put("ali_033", "吼叫");
        aBq.put("ali_034", "嚷");
        aBq.put("ali_035", "唠叨");
        aBq.put("ali_036", "捏脸");
        aBq.put("ali_037", "爆笑");
        aBq.put("ali_038", "郁闷");
        aBq.put("ali_039", "潜水");
        aBq.put("ali_040", "十分开心");
        aBq.put("ali_041", "冷笑话");
        aBq.put("ali_042", "顶！");
        aBq.put("ali_043", "潜");
        aBq.put("ali_044", "画圈圈");
        aBq.put("ali_045", "玩电脑");
        aBq.put("ali_046", "狂吐");
        aBq.put("ali_047", "哭着跑");
        aBq.put("ali_048", "阿狸侠");
        aBq.put("ali_049", "冷死了");
        aBq.put("ali_050", "惆怅~");
        aBq.put("ali_051", "摸头");
        aBq.put("ali_052", "蹭");
        aBq.put("ali_053", "打滚");
        aBq.put("ali_054", "叩拜");
        aBq.put("ali_055", "摸");
        aBq.put("ali_056", "数钱");
        aBq.put("ali_057", "拖走");
        aBq.put("ali_058", "热");
        aBq.put("ali_059", "加1");
        aBq.put("ali_060", "压力");
        aBq.put("ali_061", "表逼我");
        aBq.put("ali_062", "人呢");
        aBq.put("ali_063", "摇晃");
        aBq.put("ali_064", "打地鼠");
        aBq.put("ali_065", "这个屌");
        aBq.put("ali_066", "恐慌");
        aBq.put("ali_067", "晕乎乎");
        aBq.put("ali_068", "浮云");
        aBq.put("ali_069", "给力");
        aBq.put("ali_070", "杯具了");
        aBq.put("b01", "微笑");
        aBq.put("b02", "帅哥");
        aBq.put("b03", "美女");
        aBq.put("b04", "老大");
        aBq.put("b05", "哈哈哈");
        aBq.put("b06", "奸笑");
        aBq.put("b07", "傻乐");
        aBq.put("b08", "飞吻");
        aBq.put("b09", "害羞");
        aBq.put("b10", "花痴");
        aBq.put("b11", "憧憬");
        aBq.put("b12", "你牛");
        aBq.put("b13", "鼓掌");
        aBq.put("b14", "可爱");
        aBq.put("b15", "太委屈");
        aBq.put("b16", "大哭");
        aBq.put("b17", "泪奔");
        aBq.put("b18", "寻死");
        aBq.put("b19", "非常惊讶");
        aBq.put("b20", "表示疑问");
        aBq.put("yz_001", "焦糖舞");
        aBq.put("yz_002", "翻滚");
        aBq.put("yz_003", "拍屁股做鬼脸");
        aBq.put("yz_004", "不");
        aBq.put("yz_005", "河蟹掉啦");
        aBq.put("yz_006", "哦耶");
        aBq.put("yz_007", "我倒");
        aBq.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fy(String str) {
        Integer num = aBn.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fz(String str) {
        Integer num = aBp.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fA(String str) {
        return aBq.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CG() {
        return aBo.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0058a S(Context context, String str) {
        return null;
    }
}
