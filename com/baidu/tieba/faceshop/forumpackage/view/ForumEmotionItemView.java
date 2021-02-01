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
/* loaded from: classes9.dex */
public class ForumEmotionItemView extends LinearLayout {
    private TextView iTM;
    private TextView iTN;
    private HListView iZc;
    private TextView iZd;
    private TextView jap;
    private ViewGroup jaq;
    private TextView jar;
    private TextView jas;
    private View jat;
    private a jau;
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
        this.iZc = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.jat = findViewById(R.id.forum_emotion_list_head);
        this.jap = (TextView) findViewById(R.id.forum_emotion_filter);
        this.jaq = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.jas = (TextView) findViewById(R.id.forum_emotion_rank);
        this.mTitle = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.iTM = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.iTN = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.iZd = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.mLineView = findViewById(R.id.line);
        this.jar = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.iZc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.jau = new a(this.mPageContext);
        this.iZc.setAdapter((ListAdapter) this.jau);
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.iTM, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTN, R.color.CAM_X0109);
        ap.setViewTextColor(this.iZd, R.color.CAM_X0109);
        ap.setViewTextColor(this.jas, R.color.CAM_X0105);
        ap.setBackgroundColor(this.mLineView, R.color.CAM_X0204);
        ap.setViewTextColor(this.jaq.getChildAt(0), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jaq.getChildAt(0), R.color.CAM_X0201);
        ap.setViewTextColor(this.jaq.getChildAt(1), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jaq.getChildAt(1), R.color.CAM_X0201);
        ap.setViewTextColor(this.jar, R.color.CAM_X0107);
        ap.setViewTextColor(this.jap, R.color.CAM_X0107);
    }

    public HListView getListView() {
        return this.iZc;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public TextView getDownloadNumView() {
        return this.iTM;
    }

    public TextView getShareNumView() {
        return this.iTN;
    }

    public TextView getDownLoadView() {
        return this.iZd;
    }

    public TextView getRankView() {
        return this.jas;
    }

    public View getLineView() {
        return this.mLineView;
    }

    public View getHeaderView() {
        return this.jat;
    }

    public TextView getFilterView() {
        return this.jap;
    }

    public ViewGroup getFilterDropDownView() {
        return this.jaq;
    }

    public a getAdapter() {
        return this.jau;
    }

    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eUY;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iZg = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eUY = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!y.isEmpty(list)) {
                this.iZg = z;
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
            C0718a c0718a;
            if (view == null) {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0718a c0718a2 = new C0718a(view);
                view.setTag(c0718a2);
                c0718a = c0718a2;
            } else {
                c0718a = (C0718a) view.getTag();
            }
            c0718a.a(this.mDatas.get(i), i == 0 && this.iZg, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0718a {
            private TextView ajF;
            private TbImageView iZh;
            private View iZi;
            private View mView;

            public C0718a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iZh = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajF = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iZi = this.mView.findViewById(R.id.emotion_cover_view);
                this.iZi.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iZh.setDefaultResource(R.drawable.img_default_100);
                        this.iZh.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.ajF.setVisibility(0);
                    } else {
                        this.ajF.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iZi.setVisibility(0);
                    } else {
                        this.iZi.setVisibility(8);
                    }
                }
            }
        }
    }
}
