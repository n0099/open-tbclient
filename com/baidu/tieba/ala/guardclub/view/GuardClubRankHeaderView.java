package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.guardclub.g;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.model.k;
import java.math.BigDecimal;
import java.util.List;
/* loaded from: classes3.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View fBn;
    private ViewGroup fBo;
    private GuardClubRankHeaderAvatarItemView fBp;
    private GuardClubRankHeaderAvatarItemView fBq;
    private GuardClubRankHeaderAvatarItemView fBr;
    private ViewGroup fBs;
    private GuardClubRankHeaderMedalItemView fBt;
    private GuardClubRankHeaderMedalItemView fBu;
    private GuardClubRankHeaderMedalItemView fBv;
    private a fBw;
    private int fBx;

    /* loaded from: classes3.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fBw = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.fBx = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.fBs.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.fBs.getChildCount()) {
                        if (this.fBs.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.fBs.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.fBs.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.fBs.getChildCount()) {
                        if (this.fBs.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.fBs.getChildAt(i4)).setStyle(18);
                        }
                        i2 = i4 + 1;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }

    public void setAvatarTopMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBo.getLayoutParams();
        layoutParams.topMargin = i;
        this.fBo.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.fBx) {
                case 0:
                    i = a.i.guard_club_rank_list_contribution_week;
                    break;
                case 1:
                    i = a.i.guard_club_rank_list_contribution_total;
                    break;
                default:
                    i = 0;
                    break;
            }
            k kVar = list.get(0);
            this.fBp.setTag(kVar);
            this.fBp.setData(kVar.avatar, g.BH().cq(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.fBx) {
                case 0:
                    str = kVar.fAd;
                    break;
                case 1:
                    str = kVar.score;
                    break;
                default:
                    str = null;
                    break;
            }
            if (str == null) {
                str = "";
            }
            this.fBt.setData(2, kVar.name, String.format(getResources().getString(i), BV(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.fBq.setTag(kVar2);
                this.fBq.setData(kVar2.avatar, g.BH().cq(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.fBx) {
                    case 0:
                        str3 = kVar2.fAd;
                        break;
                    case 1:
                        str3 = kVar2.score;
                        break;
                    default:
                        str3 = null;
                        break;
                }
                if (str3 == null) {
                    str3 = "";
                }
                this.fBu.setData(1, kVar2.name, String.format(getResources().getString(i), BV(str3)));
            } else {
                this.fBu.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.fBr.setTag(kVar3);
                this.fBr.setData(kVar3.avatar, g.BH().cq(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.fBx) {
                    case 0:
                        str2 = kVar3.fAd;
                        break;
                    case 1:
                        str2 = kVar3.score;
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.fBv.setData(1, kVar3.name, String.format(getResources().getString(i), BV(str2)));
                return;
            }
            this.fBv.setData(1, "虚位以待", "");
        }
    }

    public void bvh() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fBo.getChildCount()) {
                if (this.fBo.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fBo.getChildAt(i2)).bve();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void buE() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fBo.getChildCount()) {
                if (this.fBo.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fBo.getChildAt(i2)).bvf();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fBo.getChildCount()) {
                if (this.fBo.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fBo.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fBw != null && (view.getTag() instanceof k)) {
            this.fBw.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.fBn = findViewById(a.g.gradient);
        this.fBo = (ViewGroup) findViewById(a.g.layout_avatar);
        this.fBp = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.fBq = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.fBr = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.fBs = (ViewGroup) findViewById(a.g.layout_medal);
        this.fBt = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.fBu = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.fBv = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.fBp.setOnClickListener(this);
        this.fBq.setOnClickListener(this);
        this.fBr.setOnClickListener(this);
        this.fBt.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.fBu.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.fBv.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.fBn.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String BV(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = p((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = p((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double p(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
