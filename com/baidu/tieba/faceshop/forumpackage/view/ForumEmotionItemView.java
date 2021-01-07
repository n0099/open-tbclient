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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class ForumEmotionItemView extends LinearLayout {
    private TextView iSM;
    private TextView iSN;
    private HListView iYc;
    private TextView iYd;
    private TextView iZp;
    private ViewGroup iZq;
    private TextView iZr;
    private TextView iZs;
    private View iZt;
    private a iZu;
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
        this.iYc = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.iZt = findViewById(R.id.forum_emotion_list_head);
        this.iZp = (TextView) findViewById(R.id.forum_emotion_filter);
        this.iZq = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.iZs = (TextView) findViewById(R.id.forum_emotion_rank);
        this.mTitle = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.iSM = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.iSN = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.iYd = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.mLineView = findViewById(R.id.line);
        this.iZr = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.iYc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iYc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.iZu = new a(this.mPageContext);
        this.iYc.setAdapter((ListAdapter) this.iZu);
    }

    public void onChangeSkin(int i) {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.iSM, R.color.CAM_X0109);
        ao.setViewTextColor(this.iSN, R.color.CAM_X0109);
        ao.setViewTextColor(this.iYd, R.color.CAM_X0109);
        ao.setViewTextColor(this.iZs, R.color.CAM_X0105);
        ao.setBackgroundColor(this.mLineView, R.color.CAM_X0204);
        ao.setViewTextColor(this.iZq.getChildAt(0), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iZq.getChildAt(0), R.color.CAM_X0201);
        ao.setViewTextColor(this.iZq.getChildAt(1), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iZq.getChildAt(1), R.color.CAM_X0201);
        ao.setViewTextColor(this.iZr, R.color.CAM_X0107);
        ao.setViewTextColor(this.iZp, R.color.CAM_X0107);
    }

    public HListView getListView() {
        return this.iYc;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public TextView getDownloadNumView() {
        return this.iSM;
    }

    public TextView getShareNumView() {
        return this.iSN;
    }

    public TextView getDownLoadView() {
        return this.iYd;
    }

    public TextView getRankView() {
        return this.iZs;
    }

    public View getLineView() {
        return this.mLineView;
    }

    public View getHeaderView() {
        return this.iZt;
    }

    public TextView getFilterView() {
        return this.iZp;
    }

    public ViewGroup getFilterDropDownView() {
        return this.iZq;
    }

    public a getAdapter() {
        return this.iZu;
    }

    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eXu;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iYg = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eXu = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!x.isEmpty(list)) {
                this.iYg = z;
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
            C0735a c0735a;
            if (view == null) {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0735a c0735a2 = new C0735a(view);
                view.setTag(c0735a2);
                c0735a = c0735a2;
            } else {
                c0735a = (C0735a) view.getTag();
            }
            c0735a.a(this.mDatas.get(i), i == 0 && this.iYg, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0735a {
            private TextView akH;
            private TbImageView iYh;
            private View iYi;
            private View mView;

            public C0735a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iYh = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.akH = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iYi = this.mView.findViewById(R.id.emotion_cover_view);
                this.iYi.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iYh.setDefaultResource(R.drawable.img_default_100);
                        this.iYh.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.akH.setVisibility(0);
                    } else {
                        this.akH.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iYi.setVisibility(0);
                    } else {
                        this.iYi.setVisibility(8);
                    }
                }
            }
        }
    }
}
