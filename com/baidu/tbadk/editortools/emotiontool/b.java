package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> arv = new HashMap<>();
    public static final ArrayList<Integer> arw = new ArrayList<>();
    public static final HashMap<String, Integer> arx = new HashMap<>();
    private static final HashMap<String, String> ary = new HashMap<>();

    static {
        ary.put("image_emoticon", "呵呵");
        ary.put("image_emoticon2", "哈哈");
        ary.put("image_emoticon3", "吐舌");
        ary.put("image_emoticon4", "啊");
        ary.put("image_emoticon5", "酷");
        ary.put("image_emoticon6", "怒");
        ary.put("image_emoticon7", "开心");
        ary.put("image_emoticon8", "汗");
        ary.put("image_emoticon9", "泪");
        ary.put("image_emoticon10", "黑线");
        ary.put("image_emoticon11", "鄙视");
        ary.put("image_emoticon12", "不高兴");
        ary.put("image_emoticon13", "真棒");
        ary.put("image_emoticon14", "钱");
        ary.put("image_emoticon15", "疑问");
        ary.put("image_emoticon16", "阴险");
        ary.put("image_emoticon17", "吐");
        ary.put("image_emoticon18", "咦");
        ary.put("image_emoticon19", "委屈");
        ary.put("image_emoticon20", "花心");
        ary.put("image_emoticon21", "呼~");
        ary.put("image_emoticon22", "笑眼");
        ary.put("image_emoticon23", "冷");
        ary.put("image_emoticon24", "太开心");
        ary.put("image_emoticon25", "滑稽");
        ary.put("image_emoticon26", "勉强");
        ary.put("image_emoticon27", "狂汗");
        ary.put("image_emoticon28", "乖");
        ary.put("image_emoticon29", "睡觉");
        ary.put("image_emoticon30", "惊哭");
        ary.put("image_emoticon31", "生气");
        ary.put("image_emoticon32", "惊讶");
        ary.put("image_emoticon33", "喷");
        ary.put("image_emoticon34", "爱心");
        ary.put("image_emoticon35", "心碎");
        ary.put("image_emoticon36", "玫瑰");
        ary.put("image_emoticon37", "礼物");
        ary.put("image_emoticon38", "彩虹");
        ary.put("image_emoticon39", "星星月亮");
        ary.put("image_emoticon40", "太阳");
        ary.put("image_emoticon41", "钱币");
        ary.put("image_emoticon42", "灯泡");
        ary.put("image_emoticon43", "茶杯");
        ary.put("image_emoticon44", "蛋糕");
        ary.put("image_emoticon45", "音乐");
        ary.put("image_emoticon46", "haha");
        ary.put("image_emoticon47", "胜利");
        ary.put("image_emoticon48", "大拇指");
        ary.put("image_emoticon49", "弱");
        ary.put("image_emoticon50", "OK");
        ary.put("image_emoticon61", "哼");
        ary.put("ali_001", "赖皮");
        ary.put("ali_002", "感动");
        ary.put("ali_003", "十分惊讶");
        ary.put("ali_004", "怒气");
        ary.put("ali_005", "哭泣");
        ary.put("ali_006", "吃惊");
        ary.put("ali_007", "嘲弄");
        ary.put("ali_008", "飘过");
        ary.put("ali_009", "转圈哭");
        ary.put("ali_010", "神经病");
        ary.put("ali_011", "揪耳朵");
        ary.put("ali_012", "惊汗");
        ary.put("ali_013", "隐身");
        ary.put("ali_014", "不要嘛");
        ary.put("ali_015", "遁");
        ary.put("ali_016", "不公平");
        ary.put("ali_017", "爬来了");
        ary.put("ali_018", "蛋花哭");
        ary.put("ali_019", "温暖");
        ary.put("ali_020", "点头");
        ary.put("ali_021", "撒钱");
        ary.put("ali_022", "献花");
        ary.put("ali_023", "寒");
        ary.put("ali_024", "傻笑");
        ary.put("ali_025", "扭扭");
        ary.put("ali_026", "疯");
        ary.put("ali_027", "抓狂");
        ary.put("ali_028", "抓");
        ary.put("ali_029", "蜷");
        ary.put("ali_030", "挠墙");
        ary.put("ali_031", "狂笑");
        ary.put("ali_032", "抱枕");
        ary.put("ali_033", "吼叫");
        ary.put("ali_034", "嚷");
        ary.put("ali_035", "唠叨");
        ary.put("ali_036", "捏脸");
        ary.put("ali_037", "爆笑");
        ary.put("ali_038", "郁闷");
        ary.put("ali_039", "潜水");
        ary.put("ali_040", "十分开心");
        ary.put("ali_041", "冷笑话");
        ary.put("ali_042", "顶！");
        ary.put("ali_043", "潜");
        ary.put("ali_044", "画圈圈");
        ary.put("ali_045", "玩电脑");
        ary.put("ali_046", "狂吐");
        ary.put("ali_047", "哭着跑");
        ary.put("ali_048", "阿狸侠");
        ary.put("ali_049", "冷死了");
        ary.put("ali_050", "惆怅~");
        ary.put("ali_051", "摸头");
        ary.put("ali_052", "蹭");
        ary.put("ali_053", "打滚");
        ary.put("ali_054", "叩拜");
        ary.put("ali_055", "摸");
        ary.put("ali_056", "数钱");
        ary.put("ali_057", "拖走");
        ary.put("ali_058", "热");
        ary.put("ali_059", "加1");
        ary.put("ali_060", "压力");
        ary.put("ali_061", "表逼我");
        ary.put("ali_062", "人呢");
        ary.put("ali_063", "摇晃");
        ary.put("ali_064", "打地鼠");
        ary.put("ali_065", "这个屌");
        ary.put("ali_066", "恐慌");
        ary.put("ali_067", "晕乎乎");
        ary.put("ali_068", "浮云");
        ary.put("ali_069", "给力");
        ary.put("ali_070", "杯具了");
        ary.put("b01", "微笑");
        ary.put("b02", "帅哥");
        ary.put("b03", "美女");
        ary.put("b04", "老大");
        ary.put("b05", "哈哈哈");
        ary.put("b06", "奸笑");
        ary.put("b07", "傻乐");
        ary.put("b08", "飞吻");
        ary.put("b09", "害羞");
        ary.put("b10", "花痴");
        ary.put("b11", "憧憬");
        ary.put("b12", "你牛");
        ary.put("b13", "鼓掌");
        ary.put("b14", "可爱");
        ary.put("b15", "太委屈");
        ary.put("b16", "大哭");
        ary.put("b17", "泪奔");
        ary.put("b18", "寻死");
        ary.put("b19", "非常惊讶");
        ary.put("b20", "表示疑问");
        ary.put("yz_001", "焦糖舞");
        ary.put("yz_002", "翻滚");
        ary.put("yz_003", "拍屁股做鬼脸");
        ary.put("yz_004", "不");
        ary.put("yz_005", "河蟹掉啦");
        ary.put("yz_006", "哦耶");
        ary.put("yz_007", "我倒");
        ary.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fa(String str) {
        Integer num = arv.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(n.e.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fb(String str) {
        Integer num = arx.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fc(String str) {
        return ary.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int BL() {
        return arw.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0051a F(Context context, String str) {
        return null;
    }
}
