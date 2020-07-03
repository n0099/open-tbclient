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
/* loaded from: classes3.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private GuardClubRankHeaderAvatarItemView fMA;
    private ViewGroup fMB;
    private GuardClubRankHeaderMedalItemView fMC;
    private GuardClubRankHeaderMedalItemView fMD;
    private GuardClubRankHeaderMedalItemView fME;
    private a fMF;
    private int fMG;
    private View fMw;
    private ViewGroup fMx;
    private GuardClubRankHeaderAvatarItemView fMy;
    private GuardClubRankHeaderAvatarItemView fMz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fMF = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.fMG = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.fMB.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.fMB.getChildCount()) {
                        if (this.fMB.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.fMB.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.fMB.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.fMB.getChildCount()) {
                        if (this.fMB.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.fMB.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMx.getLayoutParams();
        layoutParams.topMargin = i;
        this.fMx.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.fMG) {
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
            this.fMy.setTag(kVar);
            this.fMy.setData(kVar.avatar, g.Ch().cw(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.fMG) {
                case 0:
                    str = kVar.fLm;
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
            this.fMC.setData(2, kVar.name, String.format(getResources().getString(i), Ct(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.fMz.setTag(kVar2);
                this.fMz.setData(kVar2.avatar, g.Ch().cw(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.fMG) {
                    case 0:
                        str3 = kVar2.fLm;
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
                this.fMD.setData(1, kVar2.name, String.format(getResources().getString(i), Ct(str3)));
            } else {
                this.fMD.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.fMA.setTag(kVar3);
                this.fMA.setData(kVar3.avatar, g.Ch().cw(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.fMG) {
                    case 0:
                        str2 = kVar3.fLm;
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
                this.fME.setData(1, kVar3.name, String.format(getResources().getString(i), Ct(str2)));
                return;
            }
            this.fME.setData(1, "虚位以待", "");
        }
    }

    public void byc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fMx.getChildCount()) {
                if (this.fMx.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fMx.getChildAt(i2)).bxZ();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bxz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fMx.getChildCount()) {
                if (this.fMx.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fMx.getChildAt(i2)).bya();
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
            if (i2 < this.fMx.getChildCount()) {
                if (this.fMx.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fMx.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fMF != null && (view.getTag() instanceof k)) {
            this.fMF.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.fMw = findViewById(a.g.gradient);
        this.fMx = (ViewGroup) findViewById(a.g.layout_avatar);
        this.fMy = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.fMz = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.fMA = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.fMB = (ViewGroup) findViewById(a.g.layout_medal);
        this.fMC = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.fMD = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.fME = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.fMy.setOnClickListener(this);
        this.fMz.setOnClickListener(this);
        this.fMA.setOnClickListener(this);
        this.fMC.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.fMD.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.fME.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.fMw.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String Ct(String str) {
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
