package com.baidu.tieba.frs.achievement;

import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext context;
    public String fid;
    public String fname;
    public String jnO;
    public String jnP;
    public String jnQ;
    public String jnR;
    public String jnS;
    public String jnT;
    public String jnU;
    public String jnV;
    public String jnW;
    public String jnX;
    public String jnY;
    public String jnZ;
    public String joa;
    public String job;
    public String nickName;
    public String shareUrl;
    public String url;

    public b(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void cFh() {
        Uri parse;
        if (this.context.getPageActivity() != null && this.context.getPageActivity().getIntent() != null) {
            this.url = this.context.getPageActivity().getIntent().getStringExtra("key_url");
            this.shareUrl = this.context.getPageActivity().getIntent().getStringExtra(AchievementActivityConfig.KEY_SHARE_URL);
            if (!TextUtils.isEmpty(this.url) && (parse = Uri.parse(this.url)) != null) {
                this.nickName = parse.getQueryParameter("nickname");
                this.fid = parse.getQueryParameter("fid");
                this.fname = parse.getQueryParameter("fname");
                this.jnO = parse.getQueryParameter("subcribe-num");
                this.jnP = parse.getQueryParameter("bazhu-days");
                this.jnQ = parse.getQueryParameter("goods-num");
                this.jnR = parse.getQueryParameter("tid-num");
                this.jnS = parse.getQueryParameter("most-hot-name");
                this.jnS = au.cutStringWithSuffix(this.jnS, 20, StringHelper.STRING_MORE);
                this.jnT = parse.getQueryParameter("most-hot-floors");
                this.jnU = parse.getQueryParameter("achievement");
                this.jnV = parse.getQueryParameter("join-days");
                this.jnW = parse.getQueryParameter("send-tids");
                this.jnX = parse.getQueryParameter("reply-num");
                this.jnY = parse.getQueryParameter("zan-num");
                this.jnZ = parse.getQueryParameter("sign-days");
                this.joa = parse.getQueryParameter("join-topicnum");
                this.job = parse.getQueryParameter("write-num");
            }
        }
    }

    public SpannableStringBuilder cFi() {
        if (this.jnU == null) {
            return null;
        }
        if (this.jnU.equals("bazhu")) {
            return a(this.fname, this.jnO, this.jnP, this.jnQ, this.jnR, this.jnS, this.jnT);
        }
        if (this.jnU.equals("active-a")) {
            return c(this.fname, this.jnO, this.jnV, this.jnW, this.jnR, this.jnS, this.jnX, this.jnY, this.jnZ);
        }
        if (this.jnU.equals("active-b")) {
            return g(this.fname, this.jnO, this.jnV, this.joa, this.job, this.jnZ);
        }
        return null;
    }

    private SpannableStringBuilder a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ("恭喜！" + str + "吧成员数突破"));
        spannableStringBuilder.append((CharSequence) Ku(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！\n\n");
        spannableStringBuilder.append((CharSequence) "感谢你在过去");
        spannableStringBuilder.append((CharSequence) Ku(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "的辛勤付出，火眼金睛的你最近挑选出了");
        spannableStringBuilder.append((CharSequence) Kv(str4));
        spannableStringBuilder.append((CharSequence) "篇精品贴子，处理了大量违规内容。\n\n衷心感谢你为吧友提供了和谐快乐的社区氛围。截止目前");
        spannableStringBuilder.append((CharSequence) Kv(str));
        spannableStringBuilder.append((CharSequence) "吧共有");
        spannableStringBuilder.append((CharSequence) Ku(str5 + "篇"));
        spannableStringBuilder.append((CharSequence) "贴子，最火热的一篇贴子");
        spannableStringBuilder.append((CharSequence) Ku("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "竟然盖了");
        spannableStringBuilder.append((CharSequence) Ku(str7 + "层"));
        spannableStringBuilder.append((CharSequence) "楼。\n\n继续加油吧！期望你能带领");
        spannableStringBuilder.append((CharSequence) Kv(str));
        spannableStringBuilder.append((CharSequence) "吧走得更远！");
        return spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
        spannableStringBuilder.append((CharSequence) Ku(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) Ku(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，最近发表了");
        spannableStringBuilder.append((CharSequence) Kv(str4));
        spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
        spannableStringBuilder.append((CharSequence) Ku("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "收到了");
        spannableStringBuilder.append((CharSequence) Ku(str7 + "条"));
        spannableStringBuilder.append((CharSequence) "回复、");
        spannableStringBuilder.append((CharSequence) Ku(str8 + "个"));
        spannableStringBuilder.append((CharSequence) "赞！近一个月累计签到了");
        spannableStringBuilder.append((CharSequence) (str9 + "天"));
        spannableStringBuilder.append((CharSequence) "。\n\n");
        spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
        return spannableStringBuilder;
    }

    private SpannableStringBuilder g(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
        spannableStringBuilder.append((CharSequence) Ku(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) Ku(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期参与了");
        spannableStringBuilder.append((CharSequence) Kv(str4));
        spannableStringBuilder.append((CharSequence) "个主题贴的讨论，写了");
        spannableStringBuilder.append((CharSequence) Ku(str5 + "条"));
        spannableStringBuilder.append((CharSequence) "评论。近一个月累计签到了");
        spannableStringBuilder.append((CharSequence) (str6 + "天。\n\n"));
        spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
        return spannableStringBuilder;
    }

    public SpannableStringBuilder cFj() {
        if (this.jnU == null) {
            return null;
        }
        if (this.jnU.equals("bazhu")) {
            return b(this.fname, this.jnO, this.jnP, this.jnQ, this.jnR, this.jnS, this.jnT);
        }
        if (this.jnU.equals("active-a")) {
            return d(this.fname, this.jnO, this.jnV, this.jnW, this.jnR, this.jnS, this.jnX, this.jnY, this.jnZ);
        }
        if (this.jnU.equals("active-b")) {
            return h(this.fname, this.jnO, this.jnV, this.joa, this.job, this.jnZ);
        }
        return null;
    }

    private SpannableStringBuilder b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ("忍不住想告诉你个好消息，" + str + "吧的成员数量突破了"));
        spannableStringBuilder.append((CharSequence) Ku(str2 + "人"));
        spannableStringBuilder.append((CharSequence) ("！作为吧主，我邀请你加入" + str + "吧！\n\n"));
        spannableStringBuilder.append((CharSequence) "在我担任吧主的这");
        spannableStringBuilder.append((CharSequence) Ku(str3 + "天"));
        spannableStringBuilder.append((CharSequence) ("，为" + str + "吧创造了良好的社区氛围，近期发现了"));
        spannableStringBuilder.append((CharSequence) Kv(str4));
        spannableStringBuilder.append((CharSequence) "篇优质贴子，最火热的一篇");
        spannableStringBuilder.append((CharSequence) Ku("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "竟然盖了");
        spannableStringBuilder.append((CharSequence) Ku(str7 + "层"));
        spannableStringBuilder.append((CharSequence) "楼。\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) Kv(str));
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    private SpannableStringBuilder d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
        spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
        spannableStringBuilder.append((CharSequence) Ku(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "了！\n\n");
        spannableStringBuilder.append((CharSequence) "我加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) Ku(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期发表了");
        spannableStringBuilder.append((CharSequence) Kv(str4));
        spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
        spannableStringBuilder.append((CharSequence) Ku("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "收到了");
        spannableStringBuilder.append((CharSequence) Ku(str7 + "条"));
        spannableStringBuilder.append((CharSequence) "回复、");
        spannableStringBuilder.append((CharSequence) Ku(str8 + "个"));
        spannableStringBuilder.append((CharSequence) "赞！\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) Kv(str));
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    private SpannableStringBuilder h(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
        spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
        spannableStringBuilder.append((CharSequence) Ku(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "了！\n\n");
        spannableStringBuilder.append((CharSequence) "我加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) Ku(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期参与了");
        spannableStringBuilder.append((CharSequence) Kv(str4));
        spannableStringBuilder.append((CharSequence) "主题贴的讨论，写了");
        spannableStringBuilder.append((CharSequence) Ku(str5 + "条"));
        spannableStringBuilder.append((CharSequence) "评论。\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) Kv(str));
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    private SpannableString Ku(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)), 0, spannableString.length(), 33);
        return spannableString;
    }

    private String Kv(String str) {
        return str == null ? "" : str;
    }
}
