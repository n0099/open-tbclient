package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aUO = new HashMap<>(200);
    public static final ArrayList<Integer> aUP = new ArrayList<>(180);
    public static final HashMap<String, Integer> aUQ = new HashMap<>(180);
    private static final HashMap<String, String> aUR = new HashMap<>(180);

    static {
        aUR.put("image_emoticon", "呵呵");
        aUR.put("image_emoticon2", "哈哈");
        aUR.put("image_emoticon3", "吐舌");
        aUR.put("image_emoticon4", "啊");
        aUR.put("image_emoticon5", "酷");
        aUR.put("image_emoticon6", "怒");
        aUR.put("image_emoticon7", "开心");
        aUR.put("image_emoticon8", "汗");
        aUR.put("image_emoticon9", "泪");
        aUR.put("image_emoticon10", "黑线");
        aUR.put("image_emoticon11", "鄙视");
        aUR.put("image_emoticon12", "不高兴");
        aUR.put("image_emoticon13", "真棒");
        aUR.put("image_emoticon14", "钱");
        aUR.put("image_emoticon15", "疑问");
        aUR.put("image_emoticon16", "阴险");
        aUR.put("image_emoticon17", "吐");
        aUR.put("image_emoticon18", "咦");
        aUR.put("image_emoticon19", "委屈");
        aUR.put("image_emoticon20", "花心");
        aUR.put("image_emoticon21", "呼~");
        aUR.put("image_emoticon22", "笑眼");
        aUR.put("image_emoticon23", "冷");
        aUR.put("image_emoticon24", "太开心");
        aUR.put("image_emoticon25", "滑稽");
        aUR.put("image_emoticon26", "勉强");
        aUR.put("image_emoticon27", "狂汗");
        aUR.put("image_emoticon28", "乖");
        aUR.put("image_emoticon29", "睡觉");
        aUR.put("image_emoticon30", "惊哭");
        aUR.put("image_emoticon31", "生气");
        aUR.put("image_emoticon32", "惊讶");
        aUR.put("image_emoticon33", "喷");
        aUR.put("image_emoticon34", "爱心");
        aUR.put("image_emoticon35", "心碎");
        aUR.put("image_emoticon36", "玫瑰");
        aUR.put("image_emoticon37", "礼物");
        aUR.put("image_emoticon38", "彩虹");
        aUR.put("image_emoticon39", "星星月亮");
        aUR.put("image_emoticon40", "太阳");
        aUR.put("image_emoticon41", "钱币");
        aUR.put("image_emoticon42", "灯泡");
        aUR.put("image_emoticon43", "茶杯");
        aUR.put("image_emoticon44", "蛋糕");
        aUR.put("image_emoticon45", "音乐");
        aUR.put("image_emoticon46", "haha");
        aUR.put("image_emoticon47", "胜利");
        aUR.put("image_emoticon48", "大拇指");
        aUR.put("image_emoticon49", "弱");
        aUR.put("image_emoticon50", "OK");
        aUR.put("image_emoticon61", "哼");
        aUR.put("image_emoticon62", "吃瓜");
        aUR.put("image_emoticon63", "扔便便");
        aUR.put("image_emoticon64", "惊恐");
        aUR.put("image_emoticon65", "哎呦");
        aUR.put("image_emoticon66", "小乖");
        aUR.put("image_emoticon67", "捂嘴笑");
        aUR.put("image_emoticon68", "你懂的");
        aUR.put("image_emoticon69", "what");
        aUR.put("image_emoticon70", "酸爽");
        aUR.put("image_emoticon71", "呀咩爹");
        aUR.put("image_emoticon72", "笑尿");
        aUR.put("image_emoticon73", "挖鼻");
        aUR.put("image_emoticon74", "犀利");
        aUR.put("image_emoticon75", "小红脸");
        aUR.put("image_emoticon76", "懒得理");
        aUR.put("image_emoticon77", "沙发");
        aUR.put("image_emoticon78", "手纸");
        aUR.put("image_emoticon79", "香蕉");
        aUR.put("image_emoticon80", "便便");
        aUR.put("image_emoticon81", "药丸");
        aUR.put("image_emoticon82", "红领巾");
        aUR.put("image_emoticon83", "蜡烛");
        aUR.put("image_emoticon84", "三道杠");
        aUR.put("image_emoticon101", "不跟丑人说话");
        aUR.put("image_emoticon102", "么么哒");
        aUR.put("image_emoticon103", "亲亲才能起来");
        aUR.put("image_emoticon104", "伦家只是宝宝");
        aUR.put("image_emoticon105", "你是我的人");
        aUR.put("image_emoticon106", "假装看不见");
        aUR.put("image_emoticon107", "单身等撩");
        aUR.put("image_emoticon108", "吓到宝宝了");
        aUR.put("image_emoticon109", "哈哈哈");
        aUR.put("image_emoticon110", "嗯嗯");
        aUR.put("image_emoticon111", "好幸福");
        aUR.put("image_emoticon112", "宝宝不开心");
        aUR.put("image_emoticon113", "小姐姐别走");
        aUR.put("image_emoticon114", "小姐姐在吗");
        aUR.put("image_emoticon115", "小姐姐来啦");
        aUR.put("image_emoticon116", "小姐姐来玩呀");
        aUR.put("image_emoticon117", "我养你");
        aUR.put("image_emoticon118", "我是不会骗你的");
        aUR.put("image_emoticon119", "扎心了");
        aUR.put("image_emoticon120", "无聊");
        aUR.put("image_emoticon121", "月亮代表我的心");
        aUR.put("image_emoticon122", "来追我呀");
        aUR.put("image_emoticon123", "爱你的形状");
        aUR.put("image_emoticon124", "白眼");
        aUR.put("ali_001", "赖皮");
        aUR.put("ali_002", "感动");
        aUR.put("ali_003", "十分惊讶");
        aUR.put("ali_004", "怒气");
        aUR.put("ali_005", "哭泣");
        aUR.put("ali_006", "吃惊");
        aUR.put("ali_007", "嘲弄");
        aUR.put("ali_008", "飘过");
        aUR.put("ali_009", "转圈哭");
        aUR.put("ali_010", "神经病");
        aUR.put("ali_011", "揪耳朵");
        aUR.put("ali_012", "惊汗");
        aUR.put("ali_013", "隐身");
        aUR.put("ali_014", "不要嘛");
        aUR.put("ali_015", "遁");
        aUR.put("ali_016", "不公平");
        aUR.put("ali_017", "爬来了");
        aUR.put("ali_018", "蛋花哭");
        aUR.put("ali_019", "温暖");
        aUR.put("ali_020", "点头");
        aUR.put("ali_021", "撒钱");
        aUR.put("ali_022", "献花");
        aUR.put("ali_023", "寒");
        aUR.put("ali_024", "傻笑");
        aUR.put("ali_025", "扭扭");
        aUR.put("ali_026", "疯");
        aUR.put("ali_027", "抓狂");
        aUR.put("ali_028", "抓");
        aUR.put("ali_029", "蜷");
        aUR.put("ali_030", "挠墙");
        aUR.put("ali_031", "狂笑");
        aUR.put("ali_032", "抱枕");
        aUR.put("ali_033", "吼叫");
        aUR.put("ali_034", "嚷");
        aUR.put("ali_035", "唠叨");
        aUR.put("ali_036", "捏脸");
        aUR.put("ali_037", "爆笑");
        aUR.put("ali_038", "郁闷");
        aUR.put("ali_039", "潜水");
        aUR.put("ali_040", "十分开心");
        aUR.put("ali_041", "冷笑话");
        aUR.put("ali_042", "顶！");
        aUR.put("ali_043", "潜");
        aUR.put("ali_044", "画圈圈");
        aUR.put("ali_045", "玩电脑");
        aUR.put("ali_046", "狂吐");
        aUR.put("ali_047", "哭着跑");
        aUR.put("ali_048", "阿狸侠");
        aUR.put("ali_049", "冷死了");
        aUR.put("ali_050", "惆怅~");
        aUR.put("ali_051", "摸头");
        aUR.put("ali_052", "蹭");
        aUR.put("ali_053", "打滚");
        aUR.put("ali_054", "叩拜");
        aUR.put("ali_055", "摸");
        aUR.put("ali_056", "数钱");
        aUR.put("ali_057", "拖走");
        aUR.put("ali_058", "热");
        aUR.put("ali_059", "加1");
        aUR.put("ali_060", "压力");
        aUR.put("ali_061", "表逼我");
        aUR.put("ali_062", "人呢");
        aUR.put("ali_063", "摇晃");
        aUR.put("ali_064", "打地鼠");
        aUR.put("ali_065", "这个屌");
        aUR.put("ali_066", "恐慌");
        aUR.put("ali_067", "晕乎乎");
        aUR.put("ali_068", "浮云");
        aUR.put("ali_069", "给力");
        aUR.put("ali_070", "杯具了");
        aUR.put("b01", "微笑");
        aUR.put("b02", "帅哥");
        aUR.put("b03", "美女");
        aUR.put("b04", "老大");
        aUR.put("b05", "哈哈哈");
        aUR.put("b06", "奸笑");
        aUR.put("b07", "傻乐");
        aUR.put("b08", "飞吻");
        aUR.put("b09", "害羞");
        aUR.put("b10", "花痴");
        aUR.put("b11", "憧憬");
        aUR.put("b12", "你牛");
        aUR.put("b13", "鼓掌");
        aUR.put("b14", "可爱");
        aUR.put("b15", "太委屈");
        aUR.put("b16", "大哭");
        aUR.put("b17", "泪奔");
        aUR.put("b18", "寻死");
        aUR.put("b19", "非常惊讶");
        aUR.put("b20", "表示疑问");
        aUR.put("yz_001", "焦糖舞");
        aUR.put("yz_002", "翻滚");
        aUR.put("yz_003", "拍屁股做鬼脸");
        aUR.put("yz_004", "不");
        aUR.put("yz_005", "河蟹掉啦");
        aUR.put("yz_006", "哦耶");
        aUR.put("yz_007", "我倒");
        aUR.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hk(String str) {
        Integer num = aUO.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(e.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hl(String str) {
        Integer num = aUQ.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String hm(String str) {
        return aUR.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int KU() {
        return aUP.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0137a ak(Context context, String str) {
        return null;
    }
}
