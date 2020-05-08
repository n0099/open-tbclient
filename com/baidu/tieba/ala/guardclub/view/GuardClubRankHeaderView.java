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
    private ViewGroup fnA;
    private GuardClubRankHeaderMedalItemView fnB;
    private GuardClubRankHeaderMedalItemView fnC;
    private GuardClubRankHeaderMedalItemView fnD;
    private a fnE;
    private int fnF;
    private View fnv;
    private ViewGroup fnw;
    private GuardClubRankHeaderAvatarItemView fnx;
    private GuardClubRankHeaderAvatarItemView fny;
    private GuardClubRankHeaderAvatarItemView fnz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(k kVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fnE = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.fnF = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.fnA.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.fnA.getChildCount()) {
                        if (this.fnA.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.fnA.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.fnA.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.fnA.getChildCount()) {
                        if (this.fnA.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.fnA.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fnw.getLayoutParams();
        layoutParams.topMargin = i;
        this.fnw.setLayoutParams(layoutParams);
    }

    public void setData(List<k> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.fnF) {
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
            this.fnx.setTag(kVar);
            this.fnx.setData(kVar.avatar, g.Ar().ch(kVar.level), kVar.liveStatus == 1 && !TextUtils.isEmpty(kVar.liveId));
            switch (this.fnF) {
                case 0:
                    str = kVar.fml;
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
            this.fnB.setData(2, kVar.name, String.format(getResources().getString(i), Ao(str)));
            if (list.size() > 1) {
                k kVar2 = list.get(1);
                this.fny.setTag(kVar2);
                this.fny.setData(kVar2.avatar, g.Ar().ch(kVar2.level), kVar2.liveStatus == 1 && !TextUtils.isEmpty(kVar2.liveId));
                switch (this.fnF) {
                    case 0:
                        str3 = kVar2.fml;
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
                this.fnC.setData(1, kVar2.name, String.format(getResources().getString(i), Ao(str3)));
            } else {
                this.fnC.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                k kVar3 = list.get(2);
                this.fnz.setTag(kVar3);
                this.fnz.setData(kVar3.avatar, g.Ar().ch(kVar3.level), kVar3.liveStatus == 1 && !TextUtils.isEmpty(kVar3.liveId));
                switch (this.fnF) {
                    case 0:
                        str2 = kVar3.fml;
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
                this.fnD.setData(1, kVar3.name, String.format(getResources().getString(i), Ao(str2)));
                return;
            }
            this.fnD.setData(1, "虚位以待", "");
        }
    }

    public void bpo() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fnw.getChildCount()) {
                if (this.fnw.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fnw.getChildAt(i2)).bpl();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void boK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fnw.getChildCount()) {
                if (this.fnw.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fnw.getChildAt(i2)).bpm();
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
            if (i2 < this.fnw.getChildCount()) {
                if (this.fnw.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.fnw.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fnE != null && (view.getTag() instanceof k)) {
            this.fnE.a((k) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.fnv = findViewById(a.g.gradient);
        this.fnw = (ViewGroup) findViewById(a.g.layout_avatar);
        this.fnx = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.fny = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.fnz = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.fnA = (ViewGroup) findViewById(a.g.layout_medal);
        this.fnB = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.fnC = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.fnD = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.fnx.setOnClickListener(this);
        this.fny.setOnClickListener(this);
        this.fnz.setOnClickListener(this);
        this.fnB.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.fnC.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.fnD.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.fnv.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String Ao(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 100000000) {
                str = o((parseLong * 1.0d) / 1.0E8d) + "亿";
            } else if (parseLong > 10000) {
                str = o((parseLong * 1.0d) / 10000.0d) + "万";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private double o(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
