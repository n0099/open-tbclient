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
    private GuardClubRankHeaderAvatarItemView gDA;
    private GuardClubRankHeaderAvatarItemView gDB;
    private ViewGroup gDC;
    private GuardClubRankHeaderMedalItemView gDD;
    private GuardClubRankHeaderMedalItemView gDE;
    private GuardClubRankHeaderMedalItemView gDF;
    private a gDG;
    private int gDH;
    private View gDx;
    private ViewGroup gDy;
    private GuardClubRankHeaderAvatarItemView gDz;

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gDG = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gDH = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.gDC.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.gDC.getChildCount()) {
                        if (this.gDC.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gDC.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.gDC.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.gDC.getChildCount()) {
                        if (this.gDC.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gDC.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDy.getLayoutParams();
        layoutParams.topMargin = i;
        this.gDy.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gDH) {
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
            this.gDz.setTag(kVar);
            this.gDz.setData(kVar.avatar, g.Kf().eC(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gDH) {
                case 0:
                    str = kVar.gCo;
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
            this.gDD.setData(2, kVar.name, String.format(getResources().getString(i), Hh(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.gDA.setTag(kVar2);
                this.gDA.setData(kVar2.avatar, g.Kf().eC(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gDH) {
                    case 0:
                        str3 = kVar2.gCo;
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
                this.gDE.setData(1, kVar2.name, String.format(getResources().getString(i), Hh(str3)));
            } else {
                this.gDE.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.gDB.setTag(kVar3);
                this.gDB.setData(kVar3.avatar, g.Kf().eC(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gDH) {
                    case 0:
                        str2 = kVar3.gCo;
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
                this.gDF.setData(1, kVar3.name, String.format(getResources().getString(i), Hh(str2)));
                return;
            }
            this.gDF.setData(1, "虚位以待", "");
        }
    }

    public void bRm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gDy.getChildCount()) {
                if (this.gDy.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gDy.getChildAt(i2)).bRj();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ue() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gDy.getChildCount()) {
                if (this.gDy.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gDy.getChildAt(i2)).bRk();
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
            if (i2 < this.gDy.getChildCount()) {
                if (this.gDy.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gDy.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gDG != null && (view.getTag() instanceof k)) {
            this.gDG.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.gDx = findViewById(a.g.gradient);
        this.gDy = (ViewGroup) findViewById(a.g.layout_avatar);
        this.gDz = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.gDA = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.gDB = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.gDC = (ViewGroup) findViewById(a.g.layout_medal);
        this.gDD = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.gDE = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.gDF = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.gDz.setOnClickListener(this);
        this.gDA.setOnClickListener(this);
        this.gDB.setOnClickListener(this);
        this.gDD.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.gDE.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.gDF.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.gDx.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String Hh(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = z((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = z((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double z(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
