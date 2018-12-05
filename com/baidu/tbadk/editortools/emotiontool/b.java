package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aZb = new HashMap<>(200);
    public static final ArrayList<Integer> aZc = new ArrayList<>(180);
    public static final HashMap<String, Integer> aZd = new HashMap<>(180);
    private static final HashMap<String, String> aZe = new HashMap<>(180);

    static {
        aZe.put("image_emoticon", "呵呵");
        aZe.put("image_emoticon2", "哈哈");
        aZe.put("image_emoticon3", "吐舌");
        aZe.put("image_emoticon4", "啊");
        aZe.put("image_emoticon5", "酷");
        aZe.put("image_emoticon6", "怒");
        aZe.put("image_emoticon7", "开心");
        aZe.put("image_emoticon8", "汗");
        aZe.put("image_emoticon9", "泪");
        aZe.put("image_emoticon10", "黑线");
        aZe.put("image_emoticon11", "鄙视");
        aZe.put("image_emoticon12", "不高兴");
        aZe.put("image_emoticon13", "真棒");
        aZe.put("image_emoticon14", "钱");
        aZe.put("image_emoticon15", "疑问");
        aZe.put("image_emoticon16", "阴险");
        aZe.put("image_emoticon17", "吐");
        aZe.put("image_emoticon18", "咦");
        aZe.put("image_emoticon19", "委屈");
        aZe.put("image_emoticon20", "花心");
        aZe.put("image_emoticon21", "呼~");
        aZe.put("image_emoticon22", "笑眼");
        aZe.put("image_emoticon23", "冷");
        aZe.put("image_emoticon24", "太开心");
        aZe.put("image_emoticon25", "滑稽");
        aZe.put("image_emoticon26", "勉强");
        aZe.put("image_emoticon27", "狂汗");
        aZe.put("image_emoticon28", "乖");
        aZe.put("image_emoticon29", "睡觉");
        aZe.put("image_emoticon30", "惊哭");
        aZe.put("image_emoticon31", "生气");
        aZe.put("image_emoticon32", "惊讶");
        aZe.put("image_emoticon33", "喷");
        aZe.put("image_emoticon34", "爱心");
        aZe.put("image_emoticon35", "心碎");
        aZe.put("image_emoticon36", "玫瑰");
        aZe.put("image_emoticon37", "礼物");
        aZe.put("image_emoticon38", "彩虹");
        aZe.put("image_emoticon39", "星星月亮");
        aZe.put("image_emoticon40", "太阳");
        aZe.put("image_emoticon41", "钱币");
        aZe.put("image_emoticon42", "灯泡");
        aZe.put("image_emoticon43", "茶杯");
        aZe.put("image_emoticon44", "蛋糕");
        aZe.put("image_emoticon45", "音乐");
        aZe.put("image_emoticon46", "haha");
        aZe.put("image_emoticon47", "胜利");
        aZe.put("image_emoticon48", "大拇指");
        aZe.put("image_emoticon49", "弱");
        aZe.put("image_emoticon50", "OK");
        aZe.put("image_emoticon61", "哼");
        aZe.put("image_emoticon62", "吃瓜");
        aZe.put("image_emoticon63", "扔便便");
        aZe.put("image_emoticon64", "惊恐");
        aZe.put("image_emoticon65", "哎呦");
        aZe.put("image_emoticon66", "小乖");
        aZe.put("image_emoticon67", "捂嘴笑");
        aZe.put("image_emoticon68", "你懂的");
        aZe.put("image_emoticon69", "what");
        aZe.put("image_emoticon70", "酸爽");
        aZe.put("image_emoticon71", "呀咩爹");
        aZe.put("image_emoticon72", "笑尿");
        aZe.put("image_emoticon73", "挖鼻");
        aZe.put("image_emoticon74", "犀利");
        aZe.put("image_emoticon75", "小红脸");
        aZe.put("image_emoticon76", "懒得理");
        aZe.put("image_emoticon77", "沙发");
        aZe.put("image_emoticon78", "手纸");
        aZe.put("image_emoticon79", "香蕉");
        aZe.put("image_emoticon80", "便便");
        aZe.put("image_emoticon81", "药丸");
        aZe.put("image_emoticon82", "红领巾");
        aZe.put("image_emoticon83", "蜡烛");
        aZe.put("image_emoticon84", "三道杠");
        aZe.put("image_emoticon101", "不跟丑人说话");
        aZe.put("image_emoticon102", "么么哒");
        aZe.put("image_emoticon103", "亲亲才能起来");
        aZe.put("image_emoticon104", "伦家只是宝宝");
        aZe.put("image_emoticon105", "你是我的人");
        aZe.put("image_emoticon106", "假装看不见");
        aZe.put("image_emoticon107", "单身等撩");
        aZe.put("image_emoticon108", "吓到宝宝了");
        aZe.put("image_emoticon109", "哈哈哈");
        aZe.put("image_emoticon110", "嗯嗯");
        aZe.put("image_emoticon111", "好幸福");
        aZe.put("image_emoticon112", "宝宝不开心");
        aZe.put("image_emoticon113", "小姐姐别走");
        aZe.put("image_emoticon114", "小姐姐在吗");
        aZe.put("image_emoticon115", "小姐姐来啦");
        aZe.put("image_emoticon116", "小姐姐来玩呀");
        aZe.put("image_emoticon117", "我养你");
        aZe.put("image_emoticon118", "我是不会骗你的");
        aZe.put("image_emoticon119", "扎心了");
        aZe.put("image_emoticon120", "无聊");
        aZe.put("image_emoticon121", "月亮代表我的心");
        aZe.put("image_emoticon122", "来追我呀");
        aZe.put("image_emoticon123", "爱你的形状");
        aZe.put("image_emoticon124", "白眼");
        aZe.put("ali_001", "赖皮");
        aZe.put("ali_002", "感动");
        aZe.put("ali_003", "十分惊讶");
        aZe.put("ali_004", "怒气");
        aZe.put("ali_005", "哭泣");
        aZe.put("ali_006", "吃惊");
        aZe.put("ali_007", "嘲弄");
        aZe.put("ali_008", "飘过");
        aZe.put("ali_009", "转圈哭");
        aZe.put("ali_010", "神经病");
        aZe.put("ali_011", "揪耳朵");
        aZe.put("ali_012", "惊汗");
        aZe.put("ali_013", "隐身");
        aZe.put("ali_014", "不要嘛");
        aZe.put("ali_015", "遁");
        aZe.put("ali_016", "不公平");
        aZe.put("ali_017", "爬来了");
        aZe.put("ali_018", "蛋花哭");
        aZe.put("ali_019", "温暖");
        aZe.put("ali_020", "点头");
        aZe.put("ali_021", "撒钱");
        aZe.put("ali_022", "献花");
        aZe.put("ali_023", "寒");
        aZe.put("ali_024", "傻笑");
        aZe.put("ali_025", "扭扭");
        aZe.put("ali_026", "疯");
        aZe.put("ali_027", "抓狂");
        aZe.put("ali_028", "抓");
        aZe.put("ali_029", "蜷");
        aZe.put("ali_030", "挠墙");
        aZe.put("ali_031", "狂笑");
        aZe.put("ali_032", "抱枕");
        aZe.put("ali_033", "吼叫");
        aZe.put("ali_034", "嚷");
        aZe.put("ali_035", "唠叨");
        aZe.put("ali_036", "捏脸");
        aZe.put("ali_037", "爆笑");
        aZe.put("ali_038", "郁闷");
        aZe.put("ali_039", "潜水");
        aZe.put("ali_040", "十分开心");
        aZe.put("ali_041", "冷笑话");
        aZe.put("ali_042", "顶！");
        aZe.put("ali_043", "潜");
        aZe.put("ali_044", "画圈圈");
        aZe.put("ali_045", "玩电脑");
        aZe.put("ali_046", "狂吐");
        aZe.put("ali_047", "哭着跑");
        aZe.put("ali_048", "阿狸侠");
        aZe.put("ali_049", "冷死了");
        aZe.put("ali_050", "惆怅~");
        aZe.put("ali_051", "摸头");
        aZe.put("ali_052", "蹭");
        aZe.put("ali_053", "打滚");
        aZe.put("ali_054", "叩拜");
        aZe.put("ali_055", "摸");
        aZe.put("ali_056", "数钱");
        aZe.put("ali_057", "拖走");
        aZe.put("ali_058", "热");
        aZe.put("ali_059", "加1");
        aZe.put("ali_060", "压力");
        aZe.put("ali_061", "表逼我");
        aZe.put("ali_062", "人呢");
        aZe.put("ali_063", "摇晃");
        aZe.put("ali_064", "打地鼠");
        aZe.put("ali_065", "这个屌");
        aZe.put("ali_066", "恐慌");
        aZe.put("ali_067", "晕乎乎");
        aZe.put("ali_068", "浮云");
        aZe.put("ali_069", "给力");
        aZe.put("ali_070", "杯具了");
        aZe.put("b01", "微笑");
        aZe.put("b02", "帅哥");
        aZe.put("b03", "美女");
        aZe.put("b04", "老大");
        aZe.put("b05", "哈哈哈");
        aZe.put("b06", "奸笑");
        aZe.put("b07", "傻乐");
        aZe.put("b08", "飞吻");
        aZe.put("b09", "害羞");
        aZe.put("b10", "花痴");
        aZe.put("b11", "憧憬");
        aZe.put("b12", "你牛");
        aZe.put("b13", "鼓掌");
        aZe.put("b14", "可爱");
        aZe.put("b15", "太委屈");
        aZe.put("b16", "大哭");
        aZe.put("b17", "泪奔");
        aZe.put("b18", "寻死");
        aZe.put("b19", "非常惊讶");
        aZe.put("b20", "表示疑问");
        aZe.put("yz_001", "焦糖舞");
        aZe.put("yz_002", "翻滚");
        aZe.put("yz_003", "拍屁股做鬼脸");
        aZe.put("yz_004", "不");
        aZe.put("yz_005", "河蟹掉啦");
        aZe.put("yz_006", "哦耶");
        aZe.put("yz_007", "我倒");
        aZe.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hD(String str) {
        Integer num = aZb.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(e.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hE(String str) {
        Integer num = aZd.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String hF(String str) {
        return aZe.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Mk() {
        return aZc.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0171a al(Context context, String str) {
        return null;
    }
}
