package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> bqT = new HashMap<>(200);
    public static final ArrayList<Integer> bqU = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> bqV = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> bqW = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        bqW.put("image_emoticon", "呵呵");
        bqW.put("image_emoticon2", "哈哈");
        bqW.put("image_emoticon3", "吐舌");
        bqW.put("image_emoticon4", "啊");
        bqW.put("image_emoticon5", "酷");
        bqW.put("image_emoticon6", "怒");
        bqW.put("image_emoticon7", "开心");
        bqW.put("image_emoticon8", "汗");
        bqW.put("image_emoticon9", "泪");
        bqW.put("image_emoticon10", "黑线");
        bqW.put("image_emoticon11", "鄙视");
        bqW.put("image_emoticon12", "不高兴");
        bqW.put("image_emoticon13", "真棒");
        bqW.put("image_emoticon14", "钱");
        bqW.put("image_emoticon15", "疑问");
        bqW.put("image_emoticon16", "阴险");
        bqW.put("image_emoticon17", "吐");
        bqW.put("image_emoticon18", "咦");
        bqW.put("image_emoticon19", "委屈");
        bqW.put("image_emoticon20", "花心");
        bqW.put("image_emoticon21", "呼~");
        bqW.put("image_emoticon22", "笑眼");
        bqW.put("image_emoticon23", "冷");
        bqW.put("image_emoticon24", "太开心");
        bqW.put("image_emoticon25", "滑稽");
        bqW.put("image_emoticon26", "勉强");
        bqW.put("image_emoticon27", "狂汗");
        bqW.put("image_emoticon28", "乖");
        bqW.put("image_emoticon29", "睡觉");
        bqW.put("image_emoticon30", "惊哭");
        bqW.put("image_emoticon31", "生气");
        bqW.put("image_emoticon32", "惊讶");
        bqW.put("image_emoticon33", "喷");
        bqW.put("image_emoticon34", "爱心");
        bqW.put("image_emoticon35", "心碎");
        bqW.put("image_emoticon36", "玫瑰");
        bqW.put("image_emoticon37", "礼物");
        bqW.put("image_emoticon38", "彩虹");
        bqW.put("image_emoticon39", "星星月亮");
        bqW.put("image_emoticon40", "太阳");
        bqW.put("image_emoticon41", "钱币");
        bqW.put("image_emoticon42", "灯泡");
        bqW.put("image_emoticon43", "茶杯");
        bqW.put("image_emoticon44", "蛋糕");
        bqW.put("image_emoticon45", "音乐");
        bqW.put("image_emoticon46", "haha");
        bqW.put("image_emoticon47", "胜利");
        bqW.put("image_emoticon48", "大拇指");
        bqW.put("image_emoticon49", "弱");
        bqW.put("image_emoticon50", "OK");
        bqW.put("image_emoticon61", "哼");
        bqW.put("image_emoticon62", "吃瓜");
        bqW.put("image_emoticon63", "扔便便");
        bqW.put("image_emoticon64", "惊恐");
        bqW.put("image_emoticon65", "哎呦");
        bqW.put("image_emoticon66", "小乖");
        bqW.put("image_emoticon67", "捂嘴笑");
        bqW.put("image_emoticon68", "你懂的");
        bqW.put("image_emoticon69", "what");
        bqW.put("image_emoticon70", "酸爽");
        bqW.put("image_emoticon71", "呀咩爹");
        bqW.put("image_emoticon72", "笑尿");
        bqW.put("image_emoticon73", "挖鼻");
        bqW.put("image_emoticon74", "犀利");
        bqW.put("image_emoticon75", "小红脸");
        bqW.put("image_emoticon76", "懒得理");
        bqW.put("image_emoticon77", "沙发");
        bqW.put("image_emoticon78", "手纸");
        bqW.put("image_emoticon79", "香蕉");
        bqW.put("image_emoticon80", "便便");
        bqW.put("image_emoticon81", "药丸");
        bqW.put("image_emoticon82", "红领巾");
        bqW.put("image_emoticon83", "蜡烛");
        bqW.put("image_emoticon84", "三道杠");
        bqW.put("image_emoticon101", "不跟丑人说话");
        bqW.put("image_emoticon102", "么么哒");
        bqW.put("image_emoticon103", "亲亲才能起来");
        bqW.put("image_emoticon104", "伦家只是宝宝");
        bqW.put("image_emoticon105", "你是我的人");
        bqW.put("image_emoticon106", "假装看不见");
        bqW.put("image_emoticon107", "单身等撩");
        bqW.put("image_emoticon108", "吓到宝宝了");
        bqW.put("image_emoticon109", "哈哈哈");
        bqW.put("image_emoticon110", "嗯嗯");
        bqW.put("image_emoticon111", "好幸福");
        bqW.put("image_emoticon112", "宝宝不开心");
        bqW.put("image_emoticon113", "小姐姐别走");
        bqW.put("image_emoticon114", "小姐姐在吗");
        bqW.put("image_emoticon115", "小姐姐来啦");
        bqW.put("image_emoticon116", "小姐姐来玩呀");
        bqW.put("image_emoticon117", "我养你");
        bqW.put("image_emoticon118", "我是不会骗你的");
        bqW.put("image_emoticon119", "扎心了");
        bqW.put("image_emoticon120", "无聊");
        bqW.put("image_emoticon121", "月亮代表我的心");
        bqW.put("image_emoticon122", "来追我呀");
        bqW.put("image_emoticon123", "爱你的形状");
        bqW.put("image_emoticon124", "白眼");
        bqW.put("ali_001", "赖皮");
        bqW.put("ali_002", "感动");
        bqW.put("ali_003", "十分惊讶");
        bqW.put("ali_004", "怒气");
        bqW.put("ali_005", "哭泣");
        bqW.put("ali_006", "吃惊");
        bqW.put("ali_007", "嘲弄");
        bqW.put("ali_008", "飘过");
        bqW.put("ali_009", "转圈哭");
        bqW.put("ali_010", "神经病");
        bqW.put("ali_011", "揪耳朵");
        bqW.put("ali_012", "惊汗");
        bqW.put("ali_013", "隐身");
        bqW.put("ali_014", "不要嘛");
        bqW.put("ali_015", "遁");
        bqW.put("ali_016", "不公平");
        bqW.put("ali_017", "爬来了");
        bqW.put("ali_018", "蛋花哭");
        bqW.put("ali_019", "温暖");
        bqW.put("ali_020", "点头");
        bqW.put("ali_021", "撒钱");
        bqW.put("ali_022", "献花");
        bqW.put("ali_023", "寒");
        bqW.put("ali_024", "傻笑");
        bqW.put("ali_025", "扭扭");
        bqW.put("ali_026", "疯");
        bqW.put("ali_027", "抓狂");
        bqW.put("ali_028", "抓");
        bqW.put("ali_029", "蜷");
        bqW.put("ali_030", "挠墙");
        bqW.put("ali_031", "狂笑");
        bqW.put("ali_032", "抱枕");
        bqW.put("ali_033", "吼叫");
        bqW.put("ali_034", "嚷");
        bqW.put("ali_035", "唠叨");
        bqW.put("ali_036", "捏脸");
        bqW.put("ali_037", "爆笑");
        bqW.put("ali_038", "郁闷");
        bqW.put("ali_039", "潜水");
        bqW.put("ali_040", "十分开心");
        bqW.put("ali_041", "冷笑话");
        bqW.put("ali_042", "顶！");
        bqW.put("ali_043", "潜");
        bqW.put("ali_044", "画圈圈");
        bqW.put("ali_045", "玩电脑");
        bqW.put("ali_046", "狂吐");
        bqW.put("ali_047", "哭着跑");
        bqW.put("ali_048", "阿狸侠");
        bqW.put("ali_049", "冷死了");
        bqW.put("ali_050", "惆怅~");
        bqW.put("ali_051", "摸头");
        bqW.put("ali_052", "蹭");
        bqW.put("ali_053", "打滚");
        bqW.put("ali_054", "叩拜");
        bqW.put("ali_055", "摸");
        bqW.put("ali_056", "数钱");
        bqW.put("ali_057", "拖走");
        bqW.put("ali_058", "热");
        bqW.put("ali_059", "加1");
        bqW.put("ali_060", "压力");
        bqW.put("ali_061", "表逼我");
        bqW.put("ali_062", "人呢");
        bqW.put("ali_063", "摇晃");
        bqW.put("ali_064", "打地鼠");
        bqW.put("ali_065", "这个屌");
        bqW.put("ali_066", "恐慌");
        bqW.put("ali_067", "晕乎乎");
        bqW.put("ali_068", "浮云");
        bqW.put("ali_069", "给力");
        bqW.put("ali_070", "杯具了");
        bqW.put("b01", "微笑");
        bqW.put("b02", "帅哥");
        bqW.put("b03", "美女");
        bqW.put("b04", "老大");
        bqW.put("b05", "哈哈哈");
        bqW.put("b06", "奸笑");
        bqW.put("b07", "傻乐");
        bqW.put("b08", "飞吻");
        bqW.put("b09", "害羞");
        bqW.put("b10", "花痴");
        bqW.put("b11", "憧憬");
        bqW.put("b12", "你牛");
        bqW.put("b13", "鼓掌");
        bqW.put("b14", "可爱");
        bqW.put("b15", "太委屈");
        bqW.put("b16", "大哭");
        bqW.put("b17", "泪奔");
        bqW.put("b18", "寻死");
        bqW.put("b19", "非常惊讶");
        bqW.put("b20", "表示疑问");
        bqW.put("yz_001", "焦糖舞");
        bqW.put("yz_002", "翻滚");
        bqW.put("yz_003", "拍屁股做鬼脸");
        bqW.put("yz_004", "不");
        bqW.put("yz_005", "河蟹掉啦");
        bqW.put("yz_006", "哦耶");
        bqW.put("yz_007", "我倒");
        bqW.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fT(String str) {
        Integer num = bqT.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fU(String str) {
        Integer num = bqV.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fV(String str) {
        return bqW.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int KH() {
        return bqU.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0084a U(Context context, String str) {
        return null;
    }
}
