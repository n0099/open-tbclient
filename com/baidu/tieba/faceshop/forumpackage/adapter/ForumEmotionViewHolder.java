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
import d.a.c.e.p.l;
import d.a.c.e.q.h;
/* loaded from: classes4.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionItemView f14882a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f14883b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.m0.z.b.c f14884c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f14885d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14886e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14887f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14886e = bVar;
            this.f14887f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.m0.z.b.b bVar = this.f14886e;
            bVar.c(!bVar.b());
            d.a.n0.m0.z.a.a aVar = this.f14887f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14888e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14889f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14888e = bVar;
            this.f14889f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14888e.c(false);
            this.f14888e.d(0);
            d.a.n0.m0.z.a.a aVar = this.f14889f;
            if (aVar != null) {
                aVar.a(this.f14888e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14891f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14890e = bVar;
            this.f14891f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14890e.c(false);
            this.f14890e.d(1);
            d.a.n0.m0.z.a.a aVar = this.f14891f;
            if (aVar != null) {
                aVar.a(this.f14890e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f14892a;

        public d(ForumEmotionPackageData forumEmotionPackageData) {
            this.f14892a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            ForumEmotionViewHolder.this.f14883b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(ForumEmotionViewHolder.this.f14883b.getPageActivity(), this.f14892a.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f14894e;

        public e(ForumEmotionPackageData forumEmotionPackageData) {
            this.f14894e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumEmotionViewHolder.this.l(this.f14894e);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.n0.z1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f14896a;

        public f(ForumEmotionPackageData forumEmotionPackageData) {
            this.f14896a = forumEmotionPackageData;
        }

        @Override // d.a.n0.z1.e.b
        public void a(String str) {
            l.L(ForumEmotionViewHolder.this.f14883b.getPageActivity(), R.string.download_error);
            ForumEmotionViewHolder.this.f14882a.getDownLoadView().setEnabled(true);
        }

        @Override // d.a.n0.z1.e.b
        public void onProgress(int i2) {
            if (i2 > 0 && i2 < 100) {
                l.J(ForumEmotionViewHolder.this.f14883b.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i2 >= 100) {
                l.I(ForumEmotionViewHolder.this.f14883b.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.a.n0.z1.e.b
        public void onSuccess(String str) {
            l.L(ForumEmotionViewHolder.this.f14883b.getPageActivity(), R.string.down_state_success);
            ForumEmotionViewHolder.this.f14882a.getDownLoadView().setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(ForumEmotionViewHolder.this.f14882a.getDownLoadView(), R.color.CAM_X0109);
            ForumEmotionViewHolder.this.f14882a.getDownLoadView().setBackgroundDrawable(null);
            ForumEmotionViewHolder.this.f14882a.getDownLoadView().setEnabled(false);
            this.f14896a.download++;
            if (ForumEmotionViewHolder.this.f14884c != null) {
                ForumEmotionPackageData forumEmotionPackageData = ForumEmotionViewHolder.this.f14884c.f57439e;
                ForumEmotionPackageData forumEmotionPackageData2 = this.f14896a;
                if (forumEmotionPackageData == forumEmotionPackageData2) {
                    ForumEmotionViewHolder.this.j(forumEmotionPackageData2);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f14882a = (ForumEmotionItemView) view;
        this.f14883b = tbPageContext;
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        TextView downLoadView = this.f14882a.getDownLoadView();
        if (forumEmotionPackageData == null) {
            downLoadView.setVisibility(4);
            return;
        }
        downLoadView.setVisibility(0);
        downLoadView.setOnClickListener(new e(forumEmotionPackageData));
        d.a.n0.m0.a c2 = d.a.n0.m0.a.c();
        if (c2.e("" + forumEmotionPackageData.id)) {
            downLoadView.setText(R.string.already_downloaded);
            downLoadView.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
            downLoadView.setBackgroundDrawable(null);
            downLoadView.setEnabled(false);
            return;
        }
        int i2 = forumEmotionPackageData.status;
        if (i2 != 0) {
            if (i2 == 1) {
                downLoadView.setText(R.string.download);
                SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                downLoadView.setEnabled(true);
                return;
            } else if (i2 == 2) {
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
                downLoadView.setEnabled(false);
                return;
            } else if (i2 != 3) {
                if (i2 != 4) {
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
            this.f14882a.getListView().setVisibility(0);
            this.f14882a.getListView().setAdapter((ListAdapter) this.f14882a.getAdapter());
            this.f14882a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
            this.f14882a.getListView().setOnItemClickListener(new d(forumEmotionPackageData));
            return;
        }
        this.f14882a.getListView().setVisibility(4);
    }

    public final void i(d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar, int i2) {
        String string;
        ViewGroup filterDropDownView = this.f14882a.getFilterDropDownView();
        if (i2 == 0 && bVar != null) {
            Resources resources = this.f14882a.getResources();
            TextView filterView = this.f14882a.getFilterView();
            this.f14882a.getHeaderView().setVisibility(0);
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
        this.f14882a.getHeaderView().setVisibility(8);
        filterDropDownView.setVisibility(8);
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.f14882a.getDownloadNumView().setVisibility(0);
            this.f14882a.getShareNumView().setVisibility(0);
            this.f14882a.getTitleView().setVisibility(0);
            if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                TextView titleView = this.f14882a.getTitleView();
                titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
            } else {
                this.f14882a.getTitleView().setText(forumEmotionPackageData.name);
            }
            this.f14882a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
            this.f14882a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
        } else {
            this.f14882a.getTitleView().setVisibility(4);
            this.f14882a.getDownloadNumView().setVisibility(4);
            this.f14882a.getShareNumView().setVisibility(4);
        }
        this.f14882a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
        if (forumEmotionPackageData == null) {
            SkinManager.setBackgroundColor(this.f14882a, R.color.CAM_X0201);
        } else {
            this.f14882a.setBackgroundColor(0);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        TextView rankView = this.f14882a.getRankView();
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
        if (ViewHelper.checkUpIsLogin(this.f14883b.getPageActivity()) && forumEmotionPackageData != null && forumEmotionPackageData.id >= 0) {
            if (this.f14885d == null) {
                this.f14885d = new NewFaceGroupDownloadModel();
            }
            this.f14882a.getDownLoadView().setEnabled(false);
            this.f14885d.s(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(forumEmotionPackageData));
        }
    }

    public void m(d.a.n0.m0.z.b.c cVar, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar, int i2) {
        this.f14884c = cVar;
        if (this.f14882a == null || cVar == null) {
            return;
        }
        if (cVar.f57439e != null || i2 == 0) {
            i(bVar, aVar, i2);
            h(cVar.f57439e);
            k(cVar.f57439e);
            j(cVar.f57439e);
            g(cVar.f57439e);
        }
    }
}
