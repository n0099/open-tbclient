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
import d.a.i0.r.f0.q.c;
import d.a.j0.q0.a1;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15926b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15927c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15928d;

    /* renamed from: e  reason: collision with root package name */
    public EntelechyUserLikeButton f15929e;

    /* renamed from: f  reason: collision with root package name */
    public c f15930f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15931g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f15932h;

    /* renamed from: i  reason: collision with root package name */
    public int f15933i;
    public TbPageContext j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSchoolRecommendItemView.this.f15932h == null || k.isEmpty(FrsSchoolRecommendItemView.this.f15932h.f57483a.getUserName()) || k.isEmpty(FrsSchoolRecommendItemView.this.f15932h.f57483a.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.a().getContext(), FrsSchoolRecommendItemView.this.f15932h.f57483a.getUserId(), FrsSchoolRecommendItemView.this.f15932h.f57483a.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.f15933i = 3;
        this.k = new a();
        this.f15931g = bdUniqueId;
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.f15926b = headImageView;
        headImageView.setPageId(this.f15931g);
        this.f15926b.setIsRound(true);
        this.f15927c = (TextView) view.findViewById(R.id.rec_user_name);
        this.f15928d = (TextView) view.findViewById(R.id.rec_user_describe);
        EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.f15929e = entelechyUserLikeButton;
        c cVar = new c(tbPageContext, entelechyUserLikeButton);
        this.f15930f = cVar;
        cVar.m("1");
        this.f15930f.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void b(d.a.j0.b1.b.c cVar) {
        if (cVar instanceof a1) {
            a1 a1Var = (a1) cVar;
            this.f15932h = a1Var;
            if (StringUtils.isNull(a1Var.f57483a.getUserId())) {
                return;
            }
            this.f15926b.V(this.f15932h.f57483a.getPortrait(), 28, false);
            String cutStringWithEllipsis = StringHelper.cutStringWithEllipsis(this.f15932h.f57483a.getUserName(), 5);
            this.f15928d.setText(StringHelper.cutStringWithEllipsis(this.f15932h.f57483a.getGodUserData().getIntro(), 6));
            this.f15927c.setText(cutStringWithEllipsis);
            a().setOnClickListener(this.k);
            this.f15930f.n(this.f15932h.f57483a);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder c(View view) {
        return new FrsSchoolRecommendItemView(view, this.j, this.f15931g);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void d(int i2) {
        if (this.f15933i != i2) {
            SkinManager.setViewTextColor(this.f15927c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15928d, R.color.CAM_X0109);
            this.f15929e.g(i2);
        }
        this.f15933i = i2;
    }
}
