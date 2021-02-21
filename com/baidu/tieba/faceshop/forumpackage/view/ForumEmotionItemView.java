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
    private TextView iUa;
    private TextView iUb;
    private HListView iZq;
    private TextView iZr;
    private TextView jaD;
    private ViewGroup jaE;
    private TextView jaF;
    private TextView jaG;
    private View jaH;
    private a jaI;
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
        this.iZq = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.jaH = findViewById(R.id.forum_emotion_list_head);
        this.jaD = (TextView) findViewById(R.id.forum_emotion_filter);
        this.jaE = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.jaG = (TextView) findViewById(R.id.forum_emotion_rank);
        this.mTitle = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.iUa = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.iUb = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.iZr = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.mLineView = findViewById(R.id.line);
        this.jaF = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.iZq.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZq.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.jaI = new a(this.mPageContext);
        this.iZq.setAdapter((ListAdapter) this.jaI);
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.iUa, R.color.CAM_X0109);
        ap.setViewTextColor(this.iUb, R.color.CAM_X0109);
        ap.setViewTextColor(this.iZr, R.color.CAM_X0109);
        ap.setViewTextColor(this.jaG, R.color.CAM_X0105);
        ap.setBackgroundColor(this.mLineView, R.color.CAM_X0204);
        ap.setViewTextColor(this.jaE.getChildAt(0), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jaE.getChildAt(0), R.color.CAM_X0201);
        ap.setViewTextColor(this.jaE.getChildAt(1), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jaE.getChildAt(1), R.color.CAM_X0201);
        ap.setViewTextColor(this.jaF, R.color.CAM_X0107);
        ap.setViewTextColor(this.jaD, R.color.CAM_X0107);
    }

    public HListView getListView() {
        return this.iZq;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public TextView getDownloadNumView() {
        return this.iUa;
    }

    public TextView getShareNumView() {
        return this.iUb;
    }

    public TextView getDownLoadView() {
        return this.iZr;
    }

    public TextView getRankView() {
        return this.jaG;
    }

    public View getLineView() {
        return this.mLineView;
    }

    public View getHeaderView() {
        return this.jaH;
    }

    public TextView getFilterView() {
        return this.jaD;
    }

    public ViewGroup getFilterDropDownView() {
        return this.jaE;
    }

    public a getAdapter() {
        return this.jaI;
    }

    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eUY;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iZu = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eUY = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!y.isEmpty(list)) {
                this.iZu = z;
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
            C0719a c0719a;
            if (view == null) {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0719a c0719a2 = new C0719a(view);
                view.setTag(c0719a2);
                c0719a = c0719a2;
            } else {
                c0719a = (C0719a) view.getTag();
            }
            c0719a.a(this.mDatas.get(i), i == 0 && this.iZu, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0719a {
            private TextView ajF;
            private TbImageView iZv;
            private View iZw;
            private View mView;

            public C0719a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iZv = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajF = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iZw = this.mView.findViewById(R.id.emotion_cover_view);
                this.iZw.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iZv.setDefaultResource(R.drawable.img_default_100);
                        this.iZv.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.ajF.setVisibility(0);
                    } else {
                        this.ajF.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iZw.setVisibility(0);
                    } else {
                        this.iZw.setVisibility(8);
                    }
                }
            }
        }
    }
}
