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
/* loaded from: classes7.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View gdS;
    private ViewGroup gdT;
    private GuardClubRankHeaderAvatarItemView gdU;
    private GuardClubRankHeaderAvatarItemView gdV;
    private GuardClubRankHeaderAvatarItemView gdW;
    private ViewGroup gdX;
    private GuardClubRankHeaderMedalItemView gdY;
    private GuardClubRankHeaderMedalItemView gdZ;
    private GuardClubRankHeaderMedalItemView gea;
    private a geb;
    private int gec;

    /* loaded from: classes7.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.geb = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gec = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.gdX.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.gdX.getChildCount()) {
                        if (this.gdX.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gdX.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.gdX.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.gdX.getChildCount()) {
                        if (this.gdX.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gdX.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdT.getLayoutParams();
        layoutParams.topMargin = i;
        this.gdT.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gec) {
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
            this.gdU.setTag(kVar);
            this.gdU.setData(kVar.avatar, g.Im().es(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gec) {
                case 0:
                    str = kVar.gcI;
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
            this.gdY.setData(2, kVar.name, String.format(getResources().getString(i), FB(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.gdV.setTag(kVar2);
                this.gdV.setData(kVar2.avatar, g.Im().es(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gec) {
                    case 0:
                        str3 = kVar2.gcI;
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
                this.gdZ.setData(1, kVar2.name, String.format(getResources().getString(i), FB(str3)));
            } else {
                this.gdZ.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.gdW.setTag(kVar3);
                this.gdW.setData(kVar3.avatar, g.Im().es(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gec) {
                    case 0:
                        str2 = kVar3.gcI;
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
                this.gea.setData(1, kVar3.name, String.format(getResources().getString(i), FB(str2)));
                return;
            }
            this.gea.setData(1, "虚位以待", "");
        }
    }

    public void bKN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gdT.getChildCount()) {
                if (this.gdT.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gdT.getChildAt(i2)).bKK();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void QC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gdT.getChildCount()) {
                if (this.gdT.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gdT.getChildAt(i2)).bKL();
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
            if (i2 < this.gdT.getChildCount()) {
                if (this.gdT.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gdT.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.geb != null && (view.getTag() instanceof k)) {
            this.geb.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.gdS = findViewById(a.g.gradient);
        this.gdT = (ViewGroup) findViewById(a.g.layout_avatar);
        this.gdU = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.gdV = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.gdW = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.gdX = (ViewGroup) findViewById(a.g.layout_medal);
        this.gdY = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.gdZ = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.gea = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.gdU.setOnClickListener(this);
        this.gdV.setOnClickListener(this);
        this.gdW.setOnClickListener(this);
        this.gdY.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.gdZ.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.gea.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.gdS.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String FB(String str) {
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
