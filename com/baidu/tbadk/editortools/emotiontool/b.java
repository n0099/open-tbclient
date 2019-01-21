package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aZP = new HashMap<>(200);
    public static final ArrayList<Integer> aZQ = new ArrayList<>(180);
    public static final HashMap<String, Integer> aZR = new HashMap<>(180);
    private static final HashMap<String, String> aZS = new HashMap<>(180);

    static {
        aZS.put("image_emoticon", "呵呵");
        aZS.put("image_emoticon2", "哈哈");
        aZS.put("image_emoticon3", "吐舌");
        aZS.put("image_emoticon4", "啊");
        aZS.put("image_emoticon5", "酷");
        aZS.put("image_emoticon6", "怒");
        aZS.put("image_emoticon7", "开心");
        aZS.put("image_emoticon8", "汗");
        aZS.put("image_emoticon9", "泪");
        aZS.put("image_emoticon10", "黑线");
        aZS.put("image_emoticon11", "鄙视");
        aZS.put("image_emoticon12", "不高兴");
        aZS.put("image_emoticon13", "真棒");
        aZS.put("image_emoticon14", "钱");
        aZS.put("image_emoticon15", "疑问");
        aZS.put("image_emoticon16", "阴险");
        aZS.put("image_emoticon17", "吐");
        aZS.put("image_emoticon18", "咦");
        aZS.put("image_emoticon19", "委屈");
        aZS.put("image_emoticon20", "花心");
        aZS.put("image_emoticon21", "呼~");
        aZS.put("image_emoticon22", "笑眼");
        aZS.put("image_emoticon23", "冷");
        aZS.put("image_emoticon24", "太开心");
        aZS.put("image_emoticon25", "滑稽");
        aZS.put("image_emoticon26", "勉强");
        aZS.put("image_emoticon27", "狂汗");
        aZS.put("image_emoticon28", "乖");
        aZS.put("image_emoticon29", "睡觉");
        aZS.put("image_emoticon30", "惊哭");
        aZS.put("image_emoticon31", "生气");
        aZS.put("image_emoticon32", "惊讶");
        aZS.put("image_emoticon33", "喷");
        aZS.put("image_emoticon34", "爱心");
        aZS.put("image_emoticon35", "心碎");
        aZS.put("image_emoticon36", "玫瑰");
        aZS.put("image_emoticon37", "礼物");
        aZS.put("image_emoticon38", "彩虹");
        aZS.put("image_emoticon39", "星星月亮");
        aZS.put("image_emoticon40", "太阳");
        aZS.put("image_emoticon41", "钱币");
        aZS.put("image_emoticon42", "灯泡");
        aZS.put("image_emoticon43", "茶杯");
        aZS.put("image_emoticon44", "蛋糕");
        aZS.put("image_emoticon45", "音乐");
        aZS.put("image_emoticon46", "haha");
        aZS.put("image_emoticon47", "胜利");
        aZS.put("image_emoticon48", "大拇指");
        aZS.put("image_emoticon49", "弱");
        aZS.put("image_emoticon50", "OK");
        aZS.put("image_emoticon61", "哼");
        aZS.put("image_emoticon62", "吃瓜");
        aZS.put("image_emoticon63", "扔便便");
        aZS.put("image_emoticon64", "惊恐");
        aZS.put("image_emoticon65", "哎呦");
        aZS.put("image_emoticon66", "小乖");
        aZS.put("image_emoticon67", "捂嘴笑");
        aZS.put("image_emoticon68", "你懂的");
        aZS.put("image_emoticon69", "what");
        aZS.put("image_emoticon70", "酸爽");
        aZS.put("image_emoticon71", "呀咩爹");
        aZS.put("image_emoticon72", "笑尿");
        aZS.put("image_emoticon73", "挖鼻");
        aZS.put("image_emoticon74", "犀利");
        aZS.put("image_emoticon75", "小红脸");
        aZS.put("image_emoticon76", "懒得理");
        aZS.put("image_emoticon77", "沙发");
        aZS.put("image_emoticon78", "手纸");
        aZS.put("image_emoticon79", "香蕉");
        aZS.put("image_emoticon80", "便便");
        aZS.put("image_emoticon81", "药丸");
        aZS.put("image_emoticon82", "红领巾");
        aZS.put("image_emoticon83", "蜡烛");
        aZS.put("image_emoticon84", "三道杠");
        aZS.put("image_emoticon101", "不跟丑人说话");
        aZS.put("image_emoticon102", "么么哒");
        aZS.put("image_emoticon103", "亲亲才能起来");
        aZS.put("image_emoticon104", "伦家只是宝宝");
        aZS.put("image_emoticon105", "你是我的人");
        aZS.put("image_emoticon106", "假装看不见");
        aZS.put("image_emoticon107", "单身等撩");
        aZS.put("image_emoticon108", "吓到宝宝了");
        aZS.put("image_emoticon109", "哈哈哈");
        aZS.put("image_emoticon110", "嗯嗯");
        aZS.put("image_emoticon111", "好幸福");
        aZS.put("image_emoticon112", "宝宝不开心");
        aZS.put("image_emoticon113", "小姐姐别走");
        aZS.put("image_emoticon114", "小姐姐在吗");
        aZS.put("image_emoticon115", "小姐姐来啦");
        aZS.put("image_emoticon116", "小姐姐来玩呀");
        aZS.put("image_emoticon117", "我养你");
        aZS.put("image_emoticon118", "我是不会骗你的");
        aZS.put("image_emoticon119", "扎心了");
        aZS.put("image_emoticon120", "无聊");
        aZS.put("image_emoticon121", "月亮代表我的心");
        aZS.put("image_emoticon122", "来追我呀");
        aZS.put("image_emoticon123", "爱你的形状");
        aZS.put("image_emoticon124", "白眼");
        aZS.put("ali_001", "赖皮");
        aZS.put("ali_002", "感动");
        aZS.put("ali_003", "十分惊讶");
        aZS.put("ali_004", "怒气");
        aZS.put("ali_005", "哭泣");
        aZS.put("ali_006", "吃惊");
        aZS.put("ali_007", "嘲弄");
        aZS.put("ali_008", "飘过");
        aZS.put("ali_009", "转圈哭");
        aZS.put("ali_010", "神经病");
        aZS.put("ali_011", "揪耳朵");
        aZS.put("ali_012", "惊汗");
        aZS.put("ali_013", "隐身");
        aZS.put("ali_014", "不要嘛");
        aZS.put("ali_015", "遁");
        aZS.put("ali_016", "不公平");
        aZS.put("ali_017", "爬来了");
        aZS.put("ali_018", "蛋花哭");
        aZS.put("ali_019", "温暖");
        aZS.put("ali_020", "点头");
        aZS.put("ali_021", "撒钱");
        aZS.put("ali_022", "献花");
        aZS.put("ali_023", "寒");
        aZS.put("ali_024", "傻笑");
        aZS.put("ali_025", "扭扭");
        aZS.put("ali_026", "疯");
        aZS.put("ali_027", "抓狂");
        aZS.put("ali_028", "抓");
        aZS.put("ali_029", "蜷");
        aZS.put("ali_030", "挠墙");
        aZS.put("ali_031", "狂笑");
        aZS.put("ali_032", "抱枕");
        aZS.put("ali_033", "吼叫");
        aZS.put("ali_034", "嚷");
        aZS.put("ali_035", "唠叨");
        aZS.put("ali_036", "捏脸");
        aZS.put("ali_037", "爆笑");
        aZS.put("ali_038", "郁闷");
        aZS.put("ali_039", "潜水");
        aZS.put("ali_040", "十分开心");
        aZS.put("ali_041", "冷笑话");
        aZS.put("ali_042", "顶！");
        aZS.put("ali_043", "潜");
        aZS.put("ali_044", "画圈圈");
        aZS.put("ali_045", "玩电脑");
        aZS.put("ali_046", "狂吐");
        aZS.put("ali_047", "哭着跑");
        aZS.put("ali_048", "阿狸侠");
        aZS.put("ali_049", "冷死了");
        aZS.put("ali_050", "惆怅~");
        aZS.put("ali_051", "摸头");
        aZS.put("ali_052", "蹭");
        aZS.put("ali_053", "打滚");
        aZS.put("ali_054", "叩拜");
        aZS.put("ali_055", "摸");
        aZS.put("ali_056", "数钱");
        aZS.put("ali_057", "拖走");
        aZS.put("ali_058", "热");
        aZS.put("ali_059", "加1");
        aZS.put("ali_060", "压力");
        aZS.put("ali_061", "表逼我");
        aZS.put("ali_062", "人呢");
        aZS.put("ali_063", "摇晃");
        aZS.put("ali_064", "打地鼠");
        aZS.put("ali_065", "这个屌");
        aZS.put("ali_066", "恐慌");
        aZS.put("ali_067", "晕乎乎");
        aZS.put("ali_068", "浮云");
        aZS.put("ali_069", "给力");
        aZS.put("ali_070", "杯具了");
        aZS.put("b01", "微笑");
        aZS.put("b02", "帅哥");
        aZS.put("b03", "美女");
        aZS.put("b04", "老大");
        aZS.put("b05", "哈哈哈");
        aZS.put("b06", "奸笑");
        aZS.put("b07", "傻乐");
        aZS.put("b08", "飞吻");
        aZS.put("b09", "害羞");
        aZS.put("b10", "花痴");
        aZS.put("b11", "憧憬");
        aZS.put("b12", "你牛");
        aZS.put("b13", "鼓掌");
        aZS.put("b14", "可爱");
        aZS.put("b15", "太委屈");
        aZS.put("b16", "大哭");
        aZS.put("b17", "泪奔");
        aZS.put("b18", "寻死");
        aZS.put("b19", "非常惊讶");
        aZS.put("b20", "表示疑问");
        aZS.put("yz_001", "焦糖舞");
        aZS.put("yz_002", "翻滚");
        aZS.put("yz_003", "拍屁股做鬼脸");
        aZS.put("yz_004", "不");
        aZS.put("yz_005", "河蟹掉啦");
        aZS.put("yz_006", "哦耶");
        aZS.put("yz_007", "我倒");
        aZS.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hS(String str) {
        Integer num = aZP.get(str);
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
        Integer num = aZR.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String hU(String str) {
        return aZS.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int MC() {
        return aZQ.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0171a aj(Context context, String str) {
        return null;
    }
}
