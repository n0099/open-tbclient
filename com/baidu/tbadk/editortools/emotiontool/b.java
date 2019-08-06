package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> csU = new HashMap<>(200);
    public static final ArrayList<Integer> csV = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> csW = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> csX = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        csX.put("image_emoticon", "呵呵");
        csX.put("image_emoticon2", "哈哈");
        csX.put("image_emoticon3", "吐舌");
        csX.put("image_emoticon4", "啊");
        csX.put("image_emoticon5", "酷");
        csX.put("image_emoticon6", "怒");
        csX.put("image_emoticon7", "开心");
        csX.put("image_emoticon8", "汗");
        csX.put("image_emoticon9", "泪");
        csX.put("image_emoticon10", "黑线");
        csX.put("image_emoticon11", "鄙视");
        csX.put("image_emoticon12", "不高兴");
        csX.put("image_emoticon13", "真棒");
        csX.put("image_emoticon14", "钱");
        csX.put("image_emoticon15", "疑问");
        csX.put("image_emoticon16", "阴险");
        csX.put("image_emoticon17", "吐");
        csX.put("image_emoticon18", "咦");
        csX.put("image_emoticon19", "委屈");
        csX.put("image_emoticon20", "花心");
        csX.put("image_emoticon21", "呼~");
        csX.put("image_emoticon22", "笑眼");
        csX.put("image_emoticon23", "冷");
        csX.put("image_emoticon24", "太开心");
        csX.put("image_emoticon25", "滑稽");
        csX.put("image_emoticon26", "勉强");
        csX.put("image_emoticon27", "狂汗");
        csX.put("image_emoticon28", "乖");
        csX.put("image_emoticon29", "睡觉");
        csX.put("image_emoticon30", "惊哭");
        csX.put("image_emoticon31", "生气");
        csX.put("image_emoticon32", "惊讶");
        csX.put("image_emoticon33", "喷");
        csX.put("image_emoticon34", "爱心");
        csX.put("image_emoticon35", "心碎");
        csX.put("image_emoticon36", "玫瑰");
        csX.put("image_emoticon37", "礼物");
        csX.put("image_emoticon38", "彩虹");
        csX.put("image_emoticon39", "星星月亮");
        csX.put("image_emoticon40", "太阳");
        csX.put("image_emoticon41", "钱币");
        csX.put("image_emoticon42", "灯泡");
        csX.put("image_emoticon43", "茶杯");
        csX.put("image_emoticon44", "蛋糕");
        csX.put("image_emoticon45", "音乐");
        csX.put("image_emoticon46", "haha");
        csX.put("image_emoticon47", "胜利");
        csX.put("image_emoticon48", "大拇指");
        csX.put("image_emoticon49", "弱");
        csX.put("image_emoticon50", "OK");
        csX.put("image_emoticon61", "哼");
        csX.put("image_emoticon62", "吃瓜");
        csX.put("image_emoticon63", "扔便便");
        csX.put("image_emoticon64", "惊恐");
        csX.put("image_emoticon65", "哎呦");
        csX.put("image_emoticon66", "小乖");
        csX.put("image_emoticon67", "捂嘴笑");
        csX.put("image_emoticon68", "你懂的");
        csX.put("image_emoticon69", "what");
        csX.put("image_emoticon70", "酸爽");
        csX.put("image_emoticon71", "呀咩爹");
        csX.put("image_emoticon72", "笑尿");
        csX.put("image_emoticon73", "挖鼻");
        csX.put("image_emoticon74", "犀利");
        csX.put("image_emoticon75", "小红脸");
        csX.put("image_emoticon76", "懒得理");
        csX.put("image_emoticon77", "沙发");
        csX.put("image_emoticon78", "手纸");
        csX.put("image_emoticon79", "香蕉");
        csX.put("image_emoticon80", "便便");
        csX.put("image_emoticon81", "药丸");
        csX.put("image_emoticon82", "红领巾");
        csX.put("image_emoticon83", "蜡烛");
        csX.put("image_emoticon84", "三道杠");
        csX.put("image_emoticon101", "不跟丑人说话");
        csX.put("image_emoticon102", "么么哒");
        csX.put("image_emoticon103", "亲亲才能起来");
        csX.put("image_emoticon104", "伦家只是宝宝");
        csX.put("image_emoticon105", "你是我的人");
        csX.put("image_emoticon106", "假装看不见");
        csX.put("image_emoticon107", "单身等撩");
        csX.put("image_emoticon108", "吓到宝宝了");
        csX.put("image_emoticon109", "哈哈哈");
        csX.put("image_emoticon110", "嗯嗯");
        csX.put("image_emoticon111", "好幸福");
        csX.put("image_emoticon112", "宝宝不开心");
        csX.put("image_emoticon113", "小姐姐别走");
        csX.put("image_emoticon114", "小姐姐在吗");
        csX.put("image_emoticon115", "小姐姐来啦");
        csX.put("image_emoticon116", "小姐姐来玩呀");
        csX.put("image_emoticon117", "我养你");
        csX.put("image_emoticon118", "我是不会骗你的");
        csX.put("image_emoticon119", "扎心了");
        csX.put("image_emoticon120", "无聊");
        csX.put("image_emoticon121", "月亮代表我的心");
        csX.put("image_emoticon122", "来追我呀");
        csX.put("image_emoticon123", "爱你的形状");
        csX.put("image_emoticon124", "白眼");
        csX.put("ali_001", "赖皮");
        csX.put("ali_002", "感动");
        csX.put("ali_003", "十分惊讶");
        csX.put("ali_004", "怒气");
        csX.put("ali_005", "哭泣");
        csX.put("ali_006", "吃惊");
        csX.put("ali_007", "嘲弄");
        csX.put("ali_008", "飘过");
        csX.put("ali_009", "转圈哭");
        csX.put("ali_010", "神经病");
        csX.put("ali_011", "揪耳朵");
        csX.put("ali_012", "惊汗");
        csX.put("ali_013", "隐身");
        csX.put("ali_014", "不要嘛");
        csX.put("ali_015", "遁");
        csX.put("ali_016", "不公平");
        csX.put("ali_017", "爬来了");
        csX.put("ali_018", "蛋花哭");
        csX.put("ali_019", "温暖");
        csX.put("ali_020", "点头");
        csX.put("ali_021", "撒钱");
        csX.put("ali_022", "献花");
        csX.put("ali_023", "寒");
        csX.put("ali_024", "傻笑");
        csX.put("ali_025", "扭扭");
        csX.put("ali_026", "疯");
        csX.put("ali_027", "抓狂");
        csX.put("ali_028", "抓");
        csX.put("ali_029", "蜷");
        csX.put("ali_030", "挠墙");
        csX.put("ali_031", "狂笑");
        csX.put("ali_032", "抱枕");
        csX.put("ali_033", "吼叫");
        csX.put("ali_034", "嚷");
        csX.put("ali_035", "唠叨");
        csX.put("ali_036", "捏脸");
        csX.put("ali_037", "爆笑");
        csX.put("ali_038", "郁闷");
        csX.put("ali_039", "潜水");
        csX.put("ali_040", "十分开心");
        csX.put("ali_041", "冷笑话");
        csX.put("ali_042", "顶！");
        csX.put("ali_043", "潜");
        csX.put("ali_044", "画圈圈");
        csX.put("ali_045", "玩电脑");
        csX.put("ali_046", "狂吐");
        csX.put("ali_047", "哭着跑");
        csX.put("ali_048", "阿狸侠");
        csX.put("ali_049", "冷死了");
        csX.put("ali_050", "惆怅~");
        csX.put("ali_051", "摸头");
        csX.put("ali_052", "蹭");
        csX.put("ali_053", "打滚");
        csX.put("ali_054", "叩拜");
        csX.put("ali_055", "摸");
        csX.put("ali_056", "数钱");
        csX.put("ali_057", "拖走");
        csX.put("ali_058", "热");
        csX.put("ali_059", "加1");
        csX.put("ali_060", "压力");
        csX.put("ali_061", "表逼我");
        csX.put("ali_062", "人呢");
        csX.put("ali_063", "摇晃");
        csX.put("ali_064", "打地鼠");
        csX.put("ali_065", "这个屌");
        csX.put("ali_066", "恐慌");
        csX.put("ali_067", "晕乎乎");
        csX.put("ali_068", "浮云");
        csX.put("ali_069", "给力");
        csX.put("ali_070", "杯具了");
        csX.put("b01", "微笑");
        csX.put("b02", "帅哥");
        csX.put("b03", "美女");
        csX.put("b04", "老大");
        csX.put("b05", "哈哈哈");
        csX.put("b06", "奸笑");
        csX.put("b07", "傻乐");
        csX.put("b08", "飞吻");
        csX.put("b09", "害羞");
        csX.put("b10", "花痴");
        csX.put("b11", "憧憬");
        csX.put("b12", "你牛");
        csX.put("b13", "鼓掌");
        csX.put("b14", "可爱");
        csX.put("b15", "太委屈");
        csX.put("b16", "大哭");
        csX.put("b17", "泪奔");
        csX.put("b18", "寻死");
        csX.put("b19", "非常惊讶");
        csX.put("b20", "表示疑问");
        csX.put("yz_001", "焦糖舞");
        csX.put("yz_002", "翻滚");
        csX.put("yz_003", "拍屁股做鬼脸");
        csX.put("yz_004", "不");
        csX.put("yz_005", "河蟹掉啦");
        csX.put("yz_006", "哦耶");
        csX.put("yz_007", "我倒");
        csX.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int qf(String str) {
        Integer num = csU.get(str);
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
        Integer num = csW.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String qh(String str) {
        return csX.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int aso() {
        return csV.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0255a aj(Context context, String str) {
        return null;
    }
}
