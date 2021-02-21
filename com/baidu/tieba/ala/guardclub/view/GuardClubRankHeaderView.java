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
/* loaded from: classes11.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View hci;
    private ViewGroup hcj;
    private GuardClubRankHeaderAvatarItemView hck;
    private GuardClubRankHeaderAvatarItemView hcl;
    private GuardClubRankHeaderAvatarItemView hcm;
    private ViewGroup hcn;
    private GuardClubRankHeaderMedalItemView hco;
    private GuardClubRankHeaderMedalItemView hcp;
    private GuardClubRankHeaderMedalItemView hcq;
    private a hcr;
    private int hcs;

    /* loaded from: classes11.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.hcr = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.hcs = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.hcn.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.hcn.getChildCount()) {
                        if (this.hcn.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.hcn.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.hcn.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.hcn.getChildCount()) {
                        if (this.hcn.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.hcn.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hcj.getLayoutParams();
        layoutParams.topMargin = i;
        this.hcj.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.hcs) {
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
            this.hck.setTag(kVar);
            this.hck.setData(kVar.avatar, g.IT().dr(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.hcs) {
                case 0:
                    str = kVar.haX;
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
            this.hco.setData(2, kVar.name, String.format(getResources().getString(i), GX(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.hcl.setTag(kVar2);
                this.hcl.setData(kVar2.avatar, g.IT().dr(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.hcs) {
                    case 0:
                        str3 = kVar2.haX;
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
                this.hcp.setData(1, kVar2.name, String.format(getResources().getString(i), GX(str3)));
            } else {
                this.hcp.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.hcm.setTag(kVar3);
                this.hcm.setData(kVar3.avatar, g.IT().dr(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.hcs) {
                    case 0:
                        str2 = kVar3.haX;
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
                this.hcq.setData(1, kVar3.name, String.format(getResources().getString(i), GX(str2)));
                return;
            }
            this.hcq.setData(1, "虚位以待", "");
        }
    }

    public void bWo() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hcj.getChildCount()) {
                if (this.hcj.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.hcj.getChildAt(i2)).bWl();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Xw() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hcj.getChildCount()) {
                if (this.hcj.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.hcj.getChildAt(i2)).bWm();
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
            if (i2 < this.hcj.getChildCount()) {
                if (this.hcj.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.hcj.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hcr != null && (view.getTag() instanceof k)) {
            this.hcr.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.hci = findViewById(a.f.gradient);
        this.hcj = (ViewGroup) findViewById(a.f.layout_avatar);
        this.hck = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_first);
        this.hcl = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_second);
        this.hcm = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_third);
        this.hcn = (ViewGroup) findViewById(a.f.layout_medal);
        this.hco = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_first);
        this.hcp = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_second);
        this.hcq = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_third);
        this.hck.setOnClickListener(this);
        this.hcl.setOnClickListener(this);
        this.hcm.setOnClickListener(this);
        this.hco.setMedalResource(a.e.gcb_rank_header_medal_first);
        this.hcp.setMedalResource(a.e.gcb_rank_header_medal_second);
        this.hcq.setMedalResource(a.e.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.hci.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String GX(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = s((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = s((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double s(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
