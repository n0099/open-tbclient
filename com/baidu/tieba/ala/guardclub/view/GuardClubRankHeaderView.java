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
    private View gdO;
    private ViewGroup gdP;
    private GuardClubRankHeaderAvatarItemView gdQ;
    private GuardClubRankHeaderAvatarItemView gdR;
    private GuardClubRankHeaderAvatarItemView gdS;
    private ViewGroup gdT;
    private GuardClubRankHeaderMedalItemView gdU;
    private GuardClubRankHeaderMedalItemView gdV;
    private GuardClubRankHeaderMedalItemView gdW;
    private a gdX;
    private int gdY;

    /* loaded from: classes7.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gdX = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gdY = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.gdT.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.gdT.getChildCount()) {
                        if (this.gdT.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gdT.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.gdT.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.gdT.getChildCount()) {
                        if (this.gdT.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gdT.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdP.getLayoutParams();
        layoutParams.topMargin = i;
        this.gdP.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gdY) {
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
            this.gdQ.setTag(kVar);
            this.gdQ.setData(kVar.avatar, g.Im().es(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gdY) {
                case 0:
                    str = kVar.gcE;
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
            this.gdU.setData(2, kVar.name, String.format(getResources().getString(i), FA(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.gdR.setTag(kVar2);
                this.gdR.setData(kVar2.avatar, g.Im().es(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gdY) {
                    case 0:
                        str3 = kVar2.gcE;
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
                this.gdV.setData(1, kVar2.name, String.format(getResources().getString(i), FA(str3)));
            } else {
                this.gdV.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.gdS.setTag(kVar3);
                this.gdS.setData(kVar3.avatar, g.Im().es(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gdY) {
                    case 0:
                        str2 = kVar3.gcE;
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
                this.gdW.setData(1, kVar3.name, String.format(getResources().getString(i), FA(str2)));
                return;
            }
            this.gdW.setData(1, "虚位以待", "");
        }
    }

    public void bKM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gdP.getChildCount()) {
                if (this.gdP.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gdP.getChildAt(i2)).bKJ();
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
            if (i2 < this.gdP.getChildCount()) {
                if (this.gdP.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gdP.getChildAt(i2)).bKK();
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
            if (i2 < this.gdP.getChildCount()) {
                if (this.gdP.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gdP.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gdX != null && (view.getTag() instanceof k)) {
            this.gdX.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.gdO = findViewById(a.g.gradient);
        this.gdP = (ViewGroup) findViewById(a.g.layout_avatar);
        this.gdQ = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.gdR = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.gdS = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.gdT = (ViewGroup) findViewById(a.g.layout_medal);
        this.gdU = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.gdV = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.gdW = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.gdQ.setOnClickListener(this);
        this.gdR.setOnClickListener(this);
        this.gdS.setOnClickListener(this);
        this.gdU.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.gdV.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.gdW.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.gdO.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String FA(String str) {
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
