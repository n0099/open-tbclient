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
    private View eID;
    private ViewGroup eIE;
    private GuardClubRankHeaderAvatarItemView eIF;
    private GuardClubRankHeaderAvatarItemView eIG;
    private GuardClubRankHeaderAvatarItemView eIH;
    private ViewGroup eII;
    private GuardClubRankHeaderMedalItemView eIJ;
    private GuardClubRankHeaderMedalItemView eIK;
    private GuardClubRankHeaderMedalItemView eIL;
    private a eIM;
    private int eIN;

    /* loaded from: classes3.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.eIM = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.eIN = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.eII.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.eII.getChildCount()) {
                        if (this.eII.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eII.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.eII.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.eII.getChildCount()) {
                        if (this.eII.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eII.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIE.getLayoutParams();
        layoutParams.topMargin = i;
        this.eIE.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.eIN) {
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
            this.eIF.setTag(kVar);
            this.eIF.setData(kVar.avatar, g.vH().bS(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.eIN) {
                case 0:
                    str = kVar.eHt;
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
            this.eIJ.setData(2, kVar.name, String.format(getResources().getString(i), yC(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.eIG.setTag(kVar2);
                this.eIG.setData(kVar2.avatar, g.vH().bS(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.eIN) {
                    case 0:
                        str3 = kVar2.eHt;
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
                this.eIK.setData(1, kVar2.name, String.format(getResources().getString(i), yC(str3)));
            } else {
                this.eIK.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.eIH.setTag(kVar3);
                this.eIH.setData(kVar3.avatar, g.vH().bS(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.eIN) {
                    case 0:
                        str2 = kVar3.eHt;
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
                this.eIL.setData(1, kVar3.name, String.format(getResources().getString(i), yC(str2)));
                return;
            }
            this.eIL.setData(1, "虚位以待", "");
        }
    }

    public void bfU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIE.getChildCount()) {
                if (this.eIE.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eIE.getChildAt(i2)).bfR();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bfq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIE.getChildCount()) {
                if (this.eIE.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eIE.getChildAt(i2)).bfS();
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
            if (i2 < this.eIE.getChildCount()) {
                if (this.eIE.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eIE.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eIM != null && (view.getTag() instanceof k)) {
            this.eIM.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.eID = findViewById(a.g.gradient);
        this.eIE = (ViewGroup) findViewById(a.g.layout_avatar);
        this.eIF = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.eIG = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.eIH = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.eII = (ViewGroup) findViewById(a.g.layout_medal);
        this.eIJ = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.eIK = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.eIL = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.eIF.setOnClickListener(this);
        this.eIG.setOnClickListener(this);
        this.eIH.setOnClickListener(this);
        this.eIJ.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.eIK.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.eIL.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.eID.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String yC(String str) {
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
