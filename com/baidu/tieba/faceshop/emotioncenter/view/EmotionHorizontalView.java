package com.baidu.tieba.faceshop.emotioncenter.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import d.b.c.e.p.l;
import d.b.c.e.q.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HListView f15454e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15455f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15456g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15457h;
    public TextView i;
    public View j;
    public c k;
    public EmotionPackageData l;
    public TbPageContext m;
    public NewFaceGroupDownloadModel n;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.d {
        public a() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            if (EmotionHorizontalView.this.l == null) {
                return;
            }
            EmotionHorizontalView.this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.m.getPageActivity(), EmotionHorizontalView.this.l.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.j0.y1.e.b {
        public b() {
        }

        @Override // d.b.j0.y1.e.b
        public void onFail(String str) {
            l.K(EmotionHorizontalView.this.m.getPageActivity(), R.string.download_error);
            EmotionHorizontalView.this.i.setEnabled(true);
        }

        @Override // d.b.j0.y1.e.b
        public void onProgress(int i) {
            if (i > 0 && i < 100) {
                l.I(EmotionHorizontalView.this.m.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i >= 100) {
                l.H(EmotionHorizontalView.this.m.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.b.j0.y1.e.b
        public void onSuccess(String str) {
            l.K(EmotionHorizontalView.this.m.getPageActivity(), R.string.down_state_success);
            EmotionHorizontalView.this.i.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(EmotionHorizontalView.this.i, R.color.CAM_X0109);
            EmotionHorizontalView.this.i.setBackgroundDrawable(null);
            EmotionHorizontalView.this.i.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f15461f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f15460e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public boolean f15462g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15463h = false;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public View f15464a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f15465b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f15466c;

            /* renamed from: d  reason: collision with root package name */
            public View f15467d;

            public a(View view) {
                this.f15464a = view;
                view.setEnabled(false);
                this.f15465b = (TbImageView) this.f15464a.findViewById(R.id.emotion_img);
                this.f15466c = (TextView) this.f15464a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f15464a.findViewById(R.id.emotion_cover_view);
                this.f15467d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f15465b.setDefaultResource(R.drawable.img_default_100);
                    this.f15465b.W(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f15466c.setVisibility(0);
                } else {
                    this.f15466c.setVisibility(8);
                }
                if (i == 7 && z2) {
                    this.f15467d.setVisibility(0);
                } else {
                    this.f15467d.setVisibility(8);
                }
            }
        }

        public c(TbPageContext tbPageContext) {
            this.f15461f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f15462g = z;
            if (list.size() > 8) {
                this.f15460e = list.subList(0, 8);
                this.f15463h = true;
            } else {
                this.f15460e = list;
                this.f15463h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f15460e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<EmotionPackageData.SingleEmotionData> list = this.f15460e;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f15461f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a(this.f15460e.get(i), i == 0 && this.f15462g, this.f15463h, i);
            return view;
        }
    }

    public EmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.m = tbPageContext;
        e();
    }

    public final void d() {
        EmotionPackageData emotionPackageData;
        if (ViewHelper.checkUpIsLogin(this.m.getPageActivity()) && (emotionPackageData = this.l) != null && emotionPackageData.id >= 0) {
            if (this.n == null) {
                this.n = new NewFaceGroupDownloadModel();
            }
            this.i.setEnabled(false);
            this.n.s(Integer.toString(this.l.id), Boolean.TRUE, new b());
        }
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_grid_item_layout, this);
        this.f15454e = (HListView) findViewById(R.id.emotion_item_grid);
        this.f15455f = (TextView) findViewById(R.id.emotion_title_tv);
        this.f15456g = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.f15457h = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.i = (TextView) findViewById(R.id.emotion_download_tv);
        this.j = findViewById(R.id.line);
        this.i.setOnClickListener(this);
        setOnClickListener(this);
        this.f15454e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f15454e.setOnItemClickListener(new a());
        this.f15454e.setSelector(this.m.getResources().getDrawable(R.drawable.transparent_bg));
        c cVar = new c(this.m);
        this.k = cVar;
        this.f15454e.setAdapter((ListAdapter) cVar);
    }

    public void f(int i) {
        SkinManager.setViewTextColor(this.f15455f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15456g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15457h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionPackageData emotionPackageData = this.l;
        if (emotionPackageData == null) {
            return;
        }
        if (view == this.i) {
            d();
        } else if (view == this) {
            this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.m.getPageActivity(), emotionPackageData.id, 0)));
        } else {
            this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.m.getPageActivity(), emotionPackageData.id, 0)));
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.l = emotionPackageData;
        if (emotionPackageData == null) {
            return;
        }
        this.f15454e.setAdapter((ListAdapter) this.k);
        c cVar = this.k;
        EmotionPackageData emotionPackageData2 = this.l;
        cVar.a(emotionPackageData2.pics, emotionPackageData2.forum_id > 0);
        if (!TextUtils.isEmpty(this.l.forum_name)) {
            TextView textView = this.f15455f;
            textView.setText(this.l.forum_name + "·" + this.l.name);
        } else {
            this.f15455f.setText(this.l.name);
        }
        this.f15456g.setText(String.format(h.a(R.string.package_detail_download_num), StringHelper.numberUniform(this.l.download)));
        this.f15457h.setText(String.format(h.a(R.string.package_detail_share_num), StringHelper.numberUniform(this.l.share)));
        d.b.j0.l0.a c2 = d.b.j0.l0.a.c();
        if (c2.e("" + this.l.id)) {
            this.i.setText(R.string.already_downloaded);
            this.i.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
            this.i.setBackgroundDrawable(null);
            this.i.setEnabled(false);
            return;
        }
        int i = this.l.status;
        if (i != 0) {
            if (i == 1) {
                this.i.setText(R.string.download);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.i, R.drawable.bg_emotion_download);
                this.i.setEnabled(true);
                return;
            } else if (i == 2) {
                this.i.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
                this.i.setEnabled(false);
                return;
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.i.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
                this.i.setText(R.string.face_package_has_delete);
                this.i.setEnabled(false);
                return;
            }
        }
        this.i.setText(R.string.download);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.i, R.drawable.bg_emotion_download);
        this.i.setEnabled(true);
    }
}
