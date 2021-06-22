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
    public ForumEmotionItemView f15021a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15022b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.m0.z.b.c f15023c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f15024d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.b.b f15025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.a.a f15026f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
            this.f15025e = bVar;
            this.f15026f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.m0.z.b.b bVar = this.f15025e;
            bVar.c(!bVar.b());
            d.a.o0.m0.z.a.a aVar = this.f15026f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.b.b f15027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.a.a f15028f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
            this.f15027e = bVar;
            this.f15028f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15027e.c(false);
            this.f15027e.d(0);
            d.a.o0.m0.z.a.a aVar = this.f15028f;
            if (aVar != null) {
                aVar.a(this.f15027e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.b.b f15029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.a.a f15030f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
            this.f15029e = bVar;
            this.f15030f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15029e.c(false);
            this.f15029e.d(1);
            d.a.o0.m0.z.a.a aVar = this.f15030f;
            if (aVar != null) {
                aVar.a(this.f15029e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15031a;

        public d(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15031a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            ForumEmotionViewHolder.this.f15022b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(ForumEmotionViewHolder.this.f15022b.getPageActivity(), this.f15031a.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15033e;

        public e(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15033e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumEmotionViewHolder.this.l(this.f15033e);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.o0.z1.e.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15035a;

        public f(ForumEmotionPackageData forumEmotionPackageData) {
            this.f15035a = forumEmotionPackageData;
        }

        @Override // d.a.o0.z1.e.b
        public void onFail(String str) {
            l.L(ForumEmotionViewHolder.this.f15022b.getPageActivity(), R.string.download_error);
            ForumEmotionViewHolder.this.f15021a.getDownLoadView().setEnabled(true);
        }

        @Override // d.a.o0.z1.e.b
        public void onProgress(int i2) {
            if (i2 > 0 && i2 < 100) {
                l.J(ForumEmotionViewHolder.this.f15022b.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i2 >= 100) {
                l.I(ForumEmotionViewHolder.this.f15022b.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.a.o0.z1.e.b
        public void onSuccess(String str) {
            l.L(ForumEmotionViewHolder.this.f15022b.getPageActivity(), R.string.down_state_success);
            ForumEmotionViewHolder.this.f15021a.getDownLoadView().setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(ForumEmotionViewHolder.this.f15021a.getDownLoadView(), R.color.CAM_X0109);
            ForumEmotionViewHolder.this.f15021a.getDownLoadView().setBackgroundDrawable(null);
            ForumEmotionViewHolder.this.f15021a.getDownLoadView().setEnabled(false);
            this.f15035a.download++;
            if (ForumEmotionViewHolder.this.f15023c != null) {
                ForumEmotionPackageData forumEmotionPackageData = ForumEmotionViewHolder.this.f15023c.f61253e;
                ForumEmotionPackageData forumEmotionPackageData2 = this.f15035a;
                if (forumEmotionPackageData == forumEmotionPackageData2) {
                    ForumEmotionViewHolder.this.j(forumEmotionPackageData2);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15021a = (ForumEmotionItemView) view;
        this.f15022b = tbPageContext;
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        TextView downLoadView = this.f15021a.getDownLoadView();
        if (forumEmotionPackageData == null) {
            downLoadView.setVisibility(4);
            return;
        }
        downLoadView.setVisibility(0);
        downLoadView.setOnClickListener(new e(forumEmotionPackageData));
        d.a.o0.m0.a c2 = d.a.o0.m0.a.c();
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
            this.f15021a.getListView().setVisibility(0);
            this.f15021a.getListView().setAdapter((ListAdapter) this.f15021a.getAdapter());
            this.f15021a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
            this.f15021a.getListView().setOnItemClickListener(new d(forumEmotionPackageData));
            return;
        }
        this.f15021a.getListView().setVisibility(4);
    }

    public final void i(d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar, int i2) {
        String string;
        ViewGroup filterDropDownView = this.f15021a.getFilterDropDownView();
        if (i2 == 0 && bVar != null) {
            Resources resources = this.f15021a.getResources();
            TextView filterView = this.f15021a.getFilterView();
            this.f15021a.getHeaderView().setVisibility(0);
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
        this.f15021a.getHeaderView().setVisibility(8);
        filterDropDownView.setVisibility(8);
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.f15021a.getDownloadNumView().setVisibility(0);
            this.f15021a.getShareNumView().setVisibility(0);
            this.f15021a.getTitleView().setVisibility(0);
            if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                TextView titleView = this.f15021a.getTitleView();
                titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
            } else {
                this.f15021a.getTitleView().setText(forumEmotionPackageData.name);
            }
            this.f15021a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
            this.f15021a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
        } else {
            this.f15021a.getTitleView().setVisibility(4);
            this.f15021a.getDownloadNumView().setVisibility(4);
            this.f15021a.getShareNumView().setVisibility(4);
        }
        this.f15021a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
        if (forumEmotionPackageData == null) {
            SkinManager.setBackgroundColor(this.f15021a, R.color.CAM_X0201);
        } else {
            this.f15021a.setBackgroundColor(0);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        TextView rankView = this.f15021a.getRankView();
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
        if (ViewHelper.checkUpIsLogin(this.f15022b.getPageActivity()) && forumEmotionPackageData != null && forumEmotionPackageData.id >= 0) {
            if (this.f15024d == null) {
                this.f15024d = new NewFaceGroupDownloadModel();
            }
            this.f15021a.getDownLoadView().setEnabled(false);
            this.f15024d.w(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(forumEmotionPackageData));
        }
    }

    public void m(d.a.o0.m0.z.b.c cVar, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar, int i2) {
        this.f15023c = cVar;
        if (this.f15021a == null || cVar == null) {
            return;
        }
        if (cVar.f61253e != null || i2 == 0) {
            i(bVar, aVar, i2);
            h(cVar.f61253e);
            k(cVar.f61253e);
            j(cVar.f61253e);
            g(cVar.f61253e);
        }
    }
}
