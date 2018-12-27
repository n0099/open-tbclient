package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aZe = new HashMap<>(200);
    public static final ArrayList<Integer> aZf = new ArrayList<>(180);
    public static final HashMap<String, Integer> aZg = new HashMap<>(180);
    private static final HashMap<String, String> aZh = new HashMap<>(180);

    static {
        aZh.put("image_emoticon", "呵呵");
        aZh.put("image_emoticon2", "哈哈");
        aZh.put("image_emoticon3", "吐舌");
        aZh.put("image_emoticon4", "啊");
        aZh.put("image_emoticon5", "酷");
        aZh.put("image_emoticon6", "怒");
        aZh.put("image_emoticon7", "开心");
        aZh.put("image_emoticon8", "汗");
        aZh.put("image_emoticon9", "泪");
        aZh.put("image_emoticon10", "黑线");
        aZh.put("image_emoticon11", "鄙视");
        aZh.put("image_emoticon12", "不高兴");
        aZh.put("image_emoticon13", "真棒");
        aZh.put("image_emoticon14", "钱");
        aZh.put("image_emoticon15", "疑问");
        aZh.put("image_emoticon16", "阴险");
        aZh.put("image_emoticon17", "吐");
        aZh.put("image_emoticon18", "咦");
        aZh.put("image_emoticon19", "委屈");
        aZh.put("image_emoticon20", "花心");
        aZh.put("image_emoticon21", "呼~");
        aZh.put("image_emoticon22", "笑眼");
        aZh.put("image_emoticon23", "冷");
        aZh.put("image_emoticon24", "太开心");
        aZh.put("image_emoticon25", "滑稽");
        aZh.put("image_emoticon26", "勉强");
        aZh.put("image_emoticon27", "狂汗");
        aZh.put("image_emoticon28", "乖");
        aZh.put("image_emoticon29", "睡觉");
        aZh.put("image_emoticon30", "惊哭");
        aZh.put("image_emoticon31", "生气");
        aZh.put("image_emoticon32", "惊讶");
        aZh.put("image_emoticon33", "喷");
        aZh.put("image_emoticon34", "爱心");
        aZh.put("image_emoticon35", "心碎");
        aZh.put("image_emoticon36", "玫瑰");
        aZh.put("image_emoticon37", "礼物");
        aZh.put("image_emoticon38", "彩虹");
        aZh.put("image_emoticon39", "星星月亮");
        aZh.put("image_emoticon40", "太阳");
        aZh.put("image_emoticon41", "钱币");
        aZh.put("image_emoticon42", "灯泡");
        aZh.put("image_emoticon43", "茶杯");
        aZh.put("image_emoticon44", "蛋糕");
        aZh.put("image_emoticon45", "音乐");
        aZh.put("image_emoticon46", "haha");
        aZh.put("image_emoticon47", "胜利");
        aZh.put("image_emoticon48", "大拇指");
        aZh.put("image_emoticon49", "弱");
        aZh.put("image_emoticon50", "OK");
        aZh.put("image_emoticon61", "哼");
        aZh.put("image_emoticon62", "吃瓜");
        aZh.put("image_emoticon63", "扔便便");
        aZh.put("image_emoticon64", "惊恐");
        aZh.put("image_emoticon65", "哎呦");
        aZh.put("image_emoticon66", "小乖");
        aZh.put("image_emoticon67", "捂嘴笑");
        aZh.put("image_emoticon68", "你懂的");
        aZh.put("image_emoticon69", "what");
        aZh.put("image_emoticon70", "酸爽");
        aZh.put("image_emoticon71", "呀咩爹");
        aZh.put("image_emoticon72", "笑尿");
        aZh.put("image_emoticon73", "挖鼻");
        aZh.put("image_emoticon74", "犀利");
        aZh.put("image_emoticon75", "小红脸");
        aZh.put("image_emoticon76", "懒得理");
        aZh.put("image_emoticon77", "沙发");
        aZh.put("image_emoticon78", "手纸");
        aZh.put("image_emoticon79", "香蕉");
        aZh.put("image_emoticon80", "便便");
        aZh.put("image_emoticon81", "药丸");
        aZh.put("image_emoticon82", "红领巾");
        aZh.put("image_emoticon83", "蜡烛");
        aZh.put("image_emoticon84", "三道杠");
        aZh.put("image_emoticon101", "不跟丑人说话");
        aZh.put("image_emoticon102", "么么哒");
        aZh.put("image_emoticon103", "亲亲才能起来");
        aZh.put("image_emoticon104", "伦家只是宝宝");
        aZh.put("image_emoticon105", "你是我的人");
        aZh.put("image_emoticon106", "假装看不见");
        aZh.put("image_emoticon107", "单身等撩");
        aZh.put("image_emoticon108", "吓到宝宝了");
        aZh.put("image_emoticon109", "哈哈哈");
        aZh.put("image_emoticon110", "嗯嗯");
        aZh.put("image_emoticon111", "好幸福");
        aZh.put("image_emoticon112", "宝宝不开心");
        aZh.put("image_emoticon113", "小姐姐别走");
        aZh.put("image_emoticon114", "小姐姐在吗");
        aZh.put("image_emoticon115", "小姐姐来啦");
        aZh.put("image_emoticon116", "小姐姐来玩呀");
        aZh.put("image_emoticon117", "我养你");
        aZh.put("image_emoticon118", "我是不会骗你的");
        aZh.put("image_emoticon119", "扎心了");
        aZh.put("image_emoticon120", "无聊");
        aZh.put("image_emoticon121", "月亮代表我的心");
        aZh.put("image_emoticon122", "来追我呀");
        aZh.put("image_emoticon123", "爱你的形状");
        aZh.put("image_emoticon124", "白眼");
        aZh.put("ali_001", "赖皮");
        aZh.put("ali_002", "感动");
        aZh.put("ali_003", "十分惊讶");
        aZh.put("ali_004", "怒气");
        aZh.put("ali_005", "哭泣");
        aZh.put("ali_006", "吃惊");
        aZh.put("ali_007", "嘲弄");
        aZh.put("ali_008", "飘过");
        aZh.put("ali_009", "转圈哭");
        aZh.put("ali_010", "神经病");
        aZh.put("ali_011", "揪耳朵");
        aZh.put("ali_012", "惊汗");
        aZh.put("ali_013", "隐身");
        aZh.put("ali_014", "不要嘛");
        aZh.put("ali_015", "遁");
        aZh.put("ali_016", "不公平");
        aZh.put("ali_017", "爬来了");
        aZh.put("ali_018", "蛋花哭");
        aZh.put("ali_019", "温暖");
        aZh.put("ali_020", "点头");
        aZh.put("ali_021", "撒钱");
        aZh.put("ali_022", "献花");
        aZh.put("ali_023", "寒");
        aZh.put("ali_024", "傻笑");
        aZh.put("ali_025", "扭扭");
        aZh.put("ali_026", "疯");
        aZh.put("ali_027", "抓狂");
        aZh.put("ali_028", "抓");
        aZh.put("ali_029", "蜷");
        aZh.put("ali_030", "挠墙");
        aZh.put("ali_031", "狂笑");
        aZh.put("ali_032", "抱枕");
        aZh.put("ali_033", "吼叫");
        aZh.put("ali_034", "嚷");
        aZh.put("ali_035", "唠叨");
        aZh.put("ali_036", "捏脸");
        aZh.put("ali_037", "爆笑");
        aZh.put("ali_038", "郁闷");
        aZh.put("ali_039", "潜水");
        aZh.put("ali_040", "十分开心");
        aZh.put("ali_041", "冷笑话");
        aZh.put("ali_042", "顶！");
        aZh.put("ali_043", "潜");
        aZh.put("ali_044", "画圈圈");
        aZh.put("ali_045", "玩电脑");
        aZh.put("ali_046", "狂吐");
        aZh.put("ali_047", "哭着跑");
        aZh.put("ali_048", "阿狸侠");
        aZh.put("ali_049", "冷死了");
        aZh.put("ali_050", "惆怅~");
        aZh.put("ali_051", "摸头");
        aZh.put("ali_052", "蹭");
        aZh.put("ali_053", "打滚");
        aZh.put("ali_054", "叩拜");
        aZh.put("ali_055", "摸");
        aZh.put("ali_056", "数钱");
        aZh.put("ali_057", "拖走");
        aZh.put("ali_058", "热");
        aZh.put("ali_059", "加1");
        aZh.put("ali_060", "压力");
        aZh.put("ali_061", "表逼我");
        aZh.put("ali_062", "人呢");
        aZh.put("ali_063", "摇晃");
        aZh.put("ali_064", "打地鼠");
        aZh.put("ali_065", "这个屌");
        aZh.put("ali_066", "恐慌");
        aZh.put("ali_067", "晕乎乎");
        aZh.put("ali_068", "浮云");
        aZh.put("ali_069", "给力");
        aZh.put("ali_070", "杯具了");
        aZh.put("b01", "微笑");
        aZh.put("b02", "帅哥");
        aZh.put("b03", "美女");
        aZh.put("b04", "老大");
        aZh.put("b05", "哈哈哈");
        aZh.put("b06", "奸笑");
        aZh.put("b07", "傻乐");
        aZh.put("b08", "飞吻");
        aZh.put("b09", "害羞");
        aZh.put("b10", "花痴");
        aZh.put("b11", "憧憬");
        aZh.put("b12", "你牛");
        aZh.put("b13", "鼓掌");
        aZh.put("b14", "可爱");
        aZh.put("b15", "太委屈");
        aZh.put("b16", "大哭");
        aZh.put("b17", "泪奔");
        aZh.put("b18", "寻死");
        aZh.put("b19", "非常惊讶");
        aZh.put("b20", "表示疑问");
        aZh.put("yz_001", "焦糖舞");
        aZh.put("yz_002", "翻滚");
        aZh.put("yz_003", "拍屁股做鬼脸");
        aZh.put("yz_004", "不");
        aZh.put("yz_005", "河蟹掉啦");
        aZh.put("yz_006", "哦耶");
        aZh.put("yz_007", "我倒");
        aZh.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hE(String str) {
        Integer num = aZe.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(e.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hF(String str) {
        Integer num = aZg.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String hG(String str) {
        return aZh.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Ml() {
        return aZf.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0171a al(Context context, String str) {
        return null;
    }
}
