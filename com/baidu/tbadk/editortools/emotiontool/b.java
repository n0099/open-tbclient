package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aqr = new HashMap<>();
    public static final ArrayList<Integer> aqs = new ArrayList<>();
    public static final HashMap<String, Integer> aqt = new HashMap<>();
    private static final HashMap<String, String> aqu = new HashMap<>();

    static {
        aqu.put("image_emoticon", "呵呵");
        aqu.put("image_emoticon2", "哈哈");
        aqu.put("image_emoticon3", "吐舌");
        aqu.put("image_emoticon4", "啊");
        aqu.put("image_emoticon5", "酷");
        aqu.put("image_emoticon6", "怒");
        aqu.put("image_emoticon7", "开心");
        aqu.put("image_emoticon8", "汗");
        aqu.put("image_emoticon9", "泪");
        aqu.put("image_emoticon10", "黑线");
        aqu.put("image_emoticon11", "鄙视");
        aqu.put("image_emoticon12", "不高兴");
        aqu.put("image_emoticon13", "真棒");
        aqu.put("image_emoticon14", "钱");
        aqu.put("image_emoticon15", "疑问");
        aqu.put("image_emoticon16", "阴险");
        aqu.put("image_emoticon17", "吐");
        aqu.put("image_emoticon18", "咦");
        aqu.put("image_emoticon19", "委屈");
        aqu.put("image_emoticon20", "花心");
        aqu.put("image_emoticon21", "呼~");
        aqu.put("image_emoticon22", "笑眼");
        aqu.put("image_emoticon23", "冷");
        aqu.put("image_emoticon24", "太开心");
        aqu.put("image_emoticon25", "滑稽");
        aqu.put("image_emoticon26", "勉强");
        aqu.put("image_emoticon27", "狂汗");
        aqu.put("image_emoticon28", "乖");
        aqu.put("image_emoticon29", "睡觉");
        aqu.put("image_emoticon30", "惊哭");
        aqu.put("image_emoticon31", "生气");
        aqu.put("image_emoticon32", "惊讶");
        aqu.put("image_emoticon33", "喷");
        aqu.put("image_emoticon34", "爱心");
        aqu.put("image_emoticon35", "心碎");
        aqu.put("image_emoticon36", "玫瑰");
        aqu.put("image_emoticon37", "礼物");
        aqu.put("image_emoticon38", "彩虹");
        aqu.put("image_emoticon39", "星星月亮");
        aqu.put("image_emoticon40", "太阳");
        aqu.put("image_emoticon41", "钱币");
        aqu.put("image_emoticon42", "灯泡");
        aqu.put("image_emoticon43", "茶杯");
        aqu.put("image_emoticon44", "蛋糕");
        aqu.put("image_emoticon45", "音乐");
        aqu.put("image_emoticon46", "haha");
        aqu.put("image_emoticon47", "胜利");
        aqu.put("image_emoticon48", "大拇指");
        aqu.put("image_emoticon49", "弱");
        aqu.put("image_emoticon50", "OK");
        aqu.put("image_emoticon61", "哼");
        aqu.put("ali_001", "赖皮");
        aqu.put("ali_002", "感动");
        aqu.put("ali_003", "十分惊讶");
        aqu.put("ali_004", "怒气");
        aqu.put("ali_005", "哭泣");
        aqu.put("ali_006", "吃惊");
        aqu.put("ali_007", "嘲弄");
        aqu.put("ali_008", "飘过");
        aqu.put("ali_009", "转圈哭");
        aqu.put("ali_010", "神经病");
        aqu.put("ali_011", "揪耳朵");
        aqu.put("ali_012", "惊汗");
        aqu.put("ali_013", "隐身");
        aqu.put("ali_014", "不要嘛");
        aqu.put("ali_015", "遁");
        aqu.put("ali_016", "不公平");
        aqu.put("ali_017", "爬来了");
        aqu.put("ali_018", "蛋花哭");
        aqu.put("ali_019", "温暖");
        aqu.put("ali_020", "点头");
        aqu.put("ali_021", "撒钱");
        aqu.put("ali_022", "献花");
        aqu.put("ali_023", "寒");
        aqu.put("ali_024", "傻笑");
        aqu.put("ali_025", "扭扭");
        aqu.put("ali_026", "疯");
        aqu.put("ali_027", "抓狂");
        aqu.put("ali_028", "抓");
        aqu.put("ali_029", "蜷");
        aqu.put("ali_030", "挠墙");
        aqu.put("ali_031", "狂笑");
        aqu.put("ali_032", "抱枕");
        aqu.put("ali_033", "吼叫");
        aqu.put("ali_034", "嚷");
        aqu.put("ali_035", "唠叨");
        aqu.put("ali_036", "捏脸");
        aqu.put("ali_037", "爆笑");
        aqu.put("ali_038", "郁闷");
        aqu.put("ali_039", "潜水");
        aqu.put("ali_040", "十分开心");
        aqu.put("ali_041", "冷笑话");
        aqu.put("ali_042", "顶！");
        aqu.put("ali_043", "潜");
        aqu.put("ali_044", "画圈圈");
        aqu.put("ali_045", "玩电脑");
        aqu.put("ali_046", "狂吐");
        aqu.put("ali_047", "哭着跑");
        aqu.put("ali_048", "阿狸侠");
        aqu.put("ali_049", "冷死了");
        aqu.put("ali_050", "惆怅~");
        aqu.put("ali_051", "摸头");
        aqu.put("ali_052", "蹭");
        aqu.put("ali_053", "打滚");
        aqu.put("ali_054", "叩拜");
        aqu.put("ali_055", "摸");
        aqu.put("ali_056", "数钱");
        aqu.put("ali_057", "拖走");
        aqu.put("ali_058", "热");
        aqu.put("ali_059", "加1");
        aqu.put("ali_060", "压力");
        aqu.put("ali_061", "表逼我");
        aqu.put("ali_062", "人呢");
        aqu.put("ali_063", "摇晃");
        aqu.put("ali_064", "打地鼠");
        aqu.put("ali_065", "这个屌");
        aqu.put("ali_066", "恐慌");
        aqu.put("ali_067", "晕乎乎");
        aqu.put("ali_068", "浮云");
        aqu.put("ali_069", "给力");
        aqu.put("ali_070", "杯具了");
        aqu.put("b01", "微笑");
        aqu.put("b02", "帅哥");
        aqu.put("b03", "美女");
        aqu.put("b04", "老大");
        aqu.put("b05", "哈哈哈");
        aqu.put("b06", "奸笑");
        aqu.put("b07", "傻乐");
        aqu.put("b08", "飞吻");
        aqu.put("b09", "害羞");
        aqu.put("b10", "花痴");
        aqu.put("b11", "憧憬");
        aqu.put("b12", "你牛");
        aqu.put("b13", "鼓掌");
        aqu.put("b14", "可爱");
        aqu.put("b15", "太委屈");
        aqu.put("b16", "大哭");
        aqu.put("b17", "泪奔");
        aqu.put("b18", "寻死");
        aqu.put("b19", "非常惊讶");
        aqu.put("b20", "表示疑问");
        aqu.put("yz_001", "焦糖舞");
        aqu.put("yz_002", "翻滚");
        aqu.put("yz_003", "拍屁股做鬼脸");
        aqu.put("yz_004", "不");
        aqu.put("yz_005", "河蟹掉啦");
        aqu.put("yz_006", "哦耶");
        aqu.put("yz_007", "我倒");
        aqu.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fi(String str) {
        Integer num = aqr.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(t.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fj(String str) {
        Integer num = aqt.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fk(String str) {
        return aqu.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Bu() {
        return aqs.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0043a x(Context context, String str) {
        return null;
    }
}
