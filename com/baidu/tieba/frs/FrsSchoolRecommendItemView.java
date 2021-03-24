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
import d.b.b.e.p.k;
import d.b.h0.r.f0.q.c;
import d.b.i0.p0.a1;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f16085b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16086c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16087d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f16088e;

    /* renamed from: f  reason: collision with root package name */
    public c f16089f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f16090g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f16091h;
    public int i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSchoolRecommendItemView.this.f16091h == null || k.isEmpty(FrsSchoolRecommendItemView.this.f16091h.f57323a.getUserName()) || k.isEmpty(FrsSchoolRecommendItemView.this.f16091h.f57323a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.a().getContext(), FrsSchoolRecommendItemView.this.f16091h.f57323a.getUserId(), FrsSchoolRecommendItemView.this.f16091h.f57323a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.i = 3;
        this.k = new a();
        this.f16090g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f16085b = headImageView;
        headImageView.setPageId(this.f16090g);
        this.f16085b.setIsRound(true);
        this.f16086c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f16087d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f16088e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f16089f = cVar;
        cVar.m("1");
        this.f16089f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.b.i0.a1.b.c cVar) {
        if (cVar instanceof a1) {
            a1 a1Var = (a1) cVar;
            this.f16091h = a1Var;
            if (StringUtils.isNull(a1Var.f57323a.getUserId())) {
                return;
            }
            this.f16085b.W(this.f16091h.f57323a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f16091h.f57323a.getUserName(), 5);
            this.f16087d.setText(StringHelper.cutStringWithEllipsis(this.f16091h.f57323a.getGodUserData().getIntro(), 6));
            this.f16086c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f16089f.n(this.f16091h.f57323a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        return new FrsSchoolRecommendItemView(view, this.j, this.f16090g);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i) {
        if (this.i != i) {
            SkinManager.setViewTextColor(this.f16086c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16087d, R.color.CAM_X0109);
            this.f16088e.g(i);
        }
        this.i = i;
    }
}
