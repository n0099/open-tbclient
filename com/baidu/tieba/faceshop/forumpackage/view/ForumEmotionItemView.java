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
/* loaded from: classes8.dex */
public class ForumEmotionItemView extends LinearLayout {
    private TextView iOf;
    private TextView iOg;
    private HListView iTv;
    private TextView iTw;
    private TextView iUI;
    private ViewGroup iUJ;
    private TextView iUK;
    private TextView iUL;
    private View iUM;
    private a iUN;
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
        this.iTv = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.iUM = findViewById(R.id.forum_emotion_list_head);
        this.iUI = (TextView) findViewById(R.id.forum_emotion_filter);
        this.iUJ = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.iUL = (TextView) findViewById(R.id.forum_emotion_rank);
        this.mTitle = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.iOf = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.iOg = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.iTw = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.mLineView = findViewById(R.id.line);
        this.iUK = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.iTv.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iTv.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.iUN = new a(this.mPageContext);
        this.iTv.setAdapter((ListAdapter) this.iUN);
    }

    public void onChangeSkin(int i) {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.iOf, R.color.CAM_X0109);
        ao.setViewTextColor(this.iOg, R.color.CAM_X0109);
        ao.setViewTextColor(this.iTw, R.color.CAM_X0109);
        ao.setViewTextColor(this.iUL, R.color.CAM_X0105);
        ao.setBackgroundColor(this.mLineView, R.color.CAM_X0204);
        ao.setViewTextColor(this.iUJ.getChildAt(0), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iUJ.getChildAt(0), R.color.CAM_X0201);
        ao.setViewTextColor(this.iUJ.getChildAt(1), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iUJ.getChildAt(1), R.color.CAM_X0201);
        ao.setViewTextColor(this.iUK, R.color.CAM_X0107);
        ao.setViewTextColor(this.iUI, R.color.CAM_X0107);
    }

    public HListView getListView() {
        return this.iTv;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public TextView getDownloadNumView() {
        return this.iOf;
    }

    public TextView getShareNumView() {
        return this.iOg;
    }

    public TextView getDownLoadView() {
        return this.iTw;
    }

    public TextView getRankView() {
        return this.iUL;
    }

    public View getLineView() {
        return this.mLineView;
    }

    public View getHeaderView() {
        return this.iUM;
    }

    public TextView getFilterView() {
        return this.iUI;
    }

    public ViewGroup getFilterDropDownView() {
        return this.iUJ;
    }

    public a getAdapter() {
        return this.iUN;
    }

    /* loaded from: classes8.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eSJ;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iTz = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eSJ = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!x.isEmpty(list)) {
                this.iTz = z;
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
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0718a c0718a2 = new C0718a(view);
                view.setTag(c0718a2);
                c0718a = c0718a2;
            } else {
                c0718a = (C0718a) view.getTag();
            }
            c0718a.a(this.mDatas.get(i), i == 0 && this.iTz, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0718a {
            private TextView ajQ;
            private TbImageView iTA;
            private View iTB;
            private View mView;

            public C0718a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iTA = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajQ = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iTB = this.mView.findViewById(R.id.emotion_cover_view);
                this.iTB.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iTA.setDefaultResource(R.drawable.img_default_100);
                        this.iTA.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.ajQ.setVisibility(0);
                    } else {
                        this.ajQ.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iTB.setVisibility(0);
                    } else {
                        this.iTB.setVisibility(8);
                    }
                }
            }
        }
    }
}
