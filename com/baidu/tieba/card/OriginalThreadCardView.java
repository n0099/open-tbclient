package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaShareInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.b1.m.e;
/* loaded from: classes4.dex */
public class OriginalThreadCardView extends RelativeLayout {
    public static final int t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    public static final int u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    public static final int v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    public static final int w = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    public static final int x = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);

    /* renamed from: e  reason: collision with root package name */
    public Context f15038e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15039f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15040g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15041h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f15042i;
    public LinearLayout j;
    public TextView k;
    public RankStarView l;
    public TextView m;
    public VoteView n;
    public int o;
    public b p;
    public int q;
    public boolean r;
    public int s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || !(view.getTag() instanceof OriginalThreadInfo)) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view.getTag();
            if (originalThreadInfo.f12796a == 4) {
                OriginalThreadCardView.this.m(originalThreadInfo);
            } else {
                OriginalThreadCardView.this.l(originalThreadInfo);
            }
            if (OriginalThreadCardView.this.p != null) {
                OriginalThreadCardView.this.p.a(originalThreadInfo);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    public OriginalThreadCardView(Context context) {
        super(context);
        this.r = true;
        this.s = 3;
        i(context);
    }

    public final void d(ItemData itemData) {
        if (itemData == null) {
            this.j.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        this.j.setVisibility(0);
        int i2 = u;
        setPadding(i2, i2, i2, v);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        if (this.f15040g.getVisibility() == 0) {
            layoutParams.addRule(3, R.id.imageview_thread_pic);
        } else {
            layoutParams.addRule(3, R.id.textview_thread_abstract);
        }
        this.j.setLayoutParams(layoutParams);
        this.l.setStarSpacing(t);
        int i3 = x;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f15040g.getLayoutParams();
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        this.f15040g.setLayoutParams(layoutParams2);
        this.f15042i.setLayoutParams(layoutParams2);
        int i4 = w;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f15041h.getLayoutParams();
        layoutParams3.leftMargin = (i3 - i4) / 2;
        this.f15041h.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f15039f.getLayoutParams();
        layoutParams4.height = i3;
        this.f15039f.setLayoutParams(layoutParams4);
    }

    public void e(OriginalThreadInfo.ShareInfo shareInfo) {
        if (shareInfo == null) {
            return;
        }
        int i2 = shareInfo.showType;
        if (i2 == 1) {
            this.o = 0;
            this.f15040g.setDefaultResource(R.color.CAM_X0204);
            if (this.r) {
                this.f15040g.setPlaceHolder(2);
            } else {
                this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f15040g.setVisibility(0);
            this.f15040g.V(shareInfo.showPicUrl, 10, false);
        } else if (i2 == 2) {
            this.o = 0;
            this.f15040g.setDefaultResource(R.drawable.icon_card_url_n);
            this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            this.f15040g.setVisibility(0);
            this.f15040g.V(shareInfo.showPicUrl, 10, false);
        } else if (i2 == 3) {
            this.o = R.drawable.icon_share_play_n;
            this.f15040g.setDefaultResource(R.color.CAM_X0204);
            this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            this.f15040g.setVisibility(0);
            this.f15040g.V(shareInfo.showPicUrl, 10, false);
        } else if (i2 != 4) {
            this.o = 0;
            this.f15040g.setVisibility(8);
        } else {
            this.o = R.drawable.icon_share_card_live;
            this.f15040g.setDefaultResource(R.color.CAM_X0204);
            this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            this.f15040g.setVisibility(0);
            this.f15040g.V(shareInfo.showPicUrl, 10, false);
        }
        if (this.o != 0) {
            this.f15041h.setVisibility(0);
            this.f15042i.setVisibility(0);
            SkinManager.setImageResource(this.f15041h, this.o);
        } else {
            this.f15041h.setVisibility(8);
            this.f15042i.setVisibility(8);
        }
        this.f15039f.setText(shareInfo.showText);
        g(shareInfo);
        this.n.setVisibility(8);
        setTag(shareInfo);
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo == null) {
            return;
        }
        int i2 = originalThreadInfo.f12796a;
        if (i2 == 1) {
            this.o = 0;
            this.f15040g.setDefaultResource(R.color.CAM_X0204);
            if (this.r) {
                this.f15040g.setPlaceHolder(2);
            } else {
                this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f15040g.setVisibility(0);
            this.f15040g.V(originalThreadInfo.f12798c, 10, false);
        } else if (i2 == 2) {
            this.o = 0;
            this.f15040g.setDefaultResource(R.drawable.icon_card_url_n);
            this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            this.f15040g.setVisibility(0);
            this.f15040g.V(originalThreadInfo.f12798c, 10, false);
        } else if (i2 == 3) {
            this.o = R.drawable.icon_share_play_n;
            this.f15040g.setDefaultResource(R.color.CAM_X0204);
            this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            this.f15040g.setVisibility(0);
            this.f15040g.V(originalThreadInfo.f12798c, 10, false);
        } else if (i2 != 4) {
            this.o = 0;
            this.f15040g.setVisibility(8);
        } else {
            this.o = R.drawable.icon_share_card_live;
            this.f15040g.setDefaultResource(R.color.CAM_X0204);
            this.f15040g.setDefaultBgResource(R.color.CAM_X0209);
            this.f15040g.setVisibility(0);
            this.f15040g.V(originalThreadInfo.f12798c, 10, false);
        }
        if (this.o != 0) {
            this.f15041h.setVisibility(0);
            this.f15042i.setVisibility(0);
            SkinManager.setImageResource(this.f15041h, this.o);
        } else {
            this.f15041h.setVisibility(8);
            this.f15042i.setVisibility(8);
        }
        TextView textView = this.f15039f;
        SpannableString spannableString = originalThreadInfo.t;
        textView.setText((spannableString == null || spannableString.length() == 0) ? originalThreadInfo.f12797b : originalThreadInfo.t);
        h(originalThreadInfo.D, originalThreadInfo.f12801f, originalThreadInfo.f12800e);
        setTag(originalThreadInfo);
    }

    public final void g(OriginalThreadInfo.ShareInfo shareInfo) {
        ItemData itemData = shareInfo.itemData;
        d(itemData);
        if (itemData != null) {
            this.k.setText(itemData.mTitle);
            this.l.setStarCount(itemData.mStar);
            double d2 = itemData.mScore;
            if (d2 > 0.0d && d2 <= 10.0d) {
                TextView textView = this.m;
                textView.setText(itemData.mScore + "");
            } else {
                this.m.setText(R.string.frs_evaluate_exception);
            }
            if (this.f15040g.getVisibility() == 8) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15039f.getLayoutParams();
                layoutParams.height = -2;
                this.f15039f.setLayoutParams(layoutParams);
            }
        }
        ItemStarData itemStarData = shareInfo.itemStarData;
        if (itemStarData != null) {
            this.f15039f.setText(j(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
        }
    }

    public final void h(PollData pollData, String str, long j) {
        this.n.setVisibility(8);
        if (pollData == null || ListUtils.isEmpty(pollData.getOptions())) {
            return;
        }
        this.n.setVisibility(0);
        this.n.setIsTransmit(true);
        this.n.setData(pollData, str, j);
    }

    public final void i(Context context) {
        if (context == null) {
            return;
        }
        this.f15038e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
        this.f15039f = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
        this.f15040g = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
        this.f15041h = (ImageView) inflate.findViewById(R.id.icon_video_type);
        this.f15042i = (ImageView) findViewById(R.id.thread_pic_mask);
        this.f15040g.setLongIconSupport(false);
        this.f15040g.setGifIconSupport(false);
        this.f15040g.setRadius(l.g(context, R.dimen.tbds10));
        this.f15040g.setConrers(5);
        int k = (((l.k(context) - (l.g(context, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15040g.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = k;
        this.f15040g.setLayoutParams(layoutParams);
        this.f15042i.setLayoutParams(layoutParams);
        int g2 = l.g(context, R.dimen.tbds78);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f15041h.getLayoutParams();
        layoutParams2.leftMargin = (k - g2) / 2;
        this.f15041h.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f15039f.getLayoutParams();
        layoutParams3.height = k;
        this.f15039f.setLayoutParams(layoutParams3);
        this.j = (LinearLayout) findViewById(R.id.add_item);
        TextView textView = (TextView) findViewById(R.id.item_title);
        this.k = textView;
        textView.setMaxWidth(l.p(context)[0] / 2);
        this.l = (RankStarView) findViewById(R.id.item_star);
        this.m = (TextView) findViewById(R.id.item_score);
        VoteView voteView = (VoteView) findViewById(R.id.vote_view);
        this.n = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
        setOnClickListener(new a());
    }

    public final SpannableStringBuilder j(String str, ItemStarData itemStarData) {
        SpannableStringBuilder e2 = e.e(itemStarData);
        e2.append((CharSequence) str);
        return e2;
    }

    public final void k(OriginalThreadInfo originalThreadInfo) {
        AlaInfoData alaInfoData;
        if (originalThreadInfo == null || (alaInfoData = originalThreadInfo.j) == null || alaInfoData.live_status != 1) {
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.j);
        AlaUserInfoData alaUserInfoData = originalThreadInfo.j.user_info;
        if (alaUserInfoData != null) {
            alaLiveInfoCoreData.userName = alaUserInfoData.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f15038e, alaLiveInfoCoreData, null, "", false, "")));
    }

    public final void l(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(originalThreadInfo.p)) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f15038e);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f12801f, null, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f12800e));
            pbActivityConfig.setStartFrom(this.q);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            return;
        }
        PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f15038e);
        pbActivityConfig2.createNormalCfg(originalThreadInfo.f12801f, originalThreadInfo.n, null);
        pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.f12800e));
        pbActivityConfig2.setStartFrom(this.q);
        pbActivityConfig2.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
    }

    public final void m(OriginalThreadInfo originalThreadInfo) {
        if (originalThreadInfo == null || originalThreadInfo.f12796a != 4) {
            return;
        }
        int i2 = originalThreadInfo.k;
        if (i2 == 49 || i2 == 69) {
            k(originalThreadInfo);
        } else if (i2 == 60) {
            AlaInfoData alaInfoData = originalThreadInfo.j;
            if (alaInfoData != null) {
                if (alaInfoData.live_status == 1) {
                    k(originalThreadInfo);
                    return;
                }
                AlaShareInfoData alaShareInfoData = alaInfoData.share_info;
                if (alaShareInfoData != null && alaShareInfoData.record_tid <= 0) {
                    k(originalThreadInfo);
                    return;
                } else {
                    l(originalThreadInfo);
                    return;
                }
            }
            l(originalThreadInfo);
        } else {
            l(originalThreadInfo);
        }
    }

    public void n() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.s != skinType) {
            this.s = skinType;
            SkinManager.setViewTextColor(this.f15039f, R.color.CAM_X0107);
            int i2 = this.o;
            if (i2 != 0) {
                SkinManager.setImageResource(this.f15041h, i2);
            }
            setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f15038e, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0206)));
            this.j.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f15038e, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0205)));
            this.n.C(skinType);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f15039f, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
            this.l.f();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setReadState(boolean z) {
        SkinManager.setViewTextColor(this.f15039f, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
    }

    public void setSubClickListener(b bVar) {
        this.p = bVar;
    }

    public void setUsePlaceHolder(boolean z) {
        this.r = z;
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = true;
        this.s = 3;
        i(context);
    }

    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = true;
        this.s = 3;
        i(context);
    }
}
