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
import d.a.c.e.p.k;
import d.a.m0.r.f0.q.c;
import d.a.n0.r0.a1;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15201b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15202c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15203d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f15204e;

    /* renamed from: f  reason: collision with root package name */
    public c f15205f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15206g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f15207h;

    /* renamed from: i  reason: collision with root package name */
    public int f15208i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSchoolRecommendItemView.this.f15207h == null || k.isEmpty(FrsSchoolRecommendItemView.this.f15207h.f62057a.getUserName()) || k.isEmpty(FrsSchoolRecommendItemView.this.f15207h.f62057a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.a().getContext(), FrsSchoolRecommendItemView.this.f15207h.f62057a.getUserId(), FrsSchoolRecommendItemView.this.f15207h.f62057a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.f15208i = 3;
        this.k = new a();
        this.f15206g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f15201b = headImageView;
        headImageView.setPageId(this.f15206g);
        this.f15201b.setIsRound(true);
        this.f15202c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f15203d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f15204e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f15205f = cVar;
        cVar.m("1");
        this.f15205f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.a.n0.c1.b.c cVar) {
        if (cVar instanceof a1) {
            a1 a1Var = (a1) cVar;
            this.f15207h = a1Var;
            if (StringUtils.isNull(a1Var.f62057a.getUserId())) {
                return;
            }
            this.f15201b.U(this.f15207h.f62057a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f15207h.f62057a.getUserName(), 5);
            this.f15203d.setText(StringHelper.cutStringWithEllipsis(this.f15207h.f62057a.getGodUserData().getIntro(), 6));
            this.f15202c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f15205f.n(this.f15207h.f62057a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        return new FrsSchoolRecommendItemView(view, this.j, this.f15206g);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f15208i != i2) {
            SkinManager.setViewTextColor(this.f15202c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15203d, R.color.CAM_X0109);
            this.f15204e.g(i2);
        }
        this.f15208i = i2;
    }
}
