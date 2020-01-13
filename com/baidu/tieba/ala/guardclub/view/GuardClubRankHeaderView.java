package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.r.a;
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.p;
import java.math.BigDecimal;
import java.util.List;
/* loaded from: classes2.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private ViewGroup eEA;
    private GuardClubRankHeaderMedalItemView eEB;
    private GuardClubRankHeaderMedalItemView eEC;
    private GuardClubRankHeaderMedalItemView eED;
    private a eEE;
    private int eEF;
    private View eEv;
    private ViewGroup eEw;
    private GuardClubRankHeaderAvatarItemView eEx;
    private GuardClubRankHeaderAvatarItemView eEy;
    private GuardClubRankHeaderAvatarItemView eEz;

    /* loaded from: classes2.dex */
    public interface a {
        void a(p pVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.eEE = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.eEF = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.eEA.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.eEA.getChildCount()) {
                        if (this.eEA.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eEA.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.eEA.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.eEA.getChildCount()) {
                        if (this.eEA.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eEA.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEw.getLayoutParams();
        layoutParams.topMargin = i;
        this.eEw.setLayoutParams(layoutParams);
    }

    public void setData(List<p> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.eEF) {
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
            this.eEx.setTag(pVar);
            this.eEx.setData(pVar.avatar, l.bcZ().pd(pVar.level), pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId));
            switch (this.eEF) {
                case 0:
                    str = pVar.eDv;
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
            this.eEB.setData(2, pVar.name, String.format(getResources().getString(i), yf(str)));
            if (list.size() > 1) {
                p pVar2 = list.get(1);
                this.eEy.setTag(pVar2);
                this.eEy.setData(pVar2.avatar, l.bcZ().pd(pVar2.level), pVar2.liveStatus == 1 && !TextUtils.isEmpty(pVar2.liveId));
                switch (this.eEF) {
                    case 0:
                        str3 = pVar2.eDv;
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
                this.eEC.setData(1, pVar2.name, String.format(getResources().getString(i), yf(str3)));
            } else {
                this.eEC.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                p pVar3 = list.get(2);
                this.eEz.setTag(pVar3);
                this.eEz.setData(pVar3.avatar, l.bcZ().pd(pVar3.level), pVar3.liveStatus == 1 && !TextUtils.isEmpty(pVar3.liveId));
                switch (this.eEF) {
                    case 0:
                        str2 = pVar3.eDv;
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
                this.eED.setData(1, pVar3.name, String.format(getResources().getString(i), yf(str2)));
                return;
            }
            this.eED.setData(1, "虚位以待", "");
        }
    }

    public void bdH() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eEw.getChildCount()) {
                if (this.eEw.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eEw.getChildAt(i2)).bdE();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bcY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eEw.getChildCount()) {
                if (this.eEw.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eEw.getChildAt(i2)).bdF();
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
            if (i2 < this.eEw.getChildCount()) {
                if (this.eEw.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eEw.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eEE != null && (view.getTag() instanceof p)) {
            this.eEE.a((p) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.eEv = findViewById(a.g.gradient);
        this.eEw = (ViewGroup) findViewById(a.g.layout_avatar);
        this.eEx = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.eEy = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.eEz = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.eEA = (ViewGroup) findViewById(a.g.layout_medal);
        this.eEB = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.eEC = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.eED = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.eEx.setOnClickListener(this);
        this.eEy.setOnClickListener(this);
        this.eEz.setOnClickListener(this);
        this.eEB.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.eEC.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.eED.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.eEv.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String yf(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = i((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = i((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double i(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
