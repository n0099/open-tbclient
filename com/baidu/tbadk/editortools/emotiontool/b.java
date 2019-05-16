package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> crz = new HashMap<>(200);
    public static final ArrayList<Integer> crA = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> crB = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> crC = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        crC.put("image_emoticon", "呵呵");
        crC.put("image_emoticon2", "哈哈");
        crC.put("image_emoticon3", "吐舌");
        crC.put("image_emoticon4", "啊");
        crC.put("image_emoticon5", "酷");
        crC.put("image_emoticon6", "怒");
        crC.put("image_emoticon7", "开心");
        crC.put("image_emoticon8", "汗");
        crC.put("image_emoticon9", "泪");
        crC.put("image_emoticon10", "黑线");
        crC.put("image_emoticon11", "鄙视");
        crC.put("image_emoticon12", "不高兴");
        crC.put("image_emoticon13", "真棒");
        crC.put("image_emoticon14", "钱");
        crC.put("image_emoticon15", "疑问");
        crC.put("image_emoticon16", "阴险");
        crC.put("image_emoticon17", "吐");
        crC.put("image_emoticon18", "咦");
        crC.put("image_emoticon19", "委屈");
        crC.put("image_emoticon20", "花心");
        crC.put("image_emoticon21", "呼~");
        crC.put("image_emoticon22", "笑眼");
        crC.put("image_emoticon23", "冷");
        crC.put("image_emoticon24", "太开心");
        crC.put("image_emoticon25", "滑稽");
        crC.put("image_emoticon26", "勉强");
        crC.put("image_emoticon27", "狂汗");
        crC.put("image_emoticon28", "乖");
        crC.put("image_emoticon29", "睡觉");
        crC.put("image_emoticon30", "惊哭");
        crC.put("image_emoticon31", "生气");
        crC.put("image_emoticon32", "惊讶");
        crC.put("image_emoticon33", "喷");
        crC.put("image_emoticon34", "爱心");
        crC.put("image_emoticon35", "心碎");
        crC.put("image_emoticon36", "玫瑰");
        crC.put("image_emoticon37", "礼物");
        crC.put("image_emoticon38", "彩虹");
        crC.put("image_emoticon39", "星星月亮");
        crC.put("image_emoticon40", "太阳");
        crC.put("image_emoticon41", "钱币");
        crC.put("image_emoticon42", "灯泡");
        crC.put("image_emoticon43", "茶杯");
        crC.put("image_emoticon44", "蛋糕");
        crC.put("image_emoticon45", "音乐");
        crC.put("image_emoticon46", "haha");
        crC.put("image_emoticon47", "胜利");
        crC.put("image_emoticon48", "大拇指");
        crC.put("image_emoticon49", "弱");
        crC.put("image_emoticon50", "OK");
        crC.put("image_emoticon61", "哼");
        crC.put("image_emoticon62", "吃瓜");
        crC.put("image_emoticon63", "扔便便");
        crC.put("image_emoticon64", "惊恐");
        crC.put("image_emoticon65", "哎呦");
        crC.put("image_emoticon66", "小乖");
        crC.put("image_emoticon67", "捂嘴笑");
        crC.put("image_emoticon68", "你懂的");
        crC.put("image_emoticon69", "what");
        crC.put("image_emoticon70", "酸爽");
        crC.put("image_emoticon71", "呀咩爹");
        crC.put("image_emoticon72", "笑尿");
        crC.put("image_emoticon73", "挖鼻");
        crC.put("image_emoticon74", "犀利");
        crC.put("image_emoticon75", "小红脸");
        crC.put("image_emoticon76", "懒得理");
        crC.put("image_emoticon77", "沙发");
        crC.put("image_emoticon78", "手纸");
        crC.put("image_emoticon79", "香蕉");
        crC.put("image_emoticon80", "便便");
        crC.put("image_emoticon81", "药丸");
        crC.put("image_emoticon82", "红领巾");
        crC.put("image_emoticon83", "蜡烛");
        crC.put("image_emoticon84", "三道杠");
        crC.put("image_emoticon101", "不跟丑人说话");
        crC.put("image_emoticon102", "么么哒");
        crC.put("image_emoticon103", "亲亲才能起来");
        crC.put("image_emoticon104", "伦家只是宝宝");
        crC.put("image_emoticon105", "你是我的人");
        crC.put("image_emoticon106", "假装看不见");
        crC.put("image_emoticon107", "单身等撩");
        crC.put("image_emoticon108", "吓到宝宝了");
        crC.put("image_emoticon109", "哈哈哈");
        crC.put("image_emoticon110", "嗯嗯");
        crC.put("image_emoticon111", "好幸福");
        crC.put("image_emoticon112", "宝宝不开心");
        crC.put("image_emoticon113", "小姐姐别走");
        crC.put("image_emoticon114", "小姐姐在吗");
        crC.put("image_emoticon115", "小姐姐来啦");
        crC.put("image_emoticon116", "小姐姐来玩呀");
        crC.put("image_emoticon117", "我养你");
        crC.put("image_emoticon118", "我是不会骗你的");
        crC.put("image_emoticon119", "扎心了");
        crC.put("image_emoticon120", "无聊");
        crC.put("image_emoticon121", "月亮代表我的心");
        crC.put("image_emoticon122", "来追我呀");
        crC.put("image_emoticon123", "爱你的形状");
        crC.put("image_emoticon124", "白眼");
        crC.put("ali_001", "赖皮");
        crC.put("ali_002", "感动");
        crC.put("ali_003", "十分惊讶");
        crC.put("ali_004", "怒气");
        crC.put("ali_005", "哭泣");
        crC.put("ali_006", "吃惊");
        crC.put("ali_007", "嘲弄");
        crC.put("ali_008", "飘过");
        crC.put("ali_009", "转圈哭");
        crC.put("ali_010", "神经病");
        crC.put("ali_011", "揪耳朵");
        crC.put("ali_012", "惊汗");
        crC.put("ali_013", "隐身");
        crC.put("ali_014", "不要嘛");
        crC.put("ali_015", "遁");
        crC.put("ali_016", "不公平");
        crC.put("ali_017", "爬来了");
        crC.put("ali_018", "蛋花哭");
        crC.put("ali_019", "温暖");
        crC.put("ali_020", "点头");
        crC.put("ali_021", "撒钱");
        crC.put("ali_022", "献花");
        crC.put("ali_023", "寒");
        crC.put("ali_024", "傻笑");
        crC.put("ali_025", "扭扭");
        crC.put("ali_026", "疯");
        crC.put("ali_027", "抓狂");
        crC.put("ali_028", "抓");
        crC.put("ali_029", "蜷");
        crC.put("ali_030", "挠墙");
        crC.put("ali_031", "狂笑");
        crC.put("ali_032", "抱枕");
        crC.put("ali_033", "吼叫");
        crC.put("ali_034", "嚷");
        crC.put("ali_035", "唠叨");
        crC.put("ali_036", "捏脸");
        crC.put("ali_037", "爆笑");
        crC.put("ali_038", "郁闷");
        crC.put("ali_039", "潜水");
        crC.put("ali_040", "十分开心");
        crC.put("ali_041", "冷笑话");
        crC.put("ali_042", "顶！");
        crC.put("ali_043", "潜");
        crC.put("ali_044", "画圈圈");
        crC.put("ali_045", "玩电脑");
        crC.put("ali_046", "狂吐");
        crC.put("ali_047", "哭着跑");
        crC.put("ali_048", "阿狸侠");
        crC.put("ali_049", "冷死了");
        crC.put("ali_050", "惆怅~");
        crC.put("ali_051", "摸头");
        crC.put("ali_052", "蹭");
        crC.put("ali_053", "打滚");
        crC.put("ali_054", "叩拜");
        crC.put("ali_055", "摸");
        crC.put("ali_056", "数钱");
        crC.put("ali_057", "拖走");
        crC.put("ali_058", "热");
        crC.put("ali_059", "加1");
        crC.put("ali_060", "压力");
        crC.put("ali_061", "表逼我");
        crC.put("ali_062", "人呢");
        crC.put("ali_063", "摇晃");
        crC.put("ali_064", "打地鼠");
        crC.put("ali_065", "这个屌");
        crC.put("ali_066", "恐慌");
        crC.put("ali_067", "晕乎乎");
        crC.put("ali_068", "浮云");
        crC.put("ali_069", "给力");
        crC.put("ali_070", "杯具了");
        crC.put("b01", "微笑");
        crC.put("b02", "帅哥");
        crC.put("b03", "美女");
        crC.put("b04", "老大");
        crC.put("b05", "哈哈哈");
        crC.put("b06", "奸笑");
        crC.put("b07", "傻乐");
        crC.put("b08", "飞吻");
        crC.put("b09", "害羞");
        crC.put("b10", "花痴");
        crC.put("b11", "憧憬");
        crC.put("b12", "你牛");
        crC.put("b13", "鼓掌");
        crC.put("b14", "可爱");
        crC.put("b15", "太委屈");
        crC.put("b16", "大哭");
        crC.put("b17", "泪奔");
        crC.put("b18", "寻死");
        crC.put("b19", "非常惊讶");
        crC.put("b20", "表示疑问");
        crC.put("yz_001", "焦糖舞");
        crC.put("yz_002", "翻滚");
        crC.put("yz_003", "拍屁股做鬼脸");
        crC.put("yz_004", "不");
        crC.put("yz_005", "河蟹掉啦");
        crC.put("yz_006", "哦耶");
        crC.put("yz_007", "我倒");
        crC.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int pP(String str) {
        Integer num = crz.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int pQ(String str) {
        Integer num = crB.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String pR(String str) {
        return crC.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int arg() {
        return crA.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0253a ak(Context context, String str) {
        return null;
    }
}
