package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> brc = new HashMap<>(200);
    public static final ArrayList<Integer> brd = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> bre = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> brf = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        brf.put("image_emoticon", "呵呵");
        brf.put("image_emoticon2", "哈哈");
        brf.put("image_emoticon3", "吐舌");
        brf.put("image_emoticon4", "啊");
        brf.put("image_emoticon5", "酷");
        brf.put("image_emoticon6", "怒");
        brf.put("image_emoticon7", "开心");
        brf.put("image_emoticon8", "汗");
        brf.put("image_emoticon9", "泪");
        brf.put("image_emoticon10", "黑线");
        brf.put("image_emoticon11", "鄙视");
        brf.put("image_emoticon12", "不高兴");
        brf.put("image_emoticon13", "真棒");
        brf.put("image_emoticon14", "钱");
        brf.put("image_emoticon15", "疑问");
        brf.put("image_emoticon16", "阴险");
        brf.put("image_emoticon17", "吐");
        brf.put("image_emoticon18", "咦");
        brf.put("image_emoticon19", "委屈");
        brf.put("image_emoticon20", "花心");
        brf.put("image_emoticon21", "呼~");
        brf.put("image_emoticon22", "笑眼");
        brf.put("image_emoticon23", "冷");
        brf.put("image_emoticon24", "太开心");
        brf.put("image_emoticon25", "滑稽");
        brf.put("image_emoticon26", "勉强");
        brf.put("image_emoticon27", "狂汗");
        brf.put("image_emoticon28", "乖");
        brf.put("image_emoticon29", "睡觉");
        brf.put("image_emoticon30", "惊哭");
        brf.put("image_emoticon31", "生气");
        brf.put("image_emoticon32", "惊讶");
        brf.put("image_emoticon33", "喷");
        brf.put("image_emoticon34", "爱心");
        brf.put("image_emoticon35", "心碎");
        brf.put("image_emoticon36", "玫瑰");
        brf.put("image_emoticon37", "礼物");
        brf.put("image_emoticon38", "彩虹");
        brf.put("image_emoticon39", "星星月亮");
        brf.put("image_emoticon40", "太阳");
        brf.put("image_emoticon41", "钱币");
        brf.put("image_emoticon42", "灯泡");
        brf.put("image_emoticon43", "茶杯");
        brf.put("image_emoticon44", "蛋糕");
        brf.put("image_emoticon45", "音乐");
        brf.put("image_emoticon46", "haha");
        brf.put("image_emoticon47", "胜利");
        brf.put("image_emoticon48", "大拇指");
        brf.put("image_emoticon49", "弱");
        brf.put("image_emoticon50", "OK");
        brf.put("image_emoticon61", "哼");
        brf.put("image_emoticon62", "吃瓜");
        brf.put("image_emoticon63", "扔便便");
        brf.put("image_emoticon64", "惊恐");
        brf.put("image_emoticon65", "哎呦");
        brf.put("image_emoticon66", "小乖");
        brf.put("image_emoticon67", "捂嘴笑");
        brf.put("image_emoticon68", "你懂的");
        brf.put("image_emoticon69", "what");
        brf.put("image_emoticon70", "酸爽");
        brf.put("image_emoticon71", "呀咩爹");
        brf.put("image_emoticon72", "笑尿");
        brf.put("image_emoticon73", "挖鼻");
        brf.put("image_emoticon74", "犀利");
        brf.put("image_emoticon75", "小红脸");
        brf.put("image_emoticon76", "懒得理");
        brf.put("image_emoticon77", "沙发");
        brf.put("image_emoticon78", "手纸");
        brf.put("image_emoticon79", "香蕉");
        brf.put("image_emoticon80", "便便");
        brf.put("image_emoticon81", "药丸");
        brf.put("image_emoticon82", "红领巾");
        brf.put("image_emoticon83", "蜡烛");
        brf.put("image_emoticon84", "三道杠");
        brf.put("image_emoticon101", "不跟丑人说话");
        brf.put("image_emoticon102", "么么哒");
        brf.put("image_emoticon103", "亲亲才能起来");
        brf.put("image_emoticon104", "伦家只是宝宝");
        brf.put("image_emoticon105", "你是我的人");
        brf.put("image_emoticon106", "假装看不见");
        brf.put("image_emoticon107", "单身等撩");
        brf.put("image_emoticon108", "吓到宝宝了");
        brf.put("image_emoticon109", "哈哈哈");
        brf.put("image_emoticon110", "嗯嗯");
        brf.put("image_emoticon111", "好幸福");
        brf.put("image_emoticon112", "宝宝不开心");
        brf.put("image_emoticon113", "小姐姐别走");
        brf.put("image_emoticon114", "小姐姐在吗");
        brf.put("image_emoticon115", "小姐姐来啦");
        brf.put("image_emoticon116", "小姐姐来玩呀");
        brf.put("image_emoticon117", "我养你");
        brf.put("image_emoticon118", "我是不会骗你的");
        brf.put("image_emoticon119", "扎心了");
        brf.put("image_emoticon120", "无聊");
        brf.put("image_emoticon121", "月亮代表我的心");
        brf.put("image_emoticon122", "来追我呀");
        brf.put("image_emoticon123", "爱你的形状");
        brf.put("image_emoticon124", "白眼");
        brf.put("ali_001", "赖皮");
        brf.put("ali_002", "感动");
        brf.put("ali_003", "十分惊讶");
        brf.put("ali_004", "怒气");
        brf.put("ali_005", "哭泣");
        brf.put("ali_006", "吃惊");
        brf.put("ali_007", "嘲弄");
        brf.put("ali_008", "飘过");
        brf.put("ali_009", "转圈哭");
        brf.put("ali_010", "神经病");
        brf.put("ali_011", "揪耳朵");
        brf.put("ali_012", "惊汗");
        brf.put("ali_013", "隐身");
        brf.put("ali_014", "不要嘛");
        brf.put("ali_015", "遁");
        brf.put("ali_016", "不公平");
        brf.put("ali_017", "爬来了");
        brf.put("ali_018", "蛋花哭");
        brf.put("ali_019", "温暖");
        brf.put("ali_020", "点头");
        brf.put("ali_021", "撒钱");
        brf.put("ali_022", "献花");
        brf.put("ali_023", "寒");
        brf.put("ali_024", "傻笑");
        brf.put("ali_025", "扭扭");
        brf.put("ali_026", "疯");
        brf.put("ali_027", "抓狂");
        brf.put("ali_028", "抓");
        brf.put("ali_029", "蜷");
        brf.put("ali_030", "挠墙");
        brf.put("ali_031", "狂笑");
        brf.put("ali_032", "抱枕");
        brf.put("ali_033", "吼叫");
        brf.put("ali_034", "嚷");
        brf.put("ali_035", "唠叨");
        brf.put("ali_036", "捏脸");
        brf.put("ali_037", "爆笑");
        brf.put("ali_038", "郁闷");
        brf.put("ali_039", "潜水");
        brf.put("ali_040", "十分开心");
        brf.put("ali_041", "冷笑话");
        brf.put("ali_042", "顶！");
        brf.put("ali_043", "潜");
        brf.put("ali_044", "画圈圈");
        brf.put("ali_045", "玩电脑");
        brf.put("ali_046", "狂吐");
        brf.put("ali_047", "哭着跑");
        brf.put("ali_048", "阿狸侠");
        brf.put("ali_049", "冷死了");
        brf.put("ali_050", "惆怅~");
        brf.put("ali_051", "摸头");
        brf.put("ali_052", "蹭");
        brf.put("ali_053", "打滚");
        brf.put("ali_054", "叩拜");
        brf.put("ali_055", "摸");
        brf.put("ali_056", "数钱");
        brf.put("ali_057", "拖走");
        brf.put("ali_058", "热");
        brf.put("ali_059", "加1");
        brf.put("ali_060", "压力");
        brf.put("ali_061", "表逼我");
        brf.put("ali_062", "人呢");
        brf.put("ali_063", "摇晃");
        brf.put("ali_064", "打地鼠");
        brf.put("ali_065", "这个屌");
        brf.put("ali_066", "恐慌");
        brf.put("ali_067", "晕乎乎");
        brf.put("ali_068", "浮云");
        brf.put("ali_069", "给力");
        brf.put("ali_070", "杯具了");
        brf.put("b01", "微笑");
        brf.put("b02", "帅哥");
        brf.put("b03", "美女");
        brf.put("b04", "老大");
        brf.put("b05", "哈哈哈");
        brf.put("b06", "奸笑");
        brf.put("b07", "傻乐");
        brf.put("b08", "飞吻");
        brf.put("b09", "害羞");
        brf.put("b10", "花痴");
        brf.put("b11", "憧憬");
        brf.put("b12", "你牛");
        brf.put("b13", "鼓掌");
        brf.put("b14", "可爱");
        brf.put("b15", "太委屈");
        brf.put("b16", "大哭");
        brf.put("b17", "泪奔");
        brf.put("b18", "寻死");
        brf.put("b19", "非常惊讶");
        brf.put("b20", "表示疑问");
        brf.put("yz_001", "焦糖舞");
        brf.put("yz_002", "翻滚");
        brf.put("yz_003", "拍屁股做鬼脸");
        brf.put("yz_004", "不");
        brf.put("yz_005", "河蟹掉啦");
        brf.put("yz_006", "哦耶");
        brf.put("yz_007", "我倒");
        brf.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int ga(String str) {
        Integer num = brc.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gb(String str) {
        Integer num = bre.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gc(String str) {
        return brf.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int KJ() {
        return brd.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0085a T(Context context, String str) {
        return null;
    }
}
