package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.k.a;
import com.baidu.tieba.ala.guardclub.m;
import com.baidu.tieba.ala.guardclub.model.p;
import java.math.BigDecimal;
import java.util.List;
/* loaded from: classes6.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View dPV;
    private ViewGroup dPW;
    private GuardClubRankHeaderAvatarItemView dPX;
    private GuardClubRankHeaderAvatarItemView dPY;
    private GuardClubRankHeaderAvatarItemView dPZ;
    private ViewGroup dQa;
    private GuardClubRankHeaderMedalItemView dQb;
    private GuardClubRankHeaderMedalItemView dQc;
    private GuardClubRankHeaderMedalItemView dQd;
    private a dQe;
    private int dQf;

    /* loaded from: classes6.dex */
    public interface a {
        void a(p pVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.dQe = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.dQf = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.dQa.setBackgroundResource(a.f.gcb_rank_header_medal_week_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.dQa.getChildCount()) {
                        if (this.dQa.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.dQa.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.dQa.setBackgroundResource(a.f.gcb_rank_header_medal_total_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.dQa.getChildCount()) {
                        if (this.dQa.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.dQa.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dPW.getLayoutParams();
        layoutParams.topMargin = i;
        this.dPW.setLayoutParams(layoutParams);
    }

    public void setData(List<p> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.dQf) {
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
            p pVar = list.get(0);
            this.dPX.setTag(pVar);
            this.dPX.setData(pVar.avatar, m.aLx().mN(pVar.level), pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId));
            switch (this.dQf) {
                case 0:
                    str = pVar.dOU;
                    break;
                case 1:
                    str = pVar.score;
                    break;
                default:
                    str = null;
                    break;
            }
            if (str == null) {
                str = "";
            }
            this.dQb.setData(2, pVar.name, String.format(getResources().getString(i), tp(str)));
            if (list.size() > 1) {
                p pVar2 = list.get(1);
                this.dPY.setTag(pVar2);
                this.dPY.setData(pVar2.avatar, m.aLx().mN(pVar2.level), pVar2.liveStatus == 1 && !TextUtils.isEmpty(pVar2.liveId));
                switch (this.dQf) {
                    case 0:
                        str3 = pVar2.dOU;
                        break;
                    case 1:
                        str3 = pVar2.score;
                        break;
                    default:
                        str3 = null;
                        break;
                }
                if (str3 == null) {
                    str3 = "";
                }
                this.dQc.setData(1, pVar2.name, String.format(getResources().getString(i), tp(str3)));
            } else {
                this.dQc.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                p pVar3 = list.get(2);
                this.dPZ.setTag(pVar3);
                this.dPZ.setData(pVar3.avatar, m.aLx().mN(pVar3.level), pVar3.liveStatus == 1 && !TextUtils.isEmpty(pVar3.liveId));
                switch (this.dQf) {
                    case 0:
                        str2 = pVar3.dOU;
                        break;
                    case 1:
                        str2 = pVar3.score;
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.dQd.setData(1, pVar3.name, String.format(getResources().getString(i), tp(str2)));
                return;
            }
            this.dQd.setData(1, "虚位以待", "");
        }
    }

    public void aMf() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dPW.getChildCount()) {
                if (this.dPW.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.dPW.getChildAt(i2)).aMc();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void aLw() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dPW.getChildCount()) {
                if (this.dPW.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.dPW.getChildAt(i2)).aMd();
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
            if (i2 < this.dPW.getChildCount()) {
                if (this.dPW.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.dPW.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dQe != null && (view.getTag() instanceof p)) {
            this.dQe.a((p) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.dPV = findViewById(a.g.gradient);
        this.dPW = (ViewGroup) findViewById(a.g.layout_avatar);
        this.dPX = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.dPY = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.dPZ = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.dQa = (ViewGroup) findViewById(a.g.layout_medal);
        this.dQb = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.dQc = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.dQd = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.dPX.setOnClickListener(this);
        this.dPY.setOnClickListener(this);
        this.dPZ.setOnClickListener(this);
        this.dQb.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.dQc.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.dQd.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.dPV.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String tp(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = h((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = h((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double h(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
