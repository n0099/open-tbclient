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
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.guardclub.model.k;
import java.math.BigDecimal;
import java.util.List;
/* loaded from: classes4.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View ghe;
    private ViewGroup ghf;
    private GuardClubRankHeaderAvatarItemView ghg;
    private GuardClubRankHeaderAvatarItemView ghh;
    private GuardClubRankHeaderAvatarItemView ghi;
    private ViewGroup ghj;
    private GuardClubRankHeaderMedalItemView ghk;
    private GuardClubRankHeaderMedalItemView ghl;
    private GuardClubRankHeaderMedalItemView ghm;
    private a ghn;
    private int gho;

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.ghn = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gho = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.ghj.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.ghj.getChildCount()) {
                        if (this.ghj.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.ghj.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.ghj.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.ghj.getChildCount()) {
                        if (this.ghj.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.ghj.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ghf.getLayoutParams();
        layoutParams.topMargin = i;
        this.ghf.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gho) {
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
            this.ghg.setTag(kVar);
            this.ghg.setData(kVar.avatar, g.IP().ew(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gho) {
                case 0:
                    str = kVar.gfV;
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
            this.ghk.setData(2, kVar.name, String.format(getResources().getString(i), FY(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.ghh.setTag(kVar2);
                this.ghh.setData(kVar2.avatar, g.IP().ew(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gho) {
                    case 0:
                        str3 = kVar2.gfV;
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
                this.ghl.setData(1, kVar2.name, String.format(getResources().getString(i), FY(str3)));
            } else {
                this.ghl.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.ghi.setTag(kVar3);
                this.ghi.setData(kVar3.avatar, g.IP().ew(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gho) {
                    case 0:
                        str2 = kVar3.gfV;
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
                this.ghm.setData(1, kVar3.name, String.format(getResources().getString(i), FY(str2)));
                return;
            }
            this.ghm.setData(1, "虚位以待", "");
        }
    }

    public void bLX() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ghf.getChildCount()) {
                if (this.ghf.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.ghf.getChildAt(i2)).bLU();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Rm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ghf.getChildCount()) {
                if (this.ghf.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.ghf.getChildAt(i2)).bLV();
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
            if (i2 < this.ghf.getChildCount()) {
                if (this.ghf.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.ghf.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ghn != null && (view.getTag() instanceof k)) {
            this.ghn.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.ghe = findViewById(a.g.gradient);
        this.ghf = (ViewGroup) findViewById(a.g.layout_avatar);
        this.ghg = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.ghh = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.ghi = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.ghj = (ViewGroup) findViewById(a.g.layout_medal);
        this.ghk = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.ghl = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.ghm = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.ghg.setOnClickListener(this);
        this.ghh.setOnClickListener(this);
        this.ghi.setOnClickListener(this);
        this.ghk.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.ghl.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.ghm.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.ghe.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String FY(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = v((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = v((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double v(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
