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
/* loaded from: classes10.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View gZk;
    private ViewGroup gZl;
    private GuardClubRankHeaderAvatarItemView gZm;
    private GuardClubRankHeaderAvatarItemView gZn;
    private GuardClubRankHeaderAvatarItemView gZo;
    private ViewGroup gZp;
    private GuardClubRankHeaderMedalItemView gZq;
    private GuardClubRankHeaderMedalItemView gZr;
    private GuardClubRankHeaderMedalItemView gZs;
    private a gZt;
    private int gZu;

    /* loaded from: classes10.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gZt = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.gZu = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.gZp.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.gZp.getChildCount()) {
                        if (this.gZp.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gZp.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.gZp.setBackgroundResource(a.e.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.gZp.getChildCount()) {
                        if (this.gZp.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.gZp.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZl.getLayoutParams();
        layoutParams.topMargin = i;
        this.gZl.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.gZu) {
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
            this.gZm.setTag(kVar);
            this.gZm.setData(kVar.avatar, g.HD().dm(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.gZu) {
                case 0:
                    str = kVar.gXZ;
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
            this.gZq.setData(2, kVar.name, String.format(getResources().getString(i), Gx(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.gZn.setTag(kVar2);
                this.gZn.setData(kVar2.avatar, g.HD().dm(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.gZu) {
                    case 0:
                        str3 = kVar2.gXZ;
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
                this.gZr.setData(1, kVar2.name, String.format(getResources().getString(i), Gx(str3)));
            } else {
                this.gZr.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.gZo.setTag(kVar3);
                this.gZo.setData(kVar3.avatar, g.HD().dm(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.gZu) {
                    case 0:
                        str2 = kVar3.gXZ;
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
                this.gZs.setData(1, kVar3.name, String.format(getResources().getString(i), Gx(str2)));
                return;
            }
            this.gZs.setData(1, "虚位以待", "");
        }
    }

    public void bVD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gZl.getChildCount()) {
                if (this.gZl.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gZl.getChildAt(i2)).bVA();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void VN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gZl.getChildCount()) {
                if (this.gZl.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gZl.getChildAt(i2)).bVB();
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
            if (i2 < this.gZl.getChildCount()) {
                if (this.gZl.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.gZl.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gZt != null && (view.getTag() instanceof k)) {
            this.gZt.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.gZk = findViewById(a.f.gradient);
        this.gZl = (ViewGroup) findViewById(a.f.layout_avatar);
        this.gZm = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_first);
        this.gZn = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_second);
        this.gZo = (GuardClubRankHeaderAvatarItemView) findViewById(a.f.avatar_third);
        this.gZp = (ViewGroup) findViewById(a.f.layout_medal);
        this.gZq = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_first);
        this.gZr = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_second);
        this.gZs = (GuardClubRankHeaderMedalItemView) findViewById(a.f.medal_third);
        this.gZm.setOnClickListener(this);
        this.gZn.setOnClickListener(this);
        this.gZo.setOnClickListener(this);
        this.gZq.setMedalResource(a.e.gcb_rank_header_medal_first);
        this.gZr.setMedalResource(a.e.gcb_rank_header_medal_second);
        this.gZs.setMedalResource(a.e.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.gZk.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String Gx(String str) {
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
