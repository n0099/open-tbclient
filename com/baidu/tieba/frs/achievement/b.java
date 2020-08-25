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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext context;
    public String fid;
    public String fname;
    public String hYA;
    public String hYB;
    public String hYC;
    public String hYD;
    public String hYE;
    public String hYF;
    public String hYG;
    public String hYH;
    public String hYI;
    public String hYJ;
    public String hYK;
    public String hYx;
    public String hYy;
    public String hYz;
    public String nickName;
    public String shareUrl;
    public String url;

    public b(TbPageContext tbPageContext) {
        this.context = tbPageContext;
    }

    public void coq() {
        Uri parse;
        if (this.context.getPageActivity() != null && this.context.getPageActivity().getIntent() != null) {
            this.url = this.context.getPageActivity().getIntent().getStringExtra("key_url");
            this.shareUrl = this.context.getPageActivity().getIntent().getStringExtra(AchievementActivityConfig.KEY_SHARE_URL);
            if (!TextUtils.isEmpty(this.url) && (parse = Uri.parse(this.url)) != null) {
                this.nickName = parse.getQueryParameter("nickname");
                this.fid = parse.getQueryParameter("fid");
                this.fname = parse.getQueryParameter("fname");
                this.hYx = parse.getQueryParameter("subcribe-num");
                this.hYy = parse.getQueryParameter("bazhu-days");
                this.hYz = parse.getQueryParameter("goods-num");
                this.hYA = parse.getQueryParameter("tid-num");
                this.hYB = parse.getQueryParameter("most-hot-name");
                this.hYB = at.cutStringWithSuffix(this.hYB, 20, StringHelper.STRING_MORE);
                this.hYC = parse.getQueryParameter("most-hot-floors");
                this.hYD = parse.getQueryParameter("achievement");
                this.hYE = parse.getQueryParameter("join-days");
                this.hYF = parse.getQueryParameter("send-tids");
                this.hYG = parse.getQueryParameter("reply-num");
                this.hYH = parse.getQueryParameter("zan-num");
                this.hYI = parse.getQueryParameter("sign-days");
                this.hYJ = parse.getQueryParameter("join-topicnum");
                this.hYK = parse.getQueryParameter("write-num");
            }
        }
    }

    public SpannableStringBuilder cor() {
        if (this.hYD == null) {
            return null;
        }
        if (this.hYD.equals("bazhu")) {
            return a(this.fname, this.hYx, this.hYy, this.hYz, this.hYA, this.hYB, this.hYC);
        }
        if (this.hYD.equals("active-a")) {
            return c(this.fname, this.hYx, this.hYE, this.hYF, this.hYA, this.hYB, this.hYG, this.hYH, this.hYI);
        }
        if (this.hYD.equals("active-b")) {
            return d(this.fname, this.hYx, this.hYE, this.hYJ, this.hYK, this.hYI);
        }
        return null;
    }

    private SpannableStringBuilder a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ("恭喜！" + str + "吧成员数突破"));
        spannableStringBuilder.append((CharSequence) It(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！\n\n");
        spannableStringBuilder.append((CharSequence) "感谢你在过去");
        spannableStringBuilder.append((CharSequence) It(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "的辛勤付出，火眼金睛的你最近挑选出了");
        spannableStringBuilder.append((CharSequence) str4);
        spannableStringBuilder.append((CharSequence) "篇精品贴子，处理了大量违规内容。\n\n衷心感谢你为吧友提供了和谐快乐的社区氛围。截止目前");
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) "吧共有");
        spannableStringBuilder.append((CharSequence) It(str5 + "篇"));
        spannableStringBuilder.append((CharSequence) "贴子，最火热的一篇贴子");
        spannableStringBuilder.append((CharSequence) It("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "竟然盖了");
        spannableStringBuilder.append((CharSequence) It(str7 + "层"));
        spannableStringBuilder.append((CharSequence) "楼。\n\n继续加油吧！期望你能带领");
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) "吧走得更远！");
        return spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
        spannableStringBuilder.append((CharSequence) It(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) It(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，最近发表了");
        spannableStringBuilder.append((CharSequence) str4);
        spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
        spannableStringBuilder.append((CharSequence) It("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "收到了");
        spannableStringBuilder.append((CharSequence) It(str7 + "条"));
        spannableStringBuilder.append((CharSequence) "回复、");
        spannableStringBuilder.append((CharSequence) It(str8 + "个"));
        spannableStringBuilder.append((CharSequence) "赞！近一个月累计签到了");
        spannableStringBuilder.append((CharSequence) (str9 + "天"));
        spannableStringBuilder.append((CharSequence) "。\n\n");
        spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
        return spannableStringBuilder;
    }

    private SpannableStringBuilder d(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
        spannableStringBuilder.append((CharSequence) It(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) It(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期参与了");
        spannableStringBuilder.append((CharSequence) str4);
        spannableStringBuilder.append((CharSequence) "个主题贴的讨论，写了");
        spannableStringBuilder.append((CharSequence) It(str5 + "条"));
        spannableStringBuilder.append((CharSequence) "评论。近一个月累计签到了");
        spannableStringBuilder.append((CharSequence) (str6 + "天。\n\n"));
        spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
        return spannableStringBuilder;
    }

    public SpannableStringBuilder cos() {
        if (this.hYD == null) {
            return null;
        }
        if (this.hYD.equals("bazhu")) {
            return b(this.fname, this.hYx, this.hYy, this.hYz, this.hYA, this.hYB, this.hYC);
        }
        if (this.hYD.equals("active-a")) {
            return d(this.fname, this.hYx, this.hYE, this.hYF, this.hYA, this.hYB, this.hYG, this.hYH, this.hYI);
        }
        if (this.hYD.equals("active-b")) {
            return e(this.fname, this.hYx, this.hYE, this.hYJ, this.hYK, this.hYI);
        }
        return null;
    }

    private SpannableStringBuilder b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ("忍不住想告诉你个好消息，" + str + "吧的成员数量突破了"));
        spannableStringBuilder.append((CharSequence) It(str2 + "人"));
        spannableStringBuilder.append((CharSequence) ("！作为吧主，我邀请你加入" + str + "吧！\n\n"));
        spannableStringBuilder.append((CharSequence) "在我担任吧主的这");
        spannableStringBuilder.append((CharSequence) It(str3 + "天"));
        spannableStringBuilder.append((CharSequence) ("，为" + str + "吧创造了良好的社区氛围，近期发现了"));
        spannableStringBuilder.append((CharSequence) str4);
        spannableStringBuilder.append((CharSequence) "篇优质贴子，最火热的一篇");
        spannableStringBuilder.append((CharSequence) It("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "竟然盖了");
        spannableStringBuilder.append((CharSequence) It(str7 + "层"));
        spannableStringBuilder.append((CharSequence) "楼。\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    private SpannableStringBuilder d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
        spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
        spannableStringBuilder.append((CharSequence) It(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "了！\n\n");
        spannableStringBuilder.append((CharSequence) "我加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) It(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期发表了");
        spannableStringBuilder.append((CharSequence) str4);
        spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
        spannableStringBuilder.append((CharSequence) It("《" + str6 + "》"));
        spannableStringBuilder.append((CharSequence) "收到了");
        spannableStringBuilder.append((CharSequence) It(str7 + "条"));
        spannableStringBuilder.append((CharSequence) "回复、");
        spannableStringBuilder.append((CharSequence) It(str8 + "个"));
        spannableStringBuilder.append((CharSequence) "赞！\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    private SpannableStringBuilder e(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
        spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
        spannableStringBuilder.append((CharSequence) It(str2 + "人"));
        spannableStringBuilder.append((CharSequence) "了！\n\n");
        spannableStringBuilder.append((CharSequence) "我加入");
        spannableStringBuilder.append((CharSequence) (str + "吧已经"));
        spannableStringBuilder.append((CharSequence) It(str3 + "天"));
        spannableStringBuilder.append((CharSequence) "了，近期参与了");
        spannableStringBuilder.append((CharSequence) str4);
        spannableStringBuilder.append((CharSequence) "主题贴的讨论，写了");
        spannableStringBuilder.append((CharSequence) It(str5 + "条"));
        spannableStringBuilder.append((CharSequence) "评论。\n\n");
        spannableStringBuilder.append((CharSequence) "我很喜欢");
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
        return spannableStringBuilder;
    }

    private SpannableString It(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)), 0, spannableString.length(), 33);
        return spannableString;
    }
}
