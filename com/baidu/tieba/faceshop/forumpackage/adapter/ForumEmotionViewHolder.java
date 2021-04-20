package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import d.b.c.e.p.l;
import d.b.c.e.q.h;
/* loaded from: classes4.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionItemView f15499a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15500b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.l0.z.b.c f15501c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f15502d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15504f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15503e = bVar;
            this.f15504f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.l0.z.b.b bVar = this.f15503e;
            bVar.c(!bVar.b());
            d.b.i0.l0.z.a.a aVar = this.f15504f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15506f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15505e = bVar;
            this.f15506f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15505e.c(false);
            this.f15505e.d(0);
            d.b.i0.l0.z.a.a aVar = this.f15506f;
            if (aVar != null) {
                aVar.a(this.f15505e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15507e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15508f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15507e = bVar;
            this.f15508f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15507e.c(false);
            this.f15507e.d(1);
            d.b.i0.l0.z.a.a aVar = this.f15508f;
            if (aVar != null) {
                aVar.a(this.f15507e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15509a;

        public d(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15509a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ForumEmotionViewHolder.this.f15500b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(ForumEmotionViewHolder.this.f15500b.getPageActivity(), this.f15509a.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15511e;

        public e(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15511e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumEmotionViewHolder.this.l(this.f15511e);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.i0.y1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15513a;

        public f(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15513a = forumEmotionPackageData;
        }

        @Override // d.b.i0.y1.e.b
        public void onFail(String str) {
            l.K(ForumEmotionViewHolder.this.f15500b.getPageActivity(), R.string.download_error);
            ForumEmotionViewHolder.this.f15499a.getDownLoadView().setEnabled(true);
        }

        @Override // d.b.i0.y1.e.b
        public void onProgress(int i) {
            if (i > 0 && i < 100) {
                l.I(ForumEmotionViewHolder.this.f15500b.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i >= 100) {
                l.H(ForumEmotionViewHolder.this.f15500b.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.b.i0.y1.e.b
        public void onSuccess(String str) {
            l.K(ForumEmotionViewHolder.this.f15500b.getPageActivity(), R.string.down_state_success);
            ForumEmotionViewHolder.this.f15499a.getDownLoadView().setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(ForumEmotionViewHolder.this.f15499a.getDownLoadView(), R.color.CAM_X0109);
            ForumEmotionViewHolder.this.f15499a.getDownLoadView().setBackgroundDrawable(null);
            ForumEmotionViewHolder.this.f15499a.getDownLoadView().setEnabled(false);
            this.f15513a.download++;
            if (ForumEmotionViewHolder.this.f15501c != null) {
                ForumEmotionPackageData forumEmotionPackageData = ForumEmotionViewHolder.this.f15501c.f58113e;
                ForumEmotionPackageData forumEmotionPackageData2 = this.f15513a;
                if (forumEmotionPackageData == forumEmotionPackageData2) {
                    ForumEmotionViewHolder.this.j(forumEmotionPackageData2);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15499a = (ForumEmotionItemView) view;
        this.f15500b = tbPageContext;
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        TextView downLoadView = this.f15499a.getDownLoadView();
        if (forumEmotionPackageData == null) {
            downLoadView.setVisibility(4);
            return;
        }
        downLoadView.setVisibility(0);
        downLoadView.setOnClickListener(new e(forumEmotionPackageData));
        d.b.i0.l0.a c2 = d.b.i0.l0.a.c();
        if (c2.e("" + forumEmotionPackageData.id)) {
            downLoadView.setText(R.string.already_downloaded);
            downLoadView.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
            downLoadView.setBackgroundDrawable(null);
            downLoadView.setEnabled(false);
            return;
        }
        int i = forumEmotionPackageData.status;
        if (i != 0) {
            if (i == 1) {
                downLoadView.setText(R.string.download);
                SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                downLoadView.setEnabled(true);
                return;
            } else if (i == 2) {
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
                downLoadView.setEnabled(false);
                return;
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
                downLoadView.setText(R.string.face_package_has_delete);
                downLoadView.setEnabled(false);
                return;
            }
        }
        downLoadView.setText(R.string.download);
        SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
        downLoadView.setEnabled(true);
    }

    public final void h(ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.f15499a.getListView().setVisibility(0);
            this.f15499a.getListView().setAdapter((ListAdapter) this.f15499a.getAdapter());
            this.f15499a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
            this.f15499a.getListView().setOnItemClickListener(new d(forumEmotionPackageData));
            return;
        }
        this.f15499a.getListView().setVisibility(4);
    }

    public final void i(d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar, int i) {
        String string;
        ViewGroup filterDropDownView = this.f15499a.getFilterDropDownView();
        if (i == 0 && bVar != null) {
            Resources resources = this.f15499a.getResources();
            TextView filterView = this.f15499a.getFilterView();
            this.f15499a.getHeaderView().setVisibility(0);
            filterDropDownView.setVisibility(0);
            if (bVar.a() == 0) {
                string = resources.getString(R.string.forum_emotion_filter_all_bar);
            } else {
                string = resources.getString(R.string.forum_emotion_filter_my_bar);
            }
            filterView.setText(string);
            if (bVar.b()) {
                filterDropDownView.setVisibility(0);
            } else {
                filterDropDownView.setVisibility(8);
            }
            filterView.setOnClickListener(new a(this, bVar, aVar));
            if (filterDropDownView.getChildCount() >= 2) {
                filterDropDownView.getChildAt(0).setOnClickListener(new b(this, bVar, aVar));
                filterDropDownView.getChildAt(1).setOnClickListener(new c(this, bVar, aVar));
                return;
            }
            return;
        }
        this.f15499a.getHeaderView().setVisibility(8);
        filterDropDownView.setVisibility(8);
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.f15499a.getDownloadNumView().setVisibility(0);
            this.f15499a.getShareNumView().setVisibility(0);
            this.f15499a.getTitleView().setVisibility(0);
            if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                TextView titleView = this.f15499a.getTitleView();
                titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
            } else {
                this.f15499a.getTitleView().setText(forumEmotionPackageData.name);
            }
            this.f15499a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
            this.f15499a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
        } else {
            this.f15499a.getTitleView().setVisibility(4);
            this.f15499a.getDownloadNumView().setVisibility(4);
            this.f15499a.getShareNumView().setVisibility(4);
        }
        this.f15499a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
        if (forumEmotionPackageData == null) {
            SkinManager.setBackgroundColor(this.f15499a, R.color.CAM_X0201);
        } else {
            this.f15499a.setBackgroundColor(0);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        TextView rankView = this.f15499a.getRankView();
        if (forumEmotionPackageData != null) {
            rankView.setVisibility(0);
            long j = forumEmotionPackageData.rank_num;
            if (j > 20) {
                rankView.setVisibility(8);
                return;
            } else if (j > 3) {
                rankView.setVisibility(0);
                rankView.setText(String.valueOf(forumEmotionPackageData.rank_num));
                SkinManager.setBackgroundResource(rankView, R.drawable.bg_emotion_rank);
                return;
            } else {
                rankView.setVisibility(0);
                rankView.setText("");
                long j2 = forumEmotionPackageData.rank_num;
                if (j2 == 3) {
                    SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num3);
                    return;
                } else if (j2 == 2) {
                    SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num2);
                    return;
                } else {
                    SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num1);
                    return;
                }
            }
        }
        rankView.setVisibility(4);
    }

    public final void l(ForumEmotionPackageData forumEmotionPackageData) {
        if (ViewHelper.checkUpIsLogin(this.f15500b.getPageActivity()) && forumEmotionPackageData != null && forumEmotionPackageData.id >= 0) {
            if (this.f15502d == null) {
                this.f15502d = new NewFaceGroupDownloadModel();
            }
            this.f15499a.getDownLoadView().setEnabled(false);
            this.f15502d.s(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(forumEmotionPackageData));
        }
    }

    public void m(d.b.i0.l0.z.b.c cVar, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar, int i) {
        this.f15501c = cVar;
        if (this.f15499a == null || cVar == null) {
            return;
        }
        if (cVar.f58113e != null || i == 0) {
            i(bVar, aVar, i);
            h(cVar.f58113e);
            k(cVar.f58113e);
            j(cVar.f58113e);
            g(cVar.f58113e);
        }
    }
}
