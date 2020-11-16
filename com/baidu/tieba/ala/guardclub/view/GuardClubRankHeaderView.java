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
    private View gIR;
    private ViewGroup gIS;
    private GuardClubRankHeaderAvatarItemView gIT;
    private GuardClubRankHeaderAvatarItemView gIU;
    private GuardClubRankHeaderAvatarItemView gIV;
    private ViewGroup gIW;
    private GuardClubRankHeaderMedalItemView gIX;
    private GuardClubRankHeaderMedalItemView gIY;
    private GuardClubRankHeaderMedalItemView gIZ;
    private a gJa;
    private int gJb;

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gJa = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gJb = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.gIW.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.gIW.getChildCount()) {
                        if (this.gIW.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gIW.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.gIW.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.gIW.getChildCount()) {
                        if (this.gIW.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gIW.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gIS.getLayoutParams();
        layoutParams.topMargin = i;
        this.gIS.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gJb) {
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
            this.gIT.setTag(kVar);
            this.gIT.setData(kVar.avatar, g.JW().ey(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gJb) {
                case 0:
                    str = kVar.gHJ;
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
            this.gIX.setData(2, kVar.name, String.format(getResources().getString(i), GV(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.gIU.setTag(kVar2);
                this.gIU.setData(kVar2.avatar, g.JW().ey(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gJb) {
                    case 0:
                        str3 = kVar2.gHJ;
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
                this.gIY.setData(1, kVar2.name, String.format(getResources().getString(i), GV(str3)));
            } else {
                this.gIY.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.gIV.setTag(kVar3);
                this.gIV.setData(kVar3.avatar, g.JW().ey(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gJb) {
                    case 0:
                        str2 = kVar3.gHJ;
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
                this.gIZ.setData(1, kVar3.name, String.format(getResources().getString(i), GV(str2)));
                return;
            }
            this.gIZ.setData(1, "虚位以待", "");
        }
    }

    public void bTe() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gIS.getChildCount()) {
                if (this.gIS.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gIS.getChildAt(i2)).bTb();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void VV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gIS.getChildCount()) {
                if (this.gIS.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gIS.getChildAt(i2)).bTc();
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
            if (i2 < this.gIS.getChildCount()) {
                if (this.gIS.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gIS.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gJa != null && (view.getTag() instanceof k)) {
            this.gJa.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.gIR = findViewById(a.f.gradient);
        this.gIS = (ViewGroup) findViewById(a.f.layout_avatar);
        this.gIT = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_first);
        this.gIU = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_second);
        this.gIV = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_third);
        this.gIW = (ViewGroup) findViewById(a.f.layout_medal);
        this.gIX = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_first);
        this.gIY = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_second);
        this.gIZ = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_third);
        this.gIT.setOnClickListener(this);
        this.gIU.setOnClickListener(this);
        this.gIV.setOnClickListener(this);
        this.gIX.setMedalResource(a.e.gcb_rank_header_medal_first);
        this.gIY.setMedalResource(a.e.gcb_rank_header_medal_second);
        this.gIZ.setMedalResource(a.e.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.gIR.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String GV(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = y((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = y((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double y(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
