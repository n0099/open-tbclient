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
import d.a.c.e.p.l;
import d.a.c.e.q.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HListView f14827e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14828f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14829g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14830h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14831i;
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
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            if (EmotionHorizontalView.this.l == null) {
                return;
            }
            EmotionHorizontalView.this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.m.getPageActivity(), EmotionHorizontalView.this.l.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.z1.e.b {
        public b() {
        }

        @Override // d.a.n0.z1.e.b
        public void a(String str) {
            l.L(EmotionHorizontalView.this.m.getPageActivity(), R.string.download_error);
            EmotionHorizontalView.this.f14831i.setEnabled(true);
        }

        @Override // d.a.n0.z1.e.b
        public void onProgress(int i2) {
            if (i2 > 0 && i2 < 100) {
                l.J(EmotionHorizontalView.this.m.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i2 >= 100) {
                l.I(EmotionHorizontalView.this.m.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.a.n0.z1.e.b
        public void onSuccess(String str) {
            l.L(EmotionHorizontalView.this.m.getPageActivity(), R.string.down_state_success);
            EmotionHorizontalView.this.f14831i.setText(R.string.already_downloaded);
            SkinManager.setViewTextColor(EmotionHorizontalView.this.f14831i, R.color.CAM_X0109);
            EmotionHorizontalView.this.f14831i.setBackgroundDrawable(null);
            EmotionHorizontalView.this.f14831i.setEnabled(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f14835f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f14834e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public boolean f14836g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f14837h = false;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public View f14838a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f14839b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f14840c;

            /* renamed from: d  reason: collision with root package name */
            public View f14841d;

            public a(View view) {
                this.f14838a = view;
                view.setEnabled(false);
                this.f14839b = (TbImageView) this.f14838a.findViewById(R.id.emotion_img);
                this.f14840c = (TextView) this.f14838a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f14838a.findViewById(R.id.emotion_cover_view);
                this.f14841d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i2) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f14839b.setDefaultResource(R.drawable.img_default_100);
                    this.f14839b.V(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f14840c.setVisibility(0);
                } else {
                    this.f14840c.setVisibility(8);
                }
                if (i2 == 7 && z2) {
                    this.f14841d.setVisibility(0);
                } else {
                    this.f14841d.setVisibility(8);
                }
            }
        }

        public c(TbPageContext tbPageContext) {
            this.f14835f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f14836g = z;
            if (list.size() > 8) {
                this.f14834e = list.subList(0, 8);
                this.f14837h = true;
            } else {
                this.f14834e = list;
                this.f14837h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f14834e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            List<EmotionPackageData.SingleEmotionData> list = this.f14834e;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f14835f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a(this.f14834e.get(i2), i2 == 0 && this.f14836g, this.f14837h, i2);
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
            this.f14831i.setEnabled(false);
            this.n.s(Integer.toString(this.l.id), Boolean.TRUE, new b());
        }
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_grid_item_layout, this);
        this.f14827e = (HListView) findViewById(R.id.emotion_item_grid);
        this.f14828f = (TextView) findViewById(R.id.emotion_title_tv);
        this.f14829g = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.f14830h = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.f14831i = (TextView) findViewById(R.id.emotion_download_tv);
        this.j = findViewById(R.id.line);
        this.f14831i.setOnClickListener(this);
        setOnClickListener(this);
        this.f14827e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f14827e.setOnItemClickListener(new a());
        this.f14827e.setSelector(this.m.getResources().getDrawable(R.drawable.transparent_bg));
        c cVar = new c(this.m);
        this.k = cVar;
        this.f14827e.setAdapter((ListAdapter) cVar);
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f14828f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14829g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14830h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14831i, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionPackageData emotionPackageData = this.l;
        if (emotionPackageData == null) {
            return;
        }
        if (view == this.f14831i) {
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
        this.f14827e.setAdapter((ListAdapter) this.k);
        c cVar = this.k;
        EmotionPackageData emotionPackageData2 = this.l;
        cVar.a(emotionPackageData2.pics, emotionPackageData2.forum_id > 0);
        if (!TextUtils.isEmpty(this.l.forum_name)) {
            TextView textView = this.f14828f;
            textView.setText(this.l.forum_name + "·" + this.l.name);
        } else {
            this.f14828f.setText(this.l.name);
        }
        this.f14829g.setText(String.format(h.a(R.string.package_detail_download_num), StringHelper.numberUniform(this.l.download)));
        this.f14830h.setText(String.format(h.a(R.string.package_detail_share_num), StringHelper.numberUniform(this.l.share)));
        d.a.n0.m0.a c2 = d.a.n0.m0.a.c();
        if (c2.e("" + this.l.id)) {
            this.f14831i.setText(R.string.already_downloaded);
            this.f14831i.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(this.f14831i, R.color.CAM_X0109);
            this.f14831i.setBackgroundDrawable(null);
            this.f14831i.setEnabled(false);
            return;
        }
        int i2 = this.l.status;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f14831i.setText(R.string.download);
                SkinManager.setViewTextColor(this.f14831i, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f14831i, R.drawable.bg_emotion_download);
                this.f14831i.setEnabled(true);
                return;
            } else if (i2 == 2) {
                this.f14831i.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.f14831i, R.color.CAM_X0109);
                this.f14831i.setEnabled(false);
                return;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.f14831i.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.f14831i, R.color.CAM_X0109);
                this.f14831i.setText(R.string.face_package_has_delete);
                this.f14831i.setEnabled(false);
                return;
            }
        }
        this.f14831i.setText(R.string.download);
        SkinManager.setViewTextColor(this.f14831i, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f14831i, R.drawable.bg_emotion_download);
        this.f14831i.setEnabled(true);
    }
}
