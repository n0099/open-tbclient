package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aZO = new HashMap<>(200);
    public static final ArrayList<Integer> aZP = new ArrayList<>(180);
    public static final HashMap<String, Integer> aZQ = new HashMap<>(180);
    private static final HashMap<String, String> aZR = new HashMap<>(180);

    static {
        aZR.put("image_emoticon", "呵呵");
        aZR.put("image_emoticon2", "哈哈");
        aZR.put("image_emoticon3", "吐舌");
        aZR.put("image_emoticon4", "啊");
        aZR.put("image_emoticon5", "酷");
        aZR.put("image_emoticon6", "怒");
        aZR.put("image_emoticon7", "开心");
        aZR.put("image_emoticon8", "汗");
        aZR.put("image_emoticon9", "泪");
        aZR.put("image_emoticon10", "黑线");
        aZR.put("image_emoticon11", "鄙视");
        aZR.put("image_emoticon12", "不高兴");
        aZR.put("image_emoticon13", "真棒");
        aZR.put("image_emoticon14", "钱");
        aZR.put("image_emoticon15", "疑问");
        aZR.put("image_emoticon16", "阴险");
        aZR.put("image_emoticon17", "吐");
        aZR.put("image_emoticon18", "咦");
        aZR.put("image_emoticon19", "委屈");
        aZR.put("image_emoticon20", "花心");
        aZR.put("image_emoticon21", "呼~");
        aZR.put("image_emoticon22", "笑眼");
        aZR.put("image_emoticon23", "冷");
        aZR.put("image_emoticon24", "太开心");
        aZR.put("image_emoticon25", "滑稽");
        aZR.put("image_emoticon26", "勉强");
        aZR.put("image_emoticon27", "狂汗");
        aZR.put("image_emoticon28", "乖");
        aZR.put("image_emoticon29", "睡觉");
        aZR.put("image_emoticon30", "惊哭");
        aZR.put("image_emoticon31", "生气");
        aZR.put("image_emoticon32", "惊讶");
        aZR.put("image_emoticon33", "喷");
        aZR.put("image_emoticon34", "爱心");
        aZR.put("image_emoticon35", "心碎");
        aZR.put("image_emoticon36", "玫瑰");
        aZR.put("image_emoticon37", "礼物");
        aZR.put("image_emoticon38", "彩虹");
        aZR.put("image_emoticon39", "星星月亮");
        aZR.put("image_emoticon40", "太阳");
        aZR.put("image_emoticon41", "钱币");
        aZR.put("image_emoticon42", "灯泡");
        aZR.put("image_emoticon43", "茶杯");
        aZR.put("image_emoticon44", "蛋糕");
        aZR.put("image_emoticon45", "音乐");
        aZR.put("image_emoticon46", "haha");
        aZR.put("image_emoticon47", "胜利");
        aZR.put("image_emoticon48", "大拇指");
        aZR.put("image_emoticon49", "弱");
        aZR.put("image_emoticon50", "OK");
        aZR.put("image_emoticon61", "哼");
        aZR.put("image_emoticon62", "吃瓜");
        aZR.put("image_emoticon63", "扔便便");
        aZR.put("image_emoticon64", "惊恐");
        aZR.put("image_emoticon65", "哎呦");
        aZR.put("image_emoticon66", "小乖");
        aZR.put("image_emoticon67", "捂嘴笑");
        aZR.put("image_emoticon68", "你懂的");
        aZR.put("image_emoticon69", "what");
        aZR.put("image_emoticon70", "酸爽");
        aZR.put("image_emoticon71", "呀咩爹");
        aZR.put("image_emoticon72", "笑尿");
        aZR.put("image_emoticon73", "挖鼻");
        aZR.put("image_emoticon74", "犀利");
        aZR.put("image_emoticon75", "小红脸");
        aZR.put("image_emoticon76", "懒得理");
        aZR.put("image_emoticon77", "沙发");
        aZR.put("image_emoticon78", "手纸");
        aZR.put("image_emoticon79", "香蕉");
        aZR.put("image_emoticon80", "便便");
        aZR.put("image_emoticon81", "药丸");
        aZR.put("image_emoticon82", "红领巾");
        aZR.put("image_emoticon83", "蜡烛");
        aZR.put("image_emoticon84", "三道杠");
        aZR.put("image_emoticon101", "不跟丑人说话");
        aZR.put("image_emoticon102", "么么哒");
        aZR.put("image_emoticon103", "亲亲才能起来");
        aZR.put("image_emoticon104", "伦家只是宝宝");
        aZR.put("image_emoticon105", "你是我的人");
        aZR.put("image_emoticon106", "假装看不见");
        aZR.put("image_emoticon107", "单身等撩");
        aZR.put("image_emoticon108", "吓到宝宝了");
        aZR.put("image_emoticon109", "哈哈哈");
        aZR.put("image_emoticon110", "嗯嗯");
        aZR.put("image_emoticon111", "好幸福");
        aZR.put("image_emoticon112", "宝宝不开心");
        aZR.put("image_emoticon113", "小姐姐别走");
        aZR.put("image_emoticon114", "小姐姐在吗");
        aZR.put("image_emoticon115", "小姐姐来啦");
        aZR.put("image_emoticon116", "小姐姐来玩呀");
        aZR.put("image_emoticon117", "我养你");
        aZR.put("image_emoticon118", "我是不会骗你的");
        aZR.put("image_emoticon119", "扎心了");
        aZR.put("image_emoticon120", "无聊");
        aZR.put("image_emoticon121", "月亮代表我的心");
        aZR.put("image_emoticon122", "来追我呀");
        aZR.put("image_emoticon123", "爱你的形状");
        aZR.put("image_emoticon124", "白眼");
        aZR.put("ali_001", "赖皮");
        aZR.put("ali_002", "感动");
        aZR.put("ali_003", "十分惊讶");
        aZR.put("ali_004", "怒气");
        aZR.put("ali_005", "哭泣");
        aZR.put("ali_006", "吃惊");
        aZR.put("ali_007", "嘲弄");
        aZR.put("ali_008", "飘过");
        aZR.put("ali_009", "转圈哭");
        aZR.put("ali_010", "神经病");
        aZR.put("ali_011", "揪耳朵");
        aZR.put("ali_012", "惊汗");
        aZR.put("ali_013", "隐身");
        aZR.put("ali_014", "不要嘛");
        aZR.put("ali_015", "遁");
        aZR.put("ali_016", "不公平");
        aZR.put("ali_017", "爬来了");
        aZR.put("ali_018", "蛋花哭");
        aZR.put("ali_019", "温暖");
        aZR.put("ali_020", "点头");
        aZR.put("ali_021", "撒钱");
        aZR.put("ali_022", "献花");
        aZR.put("ali_023", "寒");
        aZR.put("ali_024", "傻笑");
        aZR.put("ali_025", "扭扭");
        aZR.put("ali_026", "疯");
        aZR.put("ali_027", "抓狂");
        aZR.put("ali_028", "抓");
        aZR.put("ali_029", "蜷");
        aZR.put("ali_030", "挠墙");
        aZR.put("ali_031", "狂笑");
        aZR.put("ali_032", "抱枕");
        aZR.put("ali_033", "吼叫");
        aZR.put("ali_034", "嚷");
        aZR.put("ali_035", "唠叨");
        aZR.put("ali_036", "捏脸");
        aZR.put("ali_037", "爆笑");
        aZR.put("ali_038", "郁闷");
        aZR.put("ali_039", "潜水");
        aZR.put("ali_040", "十分开心");
        aZR.put("ali_041", "冷笑话");
        aZR.put("ali_042", "顶！");
        aZR.put("ali_043", "潜");
        aZR.put("ali_044", "画圈圈");
        aZR.put("ali_045", "玩电脑");
        aZR.put("ali_046", "狂吐");
        aZR.put("ali_047", "哭着跑");
        aZR.put("ali_048", "阿狸侠");
        aZR.put("ali_049", "冷死了");
        aZR.put("ali_050", "惆怅~");
        aZR.put("ali_051", "摸头");
        aZR.put("ali_052", "蹭");
        aZR.put("ali_053", "打滚");
        aZR.put("ali_054", "叩拜");
        aZR.put("ali_055", "摸");
        aZR.put("ali_056", "数钱");
        aZR.put("ali_057", "拖走");
        aZR.put("ali_058", "热");
        aZR.put("ali_059", "加1");
        aZR.put("ali_060", "压力");
        aZR.put("ali_061", "表逼我");
        aZR.put("ali_062", "人呢");
        aZR.put("ali_063", "摇晃");
        aZR.put("ali_064", "打地鼠");
        aZR.put("ali_065", "这个屌");
        aZR.put("ali_066", "恐慌");
        aZR.put("ali_067", "晕乎乎");
        aZR.put("ali_068", "浮云");
        aZR.put("ali_069", "给力");
        aZR.put("ali_070", "杯具了");
        aZR.put("b01", "微笑");
        aZR.put("b02", "帅哥");
        aZR.put("b03", "美女");
        aZR.put("b04", "老大");
        aZR.put("b05", "哈哈哈");
        aZR.put("b06", "奸笑");
        aZR.put("b07", "傻乐");
        aZR.put("b08", "飞吻");
        aZR.put("b09", "害羞");
        aZR.put("b10", "花痴");
        aZR.put("b11", "憧憬");
        aZR.put("b12", "你牛");
        aZR.put("b13", "鼓掌");
        aZR.put("b14", "可爱");
        aZR.put("b15", "太委屈");
        aZR.put("b16", "大哭");
        aZR.put("b17", "泪奔");
        aZR.put("b18", "寻死");
        aZR.put("b19", "非常惊讶");
        aZR.put("b20", "表示疑问");
        aZR.put("yz_001", "焦糖舞");
        aZR.put("yz_002", "翻滚");
        aZR.put("yz_003", "拍屁股做鬼脸");
        aZR.put("yz_004", "不");
        aZR.put("yz_005", "河蟹掉啦");
        aZR.put("yz_006", "哦耶");
        aZR.put("yz_007", "我倒");
        aZR.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hS(String str) {
        Integer num = aZO.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(e.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hT(String str) {
        Integer num = aZQ.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String hU(String str) {
        return aZR.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int MC() {
        return aZP.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0171a aj(Context context, String str) {
        return null;
    }
}
