package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aVE = new HashMap<>(200);
    public static final ArrayList<Integer> aVF = new ArrayList<>(180);
    public static final HashMap<String, Integer> aVG = new HashMap<>(180);
    private static final HashMap<String, String> aVH = new HashMap<>(180);

    static {
        aVH.put("image_emoticon", "呵呵");
        aVH.put("image_emoticon2", "哈哈");
        aVH.put("image_emoticon3", "吐舌");
        aVH.put("image_emoticon4", "啊");
        aVH.put("image_emoticon5", "酷");
        aVH.put("image_emoticon6", "怒");
        aVH.put("image_emoticon7", "开心");
        aVH.put("image_emoticon8", "汗");
        aVH.put("image_emoticon9", "泪");
        aVH.put("image_emoticon10", "黑线");
        aVH.put("image_emoticon11", "鄙视");
        aVH.put("image_emoticon12", "不高兴");
        aVH.put("image_emoticon13", "真棒");
        aVH.put("image_emoticon14", "钱");
        aVH.put("image_emoticon15", "疑问");
        aVH.put("image_emoticon16", "阴险");
        aVH.put("image_emoticon17", "吐");
        aVH.put("image_emoticon18", "咦");
        aVH.put("image_emoticon19", "委屈");
        aVH.put("image_emoticon20", "花心");
        aVH.put("image_emoticon21", "呼~");
        aVH.put("image_emoticon22", "笑眼");
        aVH.put("image_emoticon23", "冷");
        aVH.put("image_emoticon24", "太开心");
        aVH.put("image_emoticon25", "滑稽");
        aVH.put("image_emoticon26", "勉强");
        aVH.put("image_emoticon27", "狂汗");
        aVH.put("image_emoticon28", "乖");
        aVH.put("image_emoticon29", "睡觉");
        aVH.put("image_emoticon30", "惊哭");
        aVH.put("image_emoticon31", "生气");
        aVH.put("image_emoticon32", "惊讶");
        aVH.put("image_emoticon33", "喷");
        aVH.put("image_emoticon34", "爱心");
        aVH.put("image_emoticon35", "心碎");
        aVH.put("image_emoticon36", "玫瑰");
        aVH.put("image_emoticon37", "礼物");
        aVH.put("image_emoticon38", "彩虹");
        aVH.put("image_emoticon39", "星星月亮");
        aVH.put("image_emoticon40", "太阳");
        aVH.put("image_emoticon41", "钱币");
        aVH.put("image_emoticon42", "灯泡");
        aVH.put("image_emoticon43", "茶杯");
        aVH.put("image_emoticon44", "蛋糕");
        aVH.put("image_emoticon45", "音乐");
        aVH.put("image_emoticon46", "haha");
        aVH.put("image_emoticon47", "胜利");
        aVH.put("image_emoticon48", "大拇指");
        aVH.put("image_emoticon49", "弱");
        aVH.put("image_emoticon50", "OK");
        aVH.put("image_emoticon61", "哼");
        aVH.put("image_emoticon62", "吃瓜");
        aVH.put("image_emoticon63", "扔便便");
        aVH.put("image_emoticon64", "惊恐");
        aVH.put("image_emoticon65", "哎呦");
        aVH.put("image_emoticon66", "小乖");
        aVH.put("image_emoticon67", "捂嘴笑");
        aVH.put("image_emoticon68", "你懂的");
        aVH.put("image_emoticon69", "what");
        aVH.put("image_emoticon70", "酸爽");
        aVH.put("image_emoticon71", "呀咩爹");
        aVH.put("image_emoticon72", "笑尿");
        aVH.put("image_emoticon73", "挖鼻");
        aVH.put("image_emoticon74", "犀利");
        aVH.put("image_emoticon75", "小红脸");
        aVH.put("image_emoticon76", "懒得理");
        aVH.put("image_emoticon77", "沙发");
        aVH.put("image_emoticon78", "手纸");
        aVH.put("image_emoticon79", "香蕉");
        aVH.put("image_emoticon80", "便便");
        aVH.put("image_emoticon81", "药丸");
        aVH.put("image_emoticon82", "红领巾");
        aVH.put("image_emoticon83", "蜡烛");
        aVH.put("image_emoticon84", "三道杠");
        aVH.put("image_emoticon101", "不跟丑人说话");
        aVH.put("image_emoticon102", "么么哒");
        aVH.put("image_emoticon103", "亲亲才能起来");
        aVH.put("image_emoticon104", "伦家只是宝宝");
        aVH.put("image_emoticon105", "你是我的人");
        aVH.put("image_emoticon106", "假装看不见");
        aVH.put("image_emoticon107", "单身等撩");
        aVH.put("image_emoticon108", "吓到宝宝了");
        aVH.put("image_emoticon109", "哈哈哈");
        aVH.put("image_emoticon110", "嗯嗯");
        aVH.put("image_emoticon111", "好幸福");
        aVH.put("image_emoticon112", "宝宝不开心");
        aVH.put("image_emoticon113", "小姐姐别走");
        aVH.put("image_emoticon114", "小姐姐在吗");
        aVH.put("image_emoticon115", "小姐姐来啦");
        aVH.put("image_emoticon116", "小姐姐来玩呀");
        aVH.put("image_emoticon117", "我养你");
        aVH.put("image_emoticon118", "我是不会骗你的");
        aVH.put("image_emoticon119", "扎心了");
        aVH.put("image_emoticon120", "无聊");
        aVH.put("image_emoticon121", "月亮代表我的心");
        aVH.put("image_emoticon122", "来追我呀");
        aVH.put("image_emoticon123", "爱你的形状");
        aVH.put("image_emoticon124", "白眼");
        aVH.put("ali_001", "赖皮");
        aVH.put("ali_002", "感动");
        aVH.put("ali_003", "十分惊讶");
        aVH.put("ali_004", "怒气");
        aVH.put("ali_005", "哭泣");
        aVH.put("ali_006", "吃惊");
        aVH.put("ali_007", "嘲弄");
        aVH.put("ali_008", "飘过");
        aVH.put("ali_009", "转圈哭");
        aVH.put("ali_010", "神经病");
        aVH.put("ali_011", "揪耳朵");
        aVH.put("ali_012", "惊汗");
        aVH.put("ali_013", "隐身");
        aVH.put("ali_014", "不要嘛");
        aVH.put("ali_015", "遁");
        aVH.put("ali_016", "不公平");
        aVH.put("ali_017", "爬来了");
        aVH.put("ali_018", "蛋花哭");
        aVH.put("ali_019", "温暖");
        aVH.put("ali_020", "点头");
        aVH.put("ali_021", "撒钱");
        aVH.put("ali_022", "献花");
        aVH.put("ali_023", "寒");
        aVH.put("ali_024", "傻笑");
        aVH.put("ali_025", "扭扭");
        aVH.put("ali_026", "疯");
        aVH.put("ali_027", "抓狂");
        aVH.put("ali_028", "抓");
        aVH.put("ali_029", "蜷");
        aVH.put("ali_030", "挠墙");
        aVH.put("ali_031", "狂笑");
        aVH.put("ali_032", "抱枕");
        aVH.put("ali_033", "吼叫");
        aVH.put("ali_034", "嚷");
        aVH.put("ali_035", "唠叨");
        aVH.put("ali_036", "捏脸");
        aVH.put("ali_037", "爆笑");
        aVH.put("ali_038", "郁闷");
        aVH.put("ali_039", "潜水");
        aVH.put("ali_040", "十分开心");
        aVH.put("ali_041", "冷笑话");
        aVH.put("ali_042", "顶！");
        aVH.put("ali_043", "潜");
        aVH.put("ali_044", "画圈圈");
        aVH.put("ali_045", "玩电脑");
        aVH.put("ali_046", "狂吐");
        aVH.put("ali_047", "哭着跑");
        aVH.put("ali_048", "阿狸侠");
        aVH.put("ali_049", "冷死了");
        aVH.put("ali_050", "惆怅~");
        aVH.put("ali_051", "摸头");
        aVH.put("ali_052", "蹭");
        aVH.put("ali_053", "打滚");
        aVH.put("ali_054", "叩拜");
        aVH.put("ali_055", "摸");
        aVH.put("ali_056", "数钱");
        aVH.put("ali_057", "拖走");
        aVH.put("ali_058", "热");
        aVH.put("ali_059", "加1");
        aVH.put("ali_060", "压力");
        aVH.put("ali_061", "表逼我");
        aVH.put("ali_062", "人呢");
        aVH.put("ali_063", "摇晃");
        aVH.put("ali_064", "打地鼠");
        aVH.put("ali_065", "这个屌");
        aVH.put("ali_066", "恐慌");
        aVH.put("ali_067", "晕乎乎");
        aVH.put("ali_068", "浮云");
        aVH.put("ali_069", "给力");
        aVH.put("ali_070", "杯具了");
        aVH.put("b01", "微笑");
        aVH.put("b02", "帅哥");
        aVH.put("b03", "美女");
        aVH.put("b04", "老大");
        aVH.put("b05", "哈哈哈");
        aVH.put("b06", "奸笑");
        aVH.put("b07", "傻乐");
        aVH.put("b08", "飞吻");
        aVH.put("b09", "害羞");
        aVH.put("b10", "花痴");
        aVH.put("b11", "憧憬");
        aVH.put("b12", "你牛");
        aVH.put("b13", "鼓掌");
        aVH.put("b14", "可爱");
        aVH.put("b15", "太委屈");
        aVH.put("b16", "大哭");
        aVH.put("b17", "泪奔");
        aVH.put("b18", "寻死");
        aVH.put("b19", "非常惊讶");
        aVH.put("b20", "表示疑问");
        aVH.put("yz_001", "焦糖舞");
        aVH.put("yz_002", "翻滚");
        aVH.put("yz_003", "拍屁股做鬼脸");
        aVH.put("yz_004", "不");
        aVH.put("yz_005", "河蟹掉啦");
        aVH.put("yz_006", "哦耶");
        aVH.put("yz_007", "我倒");
        aVH.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hl(String str) {
        Integer num = aVE.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(e.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int hm(String str) {
        Integer num = aVG.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String hn(String str) {
        return aVH.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Lg() {
        return aVF.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0161a ai(Context context, String str) {
        return null;
    }
}
