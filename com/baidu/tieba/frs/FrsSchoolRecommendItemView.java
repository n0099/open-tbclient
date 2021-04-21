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
import d.b.i0.r.f0.q.c;
import d.b.j0.q0.a1;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15755b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15756c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15757d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f15758e;

    /* renamed from: f  reason: collision with root package name */
    public c f15759f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15760g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f15761h;
    public int i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSchoolRecommendItemView.this.f15761h == null || k.isEmpty(FrsSchoolRecommendItemView.this.f15761h.f59444a.getUserName()) || k.isEmpty(FrsSchoolRecommendItemView.this.f15761h.f59444a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.a().getContext(), FrsSchoolRecommendItemView.this.f15761h.f59444a.getUserId(), FrsSchoolRecommendItemView.this.f15761h.f59444a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.i = 3;
        this.k = new a();
        this.f15760g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f15755b = headImageView;
        headImageView.setPageId(this.f15760g);
        this.f15755b.setIsRound(true);
        this.f15756c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f15757d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f15758e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f15759f = cVar;
        cVar.m("1");
        this.f15759f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.b.j0.b1.b.c cVar) {
        if (cVar instanceof a1) {
            a1 a1Var = (a1) cVar;
            this.f15761h = a1Var;
            if (StringUtils.isNull(a1Var.f59444a.getUserId())) {
                return;
            }
            this.f15755b.W(this.f15761h.f59444a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f15761h.f59444a.getUserName(), 5);
            this.f15757d.setText(StringHelper.cutStringWithEllipsis(this.f15761h.f59444a.getGodUserData().getIntro(), 6));
            this.f15756c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f15759f.n(this.f15761h.f59444a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        return new FrsSchoolRecommendItemView(view, this.j, this.f15760g);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.i != i) {
            SkinManager.setViewTextColor(this.f15756c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15757d, R.color.CAM_X0109);
            this.f15758e.g(i);
        }
        this.i = i;
    }
}
