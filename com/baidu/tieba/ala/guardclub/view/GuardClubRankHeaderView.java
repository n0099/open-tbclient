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
    private View gSb;
    private ViewGroup gSc;
    private GuardClubRankHeaderAvatarItemView gSd;
    private GuardClubRankHeaderAvatarItemView gSe;
    private GuardClubRankHeaderAvatarItemView gSf;
    private ViewGroup gSg;
    private GuardClubRankHeaderMedalItemView gSh;
    private GuardClubRankHeaderMedalItemView gSi;
    private GuardClubRankHeaderMedalItemView gSj;
    private a gSk;
    private int gSl;

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gSk = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gSl = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.gSg.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.gSg.getChildCount()) {
                        if (this.gSg.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gSg.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.gSg.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.gSg.getChildCount()) {
                        if (this.gSg.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gSg.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSc.getLayoutParams();
        layoutParams.topMargin = i;
        this.gSc.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gSl) {
                case 0:
                    i = a.h.guard_club_rank_list_contribution_week;
                    break;
                case 1:
                    i = a.h.guard_club_rank_list_contribution_total;
                    break;
                default:
                    i = 0;
                    break;
            }
            k kVar = list.get(0);
            this.gSd.setTag(kVar);
            this.gSd.setData(kVar.avatar, g.LZ().eU(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gSl) {
                case 0:
                    str = kVar.gQQ;
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
            this.gSh.setData(2, kVar.name, String.format(getResources().getString(i), HJ(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.gSe.setTag(kVar2);
                this.gSe.setData(kVar2.avatar, g.LZ().eU(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gSl) {
                    case 0:
                        str3 = kVar2.gQQ;
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
                this.gSi.setData(1, kVar2.name, String.format(getResources().getString(i), HJ(str3)));
            } else {
                this.gSi.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.gSf.setTag(kVar3);
                this.gSf.setData(kVar3.avatar, g.LZ().eU(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gSl) {
                    case 0:
                        str2 = kVar3.gQQ;
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
                this.gSj.setData(1, kVar3.name, String.format(getResources().getString(i), HJ(str2)));
                return;
            }
            this.gSj.setData(1, "虚位以待", "");
        }
    }

    public void bWO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gSc.getChildCount()) {
                if (this.gSc.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gSc.getChildAt(i2)).bWL();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Yv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gSc.getChildCount()) {
                if (this.gSc.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gSc.getChildAt(i2)).bWM();
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
            if (i2 < this.gSc.getChildCount()) {
                if (this.gSc.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gSc.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gSk != null && (view.getTag() instanceof k)) {
            this.gSk.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.gSb = findViewById(a.f.gradient);
        this.gSc = (ViewGroup) findViewById(a.f.layout_avatar);
        this.gSd = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_first);
        this.gSe = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_second);
        this.gSf = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_third);
        this.gSg = (ViewGroup) findViewById(a.f.layout_medal);
        this.gSh = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_first);
        this.gSi = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_second);
        this.gSj = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_third);
        this.gSd.setOnClickListener(this);
        this.gSe.setOnClickListener(this);
        this.gSf.setOnClickListener(this);
        this.gSh.setMedalResource(a.e.gcb_rank_header_medal_first);
        this.gSi.setMedalResource(a.e.gcb_rank_header_medal_second);
        this.gSj.setMedalResource(a.e.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.gSb.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String HJ(String str) {
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
