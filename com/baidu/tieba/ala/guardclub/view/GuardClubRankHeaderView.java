package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.q.a;
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.p;
import java.math.BigDecimal;
import java.util.List;
/* loaded from: classes2.dex */
public class GuardClubRankHeaderView extends RelativeLayout implements View.OnClickListener {
    private View eDk;
    private ViewGroup eDl;
    private GuardClubRankHeaderAvatarItemView eDm;
    private GuardClubRankHeaderAvatarItemView eDn;
    private GuardClubRankHeaderAvatarItemView eDo;
    private ViewGroup eDp;
    private GuardClubRankHeaderMedalItemView eDq;
    private GuardClubRankHeaderMedalItemView eDr;
    private GuardClubRankHeaderMedalItemView eDs;
    private a eDt;
    private int eDu;

    /* loaded from: classes2.dex */
    public interface a {
        void a(p pVar);
    }

    public GuardClubRankHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.eDt = aVar;
    }

    public void setStyle(int i) {
        int i2 = 0;
        this.eDu = i;
        switch (i) {
            case 0:
                setGradientColors(new int[]{-5368807, -12646528, -14875807});
                this.eDp.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i3 = i2;
                    if (i3 < this.eDp.getChildCount()) {
                        if (this.eDp.getChildAt(i3) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eDp.getChildAt(i3)).setStyle(17);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 1:
                setGradientColors(new int[]{-6422368, -9957742, -12185707});
                this.eDp.setBackgroundResource(a.f.gcb_rank_header_medal_bg);
                while (true) {
                    int i4 = i2;
                    if (i4 < this.eDp.getChildCount()) {
                        if (this.eDp.getChildAt(i4) instanceof GuardClubRankHeaderMedalItemView) {
                            ((GuardClubRankHeaderMedalItemView) this.eDp.getChildAt(i4)).setStyle(18);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eDl.getLayoutParams();
        layoutParams.topMargin = i;
        this.eDl.setLayoutParams(layoutParams);
    }

    public void setData(List<p> list) {
        int i;
        String str;
        String str2;
        String str3;
        if (list != null && !list.isEmpty()) {
            switch (this.eDu) {
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
            p pVar = list.get(0);
            this.eDm.setTag(pVar);
            this.eDm.setData(pVar.avatar, l.bcE().pc(pVar.level), pVar.liveStatus == 1 && !TextUtils.isEmpty(pVar.liveId));
            switch (this.eDu) {
                case 0:
                    str = pVar.eCk;
                    break;
                case 1:
                    str = pVar.score;
                    break;
                default:
                    str = null;
                    break;
            }
            if (str == null) {
                str = "";
            }
            this.eDq.setData(2, pVar.name, String.format(getResources().getString(i), ya(str)));
            if (list.size() > 1) {
                p pVar2 = list.get(1);
                this.eDn.setTag(pVar2);
                this.eDn.setData(pVar2.avatar, l.bcE().pc(pVar2.level), pVar2.liveStatus == 1 && !TextUtils.isEmpty(pVar2.liveId));
                switch (this.eDu) {
                    case 0:
                        str3 = pVar2.eCk;
                        break;
                    case 1:
                        str3 = pVar2.score;
                        break;
                    default:
                        str3 = null;
                        break;
                }
                if (str3 == null) {
                    str3 = "";
                }
                this.eDr.setData(1, pVar2.name, String.format(getResources().getString(i), ya(str3)));
            } else {
                this.eDr.setData(1, "虚位以待", "");
            }
            if (list.size() > 2) {
                p pVar3 = list.get(2);
                this.eDo.setTag(pVar3);
                this.eDo.setData(pVar3.avatar, l.bcE().pc(pVar3.level), pVar3.liveStatus == 1 && !TextUtils.isEmpty(pVar3.liveId));
                switch (this.eDu) {
                    case 0:
                        str2 = pVar3.eCk;
                        break;
                    case 1:
                        str2 = pVar3.score;
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.eDs.setData(1, pVar3.name, String.format(getResources().getString(i), ya(str2)));
                return;
            }
            this.eDs.setData(1, "虚位以待", "");
        }
    }

    public void bdm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eDl.getChildCount()) {
                if (this.eDl.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eDl.getChildAt(i2)).bdj();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bcD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eDl.getChildCount()) {
                if (this.eDl.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eDl.getChildAt(i2)).bdk();
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
            if (i2 < this.eDl.getChildCount()) {
                if (this.eDl.getChildAt(i2) instanceof GuardClubRankHeaderAvatarItemView) {
                    ((GuardClubRankHeaderAvatarItemView) this.eDl.getChildAt(i2)).release();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eDt != null && (view.getTag() instanceof p)) {
            this.eDt.a((p) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header, (ViewGroup) this, true);
        this.eDk = findViewById(a.g.gradient);
        this.eDl = (ViewGroup) findViewById(a.g.layout_avatar);
        this.eDm = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_first);
        this.eDn = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_second);
        this.eDo = (GuardClubRankHeaderAvatarItemView) findViewById(a.g.avatar_third);
        this.eDp = (ViewGroup) findViewById(a.g.layout_medal);
        this.eDq = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_first);
        this.eDr = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_second);
        this.eDs = (GuardClubRankHeaderMedalItemView) findViewById(a.g.medal_third);
        this.eDm.setOnClickListener(this);
        this.eDn.setOnClickListener(this);
        this.eDo.setOnClickListener(this);
        this.eDq.setMedalResource(a.f.gcb_rank_header_medal_first);
        this.eDr.setMedalResource(a.f.gcb_rank_header_medal_second);
        this.eDs.setMedalResource(a.f.gcb_rank_header_medal_third);
    }

    private void setGradientColors(int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(iArr);
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
            this.eDk.setBackgroundDrawable(gradientDrawable);
        }
    }

    private String ya(String str) {
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
