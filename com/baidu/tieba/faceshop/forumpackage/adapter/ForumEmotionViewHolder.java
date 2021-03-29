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
import d.b.b.e.p.l;
import d.b.b.e.q.h;
/* loaded from: classes4.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionItemView f15836a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15837b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.l0.z.b.c f15838c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f15839d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15841f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15840e = bVar;
            this.f15841f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.l0.z.b.b bVar = this.f15840e;
            bVar.c(!bVar.b());
            d.b.i0.l0.z.a.a aVar = this.f15841f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15843f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15842e = bVar;
            this.f15843f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15842e.c(false);
            this.f15842e.d(0);
            d.b.i0.l0.z.a.a aVar = this.f15843f;
            if (aVar != null) {
                aVar.a(this.f15842e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15845f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15844e = bVar;
            this.f15845f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15844e.c(false);
            this.f15844e.d(1);
            d.b.i0.l0.z.a.a aVar = this.f15845f;
            if (aVar != null) {
                aVar.a(this.f15844e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15846a;

        public d(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15846a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ForumEmotionViewHolder.this.f15837b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(ForumEmotionViewHolder.this.f15837b.getPageActivity(), this.f15846a.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15848e;

        public e(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15848e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumEmotionViewHolder.this.l(this.f15848e);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.i0.x1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15850a;

        public f(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15850a = forumEmotionPackageData;
        }

        @Override // d.b.i0.x1.e.b
        public void onFail(String str) {
            l.K(ForumEmotionViewHolder.this.f15837b.getPageActivity(), R.string.download_error);
            ForumEmotionViewHolder.this.f15836a.getDownLoadView().setEnabled(true);
        }

        @Override // d.b.i0.x1.e.b
        public void onProgress(int i) {
            if (i > 0 && i < 100) {
                l.I(ForumEmotionViewHolder.this.f15837b.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i >= 100) {
                l.H(ForumEmotionViewHolder.this.f15837b.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.b.i0.x1.e.b
        public void onSuccess(String str) {
            l.K(ForumEmotionViewHolder.this.f15837b.getPageActivity(), R.string.down_state_success);
            ForumEmotionViewHolder.this.f15836a.getDownLoadView().setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(ForumEmotionViewHolder.this.f15836a.getDownLoadView(), R.color.CAM_X0109);
            ForumEmotionViewHolder.this.f15836a.getDownLoadView().setBackgroundDrawable(null);
            ForumEmotionViewHolder.this.f15836a.getDownLoadView().setEnabled(false);
            this.f15850a.download++;
            if (ForumEmotionViewHolder.this.f15838c != null) {
                ForumEmotionPackageData forumEmotionPackageData = ForumEmotionViewHolder.this.f15838c.f56707e;
                ForumEmotionPackageData forumEmotionPackageData2 = this.f15850a;
                if (forumEmotionPackageData == forumEmotionPackageData2) {
                    ForumEmotionViewHolder.this.j(forumEmotionPackageData2);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15836a = (ForumEmotionItemView) view;
        this.f15837b = tbPageContext;
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        TextView downLoadView = this.f15836a.getDownLoadView();
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
            this.f15836a.getListView().setVisibility(0);
            this.f15836a.getListView().setAdapter((ListAdapter) this.f15836a.getAdapter());
            this.f15836a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
            this.f15836a.getListView().setOnItemClickListener(new d(forumEmotionPackageData));
            return;
        }
        this.f15836a.getListView().setVisibility(4);
    }

    public final void i(d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar, int i) {
        String string;
        ViewGroup filterDropDownView = this.f15836a.getFilterDropDownView();
        if (i == 0 && bVar != null) {
            Resources resources = this.f15836a.getResources();
            TextView filterView = this.f15836a.getFilterView();
            this.f15836a.getHeaderView().setVisibility(0);
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
        this.f15836a.getHeaderView().setVisibility(8);
        filterDropDownView.setVisibility(8);
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.f15836a.getDownloadNumView().setVisibility(0);
            this.f15836a.getShareNumView().setVisibility(0);
            this.f15836a.getTitleView().setVisibility(0);
            if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                TextView titleView = this.f15836a.getTitleView();
                titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
            } else {
                this.f15836a.getTitleView().setText(forumEmotionPackageData.name);
            }
            this.f15836a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
            this.f15836a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
        } else {
            this.f15836a.getTitleView().setVisibility(4);
            this.f15836a.getDownloadNumView().setVisibility(4);
            this.f15836a.getShareNumView().setVisibility(4);
        }
        this.f15836a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
        if (forumEmotionPackageData == null) {
            SkinManager.setBackgroundColor(this.f15836a, R.color.CAM_X0201);
        } else {
            this.f15836a.setBackgroundColor(0);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        TextView rankView = this.f15836a.getRankView();
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
        if (ViewHelper.checkUpIsLogin(this.f15837b.getPageActivity()) && forumEmotionPackageData != null && forumEmotionPackageData.id >= 0) {
            if (this.f15839d == null) {
                this.f15839d = new NewFaceGroupDownloadModel();
            }
            this.f15836a.getDownLoadView().setEnabled(false);
            this.f15839d.s(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(forumEmotionPackageData));
        }
    }

    public void m(d.b.i0.l0.z.b.c cVar, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar, int i) {
        this.f15838c = cVar;
        if (this.f15836a == null || cVar == null) {
            return;
        }
        if (cVar.f56707e != null || i == 0) {
            i(bVar, aVar, i);
            h(cVar.f56707e);
            k(cVar.f56707e);
            j(cVar.f56707e);
            g(cVar.f56707e);
        }
    }
}
