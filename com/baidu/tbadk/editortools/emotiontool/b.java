package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> csN = new HashMap<>(200);
    public static final ArrayList<Integer> csO = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> csP = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> csQ = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        csQ.put("image_emoticon", "呵呵");
        csQ.put("image_emoticon2", "哈哈");
        csQ.put("image_emoticon3", "吐舌");
        csQ.put("image_emoticon4", "啊");
        csQ.put("image_emoticon5", "酷");
        csQ.put("image_emoticon6", "怒");
        csQ.put("image_emoticon7", "开心");
        csQ.put("image_emoticon8", "汗");
        csQ.put("image_emoticon9", "泪");
        csQ.put("image_emoticon10", "黑线");
        csQ.put("image_emoticon11", "鄙视");
        csQ.put("image_emoticon12", "不高兴");
        csQ.put("image_emoticon13", "真棒");
        csQ.put("image_emoticon14", "钱");
        csQ.put("image_emoticon15", "疑问");
        csQ.put("image_emoticon16", "阴险");
        csQ.put("image_emoticon17", "吐");
        csQ.put("image_emoticon18", "咦");
        csQ.put("image_emoticon19", "委屈");
        csQ.put("image_emoticon20", "花心");
        csQ.put("image_emoticon21", "呼~");
        csQ.put("image_emoticon22", "笑眼");
        csQ.put("image_emoticon23", "冷");
        csQ.put("image_emoticon24", "太开心");
        csQ.put("image_emoticon25", "滑稽");
        csQ.put("image_emoticon26", "勉强");
        csQ.put("image_emoticon27", "狂汗");
        csQ.put("image_emoticon28", "乖");
        csQ.put("image_emoticon29", "睡觉");
        csQ.put("image_emoticon30", "惊哭");
        csQ.put("image_emoticon31", "生气");
        csQ.put("image_emoticon32", "惊讶");
        csQ.put("image_emoticon33", "喷");
        csQ.put("image_emoticon34", "爱心");
        csQ.put("image_emoticon35", "心碎");
        csQ.put("image_emoticon36", "玫瑰");
        csQ.put("image_emoticon37", "礼物");
        csQ.put("image_emoticon38", "彩虹");
        csQ.put("image_emoticon39", "星星月亮");
        csQ.put("image_emoticon40", "太阳");
        csQ.put("image_emoticon41", "钱币");
        csQ.put("image_emoticon42", "灯泡");
        csQ.put("image_emoticon43", "茶杯");
        csQ.put("image_emoticon44", "蛋糕");
        csQ.put("image_emoticon45", "音乐");
        csQ.put("image_emoticon46", "haha");
        csQ.put("image_emoticon47", "胜利");
        csQ.put("image_emoticon48", "大拇指");
        csQ.put("image_emoticon49", "弱");
        csQ.put("image_emoticon50", "OK");
        csQ.put("image_emoticon61", "哼");
        csQ.put("image_emoticon62", "吃瓜");
        csQ.put("image_emoticon63", "扔便便");
        csQ.put("image_emoticon64", "惊恐");
        csQ.put("image_emoticon65", "哎呦");
        csQ.put("image_emoticon66", "小乖");
        csQ.put("image_emoticon67", "捂嘴笑");
        csQ.put("image_emoticon68", "你懂的");
        csQ.put("image_emoticon69", "what");
        csQ.put("image_emoticon70", "酸爽");
        csQ.put("image_emoticon71", "呀咩爹");
        csQ.put("image_emoticon72", "笑尿");
        csQ.put("image_emoticon73", "挖鼻");
        csQ.put("image_emoticon74", "犀利");
        csQ.put("image_emoticon75", "小红脸");
        csQ.put("image_emoticon76", "懒得理");
        csQ.put("image_emoticon77", "沙发");
        csQ.put("image_emoticon78", "手纸");
        csQ.put("image_emoticon79", "香蕉");
        csQ.put("image_emoticon80", "便便");
        csQ.put("image_emoticon81", "药丸");
        csQ.put("image_emoticon82", "红领巾");
        csQ.put("image_emoticon83", "蜡烛");
        csQ.put("image_emoticon84", "三道杠");
        csQ.put("image_emoticon101", "不跟丑人说话");
        csQ.put("image_emoticon102", "么么哒");
        csQ.put("image_emoticon103", "亲亲才能起来");
        csQ.put("image_emoticon104", "伦家只是宝宝");
        csQ.put("image_emoticon105", "你是我的人");
        csQ.put("image_emoticon106", "假装看不见");
        csQ.put("image_emoticon107", "单身等撩");
        csQ.put("image_emoticon108", "吓到宝宝了");
        csQ.put("image_emoticon109", "哈哈哈");
        csQ.put("image_emoticon110", "嗯嗯");
        csQ.put("image_emoticon111", "好幸福");
        csQ.put("image_emoticon112", "宝宝不开心");
        csQ.put("image_emoticon113", "小姐姐别走");
        csQ.put("image_emoticon114", "小姐姐在吗");
        csQ.put("image_emoticon115", "小姐姐来啦");
        csQ.put("image_emoticon116", "小姐姐来玩呀");
        csQ.put("image_emoticon117", "我养你");
        csQ.put("image_emoticon118", "我是不会骗你的");
        csQ.put("image_emoticon119", "扎心了");
        csQ.put("image_emoticon120", "无聊");
        csQ.put("image_emoticon121", "月亮代表我的心");
        csQ.put("image_emoticon122", "来追我呀");
        csQ.put("image_emoticon123", "爱你的形状");
        csQ.put("image_emoticon124", "白眼");
        csQ.put("ali_001", "赖皮");
        csQ.put("ali_002", "感动");
        csQ.put("ali_003", "十分惊讶");
        csQ.put("ali_004", "怒气");
        csQ.put("ali_005", "哭泣");
        csQ.put("ali_006", "吃惊");
        csQ.put("ali_007", "嘲弄");
        csQ.put("ali_008", "飘过");
        csQ.put("ali_009", "转圈哭");
        csQ.put("ali_010", "神经病");
        csQ.put("ali_011", "揪耳朵");
        csQ.put("ali_012", "惊汗");
        csQ.put("ali_013", "隐身");
        csQ.put("ali_014", "不要嘛");
        csQ.put("ali_015", "遁");
        csQ.put("ali_016", "不公平");
        csQ.put("ali_017", "爬来了");
        csQ.put("ali_018", "蛋花哭");
        csQ.put("ali_019", "温暖");
        csQ.put("ali_020", "点头");
        csQ.put("ali_021", "撒钱");
        csQ.put("ali_022", "献花");
        csQ.put("ali_023", "寒");
        csQ.put("ali_024", "傻笑");
        csQ.put("ali_025", "扭扭");
        csQ.put("ali_026", "疯");
        csQ.put("ali_027", "抓狂");
        csQ.put("ali_028", "抓");
        csQ.put("ali_029", "蜷");
        csQ.put("ali_030", "挠墙");
        csQ.put("ali_031", "狂笑");
        csQ.put("ali_032", "抱枕");
        csQ.put("ali_033", "吼叫");
        csQ.put("ali_034", "嚷");
        csQ.put("ali_035", "唠叨");
        csQ.put("ali_036", "捏脸");
        csQ.put("ali_037", "爆笑");
        csQ.put("ali_038", "郁闷");
        csQ.put("ali_039", "潜水");
        csQ.put("ali_040", "十分开心");
        csQ.put("ali_041", "冷笑话");
        csQ.put("ali_042", "顶！");
        csQ.put("ali_043", "潜");
        csQ.put("ali_044", "画圈圈");
        csQ.put("ali_045", "玩电脑");
        csQ.put("ali_046", "狂吐");
        csQ.put("ali_047", "哭着跑");
        csQ.put("ali_048", "阿狸侠");
        csQ.put("ali_049", "冷死了");
        csQ.put("ali_050", "惆怅~");
        csQ.put("ali_051", "摸头");
        csQ.put("ali_052", "蹭");
        csQ.put("ali_053", "打滚");
        csQ.put("ali_054", "叩拜");
        csQ.put("ali_055", "摸");
        csQ.put("ali_056", "数钱");
        csQ.put("ali_057", "拖走");
        csQ.put("ali_058", "热");
        csQ.put("ali_059", "加1");
        csQ.put("ali_060", "压力");
        csQ.put("ali_061", "表逼我");
        csQ.put("ali_062", "人呢");
        csQ.put("ali_063", "摇晃");
        csQ.put("ali_064", "打地鼠");
        csQ.put("ali_065", "这个屌");
        csQ.put("ali_066", "恐慌");
        csQ.put("ali_067", "晕乎乎");
        csQ.put("ali_068", "浮云");
        csQ.put("ali_069", "给力");
        csQ.put("ali_070", "杯具了");
        csQ.put("b01", "微笑");
        csQ.put("b02", "帅哥");
        csQ.put("b03", "美女");
        csQ.put("b04", "老大");
        csQ.put("b05", "哈哈哈");
        csQ.put("b06", "奸笑");
        csQ.put("b07", "傻乐");
        csQ.put("b08", "飞吻");
        csQ.put("b09", "害羞");
        csQ.put("b10", "花痴");
        csQ.put("b11", "憧憬");
        csQ.put("b12", "你牛");
        csQ.put("b13", "鼓掌");
        csQ.put("b14", "可爱");
        csQ.put("b15", "太委屈");
        csQ.put("b16", "大哭");
        csQ.put("b17", "泪奔");
        csQ.put("b18", "寻死");
        csQ.put("b19", "非常惊讶");
        csQ.put("b20", "表示疑问");
        csQ.put("yz_001", "焦糖舞");
        csQ.put("yz_002", "翻滚");
        csQ.put("yz_003", "拍屁股做鬼脸");
        csQ.put("yz_004", "不");
        csQ.put("yz_005", "河蟹掉啦");
        csQ.put("yz_006", "哦耶");
        csQ.put("yz_007", "我倒");
        csQ.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int qf(String str) {
        Integer num = csN.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int qg(String str) {
        Integer num = csP.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String qh(String str) {
        return csQ.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int asm() {
        return csO.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0250a aj(Context context, String str) {
        return null;
    }
}
