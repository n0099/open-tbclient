package com.baidu.tieba.faceshop.forumpackage.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumEmotionItemView extends LinearLayout {
    private TextView iVJ;
    private TextView iVK;
    private HListView jaZ;
    private TextView jba;
    private TextView jcm;
    private ViewGroup jcn;
    private TextView jco;
    private TextView jcp;
    private View jcq;
    private a jcr;
    private View mLineView;
    private TbPageContext mPageContext;
    private TextView mTitle;

    public ForumEmotionItemView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_list_item_layout, this);
        this.jaZ = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.jcq = findViewById(R.id.forum_emotion_list_head);
        this.jcm = (TextView) findViewById(R.id.forum_emotion_filter);
        this.jcn = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.jcp = (TextView) findViewById(R.id.forum_emotion_rank);
        this.mTitle = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.iVJ = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.iVK = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.jba = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.mLineView = findViewById(R.id.line);
        this.jco = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.jaZ.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jaZ.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.jcr = new a(this.mPageContext);
        this.jaZ.setAdapter((ListAdapter) this.jcr);
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVJ, R.color.CAM_X0109);
        ap.setViewTextColor(this.iVK, R.color.CAM_X0109);
        ap.setViewTextColor(this.jba, R.color.CAM_X0109);
        ap.setViewTextColor(this.jcp, R.color.CAM_X0105);
        ap.setBackgroundColor(this.mLineView, R.color.CAM_X0204);
        ap.setViewTextColor(this.jcn.getChildAt(0), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jcn.getChildAt(0), R.color.CAM_X0201);
        ap.setViewTextColor(this.jcn.getChildAt(1), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jcn.getChildAt(1), R.color.CAM_X0201);
        ap.setViewTextColor(this.jco, R.color.CAM_X0107);
        ap.setViewTextColor(this.jcm, R.color.CAM_X0107);
    }

    public HListView getListView() {
        return this.jaZ;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public TextView getDownloadNumView() {
        return this.iVJ;
    }

    public TextView getShareNumView() {
        return this.iVK;
    }

    public TextView getDownLoadView() {
        return this.jba;
    }

    public TextView getRankView() {
        return this.jcp;
    }

    public View getLineView() {
        return this.mLineView;
    }

    public View getHeaderView() {
        return this.jcq;
    }

    public TextView getFilterView() {
        return this.jcm;
    }

    public ViewGroup getFilterDropDownView() {
        return this.jcn;
    }

    public a getAdapter() {
        return this.jcr;
    }

    /* loaded from: classes8.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eWx;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean jbd = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eWx = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!y.isEmpty(list)) {
                this.jbd = z;
                if (list.size() > 8) {
                    this.mDatas = list.subList(0, 8);
                    this.showCover = true;
                } else {
                    this.mDatas = list;
                    this.showCover = false;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mDatas == null) {
                return 0;
            }
            return this.mDatas.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.mDatas == null) {
                return null;
            }
            return this.mDatas.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0725a c0725a;
            if (view == null) {
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0725a c0725a2 = new C0725a(view);
                view.setTag(c0725a2);
                c0725a = c0725a2;
            } else {
                c0725a = (C0725a) view.getTag();
            }
            c0725a.a(this.mDatas.get(i), i == 0 && this.jbd, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0725a {
            private TextView akX;
            private TbImageView jbe;
            private View jbf;
            private View mView;

            public C0725a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.jbe = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.akX = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.jbf = this.mView.findViewById(R.id.emotion_cover_view);
                this.jbf.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.jbe.setDefaultResource(R.drawable.img_default_100);
                        this.jbe.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.akX.setVisibility(0);
                    } else {
                        this.akX.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.jbf.setVisibility(0);
                    } else {
                        this.jbf.setVisibility(8);
                    }
                }
            }
        }
    }
}
