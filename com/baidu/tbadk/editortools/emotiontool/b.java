package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> cFi = new HashMap<>(200);
    public static final ArrayList<Integer> cFj = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> cFk = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> cFl = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        cFl.put("image_emoticon", "呵呵");
        cFl.put("image_emoticon2", "哈哈");
        cFl.put("image_emoticon3", "吐舌");
        cFl.put("image_emoticon4", "啊");
        cFl.put("image_emoticon5", "酷");
        cFl.put("image_emoticon6", "怒");
        cFl.put("image_emoticon7", "开心");
        cFl.put("image_emoticon8", "汗");
        cFl.put("image_emoticon9", "泪");
        cFl.put("image_emoticon10", "黑线");
        cFl.put("image_emoticon11", "鄙视");
        cFl.put("image_emoticon12", "不高兴");
        cFl.put("image_emoticon13", "真棒");
        cFl.put("image_emoticon14", "钱");
        cFl.put("image_emoticon15", "疑问");
        cFl.put("image_emoticon16", "阴险");
        cFl.put("image_emoticon17", "吐");
        cFl.put("image_emoticon18", "咦");
        cFl.put("image_emoticon19", "委屈");
        cFl.put("image_emoticon20", "花心");
        cFl.put("image_emoticon21", "呼~");
        cFl.put("image_emoticon22", "笑眼");
        cFl.put("image_emoticon23", "冷");
        cFl.put("image_emoticon24", "太开心");
        cFl.put("image_emoticon25", "滑稽");
        cFl.put("image_emoticon26", "勉强");
        cFl.put("image_emoticon27", "狂汗");
        cFl.put("image_emoticon28", "乖");
        cFl.put("image_emoticon29", "睡觉");
        cFl.put("image_emoticon30", "惊哭");
        cFl.put("image_emoticon31", "生气");
        cFl.put("image_emoticon32", "惊讶");
        cFl.put("image_emoticon33", "喷");
        cFl.put("image_emoticon34", "爱心");
        cFl.put("image_emoticon35", "心碎");
        cFl.put("image_emoticon36", "玫瑰");
        cFl.put("image_emoticon37", "礼物");
        cFl.put("image_emoticon38", "彩虹");
        cFl.put("image_emoticon39", "星星月亮");
        cFl.put("image_emoticon40", "太阳");
        cFl.put("image_emoticon41", "钱币");
        cFl.put("image_emoticon42", "灯泡");
        cFl.put("image_emoticon43", "茶杯");
        cFl.put("image_emoticon44", "蛋糕");
        cFl.put("image_emoticon45", "音乐");
        cFl.put("image_emoticon46", "haha");
        cFl.put("image_emoticon47", "胜利");
        cFl.put("image_emoticon48", "大拇指");
        cFl.put("image_emoticon49", "弱");
        cFl.put("image_emoticon50", "OK");
        cFl.put("image_emoticon61", "哼");
        cFl.put("image_emoticon62", "吃瓜");
        cFl.put("image_emoticon63", "扔便便");
        cFl.put("image_emoticon64", "惊恐");
        cFl.put("image_emoticon65", "哎呦");
        cFl.put("image_emoticon66", "小乖");
        cFl.put("image_emoticon67", "捂嘴笑");
        cFl.put("image_emoticon68", "你懂的");
        cFl.put("image_emoticon69", "what");
        cFl.put("image_emoticon70", "酸爽");
        cFl.put("image_emoticon71", "呀咩爹");
        cFl.put("image_emoticon72", "笑尿");
        cFl.put("image_emoticon73", "挖鼻");
        cFl.put("image_emoticon74", "犀利");
        cFl.put("image_emoticon75", "小红脸");
        cFl.put("image_emoticon76", "懒得理");
        cFl.put("image_emoticon77", "沙发");
        cFl.put("image_emoticon78", "手纸");
        cFl.put("image_emoticon79", "香蕉");
        cFl.put("image_emoticon80", "便便");
        cFl.put("image_emoticon81", "药丸");
        cFl.put("image_emoticon82", "红领巾");
        cFl.put("image_emoticon83", "蜡烛");
        cFl.put("image_emoticon84", "三道杠");
        cFl.put("image_emoticon101", "不跟丑人说话");
        cFl.put("image_emoticon102", "么么哒");
        cFl.put("image_emoticon103", "亲亲才能起来");
        cFl.put("image_emoticon104", "伦家只是宝宝");
        cFl.put("image_emoticon105", "你是我的人");
        cFl.put("image_emoticon106", "假装看不见");
        cFl.put("image_emoticon107", "单身等撩");
        cFl.put("image_emoticon108", "吓到宝宝了");
        cFl.put("image_emoticon109", "哈哈哈");
        cFl.put("image_emoticon110", "嗯嗯");
        cFl.put("image_emoticon111", "好幸福");
        cFl.put("image_emoticon112", "宝宝不开心");
        cFl.put("image_emoticon113", "小姐姐别走");
        cFl.put("image_emoticon114", "小姐姐在吗");
        cFl.put("image_emoticon115", "小姐姐来啦");
        cFl.put("image_emoticon116", "小姐姐来玩呀");
        cFl.put("image_emoticon117", "我养你");
        cFl.put("image_emoticon118", "我是不会骗你的");
        cFl.put("image_emoticon119", "扎心了");
        cFl.put("image_emoticon120", "无聊");
        cFl.put("image_emoticon121", "月亮代表我的心");
        cFl.put("image_emoticon122", "来追我呀");
        cFl.put("image_emoticon123", "爱你的形状");
        cFl.put("image_emoticon124", "白眼");
        cFl.put("ali_001", "赖皮");
        cFl.put("ali_002", "感动");
        cFl.put("ali_003", "十分惊讶");
        cFl.put("ali_004", "怒气");
        cFl.put("ali_005", "哭泣");
        cFl.put("ali_006", "吃惊");
        cFl.put("ali_007", "嘲弄");
        cFl.put("ali_008", "飘过");
        cFl.put("ali_009", "转圈哭");
        cFl.put("ali_010", "神经病");
        cFl.put("ali_011", "揪耳朵");
        cFl.put("ali_012", "惊汗");
        cFl.put("ali_013", "隐身");
        cFl.put("ali_014", "不要嘛");
        cFl.put("ali_015", "遁");
        cFl.put("ali_016", "不公平");
        cFl.put("ali_017", "爬来了");
        cFl.put("ali_018", "蛋花哭");
        cFl.put("ali_019", "温暖");
        cFl.put("ali_020", "点头");
        cFl.put("ali_021", "撒钱");
        cFl.put("ali_022", "献花");
        cFl.put("ali_023", "寒");
        cFl.put("ali_024", "傻笑");
        cFl.put("ali_025", "扭扭");
        cFl.put("ali_026", "疯");
        cFl.put("ali_027", "抓狂");
        cFl.put("ali_028", "抓");
        cFl.put("ali_029", "蜷");
        cFl.put("ali_030", "挠墙");
        cFl.put("ali_031", "狂笑");
        cFl.put("ali_032", "抱枕");
        cFl.put("ali_033", "吼叫");
        cFl.put("ali_034", "嚷");
        cFl.put("ali_035", "唠叨");
        cFl.put("ali_036", "捏脸");
        cFl.put("ali_037", "爆笑");
        cFl.put("ali_038", "郁闷");
        cFl.put("ali_039", "潜水");
        cFl.put("ali_040", "十分开心");
        cFl.put("ali_041", "冷笑话");
        cFl.put("ali_042", "顶！");
        cFl.put("ali_043", "潜");
        cFl.put("ali_044", "画圈圈");
        cFl.put("ali_045", "玩电脑");
        cFl.put("ali_046", "狂吐");
        cFl.put("ali_047", "哭着跑");
        cFl.put("ali_048", "阿狸侠");
        cFl.put("ali_049", "冷死了");
        cFl.put("ali_050", "惆怅~");
        cFl.put("ali_051", "摸头");
        cFl.put("ali_052", "蹭");
        cFl.put("ali_053", "打滚");
        cFl.put("ali_054", "叩拜");
        cFl.put("ali_055", "摸");
        cFl.put("ali_056", "数钱");
        cFl.put("ali_057", "拖走");
        cFl.put("ali_058", "热");
        cFl.put("ali_059", "加1");
        cFl.put("ali_060", "压力");
        cFl.put("ali_061", "表逼我");
        cFl.put("ali_062", "人呢");
        cFl.put("ali_063", "摇晃");
        cFl.put("ali_064", "打地鼠");
        cFl.put("ali_065", "这个屌");
        cFl.put("ali_066", "恐慌");
        cFl.put("ali_067", "晕乎乎");
        cFl.put("ali_068", "浮云");
        cFl.put("ali_069", "给力");
        cFl.put("ali_070", "杯具了");
        cFl.put("b01", "微笑");
        cFl.put("b02", "帅哥");
        cFl.put("b03", "美女");
        cFl.put("b04", "老大");
        cFl.put("b05", "哈哈哈");
        cFl.put("b06", "奸笑");
        cFl.put("b07", "傻乐");
        cFl.put("b08", "飞吻");
        cFl.put("b09", "害羞");
        cFl.put("b10", "花痴");
        cFl.put("b11", "憧憬");
        cFl.put("b12", "你牛");
        cFl.put("b13", "鼓掌");
        cFl.put("b14", "可爱");
        cFl.put("b15", "太委屈");
        cFl.put("b16", "大哭");
        cFl.put("b17", "泪奔");
        cFl.put("b18", "寻死");
        cFl.put("b19", "非常惊讶");
        cFl.put("b20", "表示疑问");
        cFl.put("yz_001", "焦糖舞");
        cFl.put("yz_002", "翻滚");
        cFl.put("yz_003", "拍屁股做鬼脸");
        cFl.put("yz_004", "不");
        cFl.put("yz_005", "河蟹掉啦");
        cFl.put("yz_006", "哦耶");
        cFl.put("yz_007", "我倒");
        cFl.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int pz(String str) {
        Integer num = cFi.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int pA(String str) {
        Integer num = cFk.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String pB(String str) {
        return cFl.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int auk() {
        return cFj.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0291a ag(Context context, String str) {
        return null;
    }
}
