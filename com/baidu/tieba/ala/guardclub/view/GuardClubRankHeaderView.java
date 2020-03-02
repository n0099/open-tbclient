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
    private int eIA;
    private View eIq;
    private ViewGroup eIr;
    private GuardClubRankHeaderAvatarItemView eIs;
    private GuardClubRankHeaderAvatarItemView eIt;
    private GuardClubRankHeaderAvatarItemView eIu;
    private ViewGroup eIv;
    private GuardClubRankHeaderMedalItemView eIw;
    private GuardClubRankHeaderMedalItemView eIx;
    private GuardClubRankHeaderMedalItemView eIy;
    private a eIz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.eIz = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.eIA = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.eIv.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.eIv.getChildCount()) {
                        if (this.eIv.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eIv.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.eIv.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.eIv.getChildCount()) {
                        if (this.eIv.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eIv.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIr.getLayoutParams();
        layoutParams.topMargin = i;
        this.eIr.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.eIA) {
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
            this.eIs.setTag(kVar);
            this.eIs.setData(kVar.avatar, g.vH().bS(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.eIA) {
                case 0:
                    str = kVar.eHg;
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
            this.eIw.setData(2, kVar.name, String.format(getResources().getString(i), yB(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.eIt.setTag(kVar2);
                this.eIt.setData(kVar2.avatar, g.vH().bS(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.eIA) {
                    case 0:
                        str3 = kVar2.eHg;
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
                this.eIx.setData(1, kVar2.name, String.format(getResources().getString(i), yB(str3)));
            } else {
                this.eIx.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.eIu.setTag(kVar3);
                this.eIu.setData(kVar3.avatar, g.vH().bS(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.eIA) {
                    case 0:
                        str2 = kVar3.eHg;
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
                this.eIy.setData(1, kVar3.name, String.format(getResources().getString(i), yB(str2)));
                return;
            }
            this.eIy.setData(1, "虚位以待", "");
        }
    }

    public void bfT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIr.getChildCount()) {
                if (this.eIr.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eIr.getChildAt(i2)).bfQ();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bfp() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIr.getChildCount()) {
                if (this.eIr.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eIr.getChildAt(i2)).bfR();
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
            if (i2 < this.eIr.getChildCount()) {
                if (this.eIr.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eIr.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eIz != null && (view.getTag() instanceof k)) {
            this.eIz.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.eIq = findViewById(a.g.gradient);
        this.eIr = (ViewGroup) findViewById(a.g.layout_avatar);
        this.eIs = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.eIt = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.eIu = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.eIv = (ViewGroup) findViewById(a.g.layout_medal);
        this.eIw = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.eIx = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.eIy = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.eIs.setOnClickListener(this);
        this.eIt.setOnClickListener(this);
        this.eIu.setOnClickListener(this);
        this.eIw.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.eIx.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.eIy.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.eIq.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String yB(String str) {
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
