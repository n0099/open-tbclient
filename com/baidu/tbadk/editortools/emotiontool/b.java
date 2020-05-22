package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> elP = new HashMap<>(200);
    public static final ArrayList<Integer> elQ = new ArrayList<>(180);
    public static final HashMap<String, Integer> elR = new HashMap<>(180);
    private static final HashMap<String, String> elS = new HashMap<>(180);

    static {
        elS.put("image_emoticon", "呵呵");
        elS.put("image_emoticon2", "哈哈");
        elS.put("image_emoticon3", "吐舌");
        elS.put("image_emoticon4", "啊");
        elS.put("image_emoticon5", "酷");
        elS.put("image_emoticon6", "怒");
        elS.put("image_emoticon7", "开心");
        elS.put("image_emoticon8", "汗");
        elS.put("image_emoticon9", "泪");
        elS.put("image_emoticon10", "黑线");
        elS.put("image_emoticon11", "鄙视");
        elS.put("image_emoticon12", "不高兴");
        elS.put("image_emoticon13", "真棒");
        elS.put("image_emoticon14", "钱");
        elS.put("image_emoticon15", "疑问");
        elS.put("image_emoticon16", "阴险");
        elS.put("image_emoticon17", "吐");
        elS.put("image_emoticon18", "咦");
        elS.put("image_emoticon19", "委屈");
        elS.put("image_emoticon20", "花心");
        elS.put("image_emoticon21", "呼~");
        elS.put("image_emoticon22", "笑眼");
        elS.put("image_emoticon23", "冷");
        elS.put("image_emoticon24", "太开心");
        elS.put("image_emoticon25", "滑稽");
        elS.put("image_emoticon26", "勉强");
        elS.put("image_emoticon27", "狂汗");
        elS.put("image_emoticon28", "乖");
        elS.put("image_emoticon29", "睡觉");
        elS.put("image_emoticon30", "惊哭");
        elS.put("image_emoticon31", "生气");
        elS.put("image_emoticon32", "惊讶");
        elS.put("image_emoticon33", "喷");
        elS.put("image_emoticon34", "爱心");
        elS.put("image_emoticon35", "心碎");
        elS.put("image_emoticon36", "玫瑰");
        elS.put("image_emoticon37", "礼物");
        elS.put("image_emoticon38", "彩虹");
        elS.put("image_emoticon39", "星星月亮");
        elS.put("image_emoticon40", "太阳");
        elS.put("image_emoticon41", "钱币");
        elS.put("image_emoticon42", "灯泡");
        elS.put("image_emoticon43", "茶杯");
        elS.put("image_emoticon44", "蛋糕");
        elS.put("image_emoticon45", "音乐");
        elS.put("image_emoticon46", "haha");
        elS.put("image_emoticon47", "胜利");
        elS.put("image_emoticon48", "大拇指");
        elS.put("image_emoticon49", "弱");
        elS.put("image_emoticon50", "OK");
        elS.put("image_emoticon61", "哼");
        elS.put("image_emoticon62", "吃瓜");
        elS.put("image_emoticon63", "扔便便");
        elS.put("image_emoticon64", "惊恐");
        elS.put("image_emoticon65", "哎呦");
        elS.put("image_emoticon66", "小乖");
        elS.put("image_emoticon67", "捂嘴笑");
        elS.put("image_emoticon68", "你懂的");
        elS.put("image_emoticon69", "what");
        elS.put("image_emoticon70", "酸爽");
        elS.put("image_emoticon71", "呀咩爹");
        elS.put("image_emoticon72", "笑尿");
        elS.put("image_emoticon73", "挖鼻");
        elS.put("image_emoticon74", "犀利");
        elS.put("image_emoticon75", "小红脸");
        elS.put("image_emoticon76", "懒得理");
        elS.put("image_emoticon77", "沙发");
        elS.put("image_emoticon78", "手纸");
        elS.put("image_emoticon79", "香蕉");
        elS.put("image_emoticon80", "便便");
        elS.put("image_emoticon81", "药丸");
        elS.put("image_emoticon82", "红领巾");
        elS.put("image_emoticon83", "蜡烛");
        elS.put("image_emoticon84", "三道杠");
        elS.put("image_emoticon85", "暗中观察");
        elS.put("image_emoticon86", "吃瓜");
        elS.put("image_emoticon87", "喝酒");
        elS.put("image_emoticon88", "嘿嘿嘿");
        elS.put("image_emoticon89", "噗");
        elS.put("image_emoticon90", "困成狗");
        elS.put("image_emoticon91", "微微一笑");
        elS.put("image_emoticon92", "托腮");
        elS.put("image_emoticon93", "摊手");
        elS.put("image_emoticon94", "柯基暗中观察");
        elS.put("image_emoticon95", "欢呼");
        elS.put("image_emoticon96", "炸药");
        elS.put("image_emoticon97", "突然兴奋");
        elS.put("image_emoticon98", "紧张");
        elS.put("image_emoticon99", "黑头瞪眼");
        elS.put("image_emoticon100", "黑头高兴");
        elS.put("image_emoticon101", "不跟丑人说话");
        elS.put("image_emoticon102", "么么哒");
        elS.put("image_emoticon103", "亲亲才能起来");
        elS.put("image_emoticon104", "伦家只是宝宝");
        elS.put("image_emoticon105", "你是我的人");
        elS.put("image_emoticon106", "假装看不见");
        elS.put("image_emoticon107", "单身等撩");
        elS.put("image_emoticon108", "吓到宝宝了");
        elS.put("image_emoticon109", "哈哈哈");
        elS.put("image_emoticon110", "嗯嗯");
        elS.put("image_emoticon111", "好幸福");
        elS.put("image_emoticon112", "宝宝不开心");
        elS.put("image_emoticon113", "小姐姐别走");
        elS.put("image_emoticon114", "小姐姐在吗");
        elS.put("image_emoticon115", "小姐姐来啦");
        elS.put("image_emoticon116", "小姐姐来玩呀");
        elS.put("image_emoticon117", "我养你");
        elS.put("image_emoticon118", "我是不会骗你的");
        elS.put("image_emoticon119", "扎心了");
        elS.put("image_emoticon120", "无聊");
        elS.put("image_emoticon121", "月亮代表我的心");
        elS.put("image_emoticon122", "来追我呀");
        elS.put("image_emoticon123", "爱你的形状");
        elS.put("image_emoticon124", "白眼");
        elS.put("ali_001", "赖皮");
        elS.put("ali_002", "感动");
        elS.put("ali_003", "十分惊讶");
        elS.put("ali_004", "怒气");
        elS.put("ali_005", "哭泣");
        elS.put("ali_006", "吃惊");
        elS.put("ali_007", "嘲弄");
        elS.put("ali_008", "飘过");
        elS.put("ali_009", "转圈哭");
        elS.put("ali_010", "神经病");
        elS.put("ali_011", "揪耳朵");
        elS.put("ali_012", "惊汗");
        elS.put("ali_013", "隐身");
        elS.put("ali_014", "不要嘛");
        elS.put("ali_015", "遁");
        elS.put("ali_016", "不公平");
        elS.put("ali_017", "爬来了");
        elS.put("ali_018", "蛋花哭");
        elS.put("ali_019", "温暖");
        elS.put("ali_020", "点头");
        elS.put("ali_021", "撒钱");
        elS.put("ali_022", "献花");
        elS.put("ali_023", "寒");
        elS.put("ali_024", "傻笑");
        elS.put("ali_025", "扭扭");
        elS.put("ali_026", "疯");
        elS.put("ali_027", "抓狂");
        elS.put("ali_028", "抓");
        elS.put("ali_029", "蜷");
        elS.put("ali_030", "挠墙");
        elS.put("ali_031", "狂笑");
        elS.put("ali_032", "抱枕");
        elS.put("ali_033", "吼叫");
        elS.put("ali_034", "嚷");
        elS.put("ali_035", "唠叨");
        elS.put("ali_036", "捏脸");
        elS.put("ali_037", "爆笑");
        elS.put("ali_038", "郁闷");
        elS.put("ali_039", "潜水");
        elS.put("ali_040", "十分开心");
        elS.put("ali_041", "冷笑话");
        elS.put("ali_042", "顶！");
        elS.put("ali_043", "潜");
        elS.put("ali_044", "画圈圈");
        elS.put("ali_045", "玩电脑");
        elS.put("ali_046", "狂吐");
        elS.put("ali_047", "哭着跑");
        elS.put("ali_048", "阿狸侠");
        elS.put("ali_049", "冷死了");
        elS.put("ali_050", "惆怅~");
        elS.put("ali_051", "摸头");
        elS.put("ali_052", "蹭");
        elS.put("ali_053", "打滚");
        elS.put("ali_054", "叩拜");
        elS.put("ali_055", "摸");
        elS.put("ali_056", "数钱");
        elS.put("ali_057", "拖走");
        elS.put("ali_058", "热");
        elS.put("ali_059", "加1");
        elS.put("ali_060", "压力");
        elS.put("ali_061", "表逼我");
        elS.put("ali_062", "人呢");
        elS.put("ali_063", "摇晃");
        elS.put("ali_064", "打地鼠");
        elS.put("ali_065", "这个屌");
        elS.put("ali_066", "恐慌");
        elS.put("ali_067", "晕乎乎");
        elS.put("ali_068", "浮云");
        elS.put("ali_069", "给力");
        elS.put("ali_070", "杯具了");
        elS.put("b01", "微笑");
        elS.put("b02", "帅哥");
        elS.put("b03", "美女");
        elS.put("b04", "老大");
        elS.put("b05", "哈哈哈");
        elS.put("b06", "奸笑");
        elS.put("b07", "傻乐");
        elS.put("b08", "飞吻");
        elS.put("b09", "害羞");
        elS.put("b10", "花痴");
        elS.put("b11", "憧憬");
        elS.put("b12", "你牛");
        elS.put("b13", "鼓掌");
        elS.put("b14", "可爱");
        elS.put("b15", "太委屈");
        elS.put("b16", "大哭");
        elS.put("b17", "泪奔");
        elS.put("b18", "寻死");
        elS.put("b19", "非常惊讶");
        elS.put("b20", "表示疑问");
        elS.put("yz_001", "焦糖舞");
        elS.put("yz_002", "翻滚");
        elS.put("yz_003", "拍屁股做鬼脸");
        elS.put("yz_004", "不");
        elS.put("yz_005", "河蟹掉啦");
        elS.put("yz_006", "哦耶");
        elS.put("yz_007", "我倒");
        elS.put("yz_008", "投降");
        elS.put("shoubai_emoji_face_01", "微笑");
        elS.put("shoubai_emoji_face_02", "开心");
        elS.put("shoubai_emoji_face_03", "期待");
        elS.put("shoubai_emoji_face_04", "大笑");
        elS.put("shoubai_emoji_face_05", "鼓掌");
        elS.put("shoubai_emoji_face_06", "悠闲");
        elS.put("shoubai_emoji_face_07", "笑哭");
        elS.put("shoubai_emoji_face_08", "不要啊");
        elS.put("shoubai_emoji_face_09", "啊");
        elS.put("shoubai_emoji_face_10", "哟");
        elS.put("shoubai_emoji_face_11", "汗");
        elS.put("shoubai_emoji_face_12", "抠鼻");
        elS.put("shoubai_emoji_face_13", "哼");
        elS.put("shoubai_emoji_face_14", "发怒");
        elS.put("shoubai_emoji_face_15", "委屈");
        elS.put("shoubai_emoji_face_16", "不高兴");
        elS.put("shoubai_emoji_face_17", "囧");
        elS.put("shoubai_emoji_face_18", "惊哭");
        elS.put("shoubai_emoji_face_19", "大哭");
        elS.put("shoubai_emoji_face_20", "流泪");
        elS.put("shoubai_emoji_face_21", "害羞");
        elS.put("shoubai_emoji_face_22", "亲亲");
        elS.put("shoubai_emoji_face_23", "色");
        elS.put("shoubai_emoji_face_24", "舔屏");
        elS.put("shoubai_emoji_face_25", "得意");
        elS.put("shoubai_emoji_face_26", "疑问");
        elS.put("shoubai_emoji_face_27", "晕");
        elS.put("shoubai_emoji_face_28", "大哈");
        elS.put("shoubai_emoji_face_29", "二哈");
        elS.put("shoubai_emoji_face_30", "三哈");
        elS.put("shoubai_emoji_face_31", "白眼");
        elS.put("shoubai_emoji_face_32", "阴险");
        elS.put("shoubai_emoji_face_33", "你懂的");
        elS.put("shoubai_emoji_face_34", "偷笑");
        elS.put("shoubai_emoji_face_35", "睡觉");
        elS.put("shoubai_emoji_face_36", "哈欠");
        elS.put("shoubai_emoji_face_37", "再见");
        elS.put("shoubai_emoji_face_38", "鄙视");
        elS.put("shoubai_emoji_face_39", "抓狂");
        elS.put("shoubai_emoji_face_40", "咒骂");
        elS.put("shoubai_emoji_face_41", "衰");
        elS.put("shoubai_emoji_face_42", "骷髅");
        elS.put("shoubai_emoji_face_43", "嘘");
        elS.put("shoubai_emoji_face_44", "闭嘴");
        elS.put("shoubai_emoji_face_45", "呆");
        elS.put("shoubai_emoji_face_46", "什么鬼");
        elS.put("shoubai_emoji_face_47", "吐");
        elS.put("shoubai_emoji_face_48", "已阅");
        elS.put("shoubai_emoji_face_49", "同上");
        elS.put("shoubai_emoji_face_50", "友军");
        elS.put("shoubai_emoji_face_51", "爱钱");
        elS.put("shoubai_emoji_face_52", "Freestyle");
        elS.put("shoubai_emoji_face_53", "国宝");
        elS.put("shoubai_emoji_face_54", "羊驼");
        elS.put("shoubai_emoji_face_55", "鲜花");
        elS.put("shoubai_emoji_face_56", "中国加油");
        elS.put("shoubai_emoji_face_57", "庆祝");
        elS.put("shoubai_emoji_face_58", "生日蛋糕");
        elS.put("shoubai_emoji_face_59", "MicDrop");
        elS.put("shoubai_emoji_face_60", "赞同");
        elS.put("shoubai_emoji_face_61", "药丸");
        elS.put("shoubai_emoji_face_62", "蜡烛");
        elS.put("shoubai_emoji_face_63", "鸡蛋");
        elS.put("shoubai_emoji_face_64", "浪");
        elS.put("shoubai_emoji_face_65", "打call");
        elS.put("shoubai_emoji_face_66", "尬笑");
        elS.put("shoubai_emoji_face_67", "坏笑");
        elS.put("shoubai_emoji_face_68", "没眼看");
        elS.put("shoubai_emoji_face_69", "嘿哈");
        elS.put("shoubai_emoji_face_70", "前面的别走");
        elS.put("shoubai_emoji_face_71", "滑稽");
        elS.put("shoubai_emoji_face_72", "捂脸");
        elS.put("shoubai_emoji_face_73", "左捂脸");
        elS.put("shoubai_emoji_face_74", "666");
        elS.put("shoubai_emoji_face_75", "2018");
        elS.put("shoubai_emoji_face_76", "福");
        elS.put("shoubai_emoji_face_77", "红包");
        elS.put("shoubai_emoji_face_78", "鞭炮");
        elS.put("shoubai_emoji_face_79", "财神");
        elS.put("shoubai_emoji_face_80", "饺子");
        elS.put("shoubai_emoji_face_81", "车票");
        elS.put("shoubai_emoji_face_82", "火车");
        elS.put("shoubai_emoji_face_83", "飞机");
        elS.put("shoubai_emoji_face_84", "射门");
        elS.put("shoubai_emoji_face_85", "红牌");
        elS.put("shoubai_emoji_face_86", "黄牌");
        elS.put("shoubai_emoji_face_87", "哨子");
        elS.put("shoubai_emoji_face_88", "比分");
        elS.put("shoubai_emoji_face_89", "啤酒");
        elS.put("shoubai_emoji_face_90", "足球");
        elS.put("shoubai_emoji_face_91", "大力神杯");
        elS.put("shoubai_emoji_face_92", "锦鲤");
        elS.put("shoubai_emoji_face_93", "2019");
        elS.put("shoubai_emoji_face_94", "猪年");
        elS.put("shoubai_emoji_face_95", "双手鼓掌");
        elS.put("shoubai_emoji_face_96", "火焰");
        elS.put("shoubai_emoji_face_97", "祈福");
        elS.put("shoubai_emoji_face_98", "亲吻");
        elS.put("shoubai_emoji_face_99", "天使");
        elS.put("shoubai_emoji_face_100", "樱花");
        elS.put("shoubai_emoji_face_101", "加油");
        elS.put("shoubai_emoji_face_102", "泡泡枪");
        elS.put("shoubai_emoji_face_103", "气球");
        elS.put("shoubai_emoji_face_104", "棒棒糖");
        elS.put("shoubai_emoji_face_105", "小黄鸭");
        elS.put("shoubai_emoji_face_106", "粽子");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int xY(String str) {
        Integer num = elP.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int xZ(String str) {
        Integer num = elR.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String ya(String str) {
        return elS.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int bdj() {
        return elQ.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0490a aj(Context context, String str) {
        return null;
    }
}
