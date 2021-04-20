package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import d.b.c.e.p.k;
import d.b.h0.r.f0.q.c;
import d.b.i0.q0.a1;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15747b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15748c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15749d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f15750e;

    /* renamed from: f  reason: collision with root package name */
    public c f15751f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15752g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f15753h;
    public int i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSchoolRecommendItemView.this.f15753h == null || k.isEmpty(FrsSchoolRecommendItemView.this.f15753h.f59023a.getUserName()) || k.isEmpty(FrsSchoolRecommendItemView.this.f15753h.f59023a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.a().getContext(), FrsSchoolRecommendItemView.this.f15753h.f59023a.getUserId(), FrsSchoolRecommendItemView.this.f15753h.f59023a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.i = 3;
        this.k = new a();
        this.f15752g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f15747b = headImageView;
        headImageView.setPageId(this.f15752g);
        this.f15747b.setIsRound(true);
        this.f15748c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f15749d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f15750e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f15751f = cVar;
        cVar.m("1");
        this.f15751f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.b.i0.b1.b.c cVar) {
        if (cVar instanceof a1) {
            a1 a1Var = (a1) cVar;
            this.f15753h = a1Var;
            if (StringUtils.isNull(a1Var.f59023a.getUserId())) {
                return;
            }
            this.f15747b.W(this.f15753h.f59023a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f15753h.f59023a.getUserName(), 5);
            this.f15749d.setText(StringHelper.cutStringWithEllipsis(this.f15753h.f59023a.getGodUserData().getIntro(), 6));
            this.f15748c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f15751f.n(this.f15753h.f59023a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        return new FrsSchoolRecommendItemView(view, this.j, this.f15752g);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.i != i) {
            SkinManager.setViewTextColor(this.f15748c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15749d, R.color.CAM_X0109);
            this.f15750e.g(i);
        }
        this.i = i;
    }
}
